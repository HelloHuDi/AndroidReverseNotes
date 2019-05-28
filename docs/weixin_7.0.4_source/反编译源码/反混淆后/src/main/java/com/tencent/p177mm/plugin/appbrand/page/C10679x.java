package com.tencent.p177mm.plugin.appbrand.page;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.page.x */
public class C10679x extends FrameLayout {
    /* renamed from: AL */
    private int f2879AL;
    /* renamed from: WL */
    View f2880WL;
    View itI;
    FrameLayout itJ;
    FrameLayout itK;
    public boolean itL = true;
    private boolean itM = false;
    private boolean itN = false;
    private boolean itO = false;
    private boolean itP = false;
    private int itQ;
    private int itR;
    private boolean itS = false;
    private ObjectAnimator itT = null;
    private int mTouchSlop;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.x$1 */
    class C106801 implements AnimatorUpdateListener {
        C106801() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(87277);
            C10679x.this.mo22228pt((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
            AppMethodBeat.m2505o(87277);
        }
    }

    public C10679x(Context context) {
        super(context);
        AppMethodBeat.m2504i(87278);
        setLayoutParams(new LayoutParams(-1, -1));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.m2505o(87278);
    }

    public void setPullDownEnabled(boolean z) {
        this.itL = !z;
    }

    public void setNeedStay(boolean z) {
        this.itM = z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(87279);
        if (this.itL) {
            boolean z = this.itP;
            AppMethodBeat.m2505o(87279);
            return z;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.itO = false;
            this.itS = false;
            AppMethodBeat.m2505o(87279);
            return false;
        } else if (action == 2 && this.itO) {
            AppMethodBeat.m2505o(87279);
            return true;
        } else {
            switch (action) {
                case 0:
                    if (aAO()) {
                        this.itQ = (int) motionEvent.getX();
                        this.itR = (int) motionEvent.getY();
                        this.f2879AL = (int) motionEvent.getY();
                        this.itO = false;
                        this.itS = true;
                        break;
                    }
                    break;
                case 2:
                    if (aAO()) {
                        if (this.itS) {
                            action = (int) motionEvent.getX();
                            int y = (int) motionEvent.getY();
                            int i = action - this.itQ;
                            int i2 = y - this.itR;
                            if (Math.abs(i2) > this.mTouchSlop && Math.abs(i2) > Math.abs(i) && i2 > 0) {
                                this.itQ = action;
                                this.itR = y;
                                this.itO = true;
                                this.itS = false;
                                AppMethodBeat.m2505o(87279);
                                return true;
                            }
                        }
                        this.itQ = (int) motionEvent.getX();
                        this.itR = (int) motionEvent.getY();
                        this.f2879AL = (int) motionEvent.getY();
                        this.itO = false;
                        this.itS = true;
                        AppMethodBeat.m2505o(87279);
                        return false;
                    }
                    break;
            }
            if (this.itO || this.itP) {
                AppMethodBeat.m2505o(87279);
                return true;
            }
            AppMethodBeat.m2505o(87279);
            return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(87280);
        if (this.itL) {
            if (this.itP) {
                aKb();
            }
            boolean z = this.itP;
            AppMethodBeat.m2505o(87280);
            return z;
        } else if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (aAO() || this.itP) {
                        this.itR = (int) motionEvent.getY();
                        this.itQ = (int) motionEvent.getX();
                        this.f2879AL = (int) motionEvent.getY();
                        this.itS = true;
                        AppMethodBeat.m2505o(87280);
                        return true;
                    }
                case 1:
                case 3:
                    this.itS = false;
                    if (this.itK.getTranslationY() > ((float) getOpenHeight()) && this.itM) {
                        aKa();
                        AppMethodBeat.m2505o(87280);
                        return true;
                    } else if (this.itO || this.itP) {
                        aKb();
                        AppMethodBeat.m2505o(87280);
                        return true;
                    }
                    break;
                case 2:
                    if (this.itO || this.itP) {
                        if (this.itS) {
                            int y = (((int) motionEvent.getY()) - this.f2879AL) >> 1;
                            int maxOverScrollDistance = getMaxOverScrollDistance();
                            if (y <= maxOverScrollDistance) {
                                maxOverScrollDistance = y;
                            }
                            if (this.itN) {
                                maxOverScrollDistance += getStayHeight();
                            }
                            maxOverScrollDistance = Math.max(maxOverScrollDistance, 0);
                            C4990ab.m7411d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", Integer.valueOf(r4), Integer.valueOf(maxOverScrollDistance));
                            this.itK.setTranslationY((float) Math.min(getMaxOverScrollDistance(), maxOverScrollDistance));
                            mo22228pt(maxOverScrollDistance);
                            AppMethodBeat.m2505o(87280);
                            return true;
                        }
                        this.itR = (int) motionEvent.getY();
                        this.itQ = (int) motionEvent.getX();
                        this.f2879AL = (int) motionEvent.getY();
                        this.itS = true;
                        AppMethodBeat.m2505o(87280);
                        return true;
                    }
            }
            AppMethodBeat.m2505o(87280);
            return false;
        } else {
            AppMethodBeat.m2505o(87280);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aKa() {
        AppMethodBeat.m2504i(87281);
        m18370pu(getStayHeight());
        if (!this.itN) {
            aKc();
        }
        this.itO = true;
        this.itN = true;
        this.itP = true;
        AppMethodBeat.m2505o(87281);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aKb() {
        AppMethodBeat.m2504i(87282);
        m18370pu(0);
        if (this.itN) {
            aKd();
        }
        this.itO = false;
        this.itN = false;
        this.itP = false;
        AppMethodBeat.m2505o(87282);
    }

    /* Access modifiers changed, original: protected */
    public void aKc() {
    }

    /* Access modifiers changed, original: protected */
    public void aKd() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: pt */
    public void mo22228pt(int i) {
    }

    public void setPullDownBackgroundColor(int i) {
        AppMethodBeat.m2504i(87283);
        this.itJ.setBackgroundColor(i);
        AppMethodBeat.m2505o(87283);
    }

    /* Access modifiers changed, original: protected */
    public boolean aAO() {
        AppMethodBeat.m2504i(87284);
        if (this.f2880WL.getScrollY() == 0) {
            AppMethodBeat.m2505o(87284);
            return true;
        }
        AppMethodBeat.m2505o(87284);
        return false;
    }

    private int getMaxOverScrollDistance() {
        AppMethodBeat.m2504i(87285);
        int height = getHeight();
        AppMethodBeat.m2505o(87285);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int getOpenHeight() {
        AppMethodBeat.m2504i(87286);
        int height = this.itI.getHeight();
        AppMethodBeat.m2505o(87286);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int getStayHeight() {
        AppMethodBeat.m2504i(87287);
        int height = this.itI.getHeight();
        AppMethodBeat.m2505o(87287);
        return height;
    }

    /* renamed from: pu */
    private void m18370pu(int i) {
        AppMethodBeat.m2504i(87288);
        int translationY = (int) this.itK.getTranslationY();
        if (translationY == i) {
            AppMethodBeat.m2505o(87288);
            return;
        }
        C4990ab.m7417i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", Integer.valueOf(translationY), Integer.valueOf(i));
        if (this.itT != null) {
            this.itT.cancel();
        }
        long abs = (long) ((((float) Math.abs(translationY - i)) / ((float) getStayHeight())) * 250.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.itK, "translationY", new float[]{(float) translationY, (float) i});
        ofFloat.setDuration(Math.min(abs, 250));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
        ofFloat.addUpdateListener(new C106801());
        this.itT = ofFloat;
        AppMethodBeat.m2505o(87288);
    }
}
