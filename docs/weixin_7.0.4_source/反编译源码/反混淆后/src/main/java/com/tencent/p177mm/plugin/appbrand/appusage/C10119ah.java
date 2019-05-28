package com.tencent.p177mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45413i;
import com.tencent.p177mm.ipcinvoker.type.IPCBoolean;
import com.tencent.p177mm.kernel.C1720g;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0002¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/appusage/IsCall;", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/appusage/AppIdentity;", "Lcom/tencent/mm/ipcinvoker/type/IPCBoolean;", "()V", "invoke", "data", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.appusage.ah */
final class C10119ah implements C45413i<AppIdentity, IPCBoolean> {
    /* renamed from: am */
    public final /* synthetic */ Object mo4785am(Object obj) {
        boolean z;
        AppMethodBeat.m2504i(134559);
        AppIdentity appIdentity = (AppIdentity) obj;
        if (!C1720g.m3531RK() || appIdentity == null) {
            z = false;
        } else {
            z = ((C10118af) C1720g.m3528K(C10118af.class)).mo21471aB(C38130h.m64523a(appIdentity), C38130h.m64524b(appIdentity));
        }
        IPCBoolean iPCBoolean = new IPCBoolean(z);
        AppMethodBeat.m2505o(134559);
        return iPCBoolean;
    }
}
