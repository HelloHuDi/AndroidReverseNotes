package com.tencent.liteav.renderer;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.Matrix;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.liteav.renderer.c */
public class C45114c {
    /* renamed from: a */
    private final float[] f17809a = new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    /* renamed from: b */
    private final float[] f17810b = new float[]{1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
    /* renamed from: c */
    private FloatBuffer f17811c;
    /* renamed from: d */
    private float[] f17812d = new float[16];
    /* renamed from: e */
    private float[] f17813e = new float[16];
    /* renamed from: f */
    private int f17814f;
    /* renamed from: g */
    private int f17815g = -12345;
    /* renamed from: h */
    private int f17816h;
    /* renamed from: i */
    private int f17817i;
    /* renamed from: j */
    private int f17818j;
    /* renamed from: k */
    private int f17819k;
    /* renamed from: l */
    private boolean f17820l = false;
    /* renamed from: m */
    private boolean f17821m = true;
    /* renamed from: n */
    private boolean f17822n = false;
    /* renamed from: o */
    private int f17823o = -1;
    /* renamed from: p */
    private int f17824p = 0;
    /* renamed from: q */
    private int f17825q = 0;

    public C45114c(boolean z) {
        AppMethodBeat.m2504i(67222);
        this.f17821m = z;
        if (this.f17821m) {
            this.f17811c = ByteBuffer.allocateDirect(this.f17809a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f17811c.put(this.f17809a).position(0);
        } else {
            this.f17811c = ByteBuffer.allocateDirect(this.f17810b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.f17811c.put(this.f17810b).position(0);
        }
        Matrix.setIdentityM(this.f17813e, 0);
        AppMethodBeat.m2505o(67222);
    }

    /* renamed from: a */
    public int mo72898a() {
        return this.f17815g;
    }

    /* renamed from: a */
    public void mo72901a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.m2504i(67223);
        if (surfaceTexture == null) {
            AppMethodBeat.m2505o(67223);
            return;
        }
        mo72902a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.f17813e);
        m82866b(GlUtil.GL_TEXTURE_EXTERNAL_OES, this.f17815g);
        AppMethodBeat.m2505o(67223);
    }

    /* renamed from: a */
    public void mo72899a(int i, int i2) {
        this.f17824p = i;
        this.f17825q = i2;
    }

    /* renamed from: a */
    public void mo72900a(int i, boolean z, int i2) {
        AppMethodBeat.m2504i(67224);
        if (!(this.f17822n == z && this.f17823o == i2)) {
            int i3;
            this.f17822n = z;
            this.f17823o = i2;
            float[] fArr = new float[20];
            for (i3 = 0; i3 < 20; i3++) {
                fArr[i3] = this.f17810b[i3];
            }
            if (this.f17822n) {
                fArr[0] = -fArr[0];
                fArr[5] = -fArr[5];
                fArr[10] = -fArr[10];
                fArr[15] = -fArr[15];
            }
            int i4 = i2 / 90;
            for (i3 = 0; i3 < i4; i3++) {
                float f = fArr[3];
                float f2 = fArr[4];
                fArr[3] = fArr[8];
                fArr[4] = fArr[9];
                fArr[8] = fArr[18];
                fArr[9] = fArr[19];
                fArr[18] = fArr[13];
                fArr[19] = fArr[14];
                fArr[13] = f;
                fArr[14] = f2;
            }
            this.f17811c.clear();
            this.f17811c.put(fArr).position(0);
        }
        m82866b(3553, i);
        AppMethodBeat.m2505o(67224);
    }

    /* renamed from: b */
    private void m82866b(int i, int i2) {
        AppMethodBeat.m2504i(67225);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        if (this.f17820l) {
            this.f17820l = false;
            AppMethodBeat.m2505o(67225);
            return;
        }
        GLES20.glUseProgram(this.f17814f);
        mo72902a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(i, i2);
        this.f17811c.position(0);
        GLES20.glVertexAttribPointer(this.f17818j, 3, 5126, false, 20, this.f17811c);
        mo72902a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.f17818j);
        mo72902a("glEnableVertexAttribArray maPositionHandle");
        this.f17811c.position(3);
        GLES20.glVertexAttribPointer(this.f17819k, 2, 5126, false, 20, this.f17811c);
        mo72902a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.f17819k);
        mo72902a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.f17812d, 0);
        GLES20.glUniformMatrix4fv(this.f17816h, 1, false, this.f17812d, 0);
        if (this.f17824p % 8 != 0) {
            Matrix.scaleM(this.f17813e, 0, (((float) (this.f17824p - 1)) * 1.0f) / ((float) (((this.f17824p + 7) / 8) * 8)), 1.0f, 1.0f);
        }
        if (this.f17825q % 8 != 0) {
            Matrix.scaleM(this.f17813e, 0, 1.0f, (((float) (this.f17825q - 1)) * 1.0f) / ((float) (((this.f17825q + 7) / 8) * 8)), 1.0f);
        }
        GLES20.glUniformMatrix4fv(this.f17817i, 1, false, this.f17813e, 0);
        GLES20.glDrawArrays(5, 0, 4);
        mo72902a("glDrawArrays");
        GLES20.glFinish();
        AppMethodBeat.m2505o(67225);
    }

    /* renamed from: b */
    public void mo72903b() {
        AppMethodBeat.m2504i(67226);
        if (this.f17821m) {
            this.f17814f = m82865a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            this.f17814f = m82865a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
        }
        RuntimeException runtimeException;
        if (this.f17814f == 0) {
            runtimeException = new RuntimeException("failed creating program");
            AppMethodBeat.m2505o(67226);
            throw runtimeException;
        }
        this.f17818j = GLES20.glGetAttribLocation(this.f17814f, "aPosition");
        mo72902a("glGetAttribLocation aPosition");
        if (this.f17818j == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for aPosition");
            AppMethodBeat.m2505o(67226);
            throw runtimeException;
        }
        this.f17819k = GLES20.glGetAttribLocation(this.f17814f, "aTextureCoord");
        mo72902a("glGetAttribLocation aTextureCoord");
        if (this.f17819k == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for aTextureCoord");
            AppMethodBeat.m2505o(67226);
            throw runtimeException;
        }
        this.f17816h = GLES20.glGetUniformLocation(this.f17814f, "uMVPMatrix");
        mo72902a("glGetUniformLocation uMVPMatrix");
        if (this.f17816h == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for uMVPMatrix");
            AppMethodBeat.m2505o(67226);
            throw runtimeException;
        }
        this.f17817i = GLES20.glGetUniformLocation(this.f17814f, "uSTMatrix");
        mo72902a("glGetUniformLocation uSTMatrix");
        if (this.f17817i == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for uSTMatrix");
            AppMethodBeat.m2505o(67226);
            throw runtimeException;
        }
        if (this.f17821m) {
            m82867d();
        }
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        mo72902a("glTexParameter");
        AppMethodBeat.m2505o(67226);
    }

    /* renamed from: c */
    public void mo72904c() {
        AppMethodBeat.m2504i(67227);
        if (this.f17814f != 0) {
            GLES20.glDeleteProgram(this.f17814f);
        }
        GLES20.glDeleteTextures(1, new int[]{this.f17815g}, 0);
        this.f17815g = -1;
        AppMethodBeat.m2505o(67227);
    }

    /* renamed from: d */
    private void m82867d() {
        AppMethodBeat.m2504i(67228);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.f17815g = iArr[0];
        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, this.f17815g);
        mo72902a("glBindTexture mTextureID");
        AppMethodBeat.m2505o(67228);
    }

    /* renamed from: a */
    private int m82864a(int i, String str) {
        int i2 = 0;
        AppMethodBeat.m2504i(67229);
        int glCreateShader = GLES20.glCreateShader(i);
        mo72902a("glCreateShader type=".concat(String.valueOf(i)));
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            TXCLog.m15676e("TXCOesTextureRender", "Could not compile shader " + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            TXCLog.m15676e("TXCOesTextureRender", " " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
        } else {
            i2 = glCreateShader;
        }
        AppMethodBeat.m2505o(67229);
        return i2;
    }

    /* renamed from: a */
    private int m82865a(String str, String str2) {
        int i = 0;
        AppMethodBeat.m2504i(67230);
        int a = m82864a(35633, str);
        if (a == 0) {
            AppMethodBeat.m2505o(67230);
        } else {
            int a2 = m82864a(35632, str2);
            if (a2 == 0) {
                AppMethodBeat.m2505o(67230);
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                mo72902a("glCreateProgram");
                if (glCreateProgram == 0) {
                    TXCLog.m15676e("TXCOesTextureRender", "Could not create program");
                }
                GLES20.glAttachShader(glCreateProgram, a);
                mo72902a("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, a2);
                mo72902a("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    TXCLog.m15676e("TXCOesTextureRender", "Could not link program: ");
                    TXCLog.m15676e("TXCOesTextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    i = glCreateProgram;
                }
                AppMethodBeat.m2505o(67230);
            }
        }
        return i;
    }

    /* renamed from: a */
    public void mo72902a(String str) {
        AppMethodBeat.m2504i(67231);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            TXCLog.m15676e("TXCOesTextureRender", str + ": glError " + glGetError);
            AppMethodBeat.m2505o(67231);
            return;
        }
        AppMethodBeat.m2505o(67231);
    }
}
