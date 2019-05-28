package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzh extends GmsClient<zzv> {
    private final GoogleSignInOptions zzev;

    public zzh(Context context, Looper looper, ClientSettings clientSettings, GoogleSignInOptions googleSignInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 91, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.m2504i(50432);
        if (googleSignInOptions == null) {
            googleSignInOptions = new Builder().build();
        }
        if (!clientSettings.getAllRequestedScopes().isEmpty()) {
            Builder builder = new Builder(googleSignInOptions);
            for (Scope requestScopes : clientSettings.getAllRequestedScopes()) {
                builder.requestScopes(requestScopes, new Scope[0]);
            }
            googleSignInOptions = builder.build();
        }
        this.zzev = googleSignInOptions;
        AppMethodBeat.m2505o(50432);
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.m2504i(50434);
        if (iBinder == null) {
            AppMethodBeat.m2505o(50434);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        if (queryLocalInterface instanceof zzv) {
            zzv zzv = (zzv) queryLocalInterface;
            AppMethodBeat.m2505o(50434);
            return zzv;
        }
        zzw zzw = new zzw(iBinder);
        AppMethodBeat.m2505o(50434);
        return zzw;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    public final Intent getSignInIntent() {
        AppMethodBeat.m2504i(50433);
        Intent zzd = zzi.zzd(getContext(), this.zzev);
        AppMethodBeat.m2505o(50433);
        return zzd;
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }

    public final boolean providesSignIn() {
        return true;
    }

    public final GoogleSignInOptions zzn() {
        return this.zzev;
    }
}
