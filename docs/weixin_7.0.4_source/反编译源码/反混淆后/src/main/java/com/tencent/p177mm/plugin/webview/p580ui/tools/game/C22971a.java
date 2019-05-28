package com.tencent.p177mm.plugin.webview.p580ui.tools.game;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p218cj.C45287c;
import com.tencent.p177mm.p612ui.widget.MMWebView;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2275g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p311m.C38339e;
import com.tencent.p177mm.plugin.webview.C14445a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C29916g;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40344k;
import com.tencent.p177mm.plugin.webview.p580ui.tools.C40346m;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C43986f;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C44786d;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C14672i;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.C46936m;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.p177mm.plugin.webview.p580ui.tools.widget.MMWebViewWithJsApi.C14670a;
import com.tencent.p177mm.plugin.webview.stub.C46434d;
import com.tencent.p177mm.plugin.wepkg.C30003c;
import com.tencent.p177mm.plugin.wepkg.event.C46472b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5034bd;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.qqvideo.proxy.api.FactoryProxyManager;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.tencent.view.C31128d;
import com.tencent.xweb.C24526c;
import com.tencent.xweb.C24530n;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.C44576b;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p685x5.p1116a.p1117a.p1118a.p1119a.C16404b;
import java.io.File;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a */
public final class C22971a {
    /* renamed from: SW */
    ViewGroup f4405SW;
    MMWebView fow;
    Context mContext;
    String mUH;
    GameWebPerformanceInfo mUN;
    C14610c mUY = new C229751();
    long mUZ;
    C43963g mVc;
    GameWebViewUI uDb;
    private C40315h uDc;
    C44786d uDd;
    C30003c uDe;
    C22970b uDf;
    private C22973a uDg;
    C43986f uDh;
    private boolean uDi;
    C46936m uDj = new C46154();
    C46434d uzS;

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$4 */
    class C46154 extends C46936m {
        C46154() {
        }

        /* renamed from: W */
        public final void mo9706W(Bundle bundle) {
            AppMethodBeat.m2504i(8654);
            C4990ab.m7416i("MicroMsg.GameFloatWebView", "closeWindow");
            try {
                C22971a.this.f4405SW.removeView(C22971a.this.fow);
                C22971a.this.onDestroy();
                AppMethodBeat.m2505o(8654);
            } catch (Exception e) {
                AppMethodBeat.m2505o(8654);
            }
        }

        /* renamed from: g */
        public final Bundle mo6226g(int i, final Bundle bundle) {
            AppMethodBeat.m2504i(8655);
            C4990ab.m7416i("MicroMsg.GameFloatWebView", "game float invokeAsResult, actionCode = ".concat(String.valueOf(i)));
            final Bundle bundle2 = new Bundle();
            final String string;
            final int i2;
            boolean z;
            String currentUrl;
            int init;
            switch (i) {
                case 18:
                    bundle2.putString("KPublisherId", C40315h.cMm);
                    bundle2.putInt("getA8KeyScene", C22971a.this.mo38575dF(C40315h.uEm, C40315h.cSQ));
                    break;
                case C2275g.CTRL_INDEX /*37*/:
                    string = bundle.getString("show_kb_placeholder");
                    i2 = bundle.getInt("show_kb_max_length");
                    C22971a.this.uDb.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(8650);
                            C22971a.this.uDb.mo30984dE(string, i2);
                            AppMethodBeat.m2505o(8650);
                        }
                    });
                    break;
                case 43:
                    string = bundle.getString("set_page_title_text");
                    i2 = C29916g.m47394bx(bundle.getString("set_page_title_color"), C22971a.this.uDb.getResources().getColor(C25738R.color.f11696du));
                    C22971a.this.uDb.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(8652);
                            if (string != null) {
                                C22971a.this.uDb.setMMTitle(string);
                            }
                            C22971a.this.uDb.mo17443ta(i2);
                            AppMethodBeat.m2505o(8652);
                        }
                    });
                    break;
                case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    C22971a.this.uDb.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(8653);
                            C22971a.this.uDb.mo30958ac(bundle);
                            AppMethodBeat.m2505o(8653);
                        }
                    });
                    break;
                case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    z = bundle.getBoolean("add_shortcut_status");
                    if (C22971a.this.uDd != null) {
                        C22971a.this.uDd.mo71940oa(z);
                        break;
                    }
                    break;
                case JsApiOperateWXData.CTRL_INDEX /*79*/:
                    C22971a.this.uDb.runOnUiThread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(8651);
                            bundle2.putInt("height", C22971a.this.uDb.cWF());
                            AppMethodBeat.m2505o(8651);
                        }
                    });
                    break;
                case C38339e.CTRL_INDEX /*84*/:
                    CharSequence mMTitle = C22971a.this.uDb.mController.getMMTitle();
                    currentUrl = getCurrentUrl();
                    bundle2.putString("webview_current_url", currentUrl);
                    bundle2.putString("webview_current_title", mMTitle != null ? mMTitle.toString() : "");
                    bundle2.putString("webview_current_desc", currentUrl);
                    break;
                case C31128d.MIC_COLORPENCIL /*87*/:
                    z = C22971a.this.uDf.dbV();
                    currentUrl = C22971a.this.uDf.dbW();
                    Map dbX = C22971a.this.uDf.dbX();
                    if (!z) {
                        bundle2.putString("full_url", C5046bo.nullAsNil(currentUrl));
                        if (dbX != null && dbX.size() != 0) {
                            bundle2.putInt("set_cookie", 1);
                            C24526c.m38159jx(C4996ah.getContext());
                            C44576b dTR = C44576b.dTR();
                            for (String string2 : dbX.keySet()) {
                                dTR.setCookie(C5046bo.nullAsNil(currentUrl), string2 + "=" + ((String) dbX.get(string2)));
                            }
                            C24526c.dTT();
                            C24526c.sync();
                            C4990ab.m7417i("MicroMsg.GameFloatWebView", "cookies:%s", dTR.getCookie(C5046bo.nullAsNil(currentUrl)));
                            break;
                        }
                        bundle2.putInt("set_cookie", 0);
                        break;
                    }
                    bundle2.putString("result", "not_return");
                    break;
                    break;
                case 95:
                    C22971a.this.mUY.uDp.mo26864ao(bundle);
                    C4990ab.m7416i("MicroMsg.GameFloatWebView", "set game float page time data");
                    break;
                case 99:
                    bundle2.putInt("geta8key_scene", C40315h.cSQ);
                    C4990ab.m7417i("MicroMsg.GameFloatWebView", "Key value: getA8KeyScene(%d)", Integer.valueOf(init));
                    break;
                case 101:
                    bundle.setClassLoader(GameWebViewUI.class.getClassLoader());
                    C25985d.m41467b(C22971a.this.mContext, bundle.getString("open_ui_with_webview_ui_plugin_name"), bundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(bundle.getBundle("open_ui_with_webview_ui_extras")).putExtra("KPublisherId", C40315h.cMm));
                    break;
                case 252:
                    C22971a.this.mUN.eBQ = 1;
                    C22971a.this.mVc.uDQ = System.currentTimeMillis();
                    break;
                case C31128d.MIC_PTU_ZIPAI_OKINAWA /*253*/:
                    C22971a.this.mVc.uDR = System.currentTimeMillis();
                    break;
                case ReaderCallback.HIDDEN_BAR /*5001*/:
                    if (C22971a.this.uzS.isSDCardAvailable()) {
                        C4990ab.m7417i("MicroMsg.GameFloatWebView", "availableSize = %d", Long.valueOf(C5034bd.dpq()));
                        if (C5034bd.dpq() < 524288000) {
                            C4990ab.m7412e("MicroMsg.GameFloatWebView", "available size not enough");
                        } else {
                            File file = new File(C14445a.ueu);
                            z = true;
                            if (!file.exists()) {
                                z = file.mkdirs();
                                C4990ab.m7417i("MicroMsg.GameFloatWebView", "create proxy cache path : %s, %b", file.getAbsolutePath(), Boolean.valueOf(z));
                            }
                            if (z) {
                                init = FactoryProxyManager.getPlayManager().init(C22971a.this.mContext, C14445a.ueu);
                                FactoryProxyManager.getPlayManager().setMaxStorageSize(200);
                            }
                        }
                        init = FactoryProxyManager.getPlayManager().init(C22971a.this.mContext, null);
                    } else {
                        C4990ab.m7416i("MicroMsg.GameFloatWebView", "sdcard not available");
                        init = FactoryProxyManager.getPlayManager().init(C22971a.this.mContext, null);
                    }
                    bundle2.putInt("webview_video_proxy_init", init);
                    break;
                case ReaderCallback.SHOW_BAR /*5002*/:
                    currentUrl = bundle.getString("webview_video_proxy_cdn_urls");
                    String string3 = bundle.getString("webview_video_proxy_fileId");
                    int i3 = bundle.getInt("webview_video_proxy_file_size");
                    init = FactoryProxyManager.getPlayManager().startPlay(currentUrl, bundle.getInt("webview_video_proxy_file_type"), string3, (long) i3, bundle.getInt("webview_video_proxy_file_duration"));
                    C4990ab.m7417i("MicroMsg.GameFloatWebView", "cdnurls = %s, filedId = %s, fileSize = %d, fileDuration = %d, fileType = %d, playDataId = %d, localUrl = %s", currentUrl, string3, Integer.valueOf(i3), Integer.valueOf(r6), Integer.valueOf(r2), Integer.valueOf(init), FactoryProxyManager.getPlayManager().buildPlayURLMp4(init));
                    bundle2.putInt("webview_video_proxy_play_data_id", init);
                    bundle2.putString("webview_video_proxy_local_url", r4);
                    break;
                case ReaderCallback.COPY_SELECT_TEXT /*5003*/:
                    init = bundle.getInt("webview_video_proxy_play_data_id");
                    C4990ab.m7417i("MicroMsg.GameFloatWebView", "webview proxy stop play, play id = %d", Integer.valueOf(init));
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
                    C4990ab.m7417i("MicroMsg.GameFloatWebView", "playid = %d, duration = %d", Integer.valueOf(bundle.getInt("webview_video_proxy_play_data_id")), Integer.valueOf(bundle.getInt("webview_video_proxy_preload_duration")));
                    bundle2.putInt("webview_video_proxy_pre_load_result", FactoryProxyManager.getPlayManager().preLoad(init, i2));
                    break;
                case 6001:
                    C4990ab.m7417i("MicroMsg.GameFloatWebView", "includeCookie = %b", Boolean.valueOf(bundle.getBoolean("clear_webview_cache_clear_cookie", false)));
                    Intent intent = new Intent();
                    intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                    intent.putExtra("tools_clean_webview_cache_ignore_cookie", z);
                    C45287c.m83504aZ(intent);
                    break;
                case 90001:
                    C4990ab.m7417i("MicroMsg.GameFloatWebView", "url = %s, cookie = %s", getCurrentUrl(), C44576b.dTR().getCookie(getCurrentUrl()));
                    bundle2.putString("cookie", currentUrl);
                    bundle2.putFloat(Constants.PARAM_DENSITY, C1338a.getDensity(C22971a.this.uDb));
                    break;
                case 90002:
                    C40346m.uuj.mo63714hg(bundle.getString("traceid"), bundle.getString("username"));
                    break;
                default:
                    C4990ab.m7412e("MicroMsg.GameFloatWebView", "undefine action code!!!");
                    break;
            }
            AppMethodBeat.m2505o(8655);
            return bundle2;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$b */
    class C22970b extends C29922b {
        public C22970b(MMWebView mMWebView) {
            super(mMWebView);
        }

        /* renamed from: a */
        public final void mo38564a(WebView webView, String str, Bitmap bitmap) {
            AppMethodBeat.m2504i(8657);
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.GameFloatWebView", "onPageStarted opt, url = %s, now = %d", str, Long.valueOf(currentTimeMillis));
            if (C22971a.this.mUN.eCf == 0) {
                C22971a.this.mUN.eCf = currentTimeMillis;
            }
            if (C22971a.this.mVc.uDM == 0) {
                C22971a.this.mVc.uDM = currentTimeMillis;
            }
            C22971a.this.mUY.uDp.dbY();
            C22971a.this.uDe.mo48240j(webView, str);
            AppMethodBeat.m2505o(8657);
        }

        /* renamed from: e */
        public final void mo38573e(WebView webView, String str) {
            AppMethodBeat.m2504i(8658);
            long currentTimeMillis = System.currentTimeMillis();
            C4990ab.m7417i("MicroMsg.GameFloatWebView", "onPageFinished opt, url = %s, now = %d", str, Long.valueOf(currentTimeMillis));
            if (C22971a.this.mUN.eCg == 0) {
                C22971a.this.mUN.eCg = currentTimeMillis;
            }
            if (C22971a.this.mVc.uDN == 0) {
                C22971a.this.mVc.uDN = currentTimeMillis;
            }
            if (C22971a.this.mUN.eCa == 0) {
                C22971a.this.mUN.eCa = currentTimeMillis;
                C22971a.this.mUZ = currentTimeMillis;
            }
            this.fow.setVisibility(0);
            C22971a.this.uDe.mo48241k(webView, str);
            C22971a.this.mUY.uDp.dbZ();
            AppMethodBeat.m2505o(8658);
        }

        /* renamed from: a */
        public final void mo38561a(C46434d c46434d, C40344k c40344k) {
            C22971a.this.uzS = c46434d;
        }

        /* renamed from: a */
        public final void mo38562a(C44786d c44786d) {
            AppMethodBeat.m2504i(8659);
            C4990ab.m7416i("MicroMsg.GameFloatWebView", "jsapi ready");
            C22971a.this.uDd = c44786d;
            AppMethodBeat.m2505o(8659);
        }

        /* renamed from: a */
        public final void mo38563a(C43986f c43986f) {
            AppMethodBeat.m2504i(8660);
            C4990ab.m7416i("MicroMsg.GameFloatWebView", "jsloader ready");
            C22971a.this.uDh = c43986f;
            AppMethodBeat.m2505o(8660);
        }

        public final boolean afI(String str) {
            AppMethodBeat.m2504i(8661);
            boolean ahB = C22971a.this.uDe.ahB(str);
            AppMethodBeat.m2505o(8661);
            return ahB;
        }

        public final String getSource() {
            return C40315h.cMm;
        }

        /* renamed from: NT */
        public final void mo38560NT(String str) {
            AppMethodBeat.m2504i(8662);
            if (C22971a.this.uDe.dgi()) {
                this.fow.loadUrl(str);
                AppMethodBeat.m2505o(8662);
                return;
            }
            super.mo38560NT(str);
            AppMethodBeat.m2505o(8662);
        }

        public final boolean agc(String str) {
            AppMethodBeat.m2504i(8663);
            boolean agc = super.agc(str);
            AppMethodBeat.m2505o(8663);
            return agc;
        }

        public final void agd(String str) {
            AppMethodBeat.m2504i(8664);
            try {
                C4990ab.m7417i("MicroMsg.GameFloatWebView", "onURLFilteredOut url:%s", str);
                C22971a.this.f4405SW.removeView(this.fow);
                AppMethodBeat.m2505o(8664);
            } catch (Exception e) {
                AppMethodBeat.m2505o(8664);
            }
        }

        public final void dbT() {
            AppMethodBeat.m2504i(8665);
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
                C4990ab.m7413e("MicroMsg.GameFloatWebView", "onDestroy, set web infos to null,  ex = %s", e.getMessage());
            }
            try {
                this.fow.destroy();
                AppMethodBeat.m2505o(8665);
            } catch (Exception e2) {
                C4990ab.m7421w("MicroMsg.GameFloatWebView", "onDestroy, viewWV destroy, ex = %s", e2.getMessage());
                AppMethodBeat.m2505o(8665);
            }
        }

        public final C46936m aGt() {
            return C22971a.this.uDj;
        }

        /* renamed from: c */
        public final C31147o mo5993c(WebView webView, String str) {
            AppMethodBeat.m2504i(8666);
            C31147o ahA = C22971a.this.uDe.ahA(str);
            if (ahA != null) {
                AppMethodBeat.m2505o(8666);
                return ahA;
            }
            ahA = super.mo5993c(webView, str);
            AppMethodBeat.m2505o(8666);
            return ahA;
        }

        /* renamed from: a */
        public final C31147o mo5990a(WebView webView, C24530n c24530n) {
            AppMethodBeat.m2504i(8667);
            C31147o a;
            if (c24530n == null || c24530n.getUrl() == null) {
                a = super.mo5990a(webView, c24530n);
                AppMethodBeat.m2505o(8667);
                return a;
            }
            a = C22971a.this.uDe.ahA(c24530n.getUrl().toString());
            if (a != null) {
                AppMethodBeat.m2505o(8667);
                return a;
            }
            a = super.mo5990a(webView, c24530n);
            AppMethodBeat.m2505o(8667);
            return a;
        }

        /* renamed from: a */
        public final C31147o mo5991a(WebView webView, C24530n c24530n, Bundle bundle) {
            AppMethodBeat.m2504i(8668);
            C31147o a;
            if (c24530n == null || c24530n.getUrl() == null) {
                a = super.mo5990a(webView, c24530n);
                AppMethodBeat.m2505o(8668);
                return a;
            }
            a = C22971a.this.uDe.ahA(c24530n.getUrl().toString());
            if (a != null) {
                AppMethodBeat.m2505o(8668);
                return a;
            }
            a = super.mo5991a(webView, c24530n, bundle);
            AppMethodBeat.m2505o(8668);
            return a;
        }

        public final void dbU() {
            AppMethodBeat.m2504i(8669);
            C22971a.this.mUN.eCe = System.currentTimeMillis();
            super.dbU();
            AppMethodBeat.m2505o(8669);
        }

        /* renamed from: bI */
        public final void mo38570bI(String str, boolean z) {
            AppMethodBeat.m2504i(8670);
            long currentTimeMillis = System.currentTimeMillis();
            if (C22971a.this.mUN.eCh == 0) {
                C22971a.this.mUN.eCh = currentTimeMillis;
            }
            if (C22971a.this.mVc.uDO == 0) {
                C22971a.this.mVc.uDO = currentTimeMillis;
            }
            super.mo38570bI(str, z);
            AppMethodBeat.m2505o(8670);
        }

        /* renamed from: am */
        public final boolean mo38569am(Bundle bundle) {
            AppMethodBeat.m2504i(8671);
            long currentTimeMillis = System.currentTimeMillis();
            if (C22971a.this.mUN.eCi == 0) {
                C22971a.this.mUN.eCi = currentTimeMillis;
            }
            if (C22971a.this.mVc.uDP == 0) {
                C22971a.this.mVc.uDP = currentTimeMillis;
            }
            boolean am = super.mo38569am(bundle);
            AppMethodBeat.m2505o(8671);
            return am;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$3 */
    class C229723 implements Runnable {
        final /* synthetic */ String val$url;

        C229723(String str) {
            this.val$url = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(8649);
            C22971a.this.fow.setVisibility(8);
            C22971a.this.uDf.agc(this.val$url);
            AppMethodBeat.m2505o(8649);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$a */
    class C22973a extends C14672i {
        C22973a(MMWebViewWithJsApi mMWebViewWithJsApi) {
            super(mMWebViewWithJsApi);
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            AppMethodBeat.m2504i(8656);
            if (C22971a.this.uDe != null) {
                C22971a.this.uDe.mo48234a(consoleMessage);
            }
            boolean onConsoleMessage = super.onConsoleMessage(consoleMessage);
            AppMethodBeat.m2505o(8656);
            return onConsoleMessage;
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$2 */
    class C229742 extends C46472b {
        C229742() {
        }

        public final void bDB() {
            AppMethodBeat.m2504i(8648);
            C4990ab.m7417i("MicroMsg.GameFloatWebView", "float page, reload url:%s from net", C22971a.this.mUH);
            if (!(C22971a.this.fow == null || C22971a.this.fow.getParent() == null || C22971a.this.uDf == null || C5046bo.isNullOrNil(C22971a.this.mUH))) {
                C22971a.this.fow.stopLoading();
                C22971a.this.fow.loadUrl(C22971a.this.uDf.dbW());
            }
            AppMethodBeat.m2505o(8648);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$1 */
    class C229751 extends C14610c {
        C229751() {
        }

        /* Access modifiers changed, original: protected|final */
        /* renamed from: I */
        public final void mo9702I(Bundle bundle) {
            AppMethodBeat.m2504i(8647);
            try {
                if (!(C22971a.this.uzS == null || bundle == null)) {
                    C22971a.this.uzS.mo15575g(96, bundle);
                }
                AppMethodBeat.m2505o(8647);
            } catch (RemoteException e) {
                AppMethodBeat.m2505o(8647);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.game.a$c */
    class C22976c extends C16404b {
        private C22976c() {
        }

        /* synthetic */ C22976c(C22971a c22971a, byte b) {
            this();
        }

        public final Object onMiscCallBack(String str, Bundle bundle) {
            AppMethodBeat.m2504i(8672);
            Object onMiscCallBack = C22971a.this.uDe.onMiscCallBack(str, bundle);
            if (onMiscCallBack != null) {
                AppMethodBeat.m2505o(8672);
                return onMiscCallBack;
            }
            onMiscCallBack = super.onMiscCallBack(str, bundle);
            AppMethodBeat.m2505o(8672);
            return onMiscCallBack;
        }
    }

    public C22971a(GameWebViewUI gameWebViewUI, ViewGroup viewGroup, String str) {
        AppMethodBeat.m2504i(8673);
        this.mUN = GameWebPerformanceInfo.m63879kV(str);
        this.mUN.url = str;
        this.mUN.eBJ = (gameWebViewUI.hashCode() & BaseClientBuilder.API_PRIORITY_OTHER) + "_" + (str.hashCode() & BaseClientBuilder.API_PRIORITY_OTHER);
        long currentTimeMillis = System.currentTimeMillis();
        this.mUN.startTime = gameWebViewUI.getIntent().getLongExtra("start_time", currentTimeMillis);
        this.mUN.eBU = gameWebViewUI.getIntent().getLongExtra("start_activity_time", currentTimeMillis);
        this.mUN.eBZ = currentTimeMillis;
        this.mUN.eCb = currentTimeMillis;
        this.mVc = C43963g.agg(str);
        this.mVc.startTime = System.currentTimeMillis();
        this.mContext = gameWebViewUI;
        this.uDb = gameWebViewUI;
        this.f4405SW = viewGroup;
        MMWebViewWithJsApi fw = C14670a.m22876fw(this.mContext);
        fw.setBackgroundResource(17170445);
        fw.setBackgroundColor(0);
        fw.setVisibility(4);
        this.uDf = new C22970b(fw);
        fw.setWebViewClient(this.uDf);
        this.uDg = new C22973a(fw);
        fw.setWebChromeClient(this.uDg);
        C4990ab.m7417i("MicroMsg.GameFloatWebView", "createFloatWebView, webview: %d, floatWebViewClient: %d", Integer.valueOf(fw.hashCode()), Integer.valueOf(this.uDf.hashCode()));
        if (fw.getIsX5Kernel()) {
            fw.setWebViewClientExtension(new C22976c(this, (byte) 0));
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
        fw.getSettings().setDatabasePath(C6457e.eSi + "databases/");
        C44576b.dTR().dTS();
        C44576b.dTR().mo71378f(fw);
        this.fow = fw;
        this.uDc = new C40315h(gameWebViewUI.getIntent());
        this.uDe = new C30003c();
        this.uDe.uVC = new C229742();
        this.mUN.eCc = System.currentTimeMillis();
        this.mVc.uDL = System.currentTimeMillis();
        AppMethodBeat.m2505o(8673);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: dF */
    public final int mo38575dF(String str, int i) {
        AppMethodBeat.m2504i(8674);
        if (i == 0) {
            if (str == null || str.length() <= 0) {
                i = 0;
            } else if (this.uzS == null) {
                i = 1;
            } else {
                try {
                    i = this.uzS.mo15587nI(str) ? 8 : this.uzS.mo15586mZ(str) ? 7 : 1;
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.GameFloatWebView", "getScene fail, ex = " + e.getMessage());
                    i = 1;
                }
            }
        }
        C4990ab.m7417i("MicroMsg.GameFloatWebView", "KGetA8KeyScene = %s", Integer.valueOf(i));
        AppMethodBeat.m2505o(8674);
        return i;
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(8675);
        if (!this.uDi) {
            C4990ab.m7416i("MicroMsg.GameFloatWebView", "onDestroy");
            this.uDi = true;
            C14610c.m22839a(C14610c.this);
            this.uDe.mo48243ot(true);
            if (this.fow != null) {
                this.fow.setWebViewClient(null);
                this.fow.setWebChromeClient(null);
            }
            GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
            gameWebPerformanceInfo.eCj += System.currentTimeMillis() - this.mUZ;
            this.mUN.eCk = System.currentTimeMillis();
            C37860c.eBG.mo60577a(this.mUN);
            GameWebPerformanceInfo.m63880kW(this.mUH);
            C43961e.agf(this.mUH);
            C43963g.agi(this.mUH);
        }
        AppMethodBeat.m2505o(8675);
    }
}
