package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.CapabilityApi.CapabilityListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzt implements zzc<CapabilityListener> {
    private final /* synthetic */ IntentFilter[] zzbr;

    zzt(IntentFilter[] intentFilterArr) {
        this.zzbr = intentFilterArr;
    }

    public final /* synthetic */ void zza(zzhg zzhg, ResultHolder resultHolder, Object obj, ListenerHolder listenerHolder) {
        AppMethodBeat.i(71472);
        zzhg.zza(resultHolder, (CapabilityListener) obj, listenerHolder, this.zzbr);
        AppMethodBeat.o(71472);
    }
}
