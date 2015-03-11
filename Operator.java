import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class Operator {
	
	static String fileName = "customerInfo.csv";
	static String LINE_SEPARATOR = ",";
	
	/**
	 * Method to add new Application form information received from the customer
	 * @param appForm ApplicationForm
	 * @throws IOException 
	 */
	public void addInfo() throws IOException {
		//File Writer
		ApplicationForm appForm = getUserInput();
		
		File file1 = new File(fileName);
		
		FileWriter fw = new FileWriter(file1, true);
		fw.write(appForm.getCustomer().getAccountId() + LINE_SEPARATOR);
		fw.write(appForm.getCustomer().getLastName() + LINE_SEPARATOR);
		fw.write(appForm.getCustomer().getFirstName() + LINE_SEPARATOR);
		fw.write(appForm.getCustomer().getAge() + LINE_SEPARATOR);
		fw.write(appForm.getAddress().getCountry() + LINE_SEPARATOR);
		fw.write(appForm.getAddress().getState() + LINE_SEPARATOR);
		fw.write(appForm.getAddress().getStreet() + LINE_SEPARATOR);
		fw.write(appForm.getAddress().getBuilding() + LINE_SEPARATOR);
		fw.write(appForm.getContactInfo().getPhone() + LINE_SEPARATOR);
		fw.write(appForm.getContactInfo().getEmail() + "\n");
		
		fw.close();
		
	}
	
	/**
	 * Method to search customer information based on the 
	 * specified accountId
	 * @param accountId
	 * @return ApplicationForm based on the accountId
	 */
	public ApplicationForm searchInfo(String accountId) {
		ApplicationForm appForm = new ApplicationForm();
		DBManager dbManager = new DBManager();
		try {
			HashMap<String, ApplicationForm> customerData = dbManager.loadData();
			
			appForm = customerData.get(accountId);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return appForm;
	}

	/**
	 * Method to delete Customer information
	 * @param appForm ApplicationForm
	 * @return boolean true if delete record else return false
	 */
	public boolean delete(ApplicationForm appForm ) {
		return false;
	}

	/**
	 * Method to update customer information based on the updated 
	 * ApplicationForm
	 * @param appForm the applicationForm with new modified information 
	 * @return ApplicationForm the updated application form
	 */
	public ApplicationForm update(ApplicationForm appForm) {
		ApplicationForm result = new ApplicationForm();
		return result;
	}
	
	private static ApplicationForm getUserInput() {
		ApplicationForm result = new ApplicationForm();
		
		Scanner scan = new Scanner(System.in);
		
		//Create Customer
		Customer c1 = new Customer();
		System.out.println("Please Enter Account ID: ");
		c1.setAccountId(scan.nextLine());
		
		System.out.println("Please Enter Age: ");
		c1.setAge(scan.nextLine());
		
		System.out.println("Please Enter Last Name: ");
		c1.setLastName(scan.nextLine());
		
		System.out.println("Please Enter First Name: ");
		c1.setFirstName(scan.nextLine());
		
		//Create Address
		Address a1 = new Address();
		System.out.println("Please Enter Country: ");
		a1.setCountry(scan.nextLine());
		
		System.out.println("Please Enter State: ");
		a1.setState(scan.nextLine());
		
		System.out.println("Please Enter Street: ");
		a1.setStreet(scan.nextLine());
		
		System.out.println("Please Enter Building: ");
		a1.setBuilding(scan.nextLine());
		
		//Create Contact Info
		ContactInfo ci1 = new ContactInfo();
		System.out.println("Please Enter Phone Number: ");
		ci1.setPhone(scan.nextLine());
		
		System.out.println("Please Enter Email: ");
		ci1.setEmail(scan.nextLine());
		
		//set Customer,address and Contactinfo to App Form
		result.setAddress(a1);
		result.setCustomer(c1);
		result.setContactInfo(ci1);
		
		return result;
	}

	
}
