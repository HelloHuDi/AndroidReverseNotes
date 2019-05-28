package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzao implements CredentialsApi {
    public final PendingResult<Status> delete(GoogleApiClient googleApiClient, Credential credential) {
        AppMethodBeat.m2504i(50475);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        Preconditions.checkNotNull(credential, "credential must not be null");
        ApiMethodImpl execute = googleApiClient.execute(new zzas(this, googleApiClient, credential));
        AppMethodBeat.m2505o(50475);
        return execute;
    }

    public final PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(50476);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        ApiMethodImpl execute = googleApiClient.execute(new zzat(this, googleApiClient));
        AppMethodBeat.m2505o(50476);
        return execute;
    }

    public final PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest) {
        AppMethodBeat.m2504i(50473);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        Preconditions.checkNotNull(hintRequest, "request must not be null");
        PendingIntent zzd = zzaw.zzd(googleApiClient.getContext(), ((zzax) googleApiClient.getClient(Auth.zzaj)).zzk(), hintRequest);
        AppMethodBeat.m2505o(50473);
        return zzd;
    }

    public final PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, CredentialRequest credentialRequest) {
        AppMethodBeat.m2504i(50472);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        Preconditions.checkNotNull(credentialRequest, "request must not be null");
        ApiMethodImpl enqueue = googleApiClient.enqueue(new zzap(this, googleApiClient, credentialRequest));
        AppMethodBeat.m2505o(50472);
        return enqueue;
    }

    public final PendingResult<Status> save(GoogleApiClient googleApiClient, Credential credential) {
        AppMethodBeat.m2504i(50474);
        Preconditions.checkNotNull(googleApiClient, "client must not be null");
        Preconditions.checkNotNull(credential, "credential must not be null");
        ApiMethodImpl execute = googleApiClient.execute(new zzar(this, googleApiClient, credential));
        AppMethodBeat.m2505o(50474);
        return execute;
    }
}
