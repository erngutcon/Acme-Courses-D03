package acme.features.any.course;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Course;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyCourseRepository extends AbstractRepository{

	
	@Query("select t from Course t ")
	Collection<Course> findCourses();

	@Query("select t from Course t where t.id = :id")
	Course findOneCourseById(int id);

	@Query("select i.cost.currency, i.cost.amount from Course c, Register r, TheoryTutorial i where c.id = r.course.id and r.theoryTutorial.id = i.id and c.id = :id")
	List<Object[]> getCourseTheoryTutorialPrice(int id);
	
	@Query("select i.cost.currency, i.cost.amount from Course c, Register r, LabTutorial i where c.id = r.course.id and r.labTutorial.id = i.id and c.id = :id")
	List<Object[]> getCourseLabTutorialPrice(int id);



}
