package com.jean.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.jean.daos.ReimbursementDao;
import com.jean.daos.ReimbursementDaoImpl;
import com.jean.models.Reimbursement;

public class ReimbursementServiceImpl implements ReimbursementService {
	
	private static Logger LOGGER = Logger.getLogger(ReimbursementServiceImpl.class);
	private static ReimbursementDao reimbDao = new ReimbursementDaoImpl();
	private static UserServiceImpl userserviceimpl = new UserServiceImpl(null);
	
	@Override
	public int createNewReimbursement(Reimbursement reimb, int Id) {
		LOGGER.info("Inside ReimbursementServiceImpl - adding the reimbursement to database...");
		int id = 0;
		try {
			LOGGER.info("Starting to process request of submission");
			id = reimbDao.insertReimbursement(reimb);
			System.out.println("reimbursement added was added, leaving the service layer");
			return id;
		} catch (Exception e) {
			LOGGER.warn("Addition failed here you fool " + e);
		}
		return 0;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		LOGGER.info("Inside ReimbursementServiceImpl - gathering all reimbursement records");
		List<Reimbursement> list = reimbDao.selectAllReimbursements();
		if (list != null) {
			LOGGER.info("Found the list ya fool!");
			return list;
		} else {
			LOGGER.warn("Fam they are nowhere to be found.");
		return null;
		}
	}

//	@Override
//	public Reimbursement getReimbursementById(int id) {
//		
//		LOGGER.info("Inside ReimbursementServiceImpl - gathering reimbursement ids: " + id);
//		
//		Reimbursement reimb = reimbDao.selectReimbursementById(id);
//		
//		System.out.println("Trying to find the reimbursement by Id: " + reimb);
//		
//		return reimb;
//	} 
//		
//
//	@Override
//	public void deleteReimbursement(Reimbursement re) {
//		LOGGER.info("Inside ReimbursementServiceImpl - removing reimbursement from database...");
//		try {
//			reimbDao.deleteReimbursement(re);
//			LOGGER.info("Deletion is my forte!");
//		} catch (Exception e) {
//			LOGGER.warn("Deletion failed here you fool!" + e);
//		}
	}


