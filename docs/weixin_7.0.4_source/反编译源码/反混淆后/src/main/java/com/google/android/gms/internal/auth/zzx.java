package com.google.android.gms.internal.auth;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.auth.api.accounttransfer.zzq;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzx extends GmsClient<zzac> {
    private final Bundle zzcf;

    public zzx(Context context, Looper looper, ClientSettings clientSettings, zzq zzq, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 128, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.m2504i(77153);
        if (zzq == null) {
            this.zzcf = new Bundle();
            AppMethodBeat.m2505o(77153);
            return;
        }
        NoSuchMethodError noSuchMethodError = new NoSuchMethodError();
        AppMethodBeat.m2505o(77153);
        throw noSuchMethodError;
    }

    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        AppMethodBeat.m2504i(77154);
        if (iBinder == null) {
            AppMethodBeat.m2505o(77154);
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService");
        if (queryLocalInterface instanceof zzac) {
            zzac zzac = (zzac) queryLocalInterface;
            AppMethodBeat.m2505o(77154);
            return zzac;
        }
        zzad zzad = new zzad(iBinder);
        AppMethodBeat.m2505o(77154);
        return zzad;
    }

    public final Bundle getGetServiceRequestExtraArgs() {
        return this.zzcf;
    }

    public final int getMinApkVersion() {
        return 12451000;
    }

    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.accounttransfer.internal.IAccountTransferService";
    }

    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.accounttransfer.service.START";
    }
}
