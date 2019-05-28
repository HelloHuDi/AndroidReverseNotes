package com.tencent.p177mm.plugin.wear.model.p575e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.wear.model.e.q */
public final class C46395q {
    public HashMap<Integer, C46394a> tYL = new HashMap();

    public C46395q() {
        AppMethodBeat.m2504i(26426);
        AppMethodBeat.m2505o(26426);
    }

    /* renamed from: a */
    public final void mo74594a(C46394a c46394a) {
        AppMethodBeat.m2504i(26427);
        for (Integer intValue : c46394a.cUA()) {
            C4990ab.m7411d("MicroMsg.Wear.WearHttpServerLogic", "add funId %d %s", Integer.valueOf(intValue.intValue()), c46394a);
            this.tYL.put(Integer.valueOf(r0), c46394a);
        }
        AppMethodBeat.m2505o(26427);
    }

    /* renamed from: HL */
    public final C46394a mo74593HL(int i) {
        AppMethodBeat.m2504i(26428);
        C46394a c46394a = (C46394a) this.tYL.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(26428);
        return c46394a;
    }
}
