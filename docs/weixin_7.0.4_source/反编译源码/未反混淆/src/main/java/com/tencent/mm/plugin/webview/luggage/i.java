package com.tencent.mm.plugin.webview.luggage;

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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.xweb.WebView;

public class i extends FrameLayout {
    private int AL;
    View WL;
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

    public i(Context context) {
        super(context);
        AppMethodBeat.i(6158);
        setLayoutParams(new LayoutParams(-1, -1));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.o(6158);
    }

    public void setPullDownEnabled(boolean z) {
        this.itL = !z;
    }

    public void setNeedStay(boolean z) {
        this.itM = z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(6159);
        if (this.itL) {
            boolean z = this.itP;
            AppMethodBeat.o(6159);
            return z;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            AppMethodBeat.o(6159);
            return false;
        } else if (this.itO) {
            AppMethodBeat.o(6159);
            return true;
        } else {
            switch (action) {
                case 0:
                    if (aAO()) {
                        this.itQ = (int) motionEvent.getX();
                        this.itR = (int) motionEvent.getY();
                        this.AL = (int) motionEvent.getY();
                        break;
                    }
                    break;
                case 2:
                    if (aAO()) {
                        action = ((int) motionEvent.getX()) - this.itQ;
                        int y = ((int) motionEvent.getY()) - this.itR;
                        if (Math.abs(y) > this.mTouchSlop && Math.abs(y) > Math.abs(action) && y > 0) {
                            this.itO = true;
                            AppMethodBeat.o(6159);
                            return true;
                        }
                    }
                    break;
            }
            AppMethodBeat.o(6159);
            return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(6160);
        if (this.itL) {
            if (this.itP) {
                aKb();
            }
            boolean z = this.itP;
            AppMethodBeat.o(6160);
            return z;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.AL = (int) motionEvent.getY();
                AppMethodBeat.o(6160);
                return true;
            case 1:
            case 3:
                if (this.itK.getTranslationY() <= ((float) getOpenHeight()) || !this.itM) {
                    aKb();
                } else {
                    pu(getStayHeight());
                    this.itO = true;
                    this.itN = true;
                    this.itP = true;
                }
                AppMethodBeat.o(6160);
                return true;
            case 2:
                int y = (((int) motionEvent.getY()) - this.AL) >> 1;
                int maxOverScrollDistance = getMaxOverScrollDistance();
                if (y <= maxOverScrollDistance) {
                    maxOverScrollDistance = y;
                }
                if (this.itN) {
                    maxOverScrollDistance += getStayHeight();
                }
                ab.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", Integer.valueOf(r4), Integer.valueOf(Math.max(maxOverScrollDistance, 0)));
                this.itK.setTranslationY((float) Math.min(getMaxOverScrollDistance(), maxOverScrollDistance));
                AppMethodBeat.o(6160);
                return true;
            default:
                AppMethodBeat.o(6160);
                return false;
        }
    }

    private void aKb() {
        AppMethodBeat.i(6161);
        pu(0);
        this.itO = false;
        this.itN = false;
        this.itP = false;
        AppMethodBeat.o(6161);
    }

    public void setPullDownBackgroundColor(int i) {
        AppMethodBeat.i(6162);
        this.itJ.setBackgroundColor(i);
        AppMethodBeat.o(6162);
    }

    private boolean aAO() {
        AppMethodBeat.i(6163);
        if (this.WL instanceof WebView) {
            if (((WebView) this.WL).getWebScrollY() == 0) {
                AppMethodBeat.o(6163);
                return true;
            }
            AppMethodBeat.o(6163);
            return false;
        } else if (this.WL.getScrollY() == 0) {
            AppMethodBeat.o(6163);
            return true;
        } else {
            AppMethodBeat.o(6163);
            return false;
        }
    }

    private int getMaxOverScrollDistance() {
        AppMethodBeat.i(6164);
        int height = getHeight();
        AppMethodBeat.o(6164);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int getOpenHeight() {
        AppMethodBeat.i(6165);
        int height = this.itI.getHeight();
        AppMethodBeat.o(6165);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int getStayHeight() {
        AppMethodBeat.i(6166);
        int height = this.itI.getHeight();
        AppMethodBeat.o(6166);
        return height;
    }

    private void pu(int i) {
        AppMethodBeat.i(6167);
        int translationY = (int) this.itK.getTranslationY();
        if (translationY == i) {
            AppMethodBeat.o(6167);
            return;
        }
        ab.i("MicroMsg.AppBrandPullDownView", "fastScrollTo from = %s, to = %s", Integer.valueOf(translationY), Integer.valueOf(i));
        if (this.itT != null) {
            this.itT.cancel();
        }
        long abs = (long) ((((float) Math.abs(translationY - i)) / ((float) getStayHeight())) * 250.0f);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.itK, "translationY", new float[]{(float) translationY, (float) i});
        ofFloat.setDuration(Math.min(abs, 250));
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ofFloat.start();
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(6157);
                ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AppMethodBeat.o(6157);
            }
        });
        this.itT = ofFloat;
        AppMethodBeat.o(6167);
    }
}
