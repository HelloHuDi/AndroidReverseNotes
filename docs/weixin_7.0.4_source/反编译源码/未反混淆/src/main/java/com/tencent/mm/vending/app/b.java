package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.SparseIntArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vending.f.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b zXh;
    Map<c, a> b = new ConcurrentHashMap();
    final Handler d = new Handler(com.tencent.mm.vending.i.b.dMs().a.getLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(126099);
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.onCreate();
                    synchronized (aVar.d) {
                        try {
                            aVar.g = true;
                            aVar.d.notify();
                        } finally {
                            while (true) {
                                AppMethodBeat.o(126099);
                                break;
                            }
                        }
                    }
                    return;
                case 2:
                    AppMethodBeat.o(126099);
                    return;
                case 3:
                    AppMethodBeat.o(126099);
                    return;
                case 4:
                    aVar.onDestroy();
                    break;
            }
            AppMethodBeat.o(126099);
        }
    };
    final SparseIntArray zXi = new SparseIntArray();

    public b() {
        AppMethodBeat.i(126096);
        AppMethodBeat.o(126096);
    }

    static {
        AppMethodBeat.i(126098);
        zXh = null;
        zXh = new b();
        AppMethodBeat.o(126098);
    }

    public static b dMb() {
        return zXh;
    }

    public final void a(c cVar, a aVar) {
        AppMethodBeat.i(126097);
        if (this.b.containsKey(cVar)) {
            a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
            AppMethodBeat.o(126097);
            return;
        }
        this.b.put(cVar, aVar);
        a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", cVar, Integer.valueOf(cVar.hashCode()), aVar, Looper.myLooper());
        int i = this.zXi.get(cVar.hashCode(), 0);
        if (i > 0 && i < 4) {
            if (i > 0) {
                this.d.sendMessage(this.d.obtainMessage(1, aVar));
            }
            if (i >= 2) {
                this.d.sendMessage(this.d.obtainMessage(2, aVar));
            }
            if (i >= 3) {
                this.d.sendMessage(this.d.obtainMessage(3, aVar));
            }
            if (i >= 4) {
                this.d.sendMessage(this.d.obtainMessage(4, aVar));
            }
        }
        AppMethodBeat.o(126097);
    }
}
