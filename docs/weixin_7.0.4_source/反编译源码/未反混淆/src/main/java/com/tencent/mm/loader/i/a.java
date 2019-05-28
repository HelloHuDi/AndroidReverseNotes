package com.tencent.mm.loader.i;

import java.util.concurrent.LinkedBlockingDeque;

public final class a<E> extends LinkedBlockingDeque<E> {
    public final boolean offer(E e) {
        return super.offerFirst(e);
    }

    public final E remove() {
        return super.removeFirst();
    }
}
