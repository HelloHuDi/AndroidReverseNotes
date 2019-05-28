package com.tencent.youtu.ytagreflectlivecheck.jni.model;

public class PersonLiveReq {
    private String app_id;
    private String business_name;
    private int live_type;
    private PersonLive livedata;
    private String person_id;
    private String req_type;

    public PersonLiveReq(String str, String str2, String str3, PersonLive personLive, int i, String str4) {
        this.app_id = str;
        this.business_name = str2;
        this.person_id = str3;
        this.livedata = personLive;
        this.live_type = i;
        this.req_type = str4;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public String getBusiness_name() {
        return this.business_name;
    }

    public void setBusiness_name(String str) {
        this.business_name = str;
    }

    public String getPerson_id() {
        return this.person_id;
    }

    public void setPerson_id(String str) {
        this.person_id = str;
    }

    public PersonLive getLivedata() {
        return this.livedata;
    }

    public void setLivedata(PersonLive personLive) {
        this.livedata = personLive;
    }

    public int getLive_type() {
        return this.live_type;
    }

    public void setLive_type(int i) {
        this.live_type = i;
    }

    public String getReq_type() {
        return this.req_type;
    }

    public void setReq_type(String str) {
        this.req_type = str;
    }
}
