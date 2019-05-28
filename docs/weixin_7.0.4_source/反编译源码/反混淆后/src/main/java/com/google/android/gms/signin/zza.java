package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza extends AbstractClientBuilder<SignInClientImpl, SignInOptions> {
    zza() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(61708);
        SignInOptions signInOptions = (SignInOptions) obj;
        SignInClientImpl signInClientImpl = new SignInClientImpl(context, looper, true, clientSettings, signInOptions == null ? SignInOptions.DEFAULT : signInOptions, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.m2505o(61708);
        return signInClientImpl;
    }
}
