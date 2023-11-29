package fitnesstracker.repositories;

import fitnesstracker.entities.meal.Meal;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends ListCrudRepository<Meal, Long> {


}
