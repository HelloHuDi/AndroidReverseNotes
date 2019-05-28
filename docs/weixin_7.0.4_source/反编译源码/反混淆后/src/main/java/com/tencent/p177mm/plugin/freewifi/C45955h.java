package com.tencent.p177mm.plugin.freewifi;

import android.net.Uri;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.p417g.C11961b;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.protocal.protobuf.C15315ad;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.freewifi.h */
public final class C45955h {
    private C11961b mtP;
    private String userAgent;

    /* renamed from: com.tencent.mm.plugin.freewifi.h$b */
    public static class C39112b {
        private static C45955h mtY = new C45955h();

        static {
            AppMethodBeat.m2504i(20582);
            AppMethodBeat.m2505o(20582);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.h$a */
    enum C45954a {
        version("version", "2"),
        httpConnectTimeoutMillis("httpConnectTimeoutMillis", "5000"),
        httpReadTimeoutMillis("httpReadTimeoutMillis", "5000"),
        pingEnabled("pingEnabled", "1"),
        pingUrl("pingUrl", "http://o2o.gtimg.com/wifi/echo"),
        threeTwoBlackUrl("threeTwoBlackUrl", "http://o2o.gtimg.com/wifi/echo.html");
        
        String key;
        String mtW;

        static {
            AppMethodBeat.m2505o(20581);
        }

        private C45954a(String str, String str2) {
            this.key = str;
            this.mtW = str2;
        }
    }

    /* synthetic */ C45955h(byte b) {
        this();
    }

    private C45955h() {
        AppMethodBeat.m2504i(20583);
        this.mtP = C11976j.byX();
        AppMethodBeat.m2505o(20583);
    }

    /* renamed from: a */
    public final synchronized void mo73808a(C15315ad c15315ad) {
        AppMethodBeat.m2504i(20584);
        byf();
        if (c15315ad == null || c15315ad.vBg == null) {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config is null.");
            AppMethodBeat.m2505o(20584);
        } else {
            this.mtP.bzw();
            if (c15315ad.vBg.version == -1) {
                this.mtP.axQ();
                C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "all local config data deleted.");
                this.mtP.bzw();
                AppMethodBeat.m2505o(20584);
            } else {
                if (c15315ad.vBg.version > byg()) {
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version is %d, local version is %d.", Integer.valueOf(c15315ad.vBg.version), Integer.valueOf(byg()));
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.version = %d " + c15315ad.vBg.version);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpConnectTimeoutMillis = %d " + c15315ad.vBg.wbk);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.httpReadTimeoutMillis = %d " + c15315ad.vBg.wbl);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingUrl = %s " + c15315ad.vBg.cuG);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.pingEnabled = %s " + c15315ad.vBg.cuF);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "resp.config.ThreeTwoBlackUrl = %s " + c15315ad.vBg.wbm);
                    C45955h.m85344vN(c15315ad.vBg.wbk);
                    m85345vO(c15315ad.vBg.wbl);
                    m85341Ms(c15315ad.vBg.cuG);
                    m85340Mr(c15315ad.vBg.cuF);
                    m85342Mt(c15315ad.vBg.wbm);
                    m85343vM(c15315ad.vBg.version);
                    C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "local config data changed.");
                    this.mtP.bzw();
                }
                AppMethodBeat.m2505o(20584);
            }
        }
    }

    private synchronized void byf() {
        AppMethodBeat.m2504i(20585);
        try {
            String MJ = this.mtP.mo23801MJ(C45954a.version.key);
            if (!C34189m.isEmpty(MJ) && Integer.valueOf(MJ).intValue() < Integer.valueOf(C45954a.version.mtW).intValue()) {
                C45955h.m85344vN(Integer.valueOf(C45954a.httpConnectTimeoutMillis.mtW).intValue());
                m85345vO(Integer.valueOf(C45954a.httpReadTimeoutMillis.mtW).intValue());
                m85341Ms(C45954a.pingUrl.mtW);
                m85340Mr(C45954a.pingEnabled.mtW);
                m85342Mt(C45954a.threeTwoBlackUrl.mtW);
                m85343vM(Integer.valueOf(C45954a.version.mtW).intValue());
            }
            AppMethodBeat.m2505o(20585);
        } catch (Exception e) {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiConfigHelper", "updateDiskDbCacheIfLowerThanDefault exception. " + C34189m.m56078h(e));
            AppMethodBeat.m2505o(20585);
        }
        return;
    }

    public final synchronized int byg() {
        int intValue;
        AppMethodBeat.m2504i(20586);
        byf();
        try {
            String MJ = this.mtP.mo23801MJ(C45954a.version.key);
            if (C34189m.isEmpty(MJ)) {
                intValue = Integer.valueOf(C45954a.version.mtW).intValue();
                AppMethodBeat.m2505o(20586);
            } else {
                intValue = Integer.valueOf(MJ).intValue();
                AppMethodBeat.m2505o(20586);
            }
        } catch (Exception e) {
            intValue = Integer.valueOf(C45954a.version.mtW).intValue();
            AppMethodBeat.m2505o(20586);
        }
        return intValue;
    }

    /* renamed from: vM */
    private synchronized void m85343vM(int i) {
        AppMethodBeat.m2504i(20587);
        if (i > Integer.valueOf(C45954a.version.mtW).intValue()) {
            C11976j.byX().mo23804et(C45954a.version.key, String.valueOf(i));
        }
        AppMethodBeat.m2505o(20587);
    }

    public final int byh() {
        AppMethodBeat.m2504i(20588);
        byf();
        int intValue;
        try {
            String MJ = this.mtP.mo23801MJ(C45954a.httpConnectTimeoutMillis.key);
            if (C34189m.isEmpty(MJ)) {
                intValue = Integer.valueOf(C45954a.httpConnectTimeoutMillis.mtW).intValue();
                AppMethodBeat.m2505o(20588);
                return intValue;
            }
            intValue = Integer.valueOf(MJ).intValue();
            AppMethodBeat.m2505o(20588);
            return intValue;
        } catch (Exception e) {
            intValue = Integer.valueOf(C45954a.httpConnectTimeoutMillis.mtW).intValue();
            AppMethodBeat.m2505o(20588);
            return intValue;
        }
    }

    /* renamed from: vN */
    private static void m85344vN(int i) {
        AppMethodBeat.m2504i(20589);
        if (i > 0) {
            C11976j.byX().mo23804et(C45954a.httpConnectTimeoutMillis.key, String.valueOf(i));
        }
        AppMethodBeat.m2505o(20589);
    }

    public final int byi() {
        AppMethodBeat.m2504i(20590);
        byf();
        int intValue;
        try {
            String MJ = this.mtP.mo23801MJ(C45954a.httpReadTimeoutMillis.key);
            if (C34189m.isEmpty(MJ)) {
                intValue = Integer.valueOf(C45954a.httpReadTimeoutMillis.mtW).intValue();
                AppMethodBeat.m2505o(20590);
                return intValue;
            }
            intValue = Integer.valueOf(MJ).intValue();
            AppMethodBeat.m2505o(20590);
            return intValue;
        } catch (Exception e) {
            intValue = Integer.valueOf(C45954a.httpReadTimeoutMillis.mtW).intValue();
            AppMethodBeat.m2505o(20590);
            return intValue;
        }
    }

    /* renamed from: vO */
    private void m85345vO(int i) {
        AppMethodBeat.m2504i(20591);
        if (i > 0) {
            this.mtP.mo23804et(C45954a.httpReadTimeoutMillis.key, String.valueOf(i));
        }
        AppMethodBeat.m2505o(20591);
    }

    public final String byj() {
        AppMethodBeat.m2504i(20592);
        byf();
        String str;
        try {
            if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(this.mtP.mo23801MJ(C45954a.pingEnabled.key))) {
                str = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                AppMethodBeat.m2505o(20592);
                return str;
            }
            str = "1";
            AppMethodBeat.m2505o(20592);
            return str;
        } catch (Exception e) {
            str = C45954a.pingEnabled.mtW;
            AppMethodBeat.m2505o(20592);
            return str;
        }
    }

    /* renamed from: Mr */
    private void m85340Mr(String str) {
        AppMethodBeat.m2504i(20593);
        if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(str) || "1".equals(str)) {
            try {
                this.mtP.mo23804et(C45954a.pingEnabled.key, str);
                AppMethodBeat.m2505o(20593);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(20593);
    }

    public final String byk() {
        AppMethodBeat.m2504i(20594);
        byf();
        String MJ;
        try {
            MJ = this.mtP.mo23801MJ(C45954a.pingUrl.key);
            if (C34189m.isEmpty(MJ)) {
                MJ = C45954a.pingUrl.mtW;
                AppMethodBeat.m2505o(20594);
                return MJ;
            }
            Uri.parse(MJ);
            AppMethodBeat.m2505o(20594);
            return MJ;
        } catch (Exception e) {
            MJ = C45954a.pingUrl.mtW;
            AppMethodBeat.m2505o(20594);
            return MJ;
        }
    }

    /* renamed from: Ms */
    private void m85341Ms(String str) {
        AppMethodBeat.m2504i(20595);
        if (!C34189m.isEmpty(str)) {
            try {
                Uri.parse(str);
                this.mtP.mo23804et(C45954a.pingUrl.key, str);
                AppMethodBeat.m2505o(20595);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(20595);
    }

    public final String byl() {
        AppMethodBeat.m2504i(20596);
        byf();
        String MJ;
        try {
            MJ = this.mtP.mo23801MJ(C45954a.threeTwoBlackUrl.key);
            if (C34189m.isEmpty(MJ)) {
                MJ = C45954a.threeTwoBlackUrl.mtW;
                AppMethodBeat.m2505o(20596);
                return MJ;
            }
            Uri.parse(MJ);
            AppMethodBeat.m2505o(20596);
            return MJ;
        } catch (Exception e) {
            MJ = C45954a.threeTwoBlackUrl.mtW;
            AppMethodBeat.m2505o(20596);
            return MJ;
        }
    }

    /* renamed from: Mt */
    private void m85342Mt(String str) {
        AppMethodBeat.m2504i(20597);
        if (!C34189m.isEmpty(str)) {
            try {
                Uri.parse(str);
                this.mtP.mo23804et(C45954a.threeTwoBlackUrl.key, str);
                AppMethodBeat.m2505o(20597);
                return;
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(20597);
    }

    public final String getUserAgent() {
        AppMethodBeat.m2504i(20598);
        if (C34189m.isEmpty(this.userAgent)) {
            this.userAgent = C30152u.m47747bh(C4996ah.getContext(), null).toLowerCase();
        }
        String str = this.userAgent;
        AppMethodBeat.m2505o(20598);
        return str;
    }
}
