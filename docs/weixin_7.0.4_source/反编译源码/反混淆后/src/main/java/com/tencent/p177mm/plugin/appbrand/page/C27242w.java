package com.tencent.p177mm.plugin.appbrand.page;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.webkit.ValueCallback;
import android.widget.ImageView;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.luggage.sdk.p148b.C25697b;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p230g.p232b.p233a.C42091cc;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.plugin.appbrand.C10048a;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.appcache.C33082aw;
import com.tencent.p177mm.plugin.appbrand.appcache.WxaCommLibRuntimeReader;
import com.tencent.p177mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C38163a.C33131d;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a;
import com.tencent.p177mm.plugin.appbrand.config.p283a.C26835a.C26839b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10332b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C27069q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C27107t;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45608m;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C16667p;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C45622a;
import com.tencent.p177mm.plugin.appbrand.launching.precondition.C10600f;
import com.tencent.p177mm.plugin.appbrand.menu.C38449o;
import com.tencent.p177mm.plugin.appbrand.menu.C42636n;
import com.tencent.p177mm.plugin.appbrand.menu.WxaMenuHelper;
import com.tencent.p177mm.plugin.appbrand.p1472u.C33536a;
import com.tencent.p177mm.plugin.appbrand.p328r.C45672d;
import com.tencent.p177mm.plugin.appbrand.p329s.C10732w;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n;
import com.tencent.p177mm.plugin.appbrand.p329s.C42682n.C42683a;
import com.tencent.p177mm.plugin.appbrand.p893e.C45551d;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c.C19628b;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19629d;
import com.tencent.p177mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.p177mm.plugin.appbrand.performance.C33487c;
import com.tencent.p177mm.plugin.appbrand.permission.C33489a;
import com.tencent.p177mm.plugin.appbrand.permission.C33491e;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.report.C19695l;
import com.tencent.p177mm.plugin.appbrand.report.model.C10718c;
import com.tencent.p177mm.plugin.appbrand.report.quality.C27285a;
import com.tencent.p177mm.plugin.appbrand.report.quality.C38501b;
import com.tencent.p177mm.plugin.appbrand.weishi.C33572e;
import com.tencent.p177mm.plugin.appbrand.weishi.C45709c;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b.C109364;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C10933b.C10937a;
import com.tencent.p177mm.plugin.appbrand.widget.actionbar.C33580g;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C33611c;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C33612d;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C36737b;
import com.tencent.p177mm.plugin.appbrand.widget.p340i.C38594e;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.AppBrandRecentView.C38620b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d.C11049a;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d.C11050b;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C42748a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C29970o;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.svg.p610a.C5147a;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.xweb.p1115c.C46832h;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.p703b.C16470a;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.page.w */
public class C27242w extends C37402a {
    private C41243o gOq;
    protected C33580g itm;
    private AppBrandRecentView itn;
    public final C10718c ito = new C10718c(hashCode());
    private long itp = System.currentTimeMillis();
    private long itq;
    private long itr;
    private boolean its = false;
    private C42091cc itt = null;
    private boolean itu = false;
    private boolean itv = false;
    private boolean itw = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$9 */
    class C24269 extends C33611c {
        C24269() {
        }

        /* renamed from: a */
        public final void mo6339a(String str, C33612d c33612d) {
            AppMethodBeat.m2504i(132391);
            super.mo6339a(str, c33612d);
            C4990ab.m7412e("IconLoadErrorHandler ", "load icon fail: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(132391);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$b */
    static final class C10678b extends C27107t {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onAppRouteResized";

        private C10678b() {
        }

        /* synthetic */ C10678b(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$a */
    static final class C16695a extends C10332b {
        static final int CTRL_INDEX = 237;
        static final String NAME = "config_navigationBarRightButton";

        private C16695a() {
        }

        /* synthetic */ C16695a(byte b) {
            this();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$8 */
    class C196568 implements OnLongClickListener {
        C196568() {
        }

        public final boolean onLongClick(View view) {
            AppMethodBeat.m2504i(132390);
            if (C27242w.this.getRuntime().mo43491ya().bQn.scene == FilterEnum4Shaka.MIC_WEISHI_v4_4_MAKALONG) {
                AppMethodBeat.m2505o(132390);
            } else if (C27242w.this.itn == null || C27242w.this.itn.getCount() == 0) {
                AppMethodBeat.m2505o(132390);
            } else {
                C27242w.this.itn.refresh();
                C27242w.this.itm.showAsDropDown(view);
                C19690c.m30500a(C27242w.this.getAppId(), C27242w.this.getURL(), 21, "", C5046bo.anT(), 1, 0);
                AppMethodBeat.m2505o(132390);
            }
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$6 */
    class C247056 implements C11049a {
        C247056() {
        }

        public final LocalUsageInfo aJZ() {
            AppMethodBeat.m2504i(132387);
            if (C27242w.this.isRunning()) {
                LocalUsageInfo localUsageInfo = new LocalUsageInfo(C27242w.this.getRuntime().atI().username, C27242w.this.getRuntime().atH().appId, C27242w.this.getRuntime().atH().hhd.gVt, C27242w.this.getRuntime().atH().hhd.gVu, C27242w.this.getRuntime().atH().cwz, C27242w.this.getRuntime().atH().bQo, C27242w.this.getRuntime().atH().hgW, false, C27242w.this.getRuntime().atH().mo3970xE(), 0);
                AppMethodBeat.m2505o(132387);
                return localUsageInfo;
            }
            AppMethodBeat.m2505o(132387);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$7 */
    class C272437 implements C38620b {

        /* renamed from: com.tencent.mm.plugin.appbrand.page.w$7$1 */
        class C272441 implements Runnable {
            C272441() {
            }

            public final void run() {
                AppMethodBeat.m2504i(132388);
                C27242w.this.itm.dismiss();
                AppMethodBeat.m2505o(132388);
            }
        }

        C272437() {
        }

        /* renamed from: a */
        public final boolean mo35067a(View view, C42748a c42748a, float f, float f2) {
            AppMethodBeat.m2504i(132389);
            C5004al.m7442n(new C272441(), 100);
            if (c42748a.type == 1) {
                LocalUsageInfo localUsageInfo = c42748a.iXW;
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = FilterEnum4Shaka.MIC_WEISHI_v4_4_LANMEI;
                appBrandStatObject.cst = C27242w.this.getAppId();
                C10600f.ijT.mo33003a(C27242w.this.mContext, localUsageInfo.username, null, null, localUsageInfo.har, -1, appBrandStatObject, null, null);
                AppMethodBeat.m2505o(132389);
                return true;
            }
            AppMethodBeat.m2505o(132389);
            return false;
        }

        /* renamed from: b */
        public final boolean mo35068b(View view, C42748a c42748a, float f, float f2) {
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$1 */
    class C272461 implements OnClickListener {
        C272461() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(132375);
            C19690c.m30500a(C27242w.this.getAppId(), C27242w.this.getURL(), 22, "", C5046bo.anT(), 1, 0);
            AppMethodBeat.m2505o(132375);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$10 */
    class C2724710 extends C38594e {

        /* renamed from: com.tencent.mm.plugin.appbrand.page.w$10$1 */
        class C272411 implements OnClickListener {
            C272411() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(132392);
                C4990ab.m7416i("MicroMsg.AppBrandPageViewWC", "CustomRightButton click");
                C19629d.m30427c(C27242w.this);
                AppMethodBeat.m2505o(132392);
            }
        }

        C2724710() {
        }

        /* renamed from: a */
        public final void mo22659a(Bitmap bitmap, C33612d c33612d) {
            AppMethodBeat.m2504i(132393);
            super.mo22659a(bitmap, c33612d);
            C5004al.m7441d(new C109364(bitmap, new C272411()));
            AppMethodBeat.m2505o(132393);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$11 */
    class C2725011 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.appbrand.page.w$11$1 */
        class C106761 implements C10937a {
            C106761() {
            }

            /* renamed from: a */
            public final void mo22217a(ImageView imageView, View view) {
                AppMethodBeat.m2504i(132394);
                if (imageView != null) {
                    imageView.clearColorFilter();
                    imageView.setImageDrawable(C5147a.m7837f(C27242w.this.mContext.getResources(), C1318a.app_brand_weishi_video_btn_close));
                }
                if (view != null) {
                    view.setBackground(null);
                }
                AppMethodBeat.m2505o(132394);
            }
        }

        /* renamed from: com.tencent.mm.plugin.appbrand.page.w$11$2 */
        class C106772 implements OnClickListener {
            C106772() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(132395);
                C4990ab.m7416i("MicroMsg.AppBrandPageViewWC", "pageview click close button");
                C33572e.aOz();
                if (C27242w.this.gOq != null) {
                    C33183g.m54275a(C27242w.this.getAppId(), C33184d.CLOSE);
                    C27242w.this.gOq.close();
                }
                AppMethodBeat.m2505o(132395);
            }
        }

        C2725011() {
        }

        public final void run() {
            AppMethodBeat.m2504i(132396);
            if (C27242w.this.isG != null) {
                C4990ab.m7416i("MicroMsg.AppBrandPageViewWC", "weishi customActionBar");
                C27242w.this.isG.setNavResetStyleListener(new C106761());
                C27242w.this.isG.setFullscreenMode(true);
                C27242w.this.isG.setForegroundStyle(false);
                C27242w.this.isG.mo22482eP(false);
                C27242w.this.isG.aON();
                C27242w.this.isG.setBackButtonClickListener(new C106772());
            }
            if (C27242w.this.isF != null) {
                C27242w.this.isF.setForceTopInsetsHeight(C27242w.this.mContext.getResources().getDimensionPixelSize(C25738R.dimen.f10196u3));
            }
            AppMethodBeat.m2505o(132396);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.page.w$5 */
    class C272515 extends C19623ai {
        C272515() {
        }

        /* Access modifiers changed, original: final */
        public final void aJY() {
            AppMethodBeat.m2504i(132385);
            C29970o.m47417JV(1);
            AppMethodBeat.m2505o(132385);
        }

        /* Access modifiers changed, original: final */
        public final void aDI() {
            AppMethodBeat.m2504i(132386);
            C29970o.m47417JV(2);
            AppMethodBeat.m2505o(132386);
        }
    }

    /* renamed from: xL */
    public /* synthetic */ C25697b mo44922xL() {
        AppMethodBeat.m2504i(132436);
        C41243o runtime = getRuntime();
        AppMethodBeat.m2505o(132436);
        return runtime;
    }

    public C27242w() {
        boolean z = false;
        AppMethodBeat.m2504i(132398);
        if (C5047bp.dpL() || C5058f.IS_FLAVOR_RED) {
            z = true;
        }
        this.gNV = z;
        AppMethodBeat.m2505o(132398);
    }

    /* renamed from: a */
    public final void mo44895a(Context context, C6750i c6750i) {
        AppMethodBeat.m2504i(132399);
        this.gOq = (C41243o) c6750i;
        super.mo44895a(context, c6750i);
        C10718c c10718c = this.ito;
        c10718c.mAppId = c6750i.mAppId;
        c10718c.iAS.start();
        aIb();
        getActionBar().setCloseButtonClickListener(new C272461());
        this.hvM = new C33489a((C41243o) c6750i, this);
        AppMethodBeat.m2505o(132399);
    }

    /* renamed from: xO */
    public final void mo44925xO() {
        AppMethodBeat.m2504i(132400);
        C4990ab.m7417i("MicroMsg.AppBrandPageViewWC", "[wxa_reload] onWebViewTrimmed %s", getURL());
        super.mo44925xO();
        this.itu = false;
        this.its = false;
        AppMethodBeat.m2505o(132400);
    }

    /* Access modifiers changed, original: protected */
    public void initView() {
        AppMethodBeat.m2504i(132401);
        super.initView();
        if (aJz() instanceof MMWebView) {
            ((MMWebView) aJz()).getIsX5Kernel();
        }
        aJy().mo61149a(new C272515());
        AppMethodBeat.m2505o(132401);
    }

    /* renamed from: cF */
    public C27221aj mo44915cF(Context context) {
        AppMethodBeat.m2504i(132402);
        if (context == null) {
            context = C4996ah.getContext();
        }
        C31324aa c31324aa = new C31324aa(context, this.isX);
        AppMethodBeat.m2505o(132402);
        return c31324aa;
    }

    public Map<String, C45608m> aub() {
        AppMethodBeat.m2504i(132403);
        Map aCi = C27069q.aCi();
        AppMethodBeat.m2505o(132403);
        return aCi;
    }

    public C41243o getRuntime() {
        AppMethodBeat.m2504i(132404);
        C41243o c41243o = (C41243o) super.mo44922xL();
        AppMethodBeat.m2505o(132404);
        return c41243o;
    }

    public final C19722s atK() {
        AppMethodBeat.m2504i(132405);
        C19722s c19722s = (C19722s) super.mo44923xM();
        AppMethodBeat.m2505o(132405);
        return c19722s;
    }

    /* renamed from: xN */
    public void mo44924xN() {
        AppMethodBeat.m2504i(132406);
        super.mo44924xN();
        if (this.itn != null) {
            this.itn.release();
        }
        if (this.itm != null) {
            C33580g c33580g = this.itm;
            c33580g.dismiss();
            if (c33580g.iVi != null) {
                c33580g.iVi.removeAllViews();
                c33580g.iVi = null;
            }
        }
        AppMethodBeat.m2505o(132406);
    }

    /* Access modifiers changed, original: protected */
    public void aIb() {
        AppMethodBeat.m2504i(132407);
        C1720g.m3528K(C11048d.class);
        if (getRuntime().atD()) {
            AppMethodBeat.m2505o(132407);
            return;
        }
        this.itn = ((C11048d) C1720g.m3528K(C11048d.class)).mo22744a(this.mContext, C11050b.TYPE_MENU, new C247056());
        this.itm = new C33580g(this.mContext);
        this.itm.setWidth(-1);
        this.itm.setBackgroundDrawable(new ColorDrawable());
        if (this.itn != null) {
            this.itn.refresh();
            this.itm.setHeight(this.itn.getLayoutParams().height);
            this.itn.setBackground(C1338a.m2864g(this.mContext, C25738R.drawable.f6367bu));
            this.itm.setContentView(this.itn);
            this.itn.setOnItemClickListener(new C272437());
        } else {
            C4990ab.m7421w("MicroMsg.AppBrandPageViewWC", "AppBrandRecentView is null, appId: %s", getAppId());
        }
        getActionBar().setCapsuleHomeButtonLongClickListener(new C196568());
        AppMethodBeat.m2505o(132407);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJC() {
        boolean z = false;
        AppMethodBeat.m2504i(132408);
        super.aJC();
        C33131d pageConfig = getPageConfig();
        boolean a = getRuntime().mo43488xY().mo53979a((C2241c) this, new C16695a());
        if (!(pageConfig.hfy && a)) {
            z = true;
        }
        super.mo44917ew(z);
        if (a && pageConfig.hfy && getRuntime().atI().bQe == 7 && !getActionBar().isFullscreenMode()) {
            C36737b c36737b = new C36737b(pageConfig.hfx, new C24269());
            c36737b.mo54185a((C38594e) new C2724710());
            c36737b.aSg();
        } else {
            C4990ab.m7416i("MicroMsg.AppBrandPageViewWC", "hasPermission:" + a + " navigationBarRightButtonHide:" + pageConfig.hfy + " appServiceType:" + getRuntime().atI().bQe + " isFullscreenMode:" + getActionBar().isFullscreenMode());
        }
        if (C33572e.m54822E(getRuntime())) {
            runOnUiThread(new C2725011());
        }
        AppMethodBeat.m2505o(132408);
    }

    /* Access modifiers changed, original: protected */
    public C19627c aBq() {
        AppMethodBeat.m2504i(132409);
        if (C33572e.m54822E(getRuntime())) {
            C45709c c45709c = new C45709c(this);
            AppMethodBeat.m2505o(132409);
            return c45709c;
        }
        C19627c aBq = super.aBq();
        AppMethodBeat.m2505o(132409);
        return aBq;
    }

    public final C45622a aJS() {
        AppMethodBeat.m2504i(132410);
        View findViewById = getContentView().findViewById(2131820572);
        if (findViewById instanceof C45622a) {
            C45622a c45622a = (C45622a) findViewById;
            AppMethodBeat.m2505o(132410);
            return c45622a;
        }
        AppMethodBeat.m2505o(132410);
        return null;
    }

    /* Access modifiers changed, original: protected|final */
    public final List<C42636n> aJx() {
        boolean z = true;
        AppMethodBeat.m2504i(132411);
        String appId = getAppId();
        LinkedList linkedList = new LinkedList();
        if ("wxfe02ecfe70800f46".equalsIgnoreCase(appId)) {
            WxaMenuHelper.m54662c(linkedList, C38449o.ShareAppMsg.ordinal(), false);
            AppMethodBeat.m2505o(132411);
            return linkedList;
        }
        WxaMenuHelper.m54662c(linkedList, C38449o.CopyPath.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.BackToHome.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.ShareAppMsg.ordinal(), true);
        WxaMenuHelper.m54662c(linkedList, C38449o.StickInWeChat.ordinal(), false);
        AppBrandSysConfigWC wJ = C10048a.m17636wJ(appId);
        if (C4872b.dnO() || !(wJ == null || wJ.hhd.gVt == 1)) {
            z = false;
        }
        WxaMenuHelper.m54662c(linkedList, C38449o.SendToDesktop.ordinal(), z);
        WxaMenuHelper.m54662c(linkedList, C38449o.ModfiyCollection.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.AboutUs.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.EnableDebug.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.EnablePerformancePanel.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.DumpPerformanceTrace.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.ShowPkgInfo.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.OpenGamePreload.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.DebugRestart.ordinal(), false);
        WxaMenuHelper.m54662c(linkedList, C38449o.Exit.ordinal(), false);
        AppMethodBeat.m2505o(132411);
        return linkedList;
    }

    /* renamed from: AA */
    public boolean mo44893AA(String str) {
        AppMethodBeat.m2504i(132412);
        this.itw = false;
        this.ito.mo22264DB(str);
        this.itq = System.currentTimeMillis();
        boolean AA = super.mo44893AA(str);
        AppMethodBeat.m2505o(132412);
        return AA;
    }

    /* Access modifiers changed, original: protected */
    public void aBa() {
        AppMethodBeat.m2504i(132413);
        super.aBa();
        this.gOq.gPr.mo73432y(4, System.currentTimeMillis() - this.itr);
        AppBrandPerformanceManager.m43287a(getRuntime(), 203, System.currentTimeMillis() - this.itq);
        C33487c.m54690a(getAppId(), "Native", "PageLoad", this.itq, System.currentTimeMillis(), "");
        this.ito.aLj();
        AppMethodBeat.m2505o(132413);
    }

    /* Access modifiers changed, original: protected */
    public void aBb() {
        AppMethodBeat.m2504i(132414);
        super.aBb();
        this.ito.mo22271wU();
        AppMethodBeat.m2505o(132414);
    }

    /* Access modifiers changed, original: protected */
    public void aBc() {
        AppMethodBeat.m2504i(132415);
        super.aBc();
        if (this.itm != null) {
            this.itm.dismiss();
        }
        this.ito.mo22272wW();
        AppMethodBeat.m2505o(132415);
    }

    public final void onConfigurationChanged(final Configuration configuration) {
        AppMethodBeat.m2504i(132416);
        super.onConfigurationChanged(configuration);
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(132397);
                C27242w.this.isT.onOrientationChanged(configuration.orientation);
                AppMethodBeat.m2505o(132397);
            }
        });
        AppMethodBeat.m2505o(132416);
    }

    /* Access modifiers changed, original: protected */
    public void aBd() {
        AppMethodBeat.m2504i(132417);
        super.aBd();
        C10718c c10718c = this.ito;
        c10718c.iAS.aLh();
        C19695l c19695l = c10718c.iAS;
        c19695l.quit();
        c19695l.mStopped = true;
        if (this.isJ instanceof C46832h) {
            C46832h c46832h = (C46832h) this.isJ;
            if (c46832h.hasEnteredFullscreen()) {
                C4990ab.m7416i("MicroMsg.AppBrandPageViewWC", "performPageDestroy, leave fullscreen");
                c46832h.leaveFullscreen();
            }
        }
        AppMethodBeat.m2505o(132417);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: De */
    public final void mo44894De(String str) {
        AppMethodBeat.m2504i(132418);
        this.itr = System.currentTimeMillis();
        aJV();
        if (this.gOq.gNO.aIy()) {
            String CC = this.gOq.gNO.mo44653CC(C8874h.m15847bO(str));
            aBx().evaluateJavascript(C33082aw.m54068a(this.gOq, CC + (CC.endsWith("/") ? "" : "/") + "page-frame.js"), null);
        }
        AppMethodBeat.m2505o(132418);
    }

    /* renamed from: bN */
    public final void mo44914bN(String str) {
        AppMethodBeat.m2504i(132419);
        super.mo44914bN(str);
        C19690c.m30502br(getAppId(), 27);
        AppMethodBeat.m2505o(132419);
    }

    /* Access modifiers changed, original: protected|final */
    public final void aJH() {
        AppMethodBeat.m2504i(132420);
        if (getRuntime().mo43491ya().bQn.scene == FilterEnum4Shaka.MIC_SHAKA_ADD_4) {
            aJJ();
        } else if (getRuntime().atD() || getRuntime().atJ().getPageCount() != 1) {
            aJI();
        } else {
            aJJ();
        }
        if (C33572e.m54822E(this.gOq)) {
            getActionBar().aON();
        }
        AppMethodBeat.m2505o(132420);
    }

    public View aBl() {
        AppMethodBeat.m2504i(132421);
        if (aJQ()) {
            View appBrandActionHeaderLayout = new AppBrandActionHeaderLayout(this.mContext);
            appBrandActionHeaderLayout.setAppId(getAppId());
            appBrandActionHeaderLayout.setActionHeaderStyle(this.isO);
            C4990ab.m7421w("MicroMsg.AppBrandPageViewWC", "getActionSheetHeader orientation:%d, mActionSheetTitle:%s", Integer.valueOf(((MMActivity) this.mContext).getRequestedOrientation()), this.isP);
            if (!TextUtils.isEmpty(this.isP)) {
                appBrandActionHeaderLayout.setStatusDescription(this.isP);
            }
            appBrandActionHeaderLayout.mo34821cI(getRuntime().atI().iconUrl, getRuntime().atI().cwz);
            AppMethodBeat.m2505o(132421);
            return appBrandActionHeaderLayout;
        }
        View aBl = super.aBl();
        AppMethodBeat.m2505o(132421);
        return aBl;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: aL */
    public void mo44911aL(List<C42636n> list) {
        AppMethodBeat.m2504i(132423);
        new C27230p(this, list).aJm();
        AppMethodBeat.m2505o(132423);
    }

    public final void aJT() {
        AppMethodBeat.m2504i(132424);
        new C27230p(this, this.irD).aJm();
        AppMethodBeat.m2505o(132424);
    }

    public final String aJA() {
        AppMethodBeat.m2504i(132425);
        String str = "https://servicewechat.com/";
        if (this.gOq == null) {
            str = str + "preload/";
        } else {
            str = str + String.format(Locale.US, "%s/%d/", new Object[]{getAppId(), Integer.valueOf(this.gOq.atH().hhd.gVu)});
        }
        AppMethodBeat.m2505o(132425);
        return str;
    }

    /* Access modifiers changed, original: protected|final */
    public final void atV() {
        AppMethodBeat.m2504i(132426);
        aJU();
        this.itu = true;
        AppMethodBeat.m2505o(132426);
    }

    /* Access modifiers changed, original: protected */
    public void onCreate() {
        AppMethodBeat.m2504i(132427);
        if (aJz() instanceof MMWebView) {
            MMWebView mMWebView = (MMWebView) aJz();
            C38450n.m65049xb(getAppId()).gPe.set(mMWebView.getIsX5Kernel());
            C19690c.m30504eA(mMWebView.getIsX5Kernel());
        }
        aBx().evaluateJavascript(String.format(Locale.US, "history.pushState({},\"\",\"%s\");", new Object[]{aJB()}), null);
        if (this.itu) {
            this.itu = false;
        } else {
            aJU();
        }
        String str = "";
        if (this.gOq.atH().bQp && !this.gOq.mo43493yd()) {
            str = WxaCommLibRuntimeReader.m42569xu("WAVConsole.js");
        }
        if (C5046bo.isNullOrNil(str)) {
            StringBuilder stringBuilder = new StringBuilder();
            String str2 = "";
            if (AppBrandPerformanceManager.m43291b(getRuntime())) {
                str2 = WxaCommLibRuntimeReader.m42569xu("WAPerf.js");
            }
            stringBuilder = stringBuilder.append(str2);
            str2 = "";
            if (this.gOq.mo43493yd()) {
                str2 = ";" + WxaCommLibRuntimeReader.m42569xu("WARemoteDebug.js");
            }
            aBx().evaluateJavascript(stringBuilder.append(str2).toString(), null);
        } else {
            final long currentTimeMillis = System.currentTimeMillis();
            final boolean atU = atU();
            aBx().evaluateJavascript(str, new ValueCallback<String>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    AppMethodBeat.m2504i(132378);
                    if (C27242w.this.atU() || C27242w.this.isRunning()) {
                        C27285a.aLz();
                        C38501b.m65164a(atU, C27242w.this.getAppId(), currentTimeMillis, "WAVConsole.js", (long) str.length());
                    }
                    AppMethodBeat.m2505o(132378);
                }
            });
        }
        aJV();
        if (!this.itv) {
            this.itv = true;
            this.gOq.gPr.mo73432y(3, System.currentTimeMillis() - this.itp);
            C33487c.m54690a(getAppId(), "Native", "WebViewInit+PageFrameLoad", this.itp, System.currentTimeMillis(), "");
        }
        AppMethodBeat.m2505o(132427);
    }

    private void aJU() {
        AppMethodBeat.m2504i(132428);
        C7060h.pYm.mo8378a(370, 1, 1, false);
        C42682n.m75589a(aBx(), C45672d.m84370Eb("wxa_library/android.js"), null);
        String xu = WxaCommLibRuntimeReader.m42569xu("WAWebview.js");
        final long currentTimeMillis = System.currentTimeMillis();
        final int length = xu == null ? 0 : xu.length();
        final boolean atU = atU();
        C42682n.m75589a(aBx(), xu, new C42683a() {
            public final void onSuccess(String str) {
                AppMethodBeat.m2504i(132376);
                if (C27242w.this.atU() || C27242w.this.isRunning()) {
                    C27285a.aLz();
                    C38501b.m65164a(atU, C27242w.this.getAppId(), currentTimeMillis, "WAWebview.js", (long) length);
                }
                C7060h.pYm.mo8378a(370, 3, 1, false);
                AppMethodBeat.m2505o(132376);
            }

            /* renamed from: lo */
            public final void mo5987lo(String str) {
                int i = 0;
                AppMethodBeat.m2504i(132377);
                C4990ab.m7413e("MicroMsg.AppBrandPageViewWC", "Inject SDK Page Script Failed: %s", str);
                C7060h.pYm.mo8378a(370, 2, 1, false);
                C19690c.m30502br(C27242w.this.getAppId(), 24);
                int i2 = -1;
                if (C27242w.this.gOq != null) {
                    i = C27242w.this.gOq.atH().hhd.gVu;
                    i2 = C27242w.this.gOq.atH().hhd.gVt;
                }
                C19690c.m30497a(C27242w.this.getAppId(), i, i2, 370, 2);
                AppMethodBeat.m2505o(132377);
            }
        });
        AppMethodBeat.m2505o(132428);
    }

    private void aJV() {
        AppMethodBeat.m2504i(132430);
        if (this.its) {
            AppMethodBeat.m2505o(132430);
            return;
        }
        if (this.gOq.gNO.aIy()) {
            String a = C33082aw.m54068a(this.gOq, "app-wxss.js");
            if (TextUtils.isEmpty(a)) {
                AppMethodBeat.m2505o(132430);
                return;
            }
            aBx().evaluateJavascript(a, null);
        } else {
            aBx().evaluateJavascript(C10675v.m18368Di(C33082aw.m54068a(this.gOq, "page-frame.html")), null);
        }
        this.its = true;
        AppMethodBeat.m2505o(132430);
    }

    /* renamed from: ew */
    public final void mo44917ew(boolean z) {
        AppMethodBeat.m2504i(132431);
        C33491e xY = getRuntime().mo43488xY();
        if (xY.mo53981b((C19722s) super.mo44923xM(), C16667p.class) || xY.mo53981b(this, C16667p.class)) {
            super.mo44917ew(z);
            AppMethodBeat.m2505o(132431);
            return;
        }
        super.mo44917ew(true);
        AppMethodBeat.m2505o(132431);
    }

    /* renamed from: h */
    public final void mo21957h(JSONObject jSONObject) {
        AppMethodBeat.m2504i(132432);
        super.mo21957h(jSONObject);
        mo21956b(jSONObject, "clientVersion", Integer.valueOf(C7243d.vxo));
        C45551d.m84004a(C33536a.aSj(), jSONObject);
        C45551d.m84006b(C33536a.aSk(), jSONObject);
        AppMethodBeat.m2505o(132432);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: cG */
    public C38461am mo44916cG(final Context context) {
        AppMethodBeat.m2504i(132433);
        C272484 c272484 = new C38461am() {
            private boolean foreground = false;
            private int itA;
            private int itB;
            private final C26839b[] itC = new C26839b[]{C26839b.LANDSCAPE_LEFT, C26839b.LANDSCAPE_RIGHT, C26839b.LANDSCAPE_LOCKED, C26839b.LANDSCAPE_SENSOR};
            private final C27107t itD = new C27107t();
            private boolean itz = false;

            /* renamed from: di */
            private boolean m43280di(int i, int i2) {
                AppMethodBeat.m2504i(132380);
                C26839b yV = C26835a.m42719yV(C27242w.this.isQ);
                if (yV == null) {
                    yV = C26839b.PORTRAIT;
                }
                if (C16470a.contains(this.itC, yV)) {
                    if (i > i2) {
                        AppMethodBeat.m2505o(132380);
                        return true;
                    }
                    AppMethodBeat.m2505o(132380);
                    return false;
                } else if (C26839b.PORTRAIT != yV) {
                    AppMethodBeat.m2505o(132380);
                    return true;
                } else if (i2 > i) {
                    AppMethodBeat.m2505o(132380);
                    return true;
                } else {
                    AppMethodBeat.m2505o(132380);
                    return false;
                }
            }

            public final void aJW() {
                AppMethodBeat.m2504i(132381);
                int width = C27242w.this.aBk().getWidth();
                int height = C27242w.this.aBk().getHeight();
                if (width <= 0 || height <= 0) {
                    C4990ab.m7413e("MicroMsg.AppBrandPageViewWC", "onPageLayout wtf invalid window size [%d %d], appId[%s], url[%s]", Integer.valueOf(width), Integer.valueOf(height), C27242w.this.getAppId(), C27242w.this.getURL());
                    AppMethodBeat.m2505o(132381);
                    return;
                }
                boolean z;
                boolean z2;
                int i;
                boolean z3 = (width == this.itA && height == this.itB) ? false : true;
                this.itA = width;
                this.itB = height;
                int[] d = C10732w.m18403d(C27242w.this);
                if (m43280di(width, height) && m43280di(d[0], d[1])) {
                    z = true;
                } else {
                    z = false;
                }
                if (this.itA == 0 || this.itB == 0) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                C4990ab.m7417i("MicroMsg.AppBrandPageViewWC", "onPageLayout appId[%s], url[%s], hadInit[%b], winSizeChanged[%b], winSizeMatched[%b], foreground[%b], needDispatch[%b]", C27242w.this.getAppId(), C27242w.this.getURL(), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z), Boolean.valueOf(this.foreground), Boolean.valueOf(this.itz));
                if ((z2 && z3 && z) || (C27242w.this.itw && z)) {
                    i = 1;
                } else {
                    i = 0;
                }
                if (i == 0) {
                    this.itz = false;
                    AppMethodBeat.m2505o(132381);
                } else if (this.foreground) {
                    aJX();
                    AppMethodBeat.m2505o(132381);
                } else {
                    this.itz = true;
                    AppMethodBeat.m2505o(132381);
                }
            }

            public final void aAS() {
                AppMethodBeat.m2504i(132382);
                if (this.itz) {
                    C4990ab.m7417i("MicroMsg.AppBrandPageViewWC", "onForeground dispatch ViewDidResize appId[%s] url[%s]", C27242w.this.getAppId(), C27242w.this.getURL());
                    aJX();
                    this.itz = false;
                }
                C27242w.this.isT.onOrientationChanged(context.getResources().getConfiguration().orientation);
                this.foreground = true;
                AppMethodBeat.m2505o(132382);
            }

            private void aJX() {
                AppMethodBeat.m2504i(132383);
                if (!C27242w.this.isRunning()) {
                    AppMethodBeat.m2505o(132383);
                } else if (C27242w.this.itw) {
                    m43279a(new C10678b());
                    C4990ab.m7417i("MicroMsg.AppBrandPageViewWC", "tryDispatchViewDidResize, appId[%s], url[%s], now_orientation[%s], send onAppRouteResized instead", C27242w.this.getAppId(), C27242w.this.getURL(), C27242w.this.isQ);
                    C27242w.this.itw = false;
                    AppMethodBeat.m2505o(132383);
                } else {
                    m43279a(this.itD);
                    AppMethodBeat.m2505o(132383);
                }
            }

            /* renamed from: a */
            private <EVENT extends C27107t> void m43279a(EVENT event) {
                AppMethodBeat.m2504i(132384);
                C33131d pageConfig = C27242w.this.getPageConfig();
                if (pageConfig == null) {
                    AppMethodBeat.m2505o(132384);
                    return;
                }
                int[] d = C10732w.m18403d(C27242w.this.atK());
                Map h = C27242w.m43261h(C27242w.this);
                h.put("originalPageOrientation", pageConfig.hfD);
                h.put("lastPageOrientation", C27242w.this.isQ);
                event.mo44764a(C27242w.this, C27242w.this.hashCode(), C27242w.this.aBk().getWidth(), C27242w.this.aBk().getHeight(), d[0], d[1], context.getResources().getConfiguration().orientation, h);
                AppMethodBeat.m2505o(132384);
            }

            public final void aAT() {
                this.foreground = false;
            }
        };
        AppMethodBeat.m2505o(132433);
        return c272484;
    }

    /* Access modifiers changed, original: protected|final */
    public final boolean aJK() {
        AppMethodBeat.m2504i(132434);
        boolean aJK = super.aJK();
        this.itw = aJK;
        AppMethodBeat.m2505o(132434);
        return aJK;
    }

    public boolean isFullScreen() {
        AppMethodBeat.m2504i(132422);
        if (this.isT.aBt() == C19628b.HIDDEN) {
            AppMethodBeat.m2505o(132422);
            return true;
        }
        AppMethodBeat.m2505o(132422);
        return false;
    }

    /* Access modifiers changed, original: protected|final */
    public final String aJP() {
        AppMethodBeat.m2504i(132429);
        String xu = WxaCommLibRuntimeReader.m42569xu("WAPageFrame.html");
        AppMethodBeat.m2505o(132429);
        return xu;
    }

    /* renamed from: xM */
    public final /* bridge */ /* synthetic */ C45126b mo44923xM() {
        AppMethodBeat.m2504i(132435);
        C19722s c19722s = (C19722s) super.mo44923xM();
        AppMethodBeat.m2505o(132435);
        return c19722s;
    }

    /* renamed from: xT */
    public final /* synthetic */ C38492q mo44926xT() {
        AppMethodBeat.m2504i(132438);
        C19722s c19722s = (C19722s) super.mo44923xM();
        AppMethodBeat.m2505o(132438);
        return c19722s;
    }
}
