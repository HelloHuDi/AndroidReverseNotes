package com.tencent.p177mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.api.recordView.b */
public final class C26715b {
    /* renamed from: Vh */
    public static int m42548Vh() {
        AppMethodBeat.m2504i(76325);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int i = iArr[0];
        AppMethodBeat.m2505o(76325);
        return i;
    }

    /* renamed from: M */
    private static int m42546M(String str, int i) {
        AppMethodBeat.m2504i(76326);
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            C4990ab.m7412e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
            AppMethodBeat.m2505o(76326);
            return 0;
        }
        AppMethodBeat.m2505o(76326);
        return glCreateShader;
    }

    /* renamed from: U */
    public static int m42547U(String str, String str2) {
        AppMethodBeat.m2504i(76327);
        int[] iArr = new int[1];
        int M = C26715b.m42546M(str, 35633);
        if (M == 0) {
            C4990ab.m7412e("MicroMsg.MMSightCameraGLUtil", "load vertex shader failed");
            AppMethodBeat.m2505o(76327);
            return 0;
        }
        int M2 = C26715b.m42546M(str2, 35632);
        if (M2 == 0) {
            C4990ab.m7412e("MicroMsg.MMSightCameraGLUtil", "load fragment shader failed");
            AppMethodBeat.m2505o(76327);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, M);
        GLES20.glAttachShader(glCreateProgram, M2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            C4990ab.m7412e("MicroMsg.MMSightCameraGLUtil", "link program failed");
            AppMethodBeat.m2505o(76327);
            return 0;
        }
        GLES20.glDeleteShader(M);
        GLES20.glDeleteShader(M2);
        AppMethodBeat.m2505o(76327);
        return glCreateProgram;
    }
}
