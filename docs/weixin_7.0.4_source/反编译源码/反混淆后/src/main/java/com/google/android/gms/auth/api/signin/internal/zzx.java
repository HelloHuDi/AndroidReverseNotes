package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.os.Binder;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzx extends zzs {
    private final Context mContext;

    public zzx(Context context) {
        this.mContext = context;
    }

    private final void zzs() {
        AppMethodBeat.m2504i(50461);
        if (GooglePlayServicesUtilLight.isGooglePlayServicesUid(this.mContext, Binder.getCallingUid())) {
            AppMethodBeat.m2505o(50461);
            return;
        }
        SecurityException securityException = new SecurityException("Calling UID " + Binder.getCallingUid() + " is not Google Play services.");
        AppMethodBeat.m2505o(50461);
        throw securityException;
    }

    public final void zzq() {
        AppMethodBeat.m2504i(50459);
        zzs();
        Storage instance = Storage.getInstance(this.mContext);
        GoogleSignInAccount savedDefaultGoogleSignInAccount = instance.getSavedDefaultGoogleSignInAccount();
        HasOptions hasOptions = GoogleSignInOptions.DEFAULT_SIGN_IN;
        if (savedDefaultGoogleSignInAccount != null) {
            hasOptions = instance.getSavedDefaultGoogleSignInOptions();
        }
        GoogleApiClient build = new Builder(this.mContext).addApi(Auth.GOOGLE_SIGN_IN_API, hasOptions).build();
        try {
            if (build.blockingConnect().isSuccess()) {
                if (savedDefaultGoogleSignInAccount != null) {
                    Auth.GoogleSignInApi.revokeAccess(build);
                } else {
                    build.clearDefaultAccountAndReconnect();
                }
            }
            build.disconnect();
            AppMethodBeat.m2505o(50459);
        } catch (Throwable th) {
            build.disconnect();
            AppMethodBeat.m2505o(50459);
        }
    }

    public final void zzr() {
        AppMethodBeat.m2504i(50460);
        zzs();
        zzq.zze(this.mContext).clear();
        AppMethodBeat.m2505o(50460);
    }
}
