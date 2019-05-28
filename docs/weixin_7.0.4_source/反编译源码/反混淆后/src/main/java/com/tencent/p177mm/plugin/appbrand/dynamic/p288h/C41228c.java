package com.tencent.p177mm.plugin.appbrand.dynamic.p288h;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.BaseIPCService;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.C37871h;
import com.tencent.p177mm.ipcinvoker.C9548e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.c */
public class C41228c implements C37866a<Bundle, Bundle> {
    /* renamed from: a */
    public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
        AppMethodBeat.m2504i(10954);
        BaseIPCService lj = C37871h.m63909PO().mo60593lj(C9548e.m17007PN());
        if (lj != null) {
            C4990ab.m7417i("MicroMsg.IPCInvokeTask_KillAllProcess", "killSelf process(%s)", r0);
            lj.mo33740ci(true);
        }
        AppMethodBeat.m2505o(10954);
    }
}
