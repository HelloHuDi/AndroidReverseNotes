package com.tencent.p177mm.plugin.freewifi.p974e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.freewifi.C28067a;
import com.tencent.p177mm.plugin.freewifi.C28067a.C20777a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.model.C45957d;
import com.tencent.p177mm.plugin.freewifi.p416d.C28075a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C11988b;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28088a;
import com.tencent.p177mm.plugin.freewifi.p418ui.FreeWifiFrontPageUI.C28089d;
import com.tencent.p177mm.protocal.protobuf.C23391gj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.freewifi.e.g */
public final class C31357g extends C28079e implements C39102a {
    private C28067a mwL;
    private int mwM = 5;

    /* renamed from: com.tencent.mm.plugin.freewifi.e.g$3 */
    class C207863 implements C1202f {
        C207863() {
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            AppMethodBeat.m2504i(20815);
            C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "errType : %d, errCode : %d, errMsg : %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            if (i == 0 && i2 == 0) {
                C28075a c28075a = (C28075a) c1207m;
                C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "authUrl : %s", c28075a.bze());
                C23391gj bzj = c28075a.bzj();
                if (bzj != null) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "backPageInfo appid: %s, nickName: %s, userName: %s, finishActionCode: %d, finishUrl: %s, signature: %s", bzj.vEn, bzj.jCH, bzj.jBB, Integer.valueOf(bzj.vID), bzj.vIE, bzj.guQ);
                    C11976j.byZ().byI().post(new C313584(r0, bzj));
                    AppMethodBeat.m2505o(20815);
                    return;
                }
                C31357g.m50664c(C31357g.this);
                AppMethodBeat.m2505o(20815);
                return;
            }
            C31357g.m50664c(C31357g.this);
            AppMethodBeat.m2505o(20815);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.e.g$4 */
    class C313584 implements Runnable {
        final /* synthetic */ String mwO;
        final /* synthetic */ C23391gj mwP;

        C313584(String str, C23391gj c23391gj) {
            this.mwO = str;
            this.mwP = c23391gj;
        }

        public final void run() {
            AppMethodBeat.m2504i(20816);
            String MH = C31357g.m50661MH(this.mwO);
            C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "get redirect location from loginurl : %s, %s", MH, this.mwO);
            if (!C5046bo.isNullOrNil(MH)) {
                String es = C31357g.m50665es(MH, "res=");
                C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "get connect result from location : %s, %s", es, MH);
                if (!C5046bo.isNullOrNil(es) && (es.startsWith("success") || es.startsWith("already"))) {
                    FreeWifiFrontPageUI freeWifiFrontPageUI = C31357g.this.mwF;
                    C28089d c28089d = C28089d.SUCCESS;
                    C11988b c11988b = new C11988b();
                    c11988b.mzh = this.mwP;
                    freeWifiFrontPageUI.mo62019a(c28089d, c11988b);
                    AppMethodBeat.m2505o(20816);
                    return;
                }
            }
            C31357g.m50664c(C31357g.this);
            AppMethodBeat.m2505o(20816);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.e.g$1 */
    class C313591 implements Runnable {
        C313591() {
        }

        public final void run() {
            AppMethodBeat.m2504i(20812);
            C31357g.m50662a(C31357g.this);
            AppMethodBeat.m2505o(20812);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.e.g$2 */
    class C313602 implements C20777a {
        C313602() {
        }

        public final void onSuccess() {
            AppMethodBeat.m2504i(20813);
            C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "sessionKey=%s, step=%d, desc=Network. ", C34189m.m56063V(C31357g.this.intent), Integer.valueOf(C34189m.m56064W(C31357g.this.intent)));
            C31357g.m50663b(C31357g.this);
            AppMethodBeat.m2505o(20813);
        }

        public final void onFail(int i) {
            AppMethodBeat.m2504i(20814);
            C31357g.m50664c(C31357g.this);
            AppMethodBeat.m2505o(20814);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m50664c(C31357g c31357g) {
        AppMethodBeat.m2504i(20823);
        c31357g.bzu();
        AppMethodBeat.m2505o(20823);
    }

    public C31357g(FreeWifiFrontPageUI freeWifiFrontPageUI) {
        super(freeWifiFrontPageUI);
    }

    public final void connect() {
        AppMethodBeat.m2504i(20817);
        C11976j.byZ().byI().post(new C313591());
        AppMethodBeat.m2505o(20817);
    }

    private void bzu() {
        AppMethodBeat.m2504i(20818);
        this.mwF.mo62019a(C28089d.FAIL, C28088a.mzg);
        AppMethodBeat.m2505o(20818);
    }

    /* renamed from: es */
    static String m50665es(String str, String str2) {
        AppMethodBeat.m2504i(20819);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.ProtocolOne", "null or nil header");
            AppMethodBeat.m2505o(20819);
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
                    AppMethodBeat.m2505o(20819);
                    return substring;
                }
            }
        }
        AppMethodBeat.m2505o(20819);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: MH */
    static String m50661MH(String str) {
        Exception e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        AppMethodBeat.m2504i(20820);
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "code : %d, location : %s", Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(20820);
                    return r1;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        C4990ab.m7413e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        AppMethodBeat.m2505o(20820);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.m2505o(20820);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(20820);
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            AppMethodBeat.m2505o(20820);
            return null;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            C4990ab.m7413e("MicroMsg.FreeWifi.ProtocolOne", "get recirect location failed : %s", e.getMessage());
            if (httpURLConnection != null) {
            }
            AppMethodBeat.m2505o(20820);
            return null;
        } catch (Throwable th22) {
            th = th22;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            AppMethodBeat.m2505o(20820);
            throw th;
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m50662a(C31357g c31357g) {
        AppMethodBeat.m2504i(20821);
        c31357g.mwL = new C28067a(c31357g.ssid, c31357g.mwF);
        c31357g.mwL.mo45989a(new C313602());
        AppMethodBeat.m2505o(20821);
    }

    /* renamed from: b */
    static /* synthetic */ void m50663b(C31357g c31357g) {
        AppMethodBeat.m2504i(20822);
        int i = c31357g.mwM;
        while (true) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "now retry count = %d", Integer.valueOf(i2));
            String Nj = C26373g.m41965Nv().mo5297Nj();
            C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "get check url from cinfig : %s", Nj);
            if (C5046bo.isNullOrNil(Nj)) {
                C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "get check url from config failed, use the default url : %s", "http://10.1.0.6/redirect");
                Nj = "http://10.1.0.6/redirect";
            }
            String MH = C31357g.m50661MH(Nj);
            C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "get location from url : %s, %s", Nj, MH);
            if (C5046bo.isNullOrNil(MH)) {
                C4990ab.m7413e("MicroMsg.FreeWifi.ProtocolOne", "get location from url failed : %s, %s", Nj, MH);
                try {
                    Thread.sleep(500);
                    i = i2;
                } catch (Exception e) {
                    i = i2;
                }
            } else {
                String es = C31357g.m50665es(MH, "auth=");
                C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "get apauthmessage from location : %s, %s", es, MH);
                if (C5046bo.isNullOrNil(es)) {
                    C4990ab.m7413e("MicroMsg.FreeWifi.ProtocolOne", "get apauth message from location failed : %s", MH);
                } else {
                    C4990ab.m7417i("MicroMsg.FreeWifi.ProtocolOne", "get ap auth data : %s, url : %s, mac : %s", es, c31357g.jUg, C45957d.byK());
                    if (C5046bo.isNullOrNil(es)) {
                        c31357g.bzu();
                        AppMethodBeat.m2505o(20822);
                        return;
                    }
                    new C28075a(c31357g.jUg, c31357g.ssid, r3, "", es, "", c31357g.cdf, C34189m.m56063V(c31357g.intent)).mo68619c(new C207863());
                    AppMethodBeat.m2505o(20822);
                    return;
                }
            }
        }
        c31357g.bzu();
        AppMethodBeat.m2505o(20822);
    }
}
