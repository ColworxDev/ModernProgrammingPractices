package lesson7.exercise_1;

public interface StringList {
		
	String[] strArray();
	int size();
	void incrementSize();
	
	/** Adds a string to the end of the list */
	//public void add(String s);
	public default void add(String s) {
		strArray()[size()] = s;
		incrementSize();
	}
	
	/** Gets the i_th string in the list */
//	public String get(int i);
	public default String get(int i) {
		if (i < 0 || i >= size()) {
			return null;
		}
		return strArray()[i];
	}
	
}
