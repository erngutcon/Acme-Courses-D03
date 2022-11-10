package acme.entities.dashboard;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EpicureDashboard implements Serializable {

	private static final long	serialVersionUID	= 1L;

	Integer						totalNumberOfProposedFineDishes;

	Integer						totalNumberOfAcceptedFineDishes;

	Integer						totalNumberOfDeniedFineDishes;

	List<Object>						averageBudgetOfProposedFineDishes;

	List<Object>						deviationBudgetOfProposedFineDishes;

	List<Object>						minimumBudgetOfProposedFineDishes;

	List<Object>						maximumBudgetOfProposedFineDishes;

	List<Object>						averageBudgetOfAcceptedFineDishes;

	List<Object>						deviationBudgetOfAcceptedFineDishes;

	List<Object>						minimumBudgetOfAcceptedFineDishes;

	List<Object>						maximumBudgetOfAcceptedFineDishes;

	List<Object>						averageBudgetOfDeniedFineDishes;

	List<Object>						deviationBudgetOfDeniedFineDishes;

	List<Object>						minimumBudgetOfDeniedFineDishes;

	List<Object>						maximumBudgetOfDeniedFineDishes;

}