package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import java.util.ArrayList;

public class ReflectColorData {
    public long begin_time;
    public long changepoint_time;
    public int config_begin;
    public int frame_num;
    public int height;
    public ArrayList<ColorImgData> images_data;
    public int landmark_num;
    public String log;
    public float offset_sys;
    public int width;

    public ArrayList<ColorImgData> getImages_data() {
        return this.images_data;
    }

    public void setImages_data(ArrayList<ColorImgData> arrayList) {
        this.images_data = arrayList;
    }

    public long getBegin_time() {
        return this.begin_time;
    }

    public void setBegin_time(long j) {
        this.begin_time = j;
    }

    public long getChangepoint_time() {
        return this.changepoint_time;
    }

    public void setChangepoint_time(long j) {
        this.changepoint_time = j;
    }

    public float getOffset_sys() {
        return this.offset_sys;
    }

    public void setOffset_sys(float f) {
        this.offset_sys = f;
    }

    public int getFrame_num() {
        return this.frame_num;
    }

    public void setFrame_num(int i) {
        this.frame_num = i;
    }

    public int getLandmark_num() {
        return this.landmark_num;
    }

    public void setLandmark_num(int i) {
        this.landmark_num = i;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        this.width = i;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int i) {
        this.height = i;
    }

    public String getLog() {
        return this.log;
    }

    public void setLog(String str) {
        this.log = str;
    }

    public int getConfig_begin() {
        return this.config_begin;
    }

    public void setConfig_begin(int i) {
        this.config_begin = i;
    }
}
