package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;

public final class e extends a<bsu, bsv> {
    public e(bsu bsu) {
        this.nRK = bsu;
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKS() {
        AppMethodBeat.i(41991);
        ab.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiStart ");
        AppMethodBeat.o(41991);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKT() {
        AppMethodBeat.i(41992);
        ab.i("MicroMsg.CgiRequestWxaHB", "CgiRequestWxaHB.onCgiEnd ");
        AppMethodBeat.o(41992);
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/requestwxaapphb";
    }

    public final int ZU() {
        return 2857;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ btd bKR() {
        AppMethodBeat.i(41993);
        bsv bsv = new bsv();
        AppMethodBeat.o(41993);
        return bsv;
    }
}
