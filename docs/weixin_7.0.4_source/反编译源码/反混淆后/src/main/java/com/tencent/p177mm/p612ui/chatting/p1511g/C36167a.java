package com.tencent.p177mm.p612ui.chatting.p1511g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.chatting.p1670d.C46650a;
import com.tencent.p177mm.p612ui.chatting.p616c.C5326v;
import com.tencent.p177mm.p612ui.chatting.p616c.C5327w;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.ui.chatting.g.a */
public final class C36167a {
    private C46650a cgL;
    public HashMap<Class<?>, C5326v> yYL = new HashMap();

    public C36167a(C46650a c46650a) {
        AppMethodBeat.m2504i(32492);
        this.cgL = c46650a;
        AppMethodBeat.m2505o(32492);
    }

    /* renamed from: aF */
    public final <T extends C5326v, V extends Class<T>> T mo57059aF(V v) {
        AppMethodBeat.m2504i(32493);
        if (!v.isInterface()) {
            RuntimeException runtimeException = new RuntimeException("[get] " + v + " is not a interface!");
            AppMethodBeat.m2505o(32493);
            throw runtimeException;
        } else if (this.yYL.containsKey(v)) {
            C5326v c5326v = (C5326v) this.yYL.get(v);
            AppMethodBeat.m2505o(32493);
            return c5326v;
        } else {
            AppMethodBeat.m2505o(32493);
            return null;
        }
    }

    /* renamed from: a */
    public final void mo57058a(Class<? extends C5326v> cls, C5326v c5326v) {
        AppMethodBeat.m2504i(32494);
        if (this.yYL.put(cls, c5326v) != null) {
            C4990ab.m7421w("MicroMsg.ChattingComponentManager", "[register] %s has register", cls);
        }
        if (c5326v instanceof C5327w) {
            long currentTimeMillis = System.currentTimeMillis();
            ((C5327w) c5326v).mo10944a(this.cgL);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            C4990ab.m7417i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", c5326v.getClass().getName(), Long.valueOf(currentTimeMillis2));
        }
        AppMethodBeat.m2505o(32494);
    }
}
