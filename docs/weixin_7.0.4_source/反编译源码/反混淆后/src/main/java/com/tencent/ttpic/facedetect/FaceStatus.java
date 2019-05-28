package com.tencent.ttpic.facedetect;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class FaceStatus {
    public float[] denseFaceModel;
    public int illumination_score;
    public float pitch;
    public float roll;
    public float scale;
    public float[] transform;
    /* renamed from: tx */
    public float f16557tx;
    /* renamed from: ty */
    public float f16558ty;
    public float[] xys = new float[188];
    public float yaw;

    public FaceStatus() {
        AppMethodBeat.m2504i(49936);
        AppMethodBeat.m2505o(49936);
    }
}
