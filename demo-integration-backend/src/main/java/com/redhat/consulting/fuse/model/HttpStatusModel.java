package com.redhat.consulting.fuse.model;

import java.io.Serializable;

public class HttpStatusModel implements Serializable {

	private static final long serialVersionUID = 5732670202749243742L;
		
	private Integer code;

	private Integer index;

	public HttpStatusModel() {
		super();	
	}	
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public HttpStatusModel(Integer code) {
		super();
		this.code = code;
	}
	
	public HttpStatusModel(Integer code, Integer index) {
		super();
		this.code = code;
		this.index = index;
	}	
	
}
