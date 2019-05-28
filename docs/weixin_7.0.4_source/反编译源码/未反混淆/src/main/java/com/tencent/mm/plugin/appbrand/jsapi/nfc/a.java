package com.tencent.mm.plugin.appbrand.jsapi.nfc;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;

public final class a extends ah {
    private static final int CTRL_INDEX = 355;
    private static final String NAME = "onHCEMessage";
    private static final a hRS = new a();

    static {
        AppMethodBeat.i(137843);
        AppMethodBeat.o(137843);
    }

    static synchronized void a(c cVar, int i, Bundle bundle) {
        synchronized (a.class) {
            AppMethodBeat.i(137842);
            ab.i("MicroMsg.EventOnHCEMessageReceived", "alvinluo EventOnHCEMessageReceived dispatch appId: %s, eventType: %d", cVar.getAppId(), Integer.valueOf(i));
            if (i == 31) {
                if (bundle != null) {
                    String string = bundle.getString("key_apdu_command");
                    HashMap hashMap = new HashMap();
                    hashMap.put("messageType", Integer.valueOf(1));
                    hashMap.put("data", string);
                    hRS.j(cVar).t(hashMap).aCj();
                    AppMethodBeat.o(137842);
                }
                AppMethodBeat.o(137842);
            } else {
                if (i == 41 && bundle != null) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("messageType", Integer.valueOf(2));
                    hashMap2.put("reason", Integer.valueOf(bundle.getInt("key_on_deactivated_reason")));
                    hRS.j(cVar).t(hashMap2).aCj();
                }
                AppMethodBeat.o(137842);
            }
        }
    }
}
