package com.tencent.p177mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.tencent.mm.plugin.freewifi.model.g */
public final class C39113g {
    int mvS = 5;

    /* renamed from: com.tencent.mm.plugin.freewifi.model.g$a */
    public interface C20799a {
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.g$b */
    public interface C20800b {
        /* renamed from: ci */
        void mo36090ci(String str, int i);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.g$2 */
    class C391142 implements Runnable {
        final /* synthetic */ String mvV;
        final /* synthetic */ C20799a mvW = null;
        final /* synthetic */ String mvg;
        final /* synthetic */ Intent val$intent;

        C391142(String str, String str2, Intent intent) {
            this.mvV = str;
            this.mvg = str2;
            this.val$intent = intent;
        }

        public final void run() {
            AppMethodBeat.m2504i(20725);
            String MH = C39113g.m66549MH(this.mvV);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "get redirect location from loginurl : %s, %s", MH, this.mvV);
            if (!C5046bo.isNullOrNil(MH)) {
                String er = C39113g.m66551er(MH, "res=");
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "get connect result from location : %s, %s", er, MH);
                if (!C5046bo.isNullOrNil(er) && (er.startsWith("success") || er.startsWith("already"))) {
                    C39113g.m66550b(this.mvg, 2, this.val$intent);
                    C11976j.byW().mo17046MM(this.mvg);
                    AppMethodBeat.m2505o(20725);
                    return;
                }
            }
            C39113g.m66550b(this.mvg, 3, this.val$intent);
            AppMethodBeat.m2505o(20725);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.g$1 */
    class C391151 implements Runnable {
        final /* synthetic */ int muW;
        final /* synthetic */ C20800b mvT;
        final /* synthetic */ String mvg;
        final /* synthetic */ Intent val$intent;

        C391151(String str, Intent intent, C20800b c20800b, int i) {
            this.mvg = str;
            this.val$intent = intent;
            this.mvT = c20800b;
            this.muW = i;
        }

        public final void run() {
            AppMethodBeat.m2504i(20724);
            int i = C39113g.this.mvS;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "now retry count = %d", Integer.valueOf(i2));
                    C39113g.m66550b(this.mvg, 1, this.val$intent);
                    String Nj = C26373g.m41965Nv().mo5297Nj();
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from cinfig : %s", Nj);
                    if (C5046bo.isNullOrNil(Nj)) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from config failed, use the default url : %s", "http://10.1.0.6/redirect");
                        Nj = "http://10.1.0.6/redirect";
                    }
                    String MH = C39113g.m66549MH(Nj);
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url : %s, %s", Nj, MH);
                    if (C5046bo.isNullOrNil(MH)) {
                        C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url failed : %s, %s", Nj, MH);
                        try {
                            Thread.sleep(500);
                            i = i2;
                        } catch (Exception e) {
                            i = i2;
                        }
                    } else {
                        Nj = C39113g.m66551er(MH, "auth=");
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauthmessage from location : %s, %s", Nj, MH);
                        if (C5046bo.isNullOrNil(Nj)) {
                            C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauth message from location failed : %s", MH);
                            C39113g.m66550b(this.mvg, 3, this.val$intent);
                        }
                        if (this.mvT != null) {
                            this.mvT.mo36090ci(Nj, this.muW);
                        }
                        AppMethodBeat.m2505o(20724);
                        return;
                    }
                }
                if (this.mvT != null) {
                    this.mvT.mo36090ci(null, this.muW);
                }
                C39113g.m66550b(this.mvg, 3, this.val$intent);
                AppMethodBeat.m2505o(20724);
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: MH */
    static String m66549MH(String str) {
        Exception e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        AppMethodBeat.m2504i(20726);
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "code : %d, location : %s", Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.m2505o(20726);
                    return r1;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        AppMethodBeat.m2505o(20726);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.m2505o(20726);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.m2505o(20726);
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            AppMethodBeat.m2505o(20726);
            return null;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", e.getMessage());
            if (httpURLConnection != null) {
            }
            AppMethodBeat.m2505o(20726);
            return null;
        } catch (Throwable th22) {
            th = th22;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            AppMethodBeat.m2505o(20726);
            throw th;
        }
    }

    /* renamed from: b */
    static /* synthetic */ void m66550b(String str, int i, Intent intent) {
        AppMethodBeat.m2504i(20727);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "update ssid  : %s to new state : %d", str, Integer.valueOf(i));
        if (i == 3) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetwork", "new state is connect failed, update local freewifiinfo expired time to now");
            C3137c MK = C11976j.byW().mo17044MK(str);
            if (MK != null) {
                MK.field_expiredTime = C5046bo.anT() - 10;
                boolean c = C11976j.byW().mo10103c(MK, new String[0]);
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetwork", "update local freewifi info expired time : ssid is : %s, now time is : %d, update ret : %b", str, Long.valueOf(MK.field_expiredTime), Boolean.valueOf(c));
            }
        }
        C45957d.m85352a(str, i, intent);
        AppMethodBeat.m2505o(20727);
    }

    /* renamed from: er */
    static /* synthetic */ String m66551er(String str, String str2) {
        AppMethodBeat.m2504i(20728);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiNetwork", "null or nil header");
        } else {
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
                        AppMethodBeat.m2505o(20728);
                        return substring;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(20728);
        return null;
    }
}
