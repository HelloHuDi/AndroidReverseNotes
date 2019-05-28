package com.tencent.p177mm.plugin.secinforeport;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p1179au.C17950b;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.plugin.auth.p1239a.C19933a;
import com.tencent.p177mm.plugin.auth.p1239a.C19934b;
import com.tencent.p177mm.plugin.normsg.C21383a;
import com.tencent.p177mm.plugin.report.C7051c;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C21734a;
import com.tencent.p177mm.plugin.secinforeport.p1293a.C44761d;
import com.tencent.p177mm.plugin.zero.p591a.C44035d;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.plugin.secinforeport.PluginSecInfoReport */
public class PluginSecInfoReport extends C7597f implements C7609b {
    private static HandlerThread qjd = null;
    private static C7306ak qje = null;

    /* renamed from: com.tencent.mm.plugin.secinforeport.PluginSecInfoReport$1 */
    class C217331 extends C4884c<C6523mp> {
        C217331() {
            AppMethodBeat.m2504i(57475);
            this.xxI = C6523mp.class.getName().hashCode();
            AppMethodBeat.m2505o(57475);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(57476);
            PluginSecInfoReport.access$000(PluginSecInfoReport.this, 0);
            AppMethodBeat.m2505o(57476);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.secinforeport.PluginSecInfoReport$2 */
    class C289272 extends C4884c<C26111d> {
        C289272() {
            AppMethodBeat.m2504i(57477);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(57477);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(57478);
            if (!((C26111d) c4883b).crQ.crR) {
                PluginSecInfoReport.access$000(PluginSecInfoReport.this, 0);
            }
            AppMethodBeat.m2505o(57478);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.secinforeport.PluginSecInfoReport$5 */
    class C348465 implements Runnable {
        C348465() {
        }

        public final void run() {
            AppMethodBeat.m2504i(57482);
            C44761d.qjp.mo8446Ch(-2147483646);
            AppMethodBeat.m2505o(57482);
        }
    }

    /* renamed from: com.tencent.mm.plugin.secinforeport.PluginSecInfoReport$3 */
    class C396433 implements C19933a {
        C396433() {
        }

        /* renamed from: a */
        public final void mo5415a(C4825f c4825f, C4826g c4826g, boolean z) {
            AppMethodBeat.m2504i(57479);
            PluginSecInfoReport.access$000(PluginSecInfoReport.this, z ? 0 : 540999680);
            AppMethodBeat.m2505o(57479);
        }

        /* renamed from: a */
        public final void mo5416a(C4844b c4844b, String str, int i, String str2, String str3, int i2) {
            AppMethodBeat.m2504i(57480);
            PluginSecInfoReport.access$000(PluginSecInfoReport.this, 540999681);
            AppMethodBeat.m2505o(57480);
        }
    }

    static /* synthetic */ void access$000(PluginSecInfoReport pluginSecInfoReport, int i) {
        AppMethodBeat.m2504i(57488);
        pluginSecInfoReport.reportSecurityInfoAsync(i);
        AppMethodBeat.m2505o(57488);
    }

    public void installed() {
        AppMethodBeat.m2504i(57483);
        alias(C7609b.class);
        AppMethodBeat.m2505o(57483);
    }

    public void dependency() {
        AppMethodBeat.m2504i(57484);
        dependsOn(C44035d.class);
        dependsOn(C7051c.class);
        dependsOn(C21383a.class);
        AppMethodBeat.m2505o(57484);
    }

    public void configure(C1681g c1681g) {
        AppMethodBeat.m2504i(57485);
        C44761d.m81619a(C3775c.qjh);
        C21734a.m33274a(C3774a.qjb);
        AppMethodBeat.m2505o(57485);
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(57486);
        if (qjd == null) {
            try {
                HandlerThread anM = C7305d.anM("SIRWorker");
                qjd = anM;
                anM.start();
                qje = new C7306ak(qjd.getLooper());
            } catch (Throwable th) {
                C4990ab.printErrStackTrace("MicroMsg.PSIR", th, "[tomys] unexpected exception.", new Object[0]);
            }
        }
        C4879a.xxA.mo10051b(new C217331());
        C4879a.xxA.mo10051b(new C289272());
        ((C19934b) C1720g.m3530M(C19934b.class)).addHandleAuthResponse(new C396433());
        AppMethodBeat.m2505o(57486);
    }

    private void reportSecurityInfoAsync(final int i) {
        AppMethodBeat.m2504i(57487);
        if (qje == null) {
            C4990ab.m7412e("MicroMsg.PSIR", "[tomys] workerposter is null, give up doing rest ops.");
            AppMethodBeat.m2505o(57487);
            return;
        }
        if (C44761d.qjp.mo8447Y(1, 86400000)) {
            qje.post(new Runnable() {
                public final void run() {
                    int i;
                    int i2;
                    AppMethodBeat.m2504i(57481);
                    try {
                        i = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("DisableRiskScanSdkProb", 0);
                        i2 = ((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getInt("DisableInstalledPkgInfoReportProb", 0);
                        C1720g.m3534RN();
                        int bL = C1179i.m2593bL(C1668a.m3383QF(), 101);
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
                        } else if (C17950b.m28216sO((String) C1720g.m3536RP().mo5239Ry().get(274436, null))) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                        }
                    } catch (Throwable th) {
                        C4990ab.printErrStackTrace("MicroMsg.PSIR", th, "unexpected exception was thrown.", new Object[0]);
                        AppMethodBeat.m2505o(57481);
                        return;
                    }
                    if (i2 != 0) {
                        i2 = i | 2;
                    } else {
                        i2 = i;
                    }
                    C44761d.qjp.mo8448ff(i, i2);
                    AppMethodBeat.m2505o(57481);
                }
            });
        }
        if (C44761d.qjp.mo8447Y(2, 86400000)) {
            qje.post(new C348465());
        }
        AppMethodBeat.m2505o(57487);
    }
}
