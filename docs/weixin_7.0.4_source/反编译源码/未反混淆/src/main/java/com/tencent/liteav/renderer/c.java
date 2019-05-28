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

public class c {
    private final float[] a = new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    private final float[] b = new float[]{1.0f, -1.0f, 0.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 0.0f};
    private FloatBuffer c;
    private float[] d = new float[16];
    private float[] e = new float[16];
    private int f;
    private int g = -12345;
    private int h;
    private int i;
    private int j;
    private int k;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private int o = -1;
    private int p = 0;
    private int q = 0;

    public c(boolean z) {
        AppMethodBeat.i(67222);
        this.m = z;
        if (this.m) {
            this.c = ByteBuffer.allocateDirect(this.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.c.put(this.a).position(0);
        } else {
            this.c = ByteBuffer.allocateDirect(this.b.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.c.put(this.b).position(0);
        }
        Matrix.setIdentityM(this.e, 0);
        AppMethodBeat.o(67222);
    }

    public int a() {
        return this.g;
    }

    public void a(SurfaceTexture surfaceTexture) {
        AppMethodBeat.i(67223);
        if (surfaceTexture == null) {
            AppMethodBeat.o(67223);
            return;
        }
        a("onDrawFrame start");
        surfaceTexture.getTransformMatrix(this.e);
        b(GlUtil.GL_TEXTURE_EXTERNAL_OES, this.g);
        AppMethodBeat.o(67223);
    }

    public void a(int i, int i2) {
        this.p = i;
        this.q = i2;
    }

    public void a(int i, boolean z, int i2) {
        AppMethodBeat.i(67224);
        if (!(this.n == z && this.o == i2)) {
            int i3;
            this.n = z;
            this.o = i2;
            float[] fArr = new float[20];
            for (i3 = 0; i3 < 20; i3++) {
                fArr[i3] = this.b[i3];
            }
            if (this.n) {
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
            this.c.clear();
            this.c.put(fArr).position(0);
        }
        b(3553, i);
        AppMethodBeat.o(67224);
    }

    private void b(int i, int i2) {
        AppMethodBeat.i(67225);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        GLES20.glClear(16640);
        if (this.l) {
            this.l = false;
            AppMethodBeat.o(67225);
            return;
        }
        GLES20.glUseProgram(this.f);
        a("glUseProgram");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(i, i2);
        this.c.position(0);
        GLES20.glVertexAttribPointer(this.j, 3, 5126, false, 20, this.c);
        a("glVertexAttribPointer maPosition");
        GLES20.glEnableVertexAttribArray(this.j);
        a("glEnableVertexAttribArray maPositionHandle");
        this.c.position(3);
        GLES20.glVertexAttribPointer(this.k, 2, 5126, false, 20, this.c);
        a("glVertexAttribPointer maTextureHandle");
        GLES20.glEnableVertexAttribArray(this.k);
        a("glEnableVertexAttribArray maTextureHandle");
        Matrix.setIdentityM(this.d, 0);
        GLES20.glUniformMatrix4fv(this.h, 1, false, this.d, 0);
        if (this.p % 8 != 0) {
            Matrix.scaleM(this.e, 0, (((float) (this.p - 1)) * 1.0f) / ((float) (((this.p + 7) / 8) * 8)), 1.0f, 1.0f);
        }
        if (this.q % 8 != 0) {
            Matrix.scaleM(this.e, 0, 1.0f, (((float) (this.q - 1)) * 1.0f) / ((float) (((this.q + 7) / 8) * 8)), 1.0f);
        }
        GLES20.glUniformMatrix4fv(this.i, 1, false, this.e, 0);
        GLES20.glDrawArrays(5, 0, 4);
        a("glDrawArrays");
        GLES20.glFinish();
        AppMethodBeat.o(67225);
    }

    public void b() {
        AppMethodBeat.i(67226);
        if (this.m) {
            this.f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "#extension GL_OES_EGL_image_external : require\nprecision mediump float;\nvarying vec2 vTextureCoord;\nuniform samplerExternalOES sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        } else {
            this.f = a("uniform mat4 uMVPMatrix;\nuniform mat4 uSTMatrix;\nattribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = (uSTMatrix * aTextureCoord).xy;\n}\n", "varying highp vec2 vTextureCoord;\n \nuniform sampler2D sTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(sTexture, vTextureCoord);\n}");
        }
        RuntimeException runtimeException;
        if (this.f == 0) {
            runtimeException = new RuntimeException("failed creating program");
            AppMethodBeat.o(67226);
            throw runtimeException;
        }
        this.j = GLES20.glGetAttribLocation(this.f, "aPosition");
        a("glGetAttribLocation aPosition");
        if (this.j == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for aPosition");
            AppMethodBeat.o(67226);
            throw runtimeException;
        }
        this.k = GLES20.glGetAttribLocation(this.f, "aTextureCoord");
        a("glGetAttribLocation aTextureCoord");
        if (this.k == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for aTextureCoord");
            AppMethodBeat.o(67226);
            throw runtimeException;
        }
        this.h = GLES20.glGetUniformLocation(this.f, "uMVPMatrix");
        a("glGetUniformLocation uMVPMatrix");
        if (this.h == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for uMVPMatrix");
            AppMethodBeat.o(67226);
            throw runtimeException;
        }
        this.i = GLES20.glGetUniformLocation(this.f, "uSTMatrix");
        a("glGetUniformLocation uSTMatrix");
        if (this.i == -1) {
            runtimeException = new RuntimeException("Could not get attrib location for uSTMatrix");
            AppMethodBeat.o(67226);
            throw runtimeException;
        }
        if (this.m) {
            d();
        }
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10241, 9729.0f);
        GLES20.glTexParameterf(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10240, 9729.0f);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10242, 33071);
        GLES20.glTexParameteri(GlUtil.GL_TEXTURE_EXTERNAL_OES, 10243, 33071);
        a("glTexParameter");
        AppMethodBeat.o(67226);
    }

    public void c() {
        AppMethodBeat.i(67227);
        if (this.f != 0) {
            GLES20.glDeleteProgram(this.f);
        }
        GLES20.glDeleteTextures(1, new int[]{this.g}, 0);
        this.g = -1;
        AppMethodBeat.o(67227);
    }

    private void d() {
        AppMethodBeat.i(67228);
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        this.g = iArr[0];
        GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, this.g);
        a("glBindTexture mTextureID");
        AppMethodBeat.o(67228);
    }

    private int a(int i, String str) {
        int i2 = 0;
        AppMethodBeat.i(67229);
        int glCreateShader = GLES20.glCreateShader(i);
        a("glCreateShader type=".concat(String.valueOf(i)));
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            TXCLog.e("TXCOesTextureRender", "Could not compile shader " + i + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
            TXCLog.e("TXCOesTextureRender", " " + GLES20.glGetShaderInfoLog(glCreateShader));
            GLES20.glDeleteShader(glCreateShader);
        } else {
            i2 = glCreateShader;
        }
        AppMethodBeat.o(67229);
        return i2;
    }

    private int a(String str, String str2) {
        int i = 0;
        AppMethodBeat.i(67230);
        int a = a(35633, str);
        if (a == 0) {
            AppMethodBeat.o(67230);
        } else {
            int a2 = a(35632, str2);
            if (a2 == 0) {
                AppMethodBeat.o(67230);
            } else {
                int glCreateProgram = GLES20.glCreateProgram();
                a("glCreateProgram");
                if (glCreateProgram == 0) {
                    TXCLog.e("TXCOesTextureRender", "Could not create program");
                }
                GLES20.glAttachShader(glCreateProgram, a);
                a("glAttachShader");
                GLES20.glAttachShader(glCreateProgram, a2);
                a("glAttachShader");
                GLES20.glLinkProgram(glCreateProgram);
                int[] iArr = new int[1];
                GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
                if (iArr[0] != 1) {
                    TXCLog.e("TXCOesTextureRender", "Could not link program: ");
                    TXCLog.e("TXCOesTextureRender", GLES20.glGetProgramInfoLog(glCreateProgram));
                    GLES20.glDeleteProgram(glCreateProgram);
                } else {
                    i = glCreateProgram;
                }
                AppMethodBeat.o(67230);
            }
        }
        return i;
    }

    public void a(String str) {
        AppMethodBeat.i(67231);
        int glGetError = GLES20.glGetError();
        if (glGetError != 0) {
            TXCLog.e("TXCOesTextureRender", str + ": glError " + glGetError);
            AppMethodBeat.o(67231);
            return;
        }
        AppMethodBeat.o(67231);
    }
}
