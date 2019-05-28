package com.tencent.p177mm.plugin.mall.p450a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23400hw;
import com.tencent.p177mm.protocal.protobuf.C30190hx;
import com.tencent.p177mm.protocal.protobuf.biu;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.mall.a.a */
public final class C41294a extends C37440a<C30190hx> {
    public List<biu> okJ;

    public C41294a(LinkedList<biu> linkedList, int i) {
        AppMethodBeat.m2504i(43092);
        C23400hw c23400hw = new C23400hw();
        c23400hw.vKm = linkedList;
        c23400hw.vKn = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = c23400hw;
        c1196a.fsK = new C30190hx();
        c1196a.fsI = 2938;
        c1196a.uri = "/cgi-bin/micromsg-bin/batchfunctionoperate";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        this.okJ = linkedList;
        C4990ab.m7417i("MicroMsg.CgiBatchFunctionOperate", "TpaCountry: %s", Integer.valueOf(i));
        AppMethodBeat.m2505o(43092);
    }
}
