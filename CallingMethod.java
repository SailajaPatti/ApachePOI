import java.io.IOException;
import java.util.ArrayList;

public class CallingMethod {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		XSSFWorkbookdemo x=new XSSFWorkbookdemo();
		ArrayList data=x.getTestcase("Required");
		System.out.println(data.get(0));
	    System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
		
	}

}
