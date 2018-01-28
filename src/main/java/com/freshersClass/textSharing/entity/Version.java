package com.freshersClass.textSharing.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "version", schema = "textsharing")
public class Version {

    private Long idversion;
    private String content;
    private Date date;
    private String url;
    private int numberVersion;

    public Version() {
    }

    public Version(String content, Date date, String url, int numberVersion) {
        this.content = content;
        this.date = date;
        this.url = url;
        this.numberVersion = numberVersion;
    }

    @Id
    @Column(name = "idversion")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getIdversion() {
        return idversion;
    }

    public void setIdversion(Long idversion) {
        this.idversion = idversion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getNumberVersion() {
        return numberVersion;
    }

    public void setNumberVersion(int numberVersion) {
        this.numberVersion = numberVersion;
    }

    @Override
    public String toString() {
        return String.format(
                "Version[id=%d, content='%s', date='%s', url='%s', numberVersion='%s']",
                idversion, content, date, url, numberVersion);
    }
}
