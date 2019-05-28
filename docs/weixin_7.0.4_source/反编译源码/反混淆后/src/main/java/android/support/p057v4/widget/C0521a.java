package android.support.p057v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.p057v4.view.C0477s;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.widget.a */
public abstract class C0521a implements OnTouchListener {
    /* renamed from: OJ */
    private static final int f682OJ = ViewConfiguration.getTapTimeout();
    /* renamed from: OA */
    private float[] f683OA = new float[]{0.0f, 0.0f};
    /* renamed from: OB */
    private float[] f684OB = new float[]{0.0f, 0.0f};
    /* renamed from: OC */
    private float[] f685OC = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    /* renamed from: OD */
    private boolean f686OD;
    /* renamed from: OE */
    boolean f687OE;
    /* renamed from: OF */
    boolean f688OF;
    /* renamed from: OG */
    boolean f689OG;
    /* renamed from: OH */
    private boolean f690OH;
    /* renamed from: OI */
    private boolean f691OI;
    /* renamed from: Ot */
    final C0519a f692Ot = new C0519a();
    /* renamed from: Ou */
    private final Interpolator f693Ou = new AccelerateInterpolator();
    /* renamed from: Ov */
    final View f694Ov;
    /* renamed from: Ow */
    private float[] f695Ow = new float[]{0.0f, 0.0f};
    /* renamed from: Ox */
    private float[] f696Ox = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    /* renamed from: Oy */
    private int f697Oy;
    /* renamed from: Oz */
    private int f698Oz;
    private Runnable mRunnable;

    /* renamed from: android.support.v4.widget.a$a */
    static class C0519a {
        /* renamed from: OL */
        int f671OL;
        /* renamed from: OM */
        int f672OM;
        /* renamed from: OO */
        float f673OO;
        /* renamed from: OP */
        float f674OP;
        /* renamed from: OQ */
        long f675OQ = 0;
        /* renamed from: OR */
        long f676OR = -1;
        /* renamed from: OS */
        float f677OS;
        /* renamed from: OT */
        int f678OT;
        long mStartTime = Long.MIN_VALUE;
        /* renamed from: yH */
        int f679yH = 0;
        /* renamed from: yI */
        int f680yI = 0;

        C0519a() {
        }

        /* renamed from: ev */
        public final void mo1274ev() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.f678OT = C0521a.m1118x((int) (currentAnimationTimeMillis - this.mStartTime), this.f672OM);
            this.f677OS = mo1277n(currentAnimationTimeMillis);
            this.f676OR = currentAnimationTimeMillis;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: n */
        public final float mo1277n(long j) {
            if (j < this.mStartTime) {
                return 0.0f;
            }
            if (this.f676OR < 0 || j < this.f676OR) {
                return C0521a.m1115d(((float) (j - this.mStartTime)) / ((float) this.f671OL), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.f676OR;
            return (C0521a.m1115d(((float) j2) / ((float) this.f678OT), 0.0f, 1.0f) * this.f677OS) + (1.0f - this.f677OS);
        }

        /* renamed from: ew */
        public final int mo1275ew() {
            return (int) (this.f673OO / Math.abs(this.f673OO));
        }

        /* renamed from: ex */
        public final int mo1276ex() {
            return (int) (this.f674OP / Math.abs(this.f674OP));
        }
    }

    /* renamed from: android.support.v4.widget.a$b */
    class C0520b implements Runnable {
        C0520b() {
        }

        public final void run() {
            if (C0521a.this.f689OG) {
                boolean z;
                if (C0521a.this.f687OE) {
                    C0521a.this.f687OE = false;
                    C0519a c0519a = C0521a.this.f692Ot;
                    c0519a.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    c0519a.f676OR = -1;
                    c0519a.f675OQ = c0519a.mStartTime;
                    c0519a.f677OS = 0.5f;
                    c0519a.f679yH = 0;
                    c0519a.f680yI = 0;
                }
                C0519a c0519a2 = C0521a.this.f692Ot;
                if (c0519a2.f676OR <= 0 || AnimationUtils.currentAnimationTimeMillis() <= c0519a2.f676OR + ((long) c0519a2.f678OT)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z || !C0521a.this.mo1282bG()) {
                    C0521a.this.f689OG = false;
                    return;
                }
                long uptimeMillis;
                if (C0521a.this.f688OF) {
                    C0521a.this.f688OF = false;
                    C0521a c0521a = C0521a.this;
                    uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    c0521a.f694Ov.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (c0519a2.f675OQ == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                uptimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float n = c0519a2.mo1277n(uptimeMillis);
                n = (n * 4.0f) + ((-4.0f * n) * n);
                long j = uptimeMillis - c0519a2.f675OQ;
                c0519a2.f675OQ = uptimeMillis;
                c0519a2.f679yH = (int) ((((float) j) * n) * c0519a2.f673OO);
                c0519a2.f680yI = (int) ((((float) j) * n) * c0519a2.f674OP);
                C0521a.this.mo1280aN(c0519a2.f680yI);
                C0477s.m934b(C0521a.this.f694Ov, (Runnable) this);
            }
        }
    }

    /* renamed from: aN */
    public abstract void mo1280aN(int i);

    /* renamed from: aO */
    public abstract boolean mo1281aO(int i);

    public C0521a(View view) {
        this.f694Ov = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        this.f685OC[0] = f / 1000.0f;
        this.f685OC[1] = f / 1000.0f;
        float f2 = (float) i2;
        this.f684OB[0] = f2 / 1000.0f;
        this.f684OB[1] = f2 / 1000.0f;
        this.f697Oy = 1;
        this.f696Ox[0] = Float.MAX_VALUE;
        this.f696Ox[1] = Float.MAX_VALUE;
        this.f695Ow[0] = 0.2f;
        this.f695Ow[1] = 0.2f;
        this.f683OA[0] = 0.001f;
        this.f683OA[1] = 0.001f;
        this.f698Oz = f682OJ;
        this.f692Ot.f671OL = 500;
        this.f692Ot.f672OM = 500;
    }

    /* renamed from: G */
    public final C0521a mo1279G(boolean z) {
        if (this.f690OH && !z) {
            m1116ev();
        }
        this.f690OH = z;
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.f690OH) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f688OF = true;
                this.f686OD = false;
                break;
            case 1:
            case 3:
                m1116ev();
                break;
            case 2:
                break;
        }
        float a = m1113a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.f694Ov.getWidth());
        float a2 = m1113a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.f694Ov.getHeight());
        C0519a c0519a = this.f692Ot;
        c0519a.f673OO = a;
        c0519a.f674OP = a2;
        if (!this.f689OG && mo1282bG()) {
            if (this.mRunnable == null) {
                this.mRunnable = new C0520b();
            }
            this.f689OG = true;
            this.f687OE = true;
            if (this.f686OD || this.f698Oz <= 0) {
                this.mRunnable.run();
            } else {
                C0477s.m908a(this.f694Ov, this.mRunnable, (long) this.f698Oz);
            }
            this.f686OD = true;
        }
        if (this.f691OI && this.f689OG) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bG */
    public final boolean mo1282bG() {
        C0519a c0519a = this.f692Ot;
        int ex = c0519a.mo1276ex();
        int ew = c0519a.mo1275ew();
        if (ex != 0 && mo1281aO(ex)) {
            return true;
        }
        if (ew != 0) {
        }
        return false;
    }

    /* renamed from: ev */
    private void m1116ev() {
        if (this.f687OE) {
            this.f689OG = false;
        } else {
            this.f692Ot.mo1274ev();
        }
    }

    /* renamed from: a */
    private float m1113a(int i, float f, float f2, float f3) {
        float c = m1114c(this.f695Ow[i], f2, this.f696Ox[i], f);
        if (c == 0.0f) {
            return 0.0f;
        }
        float f4 = this.f683OA[i];
        float f5 = this.f684OB[i];
        float f6 = this.f685OC[i];
        f4 *= f3;
        if (c > 0.0f) {
            return C0521a.m1115d(c * f4, f5, f6);
        }
        return -C0521a.m1115d((-c) * f4, f5, f6);
    }

    /* renamed from: c */
    private float m1114c(float f, float f2, float f3, float f4) {
        float f5;
        float d = C0521a.m1115d(f * f2, 0.0f, f3);
        d = m1117t(f2 - f4, d) - m1117t(f4, d);
        if (d < 0.0f) {
            f5 = -this.f693Ou.getInterpolation(-d);
        } else if (d <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.f693Ou.getInterpolation(d);
        }
        return C0521a.m1115d(f5, -1.0f, 1.0f);
    }

    /* renamed from: t */
    private float m1117t(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.f697Oy) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.f689OG && this.f697Oy == 1) {
                    return 1.0f;
                }
                return 0.0f;
            case 2:
                if (f < 0.0f) {
                    return f / (-f2);
                }
                return 0.0f;
            default:
                return 0.0f;
        }
    }

    /* renamed from: x */
    static int m1118x(int i, int i2) {
        if (i > i2) {
            return i2;
        }
        return i < 0 ? 0 : i;
    }

    /* renamed from: d */
    static float m1115d(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }
}
