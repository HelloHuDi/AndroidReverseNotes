package com.tencent.p177mm.ipcinvoker.wx_extension;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C45412g;
import com.tencent.p177mm.ipcinvoker.C45412g.C185122;
import com.tencent.p177mm.ipcinvoker.C45412g.C454111;
import com.tencent.p177mm.ipcinvoker.C9548e;
import com.tencent.p177mm.ipcinvoker.p1383a.C26327e;
import com.tencent.p177mm.ipcinvoker.p1383a.C37865d;
import com.tencent.p177mm.ipcinvoker.p1383a.C41211a;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.p177mm.ipcinvoker.p855h.p1193a.C18513a;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C6624h;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ipcinvoker.wx_extension.PluginIPC */
public class PluginIPC extends C7597f implements C42147c {

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.PluginIPC$a */
    static final class C9555a implements C18513a {
        static final C18513a eGG = new C9555a();

        private C9555a() {
        }

        static {
            AppMethodBeat.m2504i(126207);
            AppMethodBeat.m2505o(126207);
        }

        /* renamed from: a */
        public final void mo20818a(int i, String str, String str2, Object... objArr) {
            AppMethodBeat.m2504i(126206);
            switch (i) {
                case 2:
                    C4990ab.m7419v(str, str2, objArr);
                    AppMethodBeat.m2505o(126206);
                    return;
                case 3:
                    C4990ab.m7411d(str, str2, objArr);
                    AppMethodBeat.m2505o(126206);
                    return;
                case 4:
                    C4990ab.m7417i(str, str2, objArr);
                    AppMethodBeat.m2505o(126206);
                    return;
                case 5:
                    C4990ab.m7421w(str, str2, objArr);
                    AppMethodBeat.m2505o(126206);
                    return;
                case 6:
                    C4990ab.m7413e(str, str2, objArr);
                    AppMethodBeat.m2505o(126206);
                    return;
                case 7:
                    C4990ab.m7413e(str, str2, objArr);
                    break;
            }
            AppMethodBeat.m2505o(126206);
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.PluginIPC$1 */
    class C95561 extends C41211a {
        C95561() {
        }

        /* renamed from: a */
        public final void mo20819a(C37865d c37865d) {
            AppMethodBeat.m2504i(126203);
            super.mo20819a(c37865d);
            c37865d.mo60587a(C9555a.eGG);
            AppMethodBeat.m2505o(126203);
        }

        /* renamed from: a */
        public final void mo20820a(C26327e c26327e) {
            AppMethodBeat.m2504i(126204);
            super.mo20820a(c26327e);
            c26327e.mo33755a(new C45414d());
            c26327e.mo33755a(new C42143a());
            c26327e.mo33755a(new C9560e());
            AppMethodBeat.m2505o(126204);
        }

        /* renamed from: b */
        public final void mo20821b(C37865d c37865d) {
            AppMethodBeat.m2504i(126205);
            c37865d.mo60588a("com.tencent.mm", MainProcessIPCService.class);
            c37865d.mo60588a("com.tencent.mm:tools", ToolsProcessIPCService.class);
            c37865d.mo60588a("com.tencent.mm:toolsmp", ToolsMpProcessIPCService.class);
            c37865d.mo60588a("com.tencent.mm:support", SupportProcessIPCService.class);
            AppMethodBeat.m2505o(126205);
        }
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(126208);
        C4990ab.m7417i("MicroMsg.PluginIPC", "execute(%s)", c1681g.eHT);
        Application application = ((C6624h) C1720g.m3533RM().mo5224Rn()).f1233cc;
        C95561 c95561 = new C95561();
        Assert.assertNotNull(application);
        C9548e.sContext = application;
        C37865d c454111 = new C454111(application);
        c95561.mo20819a(c454111);
        c95561.mo20820a(new C185122());
        c95561.mo20821b(c454111);
        C26340b.m41917i("IPC.IPCInvokerBoot", "setup IPCInvoker(process : %s, application : %s)", C9548e.m17007PN(), Integer.valueOf(application.hashCode()));
        if (C4996ah.doF() || C4996ah.doG()) {
            C45412g.m83632lh("com.tencent.mm");
        }
        AppMethodBeat.m2505o(126208);
    }
}
