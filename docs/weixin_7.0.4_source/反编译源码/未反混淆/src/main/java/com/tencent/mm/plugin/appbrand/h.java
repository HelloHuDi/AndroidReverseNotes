package com.tencent.mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.d;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.app.f;
import com.tencent.mm.plugin.appbrand.appcache.ap;
import com.tencent.mm.plugin.appbrand.appcache.n;
import com.tencent.mm.plugin.appbrand.appcache.n.e;
import com.tencent.mm.plugin.appbrand.appcache.r;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vending.c.a;
import com.tencent.smtt.sdk.TbsDownloadConfig;

public final class h {
    private static final c<d> gNw = new c<d>() {
        {
            AppMethodBeat.i(128950);
            this.xxI = d.class.getName().hashCode();
            AppMethodBeat.o(128950);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(128951);
            if (((d) bVar).crQ.crR) {
                n.c.interrupt();
                AppMethodBeat.o(128951);
            } else if (g.RK()) {
                com.tencent.mm.ci.g.dOW().i(new a<Void, Void>() {
                    public final /* synthetic */ Object call(Object obj) {
                        AppMethodBeat.i(128949);
                        Void asR = AnonymousClass1.asR();
                        AppMethodBeat.o(128949);
                        return asR;
                    }

                    private static Void asR() {
                        AppMethodBeat.i(128948);
                        try {
                            Void voidR;
                            if (g.RN().eJb) {
                                long j = r.avG() ? AppBrandGlobalSystemConfig.ayC().hgf.hgu : TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
                                long longValue = ((Long) g.RP().Ry().get(ac.a.USERINFO_APP_BRAND_PRUNE_PKG_NEXT_TIME_SEC_LONG, Long.valueOf(0))).longValue();
                                long anT = bo.anT();
                                if (anT >= longValue) {
                                    g.RP().Ry().set(ac.a.USERINFO_APP_BRAND_PRUNE_PKG_NEXT_TIME_SEC_LONG, Long.valueOf(j + anT));
                                    n.c.avx().run();
                                    if (f.auK() == null) {
                                        ab.e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
                                    } else {
                                        bn bnVar = new bn();
                                        StatFs statFs = new StatFs(ap.avY());
                                        j = VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
                                        long avw = n.b.avw();
                                        if (VERSION.SDK_INT >= 18) {
                                            longValue = statFs.getBlockSizeLong();
                                        } else {
                                            longValue = (long) statFs.getBlockSize();
                                        }
                                        double d = ((double) (avw / longValue)) / ((double) j);
                                        bnVar.dcT = avw;
                                        bnVar.dcU = Math.round(d * 100.0d);
                                        statFs = new StatFs(com.tencent.mm.loader.j.b.eSj);
                                        j = VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
                                        if (VERSION.SDK_INT >= 18) {
                                            longValue = statFs.getAvailableBlocksLong();
                                        } else {
                                            longValue = (long) statFs.getAvailableBlocks();
                                        }
                                        bnVar.dcV = Math.round((((double) longValue) / ((double) j)) * 100.0d);
                                        if (r.avG()) {
                                            longValue = 1;
                                        } else {
                                            longValue = 0;
                                        }
                                        bnVar.dcW = longValue;
                                        bnVar.dcX = (long) e.avB();
                                        ab.i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", bnVar.Fk());
                                        bnVar.ajK();
                                    }
                                    com.tencent.mm.plugin.appbrand.appstorage.e.gXq.run();
                                    ((com.tencent.mm.plugin.appbrand.appcache.b.d.a) f.E(com.tencent.mm.plugin.appbrand.appcache.b.d.a.class)).aww();
                                }
                                voidR = zXH;
                                AppMethodBeat.o(128948);
                                return voidR;
                            }
                            voidR = zXH;
                            AppMethodBeat.o(128948);
                            return voidR;
                        } catch (com.tencent.mm.model.b | NullPointerException e) {
                            ab.printErrStackTrace("MicroMsg.AppBrandPruner", e, "caught exception while prune", new Object[0]);
                        }
                    }
                });
                AppMethodBeat.o(128951);
            } else {
                AppMethodBeat.o(128951);
            }
            return false;
        }
    };

    static {
        AppMethodBeat.i(128954);
        AppMethodBeat.o(128954);
    }

    public static void setup() {
        AppMethodBeat.i(128952);
        gNw.dnU();
        AppMethodBeat.o(128952);
    }

    public static void release() {
        AppMethodBeat.i(128953);
        gNw.dead();
        AppMethodBeat.o(128953);
    }
}
