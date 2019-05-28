package com.tencent.p177mm.p612ui.mogic;

import android.content.Context;
import android.support.p057v4.widget.C0539p;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Arrays;

/* renamed from: com.tencent.mm.ui.mogic.a */
public final class C5516a {
    private static final Interpolator sInterpolator = new C55131();
    /* renamed from: SG */
    public int f1307SG;
    /* renamed from: SH */
    public float[] f1308SH;
    /* renamed from: SI */
    public float[] f1309SI;
    /* renamed from: SJ */
    public float[] f1310SJ;
    /* renamed from: SK */
    public float[] f1311SK;
    /* renamed from: SL */
    public int[] f1312SL;
    /* renamed from: SM */
    private int[] f1313SM;
    /* renamed from: SN */
    private int[] f1314SN;
    /* renamed from: SO */
    public int f1315SO;
    /* renamed from: SP */
    public float f1316SP;
    /* renamed from: SQ */
    public float f1317SQ;
    /* renamed from: SR */
    private int f1318SR;
    /* renamed from: SS */
    public int f1319SS;
    /* renamed from: SU */
    public View f1320SU;
    /* renamed from: SV */
    public boolean f1321SV;
    /* renamed from: SW */
    public final ViewGroup f1322SW;
    /* renamed from: SX */
    public final Runnable f1323SX = new C55142();
    public C0539p jlU;
    public int mActivePointerId = -1;
    private int mTouchSlop;
    public VelocityTracker mVelocityTracker;
    public final C5515a zzE;

    /* renamed from: com.tencent.mm.ui.mogic.a$1 */
    static class C55131 implements Interpolator {
        C55131() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.a$2 */
    class C55142 implements Runnable {
        C55142() {
        }

        public final void run() {
            AppMethodBeat.m2504i(107432);
            C5516a.this.mo11139ba(0);
            AppMethodBeat.m2505o(107432);
        }
    }

    /* renamed from: com.tencent.mm.ui.mogic.a$a */
    public static abstract class C5515a {
        /* renamed from: PG */
        public abstract boolean mo11129PG(int i);

        /* renamed from: N */
        public void mo11128N(int i) {
        }

        /* renamed from: ht */
        public void mo11133ht(int i, int i2) {
        }

        /* renamed from: a */
        public void mo11130a(View view, float f, float f2) {
        }

        public int dJm() {
            return 0;
        }

        /* renamed from: d */
        public int mo11131d(View view, int i) {
            return 0;
        }
    }

    static {
        AppMethodBeat.m2504i(107452);
        AppMethodBeat.m2505o(107452);
    }

    /* renamed from: a */
    public static C5516a m8303a(ViewGroup viewGroup, C5515a c5515a, Interpolator interpolator) {
        AppMethodBeat.m2504i(107433);
        C5516a c5516a = new C5516a(viewGroup.getContext(), viewGroup, c5515a, interpolator);
        AppMethodBeat.m2505o(107433);
        return c5516a;
    }

    private C5516a(Context context, ViewGroup viewGroup, C5515a c5515a, Interpolator interpolator) {
        AppMethodBeat.m2504i(107434);
        IllegalArgumentException illegalArgumentException;
        if (viewGroup == null) {
            illegalArgumentException = new IllegalArgumentException("Parent view may not be null");
            AppMethodBeat.m2505o(107434);
            throw illegalArgumentException;
        } else if (c5515a == null) {
            illegalArgumentException = new IllegalArgumentException("Callback may not be null");
            AppMethodBeat.m2505o(107434);
            throw illegalArgumentException;
        } else {
            this.f1322SW = viewGroup;
            this.zzE = c5515a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f1318SR = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.f1316SP = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f1317SQ = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.jlU = C0539p.m1164a(context, interpolator);
            AppMethodBeat.m2505o(107434);
        }
    }

    public final void cancel() {
        AppMethodBeat.m2504i(107435);
        this.mActivePointerId = -1;
        if (this.f1308SH != null) {
            Arrays.fill(this.f1308SH, 0.0f);
            Arrays.fill(this.f1309SI, 0.0f);
            Arrays.fill(this.f1310SJ, 0.0f);
            Arrays.fill(this.f1311SK, 0.0f);
            Arrays.fill(this.f1312SL, 0);
            Arrays.fill(this.f1313SM, 0);
            Arrays.fill(this.f1314SN, 0);
            this.f1315SO = 0;
        }
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.m2505o(107435);
    }

    /* renamed from: b */
    public final boolean mo11138b(int i, int i2, int i3, int i4, long j) {
        AppMethodBeat.m2504i(107436);
        int left = this.f1320SU.getLeft();
        int top = this.f1320SU.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.jlU.f710qN.abortAnimation();
            mo11139ba(0);
            AppMethodBeat.m2505o(107436);
            return false;
        }
        if (j == 0) {
            j = (long) m8302K(i5, i6, i3, i4);
        }
        C4990ab.m7411d("WxViewDragHelper", "ashutest:: xvel %d, yvel %d, dx %d, dy %d duration %d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Long.valueOf(j));
        this.jlU.startScroll(left, top, i5, i6, (int) j);
        mo11139ba(2);
        AppMethodBeat.m2505o(107436);
        return true;
    }

    /* renamed from: K */
    private int m8302K(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107437);
        int i5 = C5516a.m8307i(i3, (int) this.f1317SQ, (int) this.f1316SP);
        int i6 = C5516a.m8307i(i4, (int) this.f1317SQ, (int) this.f1316SP);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(i5);
        int abs4 = Math.abs(i6);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        abs = (int) (((i6 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) m8306h(i2, i6, 0))) + ((i5 != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) m8306h(i, i5, this.zzE.dJm()))));
        AppMethodBeat.m2505o(107437);
        return abs;
    }

    /* renamed from: h */
    private int m8306h(int i, int i2, int i3) {
        AppMethodBeat.m2504i(107438);
        if (i == 0) {
            AppMethodBeat.m2505o(107438);
            return 0;
        }
        int width = this.f1322SW.getWidth();
        int i4 = width / 2;
        float distanceInfluenceForSnapDuration = (C5516a.distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        width = Math.min(width, 600);
        AppMethodBeat.m2505o(107438);
        return width;
    }

    /* renamed from: i */
    private static int m8307i(int i, int i2, int i3) {
        AppMethodBeat.m2504i(107439);
        int abs = Math.abs(i);
        if (abs < i2) {
            AppMethodBeat.m2505o(107439);
            return 0;
        } else if (abs <= i3) {
            AppMethodBeat.m2505o(107439);
            return i;
        } else if (i > 0) {
            AppMethodBeat.m2505o(107439);
            return i3;
        } else {
            i3 = -i3;
            AppMethodBeat.m2505o(107439);
            return i3;
        }
    }

    /* renamed from: e */
    private static float m8305e(float f, float f2, float f3) {
        AppMethodBeat.m2504i(107440);
        float abs = Math.abs(f);
        if (abs < f2) {
            AppMethodBeat.m2505o(107440);
            return 0.0f;
        } else if (abs <= f3) {
            AppMethodBeat.m2505o(107440);
            return f;
        } else if (f > 0.0f) {
            AppMethodBeat.m2505o(107440);
            return f3;
        } else {
            f3 = -f3;
            AppMethodBeat.m2505o(107440);
            return f3;
        }
    }

    private static float distanceInfluenceForSnapDuration(float f) {
        AppMethodBeat.m2504i(107441);
        float sin = (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.m2505o(107441);
        return sin;
    }

    /* renamed from: u */
    public final void mo11144u(float f, float f2) {
        AppMethodBeat.m2504i(107442);
        this.f1321SV = true;
        this.zzE.mo11130a(this.f1320SU, f, f2);
        this.f1321SV = false;
        if (this.f1307SG == 1) {
            mo11139ba(0);
        }
        AppMethodBeat.m2505o(107442);
    }

    /* renamed from: aY */
    public final void mo11136aY(int i) {
        if (this.f1308SH != null) {
            this.f1308SH[i] = 0.0f;
            this.f1309SI[i] = 0.0f;
            this.f1310SJ[i] = 0.0f;
            this.f1311SK[i] = 0.0f;
            this.f1312SL[i] = 0;
            this.f1313SM[i] = 0;
            this.f1314SN[i] = 0;
            this.f1315SO &= (1 << i) ^ -1;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ba */
    public final void mo11139ba(int i) {
        AppMethodBeat.m2504i(107445);
        if (this.f1307SG != i) {
            this.f1307SG = i;
            this.zzE.mo11128N(i);
            if (i == 0) {
                this.f1320SU = null;
            }
        }
        AppMethodBeat.m2505o(107445);
    }

    /* renamed from: v */
    public final boolean mo11145v(View view, int i) {
        AppMethodBeat.m2504i(107446);
        if (view == this.f1320SU && this.mActivePointerId == i) {
            AppMethodBeat.m2505o(107446);
            return true;
        } else if (view == null || !this.zzE.mo11129PG(i)) {
            AppMethodBeat.m2505o(107446);
            return false;
        } else {
            this.mActivePointerId = i;
            if (view.getParent() != this.f1322SW) {
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f1322SW + ")");
                AppMethodBeat.m2505o(107446);
                throw illegalArgumentException;
            }
            this.f1320SU = view;
            this.mActivePointerId = i;
            mo11139ba(1);
            AppMethodBeat.m2505o(107446);
            return true;
        }
    }

    /* renamed from: b */
    public final void mo11137b(float f, float f2, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(107447);
        if (!m8304a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m8304a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m8304a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m8304a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f1313SM;
            iArr[i] = i2 | iArr[i];
        }
        AppMethodBeat.m2505o(107447);
    }

    /* renamed from: a */
    private boolean m8304a(float f, float f2, int i, int i2) {
        AppMethodBeat.m2504i(107448);
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f1312SL[i] & i2) != i2 || (this.f1319SS & i2) == 0 || (this.f1314SN[i] & i2) == i2 || (this.f1313SM[i] & i2) == i2 || (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop))) {
            AppMethodBeat.m2505o(107448);
            return false;
        } else if ((this.f1313SM[i] & i2) != 0 || abs <= ((float) this.mTouchSlop)) {
            AppMethodBeat.m2505o(107448);
            return false;
        } else {
            AppMethodBeat.m2505o(107448);
            return true;
        }
    }

    /* renamed from: q */
    public final boolean mo11143q(View view, float f) {
        AppMethodBeat.m2504i(107449);
        if (view == null) {
            AppMethodBeat.m2505o(107449);
            return false;
        }
        if (!(this.zzE.dJm() > 0)) {
            AppMethodBeat.m2505o(107449);
            return false;
        } else if (Math.abs(f) > ((float) this.mTouchSlop)) {
            AppMethodBeat.m2505o(107449);
            return true;
        } else {
            AppMethodBeat.m2505o(107449);
            return false;
        }
    }

    /* renamed from: eZ */
    public final void mo11142eZ() {
        AppMethodBeat.m2504i(107450);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.f1316SP);
        mo11144u(C5516a.m8305e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.f1317SQ, this.f1316SP), C5516a.m8305e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.f1317SQ, this.f1316SP));
        AppMethodBeat.m2505o(107450);
    }

    /* renamed from: F */
    public final View mo11134F(int i, int i2) {
        AppMethodBeat.m2504i(107451);
        int childCount = this.f1322SW.getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = this.f1322SW.getChildAt(childCount);
            if (i < childAt.getLeft() || i >= childAt.getRight() || i2 < childAt.getTop() || i2 >= childAt.getBottom()) {
                childCount--;
            } else {
                AppMethodBeat.m2505o(107451);
                return childAt;
            }
        }
        AppMethodBeat.m2505o(107451);
        return null;
    }

    /* renamed from: a */
    public final void mo11135a(float f, float f2, int i) {
        float[] fArr;
        int i2 = 0;
        AppMethodBeat.m2504i(107443);
        if (this.f1308SH == null || this.f1308SH.length <= i) {
            fArr = new float[(i + 1)];
            float[] fArr2 = new float[(i + 1)];
            float[] fArr3 = new float[(i + 1)];
            float[] fArr4 = new float[(i + 1)];
            int[] iArr = new int[(i + 1)];
            int[] iArr2 = new int[(i + 1)];
            int[] iArr3 = new int[(i + 1)];
            if (this.f1308SH != null) {
                System.arraycopy(this.f1308SH, 0, fArr, 0, this.f1308SH.length);
                System.arraycopy(this.f1309SI, 0, fArr2, 0, this.f1309SI.length);
                System.arraycopy(this.f1310SJ, 0, fArr3, 0, this.f1310SJ.length);
                System.arraycopy(this.f1311SK, 0, fArr4, 0, this.f1311SK.length);
                System.arraycopy(this.f1312SL, 0, iArr, 0, this.f1312SL.length);
                System.arraycopy(this.f1313SM, 0, iArr2, 0, this.f1313SM.length);
                System.arraycopy(this.f1314SN, 0, iArr3, 0, this.f1314SN.length);
            }
            this.f1308SH = fArr;
            this.f1309SI = fArr2;
            this.f1310SJ = fArr3;
            this.f1311SK = fArr4;
            this.f1312SL = iArr;
            this.f1313SM = iArr2;
            this.f1314SN = iArr3;
        }
        fArr = this.f1308SH;
        this.f1310SJ[i] = f;
        fArr[i] = f;
        fArr = this.f1309SI;
        this.f1311SK[i] = f2;
        fArr[i] = f2;
        int[] iArr4 = this.f1312SL;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.f1322SW.getLeft() + this.f1318SR) {
            i2 = 1;
        }
        if (i4 < this.f1322SW.getTop() + this.f1318SR) {
            i2 |= 4;
        }
        if (i3 > this.f1322SW.getRight() - this.f1318SR) {
            i2 |= 2;
        }
        if (i4 > this.f1322SW.getBottom() - this.f1318SR) {
            i2 |= 8;
        }
        iArr4[i] = i2;
        this.f1315SO |= 1 << i;
        AppMethodBeat.m2505o(107443);
    }

    /* renamed from: e */
    public final void mo11141e(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(107444);
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            this.f1310SJ[pointerId] = x;
            this.f1311SK[pointerId] = y;
        }
        AppMethodBeat.m2505o(107444);
    }
}
