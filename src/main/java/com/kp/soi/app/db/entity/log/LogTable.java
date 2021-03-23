package com.kp.soi.app.db.entity.log;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Entity
@Table(name = "MACM.MA_UPLOAD_LOG")
public class LogTable {
	
	// Instance variables
	@Id
    @Column(name = "ID")
    private Integer logid;
	
	@Column(name = "TYPE")
    private LogType logtype;

    @Column(name = "PASS_COUNT")
    private Integer logpasscount;
	
	@Column(name = "FAIL_COUNT")
    private Integer logfailcount;
	
	@Column(name = "LAST_UPDATED")
    private LocalDateTime loglastupdated;
	
	@Column(name = "LAST_UPDATED_BY")
    private String loglastupdatedby;
	
	@Column(name = "FILE_NAME")
    private String logfilename;
	
	
	// Getter/Setter methods
	public Integer getlogid() {
		return logid;
	}

	public void setlogid(Integer logid) {
		this.logid = logid;
	}
	
	public LogType getlogtype() {
		return logtype;
	}
	
	public void setlogtype(LogType logtype) {
		this.logtype = logtype;
	}
	
	public Integer getpasscount() {
		return logpasscount;
	}
	
	public void setlogpasscount(Integer logpasscount) {
		this.logpasscount = logpasscount;
	}
	
	public Integer getlogfailcount() {
		return logfailcount;
	}
	
	public void setlogfailcount(Integer logfailcount) {
		this.logfailcount = logfailcount;
	}
	
	public LocalDateTime getloglastupdated() {
		return loglastupdated;
	}
	
	public void setloglastupdated(LocalDateTime loglastupdated) {
		this.loglastupdated = loglastupdated;
	}
	
	public String getloglastupdatedby() {
		return loglastupdatedby;
	}
	
	public void setloglastupdatedby(String loglastupdatedby) {
		this.loglastupdatedby = loglastupdatedby;
	}

	public String getlogfilename() {
		return logfilename;
	}
	
	public void setlogfilename(String logfilename) {
		this.logfilename = logfilename;
	}
	
	
	//Constructor
	
	public LogTable(Integer logid, LogType logtype, Integer logpasscount, Integer logfailcount, LocalDateTime loglastupdated,
			String loglastupdatedby, String logfilename) {
		super();
		this.logid = logid;
		this.logtype = logtype;
		this.logpasscount = logpasscount;
		this.logfailcount = logfailcount;
		this.loglastupdated = loglastupdated;
		this.loglastupdatedby = loglastupdatedby;
		this.logfilename = logfilename;
	}
	
	
	public LogTable(LogType logtype, Integer logpasscount, Integer logfailcount, LocalDateTime loglastupdated,
			String loglastupdatedby, String logfilename) {
		super();
		this.logtype = logtype;
		this.logpasscount = logpasscount;
		this.logfailcount = logfailcount;
		this.loglastupdated = loglastupdated;
		this.loglastupdatedby = loglastupdatedby;
		this.logfilename = logfilename;
	}
	
	
}
