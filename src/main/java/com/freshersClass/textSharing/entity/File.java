package com.freshersClass.textSharing.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idfile;

    @Column(name = "datecreation")
    private Date dateCreation;

    private String content;

    protected File() {
    }

    public File(String content) {
        this.content = content;
    }


    public Long getIdfile() {
        return idfile;
    }

    public void setIdfile(Long idfile) {
        this.idfile = idfile;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
