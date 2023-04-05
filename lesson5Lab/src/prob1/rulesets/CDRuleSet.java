package prob1.rulesets;

import java.awt.Component;
import java.text.DecimalFormat;

import prob1.gui.CDWindow;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {
	private CDWindow uiObj;
	
	
	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		uiObj = (CDWindow) ob;
		
		nonemptyRule();
		idNumericRule();
		priceGreaterRule();
	}
	
	
	private void nonemptyRule() throws RuleException {
		
		if(uiObj.getTitleValue().trim().isEmpty() ||
				uiObj.getArtistValue().trim().isEmpty() ||
				uiObj.getPriceValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}
	
	private void idNumericRule() throws RuleException {
		String val = uiObj.getPriceValue().trim();
		try {
			int indexOfDecimal = val.indexOf('.');
			int decimalPlaces = val.length() - indexOfDecimal - 1;
			if (indexOfDecimal == -1 || decimalPlaces != 2) {
				throw new RuleException("Price must be a floating point number with two decimal places");
			}
		} catch(NumberFormatException e) {
			throw new RuleException("Price must be a floating point number with two decimal places");
		}		
	}
	
	private void priceGreaterRule() throws RuleException  {
		String val = uiObj.getPriceValue().trim();
		
		try {
			Float price = Float.parseFloat(val);
			if (price < 0.49) {
					throw new RuleException("Price must be a number greater than 0.49");
			}
		} catch(NumberFormatException e) {
			throw new RuleException("Price must be a floating point number with two decimal places");
		}
		
	}
	
}
