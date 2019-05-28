package com.tencent.luggage.bridge;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

public final class f {
    private s bOo;
    LinkedList<e> bOp = new LinkedList();
    boolean bOq = false;

    f(s sVar) {
        AppMethodBeat.i(90719);
        this.bOo = sVar;
        AppMethodBeat.o(90719);
    }

    public final synchronized void a(e eVar) {
        AppMethodBeat.i(90720);
        if (this.bOq) {
            b(eVar);
            AppMethodBeat.o(90720);
        } else {
            this.bOp.add(eVar);
            AppMethodBeat.o(90720);
        }
    }

    private void b(e eVar) {
        AppMethodBeat.i(90721);
        this.bOo.by(String.format("luggageBridge._processMessageFromJava(%s);", new Object[]{eVar.toString()}));
        AppMethodBeat.o(90721);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void wL() {
        AppMethodBeat.i(90722);
        d.i("Java2JsMessageQueue", "ready");
        this.bOq = true;
        Iterator it = this.bOp.iterator();
        while (it.hasNext()) {
            b((e) it.next());
        }
        this.bOp.clear();
        AppMethodBeat.o(90722);
    }
}
