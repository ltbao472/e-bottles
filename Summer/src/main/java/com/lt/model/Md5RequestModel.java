package com.lt.model;

import java.io.Serializable;

public class Md5RequestModel implements Serializable {
	private static final long serialVersionUID = 5659817185203988697L;
	private String data;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Md5RequestModel [data=" + data + "]";
	}
}
