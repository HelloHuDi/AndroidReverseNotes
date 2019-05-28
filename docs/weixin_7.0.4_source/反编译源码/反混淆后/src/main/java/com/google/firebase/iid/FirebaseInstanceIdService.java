package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FirebaseInstanceIdService extends zzb {
    /* Access modifiers changed, original: protected|final */
    /* renamed from: f */
    public final Intent mo32803f(Intent intent) {
        AppMethodBeat.m2504i(108710);
        Intent intent2 = (Intent) C25587o.m40589uS().bvY.poll();
        AppMethodBeat.m2505o(108710);
        return intent2;
    }

    public void onTokenRefresh() {
    }

    /* renamed from: g */
    public final void mo32804g(Intent intent) {
        AppMethodBeat.m2504i(108711);
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            onTokenRefresh();
            AppMethodBeat.m2505o(108711);
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                new StringBuilder((String.valueOf(stringExtra).length() + 21) + String.valueOf(valueOf).length()).append("Received command: ").append(stringExtra).append(" - ").append(valueOf);
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.m40567uD().mo43239uI();
                AppMethodBeat.m2505o(108711);
                return;
            } else if ("SYNC".equals(stringExtra)) {
                FirebaseInstanceId uD = FirebaseInstanceId.m40567uD();
                FirebaseInstanceId.bvq.mo19767aZ("");
                uD.startSync();
            }
        }
        AppMethodBeat.m2505o(108711);
    }
}
