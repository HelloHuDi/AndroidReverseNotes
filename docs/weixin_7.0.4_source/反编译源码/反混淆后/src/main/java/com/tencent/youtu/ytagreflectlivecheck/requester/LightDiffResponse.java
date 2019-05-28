package com.tencent.youtu.ytagreflectlivecheck.requester;

public class LightDiffResponse {
    private String business_name;
    private int error_code;
    private String error_msg;
    private int live_type;
    private String person_id;
    private String wx_open_business_id;

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

    public int getError_code() {
        return this.error_code;
    }

    public void setError_code(int i) {
        this.error_code = i;
    }

    public String getError_msg() {
        return this.error_msg;
    }

    public void setError_msg(String str) {
        this.error_msg = str;
    }

    public String getWx_open_business_id() {
        return this.wx_open_business_id;
    }

    public void setWx_open_business_id(String str) {
        this.wx_open_business_id = str;
    }

    public int getLive_type() {
        return this.live_type;
    }

    public void setLive_type(int i) {
        this.live_type = i;
    }
}
