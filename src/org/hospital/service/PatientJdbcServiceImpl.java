package org.hospital.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hospital.domain.PatientData;
import org.hospital.utils.PatientServiceUtils;

public class PatientJdbcServiceImpl implements PatientService {
	/* Global variables */
	Statement stmt;
	ResultSet rs;
	PreparedStatement pst;

	List<PatientData> patientList = new ArrayList<PatientData>();
	PatientServiceUtils util = new PatientServiceUtils();

	@Override
	/* To retrieve specific patient by pid we can use the getPatient(Pid) method */
	public PatientData getPatient(int pid) {

		return util.getRecordFromTable(pid);

	}

	@Override
	/* To add the record in the database we can use this method */
	public Boolean addPatient(PatientData patient) {

		return util.insertRecord(patient);
	}

	@Override
	public List<PatientData> getAllPatients() {

		return util.getAllRecords();
	}

	@Override
	public Boolean deletePatient(int pid) {

		return util.deleteRecord(pid);
	}

	@Override
	public List<PatientData> topNPatients(int n) {

		return util.topNRecords(n);
	}

	@Override
	public List<PatientData> getAllPatientsByYear(int year) {

		return util.getAllRecordsByYear(year);
	}

	@Override
	public PatientData updatePatientDischargeDate(int pid) {

		return util.updatePatientDischargeDate(pid);
	}

	@Override
	public List<PatientData> sortByAge() {

		return util.sortByAge();
	}

}
