package com.tencent.p177mm.p612ui.tools;

import java.lang.reflect.Array;

/* renamed from: com.tencent.mm.ui.tools.l */
public final class C46697l {
    /* renamed from: c */
    public static float[] m88467c(float[][] fArr, float[] fArr2) {
        float[] fArr3 = new float[3];
        for (int i = 0; i < 3; i++) {
            float f = 0.0f;
            for (int i2 = 0; i2 < 3; i2++) {
                f += fArr[i][i2] * fArr2[i2];
            }
            fArr3[i] = f;
        }
        return fArr3;
    }

    /* renamed from: c */
    public static float[][] m88468c(float[][] fArr) {
        int i;
        int i2;
        float f;
        float[][] fArr2 = (float[][]) Array.newInstance(Float.TYPE, new int[]{3, 3});
        for (i = 0; i < 3; i++) {
            for (i2 = 0; i2 < 3; i2++) {
                float[] fArr3 = fArr2[i];
                if (i == i2) {
                    f = 1.0f;
                } else {
                    f = 0.0f;
                }
                fArr3[i2] = f;
            }
        }
        for (i = 0; i < 3; i++) {
            int i3;
            float f2;
            f = fArr[i][i];
            if (f == 0.0f) {
                i2 = i + 1;
                while (i2 < 3) {
                    if (fArr[i2][i] != 0.0f) {
                        for (i3 = 0; i3 < 3; i3++) {
                            f2 = fArr[i2][i3];
                            fArr[i2][i3] = fArr[i][i3];
                            fArr[i][i3] = f2;
                            f2 = fArr2[i2][i3];
                            fArr2[i2][i3] = fArr2[i][i3];
                            fArr2[i][i3] = f2;
                        }
                        f = fArr[i][i];
                    } else {
                        i2++;
                    }
                }
                f = fArr[i][i];
            }
            for (i2 = 0; i2 < 3; i2++) {
                fArr[i][i2] = fArr[i][i2] / f;
                fArr2[i][i2] = fArr2[i][i2] / f;
            }
            for (i2 = 0; i2 < 3; i2++) {
                if (i2 != i) {
                    f2 = fArr[i2][i];
                    for (i3 = 0; i3 < 3; i3++) {
                        fArr[i2][i3] = fArr[i2][i3] - (fArr[i][i3] * f2);
                        fArr2[i2][i3] = fArr2[i2][i3] - (fArr2[i][i3] * f2);
                    }
                }
            }
        }
        return fArr2;
    }
}
