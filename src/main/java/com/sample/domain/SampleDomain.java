package com.sample.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="sample")
public class SampleDomain {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name="business_services")
	private String businessName;
	@Column(name="fullapplication_name")
	private String fullApplicationName;
	@Column(name="abap_java")
	private String abapOrJava;
	@Column(name="sid")
	private String sid;
	@Column(name="aka")
	private String aka;
	@Column(name="environment_role")
	private String environmentRole;
	@Column(name="physicalserver_names")
	private String physicalServerName;
	@Column(name="db_ci_app")
	private String dbOrCiOrApp;
	@Column(name="sap_nw_bi_version")
	private String sapOrBi;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getFullApplicationName() {
		return fullApplicationName;
	}
	public void setFullApplicationName(String fullApplicationName) {
		this.fullApplicationName = fullApplicationName;
	}
	public String getAbapOrJava() {
		return abapOrJava;
	}
	public void setAbapOrJava(String abapOrJava) {
		this.abapOrJava = abapOrJava;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getAka() {
		return aka;
	}
	public void setAka(String aka) {
		this.aka = aka;
	}
	public String getEnvironmentRole() {
		return environmentRole;
	}
	public void setEnvironmentRole(String environmentRole) {
		this.environmentRole = environmentRole;
	}
	public String getPhysicalServerName() {
		return physicalServerName;
	}
	public void setPhysicalServerName(String physicalServerName) {
		this.physicalServerName = physicalServerName;
	}
	public String getDbOrCiOrApp() {
		return dbOrCiOrApp;
	}
	public void setDbOrCiOrApp(String dbOrCiOrApp) {
		this.dbOrCiOrApp = dbOrCiOrApp;
	}
	public String getSapOrBi() {
		return sapOrBi;
	}
	public void setSapOrBi(String sapOrBi) {
		this.sapOrBi = sapOrBi;
	}
	public SampleDomain(String businessName, String fullApplicationName, String abapOrJava, String sid, String aka,
			String environmentRole, String physicalServerName, String dbOrCiOrApp, String sapOrBi) {
		super();
		this.businessName = businessName;
		this.fullApplicationName = fullApplicationName;
		this.abapOrJava = abapOrJava;
		this.sid = sid;
		this.aka = aka;
		this.environmentRole = environmentRole;
		this.physicalServerName = physicalServerName;
		this.dbOrCiOrApp = dbOrCiOrApp;
		this.sapOrBi = sapOrBi;
	}
	public SampleDomain() {
		super();
	}
	@Override
	public String toString() {
		return "SampleDomain [id=" + id + ", businessName=" + businessName + ", fullApplicationName="
				+ fullApplicationName + ", abapOrJava=" + abapOrJava + ", sid=" + sid + ", aka=" + aka
				+ ", environmentRole=" + environmentRole + ", physicalServerName=" + physicalServerName
				+ ", dbOrCiOrApp=" + dbOrCiOrApp + ", sapOrBi=" + sapOrBi + "]";
	}
	
}
