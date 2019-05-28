package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.s;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

public final class t {
    private static final Interpolator sInterpolator = new Interpolator() {
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    };
    int SG;
    float[] SH;
    float[] SI;
    float[] SJ;
    float[] SK;
    private int[] SL;
    private int[] SM;
    private int[] SN;
    private int SO;
    private float SP;
    float SQ;
    int SR;
    int SS;
    private final a ST;
    View SU;
    private boolean SV;
    private final ViewGroup SW;
    private final Runnable SX = new Runnable() {
        public final void run() {
            t.this.ba(0);
        }
    };
    private int mActivePointerId = -1;
    public int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private OverScroller qN;

    public static abstract class a {
        public abstract boolean b(View view, int i);

        public void N(int i) {
        }

        public void b(View view, int i, int i2) {
        }

        public void k(View view, int i) {
        }

        public void a(View view, float f, float f2) {
        }

        public void eK() {
        }

        public void z(int i, int i2) {
        }

        public int s(View view) {
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

    public static t a(ViewGroup viewGroup, a aVar) {
        return new t(viewGroup.getContext(), viewGroup, aVar);
    }

    public static t a(ViewGroup viewGroup, float f, a aVar) {
        t a = a(viewGroup, aVar);
        a.mTouchSlop = (int) (((float) a.mTouchSlop) * (1.0f / f));
        return a;
    }

    private t(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.SW = viewGroup;
            this.ST = aVar;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.SR = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.SP = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.SQ = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.qN = new OverScroller(context, sInterpolator);
        }
    }

    public final void u(View view, int i) {
        if (view.getParent() != this.SW) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.SW + ")");
        }
        this.SU = view;
        this.mActivePointerId = i;
        this.ST.k(view, i);
        ba(1);
    }

    public final void cancel() {
        this.mActivePointerId = -1;
        eY();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public final void abort() {
        cancel();
        if (this.SG == 2) {
            this.qN.getCurrX();
            this.qN.getCurrY();
            this.qN.abortAnimation();
            this.ST.b(this.SU, this.qN.getCurrX(), this.qN.getCurrY());
        }
        ba(0);
    }

    public final boolean h(View view, int i, int i2) {
        this.SU = view;
        this.mActivePointerId = -1;
        boolean h = h(i, i2, 0, 0);
        if (!(h || this.SG != 0 || this.SU == null)) {
            this.SU = null;
        }
        return h;
    }

    public final boolean D(int i, int i2) {
        if (this.SV) {
            return h(i, i2, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean h(int i, int i2, int i3, int i4) {
        int left = this.SU.getLeft();
        int top = this.SU.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.qN.abortAnimation();
            ba(0);
            return false;
        }
        this.qN.startScroll(left, top, i5, i6, e(this.SU, i5, i6, i3, i4));
        ba(2);
        return true;
    }

    private int e(View view, int i, int i2, int i3, int i4) {
        int i5 = i(i3, (int) this.SQ, (int) this.SP);
        int i6 = i(i4, (int) this.SQ, (int) this.SP);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(i5);
        int abs4 = Math.abs(i6);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        return (int) (((i6 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) h(i2, i6, this.ST.bL()))) + ((i5 != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) h(i, i5, this.ST.s(view)))));
    }

    private int h(int i, int i2, int i3) {
        if (i == 0) {
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
        return Math.min(width, 600);
    }

    private static int i(int i, int i2, int i3) {
        int abs = Math.abs(i);
        if (abs < i2) {
            return 0;
        }
        if (abs <= i3) {
            return i;
        }
        if (i <= 0) {
            return -i3;
        }
        return i3;
    }

    private static float e(float f, float f2, float f3) {
        float abs = Math.abs(f);
        if (abs < f2) {
            return 0.0f;
        }
        if (abs <= f3) {
            return f;
        }
        if (f <= 0.0f) {
            return -f3;
        }
        return f3;
    }

    private static float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((f - 0.5f) * 0.47123894f));
    }

    public final boolean eX() {
        if (this.SG == 2) {
            boolean computeScrollOffset = this.qN.computeScrollOffset();
            int currX = this.qN.getCurrX();
            int currY = this.qN.getCurrY();
            int left = currX - this.SU.getLeft();
            int top = currY - this.SU.getTop();
            if (left != 0) {
                s.r(this.SU, left);
            }
            if (top != 0) {
                s.q(this.SU, top);
            }
            if (!(left == 0 && top == 0)) {
                this.ST.b(this.SU, currX, currY);
            }
            if (computeScrollOffset && currX == this.qN.getFinalX() && currY == this.qN.getFinalY()) {
                this.qN.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.SW.post(this.SX);
            }
        }
        if (this.SG == 2) {
            return true;
        }
        return false;
    }

    private void u(float f, float f2) {
        this.SV = true;
        this.ST.a(this.SU, f, f2);
        this.SV = false;
        if (this.SG == 1) {
            ba(0);
        }
    }

    private void eY() {
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
    }

    private void aY(int i) {
        if (this.SH != null && aZ(i)) {
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

    private void a(float f, float f2, int i) {
        float[] fArr;
        int i2 = 0;
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
    }

    private void e(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (bb(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.SJ[pointerId] = x;
                this.SK[pointerId] = y;
            }
        }
    }

    public final boolean aZ(int i) {
        return (this.SO & (1 << i)) != 0;
    }

    /* Access modifiers changed, original: final */
    public final void ba(int i) {
        this.SW.removeCallbacks(this.SX);
        if (this.SG != i) {
            this.SG = i;
            this.ST.N(i);
            if (this.SG == 0) {
                this.SU = null;
            }
        }
    }

    private boolean v(View view, int i) {
        if (view == this.SU && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.ST.b(view, i)) {
            return false;
        }
        this.mActivePointerId = i;
        u(view, i);
        return true;
    }

    /* JADX WARNING: Missing block: B:46:0x00f3, code skipped:
            if (r8 != r7) goto L_0x00fb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean f(MotionEvent motionEvent) {
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
        int pointerId;
        switch (actionMasked) {
            case 0:
                x = motionEvent.getX();
                y = motionEvent.getY();
                pointerId = motionEvent.getPointerId(0);
                a(x, y, pointerId);
                View F = F((int) x, (int) y);
                if (F == this.SU && this.SG == 2) {
                    v(F, pointerId);
                }
                if ((this.SL[pointerId] & this.SS) != 0) {
                    this.ST.eK();
                    break;
                }
                break;
            case 1:
            case 3:
                cancel();
                break;
            case 2:
                if (!(this.SH == null || this.SI == null)) {
                    pointerId = motionEvent.getPointerCount();
                    for (actionIndex = 0; actionIndex < pointerId; actionIndex++) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        if (bb(pointerId2)) {
                            x = motionEvent.getX(actionIndex);
                            float y2 = motionEvent.getY(actionIndex);
                            float f = x - this.SH[pointerId2];
                            float f2 = y2 - this.SI[pointerId2];
                            View F2 = F((int) x, (int) y2);
                            Object obj = (F2 == null || !c(F2, f, f2)) ? null : 1;
                            if (obj != null) {
                                int left = F2.getLeft();
                                int d = this.ST.d(F2, ((int) f) + left);
                                int top = F2.getTop();
                                int c = this.ST.c(F2, ((int) f2) + top);
                                int s = this.ST.s(F2);
                                int bL = this.ST.bL();
                                if (s != 0) {
                                    if (s > 0) {
                                    }
                                }
                                if (bL != 0) {
                                    if (bL > 0 && c == top) {
                                    }
                                }
                                e(motionEvent);
                                break;
                            }
                            b(f, f2, pointerId2);
                            if (this.SG != 1) {
                                if (obj != null && v(F2, pointerId2)) {
                                }
                            }
                            e(motionEvent);
                        }
                    }
                    e(motionEvent);
                }
                break;
            case 5:
                actionMasked = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                a(x2, y, actionMasked);
                if (this.SG != 0) {
                    if (this.SG == 2) {
                        View F3 = F((int) x2, (int) y);
                        if (F3 == this.SU) {
                            v(F3, actionMasked);
                            break;
                        }
                    }
                } else if ((this.SL[actionMasked] & this.SS) != 0) {
                    this.ST.eK();
                    break;
                }
                break;
            case 6:
                aY(motionEvent.getPointerId(actionIndex));
                break;
        }
        if (this.SG == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void g(MotionEvent motionEvent) {
        int i = 0;
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
                if ((this.SL[i] & this.SS) != 0) {
                    this.ST.eK();
                    return;
                }
                return;
            case 1:
                if (this.SG == 1) {
                    eZ();
                }
                cancel();
                return;
            case 2:
                int pointerCount;
                if (this.SG != 1) {
                    pointerCount = motionEvent.getPointerCount();
                    while (i < pointerCount) {
                        actionMasked = motionEvent.getPointerId(i);
                        if (bb(actionMasked)) {
                            float x2 = motionEvent.getX(i);
                            float y2 = motionEvent.getY(i);
                            float f = x2 - this.SH[actionMasked];
                            float f2 = y2 - this.SI[actionMasked];
                            b(f, f2, actionMasked);
                            if (this.SG != 1) {
                                F = F((int) x2, (int) y2);
                                if (c(F, f, f2) && v(F, actionMasked)) {
                                }
                            }
                            e(motionEvent);
                            return;
                        }
                        i++;
                    }
                    e(motionEvent);
                    return;
                } else if (bb(this.mActivePointerId)) {
                    i = motionEvent.findPointerIndex(this.mActivePointerId);
                    x = motionEvent.getX(i);
                    pointerCount = (int) (x - this.SJ[this.mActivePointerId]);
                    i = (int) (motionEvent.getY(i) - this.SK[this.mActivePointerId]);
                    i(this.SU.getLeft() + pointerCount, this.SU.getTop() + i, pointerCount, i);
                    e(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.SG == 1) {
                    u(0.0f, 0.0f);
                }
                cancel();
                return;
            case 5:
                i = motionEvent.getPointerId(actionIndex);
                x = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                a(x, y, i);
                if (this.SG == 0) {
                    v(F((int) x, (int) y), i);
                    if ((this.SL[i] & this.SS) != 0) {
                        this.ST.eK();
                        return;
                    }
                    return;
                } else if (E((int) x, (int) y)) {
                    v(this.SU, i);
                    return;
                } else {
                    return;
                }
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
                return;
            default:
                return;
        }
    }

    private void b(float f, float f2, int i) {
        int i2 = 1;
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
            iArr[i] = iArr[i] | i2;
            this.ST.z(i2, i);
        }
    }

    private boolean a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.SL[i] & i2) != i2 || (this.SS & i2) == 0 || (this.SN[i] & i2) == i2 || (this.SM[i] & i2) == i2) {
            return false;
        }
        if ((abs > ((float) this.mTouchSlop) || abs2 > ((float) this.mTouchSlop)) && (this.SM[i] & i2) == 0 && abs > ((float) this.mTouchSlop)) {
            return true;
        }
        return false;
    }

    private boolean c(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.ST.s(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.ST.bL() > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && z2) {
            if ((f * f) + (f2 * f2) > ((float) (this.mTouchSlop * this.mTouchSlop))) {
                return true;
            }
            return false;
        } else if (z) {
            if (Math.abs(f) > ((float) this.mTouchSlop)) {
                return true;
            }
            return false;
        } else if (!z2 || Math.abs(f2) <= ((float) this.mTouchSlop)) {
            return false;
        } else {
            return true;
        }
    }

    private void eZ() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.SP);
        u(e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.SQ, this.SP), e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.SQ, this.SP));
    }

    private void i(int i, int i2, int i3, int i4) {
        int left = this.SU.getLeft();
        int top = this.SU.getTop();
        if (i3 != 0) {
            i = this.ST.d(this.SU, i);
            s.r(this.SU, i - left);
        }
        if (i4 != 0) {
            i2 = this.ST.c(this.SU, i2);
            s.q(this.SU, i2 - top);
        }
        if (i3 != 0 || i4 != 0) {
            this.ST.b(this.SU, i, i2);
        }
    }

    private boolean E(int i, int i2) {
        return i(this.SU, i, i2);
    }

    public static boolean i(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    public final View F(int i, int i2) {
        for (int childCount = this.SW.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.SW.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean bb(int i) {
        if (aZ(i)) {
            return true;
        }
        new StringBuilder("Ignoring pointerId=").append(i).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
