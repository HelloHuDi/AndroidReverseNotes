package android.support.v4.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.support.v4.f.l;
import android.support.v4.view.b.b;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.smtt.sdk.WebView;

public final class d extends Drawable implements Animatable {
    private static final Interpolator Pb = new b();
    private static final int[] Pc = new int[]{WebView.NIGHT_MODE_COLOR};
    private static final Interpolator mf = new LinearInterpolator();
    private Animator Cz;
    final a Pd = new a();
    private float Pe;
    private boolean Pf;
    private Resources mResources;
    private float nR;

    static class a {
        int HD;
        final RectF Pi = new RectF();
        final Paint Pj = new Paint();
        final Paint Pk = new Paint();
        float Pl = 0.0f;
        float Pm = 0.0f;
        int[] Pn;
        int Po;
        float Pp;
        float Pq;
        float Pr;
        boolean Ps;
        Path Pt;
        float Pu = 1.0f;
        float Pv;
        int Pw;
        int Px;
        int mAlpha = 255;
        final Paint mPaint = new Paint();
        float nR = 0.0f;
        float uW = 5.0f;

        a() {
            this.mPaint.setStrokeCap(Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Style.STROKE);
            this.Pj.setStyle(Style.FILL);
            this.Pj.setAntiAlias(true);
            this.Pk.setColor(0);
        }

        /* Access modifiers changed, original: final */
        public final void setColors(int[] iArr) {
            this.Pn = iArr;
            aR(0);
        }

        /* Access modifiers changed, original: final */
        public final void aR(int i) {
            this.Po = i;
            this.HD = this.Pn[this.Po];
        }

        /* Access modifiers changed, original: final */
        public final int ez() {
            return (this.Po + 1) % this.Pn.length;
        }

        /* Access modifiers changed, original: final */
        public final void setStrokeWidth(float f) {
            this.uW = f;
            this.mPaint.setStrokeWidth(f);
        }

        /* Access modifiers changed, original: final */
        public final int eA() {
            return this.Pn[this.Po];
        }

        /* Access modifiers changed, original: final */
        public final void I(boolean z) {
            if (this.Ps != z) {
                this.Ps = z;
            }
        }

        /* Access modifiers changed, original: final */
        public final void eB() {
            this.Pp = this.Pl;
            this.Pq = this.Pm;
            this.Pr = this.nR;
        }

        /* Access modifiers changed, original: final */
        public final void eC() {
            this.Pp = 0.0f;
            this.Pq = 0.0f;
            this.Pr = 0.0f;
            this.Pl = 0.0f;
            this.Pm = 0.0f;
            this.nR = 0.0f;
        }
    }

    static /* synthetic */ void a(d dVar, float f, a aVar, boolean z) {
        float floor;
        if (dVar.Pf) {
            a(f, aVar);
            floor = (float) (Math.floor((double) (aVar.Pr / 0.8f)) + 1.0d);
            aVar.Pl = aVar.Pp + (((aVar.Pq - 0.01f) - aVar.Pp) * f);
            aVar.Pm = aVar.Pq;
            aVar.nR = ((floor - aVar.Pr) * f) + aVar.Pr;
        } else if (f != 1.0f || z) {
            float f2;
            float f3 = aVar.Pr;
            if (f < 0.5f) {
                floor = f / 0.5f;
                f2 = aVar.Pp;
                floor = ((Pb.getInterpolation(floor) * 0.79f) + 0.01f) + f2;
            } else {
                floor = aVar.Pp + 0.79f;
                f2 = floor - (((1.0f - Pb.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            f3 += 0.20999998f * f;
            float f4 = 216.0f * (dVar.Pe + f);
            aVar.Pl = f2;
            aVar.Pm = floor;
            aVar.nR = f3;
            dVar.nR = f4;
        }
    }

    public d(Context context) {
        this.mResources = ((Context) l.checkNotNull(context)).getResources();
        this.Pd.setColors(Pc);
        this.Pd.setStrokeWidth(2.5f);
        invalidateSelf();
        final a aVar = this.Pd;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                d.a(floatValue, aVar);
                d.a(d.this, floatValue, aVar, false);
                d.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(mf);
        ofFloat.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                d.this.Pe = 0.0f;
            }

            public final void onAnimationEnd(Animator animator) {
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
                d.a(d.this, 1.0f, aVar, true);
                aVar.eB();
                a aVar = aVar;
                aVar.aR(aVar.ez());
                if (d.this.Pf) {
                    d.this.Pf = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    aVar.I(false);
                    return;
                }
                d.this.Pe = d.this.Pe + 1.0f;
            }
        });
        this.Cz = ofFloat;
    }

    private void d(float f, float f2, float f3, float f4) {
        a aVar = this.Pd;
        float f5 = this.mResources.getDisplayMetrics().density;
        aVar.setStrokeWidth(f2 * f5);
        aVar.Pv = f * f5;
        aVar.aR(0);
        float f6 = f3 * f5;
        f5 *= f4;
        aVar.Pw = (int) f6;
        aVar.Px = (int) f5;
    }

    public final void aQ(int i) {
        if (i == 0) {
            d(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            d(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    public final void H(boolean z) {
        this.Pd.I(z);
        invalidateSelf();
    }

    public final void B(float f) {
        a aVar = this.Pd;
        if (f != aVar.Pu) {
            aVar.Pu = f;
        }
        invalidateSelf();
    }

    public final void C(float f) {
        this.Pd.Pl = 0.0f;
        this.Pd.Pm = f;
        invalidateSelf();
    }

    public final void D(float f) {
        this.Pd.nR = f;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.nR, bounds.exactCenterX(), bounds.exactCenterY());
        a aVar = this.Pd;
        RectF rectF = aVar.Pi;
        float f = aVar.Pv + (aVar.uW / 2.0f);
        if (aVar.Pv <= 0.0f) {
            f = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) aVar.Pw) * aVar.Pu) / 2.0f, aVar.uW / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f, ((float) bounds.centerY()) - f, ((float) bounds.centerX()) + f, f + ((float) bounds.centerY()));
        float f2 = (aVar.Pl + aVar.nR) * 360.0f;
        float f3 = ((aVar.Pm + aVar.nR) * 360.0f) - f2;
        aVar.mPaint.setColor(aVar.HD);
        aVar.mPaint.setAlpha(aVar.mAlpha);
        f = aVar.uW / 2.0f;
        rectF.inset(f, f);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, aVar.Pk);
        rectF.inset(-f, -f);
        canvas.drawArc(rectF, f2, f3, false, aVar.mPaint);
        if (aVar.Ps) {
            if (aVar.Pt == null) {
                aVar.Pt = new Path();
                aVar.Pt.setFillType(FillType.EVEN_ODD);
            } else {
                aVar.Pt.reset();
            }
            f = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f4 = (((float) aVar.Pw) * aVar.Pu) / 2.0f;
            aVar.Pt.moveTo(0.0f, 0.0f);
            aVar.Pt.lineTo(((float) aVar.Pw) * aVar.Pu, 0.0f);
            aVar.Pt.lineTo((((float) aVar.Pw) * aVar.Pu) / 2.0f, ((float) aVar.Px) * aVar.Pu);
            aVar.Pt.offset((f + rectF.centerX()) - f4, rectF.centerY() + (aVar.uW / 2.0f));
            aVar.Pt.close();
            aVar.Pj.setColor(aVar.HD);
            aVar.Pj.setAlpha(aVar.mAlpha);
            canvas.save();
            canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
            canvas.drawPath(aVar.Pt, aVar.Pj);
            canvas.restore();
        }
        canvas.restore();
    }

    public final void setAlpha(int i) {
        this.Pd.mAlpha = i;
        invalidateSelf();
    }

    public final int getAlpha() {
        return this.Pd.mAlpha;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.Pd.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        return this.Cz.isRunning();
    }

    public final void start() {
        this.Cz.cancel();
        this.Pd.eB();
        if (this.Pd.Pm != this.Pd.Pl) {
            this.Pf = true;
            this.Cz.setDuration(666);
            this.Cz.start();
            return;
        }
        this.Pd.aR(0);
        this.Pd.eC();
        this.Cz.setDuration(1332);
        this.Cz.start();
    }

    public final void stop() {
        this.Cz.cancel();
        this.nR = 0.0f;
        this.Pd.I(false);
        this.Pd.aR(0);
        this.Pd.eC();
        invalidateSelf();
    }

    private static void a(float f, a aVar) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int eA = aVar.eA();
            int i = aVar.Pn[aVar.ez()];
            int i2 = (eA >> 24) & 255;
            int i3 = (eA >> 16) & 255;
            int i4 = (eA >> 8) & 255;
            eA &= 255;
            aVar.HD = (((int) (f2 * ((float) ((i & 255) - eA)))) + eA) | ((((i2 + ((int) (((float) (((i >> 24) & 255) - i2)) * f2))) << 24) | ((i3 + ((int) (((float) (((i >> 16) & 255) - i3)) * f2))) << 16)) | ((((int) (((float) (((i >> 8) & 255) - i4)) * f2)) + i4) << 8));
            return;
        }
        aVar.HD = aVar.eA();
    }
}
