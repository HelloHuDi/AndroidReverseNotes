package com.tencent.mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.CustomViewPager;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.view.a.g;
import com.tencent.mm.view.popview.AbstractPopView;

public class SmileySubGrid extends SmileyGrid {
    int AaP = -1;
    boolean AaQ;
    private AbstractPopView AaR;
    private c AaS;
    private int AaT;
    private a AaU;
    private b AaV;
    private View AaW;
    private boolean AaX = false;
    private volatile int AaY = -1;
    private volatile boolean AaZ = false;
    public boolean Aba = true;
    private final Object Abb = new Object();
    Rect ahV = new Rect();
    private int aiN;
    int aia;
    int ath;
    float lbS;
    float lbT;
    private WindowManager lca;
    private boolean lgu;
    private ak mHandler = new ak();
    private int mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    int yto = 6;

    class c implements Runnable {
        private c() {
        }

        /* synthetic */ c(SmileySubGrid smileySubGrid, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(62957);
            if (!SmileySubGrid.this.lgu) {
                SmileySubGrid.this.lca.addView(SmileySubGrid.this.AaR, SmileySubGrid.this.AaR.getWindowLayoutParams());
                SmileySubGrid.this.lgu = true;
            }
            AppMethodBeat.o(62957);
        }
    }

    class d {
        private int yxj;

        private d() {
        }

        /* synthetic */ d(SmileySubGrid smileySubGrid, byte b) {
            this();
        }

        public final void dJk() {
            AppMethodBeat.i(62958);
            this.yxj = SmileySubGrid.a(SmileySubGrid.this);
            AppMethodBeat.o(62958);
        }

        public final boolean dJl() {
            AppMethodBeat.i(62959);
            if (SmileySubGrid.this.hasWindowFocus() && SmileySubGrid.b(SmileySubGrid.this) == this.yxj) {
                AppMethodBeat.o(62959);
                return true;
            }
            AppMethodBeat.o(62959);
            return false;
        }
    }

    class b extends d implements Runnable {
        View Dg;
        int zyT;

        private b() {
            super(SmileySubGrid.this, (byte) 0);
        }

        /* synthetic */ b(SmileySubGrid smileySubGrid, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(62956);
            ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
            ListAdapter adapter = SmileySubGrid.this.getAdapter();
            int i = this.zyT;
            if (adapter != null && SmileySubGrid.this.getCount() > 0 && i != -1 && i < adapter.getCount() && dJl()) {
                ab.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", Integer.valueOf(i), Long.valueOf(adapter.getItemId(i)));
                SmileySubGrid.this.performItemClick(this.Dg, i, adapter.getItemId(i));
            }
            AppMethodBeat.o(62956);
        }
    }

    class a extends d implements Runnable {
        private a() {
            super(SmileySubGrid.this, (byte) 0);
        }

        /* synthetic */ a(SmileySubGrid smileySubGrid, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.i(62955);
            ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "LongPress run");
            int i = SmileySubGrid.this.aia;
            SmileySubGrid smileySubGrid = SmileySubGrid.this;
            View childAt = smileySubGrid.getChildAt(i - smileySubGrid.getFirstVisiblePosition());
            if (childAt != null) {
                int i2 = SmileySubGrid.this.aia;
                long itemId = SmileySubGrid.this.getAdapter().getItemId(SmileySubGrid.this.aia);
                if (dJl()) {
                    ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", Integer.valueOf(i2), Long.valueOf(itemId));
                    SmileySubGrid.a(SmileySubGrid.this, childAt, i);
                    SmileySubGrid.this.ath = -1;
                    SmileySubGrid.this.yto = 5;
                    SmileySubGrid.this.setScrollEnable(false);
                }
            }
            AppMethodBeat.o(62955);
        }
    }

    static /* synthetic */ int a(SmileySubGrid smileySubGrid) {
        AppMethodBeat.i(62973);
        int windowAttachCount = smileySubGrid.getWindowAttachCount();
        AppMethodBeat.o(62973);
        return windowAttachCount;
    }

    static /* synthetic */ void a(SmileySubGrid smileySubGrid, View view, int i) {
        AppMethodBeat.i(62975);
        smileySubGrid.az(view, i);
        AppMethodBeat.o(62975);
    }

    static /* synthetic */ int b(SmileySubGrid smileySubGrid) {
        AppMethodBeat.i(62974);
        int windowAttachCount = smileySubGrid.getWindowAttachCount();
        AppMethodBeat.o(62974);
        return windowAttachCount;
    }

    public SmileySubGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(62960);
        this.lca = (WindowManager) context.getSystemService("window");
        this.aiN = getLongTouchTime();
        this.AaT = ViewConfiguration.getPressedStateDuration();
        AppMethodBeat.o(62960);
    }

    private void az(View view, int i) {
        AppMethodBeat.i(62962);
        if (QB(i)) {
            ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", Integer.valueOf(i));
        } else {
            ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", Integer.valueOf(i));
            Object item = getAdapter().getItem(i);
            if (this.AaR == null) {
                this.AaR = com.tencent.mm.view.popview.a.b(getContext(), item);
            }
            cX(item);
            fu(view);
        }
        this.AaY = i;
        AppMethodBeat.o(62962);
    }

    private boolean QB(int i) {
        AppMethodBeat.i(62963);
        if (i == this.AaY && this.AaR.isShown()) {
            AppMethodBeat.o(62963);
            return true;
        }
        AppMethodBeat.o(62963);
        return false;
    }

    private void fu(View view) {
        AppMethodBeat.i(62964);
        if (this.AaS == null) {
            this.AaS = new c(this, (byte) 0);
        }
        ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "updatePopView %s", Boolean.valueOf(this.lgu));
        this.AaR.fw(view);
        if (this.lgu) {
            this.lca.updateViewLayout(this.AaR, this.AaR.getWindowLayoutParams());
            AppMethodBeat.o(62964);
            return;
        }
        this.AaZ = true;
        this.mHandler.postDelayed(this.AaS, (long) this.AaT);
        AppMethodBeat.o(62964);
    }

    private void dMK() {
        AppMethodBeat.i(62965);
        if (this.AaS != null) {
            this.mHandler.removeCallbacks(this.AaS);
        }
        if (this.lgu) {
            this.lca.removeView(this.AaR);
            this.lgu = false;
            this.AaZ = false;
        }
        AppMethodBeat.o(62965);
    }

    public void setViewParent(View view) {
        this.AaW = view;
    }

    private void fv(View view) {
        AppMethodBeat.i(62966);
        Rect rect = this.ahV;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        N(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.AaQ;
        if (view.isEnabled() != z) {
            this.AaQ = !z;
            refreshDrawableState();
        }
        AppMethodBeat.o(62966);
    }

    private void N(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(62967);
        this.ahV.set(i - getPaddingLeft(), i2 - getPaddingTop(), getPaddingRight() + i3, getPaddingBottom() + i4);
        AppMethodBeat.o(62967);
    }

    /* Access modifiers changed, original: protected */
    public void setScrollEnable(boolean z) {
        AppMethodBeat.i(62968);
        ab.d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", Boolean.valueOf(z));
        if (this.AaW != null) {
            if (this.AaW instanceof MMFlipper) {
                ((MMFlipper) this.AaW).setScrollEnable(z);
                AppMethodBeat.o(62968);
                return;
            } else if (this.AaW instanceof CustomViewPager) {
                ((CustomViewPager) this.AaW).setCanSlide(z);
            }
        }
        AppMethodBeat.o(62968);
    }

    /* Access modifiers changed, original: protected */
    public int getLongTouchTime() {
        AppMethodBeat.i(62969);
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        AppMethodBeat.o(62969);
        return longPressTimeout;
    }

    public void setIsShowPopWin(boolean z) {
        this.Aba = z;
    }

    private void cX(Object obj) {
        AppMethodBeat.i(62970);
        synchronized (this.Abb) {
            try {
                if (this.AaR != null) {
                    com.tencent.mm.view.popview.a.a(this.AaR, obj);
                } else {
                    ab.i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
                }
            } finally {
                AppMethodBeat.o(62970);
            }
        }
    }

    public final void release() {
        AppMethodBeat.i(62971);
        super.release();
        dMK();
        if (this.AaR != null) {
            this.AaR = null;
        }
        AppMethodBeat.o(62971);
    }

    public void setFromDetail(boolean z) {
        this.AaX = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.i(62972);
        super.onDetachedFromWindow();
        dMK();
        AppMethodBeat.o(62972);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(62961);
        if (this.Aba) {
            int action = motionEvent.getAction();
            View view = null;
            int i;
            switch (action) {
                case 0:
                    action = (int) motionEvent.getX();
                    int y = (int) motionEvent.getY();
                    this.lbS = (float) action;
                    this.lbT = (float) y;
                    action = pointToPosition(action, y);
                    if (action >= 0 && getAdapter().isEnabled(action)) {
                        this.ath = 0;
                    }
                    if (action >= 0) {
                        this.AaP = action;
                        view = getChildAt(action - getFirstVisiblePosition());
                    }
                    if (view != null) {
                        view.setPressed(true);
                        view.setSelected(true);
                        fv(view);
                    }
                    if (this.AaU == null) {
                        this.AaU = new a(this, (byte) 0);
                    }
                    this.AaU.dJk();
                    this.aia = action;
                    if (action >= 0 && (getAdapter() instanceof g) && ((g) getAdapter()).ui(action)) {
                        this.mHandler.postDelayed(this.AaU, (long) this.aiN);
                        break;
                    }
                case 1:
                case 3:
                    i = this.aia;
                    View childAt = getChildAt(i - getFirstVisiblePosition());
                    if (action == 1 && this.ath != -1) {
                        if (this.AaV == null) {
                            this.AaV = new b(this, (byte) 0);
                        }
                        b bVar = this.AaV;
                        bVar.Dg = childAt;
                        bVar.zyT = i;
                        bVar.dJk();
                        this.mHandler.post(bVar);
                    }
                    this.mHandler.removeCallbacks(this.AaU);
                    setScrollEnable(true);
                    dMK();
                    if (this.AaP >= 0) {
                        view = getChildAt(this.AaP - getFirstVisiblePosition());
                        if (view != null) {
                            view.setPressed(false);
                            view.setSelected(false);
                            fv(view);
                        }
                    }
                    this.yto = 6;
                    break;
                case 2:
                    i = (int) motionEvent.getX();
                    action = (int) motionEvent.getY();
                    if (this.yto != 5) {
                        if (Math.abs(this.lbS - ((float) i)) > ((float) this.mTouchSlop)) {
                            this.ath = -1;
                            this.mHandler.removeCallbacks(this.AaU);
                        }
                        dMK();
                        break;
                    }
                    action = pointToPosition(i, action);
                    this.aia = action;
                    if (action < 0 || !(getAdapter() instanceof g) || !((g) getAdapter()).ui(action)) {
                        dMK();
                        if (this.AaP >= 0) {
                            view = getChildAt(this.AaP - getFirstVisiblePosition());
                            if (view != null) {
                                view.setPressed(false);
                                view.setSelected(false);
                                fv(view);
                            }
                        }
                    } else if (this.AaP != action) {
                        this.AaP = action;
                        view = getChildAt(action - getFirstVisiblePosition());
                        layoutChildren();
                        if (view != null) {
                            view.setPressed(true);
                            view.setSelected(true);
                            fv(view);
                            az(view, this.AaP);
                        }
                    }
                    this.mHandler.removeCallbacks(this.AaU);
                    break;
            }
            AppMethodBeat.o(62961);
            return true;
        }
        dMK();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(62961);
        return onTouchEvent;
    }
}
