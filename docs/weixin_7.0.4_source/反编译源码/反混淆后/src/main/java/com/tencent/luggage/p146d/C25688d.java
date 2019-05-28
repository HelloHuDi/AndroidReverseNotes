package com.tencent.luggage.p146d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.luggage.d.d */
public final class C25688d {
    final LinkedList<Class<? extends C37393a>> bPc = new LinkedList();

    public C25688d() {
        AppMethodBeat.m2504i(90770);
        AppMethodBeat.m2505o(90770);
    }

    /* renamed from: B */
    public final void mo43471B(List<Class<? extends C37393a>> list) {
        AppMethodBeat.m2504i(90771);
        for (Class add : list) {
            this.bPc.add(add);
        }
        AppMethodBeat.m2505o(90771);
    }
}
