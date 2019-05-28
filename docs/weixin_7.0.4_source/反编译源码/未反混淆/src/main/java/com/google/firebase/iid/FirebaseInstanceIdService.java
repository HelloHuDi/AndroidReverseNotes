package com.google.firebase.iid;

import android.content.Intent;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FirebaseInstanceIdService extends zzb {
    /* Access modifiers changed, original: protected|final */
    public final Intent f(Intent intent) {
        AppMethodBeat.i(108710);
        Intent intent2 = (Intent) o.uS().bvY.poll();
        AppMethodBeat.o(108710);
        return intent2;
    }

    public void onTokenRefresh() {
    }

    public final void g(Intent intent) {
        AppMethodBeat.i(108711);
        if ("com.google.firebase.iid.TOKEN_REFRESH".equals(intent.getAction())) {
            onTokenRefresh();
            AppMethodBeat.o(108711);
            return;
        }
        String stringExtra = intent.getStringExtra("CMD");
        if (stringExtra != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                new StringBuilder((String.valueOf(stringExtra).length() + 21) + String.valueOf(valueOf).length()).append("Received command: ").append(stringExtra).append(" - ").append(valueOf);
            }
            if ("RST".equals(stringExtra) || "RST_FULL".equals(stringExtra)) {
                FirebaseInstanceId.uD().uI();
                AppMethodBeat.o(108711);
                return;
            } else if ("SYNC".equals(stringExtra)) {
                FirebaseInstanceId uD = FirebaseInstanceId.uD();
                FirebaseInstanceId.bvq.aZ("");
                uD.startSync();
            }
        }
        AppMethodBeat.o(108711);
    }
}
