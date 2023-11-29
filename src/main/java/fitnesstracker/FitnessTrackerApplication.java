package fitnesstracker;

import fitnesstracker.data.DataPopulator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class FitnessTrackerApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(FitnessTrackerApplication.class, args);

//		DataPopulator populator = context.getBean(DataPopulator.class);
//
//		populator.populateData();
	}
}
