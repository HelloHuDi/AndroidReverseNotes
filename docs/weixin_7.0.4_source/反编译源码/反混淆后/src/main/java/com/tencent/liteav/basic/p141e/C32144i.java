package com.tencent.liteav.basic.p141e;

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

/* renamed from: com.tencent.liteav.basic.e.i */
public class C32144i {
    /* renamed from: a */
    public static FloatBuffer f14742a = C32144i.m52317a(f14747f);
    /* renamed from: b */
    public static FloatBuffer f14743b = C32144i.m52317a(f14748g);
    /* renamed from: c */
    public static FloatBuffer f14744c = C32144i.m52317a(f14749h);
    /* renamed from: d */
    public static FloatBuffer f14745d = C32144i.m52317a(f14750i);
    /* renamed from: e */
    public static FloatBuffer f14746e = C32144i.m52317a(f14751j);
    /* renamed from: f */
    private static float[] f14747f = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    /* renamed from: g */
    private static float[] f14748g = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    /* renamed from: h */
    private static float[] f14749h = new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f};
    /* renamed from: i */
    private static float[] f14750i = new float[]{1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    /* renamed from: j */
    private static float[] f14751j = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f};
    /* renamed from: k */
    private static int f14752k = 2;

    /* renamed from: com.tencent.liteav.basic.e.i$a */
    public interface C32145a {
    }

    static {
        AppMethodBeat.m2504i(66205);
        AppMethodBeat.m2505o(66205);
    }

    /* renamed from: a */
    public static void m52318a(int i) {
        f14752k = i;
    }

    /* renamed from: a */
    public static final int m52309a() {
        return f14752k;
    }

    /* renamed from: a */
    public static int m52312a(int i, int i2, int i3, int i4, int[] iArr) {
        AppMethodBeat.m2504i(66195);
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i4, GLType.GL_UNSIGNED_BYTE, null);
        int i5 = iArr[0];
        AppMethodBeat.m2505o(66195);
        return i5;
    }

    /* renamed from: a */
    public static FloatBuffer m52317a(float[] fArr) {
        AppMethodBeat.m2504i(66196);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        asFloatBuffer.put(fArr);
        asFloatBuffer.position(0);
        AppMethodBeat.m2505o(66196);
        return asFloatBuffer;
    }

    /* renamed from: a */
    public static int m52311a(int i, int i2, int i3, int i4, IntBuffer intBuffer) {
        AppMethodBeat.m2504i(66197);
        int c = C32144i.m52320c();
        GLES20.glBindTexture(3553, c);
        GLES20.glTexImage2D(3553, 0, i3, i, i2, 0, i4, GLType.GL_UNSIGNED_BYTE, intBuffer);
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.m2505o(66197);
        return c;
    }

    /* renamed from: a */
    public static int m52310a(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(66198);
        int a = C32144i.m52311a(i, i2, i3, i4, null);
        AppMethodBeat.m2505o(66198);
        return a;
    }

    /* renamed from: a */
    public static int m52314a(Bitmap bitmap, int i, boolean z) {
        AppMethodBeat.m2504i(66199);
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
        AppMethodBeat.m2505o(66199);
        return i2;
    }

    /* renamed from: a */
    public static int m52313a(int i, int i2, int[] iArr) {
        AppMethodBeat.m2504i(66200);
        int i3 = (i * i2) * 4;
        GLES30.glGenBuffers(1, iArr, 0);
        GLES30.glBindBuffer(35051, iArr[0]);
        GLES30.glBufferData(35051, i3, null, 35049);
        GLES30.glBindBuffer(35051, 0);
        i3 = iArr[0];
        AppMethodBeat.m2505o(66200);
        return i3;
    }

    /* renamed from: b */
    public static int m52319b() {
        AppMethodBeat.m2504i(66201);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, iArr[0]);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        int i = iArr[0];
        AppMethodBeat.m2505o(66201);
        return i;
    }

    /* renamed from: c */
    public static int m52320c() {
        AppMethodBeat.m2504i(66202);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        GLES20.glBindTexture(3553, iArr[0]);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glBindTexture(3553, 0);
        int i = iArr[0];
        AppMethodBeat.m2505o(66202);
        return i;
    }

    /* renamed from: a */
    public static int m52315a(String str, int i) {
        AppMethodBeat.m2504i(66203);
        int[] iArr = new int[1];
        int glCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            TXCLog.m15675d("Load Shader Failed", "Compilation\n" + GLES20.glGetShaderInfoLog(glCreateShader));
            AppMethodBeat.m2505o(66203);
            return 0;
        }
        AppMethodBeat.m2505o(66203);
        return glCreateShader;
    }

    /* renamed from: a */
    public static int m52316a(String str, String str2) {
        AppMethodBeat.m2504i(66204);
        int[] iArr = new int[1];
        int a = C32144i.m52315a(str, 35633);
        if (a == 0) {
            TXCLog.m15675d("Load Program", "Vertex Shader Failed");
            AppMethodBeat.m2505o(66204);
            return 0;
        }
        int a2 = C32144i.m52315a(str2, 35632);
        if (a2 == 0) {
            TXCLog.m15675d("Load Program", "Fragment Shader Failed");
            AppMethodBeat.m2505o(66204);
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(glCreateProgram, a);
        GLES20.glAttachShader(glCreateProgram, a2);
        GLES20.glLinkProgram(glCreateProgram);
        GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            TXCLog.m15675d("Load Program", "Linking Failed");
            AppMethodBeat.m2505o(66204);
            return 0;
        }
        GLES20.glDeleteShader(a);
        GLES20.glDeleteShader(a2);
        AppMethodBeat.m2505o(66204);
        return glCreateProgram;
    }
}
