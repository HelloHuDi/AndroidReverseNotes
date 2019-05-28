package com.tencent.liteav.beauty.b;

import android.opengl.GLES20;
import com.tencent.liteav.beauty.NativeLoad;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class c extends b {
    private static final String r = c.class.getSimpleName();
    private float A = 0.0f;
    private f s;
    private a t;
    private p u = null;
    private int v = -1;
    private int w = -1;
    private float x = 0.0f;
    private float y = 0.0f;
    private float z = 0.0f;

    public static class a extends q {
        private int x = -1;
        private int y = -1;
        private int z = -1;

        public a() {
            super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\nattribute vec4 inputTextureCoordinate2;\nattribute vec4 inputTextureCoordinate3;\n \nvarying vec2 textureCoordinate;\nvarying vec2 textureCoordinate2;\nvarying vec2 textureCoordinate3;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n    textureCoordinate2 = inputTextureCoordinate2.xy;\n    textureCoordinate3 = inputTextureCoordinate3.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}");
        }

        public boolean a() {
            AppMethodBeat.i(66933);
            NativeLoad.getInstance();
            this.a = NativeLoad.nativeLoadGLProgram(1);
            if (this.a == 0 || !b()) {
                this.g = false;
            } else {
                this.g = true;
            }
            c();
            boolean z = this.g;
            AppMethodBeat.o(66933);
            return z;
        }

        public void a(int i, int i2) {
            AppMethodBeat.i(66934);
            if (this.f == i2 && this.e == i) {
                AppMethodBeat.o(66934);
                return;
            }
            super.a(i, i2);
            this.x = GLES20.glGetUniformLocation(p(), "smoothDegree");
            this.y = GLES20.glGetUniformLocation(p(), "brightDegree");
            this.z = GLES20.glGetUniformLocation(p(), "ruddyDegree");
            AppMethodBeat.o(66934);
        }

        public boolean b() {
            AppMethodBeat.i(66935);
            boolean b = super.b();
            AppMethodBeat.o(66935);
            return b;
        }

        public void a(float f) {
            AppMethodBeat.i(66936);
            a(this.x, c.a(f));
            AppMethodBeat.o(66936);
        }

        public void b(float f) {
            AppMethodBeat.i(66937);
            a(this.y, f / 3.0f);
            AppMethodBeat.o(66937);
        }

        public void c(float f) {
            AppMethodBeat.i(66938);
            a(this.z, (f / 10.0f) / 2.0f);
            AppMethodBeat.o(66938);
        }
    }

    static /* synthetic */ float a(float f) {
        AppMethodBeat.i(66931);
        float b = b(f);
        AppMethodBeat.o(66931);
        return b;
    }

    static {
        AppMethodBeat.i(66932);
        AppMethodBeat.o(66932);
    }

    public int b(int i) {
        AppMethodBeat.i(66922);
        if (this.x > 0.0f || this.y > 0.0f || this.z > 0.0f) {
            int b;
            if (this.x != 0.0f) {
                b = this.s.b(i);
            } else {
                b = i;
            }
            i = this.t.a(b, i, i);
        }
        if (this.A > 0.0f) {
            i = this.u.b(i);
        }
        AppMethodBeat.o(66922);
        return i;
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(66923);
        if (this.v == i && this.w == i2) {
            AppMethodBeat.o(66923);
            return;
        }
        new StringBuilder("onOutputSizeChanged mFrameWidth = ").append(i).append("  mFrameHeight = ").append(i2);
        this.v = i;
        this.w = i2;
        b(this.v, this.w);
        AppMethodBeat.o(66923);
    }

    public boolean b(int i, int i2) {
        AppMethodBeat.i(66924);
        this.v = i;
        this.w = i2;
        new StringBuilder("init mFrameWidth = ").append(i).append("  mFrameHeight = ").append(i2);
        if (this.s == null) {
            this.s = new f();
            this.s.a(true);
            if (!this.s.a()) {
                AppMethodBeat.o(66924);
                return false;
            }
        }
        this.s.a(this.v, this.w);
        if (this.t == null) {
            this.t = new a();
            this.t.a(true);
            if (!this.t.a()) {
                AppMethodBeat.o(66924);
                return false;
            }
        }
        this.t.a(this.v, this.w);
        if (this.u == null) {
            this.u = new p();
            this.u.a(true);
            if (!this.u.a()) {
                AppMethodBeat.o(66924);
                return false;
            }
        }
        this.u.a(this.v, this.w);
        AppMethodBeat.o(66924);
        return true;
    }

    public void e() {
        AppMethodBeat.i(66925);
        if (this.t != null) {
            this.t.d();
            this.t = null;
        }
        if (this.s != null) {
            this.s.d();
            this.s = null;
        }
        if (this.u != null) {
            this.u.d();
            this.u = null;
        }
        AppMethodBeat.o(66925);
    }

    public void c(int i) {
        AppMethodBeat.i(66926);
        this.x = (float) i;
        if (this.t != null) {
            this.t.a((float) i);
        }
        AppMethodBeat.o(66926);
    }

    public void d(int i) {
        AppMethodBeat.i(66927);
        this.y = (float) i;
        if (this.t != null) {
            this.t.b((float) i);
        }
        AppMethodBeat.o(66927);
    }

    public void e(int i) {
        AppMethodBeat.i(66928);
        this.z = (float) i;
        if (this.t != null) {
            this.t.c((float) i);
        }
        AppMethodBeat.o(66928);
    }

    public void f(int i) {
        AppMethodBeat.i(66929);
        this.A = ((float) i) / 15.0f;
        if (this.u != null) {
            this.u.a(this.A);
        }
        AppMethodBeat.o(66929);
    }

    private static float b(float f) {
        AppMethodBeat.i(66930);
        if (f > 1.0f) {
            if (((double) f) < 2.5d) {
                f = a((f - 1.0f) / 1.5f, 1.0f, 4.1f);
            } else if (f < 4.0f) {
                f = a((f - 2.5f) / 1.5f, 4.1f, 5.6f);
            } else if (((double) f) < 5.5d) {
                f = a((f - 4.0f) / 1.5f, 5.6f, 6.8f);
            } else if (((double) f) <= 7.0d) {
                f = a((f - 5.5f) / 1.5f, 6.8f, 7.0f);
            }
            float f2 = f / 10.0f;
            AppMethodBeat.o(66930);
            return f2;
        }
        AppMethodBeat.o(66930);
        return 0.1f;
    }

    private static float a(float f, float f2, float f3) {
        return ((f3 - f2) * f) + f2;
    }
}
