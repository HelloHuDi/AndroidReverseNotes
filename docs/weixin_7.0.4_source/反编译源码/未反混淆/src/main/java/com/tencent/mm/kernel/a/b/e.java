package com.tencent.mm.kernel.a.b;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.h.h;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import junit.framework.Assert;

public final class e<T> {
    private static e eLN = null;
    private Queue<c> eLG = new LinkedList();
    private int eLH;
    private volatile a eLI;
    private volatile boolean eLJ = false;
    private final byte[] eLK = new byte[0];
    private volatile com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> eLL;
    private volatile c<T> eLM;

    public interface a {
        void Ss();

        void Sv();
    }

    public static class c {
        public HandlerThread cet;
        h eLR;
        Handler handler;
    }

    public static class b implements a {
        private final byte[] eHH = new byte[]{(byte) 0};

        public b() {
            AppMethodBeat.i(123307);
            AppMethodBeat.o(123307);
        }

        public final void Ss() {
            AppMethodBeat.i(123308);
            try {
                synchronized (this.eHH) {
                    if (this.eHH[0] == (byte) 0) {
                        j.i("MMSkeleton.Parallels", "Waiting for lock(%s)", this.eHH);
                        this.eHH.wait();
                    } else {
                        j.i("MMSkeleton.Parallels", "Not need wait for lock(%s)", this.eHH);
                    }
                }
                AppMethodBeat.o(123308);
            } catch (InterruptedException e) {
                ab.printErrStackTrace("MMSkeleton.Parallels", e, "", new Object[0]);
                AppMethodBeat.o(123308);
            } catch (Throwable th) {
                AppMethodBeat.o(123308);
            }
        }

        public final void Sv() {
            AppMethodBeat.i(123309);
            synchronized (this.eHH) {
                try {
                    this.eHH[0] = (byte) 1;
                    this.eHH.notify();
                    j.i("MMSkeleton.Parallels", "Lock(%s) notified", this.eHH);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(123309);
                }
            }
        }
    }

    static /* synthetic */ void c(e eVar) {
        AppMethodBeat.i(123326);
        eVar.active();
        AppMethodBeat.o(123326);
    }

    public static e Sq() {
        return eLN;
    }

    public static e Sr() {
        AppMethodBeat.i(123310);
        if (eLN == null) {
            eLN = new e();
        }
        e eVar = eLN;
        AppMethodBeat.o(123310);
        return eVar;
    }

    private e() {
        AppMethodBeat.i(123311);
        AppMethodBeat.o(123311);
    }

    public final synchronized void init(int i) {
        AppMethodBeat.i(123312);
        for (int i2 = 0; i2 < i; i2++) {
            Queue queue = this.eLG;
            HandlerThread handlerThread = new HandlerThread("parallels-".concat(String.valueOf(i2)), -8);
            handlerThread.start();
            c cVar = new c();
            cVar.cet = handlerThread;
            queue.add(cVar);
        }
        this.eLH = i;
        AppMethodBeat.o(123312);
    }

    public final synchronized void prepare() {
        AppMethodBeat.i(123313);
        for (int i = 0; i < this.eLH; i++) {
            c cVar = (c) ((LinkedList) this.eLG).get(i);
            Handler handler = new Handler(cVar.cet.getLooper());
            h hVar = new h(handler, cVar.cet.getName());
            cVar.handler = handler;
            cVar.eLR = hVar;
        }
        AppMethodBeat.o(123313);
    }

    public final boolean a(a aVar, com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> aVar2, c<T> cVar) {
        AppMethodBeat.i(123314);
        synchronized (this.eLK) {
            try {
                if (this.eLJ) {
                    ab.w("MMSkeleton.Parallels", "Arrange parallels task failed. It's busy on working.");
                    Assert.assertTrue(false);
                } else {
                    this.eLI = aVar;
                    this.eLL = aVar2;
                    this.eLM = cVar;
                    AppMethodBeat.o(123314);
                    return true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(123314);
            }
        }
        return false;
    }

    public final void a(a aVar, com.tencent.mm.vending.c.a<Void, com.tencent.mm.kernel.a.b.f.a> aVar2, c<T> cVar, String str) {
        AppMethodBeat.i(123315);
        if (a(aVar, (com.tencent.mm.vending.c.a) aVar2, (c) cVar)) {
            cVar.prepare();
            start(str);
            Ss();
        }
        AppMethodBeat.o(123315);
    }

    public final void Ss() {
        AppMethodBeat.i(123316);
        this.eLI.Ss();
        AppMethodBeat.o(123316);
    }

    public final void start(String str) {
        AppMethodBeat.i(123317);
        j.i("MMSkeleton.Parallels", "Start working. For %s", str);
        synchronized (this.eLK) {
            try {
                this.eLJ = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(123317);
            }
        }
        active();
    }

    public final synchronized List<c> St() {
        LinkedList linkedList;
        AppMethodBeat.i(123318);
        linkedList = new LinkedList(this.eLG);
        AppMethodBeat.o(123318);
        return linkedList;
    }

    private synchronized c Su() {
        c cVar;
        AppMethodBeat.i(123319);
        cVar = (c) this.eLG.poll();
        AppMethodBeat.o(123319);
        return cVar;
    }

    private synchronized boolean a(c cVar) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(123320);
            this.eLG.add(cVar);
            j.d("MMSkeleton.Parallels", "Parallels check threads idle. %s of %s", Integer.valueOf(this.eLG.size()), Integer.valueOf(this.eLH));
            if (this.eLG.size() == this.eLH) {
                AppMethodBeat.o(123320);
            } else {
                AppMethodBeat.o(123320);
                z = false;
            }
        }
        return z;
    }

    private void b(c cVar) {
        AppMethodBeat.i(123321);
        if (a(cVar)) {
            synchronized (this.eLK) {
                try {
                    if (this.eLJ) {
                        j.i("MMSkeleton.Parallels", "Parallels notify done", new Object[0]);
                    }
                    this.eLJ = false;
                    this.eLI.Sv();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(123321);
                }
            }
            return;
        }
        AppMethodBeat.o(123321);
    }

    private void active() {
        AppMethodBeat.i(123322);
        while (true) {
            c Su = Su();
            if (Su != null) {
                com.tencent.mm.kernel.a.b.f.a Sp = this.eLM.Sp();
                if (Sp != null) {
                    a(Su, Sp);
                } else {
                    b(Su);
                    AppMethodBeat.o(123322);
                    return;
                }
            }
            AppMethodBeat.o(123322);
            return;
        }
    }

    private void a(final c cVar, final com.tencent.mm.kernel.a.b.f.a<T> aVar) {
        AppMethodBeat.i(123323);
        cVar.eLR.o(new Runnable() {
            public final void run() {
                AppMethodBeat.i(123306);
                com.tencent.mm.kernel.a.b.f.a aVar = aVar;
                com.tencent.mm.vending.c.a a = e.this.eLL;
                if (!aVar.eLB) {
                    aVar.eMc.eMd.dOV();
                    if (!aVar.eLB) {
                        a.call(aVar);
                        ab.d("MMSkeleton.ParallelsDependencies", "consume call functional %s, node %s", a, aVar);
                        aVar.eLB = true;
                    }
                    aVar.eMc.eMd.done();
                }
                e.this.eLM.a(aVar);
                aVar = e.this.eLM.Sp();
                if (aVar == null) {
                    e.a(e.this, cVar);
                    AppMethodBeat.o(123306);
                    return;
                }
                e.a(e.this, cVar, aVar);
                e.c(e.this);
                AppMethodBeat.o(123306);
            }
        });
        AppMethodBeat.o(123323);
    }
}
