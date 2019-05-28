package com.tencent.p177mm.plugin.freewifi.p974e;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.freewifi.C11966k;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11967a;
import com.tencent.p177mm.plugin.freewifi.C11966k.C11968b;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a;
import com.tencent.p177mm.plugin.freewifi.p1549a.C45949a.C39099a;
import com.tencent.p177mm.plugin.freewifi.p416d.C44738f;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiErrorUI;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C11988b;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28088a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28089d;
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.net.HttpURLConnection;

/* renamed from: com.tencent.mm.plugin.freewifi.e.i */
public final class C43107i extends C28079e implements C39102a {
    protected String cvO;
    private int mwR;
    protected String mwU;
    protected String mwV;
    protected String mwW;
    private Uri mwX;
    private String mwY;
    protected String sign;

    /* renamed from: com.tencent.mm.plugin.freewifi.e.i$2 */
    class C207932 implements C39099a {
        C207932() {
        }

        /* renamed from: g */
        public final void mo7408g(HttpURLConnection httpURLConnection) {
            AppMethodBeat.m2504i(20837);
            int responseCode = httpURLConnection.getResponseCode();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", C34189m.m56063V(C43107i.this.intent), Integer.valueOf(C34189m.m56064W(C43107i.this.intent)), Integer.valueOf(responseCode));
            if (responseCode == 200) {
                C43107i.this.bzv();
                AppMethodBeat.m2505o(20837);
            } else if (responseCode == 302) {
                C43107i.m76638a(C43107i.this, httpURLConnection.getHeaderField("Location"));
                AppMethodBeat.m2505o(20837);
            } else {
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", C34189m.m56063V(C43107i.this.intent), Integer.valueOf(C34189m.m56064W(C43107i.this.intent)));
                FreeWifiFrontPageUI freeWifiFrontPageUI = C43107i.this.mwF;
                C28089d c28089d = C28089d.FAIL;
                C28088a c28088a = new C28088a();
                c28088a.myI = C34189m.m56068a(C43107i.this.mwG, C11968b.ThreeThreeAuth, 32);
                freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                AppMethodBeat.m2505o(20837);
            }
        }

        /* renamed from: j */
        public final void mo7409j(Exception exception) {
            AppMethodBeat.m2504i(20838);
            C4990ab.m7413e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", C34189m.m56063V(C43107i.this.intent), Integer.valueOf(C34189m.m56064W(C43107i.this.intent)), exception.getMessage(), C34189m.m56078h(exception));
            FreeWifiFrontPageUI freeWifiFrontPageUI = C43107i.this.mwF;
            C28089d c28089d = C28089d.FAIL;
            C28088a c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(C43107i.this.mwG, C11968b.ThreeThreeAuth, C34189m.m56079i(exception));
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            AppMethodBeat.m2505o(20838);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.e.i$3 */
    class C431063 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.freewifi.e.i$3$1 */
        class C431051 implements C1202f {
            C431051() {
            }

            public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
                AppMethodBeat.m2504i(20839);
                C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", C34189m.m56063V(C43107i.this.intent), Integer.valueOf(C34189m.m56064W(C43107i.this.intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
                C11967a byo = C11966k.byo();
                byo.ssid = C43107i.this.ssid;
                byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol33");
                byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol33");
                byo.cuH = C43107i.this.cuH;
                byo.kBq = C34189m.m56063V(C43107i.this.intent);
                byo.mue = C34189m.m56065X(C43107i.this.intent);
                byo.muf = C11968b.GetBackPage33Return.muQ;
                byo.mug = C11968b.GetBackPage33Return.name;
                byo.cIb = C34189m.m56066Y(C43107i.this.intent);
                byo.result = i2;
                byo.ehr = str;
                byo.byq().byp();
                FreeWifiFrontPageUI freeWifiFrontPageUI;
                C28089d c28089d;
                C28088a c28088a;
                if (i == 0 && i2 == 0) {
                    C23391gj bzj = ((C44738f) c1207m).bzj();
                    if (bzj != null) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ, bzj.vIF);
                        FreeWifiFrontPageUI freeWifiFrontPageUI2 = C43107i.this.mwF;
                        C28089d c28089d2 = C28089d.SUCCESS;
                        C11988b c11988b = new C11988b();
                        c11988b.mzh = bzj;
                        freeWifiFrontPageUI2.mo62019a(c28089d2, c11988b);
                        AppMethodBeat.m2505o(20839);
                        return;
                    }
                    freeWifiFrontPageUI = C43107i.this.mwF;
                    c28089d = C28089d.FAIL;
                    c28088a = new C28088a();
                    c28088a.myI = C34189m.m56068a(C43107i.this.mwG, C11968b.GetBackPage33Return, 20);
                    freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                    AppMethodBeat.m2505o(20839);
                } else if (i2 == -30032) {
                    Intent intent = new Intent();
                    intent.putExtra("free_wifi_error_ui_error_msg", C43107i.this.mwF.getString(C25738R.string.bzv));
                    intent.setClass(C43107i.this.mwF, FreeWifiErrorUI.class);
                    C43107i.this.mwF.finish();
                    C43107i.this.mwF.startActivity(intent);
                    AppMethodBeat.m2505o(20839);
                } else {
                    freeWifiFrontPageUI = C43107i.this.mwF;
                    c28089d = C28089d.FAIL;
                    c28088a = new C28088a();
                    c28088a.myH = C25738R.string.bzq;
                    c28088a.myI = C34189m.m56068a(C43107i.this.mwG, C11968b.GetBackPage33Return, i2);
                    freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                    AppMethodBeat.m2505o(20839);
                }
            }
        }

        C431063() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20840);
            C11967a byo = C11966k.byo();
            byo.ssid = C43107i.this.ssid;
            byo.bssid = C34189m.m56060My("MicroMsg.FreeWifi.Protocol33");
            byo.cuI = C34189m.m56061Mz("MicroMsg.FreeWifi.Protocol33");
            byo.cuH = C43107i.this.cuH;
            byo.kBq = C34189m.m56063V(C43107i.this.intent);
            byo.mue = C43107i.this.mwG;
            byo.muf = C11968b.GetBackPage33.muQ;
            byo.mug = C11968b.GetBackPage33.name;
            byo.cIb = C34189m.m56066Y(C43107i.this.intent);
            byo.result = 0;
            byo.byq().byp();
            String byK = C45957d.byK();
            String byO = C45957d.byO();
            int byL = C45957d.byL();
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", C34189m.m56063V(C43107i.this.intent), Integer.valueOf(C34189m.m56064W(C43107i.this.intent)), "", byK, byO, Integer.valueOf(byL));
            new C44738f(C43107i.this.ssid, C34189m.m56060My("MicroMsg.FreeWifi.Protocol33"), C43107i.this.appId, C43107i.this.mwU, C43107i.this.mwV, C43107i.this.mwW, C43107i.this.cvO, C43107i.this.sign).mo68619c(new C431051());
            AppMethodBeat.m2505o(20840);
        }
    }

    public C43107i(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.m2504i(20841);
        this.mwR = 0;
        this.mwY = this.intent.getStringExtra("free_wifi_schema_uri");
        this.mwX = Uri.parse(this.mwY);
        this.appId = this.mwX.getQueryParameter("appId");
        this.mwU = this.mwX.getQueryParameter("shopId");
        this.mwV = this.mwX.getQueryParameter("authUrl");
        this.mwW = this.mwX.getQueryParameter("extend");
        this.cvO = this.mwX.getQueryParameter(Param.TIMESTAMP);
        this.sign = this.mwX.getQueryParameter("sign");
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)), this.mwX, this.appId, this.mwU, this.mwV, this.mwW, this.cvO, this.sign);
        AppMethodBeat.m2505o(20841);
    }

    public final void connect() {
        AppMethodBeat.m2504i(20842);
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        C28089d c28089d;
        C28088a c28088a;
        if (C34189m.isEmpty(this.ssid)) {
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)));
            freeWifiFrontPageUI = this.mwF;
            c28089d = C28089d.FAIL;
            c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(this.mwG, C11968b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            AppMethodBeat.m2505o(20842);
        } else if (C34189m.isEmpty(this.mwV)) {
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", C34189m.m56063V(this.intent), Integer.valueOf(C34189m.m56064W(this.intent)));
            freeWifiFrontPageUI = this.mwF;
            c28089d = C28089d.FAIL;
            c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(this.mwG, C11968b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            AppMethodBeat.m2505o(20842);
        } else {
            StringBuilder stringBuilder = new StringBuilder(this.mwV);
            if (this.mwV.indexOf("?") == -1) {
                stringBuilder.append("?extend=").append(this.mwW);
            } else {
                stringBuilder.append("&extend=").append(this.mwW);
            }
            final String stringBuilder2 = stringBuilder.toString();
            C11976j.byZ().byI().post(new Runnable() {

                /* renamed from: com.tencent.mm.plugin.freewifi.e.i$1$1 */
                class C207911 implements C39099a {
                    C207911() {
                    }

                    /* renamed from: g */
                    public final void mo7408g(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.m2504i(20834);
                        int responseCode = httpURLConnection.getResponseCode();
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", C34189m.m56063V(C43107i.this.intent), Integer.valueOf(C34189m.m56064W(C43107i.this.intent)), Integer.valueOf(responseCode));
                        if (responseCode == 200) {
                            C43107i.this.bzv();
                            AppMethodBeat.m2505o(20834);
                        } else if (responseCode == 302) {
                            C43107i.m76638a(C43107i.this, httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.m2505o(20834);
                        } else {
                            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", C34189m.m56063V(C43107i.this.intent), Integer.valueOf(C34189m.m56064W(C43107i.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = C43107i.this.mwF;
                            C28089d c28089d = C28089d.FAIL;
                            C28088a c28088a = new C28088a();
                            c28088a.myI = C34189m.m56068a(C43107i.this.mwG, C11968b.ThreeThreeAuth, 32);
                            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                            AppMethodBeat.m2505o(20834);
                        }
                    }

                    /* renamed from: j */
                    public final void mo7409j(Exception exception) {
                        AppMethodBeat.m2504i(20835);
                        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", C34189m.m56063V(C43107i.this.intent), Integer.valueOf(C34189m.m56064W(C43107i.this.intent)), exception.getMessage(), C34189m.m56078h(exception));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = C43107i.this.mwF;
                        C28089d c28089d = C28089d.FAIL;
                        C28088a c28088a = new C28088a();
                        c28088a.myI = C34189m.m56068a(C43107i.this.mwG, C11968b.ThreeThreeAuth, C34189m.m56079i(exception));
                        freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
                        AppMethodBeat.m2505o(20835);
                    }
                }

                public final void run() {
                    AppMethodBeat.m2504i(20836);
                    C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", C34189m.m56063V(C43107i.this.intent), Integer.valueOf(C34189m.m56064W(C43107i.this.intent)), stringBuilder2);
                    C45949a.byw();
                    C45949a.m85337a(stringBuilder2, new C207911());
                    AppMethodBeat.m2505o(20836);
                }
            });
            AppMethodBeat.m2505o(20842);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzv() {
        AppMethodBeat.m2504i(20843);
        C11976j.byZ().byI().post(new C431063());
        AppMethodBeat.m2505o(20843);
    }

    /* renamed from: a */
    static /* synthetic */ void m76638a(C43107i c43107i, String str) {
        AppMethodBeat.m2504i(20844);
        c43107i.mwR++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        C28089d c28089d;
        C28088a c28088a;
        if (c43107i.mwR > 3) {
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", C34189m.m56063V(c43107i.intent), Integer.valueOf(C34189m.m56064W(c43107i.intent)));
            freeWifiFrontPageUI = c43107i.mwF;
            c28089d = C28089d.FAIL;
            c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(c43107i.mwG, C11968b.ThreeThreeAuth, 33);
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            AppMethodBeat.m2505o(20844);
            return;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", C34189m.m56063V(c43107i.intent), Integer.valueOf(C34189m.m56064W(c43107i.intent)), str);
        if (C34189m.isEmpty(str)) {
            freeWifiFrontPageUI = c43107i.mwF;
            c28089d = C28089d.FAIL;
            c28088a = new C28088a();
            c28088a.myI = C34189m.m56068a(c43107i.mwG, C11968b.ThreeThreeAuth, 34);
            freeWifiFrontPageUI.mo62019a(c28089d, c28088a);
            AppMethodBeat.m2505o(20844);
            return;
        }
        C207932 c207932 = new C207932();
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(C8741b.METHOD))) {
            C45949a.byw();
            C45949a.m85338a(str, parse.getEncodedQuery(), c207932);
            AppMethodBeat.m2505o(20844);
            return;
        }
        C45949a.byw();
        C45949a.m85337a(str, c207932);
        AppMethodBeat.m2505o(20844);
    }
}
