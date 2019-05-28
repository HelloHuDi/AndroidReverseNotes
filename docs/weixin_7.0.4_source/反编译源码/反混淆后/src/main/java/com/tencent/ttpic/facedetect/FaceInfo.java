package com.tencent.ttpic.facedetect;

import android.graphics.PointF;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public class FaceInfo {
    public float[] angles = new float[3];
    public float[] denseFaceModel;
    public List<PointF> irisPoints;
    public float pitch;
    public List<PointF> points;
    public float roll;
    public float scale;
    public float[] transform;
    /* renamed from: tx */
    public float f17522tx;
    /* renamed from: ty */
    public float f17523ty;
    public float yaw;

    public FaceInfo() {
        AppMethodBeat.m2504i(81915);
        AppMethodBeat.m2505o(81915);
    }
}
