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
		PatientData patient0 = new PatientData(100, "Mahesh", "Rao", 'M', (byte) 30, 7416457574L, "Vizag", 201,
				LocalDate.of(2020, 02, 12), LocalDate.now());
		PatientData patient1 = new PatientData(101, "Ramesh", "Rao", 'M', (byte) 42, 7416457574L, "Vizag", 203,
				LocalDate.of(2020, 02, 22), LocalDate.now());
		PatientData patient2 = new PatientData(102, "Suresh", "Rao", 'M', (byte) 60, 7416457574L, "Vizag", 202,
				LocalDate.of(2021, 03, 01), LocalDate.now());
		PatientData patient3 = new PatientData(103, "Geetha", "Rani", 'F', (byte) 54, 7416457574L, "Vizag", 202,
				LocalDate.of(2021, 03, 05), LocalDate.now());
		PatientData patient4 = new PatientData(104, "Anjali", "Varma", 'F', (byte) 29, 7416457574L, "Vizag", 202,
				LocalDate.of(2020, 03, 12), LocalDate.now());
		PatientData patient5 = new PatientData(105, "Geetha", "Rani", 'F', (byte) 35, 7416457574L, "Vizag", 502,
				LocalDate.of(2021, 02, 12), LocalDate.now());
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
		FinanceData record6 = new FinanceData(105, 502, "Geetha", "Rani", 'F', (byte) 35, 201, 5051.25, "Card", 0.0,
				LocalDate.now());
		FinanceData record7 = new FinanceData(105, 502, "Geetha", "Rani", 'F', (byte) 35, 201, 5051.25, "Card", 0.0,
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

//		System.out.println(patientService.getAllPatients());
//		System.out.println(patientService.getPatient(102));
//		System.out.println(patientService.getPatient(101));
		// patientService.deletePatient(obj2);

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
		PatientDataUtils obj=new PatientDataUtils();
		PatientService obj1=new PatientJdbcServiceImpl();
		System.out.println(obj1.getAllPatients());

	}
}
