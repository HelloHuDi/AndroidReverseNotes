package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35957tx;
import com.tencent.p177mm.protocal.protobuf.C40576ty;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.a */
public final class C28423a extends C37440a<C40576ty> {
    public C28423a(String str) {
        AppMethodBeat.m2504i(42270);
        C35957tx c35957tx = new C35957tx();
        c35957tx.materialId = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c35957tx;
        c1196a.fsK = new C40576ty();
        c1196a.uri = "/cgi-bin/mmpay-bin/ftfhb/confirmshowsource";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(42270);
    }
}
