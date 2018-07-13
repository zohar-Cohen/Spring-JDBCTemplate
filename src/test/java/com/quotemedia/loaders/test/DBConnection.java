package com.quotemedia.loaders.test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.quotemedia.loaders.config.LoaderConfiguration;

public class DBConnection {

	public static void main(String[] args) {
		// Retrive the IoC container
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LoaderConfiguration.class);
		// retrive the bean
		DataSource dataSource = (DataSource) context.getBean("dataSource");

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			con = dataSource.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery("select A from EDI_TEST where event_type='BON'");

			if (rs.next()) {

				System.out.println("Test Results: " + rs.getString(1));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			context.close();
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
				if (con != null)
					con.close();
			} catch (

			SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
