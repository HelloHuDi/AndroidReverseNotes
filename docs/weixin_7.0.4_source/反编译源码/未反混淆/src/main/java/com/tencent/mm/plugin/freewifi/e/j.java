package com.tencent.mm.plugin.freewifi.e;

import android.net.Uri;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.h;
import com.tencent.mm.plugin.freewifi.k;
import com.tencent.mm.plugin.freewifi.k.b;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.net.HttpURLConnection;
import java.net.UnknownHostException;

public final class j extends e implements a {
    String cvO = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_TIMESTAMP");
    private a mwL;
    private int mwR = 0;
    String mxc = this.intent.getStringExtra("free_wifi_tid");
    String openId = this.intent.getStringExtra("free_wifi_openid");
    String sign = this.intent.getStringExtra("ConstantsFreeWifi.FREE_WIFI_SIGN");

    static /* synthetic */ void a(j jVar, int i, String str) {
        AppMethodBeat.i(20864);
        jVar.aI(i, str);
        AppMethodBeat.o(20864);
    }

    public j(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
        AppMethodBeat.i(20860);
        ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. openId=%s, tid=%s, timestamp=%s, sign=%s", m.V(this.intent), Integer.valueOf(m.W(this.intent)), this.openId, this.mxc, this.cvO, this.sign);
        AppMethodBeat.o(20860);
    }

    public final void connect() {
        AppMethodBeat.i(20861);
        this.mwL = new a(this.ssid, this.mwF);
        com.tencent.mm.plugin.freewifi.model.j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20845);
                j.a(j.this);
                AppMethodBeat.o(20845);
            }
        });
        AppMethodBeat.o(20861);
    }

    private void aI(int i, String str) {
        AppMethodBeat.i(20862);
        k.a byo = k.byo();
        byo.ssid = this.ssid;
        byo.bssid = m.My("MicroMsg.FreeWifi.Protocol32");
        byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol32");
        byo.cuH = this.cuH;
        byo.mud = this.appId;
        byo.kBq = m.V(this.intent);
        byo.mue = 32;
        byo.muf = b.ThreeTwoAuth.muQ;
        byo.mug = b.ThreeTwoAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = m.Y(this.intent);
        byo.byq().byp();
        AppMethodBeat.o(20862);
    }

    static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(20863);
        ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connectSsid, desc=it starts to connect ssid. ssid=%s", m.V(jVar.intent), Integer.valueOf(m.W(jVar.intent)), jVar.ssid);
        jVar.mwL.a(new a.a() {
            public final void onSuccess() {
                AppMethodBeat.i(20853);
                k.a byo = k.byo();
                byo.ssid = j.this.ssid;
                byo.bssid = m.My("MicroMsg.FreeWifi.Protocol32");
                byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol32");
                byo.cuH = j.this.cuH;
                byo.mud = j.this.appId;
                byo.kBq = m.V(j.this.intent);
                byo.mue = m.X(j.this.intent);
                byo.muf = b.AddNetwork.muQ;
                byo.mug = b.AddNetwork.name;
                byo.result = 0;
                byo.cIb = m.Y(j.this.intent);
                byo.byq().byp();
                final String byl = h.b.mtY.byl();
                ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid succeeded and then tries to access blackUrl. ssid=%s, blackUrl = %s", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), j.this.ssid, byl);
                AnonymousClass1 anonymousClass1 = new com.tencent.mm.plugin.freewifi.a.a.a() {
                    int mxe = 0;
                    private final int mxf = 3;
                    private int mxg = 0;
                    private com.tencent.mm.plugin.freewifi.a.a.a mxh = new com.tencent.mm.plugin.freewifi.a.a.a() {
                        public final void g(HttpURLConnection httpURLConnection) {
                            AppMethodBeat.i(20846);
                            int responseCode = httpURLConnection.getResponseCode();
                            FreeWifiFrontPageUI freeWifiFrontPageUI;
                            d dVar;
                            FreeWifiFrontPageUI.a aVar;
                            if (responseCode == 200) {
                                ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=it still cannot get authurl and extend (now http returns 200), so it fails to connect wifi. ", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)));
                                freeWifiFrontPageUI = j.this.mwF;
                                dVar = d.FAIL;
                                aVar = new FreeWifiFrontPageUI.a();
                                aVar.myI = m.a(j.this.mwG, b.ThreeTwoBlack, 35);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                j.a(j.this, 35, "CANNOT_GET_AUTHURL_AFTER_BLACK_URL");
                                AppMethodBeat.o(20846);
                            } else if (responseCode == 302) {
                                AnonymousClass1.a(AnonymousClass1.this, httpURLConnection.getHeaderField("Location"));
                                AppMethodBeat.o(20846);
                            } else {
                                ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)));
                                freeWifiFrontPageUI = j.this.mwF;
                                dVar = d.FAIL;
                                aVar = new FreeWifiFrontPageUI.a();
                                aVar.myI = m.a(j.this.mwG, b.ThreeTwoBlack, 32);
                                freeWifiFrontPageUI.a(dVar, aVar);
                                j.a(j.this, 32, "INVALID_HTTP_RESP_CODE");
                                AppMethodBeat.o(20846);
                            }
                        }

                        public final void j(Exception exception) {
                            AppMethodBeat.i(20847);
                            ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.black, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s,stacktrace=%s", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), exception.getMessage(), m.h(exception));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mwF;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.myI = m.a(j.this.mwG, b.ThreeTwoBlack, m.i(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.a(j.this, m.i(exception), m.g(exception));
                            AppMethodBeat.o(20847);
                        }
                    };

                    static /* synthetic */ void a(AnonymousClass1 anonymousClass1, String str) {
                        AppMethodBeat.i(20852);
                        anonymousClass1.MI(str);
                        AppMethodBeat.o(20852);
                    }

                    public final void g(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.i(20849);
                        int responseCode = httpURLConnection.getResponseCode();
                        if (responseCode == 200) {
                            ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackurl returns 200 directly, so we believe that the device is already authenticated. Authentication ended.", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)));
                            j.a(j.this, 0, "");
                            m.a(j.this.intent, j.this.cuH, j.this.mwG, j.this.cdf, j.this.mwF, "MicroMsg.FreeWifi.Protocol32");
                            AppMethodBeat.o(20849);
                        } else if (responseCode == 302) {
                            MI(httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.o(20849);
                        } else {
                            ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=http response status code is neither 200 nor 302, so it fails to connect wifi. ", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mwF;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.myI = m.a(j.this.mwG, b.ThreeTwoBlack, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.b(j.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.o(20849);
                        }
                    }

                    public final void j(Exception exception) {
                        FreeWifiFrontPageUI freeWifiFrontPageUI;
                        d dVar;
                        FreeWifiFrontPageUI.a aVar;
                        AppMethodBeat.i(20850);
                        ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), exception.getMessage(), m.h(exception));
                        if (exception instanceof UnknownHostException) {
                            j.b(j.this, 102, m.g(exception));
                            ab.i("MicroMsg.FreeWifi.Protocol32", "countBlackHttpRequest=" + this.mxe);
                            int i = this.mxe + 1;
                            this.mxe = i;
                            if (i <= 3) {
                                try {
                                    Thread.sleep(3000);
                                    com.tencent.mm.plugin.freewifi.a.a.byw();
                                    com.tencent.mm.plugin.freewifi.a.a.a(byl, this);
                                    AppMethodBeat.o(20850);
                                    return;
                                } catch (InterruptedException e) {
                                    ab.e("MicroMsg.FreeWifi.Protocol32", "InterruptedException e stacktrace=%s", m.h(exception));
                                    j.b(j.this, 103, m.g(exception));
                                    freeWifiFrontPageUI = j.this.mwF;
                                    dVar = d.FAIL;
                                    aVar = new FreeWifiFrontPageUI.a();
                                    aVar.myI = m.a(j.this.mwG, b.ThreeTwoBlack, 103);
                                    freeWifiFrontPageUI.a(dVar, aVar);
                                    AppMethodBeat.o(20850);
                                    return;
                                }
                            }
                            freeWifiFrontPageUI = j.this.mwF;
                            dVar = d.FAIL;
                            aVar = new FreeWifiFrontPageUI.a();
                            aVar.myI = m.a(j.this.mwG, b.ThreeTwoBlack, m.i(exception));
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.b(j.this, m.i(exception), m.g(exception));
                            AppMethodBeat.o(20850);
                            return;
                        }
                        freeWifiFrontPageUI = j.this.mwF;
                        dVar = d.FAIL;
                        aVar = new FreeWifiFrontPageUI.a();
                        aVar.myI = m.a(j.this.mwG, b.ThreeTwoBlack, m.i(exception));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        j.b(j.this, m.i(exception), m.g(exception));
                        AppMethodBeat.o(20850);
                    }

                    private void MI(String str) {
                        AppMethodBeat.i(20851);
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("authUrl");
                        String Mw = m.Mw(parse.getQueryParameter("extend"));
                        ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Access to blackUrl returns 302 and now trying to  get authurl and extend from location. location=%s, authUrl=%s, extend=%s", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), str, queryParameter, Mw);
                        if (m.isEmpty(queryParameter)) {
                            this.mxg++;
                            if (this.mxg < 3) {
                                com.tencent.mm.plugin.freewifi.a.a.byw();
                                com.tencent.mm.plugin.freewifi.a.a.a(str, this.mxh);
                                AppMethodBeat.o(20851);
                                return;
                            }
                            ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handleBlack302, desc=Connection fail. Too many 302, exceeding 3 times", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mwF;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.myI = m.a(j.this.mwG, b.ThreeTwoBlack, 36);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.a(j.this, 36, "BLACK_302_TIMES_EXCESS");
                            AppMethodBeat.o(20851);
                            return;
                        }
                        StringBuilder stringBuilder = new StringBuilder(queryParameter);
                        if (queryParameter.indexOf("?") != -1) {
                            stringBuilder.append("&extend=").append(Mw);
                        } else {
                            stringBuilder.append("?extend=").append(Mw);
                        }
                        stringBuilder.append("&openId=").append(m.Mw(j.this.openId)).append("&tid=").append(m.Mw(j.this.mxc)).append("&timestamp=").append(j.this.cvO).append("&sign=").append(j.this.sign);
                        j.a(j.this, stringBuilder.toString());
                        ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, desc=Data retrieved. http authentication url = %s", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), stringBuilder.toString());
                        AppMethodBeat.o(20851);
                    }
                };
                com.tencent.mm.plugin.freewifi.a.a.byw();
                com.tencent.mm.plugin.freewifi.a.a.a(byl, anonymousClass1);
                AppMethodBeat.o(20853);
            }

            public final void onFail(int i) {
                AppMethodBeat.i(20854);
                ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=connect, desc=An attempt to connect to ssid failed. ssid=%s, errCode=%d", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), j.this.ssid, Integer.valueOf(i));
                FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mwF;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.myI = m.a(j.this.mwG, b.AddNetwork, i);
                freeWifiFrontPageUI.a(dVar, aVar);
                k.a byo = k.byo();
                byo.ssid = j.this.ssid;
                byo.bssid = m.My("MicroMsg.FreeWifi.Protocol32");
                byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol32");
                byo.cuH = j.this.cuH;
                byo.mud = j.this.appId;
                byo.kBq = m.V(j.this.intent);
                byo.mue = m.X(j.this.intent);
                byo.mug = b.AddNetwork.name;
                byo.muf = b.AddNetwork.muQ;
                byo.result = i;
                byo.cIb = m.Y(j.this.intent);
                byo.byq().byp();
                AppMethodBeat.o(20854);
            }
        });
        AppMethodBeat.o(20863);
    }

    static /* synthetic */ void b(j jVar, int i, String str) {
        AppMethodBeat.i(20865);
        k.a byo = k.byo();
        byo.ssid = jVar.ssid;
        byo.bssid = m.My("MicroMsg.FreeWifi.Protocol32");
        byo.cuI = m.Mz("MicroMsg.FreeWifi.Protocol32");
        byo.cuH = jVar.cuH;
        byo.mud = jVar.appId;
        byo.kBq = m.V(jVar.intent);
        byo.mue = 32;
        byo.muf = b.ThreeTwoAuth.muQ;
        byo.mug = b.ThreeTwoAuth.name;
        byo.result = i;
        byo.ehr = str;
        byo.cIb = m.Y(jVar.intent);
        byo.byq().byp();
        AppMethodBeat.o(20865);
    }

    static /* synthetic */ void a(j jVar, final String str) {
        AppMethodBeat.i(20866);
        com.tencent.mm.plugin.freewifi.model.j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20857);
                ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=it sends http request for authentication. http url=%s", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), str);
                com.tencent.mm.plugin.freewifi.a.a.byw();
                com.tencent.mm.plugin.freewifi.a.a.a(str, new com.tencent.mm.plugin.freewifi.a.a.a() {
                    public final void g(HttpURLConnection httpURLConnection) {
                        AppMethodBeat.i(20855);
                        int responseCode = httpURLConnection.getResponseCode();
                        ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.HttpAuthentication.onSuccess, desc=it receives http response for authentication. http response status code=%d", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), Integer.valueOf(responseCode));
                        if (responseCode == 200) {
                            j.a(j.this, 0, "");
                            m.a(j.this.intent, j.this.cuH, j.this.mwG, j.this.cdf, j.this.mwF, "MicroMsg.FreeWifi.Protocol32");
                            AppMethodBeat.o(20855);
                        } else if (responseCode == 302) {
                            j.b(j.this, httpURLConnection.getHeaderField("Location"));
                            AppMethodBeat.o(20855);
                        } else {
                            ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=http response status code is neither 200 nor 302, so it fs to connect wifi. ", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)));
                            FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mwF;
                            d dVar = d.FAIL;
                            FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                            aVar.myI = m.a(j.this.mwG, b.ThreeTwoAuth, 32);
                            freeWifiFrontPageUI.a(dVar, aVar);
                            j.a(j.this, 32, "INVALID_HTTP_RESP_CODE");
                            AppMethodBeat.o(20855);
                        }
                    }

                    public final void j(Exception exception) {
                        AppMethodBeat.i(20856);
                        ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.httpAuthentication, desc=exception happens during http, so it fails to connect wifi. e.getMessage()=%s, stacktrace=%s", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), exception.getMessage(), m.h(exception));
                        FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mwF;
                        d dVar = d.FAIL;
                        FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                        aVar.myI = m.a(j.this.mwG, b.ThreeTwoAuth, m.i(exception));
                        freeWifiFrontPageUI.a(dVar, aVar);
                        j.a(j.this, m.i(exception), m.g(exception));
                        AppMethodBeat.o(20856);
                    }
                });
                AppMethodBeat.o(20857);
            }
        });
        AppMethodBeat.o(20866);
    }

    static /* synthetic */ void b(j jVar, String str) {
        AppMethodBeat.i(20867);
        jVar.mwR++;
        FreeWifiFrontPageUI freeWifiFrontPageUI;
        d dVar;
        FreeWifiFrontPageUI.a aVar;
        if (jVar.mwR > 3) {
            ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=Connection fail. Too many 302, exceeding 3 times", m.V(jVar.intent), Integer.valueOf(m.W(jVar.intent)));
            freeWifiFrontPageUI = jVar.mwF;
            dVar = d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.myI = m.a(jVar.mwG, b.ThreeTwoAuth, 33);
            freeWifiFrontPageUI.a(dVar, aVar);
            jVar.aI(33, "AUTH_302_TIMES_EXCESS");
            AppMethodBeat.o(20867);
            return;
        }
        ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=it discovers 302 Location and redirects. http response header Location=%s", m.V(jVar.intent), Integer.valueOf(m.W(jVar.intent)), str);
        if (m.isEmpty(str)) {
            freeWifiFrontPageUI = jVar.mwF;
            dVar = d.FAIL;
            aVar = new FreeWifiFrontPageUI.a();
            aVar.myI = m.a(jVar.mwG, b.ThreeTwoAuth, 34);
            freeWifiFrontPageUI.a(dVar, aVar);
            jVar.aI(34, "EMPTY_AUTH_LOCATION");
            AppMethodBeat.o(20867);
            return;
        }
        AnonymousClass4 anonymousClass4 = new com.tencent.mm.plugin.freewifi.a.a.a() {
            public final void g(HttpURLConnection httpURLConnection) {
                AppMethodBeat.i(20858);
                int responseCode = httpURLConnection.getResponseCode();
                ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onSuccess, desc=it receives http response for authentication(after 302). http response status code=%d", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), Integer.valueOf(responseCode));
                if (responseCode == 200) {
                    j.a(j.this, 0, "");
                    m.a(j.this.intent, j.this.cuH, j.this.mwG, j.this.cdf, j.this.mwF, "MicroMsg.FreeWifi.Protocol32");
                    AppMethodBeat.o(20858);
                } else if (responseCode == 302) {
                    j.b(j.this, httpURLConnection.getHeaderField("Location"));
                    AppMethodBeat.o(20858);
                } else {
                    ab.i("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication, desc=http response status code is not 200, so it fails to connect wifi. ", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)));
                    FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mwF;
                    d dVar = d.FAIL;
                    FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                    aVar.myI = m.a(j.this.mwG, b.ThreeTwoAuth, 32);
                    freeWifiFrontPageUI.a(dVar, aVar);
                    j.a(j.this, 32, "INVALID_HTTP_RESP_CODE");
                    AppMethodBeat.o(20858);
                }
            }

            public final void j(Exception exception) {
                AppMethodBeat.i(20859);
                ab.e("MicroMsg.FreeWifi.Protocol32", "sessionKey=%s, step=%d, method=Protocol32UI.handle302Authentication.onException, desc=exception happens during http. e.getMessage()=%s, stacktrace=%s", m.V(j.this.intent), Integer.valueOf(m.W(j.this.intent)), exception.getMessage(), m.h(exception));
                FreeWifiFrontPageUI freeWifiFrontPageUI = j.this.mwF;
                d dVar = d.FAIL;
                FreeWifiFrontPageUI.a aVar = new FreeWifiFrontPageUI.a();
                aVar.myI = m.a(j.this.mwG, b.ThreeTwoAuth, m.i(exception));
                freeWifiFrontPageUI.a(dVar, aVar);
                j.a(j.this, m.i(exception), m.g(exception));
                AppMethodBeat.o(20859);
            }
        };
        Uri parse = Uri.parse(str);
        if ("post".equalsIgnoreCase(parse.getQueryParameter(FirebaseAnalytics.b.METHOD))) {
            com.tencent.mm.plugin.freewifi.a.a.byw();
            com.tencent.mm.plugin.freewifi.a.a.a(str, parse.getEncodedQuery(), anonymousClass4);
            AppMethodBeat.o(20867);
            return;
        }
        com.tencent.mm.plugin.freewifi.a.a.byw();
        com.tencent.mm.plugin.freewifi.a.a.a(str, anonymousClass4);
        AppMethodBeat.o(20867);
    }
}
