package com.google.android.gms.auth.api.accounttransfer;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzx;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd extends AbstractClientBuilder<zzx, zzq> {
    zzd() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(76992);
        zzx zzx = new zzx(context, looper, clientSettings, (zzq) obj, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.m2505o(76992);
        return zzx;
    }
}
