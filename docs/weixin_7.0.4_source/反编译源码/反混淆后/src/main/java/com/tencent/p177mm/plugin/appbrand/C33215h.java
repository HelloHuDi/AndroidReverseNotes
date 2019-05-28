package com.tencent.p177mm.plugin.appbrand;

import android.os.Build.VERSION;
import android.os.StatFs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.p217ci.C41930g;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.p230g.p232b.p233a.C32665bn;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C10072ap;
import com.tencent.p177mm.plugin.appbrand.appcache.C19054n.C19055c;
import com.tencent.p177mm.plugin.appbrand.appcache.C19054n.C19060b;
import com.tencent.p177mm.plugin.appbrand.appcache.C19054n.C19061e;
import com.tencent.p177mm.plugin.appbrand.appcache.C19071r;
import com.tencent.p177mm.plugin.appbrand.appcache.p277b.p278d.C2058a;
import com.tencent.p177mm.plugin.appbrand.appstorage.C19082e;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.smtt.sdk.TbsDownloadConfig;

/* renamed from: com.tencent.mm.plugin.appbrand.h */
public final class C33215h {
    private static final C4884c<C26111d> gNw = new C102551();

    /* renamed from: com.tencent.mm.plugin.appbrand.h$1 */
    static class C102551 extends C4884c<C26111d> {

        /* renamed from: com.tencent.mm.plugin.appbrand.h$1$1 */
        class C102541 implements C5681a<Void, Void> {
            C102541() {
            }

            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.m2504i(128949);
                Void asR = C102541.asR();
                AppMethodBeat.m2505o(128949);
                return asR;
            }

            private static Void asR() {
                AppMethodBeat.m2504i(128948);
                try {
                    Void voidR;
                    if (C1720g.m3534RN().eJb) {
                        long j = C19071r.avG() ? AppBrandGlobalSystemConfig.ayC().hgf.hgu : TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
                        long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_PRUNE_PKG_NEXT_TIME_SEC_LONG, Long.valueOf(0))).longValue();
                        long anT = C5046bo.anT();
                        if (anT >= longValue) {
                            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_APP_BRAND_PRUNE_PKG_NEXT_TIME_SEC_LONG, Long.valueOf(j + anT));
                            C19055c.avx().run();
                            if (C42340f.auK() == null) {
                                C4990ab.m7412e("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage, db not ready");
                            } else {
                                C32665bn c32665bn = new C32665bn();
                                StatFs statFs = new StatFs(C10072ap.avY());
                                j = VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
                                long avw = C19060b.avw();
                                if (VERSION.SDK_INT >= 18) {
                                    longValue = statFs.getBlockSizeLong();
                                } else {
                                    longValue = (long) statFs.getBlockSize();
                                }
                                double d = ((double) (avw / longValue)) / ((double) j);
                                c32665bn.dcT = avw;
                                c32665bn.dcU = Math.round(d * 100.0d);
                                statFs = new StatFs(C1761b.eSj);
                                j = VERSION.SDK_INT >= 18 ? statFs.getBlockCountLong() : (long) statFs.getBlockCount();
                                if (VERSION.SDK_INT >= 18) {
                                    longValue = statFs.getAvailableBlocksLong();
                                } else {
                                    longValue = (long) statFs.getAvailableBlocks();
                                }
                                c32665bn.dcV = Math.round((((double) longValue) / ((double) j)) * 100.0d);
                                if (C19071r.avG()) {
                                    longValue = 1;
                                } else {
                                    longValue = 0;
                                }
                                c32665bn.dcW = longValue;
                                c32665bn.dcX = (long) C19061e.avB();
                                C4990ab.m7417i("MicroMsg.AppBrand.IPkgCleanupLogic.Report", "reportStorageUsage %s", c32665bn.mo4983Fk());
                                c32665bn.ajK();
                            }
                            C19082e.gXq.run();
                            ((C2058a) C42340f.m74878E(C2058a.class)).aww();
                        }
                        voidR = zXH;
                        AppMethodBeat.m2505o(128948);
                        return voidR;
                    }
                    voidR = zXH;
                    AppMethodBeat.m2505o(128948);
                    return voidR;
                } catch (C1819b | NullPointerException e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppBrandPruner", e, "caught exception while prune", new Object[0]);
                }
            }
        }

        C102551() {
            AppMethodBeat.m2504i(128950);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(128950);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(128951);
            if (((C26111d) c4883b).crQ.crR) {
                C19055c.interrupt();
                AppMethodBeat.m2505o(128951);
            } else if (C1720g.m3531RK()) {
                C41930g.dOW().mo60493i(new C102541());
                AppMethodBeat.m2505o(128951);
            } else {
                AppMethodBeat.m2505o(128951);
            }
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(128954);
        AppMethodBeat.m2505o(128954);
    }

    public static void setup() {
        AppMethodBeat.m2504i(128952);
        gNw.dnU();
        AppMethodBeat.m2505o(128952);
    }

    public static void release() {
        AppMethodBeat.m2504i(128953);
        gNw.dead();
        AppMethodBeat.m2505o(128953);
    }
}
