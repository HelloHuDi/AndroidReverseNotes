package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.auth.zzax;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzd extends AbstractClientBuilder<zzax, AuthCredentialsOptions> {
    zzd() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(50465);
        zzax zzax = new zzax(context, looper, clientSettings, (AuthCredentialsOptions) obj, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.m2505o(50465);
        return zzax;
    }
}
