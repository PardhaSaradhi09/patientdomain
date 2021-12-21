package org.hospital.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hospital.domain.PatientData;

public class PatientServiceImpl implements PatientService {

	List<PatientData> patientList = new ArrayList<PatientData>();

	@Override
	public PatientData getPatient(int pid) {
		for (PatientData patient : patientList) {
			if (patient.getpid() == pid) {
				return patient;
			}
		}
		return null;
	}

	@SuppressWarnings("unlikely-arg-type")
	@Override
	public List<PatientData> addPatient(PatientData patient) {
//		for (PatientData patient1 : patientList) {
//			if ((patient1.getpid() != patient.getpid()) || (patientList.isEmpty())) {
//				
//				//System.out.println("Patient ID is already exists");
//			}
//			
//			
//		}
		patientList.add(patient);
		return patientList;
	}

	@Override
	public List<PatientData> getAllPatients() {

		return patientList;
	}

	@Override
	public List<PatientData> deletePatient(PatientData patient) {

		patientList.remove(patient);
		return patientList;
	}

	@Override
	public List<PatientData> topNPatients(int n) {
		// TODO Auto-generated method stub
		// return patientList.subList(0, n);
//		for (PatientData patient: patientList) {
//			  if(count<n) {
//				  count++;
//				  
//			  }
//			}
		List<PatientData> patientTopList = new ArrayList<PatientData>();
		for (int i = 0; i < n; i++) {
			patientTopList.add(patientList.get(i));

		}
		return patientTopList;
	}

	@Override
	public List<PatientData> getAllPatientsByYear(int year) {
		// TODO Auto-generated method stub
		List<PatientData> patientListByYear = new ArrayList<PatientData>();
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getDateOfJoin().getYear() == year) {
				patientListByYear.add(patientList.get(i));
			}
		}
		return patientListByYear;
	}

	public PatientData updatePatientJoiningDate(int pid) {
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getpid() == pid) {
				patientList.get(i).setDateOfJoin(LocalDate.now());
				return patientList.get(i);
			}
		}
		return null;
	}

	@Override
	public List<PatientData> sortByAge() {
		Collections.sort(patientList, new Comparator<PatientData>() {

			public int compare(PatientData patient1, PatientData patient2) {

				if (patient1.getAge() < patient2.getAge())
					return 1;

				return -1;
			}
		});
		return patientList;
	}
}
