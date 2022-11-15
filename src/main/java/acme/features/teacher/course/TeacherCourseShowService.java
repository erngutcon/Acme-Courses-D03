package acme.features.teacher.course;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.Course;
import acme.entities.LabTutorial;
import acme.entities.TheoryTutorial;
import acme.features.any.labTutorial.AnyLabTutorialRepository;
import acme.features.any.theoryTutorial.AnyTheoryTutorialRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Teacher;

@Service
public class TeacherCourseShowService implements AbstractShowService<Teacher, Course> {

	@Autowired
	protected TeacherCourseRepository repository;
	
	@Autowired
	protected AnyLabTutorialRepository labTutorialRepository;
	
	@Autowired
	protected AnyTheoryTutorialRepository theoryTutorialRepository;

	@Override
	public boolean authorise(final Request<Course> request) {
		assert request != null;

		boolean result;
		int id;
		Course item;
		
		id = request.getModel().getInteger("id");
		item = this.repository.findOneCourseById(id);
		result = item != null && this.repository.findTeacherByCourseId(id) == request.getPrincipal().getActiveRoleId();

		return result;
	}

	@Override
	public Course findOne(final Request<Course> request) {
		assert request != null;

		int id;
		Course result;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneCourseById(id);

		return result;
	}
	
	@Override
	public void unbind(final Request<Course> request, final Course entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "caption", "abstractText");
		
		final int courseId = request.getModel().getInteger("id");
		/*final List<Object[]> price = this.repository.getCourseLabTutorialPrice(courseId);
		final List<Object[]> price2 = this.repository.getCourseTheoryTutorialPrice(courseId);
		final Object totalPrice = price+price2;
		model.setAttribute("totalPrice", totalPrice);*/
		
		//request.this.unbind(entity, model, "ticker", "caption", "abstractText", "hyperlink");

		boolean existsTheoryTutorial = false;
		boolean existsLabTutorial = false;
		
		final Collection<TheoryTutorial> theoryTutorials = this.theoryTutorialRepository.findManyTheoryTutorialsByCourseId(courseId);
		final Collection<LabTutorial> labTutorials = this.labTutorialRepository.findManyLabTutorialsByCourseId(courseId);
		if(theoryTutorials.isEmpty()) {
			existsTheoryTutorial=false;
		} else { existsTheoryTutorial=true;}
		if(labTutorials.isEmpty()) {
			existsLabTutorial=false;
		} else { existsLabTutorial=true;}
		
		model.setAttribute("existsLabTutorial", existsLabTutorial);
		model.setAttribute("existstheoryTutorial", existsTheoryTutorial);
	}
}