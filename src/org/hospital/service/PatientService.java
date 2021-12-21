package org.hospital.service;

import java.util.List;

import org.hospital.domain.PatientData;

public interface PatientService {

	public PatientData getPatient(int pid);

	public List<PatientData> addPatient(PatientData Patient);

	public List<PatientData> getAllPatients();

	public List<PatientData> deletePatient(PatientData Patient);

	public List<PatientData> topNPatients(int n);

	public List<PatientData> getAllPatientsByYear(int year);

	public PatientData updatePatientJoiningDate(int pid);

	public List<PatientData> sortByAge();

}
