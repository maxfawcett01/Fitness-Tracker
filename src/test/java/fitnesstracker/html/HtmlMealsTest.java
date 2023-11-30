package fitnesstracker.html;

import com.fasterxml.jackson.databind.ObjectMapper;
import fitnesstracker.controllers.MealController;
import fitnesstracker.services.MealService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.IOException;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(MealController.class)
@AutoConfigureMockMvc
class HtmlMealsTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper mapper;

    @MockBean
    private MealService mealService;


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
        WebDriver driver = new ChromeDriver();

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

    @Test
    void testAddMealAndVerifyInList() {
        WebDriver driver = new ChromeDriver();

        try {
            Resource resource = new ClassPathResource("static/meals.html");
            String filePath = resource.getFile().getAbsolutePath();
            driver.get("http://localhost:8081/meals.html");

            WebElement addMealButton = driver.findElement(By.id("addMealButton"));
            addMealButton.click();

            WebElement personIdInput = driver.findElement(By.id("personId"));
            WebElement dateInput = driver.findElement(By.id("date"));
            WebElement mealNameInput = driver.findElement(By.id("mealName"));
            WebElement mealTypeInput = driver.findElement(By.id("mealType"));
            WebElement caloriesInput = driver.findElement(By.id("calories"));

            personIdInput.sendKeys("999");
            dateInput.clear();
            dateInput.sendKeys("20200202");
            mealNameInput.sendKeys("New Meal");
            mealTypeInput.sendKeys("Dinner");
            caloriesInput.sendKeys("500");

            WebElement saveMealButton = driver.findElement(By.id("saveMealButton"));
            saveMealButton.click();


            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement mealList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("mealList")));

            System.out.println("Meal List Text: " + mealList.getText());

            String mealListText = mealList.getText();
            String expectedText = "999 - 2020-02-02 - New Meal - Dinner - Calories: 500";

            assertTrue(mealListText.contains(expectedText), "Expected text not found in the list. Expected: '" + expectedText + "', Actual: '" + mealListText + "'");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
           driver.quit();
        }
    }
}


