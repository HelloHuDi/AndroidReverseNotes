package com.tencent.luggage.sdk.config;

import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.C42409s;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.sdk.p603e.C4935m;
import com.tencent.p177mm.sdk.p603e.C7296k.C4931a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.luggage.sdk.config.a */
public class C6276a implements C4931a {
    public static C6276a bPZ;
    private static String[] bQc = new String[]{"username", "appId", "versionInfo", "appInfo", "smallHeadURL", "nickname"};
    private final Map<String, AppBrandInitConfigLU> bQa = new C6197a();
    private final Map<String, String> bQb = new C6197a();

    protected C6276a() {
        AppMethodBeat.m2504i(101602);
        AppMethodBeat.m2505o(101602);
    }

    public static void release() {
        synchronized (C6276a.class) {
            bPZ = null;
        }
    }

    /* renamed from: xw */
    public static C6276a m10270xw() {
        C6276a c6276a;
        synchronized (C6276a.class) {
            c6276a = bPZ;
        }
        return c6276a;
    }

    /* renamed from: a */
    public final void mo5248a(String str, C4935m c4935m) {
        AppMethodBeat.m2504i(101603);
        if ("single".equals(str)) {
            if (String.class.isInstance(c4935m.obj)) {
                String valueOf = String.valueOf(c4935m.obj);
                if (!C5046bo.isNullOrNil(valueOf)) {
                    m10269bL(valueOf);
                }
            }
            AppMethodBeat.m2505o(101603);
        } else if ("batch".equals(str)) {
            synchronized (this.bQa) {
                try {
                    this.bQa.clear();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(101603);
                }
            }
        } else {
            AppMethodBeat.m2505o(101603);
        }
    }

    /* renamed from: bK */
    public final String mo14507bK(String str) {
        AppMethodBeat.m2504i(101604);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101604);
            return null;
        }
        String str2;
        synchronized (this.bQb) {
            try {
                str2 = (String) this.bQb.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(101604);
            }
        }
        return str2;
    }

    /* renamed from: bL */
    private AppBrandInitConfigLU m10269bL(String str) {
        AppMethodBeat.m2504i(101605);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101605);
            return null;
        }
        String str2;
        AppBrandInitConfigLU a;
        synchronized (this.bQb) {
            try {
                str2 = (String) this.bQb.get(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(101605);
                }
            }
        }
        if (C5046bo.isNullOrNil(str2)) {
            C42409s.ayO();
            a = mo14505a(C42409s.m75084f(String.format("%s=?", new Object[]{"username"}), new String[]{str}));
            if (a != null) {
                synchronized (this.bQb) {
                    try {
                        this.bQb.put(str, a.appId);
                    } catch (Throwable th2) {
                        while (true) {
                            AppMethodBeat.m2505o(101605);
                        }
                    }
                }
            }
        } else {
            a = mo14508bM(str2);
        }
        AppMethodBeat.m2505o(101605);
        return a;
    }

    /* renamed from: a */
    public AppBrandInitConfigLU mo14505a(WxaAttributes wxaAttributes) {
        AppMethodBeat.m2504i(101606);
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
        AppMethodBeat.m2505o(101606);
        return appBrandInitConfigLU;
    }

    /* renamed from: bM */
    public AppBrandInitConfigLU mo14508bM(String str) {
        AppMethodBeat.m2504i(101607);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101607);
            return null;
        }
        AppBrandInitConfigLU appBrandInitConfigLU;
        synchronized (this.bQa) {
            try {
                appBrandInitConfigLU = (AppBrandInitConfigLU) this.bQa.remove(str);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(101607);
                }
            }
        }
        if (appBrandInitConfigLU == null) {
            C42409s.ayO();
            appBrandInitConfigLU = mo14505a(C42409s.m75085zB(str));
        }
        AppMethodBeat.m2505o(101607);
        return appBrandInitConfigLU;
    }

    /* renamed from: a */
    public final void mo14506a(String str, AppBrandInitConfigLU appBrandInitConfigLU) {
        AppMethodBeat.m2504i(101608);
        if (appBrandInitConfigLU == null || C5046bo.isNullOrNil(appBrandInitConfigLU.appId)) {
            AppMethodBeat.m2505o(101608);
            return;
        }
        synchronized (this.bQa) {
            try {
                this.bQa.put(appBrandInitConfigLU.appId, appBrandInitConfigLU);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(101608);
            }
        }
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101608);
            return;
        }
        synchronized (this.bQb) {
            try {
                this.bQb.put(str, appBrandInitConfigLU.appId);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(101608);
                }
            }
        }
    }
}
