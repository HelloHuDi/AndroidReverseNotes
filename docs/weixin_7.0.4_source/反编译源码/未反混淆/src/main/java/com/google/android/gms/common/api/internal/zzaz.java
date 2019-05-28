package com.google.android.gms.common.api.internal;

import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaz implements ResultCallback<Status> {
    private final /* synthetic */ zzav zzit;
    private final /* synthetic */ StatusPendingResult zziv;
    private final /* synthetic */ boolean zziw;
    private final /* synthetic */ GoogleApiClient zzix;

    zzaz(zzav zzav, StatusPendingResult statusPendingResult, boolean z, GoogleApiClient googleApiClient) {
        this.zzit = zzav;
        this.zziv = statusPendingResult;
        this.zziw = z;
        this.zzix = googleApiClient;
    }

    public final /* synthetic */ void onResult(Result result) {
        AppMethodBeat.i(60812);
        Status status = (Status) result;
        Storage.getInstance(this.zzit.mContext).removeSavedDefaultGoogleSignInAccount();
        if (status.isSuccess() && this.zzit.isConnected()) {
            this.zzit.reconnect();
        }
        this.zziv.setResult(status);
        if (this.zziw) {
            this.zzix.disconnect();
        }
        AppMethodBeat.o(60812);
    }
}
