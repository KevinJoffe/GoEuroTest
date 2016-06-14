package com.goeuro;

import com.goeuro.data.CsvDataWriter;
import com.goeuro.data.DataFetcher;
import com.goeuro.data.city.CityRequest;
import com.goeuro.data.city.CityResult;

public class CityDataWriterMain {
	public static void main(String[] args) {
		if (args.length == 0 || args.length > 1) {
			System.out.println("Only one parameter allowed.");
			System.exit(1);
		}

		// data retrieval and storage
		CityRequest city = DataFetcher.getCityResult(args[0]);

		// write the data to CSV
		CsvDataWriter.writeData(city);
	}
}
