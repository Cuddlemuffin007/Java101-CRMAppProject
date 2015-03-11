import java.io.IOException;


public class CrmApp {

	public static void main(String[] args) throws IOException {
		System.out.println("=====WELCOME CRM======");
		
		//Create Operator
		Operator op = new Operator();
		op.addInfo();
		
		//System.out.println("Customer First Name = " + appForm1.getCustomer().getFirtName());
		
		System.out.println("DONE.");
	}

}










//
//ACCOUNTID, LNAME, FNAME, AGE, COUNTRY, STATE, STREET, BUILDING, ROOM, OFFICENAME, 
//TELPHONE, EMAIL
//
//A007, SUZUKI, TARO, 30, JAPAN, TOKYO, SHIBUYA-KU 2-2-2, MIZU, 101, , 777-123, 
//sta@com




//=====WELCOME CRM======
//Customer First Name =  TARO
//DONE.
//


