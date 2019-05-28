package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Color;
import android.os.Message;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.i;

public class MMPullDownView extends FrameLayout implements OnGestureListener {
    private static int ywE = 400;
    private static final int ywH = Color.parseColor("#00000000");
    private int bgColor;
    protected Context context;
    private GestureDetector lCs;
    private Scroller mScroller;
    public View yho;
    private int ytq;
    private int yud;
    private boolean ywA;
    private i ywB;
    private boolean ywC;
    private a ywD;
    private ak ywF;
    boolean ywG;
    private boolean ywI;
    private int ywJ;
    private int ywK;
    private b ywL;
    private g ywg;
    private e ywh;
    private int ywi;
    private int ywj;
    private boolean ywk;
    private boolean ywl;
    private boolean ywm;
    private boolean ywn;
    protected boolean ywo;
    private boolean ywp;
    private boolean ywq;
    private boolean ywr;
    private c yws;
    private d ywt;
    public View ywu;
    private int ywv;
    private int yww;
    private int ywx;
    private boolean ywy;
    private f ywz;

    public interface e {
        boolean bhk();
    }

    public interface c {
        boolean bhm();
    }

    public interface b {
        void bpT();
    }

    public interface d {
        boolean bhl();
    }

    public interface a {
        boolean onInterceptTouchEvent(MotionEvent motionEvent);
    }

    public interface g {
        boolean bhn();
    }

    public interface f {
        void ba(float f);

        void cuq();
    }

    public MMPullDownView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMPullDownView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(106722);
        this.yud = 1;
        this.ywk = false;
        this.ywl = false;
        this.ywm = false;
        this.ywn = false;
        this.ywo = true;
        this.ywp = false;
        this.ywq = true;
        this.ywr = true;
        this.yww = 4;
        this.ywx = 4;
        this.ywy = false;
        this.ywA = true;
        this.ywC = false;
        this.ywF = new ak() {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(106721);
                super.handleMessage(message);
                switch (MMPullDownView.this.ywv) {
                    case 0:
                        if (MMPullDownView.this.ywg != null) {
                            MMPullDownView.this.ywo = MMPullDownView.this.ywg.bhn();
                        }
                        if (MMPullDownView.this.ywo && MMPullDownView.this.ywu.getVisibility() == 0) {
                            MMPullDownView.this.scrollTo(0, MMPullDownView.this.ywi);
                            break;
                        }
                    case 1:
                        if (MMPullDownView.this.ywh != null) {
                            MMPullDownView.this.ywo = MMPullDownView.this.ywh.bhk();
                        }
                        if (MMPullDownView.this.ywo && MMPullDownView.this.yho.getVisibility() == 0) {
                            MMPullDownView.this.scrollTo(0, MMPullDownView.this.ywi);
                            break;
                        }
                }
                ab.i("MicroMsg.MMPullDownView", "updateDelayHandler handleMessage loadDataType[%d] loadDataEnd[%b]", Integer.valueOf(MMPullDownView.this.ywv), Boolean.valueOf(MMPullDownView.this.ywo));
                AppMethodBeat.o(106721);
            }
        };
        this.ywG = false;
        this.ywI = false;
        this.bgColor = Color.parseColor("#ffffffff");
        this.ywJ = j.INVALID_ID;
        this.ywK = this.bgColor;
        this.mScroller = new Scroller(context, new AccelerateInterpolator());
        this.ytq = this.yud;
        this.lCs = new GestureDetector(context, this);
        this.ywB = new i(context);
        this.context = context;
        AppMethodBeat.o(106722);
    }

    /* Access modifiers changed, original: protected */
    public void bhG() {
        AppMethodBeat.i(106723);
        View inflate = inflate(this.context, R.layout.a_4, null);
        View inflate2 = inflate(this.context, R.layout.a_4, null);
        addView(inflate, 0, new LayoutParams(-1, -2));
        addView(inflate2, new LayoutParams(-1, -2));
        AppMethodBeat.o(106723);
    }

    public void setCanOverScrool(boolean z) {
        this.ywA = z;
    }

    public void setIsTopShowAll(boolean z) {
        AppMethodBeat.i(106724);
        ab.i("MicroMsg.MMPullDownView", "setIsTopShowAll showAll[%b], isTopShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.ywq), bo.dpG());
        this.ywq = z;
        AppMethodBeat.o(106724);
    }

    public void setIsBottomShowAll(boolean z) {
        AppMethodBeat.i(106725);
        ab.i("MicroMsg.MMPullDownView", "setIsBottomShowAll showAll[%b], isBottomShowAll[%b], stack[%s]", Boolean.valueOf(z), Boolean.valueOf(this.ywr), bo.dpG());
        this.ywr = z;
        AppMethodBeat.o(106725);
    }

    public void setOnTopLoadDataListener(g gVar) {
        this.ywg = gVar;
    }

    public void setOnBottomLoadDataListener(e eVar) {
        this.ywh = eVar;
    }

    public void setAtTopCallBack(d dVar) {
        this.ywt = dVar;
    }

    public void setAtBottomCallBack(c cVar) {
        this.yws = cVar;
    }

    public void setOnSrcollDistance(f fVar) {
        this.ywz = fVar;
    }

    public void setOnMMFlingListener(com.tencent.mm.ui.tools.i.a aVar) {
        this.ywB.zFy = aVar;
    }

    public void setTopView(View view) {
        AppMethodBeat.i(106726);
        if (view == null) {
            this.ywx = 4;
            if (this.ywu != null) {
                this.ywu.setVisibility(4);
                AppMethodBeat.o(106726);
                return;
            }
        }
        removeViewAt(0);
        this.ywu = view;
        this.ywu.setVisibility(0);
        this.ywx = 0;
        addView(this.ywu, 0, new LayoutParams(-1, -2));
        this.ywi = 0;
        AppMethodBeat.o(106726);
    }

    public void setBottomView(View view) {
        AppMethodBeat.i(106727);
        if (view == null) {
            this.yww = 4;
            if (this.yho != null) {
                this.yho.setVisibility(4);
                AppMethodBeat.o(106727);
                return;
            }
        }
        this.yho = view;
        this.yho.setVisibility(0);
        this.yww = 0;
        removeViewAt(getChildCount() - 1);
        addView(this.yho, new LayoutParams(-1, -2));
        this.ywj = 0;
        AppMethodBeat.o(106727);
    }

    public void setBottomViewVisible(boolean z) {
        AppMethodBeat.i(106728);
        this.yww = z ? 0 : 4;
        if (this.yho != null) {
            this.yho.setVisibility(this.yww);
        }
        ab.i("MicroMsg.MMPullDownView", "setBottomViewVisible visible[%b], stack[%s]", Boolean.valueOf(z), bo.dpG());
        AppMethodBeat.o(106728);
    }

    public void setTopViewVisible(boolean z) {
        AppMethodBeat.i(106729);
        this.ywx = z ? 0 : 4;
        if (this.ywu != null) {
            this.ywu.setVisibility(this.ywx);
        }
        ab.i("MicroMsg.MMPullDownView", "setTopViewVisible visible[%b]", Boolean.valueOf(z));
        AppMethodBeat.o(106729);
    }

    public static void d(ViewGroup viewGroup, int i) {
        AppMethodBeat.i(106730);
        ab.i("MicroMsg.MMPullDownView", "fix android O progress bar bug.");
        if (viewGroup != null && viewGroup.getVisibility() == 0) {
            if (viewGroup.getTag() == null) {
                viewGroup.setTag(viewGroup.findViewById(R.id.afz));
            }
            View view = (View) viewGroup.getTag();
            if (view != null) {
                view.setVisibility(i);
            }
        }
        AppMethodBeat.o(106730);
    }

    private void dzS() {
        AppMethodBeat.i(106731);
        d((ViewGroup) this.ywu, 0);
        d((ViewGroup) this.yho, 0);
        AppMethodBeat.o(106731);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(106732);
        if (!this.ywy) {
            bhG();
            this.ywy = true;
        }
        super.onMeasure(i, i2);
        AppMethodBeat.o(106732);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106733);
        ab.d("MicroMsg.MMPullDownView", "jacks onLayout change: %B, l:%d, t:%d, r:%d, b:%d", Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        int i5 = 0;
        int childCount = getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            int measuredHeight = childAt.getMeasuredHeight();
            if (childAt.getVisibility() != 8) {
                try {
                    childAt.layout(0, i5, childAt.getMeasuredWidth(), i5 + measuredHeight);
                } catch (ArrayIndexOutOfBoundsException e) {
                    ab.printErrStackTrace("MicroMsg.MMPullDownView", e, "childCount: %d, i:%d, childHeight:%d", Integer.valueOf(childCount), Integer.valueOf(i6), Integer.valueOf(measuredHeight));
                }
                i5 += measuredHeight;
            }
        }
        this.ywu = getChildAt(0);
        this.yho = getChildAt(getChildCount() - 1);
        this.ywu.setVisibility(this.ywx);
        this.yho.setVisibility(this.yww);
        this.ywi = this.ywu.getHeight();
        this.ywj = this.yho.getHeight();
        this.ywJ = this.ywi;
        if (!(this.ywp || this.ywi == 0)) {
            this.ywp = true;
            scrollTo(0, this.ywi);
        }
        AppMethodBeat.o(106733);
    }

    public int getCurScreen() {
        return this.ytq;
    }

    static {
        AppMethodBeat.i(106746);
        AppMethodBeat.o(106746);
    }

    public void computeScroll() {
        AppMethodBeat.i(106734);
        if (this.mScroller.computeScrollOffset()) {
            scrollTo(this.mScroller.getCurrX(), this.mScroller.getCurrY());
            postInvalidate();
        } else if (this.ywn) {
            ab.i("MicroMsg.MMPullDownView", "computeScroll loadDataBegin true UPDATE_DELAY");
            this.ywn = false;
            this.ywF.sendEmptyMessageDelayed(0, (long) ywE);
            dzS();
        }
        this.mScroller.isFinished();
        AppMethodBeat.o(106734);
    }

    public int getTopHeight() {
        return this.ywi;
    }

    public int getBottomHeight() {
        return this.ywj;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106735);
        if (this.ywD != null) {
            this.ywD.onInterceptTouchEvent(motionEvent);
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(106735);
        return onInterceptTouchEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(106736);
        switch (motionEvent.getAction()) {
            case 1:
                if (getScrollY() - this.ywi < 0) {
                    this.ywk = true;
                }
                if (getScrollY() > this.ywj) {
                    this.ywl = true;
                }
                dzT();
                break;
        }
        AppMethodBeat.o(106736);
        return true;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean z = true;
        AppMethodBeat.i(106737);
        i iVar = this.ywB;
        if (iVar.zFy != null) {
            iVar.aJM.onTouchEvent(motionEvent);
        }
        if (this.ywo) {
            if (this.ywt == null) {
                this.ywk = false;
            } else {
                this.ywk = this.ywt.bhl();
            }
            if (this.yws == null) {
                this.ywl = false;
            } else {
                this.ywl = this.yws.bhm();
            }
            if (this.ywx == 0) {
                if (this.ywq) {
                    this.ywu.setVisibility(4);
                } else {
                    this.ywu.setVisibility(0);
                }
            }
            if (this.yww == 0) {
                if (this.ywr) {
                    this.yho.setVisibility(4);
                } else {
                    this.yho.setVisibility(0);
                }
            }
            if (motionEvent.getAction() == z) {
                dzT();
                z = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(106737);
                return z;
            } else if (motionEvent.getAction() == 3) {
                dzT();
                if (this.ywC) {
                    z = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(106737);
                    return z;
                }
                AppMethodBeat.o(106737);
                return false;
            } else if (this.lCs.onTouchEvent(motionEvent)) {
                motionEvent.setAction(3);
                this.ywG = z;
                z = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(106737);
                return z;
            } else {
                try {
                    z = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(106737);
                    return z;
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.MMPullDownView", e, "", new Object[0]);
                    AppMethodBeat.o(106737);
                    return z;
                }
            }
        }
        AppMethodBeat.o(106737);
        return z;
    }

    public void qc(boolean z) {
        AppMethodBeat.i(106738);
        ab.i("MicroMsg.MMPullDownView", "forceTopLoadData start[%b] loadDataBegin[%b], loadDataEnd[%b], isTopShowAll[%b], getScrollY[%d]", Boolean.valueOf(z), Boolean.valueOf(this.ywn), Boolean.valueOf(this.ywo), Boolean.valueOf(this.ywq), Integer.valueOf(getScrollY()));
        if (z) {
            if (this.ywu != null) {
                this.ywu.setVisibility(this.ywx);
            }
            if (this.ywq) {
                this.mScroller.startScroll(0, getScrollY(), 0, this.ywi + (-getScrollY()), 200);
            } else {
                if (this.ywu != null && this.ywu.getVisibility() == 4) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ywi + (-getScrollY()), 200);
                }
                if (this.ywu != null && this.ywu.getVisibility() == 0) {
                    this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.ywv = 0;
                this.ywn = true;
                this.ywo = false;
            }
            postInvalidate();
        } else {
            if (!this.ywo) {
                this.ywo = true;
                this.ywn = false;
                if (this.ywu != null && this.ywu.getVisibility() == 0) {
                    scrollTo(0, this.ywi);
                }
            }
            if (this.ywu != null && this.ywu.getVisibility() == 0) {
                this.ywu.setVisibility(8);
            }
        }
        dzS();
        AppMethodBeat.o(106738);
    }

    public final void qd(boolean z) {
        AppMethodBeat.i(106739);
        ab.i("MicroMsg.MMPullDownView", "forceBottomLoadData start[%b] loadDataBegin[%b] loadDataEnd[%b], isBottomShowAll[%b], getScrollY[%d]", Boolean.valueOf(z), Boolean.valueOf(this.ywn), Boolean.valueOf(this.ywo), Boolean.valueOf(this.ywr), Integer.valueOf(getScrollY()));
        if (z) {
            if (this.yho != null) {
                this.yho.setVisibility(this.ywx);
            }
            if (this.ywr) {
                this.mScroller.startScroll(0, getScrollY(), 0, this.ywj - getScrollY(), 200);
            } else {
                if (this.yho != null && this.yho.getVisibility() == 4) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ywj - getScrollY(), 200);
                }
                if (this.yho != null && this.yho.getVisibility() == 0) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ywj + (this.ywj - getScrollY()), 200);
                }
                this.ywv = 1;
                this.ywn = true;
                this.ywo = false;
            }
            postInvalidate();
            AppMethodBeat.o(106739);
            return;
        }
        if (!this.ywo) {
            this.ywo = true;
            this.ywn = false;
        }
        if (this.yho != null && this.yho.getVisibility() == 0) {
            ab.i("MicroMsg.MMPullDownView", "forceBottomLoadData false bottomView VISIBLE scroll to 0");
            scrollTo(0, this.ywi);
        }
        if (this.yho != null && this.yho.getVisibility() == 0) {
            this.yho.setVisibility(8);
        }
        AppMethodBeat.o(106739);
    }

    private void dzT() {
        AppMethodBeat.i(106740);
        if (this.ywz != null) {
            this.ywz.cuq();
        }
        if (getScrollY() - this.ywi < 0) {
            if (this.ywq) {
                this.mScroller.startScroll(0, getScrollY(), 0, this.ywi + (-getScrollY()), 200);
            } else {
                if (this.ywu.getVisibility() == 4) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ywi + (-getScrollY()), 200);
                }
                if (this.ywu.getVisibility() == 0) {
                    this.mScroller.startScroll(0, getScrollY(), 0, -getScrollY(), 200);
                }
                this.ywv = 0;
                this.ywn = true;
                this.ywo = false;
            }
            postInvalidate();
        }
        if (getScrollY() > this.ywj) {
            if (this.ywr) {
                this.mScroller.startScroll(0, getScrollY(), 0, this.ywj - getScrollY(), 200);
            } else {
                if (this.yho.getVisibility() == 4) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ywj - getScrollY(), 200);
                }
                if (this.yho.getVisibility() == 0) {
                    this.mScroller.startScroll(0, getScrollY(), 0, this.ywj + (this.ywj - getScrollY()), 200);
                }
                this.ywv = 1;
                this.ywn = true;
                this.ywo = false;
            }
            postInvalidate();
        }
        this.ywm = false;
        AppMethodBeat.o(106740);
    }

    public boolean onDown(MotionEvent motionEvent) {
        AppMethodBeat.i(106741);
        if (!this.mScroller.isFinished()) {
            this.mScroller.abortAnimation();
        }
        AppMethodBeat.o(106741);
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.i(106742);
        ab.v("MicroMsg.MMPullDownView", "on fling, velocityX %f velocityY %f", Float.valueOf(f), Float.valueOf(f2));
        AppMethodBeat.o(106742);
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        AppMethodBeat.i(106743);
        if (this.ywz != null) {
            this.ywz.ba(f2);
        }
        if (f2 > 0.0f) {
            this.ywm = true;
        } else {
            this.ywm = false;
        }
        int i;
        if (!this.ywl || (!this.ywm && getScrollY() - this.ywi <= 0)) {
            if (!this.ywk || (this.ywm && getScrollY() - this.ywi >= 0)) {
                AppMethodBeat.o(106743);
                return false;
            } else if (this.ywA || (this.ywu.getVisibility() == 0 && (this.ywm || getScrollY() > 0))) {
                i = (int) (((double) f2) * 0.5d);
                if (i == 0) {
                    i = f2 > 0.0f ? 1 : -1;
                }
                if (getScrollY() + i > this.ywi) {
                    i = this.ywi - getScrollY();
                } else if (!this.ywA && getScrollY() + i < 0) {
                    i = -getScrollY();
                }
                scrollBy(0, i);
                AppMethodBeat.o(106743);
                return true;
            } else {
                AppMethodBeat.o(106743);
                return true;
            }
        } else if (this.ywA || (this.yho.getVisibility() == 0 && (!this.ywm || getScrollY() < this.ywi * 2))) {
            i = (int) (((double) f2) * 0.5d);
            if (i == 0) {
                i = f2 > 0.0f ? 1 : -1;
            }
            ab.v("check", "moveUp:" + i + " distanceY:" + f2 + " scrollY:" + getScrollY());
            if (getScrollY() + i < this.ywi && !this.ywm) {
                i = this.ywi - getScrollY();
            } else if (!this.ywA && getScrollY() + i >= this.ywi * 2) {
                i = (this.ywi * 2) - getScrollY();
            }
            scrollBy(0, i);
            AppMethodBeat.o(106743);
            return true;
        } else {
            AppMethodBeat.o(106743);
            return true;
        }
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void setShowBackground(boolean z) {
        this.ywI = z;
    }

    public void setBgColor(String str) {
        AppMethodBeat.i(106744);
        this.bgColor = Color.parseColor(str);
        this.ywK = this.bgColor;
        AppMethodBeat.o(106744);
    }

    /* Access modifiers changed, original: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(106745);
        super.onScrollChanged(i, i2, i3, i4);
        if (this.ywL != null) {
            this.ywL.bpT();
        }
        if (this.ywI) {
            if (this.ywJ == j.INVALID_ID) {
                this.ywJ = this.ywi;
                ab.d("MicroMsg.MMPullDownView", "onScrollChanged static y:" + this.ywJ);
            }
            if (i2 > this.ywJ || this.ywK == ywH) {
                if (i2 > this.ywJ && this.ywK != this.bgColor) {
                    ab.d("MicroMsg.MMPullDownView", "onScrollChanged white");
                    setBackgroundColor(this.bgColor);
                    this.ywK = this.bgColor;
                }
                AppMethodBeat.o(106745);
                return;
            }
            setBackgroundResource(R.drawable.uv);
            this.ywK = ywH;
            ab.d("MicroMsg.MMPullDownView", "onScrollChanged full");
            AppMethodBeat.o(106745);
            return;
        }
        AppMethodBeat.o(106745);
    }

    public void setOnScrollChangedListener(b bVar) {
        this.ywL = bVar;
    }

    public void setOnInterceptTouchEventListener(a aVar) {
        this.ywD = aVar;
    }

    public void setIsReturnSuperDispatchWhenCancel(boolean z) {
        this.ywC = z;
    }
}
