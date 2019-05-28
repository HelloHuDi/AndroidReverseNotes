package com.tencent.mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

public class FCMInstanceIDListenerService extends FirebaseInstanceIdService {
    public final void onTokenRefresh() {
        AppMethodBeat.i(56426);
        String token = FirebaseInstanceId.uD().getToken();
        ab.i("MicroMsg.FCM.FCMInstanceIDListenerService", "Refreshed token: ".concat(String.valueOf(token)));
        g.RN();
        if (a.QX()) {
            a bwG = a.bwG();
            if (bwG != null) {
                bwG.Mk(token);
                AppMethodBeat.o(56426);
                return;
            }
            ab.w("MicroMsg.FCM.FCMInstanceIDListenerService", "fcmRegister null, not reg token");
            AppMethodBeat.o(56426);
            return;
        }
        ab.w("MicroMsg.FCM.FCMInstanceIDListenerService", "User is not logined, not reg token");
        AppMethodBeat.o(56426);
    }
}
