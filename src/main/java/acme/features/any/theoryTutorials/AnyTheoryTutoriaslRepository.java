/*
 * AnyDutyRepository.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.features.any.theoryTutorials;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.TheoryTutorial;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AnyTheoryTutoriaslRepository extends AbstractRepository {

	@Query("select i from TheoryTutorial i where i.id = :id")
	TheoryTutorial findOneTheoryTutorialById(int id);
	
	@Query("select i from TheoryTutorial i")
	List<TheoryTutorial> findAllTheoryTutorials();

	@Query("select i from Course c, Register r, TheoryTutorial i where t.id = q.toolkit.id and q.theoryTutorial.id = i.id and t.id = :id")
	Collection<TheoryTutorial> findManyTheoryTutorialsByCourseId(int id);
	
	
}
