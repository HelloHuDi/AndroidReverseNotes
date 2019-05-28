package com.tencent.p177mm.plugin.wear.model;

import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1200d;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.wear.model.p1322g.C22744b;
import com.tencent.p177mm.plugin.wear.model.p1322g.C35562a;
import com.tencent.p177mm.plugin.wear.model.p575e.C14409d;
import com.tencent.p177mm.plugin.wear.model.p575e.C14410e;
import com.tencent.p177mm.plugin.wear.model.p575e.C14411l;
import com.tencent.p177mm.plugin.wear.model.p575e.C14412n;
import com.tencent.p177mm.plugin.wear.model.p575e.C35557f;
import com.tencent.p177mm.plugin.wear.model.p575e.C35558g;
import com.tencent.p177mm.plugin.wear.model.p575e.C35559h;
import com.tencent.p177mm.plugin.wear.model.p575e.C40185r;
import com.tencent.p177mm.plugin.wear.model.p575e.C4503c;
import com.tencent.p177mm.plugin.wear.model.p575e.C4504k;
import com.tencent.p177mm.plugin.wear.model.p575e.C4505m;
import com.tencent.p177mm.plugin.wear.model.p575e.C46395q;
import com.tencent.p177mm.plugin.wear.model.p575e.C46930o;
import com.tencent.p177mm.plugin.wear.model.p576f.C29724c;
import com.tencent.p177mm.pluginsdk.C44068p.C30089e;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wear.model.a */
public final class C43841a implements C1816at {
    public C35562a tXA;
    private C1201e tXB;
    C46395q tXr;
    public C40185r tXs;
    public C35556d tXt;
    private C22732e tXu;
    public C22745g tXv;
    public C43842b tXw;
    private WearMessageLogic tXx;
    private C43847i tXy;
    public C43850j tXz;

    /* renamed from: com.tencent.mm.plugin.wear.model.a$1 */
    class C144051 extends C29724c {
        C144051() {
        }

        public final String getName() {
            return "PhoneStartTask";
        }

        public final void send() {
            AppMethodBeat.m2504i(26265);
            C40185r.m68920b(CdnLogic.kMediaTypeBackupFile, null, false);
            C40185r.m68920b(20008, null, false);
            AppMethodBeat.m2505o(26265);
        }
    }

    /* renamed from: com.tencent.mm.plugin.wear.model.a$2 */
    class C314692 extends C29724c {
        C314692() {
        }

        public final void send() {
            AppMethodBeat.m2504i(26266);
            if (C43841a.this.tXt.cUt() != null) {
                C43841a.this.tXt.cUt().cUz();
            }
            C40185r.m68920b(20009, null, false);
            C40185r.m68920b(20017, null, false);
            AppMethodBeat.m2505o(26266);
        }

        public final String getName() {
            return "SyncFileTask";
        }
    }

    public C43841a() {
        AppMethodBeat.m2504i(26267);
        C4990ab.m7417i("MicroMsg.Wear.SubCoreWear", "Create SubCore, classLoader=%s", getClass().getClassLoader());
        AppMethodBeat.m2505o(26267);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    public static C43841a cUn() {
        AppMethodBeat.m2504i(26268);
        C9638aw.m17184ZE();
        C43841a c43841a = (C43841a) C45439bw.m83697oJ("plugin.wear");
        if (c43841a == null) {
            c43841a = new C43841a();
            C9638aw.m17184ZE().mo73244a("plugin.wear", c43841a);
        }
        AppMethodBeat.m2505o(26268);
        return c43841a;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
        AppMethodBeat.m2504i(26269);
        C4990ab.m7417i("MicroMsg.Wear.SubCoreWear", "clearPluginData, pluginFlag=%d", Integer.valueOf(i));
        AppMethodBeat.m2505o(26269);
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(26270);
        C30089e.vaw = new C40182c();
        C4990ab.m7417i("MicroMsg.Wear.SubCoreWear", "onAccountPostReset, updated=%b", Boolean.valueOf(z));
        this.tXr = new C46395q();
        this.tXs = new C40185r();
        this.tXz = new C43850j();
        this.tXu = new C22732e();
        this.tXv = new C22745g();
        this.tXw = new C43842b();
        this.tXt = new C35556d();
        this.tXx = new WearMessageLogic();
        this.tXy = new C43847i();
        this.tXA = new C35562a();
        this.tXB = new C22744b();
        C1200d.m2636a(Integer.valueOf(63), this.tXB);
        this.tXr.mo74594a(this.tXt.tXJ);
        this.tXr.mo74594a(this.tXt.tXK);
        this.tXr.mo74594a(this.tXt.tXL);
        this.tXr.mo74594a(new C35559h());
        this.tXr.mo74594a(new C35558g());
        this.tXr.mo74594a(new C14409d());
        this.tXr.mo74594a(new C4503c());
        this.tXr.mo74594a(new C14410e());
        this.tXr.mo74594a(new C35557f());
        this.tXr.mo74594a(new C4504k());
        this.tXr.mo74594a(new C4505m());
        this.tXr.mo74594a(new C46930o());
        this.tXr.mo74594a(new C14412n());
        this.tXr.mo74594a(new C14411l());
        this.tXz.mo69532a(new C144051());
        C43850j c43850j = this.tXz;
        C314692 c314692 = new C314692();
        if (c43850j.ilv != null) {
            c43850j.ilv.sendMessageDelayed(c43850j.ilv.obtainMessage(0, c314692), 5000);
        }
        AppMethodBeat.m2505o(26270);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
        AppMethodBeat.m2504i(26271);
        C4990ab.m7417i("MicroMsg.Wear.SubCoreWear", "onSdcardMount, mounted=%b", Boolean.valueOf(z));
        AppMethodBeat.m2505o(26271);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(26272);
        C1200d.m2637b(Integer.valueOf(63), this.tXB);
        this.tXB = null;
        C4990ab.m7416i("MicroMsg.Wear.SubCoreWear", "onAccountRelease");
        this.tXr.tYL.clear();
        this.tXr = null;
        this.tXs = null;
        C22732e c22732e = this.tXu;
        c22732e.gyS.stopTimer();
        c22732e.ryO.dead();
        c22732e.tXP.dead();
        c22732e.tXQ.dead();
        c22732e.ilT.dead();
        c22732e.tXR.dead();
        c22732e.tXS.dead();
        c22732e.tXT.dead();
        c22732e.edy.dead();
        c22732e.nZv.dead();
        C9638aw.m17190ZK();
        C18628c.m29080XO().mo15286a(c22732e.lPn);
        this.tXu = null;
        this.tXv = null;
        C43842b c43842b = this.tXw;
        C4879a.xxA.mo10053d(c43842b.tXE);
        C9638aw.m17190ZK();
        C18628c.m29078XM().mo10121b(c43842b.mFC);
        c43842b.tXF.stopTimer();
        this.tXw = null;
        C35556d c35556d = this.tXt;
        c35556d.tXI.finish();
        c35556d.tXM.reset();
        this.tXt = null;
        C4996ah.getContext().unregisterReceiver(this.tXx);
        this.tXx = null;
        C43850j c43850j = this.tXz;
        if (c43850j.handlerThread != null) {
            c43850j.handlerThread.quit();
        }
        this.tXz = null;
        C43847i c43847i = this.tXy;
        c43847i.eoY = null;
        c43847i.cUu();
        C4996ah.getContext().unregisterReceiver(c43847i.tYm);
        this.tXy = null;
        AppMethodBeat.m2505o(26272);
    }
}
