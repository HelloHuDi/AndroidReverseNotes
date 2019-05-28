package com.google.android.gms.auth.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.zzh;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class zze extends AbstractClientBuilder<zzh, GoogleSignInOptions> {
    zze() {
    }

    public final /* synthetic */ Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        AppMethodBeat.m2504i(50466);
        zzh zzh = new zzh(context, looper, clientSettings, (GoogleSignInOptions) obj, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.m2505o(50466);
        return zzh;
    }

    public final /* synthetic */ List getImpliedScopes(Object obj) {
        AppMethodBeat.m2504i(50467);
        GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
        if (googleSignInOptions == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(50467);
            return emptyList;
        }
        ArrayList scopes = googleSignInOptions.getScopes();
        AppMethodBeat.m2505o(50467);
        return scopes;
    }
}
