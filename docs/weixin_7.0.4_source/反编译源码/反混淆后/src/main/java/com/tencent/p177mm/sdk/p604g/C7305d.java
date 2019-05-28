package com.tencent.p177mm.sdk.p604g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.C4969e.C4968a;
import com.tencent.p177mm.sdk.p604g.p605a.C4939b;
import com.tencent.p177mm.sdk.p604g.p605a.C4941c;
import com.tencent.p177mm.sdk.p604g.p605a.C4942d;
import com.tencent.p177mm.sdk.p604g.p605a.C4943e;
import com.tencent.p177mm.sdk.p604g.p605a.C4944f;
import com.tencent.p177mm.sdk.p604g.p606b.C4946a;
import com.tencent.p177mm.sdk.p604g.p606b.C7299d.C4950a;
import com.tencent.p177mm.sdk.p604g.p606b.C7301e;
import com.tencent.p177mm.sdk.p604g.p607c.C4955a;
import com.tencent.p177mm.sdk.p604g.p607c.C4957b;
import com.tencent.p177mm.sdk.p604g.p607c.C4960c;
import com.tencent.p177mm.sdk.p604g.p608d.C4967b;
import com.tencent.p177mm.sdk.p604g.p608d.C7304a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
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

/* renamed from: com.tencent.mm.sdk.g.d */
public class C7305d implements C4939b, C4943e, C4950a {
    static final /* synthetic */ boolean $assertionsDisabled = (!C7305d.class.desiredAssertionStatus());
    public static boolean xDB = false;
    public static boolean xDC = false;
    private static C4953b<Runnable> xDF = new C4953b();
    public static final C4943e xDG = new C7305d();
    public static final C4941c xDH = new C7302c(xDG);
    private static C4944f xDJ;
    public static int xDN = 7;
    private static C4957b xDO;
    private static C4955a xDP;
    private C7306ak xDD = new C7306ak(Looper.getMainLooper());
    private Map<Object, List<C7304a>> xDE = new HashMap();
    public C4946a xDI = new C7301e(this, this);
    private long xDK;
    final AtomicBoolean xDL = new AtomicBoolean(false);
    final ReentrantLock xDM = new ReentrantLock();

    /* renamed from: com.tencent.mm.sdk.g.d$2 */
    class C49642 implements Runnable {
        C49642() {
        }

        public final void run() {
            AppMethodBeat.m2504i(52536);
            C4945a.setTag("MAIN_LOOP_TAG");
            AppMethodBeat.m2505o(52536);
        }
    }

    /* renamed from: com.tencent.mm.sdk.g.d$b */
    static class C4966b {
        private static HandlerThread xDV = C4960c.anN("OrderWorker");
        private static Handler xDW = new Handler(xDV.getLooper()) {
            public final void handleMessage(Message message) {
                AppMethodBeat.m2504i(52539);
                super.handleMessage(message);
                if (message.what == C7305d.xDN && C7305d.xDJ != null) {
                    C7305d.xDJ.mo10169e((C4969e) message.obj);
                }
                AppMethodBeat.m2505o(52539);
            }
        };

        static {
            AppMethodBeat.m2504i(52540);
            if (!xDV.isAlive()) {
                xDV.start();
            }
            AppMethodBeat.m2505o(52540);
        }
    }

    /* renamed from: com.tencent.mm.sdk.g.d$a */
    class C7303a implements C4942d {
        C4942d xDT;
        String xDU;

        C7303a(String str, C4942d c4942d) {
            this.xDU = str;
            this.xDT = c4942d;
        }

        /* renamed from: a */
        public final void mo10145a(Runnable runnable, int i) {
            AppMethodBeat.m2504i(52537);
            if (this.xDT != null) {
                this.xDT.mo10145a(runnable, i);
            }
            AppMethodBeat.m2505o(52537);
        }

        /* renamed from: b */
        public final void mo10146b(Runnable runnable, int i) {
            AppMethodBeat.m2504i(52538);
            try {
                if (!TextUtils.isEmpty(this.xDU)) {
                    C7304a a = C7305d.m12284a(C7305d.this, C7305d.m12303i(runnable, this.xDU), i);
                    if (a != null) {
                        C7305d.this.xDI.execute(a);
                    }
                    if (this.xDT != null) {
                        this.xDT.mo10146b(runnable, i);
                        AppMethodBeat.m2505o(52538);
                        return;
                    }
                    AppMethodBeat.m2505o(52538);
                }
            } finally {
                if (this.xDT != null) {
                    this.xDT.mo10146b(runnable, i);
                }
                AppMethodBeat.m2505o(52538);
            }
        }
    }

    static {
        AppMethodBeat.m2504i(52586);
        AppMethodBeat.m2505o(52586);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.m2504i(52541);
        if ($assertionsDisabled || runnable != null) {
            m12292a(runnable, C7305d.m12296d(runnable, null), null, null);
            AppMethodBeat.m2505o(52541);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(52541);
        throw assertionError;
    }

    /* renamed from: b */
    public final void mo10151b(Runnable runnable, String str) {
        AppMethodBeat.m2504i(52542);
        if ($assertionsDisabled || runnable != null) {
            m12292a(runnable, C7305d.m12296d(runnable, null), str, null);
            AppMethodBeat.m2505o(52542);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(52542);
        throw assertionError;
    }

    /* renamed from: a */
    public final void mo10147a(Runnable runnable, String str, C4942d c4942d) {
        AppMethodBeat.m2504i(52543);
        if ($assertionsDisabled || runnable != null) {
            m12292a(runnable, C7305d.m12296d(runnable, null), str, c4942d);
            AppMethodBeat.m2505o(52543);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(52543);
        throw assertionError;
    }

    /* renamed from: a */
    private void m12292a(Runnable runnable, String str, String str2, C4942d c4942d) {
        AppMethodBeat.m2504i(52544);
        C7304a c7304a = new C7304a(runnable, str, str2, 0, new C7303a(str2, c4942d), xDJ, C4966b.xDW);
        m12289a((Object) runnable, c7304a);
        m12290a(runnable, str2, c7304a);
        AppMethodBeat.m2505o(52544);
    }

    /* renamed from: a */
    private void m12290a(Runnable runnable, String str, C7304a c7304a) {
        AppMethodBeat.m2504i(52545);
        if (C7305d.m12293c(runnable, str)) {
            this.xDI.execute(c7304a);
        }
        AppMethodBeat.m2505o(52545);
    }

    /* renamed from: p */
    public final void mo10159p(Runnable runnable, long j) {
        AppMethodBeat.m2504i(52546);
        if ($assertionsDisabled || runnable != null) {
            m12291a(runnable, C7305d.m12296d(runnable, null), null, j);
            AppMethodBeat.m2505o(52546);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(52546);
        throw assertionError;
    }

    /* renamed from: b */
    public final void mo10152b(Runnable runnable, String str, long j) {
        AppMethodBeat.m2504i(52547);
        if ($assertionsDisabled || runnable != null) {
            m12291a(runnable, C7305d.m12296d(runnable, null), str, j);
            AppMethodBeat.m2505o(52547);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(52547);
        throw assertionError;
    }

    /* renamed from: a */
    private void m12291a(final Runnable runnable, String str, final String str2, long j) {
        AppMethodBeat.m2504i(52548);
        final C7304a c7304a = new C7304a(runnable, str, str2, j, new C7303a(str2, null), xDJ, C4966b.xDW);
        m12289a((Object) runnable, c7304a);
        C4966b.xDW.postAtTime(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(52535);
                if (c7304a.bYT) {
                    C7305d.m12288a(C7305d.this, runnable, str2, c7304a);
                    AppMethodBeat.m2505o(52535);
                    return;
                }
                C4990ab.m7421w("MicroMsg.ThreadPool", "may be was removed before! future:%s", c7304a);
                AppMethodBeat.m2505o(52535);
            }
        }, c7304a, SystemClock.uptimeMillis() + Math.max(0, j));
        AppMethodBeat.m2505o(52548);
    }

    /* renamed from: c */
    private static boolean m12293c(Runnable runnable, String str) {
        AppMethodBeat.m2504i(52549);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(52549);
            return true;
        }
        boolean h = xDF.mo10194h(runnable, str);
        AppMethodBeat.m2505o(52549);
        return h;
    }

    /* renamed from: d */
    private static String m12296d(Runnable runnable, String str) {
        AppMethodBeat.m2504i(52550);
        if (runnable instanceof C4967b) {
            str = ((C4967b) runnable).getKey();
        } else if (TextUtils.isEmpty(str)) {
            str = runnable.getClass().getName();
        }
        AppMethodBeat.m2505o(52550);
        return str;
    }

    /* renamed from: am */
    public final void mo10148am(Runnable runnable) {
        AppMethodBeat.m2504i(52551);
        C7304a i = m12302i((Object) runnable, -1);
        while (i != null) {
            try {
                i.get(5000, TimeUnit.MILLISECONDS);
            } catch (CancellationException e) {
            }
            i = m12302i((Object) runnable, i.token);
        }
        AppMethodBeat.m2505o(52551);
    }

    /* renamed from: an */
    public final void mo10149an(Runnable runnable) {
        AppMethodBeat.m2504i(52552);
        C7304a i = m12302i((Object) runnable, -1);
        while (i != null) {
            try {
                i.get();
            } catch (CancellationException e) {
            }
            i = m12302i((Object) runnable, i.token);
        }
        AppMethodBeat.m2505o(52552);
    }

    public final boolean remove(Runnable runnable) {
        int i = 0;
        AppMethodBeat.m2504i(52553);
        if (runnable == null) {
            AppMethodBeat.m2505o(52553);
            return false;
        }
        boolean z;
        List cG = m12294cG(runnable);
        xDF.remove(runnable);
        if (cG.isEmpty()) {
            z = false;
        } else {
            z = true;
        }
        while (i < cG.size()) {
            C7304a c7304a = (C7304a) cG.get(i);
            C4966b.xDW.removeCallbacksAndMessages(c7304a);
            this.xDI.remove(c7304a);
            if (xDJ != null) {
                xDJ.mo10168d(c7304a.dqt());
            }
            i++;
        }
        AppMethodBeat.m2505o(52553);
        return z;
    }

    public final void remove(String str) {
        AppMethodBeat.m2504i(52554);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(52554);
            return;
        }
        List anL = anL(str);
        xDF.anK(str);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < anL.size()) {
                C7304a c7304a = (C7304a) anL.get(i2);
                C4966b.xDW.removeCallbacksAndMessages(c7304a);
                this.xDI.remove(c7304a);
                if (xDJ != null) {
                    xDJ.mo10168d(c7304a.dqt());
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(52554);
                return;
            }
        }
    }

    /* renamed from: d */
    public final void mo10154d(Runnable runnable) {
        AppMethodBeat.m2504i(52556);
        this.xDD.post(runnable);
        AppMethodBeat.m2505o(52556);
    }

    /* renamed from: q */
    public final void mo10160q(Runnable runnable, long j) {
        AppMethodBeat.m2504i(52557);
        this.xDD.postDelayed(runnable, j);
        AppMethodBeat.m2505o(52557);
    }

    public final C4946a cin() {
        return this.xDI;
    }

    /* renamed from: ap */
    public final void mo10138ap(Runnable runnable) {
        AppMethodBeat.m2504i(52558);
        if (runnable instanceof C7304a) {
            C7304a c7304a = (C7304a) runnable;
            C4945a.setTag(c7304a.xDU);
            if (xDJ != null) {
                xDJ.mo10166b(c7304a.dqt());
            }
        }
        AppMethodBeat.m2505o(52558);
    }

    public final void afterExecute(Runnable runnable, Throwable th) {
        AppMethodBeat.m2504i(52559);
        if (runnable instanceof C7304a) {
            C7304a c7304a = (C7304a) runnable;
            m12300h(c7304a.xzE, c7304a.token);
            C4945a.setTag("");
            th = c7304a.xEP;
            if (xDJ != null) {
                xDJ.mo10167c(c7304a.dqt());
            }
        }
        if (th != null) {
            Object runnable2;
            if (runnable2 instanceof C7304a) {
                runnable2 = ((C7304a) runnable2).xzE;
            }
            if (xDJ != null) {
                xDJ.mo10165a(runnable2, th);
            }
        }
        AppMethodBeat.m2505o(52559);
    }

    /* renamed from: Me */
    public final void mo10180Me(int i) {
        AppMethodBeat.m2504i(52560);
        this.xDM.lock();
        try {
            if (this.xDL.compareAndSet(false, true)) {
                this.xDK = System.currentTimeMillis();
                if (xDJ != null) {
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    m12304o(linkedList, linkedList2);
                    xDJ.mo10163a(i, linkedList, linkedList2);
                }
            }
            this.xDM.unlock();
            AppMethodBeat.m2505o(52560);
        } catch (Throwable th) {
            this.xDM.unlock();
            AppMethodBeat.m2505o(52560);
        }
    }

    public final void dqa() {
        AppMethodBeat.m2504i(52561);
        this.xDM.lock();
        try {
            if (this.xDL.compareAndSet(true, false) && xDJ != null) {
                xDJ.mo10170jt(System.currentTimeMillis() - this.xDK);
            }
            this.xDM.unlock();
            AppMethodBeat.m2505o(52561);
        } catch (Throwable th) {
            this.xDM.unlock();
            AppMethodBeat.m2505o(52561);
        }
    }

    public final String dqb() {
        AppMethodBeat.m2504i(52562);
        StringBuilder stringBuilder = new StringBuilder(String.format("dumpInfo[%s]:", new Object[]{null}));
        HashMap hashMap = new HashMap();
        synchronized (this.xDE) {
            try {
                for (List<C7304a> it : this.xDE.values()) {
                    for (C7304a c7304a : it) {
                        if (c7304a.isRunning()) {
                            if (hashMap.containsKey(c7304a.eOn)) {
                                hashMap.put(c7304a.eOn, Integer.valueOf(((Integer) hashMap.get(c7304a.eOn)).intValue() + 1));
                            } else {
                                hashMap.put(c7304a.eOn, Integer.valueOf(1));
                            }
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(52562);
            }
        }
        stringBuilder.append(hashMap.toString());
        String stringBuilder2 = stringBuilder.toString();
        return stringBuilder2;
    }

    /* renamed from: d */
    public final void mo10155d(Map<String, Integer> map, Map<String, Integer> map2) {
        AppMethodBeat.m2504i(52563);
        List linkedList = new LinkedList();
        List linkedList2 = new LinkedList();
        m12304o(linkedList, linkedList2);
        C7305d.m12286a((Map) map, linkedList2);
        C7305d.m12286a((Map) map2, linkedList);
        AppMethodBeat.m2505o(52563);
    }

    /* renamed from: o */
    private void m12304o(List<C4969e> list, List<C4969e> list2) {
        AppMethodBeat.m2504i(52564);
        synchronized (this.xDE) {
            try {
                for (List<C7304a> it : this.xDE.values()) {
                    for (C7304a c7304a : it) {
                        C4969e c4969e = new C4969e(c7304a.eOn);
                        c4969e.xDY = c7304a.cmn;
                        if (c7304a.isRunning()) {
                            c4969e.xDX = C4968a.RUNNING;
                            list2.add(c4969e);
                        } else {
                            c4969e.xDX = C4968a.WAITING;
                            list.add(c4969e);
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(52564);
            }
        }
    }

    /* renamed from: a */
    private static Map<String, Integer> m12286a(Map<String, Integer> map, List<C4969e> list) {
        AppMethodBeat.m2504i(52565);
        for (C4969e c4969e : list) {
            if (map.containsKey(c4969e.name)) {
                map.put(c4969e.name, Integer.valueOf(((Integer) map.get(c4969e.name)).intValue() + 1));
            } else {
                map.put(c4969e.name, Integer.valueOf(1));
            }
        }
        AppMethodBeat.m2505o(52565);
        return map;
    }

    private C7305d() {
        AppMethodBeat.m2504i(52566);
        mo10154d(new C49642());
        AppMethodBeat.m2505o(52566);
    }

    /* JADX WARNING: Missing block: B:20:0x0048, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(52567);
     */
    /* JADX WARNING: Missing block: B:32:?, code skipped:
            return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    private C7304a m12300h(Object obj, int i) {
        AppMethodBeat.m2504i(52567);
        synchronized (this.xDE) {
            try {
                List list = (List) this.xDE.get(obj);
                if (list == null || list.isEmpty()) {
                    this.xDE.remove(obj);
                } else {
                    C7304a c7304a;
                    ListIterator listIterator = list.listIterator();
                    while (listIterator.hasNext()) {
                        c7304a = (C7304a) listIterator.next();
                        if (c7304a.token == i) {
                            listIterator.remove();
                            break;
                        }
                    }
                    c7304a = null;
                    if (list.isEmpty()) {
                        this.xDE.remove(obj);
                    }
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(52567);
            }
        }
        return null;
    }

    /* renamed from: cG */
    private List<C7304a> m12294cG(Object obj) {
        AppMethodBeat.m2504i(52568);
        LinkedList linkedList = new LinkedList();
        synchronized (this.xDE) {
            try {
                List<C7304a> list = (List) this.xDE.remove(obj);
                if (list != null) {
                    for (C7304a c7304a : list) {
                        if (c7304a.dqs()) {
                            linkedList.add(c7304a);
                        }
                    }
                }
            } finally {
                AppMethodBeat.m2505o(52568);
            }
        }
        return linkedList;
    }

    private List<C7304a> anL(String str) {
        AppMethodBeat.m2504i(52569);
        LinkedList linkedList = new LinkedList();
        synchronized (this.xDE) {
            try {
                Iterator it = this.xDE.values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) it.next()).iterator();
                    Object obj = 1;
                    while (it2.hasNext()) {
                        C7304a c7304a = (C7304a) it2.next();
                        if (c7304a.xDU == str && c7304a.dqs()) {
                            linkedList.add(c7304a);
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
                AppMethodBeat.m2505o(52569);
            }
        }
        return linkedList;
    }

    /* renamed from: a */
    private void m12289a(Object obj, C7304a c7304a) {
        AppMethodBeat.m2504i(52570);
        synchronized (this.xDE) {
            try {
                List list = (List) this.xDE.get(obj);
                if (list == null) {
                    Map map = this.xDE;
                    list = new LinkedList();
                    map.put(obj, list);
                }
                list.add(c7304a);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(52570);
                }
            }
        }
        if (xDJ != null) {
            xDJ.mo10164a(c7304a.dqt());
        }
        AppMethodBeat.m2505o(52570);
    }

    /* JADX WARNING: Missing block: B:16:0x0031, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(52571);
     */
    /* JADX WARNING: Missing block: B:31:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: i */
    private C7304a m12302i(Object obj, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(52571);
        if (obj == null) {
            AppMethodBeat.m2505o(52571);
            return null;
        }
        synchronized (this.xDE) {
            try {
                List<C7304a> list = (List) this.xDE.get(obj);
                C7304a c7304a;
                if (list == null || list.isEmpty()) {
                } else if (i < 0) {
                    i2 = 0;
                    c7304a = (C7304a) list.get(0);
                } else {
                    for (C7304a c7304a2 : list) {
                        if (i != c7304a2.token) {
                            break;
                        }
                    }
                    c7304a2 = null;
                }
            } finally {
                AppMethodBeat.m2505o(52571);
            }
        }
        return i2;
    }

    /* renamed from: cH */
    private boolean m12295cH(Object obj) {
        boolean containsKey;
        AppMethodBeat.m2504i(52572);
        synchronized (this.xDE) {
            try {
                containsKey = this.xDE.containsKey(obj);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(52572);
            }
        }
        return containsKey;
    }

    /* renamed from: a */
    public static void m12287a(C4944f c4944f) {
        xDJ = c4944f;
    }

    @Deprecated
    /* renamed from: e */
    public final void mo10157e(Runnable runnable, String str) {
        AppMethodBeat.m2504i(52573);
        if ($assertionsDisabled || runnable != null) {
            m12292a(runnable, C7305d.m12296d(runnable, str), null, null);
            AppMethodBeat.m2505o(52573);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.m2505o(52573);
        throw assertionError;
    }

    @Deprecated
    public static void post(Runnable runnable, String str) {
        AppMethodBeat.m2504i(52574);
        xDG.mo10157e(runnable, str);
        AppMethodBeat.m2505o(52574);
    }

    @Deprecated
    /* renamed from: f */
    public static void m12298f(Runnable runnable, String str) {
        AppMethodBeat.m2504i(52575);
        xDG.mo10157e(runnable, str);
        AppMethodBeat.m2505o(52575);
    }

    @Deprecated
    /* renamed from: g */
    public static void m12299g(Runnable runnable, String str) {
        AppMethodBeat.m2504i(52576);
        xDG.mo10157e(runnable, str);
        AppMethodBeat.m2505o(52576);
    }

    private static C4957b dqc() {
        AppMethodBeat.m2504i(52577);
        if (xDO == null) {
            synchronized (C7305d.class) {
                try {
                    if (xDO == null) {
                        xDO = new C4957b();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(52577);
                    }
                }
            }
        }
        C4957b c4957b = xDO;
        AppMethodBeat.m2505o(52577);
        return c4957b;
    }

    /* renamed from: h */
    public static Thread m12301h(Runnable runnable, String str) {
        AppMethodBeat.m2504i(52578);
        Thread newThread = C7305d.dqc().newThread(runnable, str, 5);
        AppMethodBeat.m2505o(52578);
        return newThread;
    }

    /* renamed from: a */
    public static Thread m12285a(Runnable runnable, String str, int i) {
        AppMethodBeat.m2504i(52579);
        Thread newThread = C7305d.dqc().newThread(runnable, str, i);
        AppMethodBeat.m2505o(52579);
        return newThread;
    }

    private static C4955a dqd() {
        AppMethodBeat.m2504i(52580);
        if (xDP == null) {
            synchronized (C7305d.class) {
                try {
                    if (xDP == null) {
                        xDP = new C4955a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(52580);
                    }
                }
            }
        }
        C4955a c4955a = xDP;
        AppMethodBeat.m2505o(52580);
        return c4955a;
    }

    @Deprecated
    public static HandlerThread anM(String str) {
        AppMethodBeat.m2504i(52581);
        C7305d.dqd();
        HandlerThread em = C4955a.m7359em(str, 0);
        AppMethodBeat.m2505o(52581);
        return em;
    }

    @Deprecated
    /* renamed from: ek */
    public static HandlerThread m12297ek(String str, int i) {
        AppMethodBeat.m2504i(52582);
        C7305d.dqd();
        HandlerThread em = C4955a.m7359em(str, i);
        AppMethodBeat.m2505o(52582);
        return em;
    }

    /* renamed from: ao */
    public final boolean mo10150ao(Runnable runnable) {
        AppMethodBeat.m2504i(52555);
        if (runnable == null) {
            AppMethodBeat.m2505o(52555);
            return false;
        }
        boolean cH = m12295cH(runnable);
        AppMethodBeat.m2505o(52555);
        return cH;
    }
}
