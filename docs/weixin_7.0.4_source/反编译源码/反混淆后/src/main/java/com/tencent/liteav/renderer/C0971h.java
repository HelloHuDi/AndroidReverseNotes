package com.tencent.liteav.renderer;

import android.opengl.GLES20;
import android.opengl.Matrix;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.liteav.renderer.h */
public class C0971h {
    /* renamed from: a */
    public static int f1145a = 1;
    /* renamed from: b */
    public static int f1146b = 2;
    /* renamed from: c */
    private int f1147c = 0;
    /* renamed from: d */
    private int f1148d = 0;
    /* renamed from: e */
    private int f1149e = 0;
    /* renamed from: f */
    private int f1150f = 0;
    /* renamed from: g */
    private int f1151g = f1146b;
    /* renamed from: h */
    private int f1152h = 0;
    /* renamed from: i */
    private boolean f1153i = false;
    /* renamed from: j */
    private float[] f1154j = new float[16];
    /* renamed from: k */
    private float[] f1155k = new float[16];
    /* renamed from: l */
    private float f1156l = 1.0f;
    /* renamed from: m */
    private float f1157m = 1.0f;
    /* renamed from: n */
    private boolean f1158n = false;
    /* renamed from: o */
    private boolean f1159o = true;
    /* renamed from: p */
    private final float[] f1160p = new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    /* renamed from: q */
    private FloatBuffer f1161q;
    /* renamed from: r */
    private float[] f1162r = new float[16];
    /* renamed from: s */
    private float[] f1163s = new float[16];
    /* renamed from: t */
    private int f1164t;
    /* renamed from: u */
    private int f1165u = -12345;
    /* renamed from: v */
    private int f1166v = -12345;
    /* renamed from: w */
    private int f1167w;
    /* renamed from: x */
    private int f1168x;
    /* renamed from: y */
    private int f1169y;
    /* renamed from: z */
    private int f1170z;

    /* renamed from: a */
    public void mo3898a(int i, int i2) {
        AppMethodBeat.m2504i(67239);
        if (i == this.f1147c && i2 == this.f1148d) {
            AppMethodBeat.m2505o(67239);
            return;
        }
        TXCLog.m15675d("TXTweenFilter", "Output resolution change: " + this.f1147c + "*" + this.f1148d + " -> " + i + "*" + i2);
        this.f1147c = i;
        this.f1148d = i2;
        Matrix.orthoM(this.f1154j, 0, -1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f);
        this.f1156l = 1.0f;
        this.f1157m = 1.0f;
        this.f1158n = true;
        AppMethodBeat.m2505o(67239);
    }

    /* renamed from: b */
    public void mo3903b(int i, int i2) {
        AppMethodBeat.m2504i(67240);
        if (i == this.f1149e && i2 == this.f1150f) {
            AppMethodBeat.m2505o(67240);
            return;
        }
        TXCLog.m15675d("TXTweenFilter", "Input resolution change: " + this.f1149e + "*" + this.f1150f + " -> " + i + "*" + i2);
        this.f1149e = i;
        this.f1150f = i2;
        AppMethodBeat.m2505o(67240);
    }

    /* renamed from: a */
    public boolean mo3900a() {
        return this.f1159o;
    }

    /* renamed from: a */
    public void mo3897a(int i) {
        this.f1151g = i;
    }

    /* renamed from: b */
    public void mo3902b(int i) {
        this.f1152h = i;
    }

    /* renamed from: b */
    private void m2185b(float[] fArr) {
        AppMethodBeat.m2504i(67241);
        if (this.f1148d == 0 || this.f1147c == 0) {
            AppMethodBeat.m2505o(67241);
            return;
        }
        int i = this.f1149e;
        int i2 = this.f1150f;
        if (this.f1152h == 270 || this.f1152h == 90) {
            i = this.f1150f;
            i2 = this.f1149e;
        }
        float f = (((float) this.f1147c) * 1.0f) / ((float) i);
        float f2 = (((float) this.f1148d) * 1.0f) / ((float) i2);
        if (this.f1151g != f1145a ? ((float) i2) * f > ((float) this.f1148d) : ((float) i2) * f <= ((float) this.f1148d)) {
            f2 = f;
        }
        Matrix.setIdentityM(this.f1155k, 0);
        if (this.f1153i) {
            if (this.f1152h % 180 == 0) {
                Matrix.scaleM(this.f1155k, 0, -1.0f, 1.0f, 1.0f);
            } else {
                Matrix.scaleM(this.f1155k, 0, 1.0f, -1.0f, 1.0f);
            }
        }
        Matrix.scaleM(this.f1155k, 0, ((((float) i) * f2) / ((float) this.f1147c)) * 1.0f, ((((float) i2) * f2) / ((float) this.f1148d)) * 1.0f, 1.0f);
        Matrix.rotateM(this.f1155k, 0, (float) this.f1152h, 0.0f, 0.0f, -1.0f);
        Matrix.multiplyMM(fArr, 0, this.f1154j, 0, this.f1155k, 0);
        AppMethodBeat.m2505o(67241);
    }

    public C0971h(Boolean bool) {
        AppMethodBeat.m2504i(67242);
        this.f1159o = bool.booleanValue();
        this.f1161q = ByteBuffer.allocateDirect(this.f1160p.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f1161q.put(this.f1160p).position(0);
        Matrix.setIdentityM(this.f1163s, 0);
        AppMethodBeat.m2505o(67242);
    }

    /* renamed from: a */
    public void mo3899a(float[] fArr) {
        this.f1163s = fArr;
    }

    /* renamed from: c */
    public void mo3905c(int i) {
        AppMethodBeat.m2504i(67243);
        GLES20.glViewport(0, 0, this.f1147c, this.f1148d);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        GLES20.glUseProgram(this.f1164t);
        m2184a("glUseProgram");
        if (this.f1159o) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, i);
        } else {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, i);
        }
        this.f1161q.position(0);
        GLES20.glVertexAttribPointer(this.f1169y, 3, 5126, false, 20, this.f1161q);
        m2184a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f1169y);
        m2184a("glEnableVertexAttribArray maPositionHandle");
        this.f1161q.position(3);
        GLES20.glVertexAttribPointer(this.f1170z, 2, 5126, false, 20, this.f1161q);
        m2184a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f1170z);
        m2184a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f1162r, 0);
        m2185b(this.f1162r);
        GLES20.glUniformMatrix4fv(this.f1167w, 1, false, this.f1162r, 0);
        GLES20.glUniformMatrix4fv(this.f1168x, 1, false, this.f1163s, 0);
        m2184a("glDrawArrays");
        GLES20.glDrawArrays(5, 0, 4);
        m2184a("glDrawArrays");
        if (this.f1159o) {
            GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
            AppMethodBeat.m2505o(67243);
            return;
        }
        GLES20.glBindTexture(3553, 0);
        AppMethodBeat.m2505o(67243);
    }

    /* renamed from: d */
    public int mo3906d(int i) {
        AppMethodBeat.m2504i(67244);
        m2186d();
        if (this.f1166v == -12345) {
            TXCLog.m15675d("TXTweenFilter", "invalid frame buffer id");
            AppMethodBeat.m2505o(67244);
            return i;
        }
        GLES20.glBindFramebuffer(36160, this.f1166v);
        mo3905c(i);
        GLES20.glBindFramebuffer(36160, 0);
        i = this.f1165u;
        AppMethodBeat.m2505o(67244);
        return i;
    }

    /* renamed from: b */
    public void mo3901b() {
        AppMethodBeat.m2504i(67245);
        if (this.f1159o) {
            this.f1164t = m2183a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            this.f1164t = m2183a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
        }
        RuntimeException runtimeException;
        if (this.f1164t == 0) {
            runtimeException = new RuntimeException("failed creating program");
            AppMethodBeat.m2505o(67245);
            throw runtimeException;
        }
        this.f1169y = GLES20.glGetAttribLocation(this.f1164t, "aPosition");
        m2184a("glGetAttribLocation aPosition");
        if (this.f1169y == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for aPosition");
            AppMethodBeat.m2505o(67245);
            throw runtimeException;
        }
        this.f1170z = GLES20.glGetAttribLocation(this.f1164t, "aTextureCoord");
        m2184a("glGetAttribLocation aTextureCoord");
        if (this.f1170z == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for aTextureCoord");
            AppMethodBeat.m2505o(67245);
            throw runtimeException;
        }
        this.f1167w = GLES20.glGetUniformLocation(this.f1164t, "uMVPMatrix");
        m2184a("glGetUniformLocation uMVPMatrix");
        if (this.f1167w == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for uMVPMatrix");
            AppMethodBeat.m2505o(67245);
            throw runtimeException;
        }
        this.f1168x = GLES20.glGetUniformLocation(this.f1164t, "uSTMatrix");
        m2184a("glGetUniformLocation uSTMatrix");
        if (this.f1168x == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for uSTMatrix");
            AppMethodBeat.m2505o(67245);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(67245);
    }

    /* renamed from: d */
    private void m2186d() {
        AppMethodBeat.m2504i(67246);
        if (this.f1158n) {
            TXCLog.m15675d("TXTweenFilter", "reloadFrameBuffer. size = " + this.f1147c + "*" + this.f1148d);
            m2187e();
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glGenFramebuffers(1, iArr2, 0);
            this.f1165u = iArr[0];
            this.f1166v = iArr2[0];
            TXCLog.m15675d("TXTweenFilter", "frameBuffer id = " + this.f1166v + ", texture id = " + this.f1165u);
            GLES20.glBindTexture(3553, this.f1165u);
            m2184a("glBindTexture mFrameBufferTextureID");
            GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.f1147c, this.f1148d, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameteri(3553, 10242, 33071);
            GLES20.glTexParameteri(3553, 10243, 33071);
            m2184a("glTexParameter");
            GLES20.glBindFramebuffer(36160, this.f1166v);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f1165u, 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
            this.f1158n = false;
            AppMethodBeat.m2505o(67246);
            return;
        }
        AppMethodBeat.m2505o(67246);
    }

    /* renamed from: c */
    public void mo3904c() {
        AppMethodBeat.m2504i(67247);
        GLES20.glDeleteProgram(this.f1164t);
        m2187e();
        AppMethodBeat.m2505o(67247);
    }

    /* renamed from: e */
    private void m2187e() {
        AppMethodBeat.m2504i(67248);
        if (this.f1166v != -12345) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.f1166v}, 0);
            this.f1166v = -12345;
        }
        if (this.f1165u != -12345) {
            GLES20.glDeleteTextures(1, new int[]{this.f1165u}, 0);
            this.f1165u = -12345;
        }
        AppMethodBeat.m2505o(67248);
    }

    /* renamed from: a */
    private int m2182a(int i, String str) {
        int i2 = 0;
        AppMethodBeat.m2504i(67249);
        int glCreateShader = GLES20.glCreateShader(i);
        m2184a("glCreateShader type=".concat(String.valueOf(i)));
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            TXCLog.m15676e("TXTweenFilter", "Could not compile shader " + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            TXCLog.m15676e("TXTweenFilter", " " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
        } else {
            i2 = glCreateShader;
        }
        AppMethodBeat.m2505o(67249);
        return i2;
    }

    /* renamed from: a */
    private int m2183a(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(67250);
        int a = m2182a(35633, str);
        if (a == 0) {
            AppMethodBeat.m2505o(67250);
        } else {
            int a2 = m2182a(35632, str2);
            if (a2 == 0) {
                AppMethodBeat.m2505o(67250);
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                m2184a("glCreateProgram");
                if (glCreateProgram == 0) {
                    TXCLog.m15676e("TXTweenFilter", "Could not create program");
                }
                GLES20.glAttachShader(glCreateProgram, a);
                m2184a("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, a2);
                m2184a("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    TXCLog.m15676e("TXTweenFilter", "Could not link program: ");
                    TXCLog.m15676e("TXTweenFilter", GLES20.glGetProgramInfoLog(glCreateProgram));
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    i = glCreateProgram;
                }
                AppMethodBeat.m2505o(67250);
            }
        }
        return i;
    }

    /* renamed from: a */
    private void m2184a(String str) {
        AppMethodBeat.m2504i(67251);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            TXCLog.m15676e("TXTweenFilter", str + ": glError " + glGetError);
            RuntimeException runtimeException = new RuntimeException(str + ": glError " + glGetError);
            AppMethodBeat.m2505o(67251);
            throw runtimeException;
        }
        AppMethodBeat.m2505o(67251);
    }
}
