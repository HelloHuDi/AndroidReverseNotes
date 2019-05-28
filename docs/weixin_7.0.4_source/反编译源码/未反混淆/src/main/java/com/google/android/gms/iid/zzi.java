package com.google.android.gms.iid;

import android.os.Binder;
import android.os.Process;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzi extends Binder {
    private final zze zzbi;

    zzi(zze zze) {
        this.zzbi = zze;
    }

    public final void zzd(zzg zzg) {
        AppMethodBeat.i(57567);
        if (Binder.getCallingUid() != Process.myUid()) {
            SecurityException securityException = new SecurityException("Binding only allowed within app");
            AppMethodBeat.o(57567);
            throw securityException;
        }
        Log.isLoggable("EnhancedIntentService", 3);
        Log.isLoggable("EnhancedIntentService", 3);
        this.zzbi.zzax.execute(new zzj(this, zzg));
        AppMethodBeat.o(57567);
    }
}
