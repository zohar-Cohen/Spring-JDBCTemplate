package com.quotemedia.loaders.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quotemedia.loaders.dao.AddressListDao;
import com.quotemedia.loaders.model.AddressList;
import com.quotemedia.loaders.service.AddressListService;



@Service
public class AdressListServiceImpl implements AddressListService {

	@Autowired
	AddressListDao addressListDao;
	
	
	@Transactional
	@Override
	public void insertAdress(List<AddressList> addressList) {
		
		addressListDao.insertAddress(addressList);
		
	}

	

}
