package com.tencent.p177mm.sdk.p600b;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p604g.p608d.C4967b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.p177mm.vending.p636b.C5677a;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.p177mm.vending.p641g.C5698f;
import com.tencent.p177mm.vending.p642h.C5703d;
import com.tencent.p177mm.vending.p644j.C5710a;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.Executor;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.sdk.b.a */
public final class C4879a {
    public static C4879a xxA = new C4879a();
    private final HashMap<Integer, LinkedList<C4884c>> xxB = new HashMap();
    private final HashMap<Integer, C4882b> xxC = new HashMap();
    private C4881a xxz = new C4881a();

    /* renamed from: com.tencent.mm.sdk.b.a$3 */
    class C48773 implements Comparator<C4884c> {
        C48773() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            return ((C4884c) obj2).priority - ((C4884c) obj).priority;
        }
    }

    /* renamed from: com.tencent.mm.sdk.b.a$a */
    public static class C4881a extends C5703d {
        /* renamed from: o */
        public final void mo10061o(Runnable runnable) {
            AppMethodBeat.m2504i(115149);
            runnable.run();
            AppMethodBeat.m2505o(115149);
        }

        /* renamed from: l */
        public final void mo10060l(Runnable runnable, long j) {
            AppMethodBeat.m2504i(115150);
            runnable.run();
            AppMethodBeat.m2505o(115150);
        }

        public final String getType() {
            AppMethodBeat.m2504i(115151);
            String thread = Thread.currentThread().toString();
            AppMethodBeat.m2505o(115151);
            return thread;
        }

        public final void cancel() {
        }
    }

    /* renamed from: com.tencent.mm.sdk.b.a$b */
    class C4882b extends C5677a<C4884c> {

        /* renamed from: com.tencent.mm.sdk.b.a$b$1 */
        class C48781 implements Comparator<C7358b> {
            C48781() {
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((C4884c) ((C7358b) obj2).f2002d).priority - ((C4884c) ((C7358b) obj).f2002d).priority;
            }
        }

        public C4882b() {
            super(C4879a.this.xxz);
            AppMethodBeat.m2504i(115152);
            AppMethodBeat.m2505o(115152);
        }

        /* renamed from: a */
        public final void mo10062a(C5710a c5710a) {
            AppMethodBeat.m2504i(115153);
            LinkedList dMf = dMf();
            C4883b c4883b = (C4883b) c5710a.get(0);
            if (c4883b == null) {
                C4990ab.m7412e("MicroMsg.EventCenter", "event is null! fatal!");
                AppMethodBeat.m2505o(115153);
                return;
            }
            if (c4883b.dnT()) {
                Collections.sort(dMf, new C48781());
            }
            C7358b[] c7358bArr = new C7358b[dMf.size()];
            dMf.toArray(c7358bArr);
            int length = c7358bArr.length;
            int i = 0;
            while (i < length && (!((C4884c) c7358bArr[i].f2002d).mo4653a(c4883b) || !c4883b.dnT())) {
                i++;
            }
            if (c4883b.callback != null) {
                c4883b.callback.run();
            }
            AppMethodBeat.m2505o(115153);
        }

        /* renamed from: b */
        public final C7358b<C4884c> mo10063b(C4884c c4884c) {
            AppMethodBeat.m2504i(115154);
            C7358b a = mo11556a(new C7358b(c4884c, this));
            AppMethodBeat.m2505o(115154);
            return a;
        }

        /* renamed from: f */
        public final void mo10064f(C4884c c4884c) {
            AppMethodBeat.m2504i(115155);
            mo11557b(new C7358b(c4884c, this));
            AppMethodBeat.m2505o(115155);
        }
    }

    static {
        AppMethodBeat.m2504i(115166);
        AppMethodBeat.m2505o(115166);
    }

    private C4879a() {
        AppMethodBeat.m2504i(115156);
        AppMethodBeat.m2505o(115156);
    }

    /* renamed from: b */
    public final C7358b<C4884c> mo10051b(C4884c c4884c) {
        C7358b<C4884c> b;
        AppMethodBeat.m2504i(115157);
        synchronized (this) {
            try {
                Assert.assertNotNull("EventPoolImpl.add", c4884c);
                C4990ab.m7419v("MicroMsg.EventCenter", "addListener %s(%d)", c4884c, Integer.valueOf(c4884c.dnS()));
                C4882b c4882b = (C4882b) this.xxC.get(Integer.valueOf(c4884c.dnS()));
                if (c4882b == null) {
                    HashMap hashMap = this.xxC;
                    Integer valueOf = Integer.valueOf(c4884c.dnS());
                    c4882b = new C4882b();
                    hashMap.put(valueOf, c4882b);
                }
                b = c4882b.mo10063b(c4884c);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115157);
            }
        }
        return b;
    }

    @Deprecated
    /* renamed from: c */
    public final boolean mo10052c(C4884c c4884c) {
        AppMethodBeat.m2504i(115158);
        synchronized (this) {
            try {
                Assert.assertNotNull("EventPoolImpl.add", c4884c);
                C4990ab.m7419v("MicroMsg.EventCenter", "addListener %s(%d)", c4884c, Integer.valueOf(c4884c.dnS()));
                LinkedList linkedList = (LinkedList) this.xxB.get(Integer.valueOf(c4884c.dnS()));
                if (linkedList == null) {
                    HashMap hashMap = this.xxB;
                    Integer valueOf = Integer.valueOf(c4884c.dnS());
                    linkedList = new LinkedList();
                    hashMap.put(valueOf, linkedList);
                }
                if (linkedList.contains(c4884c)) {
                } else {
                    ListenerInstanceMonitor.m7382cA(c4884c);
                    boolean add = linkedList.add(c4884c);
                    AppMethodBeat.m2505o(115158);
                    return add;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115158);
            }
        }
        return true;
    }

    @Deprecated
    /* renamed from: d */
    public final boolean mo10053d(C4884c c4884c) {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.m2504i(115159);
        synchronized (this) {
            try {
                Assert.assertNotNull("EventPoolImpl.remove", c4884c);
                C4990ab.m7419v("MicroMsg.EventCenter", "removeListener %s(%d)", c4884c, Integer.valueOf(c4884c.dnS()));
                LinkedList linkedList = (LinkedList) this.xxB.get(Integer.valueOf(c4884c.dnS()));
                if (linkedList != null) {
                    z2 = linkedList.remove(c4884c);
                }
                C4882b c4882b = (C4882b) this.xxC.get(Integer.valueOf(c4884c.dnS()));
                if (c4882b != null) {
                    c4882b.mo10064f(c4884c);
                    z = true;
                } else {
                    z = z2;
                }
                ListenerInstanceMonitor.m7383cB(c4884c);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(115159);
            }
        }
        return z;
    }

    /* renamed from: m */
    public final boolean mo10055m(C4883b c4883b) {
        C4882b c4882b;
        boolean z = false;
        boolean z2 = true;
        AppMethodBeat.m2504i(115160);
        Assert.assertNotNull("EventPoolImpl.publish", c4883b);
        C4990ab.m7419v("MicroMsg.EventCenter", "publish %s(%d)", c4883b, Integer.valueOf(c4883b.dnS()));
        LinkedList linkedList = null;
        synchronized (this) {
            try {
                int dnS = c4883b.dnS();
                LinkedList linkedList2 = (LinkedList) this.xxB.get(Integer.valueOf(dnS));
                if (linkedList2 != null) {
                    linkedList = new LinkedList(linkedList2);
                    z = true;
                }
                c4882b = (C4882b) this.xxC.get(Integer.valueOf(dnS));
                if (c4882b == null) {
                    z2 = z;
                }
                if (!z2) {
                    C4990ab.m7421w("MicroMsg.EventCenter", "No listener for this event %s(%d), Stack: %s.", c4883b, Integer.valueOf(dnS), "");
                }
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(115160);
                }
            }
        }
        if (linkedList != null) {
            m7245a(linkedList, c4883b);
        }
        if (c4882b != null) {
            c4882b.mo10062a(C5698f.m8560cV(c4883b));
        }
        AppMethodBeat.m2505o(115160);
        return z2;
    }

    /* renamed from: a */
    public final void mo10048a(final C4883b c4883b, Looper looper) {
        AppMethodBeat.m2504i(115161);
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", c4883b);
        Assert.assertNotNull("EventPoolImpl.asyncPublish looper", looper);
        C4990ab.m7419v("MicroMsg.EventCenter", "publish %s(%d)", c4883b, Integer.valueOf(c4883b.dnS()));
        new C7306ak(looper).post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(115146);
                C4879a.xxA.mo10055m(c4883b);
                AppMethodBeat.m2505o(115146);
            }
        });
        AppMethodBeat.m2505o(115161);
    }

    /* renamed from: a */
    public final void mo10049a(final C4883b c4883b, Executor executor) {
        AppMethodBeat.m2504i(115162);
        Assert.assertNotNull("EventPoolImpl.asyncPublish event", c4883b);
        Assert.assertNotNull("EventPoolImpl.asyncPublish executor", executor);
        C4990ab.m7419v("MicroMsg.EventCenter", "publish %s(%d)", c4883b, Integer.valueOf(c4883b.dnS()));
        executor.execute(new C4967b() {
            public final String getKey() {
                AppMethodBeat.m2504i(115147);
                String name = c4883b.getClass().getName();
                AppMethodBeat.m2505o(115147);
                return name;
            }

            public final void run() {
                AppMethodBeat.m2504i(115148);
                C4879a.xxA.mo10055m(c4883b);
                AppMethodBeat.m2505o(115148);
            }
        });
        AppMethodBeat.m2505o(115162);
    }

    /* renamed from: av */
    public final synchronized boolean mo10050av(Class<? extends C4883b> cls) {
        boolean z;
        AppMethodBeat.m2504i(115163);
        Assert.assertNotNull("EventPoolImpl.hasListener", cls);
        LinkedList linkedList = (LinkedList) this.xxB.get(Integer.valueOf(cls.getName().hashCode()));
        if (linkedList == null || linkedList.size() <= 0) {
            C4882b c4882b = (C4882b) this.xxC.get(Integer.valueOf(cls.getName().hashCode()));
            if (c4882b == null || c4882b.size() <= 0) {
                z = false;
                AppMethodBeat.m2505o(115163);
            } else {
                AppMethodBeat.m2505o(115163);
                z = true;
            }
        } else {
            AppMethodBeat.m2505o(115163);
            z = true;
        }
        return z;
    }

    /* renamed from: e */
    public final synchronized boolean mo10054e(C4884c c4884c) {
        boolean z;
        AppMethodBeat.m2504i(115164);
        Assert.assertNotNull("EventPoolImpl.hadListened", c4884c);
        LinkedList linkedList = (LinkedList) this.xxB.get(Integer.valueOf(c4884c.dnS()));
        if (linkedList == null || linkedList.isEmpty() || !linkedList.contains(c4884c)) {
            C4882b c4882b = (C4882b) this.xxC.get(Integer.valueOf(c4884c.dnS()));
            if (c4882b == null || c4882b.size() <= 0 || !c4882b.contains(c4884c)) {
                z = false;
                AppMethodBeat.m2505o(115164);
            } else {
                AppMethodBeat.m2505o(115164);
                z = true;
            }
        } else {
            AppMethodBeat.m2505o(115164);
            z = true;
        }
        return z;
    }

    /* renamed from: a */
    private void m7245a(LinkedList<C4884c> linkedList, C4883b c4883b) {
        AppMethodBeat.m2504i(115165);
        if (c4883b.dnT()) {
            Collections.sort(linkedList, new C48773());
        }
        C4884c[] c4884cArr = new C4884c[linkedList.size()];
        linkedList.toArray(c4884cArr);
        int length = c4884cArr.length;
        int i = 0;
        while (i < length && (!c4884cArr[i].mo4653a(c4883b) || !c4883b.dnT())) {
            i++;
        }
        if (c4883b.callback != null) {
            c4883b.callback.run();
        }
        AppMethodBeat.m2505o(115165);
    }
}
