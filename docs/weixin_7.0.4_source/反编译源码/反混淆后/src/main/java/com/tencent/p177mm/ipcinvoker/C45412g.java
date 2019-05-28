package com.tencent.p177mm.ipcinvoker;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.C18508a;
import com.tencent.p177mm.ipcinvoker.extension.C18509c;
import com.tencent.p177mm.ipcinvoker.p1383a.C26327e;
import com.tencent.p177mm.ipcinvoker.p1383a.C37865d;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.p177mm.ipcinvoker.p855h.C9552c;
import com.tencent.p177mm.ipcinvoker.p855h.p1193a.C18513a;

/* renamed from: com.tencent.mm.ipcinvoker.g */
public final class C45412g {

    /* renamed from: com.tencent.mm.ipcinvoker.g$2 */
    public static class C185122 implements C26327e {
        /* renamed from: a */
        public final void mo33755a(C18508a c18508a) {
            AppMethodBeat.m2504i(114037);
            C18509c.m28813a(c18508a);
            AppMethodBeat.m2505o(114037);
        }
    }

    /* renamed from: com.tencent.mm.ipcinvoker.g$1 */
    public static class C454111 implements C37865d {
        final /* synthetic */ Application eGd;

        public C454111(Application application) {
            this.eGd = application;
        }

        /* renamed from: a */
        public final <T extends BaseIPCService> void mo60588a(String str, Class<T> cls) {
            AppMethodBeat.m2504i(114035);
            C32710b PL = C32710b.m53380PL();
            String str2 = C9552c.m17015P(str, this.eGd.getPackageName()) + "/" + str;
            if (((Class) PL.eFK.get(str2)) != null) {
                C26340b.m41918w("IPC.IPCBridgeManager", "warning: override ipc service: %s -> %s", str2, (Class) PL.eFK.get(str2));
            }
            PL.eFK.put(str2, cls);
            AppMethodBeat.m2505o(114035);
        }

        /* renamed from: a */
        public final void mo60587a(C18513a c18513a) {
            AppMethodBeat.m2504i(114036);
            C26340b.m41914b(c18513a);
            AppMethodBeat.m2505o(114036);
        }
    }

    /* renamed from: lh */
    public static void m83632lh(final String str) {
        AppMethodBeat.m2504i(114040);
        if (C32710b.m53380PL().mo53222le(str)) {
            AppMethodBeat.m2505o(114040);
            return;
        }
        C18515m.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(114038);
                C32710b PL = C32710b.m53380PL();
                String str = str;
                if (C9548e.m17008lg(str)) {
                    C26340b.m41917i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", str);
                    AppMethodBeat.m2505o(114038);
                    return;
                }
                PL.mo53221ld(str);
                AppMethodBeat.m2505o(114038);
            }
        });
        AppMethodBeat.m2505o(114040);
    }

    /* renamed from: li */
    public static void m83633li(final String str) {
        AppMethodBeat.m2504i(114041);
        if (C32710b.m53380PL().mo53222le(str)) {
            AppMethodBeat.m2505o(114041);
            return;
        }
        C18515m.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(114039);
                C32710b.m53380PL().mo53223lf(str);
                AppMethodBeat.m2505o(114039);
            }
        });
        AppMethodBeat.m2505o(114041);
    }
}
