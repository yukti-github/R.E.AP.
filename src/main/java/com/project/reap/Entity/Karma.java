package com.project.reap.Entity;

import javax.persistence.*;

@Entity
public class Karma {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer karmaId;

//    @Column(unique = true)
    private Integer karmaValue;
    private String karmaName;

    public Integer getKarmaValue() {
        return karmaValue;
    }

    public void setKarmaValue(Integer karmaValue) {
        this.karmaValue = karmaValue;
    }

    public String getKarmaName() {
        return karmaName;
    }

    public void setKarmaName(String karmaName) {
        this.karmaName = karmaName;
    }

    public Karma(Integer karmaValue, String karmaName) {
        this.karmaValue = karmaValue;
        this.karmaName = karmaName;
    }

    public Karma() {
    }

    @Override
    public String toString() {
        return "Karma{" +
                "karmaId=" + karmaId +
                ", karmaValue=" + karmaValue +
                ", karmaName='" + karmaName + '\'' +
                '}';
    }
}
