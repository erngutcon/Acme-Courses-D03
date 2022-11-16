package acme.features.teacher.theoryTutorial;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.Configuration;
import acme.entities.Course;
import acme.entities.LabTutorial;
import acme.entities.TheoryTutorial;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Teacher;

@Repository
public interface TeacherTheoryTutorialRepository extends AbstractRepository {

	@Query("SELECT userAccount FROM UserAccount userAccount WHERE userAccount.id = :id")
	UserAccount findOneUserAccountById(int id);

	@Query("SELECT c FROM Course c WHERE c.teacher.id = :id")
	Collection<Course> findAllCoursesByTeacher(int id);
	
	@Query("SELECT t FROM Teacher t WHERE t.id = :id")
	Teacher findOneTeacherById(int id);
	
	@Query("SELECT t FROM Teacher t WHERE t.userAccount.id = :id")
	Teacher findOneTeacherByAccountId(int id);
	
	@Query("SELECT c FROM Course c WHERE c.id = :id")
	Course findOneCourseById(int id);

	@Query("SELECT t FROM Teacher t, Register r, Course c WHERE t.id = r.theoryTutorial.id AND c.teacher.id = t.id AND c.id = r.course.id AND t.id = :id")
	Collection<TheoryTutorial> findManyTheoryTutorialsByTeacherId(int id);
	
	@Query("SELECT t FROM Teacher t, Register r, Course c WHERE t.id = r.labTutorial.id AND c.teacher.id = t.id AND c.id = r.course.id AND t.id = :id")
	Collection<LabTutorial> findManyLabTutorialsByTeacherId(int id);
	
	@Query("SELECT item FROM Course item")
	Collection<Course> findAllCourses();
	
	@Query("select c from Configuration c")
	Configuration findConfiguration();
	
	@Query("select t.cost.amount, t.cost.currency from Register r, Course c, TheoryTutorial t where c.id = r.course.id and r.theoryTutorial.id = t.id and c.id = :id")
	List<Object[]> getCourseTheoryTutorialsPrice(int id);

	@Query("select l.cost.amount, l.cost.currency from Register r, Course c, LabTutorial l where c.id = r.course.id and r.labTutorial.id = l.id and c.id = :id")
	List<Object[]> getCourseLabTutorialsPrice(int id);
	
	@Query("select distinct t.id from Teacher t, Register r, Course c, TheoryTutorial tt where t.id = c.teacher.id and c.id = r.course.id and r.theoryTutorial.id = :id")
	Integer findTeacherByTheoryTutorialId(int id);
	
	@Query("select t from TheoryTutorial t where t.id = :id")
	TheoryTutorial findOneTheoryTutorialById(int id);
	
	@Query("select l from LabTutorial l where l.id = :id")
	LabTutorial findOneLabTutorialById(int id);
}