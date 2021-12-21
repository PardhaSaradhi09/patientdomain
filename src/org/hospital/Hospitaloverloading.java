package org.hospital;
	
class Hospitaloverloading {	String PID;
String firstName;
String lastName;
String gender;
String age;
String phn;
String address;
String doctorID;
String joinDate;
 {
	// TODO Auto-generated constructor stub
}
public void hospitalDetails(String PID,String firstName,String lastName ) {
	System.out.println("PID:-"+ PID +"\n"+ "firstname:-"+firstName+"\n" + "lastname:-"+ lastName+ "\n"+"not found gender,age,phn,address,doctorID,joindate");
	
}
public void hospitalDetails(String PID,
String firstName,
String lastName,
String gender,
String age) {System.out.println("PID:-"+ PID +"\n"+ "firstname:-"+firstName+"\n" + "lastname:-"+ lastName+"gender:-"+gender+"\n"+"age:-"+age+"\n"+"not found phn,address,doctorID,joindate"
);}

public static void hospitalDetails(String PID,
String firstName,
String lastName,
String gender,
String age,
String phn,
String address,
String doctorID,
String joinDate)
{System.out.println("PID:-"+ PID +"\n"+ "firstname:-"+firstName+"\n" + "lastname:-"+ lastName+"gender:-"+gender+"\n"+"age:-"+age+"phn"+phn+"\n"
+"address:-"+address+"\n"+"doctorID:-"+doctorID+"joinDate:-"+joinDate+"\n"+"patient compeleted");}

static class patenits{
	public static  void main(String[] args) {
		Hospitaloverloading monika = new Hospitaloverloading();
		monika.hospitalDetails("420", "monika", "mental");
		System.out.println("  ");
		Hospitaloverloading nistha = new Hospitaloverloading();
		nistha.hospitalDetails("320", "nistha", "pichi", "female", "56");
		System.out.println(" ");
		Hospitaloverloading pravalika = new Hospitaloverloading();
		pravalika.hospitalDetails("620", "pravalika", "peda pichi", "female", "62", "108", "waliter near mental hospital", "RMP 420_2019", "11/23/2020");

	}


}
}