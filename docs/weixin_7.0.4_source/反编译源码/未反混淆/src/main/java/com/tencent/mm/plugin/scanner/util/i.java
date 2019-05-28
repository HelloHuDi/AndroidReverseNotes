package com.tencent.mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class i {
    public static boolean cig() {
        AppMethodBeat.i(81450);
        c ll = com.tencent.mm.model.c.c.abi().ll("100027");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (dru == null) {
                ab.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
                AppMethodBeat.o(81450);
                return false;
            } else if (dru.containsKey("showEntrance") && "1".equals(dru.get("showEntrance"))) {
                AppMethodBeat.o(81450);
                return true;
            } else {
                ab.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
                AppMethodBeat.o(81450);
                return false;
            }
        }
        ab.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
        AppMethodBeat.o(81450);
        return false;
    }
}
