package test;


import dao.DBFunctions;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;



@RunWith(value=Parameterized.class)
public class ParametrizedLoginTest {

    private int expectedResult;
    private String idOwner;
    private String password;

    @Parameters
    public static Collection<Object[]> getTestParameters(){
        return Arrays.asList(new Object[][]{

                {0,"r4","ciao"},  //expected, first value, second value
                {1,"r1","root"},
                {1,"t1","root2"},
                {1,"r2","root3"},

        });
    }

    public ParametrizedLoginTest(int result, String idOwner, String password){

        this.expectedResult = result;
        this.idOwner = idOwner;
        this.password = password;

    }


    @Test
    public void testCheckLogin(){

        DBFunctions dbf = new DBFunctions();
        Assert.assertEquals(expectedResult,dbf.checkLogin(idOwner,password));
    }

}
