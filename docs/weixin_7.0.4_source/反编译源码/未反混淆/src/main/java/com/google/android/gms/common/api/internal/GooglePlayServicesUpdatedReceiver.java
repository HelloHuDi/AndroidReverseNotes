package com.google.android.gms.common.api.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GooglePlayServicesUpdatedReceiver extends BroadcastReceiver {
    private Context mContext;
    private final Callback zzkt;

    public static abstract class Callback {
        public abstract void zzv();
    }

    public GooglePlayServicesUpdatedReceiver(Callback callback) {
        this.zzkt = callback;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(60637);
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.zzkt.zzv();
            unregister();
        }
        AppMethodBeat.o(60637);
    }

    public final synchronized void unregister() {
        AppMethodBeat.i(60636);
        if (this.mContext != null) {
            this.mContext.unregisterReceiver(this);
        }
        this.mContext = null;
        AppMethodBeat.o(60636);
    }

    public final void zzc(Context context) {
        this.mContext = context;
    }
}
