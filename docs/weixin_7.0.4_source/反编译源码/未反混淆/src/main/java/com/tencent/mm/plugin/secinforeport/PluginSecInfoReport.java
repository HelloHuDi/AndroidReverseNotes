package com.tencent.mm.plugin.secinforeport;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.normsg.a;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;

public class PluginSecInfoReport extends f implements b {
    private static HandlerThread qjd = null;
    private static ak qje = null;

    static /* synthetic */ void access$000(PluginSecInfoReport pluginSecInfoReport, int i) {
        AppMethodBeat.i(57488);
        pluginSecInfoReport.reportSecurityInfoAsync(i);
        AppMethodBeat.o(57488);
    }

    public void installed() {
        AppMethodBeat.i(57483);
        alias(b.class);
        AppMethodBeat.o(57483);
    }

    public void dependency() {
        AppMethodBeat.i(57484);
        dependsOn(d.class);
        dependsOn(c.class);
        dependsOn(a.class);
        AppMethodBeat.o(57484);
    }

    public void configure(g gVar) {
        AppMethodBeat.i(57485);
        com.tencent.mm.plugin.secinforeport.a.d.a(c.qjh);
        com.tencent.mm.plugin.secinforeport.a.a.a(a.qjb);
        AppMethodBeat.o(57485);
    }

    public void execute(g gVar) {
        AppMethodBeat.i(57486);
        if (qjd == null) {
            try {
                HandlerThread anM = com.tencent.mm.sdk.g.d.anM("SIRWorker");
                qjd = anM;
                anM.start();
                qje = new ak(qjd.getLooper());
            } catch (Throwable th) {
                ab.printErrStackTrace("MicroMsg.PSIR", th, "[tomys] unexpected exception.", new Object[0]);
            }
        }
        com.tencent.mm.sdk.b.a.xxA.b(new com.tencent.mm.sdk.b.c<mp>() {
            {
                AppMethodBeat.i(57475);
                this.xxI = mp.class.getName().hashCode();
                AppMethodBeat.o(57475);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(57476);
                PluginSecInfoReport.access$000(PluginSecInfoReport.this, 0);
                AppMethodBeat.o(57476);
                return false;
            }
        });
        com.tencent.mm.sdk.b.a.xxA.b(new com.tencent.mm.sdk.b.c<com.tencent.mm.g.a.d>() {
            {
                AppMethodBeat.i(57477);
                this.xxI = com.tencent.mm.g.a.d.class.getName().hashCode();
                AppMethodBeat.o(57477);
            }

            public final /* synthetic */ boolean a(b bVar) {
                AppMethodBeat.i(57478);
                if (!((com.tencent.mm.g.a.d) bVar).crQ.crR) {
                    PluginSecInfoReport.access$000(PluginSecInfoReport.this, 0);
                }
                AppMethodBeat.o(57478);
                return false;
            }
        });
        ((com.tencent.mm.plugin.auth.a.b) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a() {
            public final void a(j.f fVar, j.g gVar, boolean z) {
                AppMethodBeat.i(57479);
                PluginSecInfoReport.access$000(PluginSecInfoReport.this, z ? 0 : 540999680);
                AppMethodBeat.o(57479);
            }

            public final void a(v.b bVar, String str, int i, String str2, String str3, int i2) {
                AppMethodBeat.i(57480);
                PluginSecInfoReport.access$000(PluginSecInfoReport.this, 540999681);
                AppMethodBeat.o(57480);
            }
        });
        AppMethodBeat.o(57486);
    }

    private void reportSecurityInfoAsync(final int i) {
        AppMethodBeat.i(57487);
        if (qje == null) {
            ab.e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
            AppMethodBeat.o(57487);
            return;
        }
        if (com.tencent.mm.plugin.secinforeport.a.d.qjp.Y(1, 86400000)) {
            qje.post(new Runnable() {
                public final void run() {
                    int i;
                    int i2;
                    AppMethodBeat.i(57481);
                    try {
                        i = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("DisableRiskScanSdkProb", 0);
                        i2 = ((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getInt("DisableInstalledPkgInfoReportProb", 0);
                        com.tencent.mm.kernel.g.RN();
                        int bL = i.bL(com.tencent.mm.kernel.a.QF(), 101);
                        int i3 = (i <= 0 || bL < 0 || bL > i) ? 0 : 1;
                        if (i2 <= 0 || bL < 0 || bL > i2) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                        i = 12;
                        if (i3 == 0) {
                            i = 13;
                        }
                        if (i2 != 0) {
                            i2 = 0;
                        } else if (com.tencent.mm.au.b.sO((String) com.tencent.mm.kernel.g.RP().Ry().get(274436, null))) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                    } catch (Throwable th) {
                        ab.printErrStackTrace("MicroMsg.PSIR", th, "unexpected exception was thrown.", new Object[0]);
                        AppMethodBeat.o(57481);
                        return;
                    }
                    if (i2 != 0) {
                        i2 = i | 2;
                    } else {
                        i2 = i;
                    }
                    com.tencent.mm.plugin.secinforeport.a.d.qjp.ff(i, i2);
                    AppMethodBeat.o(57481);
                }
            });
        }
        if (com.tencent.mm.plugin.secinforeport.a.d.qjp.Y(2, 86400000)) {
            qje.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(57482);
                    com.tencent.mm.plugin.secinforeport.a.d.qjp.Ch(-2147483646);
                    AppMethodBeat.o(57482);
                }
            });
        }
        AppMethodBeat.o(57487);
    }
}
