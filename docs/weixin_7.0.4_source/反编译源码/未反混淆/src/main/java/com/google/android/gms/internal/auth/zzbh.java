package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.zzf;
import com.google.android.gms.auth.api.zzh;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzbh extends GmsClient<zzbk> {
    private final Bundle zzcf;

    public zzbh(Context context, Looper looper, ClientSettings clientSettings, zzh zzh, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 16, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.i(77103);
        if (zzh == null) {
            this.zzcf = new Bundle();
            AppMethodBeat.o(77103);
            return;
        }
        NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
        AppMethodBeat.o(77103);
        throw noSuchMethodError;
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(77105);
        if (iBinder == null) {
            AppMethodBeat.o(77105);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.internal.IAuthService");
        if (queryLocalInterface instanceof zzbk) {
            zzbk zzbk = (zzbk) queryLocalInterface;
            AppMethodBeat.o(77105);
            return zzbk;
        }
        zzbl zzbl = new zzbl(iBinder);
        AppMethodBeat.o(77105);
        return zzbl;
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zzcf;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.service.START";
    }

    public final boolean requiresSignIn() {
        AppMethodBeat.i(77104);
        ClientSettings clientSettings = getClientSettings();
        if (TextUtils.isEmpty(clientSettings.getAccountName()) || clientSettings.getApplicableScopes(zzf.API).isEmpty()) {
            AppMethodBeat.o(77104);
            return false;
        }
        AppMethodBeat.o(77104);
        return true;
    }
}
