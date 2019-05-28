package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzah extends BroadcastReceiver {
    private final /* synthetic */ zzaf zzcx;

    zzah(zzaf zzaf) {
        this.zzcx = zzaf;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(57548);
        Log.isLoggable("InstanceID", 3);
        this.zzcx.zzh(intent);
        AppMethodBeat.o(57548);
    }
}
