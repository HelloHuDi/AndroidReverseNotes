package com.tencent.mm.sdk.b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.d;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import junit.framework.Assert;

public final class a {
    public static a xxA = new a();
    private final HashMap<Integer, LinkedList<c>> xxB = new HashMap();
    private final HashMap<Integer, b> xxC = new HashMap();
    private a xxz = new a();

    public static class a extends d {
        public final void o(Runnable runnable) {
            AppMethodBeat.i(115149);
            runnable.run();
            AppMethodBeat.o(115149);
        }

        public final void l(Runnable runnable, long j) {
            AppMethodBeat.i(115150);
            runnable.run();
            AppMethodBeat.o(115150);
        }

        public final String getType() {
            AppMethodBeat.i(115151);
            String thread = Thread.currentThread().toString();
            AppMethodBeat.o(115151);
            return thread;
        }

        public final void cancel() {
        }
    }

    class b extends com.tencent.mm.vending.b.a<c> {
        public b() {
            super(a.this.xxz);
            AppMethodBeat.i(115152);
            AppMethodBeat.o(115152);
        }

        public final void a(com.tencent.mm.vending.j.a aVar) {
            AppMethodBeat.i(115153);
            LinkedList dMf = dMf();
            b bVar = (b) aVar.get(0);
            if (bVar == null) {
                ab.e("MicroMsg.EventCenter", "event is null! fatal!");
                AppMethodBeat.o(115153);
                return;
            }
            if (bVar.dnT()) {
                Collections.sort(dMf, new Comparator<com.tencent.mm.vending.b.b>() {
                    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                        return ((c) ((com.tencent.mm.vending.b.b) obj2).d).priority - ((c) ((com.tencent.mm.vending.b.b) obj).d).priority;
                    }
                });
            }
            com.tencent.mm.vending.b.b[] bVarArr = new com.tencent.mm.vending.b.b[dMf.size()];
            dMf.toArray(bVarArr);
            int length = bVarArr.length;
            int i = 0;
            while (i < length && (!((c) bVarArr[i].d).a(bVar) || !bVar.dnT())) {
                i++;
            }
            if (bVar.callback != null) {
                bVar.callback.run();
            }
            AppMethodBeat.o(115153);
        }

        public final com.tencent.mm.vending.b.b<c> b(c cVar) {
            AppMethodBeat.i(115154);
            com.tencent.mm.vending.b.b a = a(new com.tencent.mm.vending.b.b(cVar, this));
            AppMethodBeat.o(115154);
            return a;
        }

        public final void f(c cVar) {
            AppMethodBeat.i(115155);
            b(new com.tencent.mm.vending.b.b(cVar, this));
            AppMethodBeat.o(115155);
        }
    }

    static {
        AppMethodBeat.i(115166);
        AppMethodBeat.o(115166);
    }

    private a() {
        AppMethodBeat.i(115156);
        AppMethodBeat.o(115156);
    }

    public final com.tencent.mm.vending.b.b<c> b(c cVar) {
        com.tencent.mm.vending.b.b<c> b;
        AppMethodBeat.i(115157);
        synchronized (this) {
            try {
                Assert.assertNotNull("EventPoolImpl.add", cVar);
                ab.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.dnS()));
                b bVar = (b) this.xxC.get(Integer.valueOf(cVar.dnS()));
                if (bVar == null) {
                    HashMap hashMap = this.xxC;
                    Integer valueOf = Integer.valueOf(cVar.dnS());
                    bVar = new b();
                    hashMap.put(valueOf, bVar);
                }
                b = bVar.b(cVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115157);
            }
        }
        return b;
    }

    @Deprecated
    public final boolean c(c cVar) {
        AppMethodBeat.i(115158);
        synchronized (this) {
            try {
                Assert.assertNotNull("EventPoolImpl.add", cVar);
                ab.v("MicroMsg.EventCenter", "addListener %s(%d)", cVar, Integer.valueOf(cVar.dnS()));
                LinkedList linkedList = (LinkedList) this.xxB.get(Integer.valueOf(cVar.dnS()));
                if (linkedList == null) {
                    HashMap hashMap = this.xxB;
                    Integer valueOf = Integer.valueOf(cVar.dnS());
                    linkedList = new LinkedList();
                    hashMap.put(valueOf, linkedList);
                }
                if (linkedList.contains(cVar)) {
                } else {
                    ListenerInstanceMonitor.cA(cVar);
                    boolean add = linkedList.add(cVar);
                    AppMethodBeat.o(115158);
                    return add;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115158);
            }
        }
        return true;
    }

    @Deprecated
    public final boolean d(c cVar) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(115159);
        synchronized (this) {
            try {
                Assert.assertNotNull("EventPoolImpl.remove", cVar);
                ab.v("MicroMsg.EventCenter", "removeListener %s(%d)", cVar, Integer.valueOf(cVar.dnS()));
                LinkedList linkedList = (LinkedList) this.xxB.get(Integer.valueOf(cVar.dnS()));
                if (linkedList != null) {
                    z2 = linkedList.remove(cVar);
                }
                b bVar = (b) this.xxC.get(Integer.valueOf(cVar.dnS()));
                if (bVar != null) {
                    bVar.f(cVar);
                    z = true;
                } else {
                    z = z2;
                }
                ListenerInstanceMonitor.cB(cVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(115159);
            }
        }
        return z;
    }

    public final boolean m(b bVar) {
        b bVar2;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.i(115160);
        Assert.assertNotNull("EventPoolImpl.publish", bVar);
        ab.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.dnS()));
        LinkedList linkedList = null;
        synchronized (this) {
            try {
                int dnS = bVar.dnS();
                LinkedList linkedList2 = (LinkedList) this.xxB.get(Integer.valueOf(dnS));
                if (linkedList2 != null) {
                    linkedList = new LinkedList(linkedList2);
                    z = true;
                }
                bVar2 = (b) this.xxC.get(Integer.valueOf(dnS));
                if (bVar2 == null) {
                    z2 = z;
                }
                if (!z2) {
                    ab.w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", bVar, Integer.valueOf(dnS), "");
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(115160);
                }
            }
        }
        if (linkedList != null) {
            a(linkedList, bVar);
        }
        if (bVar2 != null) {
            bVar2.a(f.cV(bVar));
        }
        AppMethodBeat.o(115160);
        return z2;
    }

    public final void a(final b bVar, Looper looper) {
        AppMethodBeat.i(115161);
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", bVar);
        Assert.assertNotNull("EventPoolImpl.asyncPublish looper", looper);
        ab.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.dnS()));
        new ak(looper).post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(115146);
                a.xxA.m(bVar);
                AppMethodBeat.o(115146);
            }
        });
        AppMethodBeat.o(115161);
    }

    public final void a(final b bVar, Executor executor) {
        AppMethodBeat.i(115162);
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", bVar);
        Assert.assertNotNull("EventPoolImpl.asyncPublish executor", executor);
        ab.v("MicroMsg.EventCenter", "publish %s(%d)", bVar, Integer.valueOf(bVar.dnS()));
        executor.execute(new com.tencent.mm.sdk.g.d.b() {
            public final String getKey() {
                AppMethodBeat.i(115147);
                String name = bVar.getClass().getName();
                AppMethodBeat.o(115147);
                return name;
            }

            public final void run() {
                AppMethodBeat.i(115148);
                a.xxA.m(bVar);
                AppMethodBeat.o(115148);
            }
        });
        AppMethodBeat.o(115162);
    }

    public final synchronized boolean av(Class<? extends b> cls) {
        boolean z;
        AppMethodBeat.i(115163);
        Assert.assertNotNull("EventPoolImpl.hasListener", cls);
        LinkedList linkedList = (LinkedList) this.xxB.get(Integer.valueOf(cls.getName().hashCode()));
        if (linkedList == null || linkedList.size() <= 0) {
            b bVar = (b) this.xxC.get(Integer.valueOf(cls.getName().hashCode()));
            if (bVar == null || bVar.size() <= 0) {
                z = false;
                AppMethodBeat.o(115163);
            } else {
                AppMethodBeat.o(115163);
                z = true;
            }
        } else {
            AppMethodBeat.o(115163);
            z = true;
        }
        return z;
    }

    public final synchronized boolean e(c cVar) {
        boolean z;
        AppMethodBeat.i(115164);
        Assert.assertNotNull("EventPoolImpl.hadListened", cVar);
        LinkedList linkedList = (LinkedList) this.xxB.get(Integer.valueOf(cVar.dnS()));
        if (linkedList == null || linkedList.isEmpty() || !linkedList.contains(cVar)) {
            b bVar = (b) this.xxC.get(Integer.valueOf(cVar.dnS()));
            if (bVar == null || bVar.size() <= 0 || !bVar.contains(cVar)) {
                z = false;
                AppMethodBeat.o(115164);
            } else {
                AppMethodBeat.o(115164);
                z = true;
            }
        } else {
            AppMethodBeat.o(115164);
            z = true;
        }
        return z;
    }

    private void a(LinkedList<c> linkedList, b bVar) {
        AppMethodBeat.i(115165);
        if (bVar.dnT()) {
            Collections.sort(linkedList, new Comparator<c>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    return ((c) obj2).priority - ((c) obj).priority;
                }
            });
        }
        c[] cVarArr = new c[linkedList.size()];
        linkedList.toArray(cVarArr);
        int length = cVarArr.length;
        int i = 0;
        while (i < length && (!cVarArr[i].a(bVar) || !bVar.dnT())) {
            i++;
        }
        if (bVar.callback != null) {
            bVar.callback.run();
        }
        AppMethodBeat.o(115165);
    }
}
