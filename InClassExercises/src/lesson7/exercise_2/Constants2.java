package lesson7.exercise_2;

public enum Constants2 {
	COMPANY("Microsoft"), SALES_TARGET(20000000);
	
	private Object val;
	
	private Constants2(Object val) {
		this.val = val;
	}
	
	public Object getValue() {
		return val;
	}
}
