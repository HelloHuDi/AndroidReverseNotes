package com.tencent.liteav.basic.e;

import android.opengl.GLES20;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct.GLFormat;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.gles.GlUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.LinkedList;

public class g {
    protected int a;
    protected int b;
    protected int c;
    protected int d;
    protected int e;
    protected int f;
    protected boolean g;
    protected FloatBuffer h;
    protected FloatBuffer i;
    protected float[] j;
    protected float[] k;
    protected a l;
    protected int m;
    protected int n;
    protected boolean o;
    protected boolean p;
    protected boolean q;
    private final LinkedList<Runnable> r;
    private final String s;
    private final String t;
    private boolean u;
    private int v;
    private float[] w;
    private String x;

    public interface a {
        void a(int i);
    }

    public g() {
        this("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", "varying lowp vec2 textureCoordinate;\n \nuniform sampler2D inputImageTexture;\n \nvoid main()\n{\n     gl_FragColor = texture2D(inputImageTexture, textureCoordinate);\n}", false);
    }

    public g(String str, String str2) {
        this(str, str2, false);
    }

    public g(String str, String str2, boolean z) {
        AppMethodBeat.i(66258);
        this.u = false;
        this.v = -1;
        this.w = null;
        this.m = -1;
        this.n = -1;
        this.o = false;
        this.p = false;
        this.q = false;
        this.x = "TXCGPUFilter";
        this.r = new LinkedList();
        this.s = str;
        this.t = str2;
        this.q = z;
        if (true == z) {
            TXCLog.i(this.x, "set Oes fileter");
        }
        this.h = ByteBuffer.allocateDirect(k.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.j = k.e;
        this.h.put(this.j).position(0);
        this.i = ByteBuffer.allocateDirect(k.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.k = k.a(j.NORMAL, false, true);
        this.i.put(this.k).position(0);
        AppMethodBeat.o(66258);
    }

    public boolean a() {
        AppMethodBeat.i(66259);
        this.a = i.a(this.s, this.t);
        if (this.a == 0 || !b()) {
            this.g = false;
        } else {
            this.g = true;
        }
        c();
        boolean z = this.g;
        AppMethodBeat.o(66259);
        return z;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public void b(boolean z) {
        AppMethodBeat.i(66260);
        this.p = z;
        TXCLog.i(this.x, "set Nearest model ".concat(String.valueOf(z)));
        AppMethodBeat.o(66260);
    }

    public void a(a aVar) {
        this.u = aVar != null;
        this.l = aVar;
    }

    public boolean b() {
        AppMethodBeat.i(66261);
        this.b = GLES20.glGetAttribLocation(this.a, "position");
        this.c = GLES20.glGetUniformLocation(this.a, "inputImageTexture");
        this.v = GLES20.glGetUniformLocation(this.a, "textureTransform");
        this.d = GLES20.glGetAttribLocation(this.a, "inputTextureCoordinate");
        AppMethodBeat.o(66261);
        return true;
    }

    public void c() {
    }

    public void d() {
        AppMethodBeat.i(66262);
        GLES20.glDeleteProgram(this.a);
        e();
        this.g = false;
        AppMethodBeat.o(66262);
    }

    public void e() {
        AppMethodBeat.i(66263);
        f();
        this.f = -1;
        this.e = -1;
        AppMethodBeat.o(66263);
    }

    private static float[] a(FloatBuffer floatBuffer) {
        AppMethodBeat.i(66264);
        if (floatBuffer.limit() <= 0) {
            AppMethodBeat.o(66264);
            return null;
        }
        float[] fArr = new float[floatBuffer.limit()];
        for (int i = 0; i < floatBuffer.limit(); i++) {
            fArr[i] = floatBuffer.get(i);
        }
        AppMethodBeat.o(66264);
        return fArr;
    }

    public void f() {
        AppMethodBeat.i(66265);
        if (this.m != -1) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.m}, 0);
            this.m = -1;
        }
        if (this.n != -1) {
            GLES20.glDeleteTextures(1, new int[]{this.n}, 0);
            this.n = -1;
        }
        AppMethodBeat.o(66265);
    }

    public void a(int i, int i2) {
        AppMethodBeat.i(66266);
        if (this.f == i2 && this.e == i) {
            AppMethodBeat.o(66266);
            return;
        }
        this.e = i;
        this.f = i2;
        if (this.o) {
            if (this.m != -1) {
                f();
            }
            int[] iArr = new int[1];
            GLES20.glGenFramebuffers(1, iArr, 0);
            this.m = iArr[0];
            this.n = i.a(i, i2, GLFormat.GL_RGBA, GLFormat.GL_RGBA);
            GLES20.glBindFramebuffer(36160, this.m);
            GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.n, 0);
            GLES20.glBindFramebuffer(36160, 0);
        }
        AppMethodBeat.o(66266);
    }

    public void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(66267);
        GLES20.glUseProgram(this.a);
        k();
        if (this.g) {
            floatBuffer.position(0);
            GLES20.glVertexAttribPointer(this.b, 2, 5126, false, 0, floatBuffer);
            GLES20.glEnableVertexAttribArray(this.b);
            floatBuffer2.position(0);
            GLES20.glVertexAttribPointer(this.d, 2, 5126, false, 0, floatBuffer2);
            GLES20.glEnableVertexAttribArray(this.d);
            if (this.v >= 0 && this.w != null) {
                GLES20.glUniformMatrix4fv(this.v, 1, false, this.w, 0);
            }
            if (i != -1) {
                GLES20.glActiveTexture(33984);
                if (true == this.q) {
                    GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, i);
                } else {
                    GLES20.glBindTexture(3553, i);
                }
                GLES20.glUniform1i(this.c, 0);
            }
            i();
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glDisableVertexAttribArray(this.b);
            GLES20.glDisableVertexAttribArray(this.d);
            j();
            if (true == this.q) {
                GLES20.glBindTexture(GlUtil.GL_TEXTURE_EXTERNAL_OES, 0);
                AppMethodBeat.o(66267);
                return;
            }
            GLES20.glBindTexture(3553, 0);
            AppMethodBeat.o(66267);
            return;
        }
        AppMethodBeat.o(66267);
    }

    public void a(float[] fArr) {
        this.w = fArr;
    }

    public void g() {
        AppMethodBeat.i(66268);
        if (this.k != null) {
            for (int i = 0; i < 8; i += 2) {
                this.k[i] = 1.0f - this.k[i];
            }
            a(this.j, this.k);
            AppMethodBeat.o(66268);
            return;
        }
        AppMethodBeat.o(66268);
    }

    public void h() {
        AppMethodBeat.i(66269);
        if (this.k != null) {
            for (int i = 1; i < 8; i += 2) {
                this.k[i] = 1.0f - this.k[i];
            }
            a(this.j, this.k);
            AppMethodBeat.o(66269);
            return;
        }
        AppMethodBeat.o(66269);
    }

    public int b(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        AppMethodBeat.i(66270);
        if (this.g) {
            a(i, floatBuffer, floatBuffer2);
            if (this.l instanceof a) {
                this.l.a(i);
            }
            AppMethodBeat.o(66270);
            return 1;
        }
        AppMethodBeat.o(66270);
        return -1;
    }

    public int a(int i) {
        AppMethodBeat.i(66271);
        int b = b(i, this.h, this.i);
        AppMethodBeat.o(66271);
        return b;
    }

    /* Access modifiers changed, original: protected */
    public void i() {
    }

    /* Access modifiers changed, original: protected */
    public void j() {
    }

    /* Access modifiers changed, original: protected */
    public void k() {
        AppMethodBeat.i(66272);
        while (!this.r.isEmpty()) {
            ((Runnable) this.r.removeFirst()).run();
        }
        AppMethodBeat.o(66272);
    }

    public int a(int i, int i2, int i3) {
        AppMethodBeat.i(66273);
        if (this.g) {
            GLES20.glBindFramebuffer(36160, i2);
            a(i, this.h, this.i);
            if (this.l instanceof a) {
                this.l.a(i3);
            }
            GLES20.glBindFramebuffer(36160, 0);
            AppMethodBeat.o(66273);
            return i3;
        }
        AppMethodBeat.o(66273);
        return -1;
    }

    public int b(int i) {
        AppMethodBeat.i(66274);
        int a = a(i, this.m, this.n);
        AppMethodBeat.o(66274);
        return a;
    }

    public int l() {
        return this.n;
    }

    public void a(float[] fArr, float[] fArr2) {
        AppMethodBeat.i(66275);
        this.j = fArr;
        this.h = ByteBuffer.allocateDirect(k.e.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.h.put(fArr).position(0);
        this.k = fArr2;
        this.i = ByteBuffer.allocateDirect(k.a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.i.put(fArr2).position(0);
        AppMethodBeat.o(66275);
    }

    public float[] a(int i, int i2, FloatBuffer floatBuffer, a aVar, int i3) {
        float[] a;
        int i4 = 0;
        AppMethodBeat.i(66276);
        if (floatBuffer != null) {
            a = a(floatBuffer);
        } else if (4 == i3) {
            a = k.a(j.NORMAL, false, false);
        } else {
            a = k.a(j.NORMAL, false, true);
        }
        if (aVar != null) {
            float f = ((float) aVar.a) / (((float) i) * 1.0f);
            float f2 = ((float) ((i - aVar.a) - aVar.c)) / (((float) i) * 1.0f);
            float f3 = ((float) aVar.b) / (((float) i2) * 1.0f);
            float f4 = ((float) ((i2 - aVar.b) - aVar.d)) / (((float) i2) * 1.0f);
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
        AppMethodBeat.o(66276);
        return a;
    }

    public void a(int i, int i2, int i3, float[] fArr, float f, boolean z, boolean z2) {
        int i4;
        int i5;
        AppMethodBeat.i(66277);
        if (fArr == null) {
            fArr = k.a(j.NORMAL, false, true);
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
        a((float[]) k.e.clone(), fArr);
        AppMethodBeat.o(66277);
    }

    public void a(int i, FloatBuffer floatBuffer) {
        float[] a;
        AppMethodBeat.i(66278);
        if (floatBuffer == null) {
            a = k.a(j.NORMAL, false, true);
        } else {
            a = a(floatBuffer);
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
        a((float[]) k.e.clone(), a);
        AppMethodBeat.o(66278);
    }

    public boolean m() {
        return this.g;
    }

    public int n() {
        return this.e;
    }

    public int o() {
        return this.f;
    }

    public int p() {
        return this.a;
    }

    public void a(final int i, final float f) {
        AppMethodBeat.i(66279);
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66209);
                GLES20.glUniform1f(i, f);
                AppMethodBeat.o(66209);
            }
        });
        AppMethodBeat.o(66279);
    }

    public void a(final int i, final float[] fArr) {
        AppMethodBeat.i(66280);
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66227);
                GLES20.glUniform2fv(i, 1, FloatBuffer.wrap(fArr));
                AppMethodBeat.o(66227);
            }
        });
        AppMethodBeat.o(66280);
    }

    public void b(final int i, final float[] fArr) {
        AppMethodBeat.i(66281);
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66179);
                GLES20.glUniform3fv(i, 1, FloatBuffer.wrap(fArr));
                AppMethodBeat.o(66179);
            }
        });
        AppMethodBeat.o(66281);
    }

    public void c(final int i, final float[] fArr) {
        AppMethodBeat.i(66282);
        a(new Runnable() {
            public void run() {
                AppMethodBeat.i(66187);
                GLES20.glUniform4fv(i, 1, FloatBuffer.wrap(fArr));
                AppMethodBeat.o(66187);
            }
        });
        AppMethodBeat.o(66282);
    }

    public void a(Runnable runnable) {
        AppMethodBeat.i(66283);
        synchronized (this.r) {
            try {
                this.r.addLast(runnable);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(66283);
            }
        }
    }
}
