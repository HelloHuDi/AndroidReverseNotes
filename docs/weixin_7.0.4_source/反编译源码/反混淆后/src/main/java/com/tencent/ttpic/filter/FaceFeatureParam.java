package com.tencent.ttpic.filter;

public class FaceFeatureParam {
    public float faceFeatureMultiplyAdjustValue = 0.8f;
    public String faceFeatureMultiplyImage = "beauty_multiply.png";
    public float faceFeatureNormalAdjustValue = 0.8f;
    public String faceFeatureNormalImage = "beauty_normal.png";
    public float faceFeatureSoftlightAdjustValue = 0.8f;
    public String faceFeatureSoftlightImage = "beauty_softlight.png";

    public FaceFeatureParam(float f) {
        this.faceFeatureNormalAdjustValue = f;
        this.faceFeatureMultiplyAdjustValue = f;
        this.faceFeatureSoftlightAdjustValue = f;
    }

    public FaceFeatureParam(float f, float f2, float f3) {
        this.faceFeatureNormalAdjustValue = f;
        this.faceFeatureMultiplyAdjustValue = f2;
        this.faceFeatureSoftlightAdjustValue = f3;
    }

    public FaceFeatureParam(float f, float f2, float f3, String str, String str2, String str3) {
        this.faceFeatureNormalAdjustValue = f;
        this.faceFeatureMultiplyAdjustValue = f2;
        this.faceFeatureSoftlightAdjustValue = f3;
        this.faceFeatureNormalImage = str;
        this.faceFeatureMultiplyImage = str2;
        this.faceFeatureSoftlightImage = str3;
    }
}
