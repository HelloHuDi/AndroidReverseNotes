package com.tencent.liteav.basic.p141e;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

/* renamed from: com.tencent.liteav.basic.e.g */
public class C8796g {
    /* renamed from: a */
    protected int f2616a;
    /* renamed from: b */
    protected int f2617b;
    /* renamed from: c */
    protected int f2618c;
    /* renamed from: d */
    protected int f2619d;
    /* renamed from: e */
    protected int f2620e;
    /* renamed from: f */
    protected int f2621f;
    /* renamed from: g */
    protected boolean f2622g;
    /* renamed from: h */
    protected FloatBuffer f2623h;
    /* renamed from: i */
    protected FloatBuffer f2624i;
    /* renamed from: j */
    protected float[] f2625j;
    /* renamed from: k */
    protected float[] f2626k;
    /* renamed from: l */
    protected C8799a f2627l;
    /* renamed from: m */
    protected int f2628m;
    /* renamed from: n */
    protected int f2629n;
    /* renamed from: o */
    protected boolean f2630o;
    /* renamed from: p */
    protected boolean f2631p;
    /* renamed from: q */
    protected boolean f2632q;
    /* renamed from: r */
    private final LinkedList<Runnable> f2633r;
    /* renamed from: s */
    private final String f2634s;
    /* renamed from: t */
    private final String f2635t;
    /* renamed from: u */
    private boolean f2636u;
    /* renamed from: v */
    private int f2637v;
    /* renamed from: w */
    private float[] f2638w;
    /* renamed from: x */
    private String f2639x;

    /* renamed from: com.tencent.liteav.basic.e.g$a */
    public interface C8799a {
        /* renamed from: a */
        void mo19897a(int i);
    }

    public C8796g() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
    }

    public C8796g(String str, String str2) {
        this(str, str2, false);
    }

    public C8796g(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(66258);
        this.f2636u = false;
        this.f2637v = -1;
        this.f2638w = null;
        this.f2628m = -1;
        this.f2629n = -1;
        this.f2630o = false;
        this.f2631p = false;
        this.f2632q = false;
        this.f2639x = "TXCGPUFilter";
        this.f2633r = new LinkedList();
        this.f2634s = str;
        this.f2635t = str2;
        this.f2632q = z;
        if (true == z) {
            TXCLog.m15677i(this.f2639x, "set Oes fileter");
        }
        this.f2623h = ByteBuffer.allocateDirect(C45103k.f17758e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2625j = C45103k.f17758e;
        this.f2623h.put(this.f2625j).position(0);
        this.f2624i = ByteBuffer.allocateDirect(C45103k.f17754a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2626k = C45103k.m82749a(C37353j.NORMAL, false, true);
        this.f2624i.put(this.f2626k).position(0);
        AppMethodBeat.m2505o(66258);
    }

    /* renamed from: a */
    public boolean mo19876a() {
        AppMethodBeat.m2504i(66259);
        this.f2616a = C32144i.m52316a(this.f2634s, this.f2635t);
        if (this.f2616a == 0 || !mo3848b()) {
            this.f2622g = false;
        } else {
            this.f2622g = true;
        }
        mo19881c();
        boolean z = this.f2622g;
        AppMethodBeat.m2505o(66259);
        return z;
    }

    /* renamed from: a */
    public void mo19873a(boolean z) {
        this.f2630o = z;
    }

    /* renamed from: b */
    public void mo19880b(boolean z) {
        AppMethodBeat.m2504i(66260);
        this.f2631p = z;
        TXCLog.m15677i(this.f2639x, "set Nearest model ".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(66260);
    }

    /* renamed from: a */
    public void mo19871a(C8799a c8799a) {
        this.f2636u = c8799a != null;
        this.f2627l = c8799a;
    }

    /* renamed from: b */
    public boolean mo3848b() {
        AppMethodBeat.m2504i(66261);
        this.f2617b = GLES20.glGetAttribLocation(this.f2616a, "position");
        this.f2618c = GLES20.glGetUniformLocation(this.f2616a, "inputImageTexture");
        this.f2637v = GLES20.glGetUniformLocation(this.f2616a, "textureTransform");
        this.f2619d = GLES20.glGetAttribLocation(this.f2616a, "inputTextureCoordinate");
        AppMethodBeat.m2505o(66261);
        return true;
    }

    /* renamed from: c */
    public void mo19881c() {
    }

    /* renamed from: d */
    public void mo19883d() {
        AppMethodBeat.m2504i(66262);
        GLES20.glDeleteProgram(this.f2616a);
        mo3844e();
        this.f2622g = false;
        AppMethodBeat.m2505o(66262);
    }

    /* renamed from: e */
    public void mo3844e() {
        AppMethodBeat.m2504i(66263);
        mo19884f();
        this.f2621f = -1;
        this.f2620e = -1;
        AppMethodBeat.m2505o(66263);
    }

    /* renamed from: a */
    private static float[] m15638a(FloatBuffer floatBuffer) {
        AppMethodBeat.m2504i(66264);
        if (floatBuffer.limit() <= 0) {
            AppMethodBeat.m2505o(66264);
            return null;
        }
        float[] fArr = new float[floatBuffer.limit()];
        for (int i = 0; i < floatBuffer.limit(); i++) {
            fArr[i] = floatBuffer.get(i);
        }
        AppMethodBeat.m2505o(66264);
        return fArr;
    }

    /* renamed from: f */
    public void mo19884f() {
        AppMethodBeat.m2504i(66265);
        if (this.f2628m != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.f2628m}, 0);
            this.f2628m = -1;
        }
        if (this.f2629n != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.f2629n}, 0);
            this.f2629n = -1;
        }
        AppMethodBeat.m2505o(66265);
    }

    /* renamed from: a */
    public void mo3839a(int i, int i2) {
        AppMethodBeat.m2504i(66266);
        if (this.f2621f == i2 && this.f2620e == i) {
            AppMethodBeat.m2505o(66266);
            return;
        }
        this.f2620e = i;
        this.f2621f = i2;
        if (this.f2630o) {
            if (this.f2628m != -1) {
                mo19884f();
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.f2628m = iArr[0];
            this.f2629n = C32144i.m52310a(i, i2, GLFormat.GL_RGBA, GLFormat.GL_RGBA);
            GLES20.glBindFramebuffer(36160, this.f2628m);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f2629n, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        AppMethodBeat.m2505o(66266);
    }

    /* renamed from: a */
    public void mo19869a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.m2504i(66267);
        GLES20.glUseProgram(this.f2616a);
        mo19889k();
        if (this.f2622g) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.f2617b, 2, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.f2617b);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.f2619d, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.f2619d);
            if (this.f2637v >= 0 && this.f2638w != null) {
                GLES20.glUniformMatrix4fv(this.f2637v, 1, false, this.f2638w, 0);
            }
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                if (true == this.f2632q) {
                    GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, i);
                } else {
                    GLES20.glBindTexture(3553, i);
                }
                GLES20.glUniform1i(this.f2618c, 0);
            }
            mo19887i();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.f2617b);
            GLES20.glDisableVertexAttribArray(this.f2619d);
            mo19888j();
            if (true == this.f2632q) {
                GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
                AppMethodBeat.m2505o(66267);
                return;
            }
            GLES20.glBindTexture(3553, 0);
            AppMethodBeat.m2505o(66267);
            return;
        }
        AppMethodBeat.m2505o(66267);
    }

    /* renamed from: a */
    public void mo19874a(float[] fArr) {
        this.f2638w = fArr;
    }

    /* renamed from: g */
    public void mo19885g() {
        AppMethodBeat.m2504i(66268);
        if (this.f2626k != null) {
            for (int i = 0; i < 8; i += 2) {
                this.f2626k[i] = 1.0f - this.f2626k[i];
            }
            mo19875a(this.f2625j, this.f2626k);
            AppMethodBeat.m2505o(66268);
            return;
        }
        AppMethodBeat.m2505o(66268);
    }

    /* renamed from: h */
    public void mo19886h() {
        AppMethodBeat.m2504i(66269);
        if (this.f2626k != null) {
            for (int i = 1; i < 8; i += 2) {
                this.f2626k[i] = 1.0f - this.f2626k[i];
            }
            mo19875a(this.f2625j, this.f2626k);
            AppMethodBeat.m2505o(66269);
            return;
        }
        AppMethodBeat.m2505o(66269);
    }

    /* renamed from: b */
    public int mo19878b(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.m2504i(66270);
        if (this.f2622g) {
            mo19869a(i, floatBuffer, floatBuffer2);
            if (this.f2627l instanceof C8799a) {
                this.f2627l.mo19897a(i);
            }
            AppMethodBeat.m2505o(66270);
            return 1;
        }
        AppMethodBeat.m2505o(66270);
        return -1;
    }

    /* renamed from: a */
    public int mo19864a(int i) {
        AppMethodBeat.m2504i(66271);
        int b = mo19878b(i, this.f2623h, this.f2624i);
        AppMethodBeat.m2505o(66271);
        return b;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: i */
    public void mo19887i() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: j */
    public void mo19888j() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: k */
    public void mo19889k() {
        AppMethodBeat.m2504i(66272);
        while (!this.f2633r.isEmpty()) {
            ((Runnable) this.f2633r.removeFirst()).run();
        }
        AppMethodBeat.m2505o(66272);
    }

    /* renamed from: a */
    public int mo19865a(int i, int i2, int i3) {
        AppMethodBeat.m2504i(66273);
        if (this.f2622g) {
            GLES20.glBindFramebuffer(36160, i2);
            mo19869a(i, this.f2623h, this.f2624i);
            if (this.f2627l instanceof C8799a) {
                this.f2627l.mo19897a(i3);
            }
            GLES20.glBindFramebuffer(36160, 0);
            AppMethodBeat.m2505o(66273);
            return i3;
        }
        AppMethodBeat.m2505o(66273);
        return -1;
    }

    /* renamed from: b */
    public int mo3840b(int i) {
        AppMethodBeat.m2504i(66274);
        int a = mo19865a(i, this.f2628m, this.f2629n);
        AppMethodBeat.m2505o(66274);
        return a;
    }

    /* renamed from: l */
    public int mo19890l() {
        return this.f2629n;
    }

    /* renamed from: a */
    public void mo19875a(float[] fArr, float[] fArr2) {
        AppMethodBeat.m2504i(66275);
        this.f2625j = fArr;
        this.f2623h = ByteBuffer.allocateDirect(C45103k.f17758e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2623h.put(fArr).position(0);
        this.f2626k = fArr2;
        this.f2624i = ByteBuffer.allocateDirect(C45103k.f17754a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f2624i.put(fArr2).position(0);
        AppMethodBeat.m2505o(66275);
    }

    /* renamed from: a */
    public float[] mo19877a(int i, int i2, FloatBuffer floatBuffer, C32140a c32140a, int i3) {
        float[] a;
        int i4 = 0;
        AppMethodBeat.m2504i(66276);
        if (floatBuffer != null) {
            a = C8796g.m15638a(floatBuffer);
        } else if (4 == i3) {
            a = C45103k.m82749a(C37353j.NORMAL, false, false);
        } else {
            a = C45103k.m82749a(C37353j.NORMAL, false, true);
        }
        if (c32140a != null) {
            float f = ((float) c32140a.f14701a) / (((float) i) * 1.0f);
            float f2 = ((float) ((i - c32140a.f14701a) - c32140a.f14703c)) / (((float) i) * 1.0f);
            float f3 = ((float) c32140a.f14702b) / (((float) i2) * 1.0f);
            float f4 = ((float) ((i2 - c32140a.f14702b) - c32140a.f14704d)) / (((float) i2) * 1.0f);
            while (i4 < a.length / 2) {
                int i5;
                if (a[i4 * 2] < 0.5f) {
                    i5 = i4 * 2;
                    a[i5] = a[i5] + f;
                } else {
                    i5 = i4 * 2;
                    a[i5] = a[i5] - f2;
                }
                if (a[(i4 * 2) + 1] < 0.5f) {
                    i5 = (i4 * 2) + 1;
                    a[i5] = a[i5] + f3;
                } else {
                    i5 = (i4 * 2) + 1;
                    a[i5] = a[i5] - f4;
                }
                i4++;
            }
        }
        AppMethodBeat.m2505o(66276);
        return a;
    }

    /* renamed from: a */
    public void mo19867a(int i, int i2, int i3, float[] fArr, float f, boolean z, boolean z2) {
        int i4;
        int i5;
        AppMethodBeat.m2504i(66277);
        if (fArr == null) {
            fArr = C45103k.m82749a(C37353j.NORMAL, false, true);
        }
        if (((float) i) / ((float) i2) > f) {
            i4 = (int) (((float) i2) * f);
            i5 = i2;
        } else if (((float) i) / ((float) i2) < f) {
            i5 = (int) (((float) i) / f);
            i4 = i;
        } else {
            i5 = i2;
            i4 = i;
        }
        float f2 = (1.0f - (((float) i4) / ((float) i))) / 2.0f;
        float f3 = (1.0f - (((float) i5) / ((float) i2))) / 2.0f;
        for (i5 = 0; i5 < fArr.length / 2; i5++) {
            int i6;
            if (fArr[i5 * 2] < 0.5f) {
                i6 = i5 * 2;
                fArr[i6] = fArr[i6] + f2;
            } else {
                i6 = i5 * 2;
                fArr[i6] = fArr[i6] - f2;
            }
            if (fArr[(i5 * 2) + 1] < 0.5f) {
                i6 = (i5 * 2) + 1;
                fArr[i6] = fArr[i6] + f3;
            } else {
                i6 = (i5 * 2) + 1;
                fArr[i6] = fArr[i6] - f3;
            }
        }
        i4 = i3 / 90;
        for (i5 = 0; i5 < i4; i5++) {
            f3 = fArr[0];
            float f4 = fArr[1];
            fArr[0] = fArr[2];
            fArr[1] = fArr[3];
            fArr[2] = fArr[6];
            fArr[3] = fArr[7];
            fArr[6] = fArr[4];
            fArr[7] = fArr[5];
            fArr[4] = f3;
            fArr[5] = f4;
        }
        if (i4 == 0 || i4 == 2) {
            if (z) {
                fArr[0] = 1.0f - fArr[0];
                fArr[2] = 1.0f - fArr[2];
                fArr[4] = 1.0f - fArr[4];
                fArr[6] = 1.0f - fArr[6];
            }
            if (z2) {
                fArr[1] = 1.0f - fArr[1];
                fArr[3] = 1.0f - fArr[3];
                fArr[5] = 1.0f - fArr[5];
                fArr[7] = 1.0f - fArr[7];
            }
        } else {
            if (z2) {
                fArr[0] = 1.0f - fArr[0];
                fArr[2] = 1.0f - fArr[2];
                fArr[4] = 1.0f - fArr[4];
                fArr[6] = 1.0f - fArr[6];
            }
            if (z) {
                fArr[1] = 1.0f - fArr[1];
                fArr[3] = 1.0f - fArr[3];
                fArr[5] = 1.0f - fArr[5];
                fArr[7] = 1.0f - fArr[7];
            }
        }
        mo19875a((float[]) C45103k.f17758e.clone(), fArr);
        AppMethodBeat.m2505o(66277);
    }

    /* renamed from: a */
    public void mo19868a(int i, FloatBuffer floatBuffer) {
        float[] a;
        AppMethodBeat.m2504i(66278);
        if (floatBuffer == null) {
            a = C45103k.m82749a(C37353j.NORMAL, false, true);
        } else {
            a = C8796g.m15638a(floatBuffer);
        }
        int i2 = i / 90;
        for (int i3 = 0; i3 < i2; i3++) {
            float f = a[0];
            float f2 = a[1];
            a[0] = a[2];
            a[1] = a[3];
            a[2] = a[6];
            a[3] = a[7];
            a[6] = a[4];
            a[7] = a[5];
            a[4] = f;
            a[5] = f2;
        }
        mo19875a((float[]) C45103k.f17758e.clone(), a);
        AppMethodBeat.m2505o(66278);
    }

    /* renamed from: m */
    public boolean mo19891m() {
        return this.f2622g;
    }

    /* renamed from: n */
    public int mo19892n() {
        return this.f2620e;
    }

    /* renamed from: o */
    public int mo19893o() {
        return this.f2621f;
    }

    /* renamed from: p */
    public int mo19894p() {
        return this.f2616a;
    }

    /* renamed from: a */
    public void mo19866a(final int i, final float f) {
        AppMethodBeat.m2504i(66279);
        mo19872a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66209);
                GLES20.glUniform1f(i, f);
                AppMethodBeat.m2505o(66209);
            }
        });
        AppMethodBeat.m2505o(66279);
    }

    /* renamed from: a */
    public void mo19870a(final int i, final float[] fArr) {
        AppMethodBeat.m2504i(66280);
        mo19872a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66227);
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
                AppMethodBeat.m2505o(66227);
            }
        });
        AppMethodBeat.m2505o(66280);
    }

    /* renamed from: b */
    public void mo19879b(final int i, final float[] fArr) {
        AppMethodBeat.m2504i(66281);
        mo19872a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66179);
                GLES20.glUniform3fv(i, 1, FloatBuffer.wrap(fArr));
                AppMethodBeat.m2505o(66179);
            }
        });
        AppMethodBeat.m2505o(66281);
    }

    /* renamed from: c */
    public void mo19882c(final int i, final float[] fArr) {
        AppMethodBeat.m2504i(66282);
        mo19872a(new Runnable() {
            public void run() {
                AppMethodBeat.m2504i(66187);
                GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
                AppMethodBeat.m2505o(66187);
            }
        });
        AppMethodBeat.m2505o(66282);
    }

    /* renamed from: a */
    public void mo19872a(Runnable runnable) {
        AppMethodBeat.m2504i(66283);
        synchronized (this.f2633r) {
            try {
                this.f2633r.addLast(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(66283);
            }
        }
    }
}
