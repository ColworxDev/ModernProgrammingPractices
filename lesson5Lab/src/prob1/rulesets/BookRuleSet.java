package prob1.rulesets;

import java.awt.Component;

import prob1.gui.*;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {
	private BookWindow uiObj;

	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		uiObj = (BookWindow) ob;
		
		nonEmptyField();
		
		isbnIsNumeric();
		isbnLengthCheck1();
		isbnLengthCheck2();
		
		priceNumericRule();
		priceGreaterRule();
		
	}
	
	private void nonEmptyField() throws RuleException {
		// TODO Auto-generated method stub
		if(uiObj.getTitleValue().trim().isEmpty() ||
				uiObj.getIsbnValue().trim().isEmpty() ||
				uiObj.getPriceValue().trim().isEmpty()) {
			throw new RuleException("All fields must be non-empty!");
		}
	}
	
	

	// Isbn must be numeric and consist of either 10 or 13 characters
	private void isbnIsNumeric() throws RuleException {
		// TODO Auto-generated method stub
		
		String val = uiObj.getIsbnValue().trim();
		try {
			Integer.parseInt(val);
			if (!(val.length() == 10 || val.length() == 13)) {
				throw new RuleException("Isbn must be numeric and consist of either 10 or 13 characters");
			} 
		} catch(NumberFormatException e) {
			throw new RuleException("Isbn must be numeric and consist of either 10 or 13 characters");
		}	
		
	}
	
	//If Isbn has length 10, the first digit must be 0 or 1
	private void isbnLengthCheck1() throws RuleException {
		// TODO Auto-generated method stub
		String val = uiObj.getIsbnValue().trim();
		try {
			if (val.length() == 10 && !(val.startsWith("0") || val.startsWith("1"))) {
				throw new RuleException("If Isbn has length 10, the first digit must be 0 or 1");
			} 
		} catch(NumberFormatException e) {
			throw new RuleException("If Isbn has length 10, the first digit must be 0 or 1");
		}
	}
	
	//If Isbn has length 13, the first 3 digits must be either 978 or 979
	private void isbnLengthCheck2() throws RuleException {
		// TODO Auto-generated method stub
		String val = uiObj.getIsbnValue().trim();
		try {
			if (val.length() == 13 && (val.startsWith("978") || val.startsWith("979"))) {
				throw new RuleException("If Isbn has length 13, the first 3 digits must be either 978 or 979");
			} 
		} catch(NumberFormatException e) {
			throw new RuleException("If Isbn has length 13, the first 3 digits must be either 978 or 979");
		}
		
	}



	private void priceNumericRule() throws RuleException {
		String val = uiObj.getPriceValue().trim();
		try {
			Float.parseFloat(val);
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
