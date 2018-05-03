package com.lt.model;

import java.io.Serializable;

public class Md5ResponseModel implements Serializable {
	private static final long serialVersionUID = -8425936826240549119L;
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Md5ResponseModel [data=" + data + "]";
	}
}
