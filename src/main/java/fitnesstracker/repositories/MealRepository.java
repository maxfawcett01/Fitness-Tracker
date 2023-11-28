package fitnesstracker.repositories;

import fitnesstracker.entities.meal.Meal;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.ListCrudRepository;

@Repository
public interface MealRepository extends ListCrudRepository<Meal, Long> {

}
