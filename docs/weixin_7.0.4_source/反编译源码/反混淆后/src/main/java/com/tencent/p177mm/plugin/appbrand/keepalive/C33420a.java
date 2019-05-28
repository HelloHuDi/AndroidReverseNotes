package com.tencent.p177mm.plugin.appbrand.keepalive;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.keepalive.a */
public final class C33420a {
    public static final C33420a ifp = new C33420a();
    ConcurrentHashMap<String, C33421a> ifq = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.keepalive.a$a */
    static final class C33421a {
        ServiceConnection ifr;
        Class ifs;

        /* renamed from: com.tencent.mm.plugin.appbrand.keepalive.a$a$1 */
        class C195341 implements ServiceConnection {
            C195341() {
            }

            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            }

            public final void onServiceDisconnected(ComponentName componentName) {
            }
        }

        private C33421a() {
            AppMethodBeat.m2504i(131681);
            this.ifr = new C195341();
            AppMethodBeat.m2505o(131681);
        }

        /* synthetic */ C33421a(byte b) {
            this();
        }
    }

    public C33420a() {
        AppMethodBeat.m2504i(131682);
        AppMethodBeat.m2505o(131682);
    }

    static {
        AppMethodBeat.m2504i(131683);
        AppMethodBeat.m2505o(131683);
    }
}
