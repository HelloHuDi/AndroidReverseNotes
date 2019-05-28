package com.google.android.gms.auth.api.signin;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzx;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class RevocationBoundService extends Service {
    public final IBinder onBind(Intent intent) {
        AppMethodBeat.i(50398);
        String str;
        String valueOf;
        if ("com.google.android.gms.auth.api.signin.RevocationBoundService.disconnect".equals(intent.getAction()) || "com.google.android.gms.auth.api.signin.RevocationBoundService.clearClientState".equals(intent.getAction())) {
            if (Log.isLoggable("RevocationService", 2)) {
                str = "RevocationBoundService handling ";
                valueOf = String.valueOf(intent.getAction());
                if (valueOf.length() != 0) {
                    str.concat(valueOf);
                } else {
                    valueOf = new String(str);
                }
            }
            zzx zzx = new zzx(this);
            AppMethodBeat.o(50398);
            return zzx;
        }
        str = "Unknown action sent to RevocationBoundService: ";
        valueOf = String.valueOf(intent.getAction());
        if (valueOf.length() != 0) {
            str.concat(valueOf);
        } else {
            valueOf = new String(str);
        }
        AppMethodBeat.o(50398);
        return null;
    }
}
