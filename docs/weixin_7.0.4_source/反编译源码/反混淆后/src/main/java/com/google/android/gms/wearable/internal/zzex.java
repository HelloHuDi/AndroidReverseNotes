package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzex extends zzn<Status> {
    private ListenerHolder<MessageListener> zzax;
    private IntentFilter[] zzba;
    private MessageListener zzeg;

    private zzex(GoogleApiClient googleApiClient, MessageListener messageListener, ListenerHolder<MessageListener> listenerHolder, IntentFilter[] intentFilterArr) {
        super(googleApiClient);
        AppMethodBeat.m2504i(71295);
        this.zzeg = (MessageListener) Preconditions.checkNotNull(messageListener);
        this.zzax = (ListenerHolder) Preconditions.checkNotNull(listenerHolder);
        this.zzba = (IntentFilter[]) Preconditions.checkNotNull(intentFilterArr);
        AppMethodBeat.m2505o(71295);
    }

    /* synthetic */ zzex(GoogleApiClient googleApiClient, MessageListener messageListener, ListenerHolder listenerHolder, IntentFilter[] intentFilterArr, zzev zzev) {
        this(googleApiClient, messageListener, listenerHolder, intentFilterArr);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        this.zzeg = null;
        this.zzax = null;
        this.zzba = null;
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.m2504i(71296);
        ((zzhg) anyClient).zza((ResultHolder) this, this.zzeg, this.zzax, this.zzba);
        this.zzeg = null;
        this.zzax = null;
        this.zzba = null;
        AppMethodBeat.m2505o(71296);
    }
}
