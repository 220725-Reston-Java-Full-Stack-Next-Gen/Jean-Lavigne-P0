package com.jean.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jean.models.Reimbursement;
import com.jean.util.JDBCConnectionUtil;

public class ReimbursementDaoImpl implements ReimbursementDao {

private static Logger LOGGER = Logger.getLogger(ReimbursementDaoImpl.class);
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			LOGGER.warn("Static initializer block failed: " + e);
		}
	}
	
	
	@Override
	public int insertReimbursement(Reimbursement reim) {
		LOGGER.info("In ReimbursementDaoImpl - insertUser() started. Adding reimbursement: " + reim);
		int reimId = 0;
		
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO ers_reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author_id, reimb_resolver_id, reimb_status_id, reimb_type_id)" + 
						 "VALUES (?, ?, NULL, ?, ?, ?, NULL, ?, ?);";
			
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			ps.setDouble(1, reim.getAmount());
			ps.setTimestamp(2, Timestamp.valueOf(reim.getSubmissionDateTime()));
			ps.setTimestamp(3, Timestamp.valueOf(reim.getResolutionDateTime()));
			ps.setString(4, reim.getDescription());		
			ps.setString(5, reim.getReceipt());
			ps.setInt(6, reim.getAuthorId());
			ps.setInt(7, reim.getResolverId());
			ps.setInt(8, reim.getStatus().getStatusId());
			ps.setInt(9, reim.getType().getTypeId());
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
			
		} catch (SQLException sqlEx) {
			System.out.println("This is ReimbursementDAOImpl insert section() " + sqlEx.getMessage());
		}
		return 0;
	}

	

	@Override
	public List<Reimbursement> selectAllReimbursements() {
		
	List<Reimbursement> reimblist = new ArrayList<Reimbursement>();
		
		LOGGER.info("In ReimbursementDaoImpl here is the full list: " + reimblist);
		

		//this opens the jdbc connection
		
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			
			String sql = "SELECT * ers_reimbursements; ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Reimbursement reim = new Reimbursement();
			
				reim.setrId(rs.getInt("reimb_id"));
				reim.setAmount(rs.getDouble("reimb_amount"));
				reim.setSubmissionDateTime(rs.getTimestamp("reimb_submitted").toLocalDateTime());
				reim.setResolutionDateTime(rs.getTimestamp("reimb_resolved").toLocalDateTime());
				reim.setDescription(rs.getString("reimb_description"));						
				reim.setReceipt(rs.getString("reimb_receipt"));
				reim.setAuthorId(rs.getInt("reimb_author_id"));
				reim.setResolverId(rs.getInt("reimb_resolver_id"));
				reim.setStatusId(rs.getInt("reimb_status_id"));
				reim.setTypeId(rs.getInt("reimb_type_id"));
				
			}
		} catch (SQLException e) {
			LOGGER.warn("Unable to update user: " + e);
		}
		return reimblist;
			
	}

	@Override
	public Boolean deleteReimbursementById(int id) {
		
		try (Connection conn = JDBCConnectionUtil.getConnection()){


			String sql = "DELETE FROM ers_reimbursement WHERE id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);

			// it will return true if the first result is  resultSet
			return ps.execute();

			// we can use Exception even though these methods specifically throw SQLExceptions 
			
		}catch(Exception e) {
			
			//System.out.println("This is the employee Doa impl - delete() " + e.getMessage());
			
			LOGGER.error("This is the deleteReimbursementById delete class" + e);

		}
		return true;
	}
	//@Override
	//public void ReimbursementStatus(String status, int id) {


//
//	@Override
//	public void ReimbursementStatus(String status, int id) {
//		// TODO Auto-generated method stub
//		
//	}
//
//
//
//	@Override
//	public Reimbursement selectReimbursementById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	@Override
//	public void deleteReimbursement(Reimbursement re) {
//		// TODO Auto-generated method stub
//		
//	}
//		
	
	//	return ;
			
	}
//	@Override
//	public int selectUserIdByReimbursementId(int reimId) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public Reimbursement selectReimbursementById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Reimbursement> selectAllReimbursementsByUsername(String user) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void updateReimbursementBalance(double balance, int id) {
//		// TODO Auto-generated method stub
//
//	}




