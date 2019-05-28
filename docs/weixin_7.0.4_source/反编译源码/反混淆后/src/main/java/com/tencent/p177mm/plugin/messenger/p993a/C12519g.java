package com.tencent.p177mm.plugin.messenger.p993a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.pluginsdk.p1336a.C31481b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.messenger.a.g */
public final class C12519g {
    public static C28488d opT;

    public static C28488d bOk() {
        AppMethodBeat.m2504i(111118);
        if (opT == null) {
            opT = new C31481b();
        }
        if (opT instanceof C31481b) {
            C4990ab.m7420w("MicroMsg.SendMsgMgrFactory", "we are using dummy SendMsgMgr!!");
        }
        C28488d c28488d = opT;
        AppMethodBeat.m2505o(111118);
        return c28488d;
    }
}
