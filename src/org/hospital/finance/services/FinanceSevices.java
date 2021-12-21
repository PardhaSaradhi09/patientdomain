package org.hospital.finance.services;

import java.util.List;
import java.util.Map;

import org.hospital.domain.FinanceData;

public interface FinanceSevices {

	public Map<Integer, List<FinanceData>> addFinanceRecord(FinanceData financeData);

	public Map<Integer, List<FinanceData>> getAllFinanceRecoords();

	public List<FinanceData> getPatientBill(int pid);

	public List<FinanceData> getPatientDueBills();

	public List<FinanceData> billPaidByCash();

}
