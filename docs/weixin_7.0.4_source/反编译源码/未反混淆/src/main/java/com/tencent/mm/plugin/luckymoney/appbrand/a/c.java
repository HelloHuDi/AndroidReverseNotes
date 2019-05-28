package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bom;
import com.tencent.mm.protocal.protobuf.bon;
import com.tencent.mm.protocal.protobuf.btd;

public final class c extends a<bom, bon> {
    public c(String str, String str2, int i) {
        AppMethodBeat.i(41987);
        bom bom = new bom();
        bom.csB = str;
        bom.wKw = str2;
        bom.offset = i;
        this.nRK = bom;
        AppMethodBeat.o(41987);
    }

    /* Access modifiers changed, original: protected|final */
    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/querywxaapphbdetail";
    }

    /* Access modifiers changed, original: protected|final */
    public final int ZU() {
        return 2949;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ btd bKR() {
        AppMethodBeat.i(41988);
        bon bon = new bon();
        AppMethodBeat.o(41988);
        return bon;
    }
}
