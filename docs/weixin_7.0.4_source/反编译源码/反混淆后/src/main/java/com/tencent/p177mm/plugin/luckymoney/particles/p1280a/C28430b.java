package com.tencent.p177mm.plugin.luckymoney.particles.p1280a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.VelocityTracker;
import android.view.animation.Interpolator;

/* renamed from: com.tencent.mm.plugin.luckymoney.particles.a.b */
public abstract class C28430b {
    private final Matrix aKk = new Matrix();
    public int alpha;
    public Interpolator nZO;
    public Rect nZP;
    public float nZU;
    public float nZW;
    public Float nZY;
    public float oaA;
    public float oaB;
    public float oaC;
    public float oaD;
    public Long oaE;
    public Long oaF;
    public float oaG;
    public float oaH;
    public Long oaI;
    public float oaJ;
    public float oaK;
    public float oaL;
    public float oaM;
    public float oaN;
    public boolean oaO;
    public boolean oaP;
    public VelocityTracker oaQ;
    public float oaR;
    public float oaS;
    public float oaT;
    public float oaU;
    public Float oaa;
    public float oag;
    public Float oai;
    public long oak;
    private final Paint oay = new Paint(1);
    public long oaz;
    public boolean terminated;

    /* renamed from: a */
    public abstract void mo26034a(Canvas canvas, Matrix matrix, Paint paint, float f, float f2, float f3, float f4);

    public abstract int getHeight();

    public abstract int getWidth();

    /* renamed from: i */
    public final void mo46414i(Rect rect) {
        this.nZP = rect;
        this.oaE = C28430b.m45120a(this.nZY, this.oaC, this.nZU);
        this.oaF = C28430b.m45120a(this.oaa, this.oaD, this.nZW);
        this.oaI = C28430b.m45120a(this.oai, this.oaH, this.oag);
        if (this.oaJ == 0.0f) {
            this.oaJ = this.oak >= 0 ? (float) this.oak : 9.223372E18f;
            this.oaJ = Math.min((float) C28430b.m45119a(this.oaA, this.oaC, this.nZU, this.oaE, this.nZY, rect.left - getWidth(), rect.right), this.oaJ);
            this.oaJ = Math.min((float) C28430b.m45119a(this.oaB, this.oaD, this.nZW, this.oaF, this.oaa, rect.top - getHeight(), rect.bottom), this.oaJ);
        }
        this.oay.setAlpha(this.alpha);
    }

    /* renamed from: a */
    private static Long m45120a(Float f, float f2, float f3) {
        if (f == null) {
            return null;
        }
        if (f3 != 0.0f) {
            long floatValue = (long) ((f.floatValue() - f2) / f3);
            if (floatValue <= 0) {
                floatValue = 0;
            }
            return Long.valueOf(floatValue);
        } else if (f.floatValue() < f2) {
            return Long.valueOf(0);
        } else {
            return null;
        }
    }

    /* renamed from: a */
    private static long m45119a(float f, float f2, float f3, Long l, Float f4, int i, int i2) {
        double sqrt;
        if (f3 != 0.0f) {
            if (f3 <= 0.0f) {
                i2 = i;
            }
            if (l == null || l.longValue() < 0) {
                sqrt = Math.sqrt((double) ((((2.0f * f3) * ((float) i2)) - ((2.0f * f3) * f)) + (f2 * f2)));
                double d = ((-sqrt) - ((double) f2)) / ((double) f3);
                if (d > 0.0d) {
                    return (long) d;
                }
                sqrt = (sqrt - ((double) f2)) / ((double) f3);
                if (sqrt > 0.0d) {
                    return (long) sqrt;
                }
                return Long.MAX_VALUE;
            }
            sqrt = ((((double) ((((float) i2) - f) - (((float) l.longValue()) * f2))) - (((0.5d * ((double) f3)) * ((double) l.longValue())) * ((double) l.longValue()))) + ((double) (f4.floatValue() * ((float) l.longValue())))) / ((double) f4.floatValue());
            return sqrt > 0.0d ? (long) sqrt : Long.MAX_VALUE;
        } else {
            if (l != null) {
                f2 = f4.floatValue();
            }
            if (f2 <= 0.0f) {
                i2 = i;
            }
            if (f2 == 0.0f) {
                return Long.MAX_VALUE;
            }
            sqrt = (double) ((((float) i2) - f) / f2);
            return sqrt > 0.0d ? (long) sqrt : Long.MAX_VALUE;
        }
    }

    public void reset() {
        this.oaz = 0;
        this.oaB = 0.0f;
        this.oaA = 0.0f;
        this.oaD = 0.0f;
        this.oaC = 0.0f;
        this.nZW = 0.0f;
        this.nZU = 0.0f;
        this.oaa = null;
        this.nZY = null;
        this.oaF = null;
        this.oaE = null;
        this.oaG = 0.0f;
        this.oaH = 0.0f;
        this.oag = 0.0f;
        this.oai = null;
        this.oaI = null;
        this.oak = 0;
        this.oaJ = 0.0f;
        this.oaK = 0.0f;
        this.nZO = null;
        this.oaM = 0.0f;
        this.oaL = 0.0f;
        this.oaN = 0.0f;
        this.alpha = 255;
        this.oaO = false;
        this.terminated = false;
    }

    /* renamed from: a */
    public static float m45118a(long j, float f, float f2, float f3, Long l, Float f4) {
        if (l == null || j < l.longValue()) {
            return ((((float) j) * f2) + f) + (((0.5f * f3) * ((float) j)) * ((float) j));
        }
        return (((((float) l.longValue()) * f2) + f) + (((0.5f * f3) * ((float) l.longValue())) * ((float) l.longValue()))) + (((float) (j - l.longValue())) * f4.floatValue());
    }

    /* renamed from: a */
    public final void mo46413a(Canvas canvas, float f, float f2, float f3, float f4) {
        canvas.save();
        canvas.clipRect(this.nZP);
        this.aKk.reset();
        this.oay.setAlpha(this.alpha);
        mo26034a(canvas, this.aKk, this.oay, f, f2, f3, f4);
        canvas.restore();
    }
}
