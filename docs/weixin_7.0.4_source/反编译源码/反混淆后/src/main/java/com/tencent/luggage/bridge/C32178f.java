package com.tencent.luggage.bridge;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.luggage.bridge.f */
public final class C32178f {
    private C25684s bOo;
    LinkedList<C45118e> bOp = new LinkedList();
    boolean bOq = false;

    C32178f(C25684s c25684s) {
        AppMethodBeat.m2504i(90719);
        this.bOo = c25684s;
        AppMethodBeat.m2505o(90719);
    }

    /* renamed from: a */
    public final synchronized void mo52820a(C45118e c45118e) {
        AppMethodBeat.m2504i(90720);
        if (this.bOq) {
            m52476b(c45118e);
            AppMethodBeat.m2505o(90720);
        } else {
            this.bOp.add(c45118e);
            AppMethodBeat.m2505o(90720);
        }
    }

    /* renamed from: b */
    private void m52476b(C45118e c45118e) {
        AppMethodBeat.m2504i(90721);
        this.bOo.mo43469by(String.format("luggageBridge._processMessageFromJava(%s);", new Object[]{c45118e.toString()}));
        AppMethodBeat.m2505o(90721);
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: wL */
    public final synchronized void mo52821wL() {
        AppMethodBeat.m2504i(90722);
        C45124d.m82929i("Java2JsMessageQueue", "ready");
        this.bOq = true;
        Iterator it = this.bOp.iterator();
        while (it.hasNext()) {
            m52476b((C45118e) it.next());
        }
        this.bOp.clear();
        AppMethodBeat.m2505o(90722);
    }
}
