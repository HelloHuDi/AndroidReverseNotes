package com.tencent.liteav.basic.p141e;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.basic.e.k */
public class C45103k {
    /* renamed from: a */
    public static final float[] f17754a = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
    /* renamed from: b */
    public static final float[] f17755b = new float[]{1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f};
    /* renamed from: c */
    public static final float[] f17756c = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    /* renamed from: d */
    public static final float[] f17757d = new float[]{0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    /* renamed from: e */
    public static final float[] f17758e = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: a */
    public static float[] m82749a(C37353j c37353j, boolean z, boolean z2) {
        float[] fArr;
        AppMethodBeat.m2504i(66174);
        switch (c37353j) {
            case ROTATION_90:
                fArr = (float[]) f17755b.clone();
                break;
            case ROTATION_180:
                fArr = (float[]) f17756c.clone();
                break;
            case ROTATION_270:
                fArr = (float[]) f17757d.clone();
                break;
            default:
                fArr = (float[]) f17754a.clone();
                break;
        }
        fArr = z2 ? new float[]{(z ? new float[]{C45103k.m82748a(fArr[0]), fArr[1], C45103k.m82748a(fArr[2]), fArr[3], C45103k.m82748a(fArr[4]), fArr[5], C45103k.m82748a(fArr[6]), fArr[7]} : fArr)[0], C45103k.m82748a((z ? new float[]{C45103k.m82748a(fArr[0]), fArr[1], C45103k.m82748a(fArr[2]), fArr[3], C45103k.m82748a(fArr[4]), fArr[5], C45103k.m82748a(fArr[6]), fArr[7]} : fArr)[1]), (z ? new float[]{C45103k.m82748a(fArr[0]), fArr[1], C45103k.m82748a(fArr[2]), fArr[3], C45103k.m82748a(fArr[4]), fArr[5], C45103k.m82748a(fArr[6]), fArr[7]} : fArr)[2], C45103k.m82748a((z ? new float[]{C45103k.m82748a(fArr[0]), fArr[1], C45103k.m82748a(fArr[2]), fArr[3], C45103k.m82748a(fArr[4]), fArr[5], C45103k.m82748a(fArr[6]), fArr[7]} : fArr)[3]), (z ? new float[]{C45103k.m82748a(fArr[0]), fArr[1], C45103k.m82748a(fArr[2]), fArr[3], C45103k.m82748a(fArr[4]), fArr[5], C45103k.m82748a(fArr[6]), fArr[7]} : fArr)[4], C45103k.m82748a((z ? new float[]{C45103k.m82748a(fArr[0]), fArr[1], C45103k.m82748a(fArr[2]), fArr[3], C45103k.m82748a(fArr[4]), fArr[5], C45103k.m82748a(fArr[6]), fArr[7]} : fArr)[5]), (z ? new float[]{C45103k.m82748a(fArr[0]), fArr[1], C45103k.m82748a(fArr[2]), fArr[3], C45103k.m82748a(fArr[4]), fArr[5], C45103k.m82748a(fArr[6]), fArr[7]} : fArr)[6], C45103k.m82748a((z ? new float[]{C45103k.m82748a(fArr[0]), fArr[1], C45103k.m82748a(fArr[2]), fArr[3], C45103k.m82748a(fArr[4]), fArr[5], C45103k.m82748a(fArr[6]), fArr[7]} : fArr)[7])} : z ? new float[]{C45103k.m82748a(fArr[0]), fArr[1], C45103k.m82748a(fArr[2]), fArr[3], C45103k.m82748a(fArr[4]), fArr[5], C45103k.m82748a(fArr[6]), fArr[7]} : fArr;
        AppMethodBeat.m2505o(66174);
        return fArr;
    }

    /* renamed from: a */
    private static float m82748a(float f) {
        if (f == 0.0f) {
            return 1.0f;
        }
        return 0.0f;
    }
}
