package prob1.rulesets;

import java.awt.Component;
import java.util.HashMap;

import prob1.gui.BookWindow;
import prob1.gui.CDWindow;


final public class RuleSetFactory {
	private RuleSetFactory(){}
	static HashMap<Class<? extends Component>, RuleSet> map = new HashMap<>();
	
	static {
		map.put(CDWindow.class, new CDRuleSet());
		map.put(BookWindow.class, new BookRuleSet());
	}
	
	public static RuleSet getRuleSet(Component cdWindow) {
		// TODO Auto-generated method stub
		Class<? extends Component> cl = cdWindow.getClass();
		if(!map.containsKey(cl)) {
			throw new IllegalArgumentException(
					"No RuleSet found for this Component");
		}
		return map.get(cl);
	}
	
}
