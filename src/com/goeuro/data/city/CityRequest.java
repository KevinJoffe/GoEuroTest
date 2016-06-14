package com.goeuro.data.city;

import com.goeuro.data.IDataRequest;
import com.goeuro.data.IDataResult;

/** Specific request for City information */
public class CityRequest implements IDataRequest {

	private final CityResult[] cityResults;
	private final String sRequestedCityName;

	public CityRequest(String sRequestedCityName, CityResult[] cityResults) {
		this.sRequestedCityName = sRequestedCityName;
		this.cityResults = cityResults;
	}

	@Override
	public String[] getFields() {
		return new String[] { "_id", "name", "type", "latitude", "longitude" };
	}

	@Override
	public IDataResult[] getResults() {
		return cityResults;
	}

	@Override
	public String getRequest() {
		return sRequestedCityName;
	}

}
