package com.tencent.p177mm.plugin.webview.luggage;

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
import com.tencent.xweb.WebView;

/* renamed from: com.tencent.mm.plugin.webview.luggage.i */
public class C43888i extends FrameLayout {
    /* renamed from: AL */
    private int f17232AL;
    /* renamed from: WL */
    View f17233WL;
    View itI;
    FrameLayout itJ = new FrameLayout(getContext());
    FrameLayout itK;
    private boolean itL = true;
    private boolean itM = false;
    private boolean itN = false;
    private boolean itO = false;
    private boolean itP = false;
    private int itQ;
    private int itR;
    private ObjectAnimator itT = null;
    private int mTouchSlop;

    /* renamed from: com.tencent.mm.plugin.webview.luggage.i$1 */
    class C228271 implements AnimatorUpdateListener {
        C228271() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(6157);
            ((Float) valueAnimator.getAnimatedValue()).floatValue();
            AppMethodBeat.m2505o(6157);
        }
    }

    public C43888i(Context context) {
        super(context);
        AppMethodBeat.m2504i(6158);
        setLayoutParams(new LayoutParams(-1, -1));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.m2505o(6158);
    }

    public void setPullDownEnabled(boolean z) {
        this.itL = !z;
    }

    public void setNeedStay(boolean z) {
        this.itM = z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(6159);
        if (this.itL) {
            boolean z = this.itP;
            AppMethodBeat.m2505o(6159);
            return z;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            AppMethodBeat.m2505o(6159);
            return false;
        } else if (this.itO) {
            AppMethodBeat.m2505o(6159);
            return true;
        } else {
            switch (action) {
                case 0:
                    if (aAO()) {
                        this.itQ = (int) motionEvent.getX();
                        this.itR = (int) motionEvent.getY();
                        this.f17232AL = (int) motionEvent.getY();
                        break;
                    }
                    break;
                case 2:
                    if (aAO()) {
                        action = ((int) motionEvent.getX()) - this.itQ;
                        int y = ((int) motionEvent.getY()) - this.itR;
                        if (Math.abs(y) > this.mTouchSlop && Math.abs(y) > Math.abs(action) && y > 0) {
                            this.itO = true;
                            AppMethodBeat.m2505o(6159);
                            return true;
                        }
                    }
                    break;
            }
            AppMethodBeat.m2505o(6159);
            return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(6160);
        if (this.itL) {
            if (this.itP) {
                aKb();
            }
            boolean z = this.itP;
            AppMethodBeat.m2505o(6160);
            return z;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.f17232AL = (int) motionEvent.getY();
                AppMethodBeat.m2505o(6160);
                return true;
            case 1:
            case 3:
                if (this.itK.getTranslationY() <= ((float) getOpenHeight()) || !this.itM) {
                    aKb();
                } else {
                    m78715pu(getStayHeight());
                    this.itO = true;
                    this.itN = true;
                    this.itP = true;
                }
                AppMethodBeat.m2505o(6160);
                return true;
            case 2:
                int y = (((int) motionEvent.getY()) - this.f17232AL) >> 1;
                int maxOverScrollDistance = getMaxOverScrollDistance();
                if (y <= maxOverScrollDistance) {
                    maxOverScrollDistance = y;
                }
                if (this.itN) {
                    maxOverScrollDistance += getStayHeight();
                }
                C4990ab.m7411d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", Integer.valueOf(r4), Integer.valueOf(Math.max(maxOverScrollDistance, 0)));
                this.itK.setTranslationY((float) Math.min(getMaxOverScrollDistance(), maxOverScrollDistance));
                AppMethodBeat.m2505o(6160);
                return true;
            default:
                AppMethodBeat.m2505o(6160);
                return false;
        }
    }

    private void aKb() {
        AppMethodBeat.m2504i(6161);
        m78715pu(0);
        this.itO = false;
        this.itN = false;
        this.itP = false;
        AppMethodBeat.m2505o(6161);
    }

    public void setPullDownBackgroundColor(int i) {
        AppMethodBeat.m2504i(6162);
        this.itJ.setBackgroundColor(i);
        AppMethodBeat.m2505o(6162);
    }

    private boolean aAO() {
        AppMethodBeat.m2504i(6163);
        if (this.f17233WL instanceof WebView) {
            if (((WebView) this.f17233WL).getWebScrollY() == 0) {
                AppMethodBeat.m2505o(6163);
                return true;
            }
            AppMethodBeat.m2505o(6163);
            return false;
        } else if (this.f17233WL.getScrollY() == 0) {
            AppMethodBeat.m2505o(6163);
            return true;
        } else {
            AppMethodBeat.m2505o(6163);
            return false;
        }
    }

    private int getMaxOverScrollDistance() {
        AppMethodBeat.m2504i(6164);
        int height = getHeight();
        AppMethodBeat.m2505o(6164);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int getOpenHeight() {
        AppMethodBeat.m2504i(6165);
        int height = this.itI.getHeight();
        AppMethodBeat.m2505o(6165);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int getStayHeight() {
        AppMethodBeat.m2504i(6166);
        int height = this.itI.getHeight();
        AppMethodBeat.m2505o(6166);
        return height;
    }

    /* renamed from: pu */
    private void m78715pu(int i) {
        AppMethodBeat.m2504i(6167);
        int translationY = (int) this.itK.getTranslationY();
        if (translationY == i) {
            AppMethodBeat.m2505o(6167);
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
        ofFloat.addUpdateListener(new C228271());
        this.itT = ofFloat;
        AppMethodBeat.m2505o(6167);
    }
}
