package com.tencent.p177mm.p612ui.conversation;

import android.content.res.Configuration;
import android.os.Looper;
import android.os.PowerManager;
import android.support.p057v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.blink.C1314b;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kiss.p243a.C1742b;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p190at.C25820b;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p203bg.C32337g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p231a.C18394st;
import com.tencent.p177mm.p230g.p231a.C6546sd;
import com.tencent.p177mm.p612ui.AbstractTabChildActivity.AbStractTabFragment;
import com.tencent.p177mm.p612ui.C40862f.C30702a;
import com.tencent.p177mm.p612ui.C5230ak;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C15521c;
import com.tencent.p177mm.p612ui.base.MMSlideDelView.C23600g;
import com.tencent.p177mm.p612ui.conversation.C23987h.C23985d;
import com.tencent.p177mm.p612ui.conversation.C23987h.C23988b;
import com.tencent.p177mm.p612ui.conversation.C23987h.C239922;
import com.tencent.p177mm.p612ui.conversation.C40859l.C306972;
import com.tencent.p177mm.p612ui.conversation.C46682k.C36294a;
import com.tencent.p177mm.p612ui.conversation.C46682k.C408577;
import com.tencent.p177mm.p612ui.conversation.C46684n.C239984;
import com.tencent.p177mm.p612ui.conversation.C46684n.C239995;
import com.tencent.p177mm.p612ui.conversation.C46684n.C240006;
import com.tencent.p177mm.p612ui.conversation.C46684n.C306997;
import com.tencent.p177mm.p612ui.conversation.C46684n.C443671;
import com.tencent.p177mm.p612ui.conversation.C46684n.C443683;
import com.tencent.p177mm.p612ui.conversation.C46684n.C443698;
import com.tencent.p177mm.p612ui.conversation.C46684n.C443709;
import com.tencent.p177mm.p612ui.conversation.C46684n.C466832;
import com.tencent.p177mm.p612ui.conversation.ConversationListView.C239316;
import com.tencent.p177mm.platformtools.C42252ah;
import com.tencent.p177mm.plugin.appbrand.widget.header.C10984a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.plugin.forcenotify.p1262a.C20772b;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.report.service.C34830g;
import com.tencent.p177mm.pluginsdk.C30036f;
import com.tencent.p177mm.pluginsdk.p597ui.p1083b.C14933b;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import com.tencent.p177mm.sdk.platformtools.FLock;
import com.tencent.p177mm.storage.C7617ak;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.ui.conversation.MainUI */
public class MainUI extends AbStractTabFragment implements C36294a {
    private View iVx;
    public MMFragmentActivity iWA;
    private View jcl = null;
    private int[] mkD = new int[2];
    private C23987h zrd;
    private C23972a zuL = new C23972a();
    public ConversationListView zuW;
    private View zuX;
    private View zuY;
    private TextView zuZ;
    private C46682k zva = new C46682k();
    private C36274d zvb = new C36274d();
    private C46684n zvc = new C46684n();
    private C40859l zvd = new C40859l();
    public C10984a zve;
    private C23963a zvf;

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$3 */
    class C158563 implements Runnable {
        C158563() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34494);
            C23972a d = MainUI.this.zuL;
            C4990ab.m7416i("MicroMsg.BannerHelper", "destroyBanner");
            C23972a.m36948fw(d.zqr);
            C23972a.m36948fw(d.zqs);
            C23972a.m36948fw(d.zqt);
            C23972a.m36948fw(d.zqu);
            for (C14933b c14933b : d.zqv) {
                if (c14933b != null) {
                    c14933b.destroy();
                }
            }
            C9638aw.m17200b(d.qbK);
            C4879a.xxA.mo10053d(d.zqx);
            C4879a.xxA.mo10053d(d.zqy);
            if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                C18628c.m29104b(d);
            }
            d.context = null;
            AppMethodBeat.m2505o(34494);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$1 */
    class C239541 implements C23988b {
        C239541() {
        }

        public final void dIJ() {
            AppMethodBeat.m2504i(34492);
            MainUI.this.zrd.clearCache();
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10118a(MainUI.this.zrd);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10118a(MainUI.this.zrd);
            AppMethodBeat.m2505o(34492);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$10 */
    class C2395510 implements Runnable {
        C2395510() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34503);
            if (MainUI.this.thisActivity() != null) {
                MainUI.this.thisActivity().supportInvalidateOptionsMenu();
            }
            AppMethodBeat.m2505o(34503);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$4 */
    class C239564 implements C30702a {

        /* renamed from: com.tencent.mm.ui.conversation.MainUI$4$1 */
        class C239571 implements Runnable {
            C239571() {
            }

            public final void run() {
                AppMethodBeat.m2504i(34495);
                MainUI.m36935a(MainUI.this, MainUI.this.zrd.getCount());
                if (MainUI.this.zrd.getCount() <= 0 && MainUI.this.zuW != null) {
                    ConversationListView c = MainUI.this.zuW;
                    C4990ab.m7417i("MicroMsg.ConversationListView", "alvinluo refreshFooter mHeaderOpen: %b", Boolean.valueOf(c.iVR));
                    if (!c.iVR) {
                        c.mo58757qH(false);
                        if (c.zst != null) {
                            c.zst.setBackgroundColor(c.getContext().getResources().getColor(C25738R.color.a69));
                        }
                        c.mo58747e(1.0f, c.getResources().getColor(C25738R.color.f11704e4));
                    }
                }
                MainUI.this.zuL.dIn();
                C34830g.m57195BO(12);
                AppMethodBeat.m2505o(34495);
            }
        }

        C239564() {
        }

        public final void dwH() {
            AppMethodBeat.m2504i(34496);
            C34830g.m57194BN(12);
            C36274d b = MainUI.this.zvb;
            b.zrb = -1;
            b.zra.clear();
            if (b.zrd == null || b.zrc < 0 || !b.zrd.dvr()) {
                b.zrb = 0;
                AppMethodBeat.m2505o(34496);
            } else if (b.zrd.ztG) {
                b.zrb = 0;
                AppMethodBeat.m2505o(34496);
            } else if (b.zrd.ztE) {
                C4990ab.m7416i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount has contact change");
                b.zrb = 0;
                b.zrd.ztE = false;
                AppMethodBeat.m2505o(34496);
            } else {
                HashSet hashSet = (HashSet) b.zrd.ztF.clone();
                C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  events size %d", Integer.valueOf(hashSet.size()));
                if (hashSet.contains("floatbottle")) {
                    b.zrb = 0;
                    AppMethodBeat.m2505o(34496);
                    return;
                }
                hashSet.remove("officialaccounts");
                if (hashSet.isEmpty()) {
                    b.zrb = 1;
                    AppMethodBeat.m2505o(34496);
                    return;
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    boolean z;
                    String str = (String) it.next();
                    C23987h c23987h = b.zrd;
                    if (c23987h.arV(str)) {
                        z = false;
                    } else {
                        C23985d c23985d = (C23985d) c23987h.yDY.get(str);
                        if (c23985d == null) {
                            z = false;
                        } else if (C1855t.m3896kH(str)) {
                            z = c23985d.zrR;
                        } else {
                            z = c23985d.zrN;
                        }
                    }
                    if (!z) {
                        C7617ak arU = b.arU(str);
                        if (arU == null) {
                            b.zra.put(str, Integer.valueOf(0));
                            C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov == null username %s, unreadcount %d", str, Integer.valueOf(0));
                        } else {
                            b.zra.put(str, Integer.valueOf(arU.field_unReadCount));
                            C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  cov != null username %s, unreadcount %d", str, Integer.valueOf(arU.field_unReadCount));
                        }
                    }
                }
                C4990ab.m7417i("MicroMsg.ConvUnreadHelper", "unreadcheck preSetLauncherUIUnReadCount  preUnReadCount size %d", Integer.valueOf(b.zra.size()));
                if (b.zra.isEmpty()) {
                    b.zrb = 1;
                    AppMethodBeat.m2505o(34496);
                } else if (b.zra.size() > 20) {
                    b.zrb = 0;
                    AppMethodBeat.m2505o(34496);
                } else {
                    b.zrb = 2;
                    AppMethodBeat.m2505o(34496);
                }
            }
        }

        public final void apt() {
            AppMethodBeat.m2504i(34497);
            MainUI.this.zvb.dIp();
            if (MainUI.this.zrd != null) {
                C23987h a = MainUI.this.zrd;
                if (!(a.yDY == null || a.ztF == null || a.ztF.isEmpty())) {
                    if (a.ztG) {
                        a.yDY.clear();
                        a.ztG = false;
                    } else {
                        C4990ab.m7411d("MicroMsg.ConversationWithCacheAdapter", "dealWithConversationEvents size %d", Integer.valueOf(a.ztF.size()));
                        Iterator it = a.ztF.iterator();
                        while (it.hasNext()) {
                            a.yDY.remove(it.next());
                        }
                    }
                    a.ztF.clear();
                }
            }
            MainUI.this.zuW.post(new C239571());
            AppMethodBeat.m2505o(34497);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$2 */
    class C239582 implements Runnable {
        C239582() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34493);
            C23972a d = MainUI.this.zuL;
            C4990ab.m7416i("MicroMsg.BannerHelper", "releaseBanner");
            C23972a.m36947fv(d.zqr);
            C23972a.m36947fv(d.zqs);
            C23972a.m36947fv(d.zqt);
            C23972a.m36947fv(d.zqu);
            for (C14933b c14933b : d.zqv) {
                if (c14933b != null) {
                    c14933b.release();
                }
            }
            if (C9638aw.m17179RK()) {
                C17884o.acd().mo67503e(d);
            }
            if (C9638aw.m17179RK()) {
                C9638aw.m17190ZK();
                C18628c.m29072Ry().mo10121b(d);
            }
            AppMethodBeat.m2505o(34493);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$11 */
    class C2395911 implements Runnable {
        C2395911() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34504);
            C23972a d = MainUI.this.zuL;
            C17884o.acd().mo67502d(d);
            C9638aw.m17190ZK();
            C18628c.m29072Ry().mo10118a(d);
            d.dIn();
            AppMethodBeat.m2505o(34504);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$5 */
    class C239605 implements C15521c {
        C239605() {
        }

        /* renamed from: cZ */
        public final int mo8831cZ(View view) {
            AppMethodBeat.m2504i(34498);
            int positionForView = MainUI.this.zuW.getPositionForView(view);
            AppMethodBeat.m2505o(34498);
            return positionForView;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$6 */
    class C239616 implements C23600g {
        C239616() {
        }

        /* renamed from: q */
        public final void mo11108q(View view, int i, int i2) {
            AppMethodBeat.m2504i(34499);
            MainUI.this.zuW.performItemClick(view, i, (long) i2);
            AppMethodBeat.m2505o(34499);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$8 */
    class C239628 implements OnTouchListener {
        C239628() {
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(34501);
            switch (motionEvent.getAction()) {
                case 0:
                    MainUI.this.hideVKB();
                    MainUI.this.mkD[0] = (int) motionEvent.getRawX();
                    MainUI.this.mkD[1] = (int) motionEvent.getRawY();
                    break;
            }
            AppMethodBeat.m2505o(34501);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$a */
    class C23963a {
        boolean cui;
        boolean zvi;
        boolean zvj;

        public C23963a(boolean z, boolean z2, boolean z3) {
            this.cui = z;
            this.zvi = z2;
            this.zvj = z3;
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$7 */
    class C239647 implements Runnable {
        C239647() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34500);
            MainUI.this.zuL.mo39773a(MainUI.this.getContext(), MainUI.this.zuW, MainUI.this.zuZ);
            AppMethodBeat.m2505o(34500);
        }
    }

    /* renamed from: com.tencent.mm.ui.conversation.MainUI$9 */
    class C239659 implements Runnable {
        int eRu = 0;

        C239659() {
        }

        public final void run() {
            AppMethodBeat.m2504i(34502);
            if (MainUI.this.zuW == null) {
                AppMethodBeat.m2505o(34502);
                return;
            }
            int J = C5230ak.m7984J(MainUI.this.getContext(), -1);
            int de = C30036f.m47542de(MainUI.this.zuW.getContext());
            if (J <= 0 || de <= 0) {
                if (this.eRu < 2) {
                    C4990ab.m7416i("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight again!");
                    MainUI.this.zuW.post(this);
                } else {
                    C4990ab.m7412e("MicroMsg.MainUI", "[trySetListViewMargin] try getStatusHeight finally!");
                }
                this.eRu++;
            } else if (J + de != MainUI.this.zuW.getPaddingTop()) {
                C4990ab.m7417i("MicroMsg.MainUI", "[initListViewPadding] now:%s old:%s", Integer.valueOf(J + de), Integer.valueOf(MainUI.this.zuW.getPaddingTop()));
                MainUI.m36937b(MainUI.this, de + J);
            } else {
                C4990ab.m7417i("MicroMsg.MainUI", "[trySetListViewMargin] has try more once! it's right! statusHeight:%s", Integer.valueOf(J));
            }
            C4990ab.m7417i("MicroMsg.MainUI", "[trySetListViewMargin] tryCount:%s statusHeight:%s", Integer.valueOf(this.eRu), Integer.valueOf(J));
            AppMethodBeat.m2505o(34502);
        }
    }

    public MainUI() {
        AppMethodBeat.m2504i(34505);
        AppMethodBeat.m2505o(34505);
    }

    /* renamed from: b */
    static /* synthetic */ void m36937b(MainUI mainUI, int i) {
        AppMethodBeat.m2504i(34530);
        mainUI.m36933Px(i);
        AppMethodBeat.m2505o(34530);
    }

    public int getLayoutId() {
        return 2130970018;
    }

    public View getLayoutView() {
        AppMethodBeat.m2504i(34506);
        this.jcl = C1742b.m3596SM().mo5274a(getContext(), "R.layout.main", 2130970018);
        View view = this.jcl;
        AppMethodBeat.m2505o(34506);
        return view;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public boolean noActionBar() {
        return true;
    }

    public void onResume() {
        AppMethodBeat.m2504i(34507);
        C4990ab.m7416i("MicroMsg.MainUI", "onResume");
        super.onResume();
        if (this.zuW != null) {
            ConversationListView conversationListView = this.zuW;
            if (conversationListView.iVo != null) {
                conversationListView.iVo.onResume();
            }
            if (conversationListView.zrY != null && conversationListView.zrY.aOV() && conversationListView.iVo.getBottom() < C1338a.fromDPToPix(conversationListView.getContext(), 100)) {
                conversationListView.mo58747e(1.0f, conversationListView.getResources().getColor(C25738R.color.f11704e4));
            }
            if (conversationListView.zrY != null) {
                conversationListView.zrY.onResume();
            }
        }
        AppMethodBeat.m2505o(34507);
    }

    public void onPause() {
        AppMethodBeat.m2504i(34508);
        C4990ab.m7416i("MicroMsg.MainUI", "onPause");
        super.onPause();
        if (this.zuW != null) {
            ConversationListView conversationListView = this.zuW;
            if (conversationListView.iVo != null) {
                conversationListView.iVo.onPause();
            }
        }
        AppMethodBeat.m2505o(34508);
    }

    /* renamed from: Px */
    private void m36933Px(int i) {
        AppMethodBeat.m2504i(34509);
        LayoutParams layoutParams = this.zuW.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        if (layoutParams instanceof RelativeLayout.LayoutParams) {
            C4990ab.m7417i("MicroMsg.MainUI", "alvinluo setListMargin topMargin: %d", Integer.valueOf(i));
            ((RelativeLayout.LayoutParams) layoutParams).topMargin = i;
            this.zuW.setLayoutParams(layoutParams);
        }
        if (this.iVx != null) {
            this.iVx.getLayoutParams().height = i;
        }
        AppMethodBeat.m2505o(34509);
    }

    /* renamed from: i */
    public final void mo39759i(boolean z, boolean z2, boolean z3) {
        AppMethodBeat.m2504i(34510);
        if (this.zuW instanceof ConversationListView) {
            this.zuW.mo58749i(z, z2, z3);
            AppMethodBeat.m2505o(34510);
            return;
        }
        this.zvf = new C23963a(z, z2, z3);
        AppMethodBeat.m2505o(34510);
    }

    public final void dHz() {
        AppMethodBeat.m2504i(34511);
        if (this.zrd != null) {
            this.zrd.dHz();
        }
        AppMethodBeat.m2505o(34511);
    }

    public void onConfigurationChanged(Configuration configuration) {
        AppMethodBeat.m2504i(34512);
        super.onConfigurationChanged(configuration);
        this.zuL.dIn();
        AppMethodBeat.m2505o(34512);
    }

    public final void dvY() {
        C23972a c23972a;
        AppMethodBeat.m2504i(34513);
        C4990ab.m7417i("MicroMsg.MainUI", "onTabCreate, %d", Integer.valueOf(hashCode()));
        if (this.mController != null) {
            this.mController.mo11176aC(4, false);
        }
        C4990ab.m7416i("MicroMsg.MainUI", "mainUIOnCreate");
        long currentTimeMillis = System.currentTimeMillis();
        setMenuVisibility(true);
        C9638aw.m17180RS().doM();
        C4990ab.m7416i("MicroMsg.MainUI", "main ui init view");
        if (this.zuW != null) {
            c23972a = this.zuL;
            if (c23972a.zqz != null) {
                c23972a.mo39775ft(c23972a.zqr);
                c23972a.mo39775ft(c23972a.zqs);
                c23972a.mo39775ft(c23972a.zqt);
                c23972a.mo39775ft(c23972a.zqu);
                for (C14933b c14933b : c23972a.zqv) {
                    if (!(c14933b == null || c14933b.getView() == null)) {
                        c23972a.zqz.removeFooterView(c14933b.getView());
                    }
                }
            }
        }
        this.zuZ = (TextView) findViewById(2131825719);
        this.zuW = (ConversationListView) findViewById(2131825718);
        this.iVx = findViewById(2131825717);
        this.zuW.setStatusBarMaskView(this.iVx);
        if (this.zuW != null) {
            int J = C5230ak.m7984J(getContext(), -1);
            C4990ab.m7417i("MicroMsg.MainUI", "alvinluo initListViewPadding actionBarHeight: %d, statusBarHeight: %d", Integer.valueOf(C30036f.m47542de(this.zuW.getContext())), Integer.valueOf(J));
            C239659 c239659 = new C239659();
            if (J <= 0) {
                this.zuW.post(c239659);
            } else {
                m36933Px(J + r1);
                C4990ab.m7417i("MicroMsg.MainUI", "[trySetListViewMargin] statusHeight: %s, actionBarHeight: %d", Integer.valueOf(J), Integer.valueOf(r1));
                this.zuW.postDelayed(c239659, 100);
            }
        }
        C11048d c11048d = (C11048d) C1720g.m3528K(C11048d.class);
        if (c11048d == null) {
            C4990ab.m7412e("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView service is null");
        } else {
            c11048d.aOE();
            if (c11048d.aOF()) {
                this.zuX = c11048d.mo22750dg(getContext());
                if (this.zuX != null && (this.jcl instanceof ViewGroup)) {
                    C4990ab.m7416i("MicroMsg.MainUI", "alvinluo addDynamicBackgroundView");
                    LayoutParams layoutParams = new LayoutParams(-1, -1);
                    this.zuX.setVisibility(8);
                    ((ViewGroup) this.jcl).addView(this.zuX, 0, layoutParams);
                }
            }
        }
        this.zuW.setDrawingCacheEnabled(false);
        this.zuW.setScrollingCacheEnabled(false);
        this.zuY = findViewById(2131825716);
        ConversationListView conversationListView = this.zuW;
        View view = this.zuX;
        View view2 = this.zuY;
        conversationListView.zsr = view;
        if (conversationListView.iVo != null) {
            conversationListView.iVo.mo54109e(view, view2);
        }
        this.zrd = new C23987h(getContext(), this.zuW, new C239564());
        this.zrd.setGetViewPositionCallback(new C239605());
        this.zrd.setPerformItemClickListener(new C239616());
        if (C1443d.m3069iX(18)) {
            C1314b.m2812HQ().mo4642o(new C239647());
        } else {
            this.zuL.mo39773a(getContext(), this.zuW, this.zuZ);
        }
        C40859l c40859l = this.zvd;
        ConversationListView conversationListView2 = this.zuW;
        C23987h c23987h = this.zrd;
        c40859l.zqz = conversationListView2;
        c40859l.zrd = c23987h;
        conversationListView2.setOnScrollListener(c40859l.ein);
        c23987h.zro = c40859l.ein;
        C5004al.m7441d(new C306972());
        this.zvb.mo57140ax(getActivity());
        this.zuW.setAdapter(this.zrd);
        this.zuW.setOnItemClickListener(new C36285f(this.zrd, this.zuW, getActivity()));
        this.zuW.setOnItemLongClickListener(new C30694g(this.zrd, this.zuW, getActivity(), this.mkD));
        this.zuW.setonDispatchTouchEventListener(new C239628());
        if (this.zve != null) {
            this.zuW.setActionBarUpdateCallback(this.zve);
        }
        if (this.iWA != null) {
            this.zuW.setActivity(this.iWA);
        }
        if (this.zvf != null) {
            mo39759i(this.zvf.cui, this.zvf.zvi, this.zvf.zvj);
        }
        this.zuW.setSelection(0);
        C1202f c1202f = this.zva;
        FragmentActivity activity = getActivity();
        c23972a = this.zuL;
        c1202f.czX = activity;
        c1202f.zuL = c23972a;
        c1202f.zuM = this;
        c1202f.gWO = new WeakReference(activity);
        c1202f.wakeLock = ((PowerManager) activity.getSystemService("power")).newWakeLock(26, "NetSceneInit Lock");
        C9638aw.m17182Rg().mo14539a(-1, c1202f);
        c1202f.zuI = false;
        C4879a.xxA.mo10052c(c1202f.zuN);
        C4879a.xxA.mo10052c(c1202f.zuO);
        File file = new File(C4996ah.getContext().getFilesDir(), "DBRecoverStarted");
        if (file.exists()) {
            C7053e.pXa.mo8382g("DBRepair", "Last recovery interrupted.", null);
            file.delete();
        }
        c1202f.zuP = new FLock(new File(C4996ah.getContext().getFilesDir(), "MMStarted"));
        if (c1202f.zuP.dob()) {
            c1202f.zuP.unlock();
            C4990ab.m7416i("MicroMsg.DuplicateDetect", "No data multiple instance detected.");
        } else {
            C4990ab.m7420w("MicroMsg.DuplicateDetect", "Data multiple instance detected.");
            C7053e.pXa.mo8378a(579, 0, 1, true);
        }
        c1202f.zuP.lockRead();
        C36274d c36274d = this.zvb;
        C23987h c23987h2 = this.zrd;
        ConversationListView conversationListView3 = this.zuW;
        FragmentActivity activity2 = getActivity();
        c36274d.zrd = c23987h2;
        c36274d.zqz = conversationListView3;
        c36274d.activity = activity2;
        C4879a.xxA.mo10052c(c36274d.zrg);
        C4879a.xxA.mo10052c(c36274d.zre);
        C4879a.xxA.mo10052c(c36274d.zrf);
        C46684n c46684n = this.zvc;
        c23987h2 = this.zrd;
        conversationListView3 = this.zuW;
        activity2 = getActivity();
        c46684n.zrd = c23987h2;
        c46684n.czX = activity2;
        c46684n.zuW = conversationListView3;
        if (c46684n.kTz == null) {
            c46684n.kTz = new C443683(new C443671());
        }
        if (c46684n.zvz == null) {
            c46684n.zvz = new C239984();
        }
        if (c46684n.zvA == null) {
            c46684n.zvA = new C239995(conversationListView3);
        }
        C4879a.xxA.mo10052c(c46684n.kTz);
        C4879a.xxA.mo10052c(c46684n.zvz);
        C4879a.xxA.mo10052c(c46684n.zvA);
        c46684n.jQs = new C240006();
        Looper.myQueue().addIdleHandler(c46684n.jQs);
        conversationListView3.post(new C306997());
        C25820b ahn = C32291o.ahn();
        C4990ab.m7416i("MicroMsg.AutoGetBigImgLogic", "chattingMaskResId change from " + ahn.fCX + " to 2130838182");
        ahn.fCX = C25738R.drawable.b0p;
        C9638aw.m17186ZG();
        C9638aw.m17190ZK();
        C18628c.m29083XR().mo10118a(this.zrd);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10118a(this.zrd);
        C23987h c23987h3 = this.zrd;
        if (c23987h3.zrt == null) {
            c23987h3.zrt = new C239922();
        }
        C4879a.xxA.mo10052c(c23987h3.zrt);
        this.zrd.ztz = new C239541();
        c23987h2 = this.zrd;
        C20772b c20772b = (C20772b) C1720g.m3528K(C20772b.class);
        if (!(c20772b == null || c20772b.bxV() == null)) {
            c20772b.bxV().mo10116c(c23987h2.yql);
        }
        r2 = new Object[3];
        C9638aw.m17190ZK();
        r2[1] = Integer.valueOf(C18628c.m29064QF());
        r2[2] = Integer.valueOf(C7243d.vxo);
        C4990ab.m7417i("MicroMsg.MainUI", "kevin mainUIOnCreate time:%d uin:%d ver:%x", r2);
        this.zuW.postDelayed(new C2395510(), 200);
        AppMethodBeat.m2505o(34513);
    }

    public final void dIT() {
        AppMethodBeat.m2504i(34514);
        if (this.zrd != null) {
            this.zrd.onResume();
        }
        AppMethodBeat.m2505o(34514);
    }

    public final void dIU() {
        AppMethodBeat.m2504i(34515);
        if (this.zrd != null) {
            this.zrd.onPause();
        }
        AppMethodBeat.m2505o(34515);
    }

    /* renamed from: Nj */
    public final void mo39753Nj(int i) {
        AppMethodBeat.m2504i(34516);
        if (this.zrd != null) {
            this.zrd.mo39785Pv(i);
        }
        AppMethodBeat.m2505o(34516);
    }

    public final void dvZ() {
        AppMethodBeat.m2504i(34517);
        C4990ab.m7416i("MicroMsg.MainUI", "onTabResume");
        long anU = C42252ah.anU();
        C36274d c36274d = this.zvb;
        if (c36274d.zrc < 0) {
            C4990ab.m7411d("MicroMsg.ConvUnreadHelper", "onTabResume totalUnReadCount %d", Integer.valueOf(c36274d.zrc));
            if (c36274d.zrd != null) {
                c36274d.zrd.dIH();
            }
        }
        dIT();
        C1314b.m2812HQ().mo4642o(new C2395911());
        C4990ab.m7411d("MicroMsg.MainUI", "start time check dkinit KEVIN mainui TestTimeLayoutTime onTabResume:%d", Long.valueOf(C42252ah.m74623gb(anU)));
        C46684n c46684n = this.zvc;
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4620a(c46684n);
        }
        C5004al.m7441d(new C443698());
        C44365m.m80189hY(c46684n.czX);
        if (!(c46684n.czX == null || c46684n.czX.getIntent() == null || !c46684n.czX.getIntent().getBooleanExtra("resend_fail_messages", false))) {
            C5004al.m7442n(new C443709(), 500);
            c46684n.czX.getIntent().putExtra("resend_fail_messages", false);
        }
        LauncherUI launcherUI = (LauncherUI) c46684n.czX;
        if (launcherUI != null) {
            launcherUI.getHomeUI().setTitleBarDoubleClickListener(c46684n.zky);
        }
        if (C5068w.m7683a(c46684n.czX.getIntent(), "Main_ListToTop", false) && c46684n.zuW != null) {
            c46684n.zuW.post(new C466832());
        }
        C5068w.m7685b(c46684n.czX.getIntent(), "Main_ListToTop", false);
        C46682k c46682k = this.zva;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabResume tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = c46682k.ehJ == null ? -1 : c46682k.ehJ.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(c46682k.dIP());
        C4990ab.m7417i(str, str2, objArr);
        c46682k.dIN();
        C5004al.m7442n(new C408577(), 100);
        if (C9638aw.m17179RK() && !this.zva.dIQ()) {
            C4879a.xxA.mo10048a(new C18394st(), Looper.getMainLooper());
            C4883b c6546sd = new C6546sd();
            c6546sd.cOe.action = 4;
            C4879a.xxA.mo10049a(c6546sd, C7305d.xDG.cin());
        }
        AppMethodBeat.m2505o(34517);
    }

    public final void dwa() {
        AppMethodBeat.m2504i(34518);
        C4990ab.m7416i("MicroMsg.MainUI", "onTabStart");
        AppMethodBeat.m2505o(34518);
    }

    public final void dwb() {
        AppMethodBeat.m2504i(34519);
        C4990ab.m7416i("MicroMsg.MainUI", "onTabPause");
        C1314b.m2812HQ().mo4642o(new C239582());
        C46682k c46682k = this.zva;
        if (c46682k.wakeLock.isHeld()) {
            C4990ab.m7420w("MicroMsg.InitHelper", "onTabPause wakelock.release!");
            c46682k.wakeLock.release();
        }
        hideVKB();
        C46684n c46684n = this.zvc;
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4623b(c46684n);
        }
        C44365m.dIW();
        LauncherUI launcherUI = (LauncherUI) c46684n.czX;
        if (launcherUI != null) {
            launcherUI.getHomeUI().mo69881aw(c46684n.zky);
        }
        dIU();
        AppMethodBeat.m2505o(34519);
    }

    public final void dwc() {
        AppMethodBeat.m2504i(34520);
        C4990ab.m7416i("MicroMsg.MainUI", "onTabStop");
        AppMethodBeat.m2505o(34520);
    }

    public final void dwd() {
        AppMethodBeat.m2504i(34521);
        C4990ab.m7417i("MicroMsg.MainUI", "onTabDestroy  acc:%b", Boolean.valueOf(C9638aw.m17179RK()));
        C1314b.m2812HQ().mo4642o(new C158563());
        C1202f c1202f = this.zva;
        c1202f.zuP.unlock();
        C9638aw.m17182Rg().mo14546b(-1, c1202f);
        if (c1202f.ehJ != null) {
            c1202f.ehJ.dismiss();
            c1202f.ehJ = null;
        }
        C4879a.xxA.mo10053d(c1202f.zuN);
        C4879a.xxA.mo10053d(c1202f.zuO);
        C46684n c46684n = this.zvc;
        if (c46684n.kTz != null) {
            C4879a.xxA.mo10053d(c46684n.kTz);
            c46684n.kTz = null;
        }
        C4879a.xxA.mo10053d(c46684n.zvz);
        C4879a.xxA.mo10053d(c46684n.zvA);
        if (C32337g.fUs != null) {
            C32337g.fUs.mo4623b(c46684n);
        }
        if (C9638aw.m17179RK()) {
            C42252ah.anV();
        }
        C36274d c36274d = this.zvb;
        C4879a.xxA.mo10053d(c36274d.zrg);
        C4879a.xxA.mo10053d(c36274d.zre);
        C4879a.xxA.mo10053d(c36274d.zrf);
        c36274d.activity = null;
        if (C9638aw.m17179RK() && this.zrd != null) {
            C9638aw.m17190ZK();
            C18628c.m29083XR().mo10121b(this.zrd);
            C9638aw.m17190ZK();
            C18628c.m29078XM().mo10121b(this.zrd);
        }
        if (this.zrd != null) {
            C23987h c23987h = this.zrd;
            if (c23987h.zrt != null) {
                C4879a.xxA.mo10053d(c23987h.zrt);
                c23987h.zrt = null;
            }
            this.zrd.ztz = null;
            C23987h c23987h2 = this.zrd;
            c23987h2.ztz = null;
            if (c23987h2.yDY != null) {
                c23987h2.yDY.clear();
                c23987h2.yDY = null;
            }
            c23987h2.mo64400pB(true);
            c23987h2.dww();
            c23987h2.ztC.clear();
            C20772b c20772b = (C20772b) C1720g.m3528K(C20772b.class);
            if (!(c20772b == null || c20772b.bxV() == null)) {
                c20772b.bxV().mo10117d(c23987h2.yql);
            }
            C4990ab.m7416i("MicroMsg.ConversationWithCacheAdapter", "clear usernamePositionMap");
        }
        AppMethodBeat.m2505o(34521);
    }

    public final void dwf() {
        AppMethodBeat.m2504i(34522);
        C4990ab.m7416i("MicroMsg.MainUI", "turn to bg");
        AppMethodBeat.m2505o(34522);
    }

    public final void dwg() {
        AppMethodBeat.m2504i(34523);
        C4990ab.m7416i("MicroMsg.MainUI", "turn to fg");
        AppMethodBeat.m2505o(34523);
    }

    public final void dwe() {
    }

    public final void dxc() {
        AppMethodBeat.m2504i(34524);
        C4990ab.m7416i("MicroMsg.MainUI", "dkinit onTabSwitchIn");
        C46682k c46682k = this.zva;
        String str = "MicroMsg.InitHelper";
        String str2 = "onTabSwitchIn tip:%d initscene:%d";
        Object[] objArr = new Object[2];
        int i = c46682k.ehJ == null ? -1 : c46682k.ehJ.isShowing() ? 1 : 0;
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Integer.valueOf(c46682k.dIP());
        C4990ab.m7417i(str, str2, objArr);
        if (c46682k.wakeLock != null) {
            c46682k.dIN();
        }
        if (this.mController != null) {
            this.mController.onResume();
        }
        AppMethodBeat.m2505o(34524);
    }

    public final void dxd() {
        AppMethodBeat.m2504i(34525);
        C4990ab.m7416i("MicroMsg.MainUI", "onTabSwitchOut");
        AppMethodBeat.m2505o(34525);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(34526);
        C4990ab.m7416i("MicroMsg.MainUI", "onDestroy");
        this.zvd.dIV();
        if (this.zuW != null) {
            ConversationListView conversationListView = this.zuW;
            if (conversationListView.iVo != null) {
                conversationListView.iVo.onDestroy();
            }
            if (conversationListView.zrY != null) {
                conversationListView.zrY.onDestroy();
            }
            if (conversationListView.zsq != null) {
                conversationListView.removeCallbacks(conversationListView.zsq);
            }
            if (conversationListView.zsp != null) {
                conversationListView.removeCallbacks(conversationListView.zsp);
            }
            if (conversationListView.zso != null) {
                conversationListView.removeCallbacks(conversationListView.zso);
            }
        }
        super.onDestroy();
        AppMethodBeat.m2505o(34526);
    }

    public final void dIR() {
        if (this.zrd != null) {
            this.zrd.nNp = true;
        }
    }

    public final void dIS() {
        AppMethodBeat.m2504i(34527);
        if (this.zrd != null) {
            this.zrd.nNp = false;
            this.zrd.dIH();
            if (thisActivity() != null) {
                this.zvb.mo57140ax(getActivity());
            }
        }
        AppMethodBeat.m2505o(34527);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(34528);
        boolean onKeyDown;
        if (i != 4 || keyEvent.getAction() != 0) {
            onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(34528);
            return onKeyDown;
        } else if (this.zuW == null || !this.zuW.dIv()) {
            onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.m2505o(34528);
            return onKeyDown;
        } else {
            ConversationListView conversationListView = this.zuW;
            C4990ab.m7417i("MicroMsg.ConversationListView", "[closeHeader] delay:%s, type: %d", Long.valueOf(10), Integer.valueOf(11));
            if (conversationListView.getFirstVisiblePosition() == 0) {
                if (10 > 0) {
                    if (conversationListView.zsp != null) {
                        conversationListView.removeCallbacks(conversationListView.zsp);
                    }
                    conversationListView.zsp = new C239316();
                    conversationListView.postDelayed(conversationListView.zsp, 10);
                } else {
                    conversationListView.setSelection(0);
                }
            }
            AppMethodBeat.m2505o(34528);
            return true;
        }
    }

    /* JADX WARNING: Missing block: B:11:0x0045, code skipped:
            if (r2.mo39776m(r2.zqu, false) == false) goto L_0x0047;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static /* synthetic */ void m36935a(MainUI mainUI, int i) {
        int i2 = 1;
        AppMethodBeat.m2504i(34529);
        if (i <= 0) {
            C23972a c23972a = mainUI.zuL;
            if (c23972a.context != null) {
                C4990ab.m7417i("MicroMsg.BannerHelper", "checkBannerEmpyt %d", Integer.valueOf(c23972a.hashCode()));
                if (!c23972a.mo39776m(c23972a.zqr, false)) {
                    if (!c23972a.mo39776m(c23972a.zqs, false)) {
                        if (!c23972a.mo39776m(c23972a.zqt, false)) {
                        }
                    }
                }
            }
            i2 = 0;
            if (i2 != 0) {
                mainUI.zuZ.setVisibility(0);
                mainUI.zuW.setVisibility(8);
            }
        }
        mainUI.zuW.setVisibility(0);
        mainUI.zuZ.setVisibility(8);
        AppMethodBeat.m2505o(34529);
    }
}
