package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final /* synthetic */ class zza implements Comparator {
    static final Comparator zzq = new zza();

    static {
        AppMethodBeat.m2504i(60408);
        AppMethodBeat.m2505o(60408);
    }

    private zza() {
    }

    public final int compare(Object obj, Object obj2) {
        AppMethodBeat.m2504i(60407);
        int zza = GoogleSignInAccount.zza((Scope) obj, (Scope) obj2);
        AppMethodBeat.m2505o(60407);
        return zza;
    }
}
