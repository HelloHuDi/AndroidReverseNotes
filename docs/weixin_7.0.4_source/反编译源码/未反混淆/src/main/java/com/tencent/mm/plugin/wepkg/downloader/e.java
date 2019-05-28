package com.tencent.mm.plugin.wepkg.downloader;

import java.util.concurrent.FutureTask;

public final class e<V> extends FutureTask<V> {
    c uWn;

    public e(Runnable runnable, V v, c cVar) {
        super(runnable, v);
        this.uWn = cVar;
    }
}
