package com.tencent.mm.plugin.cdndownloader.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;

public final class a<E> extends HashSet<E> {
    private b ktx;

    public a(b bVar) {
        this.ktx = bVar;
    }

    private synchronized void beY() {
        AppMethodBeat.i(932);
        this.ktx.beX();
        AppMethodBeat.o(932);
    }

    private synchronized void beZ() {
        AppMethodBeat.i(933);
        this.ktx.remove();
        AppMethodBeat.o(933);
    }

    private synchronized void bfa() {
        AppMethodBeat.i(934);
        this.ktx.clear();
        AppMethodBeat.o(934);
    }

    public final synchronized boolean add(E e) {
        boolean add;
        AppMethodBeat.i(935);
        add = super.add(e);
        beY();
        AppMethodBeat.o(935);
        return add;
    }

    public final void clear() {
        AppMethodBeat.i(936);
        super.clear();
        bfa();
        AppMethodBeat.o(936);
    }

    public final synchronized boolean remove(Object obj) {
        boolean remove;
        AppMethodBeat.i(937);
        remove = super.remove(obj);
        beZ();
        AppMethodBeat.o(937);
        return remove;
    }
}
