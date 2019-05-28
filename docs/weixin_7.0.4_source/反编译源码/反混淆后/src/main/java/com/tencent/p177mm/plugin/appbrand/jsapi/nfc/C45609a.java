package com.tencent.p177mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.nfc.a */
public final class C45609a extends C42467ah {
    private static final int CTRL_INDEX = 355;
    private static final String NAME = "onHCEMessage";
    private static final C45609a hRS = new C45609a();

    static {
        AppMethodBeat.m2504i(137843);
        AppMethodBeat.m2505o(137843);
    }

    /* renamed from: a */
    static synchronized void m84185a(C2241c c2241c, int i, Bundle bundle) {
        synchronized (C45609a.class) {
            AppMethodBeat.m2504i(137842);
            C4990ab.m7417i("MicroMsg.EventOnHCEMessageReceived", "alvinluo EventOnHCEMessageReceived dispatch appId: %s, eventType: %d", c2241c.getAppId(), Integer.valueOf(i));
            if (i == 31) {
                if (bundle != null) {
                    String string = bundle.getString("key_apdu_command");
                    HashMap hashMap = new HashMap();
                    hashMap.put("messageType", Integer.valueOf(1));
                    hashMap.put("data", string);
                    hRS.mo61032j(c2241c).mo34958t(hashMap).aCj();
                    AppMethodBeat.m2505o(137842);
                }
                AppMethodBeat.m2505o(137842);
            } else {
                if (i == 41 && bundle != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("messageType", Integer.valueOf(2));
                    hashMap2.put("reason", Integer.valueOf(bundle.getInt("key_on_deactivated_reason")));
                    hRS.mo61032j(c2241c).mo34958t(hashMap2).aCj();
                }
                AppMethodBeat.m2505o(137842);
            }
        }
    }
}
