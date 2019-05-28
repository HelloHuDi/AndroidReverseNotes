package com.tencent.p177mm.plugin.expt.p395c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;

/* renamed from: com.tencent.mm.plugin.expt.c.c */
public final class C27889c {
    static C27889c lNS;

    /* renamed from: com.tencent.mm.plugin.expt.c.c$a */
    static class C3004a implements C37866a<Bundle, IPCVoid> {

        /* renamed from: com.tencent.mm.plugin.expt.c.c$a$1 */
        class C30051 implements Runnable {
            C30051() {
            }

            public final void run() {
                AppMethodBeat.m2504i(73529);
                C11747d.brb().brd();
                AppMethodBeat.m2505o(73529);
            }
        }

        private C3004a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(73530);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("key_page_flow_name");
            int i = bundle.getInt("key_page_flow_type");
            int i2 = bundle.getInt("key_page_flow_hashcode", 0);
            long j = bundle.getLong("key_page_flow_time_stamp", 0);
            C4990ab.m7417i("MicroMsg.MMPageFlowSenderByIPCInvoker", "MMPageFlowReceiver async receive action name[%s-%d-%d] type[%d]", string, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i));
            try {
                C5004al.m7441d(new C30051());
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.MMPageFlowSenderByIPCInvoker", e, "post to main thread error? [%s]", e.toString());
            }
            C7060h.pYm.mo8378a(932, 101, 1, false);
            AppMethodBeat.m2505o(73530);
        }
    }

    C27889c() {
    }
}
