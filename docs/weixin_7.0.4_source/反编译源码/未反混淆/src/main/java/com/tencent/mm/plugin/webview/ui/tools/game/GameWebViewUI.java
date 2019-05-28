package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.widget.FrameLayout;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.model.aq.e;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.w;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d.AnonymousClass64;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameWebViewUI extends GameBaseWebViewUI {
    private static String uDU = "wx_fullscreen";
    private boolean mTC = false;
    public GameWebPerformanceInfo mUN;
    private ViewGroup mUO;
    private boolean mUP = false;
    private Object mUQ = new Object();
    private long mUZ;
    public g mVc;
    private boolean uDT = false;
    private HashMap<String, String> uDV = new HashMap();
    private Drawable uDW;
    private Drawable uDX;
    private String uDY = null;
    private Map<Integer, bbb> uDZ = new HashMap();
    public com.tencent.mm.plugin.wepkg.c uDe;
    private String uEa;
    private GameMenuImageButton uEb;
    private boolean uEc;
    private boolean uEd = false;
    private boolean uEe;
    private boolean uEf = false;
    private boolean uEg = false;

    class c extends a {
        private c() {
            super();
        }

        /* synthetic */ c(GameWebViewUI gameWebViewUI, byte b) {
            this();
        }

        public final void b(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(8734);
            if (GameWebViewUI.this.mUN.eCf == 0) {
                GameWebViewUI.this.mUN.eCf = System.currentTimeMillis();
            }
            if (GameWebViewUI.this.mVc.uDM == 0) {
                GameWebViewUI.this.mVc.uDM = System.currentTimeMillis();
            }
            GameWebViewUI.this.uDe.j(webView, str);
            super.b(webView, str, bitmap);
            AppMethodBeat.o(8734);
        }

        public final void b(WebView webView, String str) {
            AppMethodBeat.i(8735);
            if (GameWebViewUI.this.mUN.eCg == 0) {
                GameWebViewUI.this.mUN.eCg = System.currentTimeMillis();
            }
            if (GameWebViewUI.this.mVc.uDN == 0) {
                GameWebViewUI.this.mVc.uDN = System.currentTimeMillis();
            }
            GameWebViewUI.O(GameWebViewUI.this);
            GameWebViewUI.this.uDe.k(webView, str);
            super.b(webView, str);
            AppMethodBeat.o(8735);
        }

        public final void a(WebView webView, int i, String str, String str2) {
            AppMethodBeat.i(8736);
            GameWebViewUI.O(GameWebViewUI.this);
            super.a(webView, i, str, str2);
            AppMethodBeat.o(8736);
        }

        public final o c(WebView webView, String str) {
            AppMethodBeat.i(8737);
            o ahA = GameWebViewUI.this.uDe.ahA(str);
            if (ahA != null) {
                AppMethodBeat.o(8737);
                return ahA;
            }
            ahA = super.c(webView, str);
            AppMethodBeat.o(8737);
            return ahA;
        }

        public final o a(WebView webView, n nVar) {
            AppMethodBeat.i(8738);
            o a;
            if (nVar == null || nVar.getUrl() == null) {
                a = super.a(webView, nVar);
                AppMethodBeat.o(8738);
                return a;
            }
            a = GameWebViewUI.this.uDe.ahA(nVar.getUrl().toString());
            if (a != null) {
                AppMethodBeat.o(8738);
                return a;
            }
            a = super.a(webView, nVar);
            AppMethodBeat.o(8738);
            return a;
        }

        public final o a(WebView webView, n nVar, Bundle bundle) {
            AppMethodBeat.i(8739);
            o a;
            if (nVar == null || nVar.getUrl() == null) {
                a = super.a(webView, nVar);
                AppMethodBeat.o(8739);
                return a;
            }
            a = GameWebViewUI.this.uDe.ahA(nVar.getUrl().toString());
            if (a != null) {
                AppMethodBeat.o(8739);
                return a;
            }
            a = super.a(webView, nVar, bundle);
            AppMethodBeat.o(8739);
            return a;
        }
    }

    class a extends com.tencent.mm.plugin.webview.ui.tools.c {
        public a(WebViewUI webViewUI) {
            super(webViewUI);
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.i(8732);
            Object onMiscCallBack = GameWebViewUI.this.uDe.onMiscCallBack(str, bundle);
            if (onMiscCallBack != null) {
                AppMethodBeat.o(8732);
                return onMiscCallBack;
            }
            onMiscCallBack = super.onMiscCallBack(str, bundle);
            AppMethodBeat.o(8732);
            return onMiscCallBack;
        }
    }

    protected class b extends g {
        protected b() {
            super();
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.i(8733);
            if (GameWebViewUI.this.uDe != null) {
                GameWebViewUI.this.uDe.a(consoleMessage);
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(8733);
            return onConsoleMessage;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public GameWebViewUI() {
        AppMethodBeat.i(8740);
        AppMethodBeat.o(8740);
    }

    static /* synthetic */ void D(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8772);
        gameWebViewUI.cZR();
        AppMethodBeat.o(8772);
    }

    static /* synthetic */ void G(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8773);
        gameWebViewUI.afG(null);
        AppMethodBeat.o(8773);
    }

    static /* synthetic */ l J(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8774);
        l dca = gameWebViewUI.dca();
        AppMethodBeat.o(8774);
        return dca;
    }

    static /* synthetic */ void c(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8765);
        gameWebViewUI.dcc();
        AppMethodBeat.o(8765);
    }

    static /* synthetic */ boolean o(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8769);
        boolean cWG = gameWebViewUI.cWG();
        AppMethodBeat.o(8769);
        return cWG;
    }

    static /* synthetic */ void s(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8770);
        gameWebViewUI.clH();
        AppMethodBeat.o(8770);
    }

    static /* synthetic */ void w(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8771);
        gameWebViewUI.cZO();
        AppMethodBeat.o(8771);
    }

    public void onCreate(Bundle bundle) {
        boolean z = false;
        AppMethodBeat.i(8741);
        final String stringExtra = getIntent().getStringExtra("rawUrl");
        ab.i("MicroMsg.Wepkg.GameWebViewUI", "rawUrl rid:%s, pkgId:%s", d.aif(stringExtra), d.aid(stringExtra));
        if (getIntent().getLongExtra("gamecenterui_createtime", 0) > 0) {
            this.mUN = GameWebPerformanceInfo.kU(stringExtra);
        } else {
            this.mUN = GameWebPerformanceInfo.kV(stringExtra);
        }
        this.mUN.url = stringExtra;
        this.mUN.eBJ = (hashCode() & BaseClientBuilder.API_PRIORITY_OTHER) + "_" + (cWL().hashCode() & BaseClientBuilder.API_PRIORITY_OTHER);
        this.mUN.eBT = getIntent().getLongExtra("gamecenterui_createtime", 0);
        this.mUN.eBU = getIntent().getLongExtra("start_activity_time", System.currentTimeMillis());
        this.mUN.startTime = getIntent().getLongExtra("start_time", this.mUN.eBU);
        this.mUN.eBZ = System.currentTimeMillis();
        this.mUN.eBN = 1;
        ab.i("MicroMsg.Wepkg.GameWebViewUI", "onCreate, startTime: %d, gameCenterUICreate: %d, startWebUI: %d,webUICreate: %d", Long.valueOf(this.mUN.startTime), Long.valueOf(this.mUN.eBT), Long.valueOf(this.mUN.eBU), Long.valueOf(this.mUN.eBZ));
        this.mVc = g.agg(stringExtra);
        this.mVc.startTime = System.currentTimeMillis();
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("disable_progress_bar", false)) {
            this.uuX.iUj = false;
            dcb();
        }
        this.pzf.setWebViewClient(new c(this, (byte) 0));
        if (this.pzf.getIsX5Kernel()) {
            this.pzf.setWebViewClientExtension(new a(this));
        }
        this.uDe = new com.tencent.mm.plugin.wepkg.c();
        this.uDe.uVC = new com.tencent.mm.plugin.wepkg.event.b() {
            public final void bDB() {
                AppMethodBeat.i(8722);
                ab.i("MicroMsg.Wepkg.GameWebViewUI", "onReload");
                GameWebViewUI.this.uEg = true;
                if (GameWebViewUI.this.uEf) {
                    GameWebViewUI.c(GameWebViewUI.this);
                }
                AppMethodBeat.o(8722);
            }

            public final void bDC() {
                AppMethodBeat.i(8723);
                if (!GameWebViewUI.this.mUP) {
                    GameWebViewUI.this.mUP = true;
                    GameWebViewUI.this.handler.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8720);
                            if (GameWebViewUI.this.mUP) {
                                GameWebViewUI.e(GameWebViewUI.this);
                            }
                            AppMethodBeat.o(8720);
                        }
                    }, 1000);
                }
                AppMethodBeat.o(8723);
            }

            public final void hL(final boolean z) {
                AppMethodBeat.i(8724);
                GameWebViewUI.this.handler.post(new Runnable() {
                    public final void run() {
                        boolean z = false;
                        AppMethodBeat.i(8721);
                        if (GameWebViewUI.this.mUP) {
                            GameWebViewUI.this.mUP = false;
                            GameWebViewUI.g(GameWebViewUI.this);
                            if (z) {
                                GameWebViewUI.this.pzf.stopLoading();
                                com.tencent.mm.plugin.wepkg.c j = GameWebViewUI.this.uDe;
                                String str = stringExtra;
                                if (!GameWebViewUI.this.uEe) {
                                    z = true;
                                }
                                j.bO(str, z);
                                GameWebViewUI.a(GameWebViewUI.this, stringExtra);
                            }
                        }
                        AppMethodBeat.o(8721);
                    }
                });
                AppMethodBeat.o(8724);
            }
        };
        this.uEe = getIntent().getBooleanExtra("open_game_float", false);
        com.tencent.mm.plugin.wepkg.c cVar = this.uDe;
        if (!this.uEe) {
            z = true;
        }
        if (cVar.bO(stringExtra, z)) {
            ab.i("MicroMsg.Wepkg.GameWebViewUI", "current page use wepkg");
            this.uEd = true;
            dcb();
        }
        this.uEb = new GameMenuImageButton(this.mController.ylL);
        AppMethodBeat.o(8741);
    }

    public final synchronized com.tencent.xweb.l dal() {
        com.tencent.xweb.l lVar;
        AppMethodBeat.i(8742);
        if (this.uvO == null) {
            this.uvO = new b();
        }
        lVar = this.uvO;
        AppMethodBeat.o(8742);
        return lVar;
    }

    private l dca() {
        AppMethodBeat.i(8743);
        try {
            List<bbb> list = com.tencent.mm.plugin.webview.ui.tools.game.menu.a.uEt;
            new Bundle().putString("game_hv_menu_appid", this.uEa);
            this.uDZ.clear();
            for (bbb bbb : list) {
                this.uDZ.put(Integer.valueOf(bbb.wFQ), bbb);
            }
            l c = com.tencent.mm.plugin.webview.ui.tools.game.menu.c.c(this, list);
            AppMethodBeat.o(8743);
            return c;
        } catch (Exception e) {
            ab.e("MicroMsg.Wepkg.GameWebViewUI", "get cache hv game menu fail! exception:%s", e.getMessage());
            AppMethodBeat.o(8743);
            return null;
        }
    }

    public final void cZM() {
        AppMethodBeat.i(8744);
        if (this.uwI.utH) {
            this.uwI.cZL();
        }
        if (this.uEb == null || !this.uEb.uEu) {
            super.cZM();
            AppMethodBeat.o(8744);
            return;
        }
        final com.tencent.mm.plugin.webview.ui.tools.game.menu.d dVar = new com.tencent.mm.plugin.webview.ui.tools.game.menu.d(this.mController.ylL);
        dVar.a(new com.tencent.mm.plugin.webview.ui.tools.game.menu.b.c() {
            public final void f(MenuItem menuItem) {
                AppMethodBeat.i(8725);
                bbb bbb = (bbb) GameWebViewUI.this.uDZ.get(Integer.valueOf(menuItem.getItemId()));
                if (bbb == null) {
                    AppMethodBeat.o(8725);
                    return;
                }
                e cYc;
                switch (com.tencent.mm.plugin.webview.ui.tools.game.menu.c.a.JI(bbb.wkB)) {
                    case HVGAME_MENU_ACTION_JUMP_H5:
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", bbb.wkC);
                        com.tencent.mm.bp.d.b(GameWebViewUI.this.mController.ylL, "webview", ".ui.tools.game.GameWebViewUI", intent);
                        AppMethodBeat.o(8725);
                        return;
                    case HVGAME_MENU_ACTION_EXIT:
                        cYc = GameWebViewUI.this.ulI.cYc();
                        cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(32), Integer.valueOf(1)};
                        cYc.b(GameWebViewUI.this.icy);
                        if (!GameWebViewUI.o(GameWebViewUI.this)) {
                            GameWebViewUI.this.finish();
                            AppMethodBeat.o(8725);
                            return;
                        }
                        break;
                    case HVGAME_MENU_ACTION_SHARE_TO_FRIEND:
                        String stringExtra = GameWebViewUI.this.getIntent().getStringExtra("KPublisherId");
                        String stringExtra2 = GameWebViewUI.this.getIntent().getStringExtra("KAppId");
                        String stringExtra3 = GameWebViewUI.this.getIntent().getStringExtra("srcUsername");
                        e cYc2 = GameWebViewUI.this.ulI.cYc();
                        cYc2.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(1), Integer.valueOf(1), stringExtra, stringExtra2, stringExtra3};
                        cYc2.b(GameWebViewUI.this.icy);
                        GameWebViewUI.this.uvr = GameWebViewUI.this.icz.cZT().dmm();
                        GameWebViewUI.s(GameWebViewUI.this);
                        AppMethodBeat.o(8725);
                        return;
                    case HVGAME_MENU_ACTION_COLLECT:
                        cYc = GameWebViewUI.this.ulI.cYc();
                        cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(3), Integer.valueOf(1)};
                        cYc.b(GameWebViewUI.this.icy);
                        h.pYm.a(157, 6, 1, false);
                        GameWebViewUI.this.uvr = GameWebViewUI.this.icz.cZT().dmm();
                        GameWebViewUI.w(GameWebViewUI.this);
                        AppMethodBeat.o(8725);
                        return;
                    case HVGAME_MENU_ACTION_REFRESH:
                        cYc = GameWebViewUI.this.ulI.cYc();
                        cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(10), Integer.valueOf(1)};
                        cYc.b(GameWebViewUI.this.icy);
                        if (GameWebViewUI.this.pzf != null) {
                            GameWebViewUI.this.pzf.reload();
                            AppMethodBeat.o(8725);
                            return;
                        }
                        break;
                    case HVGAME_MENU_ACTION_ADD_TO_DESKTOP:
                        cYc = GameWebViewUI.this.ulI.cYc();
                        cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(31), Integer.valueOf(1)};
                        cYc.b(GameWebViewUI.this.icy);
                        GameWebViewUI.D(GameWebViewUI.this);
                        AppMethodBeat.o(8725);
                        return;
                    case HVGAME_MENU_ACTION_COMPLAINT:
                        cYc = GameWebViewUI.this.ulI.cYc();
                        cYc.une = new Object[]{GameWebViewUI.this.cOG, Integer.valueOf(11), Integer.valueOf(1)};
                        cYc.b(GameWebViewUI.this.icy);
                        GameWebViewUI.G(GameWebViewUI.this);
                        AppMethodBeat.o(8725);
                        return;
                    case HVGAME_MENU_ACTION_CUSTOM:
                        if (GameWebViewUI.this.uhz != null) {
                            com.tencent.mm.plugin.webview.ui.tools.jsapi.d I = GameWebViewUI.this.uhz;
                            int i = bbb.wFQ;
                            ab.i("MicroMsg.JsApiHandler", "onCustomGameMenuClicked");
                            HashMap hashMap = new HashMap();
                            hashMap.put("itemId", Integer.valueOf(i));
                            al.d(new AnonymousClass64(com.tencent.mm.plugin.webview.ui.tools.jsapi.i.a.b("onCustomGameMenuClicked", hashMap, I.uFv, I.uFw)));
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(8725);
            }
        });
        dVar.uEJ = new com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b() {
            public final void a(l lVar) {
                AppMethodBeat.i(8726);
                h.pYm.a(480, 0, 1, false);
                l J = GameWebViewUI.J(GameWebViewUI.this);
                if (J != null) {
                    lVar.yvT.addAll(J.yvT);
                }
                AppMethodBeat.o(8726);
            }
        };
        if (this.uvf) {
            dVar.uEO = true;
            dVar.uEP = true;
        } else {
            dVar.uEO = false;
            dVar.uEP = false;
        }
        if (this.uvj == null || !this.uvj.isShown()) {
            aqX();
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(8728);
                    if (GameWebViewUI.this.isFinishing() || GameWebViewUI.this.uwA) {
                        ab.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                        AppMethodBeat.o(8728);
                        return;
                    }
                    dVar.cpD();
                    AppMethodBeat.o(8728);
                }
            }, 100);
            AppMethodBeat.o(8744);
            return;
        }
        this.uvj.hide();
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8727);
                if (GameWebViewUI.this.isFinishing() || GameWebViewUI.this.uwA) {
                    ab.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
                    AppMethodBeat.o(8727);
                    return;
                }
                dVar.cpD();
                AppMethodBeat.o(8727);
            }
        }, 100);
        AppMethodBeat.o(8744);
    }

    public final void dE(String str, int i) {
        AppMethodBeat.i(8745);
        super.dE(str, i);
        AppMethodBeat.o(8745);
    }

    public final int cWF() {
        AppMethodBeat.i(8746);
        int cWF = super.cWF();
        AppMethodBeat.o(8746);
        return cWF;
    }

    public final void ac(Bundle bundle) {
        AppMethodBeat.i(8747);
        super.ac(bundle);
        AppMethodBeat.o(8747);
    }

    public final void aMh() {
        boolean z;
        AppMethodBeat.i(8748);
        super.aMh();
        this.uEc = true;
        if (!this.mTC && this.nft == null && this.nfs == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            dd bDg = com.tencent.mm.plugin.game.commlib.a.bDg();
            if (!(bDg == null || bo.isNullOrNil(bDg.color))) {
                try {
                    this.nfs = Color.parseColor(bDg.color);
                } catch (IllegalArgumentException e) {
                    ab.e("MicroMsg.Wepkg.GameWebViewUI", "parse color: " + e.getMessage());
                }
                this.nft = bDg.mYo;
                dad();
                nO(true);
            }
        }
        Intent intent = getIntent();
        if (intent != null && intent.getBooleanExtra("game_check_float", false)) {
            int intExtra = intent.getIntExtra("game_sourceScene", 0);
            this.uDY = intent.getStringExtra("game_transparent_float_url");
            if (bo.isNullOrNil(this.uDY)) {
                intent = new Intent();
                intent.putExtra("game_check_float", true);
                intent.putExtra("game_sourceScene", intExtra);
                com.tencent.mm.bp.d.b((Context) this, "game", ".ui.GameCenterUI", intent);
                AppMethodBeat.o(8748);
                return;
            }
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("game_sourceScene", intExtra);
                if (this.icy != null) {
                    this.icy.g(91, bundle);
                }
                if (this.uCU == null) {
                    this.uCU = new a(this, this.uvd, this.uDY);
                }
                a aVar = this.uCU;
                String str = this.uDY;
                aVar.mUH = str;
                aVar.uDe.bO(str, false);
                if (aVar.fow != null && aVar.fow.getParent() == null) {
                    aVar.SW.addView(aVar.fow, new LayoutParams(-1, -1));
                }
                if (!(aVar.fow == null || aVar.uDf == null)) {
                    aVar.fow.post(new com.tencent.mm.plugin.webview.ui.tools.game.a.AnonymousClass3(str));
                }
                this.uDY = null;
                AppMethodBeat.o(8748);
                return;
            } catch (RemoteException e2) {
            }
        }
        AppMethodBeat.o(8748);
    }

    public final void nO(boolean z) {
        AppMethodBeat.i(8749);
        super.nO(z);
        nR(false);
        AppMethodBeat.o(8749);
    }

    public final void addIconOptionMenu(int i, int i2, OnMenuItemClickListener onMenuItemClickListener) {
        AppMethodBeat.i(8750);
        if (this.uEc) {
            super.addIconOptionMenu(i, i2, onMenuItemClickListener);
        }
        AppMethodBeat.o(8750);
    }

    public void onResume() {
        AppMethodBeat.i(8751);
        super.onResume();
        if (this.mUN.eCa == 0) {
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.Wepkg.GameWebViewUI", "onResume: ".concat(String.valueOf(currentTimeMillis)));
            this.mUN.eCa = currentTimeMillis;
        }
        this.mUZ = System.currentTimeMillis();
        AppMethodBeat.o(8751);
    }

    public void onPause() {
        AppMethodBeat.i(8752);
        super.onPause();
        GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
        gameWebPerformanceInfo.eCj += System.currentTimeMillis() - this.mUZ;
        AppMethodBeat.o(8752);
    }

    public void onDestroy() {
        AppMethodBeat.i(8753);
        super.onDestroy();
        this.uDe.ot(this.uEe);
        this.mUN.eCk = System.currentTimeMillis();
        com.tencent.mm.game.report.api.c.eBG.a(this.mUN);
        GameWebPerformanceInfo.kW(cWL());
        e.agf(this.cOG);
        g.agi(this.cOG);
        AppMethodBeat.o(8753);
    }

    public final int getLayoutId() {
        AppMethodBeat.i(8754);
        this.mUN.eCb = System.currentTimeMillis();
        int layoutId = super.getLayoutId();
        AppMethodBeat.o(8754);
        return layoutId;
    }

    public void initView() {
        AppMethodBeat.i(8755);
        super.initView();
        this.uDW = new ColorDrawable(android.support.v4.content.b.i(this, R.color.dy));
        this.uDX = new ColorDrawable(android.support.v4.content.b.i(this, R.color.dy));
        this.mUN.eCc = System.currentTimeMillis();
        this.mVc.uDL = System.currentTimeMillis();
        AppMethodBeat.o(8755);
    }

    public final void dak() {
        AppMethodBeat.i(8756);
        super.dak();
        this.uEa = getIntent().getStringExtra("game_hv_menu_appid");
        if (this.uvf && !bo.isNullOrNil(this.uEa)) {
            if (this.uve != null) {
                this.uve.setVisibility(8);
            }
            this.uEb.a(this.uvc, new com.tencent.mm.plugin.webview.ui.tools.game.menu.GameMenuImageButton.a() {
                public final void bDJ() {
                    AppMethodBeat.i(8729);
                    GameWebViewUI.this.cZM();
                    AppMethodBeat.o(8729);
                }
            });
        }
        AppMethodBeat.o(8756);
    }

    public final boolean afI(String str) {
        AppMethodBeat.i(8757);
        boolean ahB = this.uDe.ahB(str);
        AppMethodBeat.o(8757);
        return ahB;
    }

    public final void b(String str, Map<String, String> map, boolean z) {
        AppMethodBeat.i(8758);
        if (this.mUN.eCe == 0) {
            this.mUN.eCe = System.currentTimeMillis();
        }
        if (this.uDe.dgi()) {
            super.b(str, (Map) map, false);
            AppMethodBeat.o(8758);
            return;
        }
        super.b(str, (Map) map, z);
        AppMethodBeat.o(8758);
    }

    public final void aBS() {
        AppMethodBeat.i(8759);
        if (VERSION.SDK_INT <= 10) {
            super.aBS();
            AppMethodBeat.o(8759);
        } else if (getForceOrientation() == -1) {
            this.ylk = getSharedPreferences(ah.doA(), 4).getBoolean("settings_landscape_mode", false);
            if (this.ylk) {
                setRequestedOrientation(2);
                AppMethodBeat.o(8759);
                return;
            }
            setRequestedOrientation(1);
            AppMethodBeat.o(8759);
        } else {
            setRequestedOrientation(getForceOrientation());
            AppMethodBeat.o(8759);
        }
    }

    public final w as(String str, boolean z) {
        AppMethodBeat.i(8760);
        if (this.mUN.eCh == 0) {
            this.mUN.eCh = System.currentTimeMillis();
        }
        if (this.mVc.uDO == 0) {
            this.mVc.uDO = System.currentTimeMillis();
        }
        w as = super.as(str, z);
        AppMethodBeat.o(8760);
        return as;
    }

    public final void daw() {
        AppMethodBeat.i(8761);
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
        AppMethodBeat.o(8761);
    }

    private void dcb() {
        AppMethodBeat.i(8762);
        if (this.uuY != null) {
            this.uuY.setVisibility(0);
        }
        AppMethodBeat.o(8762);
    }

    public boolean aYc() {
        AppMethodBeat.i(8763);
        getIntent().putExtra("minimize_secene", 2);
        AppMethodBeat.o(8763);
        return true;
    }

    private void dcc() {
        AppMethodBeat.i(8764);
        this.uEf = false;
        this.uEg = false;
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8730);
                if (GameWebViewUI.this.pzf != null) {
                    ab.i("MicroMsg.Wepkg.GameWebViewUI", "home page, reload url:%s from net", GameWebViewUI.this.jUg);
                    GameWebViewUI.this.pzf.stopLoading();
                    GameWebViewUI.this.pzf.loadUrl(GameWebViewUI.this.jUg);
                }
                AppMethodBeat.o(8730);
            }
        }, 100);
        AppMethodBeat.o(8764);
    }

    static /* synthetic */ void e(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8766);
        synchronized (gameWebViewUI.mUQ) {
            try {
                if (gameWebViewUI.uvd != null && gameWebViewUI.mUP) {
                    gameWebViewUI.mUO = new FrameLayout(gameWebViewUI);
                    gameWebViewUI.mUO.setClickable(true);
                    gameWebViewUI.uvd.addView(gameWebViewUI.mUO, new FrameLayout.LayoutParams(-1, -1));
                    gameWebViewUI.mUO.addView(LayoutInflater.from(gameWebViewUI).inflate(R.layout.a_3, gameWebViewUI.uvd, false), new FrameLayout.LayoutParams(-2, -2, 17));
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(8766);
            }
        }
    }

    static /* synthetic */ void g(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8767);
        synchronized (gameWebViewUI.mUQ) {
            try {
                if (!(gameWebViewUI.uvd == null || gameWebViewUI.mUO == null)) {
                    gameWebViewUI.uvd.removeView(gameWebViewUI.mUO);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(8767);
            }
        }
    }

    static /* synthetic */ void O(GameWebViewUI gameWebViewUI) {
        AppMethodBeat.i(8775);
        if (gameWebViewUI.uuY != null) {
            gameWebViewUI.uuY.setVisibility(8);
        }
        AppMethodBeat.o(8775);
    }
}
