package com.tencent.mm.plugin.api.recordView;

import android.opengl.GLES20;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static int Vh() {
        AppMethodBeat.i(76325);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        int i = iArr[0];
        AppMethodBeat.o(76325);
        return i;
    }

    private static int M(String str, int i) {
        AppMethodBeat.i(76326);
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            ab.e("loadShader error, infoLog: %s", GLES20.glGetShaderInfoLog(glCreateShader));
            AppMethodBeat.o(76326);
            return 0;
        }
        AppMethodBeat.o(76326);
        return glCreateShader;
    }

    public static int U(String str, String str2) {
        AppMethodBeat.i(76327);
        int[] iArr = new int[1];
        int M = M(str, 35633);
        if (M == 0) {
            ab.e("MicroMsg.MMSightCameraGLUtil", "load vertex shader failed");
            AppMethodBeat.o(76327);
            return 0;
        }
        int M2 = M(str2, 35632);
        if (M2 == 0) {
            ab.e("MicroMsg.MMSightCameraGLUtil", "load fragment shader failed");
            AppMethodBeat.o(76327);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, M);
        GLES20.glAttachShader(glCreateProgram, M2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            ab.e("MicroMsg.MMSightCameraGLUtil", "link program failed");
            AppMethodBeat.o(76327);
            return 0;
        }
        GLES20.glDeleteShader(M);
        GLES20.glDeleteShader(M2);
        AppMethodBeat.o(76327);
        return glCreateProgram;
    }
}
