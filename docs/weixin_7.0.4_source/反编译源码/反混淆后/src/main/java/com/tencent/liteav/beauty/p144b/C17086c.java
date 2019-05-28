package com.tencent.liteav.beauty.p144b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.b.c */
public class C17086c extends C16518b {
    /* renamed from: r */
    private static final String f3590r = C17086c.class.getSimpleName();
    /* renamed from: A */
    private float f3591A = 0.0f;
    /* renamed from: s */
    private C32153f f3592s;
    /* renamed from: t */
    private C17087a f3593t;
    /* renamed from: u */
    private C45107p f3594u = null;
    /* renamed from: v */
    private int f3595v = -1;
    /* renamed from: w */
    private int f3596w = -1;
    /* renamed from: x */
    private float f3597x = 0.0f;
    /* renamed from: y */
    private float f3598y = 0.0f;
    /* renamed from: z */
    private float f3599z = 0.0f;

    /* renamed from: com.tencent.liteav.beauty.b.c$a */
    public static class C17087a extends C37361q {
        /* renamed from: x */
        private int f3600x = -1;
        /* renamed from: y */
        private int f3601y = -1;
        /* renamed from: z */
        private int f3602z = -1;

        public C17087a() {
            super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        }

        /* renamed from: a */
        public boolean mo19876a() {
            AppMethodBeat.m2504i(66933);
            NativeLoad.getInstance();
            this.f2616a = NativeLoad.nativeLoadGLProgram(1);
            if (this.f2616a == 0 || !mo3848b()) {
                this.f2622g = false;
            } else {
                this.f2622g = true;
            }
            mo19881c();
            boolean z = this.f2622g;
            AppMethodBeat.m2505o(66933);
            return z;
        }

        /* renamed from: a */
        public void mo3839a(int i, int i2) {
            AppMethodBeat.m2504i(66934);
            if (this.f2621f == i2 && this.f2620e == i) {
                AppMethodBeat.m2505o(66934);
                return;
            }
            super.mo3839a(i, i2);
            this.f3600x = GLES20.glGetUniformLocation(mo19894p(), "smoothDegree");
            this.f3601y = GLES20.glGetUniformLocation(mo19894p(), "brightDegree");
            this.f3602z = GLES20.glGetUniformLocation(mo19894p(), "ruddyDegree");
            AppMethodBeat.m2505o(66934);
        }

        /* renamed from: b */
        public boolean mo3848b() {
            AppMethodBeat.m2504i(66935);
            boolean b = super.mo3848b();
            AppMethodBeat.m2505o(66935);
            return b;
        }

        /* renamed from: a */
        public void mo31158a(float f) {
            AppMethodBeat.m2504i(66936);
            mo19866a(this.f3600x, C17086c.m26441a(f));
            AppMethodBeat.m2505o(66936);
        }

        /* renamed from: b */
        public void mo31159b(float f) {
            AppMethodBeat.m2504i(66937);
            mo19866a(this.f3601y, f / 3.0f);
            AppMethodBeat.m2505o(66937);
        }

        /* renamed from: c */
        public void mo31160c(float f) {
            AppMethodBeat.m2504i(66938);
            mo19866a(this.f3602z, (f / 10.0f) / 2.0f);
            AppMethodBeat.m2505o(66938);
        }
    }

    /* renamed from: a */
    static /* synthetic */ float m26441a(float f) {
        AppMethodBeat.m2504i(66931);
        float b = C17086c.m26443b(f);
        AppMethodBeat.m2505o(66931);
        return b;
    }

    static {
        AppMethodBeat.m2504i(66932);
        AppMethodBeat.m2505o(66932);
    }

    /* renamed from: b */
    public int mo3840b(int i) {
        AppMethodBeat.m2504i(66922);
        if (this.f3597x > 0.0f || this.f3598y > 0.0f || this.f3599z > 0.0f) {
            int b;
            if (this.f3597x != 0.0f) {
                b = this.f3592s.mo3840b(i);
            } else {
                b = i;
            }
            i = this.f3593t.mo19865a(b, i, i);
        }
        if (this.f3591A > 0.0f) {
            i = this.f3594u.mo3840b(i);
        }
        AppMethodBeat.m2505o(66922);
        return i;
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66923);
        if (this.f3595v == i && this.f3596w == i2) {
            AppMethodBeat.m2505o(66923);
            return;
        }
        new StringBuilder("onOutputSizeChanged mFrameWidth = ").append(i).append("  mFrameHeight = ").append(i2);
        this.f3595v = i;
        this.f3596w = i2;
        mo3841b(this.f3595v, this.f3596w);
        AppMethodBeat.m2505o(66923);
    }

    /* renamed from: b */
    public boolean mo3841b(int i, int i2) {
        AppMethodBeat.m2504i(66924);
        this.f3595v = i;
        this.f3596w = i2;
        new StringBuilder("init mFrameWidth = ").append(i).append("  mFrameHeight = ").append(i2);
        if (this.f3592s == null) {
            this.f3592s = new C32153f();
            this.f3592s.mo19873a(true);
            if (!this.f3592s.mo19876a()) {
                AppMethodBeat.m2505o(66924);
                return false;
            }
        }
        this.f3592s.mo3839a(this.f3595v, this.f3596w);
        if (this.f3593t == null) {
            this.f3593t = new C17087a();
            this.f3593t.mo19873a(true);
            if (!this.f3593t.mo19876a()) {
                AppMethodBeat.m2505o(66924);
                return false;
            }
        }
        this.f3593t.mo3839a(this.f3595v, this.f3596w);
        if (this.f3594u == null) {
            this.f3594u = new C45107p();
            this.f3594u.mo19873a(true);
            if (!this.f3594u.mo19876a()) {
                AppMethodBeat.m2505o(66924);
                return false;
            }
        }
        this.f3594u.mo3839a(this.f3595v, this.f3596w);
        AppMethodBeat.m2505o(66924);
        return true;
    }

    /* renamed from: e */
    public void mo3844e() {
        AppMethodBeat.m2504i(66925);
        if (this.f3593t != null) {
            this.f3593t.mo19883d();
            this.f3593t = null;
        }
        if (this.f3592s != null) {
            this.f3592s.mo19883d();
            this.f3592s = null;
        }
        if (this.f3594u != null) {
            this.f3594u.mo19883d();
            this.f3594u = null;
        }
        AppMethodBeat.m2505o(66925);
    }

    /* renamed from: c */
    public void mo3842c(int i) {
        AppMethodBeat.m2504i(66926);
        this.f3597x = (float) i;
        if (this.f3593t != null) {
            this.f3593t.mo31158a((float) i);
        }
        AppMethodBeat.m2505o(66926);
    }

    /* renamed from: d */
    public void mo3843d(int i) {
        AppMethodBeat.m2504i(66927);
        this.f3598y = (float) i;
        if (this.f3593t != null) {
            this.f3593t.mo31159b((float) i);
        }
        AppMethodBeat.m2505o(66927);
    }

    /* renamed from: e */
    public void mo3845e(int i) {
        AppMethodBeat.m2504i(66928);
        this.f3599z = (float) i;
        if (this.f3593t != null) {
            this.f3593t.mo31160c((float) i);
        }
        AppMethodBeat.m2505o(66928);
    }

    /* renamed from: f */
    public void mo3846f(int i) {
        AppMethodBeat.m2504i(66929);
        this.f3591A = ((float) i) / 15.0f;
        if (this.f3594u != null) {
            this.f3594u.mo72889a(this.f3591A);
        }
        AppMethodBeat.m2505o(66929);
    }

    /* renamed from: b */
    private static float m26443b(float f) {
        AppMethodBeat.m2504i(66930);
        if (f > 1.0f) {
            if (((double) f) < 2.5d) {
                f = C17086c.m26442a((f - 1.0f) / 1.5f, 1.0f, 4.1f);
            } else if (f < 4.0f) {
                f = C17086c.m26442a((f - 2.5f) / 1.5f, 4.1f, 5.6f);
            } else if (((double) f) < 5.5d) {
                f = C17086c.m26442a((f - 4.0f) / 1.5f, 5.6f, 6.8f);
            } else if (((double) f) <= 7.0d) {
                f = C17086c.m26442a((f - 5.5f) / 1.5f, 6.8f, 7.0f);
            }
            float f2 = f / 10.0f;
            AppMethodBeat.m2505o(66930);
            return f2;
        }
        AppMethodBeat.m2505o(66930);
        return 0.1f;
    }

    /* renamed from: a */
    private static float m26442a(float f, float f2, float f3) {
        return ((f3 - f2) * f) + f2;
    }
}
