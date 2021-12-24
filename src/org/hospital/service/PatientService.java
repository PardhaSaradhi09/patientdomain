package org.hospital.service;

import java.util.List;

import org.hospital.domain.PatientData;

public interface PatientService {

	public PatientData getPatient(int pid);

	public Boolean addPatient(PatientData Patient);

	public List<PatientData> getAllPatients();

	public Boolean deletePatient(int pid);

	public List<PatientData> topNPatients(int n);

	public List<PatientData> getAllPatientsByYear(int year);

	public PatientData updatePatientDischargeDate(int pid);

	public List<PatientData> sortByAge();

}
