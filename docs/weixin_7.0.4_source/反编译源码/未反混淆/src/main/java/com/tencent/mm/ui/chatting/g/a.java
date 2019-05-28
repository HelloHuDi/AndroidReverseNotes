package com.tencent.mm.ui.chatting.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.chatting.c.v;
import com.tencent.mm.ui.chatting.c.w;
import java.util.HashMap;

public final class a {
    private com.tencent.mm.ui.chatting.d.a cgL;
    public HashMap<Class<?>, v> yYL = new HashMap();

    public a(com.tencent.mm.ui.chatting.d.a aVar) {
        AppMethodBeat.i(32492);
        this.cgL = aVar;
        AppMethodBeat.o(32492);
    }

    public final <T extends v, V extends Class<T>> T aF(V v) {
        AppMethodBeat.i(32493);
        if (!v.isInterface()) {
            RuntimeException runtimeException = new RuntimeException("[get] " + v + " is not a interface!");
            AppMethodBeat.o(32493);
            throw runtimeException;
        } else if (this.yYL.containsKey(v)) {
            v vVar = (v) this.yYL.get(v);
            AppMethodBeat.o(32493);
            return vVar;
        } else {
            AppMethodBeat.o(32493);
            return null;
        }
    }

    public final void a(Class<? extends v> cls, v vVar) {
        AppMethodBeat.i(32494);
        if (this.yYL.put(cls, vVar) != null) {
            ab.w("MicroMsg.ChattingComponentManager", "[register] %s has register", cls);
        }
        if (vVar instanceof w) {
            long currentTimeMillis = System.currentTimeMillis();
            ((w) vVar).a(this.cgL);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            ab.i("MicroMsg.ChattingComponentManager", "[install] listener:%s cost:%sms", vVar.getClass().getName(), Long.valueOf(currentTimeMillis2));
        }
        AppMethodBeat.o(32494);
    }
}
