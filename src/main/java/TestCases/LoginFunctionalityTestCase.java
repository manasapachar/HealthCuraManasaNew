package TestCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.BaseClass;
import utility.ExcelUtility;



public class LoginFunctionalityTestCase extends BaseClass {
	
	//
	@DataProvider
	Object getInfo() throws IOException
	{
		
		  // way1 : 
		/*Object info[][]= new Object[2][2];
		info[0][0]= "u1";
		info[0][1]= "p1";
				
		info[1][0]="u2";
		info[1][1]="p2";
		
		 return info;*/
		
		// way 2: 
		String path = "/Users/anandsortur/eclipse-workspace/GitHubRepos/HealthCuraManasa/src/main/resources/LoginDataResource.xlsx";
		ExcelUtility read = new ExcelUtility(path);
	    int row=	read.getRowCount("Sheet1");
	    int cols=	read.getCellCount("Sheet1", row);
	    System.out.println("row ="+row);
	    System.out.println("cols ="+cols);
	    Object info[][]= new Object[row][cols];
	    
	    for(int i=1;i<=row;i++)
	    {
	    	
	    	 for(int j=0;j<cols;j++)
	 	    {
	 	    	info[i-1][j]=read.getCellData("Sheet1", i, j);
	 	    	//System.out.println("============"+info[i][j]);
	 	    	
	 	    }
	    }
	    
	

	    return info;
		
	}
	
	
	
	@Test(dataProvider = "getInfo")
	void VerifyUser(String user, String pass) throws InterruptedException
	{
		// System.out.println(user);
		 //System.out.println(pass);
		  driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");
	      LoginPage lPage = new LoginPage(driver);
	      Thread.sleep(1000);
	      lPage.setUserName(user);
	      lPage.setPassword(pass);
	      lPage.clickButton();
	      Thread.sleep(1000);
	}
	

}
