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
@Table(name = "file", schema = "textsharing")
public class File {

    private Long idfile;
    private Date dateCreation;
    private String content;

    protected File() {
    }

    public File(String content) {
        this.content = content;
    }

    @Id
    @Column(name = "idfile")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getIdfile() {
        return idfile;
    }

    public void setIdfile(Long idfile) {
        this.idfile = idfile;
    }

    @Column(name = "datecreation")
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

    @Override
    public String toString() {
        return String.format(
                "File[id=%d, dateCreation='%s', content='%s']",
                idfile, dateCreation, content);
    }
}
