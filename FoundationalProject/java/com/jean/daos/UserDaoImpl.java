package com.jean.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.jean.models.Reimbursement;
import com.jean.models.User;
import com.jean.models.UserRole;
import com.jean.util.JDBCConnectionUtil;

	public class UserDaoImpl implements UserDao {
	private static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
	
	//without this servlet wont run
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			LOGGER.warn("Static initializer block failed: " + e);
		}
	}
	

	@Override
	public int insertUser(User user) {
		LOGGER.info("In UserDaoImpl - insertUser() started. Adding user: " + user);
		int targetId = 0;
		
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			
			String sql = "INSERT INTO ers_users (ers_user_role_id, ers_username, ers_user_password, ers_user_first_name, ers_user_last_name, ers_user_email, ers_user_hire_date)"
						+ "VALUES (?,?,?,?,?,?,'EMPLOYEE')";
			
			PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setDate(6,  Date.valueOf(user.getHireDate()));
			
			int isSuccessfulInsert = ps.executeUpdate();
			
			LOGGER.info("Successful registration to DB: 1 FOR YES/0 FOR NO " + isSuccessfulInsert);
			ResultSet rs = ps.getGeneratedKeys();	
			
			while(rs.next()) {
				targetId = rs.getInt("ers_user_id");
				rs.next();
			}
			
			
		}catch(SQLException e) {
			LOGGER.warn("Unable to add new user: " + e);
			
			
		}
		LOGGER.info("In userDaoImpl - insertUser() ended. New user id is: " + targetId);
		
		return targetId;
		

	}

	@Override
	public User selectUserByUsername(String username) {
		LOGGER.info("In UserDaoImpl - selectUserByUsername() started. Adding user: " + username);
		User target = new User();
		//this opens the jdbc connection
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			//preparing the sql statement
			String sql = "select * from ers_users where username = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			
			//executing the statement			
			ResultSet rs = ps.executeQuery();	
			
			while(rs.next()) {
				
				target.setUserId(rs.getInt("ers_user_id)"));
				target.setUsername(username);
				target.setPassword(rs.getString("ers_user_password"));
				target.setFirstName(rs.getString("ers_user_first_name"));
				target.setLastName(rs.getString("ers_user_last_name"));
				target.setEmail(rs.getString("ers_user_email"));
				target.setUserRole(new UserRole(rs.getString("ers_user_role_id")));
				target.setReimb(new ArrayList<Reimbursement>());
			}
			
			
		}catch(SQLException e) {
			LOGGER.warn("Unable to find user: " + e);
			
			
		}
		LOGGER.info("In userDaoImpl - selectUserByUsername() ended. found user: " + target);
		return target;
		
	}

	@Override
	public void updateUser(User user) {
		LOGGER.info("In UserDaoImpl - updateUser() started. Adding user: " + user);
		

		//this opens the jdbc connection
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			//preparing the sql statement
			String sql = "update ers_users set username =?, user_password = ?, user_first_name = ?, user_last_name = ?, user_email = ?, user_role_id = ?\r\n"
					+ "where ers_user_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getFirstName());
			ps.setString(4, user.getLastName());
			ps.setString(5, user.getEmail());
			ps.setString(6, user.getUserRole().getroleType());
			ps.setInt(7, user.getUserId());
			//executing the statement			
			
			int isSuccessfulUpdate = ps.executeUpdate();	
			LOGGER.info("Successful update to DB: 1 FOR YES/0 FOR NO " + isSuccessfulUpdate);

			
			
		}catch(SQLException e) {
			LOGGER.warn("Unable to update user: " + e);
			
			
		}
		LOGGER.info("In userDaoImpl - updateUser() ended. " );
	
		
	}
	

	@Override
	public List<User> selectAllUsers() {
		
		List<User> userList = new ArrayList<User>();
		
		LOGGER.info("In UserDaoImpl - SelectAllUsers() here are all the users: " + userList);
		

		//this opens the jdbc connection
		
		try(Connection conn = JDBCConnectionUtil.getConnection()){
			
			String sql = "SELECT * FROM ers_users ORDER BY ers_user_id; ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				User user = new User();
			
				user.setUserId(rs.getInt("ers_user_id"));
				user.setUsername(rs.getString("ers_username"));
				user.setPassword(rs.getString("ers_user_password"));
				user.setFirstName(rs.getString("ers_user_first_name"));
				user.setLastName(rs.getString("ers_user_last_name"));
				user.setEmail(rs.getString("email"));
				user.setHireDate(rs.getDate("ers_user_hire_date").toLocalDate());
									
				userList.add(user);
				
				
			}
		} catch (SQLException e) {
			LOGGER.warn("Unable to update user: " + e);
		}
		return userList;
	}


	@Override
	public Boolean deleteUser(int userId) {
		
		try (Connection conn = JDBCConnectionUtil.getConnection()){


			String sql = "DELETE FROM ers_users WHERE id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, userId);

			// it will return true if the first result is  resultSet
			return ps.execute();

			// we can use Exception even though these methods specifically throw SQLExceptions 
			//because Exception is the parent class of all Exceptions
		}catch(Exception e) {
			//System.out.println("This is the employee Doa impl - delete() " + e.getMessage());
			LOGGER.error("This is the usereDaoImpl delete class" + e);

		}
		return true;
		
	}

	@Override
	public void updatePassword(String username, String password) {
		// TODO Auto-generated method stub

	}


}
