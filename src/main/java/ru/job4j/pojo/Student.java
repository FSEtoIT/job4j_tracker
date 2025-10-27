package ru.job4j.pojo;

import java.time.LocalDateTime;
import java.util.Date;

public class Student {
    private String fio;
    private String group;
    private Date joined;

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }
}
