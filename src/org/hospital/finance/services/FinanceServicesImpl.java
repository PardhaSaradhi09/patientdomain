package org.hospital.finance.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hospital.domain.FinanceData;

public class FinanceServicesImpl implements FinanceServices {

	// List<FinanceData> financeList=new ArrayList<FinanceData>();

	Map<Integer, List<FinanceData>> financeRecordList = new HashMap<>();

	@Override
	
	public Map<Integer, List<FinanceData>> addFinanceRecord(FinanceData financeData) {
		// TODO Auto-generated method stub
		financeRecordList.put(financeData.getPid(), new ArrayList<FinanceData>());
		financeRecordList.get(financeData.getPid()).add(financeData);
		return financeRecordList;
	}

	@Override
	//this return the all records in finance list
	public Map<Integer, List<FinanceData>> getAllFinanceRecoords() {
		// TODO Auto-generated method stub
		return financeRecordList;
	}

	@Override
	public List<FinanceData> getPatientBill(int pid) {
		// TODO Auto-generated method stub
		for (Integer key : financeRecordList.keySet()) {
			if (key == pid) {
				return financeRecordList.get(key);
			}
		}
		return null;
	}

	@Override
	public List<FinanceData> getPatientDueBills() {
		// TODO Auto-generated method stub
		List<FinanceData> financeList = new ArrayList<FinanceData>();
		List<FinanceData> financeDueList = new ArrayList<FinanceData>();
		for (Map.Entry<Integer, List<FinanceData>> entry : financeRecordList.entrySet()) {
			financeList.addAll(entry.getValue());
//			if(entry.getValue().getBillDue()!=0) {
//				return entry.getValue();
//			}
		}
		for (int i = 0; i < financeList.size(); i++) {
			if (financeList.get(i).getBillDue() != 0) {
				financeDueList.add(financeList.get(i));
			}
		}

		return financeDueList;
	}
	

	@Override
	public List<FinanceData> billPaidByCash() {
		// TODO Auto-generated method stub
		List<FinanceData> financeList = new ArrayList<FinanceData>();
		List<FinanceData> billPaidByCashList = new ArrayList<FinanceData>();
		for (Map.Entry<Integer, List<FinanceData>> entry : financeRecordList.entrySet()) {
			financeList.addAll(entry.getValue());
//			if(entry.getValue().getBillDue()!=0) {
//				return entry.getValue();
//			}
		}
		for (int i = 0; i < financeList.size(); i++) {
			if (financeList.get(i).getPaymentType() == "Cash") {
				billPaidByCashList.add(financeList.get(i));
			}
		}

		return billPaidByCashList;
	}

}
