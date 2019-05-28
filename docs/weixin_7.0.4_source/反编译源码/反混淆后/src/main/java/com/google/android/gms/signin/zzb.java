package com.google.android.gms.signin;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignIn.SignInOptionsInternal;
import com.google.android.gms.signin.internal.SignInClientImpl;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb extends AbstractClientBuilder<SignInClientImpl, SignInOptionsInternal> {
    zzb() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(61709);
        SignInClientImpl signInClientImpl = new SignInClientImpl(context, looper, false, clientSettings, ((SignInOptionsInternal) obj).getSignInOptionsBundle(), connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.m2505o(61709);
        return signInClientImpl;
    }
}
