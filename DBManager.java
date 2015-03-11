import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;


/**
 * Class to manage external data handling, file or database.
 * @author Cuddlemuffin007
 */
public class DBManager {
	
	public HashMap<String, ApplicationForm> loadData() throws FileNotFoundException {
		HashMap<String, ApplicationForm> result = new HashMap<String, ApplicationForm>();
		
		String fileName = "customerInfo.csv";
		File file = new File(fileName);
		Scanner scan = new Scanner(file);
		
		String record = "";
		while(scan.hasNextLine()) {
			record = scan.nextLine();
			String[] cells = new String[12]; //ArrayList
			cells = record.split(",");
		
			ApplicationForm appForm = new ApplicationForm();
			//A007, SUZUKI, TARO, 30, JAPAN, TOKYO, SHIBUYA-KU 2-2-2, MIZU, 101, , 777-123, 
			//sta@com
			
			//Create Customer
			Customer c1 = new Customer();
			c1.setAccountId(cells[0]);
			c1.setAge(cells[3]);
			c1.setFirstName(cells[2]);
			c1.setLastName(cells[1]);
			
			//Create Address
			Address a1 = new Address();
			a1.setCountry(cells[4]);
			a1.setState(cells[5]);
			a1.setStreet(cells[6]);
			a1.setBuilding(cells[7]);
			
			//Create Contact Info
			ContactInfo ci1 = new ContactInfo();
			ci1.setPhone(cells[8]);
			ci1.setEmail(cells[9]);
			
			//set Customer,address and Contactinfo to App Form
			appForm.setAddress(a1);
			appForm.setCustomer(c1);
			appForm.setContactInfo(ci1);
			
			result.put(c1.getAccountId(), appForm);
		}
		
		return result;
	}
}
