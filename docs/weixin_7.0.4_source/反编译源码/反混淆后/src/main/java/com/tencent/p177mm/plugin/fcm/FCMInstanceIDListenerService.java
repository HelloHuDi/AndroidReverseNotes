package com.tencent.p177mm.plugin.fcm;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.fcm.FCMInstanceIDListenerService */
public class FCMInstanceIDListenerService extends FirebaseInstanceIdService {
    public final void onTokenRefresh() {
        AppMethodBeat.m2504i(56426);
        String token = FirebaseInstanceId.m40567uD().getToken();
        C4990ab.m7416i("MicroMsg.FCM.FCMInstanceIDListenerService", "Refreshed token: ".concat(String.valueOf(token)));
        C1720g.m3534RN();
        if (C1668a.m3395QX()) {
            C39085a bwG = C39085a.bwG();
            if (bwG != null) {
                bwG.mo61994Mk(token);
                AppMethodBeat.m2505o(56426);
                return;
            }
            C4990ab.m7420w("MicroMsg.FCM.FCMInstanceIDListenerService", "fcmRegister null, not reg token");
            AppMethodBeat.m2505o(56426);
            return;
        }
        C4990ab.m7420w("MicroMsg.FCM.FCMInstanceIDListenerService", "User is not logined, not reg token");
        AppMethodBeat.m2505o(56426);
    }
}
