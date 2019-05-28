package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24370er.C24369a;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31029ce.C24362a;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.bg */
public class C16208bg {
    /* renamed from: a */
    private static volatile boolean f3140a = false;

    /* renamed from: a */
    public static synchronized void m24694a(C16209bh c16209bh) {
        boolean z = true;
        int i = 0;
        synchronized (C16208bg.class) {
            AppMethodBeat.m2504i(98561);
            if (f3140a) {
                AppMethodBeat.m2505o(98561);
            } else {
                System.currentTimeMillis();
                SystemClock.elapsedRealtime();
                C16210bi c16210bi;
                if (c16209bh == null) {
                    c16210bi = new C16210bi("initParam null");
                    AppMethodBeat.m2505o(98561);
                    throw c16210bi;
                }
                String packageName = c16209bh.mo29243a().getPackageName();
                String a = C24370er.m37708a(c16209bh.mo29243a());
                boolean f = c16209bh.mo29248f();
                int g = c16209bh.mo29249g();
                int e = c16209bh.mo29246d() ? c16209bh.mo29247e() : C24370er.m37704a(c16209bh.mo29243a(), packageName);
                if (e <= 0) {
                    c16210bi = new C16210bi("appid illegal:".concat(String.valueOf(e)));
                    AppMethodBeat.m2505o(98561);
                    throw c16210bi;
                } else if (!f || g > 0) {
                    if (!c16209bh.mo29246d()) {
                        C24369a a2 = C24370er.m37705a(e, c16209bh.mo29243a(), packageName, "com.tencent.halley.common.platform.service.PlatformService");
                        if (a2 == null) {
                            c16210bi = new C16210bi("need set PlatformService in manifest for halley");
                            AppMethodBeat.m2505o(98561);
                            throw c16210bi;
                        }
                        if (!(a2.f4674d == null || a2.f4671a == null)) {
                            if (a2.f4674d.equals(a2.f4671a)) {
                                z = false;
                            }
                            C46772bt.f18097f = z;
                        }
                        if (a2.f4673c) {
                            c16210bi = new C16210bi("need set PlatformService exported to false");
                            AppMethodBeat.m2505o(98561);
                            throw c16210bi;
                        } else if (a2.f4672b) {
                            C24369a a3 = C24370er.m37705a(e, c16209bh.mo29243a(), packageName, "com.tencent.halley.common.platform.service.ActivateService");
                            if (a3 != null) {
                                if (!a3.f4673c) {
                                    c16210bi = new C16210bi("need set ActivateService exported to true");
                                    AppMethodBeat.m2505o(98561);
                                    throw c16210bi;
                                } else if (a3.f4675e == null) {
                                    c16210bi = new C16210bi("need set security_version for ActivateService");
                                    AppMethodBeat.m2505o(98561);
                                    throw c16210bi;
                                } else {
                                    i = a3.f4675e.getInt("security_version");
                                    if (i <= 0) {
                                        c16210bi = new C16210bi("need set valid security_version for ActivateService");
                                        AppMethodBeat.m2505o(98561);
                                        throw c16210bi;
                                    }
                                }
                            }
                        } else {
                            c16210bi = new C16210bi("need set PlatformService enabled to true");
                            AppMethodBeat.m2505o(98561);
                            throw c16210bi;
                        }
                    }
                    if (!f) {
                        g = e;
                    }
                    C46772bt.m88737a(f, g, c16209bh, a, i);
                    C41035bw.m71359a();
                    C24362a.m37669a(c16209bh.mo29250h());
                    C46780en.m88752d().mo75366g();
                    f3140a = true;
                    SystemClock.elapsedRealtime();
                    AppMethodBeat.m2505o(98561);
                } else {
                    C16210bi c16210bi2 = new C16210bi("testAppid illegal:".concat(String.valueOf(g)));
                    AppMethodBeat.m2505o(98561);
                    throw c16210bi2;
                }
            }
        }
    }

    /* renamed from: b */
    public static C36485bk m24695b(C16209bh c16209bh) {
        AppMethodBeat.m2504i(98562);
        if (!f3140a) {
            C16208bg.m24694a(c16209bh);
        }
        C36892bn a = C36892bn.m61408a();
        AppMethodBeat.m2505o(98562);
        return a;
    }
}
