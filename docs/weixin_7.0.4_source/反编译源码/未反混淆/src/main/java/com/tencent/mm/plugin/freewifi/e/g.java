package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.freewifi.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.b;
import com.tencent.mm.plugin.freewifi.ui.FreeWifiFrontPageUI.d;
import com.tencent.mm.protocal.protobuf.gj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g extends e implements a {
    private a mwL;
    private int mwM = 5;

    /* renamed from: com.tencent.mm.plugin.freewifi.e.g$4 */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String mwO;
        final /* synthetic */ gj mwP;

        AnonymousClass4(String str, gj gjVar) {
            this.mwO = str;
            this.mwP = gjVar;
        }

        public final void run() {
            AppMethodBeat.i(20816);
            String MH = g.MH(this.mwO);
            ab.i("MicroMsg.FreeWifi.ProtocolOne", "get redirect location from loginurl : %s, %s", MH, this.mwO);
            if (!bo.isNullOrNil(MH)) {
                String es = g.es(MH, "res=");
                ab.i("MicroMsg.FreeWifi.ProtocolOne", "get connect result from location : %s, %s", es, MH);
                if (!bo.isNullOrNil(es) && (es.startsWith("success") || es.startsWith("already"))) {
                    FreeWifiFrontPageUI freeWifiFrontPageUI = g.this.mwF;
                    d dVar = d.SUCCESS;
                    b bVar = new b();
                    bVar.mzh = this.mwP;
                    freeWifiFrontPageUI.a(dVar, bVar);
                    AppMethodBeat.o(20816);
                    return;
                }
            }
            g.c(g.this);
            AppMethodBeat.o(20816);
        }
    }

    static /* synthetic */ void c(g gVar) {
        AppMethodBeat.i(20823);
        gVar.bzu();
        AppMethodBeat.o(20823);
    }

    public g(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
    }

    public final void connect() {
        AppMethodBeat.i(20817);
        j.byZ().byI().post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(20812);
                g.a(g.this);
                AppMethodBeat.o(20812);
            }
        });
        AppMethodBeat.o(20817);
    }

    private void bzu() {
        AppMethodBeat.i(20818);
        this.mwF.a(d.FAIL, FreeWifiFrontPageUI.a.mzg);
        AppMethodBeat.o(20818);
    }

    static String es(String str, String str2) {
        AppMethodBeat.i(20819);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FreeWifi.ProtocolOne", "null or nil header");
            AppMethodBeat.o(20819);
            return null;
        }
        String[] split;
        String[] split2 = str.split("\\?");
        if (str2.length() > 0) {
            split = split2[1].split("&");
        } else {
            split = split2;
        }
        if (split != null && split.length > 0) {
            for (String str3 : split) {
                if (str3.startsWith(str2)) {
                    String substring = str3.substring(str2.length());
                    AppMethodBeat.o(20819);
                    return substring;
                }
            }
        }
        AppMethodBeat.o(20819);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static String MH(String str) {
        Exception e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        AppMethodBeat.i(20820);
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    ab.i("MicroMsg.FreeWifi.ProtocolOne", "code : %d, location : %s", Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.o(20820);
                    return r1;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        ab.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        AppMethodBeat.o(20820);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.o(20820);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.o(20820);
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            AppMethodBeat.o(20820);
            return null;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            ab.e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", e.getMessage());
            if (httpURLConnection != null) {
            }
            AppMethodBeat.o(20820);
            return null;
        } catch (Throwable th22) {
            th = th22;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            AppMethodBeat.o(20820);
            throw th;
        }
    }

    static /* synthetic */ void a(g gVar) {
        AppMethodBeat.i(20821);
        gVar.mwL = new a(gVar.ssid, gVar.mwF);
        gVar.mwL.a(new a.a() {
            public final void onSuccess() {
                AppMethodBeat.i(20813);
                ab.i("MicroMsg.FreeWifi.ProtocolOne", "sessionKey=%s, step=%d, desc=Network. ", m.V(g.this.intent), Integer.valueOf(m.W(g.this.intent)));
                g.b(g.this);
                AppMethodBeat.o(20813);
            }

            public final void onFail(int i) {
                AppMethodBeat.i(20814);
                g.c(g.this);
                AppMethodBeat.o(20814);
            }
        });
        AppMethodBeat.o(20821);
    }

    static /* synthetic */ void b(g gVar) {
        AppMethodBeat.i(20822);
        int i = gVar.mwM;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            ab.i("MicroMsg.FreeWifi.ProtocolOne", "now retry count = %d", Integer.valueOf(i2));
            String Nj = com.tencent.mm.m.g.Nv().Nj();
            ab.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from cinfig : %s", Nj);
            if (bo.isNullOrNil(Nj)) {
                ab.i("MicroMsg.FreeWifi.ProtocolOne", "get check url from config failed, use the default url : %s", "http://10.1.0.6/redirect");
                Nj = "http://10.1.0.6/redirect";
            }
            String MH = MH(Nj);
            ab.i("MicroMsg.FreeWifi.ProtocolOne", "get location from url : %s, %s", Nj, MH);
            if (bo.isNullOrNil(MH)) {
                ab.e("MicroMsg.FreeWifi.ProtocolOne", "get location from url failed : %s, %s", Nj, MH);
                try {
                    Thread.sleep(500);
                    i = i2;
                } catch (Exception e) {
                    i = i2;
                }
            } else {
                String es = es(MH, "auth=");
                ab.i("MicroMsg.FreeWifi.ProtocolOne", "get apauthmessage from location : %s, %s", es, MH);
                if (bo.isNullOrNil(es)) {
                    ab.e("MicroMsg.FreeWifi.ProtocolOne", "get apauth message from location failed : %s", MH);
                } else {
                    ab.i("MicroMsg.FreeWifi.ProtocolOne", "get ap auth data : %s, url : %s, mac : %s", es, gVar.jUg, com.tencent.mm.plugin.freewifi.model.d.byK());
                    if (bo.isNullOrNil(es)) {
                        gVar.bzu();
                        AppMethodBeat.o(20822);
                        return;
                    }
                    new com.tencent.mm.plugin.freewifi.d.a(gVar.jUg, gVar.ssid, r3, "", es, "", gVar.cdf, m.V(gVar.intent)).c(new f() {
                        public final void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
                            AppMethodBeat.i(20815);
                            ab.i("MicroMsg.FreeWifi.ProtocolOne", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                            if (i == 0 && i2 == 0) {
                                com.tencent.mm.plugin.freewifi.d.a aVar = (com.tencent.mm.plugin.freewifi.d.a) mVar;
                                ab.i("MicroMsg.FreeWifi.ProtocolOne", "authUrl : %s", aVar.bze());
                                gj bzj = aVar.bzj();
                                if (bzj != null) {
                                    ab.i("MicroMsg.FreeWifi.ProtocolOne", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                                    j.byZ().byI().post(new AnonymousClass4(r0, bzj));
                                    AppMethodBeat.o(20815);
                                    return;
                                }
                                g.c(g.this);
                                AppMethodBeat.o(20815);
                                return;
                            }
                            g.c(g.this);
                            AppMethodBeat.o(20815);
                        }
                    });
                    AppMethodBeat.o(20822);
                    return;
                }
            }
        }
        gVar.bzu();
        AppMethodBeat.o(20822);
    }
}
