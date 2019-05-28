package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzeu implements MessageApi {
    private static PendingResult<Status> zza(GoogleApiClient googleApiClient, MessageListener messageListener, IntentFilter[] intentFilterArr) {
        AppMethodBeat.i(71290);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzex(googleApiClient, messageListener, googleApiClient.registerListener(messageListener), intentFilterArr, null));
        AppMethodBeat.o(71290);
        return enqueue;
    }

    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageListener messageListener) {
        AppMethodBeat.i(71288);
        PendingResult zza = zza(googleApiClient, messageListener, new IntentFilter[]{zzgj.zzc("com.google.android.gms.wearable.MESSAGE_RECEIVED")});
        AppMethodBeat.o(71288);
        return zza;
    }

    public final PendingResult<Status> addListener(GoogleApiClient googleApiClient, MessageListener messageListener, Uri uri, int i) {
        AppMethodBeat.i(71289);
        Preconditions.checkNotNull(uri, "uri must not be null");
        boolean z = i == 0 || i == 1;
        Preconditions.checkArgument(z, "invalid filter type");
        PendingResult zza = zza(googleApiClient, messageListener, new IntentFilter[]{zzgj.zza("com.google.android.gms.wearable.MESSAGE_RECEIVED", uri, i)});
        AppMethodBeat.o(71289);
        return zza;
    }

    public final PendingResult<Status> removeListener(GoogleApiClient googleApiClient, MessageListener messageListener) {
        AppMethodBeat.i(71291);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzew(this, googleApiClient, messageListener));
        AppMethodBeat.o(71291);
        return enqueue;
    }

    public final PendingResult<SendMessageResult> sendMessage(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr) {
        AppMethodBeat.i(71287);
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzev(this, googleApiClient, str, str2, bArr));
        AppMethodBeat.o(71287);
        return enqueue;
    }
}
