package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzan implements CredentialRequestResult {
    private final Status mStatus;
    private final Credential zzdq;

    public zzan(Status status, Credential credential) {
        this.mStatus = status;
        this.zzdq = credential;
    }

    public static zzan zzf(Status status) {
        AppMethodBeat.i(50471);
        zzan zzan = new zzan(status, null);
        AppMethodBeat.o(50471);
        return zzan;
    }

    public final Credential getCredential() {
        return this.zzdq;
    }

    public final Status getStatus() {
        return this.mStatus;
    }
}
