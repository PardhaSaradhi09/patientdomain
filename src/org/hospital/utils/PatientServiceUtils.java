package org.hospital.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.hospital.domain.PatientData;

import java.sql.PreparedStatement;

public class PatientServiceUtils {

	Connection connection;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;

	public Connection getConnection() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital", "root", "root");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public Boolean insertRecord(PatientData patient) {

		if (connection == null) {
			try {

				pst = getConnection().prepareStatement("insert into patientRecords values(?,?,?,?,?,?,?,?,?,?)");
				pst.setInt(1, patient.getpid());
				pst.setString(2, patient.getFirstName());
				pst.setString(3, patient.getLastName());
				pst.setString(4, String.valueOf(patient.getGender()));
				pst.setByte(5, patient.getAge());
				pst.setLong(6, patient.getPhn());
				pst.setString(7, patient.getAddress());
				pst.setInt(8, patient.getDoctorID());
				pst.setDate(9, Date.valueOf(patient.getDateOfJoin()));
				pst.setDate(10, Date.valueOf(patient.getDateOfDischarge()));
				
				pst.execute();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return true;

	}

	public List<PatientData> getAllRecords() {

		List<PatientData> patientList = new ArrayList<PatientData>();
		try {

			stmt = getConnection().createStatement();
			rs = stmt.executeQuery("select * from patientRecords");
			while (rs.next()) {

				java.sql.Date sqlDate = rs.getDate("dateOfJoin");
				java.sql.Date sqlDate1 = rs.getDate("dateOfDischarge");
				LocalDate dateOfJoin = sqlDate.toLocalDate();
				LocalDate dateOfDischarge = rs.getDate("dateOfDischarge").toLocalDate();

				patientList.add(new PatientData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getByte("age"), rs.getLong("phn"), rs.getString("address"),
						rs.getInt("doctorID"), dateOfJoin, dateOfDischarge));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return patientList;

	}

	public Boolean deleteRecord(int pid) {

		if (connection == null) {
			try {
				pst = getConnection().prepareStatement(
						"delete from patientRecords where pid = ?");/*
																	 * we passing the SQL query in the prepStatment.
																	 */
				pst.setInt(1, pid);
				pst.execute();// We are executing the query by using executeQurey

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}

		return true;
	}

	public PatientData getRecordFromTable(int pid) {
		PatientData patient = new PatientData();
		try {
			pst = getConnection().prepareStatement(
					"select * from patientRecords where pid = ?");/*
																	 * we passing the SQL query in the prepStatment.
																	 */
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next() method
			while (rs.next()) {
				java.sql.Date sqlDate = rs.getDate("dateOfJoin");
				java.sql.Date sqlDate1 = rs.getDate("dateOfDischarge");
				LocalDate dateOfJoin = sqlDate.toLocalDate();
				LocalDate dateOfDischarge = sqlDate1.toLocalDate();
				patient.setpid(rs.getInt("pid"));
				patient.setFirstName(rs.getString("firstName"));
				patient.setLastName(rs.getString("lastName"));
				patient.setGender((rs.getString("gender")));
				patient.setAge(rs.getByte("age"));
				patient.setPhn(rs.getLong("phn"));
				patient.setAddress(rs.getString("address"));
				patient.setDoctorID(rs.getInt("doctorID"));
				patient.setDateOfJoin(dateOfJoin);
				patient.setDateOfDischarge(dateOfDischarge);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return patient;
	}

	public List<PatientData> topNRecords(int n) {
		List<PatientData> topTatientList = new ArrayList<PatientData>();

		// PatientData patient = new PatientData();
		try {
			pst = getConnection().prepareStatement("SELECT * FROM patientRecords");
			// prepStatement.setInt(1, n);
			pst.setMaxRows(n);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				java.sql.Date dateOfJoin = rs.getDate("dateOfJoin");
				java.sql.Date dateOfDischarge = rs.getDate("dateOfDischarge");

				topTatientList.add(new PatientData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getByte("age"), rs.getLong("phn"), rs.getString("address"),
						rs.getInt("doctorID"), dateOfJoin.toLocalDate(), dateOfDischarge.toLocalDate()));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return topTatientList;
	}

	public List<PatientData> getAllRecordsByYear(int year) {
		List<PatientData> patientListByYear = new ArrayList<PatientData>();
		// PatientData patient = new PatientData();
		try {
			pst = getConnection().prepareStatement(
					"select * from patientRecords where YEAR(dateofjoin)=?;");/*
																				 * we passing the SQL query in the
																				 * prepStatment.
																				 */
			pst.setInt(1, year);
			ResultSet rs = pst.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next() method
			while (rs.next()) {
				java.sql.Date sqlDate = rs.getDate("dateOfJoin");
				java.sql.Date sqlDate1 = rs.getDate("dateOfDischarge");
				LocalDate dateOfJoin = sqlDate.toLocalDate();
				LocalDate dateOfDischarge = sqlDate1.toLocalDate();
				patientListByYear.add(new PatientData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getByte("age"), rs.getLong("phn"), rs.getString("address"),
						rs.getInt("doctorID"), dateOfJoin, dateOfDischarge));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return patientListByYear;
	}

	public PatientData updatePatientDischargeDate(int pid) {
		// TODO Auto-generated method stub
		PreparedStatement pst1;
		PatientData patient = new PatientData();
		try {
//          udapate query
			pst = getConnection().prepareStatement(
					"update patientRecords set dateOfDischarge=? where pid=?;");/*
																				 * we passing the SQL query in the
																				 * prepStatment.
																				 */
			pst.setDate(1, Date.valueOf(LocalDate.now()));
			pst.setInt(2, pid);
			pst.execute();
//         get updated query

			pst1 = getConnection().prepareStatement(
					"select * from patientRecords where pid = ?");/*
																	 * we passing the SQL query in the prepStatment.
																	 */
			pst1.setInt(1, pid);
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {

				java.sql.Date sqlDate = rs.getDate("dateOfJoin");
				java.sql.Date sqlDate1 = rs.getDate("dateOfDischarge");
				LocalDate dateOfJoin = sqlDate.toLocalDate();
				LocalDate dateOfDischarge = sqlDate1.toLocalDate();

				patient = (new PatientData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getByte("age"), rs.getLong("phn"), rs.getString("address"),
						rs.getInt("doctorID"), dateOfJoin, dateOfDischarge));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return patient;

	}

	public List<PatientData> sortByAge() {

		List<PatientData> patientListByAge = new ArrayList<PatientData>();

		// PatientData patient = new PatientData();
		try {
			pst = getConnection().prepareStatement("SELECT * FROM patientRecords ORDER BY age Desc");
			// prepStatement.setInt(1, n);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				java.sql.Date sqlDate = rs.getDate("dateOfJoin");
				java.sql.Date sqlDate1 = rs.getDate("dateOfDischarge");
				LocalDate dateOfJoin = sqlDate.toLocalDate();
				LocalDate dateOfDischarge = sqlDate1.toLocalDate();
				patientListByAge.add(new PatientData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getByte("age"), rs.getLong("phn"), rs.getString("address"),
						rs.getInt("doctorID"), dateOfJoin, dateOfDischarge));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return patientListByAge;

	}

}
