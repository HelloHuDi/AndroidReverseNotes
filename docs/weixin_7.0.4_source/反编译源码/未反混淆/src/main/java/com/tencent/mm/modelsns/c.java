package com.tencent.mm.modelsns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {
    public static int fQr = 0;
    public static c fQs = new c();

    static {
        AppMethodBeat.i(94482);
        AppMethodBeat.o(94482);
    }

    public static void ajL() {
        AppMethodBeat.i(94481);
        com.tencent.mm.storage.c ll = com.tencent.mm.model.c.c.abi().ll("100024");
        ab.i("MicroMsg.StatisticsOplogAbTest", "test " + ll.field_rawXML + " " + ll.isValid());
        if (ll.isValid()) {
            fQr = bo.ank((String) ll.dru().get("Switch"));
            ab.i("MicroMsg.StatisticsOplogAbTest", "switchVal " + fQr);
        }
        AppMethodBeat.o(94481);
    }
}
