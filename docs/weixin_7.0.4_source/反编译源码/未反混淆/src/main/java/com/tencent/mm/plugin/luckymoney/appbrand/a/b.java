package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bhj;
import com.tencent.mm.protocal.protobuf.bhk;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;

public final class b extends a<bhj, bhk> {
    public b(String str, String str2, byte[] bArr) {
        AppMethodBeat.i(41983);
        bhj bhj = new bhj();
        bhj.csB = str;
        bhj.wKw = str2;
        bhj.wKx = com.tencent.mm.bt.b.bI(bArr);
        this.nRK = bhj;
        AppMethodBeat.o(41983);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKS() {
        AppMethodBeat.i(41984);
        ab.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiStart ");
        AppMethodBeat.o(41984);
    }

    /* Access modifiers changed, original: protected|final */
    public final void bKT() {
        AppMethodBeat.i(41985);
        ab.i("MicroMsg.CgiOpenWxaHB", "CgiOpenWxaHB.onCgiEnd ");
        AppMethodBeat.o(41985);
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/openwxaapphb";
    }

    public final int ZU() {
        return 2701;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ btd bKR() {
        AppMethodBeat.i(41986);
        bhk bhk = new bhk();
        AppMethodBeat.o(41986);
        return bhk;
    }
}
