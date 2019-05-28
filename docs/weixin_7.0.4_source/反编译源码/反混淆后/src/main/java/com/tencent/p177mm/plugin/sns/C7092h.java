package com.tencent.p177mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C26197mo;
import com.tencent.p177mm.plugin.sns.model.C7109w;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.h */
public final class C7092h extends C4884c<C26197mo> {
    public C7092h() {
        AppMethodBeat.m2504i(35622);
        this.xxI = C26197mo.class.getName().hashCode();
        AppMethodBeat.m2505o(35622);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(35623);
        C26197mo c26197mo = (C26197mo) c4883b;
        if (!(c26197mo instanceof C26197mo)) {
            C4990ab.m7414f("MicroMsg.PostSnsTagMemberOptionListener", "mismatched event");
            AppMethodBeat.m2505o(35623);
            return false;
        } else if (c26197mo.cIr.list == null) {
            C4990ab.m7412e("MicroMsg.PostSnsTagMemberOptionListener", "event.data.list is null!");
            AppMethodBeat.m2505o(35623);
            return false;
        } else {
            C1207m c7109w = new C7109w(c26197mo.cIr.czE, c26197mo.cIr.cIs, "", c26197mo.cIr.list.size(), c26197mo.cIr.list, c26197mo.cIr.scene);
            C4990ab.m7416i("MicroMsg.PostSnsTagMemberOptionListener", "opCode " + c26197mo.cIr.czE + " memberList " + c26197mo.cIr.list.size() + " scene " + c26197mo.cIr.scene);
            C1720g.m3535RO().eJo.mo14541a(c7109w, 0);
            AppMethodBeat.m2505o(35623);
            return true;
        }
    }
}
