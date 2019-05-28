package com.tencent.p177mm.p612ui.conversation;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10984a;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10985b.C10986a;
import com.tencent.p177mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38619e;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5056d;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.conversation.ConversationListView */
public class ConversationListView extends ListView implements OnTouchListener, OnScrollListener, C10986a, C38619e {
    private int acV;
    private OnItemClickListener arw;
    boolean iVR = false;
    HeaderContainer iVo;
    private int iVu;
    private C10984a iVv = null;
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
    C10985b zrY;
    private String zrZ;
    private float zsa;
    private int zsb;
    private Bitmap zsc = null;
    private RectF zsd = new RectF(0.0f, 0.0f, 0.0f, 0.0f);
    private boolean zse = false;
    private NinePatchDrawable zsf = null;
    private Rect zsg = new Rect();
    private final float zsh = ((float) C1338a.fromDPToPix(getContext(), 30));
    private final float zsi = ((float) C1338a.fromDPToPix(getContext(), 8));
    private final float zsj = ((float) C1338a.fromDPToPix(getContext(), 24));
    private final float zsk = ((float) C1338a.fromDPToPix(getContext(), 64));
    private final float zsl = 0.5f;
    private final float zsm = ((float) C1338a.fromDPToPix(getContext(), 200));
    private int zsn = 0;
    Runnable zso = null;
    Runnable zsp = null;
    Runnable zsq = null;
    View zsr;
    private OnTouchListener zss = null;
    View zst;
    private boolean zsu;
    private boolean zsv = false;

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$11 */
    class C2392911 implements OnItemClickListener {
        C2392911() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(34220);
            C4990ab.m7417i("MicroMsg.ConversationListView", "alvinluo onItemClick isCanClose: %b", Boolean.valueOf(ConversationListView.this.zsu));
            if (!(ConversationListView.this.arw == null || ConversationListView.this.zsu)) {
                ConversationListView.this.arw.onItemClick(adapterView, view, i, j);
            }
            AppMethodBeat.m2505o(34220);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$6 */
    class C239316 implements Runnable {
        final /* synthetic */ int bVv = 11;

        C239316() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34215);
            ConversationListView conversationListView = ConversationListView.this;
            int i = this.bVv;
            if (conversationListView.zrY != null) {
                conversationListView.zrY.mo22628qh(i);
            }
            AppMethodBeat.m2505o(34215);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$7 */
    class C239327 implements Runnable {
        C239327() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34216);
            if (ConversationListView.this.dIv()) {
                ConversationListView.m61386a(ConversationListView.this, 0.0f, ConversationListView.this.getResources().getColor(C25738R.color.f11705e5));
            }
            AppMethodBeat.m2505o(34216);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$8 */
    class C239338 implements Runnable {
        C239338() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34217);
            ConversationListView.m61386a(ConversationListView.this, 1.0f, ConversationListView.this.getResources().getColor(C25738R.color.f11704e4));
            AppMethodBeat.m2505o(34217);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$10 */
    class C3625410 implements OnItemLongClickListener {
        C3625410() {
        }

        public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(34219);
            C4990ab.m7417i("MicroMsg.ConversationListView", "alvinluo onItemLongClick isCanClose: %b", Boolean.valueOf(ConversationListView.this.zsu));
            if (ConversationListView.this.oiQ == null || ConversationListView.this.zsu) {
                AppMethodBeat.m2505o(34219);
                return false;
            }
            boolean onItemLongClick = ConversationListView.this.oiQ.onItemLongClick(adapterView, view, i, j);
            AppMethodBeat.m2505o(34219);
            return onItemLongClick;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$5 */
    class C362555 implements Runnable {
        C362555() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34214);
            ConversationListView.this.setSelection(1);
            AppMethodBeat.m2505o(34214);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$1 */
    class C368791 implements Runnable {
        C368791() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34210);
            ConversationListView.this.zsc = C5056d.m7668v(ConversationListView.this.getContext().getResources().getDrawable(C1318a.app_brand_desktop_bottom_close_icon));
            ConversationListView.this.zsf = (NinePatchDrawable) ConversationListView.this.getResources().getDrawable(C25738R.drawable.aat);
            AppMethodBeat.m2505o(34210);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$2 */
    class C368802 implements Runnable {
        C368802() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34211);
            ConversationListView.this.setSelection(1);
            ConversationListView.m61390e(ConversationListView.this);
            AppMethodBeat.m2505o(34211);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$3 */
    class C368813 implements Runnable {
        C368813() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34212);
            ConversationListView.this.smoothScrollToPositionFromTop(0, 0, 300);
            AppMethodBeat.m2505o(34212);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationListView$9 */
    class C368829 implements Runnable {
        C368829() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34218);
            ConversationListView.m61385a(ConversationListView.this);
            AppMethodBeat.m2505o(34218);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m61385a(ConversationListView conversationListView) {
        AppMethodBeat.m2504i(34258);
        conversationListView.dIu();
        AppMethodBeat.m2505o(34258);
    }

    /* renamed from: a */
    static /* synthetic */ void m61386a(ConversationListView conversationListView, float f, int i) {
        AppMethodBeat.m2504i(34257);
        conversationListView.mo58747e(f, i);
        AppMethodBeat.m2505o(34257);
    }

    public ConversationListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(34221);
        init(context);
        AppMethodBeat.m2505o(34221);
    }

    public ConversationListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(34222);
        init(context);
        AppMethodBeat.m2505o(34222);
    }

    public boolean canScrollHorizontally(int i) {
        AppMethodBeat.m2504i(34223);
        if (this.iVo == null) {
            boolean canScrollHorizontally = super.canScrollHorizontally(i);
            AppMethodBeat.m2505o(34223);
            return canScrollHorizontally;
        } else if (this.iVo.getBottom() >= this.iVo.getHeight()) {
            AppMethodBeat.m2505o(34223);
            return true;
        } else {
            AppMethodBeat.m2505o(34223);
            return false;
        }
    }

    private void init(Context context) {
        AppMethodBeat.m2504i(34224);
        this.mPaint.setAlpha(255);
        this.mPaint.setTextSize((float) C1338a.m2857am(getContext(), C25738R.dimen.f9964lm));
        this.zrZ = getResources().getString(C25738R.string.ar5);
        this.zsa = this.mPaint.measureText(this.zrZ);
        super.setOnScrollListener(this);
        super.setOnTouchListener(this);
        setOverScrollMode(2);
        C4990ab.m7417i("MicroMsg.ConversationListView", "alvinluo HeaderContainer new, ConversationListView: %d", Integer.valueOf(hashCode()));
        this.iVo = ((C11048d) C1720g.m3528K(C11048d.class)).mo22749df(context);
        this.iVo.setLayoutParams(new LayoutParams(-1, -2));
        addHeaderView(this.iVo);
        addFooterView(getEmptyFooter());
        this.zrY = ((C11048d) C1720g.m3528K(C11048d.class)).mo22743a(context, (ListView) this, this.iVo);
        this.zrY.mo22616a(this);
        this.iVo.setAnimController(this.zrY);
        C7305d.post(new C368791(), "DecodeCloseIcon");
        this.zsn = (int) (((float) C1338a.m2857am(getContext(), C25738R.dimen.f9782fh)) * C1338a.m2862fY(getContext()));
        AppMethodBeat.m2505o(34224);
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
        AppMethodBeat.m2504i(34225);
        boolean onTouch = this.zrY.onTouch(view, motionEvent);
        if (this.jZu != null) {
            onTouch |= this.jZu.onTouch(view, motionEvent);
        }
        AppMethodBeat.m2505o(34225);
        return onTouch;
    }

    /* Access modifiers changed, original: protected */
    public void attachViewToParent(View view, int i, ViewGroup.LayoutParams layoutParams) {
        AppMethodBeat.m2504i(34226);
        super.attachViewToParent(view, i, layoutParams);
        if (this.acV <= 0 && this.zrY != null) {
            this.acV = C5230ak.m7987de(getContext()) + C5222ae.m7948hB(getContext());
            this.iVu = 0;
            this.zrY.mo22621cD(getRootView().findViewById(2131820940));
            this.zrY.setTabView(getRootView().findViewById(2131820634));
        }
        AppMethodBeat.m2505o(34226);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(34227);
        super.onDraw(canvas);
        if (this.iVo != null && getFirstVisiblePosition() == 0 && this.iVo.isFullScreen() && this.iVo.getBottom() > 6) {
            if (this.zsb < 30) {
                AppMethodBeat.m2505o(34227);
                return;
            } else if (((float) this.iVo.getBackUpFooterRect().top) >= this.zsm) {
                this.mPaint.reset();
                this.mPaint.setAlpha(this.zsb < 20 ? 0 : this.zsb);
                if (!(this.zsc == null || this.zsc.isRecycled())) {
                    canvas.drawBitmap(this.zsc, (float) ((getWidth() - this.zsc.getWidth()) / 2), ((float) this.iVo.getBackUpFooterRect().top) + this.zsh, this.mPaint);
                }
            }
        }
        AppMethodBeat.m2505o(34227);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(34228);
        if (this.nSS != null) {
            this.nSS.onScrollStateChanged(absListView, i);
        }
        if (this.zrY != null) {
            this.zrY.onScrollStateChanged(absListView, i);
        }
        if (i == 0) {
            if (dIv()) {
                mo58747e(0.0f, getResources().getColor(C25738R.color.f11705e5));
            } else {
                mo58747e(1.0f, getResources().getColor(C25738R.color.f11704e4));
            }
        }
        this.mScrollState = i;
        AppMethodBeat.m2505o(34228);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(34229);
        if (this.nSS != null) {
            this.nSS.onScroll(absListView, i, i2, i3);
        }
        if (this.zrY != null) {
            this.zrY.onScroll(absListView, i, i2, i3);
        }
        if (i2 > 1 && dIw() && this.iVo != null) {
            int bottom = this.iVo.getBottom();
            this.iVo.getBackUpFooterRect().set(0, bottom, getWidth(), getHeight() + bottom);
            C4990ab.m7417i("MicroMsg.ConversationListView", "alvinluo onScroll BackUpFooterRect: %s", this.iVo.getBackUpFooterRect().toString());
            this.zsb = (int) ((255.0f * ((float) this.iVo.getBottom())) / ((float) this.iVo.getHeight()));
        }
        AppMethodBeat.m2505o(34229);
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(34230);
        try {
            super.onLayout(z, i, i2, i3, i4);
            C4990ab.m7417i("MicroMsg.ConversationListView", "[onLayout] changed:%s, isHeaderOpen: %b", Boolean.valueOf(z), Boolean.valueOf(dIv()));
            C4990ab.m7411d("MicroMsg.ConversationListView", "[onLayout] top: %d, bottom: %d, height: %d, count: %d, realCount: %d, hashCode: %s", Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i4 - i2), Integer.valueOf(this.mCount), Integer.valueOf(getRealCount()), Integer.valueOf(hashCode()));
            if (z && !r0) {
                setSelection(1);
                post(new C362555());
            }
            if (z || (this.mCount < 16 && getRealCount() != this.mCount)) {
                mo58757qH(false);
            }
            if (!(this.zsr == null || this.zsr.getVisibility() != 0 || getFirstVisiblePosition() == 0)) {
                this.zsr.setVisibility(4);
            }
            this.mCount = getRealCount();
            AppMethodBeat.m2505o(34230);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ConversationListView", e, "alvinluo onLayout exception", new Object[0]);
            AppMethodBeat.m2505o(34230);
        }
    }

    private int getRealCount() {
        AppMethodBeat.m2504i(34231);
        if (getAdapter() == null) {
            AppMethodBeat.m2505o(34231);
            return 1;
        }
        int count = (getAdapter().getCount() - getHeaderViewsCount()) - getFooterViewsCount();
        AppMethodBeat.m2505o(34231);
        return count;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: e */
    public final void mo58747e(float f, int i) {
        AppMethodBeat.m2504i(34232);
        if (this.iVv != null) {
            this.iVv.mo22614a(f, 0, i, 0);
        }
        AppMethodBeat.m2505o(34232);
    }

    public final void aPs() {
        AppMethodBeat.m2504i(34233);
        C4990ab.m7410d("MicroMsg.ConversationListView", "[onOpenHeader]");
        this.iVR = true;
        if (this.zso != null) {
            removeCallbacks(this.zso);
        }
        C239327 c239327 = new C239327();
        this.zso = c239327;
        post(c239327);
        AppMethodBeat.m2505o(34233);
    }

    /* renamed from: qj */
    public final void mo22635qj(int i) {
        AppMethodBeat.m2504i(34234);
        C4990ab.m7410d("MicroMsg.ConversationListView", "[onCloseHeader]");
        this.zsu = false;
        this.iVR = false;
        this.zsb = 0;
        if (this.zso != null) {
            removeCallbacks(this.zso);
        }
        C239338 c239338 = new C239338();
        this.zso = c239338;
        post(c239338);
        AppMethodBeat.m2505o(34234);
    }

    /* renamed from: qk */
    public final void mo22636qk(int i) {
        AppMethodBeat.m2504i(34235);
        mo22635qj(i);
        AppMethodBeat.m2505o(34235);
    }

    public final void aPt() {
        AppMethodBeat.m2504i(34236);
        aPs();
        AppMethodBeat.m2505o(34236);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: qH */
    public final void mo58757qH(boolean z) {
        AppMethodBeat.m2504i(34237);
        if (this.zst == null) {
            AppMethodBeat.m2505o(34237);
        } else if (z) {
            postDelayed(new C368829(), 0);
            AppMethodBeat.m2505o(34237);
        } else {
            dIu();
            AppMethodBeat.m2505o(34237);
        }
    }

    private void dIu() {
        boolean z;
        int height;
        AppMethodBeat.m2504i(34238);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.zst.getLayoutParams();
        float Pr = m61382Pr(getAdapter() == null ? 0 : getAdapter().getCount());
        if (Pr < 0.0f) {
            z = true;
        } else {
            z = false;
        }
        int i = layoutParams.height;
        C4990ab.m7416i("MicroMsg.ConversationListView", "[checkEmptyFooter] isRealFull:" + z + " old height:" + i);
        View findViewById = getRootView().findViewById(2131820634);
        if (findViewById != null) {
            C4990ab.m7417i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabView Height: %d", Integer.valueOf(findViewById.getHeight()));
        }
        int dimension = (int) getResources().getDimension(C25738R.dimen.f9978m3);
        if (findViewById != null) {
            height = findViewById.getHeight();
        } else {
            height = 0;
        }
        if (height <= 0) {
            height = this.zsn;
        }
        C4990ab.m7411d("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter tabHeight: %d", Integer.valueOf(height));
        if (z) {
            layoutParams.height = height;
        } else {
            if (Pr < ((float) height)) {
                Pr = (float) height;
            }
            layoutParams.height = (int) Pr;
        }
        if (i != layoutParams.height) {
            C4990ab.m7417i("MicroMsg.ConversationListView", "alvinluo checkEmptyFooter isHeaderOpen: %b", Boolean.valueOf(dIv()));
            if ((!z || Math.abs(Pr) <= ((float) (height + dimension))) && !dIv()) {
                C4990ab.m7416i("MicroMsg.ConversationListView", "[checkEmptyFooter] setSelection");
                setSelection(1);
            }
            this.zst.requestLayout();
        }
        AppMethodBeat.m2505o(34238);
    }

    private View getEmptyFooter() {
        AppMethodBeat.m2504i(34239);
        View findViewById = getRootView().findViewById(2131820634);
        int dimension = (int) getResources().getDimension(C25738R.dimen.f9978m3);
        int height = findViewById != null ? findViewById.getHeight() : 0;
        if (height > 0) {
            dimension = height;
        }
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.zst = new View(getContext());
        this.zst.setLayoutParams(new LinearLayout.LayoutParams(-1, dimension));
        linearLayout.addView(this.zst);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(C25738R.color.a69));
        AppMethodBeat.m2505o(34239);
        return linearLayout;
    }

    /* renamed from: Pr */
    private float m61382Pr(int i) {
        AppMethodBeat.m2504i(34240);
        float measuredHeight = (float) (getMeasuredHeight() - (((int) getResources().getDimension(C25738R.dimen.f9978m3)) * ((i - getHeaderViewsCount()) - getFooterViewsCount())));
        C4990ab.m7411d("MicroMsg.ConversationListView", "alvinluo isFullScreen getMeasuredHeight: %d", Integer.valueOf(getMeasuredHeight()));
        C4990ab.m7416i("MicroMsg.ConversationListView", "[isFullScreen] totalItemCount:" + i + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount() + " extraHeight:" + measuredHeight);
        AppMethodBeat.m2505o(34240);
        return measuredHeight;
    }

    /* renamed from: qs */
    public final void mo6518qs(int i) {
    }

    public void setSelection(int i) {
        AppMethodBeat.m2504i(34241);
        C4990ab.m7417i("MicroMsg.ConversationListView", "[setSelection] position:%s", Integer.valueOf(i));
        if (i == 0) {
            super.setSelectionFromTop(getFirstHeaderVisible(), this.iVu);
            AppMethodBeat.m2505o(34241);
            return;
        }
        super.setSelectionFromTop(i, this.iVu);
        AppMethodBeat.m2505o(34241);
    }

    public void smoothScrollToPosition(int i) {
        AppMethodBeat.m2504i(34242);
        C4990ab.m7417i("MicroMsg.ConversationListView", "[smoothScrollToPosition] position:%s", Integer.valueOf(i));
        if (i == 0) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.iVu);
            AppMethodBeat.m2505o(34242);
            return;
        }
        super.smoothScrollToPositionFromTop(i, this.iVu);
        AppMethodBeat.m2505o(34242);
    }

    public void smoothScrollToPositionFromTop(int i, int i2) {
        AppMethodBeat.m2504i(34243);
        C4990ab.m7417i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.iVu + i2);
            AppMethodBeat.m2505o(34243);
            return;
        }
        super.smoothScrollToPositionFromTop(i, this.iVu + i2);
        AppMethodBeat.m2505o(34243);
    }

    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        AppMethodBeat.m2504i(34244);
        C4990ab.m7417i("MicroMsg.ConversationListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i == 0) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), this.iVu + i2, i3);
            AppMethodBeat.m2505o(34244);
            return;
        }
        super.smoothScrollToPositionFromTop(i, this.iVu + i2, i3);
        AppMethodBeat.m2505o(34244);
    }

    /* renamed from: i */
    public final void mo58749i(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(34245);
        C4990ab.m7416i("MicroMsg.ConversationListView", "[showAppBrandHeader] isShow:" + z + " isAnim:" + z2 + " isScrollFirst:" + z3);
        if (z) {
            if (this.zrY != null) {
                this.zrY.aOS();
                AppMethodBeat.m2505o(34245);
                return;
            }
        } else if (this.zrY != null) {
            this.zrY.mo22628qh(0);
        }
        AppMethodBeat.m2505o(34245);
    }

    public int getFirstHeaderVisible() {
        AppMethodBeat.m2504i(34246);
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
                        C4990ab.m7417i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i));
                        AppMethodBeat.m2505o(34246);
                        break;
                    }
                }
                i++;
            }
        }
        C4990ab.m7417i("MicroMsg.ConversationListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i));
        AppMethodBeat.m2505o(34246);
        return i;
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        AppMethodBeat.m2504i(34247);
        super.addHeaderView(view, obj, z);
        FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.zrX.add(fixedViewInfo);
        AppMethodBeat.m2505o(34247);
    }

    public final boolean dIv() {
        AppMethodBeat.m2504i(34248);
        if (dIw() && this.iVR) {
            AppMethodBeat.m2505o(34248);
            return true;
        }
        AppMethodBeat.m2505o(34248);
        return false;
    }

    private boolean dIw() {
        AppMethodBeat.m2504i(34249);
        if (this.iVo == null) {
            AppMethodBeat.m2505o(34249);
            return false;
        } else if (this.iVo.getBottom() < this.acV + 3 || getFirstVisiblePosition() != 0) {
            AppMethodBeat.m2505o(34249);
            return false;
        } else {
            AppMethodBeat.m2505o(34249);
            return true;
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(34250);
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
                    AppMethodBeat.m2505o(34250);
                    return dispatchTouchEvent;
                }
            }
            if (this.iVo == null || this.iVo.getBottom() < this.iVo.getHeight() || !this.iVo.isFullScreen() || getFirstVisiblePosition() != 0) {
                if (this.zsu && motionEvent.getAction() == 1) {
                    C4990ab.m7417i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event..., isHeaderOpen: %b, isHeaderVisible: %b", Boolean.valueOf(dIv()), Boolean.valueOf(dIw()));
                    if (dIv()) {
                        motionEvent.setAction(3);
                    } else {
                        this.zsu = false;
                    }
                }
                if (motionEvent.getAction() == 0 && this.zrY != null && motionEvent.getAction() == 0) {
                    this.zrY.mo22615F(motionEvent);
                }
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(34250);
                return dispatchTouchEvent;
            }
            if (motionEvent.getAction() == 0 && this.iVo.getBackUpFooterRect().contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                this.zsu = true;
            } else if (motionEvent.getAction() == 0) {
                this.zsu = false;
            }
            if (motionEvent.getAction() != 1 && motionEvent.getAction() != 3) {
                if (this.zrY != null && motionEvent.getAction() == 0) {
                    this.zrY.mo22615F(motionEvent);
                }
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(34250);
                return dispatchTouchEvent;
            } else if (this.zsu) {
                this.zsu = false;
                if (this.zrY != null) {
                    C4990ab.m7416i("MicroMsg.ConversationListView", "alvinluo closeHeader by click BackUpFooterRect");
                    this.zrY.mo22628qh(12);
                }
                if (motionEvent.getAction() == 1) {
                    C4990ab.m7416i("MicroMsg.ConversationListView", "alvinluo ConversationListView cancel touch event");
                    motionEvent.setAction(3);
                    dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                    AppMethodBeat.m2505o(34250);
                    return dispatchTouchEvent;
                }
                AppMethodBeat.m2505o(34250);
                return true;
            } else {
                dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                AppMethodBeat.m2505o(34250);
                return dispatchTouchEvent;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ConversationListView", e, "alvinluo ConversationListView dispatchTouchEvent exception", new Object[0]);
            AppMethodBeat.m2505o(34250);
            return false;
        }
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.m2504i(34251);
        this.oiQ = onItemLongClickListener;
        super.setOnItemLongClickListener(new C3625410());
        AppMethodBeat.m2505o(34251);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        AppMethodBeat.m2504i(34252);
        this.arw = onItemClickListener;
        super.setOnItemClickListener(new C2392911());
        AppMethodBeat.m2505o(34252);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(34253);
        super.onConfigurationChanged(configuration);
        C4990ab.m7417i("MicroMsg.ConversationListView", "[onConfigurationChanged] orientation:%s, last: %d", Integer.valueOf(configuration.orientation), Integer.valueOf(this.ivr));
        mo58757qH(true);
        if (this.zrY != null) {
            this.zrY.mo22625gY();
        }
        if (this.iVo != null) {
            this.iVo.mo54106a(configuration);
        }
        mo58747e(1.0f, getContext().getResources().getColor(C25738R.color.f11704e4));
        if (this.zsq != null) {
            removeCallbacks(this.zsq);
        }
        C368802 c368802 = new C368802();
        this.zsq = c368802;
        postDelayed(c368802, 800);
        this.iVR = false;
        AppMethodBeat.m2505o(34253);
    }

    public void setActionBarUpdateCallback(final C10984a c10984a) {
        AppMethodBeat.m2504i(34254);
        if (this.zrY != null) {
            this.iVv = c10984a;
            this.zrY.setActionBarUpdateCallback(new C10984a() {
                /* renamed from: a */
                public final void mo22614a(float f, int i, int i2, int i3) {
                    AppMethodBeat.m2504i(34213);
                    int color = (((int) (255.0f * f)) << 24) | (ConversationListView.this.getResources().getColor(C25738R.color.f12206vy) & 16777215);
                    ConversationListView.this.setBackgroundColor(color);
                    if (ConversationListView.this.iVx != null) {
                        ConversationListView.this.iVx.setBackgroundColor(color);
                    }
                    if (c10984a != null) {
                        c10984a.mo22614a(f, i, i2, i3);
                    }
                    AppMethodBeat.m2505o(34213);
                }
            });
        }
        AppMethodBeat.m2505o(34254);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
        AppMethodBeat.m2504i(34255);
        this.iWA = mMFragmentActivity;
        if (this.iVo != null) {
            this.iVo.setActivity(this.iWA);
        }
        AppMethodBeat.m2505o(34255);
    }

    public void setStatusBarMaskView(View view) {
        AppMethodBeat.m2504i(34256);
        this.iVx = view;
        if (this.zrY != null) {
            this.zrY.setStatusBarMaskView(view);
        }
        AppMethodBeat.m2505o(34256);
    }

    /* renamed from: e */
    static /* synthetic */ void m61390e(ConversationListView conversationListView) {
        AppMethodBeat.m2504i(34259);
        C4990ab.m7417i("MicroMsg.ConversationListView", "alvinluo resetListAlpha first: %d, last: %d", Integer.valueOf(1), Integer.valueOf(conversationListView.getChildCount()));
        for (int i = 1; i <= r2; i++) {
            View childAt = conversationListView.getChildAt(i);
            if (childAt != null) {
                C4990ab.m7419v("MicroMsg.ConversationListView", "alvinluo resetListAlpha index: %d", Integer.valueOf(i));
                childAt.setAlpha(1.0f);
            }
        }
        AppMethodBeat.m2505o(34259);
    }
}
