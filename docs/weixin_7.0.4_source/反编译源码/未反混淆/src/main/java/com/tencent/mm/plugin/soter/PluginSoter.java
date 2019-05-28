package com.tencent.mm.plugin.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lm;
import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.soter.a.a;
import com.tencent.mm.plugin.soter.d.b;
import com.tencent.mm.plugin.soter.d.m;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ac;

public class PluginSoter extends f implements c, a {
    private static com.tencent.mm.plugin.soter.d.c rNx = new com.tencent.mm.plugin.soter.d.c();
    private static b rNy = new b();
    private com.tencent.mm.vending.b.b gRC;
    private com.tencent.mm.plugin.soter.d.f rNv = null;
    private boolean rNw = false;

    static {
        AppMethodBeat.i(59296);
        AppMethodBeat.o(59296);
    }

    public String name() {
        return "plugin-soter";
    }

    public void execute(g gVar) {
        AppMethodBeat.i(59290);
        if (gVar.SG()) {
            ab.i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", gVar.eHT);
            this.rNw = true;
            ab.v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
            this.rNv = new com.tencent.mm.plugin.soter.d.f();
            safeAddListener(this.rNv);
        }
        AppMethodBeat.o(59290);
    }

    public void uninstalled() {
        AppMethodBeat.i(59291);
        super.uninstalled();
        safeRemoveListener(this.rNv);
        AppMethodBeat.o(59291);
    }

    private void safeAddListener(com.tencent.mm.sdk.b.c cVar) {
        AppMethodBeat.i(59292);
        if (cVar == null) {
            ab.w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
            AppMethodBeat.o(59292);
        } else if (com.tencent.mm.sdk.b.a.xxA.e(cVar)) {
            ab.w("MicroMsg.PluginSoter", "hy: already has listener");
            AppMethodBeat.o(59292);
        } else {
            com.tencent.mm.sdk.b.a.xxA.c(cVar);
            AppMethodBeat.o(59292);
        }
    }

    private void safeRemoveListener(com.tencent.mm.sdk.b.c cVar) {
        AppMethodBeat.i(59293);
        if (cVar == null) {
            ab.w("MicroMsg.PluginSoter", "alvinluo listener is null");
            AppMethodBeat.o(59293);
            return;
        }
        com.tencent.mm.sdk.b.a.xxA.d(cVar);
        AppMethodBeat.o(59293);
    }

    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(59294);
        ab.v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", Boolean.valueOf(this.rNw));
        if (this.rNw) {
            m.cvR();
            d.xDG.p(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(59287);
                    com.tencent.mm.plugin.soter.e.b.a(true, true, new com.tencent.mm.plugin.soter.d.g() {
                        public final void aC(int i, String str) {
                            AppMethodBeat.i(59286);
                            ab.i("MicroMsg.PluginSoter", "init finish: %s, %s", Integer.valueOf(i), str);
                            lm lmVar = new lm();
                            lmVar.cHn.errCode = i;
                            lmVar.cHn.aIm = str;
                            com.tencent.mm.sdk.b.a.xxA.m(lmVar);
                            AppMethodBeat.o(59286);
                        }
                    });
                    AppMethodBeat.o(59287);
                }
            }, 1500);
            this.gRC = ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a() {
                public final void a(j.f fVar, j.g gVar, boolean z) {
                    AppMethodBeat.i(59289);
                    ab.i("MicroMsg.PluginSoter", "autoAuth: %s", Boolean.valueOf(z));
                    d.xDG.execute(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(59288);
                            long longValue = ((Long) com.tencent.mm.kernel.g.RP().Ry().get(ac.a.USERINFO_SOTER_REPORT_TIMESTAMP_LONG_SYNC, Long.valueOf(0))).longValue();
                            long currentTimeMillis = System.currentTimeMillis();
                            if (currentTimeMillis - longValue > 86400000 && com.tencent.soter.a.a.dRc()) {
                                h.pYm.k(1034, 1, 1);
                                com.tencent.mm.kernel.g.RP().Ry().set(ac.a.USERINFO_SOTER_REPORT_TIMESTAMP_LONG_SYNC, Long.valueOf(currentTimeMillis));
                            }
                            AppMethodBeat.o(59288);
                        }
                    });
                    AppMethodBeat.o(59289);
                }

                public final void a(v.b bVar, String str, int i, String str2, String str3, int i2) {
                }
            });
        }
        if (!com.tencent.mm.sdk.b.a.xxA.e(rNx)) {
            com.tencent.mm.sdk.b.a.xxA.c(rNx);
        }
        if (!com.tencent.mm.sdk.b.a.xxA.e(rNy)) {
            com.tencent.mm.sdk.b.a.xxA.c(rNy);
        }
        AppMethodBeat.o(59294);
    }

    public void onAccountRelease() {
        AppMethodBeat.i(59295);
        ab.v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
        if (this.rNw) {
            this.gRC.dead();
        }
        AppMethodBeat.o(59295);
    }
}
