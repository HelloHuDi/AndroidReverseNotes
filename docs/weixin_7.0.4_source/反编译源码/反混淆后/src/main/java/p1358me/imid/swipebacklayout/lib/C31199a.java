package p1358me.imid.swipebacklayout.lib;

import android.content.Context;
import android.support.p057v4.widget.C0539p;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: me.imid.swipebacklayout.lib.a */
public final class C31199a {
    private static final Interpolator sInterpolator = new C312001();
    int[] BTp;
    final C31198a BTq;
    /* renamed from: SG */
    int f14346SG;
    /* renamed from: SH */
    float[] f14347SH;
    /* renamed from: SI */
    float[] f14348SI;
    /* renamed from: SJ */
    private float[] f14349SJ;
    /* renamed from: SK */
    private float[] f14350SK;
    /* renamed from: SM */
    private int[] f14351SM;
    /* renamed from: SN */
    private int[] f14352SN;
    /* renamed from: SO */
    private int f14353SO;
    /* renamed from: SP */
    float f14354SP;
    /* renamed from: SQ */
    float f14355SQ;
    /* renamed from: SR */
    int f14356SR;
    /* renamed from: SS */
    int f14357SS;
    /* renamed from: SU */
    View f14358SU;
    /* renamed from: SV */
    boolean f14359SV;
    /* renamed from: SW */
    final ViewGroup f14360SW;
    /* renamed from: SX */
    final Runnable f14361SX = new C312012();
    C0539p jlU;
    int mActivePointerId = -1;
    private int mTouchSlop;
    VelocityTracker mVelocityTracker;

    /* renamed from: me.imid.swipebacklayout.lib.a$a */
    public static abstract class C31198a {
        /* renamed from: PG */
        public abstract boolean mo41389PG(int i);

        /* renamed from: N */
        public void mo41388N(int i) {
        }

        /* renamed from: o */
        public void mo41395o(View view, int i, int i2, int i3, int i4) {
        }

        /* renamed from: a */
        public void mo41390a(View view, float f, float f2) {
        }

        public int dJm() {
            return 0;
        }

        /* renamed from: bL */
        public int mo41391bL() {
            return 0;
        }

        /* renamed from: d */
        public int mo41393d(View view, int i) {
            return 0;
        }

        /* renamed from: c */
        public int mo41392c(View view, int i) {
            return 0;
        }
    }

    /* renamed from: me.imid.swipebacklayout.lib.a$1 */
    static class C312001 implements Interpolator {
        C312001() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: me.imid.swipebacklayout.lib.a$2 */
    class C312012 implements Runnable {
        C312012() {
        }

        public final void run() {
            AppMethodBeat.m2504i(91221);
            C31199a.this.mo50973ba(0);
            AppMethodBeat.m2505o(91221);
        }
    }

    static {
        AppMethodBeat.m2504i(91249);
        AppMethodBeat.m2505o(91249);
    }

    /* renamed from: a */
    public static C31199a m50301a(ViewGroup viewGroup, C31198a c31198a) {
        AppMethodBeat.m2504i(91222);
        C31199a c31199a = new C31199a(viewGroup.getContext(), viewGroup, c31198a);
        AppMethodBeat.m2505o(91222);
        return c31199a;
    }

    private C31199a(Context context, ViewGroup viewGroup, C31198a c31198a) {
        AppMethodBeat.m2504i(91223);
        IllegalArgumentException illegalArgumentException;
        if (viewGroup == null) {
            illegalArgumentException = new IllegalArgumentException("Parent view may not be null");
            AppMethodBeat.m2505o(91223);
            throw illegalArgumentException;
        } else if (c31198a == null) {
            illegalArgumentException = new IllegalArgumentException("Callback may not be null");
            AppMethodBeat.m2505o(91223);
            throw illegalArgumentException;
        } else {
            this.f14360SW = viewGroup;
            this.BTq = c31198a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f14356SR = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.f14354SP = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f14355SQ = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.jlU = C0539p.m1164a(context, sInterpolator);
            AppMethodBeat.m2505o(91223);
        }
    }

    /* renamed from: u */
    private void m50312u(View view, int i) {
        AppMethodBeat.m2504i(91224);
        if (view.getParent() != this.f14360SW) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f14360SW + ")");
            AppMethodBeat.m2505o(91224);
            throw illegalArgumentException;
        }
        this.f14358SU = view;
        this.mActivePointerId = i;
        mo50973ba(1);
        AppMethodBeat.m2505o(91224);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(91225);
        this.mActivePointerId = -1;
        m50305eY();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.m2505o(91225);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: h */
    public final int mo50978h(int i, int i2, int i3) {
        AppMethodBeat.m2504i(91226);
        if (i == 0) {
            AppMethodBeat.m2505o(91226);
            return 0;
        }
        int width = this.f14360SW.getWidth();
        int i4 = width / 2;
        float distanceInfluenceForSnapDuration = (C31199a.distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        width = Math.min(width, 600);
        AppMethodBeat.m2505o(91226);
        return width;
    }

    /* renamed from: i */
    static int m50307i(int i, int i2, int i3) {
        AppMethodBeat.m2504i(91227);
        int abs = Math.abs(i);
        if (abs < i2) {
            AppMethodBeat.m2505o(91227);
            return 0;
        } else if (abs <= i3) {
            AppMethodBeat.m2505o(91227);
            return i;
        } else if (i > 0) {
            AppMethodBeat.m2505o(91227);
            return i3;
        } else {
            i3 = -i3;
            AppMethodBeat.m2505o(91227);
            return i3;
        }
    }

    /* renamed from: e */
    private static float m50304e(float f, float f2, float f3) {
        AppMethodBeat.m2504i(91228);
        float abs = Math.abs(f);
        if (abs < f2) {
            AppMethodBeat.m2505o(91228);
            return 0.0f;
        } else if (abs <= f3) {
            AppMethodBeat.m2505o(91228);
            return f;
        } else if (f > 0.0f) {
            AppMethodBeat.m2505o(91228);
            return f3;
        } else {
            f3 = -f3;
            AppMethodBeat.m2505o(91228);
            return f3;
        }
    }

    private static float distanceInfluenceForSnapDuration(float f) {
        AppMethodBeat.m2504i(91229);
        float sin = (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.m2505o(91229);
        return sin;
    }

    /* renamed from: u */
    private void m50311u(float f, float f2) {
        AppMethodBeat.m2504i(91230);
        this.f14359SV = true;
        this.BTq.mo41390a(this.f14358SU, f, f2);
        this.f14359SV = false;
        if (this.f14346SG == 1) {
            mo50973ba(0);
        }
        AppMethodBeat.m2505o(91230);
    }

    /* renamed from: eY */
    private void m50305eY() {
        AppMethodBeat.m2504i(91231);
        if (this.f14347SH == null) {
            AppMethodBeat.m2505o(91231);
            return;
        }
        Arrays.fill(this.f14347SH, 0.0f);
        Arrays.fill(this.f14348SI, 0.0f);
        Arrays.fill(this.f14349SJ, 0.0f);
        Arrays.fill(this.f14350SK, 0.0f);
        Arrays.fill(this.BTp, 0);
        Arrays.fill(this.f14351SM, 0);
        Arrays.fill(this.f14352SN, 0);
        this.f14353SO = 0;
        AppMethodBeat.m2505o(91231);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: aY */
    public final void mo50971aY(int i) {
        if (this.f14347SH != null) {
            this.f14347SH[i] = 0.0f;
            this.f14348SI[i] = 0.0f;
            this.f14349SJ[i] = 0.0f;
            this.f14350SK[i] = 0.0f;
            this.BTp[i] = 0;
            this.f14351SM[i] = 0;
            this.f14352SN[i] = 0;
            this.f14353SO &= (1 << i) ^ -1;
        }
    }

    /* renamed from: Vf */
    private void m50300Vf(int i) {
        AppMethodBeat.m2504i(91232);
        if (this.f14347SH == null || this.f14347SH.length <= i) {
            float[] fArr = new float[(i + 1)];
            float[] fArr2 = new float[(i + 1)];
            float[] fArr3 = new float[(i + 1)];
            float[] fArr4 = new float[(i + 1)];
            int[] iArr = new int[(i + 1)];
            int[] iArr2 = new int[(i + 1)];
            int[] iArr3 = new int[(i + 1)];
            if (this.f14347SH != null) {
                System.arraycopy(this.f14347SH, 0, fArr, 0, this.f14347SH.length);
                System.arraycopy(this.f14348SI, 0, fArr2, 0, this.f14348SI.length);
                System.arraycopy(this.f14349SJ, 0, fArr3, 0, this.f14349SJ.length);
                System.arraycopy(this.f14350SK, 0, fArr4, 0, this.f14350SK.length);
                System.arraycopy(this.BTp, 0, iArr, 0, this.BTp.length);
                System.arraycopy(this.f14351SM, 0, iArr2, 0, this.f14351SM.length);
                System.arraycopy(this.f14352SN, 0, iArr3, 0, this.f14352SN.length);
            }
            this.f14347SH = fArr;
            this.f14348SI = fArr2;
            this.f14349SJ = fArr3;
            this.f14350SK = fArr4;
            this.BTp = iArr;
            this.f14351SM = iArr2;
            this.f14352SN = iArr3;
        }
        AppMethodBeat.m2505o(91232);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo50970a(float f, float f2, int i) {
        AppMethodBeat.m2504i(91233);
        m50300Vf(i);
        float[] fArr = this.f14347SH;
        this.f14349SJ[i] = f;
        fArr[i] = f;
        fArr = this.f14348SI;
        this.f14350SK[i] = f2;
        fArr[i] = f2;
        this.BTp[i] = m50310iv((int) f, (int) f2);
        this.f14353SO |= 1 << i;
        AppMethodBeat.m2505o(91233);
    }

    /* renamed from: aZ */
    private boolean m50303aZ(int i) {
        return (this.f14353SO & (1 << i)) != 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ba */
    public final void mo50973ba(int i) {
        AppMethodBeat.m2504i(91235);
        if (this.f14346SG != i) {
            this.f14346SG = i;
            this.BTq.mo41388N(i);
            if (i == 0) {
                this.f14358SU = null;
            }
        }
        AppMethodBeat.m2505o(91235);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: v */
    public final boolean mo50981v(View view, int i) {
        AppMethodBeat.m2504i(91236);
        if (view == this.f14358SU && this.mActivePointerId == i) {
            AppMethodBeat.m2505o(91236);
            return true;
        } else if (view == null || !this.BTq.mo41389PG(i)) {
            AppMethodBeat.m2505o(91236);
            return false;
        } else {
            this.mActivePointerId = i;
            m50312u(view, i);
            AppMethodBeat.m2505o(91236);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo50972b(float f, float f2, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(91238);
        if (!m50302a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m50302a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m50302a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m50302a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f14351SM;
            iArr[i] = i2 | iArr[i];
        }
        AppMethodBeat.m2505o(91238);
    }

    /* renamed from: a */
    private boolean m50302a(float f, float f2, int i, int i2) {
        AppMethodBeat.m2504i(91239);
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.BTp[i] & i2) != i2 || (this.f14357SS & i2) == 0 || (this.f14352SN[i] & i2) == i2 || (this.f14351SM[i] & i2) == i2 || (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop))) {
            AppMethodBeat.m2505o(91239);
            return false;
        } else if ((this.f14351SM[i] & i2) != 0 || abs <= ((float) this.mTouchSlop)) {
            AppMethodBeat.m2505o(91239);
            return false;
        } else {
            AppMethodBeat.m2505o(91239);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final boolean mo50974c(View view, float f, float f2) {
        AppMethodBeat.m2504i(91240);
        if (view == null) {
            AppMethodBeat.m2505o(91240);
            return false;
        }
        boolean z;
        boolean z2;
        if (this.BTq.dJm() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.BTq.mo41391bL() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.mTouchSlop * this.mTouchSlop))) {
                AppMethodBeat.m2505o(91240);
                return true;
            }
            AppMethodBeat.m2505o(91240);
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.mTouchSlop)) {
                AppMethodBeat.m2505o(91240);
                return true;
            }
            AppMethodBeat.m2505o(91240);
            return false;
        } else if (!z2) {
            AppMethodBeat.m2505o(91240);
            return false;
        } else if (Math.abs(f2) > ((float) this.mTouchSlop)) {
            AppMethodBeat.m2505o(91240);
            return true;
        } else {
            AppMethodBeat.m2505o(91240);
            return false;
        }
    }

    /* renamed from: it */
    public final boolean mo50979it(int i, int i2) {
        AppMethodBeat.m2504i(91241);
        if (m50303aZ(i2)) {
            boolean z;
            boolean z2 = (i & 1) == 1;
            if ((i & 2) == 2) {
                z = true;
            } else {
                z = false;
            }
            float f = this.f14349SJ[i2] - this.f14347SH[i2];
            float f2 = this.f14350SK[i2] - this.f14348SI[i2];
            if (z2 && z) {
                if ((f * f) + (f2 * f2) > ((float) (this.mTouchSlop * this.mTouchSlop))) {
                    AppMethodBeat.m2505o(91241);
                    return true;
                }
                AppMethodBeat.m2505o(91241);
                return false;
            } else if (z2) {
                if (Math.abs(f) > ((float) this.mTouchSlop)) {
                    AppMethodBeat.m2505o(91241);
                    return true;
                }
                AppMethodBeat.m2505o(91241);
                return false;
            } else if (!z) {
                AppMethodBeat.m2505o(91241);
                return false;
            } else if (Math.abs(f2) > ((float) this.mTouchSlop)) {
                AppMethodBeat.m2505o(91241);
                return true;
            } else {
                AppMethodBeat.m2505o(91241);
                return false;
            }
        }
        AppMethodBeat.m2505o(91241);
        return false;
    }

    /* renamed from: iu */
    public final boolean mo50980iu(int i, int i2) {
        AppMethodBeat.m2504i(91242);
        if (!m50303aZ(i2) || (this.BTp[i2] & i) == 0) {
            AppMethodBeat.m2505o(91242);
            return false;
        }
        AppMethodBeat.m2505o(91242);
        return true;
    }

    /* renamed from: eZ */
    private void m50306eZ() {
        AppMethodBeat.m2504i(91243);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.f14354SP);
        m50311u(C31199a.m50304e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.f14355SQ, this.f14354SP), C31199a.m50304e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.f14355SQ, this.f14354SP));
        AppMethodBeat.m2505o(91243);
    }

    /* renamed from: i */
    private void m50308i(int i, int i2, int i3, int i4) {
        int d;
        int c;
        AppMethodBeat.m2504i(91244);
        int left = this.f14358SU.getLeft();
        int top = this.f14358SU.getTop();
        if (i3 != 0) {
            d = this.BTq.mo41393d(this.f14358SU, i);
            this.f14358SU.offsetLeftAndRight(d - left);
        } else {
            d = i;
        }
        if (i4 != 0) {
            c = this.BTq.mo41392c(this.f14358SU, i2);
            this.f14358SU.offsetTopAndBottom(c - top);
        } else {
            c = i2;
        }
        if (!(i3 == 0 && i4 == 0)) {
            this.BTq.mo41395o(this.f14358SU, d, c, d - left, c - top);
        }
        AppMethodBeat.m2505o(91244);
    }

    /* renamed from: E */
    private boolean m50299E(int i, int i2) {
        AppMethodBeat.m2504i(91245);
        boolean i3 = C31199a.m50309i(this.f14358SU, i, i2);
        AppMethodBeat.m2505o(91245);
        return i3;
    }

    /* renamed from: i */
    private static boolean m50309i(View view, int i, int i2) {
        AppMethodBeat.m2504i(91246);
        if (view == null) {
            AppMethodBeat.m2505o(91246);
            return false;
        } else if (i < view.getLeft() || i >= view.getRight() || i2 < view.getTop() || i2 >= view.getBottom()) {
            AppMethodBeat.m2505o(91246);
            return false;
        } else {
            AppMethodBeat.m2505o(91246);
            return true;
        }
    }

    /* renamed from: F */
    public final View mo50969F(int i, int i2) {
        AppMethodBeat.m2504i(91247);
        int childCount = this.f14360SW.getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = this.f14360SW.getChildAt(childCount);
            if (i < childAt.getLeft() || i >= childAt.getRight() || i2 < childAt.getTop() || i2 >= childAt.getBottom()) {
                childCount--;
            } else {
                AppMethodBeat.m2505o(91247);
                return childAt;
            }
        }
        AppMethodBeat.m2505o(91247);
        return null;
    }

    /* renamed from: iv */
    private int m50310iv(int i, int i2) {
        AppMethodBeat.m2504i(91248);
        int i3 = 0;
        if (i < this.f14360SW.getLeft() + this.f14356SR) {
            i3 = 1;
        }
        if (i2 < this.f14360SW.getTop() + this.f14356SR) {
            i3 = 4;
        }
        if (i > this.f14360SW.getRight() - this.f14356SR) {
            i3 = 2;
        }
        if (i2 > this.f14360SW.getBottom() - this.f14356SR) {
            i3 = 8;
        }
        AppMethodBeat.m2505o(91248);
        return i3;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo50976e(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(91234);
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            this.f14349SJ[pointerId] = x;
            this.f14350SK[pointerId] = y;
        }
        AppMethodBeat.m2505o(91234);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public final void mo50977g(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.m2504i(91237);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        float x;
        float y;
        View F;
        switch (actionMasked) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = motionEvent.getPointerId(0);
                F = mo50969F((int) x, (int) y);
                mo50970a(x, y, i);
                mo50981v(F, i);
                if ((this.BTp[i] & this.f14357SS) != 0) {
                    AppMethodBeat.m2505o(91237);
                    return;
                }
                break;
            case 1:
                if (this.f14346SG == 1) {
                    m50306eZ();
                }
                cancel();
                AppMethodBeat.m2505o(91237);
                return;
            case 2:
                int i2;
                if (this.f14346SG == 1) {
                    i = motionEvent.findPointerIndex(this.mActivePointerId);
                    x = motionEvent.getX(i);
                    i2 = (int) (x - this.f14349SJ[this.mActivePointerId]);
                    i = (int) (motionEvent.getY(i) - this.f14350SK[this.mActivePointerId]);
                    m50308i(this.f14358SU.getLeft() + i2, this.f14358SU.getTop() + i, i2, i);
                    mo50976e(motionEvent);
                    AppMethodBeat.m2505o(91237);
                    return;
                }
                i2 = motionEvent.getPointerCount();
                while (i < i2) {
                    actionMasked = motionEvent.getPointerId(i);
                    float x2 = motionEvent.getX(i);
                    float y2 = motionEvent.getY(i);
                    float f = x2 - this.f14347SH[actionMasked];
                    float f2 = y2 - this.f14348SI[actionMasked];
                    mo50972b(f, f2, actionMasked);
                    if (this.f14346SG != 1) {
                        F = mo50969F((int) x2, (int) y2);
                        if (!mo50974c(F, f, f2) || !mo50981v(F, actionMasked)) {
                            i++;
                        }
                    }
                    mo50976e(motionEvent);
                    AppMethodBeat.m2505o(91237);
                    return;
                }
                mo50976e(motionEvent);
                AppMethodBeat.m2505o(91237);
                return;
            case 3:
                if (this.f14346SG == 1) {
                    m50311u(0.0f, 0.0f);
                }
                cancel();
                break;
            case 5:
                i = motionEvent.getPointerId(actionIndex);
                x = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                mo50970a(x, y, i);
                if (this.f14346SG == 0) {
                    mo50981v(mo50969F((int) x, (int) y), i);
                    AppMethodBeat.m2505o(91237);
                    return;
                } else if (m50299E((int) x, (int) y)) {
                    mo50981v(this.f14358SU, i);
                    AppMethodBeat.m2505o(91237);
                    return;
                }
                break;
            case 6:
                actionMasked = motionEvent.getPointerId(actionIndex);
                if (this.f14346SG == 1 && actionMasked == this.mActivePointerId) {
                    actionIndex = motionEvent.getPointerCount();
                    while (i < actionIndex) {
                        int pointerId = motionEvent.getPointerId(i);
                        if (pointerId != this.mActivePointerId) {
                            if (mo50969F((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.f14358SU && mo50981v(this.f14358SU, pointerId)) {
                                i = this.mActivePointerId;
                                if (i == -1) {
                                    m50306eZ();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                    }
                }
                mo50971aY(actionMasked);
                AppMethodBeat.m2505o(91237);
                return;
        }
        AppMethodBeat.m2505o(91237);
    }
}
