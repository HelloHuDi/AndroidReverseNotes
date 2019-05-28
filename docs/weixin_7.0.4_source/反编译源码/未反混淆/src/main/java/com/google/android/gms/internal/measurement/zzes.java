package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

final class zzes implements Iterator<String> {
    private Iterator<String> zzafz = this.zzaga.zzafy.keySet().iterator();
    private final /* synthetic */ zzer zzaga;

    zzes(zzer zzer) {
        this.zzaga = zzer;
        AppMethodBeat.i(68740);
        AppMethodBeat.o(68740);
    }

    public final boolean hasNext() {
        AppMethodBeat.i(68741);
        boolean hasNext = this.zzafz.hasNext();
        AppMethodBeat.o(68741);
        return hasNext;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.i(68743);
        String str = (String) this.zzafz.next();
        AppMethodBeat.o(68743);
        return str;
    }

    public final void remove() {
        AppMethodBeat.i(68742);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Remove not supported");
        AppMethodBeat.o(68742);
        throw unsupportedOperationException;
    }
}
