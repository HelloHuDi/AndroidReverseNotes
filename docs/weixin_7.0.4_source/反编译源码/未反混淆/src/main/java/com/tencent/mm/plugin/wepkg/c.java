package com.tencent.mm.plugin.wepkg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.mm.plugin.wepkg.model.b;
import com.tencent.mm.plugin.wepkg.model.f;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.WebView;
import com.tencent.xweb.o;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public final class c {
    private static final Pattern hnu = Pattern.compile(".*#.*wechat_redirect");
    private long aIv = 0;
    private ap che = new ap(new a() {
        public final boolean BI() {
            AppMethodBeat.i(63367);
            if (!c.this.uVB || c.this.uVA) {
                c.Kj(0);
            } else {
                ab.i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(63366);
                        try {
                            ab.i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
                            c.this.uVv = false;
                            c.e(c.this);
                            int dgl = c.dgl();
                            if (dgl > 1) {
                                if (c.this.uVx != null) {
                                    com.tencent.mm.plugin.wepkg.utils.a.b("whiteScreen", c.this.mUH, c.this.uVx.eBS, c.this.uVx.version, -1, 0, null);
                                }
                                h.pYm.a(859, 13, 1, false);
                                String aid = d.aid(c.this.mUH);
                                b.Dp(aid);
                                b.dgz().dP(aid, 1);
                                c.dgm();
                                AppMethodBeat.o(63366);
                                return;
                            }
                            c.Kj(dgl + 1);
                            AppMethodBeat.o(63366);
                        } catch (Exception e) {
                            AppMethodBeat.o(63366);
                        }
                    }
                });
            }
            AppMethodBeat.o(63367);
            return false;
        }
    }, false);
    private String mUH;
    private GameWebPerformanceInfo mUN;
    private String mXy;
    private boolean uVA = false;
    private boolean uVB = false;
    public com.tencent.mm.plugin.wepkg.event.b uVC = new com.tencent.mm.plugin.wepkg.event.b() {
        public final void bDB() {
            AppMethodBeat.i(135930);
            if (!bo.isNullOrNil(d.this.mTH)) {
                d.this.post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(135926);
                        d.this.loadUrl(d.this.mTH, d.this.mUG);
                        AppMethodBeat.o(135926);
                    }
                });
            }
            AppMethodBeat.o(135930);
        }

        public final void bDC() {
            AppMethodBeat.i(135931);
            d.this.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(135928);
                    com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onForceUpdate");
                    d.this.mUP = true;
                    d.this.postDelayed(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(135927);
                            if (d.this.mUP) {
                                d.d(d.this);
                            }
                            AppMethodBeat.o(135927);
                        }
                    }, 1000);
                    AppMethodBeat.o(135928);
                }
            });
            AppMethodBeat.o(135931);
        }

        public final void hL(final boolean z) {
            AppMethodBeat.i(135932);
            d.this.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(135929);
                    if (d.this.mUP) {
                        d.this.mUP = false;
                        d.e(d.this);
                        if (z) {
                            com.tencent.luggage.g.d.i("MicroMsg.GameWebCoreImpl", "onPkgReady");
                            d.this.stopLoading();
                            d.this.mUF = false;
                            d.this.loadUrl(d.this.mUH);
                        }
                    }
                    AppMethodBeat.o(135929);
                }
            });
            AppMethodBeat.o(135932);
        }
    };
    private boolean uVD = false;
    private Set<String> uVE = new HashSet();
    private long uVF;
    public boolean uVv = false;
    private f uVw;
    private WepkgVersion uVx;
    private com.tencent.mm.plugin.wepkg.event.a uVy;
    private com.tencent.mm.plugin.wepkg.model.d uVz;

    public c() {
        AppMethodBeat.i(63368);
        b.dgd();
        this.uVz = new com.tencent.mm.plugin.wepkg.model.d();
        b.dge();
        this.uVy = new com.tencent.mm.plugin.wepkg.event.a() {
            public final void ct(Object obj) {
                AppMethodBeat.i(63364);
                if (obj instanceof ForceUpdateNotify) {
                    ForceUpdateNotify forceUpdateNotify = (ForceUpdateNotify) obj;
                    if (!(forceUpdateNotify == null || forceUpdateNotify.uWC == null || forceUpdateNotify.uWC.length <= 0)) {
                        for (String str : forceUpdateNotify.uWC) {
                            if (str.equals(a.dga()) || (!bo.isNullOrNil(c.this.mXy) && str.equals(c.this.mXy))) {
                                c.a(c.this, str);
                                AppMethodBeat.o(63364);
                                return;
                            }
                        }
                    }
                    AppMethodBeat.o(63364);
                    return;
                }
                if (obj instanceof DownloadBigPkgCompleteNotify) {
                    DownloadBigPkgCompleteNotify downloadBigPkgCompleteNotify = (DownloadBigPkgCompleteNotify) obj;
                    if (!(downloadBigPkgCompleteNotify == null || downloadBigPkgCompleteNotify.eBS == null || (!downloadBigPkgCompleteNotify.eBS.equals(a.dga()) && !downloadBigPkgCompleteNotify.eBS.equals(c.this.mXy)))) {
                        c.a(c.this, downloadBigPkgCompleteNotify.eBS, downloadBigPkgCompleteNotify.success);
                    }
                }
                AppMethodBeat.o(63364);
            }
        };
        com.tencent.mm.plugin.wepkg.event.c.a(this.uVy);
        AppMethodBeat.o(63368);
    }

    public final boolean bO(String str, boolean z) {
        AppMethodBeat.i(63369);
        this.mUH = str;
        this.mXy = d.aid(str);
        this.uVw = b.bN(str, z);
        if (!(this.uVw == null || this.uVw.uWY == null)) {
            this.uVv = true;
            this.uVx = this.uVw.uWY;
            com.tencent.mm.plugin.wepkg.utils.a.b("EnterWeb", this.mUH, this.uVx.eBS, this.uVx.version, 1, 0, null);
        }
        ab.i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", Boolean.valueOf(this.uVv), this.mXy);
        if (this.mUN == null) {
            int i;
            this.mUN = GameWebPerformanceInfo.kU(str);
            this.mUN.eBS = d.aid(str);
            GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
            if (this.uVv) {
                i = 1;
            } else {
                i = 0;
            }
            gameWebPerformanceInfo.eBL = i;
            this.mUN.eCn = a.dgb();
            this.mUN.eCo = dgj();
        }
        boolean z2 = this.uVv;
        AppMethodBeat.o(63369);
        return z2;
    }

    public final void ot(boolean z) {
        AppMethodBeat.i(63370);
        this.che.stopTimer();
        if (z && !bo.isNullOrNil(this.mXy)) {
            b.Dp(this.mXy);
            b.dgz().dP(this.mXy, 2);
        }
        b.dgg();
        com.tencent.mm.plugin.wepkg.event.c.b(this.uVy);
        AppMethodBeat.o(63370);
    }

    public final void j(WebView webView, String str) {
        AppMethodBeat.i(63371);
        ab.d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", str);
        this.aIv = System.currentTimeMillis();
        b(webView, ahB(str));
        AppMethodBeat.o(63371);
    }

    public final void k(WebView webView, String str) {
        AppMethodBeat.i(63372);
        ab.d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", str);
        if (this.aIv != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.aIv;
            String aid = d.aid(str);
            if (bo.isNullOrNil(aid)) {
                com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", str, "", null, 2, currentTimeMillis, null);
            } else if (!this.uVv || this.uVx == null) {
                com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", str, aid, null, 0, currentTimeMillis, null);
            } else {
                com.tencent.mm.plugin.wepkg.utils.a.b("PageLoadTime", str, this.uVx.eBS, this.uVx.version, 1, currentTimeMillis, null);
            }
            this.aIv = 0;
        }
        if (this.uVv && this.uVw != null && this.uVw.ahT(str)) {
            ab.i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
            this.che.ae(1000, 1000);
        }
        b(webView, ahB(str));
        AppMethodBeat.o(63372);
    }

    public final void a(ConsoleMessage consoleMessage) {
        AppMethodBeat.i(63373);
        this.uVB = true;
        String message = consoleMessage != null ? consoleMessage.message() : null;
        if (!bo.isNullOrNil(message) && message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
            ab.i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
            this.uVA = true;
        }
        AppMethodBeat.o(63373);
    }

    public final o ahA(String str) {
        o ahu;
        AppMethodBeat.i(63374);
        ab.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(str)));
        String ahy = b.ahy(str);
        if (ahy != null) {
            ab.i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(ahy)));
            ahu = a.ahu(ahy);
            if (ahu != null) {
                AppMethodBeat.o(63374);
                return ahu;
            } else if (!ahy.equals(this.mXy)) {
                this.uVz.ahR(str);
            }
        }
        if (this.uVv) {
            o ahS;
            if (this.uVw != null) {
                ahS = this.uVw.ahS(d.aif(str));
            } else {
                ahS = null;
            }
            if (ahS != null) {
                if (this.uVx != null) {
                    com.tencent.mm.plugin.wepkg.utils.a.b("RequestHook", str, this.uVx.eBS, this.uVx.version, 1, 0, null);
                }
                AppMethodBeat.o(63374);
                return ahS;
            }
        }
        ahu = this.uVz.ahS(d.aif(str));
        AppMethodBeat.o(63374);
        return ahu;
    }

    public final Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.i(63375);
        String str2 = "MicroMsg.Wepkg.WePkgPlugin";
        String str3 = "method = %s, bundler == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(bundle == null);
        ab.i(str2, str3, objArr);
        if (bo.isNullOrNil(str) || bundle == null) {
            AppMethodBeat.o(63375);
            return null;
        }
        if (this.uVv && this.uVw != null && str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
            String string = bundle.getString("url");
            ab.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(string)));
            if (!bo.isNullOrNil(string)) {
                ab.i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
                Object Kl = this.uVw.Kl(d.aif(string));
                if (!bo.isNullOrNil(Kl)) {
                    ab.i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(Kl)));
                    h.pYm.a(859, 14, 1, false);
                    AppMethodBeat.o(63375);
                    return Kl;
                }
            }
        }
        AppMethodBeat.o(63375);
        return null;
    }

    private void b(final WebView webView, final boolean z) {
        AppMethodBeat.i(63376);
        ab.i("MicroMsg.Wepkg.WePkgPlugin", "useWepkg:".concat(String.valueOf(z)));
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(63365);
                if (webView != null) {
                    webView.evaluateJavascript(String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[]{Boolean.valueOf(z)}), null);
                    AppMethodBeat.o(63365);
                    return;
                }
                ab.i("MicroMsg.Wepkg.WePkgPlugin", "injectWepkgState, webview == null");
                AppMethodBeat.o(63365);
            }
        });
        AppMethodBeat.o(63376);
    }

    public final boolean dgi() {
        return this.uVx == null || !this.uVx.uXG;
    }

    public final String dgj() {
        if (this.uVx != null) {
            return this.uVx.version;
        }
        return "";
    }

    public static String dgk() {
        AppMethodBeat.i(139116);
        String dgb = a.dgb();
        AppMethodBeat.o(139116);
        return dgb;
    }

    static {
        AppMethodBeat.i(63385);
        AppMethodBeat.o(63385);
    }

    public final boolean ahB(String str) {
        AppMethodBeat.i(63378);
        if (hnu.matcher(bo.nullAsNil(str)).find()) {
            AppMethodBeat.o(63378);
            return false;
        }
        boolean z = this.uVv;
        AppMethodBeat.o(63378);
        return z;
    }

    static /* synthetic */ void a(c cVar, String str) {
        AppMethodBeat.i(63379);
        cVar.uVF = System.currentTimeMillis();
        ab.i("MicroMsg.Wepkg.WePkgPlugin", "forceUpdatePageSrc, pkgId: %s, time: %d", str, Long.valueOf(cVar.uVF));
        cVar.uVE.add(str);
        if (!(cVar.uVC == null || !cVar.uVv || cVar.uVD)) {
            cVar.uVD = true;
            cVar.uVC.bDC();
        }
        a.aht(str);
        AppMethodBeat.o(63379);
    }

    static /* synthetic */ void a(c cVar, String str, boolean z) {
        AppMethodBeat.i(63380);
        ab.i("MicroMsg.Wepkg.WePkgPlugin", "downloadPkgCpl, pkgId: %s, success: %b", str, Boolean.valueOf(z));
        if (cVar.uVE.contains(str)) {
            String dgb;
            int i = z ? 1 : 2;
            long currentTimeMillis = System.currentTimeMillis() - cVar.uVF;
            String str2 = "forceUpdateTime";
            String str3 = cVar.mUH;
            if (cVar.mXy == null || !cVar.mXy.equals(str)) {
                if (a.dga().equals(str)) {
                    dgb = a.dgb();
                } else {
                    dgb = "";
                }
            } else if (cVar.uVx != null) {
                dgb = cVar.uVx.version;
            } else {
                dgb = "";
            }
            com.tencent.mm.plugin.wepkg.utils.a.b(str2, str3, str, dgb, (long) i, currentTimeMillis, null);
            cVar.uVE.remove(str);
            b.Dp(str);
        }
        a.bM(str, z);
        if (cVar.uVC != null && cVar.uVv && cVar.uVE.isEmpty()) {
            cVar.uVC.hL(z);
        }
        AppMethodBeat.o(63380);
    }

    static /* synthetic */ void e(c cVar) {
        AppMethodBeat.i(63381);
        ab.i("MicroMsg.Wepkg.WePkgPlugin", "reloadPage");
        if (cVar.uVv) {
            cVar.uVv = false;
            b.Dp(cVar.mXy);
        }
        if (cVar.uVC != null) {
            cVar.uVC.bDB();
        }
        AppMethodBeat.o(63381);
    }

    static /* synthetic */ int dgl() {
        AppMethodBeat.i(63382);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            int i = sharedPreferences.getInt("white_screen_times", 0);
            AppMethodBeat.o(63382);
            return i;
        }
        AppMethodBeat.o(63382);
        return 0;
    }

    static /* synthetic */ void dgm() {
        AppMethodBeat.i(63383);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            ab.i("MicroMsg.Wepkg.WePkgPlugin", "disableWePkg");
            sharedPreferences.edit().putBoolean("disable_we_pkg", true).commit();
        }
        AppMethodBeat.o(63383);
    }

    static /* synthetic */ void Kj(int i) {
        AppMethodBeat.i(63384);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("white_screen_times", i).commit();
        }
        AppMethodBeat.o(63384);
    }
}
