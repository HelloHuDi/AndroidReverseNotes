package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35957tx;
import com.tencent.p177mm.protocal.protobuf.C40576ty;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.b */
public final class C21199b extends C37440a<C40576ty> {
    public C21199b(String str) {
        AppMethodBeat.m2504i(42271);
        C35957tx c35957tx = new C35957tx();
        c35957tx.materialId = str;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c35957tx;
        c1196a.fsK = new C40576ty();
        c1196a.uri = "/cgi-bin/mmpay-bin/ftfhb/deleteshowsource";
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(42271);
    }
}
