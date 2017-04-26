package aima.core.environment.aircargo;

import java.util.LinkedHashSet;
import java.util.Set;

import aima.core.agent.Action;
import aima.core.search.framework.problem.ActionsFunction;
import aima.core.search.framework.problem.ResultFunction;

public class AirCargoFunctionFactory {
	private static ActionsFunction actionsFunction = null;
	private static ResultFunction resultFunction = null;

	public static ActionsFunction getActionsFunction() {
		if (null == actionsFunction) {
			actionsFunction = new ACActionsFunction();
		}
		return actionsFunction;
	}

	public static ResultFunction getResultFunction() {
		if (null == resultFunction) {
			resultFunction = new ACResultFunction();
		}
		return resultFunction;
	}

	private static class ACActionsFunction implements ActionsFunction {
		public Set<Action> actions(Object state) {
			
			Set<Action> actions = new LinkedHashSet<Action>();

			

			return actions;
		}
	}

	private static class ACResultFunction implements ResultFunction {
		public Object result(Object s, Action a) {

			return s;
		}
	}

}
