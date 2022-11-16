/*
 * LearnerPatronageRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.learner.helpRequest;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.HelpRequest;
import acme.framework.entities.UserAccount;
import acme.framework.repositories.AbstractRepository;
import acme.roles.Learner;

@Repository
public interface LearnerHelpRequestRepository extends AbstractRepository {
	
	@Query("select learner from Learner learner where learner.userAccount.id =:id")
	Learner findLearnerByUserId(int id);
	
	@Query("select learner from Learner learner where learner.id =:id")
	Learner findLearnerById(int id);
	
	@Query("select learner from Learner learner")
	List<Learner> findAllLearners();

	@Query("select ua from UserAccount ua where ua.id = :id")
	UserAccount findOneUserAccountById(int id);

	@Query("select hp from HelpRequest hp")
	Collection<HelpRequest> findAllHelpRequests();
	
	@Query("select hp from HelpRequest hp where hp.id = :id")
	HelpRequest findOneHelpRequestById(int id);

	@Query("select learner from Learner learner where learner.userAccount.username =:username")
	Learner findByName(String username);
	
	@Query("select h.learner.id from HelpRequest h where h.id = :id")
	Integer findLearnerByHelpRequestId(int id);
	
}