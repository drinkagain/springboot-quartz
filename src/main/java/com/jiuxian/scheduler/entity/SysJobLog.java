package com.jiuxian.scheduler.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.context.annotation.Lazy;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Lazy(false)
@Table(name = "TS_JOB_LOG")
public class SysJobLog {

    private static final long serialVersionUID = 1419813775351153342L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer jobId;
    private Date exeTime;
    private String exeResult;
    private String errorMsg;

    @SequenceGenerator(name = "generator", sequenceName = "SEQ_JOB_LOG_ID")
    @Column(name = "ID")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "JOB_ID")
    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXE_TIME")
    public Date getExeTime() {
        return exeTime;
    }

    public void setExeTime(Date exeTime) {
        this.exeTime = exeTime;
    }

    @Column(name = "EXE_RESULT")
    public String getExeResult() {
        return exeResult;
    }

    public void setExeResult(String exeResult) {
        this.exeResult = exeResult;
    }

    @Column(name = "ERROR_MSG")
    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}