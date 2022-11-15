package acme.features.teacher.theoryTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.TheoryTutorial;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Teacher;

@Service
public class TeacherTheoryTutorialShowService implements AbstractShowService<Teacher, TheoryTutorial> {

	@Autowired
	protected TeacherTheoryTutorialRepository repository;

	@Override
	public boolean authorise(final Request<TheoryTutorial> request) {
		assert request != null;

		boolean result;
		int id;
		TheoryTutorial item;
		
		id = request.getModel().getInteger("id");
		item = this.repository.findOneTheoryTutorialById(id);
		result = item != null && this.repository.findTeacherByTheoryTutorialId(id) == request.getPrincipal().getActiveRoleId();

		return result;
	}

	@Override
	public TheoryTutorial findOne(final Request<TheoryTutorial> request) {
		assert request != null;

		int id;
		TheoryTutorial result;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneTheoryTutorialById(id);

		return result;
	}
	
	@Override
	public void unbind(final Request<TheoryTutorial> request, final TheoryTutorial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "abstractText", "cost", "hyperlink");
	}
}