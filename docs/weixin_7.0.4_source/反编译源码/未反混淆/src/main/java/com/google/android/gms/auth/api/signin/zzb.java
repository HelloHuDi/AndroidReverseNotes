package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Scope;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;

final class zzb implements Comparator<Scope> {
    zzb() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        AppMethodBeat.i(60409);
        int compareTo = ((Scope) obj).getScopeUri().compareTo(((Scope) obj2).getScopeUri());
        AppMethodBeat.o(60409);
        return compareTo;
    }
}
