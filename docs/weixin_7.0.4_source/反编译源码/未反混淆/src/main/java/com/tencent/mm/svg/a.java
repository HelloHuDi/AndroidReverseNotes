package com.tencent.mm.svg;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

final class a<T> {
    private HashMap<Looper, LinkedList<T>> ycD = new HashMap();
    private Queue<T> ycE = new ArrayDeque();

    a() {
        AppMethodBeat.i(70053);
        AppMethodBeat.o(70053);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized T dvC() {
        T t;
        AppMethodBeat.i(70054);
        t = null;
        if (this.ycE.size() != 0) {
            t = this.ycE.poll();
        }
        AppMethodBeat.o(70054);
        return t;
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void a(Looper looper, T t) {
        LinkedList linkedList;
        AppMethodBeat.i(70055);
        if (this.ycD.containsKey(looper)) {
            linkedList = (LinkedList) this.ycD.get(looper);
        } else {
            linkedList = new LinkedList();
            this.ycD.put(looper, linkedList);
        }
        if (linkedList.size() < 20) {
            linkedList.add(t);
        }
        AppMethodBeat.o(70055);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized void e(Looper looper) {
        AppMethodBeat.i(70056);
        if (this.ycD.containsKey(looper)) {
            LinkedList linkedList = (LinkedList) this.ycD.remove(looper);
            if (this.ycE.size() < 40) {
                this.ycE.addAll(linkedList);
            }
        }
        AppMethodBeat.o(70056);
    }
}
