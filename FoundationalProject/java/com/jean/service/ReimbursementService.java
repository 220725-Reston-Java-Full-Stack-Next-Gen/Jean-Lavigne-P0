package com.jean.service;

import java.util.List;

import com.jean.models.Reimbursement;

public interface ReimbursementService {

	//crud methods
	
	
	public int createNewReimbursement(Reimbursement reimb, int Id);

	public List<Reimbursement> getAllReimbursements();

	//public Reimbursement getReimbursementById(int id);
	
	
	//public List<Reimbursement> getReimbursementsByStatusId(int statusId);
	
	//public void deleteReimbursement(Reimbursement re);

}
