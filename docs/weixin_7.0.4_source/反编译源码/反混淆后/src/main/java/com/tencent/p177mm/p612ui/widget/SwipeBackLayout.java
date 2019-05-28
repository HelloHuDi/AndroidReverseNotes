package com.tencent.p177mm.p612ui.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.p612ui.base.C5274b.C5272a;
import com.tencent.p177mm.p612ui.mogic.C5516a;
import com.tencent.p177mm.p612ui.mogic.C5516a.C5515a;
import com.tencent.p177mm.p612ui.tools.C5587h;
import com.tencent.p177mm.p612ui.tools.C5587h.C5586a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.ui.widget.SwipeBackLayout */
public class SwipeBackLayout extends FrameLayout {
    /* renamed from: Qb */
    private float f1331Qb;
    /* renamed from: WL */
    public View f1332WL;
    private boolean mEnable;
    private boolean mInLayout;
    /* renamed from: oT */
    private Rect f1333oT;
    private float zOf;
    private int zOg;
    private int zOh;
    public C5516a zOi;
    private float zOj;
    public Drawable zOk;
    private boolean zOl;
    private boolean zOm;
    public boolean zOn;
    public boolean zOo;
    public boolean zOp;
    private boolean zOq;
    private C5629b zOr;
    private Drawable zOs;
    private boolean zOt;
    private boolean zOu;
    public C5628a zOv;

    /* renamed from: com.tencent.mm.ui.widget.SwipeBackLayout$a */
    public interface C5628a {
        void onCancel();

        void onDrag();

        void onSwipeBack();
    }

    /* renamed from: com.tencent.mm.ui.widget.SwipeBackLayout$b */
    public interface C5629b {
        /* renamed from: ba */
        boolean mo11403ba(boolean z);

        /* renamed from: bf */
        void mo11404bf(float f);

        /* renamed from: l */
        void mo11405l(MotionEvent motionEvent);
    }

    /* renamed from: com.tencent.mm.ui.widget.SwipeBackLayout$c */
    class C5635c extends C5515a implements C5272a {
        int zOw;
        int zOx;
        int zOy;

        /* renamed from: com.tencent.mm.ui.widget.SwipeBackLayout$c$1 */
        class C56301 implements Runnable {
            C56301() {
            }

            public final void run() {
                AppMethodBeat.m2504i(107978);
                if (SwipeBackLayout.this.zOv != null) {
                    C4990ab.m7416i("MicroMsg.SwipeBackLayout", "ashutest:: on popOut");
                    if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.zOs != null) {
                        if (SwipeBackLayout.this.zOu) {
                            ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.zOs);
                        }
                        SwipeBackLayout.this.zOs = null;
                    }
                    SwipeBackLayout.this.zOv.onSwipeBack();
                }
                SwipeBackLayout.this.zOp = false;
                AppMethodBeat.m2505o(107978);
            }
        }

        private C5635c() {
            this.zOw = 0;
            this.zOx = 0;
            this.zOy = 0;
        }

        /* synthetic */ C5635c(SwipeBackLayout swipeBackLayout, byte b) {
            this();
        }

        /* renamed from: PG */
        public final boolean mo11129PG(int i) {
            int i2;
            AppMethodBeat.m2504i(107985);
            C5516a a = SwipeBackLayout.this.zOi;
            if ((a.f1315SO & (1 << i)) != 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0 || (a.f1312SL[i] & 1) == 0) {
                AppMethodBeat.m2505o(107985);
                return false;
            }
            AppMethodBeat.m2505o(107985);
            return true;
        }

        public final int dJm() {
            return 1;
        }

        /* renamed from: ht */
        public final void mo11133ht(int i, int i2) {
            AppMethodBeat.m2504i(107986);
            if (SwipeBackLayout.this.zOn) {
                SwipeBackLayout.this.zOj = Math.abs(((float) i) / ((float) (SwipeBackLayout.this.f1332WL.getWidth() + SwipeBackLayout.this.zOk.getIntrinsicWidth())));
                SwipeBackLayout.this.zOg = i;
                SwipeBackLayout.this.zOh = i2;
                SwipeBackLayout.this.invalidate();
                if (SwipeBackLayout.this.zOr != null) {
                    SwipeBackLayout.this.zOr.mo11404bf(SwipeBackLayout.this.zOj);
                }
                if (Float.compare(SwipeBackLayout.this.zOj, 1.0f) >= 0 && !SwipeBackLayout.this.zOo) {
                    SwipeBackLayout.this.zOo = true;
                    C5004al.m7441d(new C56301());
                } else if (Float.compare(SwipeBackLayout.this.zOj, 0.01f) <= 0) {
                    SwipeBackLayout.this.zOp = false;
                    C4990ab.m7421w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mScrollPercent:%s mHasCallPopOut:%s", Float.valueOf(SwipeBackLayout.this.zOj), Boolean.valueOf(SwipeBackLayout.this.zOo));
                }
                if (SwipeBackLayout.this.zOi.f1307SG == 1) {
                    C5666h.m8514bq(SwipeBackLayout.this.zOj);
                }
                AppMethodBeat.m2505o(107986);
                return;
            }
            C4990ab.m7420w("MicroMsg.SwipeBackLayout", "[onViewPositionChanged] mHasTranslucent is false");
            AppMethodBeat.m2505o(107986);
        }

        /* renamed from: a */
        public final void mo11130a(View view, float f, float f2) {
            boolean z = false;
            AppMethodBeat.m2504i(107987);
            int width = view.getWidth();
            this.zOx = 0;
            this.zOy = 0;
            width = (f > 0.0f || (f == 0.0f && SwipeBackLayout.this.zOj > SwipeBackLayout.this.zOf)) ? (width + SwipeBackLayout.this.zOk.getIntrinsicWidth()) + 10 : 0;
            this.zOx = width;
            C4990ab.m7417i("MicroMsg.SwipeBackLayout", "ashutest::onViewReleased, xvel:%f yvel:%f, releaseLeft:%d, releaseTop:%d, translucent %B", Float.valueOf(f), Float.valueOf(f2), Integer.valueOf(this.zOx), Integer.valueOf(this.zOy), Boolean.valueOf(SwipeBackLayout.this.zOn));
            SwipeBackLayout.this.zOp = true;
            if (SwipeBackLayout.this.zOr != null) {
                C5629b e = SwipeBackLayout.this.zOr;
                if (this.zOx != 0) {
                    z = true;
                }
                if (e.mo11403ba(z)) {
                    C4990ab.m7416i("MicroMsg.SwipeBackLayout", "intercepted by mSwipeBackListener.onViewReleased");
                    AppMethodBeat.m2505o(107987);
                    return;
                }
            }
            if (SwipeBackLayout.this.zOn) {
                C5516a a = SwipeBackLayout.this.zOi;
                int i = this.zOx;
                int i2 = this.zOy;
                if (a.f1321SV) {
                    a.mo11138b(i, i2, (int) a.mVelocityTracker.getXVelocity(a.mActivePointerId), (int) a.mVelocityTracker.getYVelocity(a.mActivePointerId), 0);
                    SwipeBackLayout.this.invalidate();
                    AppMethodBeat.m2505o(107987);
                    return;
                }
                IllegalStateException illegalStateException = new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
                AppMethodBeat.m2505o(107987);
                throw illegalStateException;
            }
            SwipeBackLayout.this.zOq = true;
            AppMethodBeat.m2505o(107987);
        }

        /* renamed from: d */
        public final int mo11131d(View view, int i) {
            AppMethodBeat.m2504i(107988);
            if (SwipeBackLayout.this.zOn) {
                int max = Math.max(this.zOw, i);
                this.zOw = 0;
                int min = Math.min(view.getWidth(), Math.max(max, 0));
                AppMethodBeat.m2505o(107988);
                return min;
            }
            this.zOw = Math.max(this.zOw, i);
            AppMethodBeat.m2505o(107988);
            return 0;
        }

        /* renamed from: N */
        public final void mo11128N(int i) {
            AppMethodBeat.m2504i(107989);
            C4990ab.m7417i("MicroMsg.SwipeBackLayout", "ashutest::onViewDragStateChanged state %d, requestedTranslucent %B fastRelease %B", Integer.valueOf(i), Boolean.valueOf(SwipeBackLayout.this.zOm), Boolean.valueOf(SwipeBackLayout.this.zOq));
            if (1 == i) {
                C4990ab.m7416i("MicroMsg.SwipeBackLayout", "ashutest:: on drag");
                if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.zOs == null) {
                    SwipeBackLayout.this.zOs = ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().getBackground();
                    if (SwipeBackLayout.this.zOu) {
                        ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackgroundResource(C25738R.color.a3p);
                    }
                }
                if (SwipeBackLayout.this.zOv != null) {
                    SwipeBackLayout.this.zOv.onDrag();
                }
                SwipeBackLayout.this.zOo = false;
                if (SwipeBackLayout.this.zOn) {
                    C5666h.m8514bq(0.0f);
                }
            }
            if (i == 0 && !SwipeBackLayout.this.zOq) {
                C4990ab.m7416i("MicroMsg.SwipeBackLayout", "ashutest:: on cancel");
                if (SwipeBackLayout.this.zOv != null) {
                    if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.zOs != null) {
                        if (SwipeBackLayout.this.zOu) {
                            ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.zOs);
                        }
                        SwipeBackLayout.this.zOs = null;
                    }
                    SwipeBackLayout.this.zOv.onCancel();
                }
                C5666h.m8514bq(1.0f);
            }
            if (1 == i && SwipeBackLayout.this.zOl && (SwipeBackLayout.this.getContext() instanceof Activity) && !SwipeBackLayout.this.zOn && !SwipeBackLayout.this.zOm) {
                C4990ab.m7416i("MicroMsg.SwipeBackLayout", "ashutest:: match dragging");
                SwipeBackLayout.this.zOm = true;
                C5274b.m8045a((Activity) SwipeBackLayout.this.getContext(), this);
            }
            if (2 == i) {
                boolean z;
                C4990ab.m7417i("MicroMsg.SwipeBackLayout", "ashutest:: notify settle, mReleasedLeft %d", Integer.valueOf(this.zOx));
                if (this.zOx > 0) {
                    z = true;
                } else {
                    z = false;
                }
                C5666h.m8511J(z, this.zOx);
            }
            AppMethodBeat.m2505o(107989);
        }

        /* renamed from: iH */
        public final void mo10877iH(final boolean z) {
            AppMethodBeat.m2504i(107990);
            C5004al.m7441d(new Runnable() {

                /* renamed from: com.tencent.mm.ui.widget.SwipeBackLayout$c$2$1 */
                class C56331 implements C5586a {
                    C56331() {
                    }

                    public final void onAnimationEnd() {
                        AppMethodBeat.m2504i(107979);
                        SwipeBackLayout.this.zOp = false;
                        AppMethodBeat.m2505o(107979);
                    }

                    public final void dbb() {
                        AppMethodBeat.m2504i(107980);
                        onAnimationEnd();
                        AppMethodBeat.m2505o(107980);
                    }
                }

                /* renamed from: com.tencent.mm.ui.widget.SwipeBackLayout$c$2$2 */
                class C56342 implements C5586a {

                    /* renamed from: com.tencent.mm.ui.widget.SwipeBackLayout$c$2$2$1 */
                    class C56311 implements Runnable {
                        C56311() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(107981);
                            if (SwipeBackLayout.this.zOv != null) {
                                if ((SwipeBackLayout.this.getContext() instanceof Activity) && SwipeBackLayout.this.zOs != null) {
                                    if (SwipeBackLayout.this.zOu) {
                                        ((Activity) SwipeBackLayout.this.getContext()).getWindow().getDecorView().setBackground(SwipeBackLayout.this.zOs);
                                    }
                                    SwipeBackLayout.this.zOs = null;
                                }
                                SwipeBackLayout.this.zOv.onSwipeBack();
                                C4990ab.m7410d("MicroMsg.SwipeBackLayout", "ashutest:: on onSwipeBack");
                            }
                            C5666h.m8514bq(1.0f);
                            SwipeBackLayout.this.zOp = false;
                            AppMethodBeat.m2505o(107981);
                        }
                    }

                    C56342() {
                    }

                    public final void onAnimationEnd() {
                        AppMethodBeat.m2504i(107982);
                        SwipeBackLayout.this.zOo = true;
                        C5004al.m7441d(new C56311());
                        AppMethodBeat.m2505o(107982);
                    }

                    public final void dbb() {
                        AppMethodBeat.m2504i(107983);
                        onAnimationEnd();
                        AppMethodBeat.m2505o(107983);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(107984);
                    C4990ab.m7417i("MicroMsg.SwipeBackLayout", "on Complete, result %B, releaseLeft %d", Boolean.valueOf(z), Integer.valueOf(C5635c.this.zOx));
                    SwipeBackLayout.this.zOm = z;
                    if (!z) {
                        SwipeBackLayout.this.zOp = false;
                    } else if (C5635c.this.zOx > 0) {
                        C5666h.m8514bq(0.0f);
                    } else {
                        C5666h.m8514bq(1.0f);
                    }
                    SwipeBackLayout.this.mo11418qX(z);
                    if (z && SwipeBackLayout.this.zOq) {
                        if (C5635c.this.zOx == 0) {
                            C5587h.m8387a(SwipeBackLayout.this.f1332WL, 200, 0.0f, new C56331());
                        } else {
                            C5587h.m8387a(SwipeBackLayout.this.f1332WL, 200, (float) C5635c.this.zOx, new C56342());
                            C5666h.m8511J(true, C5635c.this.zOx);
                        }
                    }
                    SwipeBackLayout.this.zOq = false;
                    AppMethodBeat.m2505o(107984);
                }
            });
            AppMethodBeat.m2505o(107990);
        }
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeBackLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(107991);
        this.zOf = 0.3f;
        this.mEnable = true;
        this.f1333oT = new Rect();
        this.zOl = true;
        this.zOm = false;
        this.zOn = false;
        this.zOo = false;
        this.zOp = false;
        this.zOq = false;
        this.zOu = true;
        this.zOv = null;
        this.zOk = getResources().getDrawable(C25738R.drawable.atq);
        setFocusable(true);
        setDescendantFocusability(262144);
        init();
        AppMethodBeat.m2505o(107991);
    }

    public final void init() {
        AppMethodBeat.m2504i(107992);
        this.zOi = C5516a.m8303a((ViewGroup) this, new C5635c(this, (byte) 0), AnimationUtils.loadInterpolator(getContext(), C25738R.anim.f8348bn));
        this.zOi.f1319SS = 1;
        float f = getResources().getDisplayMetrics().density;
        float f2 = 100.0f * f;
        f *= 300.0f;
        this.zOi.f1317SQ = f2;
        this.zOi.f1316SP = f;
        this.zOg = 0;
        this.zOh = 0;
        AppMethodBeat.m2505o(107992);
    }

    /* renamed from: qX */
    public final void mo11418qX(boolean z) {
        AppMethodBeat.m2504i(107993);
        C4990ab.m7417i("MicroMsg.SwipeBackLayout", "ashutest::markTranslucent %B", Boolean.valueOf(z));
        this.zOn = z;
        AppMethodBeat.m2505o(107993);
    }

    public void setNeedRequestActivityTranslucent(boolean z) {
        this.zOl = z;
        if (this.zOl) {
            this.zOm = false;
        }
    }

    public void setSwipeBackListener(C5629b c5629b) {
        this.zOr = c5629b;
    }

    public final boolean dkx() {
        AppMethodBeat.m2504i(107994);
        dKR();
        boolean z = this.zOp;
        AppMethodBeat.m2505o(107994);
        return z;
    }

    public void setContentView(View view) {
        this.f1332WL = view;
    }

    public View getTargetContentView() {
        return this.f1332WL;
    }

    public void onFinishInflate() {
        this.f1332WL = this;
    }

    public void setEnableGesture(boolean z) {
        this.mEnable = z;
    }

    public void setOnceDisEnableGesture(boolean z) {
        AppMethodBeat.m2504i(107995);
        C4990ab.m7417i("MicroMsg.SwipeBackLayout", "[setOnceDisEnableGesture] enable:%s", Boolean.valueOf(z));
        this.zOt = z;
        AppMethodBeat.m2505o(107995);
    }

    public final boolean dKR() {
        AppMethodBeat.m2504i(107996);
        if (!this.zOp) {
            AppMethodBeat.m2505o(107996);
            return false;
        } else if (Float.compare((float) this.f1332WL.getLeft(), 0.01f) <= 0) {
            this.zOp = false;
            AppMethodBeat.m2505o(107996);
            return false;
        } else {
            AppMethodBeat.m2505o(107996);
            return true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:93:0x01e9 A:{Catch:{ NullPointerException -> 0x00ab, IllegalArgumentException -> 0x00e4, ArrayIndexOutOfBoundsException -> 0x015e }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(107997);
        boolean dispatchTouchEvent;
        if (this.mEnable) {
            if (this.zOr != null) {
                this.zOr.mo11405l(motionEvent);
            }
            if (motionEvent.getAction() == 0) {
                this.zOt = false;
            }
            if (this.zOt) {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(107997);
                return dispatchTouchEvent;
            } else if (dKR()) {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(107997);
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
                    if (this.zOi.f1307SG == 1) {
                        C5516a c5516a = this.zOi;
                        actionMasked = motionEvent.getActionMasked();
                        actionIndex = motionEvent.getActionIndex();
                        if (actionMasked == 0) {
                            c5516a.cancel();
                        }
                        if (c5516a.mVelocityTracker == null) {
                            c5516a.mVelocityTracker = VelocityTracker.obtain();
                        }
                        c5516a.mVelocityTracker.addMovement(motionEvent);
                        float y3;
                        int y4;
                        int left;
                        int left2;
                        switch (actionMasked) {
                            case 0:
                                x = motionEvent.getX();
                                y3 = motionEvent.getY();
                                actionIndex = motionEvent.getPointerId(0);
                                F = c5516a.mo11134F((int) x, (int) y3);
                                c5516a.mo11135a(x, y3, actionIndex);
                                c5516a.mo11145v(F, actionIndex);
                                if ((c5516a.f1319SS & c5516a.f1312SL[actionIndex]) != 0) {
                                    break;
                                }
                                break;
                            case 1:
                                if (c5516a.f1307SG == 1) {
                                    c5516a.mo11142eZ();
                                }
                                c5516a.cancel();
                                break;
                            case 2:
                                if (c5516a.f1307SG == 1) {
                                    actionMasked = motionEvent.findPointerIndex(c5516a.mActivePointerId);
                                    y3 = motionEvent.getX(actionMasked);
                                    actionIndex = (int) (y3 - c5516a.f1310SJ[c5516a.mActivePointerId]);
                                    y4 = (int) (motionEvent.getY(actionMasked) - c5516a.f1311SK[c5516a.mActivePointerId]);
                                    left = c5516a.f1320SU.getLeft() + actionIndex;
                                    actionMasked = c5516a.f1320SU.getTop() + y4;
                                    left2 = c5516a.f1320SU.getLeft();
                                    int top = c5516a.f1320SU.getTop();
                                    if (actionIndex != 0) {
                                        left = c5516a.zzE.mo11131d(c5516a.f1320SU, left);
                                        c5516a.f1320SU.offsetLeftAndRight(left - left2);
                                    }
                                    if (y4 != 0) {
                                        c5516a.f1320SU.offsetTopAndBottom(0 - top);
                                        actionMasked = 0;
                                    }
                                    if (!(actionIndex == 0 && y4 == 0)) {
                                        c5516a.zzE.mo11133ht(left, actionMasked);
                                    }
                                    c5516a.mo11141e(motionEvent);
                                    break;
                                }
                                left = motionEvent.getPointerCount();
                                actionMasked = 0;
                                while (actionMasked < left) {
                                    actionIndex = motionEvent.getPointerId(actionMasked);
                                    x2 = motionEvent.getX(actionMasked);
                                    y = motionEvent.getY(actionMasked);
                                    f = x2 - c5516a.f1308SH[actionIndex];
                                    c5516a.mo11137b(f, y - c5516a.f1309SI[actionIndex], actionIndex);
                                    if (c5516a.f1307SG != 1) {
                                        F = c5516a.mo11134F((int) x2, (int) y);
                                        if (!c5516a.mo11143q(F, f) || !c5516a.mo11145v(F, actionIndex)) {
                                            actionMasked++;
                                        }
                                    }
                                    c5516a.mo11141e(motionEvent);
                                    break;
                                }
                                c5516a.mo11141e(motionEvent);
                                break;
                            case 3:
                                if (c5516a.f1307SG == 1) {
                                    c5516a.mo11144u(0.0f, 0.0f);
                                }
                                c5516a.cancel();
                                break;
                            case 5:
                                left = motionEvent.getPointerId(actionIndex);
                                x = motionEvent.getX(actionIndex);
                                y2 = motionEvent.getY(actionIndex);
                                c5516a.mo11135a(x, y2, left);
                                if (c5516a.f1307SG != 0) {
                                    actionMasked = (int) x;
                                    actionIndex = (int) y2;
                                    F = c5516a.f1320SU;
                                    if (F == null || actionMasked < F.getLeft() || actionMasked >= F.getRight() || actionIndex < F.getTop() || actionIndex >= F.getBottom()) {
                                        z = false;
                                    } else {
                                        z = true;
                                    }
                                    if (z) {
                                        c5516a.mo11145v(c5516a.f1320SU, left);
                                        break;
                                    }
                                }
                                c5516a.mo11145v(c5516a.mo11134F((int) x, (int) y2), left);
                                break;
                                break;
                            case 6:
                                actionIndex = motionEvent.getPointerId(actionIndex);
                                if (c5516a.f1307SG == 1 && actionIndex == c5516a.mActivePointerId) {
                                    y4 = motionEvent.getPointerCount();
                                    for (actionMasked = 0; actionMasked < y4; actionMasked++) {
                                        left2 = motionEvent.getPointerId(actionMasked);
                                        if (left2 != c5516a.mActivePointerId) {
                                            if (c5516a.mo11134F((int) motionEvent.getX(actionMasked), (int) motionEvent.getY(actionMasked)) == c5516a.f1320SU && c5516a.mo11145v(c5516a.f1320SU, left2)) {
                                                actionMasked = c5516a.mActivePointerId;
                                                if (actionMasked == -1) {
                                                    c5516a.mo11142eZ();
                                                }
                                            }
                                        }
                                    }
                                    actionMasked = -1;
                                    if (actionMasked == -1) {
                                    }
                                }
                                c5516a.mo11136aY(actionIndex);
                                break;
                        }
                        AppMethodBeat.m2505o(107997);
                        return true;
                    }
                    C5516a c5516a2 = this.zOi;
                    actionMasked = motionEvent.getActionMasked();
                    int actionIndex2 = motionEvent.getActionIndex();
                    if (actionMasked == 0) {
                        c5516a2.cancel();
                    }
                    if (c5516a2.mVelocityTracker == null) {
                        c5516a2.mVelocityTracker = VelocityTracker.obtain();
                    }
                    c5516a2.mVelocityTracker.addMovement(motionEvent);
                    float y5;
                    switch (actionMasked) {
                        case 0:
                            x = motionEvent.getX();
                            y5 = motionEvent.getY();
                            actionIndex = motionEvent.getPointerId(0);
                            c5516a2.mo11135a(x, y5, actionIndex);
                            View F2 = c5516a2.mo11134F((int) x, (int) y5);
                            if (F2 == c5516a2.f1320SU && c5516a2.f1307SG == 2) {
                                c5516a2.mo11145v(F2, actionIndex);
                            }
                            if ((c5516a2.f1312SL[actionIndex] & c5516a2.f1319SS) != 0) {
                                break;
                            }
                            break;
                        case 1:
                        case 3:
                            c5516a2.cancel();
                            break;
                        case 2:
                            actionIndex2 = motionEvent.getPointerCount();
                            actionMasked = 0;
                            while (actionMasked < actionIndex2) {
                                actionIndex = motionEvent.getPointerId(actionMasked);
                                x2 = motionEvent.getX(actionMasked);
                                y = motionEvent.getY(actionMasked);
                                f = x2 - c5516a2.f1308SH[actionIndex];
                                c5516a2.mo11137b(f, y - c5516a2.f1309SI[actionIndex], actionIndex);
                                if (c5516a2.f1307SG != 1) {
                                    F = c5516a2.mo11134F((int) x2, (int) y);
                                    if (F == null || !c5516a2.mo11143q(F, f) || !c5516a2.mo11145v(F, actionIndex)) {
                                        actionMasked++;
                                    }
                                }
                                c5516a2.mo11141e(motionEvent);
                                break;
                            }
                            c5516a2.mo11141e(motionEvent);
                            break;
                        case 5:
                            actionMasked = motionEvent.getPointerId(actionIndex2);
                            y2 = motionEvent.getX(actionIndex2);
                            y5 = motionEvent.getY(actionIndex2);
                            c5516a2.mo11135a(y2, y5, actionMasked);
                            if (c5516a2.f1307SG != 0 && c5516a2.f1307SG == 2) {
                                View F3 = c5516a2.mo11134F((int) y2, (int) y5);
                                if (F3 == c5516a2.f1320SU) {
                                    c5516a2.mo11145v(F3, actionMasked);
                                    break;
                                }
                            }
                            break;
                        case 6:
                            c5516a2.mo11136aY(motionEvent.getPointerId(actionIndex2));
                            break;
                    }
                    if (c5516a2.f1307SG == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        C4990ab.m7417i("changelcai", "shouldInterceptTouchEvent %s", motionEvent);
                        motionEvent.setAction(3);
                        super.dispatchTouchEvent(motionEvent);
                        AppMethodBeat.m2505o(107997);
                        return true;
                    }
                    super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.m2505o(107997);
                    return true;
                } catch (NullPointerException e) {
                    C4990ab.printErrStackTrace("MicroMsg.SwipeBackLayout", e, "got an NullPointerException", new Object[0]);
                    AppMethodBeat.m2505o(107997);
                    return false;
                } catch (IllegalArgumentException e2) {
                    C4990ab.printErrStackTrace("MicroMsg.SwipeBackLayout", e2, "got an IllegalArgumentException", new Object[0]);
                    AppMethodBeat.m2505o(107997);
                    return false;
                } catch (ArrayIndexOutOfBoundsException e3) {
                    C4990ab.printErrStackTrace("MicroMsg.SwipeBackLayout", e3, "got an ArrayIndexOutOfBoundsException", new Object[0]);
                    AppMethodBeat.m2505o(107997);
                    return false;
                }
            }
        }
        dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(107997);
        return dispatchTouchEvent;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(107998);
        this.mInLayout = true;
        if (this.f1332WL != null) {
            this.f1332WL.layout(this.zOg, this.zOh, this.zOg + this.f1332WL.getMeasuredWidth(), this.zOh + this.f1332WL.getMeasuredHeight());
        }
        this.mInLayout = false;
        AppMethodBeat.m2505o(107998);
    }

    public void requestLayout() {
        AppMethodBeat.m2504i(107999);
        if (!this.mInLayout) {
            super.requestLayout();
        }
        AppMethodBeat.m2505o(107999);
    }

    /* Access modifiers changed, original: protected */
    public boolean drawChild(Canvas canvas, View view, long j) {
        AppMethodBeat.m2504i(108000);
        Object obj = view == this.f1332WL ? 1 : null;
        boolean drawChild = super.drawChild(canvas, view, j);
        if (!(Float.compare(this.f1331Qb, 0.0f) <= 0 || obj == null || this.zOi.f1307SG == 0)) {
            Rect rect = this.f1333oT;
            view.getHitRect(rect);
            this.zOk.setBounds(rect.left - this.zOk.getIntrinsicWidth(), rect.top, rect.left, rect.bottom);
            this.zOk.setAlpha((int) (this.f1331Qb * 255.0f));
            this.zOk.draw(canvas);
        }
        AppMethodBeat.m2505o(108000);
        return drawChild;
    }

    public void computeScroll() {
        Object obj;
        AppMethodBeat.m2504i(108001);
        this.f1331Qb = Math.max(0.0f, 1.0f - this.zOj);
        C5516a c5516a = this.zOi;
        if (c5516a.f1307SG == 2) {
            boolean computeScrollOffset = c5516a.jlU.f710qN.computeScrollOffset();
            int currX = c5516a.jlU.f710qN.getCurrX();
            int currY = c5516a.jlU.f710qN.getCurrY();
            int left = currX - c5516a.f1320SU.getLeft();
            int top = currY - c5516a.f1320SU.getTop();
            if (left != 0) {
                c5516a.f1320SU.offsetLeftAndRight(left);
            }
            if (top != 0) {
                c5516a.f1320SU.offsetTopAndBottom(top);
            }
            if (!(left == 0 && top == 0)) {
                c5516a.zzE.mo11133ht(currX, currY);
            }
            if (computeScrollOffset && currX == c5516a.jlU.f710qN.getFinalX() && currY == c5516a.jlU.f710qN.getFinalY()) {
                c5516a.jlU.f710qN.abortAnimation();
                computeScrollOffset = c5516a.jlU.f710qN.isFinished();
            }
            if (!computeScrollOffset) {
                c5516a.f1322SW.post(c5516a.f1323SX);
            }
        }
        if (c5516a.f1307SG == 2) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            C0477s.m891R(this);
        }
        AppMethodBeat.m2505o(108001);
    }

    public void setNeedChangeWindowBackground(boolean z) {
        this.zOu = z;
    }

    public void setSwipeGestureDelegate(C5628a c5628a) {
        this.zOv = c5628a;
    }
}
