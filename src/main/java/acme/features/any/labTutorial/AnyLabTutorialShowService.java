/*
 * AnyDutyShowService.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.labTutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.LabTutorial;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class AnyLabTutorialShowService implements AbstractShowService<Any, LabTutorial> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected AnyLabTutorialRepository repository;

	@Override
	public boolean authorise(final Request<LabTutorial> request) {
		assert request!=null;
		
		return true;
	}

	@Override
	public LabTutorial findOne(final Request<LabTutorial> request) {
		assert request!=null;
		
		LabTutorial result;
		int id;
		
		id = request.getModel().getInteger("id");
		result = this.repository.findOneLabTutorialById(id);
		
		return result;
	}

	@Override
	public void unbind(final Request<LabTutorial> request, final LabTutorial entity, final Model model) {
		assert request!=null;
		assert entity!=null;
		assert model!=null;
		
		request.unbind(entity, model, "ticker", "title", "abstractText", "cost", "hyperlink");
		
	}


}