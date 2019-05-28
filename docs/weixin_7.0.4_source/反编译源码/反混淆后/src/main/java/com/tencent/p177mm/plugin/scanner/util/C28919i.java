package com.tencent.p177mm.plugin.scanner.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5141c;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.scanner.util.i */
public final class C28919i {
    public static boolean cig() {
        AppMethodBeat.m2504i(81450);
        C5141c ll = C18624c.abi().mo17131ll("100027");
        if (ll.isValid()) {
            Map dru = ll.dru();
            if (dru == null) {
                C4990ab.m7412e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
                AppMethodBeat.m2505o(81450);
                return false;
            } else if (dru.containsKey("showEntrance") && "1".equals(dru.get("showEntrance"))) {
                AppMethodBeat.m2505o(81450);
                return true;
            } else {
                C4990ab.m7412e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
                AppMethodBeat.m2505o(81450);
                return false;
            }
        }
        C4990ab.m7412e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
        AppMethodBeat.m2505o(81450);
        return false;
    }
}
