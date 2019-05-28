package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzal implements zzc<ChannelListener> {
    private final /* synthetic */ IntentFilter[] zzbr;

    zzal(IntentFilter[] intentFilterArr) {
        this.zzbr = intentFilterArr;
    }

    public final /* synthetic */ void zza(zzhg zzhg, ResultHolder resultHolder, Object obj, ListenerHolder listenerHolder) {
        AppMethodBeat.i(71002);
        zzhg.zza(resultHolder, (ChannelListener) obj, listenerHolder, null, this.zzbr);
        AppMethodBeat.o(71002);
    }
}
