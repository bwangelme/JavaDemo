package com.bwangel.learnjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String []args) throws Exception {
        List<Student> students = queryStudents();
		students.forEach(System.out::println);
    }
    static List<Student> queryStudents() throws SQLException {
		List<Student> students = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(jdbcUrl, jdbcUsername, jdbcPassword)) {
			try (PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM students WHERE grade = ? AND score >= ?")) {
				ps.setInt(1, 3); // 第一个参数grade=?
				ps.setInt(2, 80); // 第二个参数score=?
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						students.add(extractRow(rs));
					}
				}
			}
		}
		return students;
	}

	static Student extractRow(ResultSet rs) throws SQLException {
		Student std = new Student();
		std.setId(rs.getLong("id"));
		std.setName(rs.getString("name"));
		std.setGender(rs.getBoolean("gender"));
		std.setGrade(rs.getInt("grade"));
		std.setScore(rs.getInt("score"));
		return std;
	}

    static final String jdbcUrl = "jdbc:mysql://localhost:3306/learnjdbc?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=utf8";
	static final String jdbcUsername = "learn";
	static final String jdbcPassword = "passwd";
}
