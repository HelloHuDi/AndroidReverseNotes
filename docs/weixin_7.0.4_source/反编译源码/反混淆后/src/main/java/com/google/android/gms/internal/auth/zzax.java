package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzax extends GmsClient<zzbc> {
    private final AuthCredentialsOptions zzdv;

    public zzax(Context context, Looper looper, ClientSettings clientSettings, AuthCredentialsOptions authCredentialsOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 68, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.zzdv = authCredentialsOptions;
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.m2504i(50487);
        if (iBinder == null) {
            AppMethodBeat.m2505o(50487);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.credentials.internal.ICredentialsService");
        if (queryLocalInterface instanceof zzbc) {
            zzbc zzbc = (zzbc) queryLocalInterface;
            AppMethodBeat.m2505o(50487);
            return zzbc;
        }
        zzbd zzbd = new zzbd(iBinder);
        AppMethodBeat.m2505o(50487);
        return zzbd;
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        AppMethodBeat.m2504i(50486);
        Bundle bundle;
        if (this.zzdv == null) {
            bundle = new Bundle();
            AppMethodBeat.m2505o(50486);
            return bundle;
        }
        bundle = this.zzdv.toBundle();
        AppMethodBeat.m2505o(50486);
        return bundle;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.credentials.internal.ICredentialsService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.credentials.service.START";
    }

    /* Access modifiers changed, original: final */
    public final AuthCredentialsOptions zzk() {
        return this.zzdv;
    }
}
