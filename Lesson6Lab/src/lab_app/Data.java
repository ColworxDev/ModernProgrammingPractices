package lab_app;

import java.util.ArrayList;
import java.util.List;

import lab_ui_interfaces.MainUITextListener;
import lesson6.labs.Auth;
import lesson6.labs.User;

/**
 * This class stores "dummy data" for the Gui. 
 */
public class Data {
	
	
	public static final Data INSTANCE = new Data();
	private Data() {
		//private constructor; must be accessed with getInstance method
	}
	
	
	/////////////names
	public final static String MESSIAH_OF_DUNE = "Messiah Of Dune";	
	public final static String GONE_WITH_THE_WIND = "Gone With The Wind";
	public final static String GARDEN_OF_RAMA = "Garden of Rama";	
	
    
    public static List<String> bookTitles = new ArrayList<>() {
    	
    	{
           add(MESSIAH_OF_DUNE);
           add(GONE_WITH_THE_WIND);
           add(GARDEN_OF_RAMA);
    	}
    };
    
    public static void addBookTitle(String title) {
    	bookTitles.add(title);
    }
    
    public static Auth currentAuth = null;
    public static MainUITextListener listener;
    
    public static List<User> logins = new ArrayList<>() {
    	
    	{
           add(new User("Joe", "111", Auth.SELLER));
           add(new User("Ann", "101", Auth.MEMBER));
           add(new User("Dave", "102", Auth.BOTH));
    	}
    };
    
    
    
    
           

    
    
}