package com.tencent.youtu.ytagreflectlivecheck.jni.model;

import java.util.ArrayList;

public class PersonLive {
    private String color_data;
    private ArrayList<FaceFrame> frames;
    private int platform;
    private ReflectColorData reflect_data;

    public ReflectColorData getReflect_data() {
        return this.reflect_data;
    }

    public void setReflect_data(ReflectColorData reflectColorData) {
        this.reflect_data = reflectColorData;
    }

    public String getColor_data() {
        return this.color_data;
    }

    public void setColor_data(String str) {
        this.color_data = str;
    }

    public int getPlatform() {
        return this.platform;
    }

    public void setPlatform(int i) {
        this.platform = i;
    }

    public ArrayList<FaceFrame> getFrames() {
        return this.frames;
    }

    public void setFrames(ArrayList<FaceFrame> arrayList) {
        this.frames = arrayList;
    }
}
