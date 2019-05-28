package android.support.v4.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.support.v4.view.s;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public abstract class a implements OnTouchListener {
    private static final int OJ = ViewConfiguration.getTapTimeout();
    private float[] OA = new float[]{0.0f, 0.0f};
    private float[] OB = new float[]{0.0f, 0.0f};
    private float[] OC = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private boolean OD;
    boolean OE;
    boolean OF;
    boolean OG;
    private boolean OH;
    private boolean OI;
    final a Ot = new a();
    private final Interpolator Ou = new AccelerateInterpolator();
    final View Ov;
    private float[] Ow = new float[]{0.0f, 0.0f};
    private float[] Ox = new float[]{Float.MAX_VALUE, Float.MAX_VALUE};
    private int Oy;
    private int Oz;
    private Runnable mRunnable;

    static class a {
        int OL;
        int OM;
        float OO;
        float OP;
        long OQ = 0;
        long OR = -1;
        float OS;
        int OT;
        long mStartTime = Long.MIN_VALUE;
        int yH = 0;
        int yI = 0;

        a() {
        }

        public final void ev() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.OT = a.x((int) (currentAnimationTimeMillis - this.mStartTime), this.OM);
            this.OS = n(currentAnimationTimeMillis);
            this.OR = currentAnimationTimeMillis;
        }

        /* Access modifiers changed, original: final */
        public final float n(long j) {
            if (j < this.mStartTime) {
                return 0.0f;
            }
            if (this.OR < 0 || j < this.OR) {
                return a.d(((float) (j - this.mStartTime)) / ((float) this.OL), 0.0f, 1.0f) * 0.5f;
            }
            long j2 = j - this.OR;
            return (a.d(((float) j2) / ((float) this.OT), 0.0f, 1.0f) * this.OS) + (1.0f - this.OS);
        }

        public final int ew() {
            return (int) (this.OO / Math.abs(this.OO));
        }

        public final int ex() {
            return (int) (this.OP / Math.abs(this.OP));
        }
    }

    class b implements Runnable {
        b() {
        }

        public final void run() {
            if (a.this.OG) {
                boolean z;
                if (a.this.OE) {
                    a.this.OE = false;
                    a aVar = a.this.Ot;
                    aVar.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                    aVar.OR = -1;
                    aVar.OQ = aVar.mStartTime;
                    aVar.OS = 0.5f;
                    aVar.yH = 0;
                    aVar.yI = 0;
                }
                a aVar2 = a.this.Ot;
                if (aVar2.OR <= 0 || AnimationUtils.currentAnimationTimeMillis() <= aVar2.OR + ((long) aVar2.OT)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z || !a.this.bG()) {
                    a.this.OG = false;
                    return;
                }
                long uptimeMillis;
                if (a.this.OF) {
                    a.this.OF = false;
                    a aVar3 = a.this;
                    uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    aVar3.Ov.onTouchEvent(obtain);
                    obtain.recycle();
                }
                if (aVar2.OQ == 0) {
                    throw new RuntimeException("Cannot compute scroll delta before calling start()");
                }
                uptimeMillis = AnimationUtils.currentAnimationTimeMillis();
                float n = aVar2.n(uptimeMillis);
                n = (n * 4.0f) + ((-4.0f * n) * n);
                long j = uptimeMillis - aVar2.OQ;
                aVar2.OQ = uptimeMillis;
                aVar2.yH = (int) ((((float) j) * n) * aVar2.OO);
                aVar2.yI = (int) ((((float) j) * n) * aVar2.OP);
                a.this.aN(aVar2.yI);
                s.b(a.this.Ov, (Runnable) this);
            }
        }
    }

    public abstract void aN(int i);

    public abstract boolean aO(int i);

    public a(View view) {
        this.Ov = view;
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        int i = (int) ((1575.0f * displayMetrics.density) + 0.5f);
        int i2 = (int) ((displayMetrics.density * 315.0f) + 0.5f);
        float f = (float) i;
        this.OC[0] = f / 1000.0f;
        this.OC[1] = f / 1000.0f;
        float f2 = (float) i2;
        this.OB[0] = f2 / 1000.0f;
        this.OB[1] = f2 / 1000.0f;
        this.Oy = 1;
        this.Ox[0] = Float.MAX_VALUE;
        this.Ox[1] = Float.MAX_VALUE;
        this.Ow[0] = 0.2f;
        this.Ow[1] = 0.2f;
        this.OA[0] = 0.001f;
        this.OA[1] = 0.001f;
        this.Oz = OJ;
        this.Ot.OL = 500;
        this.Ot.OM = 500;
    }

    public final a G(boolean z) {
        if (this.OH && !z) {
            ev();
        }
        this.OH = z;
        return this;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.OH) {
            return false;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.OF = true;
                this.OD = false;
                break;
            case 1:
            case 3:
                ev();
                break;
            case 2:
                break;
        }
        float a = a(0, motionEvent.getX(), (float) view.getWidth(), (float) this.Ov.getWidth());
        float a2 = a(1, motionEvent.getY(), (float) view.getHeight(), (float) this.Ov.getHeight());
        a aVar = this.Ot;
        aVar.OO = a;
        aVar.OP = a2;
        if (!this.OG && bG()) {
            if (this.mRunnable == null) {
                this.mRunnable = new b();
            }
            this.OG = true;
            this.OE = true;
            if (this.OD || this.Oz <= 0) {
                this.mRunnable.run();
            } else {
                s.a(this.Ov, this.mRunnable, (long) this.Oz);
            }
            this.OD = true;
        }
        if (this.OI && this.OG) {
            return true;
        }
        return false;
    }

    /* Access modifiers changed, original: final */
    public final boolean bG() {
        a aVar = this.Ot;
        int ex = aVar.ex();
        int ew = aVar.ew();
        if (ex != 0 && aO(ex)) {
            return true;
        }
        if (ew != 0) {
        }
        return false;
    }

    private void ev() {
        if (this.OE) {
            this.OG = false;
        } else {
            this.Ot.ev();
        }
    }

    private float a(int i, float f, float f2, float f3) {
        float c = c(this.Ow[i], f2, this.Ox[i], f);
        if (c == 0.0f) {
            return 0.0f;
        }
        float f4 = this.OA[i];
        float f5 = this.OB[i];
        float f6 = this.OC[i];
        f4 *= f3;
        if (c > 0.0f) {
            return d(c * f4, f5, f6);
        }
        return -d((-c) * f4, f5, f6);
    }

    private float c(float f, float f2, float f3, float f4) {
        float f5;
        float d = d(f * f2, 0.0f, f3);
        d = t(f2 - f4, d) - t(f4, d);
        if (d < 0.0f) {
            f5 = -this.Ou.getInterpolation(-d);
        } else if (d <= 0.0f) {
            return 0.0f;
        } else {
            f5 = this.Ou.getInterpolation(d);
        }
        return d(f5, -1.0f, 1.0f);
    }

    private float t(float f, float f2) {
        if (f2 == 0.0f) {
            return 0.0f;
        }
        switch (this.Oy) {
            case 0:
            case 1:
                if (f >= f2) {
                    return 0.0f;
                }
                if (f >= 0.0f) {
                    return 1.0f - (f / f2);
                }
                if (this.OG && this.Oy == 1) {
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

    static int x(int i, int i2) {
        if (i > i2) {
            return i2;
        }
        return i < 0 ? 0 : i;
    }

    static float d(float f, float f2, float f3) {
        if (f > f3) {
            return f3;
        }
        if (f < f2) {
            return f2;
        }
        return f;
    }
}
