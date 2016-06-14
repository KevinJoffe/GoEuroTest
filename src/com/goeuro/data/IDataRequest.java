package com.goeuro.data;

/** Interface for a data request. */
public interface IDataRequest {
	public String[] getFields();

	public IDataResult[] getResults();

	public String getRequest();
}
