package com.google.android.gms.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Deprecated
public class InstanceIDListenerService extends zze {
    static void zzd(Context context, zzak zzak) {
        AppMethodBeat.i(57520);
        zzak.zzx();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra("CMD", "RST");
        intent.setClassName(context, "com.google.android.gms.gcm.GcmReceiver");
        context.sendBroadcast(intent);
        AppMethodBeat.o(57520);
    }

    public void handleIntent(Intent intent) {
        AppMethodBeat.i(57519);
        if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
            Bundle bundle = null;
            String stringExtra = intent.getStringExtra("subtype");
            if (stringExtra != null) {
                bundle = new Bundle();
                bundle.putString("subtype", stringExtra);
            }
            InstanceID instance = InstanceID.getInstance(this, bundle);
            String stringExtra2 = intent.getStringExtra("CMD");
            if (Log.isLoggable("InstanceID", 3)) {
                new StringBuilder((String.valueOf(stringExtra).length() + 34) + String.valueOf(stringExtra2).length()).append("Service command. subtype:").append(stringExtra).append(" command:").append(stringExtra2);
            }
            if ("RST".equals(stringExtra2)) {
                instance.zzm();
                onTokenRefresh();
                AppMethodBeat.o(57519);
                return;
            }
            if ("RST_FULL".equals(stringExtra2)) {
                if (!InstanceID.zzn().isEmpty()) {
                    InstanceID.zzn().zzx();
                    onTokenRefresh();
                    AppMethodBeat.o(57519);
                    return;
                }
            } else if ("SYNC".equals(stringExtra2)) {
                InstanceID.zzn().zzi(String.valueOf(stringExtra).concat("|T|"));
                onTokenRefresh();
            }
            AppMethodBeat.o(57519);
            return;
        }
        AppMethodBeat.o(57519);
    }

    public void onTokenRefresh() {
    }
}
