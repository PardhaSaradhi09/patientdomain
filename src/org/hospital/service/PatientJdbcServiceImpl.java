package org.hospital.service;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hospital.domain.PatientData;
import org.hospital.utils.PatientDataUtils;

public class PatientJdbcServiceImpl implements PatientService {
	Statement stmt = null;
	ResultSet rs = null;
	PatientDataUtils util = new PatientDataUtils();

	@Override
	public PatientData getPatient(int pid) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public List<PatientData> addPatient(PatientData Patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientData> getAllPatients() {
		// TODO Auto-generated method stub
		List<PatientData> patientList = new ArrayList<PatientData>();
		PatientData patient;
		

		try {

			stmt = (Statement) util.getConnection().createStatement();
			rs = stmt.executeQuery("select * from patientRecords");
			while (rs.next()) {
				//patientList.add(rs);
				//patientList=rs.getInt("pid")+rs.getString("firstName")+rs.getString("lastName");
				System.out.println(rs.getInt("pid"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PatientData> deletePatient(PatientData Patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientData> topNPatients(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientData> getAllPatientsByYear(int year) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public PatientData updatePatientJoiningDate(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientData> sortByAge() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
