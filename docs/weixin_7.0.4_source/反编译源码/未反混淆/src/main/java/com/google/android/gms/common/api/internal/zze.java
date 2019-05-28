package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.GoogleApiManager.zza;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zze extends zzc<Void> {
    private final RegisterListenerMethod<AnyClient, ?> zzdw;
    private final UnregisterListenerMethod<AnyClient, ?> zzdx;

    public zze(zzbv zzbv, TaskCompletionSource<Void> taskCompletionSource) {
        super(3, taskCompletionSource);
        this.zzdw = zzbv.zzlt;
        this.zzdx = zzbv.zzlu;
    }

    public final /* bridge */ /* synthetic */ void zza(zzaa zzaa, boolean z) {
    }

    public final void zzb(zza<?> zza) {
        AppMethodBeat.i(60905);
        this.zzdw.registerListener(zza.zzae(), this.zzdu);
        if (this.zzdw.getListenerKey() != null) {
            zza.zzbn().put(this.zzdw.getListenerKey(), new zzbv(this.zzdw, this.zzdx));
        }
        AppMethodBeat.o(60905);
    }
}
