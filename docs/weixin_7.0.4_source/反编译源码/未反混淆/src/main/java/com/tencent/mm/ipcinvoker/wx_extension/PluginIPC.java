package com.tencent.mm.ipcinvoker.wx_extension;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.d;
import com.tencent.mm.ipcinvoker.a.e;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import junit.framework.Assert;

public class PluginIPC extends f implements c {

    static final class a implements com.tencent.mm.ipcinvoker.h.a.a {
        static final com.tencent.mm.ipcinvoker.h.a.a eGG = new a();

        private a() {
        }

        static {
            AppMethodBeat.i(126207);
            AppMethodBeat.o(126207);
        }

        public final void a(int i, String str, String str2, Object... objArr) {
            AppMethodBeat.i(126206);
            switch (i) {
                case 2:
                    ab.v(str, str2, objArr);
                    AppMethodBeat.o(126206);
                    return;
                case 3:
                    ab.d(str, str2, objArr);
                    AppMethodBeat.o(126206);
                    return;
                case 4:
                    ab.i(str, str2, objArr);
                    AppMethodBeat.o(126206);
                    return;
                case 5:
                    ab.w(str, str2, objArr);
                    AppMethodBeat.o(126206);
                    return;
                case 6:
                    ab.e(str, str2, objArr);
                    AppMethodBeat.o(126206);
                    return;
                case 7:
                    ab.e(str, str2, objArr);
                    break;
            }
            AppMethodBeat.o(126206);
        }
    }

    public void execute(g gVar) {
        AppMethodBeat.i(126208);
        ab.i("MicroMsg.PluginIPC", "execute(%s)", gVar.eHT);
        Application application = ((h) com.tencent.mm.kernel.g.RM().Rn()).cc;
        AnonymousClass1 anonymousClass1 = new com.tencent.mm.ipcinvoker.a.a() {
            public final void a(d dVar) {
                AppMethodBeat.i(126203);
                super.a(dVar);
                dVar.a(a.eGG);
                AppMethodBeat.o(126203);
            }

            public final void a(e eVar) {
                AppMethodBeat.i(126204);
                super.a(eVar);
                eVar.a(new d());
                eVar.a(new a());
                eVar.a(new e());
                AppMethodBeat.o(126204);
            }

            public final void b(d dVar) {
                AppMethodBeat.i(126205);
                dVar.a("com.tencent.mm", MainProcessIPCService.class);
                dVar.a("com.tencent.mm:tools", ToolsProcessIPCService.class);
                dVar.a("com.tencent.mm:toolsmp", ToolsMpProcessIPCService.class);
                dVar.a("com.tencent.mm:support", SupportProcessIPCService.class);
                AppMethodBeat.o(126205);
            }
        };
        Assert.assertNotNull(application);
        com.tencent.mm.ipcinvoker.e.sContext = application;
        d anonymousClass12 = new com.tencent.mm.ipcinvoker.g.AnonymousClass1(application);
        anonymousClass1.a(anonymousClass12);
        anonymousClass1.a(new e() {
            public final void a(a aVar) {
                AppMethodBeat.i(114037);
                c.a(aVar);
                AppMethodBeat.o(114037);
            }
        });
        anonymousClass1.b(anonymousClass12);
        b.i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", com.tencent.mm.ipcinvoker.e.PN(), Integer.valueOf(application.hashCode()));
        if (ah.doF() || ah.doG()) {
            com.tencent.mm.ipcinvoker.g.lh("com.tencent.mm");
        }
        AppMethodBeat.o(126208);
    }
}
