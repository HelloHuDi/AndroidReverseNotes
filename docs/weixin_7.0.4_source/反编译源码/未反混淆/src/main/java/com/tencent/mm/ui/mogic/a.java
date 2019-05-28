package com.tencent.mm.ui.mogic;

import android.content.Context;
import android.support.v4.widget.p;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Arrays;

public final class a {
    private static final Interpolator sInterpolator = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    public int SG;
    public float[] SH;
    public float[] SI;
    public float[] SJ;
    public float[] SK;
    public int[] SL;
    private int[] SM;
    private int[] SN;
    public int SO;
    public float SP;
    public float SQ;
    private int SR;
    public int SS;
    public View SU;
    public boolean SV;
    public final ViewGroup SW;
    public final Runnable SX = new Runnable() {
        public final void run() {
            AppMethodBeat.i(107432);
            a.this.ba(0);
            AppMethodBeat.o(107432);
        }
    };
    public p jlU;
    public int mActivePointerId = -1;
    private int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public final a zzE;

    public static abstract class a {
        public abstract boolean PG(int i);

        public void N(int i) {
        }

        public void ht(int i, int i2) {
        }

        public void a(View view, float f, float f2) {
        }

        public int dJm() {
            return 0;
        }

        public int d(View view, int i) {
            return 0;
        }
    }

    static {
        AppMethodBeat.i(107452);
        AppMethodBeat.o(107452);
    }

    public static a a(ViewGroup viewGroup, a aVar, Interpolator interpolator) {
        AppMethodBeat.i(107433);
        a aVar2 = new a(viewGroup.getContext(), viewGroup, aVar, interpolator);
        AppMethodBeat.o(107433);
        return aVar2;
    }

    private a(Context context, ViewGroup viewGroup, a aVar, Interpolator interpolator) {
        AppMethodBeat.i(107434);
        IllegalArgumentException illegalArgumentException;
        if (viewGroup == null) {
            illegalArgumentException = new IllegalArgumentException("Parent view may not be null");
            AppMethodBeat.o(107434);
            throw illegalArgumentException;
        } else if (aVar == null) {
            illegalArgumentException = new IllegalArgumentException("Callback may not be null");
            AppMethodBeat.o(107434);
            throw illegalArgumentException;
        } else {
            this.SW = viewGroup;
            this.zzE = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.SR = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.SP = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.SQ = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.jlU = p.a(context, interpolator);
            AppMethodBeat.o(107434);
        }
    }

    public final void cancel() {
        AppMethodBeat.i(107435);
        this.mActivePointerId = -1;
        if (this.SH != null) {
            Arrays.fill(this.SH, 0.0f);
            Arrays.fill(this.SI, 0.0f);
            Arrays.fill(this.SJ, 0.0f);
            Arrays.fill(this.SK, 0.0f);
            Arrays.fill(this.SL, 0);
            Arrays.fill(this.SM, 0);
            Arrays.fill(this.SN, 0);
            this.SO = 0;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(107435);
    }

    public final boolean b(int i, int i2, int i3, int i4, long j) {
        AppMethodBeat.i(107436);
        int left = this.SU.getLeft();
        int top = this.SU.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.jlU.qN.abortAnimation();
            ba(0);
            AppMethodBeat.o(107436);
            return false;
        }
        if (j == 0) {
            j = (long) K(i5, i6, i3, i4);
        }
        ab.d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j));
        this.jlU.startScroll(left, top, i5, i6, (int) j);
        ba(2);
        AppMethodBeat.o(107436);
        return true;
    }

    private int K(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107437);
        int i5 = i(i3, (int) this.SQ, (int) this.SP);
        int i6 = i(i4, (int) this.SQ, (int) this.SP);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(i5);
        int abs4 = Math.abs(i6);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        abs = (int) (((i6 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) h(i2, i6, 0))) + ((i5 != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) h(i, i5, this.zzE.dJm()))));
        AppMethodBeat.o(107437);
        return abs;
    }

    private int h(int i, int i2, int i3) {
        AppMethodBeat.i(107438);
        if (i == 0) {
            AppMethodBeat.o(107438);
            return 0;
        }
        int width = this.SW.getWidth();
        int i4 = width / 2;
        float distanceInfluenceForSnapDuration = (distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        width = Math.min(width, 600);
        AppMethodBeat.o(107438);
        return width;
    }

    private static int i(int i, int i2, int i3) {
        AppMethodBeat.i(107439);
        int abs = Math.abs(i);
        if (abs < i2) {
            AppMethodBeat.o(107439);
            return 0;
        } else if (abs <= i3) {
            AppMethodBeat.o(107439);
            return i;
        } else if (i > 0) {
            AppMethodBeat.o(107439);
            return i3;
        } else {
            i3 = -i3;
            AppMethodBeat.o(107439);
            return i3;
        }
    }

    private static float e(float f, float f2, float f3) {
        AppMethodBeat.i(107440);
        float abs = Math.abs(f);
        if (abs < f2) {
            AppMethodBeat.o(107440);
            return 0.0f;
        } else if (abs <= f3) {
            AppMethodBeat.o(107440);
            return f;
        } else if (f > 0.0f) {
            AppMethodBeat.o(107440);
            return f3;
        } else {
            f3 = -f3;
            AppMethodBeat.o(107440);
            return f3;
        }
    }

    private static float distanceInfluenceForSnapDuration(float f) {
        AppMethodBeat.i(107441);
        float sin = (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.o(107441);
        return sin;
    }

    public final void u(float f, float f2) {
        AppMethodBeat.i(107442);
        this.SV = true;
        this.zzE.a(this.SU, f, f2);
        this.SV = false;
        if (this.SG == 1) {
            ba(0);
        }
        AppMethodBeat.o(107442);
    }

    public final void aY(int i) {
        if (this.SH != null) {
            this.SH[i] = 0.0f;
            this.SI[i] = 0.0f;
            this.SJ[i] = 0.0f;
            this.SK[i] = 0.0f;
            this.SL[i] = 0;
            this.SM[i] = 0;
            this.SN[i] = 0;
            this.SO &= (1 << i) ^ -1;
        }
    }

    /* Access modifiers changed, original: final */
    public final void ba(int i) {
        AppMethodBeat.i(107445);
        if (this.SG != i) {
            this.SG = i;
            this.zzE.N(i);
            if (i == 0) {
                this.SU = null;
            }
        }
        AppMethodBeat.o(107445);
    }

    public final boolean v(View view, int i) {
        AppMethodBeat.i(107446);
        if (view == this.SU && this.mActivePointerId == i) {
            AppMethodBeat.o(107446);
            return true;
        } else if (view == null || !this.zzE.PG(i)) {
            AppMethodBeat.o(107446);
            return false;
        } else {
            this.mActivePointerId = i;
            if (view.getParent() != this.SW) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.SW + ")");
                AppMethodBeat.o(107446);
                throw illegalArgumentException;
            }
            this.SU = view;
            this.mActivePointerId = i;
            ba(1);
            AppMethodBeat.o(107446);
            return true;
        }
    }

    public final void b(float f, float f2, int i) {
        int i2 = 1;
        AppMethodBeat.i(107447);
        if (!a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.SM;
            iArr[i] = i2 | iArr[i];
        }
        AppMethodBeat.o(107447);
    }

    private boolean a(float f, float f2, int i, int i2) {
        AppMethodBeat.i(107448);
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.SL[i] & i2) != i2 || (this.SS & i2) == 0 || (this.SN[i] & i2) == i2 || (this.SM[i] & i2) == i2 || (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop))) {
            AppMethodBeat.o(107448);
            return false;
        } else if ((this.SM[i] & i2) != 0 || abs <= ((float) this.mTouchSlop)) {
            AppMethodBeat.o(107448);
            return false;
        } else {
            AppMethodBeat.o(107448);
            return true;
        }
    }

    public final boolean q(View view, float f) {
        AppMethodBeat.i(107449);
        if (view == null) {
            AppMethodBeat.o(107449);
            return false;
        }
        if (!(this.zzE.dJm() > 0)) {
            AppMethodBeat.o(107449);
            return false;
        } else if (Math.abs(f) > ((float) this.mTouchSlop)) {
            AppMethodBeat.o(107449);
            return true;
        } else {
            AppMethodBeat.o(107449);
            return false;
        }
    }

    public final void eZ() {
        AppMethodBeat.i(107450);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.SP);
        u(e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.SQ, this.SP), e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.SQ, this.SP));
        AppMethodBeat.o(107450);
    }

    public final View F(int i, int i2) {
        AppMethodBeat.i(107451);
        int childCount = this.SW.getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = this.SW.getChildAt(childCount);
            if (i < childAt.getLeft() || i >= childAt.getRight() || i2 < childAt.getTop() || i2 >= childAt.getBottom()) {
                childCount--;
            } else {
                AppMethodBeat.o(107451);
                return childAt;
            }
        }
        AppMethodBeat.o(107451);
        return null;
    }

    public final void a(float f, float f2, int i) {
        float[] fArr;
        int i2 = 0;
        AppMethodBeat.i(107443);
        if (this.SH == null || this.SH.length <= i) {
            fArr = new float[(i + 1)];
            float[] fArr2 = new float[(i + 1)];
            float[] fArr3 = new float[(i + 1)];
            float[] fArr4 = new float[(i + 1)];
            int[] iArr = new int[(i + 1)];
            int[] iArr2 = new int[(i + 1)];
            int[] iArr3 = new int[(i + 1)];
            if (this.SH != null) {
                System.arraycopy(this.SH, 0, fArr, 0, this.SH.length);
                System.arraycopy(this.SI, 0, fArr2, 0, this.SI.length);
                System.arraycopy(this.SJ, 0, fArr3, 0, this.SJ.length);
                System.arraycopy(this.SK, 0, fArr4, 0, this.SK.length);
                System.arraycopy(this.SL, 0, iArr, 0, this.SL.length);
                System.arraycopy(this.SM, 0, iArr2, 0, this.SM.length);
                System.arraycopy(this.SN, 0, iArr3, 0, this.SN.length);
            }
            this.SH = fArr;
            this.SI = fArr2;
            this.SJ = fArr3;
            this.SK = fArr4;
            this.SL = iArr;
            this.SM = iArr2;
            this.SN = iArr3;
        }
        fArr = this.SH;
        this.SJ[i] = f;
        fArr[i] = f;
        fArr = this.SI;
        this.SK[i] = f2;
        fArr[i] = f2;
        int[] iArr4 = this.SL;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.SW.getLeft() + this.SR) {
            i2 = 1;
        }
        if (i4 < this.SW.getTop() + this.SR) {
            i2 |= 4;
        }
        if (i3 > this.SW.getRight() - this.SR) {
            i2 |= 2;
        }
        if (i4 > this.SW.getBottom() - this.SR) {
            i2 |= 8;
        }
        iArr4[i] = i2;
        this.SO |= 1 << i;
        AppMethodBeat.o(107443);
    }

    public final void e(MotionEvent motionEvent) {
        AppMethodBeat.i(107444);
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            this.SJ[pointerId] = x;
            this.SK[pointerId] = y;
        }
        AppMethodBeat.o(107444);
    }
}
