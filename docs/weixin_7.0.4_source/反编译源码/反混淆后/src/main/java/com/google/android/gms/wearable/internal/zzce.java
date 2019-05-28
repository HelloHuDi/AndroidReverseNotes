package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzce implements zzc<DataListener> {
    private final /* synthetic */ IntentFilter[] zzbr;

    zzce(IntentFilter[] intentFilterArr) {
        this.zzbr = intentFilterArr;
    }

    public final /* synthetic */ void zza(zzhg zzhg, ResultHolder resultHolder, Object obj, ListenerHolder listenerHolder) {
        AppMethodBeat.m2504i(71135);
        zzhg.zza(resultHolder, (DataListener) obj, listenerHolder, this.zzbr);
        AppMethodBeat.m2505o(71135);
    }
}
