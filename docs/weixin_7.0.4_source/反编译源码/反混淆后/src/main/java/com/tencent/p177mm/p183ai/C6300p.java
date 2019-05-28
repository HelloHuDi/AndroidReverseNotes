package com.tencent.p177mm.p183ai;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.sdk.platformtools.ListenerInstanceMonitor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.ai.p */
public final class C6300p implements C1202f {
    private static int ftK = 1;
    private static C6300p ftz = null;
    public boolean foreground = false;
    public C1902e ftA;
    public C5004al ftB = null;
    private Vector<C1207m> ftC = new Vector();
    private Vector<C1207m> ftD = new Vector();
    private final Map<Integer, Set<C1202f>> ftE = new HashMap();
    public Boolean ftF = null;
    private final C1213a ftG;
    private long ftH = 21600000;
    private boolean ftI = false;
    private C7564ap ftJ = new C7564ap(Looper.getMainLooper(), new C62981(), true);
    private final C7306ak handler = new C7306ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(58171);
            C6300p.this.mo14541a((C1207m) message.obj, 0);
            AppMethodBeat.m2505o(58171);
        }
    };
    private final Object lock = new Object();

    /* renamed from: com.tencent.mm.ai.p$a */
    public interface C1213a {
        /* renamed from: a */
        void mo4483a(C6300p c6300p);

        /* renamed from: a */
        void mo4484a(C6300p c6300p, boolean z);
    }

    /* renamed from: com.tencent.mm.ai.p$1 */
    class C62981 implements C5015a {
        C62981() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            boolean z = false;
            AppMethodBeat.m2504i(58170);
            if (C6300p.this.ftG == null) {
                AppMethodBeat.m2505o(58170);
                return false;
            }
            C4990ab.m7419v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", Integer.valueOf(C6300p.this.ftC.size()), Integer.valueOf(C6300p.this.ftD.size()), Boolean.valueOf(C6300p.this.foreground));
            C1213a b = C6300p.this.ftG;
            C6300p c6300p = C6300p.this;
            if (C6300p.this.ftI && C6300p.this.ftC.isEmpty() && C6300p.this.ftD.isEmpty()) {
                z = true;
            }
            b.mo4484a(c6300p, z);
            AppMethodBeat.m2505o(58170);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.ai.p$7 */
    class C62997 implements C5015a {
        private long ftP = 10;

        C62997() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(58180);
            if (C6300p.this.ftA == null) {
                long j = this.ftP;
                this.ftP = j - 1;
                if (j > 0) {
                    AppMethodBeat.m2505o(58180);
                    return true;
                }
            }
            C6300p.m10358k(C6300p.this);
            AppMethodBeat.m2505o(58180);
            return false;
        }
    }

    /* renamed from: k */
    static /* synthetic */ void m10358k(C6300p c6300p) {
        AppMethodBeat.m2504i(58210);
        c6300p.acX();
        AppMethodBeat.m2505o(58210);
    }

    /* renamed from: cD */
    public final void mo14548cD(boolean z) {
        AppMethodBeat.m2504i(58181);
        this.ftI = z;
        if (this.ftI) {
            C4990ab.m7412e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
            C7564ap c7564ap = this.ftJ;
            long j = this.ftH;
            c7564ap.mo16770ae(j, j);
            AppMethodBeat.m2505o(58181);
            return;
        }
        this.ftJ.stopTimer();
        AppMethodBeat.m2505o(58181);
    }

    /* renamed from: a */
    public final void mo14540a(int i, String str, int i2, boolean z) {
        AppMethodBeat.m2504i(58182);
        if (this.ftA == null) {
            C4990ab.m7412e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
            AppMethodBeat.m2505o(58182);
            return;
        }
        this.ftA.mo5520a(i, str, i2, z);
        AppMethodBeat.m2505o(58182);
    }

    /* renamed from: cE */
    public final void mo14549cE(boolean z) {
        AppMethodBeat.m2504i(58183);
        this.foreground = z;
        this.ftF = Boolean.valueOf(z);
        C4872b.m7236cE(z);
        WXHardCoderJNI.foreground = z;
        if (this.ftA == null) {
            C4990ab.m7412e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
            AppMethodBeat.m2505o(58183);
            return;
        }
        this.ftA.mo5531cF(z);
        AppMethodBeat.m2505o(58183);
    }

    public final int acS() {
        AppMethodBeat.m2504i(58184);
        try {
            if (this.ftA == null || this.ftA.adh() == null) {
                C4990ab.m7412e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
                if (C5023at.isConnected(C4996ah.getContext())) {
                    AppMethodBeat.m2505o(58184);
                    return 6;
                }
                AppMethodBeat.m2505o(58184);
                return 0;
            }
            int amP = this.ftA.adh().amP();
            AppMethodBeat.m2505o(58184);
            return amP;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.NetSceneQueue", "exception:%s", C5046bo.m7574l(e));
        }
    }

    public final boolean acT() {
        AppMethodBeat.m2504i(58185);
        if (this.ftA != null) {
            boolean acT = this.ftA.acT();
            AppMethodBeat.m2505o(58185);
            return acT;
        }
        AppMethodBeat.m2505o(58185);
        return true;
    }

    public final String getNetworkServerIp() {
        AppMethodBeat.m2504i(58186);
        String networkServerIp;
        if (this.ftA != null) {
            networkServerIp = this.ftA.getNetworkServerIp();
            AppMethodBeat.m2505o(58186);
            return networkServerIp;
        }
        networkServerIp = "unknown";
        AppMethodBeat.m2505o(58186);
        return networkServerIp;
    }

    private C6300p(C1213a c1213a) {
        AppMethodBeat.m2504i(58187);
        this.ftG = c1213a;
        AppMethodBeat.m2505o(58187);
    }

    /* renamed from: d */
    public final void mo14551d(C1902e c1902e) {
        AppMethodBeat.m2504i(58188);
        this.ftA = c1902e;
        c1902e.mo5531cF(this.foreground);
        acX();
        AppMethodBeat.m2505o(58188);
    }

    /* renamed from: a */
    public static C6300p m10343a(C1213a c1213a) {
        AppMethodBeat.m2504i(58189);
        if (ftz == null) {
            ftz = new C6300p(c1213a);
        }
        C6300p c6300p = ftz;
        AppMethodBeat.m2505o(58189);
        return c6300p;
    }

    /* renamed from: a */
    public final void mo14539a(int i, C1202f c1202f) {
        AppMethodBeat.m2504i(58190);
        synchronized (this.ftE) {
            try {
                if (!this.ftE.containsKey(Integer.valueOf(i))) {
                    this.ftE.put(Integer.valueOf(i), new HashSet());
                }
                if (!((Set) this.ftE.get(Integer.valueOf(i))).contains(c1202f) && ((Set) this.ftE.get(Integer.valueOf(i))).add(c1202f)) {
                    ListenerInstanceMonitor.m7382cA(c1202f);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(58190);
            }
        }
    }

    /* renamed from: b */
    public final void mo14546b(int i, C1202f c1202f) {
        AppMethodBeat.m2504i(58191);
        synchronized (this.ftE) {
            try {
                if (this.ftE.get(Integer.valueOf(i)) != null && ((Set) this.ftE.get(Integer.valueOf(i))).remove(c1202f)) {
                    ListenerInstanceMonitor.m7383cB(c1202f);
                }
            } catch (Exception e) {
            }
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(58191);
            }
        }
    }

    public final void reset() {
        AppMethodBeat.m2504i(58192);
        if (this.ftA != null) {
            this.ftA.reset();
        }
        acV();
        acU();
        AppMethodBeat.m2505o(58192);
    }

    private void acU() {
        AppMethodBeat.m2504i(58193);
        Vector<C1207m> vector = this.ftD;
        this.ftD = new Vector();
        for (C1207m c1207m : vector) {
            C4990ab.m7416i("MicroMsg.NetSceneQueue", "reset::cancel scene " + c1207m.getType());
            c1207m.cancel();
            m10346b(3, -1, "doScene failed clearWaitingQueue", c1207m);
        }
        vector.clear();
        AppMethodBeat.m2505o(58193);
    }

    public final void acV() {
        AppMethodBeat.m2504i(58194);
        Vector<C1207m> vector = this.ftC;
        this.ftC = new Vector();
        for (C1207m c1207m : vector) {
            C4990ab.m7416i("MicroMsg.NetSceneQueue", "reset::cancel scene " + c1207m.getType());
            c1207m.cancel();
            m10346b(3, -1, "doScene failed clearRunningQueue", c1207m);
        }
        vector.clear();
        AppMethodBeat.m2505o(58194);
    }

    public final void acW() {
        AppMethodBeat.m2504i(58195);
        C4990ab.m7416i("MicroMsg.NetSceneQueue", "resetDispatcher");
        if (this.ftA != null) {
            this.ftA.reset();
            this.ftA = null;
        }
        AppMethodBeat.m2505o(58195);
    }

    /* renamed from: Rk */
    public final C1902e mo14538Rk() {
        return this.ftA;
    }

    public final void cancel(final int i) {
        AppMethodBeat.m2504i(58196);
        C4990ab.m7409c("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(i));
        this.ftB.mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(58172);
                C6300p.m10344a(C6300p.this, i);
                AppMethodBeat.m2505o(58172);
            }

            public final String toString() {
                AppMethodBeat.m2504i(58173);
                String str = super.toString() + "|cancelImp_" + i;
                AppMethodBeat.m2505o(58173);
                return str;
            }
        });
        AppMethodBeat.m2505o(58196);
    }

    /* renamed from: kX */
    public final void mo14554kX(final int i) {
        AppMethodBeat.m2504i(58197);
        C4990ab.m7409c("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(i));
        this.ftB.mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(58174);
                C6300p.m10348b(C6300p.this, i);
                AppMethodBeat.m2505o(58174);
            }

            public final String toString() {
                AppMethodBeat.m2504i(58175);
                String str = super.toString() + "|cancelImp_" + i;
                AppMethodBeat.m2505o(58175);
                return str;
            }
        });
        AppMethodBeat.m2505o(58197);
    }

    /* renamed from: c */
    public final void mo14547c(C1207m c1207m) {
        AppMethodBeat.m2504i(58198);
        if (c1207m == null) {
            AppMethodBeat.m2505o(58198);
            return;
        }
        C4990ab.m7409c("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(c1207m.hashCode()));
        c1207m.cancel();
        synchronized (this.lock) {
            try {
                this.ftD.remove(c1207m);
                this.ftC.remove(c1207m);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(58198);
            }
        }
    }

    /* renamed from: d */
    public final boolean mo14552d(C1207m c1207m) {
        AppMethodBeat.m2504i(139008);
        boolean a = mo14541a(c1207m, 0);
        AppMethodBeat.m2505o(139008);
        return a;
    }

    /* renamed from: a */
    public final boolean mo14541a(C1207m c1207m, int i) {
        AppMethodBeat.m2504i(58200);
        boolean z = c1207m != null || i >= 0;
        Assert.assertTrue(z);
        String str = "worker thread has not been set";
        if (this.ftB != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        if (m10351e(c1207m)) {
            m10347b(c1207m, i);
            AppMethodBeat.m2505o(58200);
            return true;
        }
        AppMethodBeat.m2505o(58200);
        return false;
    }

    /* renamed from: b */
    private void m10347b(final C1207m c1207m, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(58201);
        boolean acY = acY();
        int size = this.ftC.size();
        String str = "MicroMsg.NetSceneQueue";
        String str2 = "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(c1207m.getType());
        objArr[1] = Integer.valueOf(c1207m.hashCode());
        objArr[2] = Integer.valueOf(c1207m.acO());
        objArr[3] = Integer.valueOf(size);
        objArr[4] = Integer.valueOf(this.ftD.size());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Boolean.valueOf(acY);
        if (this.ftA != null) {
            i2 = this.ftA.hashCode();
        }
        objArr[7] = Integer.valueOf(i2);
        C4990ab.m7417i(str, str2, objArr);
        if (i == 0 && acY && this.ftA != null) {
            synchronized (this.lock) {
                try {
                    this.ftC.add(c1207m);
                    if (size == this.ftC.size()) {
                        C4990ab.m7421w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", Integer.valueOf(c1207m.getType()), Integer.valueOf(c1207m.hashCode()), Integer.valueOf(size), Integer.valueOf(this.ftC.size()), Integer.valueOf(this.ftD.size()));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(58201);
                    }
                }
            }
            this.ftB.mo10302aa(new Runnable() {

                /* renamed from: com.tencent.mm.ai.p$5$1 */
                class C12101 implements Runnable {
                    C12101() {
                    }

                    public final void run() {
                        AppMethodBeat.m2504i(58176);
                        C6300p.this.onSceneEnd(3, -1, "doScene failed", c1207m);
                        AppMethodBeat.m2505o(58176);
                    }
                }

                public final void run() {
                    int i;
                    String str;
                    String str2;
                    Object[] objArr;
                    int i2 = 0;
                    AppMethodBeat.m2504i(58177);
                    c1207m.ftj = C6300p.this;
                    if (c1207m.bqV || C6300p.this.ftA == null) {
                        i = 0;
                    } else {
                        i = c1207m.mo4456a(C6300p.this.ftA, C6300p.this);
                        if (i >= 0) {
                            str = "MicroMsg.NetSceneQueue";
                            str2 = "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d";
                            objArr = new Object[7];
                            objArr[0] = Integer.valueOf(c1207m.getType());
                            objArr[1] = Integer.valueOf(c1207m.hashCode());
                            objArr[2] = Integer.valueOf(c1207m.acO());
                            objArr[3] = Integer.valueOf(C6300p.this.ftC.size());
                            objArr[4] = Integer.valueOf(C6300p.this.ftD.size());
                            objArr[5] = Integer.valueOf(i);
                            if (C6300p.this.ftA == null) {
                                i = 0;
                            } else {
                                i = C6300p.this.ftA.hashCode();
                            }
                            objArr[6] = Integer.valueOf(i);
                            C4990ab.m7417i(str, str2, objArr);
                            c1207m.ftk = false;
                            AppMethodBeat.m2505o(58177);
                        }
                    }
                    str = "MicroMsg.NetSceneQueue";
                    str2 = "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d";
                    objArr = new Object[8];
                    objArr[0] = Integer.valueOf(c1207m.getType());
                    objArr[1] = Integer.valueOf(c1207m.hashCode());
                    objArr[2] = Integer.valueOf(c1207m.acO());
                    objArr[3] = Boolean.valueOf(c1207m.bqV);
                    objArr[4] = Integer.valueOf(C6300p.this.ftC.size());
                    objArr[5] = Integer.valueOf(C6300p.this.ftD.size());
                    objArr[6] = Integer.valueOf(i);
                    if (C6300p.this.ftA != null) {
                        i2 = C6300p.this.ftA.hashCode();
                    }
                    objArr[7] = Integer.valueOf(i2);
                    C4990ab.m7421w(str, str2, objArr);
                    c1207m.ftj = null;
                    synchronized (C6300p.this.lock) {
                        try {
                            C6300p.this.ftC.remove(c1207m);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.m2505o(58177);
                        }
                    }
                    if (!c1207m.bqV) {
                        C6300p.this.handler.post(new C12101());
                        return;
                    }
                    AppMethodBeat.m2505o(58177);
                }

                public final String toString() {
                    AppMethodBeat.m2504i(58178);
                    String str = super.toString() + "|doSceneImp_" + c1207m + "_type=" + c1207m.getType();
                    AppMethodBeat.m2505o(58178);
                    return str;
                }
            });
        } else if (i > 0) {
            Message obtain = Message.obtain();
            obtain.obj = c1207m;
            this.handler.sendMessageDelayed(obtain, (long) i);
            C4990ab.m7416i("MicroMsg.NetSceneQueue", "timed: type=" + c1207m.getType() + " id=" + c1207m.hashCode() + " cur_after_sec=" + i);
        } else {
            C4990ab.m7416i("MicroMsg.NetSceneQueue", "waited: type=" + c1207m.getType() + " id=" + c1207m.hashCode() + " cur_waiting_cnt=" + this.ftD.size());
            synchronized (this.lock) {
                try {
                    this.ftD.add(c1207m);
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.m2505o(58201);
                    }
                }
            }
            C4990ab.m7416i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.ftD.size());
        }
        if (this.ftA == null) {
            acZ();
            AppMethodBeat.m2505o(58201);
            return;
        }
        ftK = 1;
        AppMethodBeat.m2505o(58201);
    }

    /* renamed from: b */
    private void m10346b(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(58203);
        final C1207m c1207m2 = c1207m;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable() {
            public final void run() {
                HashSet<C1202f> hashSet;
                AppMethodBeat.m2504i(58179);
                Set set = (Set) C6300p.this.ftE.get(Integer.valueOf(c1207m2.getType()));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (C1202f c1202f : hashSet) {
                        if (c1202f != null && set.contains(c1202f)) {
                            c1202f.onSceneEnd(i3, i4, str2, c1207m2);
                        }
                    }
                }
                set = (Set) C6300p.this.ftE.get(Integer.valueOf(-1));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (C1202f c1202f2 : hashSet) {
                        if (c1202f2 != null && set.contains(c1202f2)) {
                            c1202f2.onSceneEnd(i3, i4, str2, c1207m2);
                        }
                    }
                }
                AppMethodBeat.m2505o(58179);
            }
        });
        AppMethodBeat.m2505o(58203);
    }

    private void acX() {
        AppMethodBeat.m2504i(58204);
        synchronized (this.lock) {
            try {
                if (this.ftD.size() > 0) {
                    C1207m c1207m = (C1207m) this.ftD.get(0);
                    int i = c1207m.priority;
                    int i2 = 1;
                    C1207m c1207m2 = c1207m;
                    while (i2 < this.ftD.size()) {
                        if (((C1207m) this.ftD.get(i2)).priority > i) {
                            this.ftD.get(i2);
                            if (acY()) {
                                c1207m = (C1207m) this.ftD.get(i2);
                                i = c1207m.priority;
                                i2++;
                                c1207m2 = c1207m;
                            }
                        }
                        c1207m = c1207m2;
                        i2++;
                        c1207m2 = c1207m;
                    }
                    this.ftD.remove(c1207m2);
                    C4990ab.m7416i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.ftD.size());
                    m10347b(c1207m2, 0);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(58204);
            }
        }
    }

    private boolean acY() {
        AppMethodBeat.m2504i(58205);
        if (this.ftC.size() >= 50) {
            AppMethodBeat.m2505o(58205);
            return false;
        }
        AppMethodBeat.m2505o(58205);
        return true;
    }

    /* renamed from: e */
    private boolean m10351e(C1207m c1207m) {
        AppMethodBeat.m2504i(58206);
        int type = c1207m.getType();
        if (c1207m.acI()) {
            synchronized (this.lock) {
                try {
                    C1207m c1207m2;
                    Iterator it = this.ftC.iterator();
                    while (it.hasNext()) {
                        c1207m2 = (C1207m) it.next();
                        if (c1207m2.getType() == type) {
                            C4990ab.m7416i("MicroMsg.NetSceneQueue", "forbid in running: type=" + c1207m.getType() + " id=" + c1207m.hashCode() + " cur_running_cnt=" + this.ftC.size());
                            if (c1207m.mo4469b(c1207m2)) {
                            } else if (c1207m.mo4459a(c1207m2)) {
                                C4990ab.m7412e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + c1207m.getType() + " id=" + c1207m.hashCode() + " cur_running_cnt=" + this.ftC.size() + " ---" + c1207m2.hashCode());
                                if (!this.foreground) {
                                    C4990ab.m7412e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + c1207m.getType() + "acinfo[" + c1207m2.getInfo() + "] scinfo[" + c1207m.getInfo() + "]");
                                    C4990ab.dot();
                                    Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + c1207m.getType(), false);
                                }
                                mo14547c(c1207m2);
                                AppMethodBeat.m2505o(58206);
                                return true;
                            } else {
                                AppMethodBeat.m2505o(58206);
                                return false;
                            }
                        }
                    }
                    it = this.ftD.iterator();
                    while (it.hasNext()) {
                        c1207m2 = (C1207m) it.next();
                        if (c1207m2.getType() == type) {
                            C4990ab.m7416i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + c1207m.getType() + " id=" + c1207m.hashCode() + " cur_waiting_cnt=" + this.ftD.size());
                            if (c1207m.mo4469b(c1207m2)) {
                                AppMethodBeat.m2505o(58206);
                                return true;
                            } else if (c1207m.mo4459a(c1207m2)) {
                                C4990ab.m7412e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + c1207m.getType() + " id=" + c1207m.hashCode() + " cur_waiting_cnt=" + this.ftD.size() + " ---" + c1207m2.hashCode());
                                if (!this.foreground) {
                                    C4990ab.dot();
                                    Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + c1207m.getType(), false);
                                }
                                mo14547c(c1207m2);
                                AppMethodBeat.m2505o(58206);
                                return true;
                            } else {
                                AppMethodBeat.m2505o(58206);
                                return false;
                            }
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(58206);
                }
            }
        }
        AppMethodBeat.m2505o(58206);
        return true;
        return true;
    }

    private void acZ() {
        AppMethodBeat.m2504i(58207);
        if (this.ftG == null) {
            C4990ab.m7413e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", this.ftG);
            AppMethodBeat.m2505o(58207);
            return;
        }
        this.ftG.mo4483a(this);
        C7564ap c7564ap = new C7564ap(Looper.getMainLooper(), new C62997(), true);
        long j = (long) (ftK * 100);
        c7564ap.mo16770ae(j, j);
        if (ftK < 512) {
            ftK *= 2;
        }
        AppMethodBeat.m2505o(58207);
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        int i3 = 0;
        AppMethodBeat.m2504i(58202);
        c1207m.ftk = true;
        synchronized (this.lock) {
            try {
                this.ftC.remove(c1207m);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(58202);
                }
            }
        }
        String str2 = "MicroMsg.NetSceneQueue";
        String str3 = "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(c1207m.getType());
        objArr[1] = Integer.valueOf(c1207m.hashCode());
        objArr[2] = Integer.valueOf(c1207m.acO());
        objArr[3] = Integer.valueOf(this.ftC.size());
        objArr[4] = Integer.valueOf(this.ftD.size());
        if (this.ftA != null) {
            i3 = this.ftA.hashCode();
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(i);
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = str;
        C4990ab.m7417i(str2, str3, objArr);
        acX();
        m10346b(i, i2, str, c1207m);
        if (this.ftI && this.ftC.isEmpty() && this.ftD.isEmpty()) {
            C7564ap c7564ap = this.ftJ;
            long j = this.ftH;
            c7564ap.mo16770ae(j, j);
        }
        AppMethodBeat.m2505o(58202);
    }
}
