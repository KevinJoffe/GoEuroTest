package com.goeuro.data;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.goeuro.data.city.CityRequest;
import com.goeuro.data.city.CityResult;

/** This class is responsible for storing the data that's read from the JSON URL */
public class DataFetcher {

	public static CityRequest getCityResult(String sCityName) {
		JSONArray data = new JSONArray();
		final String sURL = "http://api.goeuro.com/api/v2/position/suggest/en/"
				+ sCityName;

		// Print exceptions for bad URL's; alternatively I could print nice
		// messages
		try {
			data = JsonReader.readJsonFromUrl(sURL);
		}
		catch (JSONException e) {
			e.printStackTrace();
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

		return new CityRequest(sCityName, extractCityProperties(data));
	}

	private static CityResult[] extractCityProperties(JSONArray cityJsonArray) {
		final CityResult cityResults[] = new CityResult[cityJsonArray.length()];
		for (int i = 0; i < cityJsonArray.length(); i++) {
			final JSONObject element = cityJsonArray.getJSONObject(i);
			final JSONObject geoPositionElement = element
					.getJSONObject("geo_position");
			cityResults[i] = new CityResult();
			cityResults[i].sID = element.get("_id").toString();
			cityResults[i].sName = element.get("name").toString();
			cityResults[i].sType = element.get("type").toString();
			try {
				cityResults[i].dLatitude_deg = Double
						.parseDouble(geoPositionElement.get("latitude")
								.toString());
				cityResults[i].dLongitude_deg = Double
						.parseDouble(geoPositionElement.get("longitude")
								.toString());
			}
			catch (NumberFormatException e) {
				e.printStackTrace();
			}
		}

		return cityResults;
	}
}
