package com.tencent.tencentmap.mapsdk.maps.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.a.er.a;

public class bg {
    private static volatile boolean a = false;

    public static synchronized void a(bh bhVar) {
        boolean z = true;
        int i = 0;
        synchronized (bg.class) {
            AppMethodBeat.i(98561);
            if (a) {
                AppMethodBeat.o(98561);
            } else {
                System.currentTimeMillis();
                SystemClock.elapsedRealtime();
                bi biVar;
                if (bhVar == null) {
                    biVar = new bi("initParam null");
                    AppMethodBeat.o(98561);
                    throw biVar;
                }
                String packageName = bhVar.a().getPackageName();
                String a = er.a(bhVar.a());
                boolean f = bhVar.f();
                int g = bhVar.g();
                int e = bhVar.d() ? bhVar.e() : er.a(bhVar.a(), packageName);
                if (e <= 0) {
                    biVar = new bi("appid illegal:".concat(String.valueOf(e)));
                    AppMethodBeat.o(98561);
                    throw biVar;
                } else if (!f || g > 0) {
                    if (!bhVar.d()) {
                        a a2 = er.a(e, bhVar.a(), packageName, "com.tencent.halley.common.platform.service.PlatformService");
                        if (a2 == null) {
                            biVar = new bi("need set PlatformService in manifest for halley");
                            AppMethodBeat.o(98561);
                            throw biVar;
                        }
                        if (!(a2.d == null || a2.a == null)) {
                            if (a2.d.equals(a2.a)) {
                                z = false;
                            }
                            bt.f = z;
                        }
                        if (a2.c) {
                            biVar = new bi("need set PlatformService exported to false");
                            AppMethodBeat.o(98561);
                            throw biVar;
                        } else if (a2.b) {
                            a a3 = er.a(e, bhVar.a(), packageName, "com.tencent.halley.common.platform.service.ActivateService");
                            if (a3 != null) {
                                if (!a3.c) {
                                    biVar = new bi("need set ActivateService exported to true");
                                    AppMethodBeat.o(98561);
                                    throw biVar;
                                } else if (a3.e == null) {
                                    biVar = new bi("need set security_version for ActivateService");
                                    AppMethodBeat.o(98561);
                                    throw biVar;
                                } else {
                                    i = a3.e.getInt("security_version");
                                    if (i <= 0) {
                                        biVar = new bi("need set valid security_version for ActivateService");
                                        AppMethodBeat.o(98561);
                                        throw biVar;
                                    }
                                }
                            }
                        } else {
                            biVar = new bi("need set PlatformService enabled to true");
                            AppMethodBeat.o(98561);
                            throw biVar;
                        }
                    }
                    if (!f) {
                        g = e;
                    }
                    bt.a(f, g, bhVar, a, i);
                    bw.a();
                    ce.a.a(bhVar.h());
                    en.d().g();
                    a = true;
                    SystemClock.elapsedRealtime();
                    AppMethodBeat.o(98561);
                } else {
                    bi biVar2 = new bi("testAppid illegal:".concat(String.valueOf(g)));
                    AppMethodBeat.o(98561);
                    throw biVar2;
                }
            }
        }
    }

    public static bk b(bh bhVar) {
        AppMethodBeat.i(98562);
        if (!a) {
            a(bhVar);
        }
        bn a = bn.a();
        AppMethodBeat.o(98562);
        return a;
    }
}
