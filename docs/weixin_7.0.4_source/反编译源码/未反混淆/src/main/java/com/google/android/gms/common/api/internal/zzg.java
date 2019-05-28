package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg extends zzc<Boolean> {
    private final ListenerKey<?> zzea;

    public zzg(ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.zzea = listenerKey;
    }

    public final /* bridge */ /* synthetic */ void zza(zzaa zzaa, boolean z) {
    }

    public final void zzb(zza<?> zza) {
        AppMethodBeat.i(60914);
        zzbv zzbv = (zzbv) zza.zzbn().remove(this.zzea);
        if (zzbv != null) {
            zzbv.zzlu.unregisterListener(zza.zzae(), this.zzdu);
            zzbv.zzlt.clearListener();
            AppMethodBeat.o(60914);
            return;
        }
        this.zzdu.trySetResult(Boolean.FALSE);
        AppMethodBeat.o(60914);
    }
}
