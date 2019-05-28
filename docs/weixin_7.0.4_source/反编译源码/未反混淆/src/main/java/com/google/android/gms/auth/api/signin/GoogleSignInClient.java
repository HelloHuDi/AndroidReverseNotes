package com.google.android.gms.auth.api.signin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.internal.zzi;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.PendingResultUtil.ResultConverter;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.tasks.Task;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleSignInClient extends GoogleApi<GoogleSignInOptions> {
    private static final zzd zzef = new zzd();
    @VisibleForTesting
    private static int zzeg = zze.zzei;

    @VisibleForTesting
    enum zze {
        public static final int zzei = 1;
        public static final int zzej = 2;
        public static final int zzek = 3;
        public static final int zzel = 4;
        private static final /* synthetic */ int[] zzem = new int[]{zzei, zzej, zzek, zzel};

        public static int[] values$50KLMJ33DTMIUPRFDTJMOP9FC5N68SJFD5I2UPRDECNM2TBKD0NM2S395TPMIPRED5N2UHRFDTJMOPAJD5JMSIBE8DM6IPBEEGI4IRBGDHIMQPBEEHGN8QBFDOTG____0() {
            AppMethodBeat.i(50387);
            int[] iArr = (int[]) zzem.clone();
            AppMethodBeat.o(50387);
            return iArr;
        }
    }

    static class zzd implements ResultConverter<GoogleSignInResult, GoogleSignInAccount> {
        private zzd() {
        }

        /* synthetic */ zzd(zzd zzd) {
            this();
        }

        public final /* synthetic */ Object convert(Result result) {
            AppMethodBeat.i(50386);
            GoogleSignInAccount signInAccount = ((GoogleSignInResult) result).getSignInAccount();
            AppMethodBeat.o(50386);
            return signInAccount;
        }
    }

    static {
        AppMethodBeat.i(50395);
        AppMethodBeat.o(50395);
    }

    GoogleSignInClient(Activity activity, GoogleSignInOptions googleSignInOptions) {
        super(activity, Auth.GOOGLE_SIGN_IN_API, (ApiOptions) googleSignInOptions, new ApiExceptionMapper());
        AppMethodBeat.i(50389);
        AppMethodBeat.o(50389);
    }

    GoogleSignInClient(Context context, GoogleSignInOptions googleSignInOptions) {
        super(context, Auth.GOOGLE_SIGN_IN_API, (ApiOptions) googleSignInOptions, new ApiExceptionMapper());
        AppMethodBeat.i(50388);
        AppMethodBeat.o(50388);
    }

    private final synchronized int zzl() {
        int i;
        AppMethodBeat.i(50390);
        if (zzeg == zze.zzei) {
            Context applicationContext = getApplicationContext();
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            int isGooglePlayServicesAvailable = instance.isGooglePlayServicesAvailable(applicationContext, 12451000);
            if (isGooglePlayServicesAvailable == 0) {
                zzeg = zze.zzel;
            } else if (instance.getErrorResolutionIntent(applicationContext, isGooglePlayServicesAvailable, null) != null || DynamiteModule.getLocalVersion(applicationContext, "com.google.android.gms.auth.api.fallback") == 0) {
                zzeg = zze.zzej;
            } else {
                zzeg = zze.zzek;
            }
        }
        i = zzeg;
        AppMethodBeat.o(50390);
        return i;
    }

    public Intent getSignInIntent() {
        AppMethodBeat.i(50391);
        Context applicationContext = getApplicationContext();
        Intent zze;
        switch (zzd.zzeh[zzl() - 1]) {
            case 1:
                zze = zzi.zze(applicationContext, (GoogleSignInOptions) getApiOptions());
                AppMethodBeat.o(50391);
                return zze;
            case 2:
                zze = zzi.zzd(applicationContext, (GoogleSignInOptions) getApiOptions());
                AppMethodBeat.o(50391);
                return zze;
            default:
                zze = zzi.zzf(applicationContext, (GoogleSignInOptions) getApiOptions());
                AppMethodBeat.o(50391);
                return zze;
        }
    }

    public Task<Void> revokeAccess() {
        AppMethodBeat.i(50394);
        Task toVoidTask = PendingResultUtil.toVoidTask(zzi.zze(asGoogleApiClient(), getApplicationContext(), zzl() == zze.zzek));
        AppMethodBeat.o(50394);
        return toVoidTask;
    }

    public Task<Void> signOut() {
        AppMethodBeat.i(50393);
        Task toVoidTask = PendingResultUtil.toVoidTask(zzi.zzd(asGoogleApiClient(), getApplicationContext(), zzl() == zze.zzek));
        AppMethodBeat.o(50393);
        return toVoidTask;
    }

    public Task<GoogleSignInAccount> silentSignIn() {
        AppMethodBeat.i(50392);
        Task toTask = PendingResultUtil.toTask(zzi.zzd(asGoogleApiClient(), getApplicationContext(), (GoogleSignInOptions) getApiOptions(), zzl() == zze.zzek), zzef);
        AppMethodBeat.o(50392);
        return toTask;
    }
}
