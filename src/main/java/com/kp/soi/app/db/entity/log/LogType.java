package com.kp.soi.app.db.entity.log;

public enum LogType {

	DASHBOARD("dashboard");
	
	LogType(String logType){
	  this.logType = logType;
	}
	
	private String logType;
	
	public String getLogType() {
	  return logType;
	}
	
	public void setLogType(String logType) {
	  this.logType = logType;
	}
	
}
