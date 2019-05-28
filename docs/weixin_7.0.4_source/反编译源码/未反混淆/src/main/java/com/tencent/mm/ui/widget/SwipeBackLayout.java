package com.tencent.mm.ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.tools.h;

public class SwipeBackLayout extends FrameLayout {
    private float Qb;
    public View WL;
    private boolean mEnable;
    private boolean mInLayout;
    private Rect oT;
    private float zOf;
    private int zOg;
    private int zOh;
    public com.tencent.mm.ui.mogic.a zOi;
    private float zOj;
    public Drawable zOk;
    private boolean zOl;
    private boolean zOm;
    public boolean zOn;
    public boolean zOo;
    public boolean zOp;
    private boolean zOq;
    private b zOr;
    private Drawable zOs;
    private boolean zOt;
    private boolean zOu;
    public a zOv;

    public interface a {
        void onCancel();

        void onDrag();

        void onSwipeBack();
    }

    public interface b {
        boolean ba(boolean z);

        void bf(float f);

        void l(MotionEvent motionEvent);
    }

    class c extends com.tencent.mm.ui.mogic.a.a implements com.tencent.mm.ui.base.b.a {
        int zOw;
        int zOx;
        int zOy;

        private c() {
            this.zOw = 0;
            this.zOx = 0;
            this.zOy = 0;
        }

        /* synthetic */ c(SwipeBackLayout swipeBackLayout, byte b) {
            this();
        }

        public final boolean PG(int i) {
            int i2;
            AppMethodBeat.i(107985);
            com.tencent.mm.ui.mogic.a a = SwipeBackLayout.this.zOi;
            if ((a.SO & (1 << i)) != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0 || (a.SL[i] & 1) == 0) {
                AppMethodBeat.o(107985);
                return false;
            }
            AppMethodBeat.o(107985);
            return true;
        }

        public final int dJm() {
            return 1;
        }

        public final void ht(int i, int i2) {
            AppMethodBeat.i(107986);
            if (SwipeBackLayout.this.zOn) {
                SwipeBackLayout.this.zOj = Math.abs(((float) i) / ((float) (SwipeBackLayout.this.WL.getWidth() + SwipeBackLayout.this.zOk.getIntrinsicWidth())));
                SwipeBackLayout.this.zOg = i;
                SwipeBackLayout.this.zOh = i2;
                SwipeBackLayout.this.invalidate();
                if (SwipeBackLayout.this.zOr != null) {
                    SwipeBackLayout.this.zOr.bf(SwipeBackLayout.this.zOj);
                }
                if (Float.compare(SwipeBackLayout.this.zOj, 1.0f) >= 0 && !SwipeBackLayout.this.zOo) {
                    SwipeBackLayout.this.zOo = true;
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(107978);
                            if (SwipeBackLayout.this.zOv != null) {
                                ab.i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
                                if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.zOs != null) {
                                    if (SwipeBackLayout.this.zOu) {
                                        ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.zOs);
                                    }
                                    SwipeBackLayout.this.zOs = null;
                                }
                                SwipeBackLayout.this.zOv.onSwipeBack();
                            }
                            SwipeBackLayout.this.zOp = false;
                            AppMethodBeat.o(107978);
                        }
                    });
                } else if (Float.compare(SwipeBackLayout.this.zOj, 0.01f) <= 0) {
                    SwipeBackLayout.this.zOp = false;
                    ab.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", Float.valueOf(SwipeBackLayout.this.zOj), Boolean.valueOf(SwipeBackLayout.this.zOo));
                }
                if (SwipeBackLayout.this.zOi.SG == 1) {
                    h.bq(SwipeBackLayout.this.zOj);
                }
                AppMethodBeat.o(107986);
                return;
            }
            ab.w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false");
            AppMethodBeat.o(107986);
        }

        public final void a(View view, float f, float f2) {
            boolean z = false;
            AppMethodBeat.i(107987);
            int width = view.getWidth();
            this.zOx = 0;
            this.zOy = 0;
            width = (f > 0.0f || (f == 0.0f && SwipeBackLayout.this.zOj > SwipeBackLayout.this.zOf)) ? (width + SwipeBackLayout.this.zOk.getIntrinsicWidth()) + 10 : 0;
            this.zOx = width;
            ab.i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(this.zOx), Integer.valueOf(this.zOy), Boolean.valueOf(SwipeBackLayout.this.zOn));
            SwipeBackLayout.this.zOp = true;
            if (SwipeBackLayout.this.zOr != null) {
                b e = SwipeBackLayout.this.zOr;
                if (this.zOx != 0) {
                    z = true;
                }
                if (e.ba(z)) {
                    ab.i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased");
                    AppMethodBeat.o(107987);
                    return;
                }
            }
            if (SwipeBackLayout.this.zOn) {
                com.tencent.mm.ui.mogic.a a = SwipeBackLayout.this.zOi;
                int i = this.zOx;
                int i2 = this.zOy;
                if (a.SV) {
                    a.b(i, i2, (int) a.mVelocityTracker.getXVelocity(a.mActivePointerId), (int) a.mVelocityTracker.getYVelocity(a.mActivePointerId), 0);
                    SwipeBackLayout.this.invalidate();
                    AppMethodBeat.o(107987);
                    return;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
                AppMethodBeat.o(107987);
                throw illegalStateException;
            }
            SwipeBackLayout.this.zOq = true;
            AppMethodBeat.o(107987);
        }

        public final int d(View view, int i) {
            AppMethodBeat.i(107988);
            if (SwipeBackLayout.this.zOn) {
                int max = Math.max(this.zOw, i);
                this.zOw = 0;
                int min = Math.min(view.getWidth(), Math.max(max, 0));
                AppMethodBeat.o(107988);
                return min;
            }
            this.zOw = Math.max(this.zOw, i);
            AppMethodBeat.o(107988);
            return 0;
        }

        public final void N(int i) {
            AppMethodBeat.i(107989);
            ab.i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", Integer.valueOf(i), Boolean.valueOf(SwipeBackLayout.this.zOm), Boolean.valueOf(SwipeBackLayout.this.zOq));
            if (1 == i) {
                ab.i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
                if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.zOs == null) {
                    SwipeBackLayout.this.zOs = ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().getBackground();
                    if (SwipeBackLayout.this.zOu) {
                        ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(R.color.a3p);
                    }
                }
                if (SwipeBackLayout.this.zOv != null) {
                    SwipeBackLayout.this.zOv.onDrag();
                }
                SwipeBackLayout.this.zOo = false;
                if (SwipeBackLayout.this.zOn) {
                    h.bq(0.0f);
                }
            }
            if (i == 0 && !SwipeBackLayout.this.zOq) {
                ab.i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
                if (SwipeBackLayout.this.zOv != null) {
                    if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.zOs != null) {
                        if (SwipeBackLayout.this.zOu) {
                            ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.zOs);
                        }
                        SwipeBackLayout.this.zOs = null;
                    }
                    SwipeBackLayout.this.zOv.onCancel();
                }
                h.bq(1.0f);
            }
            if (1 == i && SwipeBackLayout.this.zOl && (SwipeBackLayout.this.getContext() instanceof Activity) && !SwipeBackLayout.this.zOn && !SwipeBackLayout.this.zOm) {
                ab.i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
                SwipeBackLayout.this.zOm = true;
                com.tencent.mm.ui.base.b.a((Activity) SwipeBackLayout.this.getContext(), this);
            }
            if (2 == i) {
                boolean z;
                ab.i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", Integer.valueOf(this.zOx));
                if (this.zOx > 0) {
                    z = true;
                } else {
                    z = false;
                }
                h.J(z, this.zOx);
            }
            AppMethodBeat.o(107989);
        }

        public final void iH(final boolean z) {
            AppMethodBeat.i(107990);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(107984);
                    ab.i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", Boolean.valueOf(z), Integer.valueOf(c.this.zOx));
                    SwipeBackLayout.this.zOm = z;
                    if (!z) {
                        SwipeBackLayout.this.zOp = false;
                    } else if (c.this.zOx > 0) {
                        h.bq(0.0f);
                    } else {
                        h.bq(1.0f);
                    }
                    SwipeBackLayout.this.qX(z);
                    if (z && SwipeBackLayout.this.zOq) {
                        if (c.this.zOx == 0) {
                            h.a(SwipeBackLayout.this.WL, 200, 0.0f, new com.tencent.mm.ui.tools.h.a() {
                                public final void onAnimationEnd() {
                                    AppMethodBeat.i(107979);
                                    SwipeBackLayout.this.zOp = false;
                                    AppMethodBeat.o(107979);
                                }

                                public final void dbb() {
                                    AppMethodBeat.i(107980);
                                    onAnimationEnd();
                                    AppMethodBeat.o(107980);
                                }
                            });
                        } else {
                            h.a(SwipeBackLayout.this.WL, 200, (float) c.this.zOx, new com.tencent.mm.ui.tools.h.a() {
                                public final void onAnimationEnd() {
                                    AppMethodBeat.i(107982);
                                    SwipeBackLayout.this.zOo = true;
                                    al.d(new Runnable() {
                                        public final void run() {
                                            AppMethodBeat.i(107981);
                                            if (SwipeBackLayout.this.zOv != null) {
                                                if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.zOs != null) {
                                                    if (SwipeBackLayout.this.zOu) {
                                                        ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.zOs);
                                                    }
                                                    SwipeBackLayout.this.zOs = null;
                                                }
                                                SwipeBackLayout.this.zOv.onSwipeBack();
                                                ab.d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                                            }
                                            h.bq(1.0f);
                                            SwipeBackLayout.this.zOp = false;
                                            AppMethodBeat.o(107981);
                                        }
                                    });
                                    AppMethodBeat.o(107982);
                                }

                                public final void dbb() {
                                    AppMethodBeat.i(107983);
                                    onAnimationEnd();
                                    AppMethodBeat.o(107983);
                                }
                            });
                            h.J(true, c.this.zOx);
                        }
                    }
                    SwipeBackLayout.this.zOq = false;
                    AppMethodBeat.o(107984);
                }
            });
            AppMethodBeat.o(107990);
        }
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.i(107991);
        this.zOf = 0.3f;
        this.mEnable = true;
        this.oT = new Rect();
        this.zOl = true;
        this.zOm = false;
        this.zOn = false;
        this.zOo = false;
        this.zOp = false;
        this.zOq = false;
        this.zOu = true;
        this.zOv = null;
        this.zOk = getResources().getDrawable(R.drawable.atq);
        setFocusable(true);
        setDescendantFocusability(262144);
        init();
        AppMethodBeat.o(107991);
    }

    public final void init() {
        AppMethodBeat.i(107992);
        this.zOi = com.tencent.mm.ui.mogic.a.a((ViewGroup) this, new c(this, (byte) 0), AnimationUtils.loadInterpolator(getContext(), R.anim.bn));
        this.zOi.SS = 1;
        float f = getResources().getDisplayMetrics().density;
        float f2 = 100.0f * f;
        f *= 300.0f;
        this.zOi.SQ = f2;
        this.zOi.SP = f;
        this.zOg = 0;
        this.zOh = 0;
        AppMethodBeat.o(107992);
    }

    public final void qX(boolean z) {
        AppMethodBeat.i(107993);
        ab.i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", Boolean.valueOf(z));
        this.zOn = z;
        AppMethodBeat.o(107993);
    }

    public void setNeedRequestActivityTranslucent(boolean z) {
        this.zOl = z;
        if (this.zOl) {
            this.zOm = false;
        }
    }

    public void setSwipeBackListener(b bVar) {
        this.zOr = bVar;
    }

    public final boolean dkx() {
        AppMethodBeat.i(107994);
        dKR();
        boolean z = this.zOp;
        AppMethodBeat.o(107994);
        return z;
    }

    public void setContentView(View view) {
        this.WL = view;
    }

    public View getTargetContentView() {
        return this.WL;
    }

    public void onFinishInflate() {
        this.WL = this;
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setOnceDisEnableGesture(boolean z) {
        AppMethodBeat.i(107995);
        ab.i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", Boolean.valueOf(z));
        this.zOt = z;
        AppMethodBeat.o(107995);
    }

    public final boolean dKR() {
        AppMethodBeat.i(107996);
        if (!this.zOp) {
            AppMethodBeat.o(107996);
            return false;
        } else if (Float.compare((float) this.WL.getLeft(), 0.01f) <= 0) {
            this.zOp = false;
            AppMethodBeat.o(107996);
            return false;
        } else {
            AppMethodBeat.o(107996);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x01e9 A:{Catch:{ NullPointerException -> 0x00ab, IllegalArgumentException -> 0x00e4, ArrayIndexOutOfBoundsException -> 0x015e }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(107997);
        boolean dispatchTouchEvent;
        if (this.mEnable) {
            if (this.zOr != null) {
                this.zOr.l(motionEvent);
            }
            if (motionEvent.getAction() == 0) {
                this.zOt = false;
            }
            if (this.zOt) {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(107997);
                return dispatchTouchEvent;
            } else if (dKR()) {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(107997);
                return dispatchTouchEvent;
            } else {
                try {
                    int actionMasked;
                    int actionIndex;
                    float x;
                    View F;
                    float x2;
                    float y;
                    float f;
                    float y2;
                    boolean z;
                    if (this.zOi.SG == 1) {
                        com.tencent.mm.ui.mogic.a aVar = this.zOi;
                        actionMasked = motionEvent.getActionMasked();
                        actionIndex = motionEvent.getActionIndex();
                        if (actionMasked == 0) {
                            aVar.cancel();
                        }
                        if (aVar.mVelocityTracker == null) {
                            aVar.mVelocityTracker = VelocityTracker.obtain();
                        }
                        aVar.mVelocityTracker.addMovement(motionEvent);
                        float y3;
                        int y4;
                        int left;
                        int left2;
                        switch (actionMasked) {
                            case 0:
                                x = motionEvent.getX();
                                y3 = motionEvent.getY();
                                actionIndex = motionEvent.getPointerId(0);
                                F = aVar.F((int) x, (int) y3);
                                aVar.a(x, y3, actionIndex);
                                aVar.v(F, actionIndex);
                                if ((aVar.SS & aVar.SL[actionIndex]) != 0) {
                                    break;
                                }
                                break;
                            case 1:
                                if (aVar.SG == 1) {
                                    aVar.eZ();
                                }
                                aVar.cancel();
                                break;
                            case 2:
                                if (aVar.SG == 1) {
                                    actionMasked = motionEvent.findPointerIndex(aVar.mActivePointerId);
                                    y3 = motionEvent.getX(actionMasked);
                                    actionIndex = (int) (y3 - aVar.SJ[aVar.mActivePointerId]);
                                    y4 = (int) (motionEvent.getY(actionMasked) - aVar.SK[aVar.mActivePointerId]);
                                    left = aVar.SU.getLeft() + actionIndex;
                                    actionMasked = aVar.SU.getTop() + y4;
                                    left2 = aVar.SU.getLeft();
                                    int top = aVar.SU.getTop();
                                    if (actionIndex != 0) {
                                        left = aVar.zzE.d(aVar.SU, left);
                                        aVar.SU.offsetLeftAndRight(left - left2);
                                    }
                                    if (y4 != 0) {
                                        aVar.SU.offsetTopAndBottom(0 - top);
                                        actionMasked = 0;
                                    }
                                    if (!(actionIndex == 0 && y4 == 0)) {
                                        aVar.zzE.ht(left, actionMasked);
                                    }
                                    aVar.e(motionEvent);
                                    break;
                                }
                                left = motionEvent.getPointerCount();
                                actionMasked = 0;
                                while (actionMasked < left) {
                                    actionIndex = motionEvent.getPointerId(actionMasked);
                                    x2 = motionEvent.getX(actionMasked);
                                    y = motionEvent.getY(actionMasked);
                                    f = x2 - aVar.SH[actionIndex];
                                    aVar.b(f, y - aVar.SI[actionIndex], actionIndex);
                                    if (aVar.SG != 1) {
                                        F = aVar.F((int) x2, (int) y);
                                        if (!aVar.q(F, f) || !aVar.v(F, actionIndex)) {
                                            actionMasked++;
                                        }
                                    }
                                    aVar.e(motionEvent);
                                    break;
                                }
                                aVar.e(motionEvent);
                                break;
                            case 3:
                                if (aVar.SG == 1) {
                                    aVar.u(0.0f, 0.0f);
                                }
                                aVar.cancel();
                                break;
                            case 5:
                                left = motionEvent.getPointerId(actionIndex);
                                x = motionEvent.getX(actionIndex);
                                y2 = motionEvent.getY(actionIndex);
                                aVar.a(x, y2, left);
                                if (aVar.SG != 0) {
                                    actionMasked = (int) x;
                                    actionIndex = (int) y2;
                                    F = aVar.SU;
                                    if (F == null || actionMasked < F.getLeft() || actionMasked >= F.getRight() || actionIndex < F.getTop() || actionIndex >= F.getBottom()) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        aVar.v(aVar.SU, left);
                                        break;
                                    }
                                }
                                aVar.v(aVar.F((int) x, (int) y2), left);
                                break;
                                break;
                            case 6:
                                actionIndex = motionEvent.getPointerId(actionIndex);
                                if (aVar.SG == 1 && actionIndex == aVar.mActivePointerId) {
                                    y4 = motionEvent.getPointerCount();
                                    for (actionMasked = 0; actionMasked < y4; actionMasked++) {
                                        left2 = motionEvent.getPointerId(actionMasked);
                                        if (left2 != aVar.mActivePointerId) {
                                            if (aVar.F((int) motionEvent.getX(actionMasked), (int) motionEvent.getY(actionMasked)) == aVar.SU && aVar.v(aVar.SU, left2)) {
                                                actionMasked = aVar.mActivePointerId;
                                                if (actionMasked == -1) {
                                                    aVar.eZ();
                                                }
                                            }
                                        }
                                    }
                                    actionMasked = -1;
                                    if (actionMasked == -1) {
                                    }
                                }
                                aVar.aY(actionIndex);
                                break;
                        }
                        AppMethodBeat.o(107997);
                        return true;
                    }
                    com.tencent.mm.ui.mogic.a aVar2 = this.zOi;
                    actionMasked = motionEvent.getActionMasked();
                    int actionIndex2 = motionEvent.getActionIndex();
                    if (actionMasked == 0) {
                        aVar2.cancel();
                    }
                    if (aVar2.mVelocityTracker == null) {
                        aVar2.mVelocityTracker = VelocityTracker.obtain();
                    }
                    aVar2.mVelocityTracker.addMovement(motionEvent);
                    float y5;
                    switch (actionMasked) {
                        case 0:
                            x = motionEvent.getX();
                            y5 = motionEvent.getY();
                            actionIndex = motionEvent.getPointerId(0);
                            aVar2.a(x, y5, actionIndex);
                            View F2 = aVar2.F((int) x, (int) y5);
                            if (F2 == aVar2.SU && aVar2.SG == 2) {
                                aVar2.v(F2, actionIndex);
                            }
                            if ((aVar2.SL[actionIndex] & aVar2.SS) != 0) {
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            aVar2.cancel();
                            break;
                        case 2:
                            actionIndex2 = motionEvent.getPointerCount();
                            actionMasked = 0;
                            while (actionMasked < actionIndex2) {
                                actionIndex = motionEvent.getPointerId(actionMasked);
                                x2 = motionEvent.getX(actionMasked);
                                y = motionEvent.getY(actionMasked);
                                f = x2 - aVar2.SH[actionIndex];
                                aVar2.b(f, y - aVar2.SI[actionIndex], actionIndex);
                                if (aVar2.SG != 1) {
                                    F = aVar2.F((int) x2, (int) y);
                                    if (F == null || !aVar2.q(F, f) || !aVar2.v(F, actionIndex)) {
                                        actionMasked++;
                                    }
                                }
                                aVar2.e(motionEvent);
                                break;
                            }
                            aVar2.e(motionEvent);
                            break;
                        case 5:
                            actionMasked = motionEvent.getPointerId(actionIndex2);
                            y2 = motionEvent.getX(actionIndex2);
                            y5 = motionEvent.getY(actionIndex2);
                            aVar2.a(y2, y5, actionMasked);
                            if (aVar2.SG != 0 && aVar2.SG == 2) {
                                View F3 = aVar2.F((int) y2, (int) y5);
                                if (F3 == aVar2.SU) {
                                    aVar2.v(F3, actionMasked);
                                    break;
                                }
                            }
                            break;
                        case 6:
                            aVar2.aY(motionEvent.getPointerId(actionIndex2));
                            break;
                    }
                    if (aVar2.SG == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        ab.i("changelcai", "shouldInterceptTouchEvent %s", motionEvent);
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        AppMethodBeat.o(107997);
                        return true;
                    }
                    super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(107997);
                    return true;
                } catch (NullPointerException e) {
                    ab.printErrStackTrace("MicroMsg.SwipeBackLayout", e, "got an NullPointerException", new Object[0]);
                    AppMethodBeat.o(107997);
                    return false;
                } catch (IllegalArgumentException e2) {
                    ab.printErrStackTrace("MicroMsg.SwipeBackLayout", e2, "got an IllegalArgumentException", new Object[0]);
                    AppMethodBeat.o(107997);
                    return false;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    ab.printErrStackTrace("MicroMsg.SwipeBackLayout", e3, "got an ArrayIndexOutOfBoundsException", new Object[0]);
                    AppMethodBeat.o(107997);
                    return false;
                }
            }
        }
        dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.o(107997);
        return dispatchTouchEvent;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(107998);
        this.mInLayout = true;
        if (this.WL != null) {
            this.WL.layout(this.zOg, this.zOh, this.zOg + this.WL.getMeasuredWidth(), this.zOh + this.WL.getMeasuredHeight());
        }
        this.mInLayout = false;
        AppMethodBeat.o(107998);
    }

    public void requestLayout() {
        AppMethodBeat.i(107999);
        if (!this.mInLayout) {
            super.requestLayout();
        }
        AppMethodBeat.o(107999);
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        AppMethodBeat.i(108000);
        Object obj = view == this.WL ? 1 : null;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(Float.compare(this.Qb, 0.0f) <= 0 || obj == null || this.zOi.SG == 0)) {
            Rect rect = this.oT;
            view.getHitRect(rect);
            this.zOk.setBounds(rect.left - this.zOk.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.zOk.setAlpha((int) (this.Qb * 255.0f));
            this.zOk.draw(canvas);
        }
        AppMethodBeat.o(108000);
        return drawChild;
    }

    public void computeScroll() {
        Object obj;
        AppMethodBeat.i(108001);
        this.Qb = Math.max(0.0f, 1.0f - this.zOj);
        com.tencent.mm.ui.mogic.a aVar = this.zOi;
        if (aVar.SG == 2) {
            boolean computeScrollOffset = aVar.jlU.qN.computeScrollOffset();
            int currX = aVar.jlU.qN.getCurrX();
            int currY = aVar.jlU.qN.getCurrY();
            int left = currX - aVar.SU.getLeft();
            int top = currY - aVar.SU.getTop();
            if (left != 0) {
                aVar.SU.offsetLeftAndRight(left);
            }
            if (top != 0) {
                aVar.SU.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                aVar.zzE.ht(currX, currY);
            }
            if (computeScrollOffset && currX == aVar.jlU.qN.getFinalX() && currY == aVar.jlU.qN.getFinalY()) {
                aVar.jlU.qN.abortAnimation();
                computeScrollOffset = aVar.jlU.qN.isFinished();
            }
            if (!computeScrollOffset) {
                aVar.SW.post(aVar.SX);
            }
        }
        if (aVar.SG == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            s.R(this);
        }
        AppMethodBeat.o(108001);
    }

    public void setNeedChangeWindowBackground(boolean z) {
        this.zOu = z;
    }

    public void setSwipeGestureDelegate(a aVar) {
        this.zOv = aVar;
    }
}
