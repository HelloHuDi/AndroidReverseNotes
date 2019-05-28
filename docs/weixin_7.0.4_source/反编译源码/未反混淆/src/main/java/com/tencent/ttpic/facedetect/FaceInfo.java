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
    public float tx;
    public float ty;
    public float yaw;

    public FaceInfo() {
        AppMethodBeat.i(81915);
        AppMethodBeat.o(81915);
    }
}
