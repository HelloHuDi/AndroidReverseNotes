package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.ChannelApi;
import com.google.android.gms.wearable.ChannelApi.ChannelListener;
import com.google.android.gms.wearable.ChannelApi.OpenChannelResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzaj implements ChannelApi {
    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, ChannelListener channelListener) {
        AppMethodBeat.i(70998);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(channelListener, "listener is null");
        PendingResult zza = zzb.zza(googleApiClient, new zzal(new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.CHANNEL_EVENT")}), channelListener);
        AppMethodBeat.o(70998);
        return zza;
    }

    public final PendingResult<OpenChannelResult> openChannel(GoogleApiClient googleApiClient, String str, String str2) {
        AppMethodBeat.i(70997);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(str, "nodeId is null");
        Preconditions.checkNotNull(str2, "path is null");
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzak(this, googleApiClient, str, str2));
        AppMethodBeat.o(70997);
        return enqueue;
    }

    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, ChannelListener channelListener) {
        AppMethodBeat.i(70999);
        Preconditions.checkNotNull(googleApiClient, "client is null");
        Preconditions.checkNotNull(channelListener, "listener is null");
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzan(googleApiClient, channelListener, null));
        AppMethodBeat.o(70999);
        return enqueue;
    }
}
