package com.tencent.mm.wallet_core;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;

public final class b {
    private static b AeS;

    public static b dNA() {
        AppMethodBeat.i(49006);
        if (AeS == null) {
            AeS = new b();
        }
        b bVar = AeS;
        AppMethodBeat.o(49006);
        return bVar;
    }

    public static boolean dNB() {
        int i;
        AppMethodBeat.i(49007);
        c ll = com.tencent.mm.model.c.c.abi().ll("100368");
        if (ll.isValid() && "1".equals(ll.dru().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        ab.i("MicroMsg.TenPaySdkAbTest", "isPwdOpen2048 %s", Integer.valueOf(i));
        if (i > 0) {
            AppMethodBeat.o(49007);
            return true;
        }
        AppMethodBeat.o(49007);
        return false;
    }

    public static boolean dNC() {
        int i;
        AppMethodBeat.i(49008);
        c ll = com.tencent.mm.model.c.c.abi().ll("100370");
        if (ll.isValid() && "1".equals(ll.dru().get("open"))) {
            i = 1;
        } else {
            i = 0;
        }
        ab.i("MicroMsg.TenPaySdkAbTest", "isOfflineOpen2048 %s", Integer.valueOf(i));
        if (i > 0) {
            AppMethodBeat.o(49008);
            return true;
        }
        AppMethodBeat.o(49008);
        return false;
    }
}
