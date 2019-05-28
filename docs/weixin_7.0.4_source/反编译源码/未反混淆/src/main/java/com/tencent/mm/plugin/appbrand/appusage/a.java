package com.tencent.mm.plugin.appbrand.appusage;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.kernel.g;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AddCall;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppIdentity;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
final class a implements i<AppIdentity, IPCInteger> {
    public final /* synthetic */ Object am(Object obj) {
        int i;
        AppMethodBeat.i(134489);
        AppIdentity appIdentity = (AppIdentity) obj;
        if (!g.RK() || appIdentity == null) {
            i = -1;
        } else {
            i = ((af) g.K(af.class)).aC(h.a(appIdentity), h.b(appIdentity));
        }
        IPCInteger iPCInteger = new IPCInteger(i);
        AppMethodBeat.o(134489);
        return iPCInteger;
    }
}
