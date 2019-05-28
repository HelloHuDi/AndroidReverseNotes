package com.tencent.p177mm.p190at.p191a.p1592e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: com.tencent.mm.at.a.e.a */
public final class C41760a<E> extends LinkedBlockingDeque<E> {
    public final boolean offer(E e) {
        AppMethodBeat.m2504i(116102);
        boolean offerFirst = super.offerFirst(e);
        AppMethodBeat.m2505o(116102);
        return offerFirst;
    }

    public final E remove() {
        AppMethodBeat.m2504i(116103);
        Object removeFirst = super.removeFirst();
        AppMethodBeat.m2505o(116103);
        return removeFirst;
    }
}
