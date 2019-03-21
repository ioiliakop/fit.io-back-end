package com.msg.msg.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.UUID;

import com.msg.msg.entities.Token;
import com.msg.msg.entities.User;

public class DatabaseHelper {

	public DatabaseHelper() {
	}

	public static Connection getConnection() {
		Connection conn = null;

		try {
			Properties connectionProps = new Properties();
			connectionProps.put("user", "root");
			connectionProps.put("password", "konnos1987");
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

//	public static int getUserIDFromTokenAlphaNumeric(String alphanumeric) {
//		try (Connection conn = getConnection();
//				PreparedStatement ps = conn.prepareStatement("select iduser from token where alphanumeric=?");) {
//			ps.setString(1, alphanumeric);
//			ResultSet rs = ps.executeQuery();
//			int userId = 0;
//			while (rs.next()) {
//				userId = rs.getInt("iduser");
//			}
//			return userId;
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage(), e);
//		}
//	}

	public static void logOutUser(String alphanumeric) {
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement("delete from token where alphanumeric=?");) {
			ps.setString(1, alphanumeric);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void trainerArea(int trainerId, int areaId) {
		try (Connection conn = getConnection();
				PreparedStatement ps = conn
						.prepareStatement("insert into trainer_area (fk_trainer_id, fk_area_id) values(?,?)");) {
			ps.setInt(1, trainerId);
			ps.setInt(2, areaId);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void trainerSpecialization(int trainerId, int typeId) {
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"insert into trainer_specialization (fk_trainer_id, fk_training_type) values(?,?)");) {
			ps.setInt(1, trainerId);
			ps.setInt(2, typeId);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
