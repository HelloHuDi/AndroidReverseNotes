package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.sdk.platformtools.ab;

public final class s {
    private static s tfH;
    public bfi tfI;

    public static s cMK() {
        AppMethodBeat.i(45277);
        if (tfH == null) {
            tfH = new s();
        }
        s sVar = tfH;
        AppMethodBeat.o(45277);
        return sVar;
    }

    public final void a(bfi bfi) {
        AppMethodBeat.i(45278);
        ab.i("MicroMsg.LqtOnClickRedeemCache", "setCache OnClickRedeemRes balance %s, bank_balance %s, lq_balance %s", Integer.valueOf(bfi.wJb), Integer.valueOf(bfi.wJd), Integer.valueOf(bfi.wJc));
        this.tfI = bfi;
        if (ae.gjw) {
            this.tfI.wJb = 100000000;
            this.tfI.wJd = 50000000;
            this.tfI.wJc = 50000000;
        }
        AppMethodBeat.o(45278);
    }
}
