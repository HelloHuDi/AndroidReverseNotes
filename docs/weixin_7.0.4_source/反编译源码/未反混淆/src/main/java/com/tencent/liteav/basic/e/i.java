package com.tencent.liteav.basic.e;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLES30;
import android.opengl.GLUtils;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class i {
    public static FloatBuffer a = a(f);
    public static FloatBuffer b = a(g);
    public static FloatBuffer c = a(h);
    public static FloatBuffer d = a(i);
    public static FloatBuffer e = a(j);
    private static float[] f = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static float[] g = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    private static float[] h = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    private static float[] i = new float[]{1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private static float[] j = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    private static int k = 2;

    public interface a {
    }

    static {
        AppMethodBeat.i(66205);
        AppMethodBeat.o(66205);
    }

    public static void a(int i) {
        k = i;
    }

    public static final int a() {
        return k;
    }

    public static int a(int i, int i2, int i3, int i4, int[] iArr) {
        AppMethodBeat.i(66195);
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i4, GLType.GL_UNSIGNED_BYTE, null);
        int i5 = iArr[0];
        AppMethodBeat.o(66195);
        return i5;
    }

    public static FloatBuffer a(float[] fArr) {
        AppMethodBeat.i(66196);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        AppMethodBeat.o(66196);
        return asFloatBuffer;
    }

    public static int a(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        AppMethodBeat.i(66197);
        int c = c();
        GLES20.glBindTexture(3553, c);
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i4, GLType.GL_UNSIGNED_BYTE, intBuffer);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.o(66197);
        return c;
    }

    public static int a(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(66198);
        int a = a(i, i2, i3, i4, null);
        AppMethodBeat.o(66198);
        return a;
    }

    public static int a(Bitmap bitmap, int i, boolean z) {
        AppMethodBeat.i(66199);
        int[] iArr = new int[1];
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
        } else {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i;
        }
        if (z) {
            bitmap.recycle();
        }
        int i2 = iArr[0];
        AppMethodBeat.o(66199);
        return i2;
    }

    public static int a(int i, int i2, int[] iArr) {
        AppMethodBeat.i(66200);
        int i3 = (i * i2) * 4;
        GLES30.glGenBuffers(1, iArr, 0);
        GLES30.glBindBuffer(35051, iArr[0]);
        GLES30.glBufferData(35051, i3, null, 35049);
        GLES30.glBindBuffer(35051, 0);
        i3 = iArr[0];
        AppMethodBeat.o(66200);
        return i3;
    }

    public static int b() {
        AppMethodBeat.i(66201);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, iArr[0]);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        int i = iArr[0];
        AppMethodBeat.o(66201);
        return i;
    }

    public static int c() {
        AppMethodBeat.i(66202);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        int i = iArr[0];
        AppMethodBeat.o(66202);
        return i;
    }

    public static int a(String str, int i) {
        AppMethodBeat.i(66203);
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            TXCLog.d("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader));
            AppMethodBeat.o(66203);
            return 0;
        }
        AppMethodBeat.o(66203);
        return glCreateShader;
    }

    public static int a(String str, String str2) {
        AppMethodBeat.i(66204);
        int[] iArr = new int[1];
        int a = a(str, 35633);
        if (a == 0) {
            TXCLog.d("Load Program", "Vertex Shader Failed");
            AppMethodBeat.o(66204);
            return 0;
        }
        int a2 = a(str2, 35632);
        if (a2 == 0) {
            TXCLog.d("Load Program", "Fragment Shader Failed");
            AppMethodBeat.o(66204);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, a);
        GLES20.glAttachShader(glCreateProgram, a2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            TXCLog.d("Load Program", "Linking Failed");
            AppMethodBeat.o(66204);
            return 0;
        }
        GLES20.glDeleteShader(a);
        GLES20.glDeleteShader(a2);
        AppMethodBeat.o(66204);
        return glCreateProgram;
    }
}
