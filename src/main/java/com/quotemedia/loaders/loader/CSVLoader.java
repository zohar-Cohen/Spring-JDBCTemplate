package com.quotemedia.loaders.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.quotemedia.loaders.model.AddressList;

@Component(value = "loaderImpl")
public class CSVLoader {

	// file separator
	private static final String FILE_SEPARATOR = ",";

	public List<AddressList> processInputFile(String inputFilePath) {

		List<AddressList> inputFileData = new ArrayList<>();

		try {
			File inputFile = new File(inputFilePath);
			InputStream inputFileStream = new FileInputStream(inputFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(inputFileStream));
			// skip the header of the csv
			inputFileData = br.lines().skip(1).map(mapToItem).collect(Collectors.toList());
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputFileData;
	}

	private Function<String, AddressList> mapToItem = (line) -> {
		String[] p = line.split(FILE_SEPARATOR);
		AddressList lineData = new AddressList();
		lineData.setSeq(Integer.parseInt(p[0]));
		lineData.setFirstName(p[1]);
		lineData.setLastName(p[2]);
		lineData.setAge(Integer.parseInt(p[3]));
		lineData.setStreet(p[4]);
		lineData.setCity(p[5]);
		lineData.setState(p[6]);
		lineData.setZip(p[7]);
		lineData.setDollar(p[8]);
		lineData.setPick(p[9]);
		lineData.setDate(p[10]);
		return lineData;
	};
	
}
