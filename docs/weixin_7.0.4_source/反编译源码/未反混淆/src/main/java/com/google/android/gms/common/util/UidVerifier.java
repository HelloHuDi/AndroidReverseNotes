package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.wrappers.Wrappers;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class UidVerifier {
    private UidVerifier() {
    }

    public static boolean isGooglePlayServicesUid(Context context, int i) {
        boolean z = false;
        AppMethodBeat.i(90276);
        if (uidHasPackageName(context, i, "com.google.android.gms")) {
            try {
                z = GoogleSignatureVerifier.getInstance(context).isGooglePublicSignedPackage(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
                AppMethodBeat.o(90276);
                return z;
            } catch (NameNotFoundException e) {
                Log.isLoggable("UidVerifier", 3);
                AppMethodBeat.o(90276);
                return z;
            }
        }
        AppMethodBeat.o(90276);
        return z;
    }

    @TargetApi(19)
    public static boolean uidHasPackageName(Context context, int i, String str) {
        AppMethodBeat.i(90277);
        boolean uidHasPackageName = Wrappers.packageManager(context).uidHasPackageName(i, str);
        AppMethodBeat.o(90277);
        return uidHasPackageName;
    }
}
