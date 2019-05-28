package com.tencent.p177mm.loader.p1641i;

import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: com.tencent.mm.loader.i.a */
public final class C45424a<E> extends LinkedBlockingDeque<E> {
    public final boolean offer(E e) {
        return super.offerFirst(e);
    }

    public final E remove() {
        return super.removeFirst();
    }
}
