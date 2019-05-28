package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;

public final class b {

    public interface a {
        void a(int i, int i2, String str, com.tencent.mm.ai.b bVar);
    }

    static final class b implements com.tencent.mm.ipcinvoker.a<com.tencent.mm.ai.b, IPCRunCgiRespWrapper> {
        private b() {
        }

        public final /* synthetic */ void a(Object obj, final c cVar) {
            AppMethodBeat.i(126199);
            com.tencent.mm.ai.b bVar = (com.tencent.mm.ai.b) obj;
            if (bVar == null || bVar.fsH.fsP.getClass() == com.tencent.mm.bt.a.class) {
                ab.e("MicroMsg.IPCRunCgi", "InvokeTask, mm received invalid rr %s", bVar);
                if (cVar != null) {
                    cVar.ao(IPCRunCgiRespWrapper.Qa());
                }
                AppMethodBeat.o(126199);
                return;
            }
            w.a(bVar, new com.tencent.mm.ai.w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(126198);
                    if (cVar != null) {
                        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
                        iPCRunCgiRespWrapper.errType = i;
                        iPCRunCgiRespWrapper.errCode = i2;
                        iPCRunCgiRespWrapper.aIm = str;
                        iPCRunCgiRespWrapper.ehh = bVar;
                        cVar.ao(iPCRunCgiRespWrapper);
                    }
                    AppMethodBeat.o(126198);
                    return 0;
                }
            }, true);
            AppMethodBeat.o(126199);
        }
    }

    public static void a(com.tencent.mm.ai.b bVar, final a aVar) {
        AppMethodBeat.i(126200);
        if (ah.bqo()) {
            w.a(bVar, new com.tencent.mm.ai.w.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ai.b bVar, m mVar) {
                    AppMethodBeat.i(126196);
                    if (aVar != null) {
                        aVar.a(i, i2, str, bVar);
                    }
                    AppMethodBeat.o(126196);
                    return 0;
                }
            }, true);
            AppMethodBeat.o(126200);
            return;
        }
        XIPCInvoker.a("com.tencent.mm", bVar, b.class, new c<IPCRunCgiRespWrapper>() {
            public final /* synthetic */ void ao(Object obj) {
                AppMethodBeat.i(126197);
                IPCRunCgiRespWrapper iPCRunCgiRespWrapper = (IPCRunCgiRespWrapper) obj;
                try {
                    if (!(aVar == null || iPCRunCgiRespWrapper == null)) {
                        aVar.a(iPCRunCgiRespWrapper.errType, iPCRunCgiRespWrapper.errCode, iPCRunCgiRespWrapper.aIm, iPCRunCgiRespWrapper.ehh);
                    }
                    AppMethodBeat.o(126197);
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.IPCRunCgi", e, "remoteCgiImpl do callback", new Object[0]);
                    AppMethodBeat.o(126197);
                }
            }
        });
        AppMethodBeat.o(126200);
    }
}
