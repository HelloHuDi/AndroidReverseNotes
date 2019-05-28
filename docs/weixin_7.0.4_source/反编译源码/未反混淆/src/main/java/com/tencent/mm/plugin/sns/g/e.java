package com.tencent.mm.plugin.sns.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;

public final class e {
    public static void YB(String str) {
        AppMethodBeat.i(36804);
        ab.i("MicroMsg.SnsABTestStrategy", "dump id ".concat(String.valueOf(str)));
        c ll = com.tencent.mm.model.c.c.abi().ll(str);
        if (!ll.isValid()) {
            ab.i("MicroMsg.SnsABTestStrategy", "abtest is invalid");
        }
        if (ll.dru() != null) {
            ab.i("MicroMsg.SnsABTestStrategy", "dump feed abtest " + ll.field_rawXML);
        }
        AppMethodBeat.o(36804);
    }
}
