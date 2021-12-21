package org.hospital.domain;


import java.time.LocalDate;

public class PatientData {
	
	private int pid;
	private String firstName;
	private String lastName;
	private char gender;
	private byte age;
	private Long phn;
	private String address;
	private int doctorID;
	private LocalDate dateOfJoin;
	private	LocalDate dateOfDischarge;
	
	public PatientData(int pid, String firstName, String lastName, char gender, byte age, Long phn, String address,
			int doctorID, LocalDate dateOfJoin, LocalDate dateOfDischarge) {
		super();
		this.pid = pid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.phn = phn;
		this.address = address;
		this.doctorID = doctorID;
		this.dateOfJoin = dateOfJoin;
		this.dateOfDischarge=dateOfDischarge;
		
	}

	public int getpid() {
		return pid;
	}

	public void setpid(int pid) {
		this.pid = pid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}

	public byte getAge() {
		return age;
	}

	public void setAge(byte age) {
		this.age = age;
	}

	public Long getPhn() {
		return phn;
	}

	public void setPhn(Long phn) {
		this.phn = phn;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getDoctorID() {
		return doctorID;
	}

	public void setDoctorID(int doctorID) {
		this.doctorID = doctorID;
	}

	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	public LocalDate getDateOfDischarge() {
		return dateOfDischarge;
	}

	public void setDateOfDischarge(LocalDate dateOfDischarge) {
		this.dateOfDischarge = dateOfDischarge;
	}

	@Override
	public String toString() {
		return "PatientData [pid=" + pid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", phn=" + phn + ", address=" + address + ", doctorID=" + doctorID + ", dateOfJoin="
				+ dateOfJoin + ", dateOfDischarge=" + dateOfDischarge + "]";
	}



	

}
