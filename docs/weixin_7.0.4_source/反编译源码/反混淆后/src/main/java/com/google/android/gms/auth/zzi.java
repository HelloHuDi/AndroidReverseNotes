package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzi implements zzm<Void> {
    private final /* synthetic */ Bundle val$extras;
    private final /* synthetic */ String zzt;

    zzi(String str, Bundle bundle) {
        this.zzt = str;
        this.val$extras = bundle;
    }

    public final /* synthetic */ Object zze(IBinder iBinder) {
        AppMethodBeat.m2504i(77075);
        Bundle bundle = (Bundle) zzg.zze(com.google.android.gms.internal.auth.zzi.zzd(iBinder).zzd(this.zzt, this.val$extras));
        String string = bundle.getString("Error");
        if (bundle.getBoolean("booleanResult")) {
            AppMethodBeat.m2505o(77075);
            return null;
        }
        GoogleAuthException googleAuthException = new GoogleAuthException(string);
        AppMethodBeat.m2505o(77075);
        throw googleAuthException;
    }
}
