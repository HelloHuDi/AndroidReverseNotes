package com.tencent.mm.ui.conversation;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.header.b;
import com.tencent.mm.plugin.appbrand.widget.header.b.a;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ae;
import com.tencent.mm.ui.ak;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationListView extends ListView implements OnTouchListener, OnScrollListener, a, e {
    private int acV;
    private OnItemClickListener arw;
    boolean iVR = false;
    HeaderContainer iVo;
    private int iVu;
    private com.tencent.mm.plugin.appbrand.widget.header.a iVv = null;
    private View iVx;
    private MMFragmentActivity iWA;
    private int ivr = 0;
    private OnTouchListener jZu;
    private int mCount;
    private Paint mPaint = new Paint(1);
    private int mScrollState;
    private OnScrollListener nSS;
    private OnItemLongClickListener oiQ;
    private LinkedList<FixedViewInfo> zrX = new LinkedList();
    b zrY;
    private String zrZ;
    private float zsa;
    private int zsb;
    private Bitmap zsc = null;
    private RectF zsd = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private boolean zse = false;
    private NinePatchDrawable zsf = null;
    private Rect zsg = new Rect();
    private final float zsh = ((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 30));
    private final float zsi = ((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 8));
    private final float zsj = ((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 24));
    private final float zsk = ((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 64));
    private final float zsl = 0.5f;
    private final float zsm = ((float) com.tencent.mm.bz.a.fromDPToPix(getContext(), 200));
    private int zsn = 0;
    Runnable zso = null;
    Runnable zsp = null;
    Runnable zsq = null;
    View zsr;
    private OnTouchListener zss = null;
    View zst;
    private boolean zsu;
    private boolean zsv = false;

    static /* synthetic */ void a(ConversationListView conversationListView) {
        AppMethodBeat.i(34258);
        conversationListView.dIu();
        AppMethodBeat.o(34258);
    }

    static /* synthetic */ void a(ConversationListView conversationListView, float f, int i) {
        AppMethodBeat.i(34257);
        conversationListView.e(f, i);
        AppMethodBeat.o(34257);
    }

    public ConversationListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(34221);
        init(context);
        AppMethodBeat.o(34221);
    }

    public ConversationListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(34222);
        init(context);
        AppMethodBeat.o(34222);
    }

    public boolean canScrollHorizontally(int i) {
        AppMethodBeat.i(34223);
        if (this.iVo == null) {
            boolean canScrollHorizontally = super.canScrollHorizontally(i);
            AppMethodBeat.o(34223);
            return canScrollHorizontally;
        } else if (this.iVo.getBottom() >= this.iVo.getHeight()) {
            AppMethodBeat.o(34223);
            return true;
        } else {
            AppMethodBeat.o(34223);
            return false;
        }
    }

    private void init(Context context) {
        AppMethodBeat.i(34224);
        this.mPaint.setAlpha(255);
        this.mPaint.setTextSize((float) com.tencent.mm.bz.a.am(getContext(), R.dimen.lm));
        this.zrZ = getResources().getString(R.string.ar5);
        this.zsa = this.mPaint.measureText(this.zrZ);
        super.setOnScrollListener(this);
        super.setOnTouchListener(this);
        setOverScrollMode(2);
        ab.i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", Integer.valueOf(hashCode()));
        this.iVo = ((d) g.K(d.class)).df(context);
        this.iVo.setLayoutParams(new LayoutParams(-1, -2));
        addHeaderView(this.iVo);
        addFooterView(getEmptyFooter());
        this.zrY = ((d) g.K(d.class)).a(context, (ListView) this, this.iVo);
        this.zrY.a(this);
        this.iVo.setAnimController(this.zrY);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34210);
                ConversationListView.this.zsc = com.tencent.mm.sdk.platformtools.d.v(ConversationListView.this.getContext().getResources().getDrawable(R.raw.app_brand_desktop_bottom_close_icon));
                ConversationListView.this.zsf = (NinePatchDrawable) ConversationListView.this.getResources().getDrawable(R.drawable.aat);
                AppMethodBeat.o(34210);
            }
        }, "DecodeCloseIcon");
        this.zsn = (int) (((float) com.tencent.mm.bz.a.am(getContext(), R.dimen.fh)) * com.tencent.mm.bz.a.fY(getContext()));
        AppMethodBeat.o(34224);
    }

    public void setonDispatchTouchEventListener(OnTouchListener onTouchListener) {
        this.zss = onTouchListener;
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.nSS = onScrollListener;
    }

    public void setOnTouchListener(OnTouchListener onTouchListener) {
        this.jZu = onTouchListener;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        AppMethodBeat.i(34225);
        boolean onTouch = this.zrY.onTouch(view, motionEvent);
        if (this.jZu != null) {
            onTouch |= this.jZu.onTouch(view, motionEvent);
        }
        AppMethodBeat.o(34225);
        return onTouch;
    }

    /* Access modifiers changed, original: protected */
    public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.i(34226);
        super.attachViewToParent(view, i, layoutParams);
        if (this.acV <= 0 && this.zrY != null) {
            this.acV = ak.de(getContext()) + ae.hB(getContext());
            this.iVu = 0;
            this.zrY.cD(getRootView().findViewById(R.id.k0));
            this.zrY.setTabView(getRootView().findViewById(R.id.bq));
        }
        AppMethodBeat.o(34226);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(34227);
        super.onDraw(canvas);
        if (this.iVo != null && getFirstVisiblePosition() == 0 && this.iVo.isFullScreen() && this.iVo.getBottom() > 6) {
            if (this.zsb < 30) {
                AppMethodBeat.o(34227);
                return;
            } else if (((float) this.iVo.getBackUpFooterRect().top) >= this.zsm) {
                this.mPaint.reset();
                this.mPaint.setAlpha(this.zsb < 20 ? 0 : this.zsb);
                if (!(this.zsc == null || this.zsc.isRecycled())) {
                    canvas.drawBitmap(this.zsc, (float) ((getWidth() - this.zsc.getWidth()) / 2), ((float) this.iVo.getBackUpFooterRect().top) + this.zsh, this.mPaint);
                }
            }
        }
        AppMethodBeat.o(34227);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(34228);
        if (this.nSS != null) {
            this.nSS.onScrollStateChanged(absListView, i);
        }
        if (this.zrY != null) {
            this.zrY.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            if (dIv()) {
                e(0.0f, getResources().getColor(R.color.e5));
            } else {
                e(1.0f, getResources().getColor(R.color.e4));
            }
        }
        this.mScrollState = i;
        AppMethodBeat.o(34228);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(34229);
        if (this.nSS != null) {
            this.nSS.onScroll(absListView, i, i2, i3);
        }
        if (this.zrY != null) {
            this.zrY.onScroll(absListView, i, i2, i3);
        }
        if (i2 > 1 && dIw() && this.iVo != null) {
            int bottom = this.iVo.getBottom();
            this.iVo.getBackUpFooterRect().set(0, bottom, getWidth(), getHeight() + bottom);
            ab.i("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s", this.iVo.getBackUpFooterRect().toString());
            this.zsb = (int) ((255.0f * ((float) this.iVo.getBottom())) / ((float) this.iVo.getHeight()));
        }
        AppMethodBeat.o(34229);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(34230);
        try {
            super.onLayout(z, i, i2, i3, i4);
            ab.i("MicroMsg.ConversationListView", "[onLayout] changed:%s, isHeaderOpen: %b", Boolean.valueOf(z), Boolean.valueOf(dIv()));
            ab.d("MicroMsg.ConversationListView", "[onLayout] top: %d, bottom: %d, height: %d, count: %d, realCount: %d, hashCode: %s", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i4 - i2), Integer.valueOf(this.mCount), Integer.valueOf(getRealCount()), Integer.valueOf(hashCode()));
            if (z && !r0) {
                setSelection(1);
                post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34214);
                        ConversationListView.this.setSelection(1);
                        AppMethodBeat.o(34214);
                    }
                });
            }
            if (z || (this.mCount < 16 && getRealCount() != this.mCount)) {
                qH(false);
            }
            if (!(this.zsr == null || this.zsr.getVisibility() != 0 || getFirstVisiblePosition() == 0)) {
                this.zsr.setVisibility(4);
            }
            this.mCount = getRealCount();
            AppMethodBeat.o(34230);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ConversationListView", e, "alvinluo onLayout exception", new Object[0]);
            AppMethodBeat.o(34230);
        }
    }

    private int getRealCount() {
        AppMethodBeat.i(34231);
        if (getAdapter() == null) {
            AppMethodBeat.o(34231);
            return 1;
        }
        int count = (getAdapter().getCount() - getHeaderViewsCount()) - getFooterViewsCount();
        AppMethodBeat.o(34231);
        return count;
    }

    /* Access modifiers changed, original: final */
    public final void e(float f, int i) {
        AppMethodBeat.i(34232);
        if (this.iVv != null) {
            this.iVv.a(f, 0, i, 0);
        }
        AppMethodBeat.o(34232);
    }

    public final void aPs() {
        AppMethodBeat.i(34233);
        ab.d("MicroMsg.ConversationListView", "[onOpenHeader]");
        this.iVR = true;
        if (this.zso != null) {
            removeCallbacks(this.zso);
        }
        AnonymousClass7 anonymousClass7 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(34216);
                if (ConversationListView.this.dIv()) {
                    ConversationListView.a(ConversationListView.this, 0.0f, ConversationListView.this.getResources().getColor(R.color.e5));
                }
                AppMethodBeat.o(34216);
            }
        };
        this.zso = anonymousClass7;
        post(anonymousClass7);
        AppMethodBeat.o(34233);
    }

    public final void qj(int i) {
        AppMethodBeat.i(34234);
        ab.d("MicroMsg.ConversationListView", "[onCloseHeader]");
        this.zsu = false;
        this.iVR = false;
        this.zsb = 0;
        if (this.zso != null) {
            removeCallbacks(this.zso);
        }
        AnonymousClass8 anonymousClass8 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(34217);
                ConversationListView.a(ConversationListView.this, 1.0f, ConversationListView.this.getResources().getColor(R.color.e4));
                AppMethodBeat.o(34217);
            }
        };
        this.zso = anonymousClass8;
        post(anonymousClass8);
        AppMethodBeat.o(34234);
    }

    public final void qk(int i) {
        AppMethodBeat.i(34235);
        qj(i);
        AppMethodBeat.o(34235);
    }

    public final void aPt() {
        AppMethodBeat.i(34236);
        aPs();
        AppMethodBeat.o(34236);
    }

    /* Access modifiers changed, original: final */
    public final void qH(boolean z) {
        AppMethodBeat.i(34237);
        if (this.zst == null) {
            AppMethodBeat.o(34237);
        } else if (z) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34218);
                    ConversationListView.a(ConversationListView.this);
                    AppMethodBeat.o(34218);
                }
            }, 0);
            AppMethodBeat.o(34237);
        } else {
            dIu();
            AppMethodBeat.o(34237);
        }
    }

    private void dIu() {
        boolean z;
        int height;
        AppMethodBeat.i(34238);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zst.getLayoutParams();
        float Pr = Pr(getAdapter() == null ? 0 : getAdapter().getCount());
        if (Pr < 0.0f) {
            z = true;
        } else {
            z = false;
        }
        int i = layoutParams.height;
        ab.i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + z + " old height:" + i);
        View findViewById = getRootView().findViewById(R.id.bq);
        if (findViewById != null) {
            ab.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", Integer.valueOf(findViewById.getHeight()));
        }
        int dimension = (int) getResources().getDimension(R.dimen.m3);
        if (findViewById != null) {
            height = findViewById.getHeight();
        } else {
            height = 0;
        }
        if (height <= 0) {
            height = this.zsn;
        }
        ab.d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", Integer.valueOf(height));
        if (z) {
            layoutParams.height = height;
        } else {
            if (Pr < ((float) height)) {
                Pr = (float) height;
            }
            layoutParams.height = (int) Pr;
        }
        if (i != layoutParams.height) {
            ab.i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", Boolean.valueOf(dIv()));
            if ((!z || Math.abs(Pr) <= ((float) (height + dimension))) && !dIv()) {
                ab.i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
                setSelection(1);
            }
            this.zst.requestLayout();
        }
        AppMethodBeat.o(34238);
    }

    private View getEmptyFooter() {
        AppMethodBeat.i(34239);
        View findViewById = getRootView().findViewById(R.id.bq);
        int dimension = (int) getResources().getDimension(R.dimen.m3);
        int height = findViewById != null ? findViewById.getHeight() : 0;
        if (height > 0) {
            dimension = height;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.zst = new View(getContext());
        this.zst.setLayoutParams(new LinearLayout.LayoutParams(-1, dimension));
        linearLayout.addView(this.zst);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.a69));
        AppMethodBeat.o(34239);
        return linearLayout;
    }

    private float Pr(int i) {
        AppMethodBeat.i(34240);
        float measuredHeight = (float) (getMeasuredHeight() - (((int) getResources().getDimension(R.dimen.m3)) * ((i - getHeaderViewsCount()) - getFooterViewsCount())));
        ab.d("MicroMsg.ConversationListView", "alvinluo isFullScreen getMeasuredHeight: %d", Integer.valueOf(getMeasuredHeight()));
        ab.i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + i + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + measuredHeight);
        AppMethodBeat.o(34240);
        return measuredHeight;
    }

    public final void qs(int i) {
    }

    public void setSelection(int i) {
        AppMethodBeat.i(34241);
        ab.i("MicroMsg.ConversationListView", "[setSelection] position:%s", Integer.valueOf(i));
        if (i == 0) {
            super.setSelectionFromTop(getFirstHeaderVisible(), this.iVu);
            AppMethodBeat.o(34241);
            return;
        }
        super.setSelectionFromTop(i, this.iVu);
        AppMethodBeat.o(34241);
    }

    public void smoothScrollToPosition(int i) {
        AppMethodBeat.i(34242);
        ab.i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", Integer.valueOf(i));
        if (i == 0) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.iVu);
            AppMethodBeat.o(34242);
            return;
        }
        super.smoothScrollToPositionFromTop(i, this.iVu);
        AppMethodBeat.o(34242);
    }

    public void smoothScrollToPositionFromTop(int i, int i2) {
        AppMethodBeat.i(34243);
        ab.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.iVu + i2);
            AppMethodBeat.o(34243);
            return;
        }
        super.smoothScrollToPositionFromTop(i, this.iVu + i2);
        AppMethodBeat.o(34243);
    }

    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        AppMethodBeat.i(34244);
        ab.i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i == 0) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.iVu + i2, i3);
            AppMethodBeat.o(34244);
            return;
        }
        super.smoothScrollToPositionFromTop(i, this.iVu + i2, i3);
        AppMethodBeat.o(34244);
    }

    public final void i(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.i(34245);
        ab.i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + z + " isAnim:" + z2 + " isScrollFirst:" + z3);
        if (z) {
            if (this.zrY != null) {
                this.zrY.aOS();
                AppMethodBeat.o(34245);
                return;
            }
        } else if (this.zrY != null) {
            this.zrY.qh(0);
        }
        AppMethodBeat.o(34245);
    }

    public int getFirstHeaderVisible() {
        AppMethodBeat.i(34246);
        Iterator it = this.zrX.iterator();
        int i = 0;
        while (it.hasNext()) {
            FixedViewInfo fixedViewInfo = (FixedViewInfo) it.next();
            if (fixedViewInfo.view == this.iVo) {
                i++;
            } else {
                if (fixedViewInfo.view != null && (fixedViewInfo.view instanceof ViewGroup)) {
                    View childAt = ((ViewGroup) fixedViewInfo.view).getChildAt(0);
                    if (childAt != null && childAt.getVisibility() == 0) {
                        ab.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i));
                        AppMethodBeat.o(34246);
                        break;
                    }
                }
                i++;
            }
        }
        ab.i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i));
        AppMethodBeat.o(34246);
        return i;
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        AppMethodBeat.i(34247);
        super.addHeaderView(view, obj, z);
        FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.zrX.add(fixedViewInfo);
        AppMethodBeat.o(34247);
    }

    public final boolean dIv() {
        AppMethodBeat.i(34248);
        if (dIw() && this.iVR) {
            AppMethodBeat.o(34248);
            return true;
        }
        AppMethodBeat.o(34248);
        return false;
    }

    private boolean dIw() {
        AppMethodBeat.i(34249);
        if (this.iVo == null) {
            AppMethodBeat.o(34249);
            return false;
        } else if (this.iVo.getBottom() < this.acV + 3 || getFirstVisiblePosition() != 0) {
            AppMethodBeat.o(34249);
            return false;
        } else {
            AppMethodBeat.o(34249);
            return true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(34250);
        if (this.zss != null) {
            this.zss.onTouch(this, motionEvent);
        }
        try {
            boolean dispatchTouchEvent;
            if (dIv() && this.iVo != null) {
                if (motionEvent.getAction() == 0) {
                    if (this.iVo.getBackUpFooterRect().contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                        this.zsv = true;
                    } else {
                        this.zsv = false;
                    }
                }
                if (!this.zsv) {
                    dispatchTouchEvent = this.iVo.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(34250);
                    return dispatchTouchEvent;
                }
            }
            if (this.iVo == null || this.iVo.getBottom() < this.iVo.getHeight() || !this.iVo.isFullScreen() || getFirstVisiblePosition() != 0) {
                if (this.zsu && motionEvent.getAction() == 1) {
                    ab.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", Boolean.valueOf(dIv()), Boolean.valueOf(dIw()));
                    if (dIv()) {
                        motionEvent.setAction(3);
                    } else {
                        this.zsu = false;
                    }
                }
                if (motionEvent.getAction() == 0 && this.zrY != null && motionEvent.getAction() == 0) {
                    this.zrY.F(motionEvent);
                }
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(34250);
                return dispatchTouchEvent;
            }
            if (motionEvent.getAction() == 0 && this.iVo.getBackUpFooterRect().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.zsu = true;
            } else if (motionEvent.getAction() == 0) {
                this.zsu = false;
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (this.zrY != null && motionEvent.getAction() == 0) {
                    this.zrY.F(motionEvent);
                }
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(34250);
                return dispatchTouchEvent;
            } else if (this.zsu) {
                this.zsu = false;
                if (this.zrY != null) {
                    ab.i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
                    this.zrY.qh(12);
                }
                if (motionEvent.getAction() == 1) {
                    ab.i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event");
                    motionEvent.setAction(3);
                    dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.o(34250);
                    return dispatchTouchEvent;
                }
                AppMethodBeat.o(34250);
                return true;
            } else {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.o(34250);
                return dispatchTouchEvent;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ConversationListView", e, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
            AppMethodBeat.o(34250);
            return false;
        }
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.i(34251);
        this.oiQ = onItemLongClickListener;
        super.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(34219);
                ab.i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", Boolean.valueOf(ConversationListView.this.zsu));
                if (ConversationListView.this.oiQ == null || ConversationListView.this.zsu) {
                    AppMethodBeat.o(34219);
                    return false;
                }
                boolean onItemLongClick = ConversationListView.this.oiQ.onItemLongClick(adapterView, view, i, j);
                AppMethodBeat.o(34219);
                return onItemLongClick;
            }
        });
        AppMethodBeat.o(34251);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(34252);
        this.arw = onItemClickListener;
        super.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(34220);
                ab.i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", Boolean.valueOf(ConversationListView.this.zsu));
                if (!(ConversationListView.this.arw == null || ConversationListView.this.zsu)) {
                    ConversationListView.this.arw.onItemClick(adapterView, view, i, j);
                }
                AppMethodBeat.o(34220);
            }
        });
        AppMethodBeat.o(34252);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(34253);
        super.onConfigurationChanged(configuration);
        ab.i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", Integer.valueOf(configuration.orientation), Integer.valueOf(this.ivr));
        qH(true);
        if (this.zrY != null) {
            this.zrY.gY();
        }
        if (this.iVo != null) {
            this.iVo.a(configuration);
        }
        e(1.0f, getContext().getResources().getColor(R.color.e4));
        if (this.zsq != null) {
            removeCallbacks(this.zsq);
        }
        AnonymousClass2 anonymousClass2 = new Runnable() {
            public final void run() {
                AppMethodBeat.i(34211);
                ConversationListView.this.setSelection(1);
                ConversationListView.e(ConversationListView.this);
                AppMethodBeat.o(34211);
            }
        };
        this.zsq = anonymousClass2;
        postDelayed(anonymousClass2, 800);
        this.iVR = false;
        AppMethodBeat.o(34253);
    }

    public void setActionBarUpdateCallback(final com.tencent.mm.plugin.appbrand.widget.header.a aVar) {
        AppMethodBeat.i(34254);
        if (this.zrY != null) {
            this.iVv = aVar;
            this.zrY.setActionBarUpdateCallback(new com.tencent.mm.plugin.appbrand.widget.header.a() {
                public final void a(float f, int i, int i2, int i3) {
                    AppMethodBeat.i(34213);
                    int color = (((int) (255.0f * f)) << 24) | (ConversationListView.this.getResources().getColor(R.color.vy) & 16777215);
                    ConversationListView.this.setBackgroundColor(color);
                    if (ConversationListView.this.iVx != null) {
                        ConversationListView.this.iVx.setBackgroundColor(color);
                    }
                    if (aVar != null) {
                        aVar.a(f, i, i2, i3);
                    }
                    AppMethodBeat.o(34213);
                }
            });
        }
        AppMethodBeat.o(34254);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
        AppMethodBeat.i(34255);
        this.iWA = mMFragmentActivity;
        if (this.iVo != null) {
            this.iVo.setActivity(this.iWA);
        }
        AppMethodBeat.o(34255);
    }

    public void setStatusBarMaskView(View view) {
        AppMethodBeat.i(34256);
        this.iVx = view;
        if (this.zrY != null) {
            this.zrY.setStatusBarMaskView(view);
        }
        AppMethodBeat.o(34256);
    }

    static /* synthetic */ void e(ConversationListView conversationListView) {
        AppMethodBeat.i(34259);
        ab.i("MicroMsg.ConversationListView", "alvinluo resetListAlpha first: %d, last: %d", Integer.valueOf(1), Integer.valueOf(conversationListView.getChildCount()));
        for (int i = 1; i <= r2; i++) {
            View childAt = conversationListView.getChildAt(i);
            if (childAt != null) {
                ab.v("MicroMsg.ConversationListView", "alvinluo resetListAlpha index: %d", Integer.valueOf(i));
                childAt.setAlpha(1.0f);
            }
        }
        AppMethodBeat.o(34259);
    }
}
