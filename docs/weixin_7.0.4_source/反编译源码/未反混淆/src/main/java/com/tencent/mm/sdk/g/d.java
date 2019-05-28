package com.tencent.mm.sdk.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.g.a.c;
import com.tencent.mm.sdk.g.a.e;
import com.tencent.mm.sdk.g.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class d implements com.tencent.mm.sdk.g.a.b, e, com.tencent.mm.sdk.g.b.d.a {
    static final /* synthetic */ boolean $assertionsDisabled = (!d.class.desiredAssertionStatus());
    public static boolean xDB = false;
    public static boolean xDC = false;
    private static b<Runnable> xDF = new b();
    public static final e xDG = new d();
    public static final c xDH = new c(xDG);
    private static f xDJ;
    public static int xDN = 7;
    private static com.tencent.mm.sdk.g.c.b xDO;
    private static com.tencent.mm.sdk.g.c.a xDP;
    private ak xDD = new ak(Looper.getMainLooper());
    private Map<Object, List<com.tencent.mm.sdk.g.d.a>> xDE = new HashMap();
    public com.tencent.mm.sdk.g.b.a xDI = new com.tencent.mm.sdk.g.b.e(this, this);
    private long xDK;
    final AtomicBoolean xDL = new AtomicBoolean(false);
    final ReentrantLock xDM = new ReentrantLock();

    static class b {
        private static HandlerThread xDV = com.tencent.mm.sdk.g.c.c.anN("OrderWorker");
        private static Handler xDW = new Handler(xDV.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.i(52539);
                super.handleMessage(message);
                if (message.what == d.xDN && d.xDJ != null) {
                    d.xDJ.e((e) message.obj);
                }
                AppMethodBeat.o(52539);
            }
        };

        static {
            AppMethodBeat.i(52540);
            if (!xDV.isAlive()) {
                xDV.start();
            }
            AppMethodBeat.o(52540);
        }
    }

    class a implements com.tencent.mm.sdk.g.a.d {
        com.tencent.mm.sdk.g.a.d xDT;
        String xDU;

        a(String str, com.tencent.mm.sdk.g.a.d dVar) {
            this.xDU = str;
            this.xDT = dVar;
        }

        public final void a(Runnable runnable, int i) {
            AppMethodBeat.i(52537);
            if (this.xDT != null) {
                this.xDT.a(runnable, i);
            }
            AppMethodBeat.o(52537);
        }

        public final void b(Runnable runnable, int i) {
            AppMethodBeat.i(52538);
            try {
                if (!TextUtils.isEmpty(this.xDU)) {
                    com.tencent.mm.sdk.g.d.a a = d.a(d.this, d.i(runnable, this.xDU), i);
                    if (a != null) {
                        d.this.xDI.execute(a);
                    }
                    if (this.xDT != null) {
                        this.xDT.b(runnable, i);
                        AppMethodBeat.o(52538);
                        return;
                    }
                    AppMethodBeat.o(52538);
                }
            } finally {
                if (this.xDT != null) {
                    this.xDT.b(runnable, i);
                }
                AppMethodBeat.o(52538);
            }
        }
    }

    static {
        AppMethodBeat.i(52586);
        AppMethodBeat.o(52586);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(52541);
        if ($assertionsDisabled || runnable != null) {
            a(runnable, d(runnable, null), null, null);
            AppMethodBeat.o(52541);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(52541);
        throw assertionError;
    }

    public final void b(Runnable runnable, String str) {
        AppMethodBeat.i(52542);
        if ($assertionsDisabled || runnable != null) {
            a(runnable, d(runnable, null), str, null);
            AppMethodBeat.o(52542);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(52542);
        throw assertionError;
    }

    public final void a(Runnable runnable, String str, com.tencent.mm.sdk.g.a.d dVar) {
        AppMethodBeat.i(52543);
        if ($assertionsDisabled || runnable != null) {
            a(runnable, d(runnable, null), str, dVar);
            AppMethodBeat.o(52543);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(52543);
        throw assertionError;
    }

    private void a(Runnable runnable, String str, String str2, com.tencent.mm.sdk.g.a.d dVar) {
        AppMethodBeat.i(52544);
        com.tencent.mm.sdk.g.d.a aVar = new com.tencent.mm.sdk.g.d.a(runnable, str, str2, 0, new a(str2, dVar), xDJ, b.xDW);
        a((Object) runnable, aVar);
        a(runnable, str2, aVar);
        AppMethodBeat.o(52544);
    }

    private void a(Runnable runnable, String str, com.tencent.mm.sdk.g.d.a aVar) {
        AppMethodBeat.i(52545);
        if (c(runnable, str)) {
            this.xDI.execute(aVar);
        }
        AppMethodBeat.o(52545);
    }

    public final void p(Runnable runnable, long j) {
        AppMethodBeat.i(52546);
        if ($assertionsDisabled || runnable != null) {
            a(runnable, d(runnable, null), null, j);
            AppMethodBeat.o(52546);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(52546);
        throw assertionError;
    }

    public final void b(Runnable runnable, String str, long j) {
        AppMethodBeat.i(52547);
        if ($assertionsDisabled || runnable != null) {
            a(runnable, d(runnable, null), str, j);
            AppMethodBeat.o(52547);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(52547);
        throw assertionError;
    }

    private void a(final Runnable runnable, String str, final String str2, long j) {
        AppMethodBeat.i(52548);
        final com.tencent.mm.sdk.g.d.a aVar = new com.tencent.mm.sdk.g.d.a(runnable, str, str2, j, new a(str2, null), xDJ, b.xDW);
        a((Object) runnable, aVar);
        b.xDW.postAtTime(new Runnable() {
            public final void run() {
                AppMethodBeat.i(52535);
                if (aVar.bYT) {
                    d.a(d.this, runnable, str2, aVar);
                    AppMethodBeat.o(52535);
                    return;
                }
                ab.w("MicroMsg.ThreadPool", "may be was removed before! future:%s", aVar);
                AppMethodBeat.o(52535);
            }
        }, aVar, SystemClock.uptimeMillis() + Math.max(0, j));
        AppMethodBeat.o(52548);
    }

    private static boolean c(Runnable runnable, String str) {
        AppMethodBeat.i(52549);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(52549);
            return true;
        }
        boolean h = xDF.h(runnable, str);
        AppMethodBeat.o(52549);
        return h;
    }

    private static String d(Runnable runnable, String str) {
        AppMethodBeat.i(52550);
        if (runnable instanceof com.tencent.mm.sdk.g.d.b) {
            str = ((com.tencent.mm.sdk.g.d.b) runnable).getKey();
        } else if (TextUtils.isEmpty(str)) {
            str = runnable.getClass().getName();
        }
        AppMethodBeat.o(52550);
        return str;
    }

    public final void am(Runnable runnable) {
        AppMethodBeat.i(52551);
        com.tencent.mm.sdk.g.d.a i = i((Object) runnable, -1);
        while (i != null) {
            try {
                i.get(5000, TimeUnit.MILLISECONDS);
            } catch (CancellationException e) {
            }
            i = i((Object) runnable, i.token);
        }
        AppMethodBeat.o(52551);
    }

    public final void an(Runnable runnable) {
        AppMethodBeat.i(52552);
        com.tencent.mm.sdk.g.d.a i = i((Object) runnable, -1);
        while (i != null) {
            try {
                i.get();
            } catch (CancellationException e) {
            }
            i = i((Object) runnable, i.token);
        }
        AppMethodBeat.o(52552);
    }

    public final boolean remove(Runnable runnable) {
        int i = 0;
        AppMethodBeat.i(52553);
        if (runnable == null) {
            AppMethodBeat.o(52553);
            return false;
        }
        boolean z;
        List cG = cG(runnable);
        xDF.remove(runnable);
        if (cG.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        while (i < cG.size()) {
            com.tencent.mm.sdk.g.d.a aVar = (com.tencent.mm.sdk.g.d.a) cG.get(i);
            b.xDW.removeCallbacksAndMessages(aVar);
            this.xDI.remove(aVar);
            if (xDJ != null) {
                xDJ.d(aVar.dqt());
            }
            i++;
        }
        AppMethodBeat.o(52553);
        return z;
    }

    public final void remove(String str) {
        AppMethodBeat.i(52554);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(52554);
            return;
        }
        List anL = anL(str);
        xDF.anK(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < anL.size()) {
                com.tencent.mm.sdk.g.d.a aVar = (com.tencent.mm.sdk.g.d.a) anL.get(i2);
                b.xDW.removeCallbacksAndMessages(aVar);
                this.xDI.remove(aVar);
                if (xDJ != null) {
                    xDJ.d(aVar.dqt());
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(52554);
                return;
            }
        }
    }

    public final void d(Runnable runnable) {
        AppMethodBeat.i(52556);
        this.xDD.post(runnable);
        AppMethodBeat.o(52556);
    }

    public final void q(Runnable runnable, long j) {
        AppMethodBeat.i(52557);
        this.xDD.postDelayed(runnable, j);
        AppMethodBeat.o(52557);
    }

    public final com.tencent.mm.sdk.g.b.a cin() {
        return this.xDI;
    }

    public final void ap(Runnable runnable) {
        AppMethodBeat.i(52558);
        if (runnable instanceof com.tencent.mm.sdk.g.d.a) {
            com.tencent.mm.sdk.g.d.a aVar = (com.tencent.mm.sdk.g.d.a) runnable;
            a.setTag(aVar.xDU);
            if (xDJ != null) {
                xDJ.b(aVar.dqt());
            }
        }
        AppMethodBeat.o(52558);
    }

    public final void afterExecute(Runnable runnable, Throwable th) {
        AppMethodBeat.i(52559);
        if (runnable instanceof com.tencent.mm.sdk.g.d.a) {
            com.tencent.mm.sdk.g.d.a aVar = (com.tencent.mm.sdk.g.d.a) runnable;
            h(aVar.xzE, aVar.token);
            a.setTag("");
            th = aVar.xEP;
            if (xDJ != null) {
                xDJ.c(aVar.dqt());
            }
        }
        if (th != null) {
            Object runnable2;
            if (runnable2 instanceof com.tencent.mm.sdk.g.d.a) {
                runnable2 = ((com.tencent.mm.sdk.g.d.a) runnable2).xzE;
            }
            if (xDJ != null) {
                xDJ.a(runnable2, th);
            }
        }
        AppMethodBeat.o(52559);
    }

    public final void Me(int i) {
        AppMethodBeat.i(52560);
        this.xDM.lock();
        try {
            if (this.xDL.compareAndSet(false, true)) {
                this.xDK = System.currentTimeMillis();
                if (xDJ != null) {
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    o(linkedList, linkedList2);
                    xDJ.a(i, linkedList, linkedList2);
                }
            }
            this.xDM.unlock();
            AppMethodBeat.o(52560);
        } catch (Throwable th) {
            this.xDM.unlock();
            AppMethodBeat.o(52560);
        }
    }

    public final void dqa() {
        AppMethodBeat.i(52561);
        this.xDM.lock();
        try {
            if (this.xDL.compareAndSet(true, false) && xDJ != null) {
                xDJ.jt(System.currentTimeMillis() - this.xDK);
            }
            this.xDM.unlock();
            AppMethodBeat.o(52561);
        } catch (Throwable th) {
            this.xDM.unlock();
            AppMethodBeat.o(52561);
        }
    }

    public final String dqb() {
        AppMethodBeat.i(52562);
        StringBuilder stringBuilder = new StringBuilder(String.format("dumpInfo[%s]:", new Object[]{null}));
        HashMap hashMap = new HashMap();
        synchronized (this.xDE) {
            try {
                for (List<com.tencent.mm.sdk.g.d.a> it : this.xDE.values()) {
                    for (com.tencent.mm.sdk.g.d.a aVar : it) {
                        if (aVar.isRunning()) {
                            if (hashMap.containsKey(aVar.eOn)) {
                                hashMap.put(aVar.eOn, Integer.valueOf(((Integer) hashMap.get(aVar.eOn)).intValue() + 1));
                            } else {
                                hashMap.put(aVar.eOn, Integer.valueOf(1));
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(52562);
            }
        }
        stringBuilder.append(hashMap.toString());
        String stringBuilder2 = stringBuilder.toString();
        return stringBuilder2;
    }

    public final void d(Map<String, Integer> map, Map<String, Integer> map2) {
        AppMethodBeat.i(52563);
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        o(linkedList, linkedList2);
        a((Map) map, linkedList2);
        a((Map) map2, linkedList);
        AppMethodBeat.o(52563);
    }

    private void o(List<e> list, List<e> list2) {
        AppMethodBeat.i(52564);
        synchronized (this.xDE) {
            try {
                for (List<com.tencent.mm.sdk.g.d.a> it : this.xDE.values()) {
                    for (com.tencent.mm.sdk.g.d.a aVar : it) {
                        e eVar = new e(aVar.eOn);
                        eVar.xDY = aVar.cmn;
                        if (aVar.isRunning()) {
                            eVar.xDX = com.tencent.mm.sdk.g.e.a.RUNNING;
                            list2.add(eVar);
                        } else {
                            eVar.xDX = com.tencent.mm.sdk.g.e.a.WAITING;
                            list.add(eVar);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(52564);
            }
        }
    }

    private static Map<String, Integer> a(Map<String, Integer> map, List<e> list) {
        AppMethodBeat.i(52565);
        for (e eVar : list) {
            if (map.containsKey(eVar.name)) {
                map.put(eVar.name, Integer.valueOf(((Integer) map.get(eVar.name)).intValue() + 1));
            } else {
                map.put(eVar.name, Integer.valueOf(1));
            }
        }
        AppMethodBeat.o(52565);
        return map;
    }

    private d() {
        AppMethodBeat.i(52566);
        d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(52536);
                a.setTag("MAIN_LOOP_TAG");
                AppMethodBeat.o(52536);
            }
        });
        AppMethodBeat.o(52566);
    }

    /* JADX WARNING: Missing block: B:20:0x0048, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(52567);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.sdk.g.d.a h(Object obj, int i) {
        AppMethodBeat.i(52567);
        synchronized (this.xDE) {
            try {
                List list = (List) this.xDE.get(obj);
                if (list == null || list.isEmpty()) {
                    this.xDE.remove(obj);
                } else {
                    com.tencent.mm.sdk.g.d.a aVar;
                    ListIterator listIterator = list.listIterator();
                    while (listIterator.hasNext()) {
                        aVar = (com.tencent.mm.sdk.g.d.a) listIterator.next();
                        if (aVar.token == i) {
                            listIterator.remove();
                            break;
                        }
                    }
                    aVar = null;
                    if (list.isEmpty()) {
                        this.xDE.remove(obj);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(52567);
            }
        }
        return null;
    }

    private List<com.tencent.mm.sdk.g.d.a> cG(Object obj) {
        AppMethodBeat.i(52568);
        LinkedList linkedList = new LinkedList();
        synchronized (this.xDE) {
            try {
                List<com.tencent.mm.sdk.g.d.a> list = (List) this.xDE.remove(obj);
                if (list != null) {
                    for (com.tencent.mm.sdk.g.d.a aVar : list) {
                        if (aVar.dqs()) {
                            linkedList.add(aVar);
                        }
                    }
                }
            } finally {
                AppMethodBeat.o(52568);
            }
        }
        return linkedList;
    }

    private List<com.tencent.mm.sdk.g.d.a> anL(String str) {
        AppMethodBeat.i(52569);
        LinkedList linkedList = new LinkedList();
        synchronized (this.xDE) {
            try {
                Iterator it = this.xDE.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) it.next()).iterator();
                    Object obj = 1;
                    while (it2.hasNext()) {
                        com.tencent.mm.sdk.g.d.a aVar = (com.tencent.mm.sdk.g.d.a) it2.next();
                        if (aVar.xDU == str && aVar.dqs()) {
                            linkedList.add(aVar);
                            it2.remove();
                        } else {
                            obj = null;
                        }
                    }
                    if (obj != null) {
                        it.remove();
                    }
                }
            } finally {
                AppMethodBeat.o(52569);
            }
        }
        return linkedList;
    }

    private void a(Object obj, com.tencent.mm.sdk.g.d.a aVar) {
        AppMethodBeat.i(52570);
        synchronized (this.xDE) {
            try {
                List list = (List) this.xDE.get(obj);
                if (list == null) {
                    Map map = this.xDE;
                    list = new LinkedList();
                    map.put(obj, list);
                }
                list.add(aVar);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(52570);
                }
            }
        }
        if (xDJ != null) {
            xDJ.a(aVar.dqt());
        }
        AppMethodBeat.o(52570);
    }

    /* JADX WARNING: Missing block: B:16:0x0031, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(52571);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.tencent.mm.sdk.g.d.a i(Object obj, int i) {
        int i2 = 0;
        AppMethodBeat.i(52571);
        if (obj == null) {
            AppMethodBeat.o(52571);
            return null;
        }
        synchronized (this.xDE) {
            try {
                List<com.tencent.mm.sdk.g.d.a> list = (List) this.xDE.get(obj);
                com.tencent.mm.sdk.g.d.a aVar;
                if (list == null || list.isEmpty()) {
                } else if (i < 0) {
                    i2 = 0;
                    aVar = (com.tencent.mm.sdk.g.d.a) list.get(0);
                } else {
                    for (com.tencent.mm.sdk.g.d.a aVar2 : list) {
                        if (i != aVar2.token) {
                            break;
                        }
                    }
                    aVar2 = null;
                }
            } finally {
                AppMethodBeat.o(52571);
            }
        }
        return i2;
    }

    private boolean cH(Object obj) {
        boolean containsKey;
        AppMethodBeat.i(52572);
        synchronized (this.xDE) {
            try {
                containsKey = this.xDE.containsKey(obj);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(52572);
            }
        }
        return containsKey;
    }

    public static void a(f fVar) {
        xDJ = fVar;
    }

    @Deprecated
    public final void e(Runnable runnable, String str) {
        AppMethodBeat.i(52573);
        if ($assertionsDisabled || runnable != null) {
            a(runnable, d(runnable, str), null, null);
            AppMethodBeat.o(52573);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(52573);
        throw assertionError;
    }

    @Deprecated
    public static void post(Runnable runnable, String str) {
        AppMethodBeat.i(52574);
        xDG.e(runnable, str);
        AppMethodBeat.o(52574);
    }

    @Deprecated
    public static void f(Runnable runnable, String str) {
        AppMethodBeat.i(52575);
        xDG.e(runnable, str);
        AppMethodBeat.o(52575);
    }

    @Deprecated
    public static void g(Runnable runnable, String str) {
        AppMethodBeat.i(52576);
        xDG.e(runnable, str);
        AppMethodBeat.o(52576);
    }

    private static com.tencent.mm.sdk.g.c.b dqc() {
        AppMethodBeat.i(52577);
        if (xDO == null) {
            synchronized (d.class) {
                try {
                    if (xDO == null) {
                        xDO = new com.tencent.mm.sdk.g.c.b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(52577);
                    }
                }
            }
        }
        com.tencent.mm.sdk.g.c.b bVar = xDO;
        AppMethodBeat.o(52577);
        return bVar;
    }

    public static Thread h(Runnable runnable, String str) {
        AppMethodBeat.i(52578);
        Thread newThread = dqc().newThread(runnable, str, 5);
        AppMethodBeat.o(52578);
        return newThread;
    }

    public static Thread a(Runnable runnable, String str, int i) {
        AppMethodBeat.i(52579);
        Thread newThread = dqc().newThread(runnable, str, i);
        AppMethodBeat.o(52579);
        return newThread;
    }

    private static com.tencent.mm.sdk.g.c.a dqd() {
        AppMethodBeat.i(52580);
        if (xDP == null) {
            synchronized (d.class) {
                try {
                    if (xDP == null) {
                        xDP = new com.tencent.mm.sdk.g.c.a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(52580);
                    }
                }
            }
        }
        com.tencent.mm.sdk.g.c.a aVar = xDP;
        AppMethodBeat.o(52580);
        return aVar;
    }

    @Deprecated
    public static HandlerThread anM(String str) {
        AppMethodBeat.i(52581);
        dqd();
        HandlerThread em = com.tencent.mm.sdk.g.c.a.em(str, 0);
        AppMethodBeat.o(52581);
        return em;
    }

    @Deprecated
    public static HandlerThread ek(String str, int i) {
        AppMethodBeat.i(52582);
        dqd();
        HandlerThread em = com.tencent.mm.sdk.g.c.a.em(str, i);
        AppMethodBeat.o(52582);
        return em;
    }

    public final boolean ao(Runnable runnable) {
        AppMethodBeat.i(52555);
        if (runnable == null) {
            AppMethodBeat.o(52555);
            return false;
        }
        boolean cH = cH(runnable);
        AppMethodBeat.o(52555);
        return cH;
    }
}
