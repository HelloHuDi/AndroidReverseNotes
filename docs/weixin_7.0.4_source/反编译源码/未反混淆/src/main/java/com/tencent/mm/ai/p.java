package com.tencent.mm.ai;

import android.os.Looper;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ListenerInstanceMonitor;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import junit.framework.Assert;

public final class p implements f {
    private static int ftK = 1;
    private static p ftz = null;
    public boolean foreground = false;
    public e ftA;
    public al ftB = null;
    private Vector<m> ftC = new Vector();
    private Vector<m> ftD = new Vector();
    private final Map<Integer, Set<f>> ftE = new HashMap();
    public Boolean ftF = null;
    private final a ftG;
    private long ftH = 21600000;
    private boolean ftI = false;
    private ap ftJ = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            boolean z = false;
            AppMethodBeat.i(58170);
            if (p.this.ftG == null) {
                AppMethodBeat.o(58170);
                return false;
            }
            ab.v("MicroMsg.NetSceneQueue", "onQueueIdle, running=%d, waiting=%d, foreground=%b", Integer.valueOf(p.this.ftC.size()), Integer.valueOf(p.this.ftD.size()), Boolean.valueOf(p.this.foreground));
            a b = p.this.ftG;
            p pVar = p.this;
            if (p.this.ftI && p.this.ftC.isEmpty() && p.this.ftD.isEmpty()) {
                z = true;
            }
            b.a(pVar, z);
            AppMethodBeat.o(58170);
            return true;
        }
    }, true);
    private final ak handler = new ak(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            AppMethodBeat.i(58171);
            p.this.a((m) message.obj, 0);
            AppMethodBeat.o(58171);
        }
    };
    private final Object lock = new Object();

    public interface a {
        void a(p pVar);

        void a(p pVar, boolean z);
    }

    static /* synthetic */ void k(p pVar) {
        AppMethodBeat.i(58210);
        pVar.acX();
        AppMethodBeat.o(58210);
    }

    public final void cD(boolean z) {
        AppMethodBeat.i(58181);
        this.ftI = z;
        if (this.ftI) {
            ab.e("MicroMsg.NetSceneQueue", "the working process is ready to be killed");
            ap apVar = this.ftJ;
            long j = this.ftH;
            apVar.ae(j, j);
            AppMethodBeat.o(58181);
            return;
        }
        this.ftJ.stopTimer();
        AppMethodBeat.o(58181);
    }

    public final void a(int i, String str, int i2, boolean z) {
        AppMethodBeat.i(58182);
        if (this.ftA == null) {
            ab.e("MicroMsg.NetSceneQueue", "logUtil autoAuth  == null");
            AppMethodBeat.o(58182);
            return;
        }
        this.ftA.a(i, str, i2, z);
        AppMethodBeat.o(58182);
    }

    public final void cE(boolean z) {
        AppMethodBeat.i(58183);
        this.foreground = z;
        this.ftF = Boolean.valueOf(z);
        b.cE(z);
        WXHardCoderJNI.foreground = z;
        if (this.ftA == null) {
            ab.e("MicroMsg.NetSceneQueue", "setForeground autoAuth  == null");
            AppMethodBeat.o(58183);
            return;
        }
        this.ftA.cF(z);
        AppMethodBeat.o(58183);
    }

    public final int acS() {
        AppMethodBeat.i(58184);
        try {
            if (this.ftA == null || this.ftA.adh() == null) {
                ab.e("MicroMsg.NetSceneQueue", "[arthurdan.getNetworkStatus] Notice!!! autoAuth and autoAuth.getNetworkEvent() is null!!!!");
                if (at.isConnected(ah.getContext())) {
                    AppMethodBeat.o(58184);
                    return 6;
                }
                AppMethodBeat.o(58184);
                return 0;
            }
            int amP = this.ftA.adh().amP();
            AppMethodBeat.o(58184);
            return amP;
        } catch (Exception e) {
            ab.e("MicroMsg.NetSceneQueue", "exception:%s", bo.l(e));
        }
    }

    public final boolean acT() {
        AppMethodBeat.i(58185);
        if (this.ftA != null) {
            boolean acT = this.ftA.acT();
            AppMethodBeat.o(58185);
            return acT;
        }
        AppMethodBeat.o(58185);
        return true;
    }

    public final String getNetworkServerIp() {
        AppMethodBeat.i(58186);
        String networkServerIp;
        if (this.ftA != null) {
            networkServerIp = this.ftA.getNetworkServerIp();
            AppMethodBeat.o(58186);
            return networkServerIp;
        }
        networkServerIp = "unknown";
        AppMethodBeat.o(58186);
        return networkServerIp;
    }

    private p(a aVar) {
        AppMethodBeat.i(58187);
        this.ftG = aVar;
        AppMethodBeat.o(58187);
    }

    public final void d(e eVar) {
        AppMethodBeat.i(58188);
        this.ftA = eVar;
        eVar.cF(this.foreground);
        acX();
        AppMethodBeat.o(58188);
    }

    public static p a(a aVar) {
        AppMethodBeat.i(58189);
        if (ftz == null) {
            ftz = new p(aVar);
        }
        p pVar = ftz;
        AppMethodBeat.o(58189);
        return pVar;
    }

    public final void a(int i, f fVar) {
        AppMethodBeat.i(58190);
        synchronized (this.ftE) {
            try {
                if (!this.ftE.containsKey(Integer.valueOf(i))) {
                    this.ftE.put(Integer.valueOf(i), new HashSet());
                }
                if (!((Set) this.ftE.get(Integer.valueOf(i))).contains(fVar) && ((Set) this.ftE.get(Integer.valueOf(i))).add(fVar)) {
                    ListenerInstanceMonitor.cA(fVar);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(58190);
            }
        }
    }

    public final void b(int i, f fVar) {
        AppMethodBeat.i(58191);
        synchronized (this.ftE) {
            try {
                if (this.ftE.get(Integer.valueOf(i)) != null && ((Set) this.ftE.get(Integer.valueOf(i))).remove(fVar)) {
                    ListenerInstanceMonitor.cB(fVar);
                }
            } catch (Exception e) {
            }
            try {
            } finally {
                while (true) {
                }
                AppMethodBeat.o(58191);
            }
        }
    }

    public final void reset() {
        AppMethodBeat.i(58192);
        if (this.ftA != null) {
            this.ftA.reset();
        }
        acV();
        acU();
        AppMethodBeat.o(58192);
    }

    private void acU() {
        AppMethodBeat.i(58193);
        Vector<m> vector = this.ftD;
        this.ftD = new Vector();
        for (m mVar : vector) {
            ab.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + mVar.getType());
            mVar.cancel();
            b(3, -1, "doScene failed clearWaitingQueue", mVar);
        }
        vector.clear();
        AppMethodBeat.o(58193);
    }

    public final void acV() {
        AppMethodBeat.i(58194);
        Vector<m> vector = this.ftC;
        this.ftC = new Vector();
        for (m mVar : vector) {
            ab.i("MicroMsg.NetSceneQueue", "reset::cancel scene " + mVar.getType());
            mVar.cancel();
            b(3, -1, "doScene failed clearRunningQueue", mVar);
        }
        vector.clear();
        AppMethodBeat.o(58194);
    }

    public final void acW() {
        AppMethodBeat.i(58195);
        ab.i("MicroMsg.NetSceneQueue", "resetDispatcher");
        if (this.ftA != null) {
            this.ftA.reset();
            this.ftA = null;
        }
        AppMethodBeat.o(58195);
    }

    public final e Rk() {
        return this.ftA;
    }

    public final void cancel(final int i) {
        AppMethodBeat.i(58196);
        ab.c("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(i));
        this.ftB.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(58172);
                p.a(p.this, i);
                AppMethodBeat.o(58172);
            }

            public final String toString() {
                AppMethodBeat.i(58173);
                String str = super.toString() + "|cancelImp_" + i;
                AppMethodBeat.o(58173);
                return str;
            }
        });
        AppMethodBeat.o(58196);
    }

    public final void kX(final int i) {
        AppMethodBeat.i(58197);
        ab.c("MicroMsg.NetSceneQueue", "cancelAllImp sceneHashCode:%d", Integer.valueOf(i));
        this.ftB.aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(58174);
                p.b(p.this, i);
                AppMethodBeat.o(58174);
            }

            public final String toString() {
                AppMethodBeat.i(58175);
                String str = super.toString() + "|cancelImp_" + i;
                AppMethodBeat.o(58175);
                return str;
            }
        });
        AppMethodBeat.o(58197);
    }

    public final void c(m mVar) {
        AppMethodBeat.i(58198);
        if (mVar == null) {
            AppMethodBeat.o(58198);
            return;
        }
        ab.c("MicroMsg.NetSceneQueue", "cancel sceneHashCode:%d", Integer.valueOf(mVar.hashCode()));
        mVar.cancel();
        synchronized (this.lock) {
            try {
                this.ftD.remove(mVar);
                this.ftC.remove(mVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(58198);
            }
        }
    }

    public final boolean d(m mVar) {
        AppMethodBeat.i(139008);
        boolean a = a(mVar, 0);
        AppMethodBeat.o(139008);
        return a;
    }

    public final boolean a(m mVar, int i) {
        AppMethodBeat.i(58200);
        boolean z = mVar != null || i >= 0;
        Assert.assertTrue(z);
        String str = "worker thread has not been set";
        if (this.ftB != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        if (e(mVar)) {
            b(mVar, i);
            AppMethodBeat.o(58200);
            return true;
        }
        AppMethodBeat.o(58200);
        return false;
    }

    private void b(final m mVar, int i) {
        int i2 = 0;
        AppMethodBeat.i(58201);
        boolean acY = acY();
        int size = this.ftC.size();
        String str = "MicroMsg.NetSceneQueue";
        String str2 = "doSceneImp start: mmcgi type:%d hash[%d,%d] run:%d wait:%d afterSec:%d canDo:%b autoauth:%d";
        Object[] objArr = new Object[8];
        objArr[0] = Integer.valueOf(mVar.getType());
        objArr[1] = Integer.valueOf(mVar.hashCode());
        objArr[2] = Integer.valueOf(mVar.acO());
        objArr[3] = Integer.valueOf(size);
        objArr[4] = Integer.valueOf(this.ftD.size());
        objArr[5] = Integer.valueOf(i);
        objArr[6] = Boolean.valueOf(acY);
        if (this.ftA != null) {
            i2 = this.ftA.hashCode();
        }
        objArr[7] = Integer.valueOf(i2);
        ab.i(str, str2, objArr);
        if (i == 0 && acY && this.ftA != null) {
            synchronized (this.lock) {
                try {
                    this.ftC.add(mVar);
                    if (size == this.ftC.size()) {
                        ab.w("MicroMsg.NetSceneQueue", "doSceneImp mmcgi  Add to runningQueue wrong  type:%d hash:%d run:[%d ,%d] wait:%d ", Integer.valueOf(mVar.getType()), Integer.valueOf(mVar.hashCode()), Integer.valueOf(size), Integer.valueOf(this.ftC.size()), Integer.valueOf(this.ftD.size()));
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(58201);
                    }
                }
            }
            this.ftB.aa(new Runnable() {
                public final void run() {
                    int i;
                    String str;
                    String str2;
                    Object[] objArr;
                    int i2 = 0;
                    AppMethodBeat.i(58177);
                    mVar.ftj = p.this;
                    if (mVar.bqV || p.this.ftA == null) {
                        i = 0;
                    } else {
                        i = mVar.a(p.this.ftA, p.this);
                        if (i >= 0) {
                            str = "MicroMsg.NetSceneQueue";
                            str2 = "On doscene  mmcgi type:%d hash[%d,%d] run:%d wait:%d ret:%d autoauth:%d";
                            objArr = new Object[7];
                            objArr[0] = Integer.valueOf(mVar.getType());
                            objArr[1] = Integer.valueOf(mVar.hashCode());
                            objArr[2] = Integer.valueOf(mVar.acO());
                            objArr[3] = Integer.valueOf(p.this.ftC.size());
                            objArr[4] = Integer.valueOf(p.this.ftD.size());
                            objArr[5] = Integer.valueOf(i);
                            if (p.this.ftA == null) {
                                i = 0;
                            } else {
                                i = p.this.ftA.hashCode();
                            }
                            objArr[6] = Integer.valueOf(i);
                            ab.i(str, str2, objArr);
                            mVar.ftk = false;
                            AppMethodBeat.o(58177);
                        }
                    }
                    str = "MicroMsg.NetSceneQueue";
                    str2 = "doscene mmcgi Failed type:%d hash[%d,%d] cancel[%b] run:%d wait:%d ret:%d autoauth:%d";
                    objArr = new Object[8];
                    objArr[0] = Integer.valueOf(mVar.getType());
                    objArr[1] = Integer.valueOf(mVar.hashCode());
                    objArr[2] = Integer.valueOf(mVar.acO());
                    objArr[3] = Boolean.valueOf(mVar.bqV);
                    objArr[4] = Integer.valueOf(p.this.ftC.size());
                    objArr[5] = Integer.valueOf(p.this.ftD.size());
                    objArr[6] = Integer.valueOf(i);
                    if (p.this.ftA != null) {
                        i2 = p.this.ftA.hashCode();
                    }
                    objArr[7] = Integer.valueOf(i2);
                    ab.w(str, str2, objArr);
                    mVar.ftj = null;
                    synchronized (p.this.lock) {
                        try {
                            p.this.ftC.remove(mVar);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(58177);
                        }
                    }
                    if (!mVar.bqV) {
                        p.this.handler.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(58176);
                                p.this.onSceneEnd(3, -1, "doScene failed", mVar);
                                AppMethodBeat.o(58176);
                            }
                        });
                        return;
                    }
                    AppMethodBeat.o(58177);
                }

                public final String toString() {
                    AppMethodBeat.i(58178);
                    String str = super.toString() + "|doSceneImp_" + mVar + "_type=" + mVar.getType();
                    AppMethodBeat.o(58178);
                    return str;
                }
            });
        } else if (i > 0) {
            Message obtain = Message.obtain();
            obtain.obj = mVar;
            this.handler.sendMessageDelayed(obtain, (long) i);
            ab.i("MicroMsg.NetSceneQueue", "timed: type=" + mVar.getType() + " id=" + mVar.hashCode() + " cur_after_sec=" + i);
        } else {
            ab.i("MicroMsg.NetSceneQueue", "waited: type=" + mVar.getType() + " id=" + mVar.hashCode() + " cur_waiting_cnt=" + this.ftD.size());
            synchronized (this.lock) {
                try {
                    this.ftD.add(mVar);
                } catch (Throwable th2) {
                    while (true) {
                        AppMethodBeat.o(58201);
                    }
                }
            }
            ab.i("MicroMsg.NetSceneQueue", "waitingQueue_size = " + this.ftD.size());
        }
        if (this.ftA == null) {
            acZ();
            AppMethodBeat.o(58201);
            return;
        }
        ftK = 1;
        AppMethodBeat.o(58201);
    }

    private void b(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(58203);
        final m mVar2 = mVar;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        this.handler.post(new Runnable() {
            public final void run() {
                HashSet<f> hashSet;
                AppMethodBeat.i(58179);
                Set set = (Set) p.this.ftE.get(Integer.valueOf(mVar2.getType()));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (f fVar : hashSet) {
                        if (fVar != null && set.contains(fVar)) {
                            fVar.onSceneEnd(i3, i4, str2, mVar2);
                        }
                    }
                }
                set = (Set) p.this.ftE.get(Integer.valueOf(-1));
                if (set != null && set.size() > 0) {
                    hashSet = new HashSet();
                    hashSet.addAll(set);
                    for (f fVar2 : hashSet) {
                        if (fVar2 != null && set.contains(fVar2)) {
                            fVar2.onSceneEnd(i3, i4, str2, mVar2);
                        }
                    }
                }
                AppMethodBeat.o(58179);
            }
        });
        AppMethodBeat.o(58203);
    }

    private void acX() {
        AppMethodBeat.i(58204);
        synchronized (this.lock) {
            try {
                if (this.ftD.size() > 0) {
                    m mVar = (m) this.ftD.get(0);
                    int i = mVar.priority;
                    int i2 = 1;
                    m mVar2 = mVar;
                    while (i2 < this.ftD.size()) {
                        if (((m) this.ftD.get(i2)).priority > i) {
                            this.ftD.get(i2);
                            if (acY()) {
                                mVar = (m) this.ftD.get(i2);
                                i = mVar.priority;
                                i2++;
                                mVar2 = mVar;
                            }
                        }
                        mVar = mVar2;
                        i2++;
                        mVar2 = mVar;
                    }
                    this.ftD.remove(mVar2);
                    ab.i("MicroMsg.NetSceneQueue", "waiting2running waitingQueue_size = " + this.ftD.size());
                    b(mVar2, 0);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(58204);
            }
        }
    }

    private boolean acY() {
        AppMethodBeat.i(58205);
        if (this.ftC.size() >= 50) {
            AppMethodBeat.o(58205);
            return false;
        }
        AppMethodBeat.o(58205);
        return true;
    }

    private boolean e(m mVar) {
        AppMethodBeat.i(58206);
        int type = mVar.getType();
        if (mVar.acI()) {
            synchronized (this.lock) {
                try {
                    m mVar2;
                    Iterator it = this.ftC.iterator();
                    while (it.hasNext()) {
                        mVar2 = (m) it.next();
                        if (mVar2.getType() == type) {
                            ab.i("MicroMsg.NetSceneQueue", "forbid in running: type=" + mVar.getType() + " id=" + mVar.hashCode() + " cur_running_cnt=" + this.ftC.size());
                            if (mVar.b(mVar2)) {
                            } else if (mVar.a(mVar2)) {
                                ab.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + mVar.getType() + " id=" + mVar.hashCode() + " cur_running_cnt=" + this.ftC.size() + " ---" + mVar2.hashCode());
                                if (!this.foreground) {
                                    ab.e("MicroMsg.NetSceneQueue", "forbid in running diagnostic: type=" + mVar.getType() + "acinfo[" + mVar2.getInfo() + "] scinfo[" + mVar.getInfo() + "]");
                                    ab.dot();
                                    Assert.assertTrue("NetsceneQueue forbid in running diagnostic: type=" + mVar.getType(), false);
                                }
                                c(mVar2);
                                AppMethodBeat.o(58206);
                                return true;
                            } else {
                                AppMethodBeat.o(58206);
                                return false;
                            }
                        }
                    }
                    it = this.ftD.iterator();
                    while (it.hasNext()) {
                        mVar2 = (m) it.next();
                        if (mVar2.getType() == type) {
                            ab.i("MicroMsg.NetSceneQueue", "forbid in waiting: type=" + mVar.getType() + " id=" + mVar.hashCode() + " cur_waiting_cnt=" + this.ftD.size());
                            if (mVar.b(mVar2)) {
                                AppMethodBeat.o(58206);
                                return true;
                            } else if (mVar.a(mVar2)) {
                                ab.e("MicroMsg.NetSceneQueue", "forbid in waiting diagnostic: type=" + mVar.getType() + " id=" + mVar.hashCode() + " cur_waiting_cnt=" + this.ftD.size() + " ---" + mVar2.hashCode());
                                if (!this.foreground) {
                                    ab.dot();
                                    Assert.assertTrue("NetsceneQueue forbid in waiting diagnostic: type=" + mVar.getType(), false);
                                }
                                c(mVar2);
                                AppMethodBeat.o(58206);
                                return true;
                            } else {
                                AppMethodBeat.o(58206);
                                return false;
                            }
                        }
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(58206);
                }
            }
        }
        AppMethodBeat.o(58206);
        return true;
        return true;
    }

    private void acZ() {
        AppMethodBeat.i(58207);
        if (this.ftG == null) {
            ab.e("MicroMsg.NetSceneQueue", "prepare dispatcher failed, queue idle:%s", this.ftG);
            AppMethodBeat.o(58207);
            return;
        }
        this.ftG.a(this);
        ap apVar = new ap(Looper.getMainLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            private long ftP = 10;

            public final boolean BI() {
                AppMethodBeat.i(58180);
                if (p.this.ftA == null) {
                    long j = this.ftP;
                    this.ftP = j - 1;
                    if (j > 0) {
                        AppMethodBeat.o(58180);
                        return true;
                    }
                }
                p.k(p.this);
                AppMethodBeat.o(58180);
                return false;
            }
        }, true);
        long j = (long) (ftK * 100);
        apVar.ae(j, j);
        if (ftK < 512) {
            ftK *= 2;
        }
        AppMethodBeat.o(58207);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        int i3 = 0;
        AppMethodBeat.i(58202);
        mVar.ftk = true;
        synchronized (this.lock) {
            try {
                this.ftC.remove(mVar);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(58202);
                }
            }
        }
        String str2 = "MicroMsg.NetSceneQueue";
        String str3 = "onSceneEnd mmcgi type:%d hash[%d,%d] run:%d wait:%d autoauth:%d [%d,%d,%s]";
        Object[] objArr = new Object[9];
        objArr[0] = Integer.valueOf(mVar.getType());
        objArr[1] = Integer.valueOf(mVar.hashCode());
        objArr[2] = Integer.valueOf(mVar.acO());
        objArr[3] = Integer.valueOf(this.ftC.size());
        objArr[4] = Integer.valueOf(this.ftD.size());
        if (this.ftA != null) {
            i3 = this.ftA.hashCode();
        }
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(i);
        objArr[7] = Integer.valueOf(i2);
        objArr[8] = str;
        ab.i(str2, str3, objArr);
        acX();
        b(i, i2, str, mVar);
        if (this.ftI && this.ftC.isEmpty() && this.ftD.isEmpty()) {
            ap apVar = this.ftJ;
            long j = this.ftH;
            apVar.ae(j, j);
        }
        AppMethodBeat.o(58202);
    }
}
