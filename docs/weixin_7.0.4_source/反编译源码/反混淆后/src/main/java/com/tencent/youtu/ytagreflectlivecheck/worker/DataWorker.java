package com.tencent.youtu.ytagreflectlivecheck.worker;

public class DataWorker {
    private static final String TAG = "YoutuLightLiveCheck";
    public int mCameraRotate;
    public String mRgbConfigCode;

    public void cleanup() {
        this.mRgbConfigCode = null;
    }
}
