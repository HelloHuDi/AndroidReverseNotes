package com.tencent.p177mm.plugin.address.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p230g.p231a.C9420nc;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.address.model.j */
public final class C26687j extends C4884c<C9420nc> {
    public C26687j() {
        AppMethodBeat.m2504i(16749);
        this.xxI = C9420nc.class.getName().hashCode();
        AppMethodBeat.m2505o(16749);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(16750);
        C9420nc c9420nc = (C9420nc) c4883b;
        C4990ab.m7416i("MicroMsg.RcptAddressEventListener", "revent " + c9420nc.cJi.cJk);
        C9638aw.m17190ZK();
        C5730e.m8644y(c9420nc.cJi.cJk, C18628c.getAccPath() + "address");
        AppMethodBeat.m2505o(16750);
        return false;
    }
}
