package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.HttpURLConnection;
import java.net.URL;

public final class g {
    int mvS = 5;

    public interface a {
    }

    public interface b {
        void ci(String str, int i);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.g$2 */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String mvV;
        final /* synthetic */ a mvW = null;
        final /* synthetic */ String mvg;
        final /* synthetic */ Intent val$intent;

        AnonymousClass2(String str, String str2, Intent intent) {
            this.mvV = str;
            this.mvg = str2;
            this.val$intent = intent;
        }

        public final void run() {
            AppMethodBeat.i(20725);
            String MH = g.MH(this.mvV);
            ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get redirect location from loginurl : %s, %s", MH, this.mvV);
            if (!bo.isNullOrNil(MH)) {
                String er = g.er(MH, "res=");
                ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get connect result from location : %s, %s", er, MH);
                if (!bo.isNullOrNil(er) && (er.startsWith("success") || er.startsWith("already"))) {
                    g.b(this.mvg, 2, this.val$intent);
                    j.byW().MM(this.mvg);
                    AppMethodBeat.o(20725);
                    return;
                }
            }
            g.b(this.mvg, 3, this.val$intent);
            AppMethodBeat.o(20725);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.g$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int muW;
        final /* synthetic */ b mvT;
        final /* synthetic */ String mvg;
        final /* synthetic */ Intent val$intent;

        AnonymousClass1(String str, Intent intent, b bVar, int i) {
            this.mvg = str;
            this.val$intent = intent;
            this.mvT = bVar;
            this.muW = i;
        }

        public final void run() {
            AppMethodBeat.i(20724);
            int i = g.this.mvS;
            while (true) {
                int i2 = i - 1;
                if (i > 0) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "now retry count = %d", Integer.valueOf(i2));
                    g.b(this.mvg, 1, this.val$intent);
                    String Nj = com.tencent.mm.m.g.Nv().Nj();
                    ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from cinfig : %s", Nj);
                    if (bo.isNullOrNil(Nj)) {
                        ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get check url from config failed, use the default url : %s", "http://10.1.0.6/redirect");
                        Nj = "http://10.1.0.6/redirect";
                    }
                    String MH = g.MH(Nj);
                    ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url : %s, %s", Nj, MH);
                    if (bo.isNullOrNil(MH)) {
                        ab.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get location from url failed : %s, %s", Nj, MH);
                        try {
                            Thread.sleep(500);
                            i = i2;
                        } catch (Exception e) {
                            i = i2;
                        }
                    } else {
                        Nj = g.er(MH, "auth=");
                        ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauthmessage from location : %s, %s", Nj, MH);
                        if (bo.isNullOrNil(Nj)) {
                            ab.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get apauth message from location failed : %s", MH);
                            g.b(this.mvg, 3, this.val$intent);
                        }
                        if (this.mvT != null) {
                            this.mvT.ci(Nj, this.muW);
                        }
                        AppMethodBeat.o(20724);
                        return;
                    }
                }
                if (this.mvT != null) {
                    this.mvT.ci(null, this.muW);
                }
                g.b(this.mvg, 3, this.val$intent);
                AppMethodBeat.o(20724);
                return;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0072  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static String MH(String str) {
        Exception e;
        HttpURLConnection httpURLConnection;
        Throwable th;
        AppMethodBeat.i(20726);
        try {
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection2 != null) {
                try {
                    httpURLConnection2.setConnectTimeout(30000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    int responseCode = httpURLConnection2.getResponseCode();
                    ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "code : %d, location : %s", Integer.valueOf(responseCode), httpURLConnection2.getHeaderField("Location"));
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    AppMethodBeat.o(20726);
                    return r1;
                } catch (Exception e2) {
                    e = e2;
                    httpURLConnection = httpURLConnection2;
                    try {
                        ab.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        AppMethodBeat.o(20726);
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                        }
                        AppMethodBeat.o(20726);
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    AppMethodBeat.o(20726);
                    throw th;
                }
            }
            if (httpURLConnection2 != null) {
                httpURLConnection2.disconnect();
            }
            AppMethodBeat.o(20726);
            return null;
        } catch (Exception e3) {
            e = e3;
            httpURLConnection = null;
            ab.e("MicroMsg.FreeWifi.FreeWifiNetwork", "get recirect location failed : %s", e.getMessage());
            if (httpURLConnection != null) {
            }
            AppMethodBeat.o(20726);
            return null;
        } catch (Throwable th22) {
            th = th22;
            httpURLConnection = null;
            if (httpURLConnection != null) {
            }
            AppMethodBeat.o(20726);
            throw th;
        }
    }

    static /* synthetic */ void b(String str, int i, Intent intent) {
        AppMethodBeat.i(20727);
        ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update ssid  : %s to new state : %d", str, Integer.valueOf(i));
        if (i == 3) {
            ab.e("MicroMsg.FreeWifi.FreeWifiNetwork", "new state is connect failed, update local freewifiinfo expired time to now");
            c MK = j.byW().MK(str);
            if (MK != null) {
                MK.field_expiredTime = bo.anT() - 10;
                boolean c = j.byW().c(MK, new String[0]);
                ab.i("MicroMsg.FreeWifi.FreeWifiNetwork", "update local freewifi info expired time : ssid is : %s, now time is : %d, update ret : %b", str, Long.valueOf(MK.field_expiredTime), Boolean.valueOf(c));
            }
        }
        d.a(str, i, intent);
        AppMethodBeat.o(20727);
    }

    static /* synthetic */ String er(String str, String str2) {
        AppMethodBeat.i(20728);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiNetwork", "null or nil header");
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
                        AppMethodBeat.o(20728);
                        return substring;
                    }
                }
            }
        }
        AppMethodBeat.o(20728);
        return null;
    }
}
