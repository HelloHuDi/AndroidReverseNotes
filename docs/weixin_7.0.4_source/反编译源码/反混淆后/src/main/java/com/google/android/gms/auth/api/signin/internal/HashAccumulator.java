package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class HashAccumulator {
    @VisibleForTesting
    private static int zzad = 31;
    private int zzae = 1;

    public HashAccumulator addBoolean(boolean z) {
        this.zzae = (z ? 1 : 0) + (this.zzae * zzad);
        return this;
    }

    public HashAccumulator addObject(Object obj) {
        AppMethodBeat.m2504i(60389);
        this.zzae = (obj == null ? 0 : obj.hashCode()) + (this.zzae * zzad);
        AppMethodBeat.m2505o(60389);
        return this;
    }

    public int hash() {
        return this.zzae;
    }
}
