package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLType;
import com.tencent.liteav.basic.p141e.C8796g;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.f */
public class C32153f extends C8796g {
    /* renamed from: A */
    private int[] f14785A;
    /* renamed from: B */
    private float f14786B = 4.0f;
    /* renamed from: r */
    int f14787r;
    /* renamed from: s */
    int f14788s;
    /* renamed from: t */
    boolean f14789t;
    /* renamed from: u */
    private C16519d f14790u;
    /* renamed from: v */
    private C8796g f14791v;
    /* renamed from: w */
    private C8808c f14792w;
    /* renamed from: x */
    private C0958a f14793x;
    /* renamed from: y */
    private C0959b f14794y;
    /* renamed from: z */
    private int[] f14795z;

    /* renamed from: com.tencent.liteav.beauty.b.f$a */
    static class C0958a extends C25653r {
        public C0958a(String str) {
            super(str);
        }

        /* renamed from: b */
        public boolean mo3848b() {
            AppMethodBeat.m2504i(67002);
            if (super.mo3848b()) {
                AppMethodBeat.m2505o(67002);
                return true;
            }
            AppMethodBeat.m2505o(67002);
            return false;
        }
    }

    /* renamed from: com.tencent.liteav.beauty.b.f$b */
    static class C0959b extends C37361q {
        public C0959b(String str) {
            super(str);
        }

        /* renamed from: b */
        public boolean mo3848b() {
            AppMethodBeat.m2504i(67038);
            if (super.mo3848b()) {
                AppMethodBeat.m2505o(67038);
                return true;
            }
            AppMethodBeat.m2505o(67038);
            return false;
        }
    }

    /* renamed from: com.tencent.liteav.beauty.b.f$c */
    static class C8808c extends C25653r {
        /* renamed from: r */
        int f2672r;
        /* renamed from: s */
        int f2673s;
        /* renamed from: t */
        float f2674t = 1.5f;

        public C8808c() {
            super(null, null);
        }

        /* renamed from: a */
        public boolean mo19876a() {
            AppMethodBeat.m2504i(67046);
            NativeLoad.getInstance();
            this.f2616a = NativeLoad.nativeLoadGLProgram(2);
            if (this.f2616a == 0 || !mo3848b()) {
                this.f2622g = false;
            } else {
                this.f2622g = true;
            }
            mo19881c();
            boolean z = this.f2622g;
            AppMethodBeat.m2505o(67046);
            return z;
        }

        /* renamed from: b */
        public boolean mo3848b() {
            AppMethodBeat.m2504i(67047);
            if (super.mo3848b()) {
                this.f2672r = GLES20.glGetUniformLocation(this.f2616a, "texelWidthOffset");
                this.f2673s = GLES20.glGetUniformLocation(this.f2616a, "texelHeightOffset");
                AppMethodBeat.m2505o(67047);
                return true;
            }
            AppMethodBeat.m2505o(67047);
            return false;
        }

        /* Access modifiers changed, original: 0000 */
        /* renamed from: a */
        public void mo19906a(float f) {
            AppMethodBeat.m2504i(67048);
            this.f2674t = f;
            mo19866a(this.f2672r, this.f2674t / ((float) this.f2620e));
            mo19866a(this.f2673s, this.f2674t / ((float) this.f2621f));
            AppMethodBeat.m2505o(67048);
        }

        /* renamed from: a */
        public void mo3839a(int i, int i2) {
            AppMethodBeat.m2504i(67049);
            super.mo3839a(i, i2);
            mo19906a(this.f2674t);
            AppMethodBeat.m2505o(67049);
        }
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(67039);
        boolean b = super.mo3848b();
        if (b) {
            this.f14790u = new C16519d();
            if (b) {
                b = this.f14790u.mo19876a();
            }
            this.f14792w = new C8808c();
            if (b) {
                b = this.f14792w.mo19876a();
            }
            this.f14793x = new C0958a("precision highp float;  \nuniform sampler2D inputImageTexture;  \nuniform sampler2D inputImageTexture2;  \nvarying vec2 textureCoordinate;  \nvarying vec2 textureCoordinate2;  \nvoid main()  \n{  \n\tgl_FragColor = texture2D(inputImageTexture2, textureCoordinate2) - texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture2, textureCoordinate2);  \n}  \n");
            if (b) {
                b = this.f14793x.mo19876a();
            }
            this.f14794y = new C0959b("precision highp float;   \nuniform sampler2D inputImageTexture;   \nuniform sampler2D inputImageTexture2;  \nuniform sampler2D inputImageTexture3;   \nvarying vec2 textureCoordinate;   \nvarying vec2 textureCoordinate2;  \nvarying vec2 textureCoordinate3;    \nvoid main()   \n{   \n\tgl_FragColor = texture2D(inputImageTexture, textureCoordinate) * texture2D(inputImageTexture3, textureCoordinate3) + texture2D(inputImageTexture2, textureCoordinate2);   \n}   \n");
            if (b) {
                b = this.f14794y.mo19876a();
            }
            this.f14791v = new C8796g();
            this.f14791v.mo19873a(true);
            if (b) {
                b = this.f14791v.mo19876a();
            }
            if (b) {
                AppMethodBeat.m2505o(67039);
                return true;
            }
        }
        mo19883d();
        AppMethodBeat.m2505o(67039);
        return false;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(67040);
        if (this.f2621f == i2 && this.f2620e == i) {
            AppMethodBeat.m2505o(67040);
            return;
        }
        super.mo3839a(i, i2);
        if (!this.f14789t) {
            if (i < i2) {
                if (i < 540) {
                    this.f14786B = 1.0f;
                } else {
                    this.f14786B = 4.0f;
                }
            } else if (i2 < 540) {
                this.f14786B = 1.0f;
            } else {
                this.f14786B = 4.0f;
            }
        }
        this.f14787r = (int) (((float) i) / this.f14786B);
        this.f14788s = (int) (((float) i2) / this.f14786B);
        this.f14791v.mo3839a(this.f14787r, this.f14788s);
        this.f14792w.mo3839a(this.f14787r, this.f14788s);
        this.f14793x.mo3839a(this.f14787r, this.f14788s);
        this.f14794y.mo3839a(i, i2);
        this.f14790u.mo3839a(this.f14787r, this.f14788s);
        if (this.f14795z != null) {
            GLES20.glDeleteFramebuffers(this.f14795z.length, this.f14795z, 0);
            GLES20.glDeleteTextures(this.f14795z.length, this.f14785A, 0);
            this.f14795z = null;
            this.f14785A = null;
        }
        this.f14795z = new int[8];
        this.f14785A = new int[this.f14795z.length];
        GLES20.glGenFramebuffers(this.f14795z.length, this.f14795z, 0);
        GLES20.glGenTextures(this.f14795z.length, this.f14785A, 0);
        for (int i3 = 0; i3 < this.f14795z.length; i3++) {
            GLES20.glBindTexture(3553, this.f14785A[i3]);
            if (i3 >= 5) {
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, i, i2, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
            } else {
                GLES20.glTexImage2D(3553, 0, GLFormat.GL_RGBA, this.f14787r, this.f14788s, 0, GLFormat.GL_RGBA, GLType.GL_UNSIGNED_BYTE, null);
            }
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glBindFramebuffer(36160, this.f14795z[i3]);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f14785A[i3], 0);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        AppMethodBeat.m2505o(67040);
    }

    /* renamed from: b */
    public int mo3840b(int i) {
        int b;
        AppMethodBeat.m2504i(67041);
        if (this.f14786B != 1.0f) {
            GLES20.glViewport(0, 0, this.f14787r, this.f14788s);
            b = this.f14791v.mo3840b(i);
        } else {
            b = i;
        }
        int a = this.f14790u.mo19865a(b, this.f14795z[4], this.f14785A[4]);
        b = this.f14792w.mo43382a(b, a, this.f14795z[0], this.f14785A[0]);
        int a2 = this.f14793x.mo43382a(b, a, this.f14795z[1], this.f14785A[1]);
        a = this.f14790u.mo19865a(b, this.f14795z[2], this.f14785A[2]);
        a2 = this.f14790u.mo19865a(a2, this.f14795z[3], this.f14785A[3]);
        if (this.f14786B != 1.0f) {
            GLES20.glViewport(0, 0, this.f2620e, this.f2621f);
            a = this.f14791v.mo19865a(a, this.f14795z[5], this.f14785A[5]);
            a2 = this.f14791v.mo19865a(a2, this.f14795z[6], this.f14785A[6]);
        }
        b = this.f14794y.mo60127a(a, a2, i, this.f14795z[7], this.f14785A[7]);
        AppMethodBeat.m2505o(67041);
        return b;
    }

    /* renamed from: e */
    public void mo3844e() {
        AppMethodBeat.m2504i(67042);
        if (this.f2622g) {
            super.mo3844e();
            this.f14790u.mo19883d();
            this.f14792w.mo19883d();
            this.f14793x.mo19883d();
            this.f14794y.mo19883d();
            this.f14791v.mo19883d();
            if (this.f14795z != null) {
                GLES20.glDeleteFramebuffers(this.f14795z.length, this.f14795z, 0);
                GLES20.glDeleteTextures(this.f14795z.length, this.f14785A, 0);
                this.f14795z = null;
            }
            this.f14785A = null;
        }
        AppMethodBeat.m2505o(67042);
    }
}
