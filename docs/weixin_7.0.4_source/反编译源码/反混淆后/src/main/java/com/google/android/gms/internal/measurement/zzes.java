package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class zzes implements Iterator<String> {
    private Iterator<String> zzafz = this.zzaga.zzafy.keySet().iterator();
    private final /* synthetic */ zzer zzaga;

    zzes(zzer zzer) {
        this.zzaga = zzer;
        AppMethodBeat.m2504i(68740);
        AppMethodBeat.m2505o(68740);
    }

    public final boolean hasNext() {
        AppMethodBeat.m2504i(68741);
        boolean hasNext = this.zzafz.hasNext();
        AppMethodBeat.m2505o(68741);
        return hasNext;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.m2504i(68743);
        String str = (String) this.zzafz.next();
        AppMethodBeat.m2505o(68743);
        return str;
    }

    public final void remove() {
        AppMethodBeat.m2504i(68742);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Remove not supported");
        AppMethodBeat.m2505o(68742);
        throw unsupportedOperationException;
    }
}
