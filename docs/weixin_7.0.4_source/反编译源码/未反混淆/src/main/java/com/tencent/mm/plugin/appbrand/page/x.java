package com.tencent.mm.plugin.appbrand.page;

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

public class x extends FrameLayout {
    private int AL;
    View WL;
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

    public x(Context context) {
        super(context);
        AppMethodBeat.i(87278);
        setLayoutParams(new LayoutParams(-1, -1));
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        AppMethodBeat.o(87278);
    }

    public void setPullDownEnabled(boolean z) {
        this.itL = !z;
    }

    public void setNeedStay(boolean z) {
        this.itM = z;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(87279);
        if (this.itL) {
            boolean z = this.itP;
            AppMethodBeat.o(87279);
            return z;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.itO = false;
            this.itS = false;
            AppMethodBeat.o(87279);
            return false;
        } else if (action == 2 && this.itO) {
            AppMethodBeat.o(87279);
            return true;
        } else {
            switch (action) {
                case 0:
                    if (aAO()) {
                        this.itQ = (int) motionEvent.getX();
                        this.itR = (int) motionEvent.getY();
                        this.AL = (int) motionEvent.getY();
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
                                AppMethodBeat.o(87279);
                                return true;
                            }
                        }
                        this.itQ = (int) motionEvent.getX();
                        this.itR = (int) motionEvent.getY();
                        this.AL = (int) motionEvent.getY();
                        this.itO = false;
                        this.itS = true;
                        AppMethodBeat.o(87279);
                        return false;
                    }
                    break;
            }
            if (this.itO || this.itP) {
                AppMethodBeat.o(87279);
                return true;
            }
            AppMethodBeat.o(87279);
            return false;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(87280);
        if (this.itL) {
            if (this.itP) {
                aKb();
            }
            boolean z = this.itP;
            AppMethodBeat.o(87280);
            return z;
        } else if (motionEvent.getAction() != 0 || motionEvent.getEdgeFlags() == 0) {
            switch (motionEvent.getAction()) {
                case 0:
                    if (aAO() || this.itP) {
                        this.itR = (int) motionEvent.getY();
                        this.itQ = (int) motionEvent.getX();
                        this.AL = (int) motionEvent.getY();
                        this.itS = true;
                        AppMethodBeat.o(87280);
                        return true;
                    }
                case 1:
                case 3:
                    this.itS = false;
                    if (this.itK.getTranslationY() > ((float) getOpenHeight()) && this.itM) {
                        aKa();
                        AppMethodBeat.o(87280);
                        return true;
                    } else if (this.itO || this.itP) {
                        aKb();
                        AppMethodBeat.o(87280);
                        return true;
                    }
                    break;
                case 2:
                    if (this.itO || this.itP) {
                        if (this.itS) {
                            int y = (((int) motionEvent.getY()) - this.AL) >> 1;
                            int maxOverScrollDistance = getMaxOverScrollDistance();
                            if (y <= maxOverScrollDistance) {
                                maxOverScrollDistance = y;
                            }
                            if (this.itN) {
                                maxOverScrollDistance += getStayHeight();
                            }
                            maxOverScrollDistance = Math.max(maxOverScrollDistance, 0);
                            ab.d("MicroMsg.AppBrandPullDownView", "real diff: %d, calc diff: %d", Integer.valueOf(r4), Integer.valueOf(maxOverScrollDistance));
                            this.itK.setTranslationY((float) Math.min(getMaxOverScrollDistance(), maxOverScrollDistance));
                            pt(maxOverScrollDistance);
                            AppMethodBeat.o(87280);
                            return true;
                        }
                        this.itR = (int) motionEvent.getY();
                        this.itQ = (int) motionEvent.getX();
                        this.AL = (int) motionEvent.getY();
                        this.itS = true;
                        AppMethodBeat.o(87280);
                        return true;
                    }
            }
            AppMethodBeat.o(87280);
            return false;
        } else {
            AppMethodBeat.o(87280);
            return false;
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void aKa() {
        AppMethodBeat.i(87281);
        pu(getStayHeight());
        if (!this.itN) {
            aKc();
        }
        this.itO = true;
        this.itN = true;
        this.itP = true;
        AppMethodBeat.o(87281);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aKb() {
        AppMethodBeat.i(87282);
        pu(0);
        if (this.itN) {
            aKd();
        }
        this.itO = false;
        this.itN = false;
        this.itP = false;
        AppMethodBeat.o(87282);
    }

    /* Access modifiers changed, original: protected */
    public void aKc() {
    }

    /* Access modifiers changed, original: protected */
    public void aKd() {
    }

    /* Access modifiers changed, original: protected */
    public void pt(int i) {
    }

    public void setPullDownBackgroundColor(int i) {
        AppMethodBeat.i(87283);
        this.itJ.setBackgroundColor(i);
        AppMethodBeat.o(87283);
    }

    /* Access modifiers changed, original: protected */
    public boolean aAO() {
        AppMethodBeat.i(87284);
        if (this.WL.getScrollY() == 0) {
            AppMethodBeat.o(87284);
            return true;
        }
        AppMethodBeat.o(87284);
        return false;
    }

    private int getMaxOverScrollDistance() {
        AppMethodBeat.i(87285);
        int height = getHeight();
        AppMethodBeat.o(87285);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int getOpenHeight() {
        AppMethodBeat.i(87286);
        int height = this.itI.getHeight();
        AppMethodBeat.o(87286);
        return height;
    }

    /* Access modifiers changed, original: protected */
    public int getStayHeight() {
        AppMethodBeat.i(87287);
        int height = this.itI.getHeight();
        AppMethodBeat.o(87287);
        return height;
    }

    private void pu(int i) {
        AppMethodBeat.i(87288);
        int translationY = (int) this.itK.getTranslationY();
        if (translationY == i) {
            AppMethodBeat.o(87288);
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
                AppMethodBeat.i(87277);
                x.this.pt((int) ((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(87277);
            }
        });
        this.itT = ofFloat;
        AppMethodBeat.o(87288);
    }
}
