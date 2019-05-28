package com.tencent.mm.plugin.appbrand.weishi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.q;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class e {

    static class a implements com.tencent.mm.ipcinvoker.a<IPCString, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(133641);
            IPCString iPCString = (IPCString) obj;
            if (!(iPCString == null || bo.isNullOrNil(iPCString.value))) {
                e.Eu(iPCString.value);
            }
            AppMethodBeat.o(133641);
        }
    }

    public static boolean E(i iVar) {
        AppMethodBeat.i(133642);
        if (iVar != null) {
            boolean equalsIgnoreCase = "wxfe02ecfe70800f46".equalsIgnoreCase(iVar.mAppId);
            AppMethodBeat.o(133642);
            return equalsIgnoreCase;
        }
        AppMethodBeat.o(133642);
        return false;
    }

    public static void aOz() {
        AppMethodBeat.i(133643);
        if (ah.bqo()) {
            Eu("wxfe02ecfe70800f46");
            AppMethodBeat.o(133643);
            return;
        }
        XIPCInvoker.a("com.tencent.mm", new IPCString("wxfe02ecfe70800f46"), a.class, new c<IPCVoid>() {
            public final /* bridge */ /* synthetic */ void ao(Object obj) {
            }
        });
        AppMethodBeat.o(133643);
    }

    static void Eu(String str) {
        AppMethodBeat.i(133644);
        ab.i("MicroMsg.AppBrandWeishiUtil", "doSendEventAppBrandUIClose");
        q qVar = new q();
        qVar.csA = new com.tencent.mm.g.a.q.a();
        qVar.csA.csB = str;
        com.tencent.mm.sdk.b.a.xxA.m(qVar);
        AppMethodBeat.o(133644);
    }
}
