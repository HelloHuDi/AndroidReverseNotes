package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public final class mg implements lz {
    private LinkedList<lz> a;
    private volatile boolean b;
    private final ReentrantLock c = new ReentrantLock();

    public mg() {
        AppMethodBeat.i(100505);
        AppMethodBeat.o(100505);
    }

    public final boolean a() {
        return this.b;
    }

    public final void b() {
        AppMethodBeat.i(100506);
        if (!this.b) {
            this.c.lock();
            try {
                if (!this.b) {
                    this.b = true;
                    LinkedList linkedList = this.a;
                    this.a = null;
                    this.c.unlock();
                    a(linkedList);
                } else {
                    return;
                }
            } finally {
                this.c.unlock();
                AppMethodBeat.o(100506);
            }
        }
        AppMethodBeat.o(100506);
    }

    private static void a(Collection<lz> collection) {
        AppMethodBeat.i(100507);
        if (collection == null) {
            AppMethodBeat.o(100507);
            return;
        }
        List list = null;
        for (lz b : collection) {
            try {
                b.b();
            } catch (Throwable th) {
                List arrayList;
                if (list == null) {
                    arrayList = new ArrayList();
                } else {
                    arrayList = list;
                }
                arrayList.add(th);
                list = arrayList;
            }
        }
        mb.a(list);
        AppMethodBeat.o(100507);
    }
}
