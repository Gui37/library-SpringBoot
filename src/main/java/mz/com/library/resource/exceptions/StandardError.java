package mz.com.library.resource.exceptions;

public class StandardError {
	private String timeStamp;
	private Integer status;
	private String error;

	public StandardError() {
		super();
		
	}

	public StandardError(String timeStamp, Integer status, String error) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.error = error;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
