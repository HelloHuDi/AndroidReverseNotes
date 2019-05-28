package com.tencent.p177mm.svg;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.svg.a */
final class C5155a<T> {
    private HashMap<Looper, LinkedList<T>> ycD = new HashMap();
    private Queue<T> ycE = new ArrayDeque();

    C5155a() {
        AppMethodBeat.m2504i(70053);
        AppMethodBeat.m2505o(70053);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    public final synchronized T dvC() {
        T t;
        AppMethodBeat.m2504i(70054);
        t = null;
        if (this.ycE.size() != 0) {
            t = this.ycE.poll();
        }
        AppMethodBeat.m2505o(70054);
        return t;
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo10614a(Looper looper, T t) {
        LinkedList linkedList;
        AppMethodBeat.m2504i(70055);
        if (this.ycD.containsKey(looper)) {
            linkedList = (LinkedList) this.ycD.get(looper);
        } else {
            linkedList = new LinkedList();
            this.ycD.put(looper, linkedList);
        }
        if (linkedList.size() < 20) {
            linkedList.add(t);
        }
        AppMethodBeat.m2505o(70055);
    }

    /* Access modifiers changed, original: protected|final|declared_synchronized */
    /* renamed from: e */
    public final synchronized void mo10616e(Looper looper) {
        AppMethodBeat.m2504i(70056);
        if (this.ycD.containsKey(looper)) {
            LinkedList linkedList = (LinkedList) this.ycD.remove(looper);
            if (this.ycE.size() < 40) {
                this.ycE.addAll(linkedList);
            }
        }
        AppMethodBeat.m2505o(70056);
    }
}
