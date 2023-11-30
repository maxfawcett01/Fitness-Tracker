package fitnesstracker.html;

import fitnesstracker.services.MealService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;

import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class HtmlMealsTest {



    @Autowired
    MockMvc mockMvc;

    WebDriver driver = new ChromeDriver();

    @MockBean
    MealService mealService;




    @Test
    void testHtmlRequestToMealListPage() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/meals.html");

        String htmlContent = mockMvc.perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andReturn()
                .getResponse()
                .getContentAsString();

        Document document = Jsoup.parse(htmlContent);

        assertNotNull(document, "HTML document is null");

        assertTrue(document.title().contains("Meal Tracker"), "Title does not match");

        assertNotNull(document.getElementById("mealList"), "Element with id 'mealList' not found");

        assertNotNull(document.getElementById("addMealButton"), "Element with id 'addMealButton' not found");
    }

    @Test
    void testAddMealButtonDisplaysModal() {

        try {
            Resource resource = new ClassPathResource("static/meals.html");
            String filePath = resource.getFile().getAbsolutePath();
            driver.get("file:///" + filePath);

            WebElement addMealButton = driver.findElement(By.id("addMealButton"));
            addMealButton.click();

            Thread.sleep(1000);

            WebElement addMealModal = driver.findElement(By.id("addMealModal"));
            assertTrue(addMealModal.isDisplayed());
        } catch (NoSuchElementException | InterruptedException e) {
            e.printStackTrace();
            fail("Test failed with exception: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }
    }

}


