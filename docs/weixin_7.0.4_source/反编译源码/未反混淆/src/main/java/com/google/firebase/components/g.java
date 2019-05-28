package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
public final class g extends h {
    private final List<a<?>> buZ;

    @KeepForSdk
    public g(List<a<?>> list) {
        String str = "Dependency cycle detected: ";
        String valueOf = String.valueOf(Arrays.toString(list.toArray()));
        super(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        AppMethodBeat.i(10614);
        this.buZ = list;
        AppMethodBeat.o(10614);
    }
}
