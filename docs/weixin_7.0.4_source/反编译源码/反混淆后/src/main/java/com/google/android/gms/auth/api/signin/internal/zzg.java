package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzg implements GoogleSignInApi {
    private static GoogleSignInOptions zzd(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(50431);
        GoogleSignInOptions zzn = ((zzh) googleApiClient.getClient(Auth.zzak)).zzn();
        AppMethodBeat.m2505o(50431);
        return zzn;
    }

    public final Intent getSignInIntent(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(50426);
        Intent zzd = zzi.zzd(googleApiClient.getContext(), zzd(googleApiClient));
        AppMethodBeat.m2505o(50426);
        return zzd;
    }

    public final GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        AppMethodBeat.m2504i(50430);
        GoogleSignInResult signInResultFromIntent = zzi.getSignInResultFromIntent(intent);
        AppMethodBeat.m2505o(50430);
        return signInResultFromIntent;
    }

    public final PendingResult<Status> revokeAccess(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(50429);
        PendingResult zze = zzi.zze(googleApiClient, googleApiClient.getContext(), false);
        AppMethodBeat.m2505o(50429);
        return zze;
    }

    public final PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(50428);
        PendingResult zzd = zzi.zzd(googleApiClient, googleApiClient.getContext(), false);
        AppMethodBeat.m2505o(50428);
        return zzd;
    }

    public final OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient) {
        AppMethodBeat.m2504i(50427);
        OptionalPendingResult zzd = zzi.zzd(googleApiClient, googleApiClient.getContext(), zzd(googleApiClient), false);
        AppMethodBeat.m2505o(50427);
        return zzd;
    }
}
