package com.quotemedia.loaders.loader;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.quotemedia.loaders.config.LoaderConfiguration;
import com.quotemedia.loaders.model.AddressList;
import com.quotemedia.loaders.service.AddressListService;

public class MainApp {

	private static final String FILE_NAME = "./InputCSV/TestJDBCTemplate.csv";

	static AddressListService addressListService;
	static CSVLoader loader;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LoaderConfiguration.class);

		addressListService = (AddressListService) context.getBean("adressListServiceImpl");
		loader = (CSVLoader) context.getBean("loaderImpl");

		List<AddressList> list = loader.processInputFile(FILE_NAME);
		System.out.println("Going to insert: " + list.size() + " new rows...");
		addressListService.insertAdress(list);

		context.close();

	}

}
