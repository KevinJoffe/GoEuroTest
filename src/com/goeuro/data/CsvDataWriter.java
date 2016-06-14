package com.goeuro.data;

import java.io.FileWriter;
import java.io.IOException;

import com.goeuro.data.city.CityResult;
import com.opencsv.CSVWriter;

/** Write data to CSV */
public class CsvDataWriter {

	public static void writeData(IDataRequest data) {
		CSVWriter csvWriter;
		try {
			csvWriter = new CSVWriter(new FileWriter("./"
					+ data.getClass().getSimpleName() + ".csv"), ',');
			csvWriter.writeNext(data.getFields());
			final IDataResult[] dataResult = data.getResults();
			if (dataResult != null) {
				for (int i = 0; i < dataResult.length; i++) {
					csvWriter.writeNext(dataResult[i].getResults());
				}
			}
			csvWriter.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
