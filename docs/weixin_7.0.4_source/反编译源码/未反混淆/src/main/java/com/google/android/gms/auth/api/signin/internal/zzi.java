package com.google.android.gms.auth.api.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.api.internal.GoogleApiManager;
import com.google.android.gms.common.api.internal.OptionalPendingResultImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class zzi {
    private static Logger zzer = new Logger("GoogleSignInCommon", new String[0]);

    static {
        AppMethodBeat.i(50443);
        AppMethodBeat.o(50443);
    }

    public static GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        AppMethodBeat.i(50442);
        if (intent == null || !(intent.hasExtra("googleSignInStatus") || intent.hasExtra("googleSignInAccount"))) {
            AppMethodBeat.o(50442);
            return null;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) intent.getParcelableExtra("googleSignInAccount");
        Status status = (Status) intent.getParcelableExtra("googleSignInStatus");
        if (googleSignInAccount != null) {
            status = Status.RESULT_SUCCESS;
        }
        GoogleSignInResult googleSignInResult = new GoogleSignInResult(googleSignInAccount, status);
        AppMethodBeat.o(50442);
        return googleSignInResult;
    }

    public static Intent zzd(Context context, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(50435);
        zzer.d("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        AppMethodBeat.o(50435);
        return intent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0089  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static OptionalPendingResult<GoogleSignInResult> zzd(GoogleApiClient googleApiClient, Context context, GoogleSignInOptions googleSignInOptions, boolean z) {
        Result googleSignInResult;
        AppMethodBeat.i(50438);
        zzer.d("silentSignIn()", new Object[0]);
        zzer.d("getEligibleSavedSignInResult()", new Object[0]);
        Preconditions.checkNotNull(googleSignInOptions);
        GoogleSignInOptions zzp = zzq.zze(context).zzp();
        if (zzp != null) {
            Account account = zzp.getAccount();
            Account account2 = googleSignInOptions.getAccount();
            boolean equals = account == null ? account2 == null : account.equals(account2);
            if (equals && !googleSignInOptions.isServerAuthCodeRequested() && ((!googleSignInOptions.isIdTokenRequested() || (zzp.isIdTokenRequested() && googleSignInOptions.getServerClientId().equals(zzp.getServerClientId()))) && new HashSet(zzp.getScopes()).containsAll(new HashSet(googleSignInOptions.getScopes())))) {
                GoogleSignInAccount zzo = zzq.zze(context).zzo();
                if (!(zzo == null || zzo.isExpired())) {
                    googleSignInResult = new GoogleSignInResult(zzo, Status.RESULT_SUCCESS);
                    OptionalPendingResult immediatePendingResult;
                    if (googleSignInResult == null) {
                        zzer.d("Eligible saved sign in result found", new Object[0]);
                        immediatePendingResult = PendingResults.immediatePendingResult(googleSignInResult, googleApiClient);
                        AppMethodBeat.o(50438);
                        return immediatePendingResult;
                    } else if (z) {
                        immediatePendingResult = PendingResults.immediatePendingResult(new GoogleSignInResult(null, new Status(4)), googleApiClient);
                        AppMethodBeat.o(50438);
                        return immediatePendingResult;
                    } else {
                        zzer.d("trySilentSignIn()", new Object[0]);
                        OptionalPendingResultImpl optionalPendingResultImpl = new OptionalPendingResultImpl(googleApiClient.enqueue(new zzj(googleApiClient, context, googleSignInOptions)));
                        AppMethodBeat.o(50438);
                        return optionalPendingResultImpl;
                    }
                }
            }
        }
        googleSignInResult = null;
        if (googleSignInResult == null) {
        }
    }

    public static PendingResult<Status> zzd(GoogleApiClient googleApiClient, Context context, boolean z) {
        AppMethodBeat.i(50439);
        zzer.d("Signing out", new Object[0]);
        zzd(context);
        if (z) {
            PendingResult immediatePendingResult = PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, googleApiClient);
            AppMethodBeat.o(50439);
            return immediatePendingResult;
        }
        ApiMethodImpl execute = googleApiClient.execute(new zzl(googleApiClient));
        AppMethodBeat.o(50439);
        return execute;
    }

    private static void zzd(Context context) {
        AppMethodBeat.i(50441);
        zzq.zze(context).clear();
        for (GoogleApiClient maybeSignOut : GoogleApiClient.getAllClients()) {
            maybeSignOut.maybeSignOut();
        }
        GoogleApiManager.reportSignOut();
        AppMethodBeat.o(50441);
    }

    public static Intent zze(Context context, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(50436);
        zzer.d("getFallbackSignInIntent()", new Object[0]);
        Intent zzd = zzd(context, googleSignInOptions);
        zzd.setAction("com.google.android.gms.auth.APPAUTH_SIGN_IN");
        AppMethodBeat.o(50436);
        return zzd;
    }

    public static PendingResult<Status> zze(GoogleApiClient googleApiClient, Context context, boolean z) {
        AppMethodBeat.i(50440);
        zzer.d("Revoking access", new Object[0]);
        String savedRefreshToken = Storage.getInstance(context).getSavedRefreshToken();
        zzd(context);
        if (z) {
            PendingResult zzg = zze.zzg(savedRefreshToken);
            AppMethodBeat.o(50440);
            return zzg;
        }
        ApiMethodImpl execute = googleApiClient.execute(new zzn(googleApiClient));
        AppMethodBeat.o(50440);
        return execute;
    }

    public static Intent zzf(Context context, GoogleSignInOptions googleSignInOptions) {
        AppMethodBeat.i(50437);
        zzer.d("getNoImplementationSignInIntent()", new Object[0]);
        Intent zzd = zzd(context, googleSignInOptions);
        zzd.setAction("com.google.android.gms.auth.NO_IMPL");
        AppMethodBeat.o(50437);
        return zzd;
    }
}
