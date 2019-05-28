package com.tencent.mm.kiss.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public ConcurrentHashMap<String, LinkedList<f>> eNi = new ConcurrentHashMap();

    public b() {
        AppMethodBeat.i(105691);
        AppMethodBeat.o(105691);
    }

    public final synchronized void a(f fVar) {
        AppMethodBeat.i(105692);
        if (fVar == null || fVar.eNM == null) {
            AppMethodBeat.o(105692);
        } else {
            LinkedList linkedList = (LinkedList) this.eNi.get(fVar.eNM.toString());
            if (linkedList == null) {
                linkedList = new LinkedList();
            }
            linkedList.add(fVar);
            this.eNi.put(fVar.eNM.toString(), linkedList);
            AppMethodBeat.o(105692);
        }
    }

    public final synchronized f u(CharSequence charSequence) {
        f fVar;
        AppMethodBeat.i(105693);
        LinkedList linkedList = (LinkedList) this.eNi.get(charSequence.toString());
        if (linkedList == null || linkedList.size() == 0) {
            fVar = null;
            AppMethodBeat.o(105693);
        } else {
            fVar = (f) linkedList.removeFirst();
            AppMethodBeat.o(105693);
        }
        return fVar;
    }
}
