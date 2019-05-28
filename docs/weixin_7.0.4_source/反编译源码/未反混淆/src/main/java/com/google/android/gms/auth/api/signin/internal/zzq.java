package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzq {
    private static zzq zzfa = null;
    @VisibleForTesting
    private Storage zzfb;
    @VisibleForTesting
    private GoogleSignInAccount zzfc = this.zzfb.getSavedDefaultGoogleSignInAccount();
    @VisibleForTesting
    private GoogleSignInOptions zzfd = this.zzfb.getSavedDefaultGoogleSignInOptions();

    private zzq(Context context) {
        AppMethodBeat.i(50451);
        this.zzfb = Storage.getInstance(context);
        AppMethodBeat.o(50451);
    }

    public static synchronized zzq zze(Context context) {
        zzq zzf;
        synchronized (zzq.class) {
            AppMethodBeat.i(50452);
            zzf = zzf(context.getApplicationContext());
            AppMethodBeat.o(50452);
        }
        return zzf;
    }

    private static synchronized zzq zzf(Context context) {
        zzq zzq;
        synchronized (zzq.class) {
            AppMethodBeat.i(50453);
            if (zzfa == null) {
                zzfa = new zzq(context);
            }
            zzq = zzfa;
            AppMethodBeat.o(50453);
        }
        return zzq;
    }

    public final synchronized void clear() {
        AppMethodBeat.i(50454);
        this.zzfb.clear();
        this.zzfc = null;
        this.zzfd = null;
        AppMethodBeat.o(50454);
    }

    public final synchronized void zzd(GoogleSignInOptions googleSignInOptions, GoogleSignInAccount googleSignInAccount) {
        AppMethodBeat.i(50455);
        this.zzfb.saveDefaultGoogleSignInAccount(googleSignInAccount, googleSignInOptions);
        this.zzfc = googleSignInAccount;
        this.zzfd = googleSignInOptions;
        AppMethodBeat.o(50455);
    }

    public final synchronized GoogleSignInAccount zzo() {
        return this.zzfc;
    }

    public final synchronized GoogleSignInOptions zzp() {
        return this.zzfd;
    }
}
