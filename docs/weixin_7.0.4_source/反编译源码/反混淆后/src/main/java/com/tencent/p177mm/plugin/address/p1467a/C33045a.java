package com.tencent.p177mm.plugin.address.p1467a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C45439bw;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.address.model.C26687j;
import com.tencent.p177mm.plugin.address.model.C38091k;
import com.tencent.p177mm.plugin.address.model.C42322l;
import com.tencent.p177mm.plugin.address.p718b.p1387a.C26684a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.address.a.a */
public final class C33045a implements C1816at {
    private C42322l gIB = null;
    private C26684a gIC = null;
    private C26687j gID = new C26687j();
    private C38091k gIE = new C38091k();

    public C33045a() {
        AppMethodBeat.m2504i(16713);
        AppMethodBeat.m2505o(16713);
    }

    public static C33045a arQ() {
        AppMethodBeat.m2504i(16714);
        C9638aw.m17184ZE();
        C33045a c33045a = (C33045a) C45439bw.m83697oJ("plugin.address");
        if (c33045a == null) {
            C4990ab.m7420w("MicroMsg.SubCoreAddress", "not found in MMCore, new one");
            c33045a = new C33045a();
            C9638aw.m17184ZE().mo73244a("plugin.address", c33045a);
        }
        AppMethodBeat.m2505o(16714);
        return c33045a;
    }

    public static C26684a arR() {
        AppMethodBeat.m2504i(16715);
        C1720g.m3534RN().mo5159QU();
        if (C33045a.arQ().gIC == null) {
            C33045a.arQ().gIC = new C26684a();
        }
        C26684a c26684a = C33045a.arQ().gIC;
        AppMethodBeat.m2505o(16715);
        return c26684a;
    }

    public static C42322l arS() {
        AppMethodBeat.m2504i(16716);
        C1720g.m3534RN().mo5159QU();
        if (C33045a.arQ().gIB == null) {
            C33045a.arQ().gIB = new C42322l();
        }
        C42322l c42322l = C33045a.arQ().gIB;
        AppMethodBeat.m2505o(16716);
        return c42322l;
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(16717);
        C4879a.xxA.mo10052c(this.gID);
        C4879a.xxA.mo10052c(this.gIE);
        C42322l arS = C33045a.arS();
        C9638aw.m17190ZK();
        arS.path = C18628c.getAccPath() + "addrmgr";
        AppMethodBeat.m2505o(16717);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(16718);
        C4879a.xxA.mo10053d(this.gID);
        C4879a.xxA.mo10053d(this.gIE);
        AppMethodBeat.m2505o(16718);
    }
}
