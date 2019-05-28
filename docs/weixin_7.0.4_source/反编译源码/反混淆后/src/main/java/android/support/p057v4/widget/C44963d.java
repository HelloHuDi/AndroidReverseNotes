package android.support.p057v4.widget;

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
import android.support.p057v4.p065f.C0416l;
import android.support.p057v4.view.p068b.C6199b;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.smtt.sdk.WebView;

/* renamed from: android.support.v4.widget.d */
public final class C44963d extends Drawable implements Animatable {
    /* renamed from: Pb */
    private static final Interpolator f17698Pb = new C6199b();
    /* renamed from: Pc */
    private static final int[] f17699Pc = new int[]{WebView.NIGHT_MODE_COLOR};
    /* renamed from: mf */
    private static final Interpolator f17700mf = new LinearInterpolator();
    /* renamed from: Cz */
    private Animator f17701Cz;
    /* renamed from: Pd */
    final C37134a f17702Pd = new C37134a();
    /* renamed from: Pe */
    private float f17703Pe;
    /* renamed from: Pf */
    private boolean f17704Pf;
    private Resources mResources;
    /* renamed from: nR */
    private float f17705nR;

    /* renamed from: android.support.v4.widget.d$a */
    static class C37134a {
        /* renamed from: HD */
        int f15807HD;
        /* renamed from: Pi */
        final RectF f15808Pi = new RectF();
        /* renamed from: Pj */
        final Paint f15809Pj = new Paint();
        /* renamed from: Pk */
        final Paint f15810Pk = new Paint();
        /* renamed from: Pl */
        float f15811Pl = 0.0f;
        /* renamed from: Pm */
        float f15812Pm = 0.0f;
        /* renamed from: Pn */
        int[] f15813Pn;
        /* renamed from: Po */
        int f15814Po;
        /* renamed from: Pp */
        float f15815Pp;
        /* renamed from: Pq */
        float f15816Pq;
        /* renamed from: Pr */
        float f15817Pr;
        /* renamed from: Ps */
        boolean f15818Ps;
        /* renamed from: Pt */
        Path f15819Pt;
        /* renamed from: Pu */
        float f15820Pu = 1.0f;
        /* renamed from: Pv */
        float f15821Pv;
        /* renamed from: Pw */
        int f15822Pw;
        /* renamed from: Px */
        int f15823Px;
        int mAlpha = 255;
        final Paint mPaint = new Paint();
        /* renamed from: nR */
        float f15824nR = 0.0f;
        /* renamed from: uW */
        float f15825uW = 5.0f;

        C37134a() {
            this.mPaint.setStrokeCap(Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Style.STROKE);
            this.f15809Pj.setStyle(Style.FILL);
            this.f15809Pj.setAntiAlias(true);
            this.f15810Pk.setColor(0);
        }

        /* Access modifiers changed, original: final */
        public final void setColors(int[] iArr) {
            this.f15813Pn = iArr;
            mo59194aR(0);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: aR */
        public final void mo59194aR(int i) {
            this.f15814Po = i;
            this.f15807HD = this.f15813Pn[this.f15814Po];
        }

        /* Access modifiers changed, original: final */
        /* renamed from: ez */
        public final int mo59198ez() {
            return (this.f15814Po + 1) % this.f15813Pn.length;
        }

        /* Access modifiers changed, original: final */
        public final void setStrokeWidth(float f) {
            this.f15825uW = f;
            this.mPaint.setStrokeWidth(f);
        }

        /* Access modifiers changed, original: final */
        /* renamed from: eA */
        public final int mo59195eA() {
            return this.f15813Pn[this.f15814Po];
        }

        /* Access modifiers changed, original: final */
        /* renamed from: I */
        public final void mo59193I(boolean z) {
            if (this.f15818Ps != z) {
                this.f15818Ps = z;
            }
        }

        /* Access modifiers changed, original: final */
        /* renamed from: eB */
        public final void mo59196eB() {
            this.f15815Pp = this.f15811Pl;
            this.f15816Pq = this.f15812Pm;
            this.f15817Pr = this.f15824nR;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: eC */
        public final void mo59197eC() {
            this.f15815Pp = 0.0f;
            this.f15816Pq = 0.0f;
            this.f15817Pr = 0.0f;
            this.f15811Pl = 0.0f;
            this.f15812Pm = 0.0f;
            this.f15824nR = 0.0f;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m82270a(C44963d c44963d, float f, C37134a c37134a, boolean z) {
        float floor;
        if (c44963d.f17704Pf) {
            C44963d.m82269a(f, c37134a);
            floor = (float) (Math.floor((double) (c37134a.f15817Pr / 0.8f)) + 1.0d);
            c37134a.f15811Pl = c37134a.f15815Pp + (((c37134a.f15816Pq - 0.01f) - c37134a.f15815Pp) * f);
            c37134a.f15812Pm = c37134a.f15816Pq;
            c37134a.f15824nR = ((floor - c37134a.f15817Pr) * f) + c37134a.f15817Pr;
        } else if (f != 1.0f || z) {
            float f2;
            float f3 = c37134a.f15817Pr;
            if (f < 0.5f) {
                floor = f / 0.5f;
                f2 = c37134a.f15815Pp;
                floor = ((f17698Pb.getInterpolation(floor) * 0.79f) + 0.01f) + f2;
            } else {
                floor = c37134a.f15815Pp + 0.79f;
                f2 = floor - (((1.0f - f17698Pb.getInterpolation((f - 0.5f) / 0.5f)) * 0.79f) + 0.01f);
            }
            f3 += 0.20999998f * f;
            float f4 = 216.0f * (c44963d.f17703Pe + f);
            c37134a.f15811Pl = f2;
            c37134a.f15812Pm = floor;
            c37134a.f15824nR = f3;
            c44963d.f17705nR = f4;
        }
    }

    public C44963d(Context context) {
        this.mResources = ((Context) C0416l.checkNotNull(context)).getResources();
        this.f17702Pd.setColors(f17699Pc);
        this.f17702Pd.setStrokeWidth(2.5f);
        invalidateSelf();
        final C37134a c37134a = this.f17702Pd;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                C44963d.m82269a(floatValue, c37134a);
                C44963d.m82270a(C44963d.this, floatValue, c37134a, false);
                C44963d.this.invalidateSelf();
            }
        });
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ofFloat.setInterpolator(f17700mf);
        ofFloat.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                C44963d.this.f17703Pe = 0.0f;
            }

            public final void onAnimationEnd(Animator animator) {
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
                C44963d.m82270a(C44963d.this, 1.0f, c37134a, true);
                c37134a.mo59196eB();
                C37134a c37134a = c37134a;
                c37134a.mo59194aR(c37134a.mo59198ez());
                if (C44963d.this.f17704Pf) {
                    C44963d.this.f17704Pf = false;
                    animator.cancel();
                    animator.setDuration(1332);
                    animator.start();
                    c37134a.mo59193I(false);
                    return;
                }
                C44963d.this.f17703Pe = C44963d.this.f17703Pe + 1.0f;
            }
        });
        this.f17701Cz = ofFloat;
    }

    /* renamed from: d */
    private void m82275d(float f, float f2, float f3, float f4) {
        C37134a c37134a = this.f17702Pd;
        float f5 = this.mResources.getDisplayMetrics().density;
        c37134a.setStrokeWidth(f2 * f5);
        c37134a.f15821Pv = f * f5;
        c37134a.mo59194aR(0);
        float f6 = f3 * f5;
        f5 *= f4;
        c37134a.f15822Pw = (int) f6;
        c37134a.f15823Px = (int) f5;
    }

    /* renamed from: aQ */
    public final void mo72182aQ(int i) {
        if (i == 0) {
            m82275d(11.0f, 3.0f, 12.0f, 6.0f);
        } else {
            m82275d(7.5f, 2.5f, 10.0f, 5.0f);
        }
        invalidateSelf();
    }

    /* renamed from: H */
    public final void mo72181H(boolean z) {
        this.f17702Pd.mo59193I(z);
        invalidateSelf();
    }

    /* renamed from: B */
    public final void mo72178B(float f) {
        C37134a c37134a = this.f17702Pd;
        if (f != c37134a.f15820Pu) {
            c37134a.f15820Pu = f;
        }
        invalidateSelf();
    }

    /* renamed from: C */
    public final void mo72179C(float f) {
        this.f17702Pd.f15811Pl = 0.0f;
        this.f17702Pd.f15812Pm = f;
        invalidateSelf();
    }

    /* renamed from: D */
    public final void mo72180D(float f) {
        this.f17702Pd.f15824nR = f;
        invalidateSelf();
    }

    public final void draw(Canvas canvas) {
        Rect bounds = getBounds();
        canvas.save();
        canvas.rotate(this.f17705nR, bounds.exactCenterX(), bounds.exactCenterY());
        C37134a c37134a = this.f17702Pd;
        RectF rectF = c37134a.f15808Pi;
        float f = c37134a.f15821Pv + (c37134a.f15825uW / 2.0f);
        if (c37134a.f15821Pv <= 0.0f) {
            f = (((float) Math.min(bounds.width(), bounds.height())) / 2.0f) - Math.max((((float) c37134a.f15822Pw) * c37134a.f15820Pu) / 2.0f, c37134a.f15825uW / 2.0f);
        }
        rectF.set(((float) bounds.centerX()) - f, ((float) bounds.centerY()) - f, ((float) bounds.centerX()) + f, f + ((float) bounds.centerY()));
        float f2 = (c37134a.f15811Pl + c37134a.f15824nR) * 360.0f;
        float f3 = ((c37134a.f15812Pm + c37134a.f15824nR) * 360.0f) - f2;
        c37134a.mPaint.setColor(c37134a.f15807HD);
        c37134a.mPaint.setAlpha(c37134a.mAlpha);
        f = c37134a.f15825uW / 2.0f;
        rectF.inset(f, f);
        canvas.drawCircle(rectF.centerX(), rectF.centerY(), rectF.width() / 2.0f, c37134a.f15810Pk);
        rectF.inset(-f, -f);
        canvas.drawArc(rectF, f2, f3, false, c37134a.mPaint);
        if (c37134a.f15818Ps) {
            if (c37134a.f15819Pt == null) {
                c37134a.f15819Pt = new Path();
                c37134a.f15819Pt.setFillType(FillType.EVEN_ODD);
            } else {
                c37134a.f15819Pt.reset();
            }
            f = Math.min(rectF.width(), rectF.height()) / 2.0f;
            float f4 = (((float) c37134a.f15822Pw) * c37134a.f15820Pu) / 2.0f;
            c37134a.f15819Pt.moveTo(0.0f, 0.0f);
            c37134a.f15819Pt.lineTo(((float) c37134a.f15822Pw) * c37134a.f15820Pu, 0.0f);
            c37134a.f15819Pt.lineTo((((float) c37134a.f15822Pw) * c37134a.f15820Pu) / 2.0f, ((float) c37134a.f15823Px) * c37134a.f15820Pu);
            c37134a.f15819Pt.offset((f + rectF.centerX()) - f4, rectF.centerY() + (c37134a.f15825uW / 2.0f));
            c37134a.f15819Pt.close();
            c37134a.f15809Pj.setColor(c37134a.f15807HD);
            c37134a.f15809Pj.setAlpha(c37134a.mAlpha);
            canvas.save();
            canvas.rotate(f2 + f3, rectF.centerX(), rectF.centerY());
            canvas.drawPath(c37134a.f15819Pt, c37134a.f15809Pj);
            canvas.restore();
        }
        canvas.restore();
    }

    public final void setAlpha(int i) {
        this.f17702Pd.mAlpha = i;
        invalidateSelf();
    }

    public final int getAlpha() {
        return this.f17702Pd.mAlpha;
    }

    public final void setColorFilter(ColorFilter colorFilter) {
        this.f17702Pd.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    public final int getOpacity() {
        return -3;
    }

    public final boolean isRunning() {
        return this.f17701Cz.isRunning();
    }

    public final void start() {
        this.f17701Cz.cancel();
        this.f17702Pd.mo59196eB();
        if (this.f17702Pd.f15812Pm != this.f17702Pd.f15811Pl) {
            this.f17704Pf = true;
            this.f17701Cz.setDuration(666);
            this.f17701Cz.start();
            return;
        }
        this.f17702Pd.mo59194aR(0);
        this.f17702Pd.mo59197eC();
        this.f17701Cz.setDuration(1332);
        this.f17701Cz.start();
    }

    public final void stop() {
        this.f17701Cz.cancel();
        this.f17705nR = 0.0f;
        this.f17702Pd.mo59193I(false);
        this.f17702Pd.mo59194aR(0);
        this.f17702Pd.mo59197eC();
        invalidateSelf();
    }

    /* renamed from: a */
    private static void m82269a(float f, C37134a c37134a) {
        if (f > 0.75f) {
            float f2 = (f - 0.75f) / 0.25f;
            int eA = c37134a.mo59195eA();
            int i = c37134a.f15813Pn[c37134a.mo59198ez()];
            int i2 = (eA >> 24) & 255;
            int i3 = (eA >> 16) & 255;
            int i4 = (eA >> 8) & 255;
            eA &= 255;
            c37134a.f15807HD = (((int) (f2 * ((float) ((i & 255) - eA)))) + eA) | ((((i2 + ((int) (((float) (((i >> 24) & 255) - i2)) * f2))) << 24) | ((i3 + ((int) (((float) (((i >> 16) & 255) - i3)) * f2))) << 16)) | ((((int) (((float) (((i >> 8) & 255) - i4)) * f2)) + i4) << 8));
            return;
        }
        c37134a.f15807HD = c37134a.mo59195eA();
    }
}
