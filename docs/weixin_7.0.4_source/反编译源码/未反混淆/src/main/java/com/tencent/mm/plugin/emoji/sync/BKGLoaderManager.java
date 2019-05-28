package com.tencent.mm.plugin.emoji.sync;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.TrafficStats;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.a.cx;
import com.tencent.mm.g.a.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ap.a;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

public final class BKGLoaderManager implements d {
    int fDe;
    private Vector<c> kXA = new Vector();
    private Set<Object> kXB = new HashSet();
    public ConnectivityReceiver kXC;
    long kXD = 0;
    long kXE = 0;
    ap kXF = new ap(Looper.getMainLooper(), new a() {
        public final boolean BI() {
            AppMethodBeat.i(53180);
            if (BKGLoaderManager.this.kXp || BKGLoaderManager.this.kXq || BKGLoaderManager.this.kXr) {
                long uidTxBytes = TrafficStats.getUidTxBytes(BKGLoaderManager.this.fDe);
                long uidRxBytes = TrafficStats.getUidRxBytes(BKGLoaderManager.this.fDe);
                long j = (uidTxBytes - BKGLoaderManager.this.kXD) + (uidRxBytes - BKGLoaderManager.this.kXE);
                ab.d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + (j / 1024));
                if (j <= 20480) {
                    BKGLoaderManager.this.bkG();
                } else {
                    BKGLoaderManager.this.kXD = uidTxBytes;
                    BKGLoaderManager.this.kXE = uidRxBytes;
                    BKGLoaderManager.this.kXF.ae(1000, 1000);
                }
            }
            AppMethodBeat.o(53180);
            return false;
        }
    }, false);
    public c kXG = new c<d>() {
        {
            AppMethodBeat.i(53181);
            this.xxI = d.class.getName().hashCode();
            AppMethodBeat.o(53181);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(53182);
            d dVar = (d) bVar;
            if ((dVar instanceof d) && !dVar.crQ.crR) {
                BKGLoaderManager.this.bkG();
            }
            AppMethodBeat.o(53182);
            return false;
        }
    };
    public c kXH = new c<cx>() {
        {
            AppMethodBeat.i(53183);
            this.xxI = cx.class.getName().hashCode();
            AppMethodBeat.o(53183);
        }

        public final /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(53184);
            cx cxVar = (cx) bVar;
            if ((cxVar instanceof cx) && !bo.isNullOrNil(cxVar.cvY.cvZ)) {
                BKGLoaderManager.this.m(cxVar.cvY.cvZ, cxVar.cvY.cuy, cxVar.cvY.success);
            }
            AppMethodBeat.o(53184);
            return false;
        }
    };
    private int kXm = 0;
    private int kXn = 0;
    private boolean kXo = false;
    boolean kXp = false;
    boolean kXq = false;
    public boolean kXr = false;
    public boolean kXs = false;
    private boolean kXt = false;
    private boolean kXu = false;
    public boolean kXv = false;
    private c kXw = null;
    private b kXx;
    private Vector<c> kXy = new Vector();
    private Vector<c> kXz = new Vector();
    int mNetWorkType = -1;

    public final class ConnectivityReceiver extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(53185);
            int netType = at.getNetType(context);
            if (BKGLoaderManager.this.mNetWorkType == netType) {
                AppMethodBeat.o(53185);
                return;
            }
            ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", Integer.valueOf(netType));
            if (BKGLoaderManager.bjI()) {
                BKGLoaderManager.this.bkH();
            } else if (BKGLoaderManager.bkJ()) {
                BKGLoaderManager.this.bkG();
            } else if (at.isConnected(ah.getContext())) {
                BKGLoaderManager.this.bkI();
            } else {
                BKGLoaderManager.this.bkH();
            }
            BKGLoaderManager.this.mNetWorkType = netType;
            AppMethodBeat.o(53185);
        }
    }

    public BKGLoaderManager(b bVar) {
        AppMethodBeat.i(53186);
        this.kXx = bVar;
        this.fDe = Process.myUid();
        this.mNetWorkType = at.getNetType(ah.getContext());
        AppMethodBeat.o(53186);
    }

    public final void bs(List<c> list) {
        AppMethodBeat.i(53187);
        this.kXo = false;
        if (this.kXy == null) {
            this.kXy = new Vector();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                c cVar = (c) list.get(i);
                if (cVar == null || this.kXy.contains(cVar)) {
                    ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", cVar.getKey());
                } else {
                    this.kXy.add(cVar);
                }
            }
        }
        AppMethodBeat.o(53187);
    }

    public final void bt(List<c> list) {
        AppMethodBeat.i(53188);
        if (this.kXz == null) {
            this.kXz = new Vector();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                c cVar = (c) list.get(i);
                if (cVar == null || this.kXz.contains(cVar)) {
                    ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", cVar.getKey());
                } else {
                    this.kXz.add(cVar);
                }
            }
        }
        AppMethodBeat.o(53188);
    }

    public final synchronized void bu(List<c> list) {
        AppMethodBeat.i(53189);
        if (this.kXA == null) {
            this.kXA = new Vector();
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                c cVar = (c) list.get(i);
                String str;
                String str2;
                Object[] objArr;
                if (this.kXw != null && this.kXw.equals(cVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] currentTask equals task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = cVar == null ? "task is null" : cVar.getKey();
                    ab.i(str, str2, objArr);
                } else if (cVar == null || this.kXA.contains(cVar)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = cVar == null ? "task is null" : cVar.getKey();
                    ab.i(str, str2, objArr);
                } else {
                    this.kXA.add(cVar);
                }
            }
        }
        AppMethodBeat.o(53189);
    }

    public final synchronized void bkF() {
        AppMethodBeat.i(53190);
        if (this.kXy != null) {
            this.kXy.clear();
        }
        if (this.kXz != null) {
            this.kXz.clear();
        }
        if (this.kXA != null) {
            this.kXA.clear();
        }
        this.kXo = false;
        AppMethodBeat.o(53190);
    }

    public final synchronized void bkH() {
        AppMethodBeat.i(53192);
        this.kXp = false;
        this.kXq = false;
        this.kXo = false;
        bkI();
        if (this.kXw != null) {
            this.kXw.cancel();
        }
        AppMethodBeat.o(53192);
    }

    public final void bkI() {
        AppMethodBeat.i(53193);
        if (this.kXB != null && this.kXB.size() > 0) {
            Iterator it = this.kXB.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.o(53193);
    }

    public final void JH(String str) {
        AppMethodBeat.i(53194);
        ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", str);
        AppMethodBeat.o(53194);
    }

    public final synchronized void m(String str, int i, boolean z) {
        AppMethodBeat.i(53195);
        ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", str, Boolean.valueOf(z));
        if (this.kXw == null || bo.isNullOrNil(str)) {
            ab.e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
            AppMethodBeat.o(53195);
        } else {
            if (this.kXy.contains(this.kXw)) {
                this.kXy.remove(this.kXw);
            } else if (this.kXz.contains(this.kXw)) {
                this.kXz.remove(this.kXw);
            } else if (this.kXA.contains(this.kXw)) {
                this.kXA.remove(this.kXw);
            }
            if (!z) {
                ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
            } else if (!(i == 2 || this.kXB == null || this.kXB.size() <= 0)) {
                Iterator it = this.kXB.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            if (i == 2) {
                this.kXF.ae(5000, 5000);
                AppMethodBeat.o(53195);
            } else {
                this.kXF.ae(1000, 1000);
                AppMethodBeat.o(53195);
            }
        }
    }

    public static boolean bkJ() {
        AppMethodBeat.i(53196);
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) ah.getContext().getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                boolean isConnected = networkInfo.isConnected();
                if (SystemClock.uptimeMillis() - uptimeMillis >= 1000) {
                    ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                }
                AppMethodBeat.o(53196);
                return isConnected;
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 1000) {
                ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
            AppMethodBeat.o(53196);
            return false;
        } catch (Throwable th) {
            if (SystemClock.uptimeMillis() - uptimeMillis >= 1000) {
                ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
            AppMethodBeat.o(53196);
        }
    }

    static boolean bjI() {
        AppMethodBeat.i(53197);
        if (at.is3G(ah.getContext()) || at.is4G(ah.getContext()) || at.is2G(ah.getContext())) {
            AppMethodBeat.o(53197);
            return true;
        }
        AppMethodBeat.o(53197);
        return false;
    }

    public final synchronized void bkG() {
        AppMethodBeat.i(53191);
        if (at.isWifi(ah.getContext()) || this.kXo) {
            if (this.kXy != null && this.kXy.size() > 0) {
                this.kXu = f.Mo();
                this.kXp = true;
                this.kXq = false;
                this.kXs = false;
                this.kXr = false;
                if (this.kXu) {
                    ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
                } else {
                    this.kXw = (c) this.kXy.remove(0);
                    this.kXw.a(this);
                    this.kXx.kXl.execute(this.kXw);
                    ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", this.kXw.getKey(), Integer.valueOf(this.kXy.size()));
                }
                bkI();
            } else if (this.kXz == null || this.kXz.size() <= 0) {
                ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
                if (this.kXy == null || this.kXy.size() <= 0) {
                    if (this.kXp && this.kXv) {
                        this.kXs = true;
                    }
                    this.kXp = false;
                }
                if (this.kXz == null || this.kXz.size() <= 0) {
                    if (this.kXq && this.kXv) {
                        this.kXt = true;
                    }
                    this.kXq = false;
                }
                if ((this.kXy == null || this.kXy.size() <= 0) && ((this.kXz == null || this.kXz.size() <= 0) && ((this.kXp || this.kXq) && this.kXv))) {
                    this.kXq = false;
                    this.kXp = false;
                }
                this.kXo = false;
                bkI();
            } else {
                this.kXq = true;
                this.kXp = false;
                this.kXt = false;
                this.kXr = false;
                this.kXw = (c) this.kXz.remove(0);
                this.kXw.a(this);
                this.kXx.kXl.execute(this.kXw);
                ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", this.kXw.getKey(), Integer.valueOf(this.kXz.size()));
                bkI();
            }
            if (!(this.kXq || this.kXp)) {
                if (this.kXA == null || this.kXA.size() <= 0) {
                    this.kXr = false;
                    AppMethodBeat.o(53191);
                } else {
                    this.kXr = true;
                    this.kXw = (c) this.kXA.remove(0);
                    this.kXw.a(this);
                    this.kXx.kXl.execute(this.kXw);
                    ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", this.kXw.getKey(), Integer.valueOf(this.kXA.size()));
                    AppMethodBeat.o(53191);
                }
            }
            AppMethodBeat.o(53191);
        } else if (bjI()) {
            ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
            this.kXp = false;
            this.kXq = false;
            this.kXs = false;
            this.kXr = false;
            bkI();
            AppMethodBeat.o(53191);
        } else {
            ab.i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
            AppMethodBeat.o(53191);
        }
    }
}
