package hbv7d.api;

import hbv7d.controller.CompanyController;
import hbv7d.controller.UserController;

public class Api {
    CompanyController companyController;
    UserController userController;
    public Api(){
        userController = new UserController();
        companyController = new CompanyController();
    }

}
