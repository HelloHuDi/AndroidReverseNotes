package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

final class zzan extends zzn<Status> {
    private final String zzce;
    private ChannelListener zzcf;

    zzan(GoogleApiClient googleApiClient, ChannelListener channelListener, @Nullable String str) {
        super(googleApiClient);
        AppMethodBeat.i(71004);
        this.zzcf = (ChannelListener) Preconditions.checkNotNull(channelListener);
        this.zzce = str;
        AppMethodBeat.o(71004);
    }

    public final /* synthetic */ Result createFailedResult(Status status) {
        this.zzcf = null;
        return status;
    }

    public final /* synthetic */ void doExecute(AnyClient anyClient) {
        AppMethodBeat.i(71005);
        ((zzhg) anyClient).zza(this, this.zzcf, this.zzce);
        this.zzcf = null;
        AppMethodBeat.o(71005);
    }
}
