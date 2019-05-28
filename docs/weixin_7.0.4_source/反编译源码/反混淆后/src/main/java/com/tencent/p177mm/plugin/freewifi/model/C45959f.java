package com.tencent.p177mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.freewifi.model.f */
public final class C45959f {
    private C11971b mvM;

    /* renamed from: com.tencent.mm.plugin.freewifi.model.f$b */
    public static final class C11971b {
        public long mvE;
        public String mvO;
        public String mvP;
        public String mvQ;
        public boolean mvR;

        /* synthetic */ C11971b(String str, String str2, String str3, long j, byte b) {
            this(str, str2, str3, j);
        }

        C11971b(String str, String str2, String str3, long j) {
            AppMethodBeat.m2504i(20720);
            this.mvO = C34189m.m56057Mv(str);
            this.mvP = str2;
            this.mvQ = str3;
            this.mvE = j;
            this.mvR = false;
            AppMethodBeat.m2505o(20720);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.f$a */
    public static class C45958a {
        private static C45959f mvN = new C45959f();

        static {
            AppMethodBeat.m2504i(20719);
            AppMethodBeat.m2505o(20719);
        }
    }

    /* synthetic */ C45959f(byte b) {
        this();
    }

    private C45959f() {
    }

    public final synchronized void byP() {
        AppMethodBeat.m2504i(20721);
        if (this.mvM != null) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", this.mvM.mvO, this.mvM.mvP);
        } else {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
        }
        this.mvM = null;
        C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory is null.");
        AppMethodBeat.m2505o(20721);
    }

    /* renamed from: S */
    public final synchronized boolean mo73816S(String str, String str2, String str3) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(20722);
            if (C5046bo.m7510Q(str, str2, str3)) {
                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "WifiInfo got Currently is null. Cannot compared with last WifiInfo.");
                AppMethodBeat.m2505o(20722);
            } else {
                if (this.mvM != null) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", this.mvM.mvO, this.mvM.mvP);
                    if (C34189m.m56057Mv(str).equals(this.mvM.mvO) && str2.equalsIgnoreCase(this.mvM.mvP)) {
                        AppMethodBeat.m2505o(20722);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
                }
                this.mvM = new C11971b(C34189m.m56057Mv(str), str2, str3, System.currentTimeMillis(), (byte) 0);
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory : ssid=%s, bssid=%s ", this.mvM.mvO, this.mvM.mvP);
                AppMethodBeat.m2505o(20722);
                z = true;
            }
        }
        return z;
    }

    public final synchronized C11971b byQ() {
        return this.mvM;
    }

    public final synchronized void byR() {
        AppMethodBeat.m2504i(20723);
        if (this.mvM != null) {
            C11971b c11971b;
            C11971b c11971b2 = this.mvM;
            if (c11971b2.mvR) {
                c11971b = c11971b2;
            } else {
                c11971b = new C11971b(c11971b2.mvO, c11971b2.mvP, c11971b2.mvQ, c11971b2.mvE);
                c11971b.mvR = true;
            }
            this.mvM = c11971b;
        }
        AppMethodBeat.m2505o(20723);
    }
}
