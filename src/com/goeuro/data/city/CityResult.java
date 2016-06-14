package com.goeuro.data.city;

import com.goeuro.data.IDataResult;

/** Specific result of a city */
public class CityResult implements IDataResult {
	public String sID;
	public String sName;
	public String sType;
	public double dLatitude_deg;
	public double dLongitude_deg;

	public CityResult() {
		sID = "";
		sName = "";
		sType = "";
		dLatitude_deg = 0;
		dLongitude_deg = 0;
	}

	public String[] getResults() {
		return new String[] { sID, sName, sType, dLatitude_deg + "",
				dLongitude_deg + "" };
	}
}
