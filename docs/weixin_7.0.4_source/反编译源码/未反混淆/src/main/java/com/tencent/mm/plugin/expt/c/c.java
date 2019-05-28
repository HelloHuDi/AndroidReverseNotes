package com.tencent.mm.plugin.expt.c;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public final class c {
    static c lNS;

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, com.tencent.mm.ipcinvoker.c cVar) {
            AppMethodBeat.i(73530);
            Bundle bundle = (Bundle) obj;
            String string = bundle.getString("key_page_flow_name");
            int i = bundle.getInt("key_page_flow_type");
            int i2 = bundle.getInt("key_page_flow_hashcode", 0);
            long j = bundle.getLong("key_page_flow_time_stamp", 0);
            ab.i("MicroMsg.MMPageFlowSenderByIPCInvoker", "MMPageFlowReceiver async receive action name[%s-%d-%d] type[%d]", string, Integer.valueOf(i2), Long.valueOf(j), Integer.valueOf(i));
            try {
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(73529);
                        d.brb().brd();
                        AppMethodBeat.o(73529);
                    }
                });
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.MMPageFlowSenderByIPCInvoker", e, "post to main thread error? [%s]", e.toString());
            }
            h.pYm.a(932, 101, 1, false);
            AppMethodBeat.o(73530);
        }
    }

    c() {
    }
}
