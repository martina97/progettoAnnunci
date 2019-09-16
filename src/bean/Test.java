package bean;

import control.ControllerLogin;
import dao.DBFunctions;

public class Test {
    public static void main(String[] args) {
        int res, res2;
        DBFunctions dbf = new DBFunctions();
        System.out.println("cacca");

        res = dbf.checkLogin("r1", "root");
        System.out.println("res= "+res);

        UserBean loginBean = new UserBean();
        loginBean.setId("r1");
        loginBean.setPassword("root");
        res2= ControllerLogin.validateLoginWeb(loginBean);
        System.out.println("res2= "+res2);

        }
}
