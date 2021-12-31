package org.hospital.finance.services;

import java.util.List;
import java.util.Map;

import org.hospital.domain.FinanceData;

public interface FinanceServices {
	// Use this method to add finance record into the hospital database.
	public Map<Integer, List<FinanceData>> addFinanceRecord(FinanceData financeData);

	//This method will retrieve all finance records from hospital database. 
	public Map<Integer, List<FinanceData>> getAllFinanceRecoords();

	//This method will retrieve the patient bill record by patient id(pid).
	public List<FinanceData> getPatientBill(int pid);

	//Use this method to retrieve patient bill records from database where due bill >0.
	public List<FinanceData> getPatientDueBills();

	//Use this method to retrieve all patient records from database where payment done by cash.
	public List<FinanceData> billPaidByCash();

}
