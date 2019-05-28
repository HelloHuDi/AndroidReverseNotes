package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb<T> extends zzn<Status> {
    private T zzaw;
    private ListenerHolder<T> zzax;
    private zzc<T> zzay;

    private zzb(GoogleApiClient googleApiClient, T t, ListenerHolder<T> listenerHolder, zzc<T> zzc) {
        super(googleApiClient);
        AppMethodBeat.i(71060);
        this.zzaw = Preconditions.checkNotNull(t);
        this.zzax = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.zzay = (zzc) Preconditions.checkNotNull(zzc);
        AppMethodBeat.o(71060);
    }

    static <T> PendingResult<Status> zza(GoogleApiClient googleApiClient, zzc<T> zzc, T t) {
        AppMethodBeat.i(71059);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzb(googleApiClient, t, googleApiClient.registerListener(t), zzc));
        AppMethodBeat.o(71059);
        return enqueue;
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        this.zzaw = null;
        this.zzax = null;
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71061);
        this.zzay.zza((zzhg) anyClient, this, this.zzaw, this.zzax);
        this.zzaw = null;
        this.zzax = null;
        AppMethodBeat.o(71061);
    }
}
