package steps;

import pages.AgencyRegistrationPage;

public class PageInitializer {

    public static AgencyRegistrationPage register;
    public static void initializePageObject(){
        register = new AgencyRegistrationPage();
    }




}
