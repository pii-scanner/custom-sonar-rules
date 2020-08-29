import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.citi.cpb.Customer;
import com.citi.cpb.annotations.NPII;
import com.citi.cpb.annotations.PII;

class MyClass {
	  MyClass(MyClass mc) { }
	  private static final Logger slf4jLogger = LoggerFactory.getLogger(Customer.class);
	  int     foo1() { return 0; }
	  void    foo2(int value) { }
	  int     foo3(int value) { return 0; } // Noncompliant
	  Object  foo4(int value) { return null; }
	  MyClass foo5(MyClass value) {return null; } // Noncompliant
	  
	  int     foo6(int value, String name) { return 0; }
	  int     foo7(int ... values) { return 0;}
	  @NPII
	  private String name;
	  private String ssn;
	  @PII
	  private String aadhar;
	  @NPII
	  private String driverLicense;
	  private String passport;
	  @PII
	  private String accountNumber;
	  private String phoneNo;
	  @NPII
	  private String address;
	  public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
//			slf4jLogger.info("Customer Name {} has registered ",this.name);
		}

		public String getSsn() {
			return ssn;
		}

		public void setSsn(String ssn) {
			this.ssn = ssn;
		}

		public String getAadhar() {
			return aadhar;
			
		}

		public void setAadhar(String aadhar) {
			this.aadhar = aadhar;
//			slf4jLogger.info("Aadhar No {} is entered ",this.aadhar);
		}

		public String getDriverLicense() {
			return driverLicense;
		}

		public void setDriverLicense(String driverLicense) {
			this.driverLicense = driverLicense;
		}

		public String getPassport() {
			return passport;
		}

		public void setPassport(String passport) {
			this.passport = passport;
		}

		public String getAccountNumber() {
			return accountNumber;
		}

		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}

		public String getPhoneNo() {
			return phoneNo;
		}

		public void setPhoneNo(String phoneNo) {
			this.phoneNo = phoneNo;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}
	  public static void main(String[] args)
	  {
		  
		  MyClass cust=new MyClass();
		  
		  
		  
		  cust.setName("Raj Bhise");
		  cust.setAadhar("5321-8569-4758");
			
		   System.out.println(cust.name);
		   slf4jLogger.info("name issays {}",cust.name);
	  }
}