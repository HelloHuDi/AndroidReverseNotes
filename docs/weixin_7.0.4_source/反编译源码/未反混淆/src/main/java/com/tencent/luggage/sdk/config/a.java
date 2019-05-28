package com.tencent.luggage.sdk.config;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class a implements com.tencent.mm.sdk.e.k.a {
    public static a bPZ;
    private static String[] bQc = new String[]{"username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname"};
    private final Map<String, AppBrandInitConfigLU> bQa = new android.support.v4.f.a();
    private final Map<String, String> bQb = new android.support.v4.f.a();

    protected a() {
        AppMethodBeat.i(101602);
        AppMethodBeat.o(101602);
    }

    public static void release() {
        synchronized (a.class) {
            bPZ = null;
        }
    }

    public static a xw() {
        a aVar;
        synchronized (a.class) {
            aVar = bPZ;
        }
        return aVar;
    }

    public final void a(String str, m mVar) {
        AppMethodBeat.i(101603);
        if ("single".equals(str)) {
            if (String.class.isInstance(mVar.obj)) {
                String valueOf = String.valueOf(mVar.obj);
                if (!bo.isNullOrNil(valueOf)) {
                    bL(valueOf);
                }
            }
            AppMethodBeat.o(101603);
        } else if ("batch".equals(str)) {
            synchronized (this.bQa) {
                try {
                    this.bQa.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(101603);
                }
            }
        } else {
            AppMethodBeat.o(101603);
        }
    }

    public final String bK(String str) {
        AppMethodBeat.i(101604);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101604);
            return null;
        }
        String str2;
        synchronized (this.bQb) {
            try {
                str2 = (String) this.bQb.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(101604);
            }
        }
        return str2;
    }

    private AppBrandInitConfigLU bL(String str) {
        AppMethodBeat.i(101605);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101605);
            return null;
        }
        String str2;
        AppBrandInitConfigLU a;
        synchronized (this.bQb) {
            try {
                str2 = (String) this.bQb.get(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(101605);
                }
            }
        }
        if (bo.isNullOrNil(str2)) {
            s.ayO();
            a = a(s.f(String.format("%s=?", new Object[]{"username"}), new String[]{str}));
            if (a != null) {
                synchronized (this.bQb) {
                    try {
                        this.bQb.put(str, a.appId);
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.o(101605);
                        }
                    }
                }
            }
        } else {
            a = bM(str2);
        }
        AppMethodBeat.o(101605);
        return a;
    }

    public AppBrandInitConfigLU a(WxaAttributes wxaAttributes) {
        AppMethodBeat.i(101606);
        AppBrandInitConfigLU appBrandInitConfigLU = null;
        if (wxaAttributes != null) {
            appBrandInitConfigLU = new AppBrandInitConfigLU();
            appBrandInitConfigLU.username = wxaAttributes.field_username;
            appBrandInitConfigLU.appId = wxaAttributes.field_appId;
            appBrandInitConfigLU.cwz = wxaAttributes.field_nickname;
            appBrandInitConfigLU.iconUrl = wxaAttributes.field_smallHeadURL;
            appBrandInitConfigLU.bQe = wxaAttributes.ayJ().fmr;
            appBrandInitConfigLU.hgD = wxaAttributes.ayJ().hgD;
            appBrandInitConfigLU.hgE = wxaAttributes.ayJ().hgE;
            if (wxaAttributes.ayL() != null) {
                appBrandInitConfigLU.bQl = wxaAttributes.ayL().bQl;
                appBrandInitConfigLU.axy = wxaAttributes.ayL().axy;
            }
        }
        AppMethodBeat.o(101606);
        return appBrandInitConfigLU;
    }

    public AppBrandInitConfigLU bM(String str) {
        AppMethodBeat.i(101607);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101607);
            return null;
        }
        AppBrandInitConfigLU appBrandInitConfigLU;
        synchronized (this.bQa) {
            try {
                appBrandInitConfigLU = (AppBrandInitConfigLU) this.bQa.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(101607);
                }
            }
        }
        if (appBrandInitConfigLU == null) {
            s.ayO();
            appBrandInitConfigLU = a(s.zB(str));
        }
        AppMethodBeat.o(101607);
        return appBrandInitConfigLU;
    }

    public final void a(String str, AppBrandInitConfigLU appBrandInitConfigLU) {
        AppMethodBeat.i(101608);
        if (appBrandInitConfigLU == null || bo.isNullOrNil(appBrandInitConfigLU.appId)) {
            AppMethodBeat.o(101608);
            return;
        }
        synchronized (this.bQa) {
            try {
                this.bQa.put(appBrandInitConfigLU.appId, appBrandInitConfigLU);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(101608);
            }
        }
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101608);
            return;
        }
        synchronized (this.bQb) {
            try {
                this.bQb.put(str, appBrandInitConfigLU.appId);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(101608);
                }
            }
        }
    }
}
