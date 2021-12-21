package org.hospital.service;

import org.hospital.domain.PatientData;
import org.hospital.utils.PatientDataUtils;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PatientJdbcServiceImpl implements PatientService {
	/* Global variables */
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement prepStatement;
	PatientDataUtils util = new PatientDataUtils();
	PatientData patient = new PatientData();

	@Override
	/* To retrieve specific patient by pid we can use the getPatient(Pid) method */
	public PatientData getPatient(int pid) {

		try {
			prepStatement = (PreparedStatement) util.getConnection()
					.prepareStatement("select * from patientRecords where pid = ?");/* we passing the SQL query in the
																					prepStatment.*/
			prepStatement.setInt(1, pid);
			ResultSet rs = prepStatement.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next() method
			while (rs.next()) {
				patient.setpid(rs.getInt("pid"));
				patient.setFirstName(rs.getString("firstName"));
				patient.setLastName(rs.getString("lastName"));
				patient.setGender((rs.getString("gender")));
				patient.setAge(rs.getByte("age"));
				patient.setPhn(rs.getLong("phn"));
				patient.setAddress(rs.getString("address"));
				patient.setDoctorID(rs.getInt("doctorID"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return patient;
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

		try {

			stmt = (Statement) util.getConnection().createStatement();
			rs = stmt.executeQuery("select * from patientRecords");
			while (rs.next()) {
				patient.setpid(rs.getInt("pid"));
				patient.setFirstName(rs.getString("firstName"));
				patient.setLastName(rs.getString("lastName"));
				patient.setGender((rs.getString("gender")));
				patient.setAge(rs.getByte("age"));
				patient.setPhn(rs.getLong("phn"));
				patient.setAddress(rs.getString("address"));
				patient.setDoctorID(rs.getInt("doctorID"));
				patientList.add(patient);
				// patientList.add(rs);
				// patientList=rs.getInt("pid")+rs.getString("firstName")+rs.getString("lastName");
				// System.out.println(rs.getInt("pid"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return patientList;
	}

	@Override
	public List<PatientData> deletePatient(PatientData Patient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientData> topNPatients(int n) {
		// TODO Auto-generated method stub
		List<PatientData> patientList = new ArrayList<PatientData>();
		try {
			prepStatement = (PreparedStatement) util.getConnection().prepareStatement("SELECT * FROM patientRecords");
			// prepStatement.setInt(1, n);
			prepStatement.setMaxRows(n);
			ResultSet rs = prepStatement.executeQuery();

			while (rs.next()) {
				// System.out.println("User ID=" + rs.getInt("empId") + ", Name=" +
				// rs.getString("empFirstname"));
				patient.setpid(rs.getInt("pid"));
				patient.setFirstName(rs.getString("firstName"));
				patient.setLastName(rs.getString("lastName"));
				patient.setGender((rs.getString("gender")));
				patient.setAge(rs.getByte("age"));
				patient.setPhn(rs.getLong("phn"));
				patient.setAddress(rs.getString("address"));
				patient.setDoctorID(rs.getInt("doctorID"));
				patientList.add(patient);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return patientList;
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
