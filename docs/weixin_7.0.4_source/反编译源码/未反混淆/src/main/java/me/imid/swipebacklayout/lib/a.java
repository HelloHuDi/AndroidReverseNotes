package me.imid.swipebacklayout.lib;

import android.content.Context;
import android.support.v4.widget.p;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public final class a {
    private static final Interpolator sInterpolator = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    int[] BTp;
    final a BTq;
    int SG;
    float[] SH;
    float[] SI;
    private float[] SJ;
    private float[] SK;
    private int[] SM;
    private int[] SN;
    private int SO;
    float SP;
    float SQ;
    int SR;
    int SS;
    View SU;
    boolean SV;
    final ViewGroup SW;
    final Runnable SX = new Runnable() {
        public final void run() {
            AppMethodBeat.i(91221);
            a.this.ba(0);
            AppMethodBeat.o(91221);
        }
    };
    p jlU;
    int mActivePointerId = -1;
    private int mTouchSlop;
    VelocityTracker mVelocityTracker;

    public static abstract class a {
        public abstract boolean PG(int i);

        public void N(int i) {
        }

        public void o(View view, int i, int i2, int i3, int i4) {
        }

        public void a(View view, float f, float f2) {
        }

        public int dJm() {
            return 0;
        }

        public int bL() {
            return 0;
        }

        public int d(View view, int i) {
            return 0;
        }

        public int c(View view, int i) {
            return 0;
        }
    }

    static {
        AppMethodBeat.i(91249);
        AppMethodBeat.o(91249);
    }

    public static a a(ViewGroup viewGroup, a aVar) {
        AppMethodBeat.i(91222);
        a aVar2 = new a(viewGroup.getContext(), viewGroup, aVar);
        AppMethodBeat.o(91222);
        return aVar2;
    }

    private a(Context context, ViewGroup viewGroup, a aVar) {
        AppMethodBeat.i(91223);
        IllegalArgumentException illegalArgumentException;
        if (viewGroup == null) {
            illegalArgumentException = new IllegalArgumentException("Parent view may not be null");
            AppMethodBeat.o(91223);
            throw illegalArgumentException;
        } else if (aVar == null) {
            illegalArgumentException = new IllegalArgumentException("Callback may not be null");
            AppMethodBeat.o(91223);
            throw illegalArgumentException;
        } else {
            this.SW = viewGroup;
            this.BTq = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.SR = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.SP = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.SQ = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.jlU = p.a(context, sInterpolator);
            AppMethodBeat.o(91223);
        }
    }

    private void u(View view, int i) {
        AppMethodBeat.i(91224);
        if (view.getParent() != this.SW) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.SW + ")");
            AppMethodBeat.o(91224);
            throw illegalArgumentException;
        }
        this.SU = view;
        this.mActivePointerId = i;
        ba(1);
        AppMethodBeat.o(91224);
    }

    public final void cancel() {
        AppMethodBeat.i(91225);
        this.mActivePointerId = -1;
        eY();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
        AppMethodBeat.o(91225);
    }

    /* Access modifiers changed, original: final */
    public final int h(int i, int i2, int i3) {
        AppMethodBeat.i(91226);
        if (i == 0) {
            AppMethodBeat.o(91226);
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
        AppMethodBeat.o(91226);
        return width;
    }

    static int i(int i, int i2, int i3) {
        AppMethodBeat.i(91227);
        int abs = Math.abs(i);
        if (abs < i2) {
            AppMethodBeat.o(91227);
            return 0;
        } else if (abs <= i3) {
            AppMethodBeat.o(91227);
            return i;
        } else if (i > 0) {
            AppMethodBeat.o(91227);
            return i3;
        } else {
            i3 = -i3;
            AppMethodBeat.o(91227);
            return i3;
        }
    }

    private static float e(float f, float f2, float f3) {
        AppMethodBeat.i(91228);
        float abs = Math.abs(f);
        if (abs < f2) {
            AppMethodBeat.o(91228);
            return 0.0f;
        } else if (abs <= f3) {
            AppMethodBeat.o(91228);
            return f;
        } else if (f > 0.0f) {
            AppMethodBeat.o(91228);
            return f3;
        } else {
            f3 = -f3;
            AppMethodBeat.o(91228);
            return f3;
        }
    }

    private static float distanceInfluenceForSnapDuration(float f) {
        AppMethodBeat.i(91229);
        float sin = (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
        AppMethodBeat.o(91229);
        return sin;
    }

    private void u(float f, float f2) {
        AppMethodBeat.i(91230);
        this.SV = true;
        this.BTq.a(this.SU, f, f2);
        this.SV = false;
        if (this.SG == 1) {
            ba(0);
        }
        AppMethodBeat.o(91230);
    }

    private void eY() {
        AppMethodBeat.i(91231);
        if (this.SH == null) {
            AppMethodBeat.o(91231);
            return;
        }
        Arrays.fill(this.SH, 0.0f);
        Arrays.fill(this.SI, 0.0f);
        Arrays.fill(this.SJ, 0.0f);
        Arrays.fill(this.SK, 0.0f);
        Arrays.fill(this.BTp, 0);
        Arrays.fill(this.SM, 0);
        Arrays.fill(this.SN, 0);
        this.SO = 0;
        AppMethodBeat.o(91231);
    }

    /* Access modifiers changed, original: final */
    public final void aY(int i) {
        if (this.SH != null) {
            this.SH[i] = 0.0f;
            this.SI[i] = 0.0f;
            this.SJ[i] = 0.0f;
            this.SK[i] = 0.0f;
            this.BTp[i] = 0;
            this.SM[i] = 0;
            this.SN[i] = 0;
            this.SO &= (1 << i) ^ -1;
        }
    }

    private void Vf(int i) {
        AppMethodBeat.i(91232);
        if (this.SH == null || this.SH.length <= i) {
            float[] fArr = new float[(i + 1)];
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
                System.arraycopy(this.BTp, 0, iArr, 0, this.BTp.length);
                System.arraycopy(this.SM, 0, iArr2, 0, this.SM.length);
                System.arraycopy(this.SN, 0, iArr3, 0, this.SN.length);
            }
            this.SH = fArr;
            this.SI = fArr2;
            this.SJ = fArr3;
            this.SK = fArr4;
            this.BTp = iArr;
            this.SM = iArr2;
            this.SN = iArr3;
        }
        AppMethodBeat.o(91232);
    }

    /* Access modifiers changed, original: final */
    public final void a(float f, float f2, int i) {
        AppMethodBeat.i(91233);
        Vf(i);
        float[] fArr = this.SH;
        this.SJ[i] = f;
        fArr[i] = f;
        fArr = this.SI;
        this.SK[i] = f2;
        fArr[i] = f2;
        this.BTp[i] = iv((int) f, (int) f2);
        this.SO |= 1 << i;
        AppMethodBeat.o(91233);
    }

    private boolean aZ(int i) {
        return (this.SO & (1 << i)) != 0;
    }

    /* Access modifiers changed, original: final */
    public final void ba(int i) {
        AppMethodBeat.i(91235);
        if (this.SG != i) {
            this.SG = i;
            this.BTq.N(i);
            if (i == 0) {
                this.SU = null;
            }
        }
        AppMethodBeat.o(91235);
    }

    /* Access modifiers changed, original: final */
    public final boolean v(View view, int i) {
        AppMethodBeat.i(91236);
        if (view == this.SU && this.mActivePointerId == i) {
            AppMethodBeat.o(91236);
            return true;
        } else if (view == null || !this.BTq.PG(i)) {
            AppMethodBeat.o(91236);
            return false;
        } else {
            this.mActivePointerId = i;
            u(view, i);
            AppMethodBeat.o(91236);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final void b(float f, float f2, int i) {
        int i2 = 1;
        AppMethodBeat.i(91238);
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
        AppMethodBeat.o(91238);
    }

    private boolean a(float f, float f2, int i, int i2) {
        AppMethodBeat.i(91239);
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.BTp[i] & i2) != i2 || (this.SS & i2) == 0 || (this.SN[i] & i2) == i2 || (this.SM[i] & i2) == i2 || (abs <= ((float) this.mTouchSlop) && abs2 <= ((float) this.mTouchSlop))) {
            AppMethodBeat.o(91239);
            return false;
        } else if ((this.SM[i] & i2) != 0 || abs <= ((float) this.mTouchSlop)) {
            AppMethodBeat.o(91239);
            return false;
        } else {
            AppMethodBeat.o(91239);
            return true;
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean c(View view, float f, float f2) {
        AppMethodBeat.i(91240);
        if (view == null) {
            AppMethodBeat.o(91240);
            return false;
        }
        boolean z;
        boolean z2;
        if (this.BTq.dJm() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.BTq.bL() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.mTouchSlop * this.mTouchSlop))) {
                AppMethodBeat.o(91240);
                return true;
            }
            AppMethodBeat.o(91240);
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.mTouchSlop)) {
                AppMethodBeat.o(91240);
                return true;
            }
            AppMethodBeat.o(91240);
            return false;
        } else if (!z2) {
            AppMethodBeat.o(91240);
            return false;
        } else if (Math.abs(f2) > ((float) this.mTouchSlop)) {
            AppMethodBeat.o(91240);
            return true;
        } else {
            AppMethodBeat.o(91240);
            return false;
        }
    }

    public final boolean it(int i, int i2) {
        AppMethodBeat.i(91241);
        if (aZ(i2)) {
            boolean z;
            boolean z2 = (i & 1) == 1;
            if ((i & 2) == 2) {
                z = true;
            } else {
                z = false;
            }
            float f = this.SJ[i2] - this.SH[i2];
            float f2 = this.SK[i2] - this.SI[i2];
            if (z2 && z) {
                if ((f * f) + (f2 * f2) > ((float) (this.mTouchSlop * this.mTouchSlop))) {
                    AppMethodBeat.o(91241);
                    return true;
                }
                AppMethodBeat.o(91241);
                return false;
            } else if (z2) {
                if (Math.abs(f) > ((float) this.mTouchSlop)) {
                    AppMethodBeat.o(91241);
                    return true;
                }
                AppMethodBeat.o(91241);
                return false;
            } else if (!z) {
                AppMethodBeat.o(91241);
                return false;
            } else if (Math.abs(f2) > ((float) this.mTouchSlop)) {
                AppMethodBeat.o(91241);
                return true;
            } else {
                AppMethodBeat.o(91241);
                return false;
            }
        }
        AppMethodBeat.o(91241);
        return false;
    }

    public final boolean iu(int i, int i2) {
        AppMethodBeat.i(91242);
        if (!aZ(i2) || (this.BTp[i2] & i) == 0) {
            AppMethodBeat.o(91242);
            return false;
        }
        AppMethodBeat.o(91242);
        return true;
    }

    private void eZ() {
        AppMethodBeat.i(91243);
        this.mVelocityTracker.computeCurrentVelocity(1000, this.SP);
        u(e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.SQ, this.SP), e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.SQ, this.SP));
        AppMethodBeat.o(91243);
    }

    private void i(int i, int i2, int i3, int i4) {
        int d;
        int c;
        AppMethodBeat.i(91244);
        int left = this.SU.getLeft();
        int top = this.SU.getTop();
        if (i3 != 0) {
            d = this.BTq.d(this.SU, i);
            this.SU.offsetLeftAndRight(d - left);
        } else {
            d = i;
        }
        if (i4 != 0) {
            c = this.BTq.c(this.SU, i2);
            this.SU.offsetTopAndBottom(c - top);
        } else {
            c = i2;
        }
        if (!(i3 == 0 && i4 == 0)) {
            this.BTq.o(this.SU, d, c, d - left, c - top);
        }
        AppMethodBeat.o(91244);
    }

    private boolean E(int i, int i2) {
        AppMethodBeat.i(91245);
        boolean i3 = i(this.SU, i, i2);
        AppMethodBeat.o(91245);
        return i3;
    }

    private static boolean i(View view, int i, int i2) {
        AppMethodBeat.i(91246);
        if (view == null) {
            AppMethodBeat.o(91246);
            return false;
        } else if (i < view.getLeft() || i >= view.getRight() || i2 < view.getTop() || i2 >= view.getBottom()) {
            AppMethodBeat.o(91246);
            return false;
        } else {
            AppMethodBeat.o(91246);
            return true;
        }
    }

    public final View F(int i, int i2) {
        AppMethodBeat.i(91247);
        int childCount = this.SW.getChildCount() - 1;
        while (childCount >= 0) {
            View childAt = this.SW.getChildAt(childCount);
            if (i < childAt.getLeft() || i >= childAt.getRight() || i2 < childAt.getTop() || i2 >= childAt.getBottom()) {
                childCount--;
            } else {
                AppMethodBeat.o(91247);
                return childAt;
            }
        }
        AppMethodBeat.o(91247);
        return null;
    }

    private int iv(int i, int i2) {
        AppMethodBeat.i(91248);
        int i3 = 0;
        if (i < this.SW.getLeft() + this.SR) {
            i3 = 1;
        }
        if (i2 < this.SW.getTop() + this.SR) {
            i3 = 4;
        }
        if (i > this.SW.getRight() - this.SR) {
            i3 = 2;
        }
        if (i2 > this.SW.getBottom() - this.SR) {
            i3 = 8;
        }
        AppMethodBeat.o(91248);
        return i3;
    }

    /* Access modifiers changed, original: final */
    public final void e(MotionEvent motionEvent) {
        AppMethodBeat.i(91234);
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            this.SJ[pointerId] = x;
            this.SK[pointerId] = y;
        }
        AppMethodBeat.o(91234);
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0138  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.i(91237);
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
                F = F((int) x, (int) y);
                a(x, y, i);
                v(F, i);
                if ((this.BTp[i] & this.SS) != 0) {
                    AppMethodBeat.o(91237);
                    return;
                }
                break;
            case 1:
                if (this.SG == 1) {
                    eZ();
                }
                cancel();
                AppMethodBeat.o(91237);
                return;
            case 2:
                int i2;
                if (this.SG == 1) {
                    i = motionEvent.findPointerIndex(this.mActivePointerId);
                    x = motionEvent.getX(i);
                    i2 = (int) (x - this.SJ[this.mActivePointerId]);
                    i = (int) (motionEvent.getY(i) - this.SK[this.mActivePointerId]);
                    i(this.SU.getLeft() + i2, this.SU.getTop() + i, i2, i);
                    e(motionEvent);
                    AppMethodBeat.o(91237);
                    return;
                }
                i2 = motionEvent.getPointerCount();
                while (i < i2) {
                    actionMasked = motionEvent.getPointerId(i);
                    float x2 = motionEvent.getX(i);
                    float y2 = motionEvent.getY(i);
                    float f = x2 - this.SH[actionMasked];
                    float f2 = y2 - this.SI[actionMasked];
                    b(f, f2, actionMasked);
                    if (this.SG != 1) {
                        F = F((int) x2, (int) y2);
                        if (!c(F, f, f2) || !v(F, actionMasked)) {
                            i++;
                        }
                    }
                    e(motionEvent);
                    AppMethodBeat.o(91237);
                    return;
                }
                e(motionEvent);
                AppMethodBeat.o(91237);
                return;
            case 3:
                if (this.SG == 1) {
                    u(0.0f, 0.0f);
                }
                cancel();
                break;
            case 5:
                i = motionEvent.getPointerId(actionIndex);
                x = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                a(x, y, i);
                if (this.SG == 0) {
                    v(F((int) x, (int) y), i);
                    AppMethodBeat.o(91237);
                    return;
                } else if (E((int) x, (int) y)) {
                    v(this.SU, i);
                    AppMethodBeat.o(91237);
                    return;
                }
                break;
            case 6:
                actionMasked = motionEvent.getPointerId(actionIndex);
                if (this.SG == 1 && actionMasked == this.mActivePointerId) {
                    actionIndex = motionEvent.getPointerCount();
                    while (i < actionIndex) {
                        int pointerId = motionEvent.getPointerId(i);
                        if (pointerId != this.mActivePointerId) {
                            if (F((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.SU && v(this.SU, pointerId)) {
                                i = this.mActivePointerId;
                                if (i == -1) {
                                    eZ();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                    }
                }
                aY(actionMasked);
                AppMethodBeat.o(91237);
                return;
        }
        AppMethodBeat.o(91237);
    }
}
