package com.tencent.mm.plugin.freewifi;

import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.protobuf.ad;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class h {
    private com.tencent.mm.plugin.freewifi.g.b mtP;
    private String userAgent;

    public static class b {
        private static h mtY = new h();

        static {
            AppMethodBeat.i(20582);
            AppMethodBeat.o(20582);
        }
    }

    enum a {
        version("version", "2"),
        httpConnectTimeoutMillis("httpConnectTimeoutMillis", "5000"),
        httpReadTimeoutMillis("httpReadTimeoutMillis", "5000"),
        pingEnabled("pingEnabled", "1"),
        pingUrl("pingUrl", "http://o2o.gtimg.com/wifi/echo"),
        threeTwoBlackUrl("threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
        
        String key;
        String mtW;

        static {
            AppMethodBeat.o(20581);
        }

        private a(String str, String str2) {
            this.key = str;
            this.mtW = str2;
        }
    }

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        AppMethodBeat.i(20583);
        this.mtP = j.byX();
        AppMethodBeat.o(20583);
    }

    public final synchronized void a(ad adVar) {
        AppMethodBeat.i(20584);
        byf();
        if (adVar == null || adVar.vBg == null) {
            ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
            AppMethodBeat.o(20584);
        } else {
            this.mtP.bzw();
            if (adVar.vBg.version == -1) {
                this.mtP.axQ();
                ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
                this.mtP.bzw();
                AppMethodBeat.o(20584);
            } else {
                if (adVar.vBg.version > byg()) {
                    ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", Integer.valueOf(adVar.vBg.version), Integer.valueOf(byg()));
                    ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + adVar.vBg.version);
                    ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + adVar.vBg.wbk);
                    ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + adVar.vBg.wbl);
                    ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + adVar.vBg.cuG);
                    ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + adVar.vBg.cuF);
                    ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + adVar.vBg.wbm);
                    vN(adVar.vBg.wbk);
                    vO(adVar.vBg.wbl);
                    Ms(adVar.vBg.cuG);
                    Mr(adVar.vBg.cuF);
                    Mt(adVar.vBg.wbm);
                    vM(adVar.vBg.version);
                    ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
                    this.mtP.bzw();
                }
                AppMethodBeat.o(20584);
            }
        }
    }

    private synchronized void byf() {
        AppMethodBeat.i(20585);
        try {
            String MJ = this.mtP.MJ(a.version.key);
            if (!m.isEmpty(MJ) && Integer.valueOf(MJ).intValue() < Integer.valueOf(a.version.mtW).intValue()) {
                vN(Integer.valueOf(a.httpConnectTimeoutMillis.mtW).intValue());
                vO(Integer.valueOf(a.httpReadTimeoutMillis.mtW).intValue());
                Ms(a.pingUrl.mtW);
                Mr(a.pingEnabled.mtW);
                Mt(a.threeTwoBlackUrl.mtW);
                vM(Integer.valueOf(a.version.mtW).intValue());
            }
            AppMethodBeat.o(20585);
        } catch (Exception e) {
            ab.i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + m.h(e));
            AppMethodBeat.o(20585);
        }
        return;
    }

    public final synchronized int byg() {
        int intValue;
        AppMethodBeat.i(20586);
        byf();
        try {
            String MJ = this.mtP.MJ(a.version.key);
            if (m.isEmpty(MJ)) {
                intValue = Integer.valueOf(a.version.mtW).intValue();
                AppMethodBeat.o(20586);
            } else {
                intValue = Integer.valueOf(MJ).intValue();
                AppMethodBeat.o(20586);
            }
        } catch (Exception e) {
            intValue = Integer.valueOf(a.version.mtW).intValue();
            AppMethodBeat.o(20586);
        }
        return intValue;
    }

    private synchronized void vM(int i) {
        AppMethodBeat.i(20587);
        if (i > Integer.valueOf(a.version.mtW).intValue()) {
            j.byX().et(a.version.key, String.valueOf(i));
        }
        AppMethodBeat.o(20587);
    }

    public final int byh() {
        AppMethodBeat.i(20588);
        byf();
        int intValue;
        try {
            String MJ = this.mtP.MJ(a.httpConnectTimeoutMillis.key);
            if (m.isEmpty(MJ)) {
                intValue = Integer.valueOf(a.httpConnectTimeoutMillis.mtW).intValue();
                AppMethodBeat.o(20588);
                return intValue;
            }
            intValue = Integer.valueOf(MJ).intValue();
            AppMethodBeat.o(20588);
            return intValue;
        } catch (Exception e) {
            intValue = Integer.valueOf(a.httpConnectTimeoutMillis.mtW).intValue();
            AppMethodBeat.o(20588);
            return intValue;
        }
    }

    private static void vN(int i) {
        AppMethodBeat.i(20589);
        if (i > 0) {
            j.byX().et(a.httpConnectTimeoutMillis.key, String.valueOf(i));
        }
        AppMethodBeat.o(20589);
    }

    public final int byi() {
        AppMethodBeat.i(20590);
        byf();
        int intValue;
        try {
            String MJ = this.mtP.MJ(a.httpReadTimeoutMillis.key);
            if (m.isEmpty(MJ)) {
                intValue = Integer.valueOf(a.httpReadTimeoutMillis.mtW).intValue();
                AppMethodBeat.o(20590);
                return intValue;
            }
            intValue = Integer.valueOf(MJ).intValue();
            AppMethodBeat.o(20590);
            return intValue;
        } catch (Exception e) {
            intValue = Integer.valueOf(a.httpReadTimeoutMillis.mtW).intValue();
            AppMethodBeat.o(20590);
            return intValue;
        }
    }

    private void vO(int i) {
        AppMethodBeat.i(20591);
        if (i > 0) {
            this.mtP.et(a.httpReadTimeoutMillis.key, String.valueOf(i));
        }
        AppMethodBeat.o(20591);
    }

    public final String byj() {
        AppMethodBeat.i(20592);
        byf();
        String str;
        try {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.mtP.MJ(a.pingEnabled.key))) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                AppMethodBeat.o(20592);
                return str;
            }
            str = "1";
            AppMethodBeat.o(20592);
            return str;
        } catch (Exception e) {
            str = a.pingEnabled.mtW;
            AppMethodBeat.o(20592);
            return str;
        }
    }

    private void Mr(String str) {
        AppMethodBeat.i(20593);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "1".equals(str)) {
            try {
                this.mtP.et(a.pingEnabled.key, str);
                AppMethodBeat.o(20593);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(20593);
    }

    public final String byk() {
        AppMethodBeat.i(20594);
        byf();
        String MJ;
        try {
            MJ = this.mtP.MJ(a.pingUrl.key);
            if (m.isEmpty(MJ)) {
                MJ = a.pingUrl.mtW;
                AppMethodBeat.o(20594);
                return MJ;
            }
            Uri.parse(MJ);
            AppMethodBeat.o(20594);
            return MJ;
        } catch (Exception e) {
            MJ = a.pingUrl.mtW;
            AppMethodBeat.o(20594);
            return MJ;
        }
    }

    private void Ms(String str) {
        AppMethodBeat.i(20595);
        if (!m.isEmpty(str)) {
            try {
                Uri.parse(str);
                this.mtP.et(a.pingUrl.key, str);
                AppMethodBeat.o(20595);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(20595);
    }

    public final String byl() {
        AppMethodBeat.i(20596);
        byf();
        String MJ;
        try {
            MJ = this.mtP.MJ(a.threeTwoBlackUrl.key);
            if (m.isEmpty(MJ)) {
                MJ = a.threeTwoBlackUrl.mtW;
                AppMethodBeat.o(20596);
                return MJ;
            }
            Uri.parse(MJ);
            AppMethodBeat.o(20596);
            return MJ;
        } catch (Exception e) {
            MJ = a.threeTwoBlackUrl.mtW;
            AppMethodBeat.o(20596);
            return MJ;
        }
    }

    private void Mt(String str) {
        AppMethodBeat.i(20597);
        if (!m.isEmpty(str)) {
            try {
                Uri.parse(str);
                this.mtP.et(a.threeTwoBlackUrl.key, str);
                AppMethodBeat.o(20597);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(20597);
    }

    public final String getUserAgent() {
        AppMethodBeat.i(20598);
        if (m.isEmpty(this.userAgent)) {
            this.userAgent = u.bh(ah.getContext(), null).toLowerCase();
        }
        String str = this.userAgent;
        AppMethodBeat.o(20598);
        return str;
    }
}
