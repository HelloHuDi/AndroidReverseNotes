package com.tencent.youtu.ytagreflectlivecheck.jni.model;

public class ColorImgData {
    public long capture_time;
    public String image;
    public int x;
    public int y;

    public String getImage() {
        return this.image;
    }

    public void setImage(String str) {
        this.image = str;
    }

    public long getCapture_time() {
        return this.capture_time;
    }

    public void setCapture_time(long j) {
        this.capture_time = j;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int i) {
        this.x = i;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int i) {
        this.y = i;
    }
}
