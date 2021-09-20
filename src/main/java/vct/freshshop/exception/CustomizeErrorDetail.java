package vct.freshshop.exception;

import java.util.Date;

public class CustomizeErrorDetail {

	private Date timeStamp;
	private String message;
	private Object details;
	
	public CustomizeErrorDetail(Date timeStamp, String message, Object details) {
		// TODO Auto-generated constructor stub
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public Object getDetails() {
		return details;
	}

}
