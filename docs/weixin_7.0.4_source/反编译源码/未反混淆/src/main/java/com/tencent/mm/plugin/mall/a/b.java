package com.tencent.mm.plugin.mall.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a;
import com.tencent.mm.protocal.protobuf.amc;
import com.tencent.mm.protocal.protobuf.amd;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends a<amd> {
    public b(int i) {
        AppMethodBeat.i(43093);
        amc amc = new amc();
        amc.vKn = i;
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = amc;
        aVar.fsK = new amd();
        aVar.fsI = 2680;
        aVar.uri = "/cgi-bin/micromsg-bin/getpayfunctionswitchlist";
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.CgiGetPayFunctionSwitchList", "TpaCountry: %s", Integer.valueOf(i));
        AppMethodBeat.o(43093);
    }
}
