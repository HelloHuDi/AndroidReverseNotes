package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwq extends ContentObserver {
    private final /* synthetic */ zzwp zzbnb;

    zzwq(zzwp zzwp, Handler handler) {
        this.zzbnb = zzwp;
        super(null);
    }

    public final void onChange(boolean z) {
        AppMethodBeat.i(69760);
        this.zzbnb.zzru();
        zzwp.zza(this.zzbnb);
        AppMethodBeat.o(69760);
    }
}
