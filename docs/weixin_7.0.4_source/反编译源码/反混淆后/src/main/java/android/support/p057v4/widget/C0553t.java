package android.support.p057v4.widget;

import android.content.Context;
import android.support.p057v4.view.C0477s;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import java.util.Arrays;

/* renamed from: android.support.v4.widget.t */
public final class C0553t {
    private static final Interpolator sInterpolator = new C05501();
    /* renamed from: SG */
    int f717SG;
    /* renamed from: SH */
    float[] f718SH;
    /* renamed from: SI */
    float[] f719SI;
    /* renamed from: SJ */
    float[] f720SJ;
    /* renamed from: SK */
    float[] f721SK;
    /* renamed from: SL */
    private int[] f722SL;
    /* renamed from: SM */
    private int[] f723SM;
    /* renamed from: SN */
    private int[] f724SN;
    /* renamed from: SO */
    private int f725SO;
    /* renamed from: SP */
    private float f726SP;
    /* renamed from: SQ */
    float f727SQ;
    /* renamed from: SR */
    int f728SR;
    /* renamed from: SS */
    int f729SS;
    /* renamed from: ST */
    private final C0552a f730ST;
    /* renamed from: SU */
    View f731SU;
    /* renamed from: SV */
    private boolean f732SV;
    /* renamed from: SW */
    private final ViewGroup f733SW;
    /* renamed from: SX */
    private final Runnable f734SX = new C05512();
    private int mActivePointerId = -1;
    public int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    /* renamed from: qN */
    private OverScroller f735qN;

    /* renamed from: android.support.v4.widget.t$1 */
    static class C05501 implements Interpolator {
        C05501() {
        }

        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.widget.t$2 */
    class C05512 implements Runnable {
        C05512() {
        }

        public final void run() {
            C0553t.this.mo1320ba(0);
        }
    }

    /* renamed from: android.support.v4.widget.t$a */
    public static abstract class C0552a {
        /* renamed from: b */
        public abstract boolean mo1218b(View view, int i);

        /* renamed from: N */
        public void mo1215N(int i) {
        }

        /* renamed from: b */
        public void mo1217b(View view, int i, int i2) {
        }

        /* renamed from: k */
        public void mo1224k(View view, int i) {
        }

        /* renamed from: a */
        public void mo1216a(View view, float f, float f2) {
        }

        /* renamed from: eK */
        public void mo1223eK() {
        }

        /* renamed from: z */
        public void mo1226z(int i, int i2) {
        }

        /* renamed from: s */
        public int mo1225s(View view) {
            return 0;
        }

        /* renamed from: bL */
        public int mo1315bL() {
            return 0;
        }

        /* renamed from: d */
        public int mo1220d(View view, int i) {
            return 0;
        }

        /* renamed from: c */
        public int mo1219c(View view, int i) {
            return 0;
        }
    }

    /* renamed from: a */
    public static C0553t m1197a(ViewGroup viewGroup, C0552a c0552a) {
        return new C0553t(viewGroup.getContext(), viewGroup, c0552a);
    }

    /* renamed from: a */
    public static C0553t m1196a(ViewGroup viewGroup, float f, C0552a c0552a) {
        C0553t a = C0553t.m1197a(viewGroup, c0552a);
        a.mTouchSlop = (int) (((float) a.mTouchSlop) * (1.0f / f));
        return a;
    }

    private C0553t(Context context, ViewGroup viewGroup, C0552a c0552a) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c0552a == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f733SW = viewGroup;
            this.f730ST = c0552a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f728SR = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
            this.f726SP = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f727SQ = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f735qN = new OverScroller(context, sInterpolator);
        }
    }

    /* renamed from: u */
    public final void mo1326u(View view, int i) {
        if (view.getParent() != this.f733SW) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f733SW + ")");
        }
        this.f731SU = view;
        this.mActivePointerId = i;
        this.f730ST.mo1224k(view, i);
        mo1320ba(1);
    }

    public final void cancel() {
        this.mActivePointerId = -1;
        m1207eY();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public final void abort() {
        cancel();
        if (this.f717SG == 2) {
            this.f735qN.getCurrX();
            this.f735qN.getCurrY();
            this.f735qN.abortAnimation();
            this.f730ST.mo1217b(this.f731SU, this.f735qN.getCurrX(), this.f735qN.getCurrY());
        }
        mo1320ba(0);
    }

    /* renamed from: h */
    public final boolean mo1325h(View view, int i, int i2) {
        this.f731SU = view;
        this.mActivePointerId = -1;
        boolean h = m1210h(i, i2, 0, 0);
        if (!(h || this.f717SG != 0 || this.f731SU == null)) {
            this.f731SU = null;
        }
        return h;
    }

    /* renamed from: D */
    public final boolean mo1316D(int i, int i2) {
        if (this.f732SV) {
            return m1210h(i, i2, (int) this.mVelocityTracker.getXVelocity(this.mActivePointerId), (int) this.mVelocityTracker.getYVelocity(this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* renamed from: h */
    private boolean m1210h(int i, int i2, int i3, int i4) {
        int left = this.f731SU.getLeft();
        int top = this.f731SU.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f735qN.abortAnimation();
            mo1320ba(0);
            return false;
        }
        this.f735qN.startScroll(left, top, i5, i6, m1205e(this.f731SU, i5, i6, i3, i4));
        mo1320ba(2);
        return true;
    }

    /* renamed from: e */
    private int m1205e(View view, int i, int i2, int i3, int i4) {
        int i5 = C0553t.m1211i(i3, (int) this.f727SQ, (int) this.f726SP);
        int i6 = C0553t.m1211i(i4, (int) this.f727SQ, (int) this.f726SP);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(i5);
        int abs4 = Math.abs(i6);
        int i7 = abs3 + abs4;
        int i8 = abs + abs2;
        return (int) (((i6 != 0 ? ((float) abs4) / ((float) i7) : ((float) abs2) / ((float) i8)) * ((float) m1209h(i2, i6, this.f730ST.mo1315bL()))) + ((i5 != 0 ? ((float) abs3) / ((float) i7) : ((float) abs) / ((float) i8)) * ((float) m1209h(i, i5, this.f730ST.mo1225s(view)))));
    }

    /* renamed from: h */
    private int m1209h(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f733SW.getWidth();
        int i4 = width / 2;
        float distanceInfluenceForSnapDuration = (C0553t.distanceInfluenceForSnapDuration(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        if (i4 > 0) {
            width = Math.round(Math.abs(distanceInfluenceForSnapDuration / ((float) i4)) * 1000.0f) * 4;
        } else {
            width = (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f);
        }
        return Math.min(width, 600);
    }

    /* renamed from: i */
    private static int m1211i(int i, int i2, int i3) {
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

    /* renamed from: e */
    private static float m1204e(float f, float f2, float f3) {
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

    /* renamed from: eX */
    public final boolean mo1322eX() {
        if (this.f717SG == 2) {
            boolean computeScrollOffset = this.f735qN.computeScrollOffset();
            int currX = this.f735qN.getCurrX();
            int currY = this.f735qN.getCurrY();
            int left = currX - this.f731SU.getLeft();
            int top = currY - this.f731SU.getTop();
            if (left != 0) {
                C0477s.m952r(this.f731SU, left);
            }
            if (top != 0) {
                C0477s.m951q(this.f731SU, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f730ST.mo1217b(this.f731SU, currX, currY);
            }
            if (computeScrollOffset && currX == this.f735qN.getFinalX() && currY == this.f735qN.getFinalY()) {
                this.f735qN.abortAnimation();
                computeScrollOffset = false;
            }
            if (!computeScrollOffset) {
                this.f733SW.post(this.f734SX);
            }
        }
        if (this.f717SG == 2) {
            return true;
        }
        return false;
    }

    /* renamed from: u */
    private void m1214u(float f, float f2) {
        this.f732SV = true;
        this.f730ST.mo1216a(this.f731SU, f, f2);
        this.f732SV = false;
        if (this.f717SG == 1) {
            mo1320ba(0);
        }
    }

    /* renamed from: eY */
    private void m1207eY() {
        if (this.f718SH != null) {
            Arrays.fill(this.f718SH, 0.0f);
            Arrays.fill(this.f719SI, 0.0f);
            Arrays.fill(this.f720SJ, 0.0f);
            Arrays.fill(this.f721SK, 0.0f);
            Arrays.fill(this.f722SL, 0);
            Arrays.fill(this.f723SM, 0);
            Arrays.fill(this.f724SN, 0);
            this.f725SO = 0;
        }
    }

    /* renamed from: aY */
    private void m1200aY(int i) {
        if (this.f718SH != null && mo1318aZ(i)) {
            this.f718SH[i] = 0.0f;
            this.f719SI[i] = 0.0f;
            this.f720SJ[i] = 0.0f;
            this.f721SK[i] = 0.0f;
            this.f722SL[i] = 0;
            this.f723SM[i] = 0;
            this.f724SN[i] = 0;
            this.f725SO &= (1 << i) ^ -1;
        }
    }

    /* renamed from: a */
    private void m1198a(float f, float f2, int i) {
        float[] fArr;
        int i2 = 0;
        if (this.f718SH == null || this.f718SH.length <= i) {
            fArr = new float[(i + 1)];
            float[] fArr2 = new float[(i + 1)];
            float[] fArr3 = new float[(i + 1)];
            float[] fArr4 = new float[(i + 1)];
            int[] iArr = new int[(i + 1)];
            int[] iArr2 = new int[(i + 1)];
            int[] iArr3 = new int[(i + 1)];
            if (this.f718SH != null) {
                System.arraycopy(this.f718SH, 0, fArr, 0, this.f718SH.length);
                System.arraycopy(this.f719SI, 0, fArr2, 0, this.f719SI.length);
                System.arraycopy(this.f720SJ, 0, fArr3, 0, this.f720SJ.length);
                System.arraycopy(this.f721SK, 0, fArr4, 0, this.f721SK.length);
                System.arraycopy(this.f722SL, 0, iArr, 0, this.f722SL.length);
                System.arraycopy(this.f723SM, 0, iArr2, 0, this.f723SM.length);
                System.arraycopy(this.f724SN, 0, iArr3, 0, this.f724SN.length);
            }
            this.f718SH = fArr;
            this.f719SI = fArr2;
            this.f720SJ = fArr3;
            this.f721SK = fArr4;
            this.f722SL = iArr;
            this.f723SM = iArr2;
            this.f724SN = iArr3;
        }
        fArr = this.f718SH;
        this.f720SJ[i] = f;
        fArr[i] = f;
        fArr = this.f719SI;
        this.f721SK[i] = f2;
        fArr[i] = f2;
        int[] iArr4 = this.f722SL;
        int i3 = (int) f;
        int i4 = (int) f2;
        if (i3 < this.f733SW.getLeft() + this.f728SR) {
            i2 = 1;
        }
        if (i4 < this.f733SW.getTop() + this.f728SR) {
            i2 |= 4;
        }
        if (i3 > this.f733SW.getRight() - this.f728SR) {
            i2 |= 2;
        }
        if (i4 > this.f733SW.getBottom() - this.f728SR) {
            i2 |= 8;
        }
        iArr4[i] = i2;
        this.f725SO |= 1 << i;
    }

    /* renamed from: e */
    private void m1206e(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = motionEvent.getPointerId(i);
            if (m1202bb(pointerId)) {
                float x = motionEvent.getX(i);
                float y = motionEvent.getY(i);
                this.f720SJ[pointerId] = x;
                this.f721SK[pointerId] = y;
            }
        }
    }

    /* renamed from: aZ */
    public final boolean mo1318aZ(int i) {
        return (this.f725SO & (1 << i)) != 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: ba */
    public final void mo1320ba(int i) {
        this.f733SW.removeCallbacks(this.f734SX);
        if (this.f717SG != i) {
            this.f717SG = i;
            this.f730ST.mo1215N(i);
            if (this.f717SG == 0) {
                this.f731SU = null;
            }
        }
    }

    /* renamed from: v */
    private boolean m1215v(View view, int i) {
        if (view == this.f731SU && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.f730ST.mo1218b(view, i)) {
            return false;
        }
        this.mActivePointerId = i;
        mo1326u(view, i);
        return true;
    }

    /* JADX WARNING: Missing block: B:46:0x00f3, code skipped:
            if (r8 != r7) goto L_0x00fb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: f */
    public final boolean mo1323f(MotionEvent motionEvent) {
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
                m1198a(x, y, pointerId);
                View F = mo1317F((int) x, (int) y);
                if (F == this.f731SU && this.f717SG == 2) {
                    m1215v(F, pointerId);
                }
                if ((this.f722SL[pointerId] & this.f729SS) != 0) {
                    this.f730ST.mo1223eK();
                    break;
                }
                break;
            case 1:
            case 3:
                cancel();
                break;
            case 2:
                if (!(this.f718SH == null || this.f719SI == null)) {
                    pointerId = motionEvent.getPointerCount();
                    for (actionIndex = 0; actionIndex < pointerId; actionIndex++) {
                        int pointerId2 = motionEvent.getPointerId(actionIndex);
                        if (m1202bb(pointerId2)) {
                            x = motionEvent.getX(actionIndex);
                            float y2 = motionEvent.getY(actionIndex);
                            float f = x - this.f718SH[pointerId2];
                            float f2 = y2 - this.f719SI[pointerId2];
                            View F2 = mo1317F((int) x, (int) y2);
                            Object obj = (F2 == null || !m1203c(F2, f, f2)) ? null : 1;
                            if (obj != null) {
                                int left = F2.getLeft();
                                int d = this.f730ST.mo1220d(F2, ((int) f) + left);
                                int top = F2.getTop();
                                int c = this.f730ST.mo1219c(F2, ((int) f2) + top);
                                int s = this.f730ST.mo1225s(F2);
                                int bL = this.f730ST.mo1315bL();
                                if (s != 0) {
                                    if (s > 0) {
                                    }
                                }
                                if (bL != 0) {
                                    if (bL > 0 && c == top) {
                                    }
                                }
                                m1206e(motionEvent);
                                break;
                            }
                            m1201b(f, f2, pointerId2);
                            if (this.f717SG != 1) {
                                if (obj != null && m1215v(F2, pointerId2)) {
                                }
                            }
                            m1206e(motionEvent);
                        }
                    }
                    m1206e(motionEvent);
                }
                break;
            case 5:
                actionMasked = motionEvent.getPointerId(actionIndex);
                float x2 = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                m1198a(x2, y, actionMasked);
                if (this.f717SG != 0) {
                    if (this.f717SG == 2) {
                        View F3 = mo1317F((int) x2, (int) y);
                        if (F3 == this.f731SU) {
                            m1215v(F3, actionMasked);
                            break;
                        }
                    }
                } else if ((this.f722SL[actionMasked] & this.f729SS) != 0) {
                    this.f730ST.mo1223eK();
                    break;
                }
                break;
            case 6:
                m1200aY(motionEvent.getPointerId(actionIndex));
                break;
        }
        if (this.f717SG == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x0141  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public final void mo1324g(MotionEvent motionEvent) {
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
                F = mo1317F((int) x, (int) y);
                m1198a(x, y, i);
                m1215v(F, i);
                if ((this.f722SL[i] & this.f729SS) != 0) {
                    this.f730ST.mo1223eK();
                    return;
                }
                return;
            case 1:
                if (this.f717SG == 1) {
                    m1208eZ();
                }
                cancel();
                return;
            case 2:
                int pointerCount;
                if (this.f717SG != 1) {
                    pointerCount = motionEvent.getPointerCount();
                    while (i < pointerCount) {
                        actionMasked = motionEvent.getPointerId(i);
                        if (m1202bb(actionMasked)) {
                            float x2 = motionEvent.getX(i);
                            float y2 = motionEvent.getY(i);
                            float f = x2 - this.f718SH[actionMasked];
                            float f2 = y2 - this.f719SI[actionMasked];
                            m1201b(f, f2, actionMasked);
                            if (this.f717SG != 1) {
                                F = mo1317F((int) x2, (int) y2);
                                if (m1203c(F, f, f2) && m1215v(F, actionMasked)) {
                                }
                            }
                            m1206e(motionEvent);
                            return;
                        }
                        i++;
                    }
                    m1206e(motionEvent);
                    return;
                } else if (m1202bb(this.mActivePointerId)) {
                    i = motionEvent.findPointerIndex(this.mActivePointerId);
                    x = motionEvent.getX(i);
                    pointerCount = (int) (x - this.f720SJ[this.mActivePointerId]);
                    i = (int) (motionEvent.getY(i) - this.f721SK[this.mActivePointerId]);
                    m1212i(this.f731SU.getLeft() + pointerCount, this.f731SU.getTop() + i, pointerCount, i);
                    m1206e(motionEvent);
                    return;
                } else {
                    return;
                }
            case 3:
                if (this.f717SG == 1) {
                    m1214u(0.0f, 0.0f);
                }
                cancel();
                return;
            case 5:
                i = motionEvent.getPointerId(actionIndex);
                x = motionEvent.getX(actionIndex);
                y = motionEvent.getY(actionIndex);
                m1198a(x, y, i);
                if (this.f717SG == 0) {
                    m1215v(mo1317F((int) x, (int) y), i);
                    if ((this.f722SL[i] & this.f729SS) != 0) {
                        this.f730ST.mo1223eK();
                        return;
                    }
                    return;
                } else if (m1195E((int) x, (int) y)) {
                    m1215v(this.f731SU, i);
                    return;
                } else {
                    return;
                }
            case 6:
                actionMasked = motionEvent.getPointerId(actionIndex);
                if (this.f717SG == 1 && actionMasked == this.mActivePointerId) {
                    actionIndex = motionEvent.getPointerCount();
                    while (i < actionIndex) {
                        int pointerId = motionEvent.getPointerId(i);
                        if (pointerId != this.mActivePointerId) {
                            if (mo1317F((int) motionEvent.getX(i), (int) motionEvent.getY(i)) == this.f731SU && m1215v(this.f731SU, pointerId)) {
                                i = this.mActivePointerId;
                                if (i == -1) {
                                    m1208eZ();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                    }
                }
                m1200aY(actionMasked);
                return;
            default:
                return;
        }
    }

    /* renamed from: b */
    private void m1201b(float f, float f2, int i) {
        int i2 = 1;
        if (!m1199a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m1199a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m1199a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m1199a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f723SM;
            iArr[i] = iArr[i] | i2;
            this.f730ST.mo1226z(i2, i);
        }
    }

    /* renamed from: a */
    private boolean m1199a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f722SL[i] & i2) != i2 || (this.f729SS & i2) == 0 || (this.f724SN[i] & i2) == i2 || (this.f723SM[i] & i2) == i2) {
            return false;
        }
        if ((abs > ((float) this.mTouchSlop) || abs2 > ((float) this.mTouchSlop)) && (this.f723SM[i] & i2) == 0 && abs > ((float) this.mTouchSlop)) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    private boolean m1203c(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z;
        boolean z2;
        if (this.f730ST.mo1225s(view) > 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f730ST.mo1315bL() > 0) {
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

    /* renamed from: eZ */
    private void m1208eZ() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.f726SP);
        m1214u(C0553t.m1204e(this.mVelocityTracker.getXVelocity(this.mActivePointerId), this.f727SQ, this.f726SP), C0553t.m1204e(this.mVelocityTracker.getYVelocity(this.mActivePointerId), this.f727SQ, this.f726SP));
    }

    /* renamed from: i */
    private void m1212i(int i, int i2, int i3, int i4) {
        int left = this.f731SU.getLeft();
        int top = this.f731SU.getTop();
        if (i3 != 0) {
            i = this.f730ST.mo1220d(this.f731SU, i);
            C0477s.m952r(this.f731SU, i - left);
        }
        if (i4 != 0) {
            i2 = this.f730ST.mo1219c(this.f731SU, i2);
            C0477s.m951q(this.f731SU, i2 - top);
        }
        if (i3 != 0 || i4 != 0) {
            this.f730ST.mo1217b(this.f731SU, i, i2);
        }
    }

    /* renamed from: E */
    private boolean m1195E(int i, int i2) {
        return C0553t.m1213i(this.f731SU, i, i2);
    }

    /* renamed from: i */
    public static boolean m1213i(View view, int i, int i2) {
        if (view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom()) {
            return true;
        }
        return false;
    }

    /* renamed from: F */
    public final View mo1317F(int i, int i2) {
        for (int childCount = this.f733SW.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f733SW.getChildAt(childCount);
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    /* renamed from: bb */
    private boolean m1202bb(int i) {
        if (mo1318aZ(i)) {
            return true;
        }
        new StringBuilder("Ignoring pointerId=").append(i).append(" because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }
}
