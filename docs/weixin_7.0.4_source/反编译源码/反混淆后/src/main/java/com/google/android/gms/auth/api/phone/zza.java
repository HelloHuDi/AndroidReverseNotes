package com.google.android.gms.auth.api.phone;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.p1161auth-api-phone.zzi;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza extends AbstractClientBuilder<zzi, NoOptions> {
    zza() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(80423);
        zzi zzi = new zzi(context, looper, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.m2505o(80423);
        return zzi;
    }
}
