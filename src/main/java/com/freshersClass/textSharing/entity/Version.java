package com.freshersClass.textSharing.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Version {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idversion;
    private String content;
    private Date date;
    private String url;
    private int numberVersion;
    @ManyToOne
    @JoinColumn(name = "iduser")
    private User user;
    @ManyToOne
    @JoinColumn(name = "idfile")
    private File file;

    public Version() {
    }


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

    public File getFile() {
        return file;
    }

    public User getUser() {
        return user;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setUser(User user) {
        this.user = user;
    }
}


