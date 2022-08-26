package com.jean.daos;

import java.util.List;

import com.jean.models.Reimbursement;
import com.jean.models.UserRole;

public interface ReimbursementDao {
		//crud methods again
		//create, read, update, delete
		public int insertReimbursement(Reimbursement reim);

		public List<Reimbursement> selectAllReimbursements();
		
		//public int selectUserIdByReimbursementId(int reimId);

		;

		//public List<Reimbursement> selectAllReimbursementsByUsername(String user);
		
		
		//public void updateReimbursementBalance(double balance, int id);
		
		//public void ReimbursementStatus(String status, int id);
	

		//public Reimbursement selectReimbursementById(int id);

		//public void deleteReimbursement(Reimbursement re);

		public Boolean deleteReimbursementById(int id);

		//int insertReimbursement(Reimbursement reim, int reimbId);


}
