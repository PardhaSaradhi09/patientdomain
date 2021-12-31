package org.hospital.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hospital.domain.FinanceData;
import org.hospital.domain.PatientData;
import org.hospital.finance.services.FinanceServices;

public class FinanceServiceUtils implements FinanceServices {

	PatientServiceUtils utils = new PatientServiceUtils();
	Connection connection;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;

	@Override
	public Map<Integer, List<FinanceData>> addFinanceRecord(FinanceData financeData) {
		Map<Integer, List<FinanceData>> financeRecordList = new HashMap<>();
		if (connection == null) {
			try {

				pst = utils.getConnection()
						.prepareStatement("insert into financeRecords values(?,?,?,?,?,?,?,?,?,?,?)");
				pst.setInt(1, financeData.getPid());
				pst.setInt(2, financeData.getbillID());
				pst.setString(3, financeData.getFirstName());
				pst.setString(4, financeData.getLastName());
				pst.setString(5, String.valueOf(financeData.getGender()));
				pst.setByte(6, financeData.getAge());
				pst.setInt(7, financeData.getDoctorID());
				pst.setDouble(8, financeData.getBillAmount());
				pst.setString(9, financeData.getPaymentType());
				pst.setDouble(10, financeData.getBillDue());
				pst.setDate(11, Date.valueOf(financeData.getBillDate()));

				pst.execute();

//				stmt = utils.getConnection().createStatement();
//				rs = stmt.executeQuery("select * from financeRecords");
//				while (rs.next()) {
//
//					java.sql.Date sqlDate = rs.getDate("dateOfJoin");
//					java.sql.Date sqlDate1 = rs.getDate("dateOfDischarge");
//					LocalDate dateOfJoin = sqlDate.toLocalDate();
//					LocalDate dateOfDischarge = sqlDate1.toLocalDate();
//
//					financeRecordList.put(rs.getInt("pid"), rs.getInt(1));
//				}

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				utils.closeConnection();
			}
		}
		return financeRecordList;
	}

	@Override
	public Map<Integer, List<FinanceData>> getAllFinanceRecoords() {
		Map<Integer, List<FinanceData>> financeRecordList = new HashMap<>();

		try {

			stmt = utils.getConnection().createStatement();
			rs = stmt.executeQuery("select * from financeRecords");
			while (rs.next()) {
				// java.sql.Date sqlDate= rs.getDate("billDate");

				LocalDate dateOfJoin = rs.getDate("billDate").toLocalDate();

				FinanceData newRecord = new FinanceData(rs.getInt("pid"), rs.getInt("billID"),
						rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender").charAt(0),
						rs.getByte("age"), rs.getInt("doctorID"), rs.getDouble("billAmount"),
						rs.getString("paymentType"), rs.getDouble("billDue"), dateOfJoin);
				financeRecordList.put(rs.getInt("pid"), new ArrayList<FinanceData>());
				financeRecordList.get(newRecord.getPid()).add(newRecord);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			utils.closeConnection();
		}
		return financeRecordList;
	}

	@Override
	public List<FinanceData> getPatientBill(int pid) {
		List<FinanceData> financeRecordList = new ArrayList<>();
		FinanceData financeRecord = new FinanceData();
		try {
			pst = utils.getConnection().prepareStatement(
					"select * from financeRecords where pid = ?");/*
																	 * we passing the SQL query in the prepStatment.
																	 */
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next() method
			while (rs.next()) {

				financeRecord.setPid(rs.getInt("pid"));
				financeRecord.setbillID(rs.getInt("billID"));
				financeRecord.setFirstName(rs.getString("firstName"));
				financeRecord.setLastName(rs.getString("lastName"));
				financeRecord.setGender((rs.getString("gender")).charAt(0));
				financeRecord.setAge(rs.getByte("age"));
				financeRecord.setDoctorID(rs.getInt("doctorID"));
				financeRecord.setBillAmount(rs.getDouble("billAmount"));
				financeRecord.setBillAmount(rs.getDouble("billDue"));
				financeRecord.setBillDate(rs.getDate("billDate").toLocalDate());
				financeRecordList.add(financeRecord);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.closeConnection();
		}

		return financeRecordList;
	}

	@Override
	public List<FinanceData> getPatientDueBills() {
		List<FinanceData> financeDueList = new ArrayList<>();

		try {
			pst = utils.getConnection().prepareStatement(
					"select * from financeRecords where  billDue >0");/*
																		 * we passing the SQL query in the prepStatment.
																		 */
			// pst.setInt(1, pid);

			ResultSet rs = pst.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next() method

			while (rs.next()) {

				financeDueList.add(new FinanceData(rs.getInt("pid"), rs.getInt("billID"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("gender").charAt(0), rs.getByte("age"),
						rs.getInt("doctorID"), rs.getDouble("billAmount"), rs.getString("paymentType"),
						rs.getDouble("billDue"), rs.getDate("billDate").toLocalDate()));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			utils.closeConnection();
		}

		return financeDueList;
	}

	@Override
	public List<FinanceData> billPaidByCash() {
		List<FinanceData> financeDueList = new ArrayList<>();

		try {
			pst = utils.getConnection().prepareStatement(
					"select * from financeRecords where  paymentType ==Cash");/*
																				 * we passing the SQL query in the
																				 * prepStatment.
																				 */
			// pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next() method
			while (rs.next()) {

				financeDueList.add(new FinanceData(rs.getInt("pid"), rs.getInt("billID"), rs.getString("firstName"),
						rs.getString("lastName"), rs.getString("gender").charAt(0), rs.getByte("age"),
						rs.getInt("doctorID"), rs.getDouble("billAmount"), rs.getString("paymentType"),
						rs.getDouble("billDue"), rs.getDate("billDate").toLocalDate()));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			utils.closeConnection();
		}

		return financeDueList;
	}

}
