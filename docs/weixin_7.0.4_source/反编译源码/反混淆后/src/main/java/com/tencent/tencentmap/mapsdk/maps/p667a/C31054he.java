package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.opengl.Matrix;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.he */
public class C31054he {
    /* renamed from: a */
    public static boolean m49928a(float[][] fArr, float[] fArr2) {
        AppMethodBeat.m2504i(99529);
        boolean b = C31054he.m49930b(fArr, fArr2);
        AppMethodBeat.m2505o(99529);
        return b;
    }

    /* renamed from: b */
    private static boolean m49930b(float[][] fArr, float[] fArr2) {
        int length = fArr2.length / 3;
        for (int i = 0; i < 6; i++) {
            int i2 = 0;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i2 + 1;
                int i5 = i4 + 1;
                float f = (fArr[i][1] * fArr2[i4]) + (fArr2[i2] * fArr[i][0]);
                i2 = i5 + 1;
                if ((f + (fArr[i][2] * fArr2[i5])) + fArr[i][3] > 0.0f) {
                    break;
                }
                i3++;
            }
            if (i3 == length) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static float[][] m49929a(float[] fArr, float[] fArr2) {
        AppMethodBeat.m2504i(99530);
        r0 = new float[16];
        Matrix.multiplyMM(r0, 0, fArr2, 0, fArr, 0);
        float[][] fArr3 = (float[][]) Array.newInstance(Float.TYPE, new int[]{6, 4});
        fArr3[0][0] = r0[3] - r0[0];
        fArr3[0][1] = r0[7] - r0[4];
        fArr3[0][2] = r0[11] - r0[8];
        fArr3[0][3] = r0[15] - r0[12];
        double sqrt = Math.sqrt((double) (((fArr3[0][0] * fArr3[0][0]) + (fArr3[0][1] * fArr3[0][1])) + (fArr3[0][2] * fArr3[0][2])));
        float[] fArr4 = fArr3[0];
        fArr4[0] = (float) (((double) fArr4[0]) / sqrt);
        fArr4 = fArr3[0];
        fArr4[1] = (float) (((double) fArr4[1]) / sqrt);
        fArr4 = fArr3[0];
        fArr4[2] = (float) (((double) fArr4[2]) / sqrt);
        fArr4 = fArr3[0];
        fArr4[3] = (float) (((double) fArr4[3]) / sqrt);
        fArr3[1][0] = r0[3] + r0[0];
        fArr3[1][1] = r0[7] + r0[4];
        fArr3[1][2] = r0[11] + r0[8];
        fArr3[1][3] = r0[15] + r0[12];
        sqrt = Math.sqrt((double) (((fArr3[1][0] * fArr3[1][0]) + (fArr3[1][1] * fArr3[1][1])) + (fArr3[1][2] * fArr3[1][2])));
        fArr4 = fArr3[1];
        fArr4[0] = (float) (((double) fArr4[0]) / sqrt);
        fArr4 = fArr3[1];
        fArr4[1] = (float) (((double) fArr4[1]) / sqrt);
        fArr4 = fArr3[1];
        fArr4[2] = (float) (((double) fArr4[2]) / sqrt);
        fArr4 = fArr3[1];
        fArr4[3] = (float) (((double) fArr4[3]) / sqrt);
        fArr3[2][0] = r0[3] + r0[1];
        fArr3[2][1] = r0[7] + r0[5];
        fArr3[2][2] = r0[11] + r0[9];
        fArr3[2][3] = r0[15] + r0[13];
        sqrt = Math.sqrt((double) (((fArr3[2][0] * fArr3[2][0]) + (fArr3[2][1] * fArr3[2][1])) + (fArr3[2][2] * fArr3[2][2])));
        fArr4 = fArr3[2];
        fArr4[0] = (float) (((double) fArr4[0]) / sqrt);
        fArr4 = fArr3[2];
        fArr4[1] = (float) (((double) fArr4[1]) / sqrt);
        fArr4 = fArr3[2];
        fArr4[2] = (float) (((double) fArr4[2]) / sqrt);
        fArr4 = fArr3[2];
        fArr4[3] = (float) (((double) fArr4[3]) / sqrt);
        fArr3[3][0] = r0[3] - r0[1];
        fArr3[3][1] = r0[7] - r0[5];
        fArr3[3][2] = r0[11] - r0[9];
        fArr3[3][3] = r0[15] - r0[13];
        sqrt = Math.sqrt((double) (((fArr3[3][0] * fArr3[3][0]) + (fArr3[3][1] * fArr3[3][1])) + (fArr3[3][2] * fArr3[3][2])));
        fArr4 = fArr3[3];
        fArr4[0] = (float) (((double) fArr4[0]) / sqrt);
        fArr4 = fArr3[3];
        fArr4[1] = (float) (((double) fArr4[1]) / sqrt);
        fArr4 = fArr3[3];
        fArr4[2] = (float) (((double) fArr4[2]) / sqrt);
        fArr4 = fArr3[3];
        fArr4[3] = (float) (((double) fArr4[3]) / sqrt);
        fArr3[4][0] = r0[3] - r0[2];
        fArr3[4][1] = r0[7] - r0[6];
        fArr3[4][2] = r0[11] - r0[10];
        fArr3[4][3] = r0[15] - r0[14];
        sqrt = Math.sqrt((double) (((fArr3[4][0] * fArr3[4][0]) + (fArr3[4][1] * fArr3[4][1])) + (fArr3[4][2] * fArr3[4][2])));
        fArr4 = fArr3[4];
        fArr4[0] = (float) (((double) fArr4[0]) / sqrt);
        fArr4 = fArr3[4];
        fArr4[1] = (float) (((double) fArr4[1]) / sqrt);
        fArr4 = fArr3[4];
        fArr4[2] = (float) (((double) fArr4[2]) / sqrt);
        fArr4 = fArr3[4];
        fArr4[3] = (float) (((double) fArr4[3]) / sqrt);
        fArr3[5][0] = r0[3] + r0[2];
        fArr3[5][1] = r0[7] + r0[6];
        fArr3[5][2] = r0[11] + r0[10];
        fArr3[5][3] = r0[14] + r0[15];
        sqrt = Math.sqrt((double) (((fArr3[5][0] * fArr3[5][0]) + (fArr3[5][1] * fArr3[5][1])) + (fArr3[5][2] * fArr3[5][2])));
        r0 = fArr3[5];
        r0[0] = (float) (((double) r0[0]) / sqrt);
        r0 = fArr3[5];
        r0[1] = (float) (((double) r0[1]) / sqrt);
        r0 = fArr3[5];
        r0[2] = (float) (((double) r0[2]) / sqrt);
        r0 = fArr3[5];
        r0[3] = (float) (((double) r0[3]) / sqrt);
        AppMethodBeat.m2505o(99530);
        return fArr3;
    }
}
