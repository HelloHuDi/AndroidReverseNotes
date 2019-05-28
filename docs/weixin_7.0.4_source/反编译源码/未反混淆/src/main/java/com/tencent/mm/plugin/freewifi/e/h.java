package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a.a;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;

public final class h extends e implements a {
    private String mwQ = this.intent.getStringExtra("free_wifi_portal_ap_info_authurl_with_params");
    private int mwR = 0;

    static /* synthetic */ void a(h hVar, int i, String str) {
        AppMethodBeat.i(20832);
        hVar.aH(i, str);
        AppMethodBeat.o(20832);
    }

    public h(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.i(20829);
        ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, desc=Data retrieved. authUrlWithParams=%s", m.V(this.intent), Integer.valueOf(m.W(this.intent)), this.mwQ);
        AppMethodBeat.o(20829);
    }

    public final void connect() {
        AppMethodBeat.i(20830);
        ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.connect, desc=it starts connecting wifi by protocol 3.1. authUrlWithParams=%s", m.V(this.intent), Integer.valueOf(m.W(this.intent)), this.mwQ);
        final String str = this.mwQ;
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20826);
                ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.V(h.this.intent), Integer.valueOf(m.W(h.this.intent)), str);
                a.byw();
                a.a(str, new a.a() {
                    public final void g(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.i(20824);
                        int responseCode = httpURLConnection.getResponseCode();
                        ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.V(h.this.intent), Integer.valueOf(m.W(h.this.intent)), Integer.valueOf(responseCode));
                        if (responseCode == 200) {
                            h.a(h.this, 0, "");
                            m.a(h.this.intent, h.this.cuH, h.this.mwG, h.this.cdf, h.this.mwF, "MicroMsg.FreeWifi.ProtocolThreeOne");
                            AppMethodBeat.o(20824);
                        } else if (responseCode == 302) {
                            h.a(h.this, httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.o(20824);
                        } else {
                            ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.V(h.this.intent), Integer.valueOf(m.W(h.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.mwF;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.myI = m.a(h.this.mwG, b.ThreeOneAuth, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            h.a(h.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.o(20824);
                        }
                    }

                    public final void j(Exception exception) {
                        AppMethodBeat.i(20825);
                        ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stackTrace=%s", m.V(h.this.intent), Integer.valueOf(m.W(h.this.intent)), exception.getMessage(), m.h(exception));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.mwF;
                        d dVar = d.FAIL;
                        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                        aVar.myI = m.a(h.this.mwG, b.ThreeOneAuth, m.i(exception));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        h.a(h.this, m.i(exception), m.g(exception));
                        AppMethodBeat.o(20825);
                    }
                });
                AppMethodBeat.o(20826);
            }
        });
        AppMethodBeat.o(20830);
    }

    private void aH(int i, String str) {
        AppMethodBeat.i(20831);
        k.a byo = k.byo();
        byo.ssid = this.ssid;
        byo.bssid = m.My("MicroMsg.FreeWifi.ProtocolThreeOne");
        byo.cuI = m.Mz("MicroMsg.FreeWifi.ProtocolThreeOne");
        byo.cuH = this.cuH;
        byo.mud = this.appId;
        byo.kBq = m.V(this.intent);
        byo.mue = 31;
        byo.muf = b.ThreeOneAuth.muQ;
        byo.mug = b.ThreeOneAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = m.Y(this.intent);
        byo.byq().b(this.intent, i != 0).byp();
        AppMethodBeat.o(20831);
    }

    static /* synthetic */ void a(h hVar, String str) {
        AppMethodBeat.i(20833);
        hVar.mwR++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        FreeWifiFrontPageUI.a aVar;
        if (hVar.mwR > 3) {
            ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.V(hVar.intent), Integer.valueOf(m.W(hVar.intent)));
            freeWifiFrontPageUI = hVar.mwF;
            dVar = d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.myI = m.a(hVar.mwG, b.ThreeOneAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            hVar.aH(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.o(20833);
            return;
        }
        ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.V(hVar.intent), Integer.valueOf(m.W(hVar.intent)), str);
        if (m.isEmpty(str)) {
            freeWifiFrontPageUI = hVar.mwF;
            dVar = d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.myI = m.a(hVar.mwG, b.ThreeOneAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            hVar.aH(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.o(20833);
            return;
        }
        AnonymousClass2 anonymousClass2 = new a.a() {
            public final void g(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(20827);
                int responseCode = httpURLConnection.getResponseCode();
                ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.V(h.this.intent), Integer.valueOf(m.W(h.this.intent)), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    h.a(h.this, 0, "");
                    m.a(h.this.intent, h.this.cuH, h.this.mwG, h.this.cdf, h.this.mwF, "MicroMsg.FreeWifi.ProtocolThreeOne");
                    AppMethodBeat.o(20827);
                } else if (responseCode == 302) {
                    h.a(h.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(20827);
                } else {
                    ab.i("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.V(h.this.intent), Integer.valueOf(m.W(h.this.intent)));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.mwF;
                    d dVar = d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.myI = m.a(h.this.mwG, b.ThreeOneAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    h.a(h.this, 32, "INVALID_HTTP_RESP_CODE");
                    AppMethodBeat.o(20827);
                }
            }

            public final void j(Exception exception) {
                AppMethodBeat.i(20828);
                ab.e("MicroMsg.FreeWifi.ProtocolThreeOne", "sessionKey=%s, step=%d, method=Protocol31.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", m.V(h.this.intent), Integer.valueOf(m.W(h.this.intent)), exception.getMessage(), m.h(exception));
                FreeWifiFrontPageUI freeWifiFrontPageUI = h.this.mwF;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.myI = m.a(h.this.mwG, b.ThreeOneAuth, m.i(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                h.a(h.this, m.i(exception), m.g(exception));
                AppMethodBeat.o(20828);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            a.byw();
            a.a(str, parse.getEncodedQuery(), anonymousClass2);
            AppMethodBeat.o(20833);
            return;
        }
        a.byw();
        a.a(str, anonymousClass2);
        AppMethodBeat.o(20833);
    }
}
