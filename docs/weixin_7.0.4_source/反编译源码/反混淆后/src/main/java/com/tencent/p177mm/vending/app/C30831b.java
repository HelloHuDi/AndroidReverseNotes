package com.tencent.p177mm.vending.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vending.p640f.C5687a;
import com.tencent.p177mm.vending.p643i.C5709b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.vending.app.b */
public final class C30831b {
    private static C30831b zXh;
    /* renamed from: b */
    Map<C40919c, C16025a> f13766b = new ConcurrentHashMap();
    /* renamed from: d */
    final Handler f13767d = new Handler(C5709b.dMs().f1355a.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(126099);
            C16025a c16025a = (C16025a) message.obj;
            switch (message.what) {
                case 1:
                    c16025a.onCreate();
                    synchronized (c16025a.f3001d) {
                        try {
                            c16025a.f3003g = true;
                            c16025a.f3001d.notify();
                        } finally {
                            while (true) {
                                AppMethodBeat.m2505o(126099);
                                break;
                            }
                        }
                    }
                    return;
                case 2:
                    AppMethodBeat.m2505o(126099);
                    return;
                case 3:
                    AppMethodBeat.m2505o(126099);
                    return;
                case 4:
                    c16025a.onDestroy();
                    break;
            }
            AppMethodBeat.m2505o(126099);
        }
    };
    final SparseIntArray zXi = new SparseIntArray();

    public C30831b() {
        AppMethodBeat.m2504i(126096);
        AppMethodBeat.m2505o(126096);
    }

    static {
        AppMethodBeat.m2504i(126098);
        zXh = null;
        zXh = new C30831b();
        AppMethodBeat.m2505o(126098);
    }

    public static C30831b dMb() {
        return zXh;
    }

    /* renamed from: a */
    public final void mo49321a(C40919c c40919c, C16025a c16025a) {
        AppMethodBeat.m2504i(126097);
        if (this.f13766b.containsKey(c40919c)) {
            C5687a.m8541e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
            AppMethodBeat.m2505o(126097);
            return;
        }
        this.f13766b.put(c40919c, c16025a);
        C5687a.m8542i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", c40919c, Integer.valueOf(c40919c.hashCode()), c16025a, Looper.myLooper());
        int i = this.zXi.get(c40919c.hashCode(), 0);
        if (i > 0 && i < 4) {
            if (i > 0) {
                this.f13767d.sendMessage(this.f13767d.obtainMessage(1, c16025a));
            }
            if (i >= 2) {
                this.f13767d.sendMessage(this.f13767d.obtainMessage(2, c16025a));
            }
            if (i >= 3) {
                this.f13767d.sendMessage(this.f13767d.obtainMessage(3, c16025a));
            }
            if (i >= 4) {
                this.f13767d.sendMessage(this.f13767d.obtainMessage(4, c16025a));
            }
        }
        AppMethodBeat.m2505o(126097);
    }
}
