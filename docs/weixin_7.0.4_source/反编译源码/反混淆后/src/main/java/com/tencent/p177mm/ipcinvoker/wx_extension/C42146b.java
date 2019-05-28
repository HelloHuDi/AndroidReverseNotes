package com.tencent.p177mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.IPCRunCgiRespWrapper;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p205bt.C1331a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.ipcinvoker.wx_extension.b */
public final class C42146b {

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.b$a */
    public interface C9557a {
        /* renamed from: a */
        void mo5951a(int i, int i2, String str, C7472b c7472b);
    }

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.b$b */
    static final class C26344b implements C37866a<C7472b, IPCRunCgiRespWrapper> {
        private C26344b() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, final C18507c c18507c) {
            AppMethodBeat.m2504i(126199);
            C7472b c7472b = (C7472b) obj;
            if (c7472b == null || c7472b.fsH.fsP.getClass() == C1331a.class) {
                C4990ab.m7413e("MicroMsg.IPCRunCgi", "InvokeTask, mm received invalid rr %s", c7472b);
                if (c18507c != null) {
                    c18507c.mo5960ao(IPCRunCgiRespWrapper.m17025Qa());
                }
                AppMethodBeat.m2505o(126199);
                return;
            }
            C1226w.m2655a(c7472b, new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(126198);
                    if (c18507c != null) {
                        IPCRunCgiRespWrapper iPCRunCgiRespWrapper = new IPCRunCgiRespWrapper();
                        iPCRunCgiRespWrapper.errType = i;
                        iPCRunCgiRespWrapper.errCode = i2;
                        iPCRunCgiRespWrapper.aIm = str;
                        iPCRunCgiRespWrapper.ehh = c7472b;
                        c18507c.mo5960ao(iPCRunCgiRespWrapper);
                    }
                    AppMethodBeat.m2505o(126198);
                    return 0;
                }
            }, true);
            AppMethodBeat.m2505o(126199);
        }
    }

    /* renamed from: a */
    public static void m74301a(C7472b c7472b, final C9557a c9557a) {
        AppMethodBeat.m2504i(126200);
        if (C4996ah.bqo()) {
            C1226w.m2655a(c7472b, new C1224a() {
                /* renamed from: a */
                public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
                    AppMethodBeat.m2504i(126196);
                    if (c9557a != null) {
                        c9557a.mo5951a(i, i2, str, c7472b);
                    }
                    AppMethodBeat.m2505o(126196);
                    return 0;
                }
            }, true);
            AppMethodBeat.m2505o(126200);
            return;
        }
        XIPCInvoker.m83629a("com.tencent.mm", c7472b, C26344b.class, new C18507c<IPCRunCgiRespWrapper>() {
            /* renamed from: ao */
            public final /* synthetic */ void mo5960ao(Object obj) {
                AppMethodBeat.m2504i(126197);
                IPCRunCgiRespWrapper iPCRunCgiRespWrapper = (IPCRunCgiRespWrapper) obj;
                try {
                    if (!(c9557a == null || iPCRunCgiRespWrapper == null)) {
                        c9557a.mo5951a(iPCRunCgiRespWrapper.errType, iPCRunCgiRespWrapper.errCode, iPCRunCgiRespWrapper.aIm, iPCRunCgiRespWrapper.ehh);
                    }
                    AppMethodBeat.m2505o(126197);
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.IPCRunCgi", e, "remoteCgiImpl do callback", new Object[0]);
                    AppMethodBeat.m2505o(126197);
                }
            }
        });
        AppMethodBeat.m2505o(126200);
    }
}
