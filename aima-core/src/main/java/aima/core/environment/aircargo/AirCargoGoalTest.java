package aima.core.environment.aircargo;

import java.util.ArrayList;
import java.util.List;
import aima.core.logic.fol.kb.FOLKnowledgeBase;
import aima.core.logic.fol.kb.data.Literal;
import aima.core.logic.fol.parsing.ast.AtomicSentence;
import aima.core.logic.propositional.parsing.ast.PropositionSymbol;
import aima.core.search.framework.problem.GoalTest;

public class AirCargoGoalTest implements GoalTest {
	List<Literal> goal = null;

	private List<Literal> getGoal() {
		if (goal == null) {
			goal = new ArrayList<Literal>();
			goal.add(new Literal((AtomicSentence) new PropositionSymbol("At(C1, SFO)")));
			goal.add(new Literal((AtomicSentence) new PropositionSymbol("At(C2, JFK)")));
			goal.add(new Literal((AtomicSentence) new PropositionSymbol("At(P1, SFO)")));
			goal.add(new Literal((AtomicSentence) new PropositionSymbol("At(P2, SFO)")));
			goal.add(new Literal((AtomicSentence) new PropositionSymbol("Plane(P1)")));
			goal.add(new Literal((AtomicSentence) new PropositionSymbol("Plane(P2)")));
			goal.add(new Literal((AtomicSentence) new PropositionSymbol("Airport(JFK)")));
			goal.add(new Literal((AtomicSentence) new PropositionSymbol("Airport(SFO)")));
		}
		return goal;
	}
	
	
	public boolean isGoalState(Object state) {
		FOLKnowledgeBase kb = (FOLKnowledgeBase) state;
		
		boolean isGoal = true;
		
		for (Literal literal : this.getGoal()) {
			isGoal = isGoal && kb.ask(literal.getAtomicSentence()).isTrue();
			if (!isGoal) 
				break;
		}
		
		return isGoal;
	}
}
