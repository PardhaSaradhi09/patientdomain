package org.hospital.client;

import java.time.LocalDate;

import org.hospital.domain.FinanceData;
import org.hospital.domain.PatientData;
import org.hospital.service.PatientJdbcServiceImpl;
import org.hospital.service.PatientService;
import org.hospital.service.PatientServiceImpl;
import org.hospital.utils.PatientDataUtils;

class PatientClient {
	public static void main(String args[]) {
		PatientData patient0 = new PatientData(100, "Mahesh", "Rao", "M", (byte) 30, 7416457574L, "Vizag", 201,
				LocalDate.of(2020, 02, 12), LocalDate.now());
		PatientData patient1 = new PatientData(101, "Ramesh", "Rao", "M", (byte) 42, 7416457574L, "Vizag", 203,
				LocalDate.of(2020, 02, 22), LocalDate.now());
		PatientData patient2 = new PatientData(102, "Suresh", "Rao", "M", (byte) 60, 7416457574L, "Vizag", 202,
				LocalDate.of(2021, 03, 01), LocalDate.now());
		PatientData patient3 = new PatientData(103, "Geetha", "Rani", "F", (byte) 54, 7416457574L, "Vizag", 202,
				LocalDate.of(2021, 03, 05), LocalDate.of(2021, 04, 05));
		PatientData patient4 = new PatientData(104, "Anjali", "Varma", "F", (byte) 29, 7416457574L, "Vizag", 202,
				LocalDate.of(2020, 03, 12), LocalDate.of(2021, 03, 15));
		PatientData patient5 = new PatientData(105, "Geetha", "Rani", "F", (byte) 35, 7416457574L, "Vizag", 502,
				LocalDate.of(2021, 02, 12), LocalDate.of(2021, 03, 05));
		PatientData patient6  = new PatientData(106, "Sree", "Valli", "F", (byte) 35, 7416457574L, "Vizag", 302,
				LocalDate.of(2021, 04, 12), LocalDate.of(2021, 05, 05));
		PatientData patient7 = new PatientData(107, "Kavitha", "Rani", "F", (byte) 35, 7416457574L, "Vizag", 502,
				LocalDate.of(2021, 04, 01), LocalDate.of(2021, 04, 05));
		PatientService patientService = new PatientServiceImpl();
		//first 
		patientService.addPatient(patient0);
		patientService.addPatient(patient1);
		patientService.addPatient(patient2);
		patientService.addPatient(patient3);
		patientService.addPatient(patient4);
		patientService.addPatient(patient5);

		FinanceData record1 = new FinanceData(100, 200, "Mahesh", "Rao", 'M', (byte) 30, 201, 35251.25, "Cash", 0.0,
				LocalDate.now());
		FinanceData record2 = new FinanceData(101, 203, "Ramesh", "Rao", 'M', (byte) 42, 203, 25401.25, "Card", 350.0,
				LocalDate.now());
		FinanceData record3 = new FinanceData(102, 202, "Suresh", "Rao", 'M', (byte) 60, 201, 30251.25, "Cash", 0.0,
				LocalDate.now());
		FinanceData record4 = new FinanceData(103, 202, "Geetha", "Rani", 'F', (byte) 54, 201, 35251.25,
				"Online Payment", 0.0, LocalDate.now());
		FinanceData record5 = new FinanceData(104, 202, "Anjali", "Varma", 'F', (byte) 29, 201, 5251.25, "Cash", 2500.0,
				LocalDate.now());
		FinanceData record6 = new FinanceData(105, 502, "Sree", "Valli", 'F', (byte) 35, 201, 5051.25, "Card", 0.0,
				LocalDate.now());
		FinanceData record7 = new FinanceData(105, 502, "Kavitha", "Rani", 'F', (byte) 35, 201, 5051.25, "Card", 0.0,
				LocalDate.now());

//		FinanceSevices financeServices = new FinanceServicesImpl();
//
//		financeServices.addFinanceRecord(record1);
//		financeServices.addFinanceRecord(record2);
//		financeServices.addFinanceRecord(record3);
//		financeServices.addFinanceRecord(record4);
//		financeServices.addFinanceRecord(record5);
//		financeServices.addFinanceRecord(record6);
//		financeServices.addFinanceRecord(record7);
		//patientService.deletePatient(100);
		//System.out.println(patientService.getAllPatients());
//		System.out.println(patientService.getPatient(102));
//		System.out.println(patientService.getPatient(101));
		

//		System.out.println(patientService.getAllPatients());
		// System.out.println(patientService.updatePatientJoiningDate(100));
//		System.out.println(patientService.topNPatients(3));
//		System.out.println(patientService.sortByAge());
		// System.out.println(patientService.getAllPatientsByYear(2021));

		//System.out.println(financeServices.getAllFinanceRecoords());
		//System.out.println(financeServices.getPatientBill(105));
		//System.out.println(financeServices.getPatientDueBills());
		//System.out.println(financeServices.getPatientDueBills());
		//System.out.println(financeServices.billPaidByCash());
		
		PatientService jdbcService=new PatientJdbcServiceImpl();
		//jdbcService.addPatient(patient7);
		//System.out.println(jdbcService.getPatient(100));
		//jdbcService.deletePatient(107);
		System.out.println(jdbcService.getAllPatients());
		//System.out.println(jdbcService.updatePatientDischargeDate(100));
		//System.out.println(jdbcService.topNPatients(2));
		//System.out.println(jdbcService.getAllPatientsByYear(2020));
		//System.out.println(jdbcService.sortByAge());
	}
}
