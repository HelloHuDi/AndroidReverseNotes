package com.tencent.ttpic.facedetect;

import android.graphics.PointF;
import com.tencent.faceBeauty.FaceParam;
import java.util.List;

public class FaceParams {
    private float[] faceAngles;
    private FaceParam faceParam;
    private List<PointF> facePoints;

    public FaceParam getFaceParam() {
        return this.faceParam;
    }

    public void setFaceParam(FaceParam faceParam) {
        this.faceParam = faceParam;
    }

    public float[] getFaceAngles() {
        return this.faceAngles;
    }

    public void setFaceAngles(float[] fArr) {
        this.faceAngles = fArr;
    }

    public List<PointF> getFacePoints() {
        return this.facePoints;
    }

    public void setFacePoints(List<PointF> list) {
        this.facePoints = list;
    }
}
