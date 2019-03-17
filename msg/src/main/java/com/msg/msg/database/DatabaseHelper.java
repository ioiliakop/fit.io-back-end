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

	public static int getUserIDFromTokenAlphaNumeric(String alphanumeric) {
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement("select iduser from token where alphanumeric=?");) {
			ps.setString(1, alphanumeric);
			ResultSet rs = ps.executeQuery();
			int userId = 0;
			while (rs.next()) {
				userId = rs.getInt("iduser");
			}
			return userId;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

	public static void logOutUser(String alphanumeric) {
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement("delete from token where alphanumeric=?");) {
			ps.setString(1, alphanumeric);
			ps.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
