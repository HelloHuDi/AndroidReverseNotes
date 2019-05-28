package com.tencent.p177mm.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.widget.ListAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.CustomViewPager;
import com.tencent.p177mm.p612ui.base.MMFlipper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.view.p645a.C36374g;
import com.tencent.p177mm.view.popview.AbstractPopView;
import com.tencent.p177mm.view.popview.C16073a;

/* renamed from: com.tencent.mm.view.SmileySubGrid */
public class SmileySubGrid extends SmileyGrid {
    int AaP = -1;
    boolean AaQ;
    private AbstractPopView AaR;
    private C16037c AaS;
    private int AaT;
    private C30839a AaU;
    private C17066b AaV;
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
    private C7306ak mHandler = new C7306ak();
    private int mTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    int yto = 6;

    /* renamed from: com.tencent.mm.view.SmileySubGrid$c */
    class C16037c implements Runnable {
        private C16037c() {
        }

        /* synthetic */ C16037c(SmileySubGrid smileySubGrid, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(62957);
            if (!SmileySubGrid.this.lgu) {
                SmileySubGrid.this.lca.addView(SmileySubGrid.this.AaR, SmileySubGrid.this.AaR.getWindowLayoutParams());
                SmileySubGrid.this.lgu = true;
            }
            AppMethodBeat.m2505o(62957);
        }
    }

    /* renamed from: com.tencent.mm.view.SmileySubGrid$d */
    class C16038d {
        private int yxj;

        private C16038d() {
        }

        /* synthetic */ C16038d(SmileySubGrid smileySubGrid, byte b) {
            this();
        }

        public final void dJk() {
            AppMethodBeat.m2504i(62958);
            this.yxj = SmileySubGrid.m80285a(SmileySubGrid.this);
            AppMethodBeat.m2505o(62958);
        }

        public final boolean dJl() {
            AppMethodBeat.m2504i(62959);
            if (SmileySubGrid.this.hasWindowFocus() && SmileySubGrid.m80288b(SmileySubGrid.this) == this.yxj) {
                AppMethodBeat.m2505o(62959);
                return true;
            }
            AppMethodBeat.m2505o(62959);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.view.SmileySubGrid$b */
    class C17066b extends C16038d implements Runnable {
        /* renamed from: Dg */
        View f3580Dg;
        int zyT;

        private C17066b() {
            super(SmileySubGrid.this, (byte) 0);
        }

        /* synthetic */ C17066b(SmileySubGrid smileySubGrid, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(62956);
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "Click run");
            ListAdapter adapter = SmileySubGrid.this.getAdapter();
            int i = this.zyT;
            if (adapter != null && SmileySubGrid.this.getCount() > 0 && i != -1 && i < adapter.getCount() && dJl()) {
                C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "PerformClick performItemClick position:[%d] id:[%d] ", Integer.valueOf(i), Long.valueOf(adapter.getItemId(i)));
                SmileySubGrid.this.performItemClick(this.f3580Dg, i, adapter.getItemId(i));
            }
            AppMethodBeat.m2505o(62956);
        }
    }

    /* renamed from: com.tencent.mm.view.SmileySubGrid$a */
    class C30839a extends C16038d implements Runnable {
        private C30839a() {
            super(SmileySubGrid.this, (byte) 0);
        }

        /* synthetic */ C30839a(SmileySubGrid smileySubGrid, byte b) {
            this();
        }

        public final void run() {
            AppMethodBeat.m2504i(62955);
            C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "LongPress run");
            int i = SmileySubGrid.this.aia;
            SmileySubGrid smileySubGrid = SmileySubGrid.this;
            View childAt = smileySubGrid.getChildAt(i - smileySubGrid.getFirstVisiblePosition());
            if (childAt != null) {
                int i2 = SmileySubGrid.this.aia;
                long itemId = SmileySubGrid.this.getAdapter().getItemId(SmileySubGrid.this.aia);
                if (dJl()) {
                    C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "CheckForLongPress performLongPress position:[%d] id:[%d]", Integer.valueOf(i2), Long.valueOf(itemId));
                    SmileySubGrid.m80286a(SmileySubGrid.this, childAt, i);
                    SmileySubGrid.this.ath = -1;
                    SmileySubGrid.this.yto = 5;
                    SmileySubGrid.this.setScrollEnable(false);
                }
            }
            AppMethodBeat.m2505o(62955);
        }
    }

    /* renamed from: a */
    static /* synthetic */ int m80285a(SmileySubGrid smileySubGrid) {
        AppMethodBeat.m2504i(62973);
        int windowAttachCount = smileySubGrid.getWindowAttachCount();
        AppMethodBeat.m2505o(62973);
        return windowAttachCount;
    }

    /* renamed from: a */
    static /* synthetic */ void m80286a(SmileySubGrid smileySubGrid, View view, int i) {
        AppMethodBeat.m2504i(62975);
        smileySubGrid.m80287az(view, i);
        AppMethodBeat.m2505o(62975);
    }

    /* renamed from: b */
    static /* synthetic */ int m80288b(SmileySubGrid smileySubGrid) {
        AppMethodBeat.m2504i(62974);
        int windowAttachCount = smileySubGrid.getWindowAttachCount();
        AppMethodBeat.m2505o(62974);
        return windowAttachCount;
    }

    public SmileySubGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(62960);
        this.lca = (WindowManager) context.getSystemService("window");
        this.aiN = getLongTouchTime();
        this.AaT = ViewConfiguration.getPressedStateDuration();
        AppMethodBeat.m2505o(62960);
    }

    /* renamed from: az */
    private void m80287az(View view, int i) {
        AppMethodBeat.m2504i(62962);
        if (m80284QB(i)) {
            C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks already show:%d", Integer.valueOf(i));
        } else {
            C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "jacks begin show:%d", Integer.valueOf(i));
            Object item = getAdapter().getItem(i);
            if (this.AaR == null) {
                this.AaR = C16073a.m24392b(getContext(), item);
            }
            m80290cX(item);
            m80294fu(view);
        }
        this.AaY = i;
        AppMethodBeat.m2505o(62962);
    }

    /* renamed from: QB */
    private boolean m80284QB(int i) {
        AppMethodBeat.m2504i(62963);
        if (i == this.AaY && this.AaR.isShown()) {
            AppMethodBeat.m2505o(62963);
            return true;
        }
        AppMethodBeat.m2505o(62963);
        return false;
    }

    /* renamed from: fu */
    private void m80294fu(View view) {
        AppMethodBeat.m2504i(62964);
        if (this.AaS == null) {
            this.AaS = new C16037c(this, (byte) 0);
        }
        C4990ab.m7417i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "updatePopView %s", Boolean.valueOf(this.lgu));
        this.AaR.mo49356fw(view);
        if (this.lgu) {
            this.lca.updateViewLayout(this.AaR, this.AaR.getWindowLayoutParams());
            AppMethodBeat.m2505o(62964);
            return;
        }
        this.AaZ = true;
        this.mHandler.postDelayed(this.AaS, (long) this.AaT);
        AppMethodBeat.m2505o(62964);
    }

    private void dMK() {
        AppMethodBeat.m2504i(62965);
        if (this.AaS != null) {
            this.mHandler.removeCallbacks(this.AaS);
        }
        if (this.lgu) {
            this.lca.removeView(this.AaR);
            this.lgu = false;
            this.AaZ = false;
        }
        AppMethodBeat.m2505o(62965);
    }

    public void setViewParent(View view) {
        this.AaW = view;
    }

    /* renamed from: fv */
    private void m80295fv(View view) {
        AppMethodBeat.m2504i(62966);
        Rect rect = this.ahV;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        m80283N(rect.left, rect.top, rect.right, rect.bottom);
        boolean z = this.AaQ;
        if (view.isEnabled() != z) {
            this.AaQ = !z;
            refreshDrawableState();
        }
        AppMethodBeat.m2505o(62966);
    }

    /* renamed from: N */
    private void m80283N(int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(62967);
        this.ahV.set(i - getPaddingLeft(), i2 - getPaddingTop(), getPaddingRight() + i3, getPaddingBottom() + i4);
        AppMethodBeat.m2505o(62967);
    }

    /* Access modifiers changed, original: protected */
    public void setScrollEnable(boolean z) {
        AppMethodBeat.m2504i(62968);
        C4990ab.m7411d("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "cpan t setScrollEnable:%b", Boolean.valueOf(z));
        if (this.AaW != null) {
            if (this.AaW instanceof MMFlipper) {
                ((MMFlipper) this.AaW).setScrollEnable(z);
                AppMethodBeat.m2505o(62968);
                return;
            } else if (this.AaW instanceof CustomViewPager) {
                ((CustomViewPager) this.AaW).setCanSlide(z);
            }
        }
        AppMethodBeat.m2505o(62968);
    }

    /* Access modifiers changed, original: protected */
    public int getLongTouchTime() {
        AppMethodBeat.m2504i(62969);
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        AppMethodBeat.m2505o(62969);
        return longPressTimeout;
    }

    public void setIsShowPopWin(boolean z) {
        this.Aba = z;
    }

    /* renamed from: cX */
    private void m80290cX(Object obj) {
        AppMethodBeat.m2504i(62970);
        synchronized (this.Abb) {
            try {
                if (this.AaR != null) {
                    C16073a.m24391a(this.AaR, obj);
                } else {
                    C4990ab.m7416i("MicroMsg.emoji.SmileyPanel.SmileySubGrid", "mPopImageView is null.");
                }
            } finally {
                AppMethodBeat.m2505o(62970);
            }
        }
    }

    public final void release() {
        AppMethodBeat.m2504i(62971);
        super.release();
        dMK();
        if (this.AaR != null) {
            this.AaR = null;
        }
        AppMethodBeat.m2505o(62971);
    }

    public void setFromDetail(boolean z) {
        this.AaX = z;
    }

    /* Access modifiers changed, original: protected */
    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(62972);
        super.onDetachedFromWindow();
        dMK();
        AppMethodBeat.m2505o(62972);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(62961);
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
                        m80295fv(view);
                    }
                    if (this.AaU == null) {
                        this.AaU = new C30839a(this, (byte) 0);
                    }
                    this.AaU.dJk();
                    this.aia = action;
                    if (action >= 0 && (getAdapter() instanceof C36374g) && ((C36374g) getAdapter()).mo28409ui(action)) {
                        this.mHandler.postDelayed(this.AaU, (long) this.aiN);
                        break;
                    }
                case 1:
                case 3:
                    i = this.aia;
                    View childAt = getChildAt(i - getFirstVisiblePosition());
                    if (action == 1 && this.ath != -1) {
                        if (this.AaV == null) {
                            this.AaV = new C17066b(this, (byte) 0);
                        }
                        C17066b c17066b = this.AaV;
                        c17066b.f3580Dg = childAt;
                        c17066b.zyT = i;
                        c17066b.dJk();
                        this.mHandler.post(c17066b);
                    }
                    this.mHandler.removeCallbacks(this.AaU);
                    setScrollEnable(true);
                    dMK();
                    if (this.AaP >= 0) {
                        view = getChildAt(this.AaP - getFirstVisiblePosition());
                        if (view != null) {
                            view.setPressed(false);
                            view.setSelected(false);
                            m80295fv(view);
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
                    if (action < 0 || !(getAdapter() instanceof C36374g) || !((C36374g) getAdapter()).mo28409ui(action)) {
                        dMK();
                        if (this.AaP >= 0) {
                            view = getChildAt(this.AaP - getFirstVisiblePosition());
                            if (view != null) {
                                view.setPressed(false);
                                view.setSelected(false);
                                m80295fv(view);
                            }
                        }
                    } else if (this.AaP != action) {
                        this.AaP = action;
                        view = getChildAt(action - getFirstVisiblePosition());
                        layoutChildren();
                        if (view != null) {
                            view.setPressed(true);
                            view.setSelected(true);
                            m80295fv(view);
                            m80287az(view, this.AaP);
                        }
                    }
                    this.mHandler.removeCallbacks(this.AaU);
                    break;
            }
            AppMethodBeat.m2505o(62961);
            return true;
        }
        dMK();
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(62961);
        return onTouchEvent;
    }
}
