package com.quotemedia.loaders.dao.impl;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.quotemedia.loaders.dao.AddressListDao;
import com.quotemedia.loaders.model.AddressList;

@Repository
public class AddressListDaoImpl implements AddressListDao{
 //seq,first,last,age,street,city,state,zip,dollar,pick,date
	private String insertSQL = "INSERT into AddressList VALUES (?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void insertAddress(final List<AddressList> addressList) {
		jdbcTemplate.batchUpdate(insertSQL, new BatchPreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				AddressList aList = addressList.get(i);
				System.out.println("Perssiting Object with <<<<<< "+aList);
				
				ps.setInt(1,aList.getSeq());
				ps.setString(2,  aList.getFirstName());
				ps.setString(3,  aList.getLastName());
				ps.setInt(4,  aList.getAge());
				ps.setString(5,  aList.getStreet());
				ps.setString(6,  aList.getCity());
				ps.setString(7,  aList.getState());
				ps.setString(8,  aList.getZip());
				ps.setString(9,  aList.getDollar());
				ps.setString(10,  aList.getPick());
				ps.setString(11,  aList.getDate());
				
			}
			public int getBatchSize() {
				return addressList.size();
			}

			
			
		});

	}

}
