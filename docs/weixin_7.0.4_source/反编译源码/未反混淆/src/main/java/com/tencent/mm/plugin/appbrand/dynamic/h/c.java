package com.tencent.mm.plugin.appbrand.dynamic.h;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.ipcinvoker.a;
import com.tencent.mm.ipcinvoker.e;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.sdk.platformtools.ab;

public class c implements a<Bundle, Bundle> {
    public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
        AppMethodBeat.i(10954);
        BaseIPCService lj = h.PO().lj(e.PN());
        if (lj != null) {
            ab.i("MicroMsg.IPCInvokeTask_KillAllProcess", "killSelf process(%s)", r0);
            lj.ci(true);
        }
        AppMethodBeat.o(10954);
    }
}
