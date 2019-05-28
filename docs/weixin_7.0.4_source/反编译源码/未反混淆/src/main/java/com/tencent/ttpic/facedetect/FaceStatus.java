package com.tencent.ttpic.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FaceStatus {
    public float[] denseFaceModel;
    public int illumination_score;
    public float pitch;
    public float roll;
    public float scale;
    public float[] transform;
    public float tx;
    public float ty;
    public float[] xys = new float[188];
    public float yaw;

    public FaceStatus() {
        AppMethodBeat.i(49936);
        AppMethodBeat.o(49936);
    }
}
