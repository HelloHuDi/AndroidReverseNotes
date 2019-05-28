package com.tencent.p177mm.plugin.appbrand.weishi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.p177mm.ipcinvoker.type.IPCString;
import com.tencent.p177mm.ipcinvoker.type.IPCVoid;
import com.tencent.p177mm.p230g.p231a.C42038q;
import com.tencent.p177mm.p230g.p231a.C42038q.C32623a;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.weishi.e */
public final class C33572e {

    /* renamed from: com.tencent.mm.plugin.appbrand.weishi.e$a */
    static class C33571a implements C37866a<IPCString, IPCVoid> {
        private C33571a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(133641);
            IPCString iPCString = (IPCString) obj;
            if (!(iPCString == null || C5046bo.isNullOrNil(iPCString.value))) {
                C33572e.m54823Eu(iPCString.value);
            }
            AppMethodBeat.m2505o(133641);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.weishi.e$1 */
    static class C335731 implements C18507c<IPCVoid> {
        C335731() {
        }

        /* renamed from: ao */
        public final /* bridge */ /* synthetic */ void mo5960ao(Object obj) {
        }
    }

    /* renamed from: E */
    public static boolean m54822E(C6750i c6750i) {
        AppMethodBeat.m2504i(133642);
        if (c6750i != null) {
            boolean equalsIgnoreCase = "wxfe02ecfe70800f46".equalsIgnoreCase(c6750i.mAppId);
            AppMethodBeat.m2505o(133642);
            return equalsIgnoreCase;
        }
        AppMethodBeat.m2505o(133642);
        return false;
    }

    public static void aOz() {
        AppMethodBeat.m2504i(133643);
        if (C4996ah.bqo()) {
            C33572e.m54823Eu("wxfe02ecfe70800f46");
            AppMethodBeat.m2505o(133643);
            return;
        }
        XIPCInvoker.m83629a("com.tencent.mm", new IPCString("wxfe02ecfe70800f46"), C33571a.class, new C335731());
        AppMethodBeat.m2505o(133643);
    }

    /* renamed from: Eu */
    static void m54823Eu(String str) {
        AppMethodBeat.m2504i(133644);
        C4990ab.m7416i("MicroMsg.AppBrandWeishiUtil", "doSendEventAppBrandUIClose");
        C42038q c42038q = new C42038q();
        c42038q.csA = new C32623a();
        c42038q.csA.csB = str;
        C4879a.xxA.mo10055m(c42038q);
        AppMethodBeat.m2505o(133644);
    }
}
