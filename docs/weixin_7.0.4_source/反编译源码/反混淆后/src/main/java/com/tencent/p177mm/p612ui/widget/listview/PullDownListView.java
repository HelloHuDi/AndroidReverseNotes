package com.tencent.p177mm.p612ui.widget.listview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5227ai;
import com.tencent.p177mm.p612ui.C5230ak;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.ui.widget.listview.PullDownListView */
public class PullDownListView extends ListView implements OnItemClickListener, OnItemLongClickListener, OnItemSelectedListener {
    private float aKM;
    private float aKN;
    private OnItemSelectedListener amA;
    private OnItemClickListener amz;
    private View aus;
    private boolean hOy = false;
    private int iVr = 0;
    private int iVs = 0;
    private Vibrator iVt;
    private int iev = 0;
    public boolean isVisible = true;
    private int mActivePointerId = -1;
    private float mLastMotionY;
    private Rect mRect = new Rect();
    /* renamed from: yI */
    private int f13759yI = 0;
    private boolean zRA = false;
    private boolean zRB = false;
    private float zRC;
    private float zRD = 0.0f;
    private int zRE = 0;
    private int zRF = 0;
    private boolean zRG = false;
    private float zRH = 0.0f;
    private int zRI = 0;
    private int zRJ = 0;
    private boolean zRK = false;
    private long zRL = 0;
    private long zRM = 0;
    private OnItemLongClickListener zRN;
    private boolean zRi = false;
    private float zRj = 0.05f;
    private float zRk = 0.05f;
    private float zRl = 0.0f;
    private float zRm = 0.0f;
    public boolean zRn = true;
    private View zRo;
    private View zRp;
    private int zRq = 0;
    public C30804a zRr;
    private boolean zRs = false;
    private final int zRt = 1;
    private final int zRu = 2;
    private final int zRv = 200;
    private View zRw;
    private float zRx = 0.0f;
    private float zRy = 0.0f;
    private boolean zRz = false;

    /* renamed from: com.tencent.mm.ui.widget.listview.PullDownListView$2 */
    class C308022 implements Runnable {
        C308022() {
        }

        public final void run() {
            AppMethodBeat.m2504i(112725);
            C5227ai.m7971d("MicroMsg.PullDownListView", "mThis.getLeft()=%s, mThis.getTop()=%s, mThis.getRight()=%s, mThis.getBottom()=%s", Integer.valueOf(PullDownListView.this.zRo.getLeft()), Integer.valueOf(PullDownListView.this.zRo.getTop()), Integer.valueOf(PullDownListView.this.zRo.getRight()), Integer.valueOf(PullDownListView.this.zRo.getBottom()));
            PullDownListView.this.mRect.set(PullDownListView.this.zRo.getLeft(), PullDownListView.this.zRo.getTop(), PullDownListView.this.zRo.getRight(), PullDownListView.this.zRo.getBottom());
            AppMethodBeat.m2505o(112725);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.listview.PullDownListView$3 */
    class C308033 extends AnimatorListenerAdapter {
        C308033() {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(112726);
            if (PullDownListView.this.zRp != null) {
                PullDownListView.this.zRp.setVisibility(8);
            }
            AppMethodBeat.m2505o(112726);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(112727);
            if (PullDownListView.this.zRp != null) {
                PullDownListView.this.zRp.setVisibility(8);
            }
            AppMethodBeat.m2505o(112727);
        }
    }

    /* renamed from: com.tencent.mm.ui.widget.listview.PullDownListView$a */
    public interface C30804a {
        /* renamed from: AU */
        void mo36928AU(int i);

        /* renamed from: AV */
        void mo36929AV(int i);

        /* renamed from: AW */
        void mo36930AW(int i);

        void caI();

        void caJ();

        void caK();

        void caL();

        void caM();

        /* renamed from: jM */
        void mo36936jM(boolean z);
    }

    /* renamed from: com.tencent.mm.ui.widget.listview.PullDownListView$5 */
    class C308055 implements AnimatorUpdateListener {
        C308055() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(112730);
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) PullDownListView.this.zRw.getLayoutParams();
            marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            PullDownListView.this.zRw.setLayoutParams(marginLayoutParams);
            AppMethodBeat.m2505o(112730);
        }
    }

    /* renamed from: e */
    static /* synthetic */ int m49160e(PullDownListView pullDownListView) {
        AppMethodBeat.m2504i(112753);
        int aOX = pullDownListView.aOX();
        AppMethodBeat.m2505o(112753);
        return aOX;
    }

    /* renamed from: f */
    static /* synthetic */ int m49161f(PullDownListView pullDownListView) {
        AppMethodBeat.m2504i(112754);
        int dLa = pullDownListView.dLa();
        AppMethodBeat.m2505o(112754);
        return dLa;
    }

    public PullDownListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(112731);
        super.setOnItemClickListener(this);
        super.setOnItemLongClickListener(this);
        super.setOnItemSelectedListener(this);
        C5230ak.m7993hy(context);
        this.iev = C5230ak.m7993hy(context).y;
        this.iVt = (Vibrator) getContext().getSystemService("vibrator");
        post(new C308022());
        AppMethodBeat.m2505o(112731);
    }

    public void setSupportOverscroll(boolean z) {
        this.zRi = z;
    }

    public void setTabView(View view) {
        this.aus = view;
    }

    public void setMuteView(final View view) {
        AppMethodBeat.m2504i(112732);
        if (view != null) {
            post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(112724);
                    PullDownListView.this.zRl = (float) (-PullDownListView.this.zRp.getWidth());
                    PullDownListView.this.zRm = (float) PullDownListView.this.zRp.getHeight();
                    PullDownListView.this.zRp.setVisibility(8);
                    view.bringToFront();
                    AppMethodBeat.m2505o(112724);
                }
            });
        } else {
            this.zRl = 0.0f;
            this.zRm = 0.0f;
        }
        this.zRp = view;
        AppMethodBeat.m2505o(112732);
    }

    public void setNavigationBarHeight(int i) {
        AppMethodBeat.m2504i(112733);
        C5227ai.m7973i("MicroMsg.PullDownListView", "setNavigationBarHeight=%s", Integer.valueOf(i));
        this.zRq = i;
        AppMethodBeat.m2505o(112733);
    }

    /* renamed from: x */
    public final void mo49263x(View view, int i, int i2) {
        this.zRw = view;
        this.zRF = i;
        this.zRE = i2;
        this.iVs = 0;
        this.iVr = 0;
    }

    private int aOX() {
        if (this.iVr == 0) {
            this.iVr = (int) (((float) this.iev) * this.zRj);
        }
        return this.iVr;
    }

    private int dLa() {
        if (this.iVs == 0) {
            this.iVs = (int) (((float) (this.iev - this.zRF)) * (1.0f - this.zRk));
        }
        return this.iVs;
    }

    /* Access modifiers changed, original: protected */
    @TargetApi(11)
    public void onFinishInflate() {
        AppMethodBeat.m2504i(112734);
        this.zRo = this;
        this.zRC = getTranslationY();
        C5227ai.m7971d("MicroMsg.PullDownListView", "onFinishInflate %s %s %s %s", Integer.valueOf(this.zRo.getLeft()), Integer.valueOf(this.zRo.getTop()), Integer.valueOf(this.zRo.getRight()), Integer.valueOf(this.zRo.getBottom()));
        AppMethodBeat.m2505o(112734);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(112735);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        AppMethodBeat.m2505o(112735);
        return dispatchTouchEvent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0131  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(11)
    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(112736);
        C5227ai.m7971d("MicroMsg.PullDownListView", "dancy test onTouchEvent, supportOverscroll:%s, scrollY:%s", Boolean.valueOf(this.zRi), Integer.valueOf(getScrollY()));
        if (!this.zRi || this.zRo == null || this.zRz) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(112736);
            return onTouchEvent;
        }
        boolean z;
        boolean z2;
        int Qm;
        C5227ai.m7971d("MicroMsg.PullDownListView", "onTouchEvent %s", Integer.valueOf(motionEvent.getActionMasked()));
        float y;
        int findPointerIndex;
        switch (motionEvent.getActionMasked()) {
            case 0:
                if (!this.zRG) {
                    this.mActivePointerId = motionEvent.getPointerId(0);
                    dLd();
                    this.zRs = false;
                    y = motionEvent.getY(0);
                    this.mLastMotionY = y;
                    this.zRx = y;
                    this.zRy = motionEvent.getX(0);
                    this.mRect.setEmpty();
                    this.aKN = motionEvent.getY(0);
                    this.aKM = motionEvent.getX(0);
                    this.zRD = 0.0f;
                    this.zRI = (int) this.zRD;
                    this.zRG = true;
                    this.zRK = false;
                    this.zRL = System.currentTimeMillis();
                    this.zRM = 0;
                    dLe();
                    z = false;
                    break;
                }
            case 1:
                findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex != -1) {
                    this.zRx = motionEvent.getY(findPointerIndex);
                    this.zRy = motionEvent.getX(findPointerIndex);
                    dLb();
                    this.mLastMotionY = 0.0f;
                    this.zRH = 0.0f;
                    this.zRA = false;
                    this.zRM = System.currentTimeMillis() - this.zRL;
                    C5227ai.m7971d("MicroMsg.PullDownListView", "dancy test action up, mDeltaY:%s, closeLimitPx:%s, bottom:%s, mPullDownDuration%s", Integer.valueOf(this.f13759yI), Integer.valueOf(dLa()), Integer.valueOf(this.zRo.getBottom()), Long.valueOf(this.zRM));
                    if (dLc() && this.zRr != null && !this.zRz && this.zRn && !this.zRK) {
                        C5227ai.m7971d("MicroMsg.PullDownListView", "dancy test action up, deltaOverScrollY:%s, translateBaseY:%s", Integer.valueOf(this.zRI), Float.valueOf(this.zRD));
                        if (((float) this.zRI) - this.zRD > 0.0f) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            if ((!this.isVisible || this.f13759yI < aOX()) && (this.isVisible || this.f13759yI < dLa())) {
                                findPointerIndex = 0;
                            } else {
                                findPointerIndex = this.zRo.getBottom() + this.zRq;
                            }
                            m49170z(this.f13759yI, findPointerIndex, m49152T(motionEvent));
                        } else {
                            if (((float) this.zRI) - this.zRD < 0.0f) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            if (z2) {
                                if (this.f13759yI < 0) {
                                    findPointerIndex = 0;
                                } else if (this.f13759yI >= dLa()) {
                                    findPointerIndex = this.zRo.getBottom();
                                } else {
                                    findPointerIndex = 0;
                                }
                                m49170z(this.f13759yI, findPointerIndex, false);
                            }
                        }
                    } else if (!dLc()) {
                        this.hOy = false;
                    }
                    this.zRs = false;
                    this.zRG = false;
                    this.zRI = 0;
                    this.mActivePointerId = -1;
                    this.zRK = false;
                    this.zRM = 0;
                    this.zRL = 0;
                    z = false;
                    break;
                }
                break;
            case 2:
                this.hOy = true;
                if (!this.zRG) {
                    if (this.isVisible) {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        dLd();
                        this.zRs = false;
                        y = motionEvent.getY(0);
                        this.mLastMotionY = y;
                        this.zRx = y;
                        this.zRy = motionEvent.getX(0);
                        this.mRect.setEmpty();
                        this.aKN = motionEvent.getY(0);
                        this.aKM = motionEvent.getX(0);
                        this.zRD = 0.0f;
                        this.zRI = (int) this.zRD;
                        this.zRG = true;
                        dLe();
                    } else {
                        this.mActivePointerId = motionEvent.getPointerId(0);
                        this.mLastMotionY = motionEvent.getY(0);
                        this.aKN = motionEvent.getY(0);
                        this.zRD = (float) (this.iev - this.zRF);
                        this.zRI = (int) this.zRD;
                        this.zRG = true;
                    }
                }
                int findPointerIndex2 = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex2 != -1) {
                    this.zRx = motionEvent.getY(findPointerIndex2);
                    this.zRy = motionEvent.getX(findPointerIndex2);
                    if (this.zRx - this.aKN >= 0.0f) {
                        this.zRJ = 2;
                    } else {
                        this.zRJ = 1;
                    }
                    findPointerIndex = getChildCount();
                    if (findPointerIndex > 0 && this.isVisible) {
                        if (this.zRJ == 2) {
                            z2 = getChildAt(0).getTop() < getPaddingTop() + 0;
                        } else if (this.zRJ == 1) {
                            z2 = getChildAt(findPointerIndex + -1).getBottom() >= getHeight() - getPaddingBottom();
                        }
                        if (z2) {
                            this.zRK = true;
                        }
                        if (!this.zRK) {
                            C5227ai.m7971d("MicroMsg.PullDownListView", "rawY:%s, rawX:%s, indexY:%s, indexX:%s", Float.valueOf(motionEvent.getRawY()), Float.valueOf(motionEvent.getRawX()), Float.valueOf(motionEvent.getY(findPointerIndex2)), Float.valueOf(motionEvent.getX(findPointerIndex2)));
                            C5227ai.m7971d("MicroMsg.PullDownListView", "move deltaY:%s, isAnima:%s, mDeltaY:%s, mIsIgnoreCallBack:%s translateBaseY:%s", Integer.valueOf((int) (this.mLastMotionY - this.zRx)), Boolean.valueOf(this.zRz), Integer.valueOf(this.f13759yI), Boolean.valueOf(this.zRs), Float.valueOf(this.zRD));
                            if (!(this.zRs || this.zRz)) {
                                if (this.mRect.isEmpty()) {
                                    this.zRC = getTranslationY();
                                    this.mRect.set(this.zRo.getLeft(), this.zRo.getTop(), this.zRo.getRight(), this.zRo.getBottom());
                                    C5227ai.m7971d("MicroMsg.PullDownListView", "mRect.isEmpty() %s %s %s %s", Integer.valueOf(this.zRo.getLeft()), Integer.valueOf(this.zRo.getTop()), Integer.valueOf(this.zRo.getRight()), Integer.valueOf(this.zRo.getBottom()));
                                }
                                C5227ai.m7971d("MicroMsg.PullDownListView", "eventIndex:%s, ev.getY():%s, y_down:%s, ev.getY()-y_down:%s", Integer.valueOf(findPointerIndex2), Float.valueOf(motionEvent.getY(findPointerIndex2)), Float.valueOf(this.aKN), Float.valueOf(motionEvent.getY(findPointerIndex2) - this.aKN));
                                this.zRI += (int) (((float) ((int) (this.zRx - this.mLastMotionY))) / 2.0f);
                                this.f13759yI = Math.max(0, this.zRI);
                                C5227ai.m7971d("MicroMsg.PullDownListView", "top %s, bottom:%s, mDeltaY %s, deltaOverScrollY:%s", Integer.valueOf(this.zRo.getTop()), Integer.valueOf(this.zRo.getBottom()), Integer.valueOf(this.f13759yI), Integer.valueOf(this.zRI));
                                if (Math.abs(this.zRI) > 50) {
                                    if (!this.zRA && this.f13759yI >= aOX() && this.f13759yI <= dLa()) {
                                        this.iVt.vibrate(10);
                                        this.zRA = true;
                                        this.zRH = (float) this.zRI;
                                    }
                                    C5227ai.m7971d("MicroMsg.PullDownListView", "OverScroll top %s, mIsIgnoreCallBack:%s, isVisible:%s", Integer.valueOf(this.mRect.top + this.f13759yI), Boolean.valueOf(this.zRs), Boolean.valueOf(this.isVisible));
                                    z = true;
                                } else {
                                    z = false;
                                }
                                this.zRo.setTranslationY((float) this.f13759yI);
                                MarginLayoutParams marginLayoutParams;
                                if (this.isVisible) {
                                    Qm = m49151Qm(Math.max(this.f13759yI - ((int) this.zRD), 0));
                                    if (this.zRw != null) {
                                        marginLayoutParams = (MarginLayoutParams) this.zRw.getLayoutParams();
                                        marginLayoutParams.topMargin = Math.max(this.zRE, Math.min(0, Qm + this.zRE));
                                        C5227ai.m7971d("MicroMsg.PullDownListView", "openingCoordinationView params.bottomMargin:%s", Integer.valueOf(marginLayoutParams.bottomMargin));
                                        this.zRw.setLayoutParams(marginLayoutParams);
                                    }
                                    if (this.zRr != null) {
                                        this.zRr.mo36928AU(m49151Qm(Math.max((this.f13759yI - aOX()) - ((int) this.zRD), 0)));
                                    }
                                } else {
                                    Qm = m49151Qm(Math.max(((int) this.zRD) - this.f13759yI, 0));
                                    if (this.zRw != null) {
                                        marginLayoutParams = (MarginLayoutParams) this.zRw.getLayoutParams();
                                        marginLayoutParams.topMargin = Math.min(0, Math.max(this.zRE, -Qm));
                                        C5227ai.m7971d("MicroMsg.PullDownListView", "closingCoordinationView params.bottomMargin:%s", Integer.valueOf(marginLayoutParams.bottomMargin));
                                        this.zRw.setLayoutParams(marginLayoutParams);
                                    }
                                    if (this.zRr != null) {
                                        this.zRr.mo36929AV(m49151Qm(Math.max(dLa() - this.f13759yI, 0)));
                                    }
                                }
                                if (this.zRH != 0.0f) {
                                    findPointerIndex = (int) (((float) ((int) (((float) this.zRI) - this.zRH))) * 3.0f);
                                    if (!this.isVisible || findPointerIndex <= 0 || this.zRr == null) {
                                        dLd();
                                    } else {
                                        y = (float) findPointerIndex;
                                        if (this.zRp != null) {
                                            this.zRp.setTranslationX(Math.min(this.zRl + y, 0.0f));
                                            this.zRp.setTranslationY(Math.max(this.zRm - y, 0.0f));
                                            this.zRp.setVisibility(0);
                                        }
                                        if (!this.zRB && m49152T(motionEvent)) {
                                            this.iVt.vibrate(20);
                                            this.zRB = true;
                                        } else if (!m49152T(motionEvent)) {
                                            this.zRB = false;
                                        }
                                        if (this.zRB) {
                                            this.zRr.caL();
                                        } else {
                                            this.zRr.caM();
                                        }
                                    }
                                }
                                C5227ai.m7971d("MicroMsg.PullDownListView", "mThis.layout %s %s %s %s", Integer.valueOf(this.zRo.getLeft()), Integer.valueOf(this.zRo.getTop()), Integer.valueOf(this.zRo.getRight()), Integer.valueOf(this.zRo.getBottom()));
                                this.mLastMotionY = this.zRx;
                                break;
                            }
                        }
                        z = false;
                        this.mLastMotionY = this.zRx;
                    }
                    z2 = false;
                    if (z2) {
                    }
                    if (this.zRK) {
                    }
                    z = false;
                    this.mLastMotionY = this.zRx;
                }
                break;
            case 3:
                dLb();
                this.zRG = false;
                this.zRs = false;
                this.mLastMotionY = 0.0f;
                this.zRH = 0.0f;
                this.zRA = false;
                if (this.zRr != null) {
                    bBu();
                }
                this.zRI = 0;
                this.mActivePointerId = -1;
                this.zRK = false;
                this.zRM = 0;
                this.zRL = 0;
                z = false;
                break;
            case 5:
                findPointerIndex = motionEvent.getActionIndex();
                if (findPointerIndex != -1) {
                    this.mLastMotionY = (float) ((int) motionEvent.getY(findPointerIndex));
                    this.mActivePointerId = motionEvent.getPointerId(findPointerIndex);
                    z = false;
                    break;
                }
            case 6:
                findPointerIndex = motionEvent.getActionIndex();
                if (motionEvent.getPointerId(findPointerIndex) == this.mActivePointerId) {
                    findPointerIndex = findPointerIndex == 0 ? 1 : 0;
                    this.mLastMotionY = (float) ((int) motionEvent.getY(findPointerIndex));
                    this.mActivePointerId = motionEvent.getPointerId(findPointerIndex);
                }
                findPointerIndex = motionEvent.getActionIndex();
                if (findPointerIndex != -1) {
                    this.mLastMotionY = (float) ((int) motionEvent.getY(findPointerIndex));
                }
                z = false;
                break;
        }
        z = false;
        C5227ai.m7971d("MicroMsg.PullDownListView", "consumed: %b", Boolean.valueOf(z));
        if (z) {
            motionEvent.setAction(3);
        }
        if (z) {
            AppMethodBeat.m2505o(112736);
            return true;
        }
        try {
            C5227ai.m7971d("MicroMsg.PullDownListView", "super.onTouchEvent(): %b", Boolean.valueOf(super.onTouchEvent(motionEvent)));
            if (this.zRr != null && getChildCount() > 0) {
                C5227ai.m7971d("MicroMsg.PullDownListView", "scrolled %s", Integer.valueOf(getChildAt(0).getTop()));
                this.zRr.mo36930AW(Qm);
            }
            AppMethodBeat.m2505o(112736);
            return z2;
        } catch (Exception e) {
            C5227ai.printErrStackTrace("MicroMsg.PullDownListView", e, "%b, %d", Boolean.valueOf(z), Integer.valueOf(r4));
            AppMethodBeat.m2505o(112736);
            return true;
        }
    }

    private void dLb() {
        AppMethodBeat.m2504i(112737);
        if (this.zRp != null) {
            float translationX = this.zRp.getTranslationX();
            float translationY = this.zRp.getTranslationY();
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.zRp, "translationX", new float[]{translationX, this.zRl});
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.zRp, "translationY", new float[]{translationY, this.zRm});
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
            animatorSet.addListener(new C308033());
            animatorSet.start();
        }
        AppMethodBeat.m2505o(112737);
    }

    /* renamed from: z */
    private void m49170z(final int i, final int i2, final boolean z) {
        AppMethodBeat.m2504i(112738);
        C5227ai.m7973i("MicroMsg.PullDownListView", "story_cat animation: %s %s %s %s %s %s %s %s start:%s, end:%s, openLimitPx():%s, closeLimitPx():%s, isMute:%s", Integer.valueOf(this.mRect.left), Integer.valueOf(this.mRect.top), Integer.valueOf(this.mRect.right), Integer.valueOf(this.mRect.bottom), Integer.valueOf(getLeft()), Integer.valueOf(getTop()), Integer.valueOf(getRight()), Integer.valueOf(getBottom()), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(aOX()), Integer.valueOf(dLa()), Boolean.valueOf(z));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this, "translationY", new float[]{(float) i, (float) i2}));
        if (this.aus != null && i > aOX() && i < dLa()) {
            if (i2 != 0) {
                arrayList.add(ObjectAnimator.ofFloat(this.aus, "translationY", new float[]{(float) i, (float) i2}));
            } else {
                arrayList.add(ObjectAnimator.ofFloat(this.aus, "translationY", new float[]{(float) i, (float) (i2 - this.zRq)}));
            }
        }
        if (this.zRw != null) {
            if (i2 >= getBottom()) {
                arrayList.add(m49164hB(((MarginLayoutParams) this.zRw.getLayoutParams()).topMargin, 0));
            } else {
                arrayList.add(m49164hB(((MarginLayoutParams) this.zRw.getLayoutParams()).topMargin, this.zRE));
            }
        }
        animatorSet.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(112728);
                C5227ai.m7973i("MicroMsg.PullDownListView", "onAnimationStart start:%s, openLimitPx():%s, closeLimitPx():%s", Integer.valueOf(i), Integer.valueOf(PullDownListView.m49160e(PullDownListView.this)), Integer.valueOf(PullDownListView.m49161f(PullDownListView.this)));
                PullDownListView.this.zRz = true;
                if (i2 == 0) {
                    PullDownListView.this.isVisible = true;
                } else {
                    PullDownListView.this.isVisible = false;
                }
                if (PullDownListView.this.zRr != null && i > PullDownListView.m49160e(PullDownListView.this) && i < PullDownListView.m49161f(PullDownListView.this)) {
                    if (PullDownListView.this.isVisible) {
                        PullDownListView.this.zRr.caK();
                        AppMethodBeat.m2505o(112728);
                        return;
                    }
                    PullDownListView.this.zRr.caJ();
                }
                AppMethodBeat.m2505o(112728);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(112729);
                C5227ai.m7973i("MicroMsg.PullDownListView", "onAnimationEnd start:%s, openLimitPx():%s, closeLimitPx():%s", Integer.valueOf(i), Integer.valueOf(PullDownListView.m49160e(PullDownListView.this)), Integer.valueOf(PullDownListView.m49161f(PullDownListView.this)));
                PullDownListView.this.hOy = false;
                PullDownListView.this.zRz = false;
                PullDownListView.this.zRA = false;
                PullDownListView.this.zRB = false;
                if (PullDownListView.this.zRr != null && i > PullDownListView.m49160e(PullDownListView.this) && i < PullDownListView.m49161f(PullDownListView.this)) {
                    if (PullDownListView.this.isVisible) {
                        PullDownListView.this.zRr.caI();
                        if (PullDownListView.this.aus != null) {
                            AppMethodBeat.m2505o(112729);
                            return;
                        }
                    }
                    PullDownListView.this.zRr.mo36936jM(z);
                }
                AppMethodBeat.m2505o(112729);
            }
        });
        animatorSet.playTogether(arrayList);
        animatorSet.start();
        bBu();
        AppMethodBeat.m2505o(112738);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(112739);
        super.onLayout(z, i, i2, i3, i4);
        AppMethodBeat.m2505o(112739);
    }

    @TargetApi(11)
    private void bBu() {
        AppMethodBeat.m2504i(112740);
        this.f13759yI = 0;
        C5227ai.m7971d("MicroMsg.PullDownListView", "startAnimation %s %s %s %s", Integer.valueOf(this.zRo.getLeft()), Integer.valueOf(this.zRo.getTop()), Integer.valueOf(this.zRo.getRight()), Integer.valueOf(this.zRo.getBottom()));
        AppMethodBeat.m2505o(112740);
    }

    private boolean dLc() {
        AppMethodBeat.m2504i(112741);
        if (this.mRect.isEmpty() || Math.abs(this.f13759yI) <= 0) {
            AppMethodBeat.m2505o(112741);
            return false;
        }
        AppMethodBeat.m2505o(112741);
        return true;
    }

    /* renamed from: Qm */
    private int m49151Qm(int i) {
        AppMethodBeat.m2504i(112742);
        C5227ai.m7971d("MicroMsg.PullDownListView", "offset:%s,  ((float) offset / screenHeight):%s,  Math.abs(mCoordinationAnimThreshold):%s,  result:%s", Integer.valueOf(i), Float.valueOf(((float) i) / ((float) this.iev)), Integer.valueOf(Math.abs(this.zRE)), Integer.valueOf((int) Math.abs((((float) i) / ((float) this.iev)) * ((float) this.zRE))));
        AppMethodBeat.m2505o(112742);
        return (int) Math.abs((((float) i) / ((float) this.iev)) * ((float) this.zRE));
    }

    /* JADX WARNING: Missing block: B:26:0x009a, code skipped:
            if (r3 < ((float) (r9.zRp.getBottom() + r9.zRq))) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: T */
    private boolean m49152T(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.m2504i(112743);
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        if (this.zRp != null) {
            if (motionEvent.getActionMasked() != 1 || this.zRM >= 200) {
                if (this.aKM < ((float) this.zRp.getRight())) {
                    if (rawX <= ((float) this.zRp.getLeft()) || rawX >= ((float) this.zRp.getRight()) || rawY <= ((float) (this.zRp.getTop() - (this.zRp.getHeight() / 2))) || rawY >= ((float) (this.zRp.getBottom() + this.zRq))) {
                        z = false;
                    }
                } else if (rawX > ((float) this.zRp.getLeft())) {
                    if (rawX < ((float) this.zRp.getRight())) {
                        if (rawY > ((float) this.zRp.getTop())) {
                        }
                    }
                }
            }
            z = false;
        } else {
            z = false;
        }
        AppMethodBeat.m2505o(112743);
        return z;
    }

    private void dLd() {
        AppMethodBeat.m2504i(112744);
        if (this.zRp != null) {
            this.zRp.setVisibility(8);
        }
        AppMethodBeat.m2505o(112744);
    }

    private void dLe() {
        AppMethodBeat.m2504i(112745);
        if (this.zRp != null) {
            this.zRp.setTranslationX(this.zRl);
            this.zRp.setTranslationY(this.zRm);
            this.zRp.setVisibility(8);
        }
        AppMethodBeat.m2505o(112745);
    }

    /* renamed from: hB */
    private ValueAnimator m49164hB(int i, int i2) {
        AppMethodBeat.m2504i(112746);
        C5227ai.m7971d("MicroMsg.PullDownListView", "startStoryGalleryOpenAnim start:%s, end:%s", Integer.valueOf(i), Integer.valueOf(i2));
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i, i2});
        ofInt.addUpdateListener(new C308055());
        AppMethodBeat.m2505o(112746);
        return ofInt;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.amz = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.zRN = onItemLongClickListener;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener onItemSelectedListener) {
        this.amA = onItemSelectedListener;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(112747);
        if (!(this.amz == null || this.hOy || !this.isVisible)) {
            this.zRs = true;
            this.amz.onItemClick(adapterView, view, i, j);
        }
        AppMethodBeat.m2505o(112747);
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(112748);
        if (!(this.amA == null || this.hOy || !this.isVisible)) {
            this.zRs = true;
            this.amA.onItemSelected(adapterView, view, i, j);
        }
        AppMethodBeat.m2505o(112748);
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        AppMethodBeat.m2504i(112749);
        if (this.amA != null) {
            this.amA.onNothingSelected(adapterView);
        }
        AppMethodBeat.m2505o(112749);
    }

    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        AppMethodBeat.m2504i(112750);
        if (this.zRN == null || this.hOy || !this.isVisible) {
            AppMethodBeat.m2505o(112750);
            return false;
        }
        this.zRs = true;
        boolean onItemLongClick = this.zRN.onItemLongClick(adapterView, view, i, j);
        AppMethodBeat.m2505o(112750);
        return onItemLongClick;
    }

    public final void dLf() {
        AppMethodBeat.m2504i(112751);
        C5227ai.m7973i("MicroMsg.PullDownListView", "switchNormalStatus", new Object[0]);
        if (!this.isVisible) {
            m49170z(dLa() - 1, 0, false);
        }
        AppMethodBeat.m2505o(112751);
    }

    public final void dLg() {
        AppMethodBeat.m2504i(112752);
        C5227ai.m7973i("MicroMsg.PullDownListView", "switchPullDownStatus", new Object[0]);
        if (this.isVisible) {
            m49170z(aOX() + 1, this.zRo.getBottom() + this.zRq, false);
        }
        AppMethodBeat.m2505o(112752);
    }
}
