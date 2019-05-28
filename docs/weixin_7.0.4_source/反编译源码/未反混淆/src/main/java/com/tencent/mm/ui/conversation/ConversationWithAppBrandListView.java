package com.tencent.mm.ui.conversation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Configuration;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Vibrator;
import android.support.v4.view.t;
import android.support.v4.widget.j;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ListView.FixedViewInfo;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.io;
import com.tencent.mm.g.a.js;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.mm.plugin.appbrand.widget.recentview.AppBrandRecentView.e;
import com.tencent.mm.plugin.appbrand.widget.recentview.b;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.ak;
import java.util.Iterator;
import java.util.LinkedList;

public class ConversationWithAppBrandListView extends ListView implements OnScrollListener, e {
    private View Ek;
    private int anK;
    private int anL;
    private int anM;
    private boolean bZi;
    private boolean cAY;
    private boolean hasInit;
    private boolean iVX;
    private Vibrator iVt;
    private MMFragmentActivity iWA;
    private GyroView iWd;
    private b jat;
    private float jcW;
    private float lbS;
    private float lbT;
    private int mTouchSlop;
    private OnScrollListener nSS;
    private ValueAnimator rD;
    private LinkedList<FixedViewInfo> zrX;
    private View zsA;
    private AppBrandRecentView zsB;
    private boolean zsC;
    private Paint zsD;
    private Paint zsE;
    private String zsF;
    private float zsG;
    private com.tencent.mm.plugin.appbrand.widget.header.a.a zsH;
    private boolean zsI;
    private boolean zsJ;
    private boolean zsK;
    private float zsL;
    private float zsM;
    private int zsN;
    private boolean zsO;
    private com.tencent.mm.plugin.appbrand.widget.header.a zsP;
    private Runnable zsQ;
    private boolean zsR;
    private float zsS;
    private j zsT;
    private j zsU;
    private j zsV;
    private c<js> zsW;
    private int zsX;
    boolean zsY;
    private final c<io> zsZ;
    private View zst;
    private HeaderContainer zsz;
    private a zta;
    private int ztb;
    private float ztc;
    private float ztd;
    private float zte;
    private float ztf;
    private boolean ztg;
    private boolean zth;
    private boolean zti;
    private boolean ztj;
    private boolean ztk;
    private Runnable ztl;
    private Runnable ztm;
    private boolean ztn;
    private boolean zto;
    private int ztp;

    class a implements Runnable {
        a() {
        }

        public final void run() {
            AppMethodBeat.i(34293);
            View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
            if (ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0 && childAt != null) {
                if (childAt.getTop() >= 0) {
                    AppMethodBeat.o(34293);
                    return;
                }
                ab.i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
                if (((float) childAt.getBottom()) >= ConversationWithAppBrandListView.this.jcW) {
                    ConversationWithAppBrandListView.s(ConversationWithAppBrandListView.this);
                    AppMethodBeat.o(34293);
                    return;
                }
                ConversationWithAppBrandListView.t(ConversationWithAppBrandListView.this);
            }
            AppMethodBeat.o(34293);
        }
    }

    static /* synthetic */ void a(ConversationWithAppBrandListView conversationWithAppBrandListView, int i, int i2) {
        AppMethodBeat.i(34347);
        super.smoothScrollToPositionFromTop(i, i2);
        AppMethodBeat.o(34347);
    }

    static /* synthetic */ void e(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(34344);
        conversationWithAppBrandListView.dIE();
        AppMethodBeat.o(34344);
    }

    static /* synthetic */ void f(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(34345);
        conversationWithAppBrandListView.dIx();
        AppMethodBeat.o(34345);
    }

    static /* synthetic */ void k(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(34348);
        conversationWithAppBrandListView.dID();
        AppMethodBeat.o(34348);
    }

    static /* synthetic */ void l(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(34349);
        conversationWithAppBrandListView.qK(true);
        AppMethodBeat.o(34349);
    }

    static /* synthetic */ void q(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(34350);
        conversationWithAppBrandListView.qI(true);
        AppMethodBeat.o(34350);
    }

    static /* synthetic */ void t(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(34352);
        conversationWithAppBrandListView.Ps(0);
        AppMethodBeat.o(34352);
    }

    public ConversationWithAppBrandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(34294);
        this.zrX = new LinkedList();
        this.zsC = false;
        this.zsI = false;
        this.zsJ = false;
        this.zsK = false;
        this.zsL = 0.0f;
        this.zsM = 0.0f;
        this.zsN = 0;
        this.zsO = false;
        this.zsQ = null;
        this.zsR = true;
        this.zsS = 0.0f;
        this.zsT = null;
        this.zsU = null;
        this.zsV = null;
        this.zsW = new c<js>() {
            {
                AppMethodBeat.i(34265);
                this.xxI = js.class.getName().hashCode();
                AppMethodBeat.o(34265);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(34266);
                ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo MainUITabDoubleClick callback");
                ConversationWithAppBrandListView.this.J(0, 7);
                AppMethodBeat.o(34266);
                return false;
            }
        };
        this.bZi = true;
        this.zsX = 0;
        this.zsY = false;
        this.anK = -1;
        this.zsZ = new c<io>() {
            {
                AppMethodBeat.i(34288);
                this.xxI = io.class.getName().hashCode();
                AppMethodBeat.o(34288);
            }

            public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
                AppMethodBeat.i(34289);
                io ioVar = (io) bVar;
                ConversationWithAppBrandListView.this.J((long) ioVar.cDH.delay, ioVar.cDH.type);
                AppMethodBeat.o(34289);
                return true;
            }
        };
        this.zta = new a();
        this.ztb = 0;
        this.zte = 0.0f;
        this.ztf = 0.0f;
        this.zth = false;
        this.ztj = false;
        this.ztk = false;
        this.ztm = new Runnable() {
            public final void run() {
                AppMethodBeat.i(34284);
                ConversationWithAppBrandListView.this.iVX = false;
                ConversationWithAppBrandListView.this.ztn = true;
                ConversationWithAppBrandListView.q(ConversationWithAppBrandListView.this);
                AppMethodBeat.o(34284);
            }
        };
        this.iVX = false;
        this.ztn = false;
        this.zto = false;
        this.hasInit = false;
        this.zsT = new j(getContext().getResources().getColor(R.color.f8), getContext().getResources().getColor(R.color.f7));
        this.zsW.dnU();
        AppMethodBeat.o(34294);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
        AppMethodBeat.i(34296);
        this.iWA = mMFragmentActivity;
        dIA();
        AppMethodBeat.o(34296);
    }

    public void setActionBarUpdateCallback(com.tencent.mm.plugin.appbrand.widget.header.a aVar) {
        this.zsP = aVar;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(34297);
        super.onLayout(z, i, i2, i3, i4);
        if (z && qL(true)) {
            if (this.bZi) {
                qH(true);
                post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34287);
                        ConversationWithAppBrandListView.this.setSelection(0);
                        AppMethodBeat.o(34287);
                    }
                });
                this.zsX = i4;
                this.bZi = false;
                AppMethodBeat.o(34297);
                return;
            } else if (!(this.cAY || this.zsX == i4)) {
                ab.i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.zsX + " b:" + i4);
                qH(true);
                this.zsX = i4;
            }
        }
        AppMethodBeat.o(34297);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.i(34298);
        super.onConfigurationChanged(configuration);
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", Integer.valueOf(configuration.orientation));
        this.zsY = true;
        qH(true);
        if (this.zsH != null) {
            this.zsH.a(configuration);
        }
        this.zsR = false;
        AppMethodBeat.o(34298);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(34299);
        boolean onInterceptTouchEvent;
        if (getFirstVisiblePosition() != 0) {
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.o(34299);
            return onInterceptTouchEvent;
        }
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        switch (actionMasked) {
            case 0:
                this.anK = motionEvent.getPointerId(0);
                this.anL = (int) (motionEvent.getX() + 0.5f);
                this.anM = (int) (motionEvent.getY() + 0.5f);
                onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.o(34299);
                return onInterceptTouchEvent;
            case 2:
                actionMasked = motionEvent.findPointerIndex(this.anK);
                if (actionMasked < 0) {
                    AppMethodBeat.o(34299);
                    return false;
                }
                boolean z;
                actionIndex = (int) (motionEvent.getX(actionMasked) + 0.5f);
                actionIndex -= this.anL;
                actionMasked = ((int) (motionEvent.getY(actionMasked) + 0.5f)) - this.anM;
                if (Math.abs(actionMasked) <= this.mTouchSlop || Math.abs(actionMasked) < Math.abs(actionIndex)) {
                    z = false;
                } else {
                    z = true;
                }
                if (z && super.onInterceptTouchEvent(motionEvent)) {
                    AppMethodBeat.o(34299);
                    return true;
                }
                AppMethodBeat.o(34299);
                return false;
            case 5:
                this.anK = motionEvent.getPointerId(actionIndex);
                this.anL = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.anM = (int) (motionEvent.getY(actionIndex) + 0.5f);
                onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.o(34299);
                return onInterceptTouchEvent;
            default:
                onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.o(34299);
                return onInterceptTouchEvent;
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        AppMethodBeat.i(34300);
        FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.zrX.add(fixedViewInfo);
        if (getAdapter() != null) {
            super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
        }
        ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", Integer.valueOf(this.zrX.size()));
        AppMethodBeat.o(34300);
    }

    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        AppMethodBeat.i(34301);
        super.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(34290);
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(adapterView, view, i, j);
                }
                if (ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this)) {
                    if (ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0) {
                        ConversationWithAppBrandListView.this.J(500, 8);
                    }
                    AppMethodBeat.o(34290);
                    return;
                }
                AppMethodBeat.o(34290);
            }
        });
        AppMethodBeat.o(34301);
    }

    public void setOnItemLongClickListener(final OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.i(34302);
        super.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(34291);
                if (i == 0 && ConversationWithAppBrandListView.b(ConversationWithAppBrandListView.this)) {
                    AppMethodBeat.o(34291);
                    return false;
                } else if (onItemLongClickListener != null) {
                    boolean onItemLongClick = onItemLongClickListener.onItemLongClick(adapterView, view, i, j);
                    AppMethodBeat.o(34291);
                    return onItemLongClick;
                } else {
                    AppMethodBeat.o(34291);
                    return false;
                }
            }
        });
        AppMethodBeat.o(34302);
    }

    public final void J(long j, int i) {
        AppMethodBeat.i(34303);
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", Long.valueOf(j), Integer.valueOf(i));
        if (!qL(true)) {
            if (this.zsA != null) {
                this.zsA.setVisibility(8);
            }
            AppMethodBeat.o(34303);
        } else if (getFirstVisiblePosition() != 0) {
            AppMethodBeat.o(34303);
        } else {
            if (!(this.jat == null || this.zsH == null)) {
                this.jat.N(this.zsH.getRecentAppBrandCount(), this.zsH.getStarAppBrandCount(), i);
                this.zsH.qu(i);
            }
            if (j > 0) {
                if (this.zsQ != null) {
                    removeCallbacks(this.zsQ);
                }
                this.zsQ = new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34292);
                        if (ConversationWithAppBrandListView.this.zsH != null) {
                            ab.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
                            ConversationWithAppBrandListView.this.zsH.aQb();
                        }
                        if (ConversationWithAppBrandListView.this.zsB != null) {
                            ConversationWithAppBrandListView.this.zsB.smoothScrollToPosition(0);
                        }
                        View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
                        int bottom = childAt == null ? 0 : childAt.getBottom();
                        if (bottom != 0) {
                            ConversationWithAppBrandListView.this.smoothScrollBy(bottom, 0);
                        }
                        ConversationWithAppBrandListView.this.setSelection(0);
                        ConversationWithAppBrandListView.e(ConversationWithAppBrandListView.this);
                        AppMethodBeat.o(34292);
                    }
                };
                postDelayed(this.zsQ, j);
            } else {
                if (this.zsH != null) {
                    this.zsH.aQb();
                }
                if (this.zsB != null) {
                    this.zsB.smoothScrollToPosition(0);
                }
                setSelection(0);
                ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
                dIE();
            }
            dID();
            AppMethodBeat.o(34303);
        }
    }

    public final void qs(int i) {
        AppMethodBeat.i(34304);
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", Integer.valueOf(i), Boolean.valueOf(this.zsC));
        if (qL(true)) {
            if (i == 1 && this.zsA != null) {
                setEmptyViewVisible(true);
            } else if (i > 1 && this.zsA != null) {
                setEmptyViewVisible(false);
            }
            if (this.zsA != null && this.zsA.getVisibility() == 8) {
                this.zsA.setVisibility(0);
                setSelection(getFirstVisiblePosition());
            }
            AppMethodBeat.o(34304);
            return;
        }
        ab.w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
        if (this.zsA != null) {
            this.zsA.setVisibility(8);
        }
        AppMethodBeat.o(34304);
    }

    private View getEmptyFooter() {
        AppMethodBeat.i(34305);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.zst = new View(getContext());
        this.zst.setLayoutParams(new LayoutParams(-1, 0));
        linearLayout.addView(this.zst);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(R.color.a69));
        AppMethodBeat.o(34305);
        return linearLayout;
    }

    private void qH(boolean z) {
        AppMethodBeat.i(34306);
        if (this.zst == null || !qL(true)) {
            AppMethodBeat.o(34306);
        } else if (z) {
            postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34267);
                    ConversationWithAppBrandListView.f(ConversationWithAppBrandListView.this);
                    AppMethodBeat.o(34267);
                }
            }, 0);
            AppMethodBeat.o(34306);
        } else {
            dIx();
            AppMethodBeat.o(34306);
        }
    }

    private int getTabViewHeight() {
        AppMethodBeat.i(34307);
        if (this.zsN == 0) {
            View findViewById = getRootView().findViewById(R.id.bq);
            if (findViewById != null) {
                ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", Integer.valueOf(findViewById.getHeight()));
                this.zsN = findViewById.getHeight();
            }
        }
        int i = this.zsN;
        AppMethodBeat.o(34307);
        return i;
    }

    private void dIx() {
        float Pt;
        boolean z = false;
        AppMethodBeat.i(34308);
        int firstHeaderVisible = getFirstHeaderVisible();
        LayoutParams layoutParams = (LayoutParams) this.zst.getLayoutParams();
        int i = layoutParams.height;
        try {
            int i2;
            if (getAdapter() == null) {
                i2 = 0;
            } else {
                i2 = getAdapter().getCount();
            }
            Pt = Pt(i2);
        } catch (Exception e) {
            Pt = 0.0f;
        }
        if (Pt < 0.0f) {
            z = true;
        }
        if (Pt < ((float) getTabViewHeight())) {
            Pt = (float) getTabViewHeight();
        }
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + z + " extraHeight:" + Pt);
        if (z) {
            layoutParams.height = getTabViewHeight();
        } else {
            layoutParams.height = (int) Pt;
            if (this.bZi) {
                post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34268);
                        ConversationWithAppBrandListView.this.setSelection(0);
                        AppMethodBeat.o(34268);
                    }
                });
            }
        }
        if (i != layoutParams.height) {
            this.zst.setLayoutParams(layoutParams);
            if (!this.bZi) {
                super.setSelection(firstHeaderVisible);
            }
        }
        AppMethodBeat.o(34308);
    }

    private void qI(boolean z) {
        AppMethodBeat.i(34309);
        if (z) {
            al.af(this.zta);
            AppMethodBeat.o(34309);
            return;
        }
        al.af(this.zta);
        al.n(this.zta, 1000);
        AppMethodBeat.o(34309);
    }

    private void setEmptyViewVisible(boolean z) {
        int i = 0;
        AppMethodBeat.i(34310);
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", Boolean.valueOf(z));
        if (this.Ek != null) {
            this.Ek.setVisibility(z ? 0 : 8);
        }
        if (this.zsA != null) {
            View findViewById = this.zsA.findViewById(R.id.yu);
            if (findViewById != null) {
                if (z) {
                    i = 4;
                }
                findViewById.setVisibility(i);
            }
        }
        AppMethodBeat.o(34310);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.i(34311);
        super.onMeasure(i, i2);
        dIz();
        AppMethodBeat.o(34311);
    }

    private boolean dIy() {
        AppMethodBeat.i(34312);
        if (!(this.zsA == null || this.zsH == null)) {
            int measuredHeight = this.zsz.getMeasuredHeight();
            if (!(measuredHeight == 0 || measuredHeight == this.ztb)) {
                this.ztb = measuredHeight;
                AppMethodBeat.o(34312);
                return true;
            }
        }
        AppMethodBeat.o(34312);
        return false;
    }

    private void dIz() {
        AppMethodBeat.i(34313);
        if (dIy()) {
            if (this.iWd != null) {
                this.iWd.setVisibility(0);
            }
            this.zsL = -(this.jcW - getResources().getDimension(R.dimen.l9));
            this.zsM = -(this.jcW - (((float) (this.ztb / 2)) - getResources().getDimension(R.dimen.ks)));
            if (this.zsK) {
                if (this.zsA != null) {
                    this.zsA.setTranslationY(0.0f);
                }
                if (this.Ek != null) {
                    this.Ek.setTranslationY(this.zsM);
                }
                ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", Integer.valueOf(this.ztb), Float.valueOf(this.zsM));
            } else {
                if (this.zsA != null) {
                    this.zsA.setTranslationY(this.zsL);
                }
                if (this.Ek != null) {
                    this.Ek.setTranslationY(0.0f);
                }
                ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", Integer.valueOf(this.ztb), Float.valueOf(this.zsL));
                AppMethodBeat.o(34313);
                return;
            }
        }
        AppMethodBeat.o(34313);
    }

    private void dIA() {
        AppMethodBeat.i(34314);
        if (this.zsO) {
            AppMethodBeat.o(34314);
        } else if (g.K(d.class) != null) {
            this.zsz = ((d) g.K(d.class)).df(this.iWA);
            this.zsO = true;
            this.zsz.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            this.zsA = this.zsz.findViewById(R.id.q1);
            this.zsA.setVisibility(8);
            this.iWd = this.zsz.getGyroView();
            this.zsH = this.zsz.getHeaderView();
            this.zsH.setCollectionRefreshListener(new e() {
                public final void qs(int i) {
                    AppMethodBeat.i(34269);
                    ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone MyAppBrand size: %d", Integer.valueOf(i));
                    if (i <= 0) {
                        ConversationWithAppBrandListView.this.zsI = true;
                    } else {
                        ConversationWithAppBrandListView.this.zsI = false;
                    }
                    ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, i);
                    AppMethodBeat.o(34269);
                }
            });
            this.zsH.setUsageRefreshListener(new e() {
                public final void qs(int i) {
                    AppMethodBeat.i(34270);
                    ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone RecentAppBrand size: %d", Integer.valueOf(i));
                    if (i <= 0) {
                        ConversationWithAppBrandListView.this.zsJ = true;
                    } else {
                        ConversationWithAppBrandListView.this.zsJ = false;
                    }
                    ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, i);
                    AppMethodBeat.o(34270);
                }
            });
            this.zsH.setIOnLaunchUIListener(new com.tencent.mm.plugin.appbrand.widget.header.a.a.b() {
                public final void aQg() {
                    AppMethodBeat.i(34271);
                    ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchCollectionUI");
                    ConversationWithAppBrandListView.this.J(300, 10);
                    AppMethodBeat.o(34271);
                }

                public final void aQh() {
                    AppMethodBeat.i(34272);
                    ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchUsageUI");
                    ConversationWithAppBrandListView.this.J(300, 9);
                    AppMethodBeat.o(34272);
                }
            });
            this.zsH.setOnEmptyViewListener(new com.tencent.mm.plugin.appbrand.widget.header.a.a.a() {
                public final void fa(boolean z) {
                    AppMethodBeat.i(34273);
                    ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onShowEmptyView show: %b, isOpenAppBrandRecentView: %b", Boolean.valueOf(z), Boolean.valueOf(ConversationWithAppBrandListView.this.zti));
                    ConversationWithAppBrandListView.this.zsK = z;
                    if (ConversationWithAppBrandListView.this.zsK) {
                        ConversationWithAppBrandListView.this.zsJ = true;
                        ConversationWithAppBrandListView.this.zsI = true;
                    }
                    if (ConversationWithAppBrandListView.this.zti) {
                        if (ConversationWithAppBrandListView.this.Ek != null && z) {
                            ConversationWithAppBrandListView.this.Ek.setTranslationY(0.0f);
                        }
                        if (ConversationWithAppBrandListView.this.zsz != null && z) {
                            ConversationWithAppBrandListView.this.zsz.setTranslationY(0.0f);
                        }
                        AppMethodBeat.o(34273);
                        return;
                    }
                    AppMethodBeat.o(34273);
                }
            });
            this.zsH.setReporter(this.jat);
            this.Ek = this.zsz.getEmptyView();
            this.zrX.remove(this.zsz);
            FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
            fixedViewInfo.view = this.zsz;
            fixedViewInfo.data = null;
            fixedViewInfo.isSelectable = true;
            this.zrX.addFirst(fixedViewInfo);
            Iterator it = this.zrX.iterator();
            while (it.hasNext()) {
                fixedViewInfo = (FixedViewInfo) it.next();
                super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
            }
            this.zsH.refresh();
            AppMethodBeat.o(34314);
        } else {
            ab.e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
            AppMethodBeat.o(34314);
        }
    }

    public void setSelection(int i) {
        AppMethodBeat.i(34315);
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", Integer.valueOf(i));
        if (i == 0 && qL(true)) {
            ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", Integer.valueOf(getFirstHeaderVisible()), Integer.valueOf(this.ztb));
            super.setSelection(r0);
            if (!(this.jat == null || this.zsH == null)) {
                this.jat.N(this.zsH.getRecentAppBrandCount(), this.zsH.getStarAppBrandCount(), 7);
                this.zsH.qu(7);
            }
            AppMethodBeat.o(34315);
            return;
        }
        super.setSelection(i);
        AppMethodBeat.o(34315);
    }

    public void smoothScrollToPosition(int i) {
        AppMethodBeat.i(34316);
        ab.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", Integer.valueOf(i));
        if (i == 0 && qL(true)) {
            super.smoothScrollToPosition(getFirstHeaderVisible());
            AppMethodBeat.o(34316);
            return;
        }
        super.smoothScrollToPosition(i);
        AppMethodBeat.o(34316);
    }

    public void smoothScrollToPositionFromTop(int i, final int i2) {
        AppMethodBeat.i(34317);
        ab.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && qL(true)) {
            i = getFirstHeaderVisible();
        }
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34274);
                ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, i, i2);
                AppMethodBeat.o(34274);
            }
        }, 100);
        AppMethodBeat.o(34317);
    }

    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        AppMethodBeat.i(34318);
        ab.d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i == 0 && qL(true)) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), i2, i3);
            AppMethodBeat.o(34318);
            return;
        }
        super.smoothScrollToPositionFromTop(i, i2, i3);
        AppMethodBeat.o(34318);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.nSS = onScrollListener;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(34320);
        try {
            if (motionEvent.getAction() == 0) {
                float x = motionEvent.getX();
                this.lbS = x;
                this.ztc = x;
                x = motionEvent.getY();
                this.lbT = x;
                this.ztd = x;
            }
            boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            return dispatchTouchEvent;
        } finally {
            this.lbS = motionEvent.getX();
            this.lbT = motionEvent.getY();
            AppMethodBeat.o(34320);
        }
    }

    private boolean P(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.i(34322);
        if (dIF()) {
            if (motionEvent.getAction() == 0) {
                this.ztf = motionEvent.getY();
                if (this.rD != null) {
                    this.rD.cancel();
                }
            } else if (motionEvent.getActionMasked() == 5) {
                this.ztf = motionEvent.getY();
            } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.zsz.getTop() == 0 && getChildTranslationY() != 0.0f) {
                qJ(true);
                this.zth = false;
                ab.d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180));
                if (dIF()) {
                    if (this.rD != null) {
                        this.rD.cancel();
                    }
                    PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{getChildTranslationY() + 0.0f, 0.0f});
                    PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("headerDeltaY", new float[]{getHeaderY() + 0.0f, 0.0f});
                    this.rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                    this.rD.setDuration(180);
                    this.rD.addUpdateListener(new AnimatorUpdateListener() {
                        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                            AppMethodBeat.i(34276);
                            float floatValue = ((Float) valueAnimator.getAnimatedValue("deltaY")).floatValue();
                            float floatValue2 = ((Float) valueAnimator.getAnimatedValue("headerDeltaY")).floatValue();
                            for (int i = 0; i < ConversationWithAppBrandListView.this.getChildCount(); i++) {
                                if (i == 0) {
                                    ConversationWithAppBrandListView.this.getChildAt(i).setTranslationY(floatValue2);
                                } else {
                                    ConversationWithAppBrandListView.this.getChildAt(i).setTranslationY(floatValue);
                                }
                                ConversationWithAppBrandListView.this.zte = floatValue;
                            }
                            ConversationWithAppBrandListView.this.invalidate();
                            AppMethodBeat.o(34276);
                        }
                    });
                    this.rD.addListener(new AnimatorListener() {
                        public final void onAnimationStart(Animator animator) {
                        }

                        public final void onAnimationEnd(Animator animator) {
                            AppMethodBeat.i(34278);
                            ConversationWithAppBrandListView.k(ConversationWithAppBrandListView.this);
                            AppMethodBeat.o(34278);
                        }

                        public final void onAnimationCancel(Animator animator) {
                            AppMethodBeat.i(34279);
                            ConversationWithAppBrandListView.k(ConversationWithAppBrandListView.this);
                            AppMethodBeat.o(34279);
                        }

                        public final void onAnimationRepeat(Animator animator) {
                        }
                    });
                    this.rD.setStartDelay(0);
                    this.rD.start();
                }
            }
            try {
                if (!(motionEvent.getAction() == 2 && Math.abs(motionEvent.getY() - this.lbT) > 2.0f && getFirstVisiblePosition() == 0 && this.zsz.getTop() == 0) && getChildTranslationY() == 0.0f) {
                    this.ztf = motionEvent.getY();
                    AppMethodBeat.o(34322);
                    return false;
                }
                qI(true);
                if (((float) (((getHeight() - getTabViewHeight()) - this.ztb) / 2)) <= this.zte) {
                    qJ(false);
                } else {
                    qJ(true);
                }
                float height = (float) ((getHeight() - getTabViewHeight()) - this.ztb);
                this.zte = ((motionEvent.getY() - this.ztf) * 0.4f) + this.zte;
                if (this.zte < 0.0f) {
                    this.zte = 0.0f;
                    dID();
                    invalidate();
                    return false;
                }
                if (height < this.zte) {
                    this.zte = height;
                }
                while (i < getChildCount()) {
                    if (i == 0) {
                        getChildAt(i).setTranslationY(this.zte * 0.5f);
                    } else {
                        getChildAt(i).setTranslationY(this.zte);
                    }
                    i++;
                }
                invalidate();
                this.ztf = motionEvent.getY();
                AppMethodBeat.o(34322);
                return true;
            } finally {
                this.ztf = motionEvent.getY();
                AppMethodBeat.o(34322);
            }
        } else {
            AppMethodBeat.o(34322);
            return false;
        }
    }

    private void dIB() {
        AppMethodBeat.i(34323);
        if (!this.zti) {
            ay.gL(getContext());
            if (!(this.jat == null || this.zsH == null)) {
                this.jat.dw(this.zsH.getRecentAppBrandCount(), this.zsH.getStarAppBrandCount());
            }
            if (this.zsH != null) {
                this.zsH.aQc();
            }
        }
        if (this.zsY && this.zsB != null) {
            this.zsB.getAdapter().aop.notifyChanged();
            this.zsY = true;
        }
        super.smoothScrollToPositionFromTop(0, 0, 250);
        qI(true);
        setOpenAppBrandRecentView(true);
        dIC();
        AppMethodBeat.o(34323);
    }

    private void dIC() {
        AppMethodBeat.i(34324);
        if (this.zsH != null) {
            this.zsH.aQd();
        }
        AppMethodBeat.o(34324);
    }

    private void Ps(int i) {
        AppMethodBeat.i(34325);
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", Boolean.valueOf(this.zti), Integer.valueOf(i));
        if (!(!this.zti || getChildAt(0) == null || this.jat == null || this.zsH == null)) {
            this.jat.N(this.zsH.getRecentAppBrandCount(), this.zsH.getStarAppBrandCount(), i);
            this.zsH.qu(i);
        }
        if (getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if ((childAt == null ? 0 : childAt.getBottom()) != 0) {
                smoothScrollToPositionFromTop(getFirstHeaderVisible(), 0, 150);
            }
        }
        dID();
        qI(true);
        setOpenAppBrandRecentView(false);
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(34275);
                if (ConversationWithAppBrandListView.this.zsH != null) {
                    ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
                    ConversationWithAppBrandListView.this.zsH.aQb();
                }
                AppMethodBeat.o(34275);
            }
        }, 500);
        AppMethodBeat.o(34325);
    }

    private void setOpenAppBrandRecentView(boolean z) {
        this.zti = z;
    }

    private float getChildTranslationY() {
        AppMethodBeat.i(34326);
        View childAt = getChildAt(1);
        if (childAt == null) {
            AppMethodBeat.o(34326);
            return 0.0f;
        }
        float translationY = childAt.getTranslationY();
        AppMethodBeat.o(34326);
        return translationY;
    }

    private float getHeaderY() {
        AppMethodBeat.i(34327);
        View childAt = getChildAt(0);
        if (childAt == null) {
            AppMethodBeat.o(34327);
            return 0.0f;
        }
        float translationY = childAt.getTranslationY();
        AppMethodBeat.o(34327);
        return translationY;
    }

    private void dID() {
        AppMethodBeat.i(34328);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setTranslationY(0.0f);
        }
        this.zte = 0.0f;
        invalidate();
        AppMethodBeat.o(34328);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.i(34329);
        super.onDraw(canvas);
        if (getFirstVisiblePosition() == 0 && this.zsz != null) {
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), ((float) this.zsz.getBottom()) + this.zte, this.zsD);
            if (getChildAt(1) != null) {
                int i;
                if (getHeight() == 0 || !this.ztk) {
                    i = 0;
                } else {
                    i = 1;
                }
                if (i != 0) {
                    canvas.drawText(this.zsF, (((float) getWidth()) - this.zsG) / 2.0f, (((float) this.zsz.getBottom()) + this.zte) - getResources().getDimension(R.dimen.ld), this.zsE);
                }
            }
        }
        AppMethodBeat.o(34329);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.i(34330);
        if (this.nSS != null) {
            this.nSS.onScrollStateChanged(absListView, i);
        }
        if (!(getFirstVisiblePosition() == 0 || i != 2 || this.ztj)) {
            this.iVX = true;
        }
        AppMethodBeat.o(34330);
    }

    private void qJ(boolean z) {
        AppMethodBeat.i(34331);
        if (z && this.ztl != null) {
            al.af(this.ztl);
            this.ztl = null;
            if (this.ztk) {
                qK(false);
                AppMethodBeat.o(34331);
                return;
            }
        } else if (!z && this.ztl == null) {
            AnonymousClass13 anonymousClass13 = new Runnable() {
                public final void run() {
                    AppMethodBeat.i(34280);
                    ab.i("MicroMsg.ConversationWithAppBrandListView", "[CheckShowTipTask]");
                    ConversationWithAppBrandListView.l(ConversationWithAppBrandListView.this);
                    AppMethodBeat.o(34280);
                }
            };
            this.ztl = anonymousClass13;
            al.n(anonymousClass13, 3000);
        }
        AppMethodBeat.o(34331);
    }

    private void qK(boolean z) {
        AppMethodBeat.i(34332);
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", Boolean.valueOf(z));
        PropertyValuesHolder ofInt;
        ValueAnimator ofPropertyValuesHolder;
        if (z) {
            this.ztk = true;
            ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0, 77});
            ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
            ofPropertyValuesHolder.setDuration(200);
            ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener() {
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    AppMethodBeat.i(34281);
                    ConversationWithAppBrandListView.this.zsE.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
                    ConversationWithAppBrandListView.this.invalidate();
                    AppMethodBeat.o(34281);
                }
            });
            ofPropertyValuesHolder.start();
            if (this.jat != null) {
                this.jat.aRY();
            }
            AppMethodBeat.o(34332);
            return;
        }
        ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{77, 0});
        ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
        ofPropertyValuesHolder.setDuration(200);
        ofPropertyValuesHolder.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(34282);
                ConversationWithAppBrandListView.this.zsE.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
                ConversationWithAppBrandListView.this.invalidate();
                AppMethodBeat.o(34282);
            }
        });
        ofPropertyValuesHolder.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(34283);
                ConversationWithAppBrandListView.this.ztk = false;
                AppMethodBeat.o(34283);
            }

            public final void onAnimationCancel(Animator animator) {
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        ofPropertyValuesHolder.start();
        AppMethodBeat.o(34332);
    }

    private void dIE() {
        AppMethodBeat.i(34333);
        ab.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
        if (this.zsD != null) {
            this.zsD.setColor(this.iWA.getResources().getColor(R.color.fa));
        }
        if (this.zsP != null) {
            this.zsP.a(0.0f, this.iWA.getResources().getColor(R.color.vy), this.iWA.getResources().getColor(R.color.o), this.iWA.getResources().getColor(R.color.o));
        }
        AppMethodBeat.o(34333);
    }

    private float getRatio() {
        float f = 0.0f;
        AppMethodBeat.i(34334);
        if (this.zsz == null || this.ztb == 0) {
            AppMethodBeat.o(34334);
        } else {
            float abs = 1.0f - (Math.abs(((float) this.zsz.getTop()) * 1.0f) / ((float) this.ztb));
            if (abs >= 0.0f) {
                f = abs;
            }
            ab.d("MicroMsg.ConversationWithAppBrandListView", "alvinluo header top: %d, header bottom: %d, ratio: %f, appBrandHeight: %d", Integer.valueOf(this.zsz.getTop()), Integer.valueOf(this.zsz.getBottom()), Float.valueOf(f), Integer.valueOf(this.ztb));
            AppMethodBeat.o(34334);
        }
        return f;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.i(34335);
        if (this.nSS != null) {
            this.nSS.onScroll(absListView, i, i2, i3);
        }
        if (qL(true)) {
            dIz();
            if (this.ztb == 0) {
                AppMethodBeat.o(34335);
                return;
            }
            ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onScroll firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            if (i == 0) {
                float ratio = getRatio();
                if (this.zsS == 0.0f || this.zsS == 1.0f || ((double) Math.abs(ratio - this.zsS)) >= 0.01d) {
                    this.zsS = ratio;
                    if (this.zsz != null) {
                        if (this.zsz.getTop() == 0 && !this.zsR) {
                            ratio = 0.0f;
                        } else if (this.zsz.getTop() != 0) {
                            this.zsR = true;
                        }
                    }
                    if (this.zsT != null) {
                        j jVar = this.zsT;
                        int argb = Color.argb(255, (int) (((double) jVar.zuy) + (((double) (((float) (jVar.zuB - jVar.zuy)) * ratio)) + 0.5d)), (int) (((double) jVar.zuz) + (((double) (((float) (jVar.zuC - jVar.zuz)) * ratio)) + 0.5d)), (int) (((double) jVar.zuA) + (((double) (((float) (jVar.zuD - jVar.zuA)) * ratio)) + 0.5d)));
                        if (this.zsD != null) {
                            this.zsD.setColor(argb);
                        }
                        if (this.zsA != null) {
                            this.zsA.setBackgroundColor(argb);
                        }
                        if (this.zsP != null) {
                            this.zsP.a(ratio, argb, 0, 0);
                        }
                    }
                }
                qI(false);
                View childAt = absListView.getChildAt(0);
                if (childAt != null && (childAt instanceof HeaderContainer)) {
                    View findViewById = childAt.findViewById(R.id.q1);
                    if (findViewById == null || findViewById.getVisibility() == 8) {
                        AppMethodBeat.o(34335);
                        return;
                    }
                    GyroView gyroView = ((HeaderContainer) childAt).getGyroView();
                    ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", Float.valueOf(this.zsL), Float.valueOf(this.zsM), Integer.valueOf(childAt.getBottom()), Float.valueOf(findViewById.getTranslationY()), Integer.valueOf(this.ztb));
                    if (childAt.getBottom() <= 3) {
                        if (this.zsK) {
                            if (this.Ek != null) {
                                this.Ek.setTranslationY(this.zsM);
                            }
                            findViewById.setTranslationY(0.0f);
                        } else {
                            findViewById.setTranslationY(this.zsL);
                        }
                        if (gyroView.getVisibility() == 0) {
                            gyroView.setVerticalScroll(0.0f);
                            gyroView.setVisibility(8);
                        }
                        this.zto = false;
                    }
                    if (childAt.getBottom() > 3 && ((float) childAt.getBottom()) <= this.jcW && (findViewById.getTranslationY() != 0.0f || (this.Ek != null && this.Ek.getTranslationY() != 0.0f))) {
                        if (gyroView.getVisibility() == 8) {
                            gyroView.setVisibility(0);
                        }
                        gyroView.setAlpha(1.0f);
                        gyroView.setTranslationY((float) (((-childAt.getBottom()) / 2) + (gyroView.getHeight() / 2)));
                        gyroView.setVerticalScroll((float) childAt.getBottom());
                    } else if (((float) childAt.getBottom()) > this.jcW && !(findViewById.getTranslationY() == 0.0f && (this.Ek == null || this.Ek.getTranslationY() == 0.0f))) {
                        float bottom = (float) ((1.0d * ((double) (((float) childAt.getBottom()) - this.jcW))) / ((double) (((float) this.ztb) - this.jcW)));
                        ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f, isEmpty: %b", Float.valueOf(findViewById.getTranslationY()), Float.valueOf(bottom), Float.valueOf(this.zsL * (1.0f - bottom)), Boolean.valueOf(this.zsK));
                        if (this.zsK) {
                            if (this.Ek != null) {
                                ab.v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", Float.valueOf(this.Ek.getTranslationY()), Float.valueOf((-this.zsM) * (1.0f - bottom)));
                                this.Ek.setTranslationY(this.zsM * (1.0f - bottom));
                            }
                            findViewById.setTranslationY(0.0f);
                        } else {
                            findViewById.setTranslationY(this.zsL * (1.0f - bottom));
                        }
                        gyroView.setTranslationY((((-this.jcW) / 2.0f) + ((float) (gyroView.getHeight() / 2))) + (((this.jcW / 2.0f) + ((float) gyroView.getHeight())) * bottom));
                        gyroView.setAlpha(1.0f - (2.0f * bottom));
                        if (!(this.zto || 1.0f == bottom)) {
                            this.iVt.vibrate(10);
                            this.zto = true;
                        }
                        qI(true);
                    }
                }
            } else {
                if (this.zsz != null) {
                    View findViewById2 = this.zsz.findViewById(R.id.q1);
                    if (this.zsK) {
                        if (this.Ek != null) {
                            this.Ek.setTranslationY(this.zsM);
                        }
                        if (findViewById2 != null) {
                            findViewById2.setTranslationY(0.0f);
                        }
                    } else if (findViewById2 != null) {
                        findViewById2.setTranslationY(this.zsL);
                    }
                }
                if (this.ztp == 0 && i != 0) {
                    Ps(4);
                    qJ(true);
                    qI(true);
                }
            }
            this.ztp = i;
            if (this.ztn && this.iVX && i == 0) {
                ab.e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
                smoothScrollBy(0, 0);
                post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34285);
                        View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
                        ab.i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: ".concat(String.valueOf(childAt == null ? 0 : childAt.getBottom())));
                        ConversationWithAppBrandListView.this.smoothScrollToPositionFromTop(ConversationWithAppBrandListView.this.getFirstHeaderVisible(), 0, 300);
                        ConversationWithAppBrandListView.q(ConversationWithAppBrandListView.this);
                        AppMethodBeat.o(34285);
                    }
                });
                this.ztn = false;
            }
            al.af(this.ztm);
            al.n(this.ztm, 50);
            AppMethodBeat.o(34335);
            return;
        }
        AppMethodBeat.o(34335);
    }

    private float Pt(int i) {
        AppMethodBeat.i(34336);
        ab.d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + i + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", Integer.valueOf(getHeight()), Integer.valueOf((i - getHeaderViewsCount()) - getFooterViewsCount()), Float.valueOf((float) (getMeasuredHeight() - (((int) getResources().getDimension(R.dimen.m3)) * ((i - getHeaderViewsCount()) - getFooterViewsCount())))));
        AppMethodBeat.o(34336);
        return (float) (getMeasuredHeight() - (((int) getResources().getDimension(R.dimen.m3)) * ((i - getHeaderViewsCount()) - getFooterViewsCount())));
    }

    public int getFirstHeaderVisible() {
        AppMethodBeat.i(34337);
        Iterator it = this.zrX.iterator();
        int i = 0;
        loop0:
        while (it.hasNext()) {
            FixedViewInfo fixedViewInfo = (FixedViewInfo) it.next();
            if (fixedViewInfo.view == this.zsz) {
                i++;
            } else {
                if (fixedViewInfo.view != null && (fixedViewInfo.view instanceof ViewGroup)) {
                    for (int i2 = 0; i2 < ((ViewGroup) fixedViewInfo.view).getChildCount(); i2++) {
                        View childAt = ((ViewGroup) fixedViewInfo.view).getChildAt(i2);
                        if ((childAt != null && childAt.getHeight() > 0) || childAt.getVisibility() == 0) {
                            ab.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i));
                            AppMethodBeat.o(34337);
                            break loop0;
                        }
                    }
                }
                i++;
            }
        }
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s, size: %d", Integer.valueOf(i), Integer.valueOf(this.zrX.size()));
        AppMethodBeat.o(34337);
        return i;
    }

    private boolean qL(boolean z) {
        AppMethodBeat.i(34338);
        if (!((this.hasInit && z) || g.K(d.class) == null)) {
            g.K(d.class);
            this.zsC = true;
            ab.i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", Boolean.valueOf(this.zsC));
            this.hasInit = true;
        }
        boolean z2 = this.zsC;
        AppMethodBeat.o(34338);
        return z2;
    }

    private boolean dIF() {
        AppMethodBeat.i(34339);
        if (this.zsA == null) {
            AppMethodBeat.o(34339);
            return false;
        } else if (qL(true) && this.zsA.getVisibility() == 0) {
            AppMethodBeat.o(34339);
            return true;
        } else {
            AppMethodBeat.o(34339);
            return false;
        }
    }

    public void setAdapter(final ListAdapter listAdapter) {
        AppMethodBeat.i(34295);
        ab.i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
        this.zsZ.dnU();
        this.iVt = (Vibrator) getContext().getSystemService("vibrator");
        this.mTouchSlop = t.a(ViewConfiguration.get(getContext()));
        this.zsD = new Paint(1);
        this.zsE = new Paint(1);
        this.zsD.setColor(getResources().getColor(R.color.fw));
        this.zsE.setColor(j.INVALID_ID);
        this.zsE.setTextSize(getResources().getDimension(R.dimen.nk));
        qL(false);
        if (g.K(d.class) != null) {
            this.jat = ((d) g.K(d.class)).aOD();
        }
        this.jcW = 100.0f * getResources().getDisplayMetrics().density;
        ab.i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", Float.valueOf(this.jcW), Float.valueOf(getResources().getDisplayMetrics().density));
        this.zsF = getResources().getString(R.string.b36);
        this.zsG = this.zsE.measureText(this.zsF);
        super.setOnScrollListener(this);
        listAdapter.registerDataSetObserver(new DataSetObserver() {
            int zts = -1;

            public final void onChanged() {
                AppMethodBeat.i(34277);
                if (this.zts != listAdapter.getCount()) {
                    String str = "MicroMsg.ConversationWithAppBrandListView";
                    String str2 = "[onChanged] isDelete:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.zts > listAdapter.getCount());
                    ab.i(str, str2, objArr);
                    if (this.zts > listAdapter.getCount()) {
                        ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, false);
                        ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this, true);
                    } else {
                        ConversationWithAppBrandListView.a(ConversationWithAppBrandListView.this);
                    }
                }
                this.zts = listAdapter.getCount();
                AppMethodBeat.o(34277);
            }
        });
        try {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.topMargin = ak.de(getContext());
            ab.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]1 ActionBar height:%s", Integer.valueOf(layoutParams.topMargin));
            if (layoutParams.topMargin <= 0) {
                postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(34286);
                        layoutParams.topMargin = ak.de(ConversationWithAppBrandListView.this.getContext());
                        ab.i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]2 ActionBar height:%s", Integer.valueOf(layoutParams.topMargin));
                        AppMethodBeat.o(34286);
                    }
                }, 200);
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.ConversationWithAppBrandListView", e, "alvinluo initLayoutParams exception", new Object[0]);
        }
        if (this.iWA != null) {
            dIA();
        }
        addFooterView(getEmptyFooter());
        super.setAdapter(listAdapter);
        AppMethodBeat.o(34295);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        AppMethodBeat.i(34319);
        if (qL(true) && getFirstVisiblePosition() == 0 && i2 < 0) {
            iArr[1] = (int) (((float) i2) / 3.0f);
            super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
            AppMethodBeat.o(34319);
            return true;
        }
        boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        AppMethodBeat.o(34319);
        return dispatchNestedPreScroll;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(34321);
        boolean onTouchEvent;
        if (qL(true)) {
            if (motionEvent.getAction() == 0) {
                if (getFirstVisiblePosition() != 0) {
                    this.ztn = true;
                }
            } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && getFirstVisiblePosition() == 0) {
                View childAt = getChildAt(0);
                if (childAt == null) {
                    AppMethodBeat.o(34321);
                    return true;
                }
                if (Math.abs(motionEvent.getX() - this.lbS) < 3.0f && Math.abs(motionEvent.getY() - this.lbT) < 3.0f) {
                    super.onTouchEvent(motionEvent);
                }
                if (getChildTranslationY() < 60.0f * getResources().getDisplayMetrics().density) {
                    float abs = Math.abs(motionEvent.getX() - this.ztc) - Math.abs(motionEvent.getY() - this.ztd);
                    if ((motionEvent.getY() - this.ztd < -5.0f && abs < 0.0f && getFirstVisiblePosition() == 0) || (childAt.getBottom() > 0 && ((float) childAt.getBottom()) < this.jcW)) {
                        Ps(4);
                    } else if (((float) childAt.getBottom()) >= this.jcW && motionEvent.getY() - this.ztd > 5.0f) {
                        dIB();
                    }
                }
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                qI(true);
                this.ztg = false;
                if (getChildTranslationY() > 0.0f) {
                    dIB();
                }
            }
            if (P(motionEvent)) {
                if (motionEvent.getAction() == 0) {
                    super.onTouchEvent(motionEvent);
                } else if (motionEvent.getAction() == 2 && !this.ztg && Math.abs(motionEvent.getY() - this.lbT) > 2.0f) {
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    this.ztg = true;
                } else if (!this.ztg) {
                    super.onTouchEvent(motionEvent);
                }
                AppMethodBeat.o(34321);
                return true;
            }
            if (this.ztg && motionEvent.getAction() == 2) {
                motionEvent.setAction(0);
                super.onTouchEvent(motionEvent);
                motionEvent.setAction(2);
                this.ztg = false;
            }
            onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.o(34321);
            return onTouchEvent;
        }
        onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.o(34321);
        return onTouchEvent;
    }

    static /* synthetic */ void a(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(34342);
        conversationWithAppBrandListView.qH(true);
        AppMethodBeat.o(34342);
    }

    static /* synthetic */ boolean b(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(34343);
        boolean qL = conversationWithAppBrandListView.qL(true);
        AppMethodBeat.o(34343);
        return qL;
    }

    static /* synthetic */ void s(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.i(34351);
        conversationWithAppBrandListView.dIB();
        AppMethodBeat.o(34351);
    }
}
