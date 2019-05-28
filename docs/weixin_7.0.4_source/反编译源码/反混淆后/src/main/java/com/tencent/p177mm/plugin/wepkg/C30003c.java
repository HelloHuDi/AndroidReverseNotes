package com.tencent.p177mm.plugin.wepkg;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.webkit.ConsoleMessage;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.GameWebPerformanceInfo;
import com.tencent.p177mm.plugin.game.luggage.p432d.C3228d.C32322;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wepkg.event.C23201a;
import com.tencent.p177mm.plugin.wepkg.event.C35760c;
import com.tencent.p177mm.plugin.wepkg.event.C46472b;
import com.tencent.p177mm.plugin.wepkg.event.DownloadBigPkgCompleteNotify;
import com.tencent.p177mm.plugin.wepkg.event.ForceUpdateNotify;
import com.tencent.p177mm.plugin.wepkg.model.C30011b;
import com.tencent.p177mm.plugin.wepkg.model.C40398f;
import com.tencent.p177mm.plugin.wepkg.model.C44024d;
import com.tencent.p177mm.plugin.wepkg.model.WepkgVersion;
import com.tencent.p177mm.plugin.wepkg.utils.C30022d;
import com.tencent.p177mm.plugin.wepkg.utils.C35765a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.xweb.C31147o;
import com.tencent.xweb.WebView;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* renamed from: com.tencent.mm.plugin.wepkg.c */
public final class C30003c {
    private static final Pattern hnu = Pattern.compile(".*#.*wechat_redirect");
    private long aIv = 0;
    private C7564ap che = new C7564ap(new C300053(), false);
    private String mUH;
    private GameWebPerformanceInfo mUN;
    private String mXy;
    private boolean uVA = false;
    private boolean uVB = false;
    public C46472b uVC = new C32322();
    private boolean uVD = false;
    private Set<String> uVE = new HashSet();
    private long uVF;
    public boolean uVv = false;
    private C40398f uVw;
    private WepkgVersion uVx;
    private C23201a uVy;
    private C44024d uVz;

    /* renamed from: com.tencent.mm.plugin.wepkg.c$1 */
    class C249321 implements C23201a {
        C249321() {
        }

        /* renamed from: ct */
        public final void mo38823ct(Object obj) {
            AppMethodBeat.m2504i(63364);
            if (obj instanceof ForceUpdateNotify) {
                ForceUpdateNotify forceUpdateNotify = (ForceUpdateNotify) obj;
                if (!(forceUpdateNotify == null || forceUpdateNotify.uWC == null || forceUpdateNotify.uWC.length <= 0)) {
                    for (String str : forceUpdateNotify.uWC) {
                        if (str.equals(C46469a.dga()) || (!C5046bo.isNullOrNil(C30003c.this.mXy) && str.equals(C30003c.this.mXy))) {
                            C30003c.m47481a(C30003c.this, str);
                            AppMethodBeat.m2505o(63364);
                            return;
                        }
                    }
                }
                AppMethodBeat.m2505o(63364);
                return;
            }
            if (obj instanceof DownloadBigPkgCompleteNotify) {
                DownloadBigPkgCompleteNotify downloadBigPkgCompleteNotify = (DownloadBigPkgCompleteNotify) obj;
                if (!(downloadBigPkgCompleteNotify == null || downloadBigPkgCompleteNotify.eBS == null || (!downloadBigPkgCompleteNotify.eBS.equals(C46469a.dga()) && !downloadBigPkgCompleteNotify.eBS.equals(C30003c.this.mXy)))) {
                    C30003c.m47482a(C30003c.this, downloadBigPkgCompleteNotify.eBS, downloadBigPkgCompleteNotify.success);
                }
            }
            AppMethodBeat.m2505o(63364);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wepkg.c$3 */
    class C300053 implements C5015a {

        /* renamed from: com.tencent.mm.plugin.wepkg.c$3$1 */
        class C147991 implements Runnable {
            C147991() {
            }

            public final void run() {
                AppMethodBeat.m2504i(63366);
                try {
                    C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "load url from net");
                    C30003c.this.uVv = false;
                    C30003c.m47487e(C30003c.this);
                    int dgl = C30003c.dgl();
                    if (dgl > 1) {
                        if (C30003c.this.uVx != null) {
                            C35765a.m58633b("whiteScreen", C30003c.this.mUH, C30003c.this.uVx.eBS, C30003c.this.uVx.version, -1, 0, null);
                        }
                        C7060h.pYm.mo8378a(859, 13, 1, false);
                        String aid = C30022d.aid(C30003c.this.mUH);
                        C40393b.m69299Dp(aid);
                        C30011b.dgz().mo48248dP(aid, 1);
                        C30003c.dgm();
                        AppMethodBeat.m2505o(63366);
                        return;
                    }
                    C30003c.m47479Kj(dgl + 1);
                    AppMethodBeat.m2505o(63366);
                } catch (Exception e) {
                    AppMethodBeat.m2505o(63366);
                }
            }
        }

        C300053() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(63367);
            if (!C30003c.this.uVB || C30003c.this.uVA) {
                C30003c.m47479Kj(0);
            } else {
                C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "white screen");
                C5004al.m7441d(new C147991());
            }
            AppMethodBeat.m2505o(63367);
            return false;
        }
    }

    public C30003c() {
        AppMethodBeat.m2504i(63368);
        C40393b.dgd();
        this.uVz = new C44024d();
        C40393b.dge();
        this.uVy = new C249321();
        C35760c.m58626a(this.uVy);
        AppMethodBeat.m2505o(63368);
    }

    /* renamed from: bO */
    public final boolean mo48237bO(String str, boolean z) {
        AppMethodBeat.m2504i(63369);
        this.mUH = str;
        this.mXy = C30022d.aid(str);
        this.uVw = C40393b.m69300bN(str, z);
        if (!(this.uVw == null || this.uVw.uWY == null)) {
            this.uVv = true;
            this.uVx = this.uVw.uWY;
            C35765a.m58633b("EnterWeb", this.mUH, this.uVx.eBS, this.uVx.version, 1, 0, null);
        }
        C4990ab.m7417i("MicroMsg.Wepkg.WePkgPlugin", "wepkgAvailable:%s, pkgId:%s", Boolean.valueOf(this.uVv), this.mXy);
        if (this.mUN == null) {
            int i;
            this.mUN = GameWebPerformanceInfo.m63878kU(str);
            this.mUN.eBS = C30022d.aid(str);
            GameWebPerformanceInfo gameWebPerformanceInfo = this.mUN;
            if (this.uVv) {
                i = 1;
            } else {
                i = 0;
            }
            gameWebPerformanceInfo.eBL = i;
            this.mUN.eCn = C46469a.dgb();
            this.mUN.eCo = dgj();
        }
        boolean z2 = this.uVv;
        AppMethodBeat.m2505o(63369);
        return z2;
    }

    /* renamed from: ot */
    public final void mo48243ot(boolean z) {
        AppMethodBeat.m2504i(63370);
        this.che.stopTimer();
        if (z && !C5046bo.isNullOrNil(this.mXy)) {
            C40393b.m69299Dp(this.mXy);
            C30011b.dgz().mo48248dP(this.mXy, 2);
        }
        C40393b.dgg();
        C35760c.m58627b(this.uVy);
        AppMethodBeat.m2505o(63370);
    }

    /* renamed from: j */
    public final void mo48240j(WebView webView, String str) {
        AppMethodBeat.m2504i(63371);
        C4990ab.m7411d("MicroMsg.Wepkg.WePkgPlugin", "onPageStarted, url = %s", str);
        this.aIv = System.currentTimeMillis();
        m47483b(webView, ahB(str));
        AppMethodBeat.m2505o(63371);
    }

    /* renamed from: k */
    public final void mo48241k(WebView webView, String str) {
        AppMethodBeat.m2504i(63372);
        C4990ab.m7411d("MicroMsg.Wepkg.WePkgPlugin", "onPageFinished, url = %s", str);
        if (this.aIv != 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.aIv;
            String aid = C30022d.aid(str);
            if (C5046bo.isNullOrNil(aid)) {
                C35765a.m58633b("PageLoadTime", str, "", null, 2, currentTimeMillis, null);
            } else if (!this.uVv || this.uVx == null) {
                C35765a.m58633b("PageLoadTime", str, aid, null, 0, currentTimeMillis, null);
            } else {
                C35765a.m58633b("PageLoadTime", str, this.uVx.eBS, this.uVx.version, 1, currentTimeMillis, null);
            }
            this.aIv = 0;
        }
        if (this.uVv && this.uVw != null && this.uVw.ahT(str)) {
            C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "startTimer");
            this.che.mo16770ae(1000, 1000);
        }
        m47483b(webView, ahB(str));
        AppMethodBeat.m2505o(63372);
    }

    /* renamed from: a */
    public final void mo48234a(ConsoleMessage consoleMessage) {
        AppMethodBeat.m2504i(63373);
        this.uVB = true;
        String message = consoleMessage != null ? consoleMessage.message() : null;
        if (!C5046bo.isNullOrNil(message) && message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
            C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "mIsReceivedWhiteScreenEnd: true");
            this.uVA = true;
        }
        AppMethodBeat.m2505o(63373);
    }

    public final C31147o ahA(String str) {
        C31147o ahu;
        AppMethodBeat.m2504i(63374);
        C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, url: ".concat(String.valueOf(str)));
        String ahy = C40393b.ahy(str);
        if (ahy != null) {
            C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "onRequestIntercept, rid: ".concat(String.valueOf(ahy)));
            ahu = C46469a.ahu(ahy);
            if (ahu != null) {
                AppMethodBeat.m2505o(63374);
                return ahu;
            } else if (!ahy.equals(this.mXy)) {
                this.uVz.ahR(str);
            }
        }
        if (this.uVv) {
            C31147o ahS;
            if (this.uVw != null) {
                ahS = this.uVw.ahS(C30022d.aif(str));
            } else {
                ahS = null;
            }
            if (ahS != null) {
                if (this.uVx != null) {
                    C35765a.m58633b("RequestHook", str, this.uVx.eBS, this.uVx.version, 1, 0, null);
                }
                AppMethodBeat.m2505o(63374);
                return ahS;
            }
        }
        ahu = this.uVz.ahS(C30022d.aif(str));
        AppMethodBeat.m2505o(63374);
        return ahu;
    }

    public final Object onMiscCallBack(String str, Bundle bundle) {
        AppMethodBeat.m2504i(63375);
        String str2 = "MicroMsg.Wepkg.WePkgPlugin";
        String str3 = "method = %s, bundler == null ? %b";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Boolean.valueOf(bundle == null);
        C4990ab.m7417i(str2, str3, objArr);
        if (C5046bo.isNullOrNil(str) || bundle == null) {
            AppMethodBeat.m2505o(63375);
            return null;
        }
        if (this.uVv && this.uVw != null && str.equalsIgnoreCase("shouldInterceptMediaUrl")) {
            String string = bundle.getString("url");
            C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack origin mediaUrl:".concat(String.valueOf(string)));
            if (!C5046bo.isNullOrNil(string)) {
                C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "onMiscCallBack replace localPath");
                Object Kl = this.uVw.mo63814Kl(C30022d.aif(string));
                if (!C5046bo.isNullOrNil(Kl)) {
                    C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "localFile:".concat(String.valueOf(Kl)));
                    C7060h.pYm.mo8378a(859, 14, 1, false);
                    AppMethodBeat.m2505o(63375);
                    return Kl;
                }
            }
        }
        AppMethodBeat.m2505o(63375);
        return null;
    }

    /* renamed from: b */
    private void m47483b(final WebView webView, final boolean z) {
        AppMethodBeat.m2504i(63376);
        C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "useWepkg:".concat(String.valueOf(z)));
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(63365);
                if (webView != null) {
                    webView.evaluateJavascript(String.format("javascript:(function() {window.__usewepkg__=%s;})();", new Object[]{Boolean.valueOf(z)}), null);
                    AppMethodBeat.m2505o(63365);
                    return;
                }
                C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "injectWepkgState, webview == null");
                AppMethodBeat.m2505o(63365);
            }
        });
        AppMethodBeat.m2505o(63376);
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
        AppMethodBeat.m2504i(139116);
        String dgb = C46469a.dgb();
        AppMethodBeat.m2505o(139116);
        return dgb;
    }

    static {
        AppMethodBeat.m2504i(63385);
        AppMethodBeat.m2505o(63385);
    }

    public final boolean ahB(String str) {
        AppMethodBeat.m2504i(63378);
        if (hnu.matcher(C5046bo.nullAsNil(str)).find()) {
            AppMethodBeat.m2505o(63378);
            return false;
        }
        boolean z = this.uVv;
        AppMethodBeat.m2505o(63378);
        return z;
    }

    /* renamed from: a */
    static /* synthetic */ void m47481a(C30003c c30003c, String str) {
        AppMethodBeat.m2504i(63379);
        c30003c.uVF = System.currentTimeMillis();
        C4990ab.m7417i("MicroMsg.Wepkg.WePkgPlugin", "forceUpdatePageSrc, pkgId: %s, time: %d", str, Long.valueOf(c30003c.uVF));
        c30003c.uVE.add(str);
        if (!(c30003c.uVC == null || !c30003c.uVv || c30003c.uVD)) {
            c30003c.uVD = true;
            c30003c.uVC.bDC();
        }
        C46469a.aht(str);
        AppMethodBeat.m2505o(63379);
    }

    /* renamed from: a */
    static /* synthetic */ void m47482a(C30003c c30003c, String str, boolean z) {
        AppMethodBeat.m2504i(63380);
        C4990ab.m7417i("MicroMsg.Wepkg.WePkgPlugin", "downloadPkgCpl, pkgId: %s, success: %b", str, Boolean.valueOf(z));
        if (c30003c.uVE.contains(str)) {
            String dgb;
            int i = z ? 1 : 2;
            long currentTimeMillis = System.currentTimeMillis() - c30003c.uVF;
            String str2 = "forceUpdateTime";
            String str3 = c30003c.mUH;
            if (c30003c.mXy == null || !c30003c.mXy.equals(str)) {
                if (C46469a.dga().equals(str)) {
                    dgb = C46469a.dgb();
                } else {
                    dgb = "";
                }
            } else if (c30003c.uVx != null) {
                dgb = c30003c.uVx.version;
            } else {
                dgb = "";
            }
            C35765a.m58633b(str2, str3, str, dgb, (long) i, currentTimeMillis, null);
            c30003c.uVE.remove(str);
            C40393b.m69299Dp(str);
        }
        C46469a.m87645bM(str, z);
        if (c30003c.uVC != null && c30003c.uVv && c30003c.uVE.isEmpty()) {
            c30003c.uVC.mo7567hL(z);
        }
        AppMethodBeat.m2505o(63380);
    }

    /* renamed from: e */
    static /* synthetic */ void m47487e(C30003c c30003c) {
        AppMethodBeat.m2504i(63381);
        C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "reloadPage");
        if (c30003c.uVv) {
            c30003c.uVv = false;
            C40393b.m69299Dp(c30003c.mXy);
        }
        if (c30003c.uVC != null) {
            c30003c.uVC.bDB();
        }
        AppMethodBeat.m2505o(63381);
    }

    static /* synthetic */ int dgl() {
        AppMethodBeat.m2504i(63382);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            int i = sharedPreferences.getInt("white_screen_times", 0);
            AppMethodBeat.m2505o(63382);
            return i;
        }
        AppMethodBeat.m2505o(63382);
        return 0;
    }

    static /* synthetic */ void dgm() {
        AppMethodBeat.m2504i(63383);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            C4990ab.m7416i("MicroMsg.Wepkg.WePkgPlugin", "disableWePkg");
            sharedPreferences.edit().putBoolean("disable_we_pkg", true).commit();
        }
        AppMethodBeat.m2505o(63383);
    }

    /* renamed from: Kj */
    static /* synthetic */ void m47479Kj(int i) {
        AppMethodBeat.m2504i(63384);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("we_pkg_sp", 4);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("white_screen_times", i).commit();
        }
        AppMethodBeat.m2505o(63384);
    }
}
