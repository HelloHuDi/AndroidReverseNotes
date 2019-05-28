package com.tencent.mm.plugin.freewifi.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class f {
    private b mvM;

    public static final class b {
        public long mvE;
        public String mvO;
        public String mvP;
        public String mvQ;
        public boolean mvR;

        /* synthetic */ b(String str, String str2, String str3, long j, byte b) {
            this(str, str2, str3, j);
        }

        b(String str, String str2, String str3, long j) {
            AppMethodBeat.i(20720);
            this.mvO = m.Mv(str);
            this.mvP = str2;
            this.mvQ = str3;
            this.mvE = j;
            this.mvR = false;
            AppMethodBeat.o(20720);
        }
    }

    public static class a {
        private static f mvN = new f();

        static {
            AppMethodBeat.i(20719);
            AppMethodBeat.o(20719);
        }
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
    }

    public final synchronized void byP() {
        AppMethodBeat.i(20721);
        if (this.mvM != null) {
            ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", this.mvM.mvO, this.mvM.mvP);
        } else {
            ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
        }
        this.mvM = null;
        ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory is null.");
        AppMethodBeat.o(20721);
    }

    public final synchronized boolean S(String str, String str2, String str3) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(20722);
            if (bo.Q(str, str2, str3)) {
                ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "WifiInfo got Currently is null. Cannot compared with last WifiInfo.");
                AppMethodBeat.o(20722);
            } else {
                if (this.mvM != null) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory : ssid=%s, bssid=%s ", this.mvM.mvO, this.mvM.mvP);
                    if (m.Mv(str).equals(this.mvM.mvO) && str2.equalsIgnoreCase(this.mvM.mvP)) {
                        AppMethodBeat.o(20722);
                    }
                } else {
                    ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "last WifiInfo stored in memmory is null.");
                }
                this.mvM = new b(m.Mv(str), str2, str3, System.currentTimeMillis(), (byte) 0);
                ab.i("MicroMsg.FreeWifi.FreeWifiNetChangeManager.onNetworkChangeFreeWifi", "new WifiInfo stored in memmory : ssid=%s, bssid=%s ", this.mvM.mvO, this.mvM.mvP);
                AppMethodBeat.o(20722);
                z = true;
            }
        }
        return z;
    }

    public final synchronized b byQ() {
        return this.mvM;
    }

    public final synchronized void byR() {
        AppMethodBeat.i(20723);
        if (this.mvM != null) {
            b bVar;
            b bVar2 = this.mvM;
            if (bVar2.mvR) {
                bVar = bVar2;
            } else {
                bVar = new b(bVar2.mvO, bVar2.mvP, bVar2.mvQ, bVar2.mvE);
                bVar.mvR = true;
            }
            this.mvM = bVar;
        }
        AppMethodBeat.o(20723);
    }
}
