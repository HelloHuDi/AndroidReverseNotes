package com.google.android.gms.security;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.security.ProviderInstaller.ProviderInstallListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zza extends AsyncTask<Void, Void, Integer> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ ProviderInstallListener zzacy;

    zza(Context context, ProviderInstallListener providerInstallListener) {
        this.val$context = context;
        this.zzacy = providerInstallListener;
    }

    private final Integer zza(Void... voidArr) {
        AppMethodBeat.m2504i(90506);
        Integer valueOf;
        try {
            ProviderInstaller.installIfNeeded(this.val$context);
            valueOf = Integer.valueOf(0);
            AppMethodBeat.m2505o(90506);
            return valueOf;
        } catch (GooglePlayServicesRepairableException e) {
            valueOf = Integer.valueOf(e.getConnectionStatusCode());
            AppMethodBeat.m2505o(90506);
            return valueOf;
        } catch (GooglePlayServicesNotAvailableException e2) {
            valueOf = Integer.valueOf(e2.errorCode);
            AppMethodBeat.m2505o(90506);
            return valueOf;
        }
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        AppMethodBeat.m2504i(90508);
        Integer zza = zza((Void[]) objArr);
        AppMethodBeat.m2505o(90508);
        return zza;
    }

    /* Access modifiers changed, original: protected|final|synthetic */
    public final /* synthetic */ void onPostExecute(Object obj) {
        AppMethodBeat.m2504i(90507);
        Integer num = (Integer) obj;
        if (num.intValue() == 0) {
            this.zzacy.onProviderInstalled();
            AppMethodBeat.m2505o(90507);
            return;
        }
        this.zzacy.onProviderInstallFailed(num.intValue(), ProviderInstaller.zzacw.getErrorResolutionIntent(this.val$context, num.intValue(), "pi"));
        AppMethodBeat.m2505o(90507);
    }
}
