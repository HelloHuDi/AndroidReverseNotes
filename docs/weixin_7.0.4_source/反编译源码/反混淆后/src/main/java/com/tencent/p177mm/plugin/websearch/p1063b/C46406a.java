package com.tencent.p177mm.plugin.websearch.p1063b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.protocal.protobuf.bvi;
import com.tencent.p177mm.protocal.protobuf.bvj;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.websearch.b.a */
public final class C46406a extends C37440a<bvj> {
    C7472b ehh;

    public C46406a(String str) {
        AppMethodBeat.m2504i(91363);
        C1196a c1196a = new C1196a();
        c1196a.uri = "/cgi-bin/mmsearch-bin/searchlocalpage";
        c1196a.fsJ = new bvi();
        c1196a.fsK = new bvj();
        this.ehh = c1196a.acD();
        this.ehh = this.ehh;
        bvi bvi = (bvi) this.ehh.fsG.fsP;
        bvi.wWv = str;
        bvi.Scene = 25;
        bvi.luQ = C4988aa.m7403gw(C4996ah.getContext());
        bvi.wDI = C46400aa.abJ();
        AppMethodBeat.m2505o(91363);
    }
}
