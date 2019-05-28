package com.tencent.mm.at.a.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingDeque;

public final class a<E> extends LinkedBlockingDeque<E> {
    public final boolean offer(E e) {
        AppMethodBeat.i(116102);
        boolean offerFirst = super.offerFirst(e);
        AppMethodBeat.o(116102);
        return offerFirst;
    }

    public final E remove() {
        AppMethodBeat.i(116103);
        Object removeFirst = super.removeFirst();
        AppMethodBeat.o(116103);
        return removeFirst;
    }
}
