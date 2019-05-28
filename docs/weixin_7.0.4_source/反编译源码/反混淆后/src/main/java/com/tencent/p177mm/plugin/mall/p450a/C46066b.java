package com.tencent.p177mm.plugin.mall.p450a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.amc;
import com.tencent.p177mm.protocal.protobuf.amd;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.mall.a.b */
public final class C46066b extends C37440a<amd> {
    public C46066b(int i) {
        AppMethodBeat.m2504i(43093);
        amc amc = new amc();
        amc.vKn = i;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = amc;
        c1196a.fsK = new amd();
        c1196a.fsI = 2680;
        c1196a.uri = "/cgi-bin/micromsg-bin/getpayfunctionswitchlist";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        C4990ab.m7417i("MicroMsg.CgiGetPayFunctionSwitchList", "TpaCountry: %s", Integer.valueOf(i));
        AppMethodBeat.m2505o(43093);
    }
}
