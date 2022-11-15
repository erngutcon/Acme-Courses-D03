package acme.features.teacher.labTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.LabTutorial;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Teacher;

@Service
public class TeacherLabTutorialShowService implements AbstractShowService<Teacher, LabTutorial> {

	@Autowired
	protected TeacherLabTutorialRepository repository;

	@Override
	public boolean authorise(final Request<LabTutorial> request) {
		assert request != null;

		boolean result;
		int id;
		LabTutorial item;
		
		id = request.getModel().getInteger("id");
		item = this.repository.findOneLabTutorialById(id);
		result = item != null && this.repository.findTeacherByLabTutorialId(id) == request.getPrincipal().getActiveRoleId();

		return result;
	}

	@Override
	public LabTutorial findOne(final Request<LabTutorial> request) {
		assert request != null;

		int id;
		LabTutorial result;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneLabTutorialById(id);

		return result;
	}
	
	@Override
	public void unbind(final Request<LabTutorial> request, final LabTutorial entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "title", "abstractText", "cost", "hyperlink");
	}
}