package com.tencent.p177mm.plugin.freewifi.p974e;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a;
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a.C39099a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28088a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28089d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.net.HttpURLConnection;

/* renamed from: com.tencent.mm.plugin.freewifi.e.h */
public final class C20787h extends C28079e implements C39102a {
    private String mwQ = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    private int mwR = 0;

    /* renamed from: com.tencent.mm.plugin.freewifi.e.h$2 */
    class C207902 implements C39099a {
        C207902() {
        }

        /* renamed from: g */
        public final void mo7408g(HttpURLConnection httpURLConnection) {
            AppMethodBeat.m2504i(20827);
            int responseCode = httpURLConnection.getResponseCode();
            C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", C34189m.m56063V(C20787h.this.intent), Integer.valueOf(C34189m.m56064W(C20787h.this.intent)), Integer.valueOf(responseCode));
            if (responseCode == 200) {
                C20787h.m32009a(C20787h.this, 0, "");
                C34189m.m56071a(C20787h.this.intent, C20787h.this.cuH, C20787h.this.mwG, C20787h.this.cdf, C20787h.this.mwF, "MicroMsg.FreeWifi.ProtocolThreeOne");
                AppMethodBeat.m2505o(20827);
            } else if (responseCode == 302) {
                C20787h.m32010a(C20787h.this, httpURLConnection.getHeaderField("Location"));
                AppMethodBeat.m2505o(20827);
            } else {
                C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", C34189m.m56063V(C20787h.this.intent), Integer.valueOf(C34189m.m56064W(C20787h.this.intent)));
                FreeWifiFrontPageUI freeWifiFrontPageUI = C20787h.this.mwF;
                C28089d c28089d = C28089d.FAIL;
                C28088a c28088a = new C28088a();
                c28088a.myI = C34189m.m56068a(C20787h.this.mwG, C11968b.ThreeOneAuth, 32);
                freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                C20787h.m32009a(C20787h.this, 32, "INVALID_HTTP_RESP_CODE");
                AppMethodBeat.m2505o(20827);
            }
        }

        /* renamed from: j */
        public final void mo7409j(Exception exception) {
            AppMethodBeat.m2504i(20828);
            C4990ab.m7413e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", C34189m.m56063V(C20787h.this.intent), Integer.valueOf(C34189m.m56064W(C20787h.this.intent)), exception.getMessage(), C34189m.m56078h(exception));
            FreeWifiFrontPageUI freeWifiFrontPageUI = C20787h.this.mwF;
            C28089d c28089d = C28089d.FAIL;
            C28088a c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(C20787h.this.mwG, C11968b.ThreeOneAuth, C34189m.m56079i(exception));
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            C20787h.m32009a(C20787h.this, C34189m.m56079i(exception), C34189m.m56077g(exception));
            AppMethodBeat.m2505o(20828);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m32009a(C20787h c20787h, int i, String str) {
        AppMethodBeat.m2504i(20832);
        c20787h.m32011aH(i, str);
        AppMethodBeat.m2505o(20832);
    }

    public C20787h(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.m2504i(20829);
        C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)), this.mwQ);
        AppMethodBeat.m2505o(20829);
    }

    public final void connect() {
        AppMethodBeat.m2504i(20830);
        C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)), this.mwQ);
        final String str = this.mwQ;
        C11976j.byZ().byI().post(new Runnable() {

            /* renamed from: com.tencent.mm.plugin.freewifi.e.h$1$1 */
            class C207891 implements C39099a {
                C207891() {
                }

                /* renamed from: g */
                public final void mo7408g(HttpURLConnection httpURLConnection) {
                    AppMethodBeat.m2504i(20824);
                    int responseCode = httpURLConnection.getResponseCode();
                    C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", C34189m.m56063V(C20787h.this.intent), Integer.valueOf(C34189m.m56064W(C20787h.this.intent)), Integer.valueOf(responseCode));
                    if (responseCode == 200) {
                        C20787h.m32009a(C20787h.this, 0, "");
                        C34189m.m56071a(C20787h.this.intent, C20787h.this.cuH, C20787h.this.mwG, C20787h.this.cdf, C20787h.this.mwF, "MicroMsg.FreeWifi.ProtocolThreeOne");
                        AppMethodBeat.m2505o(20824);
                    } else if (responseCode == 302) {
                        C20787h.m32010a(C20787h.this, httpURLConnection.getHeaderField("Location"));
                        AppMethodBeat.m2505o(20824);
                    } else {
                        C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", C34189m.m56063V(C20787h.this.intent), Integer.valueOf(C34189m.m56064W(C20787h.this.intent)));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = C20787h.this.mwF;
                        C28089d c28089d = C28089d.FAIL;
                        C28088a c28088a = new C28088a();
                        c28088a.myI = C34189m.m56068a(C20787h.this.mwG, C11968b.ThreeOneAuth, 32);
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        C20787h.m32009a(C20787h.this, 32, "INVALID_HTTP_RESP_CODE");
                        AppMethodBeat.m2505o(20824);
                    }
                }

                /* renamed from: j */
                public final void mo7409j(Exception exception) {
                    AppMethodBeat.m2504i(20825);
                    C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", C34189m.m56063V(C20787h.this.intent), Integer.valueOf(C34189m.m56064W(C20787h.this.intent)), exception.getMessage(), C34189m.m56078h(exception));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = C20787h.this.mwF;
                    C28089d c28089d = C28089d.FAIL;
                    C28088a c28088a = new C28088a();
                    c28088a.myI = C34189m.m56068a(C20787h.this.mwG, C11968b.ThreeOneAuth, C34189m.m56079i(exception));
                    freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                    C20787h.m32009a(C20787h.this, C34189m.m56079i(exception), C34189m.m56077g(exception));
                    AppMethodBeat.m2505o(20825);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(20826);
                C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", C34189m.m56063V(C20787h.this.intent), Integer.valueOf(C34189m.m56064W(C20787h.this.intent)), str);
                C45949a.byw();
                C45949a.m85337a(str, new C207891());
                AppMethodBeat.m2505o(20826);
            }
        });
        AppMethodBeat.m2505o(20830);
    }

    /* renamed from: aH */
    private void m32011aH(int i, String str) {
        AppMethodBeat.m2504i(20831);
        C11967a byo = C11966k.byo();
        byo.ssid = this.ssid;
        byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.ProtocolThreeOne");
        byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.ProtocolThreeOne");
        byo.cuH = this.cuH;
        byo.mud = this.appId;
        byo.kBq = C34189m.m56063V(this.intent);
        byo.mue = 31;
        byo.muf = C11968b.ThreeOneAuth.muQ;
        byo.mug = C11968b.ThreeOneAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = C34189m.m56066Y(this.intent);
        byo.byq().mo23810b(this.intent, i != 0).byp();
        AppMethodBeat.m2505o(20831);
    }

    /* renamed from: a */
    static /* synthetic */ void m32010a(C20787h c20787h, String str) {
        AppMethodBeat.m2504i(20833);
        c20787h.mwR++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        C28089d c28089d;
        C28088a c28088a;
        if (c20787h.mwR > 3) {
            C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", C34189m.m56063V(c20787h.intent), Integer.valueOf(C34189m.m56064W(c20787h.intent)));
            freeWifiFrontPageUI = c20787h.mwF;
            c28089d = C28089d.FAIL;
            c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(c20787h.mwG, C11968b.ThreeOneAuth, 33);
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            c20787h.m32011aH(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.m2505o(20833);
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", C34189m.m56063V(c20787h.intent), Integer.valueOf(C34189m.m56064W(c20787h.intent)), str);
        if (C34189m.isEmpty(str)) {
            freeWifiFrontPageUI = c20787h.mwF;
            c28089d = C28089d.FAIL;
            c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(c20787h.mwG, C11968b.ThreeOneAuth, 34);
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            c20787h.m32011aH(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.m2505o(20833);
            return;
        }
        C207902 c207902 = new C207902();
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(C8741b.METHOD))) {
            C45949a.byw();
            C45949a.m85338a(str, parse.getEncodedQuery(), c207902);
            AppMethodBeat.m2505o(20833);
            return;
        }
        C45949a.byw();
        C45949a.m85337a(str, c207902);
        AppMethodBeat.m2505o(20833);
    }
}
