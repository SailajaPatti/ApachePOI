package DataProviderAndExcelDriveFromPOI.DataDriveForTestCase;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketTimeoutException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderAndExcelDrive  {

	//object is a superset for all data types so we can either insert integer and string etc
	//
	@Test(dataProvider="drivetest")
	public void testcase(String cred1,String cred2, int cred3) throws SocketTimeoutException{
		System.out.println(cred1);
	}
	 @DataProvider(name="drivetest")
		public Object[][] RequiredData() throws IOException {
		/*	Object[][] data= {{"user1","pwd1"},{"user2","pwd2"},{"user2","123"}};
			//so every data set we need to keep in one array
			return data; */
		 
		 DataFormatter formatter=new DataFormatter();
		    FileInputStream fis=new FileInputStream("C:\\Users\\1685453\\DataProviderInstead.xlsx");
		    XSSFWorkbook x=new XSSFWorkbook(fis);
		    XSSFSheet sheet= x.getSheetAt(0);
		    int rowcount=sheet.getPhysicalNumberOfRows();
		   XSSFRow row= sheet.getRow(0);
		   int colcount=row.getLastCellNum();
		   Object data[][] =new Object[rowcount-1][colcount];
		   //so to get the data from excel definately it is multidemnitional array since set of data 
		   //which means 1st row needs to take one array with 2 values or 1 data set
		   //so we already know multi dimentional array outler loop is how many sets of data means how many columns
		   //inner loop is for how many vales in one data set
		   //all these is to run the whole into 3 different test cases unlike the POI Code (since if we grab thetext from xcel like before it will recognise whole as 1 tc
		   //that's only we r bringing data provider oncept rt
		   for(int i=0;i<rowcount-1;i++) { //since we don't need to 1st row rt since those are headers
			    
			row = sheet.getRow(i+1); //since row is instance variable it can change method to method
			for(int j=0;j<colcount;j++) {
				
			 XSSFCell cell=row.getCell(j);
			 data[i][j]=formatter.formatCellValue(cell);
			 
			 //after the data grabbed before assigning into array u need to make sure that whether the data is formatted or not
			 //which means whether all data is converted into excel or not
			 //for this there is a data farmatter class 
			}
		 }
		   return data;
}
	
	 }


