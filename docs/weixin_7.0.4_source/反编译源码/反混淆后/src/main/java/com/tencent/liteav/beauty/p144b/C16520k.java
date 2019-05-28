package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.p141e.C32144i;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;

/* renamed from: com.tencent.liteav.beauty.b.k */
public class C16520k extends C8796g {
    /* renamed from: z */
    private static String f3521z = "YUV420pToRGBFilter";
    /* renamed from: r */
    private ByteBuffer f3522r = null;
    /* renamed from: s */
    private byte[] f3523s = null;
    /* renamed from: t */
    private int f3524t = 1;
    /* renamed from: u */
    private int[] f3525u = null;
    /* renamed from: v */
    private int[] f3526v = null;
    /* renamed from: w */
    private int f3527w = 0;
    /* renamed from: x */
    private int f3528x = 0;
    /* renamed from: y */
    private int[] f3529y = null;

    public C16520k(int i) {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        AppMethodBeat.m2504i(66986);
        this.f3524t = i;
        TXCLog.m15677i(f3521z, "yuv Type ".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(66986);
    }

    /* renamed from: a */
    public boolean mo19876a() {
        boolean a;
        int i = 7;
        AppMethodBeat.m2504i(66987);
        if (this.f3524t != 1) {
            if (this.f3524t == 3) {
                i = 9;
            } else if (this.f3524t == 2) {
                a = super.mo19876a();
                AppMethodBeat.m2505o(66987);
                return a;
            } else {
                TXCLog.m15676e(f3521z, "don't support yuv format " + this.f3524t);
            }
        }
        NativeLoad.getInstance();
        this.f2616a = NativeLoad.nativeLoadGLProgram(i);
        if (this.f2616a == 0 || !mo3848b()) {
            this.f2622g = false;
        } else {
            this.f2622g = true;
        }
        mo19881c();
        a = this.f2622g;
        AppMethodBeat.m2505o(66987);
        return a;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66988);
        if (this.f2621f == i2 && this.f2620e == i) {
            AppMethodBeat.m2505o(66988);
            return;
        }
        if (1 == this.f3524t) {
            this.f3525u = new int[1];
            this.f3525u[0] = C32144i.m52312a(i, (i2 * 3) / 2, 6409, 6409, this.f3525u);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.f3525u[0]);
            GLES20.glBindTexture(3553, 0);
            GLES20.glUniform1i(this.f2618c, 0);
        } else if (3 == this.f3524t) {
            GLES20.glActiveTexture(33984);
            GLES20.glActiveTexture(33985);
            this.f3527w = GLES20.glGetUniformLocation(mo19894p(), "yTexture");
            this.f3528x = GLES20.glGetUniformLocation(mo19894p(), "uvTexture");
            if (this.f3525u == null) {
                this.f3525u = new int[1];
                this.f3525u[0] = C32144i.m52312a(i, i2, 6409, 6409, this.f3525u);
            }
            if (this.f3526v == null) {
                this.f3526v = new int[1];
                this.f3526v[0] = C32144i.m52312a(i / 2, i2 / 2, 6410, 6410, this.f3526v);
            }
            GLES20.glUniform1i(this.f3527w, 0);
            GLES20.glUniform1i(this.f3528x, 1);
        } else if (2 == this.f3524t && this.f3529y == null) {
            this.f3529y = new int[1];
            this.f3529y[0] = C32144i.m52312a(i, i2, (int) GLFormat.GL_RGBA, (int) GLFormat.GL_RGBA, this.f3529y);
        }
        super.mo3839a(i, i2);
        AppMethodBeat.m2505o(66988);
    }

    /* renamed from: a */
    public void mo30453a(byte[] bArr) {
        this.f3523s = bArr;
    }

    /* renamed from: i */
    public void mo19887i() {
        AppMethodBeat.m2504i(66989);
        super.mo19887i();
        if (1 == this.f3524t) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.f3525u[0]);
            GLES20.glUniform1i(this.f2618c, 0);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.f2620e, (this.f2621f * 3) / 2, 0, 6409, GLType.GL_UNSIGNED_BYTE, this.f3523s, 0);
            AppMethodBeat.m2505o(66989);
        } else if (3 == this.f3524t) {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, this.f3525u[0]);
            GLES20.glUniform1i(this.f3527w, 0);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6409, this.f2620e, this.f2621f, 0, 6409, GLType.GL_UNSIGNED_BYTE, this.f3523s, 0);
            GLES20.glActiveTexture(33985);
            GLES20.glBindTexture(3553, this.f3526v[0]);
            GLES20.glUniform1i(this.f3528x, 1);
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, 6410, this.f2620e / 2, this.f2621f / 2, 0, 6410, GLType.GL_UNSIGNED_BYTE, this.f3523s, this.f2621f * this.f2620e);
            AppMethodBeat.m2505o(66989);
        } else {
            if (2 == this.f3524t) {
                m25365r();
            }
            AppMethodBeat.m2505o(66989);
        }
    }

    /* renamed from: q */
    public int mo30454q() {
        AppMethodBeat.m2504i(66990);
        int r;
        if (2 == this.f3524t) {
            r = m25365r();
            GLES20.glBindTexture(3553, 0);
            AppMethodBeat.m2505o(66990);
            return r;
        }
        r = super.mo3840b(-1);
        AppMethodBeat.m2505o(66990);
        return r;
    }

    /* renamed from: r */
    private int m25365r() {
        AppMethodBeat.m2504i(66991);
        GLES20.glBindTexture(3553, this.f3529y[0]);
        if (this.f3523s != null) {
            NativeLoad.getInstance();
            NativeLoad.nativeglTexImage2D(3553, 0, GLFormat.GL_RGBA, this.f2620e, this.f2621f, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, this.f3523s, 0);
        }
        int i = this.f3529y[0];
        AppMethodBeat.m2505o(66991);
        return i;
    }

    /* renamed from: a */
    public void mo19869a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.m2504i(66992);
        super.mo19869a(-1, floatBuffer, floatBuffer2);
        AppMethodBeat.m2505o(66992);
    }

    /* renamed from: e */
    public void mo3844e() {
        AppMethodBeat.m2504i(66993);
        super.mo3844e();
        if (this.f3525u != null && this.f3525u[0] > 0) {
            GLES20.glDeleteTextures(1, this.f3525u, 0);
            this.f3525u = null;
        }
        if (this.f3526v != null && this.f3526v[0] > 0) {
            GLES20.glDeleteTextures(1, this.f3526v, 0);
            this.f3526v = null;
        }
        if (this.f3529y != null && this.f3529y[0] > 0) {
            GLES20.glDeleteTextures(1, this.f3529y, 0);
            this.f3529y = null;
        }
        AppMethodBeat.m2505o(66993);
    }
}
