package com.tencent.mm.plugin.freewifi.e;

import android.content.Intent;
import android.net.Uri;
import com.google.android.gms.measurement.AppMeasurement.Param;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.freewifi.d.f;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiErrorUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.a;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;

public final class i extends e implements a {
    protected String cvO;
    private int mwR;
    protected String mwU;
    protected String mwV;
    protected String mwW;
    private Uri mwX;
    private String mwY;
    protected String sign;

    public i(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.i(20841);
        this.mwR = 0;
        this.mwY = this.intent.getStringExtra("free_wifi_schema_uri");
        this.mwX = Uri.parse(this.mwY);
        this.appId = this.mwX.getQueryParameter("appId");
        this.mwU = this.mwX.getQueryParameter("shopId");
        this.mwV = this.mwX.getQueryParameter("authUrl");
        this.mwW = this.mwX.getQueryParameter("extend");
        this.cvO = this.mwX.getQueryParameter(Param.TIMESTAMP);
        this.sign = this.mwX.getQueryParameter("sign");
        ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=Data retrieved. schemaUri=%s, appid=%s, shopId=%s, authUrl=%s, extend=%s, timestamp=%s, sign=%s", m.V(this.intent), Integer.valueOf(m.W(this.intent)), this.mwX, this.appId, this.mwU, this.mwV, this.mwW, this.cvO, this.sign);
        AppMethodBeat.o(20841);
    }

    public final void connect() {
        AppMethodBeat.i(20842);
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (m.isEmpty(this.ssid)) {
            ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=it cannot get ssid, so it fails. ", m.V(this.intent), Integer.valueOf(m.W(this.intent)));
            freeWifiFrontPageUI = this.mwF;
            dVar = d.FAIL;
            aVar = new a();
            aVar.myI = m.a(this.mwG, b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
            AppMethodBeat.o(20842);
        } else if (m.isEmpty(this.mwV)) {
            ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, desc=authurl is empty, so it fails. ", m.V(this.intent), Integer.valueOf(m.W(this.intent)));
            freeWifiFrontPageUI = this.mwF;
            dVar = d.FAIL;
            aVar = new a();
            aVar.myI = m.a(this.mwG, b.ThreeThreeAuth, 32);
            freeWifiFrontPageUI.a(dVar, aVar);
            AppMethodBeat.o(20842);
        } else {
            StringBuilder stringBuilder = new StringBuilder(this.mwV);
            if (this.mwV.indexOf("?") == -1) {
                stringBuilder.append("?extend=").append(this.mwW);
            } else {
                stringBuilder.append("&extend=").append(this.mwW);
            }
            final String stringBuilder2 = stringBuilder.toString();
            j.byZ().byI().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(20836);
                    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.V(i.this.intent), Integer.valueOf(m.W(i.this.intent)), stringBuilder2);
                    com.tencent.mm.plugin.freewifi.a.a.byw();
                    com.tencent.mm.plugin.freewifi.a.a.a(stringBuilder2, new com.tencent.mm.plugin.freewifi.a.a.a() {
                        public final void g(HttpURLConnection httpURLConnection) {
                            AppMethodBeat.i(20834);
                            int responseCode = httpURLConnection.getResponseCode();
                            ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.V(i.this.intent), Integer.valueOf(m.W(i.this.intent)), Integer.valueOf(responseCode));
                            if (responseCode == 200) {
                                i.this.bzv();
                                AppMethodBeat.o(20834);
                            } else if (responseCode == 302) {
                                i.a(i.this, httpURLConnection.getHeaderField("Location"));
                                AppMethodBeat.o(20834);
                            } else {
                                ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.V(i.this.intent), Integer.valueOf(m.W(i.this.intent)));
                                FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.mwF;
                                d dVar = d.FAIL;
                                a aVar = new a();
                                aVar.myI = m.a(i.this.mwG, b.ThreeThreeAuth, 32);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                AppMethodBeat.o(20834);
                            }
                        }

                        public final void j(Exception exception) {
                            AppMethodBeat.i(20835);
                            ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", m.V(i.this.intent), Integer.valueOf(m.W(i.this.intent)), exception.getMessage(), m.h(exception));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.mwF;
                            d dVar = d.FAIL;
                            a aVar = new a();
                            aVar.myI = m.a(i.this.mwG, b.ThreeThreeAuth, m.i(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            AppMethodBeat.o(20835);
                        }
                    });
                    AppMethodBeat.o(20836);
                }
            });
            AppMethodBeat.o(20842);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzv() {
        AppMethodBeat.i(20843);
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20840);
                k.a byo = k.byo();
                byo.ssid = i.this.ssid;
                byo.bssid = m.My("MicroMsg.FreeWifi.Protocol33");
                byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol33");
                byo.cuH = i.this.cuH;
                byo.kBq = m.V(i.this.intent);
                byo.mue = i.this.mwG;
                byo.muf = b.GetBackPage33.muQ;
                byo.mug = b.GetBackPage33.name;
                byo.cIb = m.Y(i.this.intent);
                byo.result = 0;
                byo.byq().byp();
                String byK = com.tencent.mm.plugin.freewifi.model.d.byK();
                String byO = com.tencent.mm.plugin.freewifi.model.d.byO();
                int byL = com.tencent.mm.plugin.freewifi.model.d.byL();
                ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.getBackPageInfoAfterConnectSuccess, desc=it starts net request [apauth.getBackPageFor33]  for backpage info. fullUrl=%s, nowApMac=%s, nowNetworkSSID=%s, rssi=%d", m.V(i.this.intent), Integer.valueOf(m.W(i.this.intent)), "", byK, byO, Integer.valueOf(byL));
                new f(i.this.ssid, m.My("MicroMsg.FreeWifi.Protocol33"), i.this.appId, i.this.mwU, i.this.mwV, i.this.mwW, i.this.cvO, i.this.sign).c(new com.tencent.mm.ai.f() {
                    public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                        AppMethodBeat.i(20839);
                        ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=FreeWifiConnector.getA8Key.callback, desc=net request [apauth.getBackPageFor33] returns. errType=%d, errCode=%d, errMsg=%s", m.V(i.this.intent), Integer.valueOf(m.W(i.this.intent)), Integer.valueOf(i), Integer.valueOf(i2), str);
                        k.a byo = k.byo();
                        byo.ssid = i.this.ssid;
                        byo.bssid = m.My("MicroMsg.FreeWifi.Protocol33");
                        byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol33");
                        byo.cuH = i.this.cuH;
                        byo.kBq = m.V(i.this.intent);
                        byo.mue = m.X(i.this.intent);
                        byo.muf = b.GetBackPage33Return.muQ;
                        byo.mug = b.GetBackPage33Return.name;
                        byo.cIb = m.Y(i.this.intent);
                        byo.result = i2;
                        byo.ehr = str;
                        byo.byq().byp();
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        d dVar;
                        a aVar;
                        if (i == 0 && i2 == 0) {
                            gj bzj = ((f) mVar).bzj();
                            if (bzj != null) {
                                ab.i("MicroMsg.FreeWifi.Protocol33", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s, qingHuaiPageUrl: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ, bzj.vIF);
                                FreeWifiFrontPageUI freeWifiFrontPageUI2 = i.this.mwF;
                                d dVar2 = d.SUCCESS;
                                FreeWifiFrontPageUI.b bVar = new FreeWifiFrontPageUI.b();
                                bVar.mzh = bzj;
                                freeWifiFrontPageUI2.a(dVar2, bVar);
                                AppMethodBeat.o(20839);
                                return;
                            }
                            freeWifiFrontPageUI = i.this.mwF;
                            dVar = d.FAIL;
                            aVar = new a();
                            aVar.myI = m.a(i.this.mwG, b.GetBackPage33Return, 20);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            AppMethodBeat.o(20839);
                        } else if (i2 == -30032) {
                            Intent intent = new Intent();
                            intent.putExtra("free_wifi_error_ui_error_msg", i.this.mwF.getString(R.string.bzv));
                            intent.setClass(i.this.mwF, FreeWifiErrorUI.class);
                            i.this.mwF.finish();
                            i.this.mwF.startActivity(intent);
                            AppMethodBeat.o(20839);
                        } else {
                            freeWifiFrontPageUI = i.this.mwF;
                            dVar = d.FAIL;
                            aVar = new a();
                            aVar.myH = R.string.bzq;
                            aVar.myI = m.a(i.this.mwG, b.GetBackPage33Return, i2);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            AppMethodBeat.o(20839);
                        }
                    }
                });
                AppMethodBeat.o(20840);
            }
        });
        AppMethodBeat.o(20843);
    }

    static /* synthetic */ void a(i iVar, String str) {
        AppMethodBeat.i(20844);
        iVar.mwR++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        a aVar;
        if (iVar.mwR > 3) {
            ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.V(iVar.intent), Integer.valueOf(m.W(iVar.intent)));
            freeWifiFrontPageUI = iVar.mwF;
            dVar = d.FAIL;
            aVar = new a();
            aVar.myI = m.a(iVar.mwG, b.ThreeThreeAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            AppMethodBeat.o(20844);
            return;
        }
        ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.V(iVar.intent), Integer.valueOf(m.W(iVar.intent)), str);
        if (m.isEmpty(str)) {
            freeWifiFrontPageUI = iVar.mwF;
            dVar = d.FAIL;
            aVar = new a();
            aVar.myI = m.a(iVar.mwG, b.ThreeThreeAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            AppMethodBeat.o(20844);
            return;
        }
        AnonymousClass2 anonymousClass2 = new com.tencent.mm.plugin.freewifi.a.a.a() {
            public final void g(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(20837);
                int responseCode = httpURLConnection.getResponseCode();
                ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.V(i.this.intent), Integer.valueOf(m.W(i.this.intent)), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    i.this.bzv();
                    AppMethodBeat.o(20837);
                } else if (responseCode == 302) {
                    i.a(i.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(20837);
                } else {
                    ab.i("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.V(i.this.intent), Integer.valueOf(m.W(i.this.intent)));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.mwF;
                    d dVar = d.FAIL;
                    a aVar = new a();
                    aVar.myI = m.a(i.this.mwG, b.ThreeThreeAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    AppMethodBeat.o(20837);
                }
            }

            public final void j(Exception exception) {
                AppMethodBeat.i(20838);
                ab.e("MicroMsg.FreeWifi.Protocol33", "sessionKey=%s, step=%d, method=Protocol33.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", m.V(i.this.intent), Integer.valueOf(m.W(i.this.intent)), exception.getMessage(), m.h(exception));
                FreeWifiFrontPageUI freeWifiFrontPageUI = i.this.mwF;
                d dVar = d.FAIL;
                a aVar = new a();
                aVar.myI = m.a(i.this.mwG, b.ThreeThreeAuth, m.i(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                AppMethodBeat.o(20838);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            com.tencent.mm.plugin.freewifi.a.a.byw();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass2);
            AppMethodBeat.o(20844);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.byw();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass2);
        AppMethodBeat.o(20844);
    }
}
