package com.tencent.ttpic.util;

import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MatrixUtil {
    private static float[] mIdentityMatrix = new float[16];
    private static float[] mMVPMatrix = new float[16];
    private static float[] mProjectionMatrix = new float[16];
    private static float[] mViewMatrix = new float[16];

    public static float[] getIdentityMatrix() {
        AppMethodBeat.m2504i(83931);
        Matrix.setIdentityM(mIdentityMatrix, 0);
        float[] fArr = mIdentityMatrix;
        AppMethodBeat.m2505o(83931);
        return fArr;
    }

    public static float[] getDefaultMVPMatrix() {
        AppMethodBeat.m2504i(83932);
        initProjectionMatrix(1.0f, 3.0f);
        initViewMatrix(2.0f);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        float[] fArr = mMVPMatrix;
        AppMethodBeat.m2505o(83932);
        return fArr;
    }

    public static float[] getMVPMatrix(float f, float f2, float f3) {
        AppMethodBeat.m2504i(83933);
        initProjectionMatrix(f2, f3);
        initViewMatrix(f);
        Matrix.multiplyMM(mMVPMatrix, 0, mProjectionMatrix, 0, mViewMatrix, 0);
        float[] fArr = mMVPMatrix;
        AppMethodBeat.m2505o(83933);
        return fArr;
    }

    public static float[] initProjectionMatrix(float f, float f2) {
        AppMethodBeat.m2504i(83934);
        Matrix.frustumM(mProjectionMatrix, 0, -1.0f, 1.0f, -1.0f, 1.0f, f, f2);
        float[] fArr = mProjectionMatrix;
        AppMethodBeat.m2505o(83934);
        return fArr;
    }

    public static float[] initViewMatrix(float f) {
        AppMethodBeat.m2504i(83935);
        Matrix.setLookAtM(mViewMatrix, 0, 0.0f, 0.0f, f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
        float[] fArr = mViewMatrix;
        AppMethodBeat.m2505o(83935);
        return fArr;
    }
}
