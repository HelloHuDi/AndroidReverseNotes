package com.google.android.gms.dynamic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class zza implements OnDelegateCreatedListener<T> {
    private final /* synthetic */ DeferredLifecycleHelper zzabg;

    zza(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.zzabg = deferredLifecycleHelper;
    }

    public final void onDelegateCreated(T t) {
        AppMethodBeat.m2504i(61635);
        this.zzabg.zzabc = t;
        Iterator it = this.zzabg.zzabe.iterator();
        while (it.hasNext()) {
            ((zza) it.next()).zza(this.zzabg.zzabc);
        }
        this.zzabg.zzabe.clear();
        this.zzabg.zzabd = null;
        AppMethodBeat.m2505o(61635);
    }
}
