package com.tencent.p177mm.p612ui.conversation;

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
import android.support.p057v4.view.C44962t;
import android.support.p057v4.widget.C8415j;
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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p230g.p231a.C42009io;
import com.tencent.p177mm.p230g.p231a.C45336js;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10984a;
import com.tencent.p177mm.plugin.appbrand.widget.header.GyroView;
import com.tencent.p177mm.plugin.appbrand.widget.header.HeaderContainer;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a.C27395a;
import com.tencent.p177mm.plugin.appbrand.widget.header.p1391a.C45717a.C42729b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38619e;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C19916b;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C35988ay;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView */
public class ConversationWithAppBrandListView extends ListView implements OnScrollListener, C38619e {
    /* renamed from: Ek */
    private View f4437Ek;
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
    private C19916b jat;
    private float jcW;
    private float lbS;
    private float lbT;
    private int mTouchSlop;
    private OnScrollListener nSS;
    /* renamed from: rD */
    private ValueAnimator f4438rD;
    private LinkedList<FixedViewInfo> zrX;
    private View zsA;
    private AppBrandRecentView zsB;
    private boolean zsC;
    private Paint zsD;
    private Paint zsE;
    private String zsF;
    private float zsG;
    private C45717a zsH;
    private boolean zsI;
    private boolean zsJ;
    private boolean zsK;
    private float zsL;
    private float zsM;
    private int zsN;
    private boolean zsO;
    private C10984a zsP;
    private Runnable zsQ;
    private boolean zsR;
    private float zsS;
    private C15871j zsT;
    private C15871j zsU;
    private C15871j zsV;
    private C4884c<C45336js> zsW;
    private int zsX;
    boolean zsY;
    private final C4884c<C42009io> zsZ;
    private View zst;
    private HeaderContainer zsz;
    private C15854a zta;
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

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$5 */
    class C54675 implements C38619e {
        C54675() {
        }

        /* renamed from: qs */
        public final void mo6518qs(int i) {
            AppMethodBeat.m2504i(34270);
            C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone RecentAppBrand size: %d", Integer.valueOf(i));
            if (i <= 0) {
                ConversationWithAppBrandListView.this.zsJ = true;
            } else {
                ConversationWithAppBrandListView.this.zsJ = false;
            }
            ConversationWithAppBrandListView.m36897a(ConversationWithAppBrandListView.this, i);
            AppMethodBeat.m2505o(34270);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$21 */
    class C735221 extends C4884c<C42009io> {
        C735221() {
            AppMethodBeat.m2504i(34288);
            this.xxI = C42009io.class.getName().hashCode();
            AppMethodBeat.m2505o(34288);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34289);
            C42009io c42009io = (C42009io) c4883b;
            ConversationWithAppBrandListView.this.mo39713J((long) c42009io.cDH.delay, c42009io.cDH.type);
            AppMethodBeat.m2505o(34289);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$10 */
    class C1585010 implements AnimatorUpdateListener {
        C1585010() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(34276);
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
            AppMethodBeat.m2505o(34276);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$20 */
    class C1585120 implements Runnable {
        C1585120() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34287);
            ConversationWithAppBrandListView.this.setSelection(0);
            AppMethodBeat.m2505o(34287);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$9 */
    class C158539 implements Runnable {
        C158539() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34275);
            if (ConversationWithAppBrandListView.this.zsH != null) {
                C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "alvinluo scrollToFirstPage");
                ConversationWithAppBrandListView.this.zsH.aQb();
            }
            AppMethodBeat.m2505o(34275);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$a */
    class C15854a implements Runnable {
        C15854a() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34293);
            View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
            if (ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0 && childAt != null) {
                if (childAt.getTop() >= 0) {
                    AppMethodBeat.m2505o(34293);
                    return;
                }
                C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "[UpAppBrandHeaderTask] run...");
                if (((float) childAt.getBottom()) >= ConversationWithAppBrandListView.this.jcW) {
                    ConversationWithAppBrandListView.m36925s(ConversationWithAppBrandListView.this);
                    AppMethodBeat.m2505o(34293);
                    return;
                }
                ConversationWithAppBrandListView.m36926t(ConversationWithAppBrandListView.this);
            }
            AppMethodBeat.m2505o(34293);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$16 */
    class C2393416 implements AnimatorListener {
        C2393416() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(34283);
            ConversationWithAppBrandListView.this.ztk = false;
            AppMethodBeat.m2505o(34283);
        }

        public final void onAnimationCancel(Animator animator) {
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$17 */
    class C2393517 implements Runnable {
        C2393517() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34284);
            ConversationWithAppBrandListView.this.iVX = false;
            ConversationWithAppBrandListView.this.ztn = true;
            ConversationWithAppBrandListView.m36918q(ConversationWithAppBrandListView.this);
            AppMethodBeat.m2505o(34284);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$18 */
    class C2393618 implements Runnable {
        C2393618() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34285);
            View childAt = ConversationWithAppBrandListView.this.getChildAt(0);
            C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollBy] offset: ".concat(String.valueOf(childAt == null ? 0 : childAt.getBottom())));
            ConversationWithAppBrandListView.this.smoothScrollToPositionFromTop(ConversationWithAppBrandListView.this.getFirstHeaderVisible(), 0, 300);
            ConversationWithAppBrandListView.m36918q(ConversationWithAppBrandListView.this);
            AppMethodBeat.m2505o(34285);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$6 */
    class C239386 implements C42729b {
        C239386() {
        }

        public final void aQg() {
            AppMethodBeat.m2504i(34271);
            C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchCollectionUI");
            ConversationWithAppBrandListView.this.mo39713J(300, 10);
            AppMethodBeat.m2505o(34271);
        }

        public final void aQh() {
            AppMethodBeat.m2504i(34272);
            C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onLaunchUsageUI");
            ConversationWithAppBrandListView.this.mo39713J(300, 9);
            AppMethodBeat.m2505o(34272);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$15 */
    class C2393915 implements AnimatorUpdateListener {
        C2393915() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(34282);
            ConversationWithAppBrandListView.this.zsE.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
            ConversationWithAppBrandListView.this.invalidate();
            AppMethodBeat.m2505o(34282);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$7 */
    class C239407 implements C27395a {
        C239407() {
        }

        /* renamed from: fa */
        public final void mo39738fa(boolean z) {
            AppMethodBeat.m2504i(34273);
            C4990ab.m7419v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onShowEmptyView show: %b, isOpenAppBrandRecentView: %b", Boolean.valueOf(z), Boolean.valueOf(ConversationWithAppBrandListView.this.zti));
            ConversationWithAppBrandListView.this.zsK = z;
            if (ConversationWithAppBrandListView.this.zsK) {
                ConversationWithAppBrandListView.this.zsJ = true;
                ConversationWithAppBrandListView.this.zsI = true;
            }
            if (ConversationWithAppBrandListView.this.zti) {
                if (ConversationWithAppBrandListView.this.f4437Ek != null && z) {
                    ConversationWithAppBrandListView.this.f4437Ek.setTranslationY(0.0f);
                }
                if (ConversationWithAppBrandListView.this.zsz != null && z) {
                    ConversationWithAppBrandListView.this.zsz.setTranslationY(0.0f);
                }
                AppMethodBeat.m2505o(34273);
                return;
            }
            AppMethodBeat.m2505o(34273);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$1 */
    class C239411 extends C4884c<C45336js> {
        C239411() {
            AppMethodBeat.m2504i(34265);
            this.xxI = C45336js.class.getName().hashCode();
            AppMethodBeat.m2505o(34265);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(34266);
            C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "alvinluo MainUITabDoubleClick callback");
            ConversationWithAppBrandListView.this.mo39713J(0, 7);
            AppMethodBeat.m2505o(34266);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$3 */
    class C239423 implements Runnable {
        C239423() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34268);
            ConversationWithAppBrandListView.this.setSelection(0);
            AppMethodBeat.m2505o(34268);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$4 */
    class C239434 implements C38619e {
        C239434() {
        }

        /* renamed from: qs */
        public final void mo6518qs(int i) {
            AppMethodBeat.m2504i(34269);
            C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "alvinluo onDone MyAppBrand size: %d", Integer.valueOf(i));
            if (i <= 0) {
                ConversationWithAppBrandListView.this.zsI = true;
            } else {
                ConversationWithAppBrandListView.this.zsI = false;
            }
            ConversationWithAppBrandListView.m36897a(ConversationWithAppBrandListView.this, i);
            AppMethodBeat.m2505o(34269);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$12 */
    class C2394412 implements AnimatorListener {
        C2394412() {
        }

        public final void onAnimationStart(Animator animator) {
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(34278);
            ConversationWithAppBrandListView.m36912k(ConversationWithAppBrandListView.this);
            AppMethodBeat.m2505o(34278);
        }

        public final void onAnimationCancel(Animator animator) {
            AppMethodBeat.m2504i(34279);
            ConversationWithAppBrandListView.m36912k(ConversationWithAppBrandListView.this);
            AppMethodBeat.m2505o(34279);
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$14 */
    class C2394514 implements AnimatorUpdateListener {
        C2394514() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(34281);
            ConversationWithAppBrandListView.this.zsE.setAlpha(((Integer) valueAnimator.getAnimatedValue("alpha")).intValue());
            ConversationWithAppBrandListView.this.invalidate();
            AppMethodBeat.m2505o(34281);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$2 */
    class C239462 implements Runnable {
        C239462() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34267);
            ConversationWithAppBrandListView.m36907f(ConversationWithAppBrandListView.this);
            AppMethodBeat.m2505o(34267);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$13 */
    class C2394913 implements Runnable {
        C2394913() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34280);
            C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "[CheckShowTipTask]");
            ConversationWithAppBrandListView.m36913l(ConversationWithAppBrandListView.this);
            AppMethodBeat.m2505o(34280);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.ConversationWithAppBrandListView$24 */
    class C2395024 implements Runnable {
        C2395024() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34292);
            if (ConversationWithAppBrandListView.this.zsH != null) {
                C4990ab.m7410d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetToFirstPage");
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
            ConversationWithAppBrandListView.m36906e(ConversationWithAppBrandListView.this);
            AppMethodBeat.m2505o(34292);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m36898a(ConversationWithAppBrandListView conversationWithAppBrandListView, int i, int i2) {
        AppMethodBeat.m2504i(34347);
        super.smoothScrollToPositionFromTop(i, i2);
        AppMethodBeat.m2505o(34347);
    }

    /* renamed from: e */
    static /* synthetic */ void m36906e(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.m2504i(34344);
        conversationWithAppBrandListView.dIE();
        AppMethodBeat.m2505o(34344);
    }

    /* renamed from: f */
    static /* synthetic */ void m36907f(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.m2504i(34345);
        conversationWithAppBrandListView.dIx();
        AppMethodBeat.m2505o(34345);
    }

    /* renamed from: k */
    static /* synthetic */ void m36912k(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.m2504i(34348);
        conversationWithAppBrandListView.dID();
        AppMethodBeat.m2505o(34348);
    }

    /* renamed from: l */
    static /* synthetic */ void m36913l(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.m2504i(34349);
        conversationWithAppBrandListView.m36922qK(true);
        AppMethodBeat.m2505o(34349);
    }

    /* renamed from: q */
    static /* synthetic */ void m36918q(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.m2504i(34350);
        conversationWithAppBrandListView.m36920qI(true);
        AppMethodBeat.m2505o(34350);
    }

    /* renamed from: t */
    static /* synthetic */ void m36926t(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.m2504i(34352);
        conversationWithAppBrandListView.m36893Ps(0);
        AppMethodBeat.m2505o(34352);
    }

    public ConversationWithAppBrandListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(34294);
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
        this.zsW = new C239411();
        this.bZi = true;
        this.zsX = 0;
        this.zsY = false;
        this.anK = -1;
        this.zsZ = new C735221();
        this.zta = new C15854a();
        this.ztb = 0;
        this.zte = 0.0f;
        this.ztf = 0.0f;
        this.zth = false;
        this.ztj = false;
        this.ztk = false;
        this.ztm = new C2393517();
        this.iVX = false;
        this.ztn = false;
        this.zto = false;
        this.hasInit = false;
        this.zsT = new C15871j(getContext().getResources().getColor(C25738R.color.f11736f8), getContext().getResources().getColor(C25738R.color.f11735f7));
        this.zsW.dnU();
        AppMethodBeat.m2505o(34294);
    }

    public void setActivity(MMFragmentActivity mMFragmentActivity) {
        AppMethodBeat.m2504i(34296);
        this.iWA = mMFragmentActivity;
        dIA();
        AppMethodBeat.m2505o(34296);
    }

    public void setActionBarUpdateCallback(C10984a c10984a) {
        this.zsP = c10984a;
    }

    /* Access modifiers changed, original: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(34297);
        super.onLayout(z, i, i2, i3, i4);
        if (z && m36923qL(true)) {
            if (this.bZi) {
                m36919qH(true);
                post(new C1585120());
                this.zsX = i4;
                this.bZi = false;
                AppMethodBeat.m2505o(34297);
                return;
            } else if (!(this.cAY || this.zsX == i4)) {
                C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "[onLayout] mLastBottom:" + this.zsX + " b:" + i4);
                m36919qH(true);
                this.zsX = i4;
            }
        }
        AppMethodBeat.m2505o(34297);
    }

    /* Access modifiers changed, original: protected */
    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(34298);
        super.onConfigurationChanged(configuration);
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[onConfigurationChanged] orientation:%s", Integer.valueOf(configuration.orientation));
        this.zsY = true;
        m36919qH(true);
        if (this.zsH != null) {
            this.zsH.mo68131a(configuration);
        }
        this.zsR = false;
        AppMethodBeat.m2505o(34298);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(34299);
        boolean onInterceptTouchEvent;
        if (getFirstVisiblePosition() != 0) {
            onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
            AppMethodBeat.m2505o(34299);
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
                AppMethodBeat.m2505o(34299);
                return onInterceptTouchEvent;
            case 2:
                actionMasked = motionEvent.findPointerIndex(this.anK);
                if (actionMasked < 0) {
                    AppMethodBeat.m2505o(34299);
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
                    AppMethodBeat.m2505o(34299);
                    return true;
                }
                AppMethodBeat.m2505o(34299);
                return false;
            case 5:
                this.anK = motionEvent.getPointerId(actionIndex);
                this.anL = (int) (motionEvent.getX(actionIndex) + 0.5f);
                this.anM = (int) (motionEvent.getY(actionIndex) + 0.5f);
                onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.m2505o(34299);
                return onInterceptTouchEvent;
            default:
                onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
                AppMethodBeat.m2505o(34299);
                return onInterceptTouchEvent;
        }
    }

    public void addHeaderView(View view, Object obj, boolean z) {
        AppMethodBeat.m2504i(34300);
        FixedViewInfo fixedViewInfo = new FixedViewInfo(this);
        fixedViewInfo.view = view;
        fixedViewInfo.data = obj;
        fixedViewInfo.isSelectable = z;
        this.zrX.add(fixedViewInfo);
        if (getAdapter() != null) {
            super.addHeaderView(fixedViewInfo.view, fixedViewInfo.data, fixedViewInfo.isSelectable);
        }
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "alvinluo addHeaderView %d", Integer.valueOf(this.zrX.size()));
        AppMethodBeat.m2505o(34300);
    }

    public void setOnItemClickListener(final OnItemClickListener onItemClickListener) {
        AppMethodBeat.m2504i(34301);
        super.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(34290);
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(adapterView, view, i, j);
                }
                if (ConversationWithAppBrandListView.m36900b(ConversationWithAppBrandListView.this)) {
                    if (ConversationWithAppBrandListView.this.getFirstVisiblePosition() == 0) {
                        ConversationWithAppBrandListView.this.mo39713J(500, 8);
                    }
                    AppMethodBeat.m2505o(34290);
                    return;
                }
                AppMethodBeat.m2505o(34290);
            }
        });
        AppMethodBeat.m2505o(34301);
    }

    public void setOnItemLongClickListener(final OnItemLongClickListener onItemLongClickListener) {
        AppMethodBeat.m2504i(34302);
        super.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(34291);
                if (i == 0 && ConversationWithAppBrandListView.m36900b(ConversationWithAppBrandListView.this)) {
                    AppMethodBeat.m2505o(34291);
                    return false;
                } else if (onItemLongClickListener != null) {
                    boolean onItemLongClick = onItemLongClickListener.onItemLongClick(adapterView, view, i, j);
                    AppMethodBeat.m2505o(34291);
                    return onItemLongClick;
                } else {
                    AppMethodBeat.m2505o(34291);
                    return false;
                }
            }
        });
        AppMethodBeat.m2505o(34302);
    }

    /* renamed from: J */
    public final void mo39713J(long j, int i) {
        AppMethodBeat.m2504i(34303);
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[hideAppBrandRecentView] delay:%s, type: %d", Long.valueOf(j), Integer.valueOf(i));
        if (!m36923qL(true)) {
            if (this.zsA != null) {
                this.zsA.setVisibility(8);
            }
            AppMethodBeat.m2505o(34303);
        } else if (getFirstVisiblePosition() != 0) {
            AppMethodBeat.m2505o(34303);
        } else {
            if (!(this.jat == null || this.zsH == null)) {
                this.jat.mo35159N(this.zsH.getRecentAppBrandCount(), this.zsH.getStarAppBrandCount(), i);
                this.zsH.mo68138qu(i);
            }
            if (j > 0) {
                if (this.zsQ != null) {
                    removeCallbacks(this.zsQ);
                }
                this.zsQ = new C2395024();
                postDelayed(this.zsQ, j);
            } else {
                if (this.zsH != null) {
                    this.zsH.aQb();
                }
                if (this.zsB != null) {
                    this.zsB.smoothScrollToPosition(0);
                }
                setSelection(0);
                C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
                dIE();
            }
            dID();
            AppMethodBeat.m2505o(34303);
        }
    }

    /* renamed from: qs */
    public final void mo6518qs(int i) {
        AppMethodBeat.m2504i(34304);
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[next] size:%s isAppBrandHeaderEnable:%s", Integer.valueOf(i), Boolean.valueOf(this.zsC));
        if (m36923qL(true)) {
            if (i == 1 && this.zsA != null) {
                setEmptyViewVisible(true);
            } else if (i > 1 && this.zsA != null) {
                setEmptyViewVisible(false);
            }
            if (this.zsA != null && this.zsA.getVisibility() == 8) {
                this.zsA.setVisibility(0);
                setSelection(getFirstVisiblePosition());
            }
            AppMethodBeat.m2505o(34304);
            return;
        }
        C4990ab.m7420w("MicroMsg.ConversationWithAppBrandListView", "[next] is disable!");
        if (this.zsA != null) {
            this.zsA.setVisibility(8);
        }
        AppMethodBeat.m2505o(34304);
    }

    private View getEmptyFooter() {
        AppMethodBeat.m2504i(34305);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.zst = new View(getContext());
        this.zst.setLayoutParams(new LayoutParams(-1, 0));
        linearLayout.addView(this.zst);
        linearLayout.setBackgroundColor(getContext().getResources().getColor(C25738R.color.a69));
        AppMethodBeat.m2505o(34305);
        return linearLayout;
    }

    /* renamed from: qH */
    private void m36919qH(boolean z) {
        AppMethodBeat.m2504i(34306);
        if (this.zst == null || !m36923qL(true)) {
            AppMethodBeat.m2505o(34306);
        } else if (z) {
            postDelayed(new C239462(), 0);
            AppMethodBeat.m2505o(34306);
        } else {
            dIx();
            AppMethodBeat.m2505o(34306);
        }
    }

    private int getTabViewHeight() {
        AppMethodBeat.m2504i(34307);
        if (this.zsN == 0) {
            View findViewById = getRootView().findViewById(2131820634);
            if (findViewById != null) {
                C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initTabViewHeight tabView.getHeight: %d", Integer.valueOf(findViewById.getHeight()));
                this.zsN = findViewById.getHeight();
            }
        }
        int i = this.zsN;
        AppMethodBeat.m2505o(34307);
        return i;
    }

    private void dIx() {
        float Pt;
        boolean z = false;
        AppMethodBeat.m2504i(34308);
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
            Pt = m36894Pt(i2);
        } catch (Exception e) {
            Pt = 0.0f;
        }
        if (Pt < 0.0f) {
            z = true;
        }
        if (Pt < ((float) getTabViewHeight())) {
            Pt = (float) getTabViewHeight();
        }
        C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "[checkEmptyFooter] isRealFull:" + z + " extraHeight:" + Pt);
        if (z) {
            layoutParams.height = getTabViewHeight();
        } else {
            layoutParams.height = (int) Pt;
            if (this.bZi) {
                post(new C239423());
            }
        }
        if (i != layoutParams.height) {
            this.zst.setLayoutParams(layoutParams);
            if (!this.bZi) {
                super.setSelection(firstHeaderVisible);
            }
        }
        AppMethodBeat.m2505o(34308);
    }

    /* renamed from: qI */
    private void m36920qI(boolean z) {
        AppMethodBeat.m2504i(34309);
        if (z) {
            C5004al.m7439af(this.zta);
            AppMethodBeat.m2505o(34309);
            return;
        }
        C5004al.m7439af(this.zta);
        C5004al.m7442n(this.zta, 1000);
        AppMethodBeat.m2505o(34309);
    }

    private void setEmptyViewVisible(boolean z) {
        int i = 0;
        AppMethodBeat.m2504i(34310);
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[setEmptyViewVisible] isShow:%s", Boolean.valueOf(z));
        if (this.f4437Ek != null) {
            this.f4437Ek.setVisibility(z ? 0 : 8);
        }
        if (this.zsA != null) {
            View findViewById = this.zsA.findViewById(2131821501);
            if (findViewById != null) {
                if (z) {
                    i = 4;
                }
                findViewById.setVisibility(i);
            }
        }
        AppMethodBeat.m2505o(34310);
    }

    /* Access modifiers changed, original: protected */
    public void onMeasure(int i, int i2) {
        AppMethodBeat.m2504i(34311);
        super.onMeasure(i, i2);
        dIz();
        AppMethodBeat.m2505o(34311);
    }

    private boolean dIy() {
        AppMethodBeat.m2504i(34312);
        if (!(this.zsA == null || this.zsH == null)) {
            int measuredHeight = this.zsz.getMeasuredHeight();
            if (!(measuredHeight == 0 || measuredHeight == this.ztb)) {
                this.ztb = measuredHeight;
                AppMethodBeat.m2505o(34312);
                return true;
            }
        }
        AppMethodBeat.m2505o(34312);
        return false;
    }

    private void dIz() {
        AppMethodBeat.m2504i(34313);
        if (dIy()) {
            if (this.iWd != null) {
                this.iWd.setVisibility(0);
            }
            this.zsL = -(this.jcW - getResources().getDimension(C25738R.dimen.f9952l9));
            this.zsM = -(this.jcW - (((float) (this.ztb / 2)) - getResources().getDimension(C25738R.dimen.f9937ks)));
            if (this.zsK) {
                if (this.zsA != null) {
                    this.zsA.setTranslationY(0.0f);
                }
                if (this.f4437Ek != null) {
                    this.f4437Ek.setTranslationY(this.zsM);
                }
                C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight emptyView appBrandHeight: %d, setTranslationY: %s", Integer.valueOf(this.ztb), Float.valueOf(this.zsM));
            } else {
                if (this.zsA != null) {
                    this.zsA.setTranslationY(this.zsL);
                }
                if (this.f4437Ek != null) {
                    this.f4437Ek.setTranslationY(0.0f);
                }
                C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "alvinluo initAppBrandHeaderHeight AppBrandHeader appBrandHeight: %d, setTranslationY: %s", Integer.valueOf(this.ztb), Float.valueOf(this.zsL));
                AppMethodBeat.m2505o(34313);
                return;
            }
        }
        AppMethodBeat.m2505o(34313);
    }

    private void dIA() {
        AppMethodBeat.m2504i(34314);
        if (this.zsO) {
            AppMethodBeat.m2505o(34314);
        } else if (C1720g.m3528K(C11048d.class) != null) {
            this.zsz = ((C11048d) C1720g.m3528K(C11048d.class)).mo22749df(this.iWA);
            this.zsO = true;
            this.zsz.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
            this.zsA = this.zsz.findViewById(2131821163);
            this.zsA.setVisibility(8);
            this.iWd = this.zsz.getGyroView();
            this.zsH = this.zsz.getHeaderView();
            this.zsH.setCollectionRefreshListener(new C239434());
            this.zsH.setUsageRefreshListener(new C54675());
            this.zsH.setIOnLaunchUIListener(new C239386());
            this.zsH.setOnEmptyViewListener(new C239407());
            this.zsH.setReporter(this.jat);
            this.f4437Ek = this.zsz.getEmptyView();
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
            AppMethodBeat.m2505o(34314);
        } else {
            C4990ab.m7412e("MicroMsg.ConversationWithAppBrandListView", "alvinluo addAppBrandHalfView error");
            AppMethodBeat.m2505o(34314);
        }
    }

    public void setSelection(int i) {
        AppMethodBeat.m2504i(34315);
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[setSelection] position:%s", Integer.valueOf(i));
        if (i == 0 && m36923qL(true)) {
            C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "alvinluo setSelection pos: %d, appbrandHeight: %d", Integer.valueOf(getFirstHeaderVisible()), Integer.valueOf(this.ztb));
            super.setSelection(r0);
            if (!(this.jat == null || this.zsH == null)) {
                this.jat.mo35159N(this.zsH.getRecentAppBrandCount(), this.zsH.getStarAppBrandCount(), 7);
                this.zsH.mo68138qu(7);
            }
            AppMethodBeat.m2505o(34315);
            return;
        }
        super.setSelection(i);
        AppMethodBeat.m2505o(34315);
    }

    public void smoothScrollToPosition(int i) {
        AppMethodBeat.m2504i(34316);
        C4990ab.m7411d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPosition] position:%s", Integer.valueOf(i));
        if (i == 0 && m36923qL(true)) {
            super.smoothScrollToPosition(getFirstHeaderVisible());
            AppMethodBeat.m2505o(34316);
            return;
        }
        super.smoothScrollToPosition(i);
        AppMethodBeat.m2505o(34316);
    }

    public void smoothScrollToPositionFromTop(int i, final int i2) {
        AppMethodBeat.m2504i(34317);
        C4990ab.m7411d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s", Integer.valueOf(i), Integer.valueOf(i2));
        if (i == 0 && m36923qL(true)) {
            i = getFirstHeaderVisible();
        }
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(34274);
                ConversationWithAppBrandListView.m36898a(ConversationWithAppBrandListView.this, i, i2);
                AppMethodBeat.m2505o(34274);
            }
        }, 100);
        AppMethodBeat.m2505o(34317);
    }

    public void smoothScrollToPositionFromTop(int i, int i2, int i3) {
        AppMethodBeat.m2504i(34318);
        C4990ab.m7411d("MicroMsg.ConversationWithAppBrandListView", "[smoothScrollToPositionFromTop] position:%s offset:%s duration:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
        if (i == 0 && m36923qL(true)) {
            super.smoothScrollToPositionFromTop(getFirstHeaderVisible(), i2, i3);
            AppMethodBeat.m2505o(34318);
            return;
        }
        super.smoothScrollToPositionFromTop(i, i2, i3);
        AppMethodBeat.m2505o(34318);
    }

    public void setOnScrollListener(OnScrollListener onScrollListener) {
        this.nSS = onScrollListener;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(34320);
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
            AppMethodBeat.m2505o(34320);
        }
    }

    /* renamed from: P */
    private boolean m36892P(MotionEvent motionEvent) {
        int i = 0;
        AppMethodBeat.m2504i(34322);
        if (dIF()) {
            if (motionEvent.getAction() == 0) {
                this.ztf = motionEvent.getY();
                if (this.f4438rD != null) {
                    this.f4438rD.cancel();
                }
            } else if (motionEvent.getActionMasked() == 5) {
                this.ztf = motionEvent.getY();
            } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.zsz.getTop() == 0 && getChildTranslationY() != 0.0f) {
                m36921qJ(true);
                this.zth = false;
                C4990ab.m7411d("MicroMsg.ConversationWithAppBrandListView", "[animationChild] offset:%s delay:%s duration%s", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(180));
                if (dIF()) {
                    if (this.f4438rD != null) {
                        this.f4438rD.cancel();
                    }
                    PropertyValuesHolder ofFloat = PropertyValuesHolder.ofFloat("deltaY", new float[]{getChildTranslationY() + 0.0f, 0.0f});
                    PropertyValuesHolder ofFloat2 = PropertyValuesHolder.ofFloat("headerDeltaY", new float[]{getHeaderY() + 0.0f, 0.0f});
                    this.f4438rD = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofFloat, ofFloat2});
                    this.f4438rD.setDuration(180);
                    this.f4438rD.addUpdateListener(new C1585010());
                    this.f4438rD.addListener(new C2394412());
                    this.f4438rD.setStartDelay(0);
                    this.f4438rD.start();
                }
            }
            try {
                if (!(motionEvent.getAction() == 2 && Math.abs(motionEvent.getY() - this.lbT) > 2.0f && getFirstVisiblePosition() == 0 && this.zsz.getTop() == 0) && getChildTranslationY() == 0.0f) {
                    this.ztf = motionEvent.getY();
                    AppMethodBeat.m2505o(34322);
                    return false;
                }
                m36920qI(true);
                if (((float) (((getHeight() - getTabViewHeight()) - this.ztb) / 2)) <= this.zte) {
                    m36921qJ(false);
                } else {
                    m36921qJ(true);
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
                AppMethodBeat.m2505o(34322);
                return true;
            } finally {
                this.ztf = motionEvent.getY();
                AppMethodBeat.m2505o(34322);
            }
        } else {
            AppMethodBeat.m2505o(34322);
            return false;
        }
    }

    private void dIB() {
        AppMethodBeat.m2504i(34323);
        if (!this.zti) {
            C35988ay.m59202gL(getContext());
            if (!(this.jat == null || this.zsH == null)) {
                this.jat.mo35163dw(this.zsH.getRecentAppBrandCount(), this.zsH.getStarAppBrandCount());
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
        m36920qI(true);
        setOpenAppBrandRecentView(true);
        dIC();
        AppMethodBeat.m2505o(34323);
    }

    private void dIC() {
        AppMethodBeat.m2504i(34324);
        if (this.zsH != null) {
            this.zsH.aQd();
        }
        AppMethodBeat.m2505o(34324);
    }

    /* renamed from: Ps */
    private void m36893Ps(int i) {
        AppMethodBeat.m2504i(34325);
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[closeAppBrandRecentView] isOpenAppBrandRecentView:%s type:%s", Boolean.valueOf(this.zti), Integer.valueOf(i));
        if (!(!this.zti || getChildAt(0) == null || this.jat == null || this.zsH == null)) {
            this.jat.mo35159N(this.zsH.getRecentAppBrandCount(), this.zsH.getStarAppBrandCount(), i);
            this.zsH.mo68138qu(i);
        }
        if (getFirstVisiblePosition() == 0) {
            View childAt = getChildAt(0);
            if ((childAt == null ? 0 : childAt.getBottom()) != 0) {
                smoothScrollToPositionFromTop(getFirstHeaderVisible(), 0, 150);
            }
        }
        dID();
        m36920qI(true);
        setOpenAppBrandRecentView(false);
        C5004al.m7442n(new C158539(), 500);
        AppMethodBeat.m2505o(34325);
    }

    private void setOpenAppBrandRecentView(boolean z) {
        this.zti = z;
    }

    private float getChildTranslationY() {
        AppMethodBeat.m2504i(34326);
        View childAt = getChildAt(1);
        if (childAt == null) {
            AppMethodBeat.m2505o(34326);
            return 0.0f;
        }
        float translationY = childAt.getTranslationY();
        AppMethodBeat.m2505o(34326);
        return translationY;
    }

    private float getHeaderY() {
        AppMethodBeat.m2504i(34327);
        View childAt = getChildAt(0);
        if (childAt == null) {
            AppMethodBeat.m2505o(34327);
            return 0.0f;
        }
        float translationY = childAt.getTranslationY();
        AppMethodBeat.m2505o(34327);
        return translationY;
    }

    private void dID() {
        AppMethodBeat.m2504i(34328);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setTranslationY(0.0f);
        }
        this.zte = 0.0f;
        invalidate();
        AppMethodBeat.m2505o(34328);
    }

    /* Access modifiers changed, original: protected */
    public void onDraw(Canvas canvas) {
        AppMethodBeat.m2504i(34329);
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
                    canvas.drawText(this.zsF, (((float) getWidth()) - this.zsG) / 2.0f, (((float) this.zsz.getBottom()) + this.zte) - getResources().getDimension(C25738R.dimen.f9957ld), this.zsE);
                }
            }
        }
        AppMethodBeat.m2505o(34329);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        AppMethodBeat.m2504i(34330);
        if (this.nSS != null) {
            this.nSS.onScrollStateChanged(absListView, i);
        }
        if (!(getFirstVisiblePosition() == 0 || i != 2 || this.ztj)) {
            this.iVX = true;
        }
        AppMethodBeat.m2505o(34330);
    }

    /* renamed from: qJ */
    private void m36921qJ(boolean z) {
        AppMethodBeat.m2504i(34331);
        if (z && this.ztl != null) {
            C5004al.m7439af(this.ztl);
            this.ztl = null;
            if (this.ztk) {
                m36922qK(false);
                AppMethodBeat.m2505o(34331);
                return;
            }
        } else if (!z && this.ztl == null) {
            C2394913 c2394913 = new C2394913();
            this.ztl = c2394913;
            C5004al.m7442n(c2394913, 3000);
        }
        AppMethodBeat.m2505o(34331);
    }

    /* renamed from: qK */
    private void m36922qK(boolean z) {
        AppMethodBeat.m2504i(34332);
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[showTipWithAnim] isShow:%s", Boolean.valueOf(z));
        PropertyValuesHolder ofInt;
        ValueAnimator ofPropertyValuesHolder;
        if (z) {
            this.ztk = true;
            ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{0, 77});
            ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
            ofPropertyValuesHolder.setDuration(200);
            ofPropertyValuesHolder.addUpdateListener(new C2394514());
            ofPropertyValuesHolder.start();
            if (this.jat != null) {
                this.jat.aRY();
            }
            AppMethodBeat.m2505o(34332);
            return;
        }
        ofInt = PropertyValuesHolder.ofInt("alpha", new int[]{77, 0});
        ofPropertyValuesHolder = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[]{ofInt});
        ofPropertyValuesHolder.setDuration(200);
        ofPropertyValuesHolder.addUpdateListener(new C2393915());
        ofPropertyValuesHolder.addListener(new C2393416());
        ofPropertyValuesHolder.start();
        AppMethodBeat.m2505o(34332);
    }

    private void dIE() {
        AppMethodBeat.m2504i(34333);
        C4990ab.m7410d("MicroMsg.ConversationWithAppBrandListView", "alvinluo resetAppBrandHeaderBg");
        if (this.zsD != null) {
            this.zsD.setColor(this.iWA.getResources().getColor(C25738R.color.f11737fa));
        }
        if (this.zsP != null) {
            this.zsP.mo22614a(0.0f, this.iWA.getResources().getColor(C25738R.color.f12206vy), this.iWA.getResources().getColor(C25738R.color.f11629o), this.iWA.getResources().getColor(C25738R.color.f11629o));
        }
        AppMethodBeat.m2505o(34333);
    }

    private float getRatio() {
        float f = 0.0f;
        AppMethodBeat.m2504i(34334);
        if (this.zsz == null || this.ztb == 0) {
            AppMethodBeat.m2505o(34334);
        } else {
            float abs = 1.0f - (Math.abs(((float) this.zsz.getTop()) * 1.0f) / ((float) this.ztb));
            if (abs >= 0.0f) {
                f = abs;
            }
            C4990ab.m7411d("MicroMsg.ConversationWithAppBrandListView", "alvinluo header top: %d, header bottom: %d, ratio: %f, appBrandHeight: %d", Integer.valueOf(this.zsz.getTop()), Integer.valueOf(this.zsz.getBottom()), Float.valueOf(f), Integer.valueOf(this.ztb));
            AppMethodBeat.m2505o(34334);
        }
        return f;
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        AppMethodBeat.m2504i(34335);
        if (this.nSS != null) {
            this.nSS.onScroll(absListView, i, i2, i3);
        }
        if (m36923qL(true)) {
            dIz();
            if (this.ztb == 0) {
                AppMethodBeat.m2505o(34335);
                return;
            }
            C4990ab.m7419v("MicroMsg.ConversationWithAppBrandListView", "alvinluo onScroll firstVisibleItem: %d, visibleItemCount: %d, totalItemCount: %d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
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
                        C15871j c15871j = this.zsT;
                        int argb = Color.argb(255, (int) (((double) c15871j.zuy) + (((double) (((float) (c15871j.zuB - c15871j.zuy)) * ratio)) + 0.5d)), (int) (((double) c15871j.zuz) + (((double) (((float) (c15871j.zuC - c15871j.zuz)) * ratio)) + 0.5d)), (int) (((double) c15871j.zuA) + (((double) (((float) (c15871j.zuD - c15871j.zuA)) * ratio)) + 0.5d)));
                        if (this.zsD != null) {
                            this.zsD.setColor(argb);
                        }
                        if (this.zsA != null) {
                            this.zsA.setBackgroundColor(argb);
                        }
                        if (this.zsP != null) {
                            this.zsP.mo22614a(ratio, argb, 0, 0);
                        }
                    }
                }
                m36920qI(false);
                View childAt = absListView.getChildAt(0);
                if (childAt != null && (childAt instanceof HeaderContainer)) {
                    View findViewById = childAt.findViewById(2131821163);
                    if (findViewById == null || findViewById.getVisibility() == 8) {
                        AppMethodBeat.m2505o(34335);
                        return;
                    }
                    GyroView gyroView = ((HeaderContainer) childAt).getGyroView();
                    C4990ab.m7419v("MicroMsg.ConversationWithAppBrandListView", "alvinluo appBrandHeaderTransH: %s, emptyTransH: %s, headerParent.bottom: %s, translationY: %f, mAppBrandHeight: %d", Float.valueOf(this.zsL), Float.valueOf(this.zsM), Integer.valueOf(childAt.getBottom()), Float.valueOf(findViewById.getTranslationY()), Integer.valueOf(this.ztb));
                    if (childAt.getBottom() <= 3) {
                        if (this.zsK) {
                            if (this.f4437Ek != null) {
                                this.f4437Ek.setTranslationY(this.zsM);
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
                    if (childAt.getBottom() > 3 && ((float) childAt.getBottom()) <= this.jcW && (findViewById.getTranslationY() != 0.0f || (this.f4437Ek != null && this.f4437Ek.getTranslationY() != 0.0f))) {
                        if (gyroView.getVisibility() == 8) {
                            gyroView.setVisibility(0);
                        }
                        gyroView.setAlpha(1.0f);
                        gyroView.setTranslationY((float) (((-childAt.getBottom()) / 2) + (gyroView.getHeight() / 2)));
                        gyroView.setVerticalScroll((float) childAt.getBottom());
                    } else if (((float) childAt.getBottom()) > this.jcW && !(findViewById.getTranslationY() == 0.0f && (this.f4437Ek == null || this.f4437Ek.getTranslationY() == 0.0f))) {
                        float bottom = (float) ((1.0d * ((double) (((float) childAt.getBottom()) - this.jcW))) / ((double) (((float) this.ztb) - this.jcW)));
                        C4990ab.m7419v("MicroMsg.ConversationWithAppBrandListView", "alvinluo checkUpAppBrandHeader appbrandHeader translationY: %f, percent: %f, setTranslationY: %f, isEmpty: %b", Float.valueOf(findViewById.getTranslationY()), Float.valueOf(bottom), Float.valueOf(this.zsL * (1.0f - bottom)), Boolean.valueOf(this.zsK));
                        if (this.zsK) {
                            if (this.f4437Ek != null) {
                                C4990ab.m7419v("MicroMsg.ConversationWithAppBrandListView", "alvinluo emptyView translationY: %f, set: %f", Float.valueOf(this.f4437Ek.getTranslationY()), Float.valueOf((-this.zsM) * (1.0f - bottom)));
                                this.f4437Ek.setTranslationY(this.zsM * (1.0f - bottom));
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
                        m36920qI(true);
                    }
                }
            } else {
                if (this.zsz != null) {
                    View findViewById2 = this.zsz.findViewById(2131821163);
                    if (this.zsK) {
                        if (this.f4437Ek != null) {
                            this.f4437Ek.setTranslationY(this.zsM);
                        }
                        if (findViewById2 != null) {
                            findViewById2.setTranslationY(0.0f);
                        }
                    } else if (findViewById2 != null) {
                        findViewById2.setTranslationY(this.zsL);
                    }
                }
                if (this.ztp == 0 && i != 0) {
                    m36893Ps(4);
                    m36921qJ(true);
                    m36920qI(true);
                }
            }
            this.ztp = i;
            if (this.ztn && this.iVX && i == 0) {
                C4990ab.m7412e("MicroMsg.ConversationWithAppBrandListView", "[Stop fling!]");
                smoothScrollBy(0, 0);
                post(new C2393618());
                this.ztn = false;
            }
            C5004al.m7439af(this.ztm);
            C5004al.m7442n(this.ztm, 50);
            AppMethodBeat.m2505o(34335);
            return;
        }
        AppMethodBeat.m2505o(34335);
    }

    /* renamed from: Pt */
    private float m36894Pt(int i) {
        AppMethodBeat.m2504i(34336);
        C4990ab.m7410d("MicroMsg.ConversationWithAppBrandListView", "[isFull] totalItemCount:" + i + " getFirstVisiblePosition:" + getFirstVisiblePosition() + " getLastVisiblePosition:" + getLastVisiblePosition() + " getHeaderViewsCount:" + getHeaderViewsCount() + " getFooterViewsCount:" + getFooterViewsCount());
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[isFull] height:%s rawCount:%s extraHeight:%s", Integer.valueOf(getHeight()), Integer.valueOf((i - getHeaderViewsCount()) - getFooterViewsCount()), Float.valueOf((float) (getMeasuredHeight() - (((int) getResources().getDimension(C25738R.dimen.f9978m3)) * ((i - getHeaderViewsCount()) - getFooterViewsCount())))));
        AppMethodBeat.m2505o(34336);
        return (float) (getMeasuredHeight() - (((int) getResources().getDimension(C25738R.dimen.f9978m3)) * ((i - getHeaderViewsCount()) - getFooterViewsCount())));
    }

    public int getFirstHeaderVisible() {
        AppMethodBeat.m2504i(34337);
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
                            C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s", Integer.valueOf(i));
                            AppMethodBeat.m2505o(34337);
                            break loop0;
                        }
                    }
                }
                i++;
            }
        }
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[getFirstHeaderVisible] index:%s, size: %d", Integer.valueOf(i), Integer.valueOf(this.zrX.size()));
        AppMethodBeat.m2505o(34337);
        return i;
    }

    /* renamed from: qL */
    private boolean m36923qL(boolean z) {
        AppMethodBeat.m2504i(34338);
        if (!((this.hasInit && z) || C1720g.m3528K(C11048d.class) == null)) {
            C1720g.m3528K(C11048d.class);
            this.zsC = true;
            C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[isAppBrandHeaderEnable] :%s", Boolean.valueOf(this.zsC));
            this.hasInit = true;
        }
        boolean z2 = this.zsC;
        AppMethodBeat.m2505o(34338);
        return z2;
    }

    private boolean dIF() {
        AppMethodBeat.m2504i(34339);
        if (this.zsA == null) {
            AppMethodBeat.m2505o(34339);
            return false;
        } else if (m36923qL(true) && this.zsA.getVisibility() == 0) {
            AppMethodBeat.m2505o(34339);
            return true;
        } else {
            AppMethodBeat.m2505o(34339);
            return false;
        }
    }

    public void setAdapter(final ListAdapter listAdapter) {
        AppMethodBeat.m2504i(34295);
        C4990ab.m7416i("MicroMsg.ConversationWithAppBrandListView", "[init] ");
        this.zsZ.dnU();
        this.iVt = (Vibrator) getContext().getSystemService("vibrator");
        this.mTouchSlop = C44962t.m82264a(ViewConfiguration.get(getContext()));
        this.zsD = new Paint(1);
        this.zsE = new Paint(1);
        this.zsD.setColor(getResources().getColor(C25738R.color.f11752fw));
        this.zsE.setColor(C8415j.INVALID_ID);
        this.zsE.setTextSize(getResources().getDimension(C25738R.dimen.f10018nk));
        m36923qL(false);
        if (C1720g.m3528K(C11048d.class) != null) {
            this.jat = ((C11048d) C1720g.m3528K(C11048d.class)).aOD();
        }
        this.jcW = 100.0f * getResources().getDisplayMetrics().density;
        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "alvinluo init mAnimationPadding: %f, density: %f", Float.valueOf(this.jcW), Float.valueOf(getResources().getDisplayMetrics().density));
        this.zsF = getResources().getString(C25738R.string.b36);
        this.zsG = this.zsE.measureText(this.zsF);
        super.setOnScrollListener(this);
        listAdapter.registerDataSetObserver(new DataSetObserver() {
            int zts = -1;

            public final void onChanged() {
                AppMethodBeat.m2504i(34277);
                if (this.zts != listAdapter.getCount()) {
                    String str = "MicroMsg.ConversationWithAppBrandListView";
                    String str2 = "[onChanged] isDelete:%s";
                    Object[] objArr = new Object[1];
                    objArr[0] = Boolean.valueOf(this.zts > listAdapter.getCount());
                    C4990ab.m7417i(str, str2, objArr);
                    if (this.zts > listAdapter.getCount()) {
                        ConversationWithAppBrandListView.m36899a(ConversationWithAppBrandListView.this, false);
                        ConversationWithAppBrandListView.m36899a(ConversationWithAppBrandListView.this, true);
                    } else {
                        ConversationWithAppBrandListView.m36896a(ConversationWithAppBrandListView.this);
                    }
                }
                this.zts = listAdapter.getCount();
                AppMethodBeat.m2505o(34277);
            }
        });
        try {
            final RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.topMargin = C5230ak.m7987de(getContext());
            C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]1 ActionBar height:%s", Integer.valueOf(layoutParams.topMargin));
            if (layoutParams.topMargin <= 0) {
                postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(34286);
                        layoutParams.topMargin = C5230ak.m7987de(ConversationWithAppBrandListView.this.getContext());
                        C4990ab.m7417i("MicroMsg.ConversationWithAppBrandListView", "[initLayoutParams]2 ActionBar height:%s", Integer.valueOf(layoutParams.topMargin));
                        AppMethodBeat.m2505o(34286);
                    }
                }, 200);
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.ConversationWithAppBrandListView", e, "alvinluo initLayoutParams exception", new Object[0]);
        }
        if (this.iWA != null) {
            dIA();
        }
        addFooterView(getEmptyFooter());
        super.setAdapter(listAdapter);
        AppMethodBeat.m2505o(34295);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        AppMethodBeat.m2504i(34319);
        if (m36923qL(true) && getFirstVisiblePosition() == 0 && i2 < 0) {
            iArr[1] = (int) (((float) i2) / 3.0f);
            super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
            AppMethodBeat.m2505o(34319);
            return true;
        }
        boolean dispatchNestedPreScroll = super.dispatchNestedPreScroll(i, i2, iArr, iArr2);
        AppMethodBeat.m2505o(34319);
        return dispatchNestedPreScroll;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(34321);
        boolean onTouchEvent;
        if (m36923qL(true)) {
            if (motionEvent.getAction() == 0) {
                if (getFirstVisiblePosition() != 0) {
                    this.ztn = true;
                }
            } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && getFirstVisiblePosition() == 0) {
                View childAt = getChildAt(0);
                if (childAt == null) {
                    AppMethodBeat.m2505o(34321);
                    return true;
                }
                if (Math.abs(motionEvent.getX() - this.lbS) < 3.0f && Math.abs(motionEvent.getY() - this.lbT) < 3.0f) {
                    super.onTouchEvent(motionEvent);
                }
                if (getChildTranslationY() < 60.0f * getResources().getDisplayMetrics().density) {
                    float abs = Math.abs(motionEvent.getX() - this.ztc) - Math.abs(motionEvent.getY() - this.ztd);
                    if ((motionEvent.getY() - this.ztd < -5.0f && abs < 0.0f && getFirstVisiblePosition() == 0) || (childAt.getBottom() > 0 && ((float) childAt.getBottom()) < this.jcW)) {
                        m36893Ps(4);
                    } else if (((float) childAt.getBottom()) >= this.jcW && motionEvent.getY() - this.ztd > 5.0f) {
                        dIB();
                    }
                }
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                m36920qI(true);
                this.ztg = false;
                if (getChildTranslationY() > 0.0f) {
                    dIB();
                }
            }
            if (m36892P(motionEvent)) {
                if (motionEvent.getAction() == 0) {
                    super.onTouchEvent(motionEvent);
                } else if (motionEvent.getAction() == 2 && !this.ztg && Math.abs(motionEvent.getY() - this.lbT) > 2.0f) {
                    motionEvent.setAction(3);
                    super.onTouchEvent(motionEvent);
                    this.ztg = true;
                } else if (!this.ztg) {
                    super.onTouchEvent(motionEvent);
                }
                AppMethodBeat.m2505o(34321);
                return true;
            }
            if (this.ztg && motionEvent.getAction() == 2) {
                motionEvent.setAction(0);
                super.onTouchEvent(motionEvent);
                motionEvent.setAction(2);
                this.ztg = false;
            }
            onTouchEvent = super.onTouchEvent(motionEvent);
            AppMethodBeat.m2505o(34321);
            return onTouchEvent;
        }
        onTouchEvent = super.onTouchEvent(motionEvent);
        AppMethodBeat.m2505o(34321);
        return onTouchEvent;
    }

    /* renamed from: a */
    static /* synthetic */ void m36896a(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.m2504i(34342);
        conversationWithAppBrandListView.m36919qH(true);
        AppMethodBeat.m2505o(34342);
    }

    /* renamed from: b */
    static /* synthetic */ boolean m36900b(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.m2504i(34343);
        boolean qL = conversationWithAppBrandListView.m36923qL(true);
        AppMethodBeat.m2505o(34343);
        return qL;
    }

    /* renamed from: s */
    static /* synthetic */ void m36925s(ConversationWithAppBrandListView conversationWithAppBrandListView) {
        AppMethodBeat.m2504i(34351);
        conversationWithAppBrandListView.dIB();
        AppMethodBeat.m2505o(34351);
    }
}
