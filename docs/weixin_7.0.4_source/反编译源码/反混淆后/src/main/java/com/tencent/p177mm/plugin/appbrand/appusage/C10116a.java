package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.type.IPCInteger;
import com.tencent.p177mm.kernel.C1720g;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/AddCall;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppIdentity;", "Lcom/tencent/mm/ipcinvoker/type/IPCInteger;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.a */
final class C10116a implements C45413i<AppIdentity, IPCInteger> {
    /* renamed from: am */
    public final /* synthetic */ Object mo4785am(Object obj) {
        int i;
        AppMethodBeat.m2504i(134489);
        AppIdentity appIdentity = (AppIdentity) obj;
        if (!C1720g.m3531RK() || appIdentity == null) {
            i = -1;
        } else {
            i = ((C10118af) C1720g.m3528K(C10118af.class)).mo21472aC(C38130h.m64523a(appIdentity), C38130h.m64524b(appIdentity));
        }
        IPCInteger iPCInteger = new IPCInteger(i);
        AppMethodBeat.m2505o(134489);
        return iPCInteger;
    }
}
