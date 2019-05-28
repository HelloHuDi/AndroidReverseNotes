package com.tencent.p177mm.plugin.freewifi.p974e;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C28067a;
import com.tencent.p177mm.plugin.freewifi.C28067a.C20777a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.C45955h.C39112b;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a;
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a.C39099a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28088a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28089d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

/* renamed from: com.tencent.mm.plugin.freewifi.e.j */
public final class C43110j extends C28079e implements C39102a {
    String cvO = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    private C28067a mwL;
    private int mwR = 0;
    String mxc = this.intent.getStringExtra("free_wifi_tid");
    String openId = this.intent.getStringExtra("free_wifi_openid");
    String sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");

    /* renamed from: com.tencent.mm.plugin.freewifi.e.j$1 */
    class C431081 implements Runnable {
        C431081() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20845);
            C43110j.m76639a(C43110j.this);
            AppMethodBeat.m2505o(20845);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.e.j$2 */
    class C431092 implements C20777a {
        C431092() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(20853);
            C11967a byo = C11966k.byo();
            byo.ssid = C43110j.this.ssid;
            byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol32");
            byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol32");
            byo.cuH = C43110j.this.cuH;
            byo.mud = C43110j.this.appId;
            byo.kBq = C34189m.m56063V(C43110j.this.intent);
            byo.mue = C34189m.m56065X(C43110j.this.intent);
            byo.muf = C11968b.AddNetwork.muQ;
            byo.mug = C11968b.AddNetwork.name;
            byo.result = 0;
            byo.cIb = C34189m.m56066Y(C43110j.this.intent);
            byo.byq().byp();
            final String byl = C39112b.mtY.byl();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), C43110j.this.ssid, byl);
            C119591 c119591 = new C39099a() {
                int mxe = 0;
                private final int mxf = 3;
                private int mxg = 0;
                private C39099a mxh = new C119581();

                /* renamed from: com.tencent.mm.plugin.freewifi.e.j$2$1$1 */
                class C119581 implements C39099a {
                    C119581() {
                    }

                    /* renamed from: g */
                    public final void mo7408g(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.m2504i(20846);
                        int responseCode = httpURLConnection.getResponseCode();
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        C28089d c28089d;
                        C28088a c28088a;
                        if (responseCode == 200) {
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)));
                            freeWifiFrontPageUI = C43110j.this.mwF;
                            c28089d = C28089d.FAIL;
                            c28088a = new C28088a();
                            c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoBlack, 35);
                            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                            C43110j.m76640a(C43110j.this, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                            AppMethodBeat.m2505o(20846);
                        } else if (responseCode == 302) {
                            C119591.m19845a(C119591.this, httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.m2505o(20846);
                        } else {
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)));
                            freeWifiFrontPageUI = C43110j.this.mwF;
                            c28089d = C28089d.FAIL;
                            c28088a = new C28088a();
                            c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoBlack, 32);
                            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                            C43110j.m76640a(C43110j.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.m2505o(20846);
                        }
                    }

                    /* renamed from: j */
                    public final void mo7409j(Exception exception) {
                        AppMethodBeat.m2504i(20847);
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), exception.getMessage(), C34189m.m56078h(exception));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = C43110j.this.mwF;
                        C28089d c28089d = C28089d.FAIL;
                        C28088a c28088a = new C28088a();
                        c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoBlack, C34189m.m56079i(exception));
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        C43110j.m76640a(C43110j.this, C34189m.m56079i(exception), C34189m.m56077g(exception));
                        AppMethodBeat.m2505o(20847);
                    }
                }

                /* renamed from: a */
                static /* synthetic */ void m19845a(C119591 c119591, String str) {
                    AppMethodBeat.m2504i(20852);
                    c119591.m19844MI(str);
                    AppMethodBeat.m2505o(20852);
                }

                /* renamed from: g */
                public final void mo7408g(HttpURLConnection httpURLConnection) {
                    AppMethodBeat.m2504i(20849);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == 200) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)));
                        C43110j.m76640a(C43110j.this, 0, "");
                        C34189m.m56071a(C43110j.this.intent, C43110j.this.cuH, C43110j.this.mwG, C43110j.this.cdf, C43110j.this.mwF, "MicroMsg.FreeWifi.Protocol32");
                        AppMethodBeat.m2505o(20849);
                    } else if (responseCode == 302) {
                        m19844MI(httpURLConnection.getHeaderField("Location"));
                        AppMethodBeat.m2505o(20849);
                    } else {
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = C43110j.this.mwF;
                        C28089d c28089d = C28089d.FAIL;
                        C28088a c28088a = new C28088a();
                        c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoBlack, 32);
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        C43110j.m76643b(C43110j.this, 32, "INVALID_HTTP_RESP_CODE");
                        AppMethodBeat.m2505o(20849);
                    }
                }

                /* renamed from: j */
                public final void mo7409j(Exception exception) {
                    FreeWifiFrontPageUI freeWifiFrontPageUI;
                    C28089d c28089d;
                    C28088a c28088a;
                    AppMethodBeat.m2504i(20850);
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), exception.getMessage(), C34189m.m56078h(exception));
                    if (exception instanceof UnknownHostException) {
                        C43110j.m76643b(C43110j.this, 102, C34189m.m56077g(exception));
                        C4990ab.m7416i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.mxe);
                        int i = this.mxe + 1;
                        this.mxe = i;
                        if (i <= 3) {
                            try {
                                Thread.sleep(3000);
                                C45949a.byw();
                                C45949a.m85337a(byl, this);
                                AppMethodBeat.m2505o(20850);
                                return;
                            } catch (InterruptedException e) {
                                C4990ab.m7413e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", C34189m.m56078h(exception));
                                C43110j.m76643b(C43110j.this, 103, C34189m.m56077g(exception));
                                freeWifiFrontPageUI = C43110j.this.mwF;
                                c28089d = C28089d.FAIL;
                                c28088a = new C28088a();
                                c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoBlack, 103);
                                freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                                AppMethodBeat.m2505o(20850);
                                return;
                            }
                        }
                        freeWifiFrontPageUI = C43110j.this.mwF;
                        c28089d = C28089d.FAIL;
                        c28088a = new C28088a();
                        c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoBlack, C34189m.m56079i(exception));
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        C43110j.m76643b(C43110j.this, C34189m.m56079i(exception), C34189m.m56077g(exception));
                        AppMethodBeat.m2505o(20850);
                        return;
                    }
                    freeWifiFrontPageUI = C43110j.this.mwF;
                    c28089d = C28089d.FAIL;
                    c28088a = new C28088a();
                    c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoBlack, C34189m.m56079i(exception));
                    freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                    C43110j.m76643b(C43110j.this, C34189m.m56079i(exception), C34189m.m56077g(exception));
                    AppMethodBeat.m2505o(20850);
                }

                /* renamed from: MI */
                private void m19844MI(String str) {
                    AppMethodBeat.m2504i(20851);
                    Uri parse = Uri.parse(str);
                    String queryParameter = parse.getQueryParameter("authUrl");
                    String Mw = C34189m.m56058Mw(parse.getQueryParameter("extend"));
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), str, queryParameter, Mw);
                    if (C34189m.isEmpty(queryParameter)) {
                        this.mxg++;
                        if (this.mxg < 3) {
                            C45949a.byw();
                            C45949a.m85337a(str, this.mxh);
                            AppMethodBeat.m2505o(20851);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = C43110j.this.mwF;
                        C28089d c28089d = C28089d.FAIL;
                        C28088a c28088a = new C28088a();
                        c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoBlack, 36);
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        C43110j.m76640a(C43110j.this, 36, "BLACK_302_TIMES_EXCESS");
                        AppMethodBeat.m2505o(20851);
                        return;
                    }
                    StringBuilder stringBuilder = new StringBuilder(queryParameter);
                    if (queryParameter.indexOf("?") != -1) {
                        stringBuilder.append("&extend=").append(Mw);
                    } else {
                        stringBuilder.append("?extend=").append(Mw);
                    }
                    stringBuilder.append("&openId=").append(C34189m.m56058Mw(C43110j.this.openId)).append("&tid=").append(C34189m.m56058Mw(C43110j.this.mxc)).append("&timestamp=").append(C43110j.this.cvO).append("&sign=").append(C43110j.this.sign);
                    C43110j.m76641a(C43110j.this, stringBuilder.toString());
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), stringBuilder.toString());
                    AppMethodBeat.m2505o(20851);
                }
            };
            C45949a.byw();
            C45949a.m85337a(byl, c119591);
            AppMethodBeat.m2505o(20853);
        }

        public final void onFail(int i) {
            AppMethodBeat.m2504i(20854);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), C43110j.this.ssid, Integer.valueOf(i));
            FreeWifiFrontPageUI freeWifiFrontPageUI = C43110j.this.mwF;
            C28089d c28089d = C28089d.FAIL;
            C28088a c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.AddNetwork, i);
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            C11967a byo = C11966k.byo();
            byo.ssid = C43110j.this.ssid;
            byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol32");
            byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol32");
            byo.cuH = C43110j.this.cuH;
            byo.mud = C43110j.this.appId;
            byo.kBq = C34189m.m56063V(C43110j.this.intent);
            byo.mue = C34189m.m56065X(C43110j.this.intent);
            byo.mug = C11968b.AddNetwork.name;
            byo.muf = C11968b.AddNetwork.muQ;
            byo.result = i;
            byo.cIb = C34189m.m56066Y(C43110j.this.intent);
            byo.byq().byp();
            AppMethodBeat.m2505o(20854);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.e.j$4 */
    class C431114 implements C39099a {
        C431114() {
        }

        /* renamed from: g */
        public final void mo7408g(HttpURLConnection httpURLConnection) {
            AppMethodBeat.m2504i(20858);
            int responseCode = httpURLConnection.getResponseCode();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), Integer.valueOf(responseCode));
            if (responseCode == 200) {
                C43110j.m76640a(C43110j.this, 0, "");
                C34189m.m56071a(C43110j.this.intent, C43110j.this.cuH, C43110j.this.mwG, C43110j.this.cdf, C43110j.this.mwF, "MicroMsg.FreeWifi.Protocol32");
                AppMethodBeat.m2505o(20858);
            } else if (responseCode == 302) {
                C43110j.m76644b(C43110j.this, httpURLConnection.getHeaderField("Location"));
                AppMethodBeat.m2505o(20858);
            } else {
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)));
                FreeWifiFrontPageUI freeWifiFrontPageUI = C43110j.this.mwF;
                C28089d c28089d = C28089d.FAIL;
                C28088a c28088a = new C28088a();
                c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoAuth, 32);
                freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                C43110j.m76640a(C43110j.this, 32, "INVALID_HTTP_RESP_CODE");
                AppMethodBeat.m2505o(20858);
            }
        }

        /* renamed from: j */
        public final void mo7409j(Exception exception) {
            AppMethodBeat.m2504i(20859);
            C4990ab.m7413e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), exception.getMessage(), C34189m.m56078h(exception));
            FreeWifiFrontPageUI freeWifiFrontPageUI = C43110j.this.mwF;
            C28089d c28089d = C28089d.FAIL;
            C28088a c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoAuth, C34189m.m56079i(exception));
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            C43110j.m76640a(C43110j.this, C34189m.m56079i(exception), C34189m.m56077g(exception));
            AppMethodBeat.m2505o(20859);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m76640a(C43110j c43110j, int i, String str) {
        AppMethodBeat.m2504i(20864);
        c43110j.m76642aI(i, str);
        AppMethodBeat.m2505o(20864);
    }

    public C43110j(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.m2504i(20860);
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)), this.openId, this.mxc, this.cvO, this.sign);
        AppMethodBeat.m2505o(20860);
    }

    public final void connect() {
        AppMethodBeat.m2504i(20861);
        this.mwL = new C28067a(this.ssid, this.mwF);
        C11976j.byZ().byI().post(new C431081());
        AppMethodBeat.m2505o(20861);
    }

    /* renamed from: aI */
    private void m76642aI(int i, String str) {
        AppMethodBeat.m2504i(20862);
        C11967a byo = C11966k.byo();
        byo.ssid = this.ssid;
        byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol32");
        byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol32");
        byo.cuH = this.cuH;
        byo.mud = this.appId;
        byo.kBq = C34189m.m56063V(this.intent);
        byo.mue = 32;
        byo.muf = C11968b.ThreeTwoAuth.muQ;
        byo.mug = C11968b.ThreeTwoAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = C34189m.m56066Y(this.intent);
        byo.byq().byp();
        AppMethodBeat.m2505o(20862);
    }

    /* renamed from: a */
    static /* synthetic */ void m76639a(C43110j c43110j) {
        AppMethodBeat.m2504i(20863);
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", C34189m.m56063V(c43110j.intent), Integer.valueOf(C34189m.m56064W(c43110j.intent)), c43110j.ssid);
        c43110j.mwL.mo45989a(new C431092());
        AppMethodBeat.m2505o(20863);
    }

    /* renamed from: b */
    static /* synthetic */ void m76643b(C43110j c43110j, int i, String str) {
        AppMethodBeat.m2504i(20865);
        C11967a byo = C11966k.byo();
        byo.ssid = c43110j.ssid;
        byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol32");
        byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol32");
        byo.cuH = c43110j.cuH;
        byo.mud = c43110j.appId;
        byo.kBq = C34189m.m56063V(c43110j.intent);
        byo.mue = 32;
        byo.muf = C11968b.ThreeTwoAuth.muQ;
        byo.mug = C11968b.ThreeTwoAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = C34189m.m56066Y(c43110j.intent);
        byo.byq().byp();
        AppMethodBeat.m2505o(20865);
    }

    /* renamed from: a */
    static /* synthetic */ void m76641a(C43110j c43110j, final String str) {
        AppMethodBeat.m2504i(20866);
        C11976j.byZ().byI().post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.freewifi.e.j$3$1 */
            class C207941 implements C39099a {
                C207941() {
                }

                /* renamed from: g */
                public final void mo7408g(HttpURLConnection httpURLConnection) {
                    AppMethodBeat.m2504i(20855);
                    int responseCode = httpURLConnection.getResponseCode();
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), Integer.valueOf(responseCode));
                    if (responseCode == 200) {
                        C43110j.m76640a(C43110j.this, 0, "");
                        C34189m.m56071a(C43110j.this.intent, C43110j.this.cuH, C43110j.this.mwG, C43110j.this.cdf, C43110j.this.mwF, "MicroMsg.FreeWifi.Protocol32");
                        AppMethodBeat.m2505o(20855);
                    } else if (responseCode == 302) {
                        C43110j.m76644b(C43110j.this, httpURLConnection.getHeaderField("Location"));
                        AppMethodBeat.m2505o(20855);
                    } else {
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = C43110j.this.mwF;
                        C28089d c28089d = C28089d.FAIL;
                        C28088a c28088a = new C28088a();
                        c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoAuth, 32);
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        C43110j.m76640a(C43110j.this, 32, "INVALID_HTTP_RESP_CODE");
                        AppMethodBeat.m2505o(20855);
                    }
                }

                /* renamed from: j */
                public final void mo7409j(Exception exception) {
                    AppMethodBeat.m2504i(20856);
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), exception.getMessage(), C34189m.m56078h(exception));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = C43110j.this.mwF;
                    C28089d c28089d = C28089d.FAIL;
                    C28088a c28088a = new C28088a();
                    c28088a.myI = C34189m.m56068a(C43110j.this.mwG, C11968b.ThreeTwoAuth, C34189m.m56079i(exception));
                    freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                    C43110j.m76640a(C43110j.this, C34189m.m56079i(exception), C34189m.m56077g(exception));
                    AppMethodBeat.m2505o(20856);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(20857);
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", C34189m.m56063V(C43110j.this.intent), Integer.valueOf(C34189m.m56064W(C43110j.this.intent)), str);
                C45949a.byw();
                C45949a.m85337a(str, new C207941());
                AppMethodBeat.m2505o(20857);
            }
        });
        AppMethodBeat.m2505o(20866);
    }

    /* renamed from: b */
    static /* synthetic */ void m76644b(C43110j c43110j, String str) {
        AppMethodBeat.m2504i(20867);
        c43110j.mwR++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        C28089d c28089d;
        C28088a c28088a;
        if (c43110j.mwR > 3) {
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", C34189m.m56063V(c43110j.intent), Integer.valueOf(C34189m.m56064W(c43110j.intent)));
            freeWifiFrontPageUI = c43110j.mwF;
            c28089d = C28089d.FAIL;
            c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(c43110j.mwG, C11968b.ThreeTwoAuth, 33);
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            c43110j.m76642aI(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.m2505o(20867);
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", C34189m.m56063V(c43110j.intent), Integer.valueOf(C34189m.m56064W(c43110j.intent)), str);
        if (C34189m.isEmpty(str)) {
            freeWifiFrontPageUI = c43110j.mwF;
            c28089d = C28089d.FAIL;
            c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(c43110j.mwG, C11968b.ThreeTwoAuth, 34);
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            c43110j.m76642aI(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.m2505o(20867);
            return;
        }
        C431114 c431114 = new C431114();
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(C8741b.METHOD))) {
            C45949a.byw();
            C45949a.m85338a(str, parse.getEncodedQuery(), c431114);
            AppMethodBeat.m2505o(20867);
            return;
        }
        C45949a.byw();
        C45949a.m85337a(str, c431114);
        AppMethodBeat.m2505o(20867);
    }
}
