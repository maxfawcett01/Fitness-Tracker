package fitnesstracker;

import fitnesstracker.data.DataPopulate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FitnessTrackerApplication {

	public static void main(String[] args) {
    
		ApplicationContext context = SpringApplication.run(FitnessTrackerApplication.class, args);

		DataPopulate populate = context.getBean(DataPopulate.class);

		populate.populateData();
	}
}
