package com.tencent.mm.ipcinvoker;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.d;
import com.tencent.mm.ipcinvoker.h.a.a;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.ipcinvoker.h.c;

public final class g {

    /* renamed from: com.tencent.mm.ipcinvoker.g$1 */
    public static class AnonymousClass1 implements d {
        final /* synthetic */ Application eGd;

        public AnonymousClass1(Application application) {
            this.eGd = application;
        }

        public final <T extends BaseIPCService> void a(String str, Class<T> cls) {
            AppMethodBeat.i(114035);
            b PL = b.PL();
            String str2 = c.P(str, this.eGd.getPackageName()) + "/" + str;
            if (((Class) PL.eFK.get(str2)) != null) {
                b.w("IPC.IPCBridgeManager", "warning: override ipc service: %s -> %s", str2, (Class) PL.eFK.get(str2));
            }
            PL.eFK.put(str2, cls);
            AppMethodBeat.o(114035);
        }

        public final void a(a aVar) {
            AppMethodBeat.i(114036);
            b.b(aVar);
            AppMethodBeat.o(114036);
        }
    }

    public static void lh(final String str) {
        AppMethodBeat.i(114040);
        if (b.PL().le(str)) {
            AppMethodBeat.o(114040);
            return;
        }
        m.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114038);
                b PL = b.PL();
                String str = str;
                if (e.lg(str)) {
                    b.i("IPC.IPCBridgeManager", "the same process(%s), do not need to build IPCBridge.", str);
                    AppMethodBeat.o(114038);
                    return;
                }
                PL.ld(str);
                AppMethodBeat.o(114038);
            }
        });
        AppMethodBeat.o(114040);
    }

    public static void li(final String str) {
        AppMethodBeat.i(114041);
        if (b.PL().le(str)) {
            AppMethodBeat.o(114041);
            return;
        }
        m.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114039);
                b.PL().lf(str);
                AppMethodBeat.o(114039);
            }
        });
        AppMethodBeat.o(114041);
    }
}
