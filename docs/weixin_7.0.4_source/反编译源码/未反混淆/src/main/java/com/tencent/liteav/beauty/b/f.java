package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.e.g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class f extends g {
    private int[] A;
    private float B = 4.0f;
    int r;
    int s;
    boolean t;
    private d u;
    private g v;
    private c w;
    private a x;
    private b y;
    private int[] z;

    static class a extends r {
        public a(String str) {
            super(str);
        }

        public boolean b() {
            AppMethodBeat.i(67002);
            if (super.b()) {
                AppMethodBeat.o(67002);
                return true;
            }
            AppMethodBeat.o(67002);
            return false;
        }
    }

    static class b extends q {
        public b(String str) {
            super(str);
        }

        public boolean b() {
            AppMethodBeat.i(67038);
            if (super.b()) {
                AppMethodBeat.o(67038);
                return true;
            }
            AppMethodBeat.o(67038);
            return false;
        }
    }

    static class c extends r {
        int r;
        int s;
        float t = 1.5f;

        public c() {
            super(null, null);
        }

        public boolean a() {
            AppMethodBeat.i(67046);
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(2);
            if (this.a == 0 || !b()) {
                this.g = false;
            } else {
                this.g = true;
            }
            c();
            boolean z = this.g;
            AppMethodBeat.o(67046);
            return z;
        }

        public boolean b() {
            AppMethodBeat.i(67047);
            if (super.b()) {
                this.r = GLES20.glGetUniformLocation(this.a, "texelWidthOffset");
                this.s = GLES20.glGetUniformLocation(this.a, "texelHeightOffset");
                AppMethodBeat.o(67047);
                return true;
            }
            AppMethodBeat.o(67047);
            return false;
        }

        /* Access modifiers changed, original: 0000 */
        public void a(float f) {
            AppMethodBeat.i(67048);
            this.t = f;
            a(this.r, this.t / ((float) this.e));
            a(this.s, this.t / ((float) this.f));
            AppMethodBeat.o(67048);
        }

        public void a(int i, int i2) {
            AppMethodBeat.i(67049);
            super.a(i, i2);
            a(this.t);
            AppMethodBeat.o(67049);
        }
    }

    public boolean b() {
        AppMethodBeat.i(67039);
        boolean b = super.b();
        if (b) {
            this.u = new d();
            if (b) {
                b = this.u.a();
            }
            this.w = new c();
            if (b) {
                b = this.w.a();
            }
            this.x = new a("precision highp float;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvarying vec2 textureCoordinate;  \nvarying vec2 textureCoordinate2;  \nvoid main()  \n{  \n\tgl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);  \n}  \n");
            if (b) {
                b = this.x.a();
            }
            this.y = new b("precision highp float;   \nuniform sampler2D inputImageTexture;   \nuniform sampler2D inputImageTexture2;  \nuniform sampler2D inputImageTexture3;   \nvarying vec2 textureCoordinate;   \nvarying vec2 textureCoordinate2;  \nvarying vec2 textureCoordinate3;    \nvoid main()   \n{   \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);   \n}   \n");
            if (b) {
                b = this.y.a();
            }
            this.v = new g();
            this.v.a(true);
            if (b) {
                b = this.v.a();
            }
            if (b) {
                AppMethodBeat.o(67039);
                return true;
            }
        }
        d();
        AppMethodBeat.o(67039);
        return false;
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(67040);
        if (this.f == i2 && this.e == i) {
            AppMethodBeat.o(67040);
            return;
        }
        super.a(i, i2);
        if (!this.t) {
            if (i < i2) {
                if (i < 540) {
                    this.B = 1.0f;
                } else {
                    this.B = 4.0f;
                }
            } else if (i2 < 540) {
                this.B = 1.0f;
            } else {
                this.B = 4.0f;
            }
        }
        this.r = (int) (((float) i) / this.B);
        this.s = (int) (((float) i2) / this.B);
        this.v.a(this.r, this.s);
        this.w.a(this.r, this.s);
        this.x.a(this.r, this.s);
        this.y.a(i, i2);
        this.u.a(this.r, this.s);
        if (this.z != null) {
            GLES20.glDeleteFramebuffers(this.z.length, this.z, 0);
            GLES20.glDeleteTextures(this.z.length, this.A, 0);
            this.z = null;
            this.A = null;
        }
        this.z = new int[8];
        this.A = new int[this.z.length];
        GLES20.glGenFramebuffers(this.z.length, this.z, 0);
        GLES20.glGenTextures(this.z.length, this.A, 0);
        for (int i3 = 0; i3 < this.z.length; i3++) {
            GLES20.glBindTexture(3553, this.A[i3]);
            if (i3 >= 5) {
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i, i2, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
            } else {
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.r, this.s, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
            }
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.z[i3]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.A[i3], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        AppMethodBeat.o(67040);
    }

    public int b(int i) {
        int b;
        AppMethodBeat.i(67041);
        if (this.B != 1.0f) {
            GLES20.glViewport(0, 0, this.r, this.s);
            b = this.v.b(i);
        } else {
            b = i;
        }
        int a = this.u.a(b, this.z[4], this.A[4]);
        b = this.w.a(b, a, this.z[0], this.A[0]);
        int a2 = this.x.a(b, a, this.z[1], this.A[1]);
        a = this.u.a(b, this.z[2], this.A[2]);
        a2 = this.u.a(a2, this.z[3], this.A[3]);
        if (this.B != 1.0f) {
            GLES20.glViewport(0, 0, this.e, this.f);
            a = this.v.a(a, this.z[5], this.A[5]);
            a2 = this.v.a(a2, this.z[6], this.A[6]);
        }
        b = this.y.a(a, a2, i, this.z[7], this.A[7]);
        AppMethodBeat.o(67041);
        return b;
    }

    public void e() {
        AppMethodBeat.i(67042);
        if (this.g) {
            super.e();
            this.u.d();
            this.w.d();
            this.x.d();
            this.y.d();
            this.v.d();
            if (this.z != null) {
                GLES20.glDeleteFramebuffers(this.z.length, this.z, 0);
                GLES20.glDeleteTextures(this.z.length, this.A, 0);
                this.z = null;
            }
            this.A = null;
        }
        AppMethodBeat.o(67042);
    }
}
