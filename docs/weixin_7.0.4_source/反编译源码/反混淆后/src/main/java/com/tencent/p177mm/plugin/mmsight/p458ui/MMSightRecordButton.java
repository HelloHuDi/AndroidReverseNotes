package com.tencent.p177mm.plugin.mmsight.p458ui;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCircularProgressBar.C34951;
import com.tencent.p177mm.plugin.mmsight.p458ui.MMSightCircularProgressBar.C3497a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton */
public class MMSightRecordButton extends FrameLayout {
    /* renamed from: LO */
    private static final int f16176LO = ViewConfiguration.getTapTimeout();
    private static final float oAQ = (((float) C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.a66)) / ((float) C4996ah.getContext().getResources().getDimensionPixelSize(C25738R.dimen.a65)));
    private boolean enable = true;
    private C7306ak fbD = new C7306ak(Looper.getMainLooper());
    private boolean isAnimating = false;
    private float neH = -1.0f;
    private long oAR = -1;
    private View oAS;
    private View oAT;
    private MMSightCircularProgressBar oAU;
    private boolean oAV = false;
    private boolean oAW = false;
    private ViewPropertyAnimator oAX;
    private ViewPropertyAnimator oAY;
    private ValueAnimator oAZ;
    private ViewPropertyAnimator oBa;
    private ViewPropertyAnimator oBb;
    private boolean oBc = false;
    private int oBd;
    private int oBe;
    private C12584d oBf;
    private C39409b oBg;
    private C39410c oBh;
    private C39408a oBi;
    private Drawable oBj;
    private Drawable oBk;
    private boolean oBl = false;
    private boolean oBm = false;
    private Runnable oBn = new C394055();
    private Runnable oBo = new C394066();
    private View progressBar;

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$d */
    public interface C12584d {
        void bnX();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$2 */
    class C285202 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatorListenerAdapter oBs = null;

        C285202() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(55092);
            MMSightRecordButton.this.isAnimating = true;
            if (this.oBs != null) {
                this.oBs.onAnimationStart(animator);
            }
            AppMethodBeat.m2505o(55092);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(55093);
            MMSightRecordButton.this.isAnimating = false;
            if (this.oBs != null) {
                this.oBs.onAnimationEnd(animator);
            }
            AppMethodBeat.m2505o(55093);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$5 */
    class C394055 implements Runnable {
        C394055() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55097);
            C4990ab.m7417i("MicroMsg.MMSightRecordButton", "on Long Press, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMSightRecordButton.this.oAV), Boolean.valueOf(MMSightRecordButton.this.oAW));
            if (!MMSightRecordButton.this.oAV) {
                MMSightRecordButton.this.oAW = true;
                if (MMSightRecordButton.this.oBg != null) {
                    MMSightRecordButton.this.oBg.mo30800if();
                }
            }
            AppMethodBeat.m2505o(55097);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$6 */
    class C394066 implements Runnable {
        C394066() {
        }

        public final void run() {
            AppMethodBeat.m2504i(55098);
            C4990ab.m7417i("MicroMsg.MMSightRecordButton", "startTransition, isDown: %s", Boolean.valueOf(MMSightRecordButton.this.oBc));
            if (MMSightRecordButton.this.oBc) {
                MMSightRecordButton.m67259f(MMSightRecordButton.this);
            }
            AppMethodBeat.m2505o(55098);
        }
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$a */
    public interface C39408a {
        void bQu();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$b */
    public interface C39409b {
        void bnU();

        void bnV();

        /* renamed from: if */
        void mo30800if();
    }

    /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$c */
    public interface C39410c {
        /* renamed from: uF */
        void mo30822uF(int i);

        /* renamed from: uG */
        void mo30823uG(int i);
    }

    static {
        AppMethodBeat.m2504i(55116);
        AppMethodBeat.m2505o(55116);
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(55100);
        init();
        AppMethodBeat.m2505o(55100);
    }

    public MMSightRecordButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(55101);
        init();
        AppMethodBeat.m2505o(55101);
    }

    private void init() {
        AppMethodBeat.m2504i(55102);
        C4990ab.m7417i("MicroMsg.MMSightRecordButton", "init, longPressTimeout: %s, tapTimeout: %s", Integer.valueOf(500), Integer.valueOf(f16176LO));
        this.oBj = getContext().getResources().getDrawable(C25738R.drawable.f6908v3);
        this.oBk = getContext().getResources().getDrawable(C25738R.drawable.f6909v4);
        this.oBd = -2236963;
        this.oBe = this.oBd;
        if (this.oBk instanceof GradientDrawable) {
            ((GradientDrawable) this.oBk).setColor(this.oBd);
        }
        C5616v.m8409hu(getContext()).inflate(2130970233, this, true);
        this.oAS = findViewById(2131826113);
        this.oAT = findViewById(2131826112);
        this.progressBar = findViewById(2131821099);
        this.oAU = (MMSightCircularProgressBar) findViewById(2131826114);
        this.oAS.setBackgroundDrawable(this.oBj);
        this.oAT.setBackgroundDrawable(this.oBk);
        this.enable = true;
        AppMethodBeat.m2505o(55102);
    }

    public void setHighLightOuter(int i) {
        AppMethodBeat.m2504i(55103);
        this.oBe = i;
        if (this.oBk instanceof GradientDrawable) {
            ((GradientDrawable) this.oBk).setColor(i);
        }
        AppMethodBeat.m2505o(55103);
    }

    public void setSimpleTapCallback(C12584d c12584d) {
        this.oBf = c12584d;
    }

    public void setLongPressCallback(C39409b c39409b) {
        this.oBg = c39409b;
    }

    public void setLongPressScrollCallback(C39410c c39410c) {
        this.oBh = c39410c;
    }

    public void setErrorPressCallback(C39408a c39408a) {
        this.oBi = c39408a;
    }

    public void setTouchEnable(boolean z) {
        AppMethodBeat.m2504i(55104);
        C4990ab.m7417i("MicroMsg.MMSightRecordButton", "setTouchEnable: %s", Boolean.valueOf(z));
        this.enable = z;
        AppMethodBeat.m2505o(55104);
    }

    public final void bQs() {
        AppMethodBeat.m2504i(55105);
        C4990ab.m7416i("MicroMsg.MMSightRecordButton", "showProgressBar");
        this.progressBar.setVisibility(0);
        AppMethodBeat.m2505o(55105);
    }

    public final void bQt() {
        AppMethodBeat.m2504i(55106);
        C4990ab.m7416i("MicroMsg.MMSightRecordButton", "hideProgressBar");
        this.progressBar.setVisibility(8);
        AppMethodBeat.m2505o(55106);
    }

    /* renamed from: a */
    public final void mo62335a(int i, int i2, final C3497a c3497a) {
        AppMethodBeat.m2504i(55107);
        C4990ab.m7409c("MicroMsg.MMSightRecordButton", "startProgress, initProgress: %s, maxProgress: %s, duration: %s, callback: %s", Integer.valueOf(0), Integer.valueOf(100), Integer.valueOf(i), c3497a);
        this.oAU.setInitProgress(0);
        this.oAU.setMaxProgress(100);
        this.oAU.setDuration(i);
        this.oAU.setVisibility(0);
        this.oAU.setCircularColor(i2);
        this.oAU.setProgressCallback(new C3497a() {

            /* renamed from: com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton$1$1 */
            class C213111 extends AnimatorListenerAdapter {
                C213111() {
                }

                public final void onAnimationEnd(Animator animator) {
                    AppMethodBeat.m2504i(55090);
                    C4990ab.m7409c("MicroMsg.MMSightRecordButton", "call onProgressFinish", new Object[0]);
                    if (c3497a != null) {
                        c3497a.bnW();
                    }
                    AppMethodBeat.m2505o(55090);
                }
            }

            public final void bnW() {
                AppMethodBeat.m2504i(55091);
                C4990ab.m7409c("MicroMsg.MMSightRecordButton", "outer, onProgressFinish", new Object[0]);
                MMSightRecordButton.this.bgk();
                MMSightRecordButton.m67252a(MMSightRecordButton.this, new C213111());
                AppMethodBeat.m2505o(55091);
            }
        });
        MMSightCircularProgressBar mMSightCircularProgressBar = this.oAU;
        C4990ab.m7417i("MicroMsg.MMSightCircularProgressBar", "start, initProgress: %s, maxProgress: %s, duration: %s", Integer.valueOf(mMSightCircularProgressBar.oAI), Integer.valueOf(mMSightCircularProgressBar.oAJ), Integer.valueOf(mMSightCircularProgressBar.duration));
        mMSightCircularProgressBar.oAH = 0.0f;
        mMSightCircularProgressBar.oAL = new C12618c((float) mMSightCircularProgressBar.oAI, (float) mMSightCircularProgressBar.oAJ, mMSightCircularProgressBar.duration);
        C12618c c12618c = mMSightCircularProgressBar.oAL;
        C4990ab.m7417i("MicroMsg.ProgressHandlerAnimator", "setAnimationCallback: %s", new C34951());
        c12618c.oCg = r2;
        C12618c c12618c2 = mMSightCircularProgressBar.oAL;
        C4990ab.m7416i("MicroMsg.ProgressHandlerAnimator", "Start");
        c12618c2.cFy = true;
        c12618c2.eyR = C5046bo.m7588yz();
        c12618c2.fJs.mo16770ae(20, 20);
        AppMethodBeat.m2505o(55107);
    }

    public final void bgk() {
        AppMethodBeat.m2504i(55108);
        MMSightCircularProgressBar mMSightCircularProgressBar = this.oAU;
        mMSightCircularProgressBar.oAM = null;
        mMSightCircularProgressBar.oAI = 0;
        mMSightCircularProgressBar.oAJ = 0;
        mMSightCircularProgressBar.duration = 0;
        mMSightCircularProgressBar.cFy = false;
        if (mMSightCircularProgressBar.oAL != null) {
            C12618c c12618c = mMSightCircularProgressBar.oAL;
            c12618c.cFy = false;
            c12618c.eyR = 0;
            mMSightCircularProgressBar.oAL = null;
        }
        this.oAU.setVisibility(8);
        AppMethodBeat.m2505o(55108);
    }

    /* renamed from: a */
    private void m67250a(final AnimatorListenerAdapter animatorListenerAdapter) {
        AppMethodBeat.m2504i(55109);
        this.isAnimating = true;
        if (this.oBa != null) {
            this.oBa.cancel();
            this.oBa = null;
        }
        this.oBa = this.oAS.animate().scaleX(1.0f).scaleY(1.0f);
        this.oBa.setListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(55094);
                MMSightRecordButton.this.isAnimating = true;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationStart(animator);
                }
                AppMethodBeat.m2505o(55094);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(55095);
                MMSightRecordButton.this.isAnimating = false;
                if (animatorListenerAdapter != null) {
                    animatorListenerAdapter.onAnimationEnd(animator);
                }
                AppMethodBeat.m2505o(55095);
            }
        }).setDuration(150).start();
        if (this.oBb != null) {
            this.oBb.cancel();
            this.oBb = null;
        }
        this.oBb = this.oAT.animate().scaleX(1.0f).scaleY(1.0f);
        this.oBb.setDuration(150).start();
        if (this.oBe != this.oBd) {
            if (this.oAZ != null) {
                this.oAZ.cancel();
            }
            this.oAZ = ObjectAnimator.ofInt(this.oBk, "color", new int[]{this.oBd, this.oBe});
            this.oAZ.setDuration(150);
            this.oAZ.setEvaluator(C3500a.bQq());
            this.oAZ.start();
        }
        AppMethodBeat.m2505o(55109);
    }

    public void setVisibility(final int i) {
        AppMethodBeat.m2504i(55110);
        C4990ab.m7417i("MicroMsg.MMSightRecordButton", "setVisibility, isAnimating: %s", Boolean.valueOf(this.isAnimating));
        if (this.isAnimating) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(55096);
                    MMSightRecordButton.m67251a(MMSightRecordButton.this, i);
                    AppMethodBeat.m2505o(55096);
                }
            }, 150);
            AppMethodBeat.m2505o(55110);
            return;
        }
        super.setVisibility(i);
        AppMethodBeat.m2505o(55110);
    }

    public final void reset() {
        AppMethodBeat.m2504i(55111);
        setClipChildren(false);
        this.enable = true;
        this.oAS.setScaleX(1.0f);
        this.oAS.setScaleY(1.0f);
        this.oAT.setScaleX(1.0f);
        this.oAT.setScaleY(1.0f);
        this.progressBar.setVisibility(8);
        bgk();
        AppMethodBeat.m2505o(55111);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(55112);
        if (this.enable) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.oBc = true;
                    this.oAR = System.currentTimeMillis();
                    this.oAV = false;
                    this.oAW = false;
                    this.neH = motionEvent.getRawY();
                    if (this.oBg != null) {
                        this.oBg.bnV();
                    }
                    this.fbD.postDelayed(this.oBn, 550);
                    this.fbD.postDelayed(this.oBo, 250);
                    this.oBm = true;
                    this.oBl = true;
                    break;
                case 1:
                case 3:
                    this.oBc = false;
                    this.fbD.removeCallbacks(this.oBo, Integer.valueOf(f16176LO));
                    this.fbD.removeCallbacks(this.oBn);
                    if (!(this.oAX == null || this.oAY == null)) {
                        this.oAX.cancel();
                        this.oAY.cancel();
                    }
                    final long currentTimeMillis = System.currentTimeMillis() - this.oAR;
                    C4990ab.m7417i("MicroMsg.MMSightRecordButton", "onAction Up/Cancel, isDispatchLongPress: %s, isDispatchSimpleTap: %s, pressDownTime: %s, upTimeDiff: %s", Boolean.valueOf(this.oAW), Boolean.valueOf(this.oAV), Long.valueOf(this.oAR), Long.valueOf(currentTimeMillis));
                    bgk();
                    m67250a(new AnimatorListenerAdapter() {
                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.m2504i(55099);
                            if (MMSightRecordButton.this.oAR > 0 && currentTimeMillis <= 500) {
                                C4990ab.m7417i("MicroMsg.MMSightRecordButton", "on Simple Tap, isDispatchSimpleTap: %s, isDispatchLongPress: %s", Boolean.valueOf(MMSightRecordButton.this.oAV), Boolean.valueOf(MMSightRecordButton.this.oAW));
                                MMSightRecordButton.this.oAV = true;
                                if (!(MMSightRecordButton.this.oAW || MMSightRecordButton.this.oBf == null)) {
                                    MMSightRecordButton.this.oBf.bnX();
                                    AppMethodBeat.m2505o(55099);
                                    return;
                                }
                            } else if (MMSightRecordButton.this.oAW) {
                                C4990ab.m7416i("MicroMsg.MMSightRecordButton", "on Long Press finish");
                                if (MMSightRecordButton.this.oBg != null) {
                                    MMSightRecordButton.this.oBg.bnU();
                                    AppMethodBeat.m2505o(55099);
                                    return;
                                }
                            } else {
                                C4990ab.m7416i("MicroMsg.MMSightRecordButton", "error action up");
                                if (MMSightRecordButton.this.oBi != null) {
                                    MMSightRecordButton.this.oBi.bQu();
                                }
                            }
                            AppMethodBeat.m2505o(55099);
                        }
                    });
                    break;
                case 2:
                    float rawY = motionEvent.getRawY();
                    if (rawY < ((float) getTop()) && this.oAW) {
                        if (this.neH > 0.0f) {
                            float abs = Math.abs(rawY - this.neH);
                            int min;
                            C39410c c39410c;
                            if (rawY >= this.neH || abs < 10.0f) {
                                if (rawY > this.neH && abs >= 10.0f) {
                                    C4990ab.m7411d("MicroMsg.MMSightRecordButton", "onScroll Down, factor: %s, isFirstScrollDown: %s", Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.oBm));
                                    min = Math.min(min, 3);
                                    if (this.oBh != null) {
                                        c39410c = this.oBh;
                                        if (this.oBm) {
                                            min = 1;
                                        }
                                        c39410c.mo30823uG(min);
                                    }
                                    this.oBm = false;
                                    this.neH = rawY;
                                    break;
                                }
                            }
                            C4990ab.m7411d("MicroMsg.MMSightRecordButton", "onScroll Up, factor: %s, isFirstScrollUp: %s", Integer.valueOf((int) (abs / 10.0f)), Boolean.valueOf(this.oBl));
                            min = Math.min(min, 3);
                            if (this.oBh != null) {
                                c39410c = this.oBh;
                                if (this.oBl) {
                                    min = 1;
                                }
                                c39410c.mo30822uF(min);
                            }
                            this.neH = rawY;
                            this.oBl = false;
                            break;
                        }
                        this.neH = motionEvent.getRawY();
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(55112);
        } else {
            C4990ab.m7416i("MicroMsg.MMSightRecordButton", "onTouchEvent, not enable, ignore");
            AppMethodBeat.m2505o(55112);
        }
        return true;
    }

    /* renamed from: f */
    static /* synthetic */ void m67259f(MMSightRecordButton mMSightRecordButton) {
        AppMethodBeat.m2504i(55115);
        mMSightRecordButton.isAnimating = true;
        if (mMSightRecordButton.oAX != null) {
            mMSightRecordButton.oAX.cancel();
            mMSightRecordButton.oAX = null;
        }
        mMSightRecordButton.oAX = mMSightRecordButton.oAS.animate().scaleX(0.67f).scaleY(0.67f);
        mMSightRecordButton.oAX.setListener(new C285202()).setDuration(150).start();
        if (mMSightRecordButton.oAY != null) {
            mMSightRecordButton.oAY.cancel();
            mMSightRecordButton.oAY = null;
        }
        mMSightRecordButton.oAY = mMSightRecordButton.oAT.animate().scaleX(oAQ).scaleY(oAQ);
        mMSightRecordButton.oAY.setDuration(150).start();
        if (mMSightRecordButton.oBe != mMSightRecordButton.oBd) {
            if (mMSightRecordButton.oAZ != null) {
                mMSightRecordButton.oAZ.cancel();
            }
            mMSightRecordButton.oAZ = ObjectAnimator.ofInt(mMSightRecordButton.oBk, "color", new int[]{mMSightRecordButton.oBe, mMSightRecordButton.oBd});
            mMSightRecordButton.oAZ.setDuration(150);
            mMSightRecordButton.oAZ.setEvaluator(C3500a.bQq());
            mMSightRecordButton.oAZ.start();
        }
        AppMethodBeat.m2505o(55115);
    }
}
