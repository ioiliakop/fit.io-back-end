package com.msg.msg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.msg.msg.entities.Token;
import com.msg.msg.entities.User;
import com.msg.msg.repositories.UserRepository;

public class DatabaseHelper {

	@Autowired
	public static UserRepository userRepository;
	
	public DatabaseHelper() {
	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "theo2512");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/tseam_six_3?zeroDateTimeBehavior=convertToNull&characterEncoding=utf-8&autoReconnect=true",
					connectionProps);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static Token createToken(User user) {
		try (Connection conn = getConnection();
				PreparedStatement ps = conn
						.prepareStatement("insert into token (alphanumeric, iduser) values (?,?)");) {
			String alphanumeric = UUID.randomUUID().toString();
			ps.setString(1, alphanumeric);
			ps.setInt(2, user.getId());
			Token newToken = new Token(alphanumeric, user);
			ps.executeUpdate();
			return newToken;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

//	public static User getUserFromToken(Token token) {
//		try (Connection conn = getConnection();
//				PreparedStatement ps = conn.prepareStatement("select iduser from token where alphanumeric=?");) {
//			ps.setString(1, token.getAlphanumeric());
//			ResultSet rs = ps.executeQuery();
//			User user = new User();
//			while (rs.next()) {
//				int userId = rs.getInt("iduser");
//				user = userRepository.findById(userId);
//			}
//				return user;
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage(), e);
//		}
//	}
	
	public static int getUserIDFromTokenAlphaNumeric(String alphanumeric) {
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement("select iduser from token where alphanumeric=?");) {
			ps.setString(1, alphanumeric);
			ResultSet rs = ps.executeQuery();
			int userId=0;
			while (rs.next()) {
				 userId = rs.getInt("iduser");
			}
				return userId;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
//	public static List<User> getTrainersByTypeAndArea(String type, String city){
//		try(Connection conn=getConnection();
//			PreparedStatement ps=conn.prepareStatement("select user.iduser, user.username,user.password,user.role, user.first_name,user.last_name,user.email,user.price,user.description from user, trainer_area,  trainer_specialization, area ,training_type where user.iduser=trainer_specialization.fk_trainer_id and user.iduser=trainer_area.fk_trainer_id and training_type.idtraining_type=trainer_specialization.fk_training_type and area.idarea=trainer_area.fk_area_id and training_type.specialization_title=?  and area.city=? ");
//				) {
//			List<User> users= new ArrayList<User>();
//			ps.setString(1, type);
//			ps.setString(2, city);
//			ResultSet rs=null;
//			rs=ps.executeQuery();
//			while(rs.next()) {
////				User user= new User(rs.getInt("iduser"), rs.getString("username"), rs.getString("password"), rs.getInt("role"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getDouble("price"), rs.getString("description"));
//				User user2= new	 User(67, "theoroo3", "1234", 1, "theodorosDSa", "bnouras", "dam@hod.com", 9.0, "hffo ddj");
//				users.add(user2);
//			}
//			return users;
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage(), e);
//		}
//	}
	


}
