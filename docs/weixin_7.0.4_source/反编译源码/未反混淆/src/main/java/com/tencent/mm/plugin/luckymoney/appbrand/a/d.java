package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bqa;
import com.tencent.mm.protocal.protobuf.bqb;
import com.tencent.mm.protocal.protobuf.btd;

public final class d extends a<bqa, bqb> {
    public d(String str, String str2) {
        AppMethodBeat.i(41989);
        bqa bqa = new bqa();
        bqa.csB = str;
        bqa.wKw = str2;
        this.nRK = bqa;
        AppMethodBeat.o(41989);
    }

    public final String getUri() {
        return "/cgi-bin/mmbiz-bin/wxahb/receivewxaapphb";
    }

    public final int ZU() {
        return 1828;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ btd bKR() {
        AppMethodBeat.i(41990);
        bqb bqb = new bqb();
        AppMethodBeat.o(41990);
        return bqb;
    }
}
