package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.Constants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.m.e;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.d;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.f;
import com.tencent.mm.plugin.webview.ui.tools.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bd;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.xweb.WebView;
import com.tencent.xweb.n;
import com.tencent.xweb.o;
import java.io.File;
import java.util.Map;

public final class a {
    ViewGroup SW;
    MMWebView fow;
    Context mContext;
    String mUH;
    GameWebPerformanceInfo mUN;
    c mUY = new c() {
        /* Access modifiers changed, original: protected|final */
        public final void I(Bundle bundle) {
            AppMethodBeat.i(8647);
            try {
                if (!(a.this.uzS == null || bundle == null)) {
                    a.this.uzS.g(96, bundle);
                }
                AppMethodBeat.o(8647);
            } catch (RemoteException e) {
                AppMethodBeat.o(8647);
            }
        }
    };
    long mUZ;
    g mVc;
    GameWebViewUI uDb;
    private h uDc;
    d uDd;
    com.tencent.mm.plugin.wepkg.c uDe;
    b uDf;
    private a uDg;
    f uDh;
    private boolean uDi;
    m uDj = new m() {
        public final void W(Bundle bundle) {
            AppMethodBeat.i(8654);
            ab.i("MicroMsg.GameFloatWebView", "closeWindow");
            try {
                a.this.SW.removeView(a.this.fow);
                a.this.onDestroy();
                AppMethodBeat.o(8654);
            } catch (Exception e) {
                AppMethodBeat.o(8654);
            }
        }

        public final Bundle g(int i, final Bundle bundle) {
            AppMethodBeat.i(8655);
            ab.i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = ".concat(String.valueOf(i)));
            final Bundle bundle2 = new Bundle();
            final String string;
            final int i2;
            boolean z;
            String currentUrl;
            int init;
            switch (i) {
                case 18:
                    bundle2.putString("KPublisherId", h.cMm);
                    bundle2.putInt("getA8KeyScene", a.this.dF(h.uEm, h.cSQ));
                    break;
                case g.CTRL_INDEX /*37*/:
                    string = bundle.getString("show_kb_placeholder");
                    i2 = bundle.getInt("show_kb_max_length");
                    a.this.uDb.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8650);
                            a.this.uDb.dE(string, i2);
                            AppMethodBeat.o(8650);
                        }
                    });
                    break;
                case 43:
                    string = bundle.getString("set_page_title_text");
                    i2 = com.tencent.mm.plugin.webview.ui.tools.g.bx(bundle.getString("set_page_title_color"), a.this.uDb.getResources().getColor(R.color.du));
                    a.this.uDb.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8652);
                            if (string != null) {
                                a.this.uDb.setMMTitle(string);
                            }
                            a.this.uDb.ta(i2);
                            AppMethodBeat.o(8652);
                        }
                    });
                    break;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    a.this.uDb.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8653);
                            a.this.uDb.ac(bundle);
                            AppMethodBeat.o(8653);
                        }
                    });
                    break;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    z = bundle.getBoolean("add_shortcut_status");
                    if (a.this.uDd != null) {
                        a.this.uDd.oa(z);
                        break;
                    }
                    break;
                case JsApiOperateWXData.CTRL_INDEX /*79*/:
                    a.this.uDb.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(8651);
                            bundle2.putInt("height", a.this.uDb.cWF());
                            AppMethodBeat.o(8651);
                        }
                    });
                    break;
                case e.CTRL_INDEX /*84*/:
                    CharSequence mMTitle = a.this.uDb.mController.getMMTitle();
                    currentUrl = getCurrentUrl();
                    bundle2.putString("webview_current_url", currentUrl);
                    bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                    bundle2.putString("webview_current_desc", currentUrl);
                    break;
                case com.tencent.view.d.MIC_COLORPENCIL /*87*/:
                    z = a.this.uDf.dbV();
                    currentUrl = a.this.uDf.dbW();
                    Map dbX = a.this.uDf.dbX();
                    if (!z) {
                        bundle2.putString("full_url", bo.nullAsNil(currentUrl));
                        if (dbX != null && dbX.size() != 0) {
                            bundle2.putInt("set_cookie", 1);
                            com.tencent.xweb.c.jx(ah.getContext());
                            com.tencent.xweb.b dTR = com.tencent.xweb.b.dTR();
                            for (String string2 : dbX.keySet()) {
                                dTR.setCookie(bo.nullAsNil(currentUrl), string2 + "=" + ((String) dbX.get(string2)));
                            }
                            com.tencent.xweb.c.dTT();
                            com.tencent.xweb.c.sync();
                            ab.i("MicroMsg.GameFloatWebView", "cookies:%s", dTR.getCookie(bo.nullAsNil(currentUrl)));
                            break;
                        }
                        bundle2.putInt("set_cookie", 0);
                        break;
                    }
                    bundle2.putString("result", "not_return");
                    break;
                    break;
                case 95:
                    a.this.mUY.uDp.ao(bundle);
                    ab.i("MicroMsg.GameFloatWebView", "set game float page time data");
                    break;
                case 99:
                    bundle2.putInt("geta8key_scene", h.cSQ);
                    ab.i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", Integer.valueOf(init));
                    break;
                case 101:
                    bundle.setClassLoader(GameWebViewUI.class.getClassLoader());
                    com.tencent.mm.bp.d.b(a.this.mContext, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", h.cMm));
                    break;
                case 252:
                    a.this.mUN.eBQ = 1;
                    a.this.mVc.uDQ = System.currentTimeMillis();
                    break;
                case com.tencent.view.d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
                    a.this.mVc.uDR = System.currentTimeMillis();
                    break;
                case ReaderCallback.HIDDEN_BAR /*5001*/:
                    if (a.this.uzS.isSDCardAvailable()) {
                        ab.i("MicroMsg.GameFloatWebView", "availableSize = %d", Long.valueOf(bd.dpq()));
                        if (bd.dpq() < 524288000) {
                            ab.e("MicroMsg.GameFloatWebView", "available size not enough");
                        } else {
                            File file = new File(com.tencent.mm.plugin.webview.a.ueu);
                            z = true;
                            if (!file.exists()) {
                                z = file.mkdirs();
                                ab.i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", file.getAbsolutePath(), Boolean.valueOf(z));
                            }
                            if (z) {
                                init = FactoryProxyManager.getPlayManager().init(a.this.mContext, com.tencent.mm.plugin.webview.a.ueu);
                                FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            }
                        }
                        init = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
                    } else {
                        ab.i("MicroMsg.GameFloatWebView", "sdcard not available");
                        init = FactoryProxyManager.getPlayManager().init(a.this.mContext, null);
                    }
                    bundle2.putInt("webview_video_proxy_init", init);
                    break;
                case ReaderCallback.SHOW_BAR /*5002*/:
                    currentUrl = bundle.getString("webview_video_proxy_cdn_urls");
                    String string3 = bundle.getString("webview_video_proxy_fileId");
                    int i3 = bundle.getInt("webview_video_proxy_file_size");
                    init = FactoryProxyManager.getPlayManager().startPlay(currentUrl, bundle.getInt("webview_video_proxy_file_type"), string3, (long) i3, bundle.getInt("webview_video_proxy_file_duration"));
                    ab.i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", currentUrl, string3, Integer.valueOf(i3), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init));
                    bundle2.putInt("webview_video_proxy_play_data_id", init);
                    bundle2.putString("webview_video_proxy_local_url", r4);
                    break;
                case ReaderCallback.COPY_SELECT_TEXT /*5003*/:
                    init = bundle.getInt("webview_video_proxy_play_data_id");
                    ab.i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", Integer.valueOf(init));
                    if (init > 0) {
                        FactoryProxyManager.getPlayManager().stopPlay(init);
                        break;
                    }
                    break;
                case ReaderCallback.SEARCH_SELECT_TEXT /*5004*/:
                    FactoryProxyManager.getPlayManager().setPlayerState(bundle.getInt("webview_video_proxy_play_state"));
                    break;
                case ReaderCallback.READER_TOAST /*5005*/:
                    FactoryProxyManager.getPlayManager().setNetWorkState(bundle.getInt("webview_video_proxy_net_state"));
                    break;
                case ReaderCallback.SHOW_DIALOG /*5006*/:
                    FactoryProxyManager.getPlayManager().setRemainTime(bundle.getInt("webview_video_proxy_play_data_id"), bundle.getInt("webview_video_proxy_play_remain_time"));
                    break;
                case 5007:
                    ab.i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration")));
                    bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, i2));
                    break;
                case 6001:
                    ab.i("MicroMsg.GameFloatWebView", "includeCookie = %b", Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false)));
                    Intent intent = new Intent();
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    intent.putExtra("tools_clean_webview_cache_ignore_cookie", z);
                    com.tencent.mm.cj.c.aZ(intent);
                    break;
                case 90001:
                    ab.i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", getCurrentUrl(), com.tencent.xweb.b.dTR().getCookie(getCurrentUrl()));
                    bundle2.putString("cookie", currentUrl);
                    bundle2.putFloat(Constants.PARAM_DENSITY, com.tencent.mm.bz.a.getDensity(a.this.uDb));
                    break;
                case 90002:
                    com.tencent.mm.plugin.webview.ui.tools.m.uuj.hg(bundle.getString("traceid"), bundle.getString("username"));
                    break;
                default:
                    ab.e("MicroMsg.GameFloatWebView", "undefine action code!!!");
                    break;
            }
            AppMethodBeat.o(8655);
            return bundle2;
        }
    };
    com.tencent.mm.plugin.webview.stub.d uzS;

    class b extends b {
        public b(MMWebView mMWebView) {
            super(mMWebView);
        }

        public final void a(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.i(8657);
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", str, Long.valueOf(currentTimeMillis));
            if (a.this.mUN.eCf == 0) {
                a.this.mUN.eCf = currentTimeMillis;
            }
            if (a.this.mVc.uDM == 0) {
                a.this.mVc.uDM = currentTimeMillis;
            }
            a.this.mUY.uDp.dbY();
            a.this.uDe.j(webView, str);
            AppMethodBeat.o(8657);
        }

        public final void e(WebView webView, String str) {
            AppMethodBeat.i(8658);
            long currentTimeMillis = System.currentTimeMillis();
            ab.i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", str, Long.valueOf(currentTimeMillis));
            if (a.this.mUN.eCg == 0) {
                a.this.mUN.eCg = currentTimeMillis;
            }
            if (a.this.mVc.uDN == 0) {
                a.this.mVc.uDN = currentTimeMillis;
            }
            if (a.this.mUN.eCa == 0) {
                a.this.mUN.eCa = currentTimeMillis;
                a.this.mUZ = currentTimeMillis;
            }
            this.fow.setVisibility(0);
            a.this.uDe.k(webView, str);
            a.this.mUY.uDp.dbZ();
            AppMethodBeat.o(8658);
        }

        public final void a(com.tencent.mm.plugin.webview.stub.d dVar, k kVar) {
            a.this.uzS = dVar;
        }

        public final void a(d dVar) {
            AppMethodBeat.i(8659);
            ab.i("MicroMsg.GameFloatWebView", "jsapi ready");
            a.this.uDd = dVar;
            AppMethodBeat.o(8659);
        }

        public final void a(f fVar) {
            AppMethodBeat.i(8660);
            ab.i("MicroMsg.GameFloatWebView", "jsloader ready");
            a.this.uDh = fVar;
            AppMethodBeat.o(8660);
        }

        public final boolean afI(String str) {
            AppMethodBeat.i(8661);
            boolean ahB = a.this.uDe.ahB(str);
            AppMethodBeat.o(8661);
            return ahB;
        }

        public final String getSource() {
            return h.cMm;
        }

        public final void NT(String str) {
            AppMethodBeat.i(8662);
            if (a.this.uDe.dgi()) {
                this.fow.loadUrl(str);
                AppMethodBeat.o(8662);
                return;
            }
            super.NT(str);
            AppMethodBeat.o(8662);
        }

        public final boolean agc(String str) {
            AppMethodBeat.i(8663);
            boolean agc = super.agc(str);
            AppMethodBeat.o(8663);
            return agc;
        }

        public final void agd(String str) {
            AppMethodBeat.i(8664);
            try {
                ab.i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", str);
                a.this.SW.removeView(this.fow);
                AppMethodBeat.o(8664);
            } catch (Exception e) {
                AppMethodBeat.o(8664);
            }
        }

        public final void dbT() {
            AppMethodBeat.i(8665);
            if (VERSION.SDK_INT >= 11) {
                this.fow.removeJavascriptInterface("MicroMsg");
                this.fow.removeJavascriptInterface("JsApi");
            }
            try {
                this.fow.setWebChromeClient(null);
                this.fow.setWebViewClient(null);
                this.fow.setOnTouchListener(null);
                this.fow.setOnLongClickListener(null);
                this.fow.setVisibility(8);
                this.fow.removeAllViews();
                this.fow.clearView();
            } catch (Exception e) {
                ab.e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", e.getMessage());
            }
            try {
                this.fow.destroy();
                AppMethodBeat.o(8665);
            } catch (Exception e2) {
                ab.w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", e2.getMessage());
                AppMethodBeat.o(8665);
            }
        }

        public final m aGt() {
            return a.this.uDj;
        }

        public final o c(WebView webView, String str) {
            AppMethodBeat.i(8666);
            o ahA = a.this.uDe.ahA(str);
            if (ahA != null) {
                AppMethodBeat.o(8666);
                return ahA;
            }
            ahA = super.c(webView, str);
            AppMethodBeat.o(8666);
            return ahA;
        }

        public final o a(WebView webView, n nVar) {
            AppMethodBeat.i(8667);
            o a;
            if (nVar == null || nVar.getUrl() == null) {
                a = super.a(webView, nVar);
                AppMethodBeat.o(8667);
                return a;
            }
            a = a.this.uDe.ahA(nVar.getUrl().toString());
            if (a != null) {
                AppMethodBeat.o(8667);
                return a;
            }
            a = super.a(webView, nVar);
            AppMethodBeat.o(8667);
            return a;
        }

        public final o a(WebView webView, n nVar, Bundle bundle) {
            AppMethodBeat.i(8668);
            o a;
            if (nVar == null || nVar.getUrl() == null) {
                a = super.a(webView, nVar);
                AppMethodBeat.o(8668);
                return a;
            }
            a = a.this.uDe.ahA(nVar.getUrl().toString());
            if (a != null) {
                AppMethodBeat.o(8668);
                return a;
            }
            a = super.a(webView, nVar, bundle);
            AppMethodBeat.o(8668);
            return a;
        }

        public final void dbU() {
            AppMethodBeat.i(8669);
            a.this.mUN.eCe = System.currentTimeMillis();
            super.dbU();
            AppMethodBeat.o(8669);
        }

        public final void bI(String str, boolean z) {
            AppMethodBeat.i(8670);
            long currentTimeMillis = System.currentTimeMillis();
            if (a.this.mUN.eCh == 0) {
                a.this.mUN.eCh = currentTimeMillis;
            }
            if (a.this.mVc.uDO == 0) {
                a.this.mVc.uDO = currentTimeMillis;
            }
            super.bI(str, z);
            AppMethodBeat.o(8670);
        }

        public final boolean am(Bundle bundle) {
            AppMethodBeat.i(8671);
            long currentTimeMillis = System.currentTimeMillis();
            if (a.this.mUN.eCi == 0) {
                a.this.mUN.eCi = currentTimeMillis;
            }
            if (a.this.mVc.uDP == 0) {
                a.this.mVc.uDP = currentTimeMillis;
            }
            boolean am = super.am(bundle);
            AppMethodBeat.o(8671);
            return am;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$3 */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ String val$url;

        AnonymousClass3(String str) {
            this.val$url = str;
        }

        public final void run() {
            AppMethodBeat.i(8649);
            a.this.fow.setVisibility(8);
            a.this.uDf.agc(this.val$url);
            AppMethodBeat.o(8649);
        }
    }

    class a extends i {
        a(MMWebViewWithJsApi mMWebViewWithJsApi) {
            super(mMWebViewWithJsApi);
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.i(8656);
            if (a.this.uDe != null) {
                a.this.uDe.a(consoleMessage);
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.o(8656);
            return onConsoleMessage;
        }
    }

    class c extends com.tencent.xweb.x5.a.a.a.a.b {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.i(8672);
            Object onMiscCallBack = a.this.uDe.onMiscCallBack(str, bundle);
            if (onMiscCallBack != null) {
                AppMethodBeat.o(8672);
                return onMiscCallBack;
            }
            onMiscCallBack = super.onMiscCallBack(str, bundle);
            AppMethodBeat.o(8672);
            return onMiscCallBack;
        }
    }

    public a(GameWebViewUI gameWebViewUI, ViewGroup viewGroup, String str) {
        AppMethodBeat.i(8673);
        this.mUN = GameWebPerformanceInfo.kV(str);
        this.mUN.url = str;
        this.mUN.eBJ = (gameWebViewUI.hashCode() & BaseClientBuilder.API_PRIORITY_OTHER) + "_" + (str.hashCode() & BaseClientBuilder.API_PRIORITY_OTHER);
        long currentTimeMillis = System.currentTimeMillis();
        this.mUN.startTime = gameWebViewUI.getIntent().getLongExtra("start_time", currentTimeMillis);
        this.mUN.eBU = gameWebViewUI.getIntent().getLongExtra("start_activity_time", currentTimeMillis);
        this.mUN.eBZ = currentTimeMillis;
        this.mUN.eCb = currentTimeMillis;
        this.mVc = g.agg(str);
        this.mVc.startTime = System.currentTimeMillis();
        this.mContext = gameWebViewUI;
        this.uDb = gameWebViewUI;
        this.SW = viewGroup;
        MMWebViewWithJsApi fw = com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi.a.fw(this.mContext);
        fw.setBackgroundResource(17170445);
        fw.setBackgroundColor(0);
        fw.setVisibility(4);
        this.uDf = new b(fw);
        fw.setWebViewClient(this.uDf);
        this.uDg = new a(fw);
        fw.setWebChromeClient(this.uDg);
        ab.i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", Integer.valueOf(fw.hashCode()), Integer.valueOf(this.uDf.hashCode()));
        if (fw.getIsX5Kernel()) {
            fw.setWebViewClientExtension(new c(this, (byte) 0));
        }
        fw.getSettings().setJavaScriptEnabled(true);
        fw.getSettings().dUh();
        fw.getSettings().setBuiltInZoomControls(false);
        fw.getSettings().setUseWideViewPort(true);
        fw.getSettings().setLoadWithOverviewMode(true);
        fw.getSettings().dUc();
        fw.getSettings().dUb();
        fw.getSettings().setGeolocationEnabled(true);
        fw.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        fw.getSettings().dUj();
        fw.getSettings().dUf();
        fw.getSettings().setAppCachePath(this.mContext.getDir("webviewcache", 0).getAbsolutePath());
        fw.getSettings().dUe();
        fw.getSettings().dUg();
        fw.getSettings().setDatabasePath(com.tencent.mm.compatible.util.e.eSi + "databases/");
        com.tencent.xweb.b.dTR().dTS();
        com.tencent.xweb.b.dTR().f(fw);
        this.fow = fw;
        this.uDc = new h(gameWebViewUI.getIntent());
        this.uDe = new com.tencent.mm.plugin.wepkg.c();
        this.uDe.uVC = new com.tencent.mm.plugin.wepkg.event.b() {
            public final void bDB() {
                AppMethodBeat.i(8648);
                ab.i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", a.this.mUH);
                if (!(a.this.fow == null || a.this.fow.getParent() == null || a.this.uDf == null || bo.isNullOrNil(a.this.mUH))) {
                    a.this.fow.stopLoading();
                    a.this.fow.loadUrl(a.this.uDf.dbW());
                }
                AppMethodBeat.o(8648);
            }
        };
        this.mUN.eCc = System.currentTimeMillis();
        this.mVc.uDL = System.currentTimeMillis();
        AppMethodBeat.o(8673);
    }

    /* Access modifiers changed, original: final */
    public final int dF(String str, int i) {
        AppMethodBeat.i(8674);
        if (i == 0) {
            if (str == null || str.length() <= 0) {
                i = 0;
            } else if (this.uzS == null) {
                i = 1;
            } else {
                try {
                    i = this.uzS.nI(str) ? 8 : this.uzS.mZ(str) ? 7 : 1;
                } catch (Exception e) {
                    ab.e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + e.getMessage());
                    i = 1;
                }
            }
        }
        ab.i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", Integer.valueOf(i));
        AppMethodBeat.o(8674);
        return i;
    }

    public final void onDestroy() {
        AppMethodBeat.i(8675);
        if (!this.uDi) {
            ab.i("MicroMsg.GameFloatWebView", "onDestroy");
            this.uDi = true;
            c.a(c.this);
            this.uDe.ot(true);
            if (this.fow != null) {
                this.fow.setWebViewClient(null);
                this.fow.setWebChromeClient(null);
            }
            GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
            gameWebPerformanceInfo.eCj += System.currentTimeMillis() - this.mUZ;
            this.mUN.eCk = System.currentTimeMillis();
            com.tencent.mm.game.report.api.c.eBG.a(this.mUN);
            GameWebPerformanceInfo.kW(this.mUH);
            e.agf(this.mUH);
            g.agi(this.mUH);
        }
        AppMethodBeat.o(8675);
    }
}
