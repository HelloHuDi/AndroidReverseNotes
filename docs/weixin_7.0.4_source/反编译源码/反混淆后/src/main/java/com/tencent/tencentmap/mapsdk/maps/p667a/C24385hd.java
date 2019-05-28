package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.opengl.GLU;
import android.opengl.Matrix;
import com.tencent.map.lib.p822gl.model.C37426c;
import com.tencent.map.lib.p822gl.model.C41720d;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.hd */
public class C24385hd {
    /* renamed from: a */
    private static final String[] f4732a = new String[]{"北", "东北", "东", "东南", "南", "西南", "西", "西北"};

    /* renamed from: a */
    public static boolean m37827a(float f, float f2, float[] fArr, float[] fArr2, int[] iArr) {
        AppMethodBeat.m2504i(99525);
        C41720d a = C24385hd.m37826a(fArr);
        float[] fArr3 = new float[16];
        Matrix.setIdentityM(fArr3, 0);
        float[] a2 = C24385hd.m37829a(f, f2, 0.0f, fArr3, fArr2, iArr);
        float[] a3 = C24385hd.m37829a(f, f2, 1.0f, fArr3, fArr2, iArr);
        for (int i = 0; i < 3; i++) {
            a2[i] = a2[i] / a2[3];
            a3[i] = a3[i] / a3[3];
        }
        C41720d c41720d = new C41720d(a3[0] - a2[0], a3[1] - a2[1], a3[2] - a2[2]);
        float[] a4 = C24385hd.m37830a(a.mo67460a(), new float[]{fArr[0], fArr[1], fArr[2]}, c41720d.mo67460a(), new float[]{a2[0], a2[1], a2[2]});
        if (a4 == null) {
            AppMethodBeat.m2505o(99525);
            return false;
        }
        boolean a5 = C24385hd.m37828a(a4, fArr);
        AppMethodBeat.m2505o(99525);
        return a5;
    }

    /* renamed from: a */
    public static float[] m37829a(float f, float f2, float f3, float[] fArr, float[] fArr2, int[] iArr) {
        AppMethodBeat.m2504i(99526);
        float[] fArr3 = new float[4];
        if (GLU.gluUnProject(f, ((float) iArr[3]) - f2, f3, fArr, 0, fArr2, 0, iArr, 0, fArr3, 0) != 1) {
            RuntimeException runtimeException = new RuntimeException("unProject fail");
            AppMethodBeat.m2505o(99526);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(99526);
        return fArr3;
    }

    /* renamed from: a */
    private static C41720d m37826a(float[] fArr) {
        AppMethodBeat.m2504i(99527);
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr[3];
        float f5 = fArr[4];
        float f6 = fArr[5];
        float f7 = fArr[6];
        float f8 = fArr[7];
        float f9 = fArr[8];
        r9 = new float[3];
        r10 = new float[3];
        float[] fArr2 = new float[]{f4 - f, f5 - f2, f6 - f3};
        fArr2[0] = f7 - f;
        fArr2[1] = f8 - f2;
        fArr2[2] = f9 - f3;
        r9[0] = (r10[1] * fArr2[2]) - (r10[2] * fArr2[1]);
        r9[1] = (r10[2] * fArr2[0]) - (r10[0] * fArr2[2]);
        r9[2] = (r10[0] * fArr2[1]) - (r10[1] * fArr2[0]);
        C41720d c41720d = new C41720d(r9[0], r9[1], r9[2]);
        AppMethodBeat.m2505o(99527);
        return c41720d;
    }

    /* renamed from: a */
    private static boolean m37828a(float[] fArr, float[] fArr2) {
        AppMethodBeat.m2504i(99528);
        boolean a = new C37426c(fArr2).mo60288a(fArr);
        AppMethodBeat.m2505o(99528);
        return a;
    }

    /* renamed from: a */
    public static float[] m37830a(float[] fArr, float[] fArr2, float[] fArr3, float[] fArr4) {
        float[] fArr5 = new float[3];
        float f = fArr[0];
        float f2 = fArr[1];
        float f3 = fArr[2];
        float f4 = fArr2[0];
        float f5 = fArr2[1];
        float f6 = fArr2[2];
        float f7 = fArr3[0];
        float f8 = fArr3[1];
        float f9 = fArr3[2];
        float f10 = fArr4[0];
        float f11 = fArr4[1];
        float f12 = fArr4[2];
        float f13 = ((f7 * f) + (f8 * f2)) + (f9 * f3);
        if (f13 == 0.0f) {
            return null;
        }
        f = (((f * (f4 - f10)) + (f2 * (f5 - f11))) + ((f6 - f12) * f3)) / f13;
        fArr5[0] = (f7 * f) + f10;
        fArr5[1] = (f8 * f) + f11;
        fArr5[2] = (f * f9) + f12;
        return fArr5;
    }
}
