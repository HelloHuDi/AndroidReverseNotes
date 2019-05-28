package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
/* renamed from: com.google.firebase.components.g */
public final class C25582g extends C8743h {
    private final List<C41645a<?>> buZ;

    @KeepForSdk
    public C25582g(List<C41645a<?>> list) {
        String str = "Dependency cycle detected: ";
        String valueOf = String.valueOf(Arrays.toString(list.toArray()));
        super(valueOf.length() != 0 ? str.concat(valueOf) : new String(str));
        AppMethodBeat.m2504i(10614);
        this.buZ = list;
        AppMethodBeat.m2505o(10614);
    }
}
