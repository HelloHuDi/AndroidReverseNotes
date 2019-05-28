package com.tencent.p177mm.plugin.soter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C9562c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.p230g.p231a.C9412lm;
import com.tencent.p177mm.plugin.auth.p1239a.C19933a;
import com.tencent.p177mm.plugin.auth.p1239a.C19934b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.soter.p1301e.C22155b;
import com.tencent.p177mm.plugin.soter.p1503a.C35148a;
import com.tencent.p177mm.plugin.soter.p528d.C13721f;
import com.tencent.p177mm.plugin.soter.p528d.C13722g;
import com.tencent.p177mm.plugin.soter.p528d.C39854b;
import com.tencent.p177mm.plugin.soter.p528d.C4104m;
import com.tencent.p177mm.plugin.soter.p528d.C46262c;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.soter.p663a.C30954a;

/* renamed from: com.tencent.mm.plugin.soter.PluginSoter */
public class PluginSoter extends C7597f implements C9562c, C35148a {
    private static C46262c rNx = new C46262c();
    private static C39854b rNy = new C39854b();
    private C7358b gRC;
    private C13721f rNv = null;
    private boolean rNw = false;

    /* renamed from: com.tencent.mm.plugin.soter.PluginSoter$2 */
    class C137162 implements C19933a {

        /* renamed from: com.tencent.mm.plugin.soter.PluginSoter$2$1 */
        class C137171 implements Runnable {
            C137171() {
            }

            public final void run() {
                AppMethodBeat.m2504i(59288);
                long longValue = ((Long) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_SOTER_REPORT_TIMESTAMP_LONG_SYNC, Long.valueOf(0))).longValue();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - longValue > 86400000 && C30954a.dRc()) {
                    C7060h.pYm.mo15419k(1034, 1, 1);
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_SOTER_REPORT_TIMESTAMP_LONG_SYNC, Long.valueOf(currentTimeMillis));
                }
                AppMethodBeat.m2505o(59288);
            }
        }

        C137162() {
        }

        /* renamed from: a */
        public final void mo5415a(C4825f c4825f, C4826g c4826g, boolean z) {
            AppMethodBeat.m2504i(59289);
            C4990ab.m7417i("MicroMsg.PluginSoter", "autoAuth: %s", Boolean.valueOf(z));
            C7305d.xDG.execute(new C137171());
            AppMethodBeat.m2505o(59289);
        }

        /* renamed from: a */
        public final void mo5416a(C4844b c4844b, String str, int i, String str2, String str3, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.soter.PluginSoter$1 */
    class C221511 implements Runnable {

        /* renamed from: com.tencent.mm.plugin.soter.PluginSoter$1$1 */
        class C221521 implements C13722g {
            C221521() {
            }

            /* renamed from: aC */
            public final void mo25925aC(int i, String str) {
                AppMethodBeat.m2504i(59286);
                C4990ab.m7417i("MicroMsg.PluginSoter", "init finish: %s, %s", Integer.valueOf(i), str);
                C9412lm c9412lm = new C9412lm();
                c9412lm.cHn.errCode = i;
                c9412lm.cHn.aIm = str;
                C4879a.xxA.mo10055m(c9412lm);
                AppMethodBeat.m2505o(59286);
            }
        }

        C221511() {
        }

        public final void run() {
            AppMethodBeat.m2504i(59287);
            C22155b.m33780a(true, true, new C221521());
            AppMethodBeat.m2505o(59287);
        }
    }

    static {
        AppMethodBeat.m2504i(59296);
        AppMethodBeat.m2505o(59296);
    }

    public String name() {
        return "plugin-soter";
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(59290);
        if (c1681g.mo5181SG()) {
            C4990ab.m7417i("MicroMsg.PluginSoter", "alvinluo PluginSoter in process: %s execute and run pipeline", c1681g.eHT);
            this.rNw = true;
            C4990ab.m7418v("MicroMsg.PluginSoter", "alvinluo PluginSoter add SoterDynamicConfigUpdatedEventListener");
            this.rNv = new C13721f();
            safeAddListener(this.rNv);
        }
        AppMethodBeat.m2505o(59290);
    }

    public void uninstalled() {
        AppMethodBeat.m2504i(59291);
        super.uninstalled();
        safeRemoveListener(this.rNv);
        AppMethodBeat.m2505o(59291);
    }

    private void safeAddListener(C4884c c4884c) {
        AppMethodBeat.m2504i(59292);
        if (c4884c == null) {
            C4990ab.m7420w("MicroMsg.PluginSoter", "hy: listener is null or id is invalid");
            AppMethodBeat.m2505o(59292);
        } else if (C4879a.xxA.mo10054e(c4884c)) {
            C4990ab.m7420w("MicroMsg.PluginSoter", "hy: already has listener");
            AppMethodBeat.m2505o(59292);
        } else {
            C4879a.xxA.mo10052c(c4884c);
            AppMethodBeat.m2505o(59292);
        }
    }

    private void safeRemoveListener(C4884c c4884c) {
        AppMethodBeat.m2504i(59293);
        if (c4884c == null) {
            C4990ab.m7420w("MicroMsg.PluginSoter", "alvinluo listener is null");
            AppMethodBeat.m2505o(59293);
            return;
        }
        C4879a.xxA.mo10053d(c4884c);
        AppMethodBeat.m2505o(59293);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(59294);
        C4990ab.m7419v("MicroMsg.PluginSoter", "alvinluo onAccountInitialized, isMainProcess: %b", Boolean.valueOf(this.rNw));
        if (this.rNw) {
            C4104m.cvR();
            C7305d.xDG.mo10159p(new C221511(), 1500);
            this.gRC = ((C19934b) C1720g.m3530M(C19934b.class)).addHandleAuthResponse(new C137162());
        }
        if (!C4879a.xxA.mo10054e(rNx)) {
            C4879a.xxA.mo10052c(rNx);
        }
        if (!C4879a.xxA.mo10054e(rNy)) {
            C4879a.xxA.mo10052c(rNy);
        }
        AppMethodBeat.m2505o(59294);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(59295);
        C4990ab.m7418v("MicroMsg.PluginSoter", "alvinluo onAccountRelease");
        if (this.rNw) {
            this.gRC.dead();
        }
        AppMethodBeat.m2505o(59295);
    }
}
