package test;


import bean.UserBean;
import boundary.ListApartmentsController;
import dao.DBFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;



@RunWith(value=Parameterized.class)
public class ParametrizedEmptyApartmentsListTest {

    private UserBean userBean=new UserBean();
    private int expected;


    @Parameters
    public static Collection<Object[]> getTestParameters(){
        return Arrays.asList(new Object[][]{

                {0,"r1","root","1"}  //expected, first value, second value


        });
    }

    public ParametrizedEmptyApartmentsListTest(int result,String id,String password, String type){

        this.expected=result;
        this.userBean.setId(id);
        this.userBean.setPassword(password);
        this.userBean.setUserType(type);

        System.out.println("userBean.setUserType(type)");

    }


    @Test
    public void test(){

        ListApartmentsController list=new ListApartmentsController();
        Assert.assertEquals("Se il locatore non ha inserito nessun appartamento nel sistema, non potrà creare un nuovo annuncio.",0,list.createListView(userBean));
    }

}
