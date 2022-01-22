package com.project.reap.Entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BadgesGiven {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User giver;

    @ManyToOne
    private User receiver;

    private String comment;

    @OneToOne
    private Star star;

    private boolean flag;

    @Column(name = "createDateTime")
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "updateDateTime")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

   private String elapsedTime;

   @ManyToOne(cascade=CascadeType.ALL)
   private Karma karma;

    public BadgesGiven() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getGiver() {
        return giver;
    }

    public void setGiver(User giver) {
        this.giver = giver;
    }

    public Karma getKarma() {
        return karma;
    }

    public void setKarma(Karma karma) {
        this.karma = karma;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Star getStar() {
        return star;
    }

    public void setStar(Star star) {
        this.star = star;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    @Override
    public String toString() {
        return "BadgesGiven{" +
                "id=" + id +
                ", giver=" + giver +
                ", receiver=" + receiver +
                ", comment='" + comment + '\'' +
                ", star=" + star +
                ", flag=" + flag +
                ", createDateTime=" + createDateTime +
                ", updateDateTime=" + updateDateTime +
                ", elapsedTime='" + elapsedTime + '\'' +
                '}';
    }
}