package com.quotemedia.loaders.dao;

import java.util.List;

import com.quotemedia.loaders.model.AddressList;

public interface AddressListDao {
	
	public void insertAddress(final List<AddressList> addressList);

}
