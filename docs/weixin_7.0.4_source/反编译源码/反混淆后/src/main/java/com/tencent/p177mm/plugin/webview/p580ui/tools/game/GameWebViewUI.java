package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.p057v4.content.C0380b;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.p731d.C39197dd;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.model.C40259aq.C40265e;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C35650c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C16953w;
import com.tencent.p177mm.plugin.webview.p580ui.tools.WebViewUI.C7216g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.C22971a.C229723;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.GameBaseWebViewUI.C4611a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C40316a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C40318c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C40318c.C22980a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46440b.C14617c;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46440b.C46439b;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.C46442d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.GameMenuImageButton;
import com.tencent.p177mm.plugin.webview.p580ui.tools.game.menu.GameMenuImageButton.C14615a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C29945i.C23124a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d.C4398264;
import com.tencent.p177mm.plugin.wepkg.C30003c;
import com.tencent.p177mm.plugin.wepkg.event.C46472b;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.protocal.protobuf.bbb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C6031l;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI */
public class GameWebViewUI extends GameBaseWebViewUI {
    private static String uDU = "wx_fullscreen";
    private boolean mTC = false;
    public GameWebPerformanceInfo mUN;
    private ViewGroup mUO;
    private boolean mUP = false;
    private Object mUQ = new Object();
    private long mUZ;
    public C43963g mVc;
    private boolean uDT = false;
    private HashMap<String, String> uDV = new HashMap();
    private Drawable uDW;
    private Drawable uDX;
    private String uDY = null;
    private Map<Integer, bbb> uDZ = new HashMap();
    public C30003c uDe;
    private String uEa;
    private GameMenuImageButton uEb;
    private boolean uEc;
    private boolean uEd = false;
    private boolean uEe;
    private boolean uEf = false;
    private boolean uEg = false;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$7 */
    class C146087 implements Runnable {
        C146087() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8730);
            if (GameWebViewUI.this.pzf != null) {
                C4990ab.m7417i("MicroMsg.Wepkg.GameWebViewUI", "home page, reload url:%s from net", GameWebViewUI.this.jUg);
                GameWebViewUI.this.pzf.stopLoading();
                GameWebViewUI.this.pzf.loadUrl(GameWebViewUI.this.jUg);
            }
            AppMethodBeat.m2505o(8730);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$c */
    class C14609c extends C4611a {
        private C14609c() {
            super();
        }

        /* synthetic */ C14609c(GameWebViewUI gameWebViewUI, byte b) {
            this();
        }

        /* renamed from: b */
        public final void mo7562b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(8734);
            if (GameWebViewUI.this.mUN.eCf == 0) {
                GameWebViewUI.this.mUN.eCf = System.currentTimeMillis();
            }
            if (GameWebViewUI.this.mVc.uDM == 0) {
                GameWebViewUI.this.mVc.uDM = System.currentTimeMillis();
            }
            GameWebViewUI.this.uDe.mo48240j(webView, str);
            super.mo7562b(webView, str, bitmap);
            AppMethodBeat.m2505o(8734);
        }

        /* renamed from: b */
        public final void mo5992b(WebView webView, String str) {
            AppMethodBeat.m2504i(8735);
            if (GameWebViewUI.this.mUN.eCg == 0) {
                GameWebViewUI.this.mUN.eCg = System.currentTimeMillis();
            }
            if (GameWebViewUI.this.mVc.uDN == 0) {
                GameWebViewUI.this.mVc.uDN = System.currentTimeMillis();
            }
            GameWebViewUI.m69117O(GameWebViewUI.this);
            GameWebViewUI.this.uDe.mo48241k(webView, str);
            super.mo5992b(webView, str);
            AppMethodBeat.m2505o(8735);
        }

        /* renamed from: a */
        public final void mo7559a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.m2504i(8736);
            GameWebViewUI.m69117O(GameWebViewUI.this);
            super.mo7559a(webView, i, str, str2);
            AppMethodBeat.m2505o(8736);
        }

        /* renamed from: c */
        public final C31147o mo5993c(WebView webView, String str) {
            AppMethodBeat.m2504i(8737);
            C31147o ahA = GameWebViewUI.this.uDe.ahA(str);
            if (ahA != null) {
                AppMethodBeat.m2505o(8737);
                return ahA;
            }
            ahA = super.mo5993c(webView, str);
            AppMethodBeat.m2505o(8737);
            return ahA;
        }

        /* renamed from: a */
        public final C31147o mo5990a(WebView webView, C24530n c24530n) {
            AppMethodBeat.m2504i(8738);
            C31147o a;
            if (c24530n == null || c24530n.getUrl() == null) {
                a = super.mo5990a(webView, c24530n);
                AppMethodBeat.m2505o(8738);
                return a;
            }
            a = GameWebViewUI.this.uDe.ahA(c24530n.getUrl().toString());
            if (a != null) {
                AppMethodBeat.m2505o(8738);
                return a;
            }
            a = super.mo5990a(webView, c24530n);
            AppMethodBeat.m2505o(8738);
            return a;
        }

        /* renamed from: a */
        public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            AppMethodBeat.m2504i(8739);
            C31147o a;
            if (c24530n == null || c24530n.getUrl() == null) {
                a = super.mo5990a(webView, c24530n);
                AppMethodBeat.m2505o(8739);
                return a;
            }
            a = GameWebViewUI.this.uDe.ahA(c24530n.getUrl().toString());
            if (a != null) {
                AppMethodBeat.m2505o(8739);
                return a;
            }
            a = super.mo5991a(webView, c24530n, bundle);
            AppMethodBeat.m2505o(8739);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$6 */
    class C299176 implements C14615a {
        C299176() {
        }

        public final void bDJ() {
            AppMethodBeat.m2504i(8729);
            GameWebViewUI.this.cZM();
            AppMethodBeat.m2505o(8729);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$a */
    class C29919a extends C35650c {
        public C29919a(WebViewUI webViewUI) {
            super(webViewUI);
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.m2504i(8732);
            Object onMiscCallBack = GameWebViewUI.this.uDe.onMiscCallBack(str, bundle);
            if (onMiscCallBack != null) {
                AppMethodBeat.m2505o(8732);
                return onMiscCallBack;
            }
            onMiscCallBack = super.onMiscCallBack(str, bundle);
            AppMethodBeat.m2505o(8732);
            return onMiscCallBack;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$b */
    protected class C29920b extends C7216g {
        protected C29920b() {
            super();
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.m2504i(8733);
            if (GameWebViewUI.this.uDe != null) {
                GameWebViewUI.this.uDe.mo48234a(consoleMessage);
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.m2505o(8733);
            return onConsoleMessage;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$2 */
    class C403122 implements C14617c {
        C403122() {
        }

        /* renamed from: f */
        public final void mo26874f(MenuItem menuItem) {
            AppMethodBeat.m2504i(8725);
            bbb bbb = (bbb) GameWebViewUI.this.uDZ.get(Integer.valueOf(menuItem.getItemId()));
            if (bbb == null) {
                AppMethodBeat.m2505o(8725);
                return;
            }
            C40265e cYc;
            switch (C22980a.m34855JI(bbb.wkB)) {
                case HVGAME_MENU_ACTION_JUMP_H5:
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", bbb.wkC);
                    C25985d.m41467b(GameWebViewUI.this.mController.ylL, "webview", ".ui.tools.game.GameWebViewUI", intent);
                    AppMethodBeat.m2505o(8725);
                    return;
                case HVGAME_MENU_ACTION_EXIT:
                    cYc = GameWebViewUI.this.ulI.cYc();
                    cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(32), Integer.valueOf(1)};
                    cYc.mo63622b(GameWebViewUI.this.icy);
                    if (!GameWebViewUI.m69141o(GameWebViewUI.this)) {
                        GameWebViewUI.this.finish();
                        AppMethodBeat.m2505o(8725);
                        return;
                    }
                    break;
                case HVGAME_MENU_ACTION_SHARE_TO_FRIEND:
                    String stringExtra = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
                    String stringExtra2 = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
                    String stringExtra3 = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
                    C40265e cYc2 = GameWebViewUI.this.ulI.cYc();
                    cYc2.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                    cYc2.mo63622b(GameWebViewUI.this.icy);
                    GameWebViewUI.this.uvr = GameWebViewUI.this.icz.cZT().dmm();
                    GameWebViewUI.m69145s(GameWebViewUI.this);
                    AppMethodBeat.m2505o(8725);
                    return;
                case HVGAME_MENU_ACTION_COLLECT:
                    cYc = GameWebViewUI.this.ulI.cYc();
                    cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(3), Integer.valueOf(1)};
                    cYc.mo63622b(GameWebViewUI.this.icy);
                    C7060h.pYm.mo8378a(157, 6, 1, false);
                    GameWebViewUI.this.uvr = GameWebViewUI.this.icz.cZT().dmm();
                    GameWebViewUI.m69149w(GameWebViewUI.this);
                    AppMethodBeat.m2505o(8725);
                    return;
                case HVGAME_MENU_ACTION_REFRESH:
                    cYc = GameWebViewUI.this.ulI.cYc();
                    cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(10), Integer.valueOf(1)};
                    cYc.mo63622b(GameWebViewUI.this.icy);
                    if (GameWebViewUI.this.pzf != null) {
                        GameWebViewUI.this.pzf.reload();
                        AppMethodBeat.m2505o(8725);
                        return;
                    }
                    break;
                case HVGAME_MENU_ACTION_ADD_TO_DESKTOP:
                    cYc = GameWebViewUI.this.ulI.cYc();
                    cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(31), Integer.valueOf(1)};
                    cYc.mo63622b(GameWebViewUI.this.icy);
                    GameWebViewUI.m69106D(GameWebViewUI.this);
                    AppMethodBeat.m2505o(8725);
                    return;
                case HVGAME_MENU_ACTION_COMPLAINT:
                    cYc = GameWebViewUI.this.ulI.cYc();
                    cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(11), Integer.valueOf(1)};
                    cYc.mo63622b(GameWebViewUI.this.icy);
                    GameWebViewUI.m69109G(GameWebViewUI.this);
                    AppMethodBeat.m2505o(8725);
                    return;
                case HVGAME_MENU_ACTION_CUSTOM:
                    if (GameWebViewUI.this.uhz != null) {
                        C44786d I = GameWebViewUI.this.uhz;
                        int i = bbb.wFQ;
                        C4990ab.m7416i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
                        HashMap hashMap = new HashMap();
                        hashMap.put("itemId", Integer.valueOf(i));
                        C5004al.m7441d(new C4398264(C23124a.m35500b("onCustomGameMenuClicked", hashMap, I.uFv, I.uFw)));
                        break;
                    }
                    break;
            }
            AppMethodBeat.m2505o(8725);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$3 */
    class C403133 implements C46439b {
        C403133() {
        }

        /* renamed from: a */
        public final void mo36295a(C44273l c44273l) {
            AppMethodBeat.m2504i(8726);
            C7060h.pYm.mo8378a(480, 0, 1, false);
            C44273l J = GameWebViewUI.m69112J(GameWebViewUI.this);
            if (J != null) {
                c44273l.yvT.addAll(J.yvT);
            }
            AppMethodBeat.m2505o(8726);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public GameWebViewUI() {
        AppMethodBeat.m2504i(8740);
        AppMethodBeat.m2505o(8740);
    }

    /* renamed from: D */
    static /* synthetic */ void m69106D(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8772);
        gameWebViewUI.cZR();
        AppMethodBeat.m2505o(8772);
    }

    /* renamed from: G */
    static /* synthetic */ void m69109G(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8773);
        gameWebViewUI.afG(null);
        AppMethodBeat.m2505o(8773);
    }

    /* renamed from: J */
    static /* synthetic */ C44273l m69112J(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8774);
        C44273l dca = gameWebViewUI.dca();
        AppMethodBeat.m2505o(8774);
        return dca;
    }

    /* renamed from: c */
    static /* synthetic */ void m69128c(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8765);
        gameWebViewUI.dcc();
        AppMethodBeat.m2505o(8765);
    }

    /* renamed from: o */
    static /* synthetic */ boolean m69141o(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8769);
        boolean cWG = gameWebViewUI.cWG();
        AppMethodBeat.m2505o(8769);
        return cWG;
    }

    /* renamed from: s */
    static /* synthetic */ void m69145s(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8770);
        gameWebViewUI.clH();
        AppMethodBeat.m2505o(8770);
    }

    /* renamed from: w */
    static /* synthetic */ void m69149w(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8771);
        gameWebViewUI.cZO();
        AppMethodBeat.m2505o(8771);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.m2504i(8741);
        final String stringExtra = getIntent().getStringExtra("rawUrl");
        C4990ab.m7417i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", C30022d.aif(stringExtra), C30022d.aid(stringExtra));
        if (getIntent().getLongExtra("gamecenterui_createtime", 0) > 0) {
            this.mUN = GameWebPerformanceInfo.m63878kU(stringExtra);
        } else {
            this.mUN = GameWebPerformanceInfo.m63879kV(stringExtra);
        }
        this.mUN.url = stringExtra;
        this.mUN.eBJ = (hashCode() & BaseClientBuilder.API_PRIORITY_OTHER) + "_" + (cWL().hashCode() & BaseClientBuilder.API_PRIORITY_OTHER);
        this.mUN.eBT = getIntent().getLongExtra("gamecenterui_createtime", 0);
        this.mUN.eBU = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        this.mUN.startTime = getIntent().getLongExtra("start_time", this.mUN.eBU);
        this.mUN.eBZ = System.currentTimeMillis();
        this.mUN.eBN = 1;
        C4990ab.m7417i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", Long.valueOf(this.mUN.startTime), Long.valueOf(this.mUN.eBT), Long.valueOf(this.mUN.eBU), Long.valueOf(this.mUN.eBZ));
        this.mVc = C43963g.agg(stringExtra);
        this.mVc.startTime = System.currentTimeMillis();
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("disable_progress_bar", false)) {
            this.uuX.iUj = false;
            dcb();
        }
        this.pzf.setWebViewClient(new C14609c(this, (byte) 0));
        if (this.pzf.getIsX5Kernel()) {
            this.pzf.setWebViewClientExtension(new C29919a(this));
        }
        this.uDe = new C30003c();
        this.uDe.uVC = new C46472b() {

            /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.GameWebViewUI$1$1 */
            class C403111 implements Runnable {
                C403111() {
                }

                public final void run() {
                    AppMethodBeat.m2504i(8720);
                    if (GameWebViewUI.this.mUP) {
                        GameWebViewUI.m69131e(GameWebViewUI.this);
                    }
                    AppMethodBeat.m2505o(8720);
                }
            }

            public final void bDB() {
                AppMethodBeat.m2504i(8722);
                C4990ab.m7416i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
                GameWebViewUI.this.uEg = true;
                if (GameWebViewUI.this.uEf) {
                    GameWebViewUI.m69128c(GameWebViewUI.this);
                }
                AppMethodBeat.m2505o(8722);
            }

            public final void bDC() {
                AppMethodBeat.m2504i(8723);
                if (!GameWebViewUI.this.mUP) {
                    GameWebViewUI.this.mUP = true;
                    GameWebViewUI.this.handler.postDelayed(new C403111(), 1000);
                }
                AppMethodBeat.m2505o(8723);
            }

            /* renamed from: hL */
            public final void mo7567hL(final boolean z) {
                AppMethodBeat.m2504i(8724);
                GameWebViewUI.this.handler.post(new Runnable() {
                    public final void run() {
                        boolean z = false;
                        AppMethodBeat.m2504i(8721);
                        if (GameWebViewUI.this.mUP) {
                            GameWebViewUI.this.mUP = false;
                            GameWebViewUI.m69133g(GameWebViewUI.this);
                            if (z) {
                                GameWebViewUI.this.pzf.stopLoading();
                                C30003c j = GameWebViewUI.this.uDe;
                                String str = stringExtra;
                                if (!GameWebViewUI.this.uEe) {
                                    z = true;
                                }
                                j.mo48237bO(str, z);
                                GameWebViewUI.m69123a(GameWebViewUI.this, stringExtra);
                            }
                        }
                        AppMethodBeat.m2505o(8721);
                    }
                });
                AppMethodBeat.m2505o(8724);
            }
        };
        this.uEe = getIntent().getBooleanExtra("open_game_float", false);
        C30003c c30003c = this.uDe;
        if (!this.uEe) {
            z = true;
        }
        if (c30003c.mo48237bO(stringExtra, z)) {
            C4990ab.m7416i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
            this.uEd = true;
            dcb();
        }
        this.uEb = new GameMenuImageButton(this.mController.ylL);
        AppMethodBeat.m2505o(8741);
    }

    public final synchronized C6031l dal() {
        C6031l c6031l;
        AppMethodBeat.m2504i(8742);
        if (this.uvO == null) {
            this.uvO = new C29920b();
        }
        c6031l = this.uvO;
        AppMethodBeat.m2505o(8742);
        return c6031l;
    }

    private C44273l dca() {
        AppMethodBeat.m2504i(8743);
        try {
            List<bbb> list = C40316a.uEt;
            new Bundle().putString("game_hv_menu_appid", this.uEa);
            this.uDZ.clear();
            for (bbb bbb : list) {
                this.uDZ.put(Integer.valueOf(bbb.wFQ), bbb);
            }
            C44273l c = C40318c.m69161c(this, list);
            AppMethodBeat.m2505o(8743);
            return c;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", e.getMessage());
            AppMethodBeat.m2505o(8743);
            return null;
        }
    }

    public final void cZM() {
        AppMethodBeat.m2504i(8744);
        if (this.uwI.utH) {
            this.uwI.cZL();
        }
        if (this.uEb == null || !this.uEb.uEu) {
            super.cZM();
            AppMethodBeat.m2505o(8744);
            return;
        }
        final C46442d c46442d = new C46442d(this.mController.ylL);
        c46442d.mo74657a(new C403122());
        c46442d.uEJ = new C403133();
        if (this.uvf) {
            c46442d.uEO = true;
            c46442d.uEP = true;
        } else {
            c46442d.uEO = false;
            c46442d.uEP = false;
        }
        if (this.uvj == null || !this.uvj.isShown()) {
            aqX();
            C5004al.m7442n(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(8728);
                    if (GameWebViewUI.this.isFinishing() || GameWebViewUI.this.uwA) {
                        C4990ab.m7416i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                        AppMethodBeat.m2505o(8728);
                        return;
                    }
                    c46442d.cpD();
                    AppMethodBeat.m2505o(8728);
                }
            }, 100);
            AppMethodBeat.m2505o(8744);
            return;
        }
        this.uvj.hide();
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(8727);
                if (GameWebViewUI.this.isFinishing() || GameWebViewUI.this.uwA) {
                    C4990ab.m7416i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                    AppMethodBeat.m2505o(8727);
                    return;
                }
                c46442d.cpD();
                AppMethodBeat.m2505o(8727);
            }
        }, 100);
        AppMethodBeat.m2505o(8744);
    }

    /* renamed from: dE */
    public final void mo30984dE(String str, int i) {
        AppMethodBeat.m2504i(8745);
        super.mo30984dE(str, i);
        AppMethodBeat.m2505o(8745);
    }

    public final int cWF() {
        AppMethodBeat.m2504i(8746);
        int cWF = super.cWF();
        AppMethodBeat.m2505o(8746);
        return cWF;
    }

    /* renamed from: ac */
    public final void mo30958ac(Bundle bundle) {
        AppMethodBeat.m2504i(8747);
        super.mo30958ac(bundle);
        AppMethodBeat.m2505o(8747);
    }

    public final void aMh() {
        boolean z;
        AppMethodBeat.m2504i(8748);
        super.aMh();
        this.uEc = true;
        if (!this.mTC && this.nft == null && this.nfs == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            C39197dd bDg = C45985a.bDg();
            if (!(bDg == null || C5046bo.isNullOrNil(bDg.color))) {
                try {
                    this.nfs = Color.parseColor(bDg.color);
                } catch (IllegalArgumentException e) {
                    C4990ab.m7412e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + e.getMessage());
                }
                this.nft = bDg.mYo;
                dad();
                mo31012nO(true);
            }
        }
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("game_check_float", false)) {
            int intExtra = intent.getIntExtra("game_sourceScene", 0);
            this.uDY = intent.getStringExtra("game_transparent_float_url");
            if (C5046bo.isNullOrNil(this.uDY)) {
                intent = new Intent();
                intent.putExtra("game_check_float", true);
                intent.putExtra("game_sourceScene", intExtra);
                C25985d.m41467b((Context) this, "game", ".ui.GameCenterUI", intent);
                AppMethodBeat.m2505o(8748);
                return;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("game_sourceScene", intExtra);
                if (this.icy != null) {
                    this.icy.mo15575g(91, bundle);
                }
                if (this.uCU == null) {
                    this.uCU = new C22971a(this, this.uvd, this.uDY);
                }
                C22971a c22971a = this.uCU;
                String str = this.uDY;
                c22971a.mUH = str;
                c22971a.uDe.mo48237bO(str, false);
                if (c22971a.fow != null && c22971a.fow.getParent() == null) {
                    c22971a.f4405SW.addView(c22971a.fow, new LayoutParams(-1, -1));
                }
                if (!(c22971a.fow == null || c22971a.uDf == null)) {
                    c22971a.fow.post(new C229723(str));
                }
                this.uDY = null;
                AppMethodBeat.m2505o(8748);
                return;
            } catch (RemoteException e2) {
            }
        }
        AppMethodBeat.m2505o(8748);
    }

    /* renamed from: nO */
    public final void mo31012nO(boolean z) {
        AppMethodBeat.m2504i(8749);
        super.mo31012nO(z);
        mo31014nR(false);
        AppMethodBeat.m2505o(8749);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.m2504i(8750);
        if (this.uEc) {
            super.addIconOptionMenu(i, i2, onMenuItemClickListener);
        }
        AppMethodBeat.m2505o(8750);
    }

    public void onResume() {
        AppMethodBeat.m2504i(8751);
        super.onResume();
        if (this.mUN.eCa == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7416i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(currentTimeMillis)));
            this.mUN.eCa = currentTimeMillis;
        }
        this.mUZ = System.currentTimeMillis();
        AppMethodBeat.m2505o(8751);
    }

    public void onPause() {
        AppMethodBeat.m2504i(8752);
        super.onPause();
        GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
        gameWebPerformanceInfo.eCj += System.currentTimeMillis() - this.mUZ;
        AppMethodBeat.m2505o(8752);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(8753);
        super.onDestroy();
        this.uDe.mo48243ot(this.uEe);
        this.mUN.eCk = System.currentTimeMillis();
        C37860c.eBG.mo60577a(this.mUN);
        GameWebPerformanceInfo.m63880kW(cWL());
        C43961e.agf(this.cOG);
        C43963g.agi(this.cOG);
        AppMethodBeat.m2505o(8753);
    }

    public final int getLayoutId() {
        AppMethodBeat.m2504i(8754);
        this.mUN.eCb = System.currentTimeMillis();
        int layoutId = super.getLayoutId();
        AppMethodBeat.m2505o(8754);
        return layoutId;
    }

    public void initView() {
        AppMethodBeat.m2504i(8755);
        super.initView();
        this.uDW = new ColorDrawable(C0380b.m652i(this, C25738R.color.f11700dy));
        this.uDX = new ColorDrawable(C0380b.m652i(this, C25738R.color.f11700dy));
        this.mUN.eCc = System.currentTimeMillis();
        this.mVc.uDL = System.currentTimeMillis();
        AppMethodBeat.m2505o(8755);
    }

    public final void dak() {
        AppMethodBeat.m2504i(8756);
        super.dak();
        this.uEa = getIntent().getStringExtra("game_hv_menu_appid");
        if (this.uvf && !C5046bo.isNullOrNil(this.uEa)) {
            if (this.uve != null) {
                this.uve.setVisibility(8);
            }
            this.uEb.mo26872a(this.uvc, new C299176());
        }
        AppMethodBeat.m2505o(8756);
    }

    public final boolean afI(String str) {
        AppMethodBeat.m2504i(8757);
        boolean ahB = this.uDe.ahB(str);
        AppMethodBeat.m2505o(8757);
        return ahB;
    }

    /* renamed from: b */
    public final void mo30970b(String str, Map<String, String> map, boolean z) {
        AppMethodBeat.m2504i(8758);
        if (this.mUN.eCe == 0) {
            this.mUN.eCe = System.currentTimeMillis();
        }
        if (this.uDe.dgi()) {
            super.mo30970b(str, (Map) map, false);
            AppMethodBeat.m2505o(8758);
            return;
        }
        super.mo30970b(str, (Map) map, z);
        AppMethodBeat.m2505o(8758);
    }

    public final void aBS() {
        AppMethodBeat.m2504i(8759);
        if (VERSION.SDK_INT <= 10) {
            super.aBS();
            AppMethodBeat.m2505o(8759);
        } else if (getForceOrientation() == -1) {
            this.ylk = getSharedPreferences(C4996ah.doA(), 4).getBoolean("settings_landscape_mode", false);
            if (this.ylk) {
                setRequestedOrientation(2);
                AppMethodBeat.m2505o(8759);
                return;
            }
            setRequestedOrientation(1);
            AppMethodBeat.m2505o(8759);
        } else {
            setRequestedOrientation(getForceOrientation());
            AppMethodBeat.m2505o(8759);
        }
    }

    /* renamed from: as */
    public final C16953w mo30966as(String str, boolean z) {
        AppMethodBeat.m2504i(8760);
        if (this.mUN.eCh == 0) {
            this.mUN.eCh = System.currentTimeMillis();
        }
        if (this.mVc.uDO == 0) {
            this.mVc.uDO = System.currentTimeMillis();
        }
        C16953w as = super.mo30966as(str, z);
        AppMethodBeat.m2505o(8760);
        return as;
    }

    public final void daw() {
        AppMethodBeat.m2504i(8761);
        if (this.mUN.eCi == 0) {
            this.mUN.eCi = System.currentTimeMillis();
        }
        if (this.mVc.uDP == 0) {
            this.mVc.uDP = System.currentTimeMillis();
        }
        this.uEf = true;
        if (this.uEg) {
            dcc();
        }
        AppMethodBeat.m2505o(8761);
    }

    private void dcb() {
        AppMethodBeat.m2504i(8762);
        if (this.uuY != null) {
            this.uuY.setVisibility(0);
        }
        AppMethodBeat.m2505o(8762);
    }

    public boolean aYc() {
        AppMethodBeat.m2504i(8763);
        getIntent().putExtra("minimize_secene", 2);
        AppMethodBeat.m2505o(8763);
        return true;
    }

    private void dcc() {
        AppMethodBeat.m2504i(8764);
        this.uEf = false;
        this.uEg = false;
        C5004al.m7442n(new C146087(), 100);
        AppMethodBeat.m2505o(8764);
    }

    /* renamed from: e */
    static /* synthetic */ void m69131e(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8766);
        synchronized (gameWebViewUI.mUQ) {
            try {
                if (gameWebViewUI.uvd != null && gameWebViewUI.mUP) {
                    gameWebViewUI.mUO = new FrameLayout(gameWebViewUI);
                    gameWebViewUI.mUO.setClickable(true);
                    gameWebViewUI.uvd.addView(gameWebViewUI.mUO, new FrameLayout.LayoutParams(-1, -1));
                    gameWebViewUI.mUO.addView(LayoutInflater.from(gameWebViewUI).inflate(2130969941, gameWebViewUI.uvd, false), new FrameLayout.LayoutParams(-2, -2, 17));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(8766);
            }
        }
    }

    /* renamed from: g */
    static /* synthetic */ void m69133g(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8767);
        synchronized (gameWebViewUI.mUQ) {
            try {
                if (!(gameWebViewUI.uvd == null || gameWebViewUI.mUO == null)) {
                    gameWebViewUI.uvd.removeView(gameWebViewUI.mUO);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(8767);
            }
        }
    }

    /* renamed from: O */
    static /* synthetic */ void m69117O(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.m2504i(8775);
        if (gameWebViewUI.uuY != null) {
            gameWebViewUI.uuY.setVisibility(8);
        }
        AppMethodBeat.m2505o(8775);
    }
}
