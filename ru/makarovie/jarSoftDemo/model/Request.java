package ru.makarovie.jarSoftDemo.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userAgent;
    private String ipAddress;
    private LocalDate date;

    @ManyToOne
    private Banner banner;

    public Request(Banner banner, String useAgent, String ipAddress, LocalDate date) {
        this.banner = banner;
        this.userAgent = useAgent;
        this.ipAddress = ipAddress;
        this.date = date;
    }

    public Request (){
    }

    public Long getId() {
        return id;
    }

    public Banner getBanner() {
        return banner;
    }

    public void setBanner(Banner bannerId) {
        this.banner = bannerId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String user_agent) {
        this.userAgent = user_agent;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ip_address) {
        this.ipAddress = ip_address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
