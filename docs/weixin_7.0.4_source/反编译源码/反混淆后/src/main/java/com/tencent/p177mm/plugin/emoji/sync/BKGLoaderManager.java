package com.tencent.p177mm.plugin.emoji.sync;

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
import com.tencent.p177mm.compatible.util.C1445f;
import com.tencent.p177mm.p230g.p231a.C26107cx;
import com.tencent.p177mm.p230g.p231a.C26111d;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/* renamed from: com.tencent.mm.plugin.emoji.sync.BKGLoaderManager */
public final class BKGLoaderManager implements C11563d {
    int fDe;
    private Vector<C27745c> kXA = new Vector();
    private Set<Object> kXB = new HashSet();
    public ConnectivityReceiver kXC;
    long kXD = 0;
    long kXE = 0;
    C7564ap kXF = new C7564ap(Looper.getMainLooper(), new C29381(), false);
    public C4884c kXG = new C29402();
    public C4884c kXH = new C29393();
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
    private C27745c kXw = null;
    private C27743b kXx;
    private Vector<C27745c> kXy = new Vector();
    private Vector<C27745c> kXz = new Vector();
    int mNetWorkType = -1;

    /* renamed from: com.tencent.mm.plugin.emoji.sync.BKGLoaderManager$1 */
    class C29381 implements C5015a {
        C29381() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(53180);
            if (BKGLoaderManager.this.kXp || BKGLoaderManager.this.kXq || BKGLoaderManager.this.kXr) {
                long uidTxBytes = TrafficStats.getUidTxBytes(BKGLoaderManager.this.fDe);
                long uidRxBytes = TrafficStats.getUidRxBytes(BKGLoaderManager.this.fDe);
                long j = (uidTxBytes - BKGLoaderManager.this.kXD) + (uidRxBytes - BKGLoaderManager.this.kXE);
                C4990ab.m7410d("MicroMsg.BKGLoader.BKGLoaderManager", "delta of data: " + (j / 1024));
                if (j <= 20480) {
                    BKGLoaderManager.this.bkG();
                } else {
                    BKGLoaderManager.this.kXD = uidTxBytes;
                    BKGLoaderManager.this.kXE = uidRxBytes;
                    BKGLoaderManager.this.kXF.mo16770ae(1000, 1000);
                }
            }
            AppMethodBeat.m2505o(53180);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.sync.BKGLoaderManager$3 */
    class C29393 extends C4884c<C26107cx> {
        C29393() {
            AppMethodBeat.m2504i(53183);
            this.xxI = C26107cx.class.getName().hashCode();
            AppMethodBeat.m2505o(53183);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53184);
            C26107cx c26107cx = (C26107cx) c4883b;
            if ((c26107cx instanceof C26107cx) && !C5046bo.isNullOrNil(c26107cx.cvY.cvZ)) {
                BKGLoaderManager.this.mo7139m(c26107cx.cvY.cvZ, c26107cx.cvY.cuy, c26107cx.cvY.success);
            }
            AppMethodBeat.m2505o(53184);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.sync.BKGLoaderManager$2 */
    class C29402 extends C4884c<C26111d> {
        C29402() {
            AppMethodBeat.m2504i(53181);
            this.xxI = C26111d.class.getName().hashCode();
            AppMethodBeat.m2505o(53181);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(53182);
            C26111d c26111d = (C26111d) c4883b;
            if ((c26111d instanceof C26111d) && !c26111d.crQ.crR) {
                BKGLoaderManager.this.bkG();
            }
            AppMethodBeat.m2505o(53182);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.sync.BKGLoaderManager$ConnectivityReceiver */
    public final class ConnectivityReceiver extends BroadcastReceiver {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(53185);
            int netType = C5023at.getNetType(context);
            if (BKGLoaderManager.this.mNetWorkType == netType) {
                AppMethodBeat.m2505o(53185);
                return;
            }
            C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] network change type:%d", Integer.valueOf(netType));
            if (BKGLoaderManager.bjI()) {
                BKGLoaderManager.this.bkH();
            } else if (BKGLoaderManager.bkJ()) {
                BKGLoaderManager.this.bkG();
            } else if (C5023at.isConnected(C4996ah.getContext())) {
                BKGLoaderManager.this.bkI();
            } else {
                BKGLoaderManager.this.bkH();
            }
            BKGLoaderManager.this.mNetWorkType = netType;
            AppMethodBeat.m2505o(53185);
        }
    }

    public BKGLoaderManager(C27743b c27743b) {
        AppMethodBeat.m2504i(53186);
        this.kXx = c27743b;
        this.fDe = Process.myUid();
        this.mNetWorkType = C5023at.getNetType(C4996ah.getContext());
        AppMethodBeat.m2505o(53186);
    }

    /* renamed from: bs */
    public final void mo7136bs(List<C27745c> list) {
        AppMethodBeat.m2504i(53187);
        this.kXo = false;
        if (this.kXy == null) {
            this.kXy = new Vector();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C27745c c27745c = (C27745c) list.get(i);
                if (c27745c == null || this.kXy.contains(c27745c)) {
                    C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist.:%s", c27745c.getKey());
                } else {
                    this.kXy.add(c27745c);
                }
            }
        }
        AppMethodBeat.m2505o(53187);
    }

    /* renamed from: bt */
    public final void mo7137bt(List<C27745c> list) {
        AppMethodBeat.m2504i(53188);
        if (this.kXz == null) {
            this.kXz = new Vector();
        }
        if (list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C27745c c27745c = (C27745c) list.get(i);
                if (c27745c == null || this.kXz.contains(c27745c)) {
                    C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is has exist:%s", c27745c.getKey());
                } else {
                    this.kXz.add(c27745c);
                }
            }
        }
        AppMethodBeat.m2505o(53188);
    }

    /* renamed from: bu */
    public final synchronized void mo7138bu(List<C27745c> list) {
        AppMethodBeat.m2504i(53189);
        if (this.kXA == null) {
            this.kXA = new Vector();
        }
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                C27745c c27745c = (C27745c) list.get(i);
                String str;
                String str2;
                Object[] objArr;
                if (this.kXw != null && this.kXw.equals(c27745c)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] currentTask equals task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = c27745c == null ? "task is null" : c27745c.getKey();
                    C4990ab.m7417i(str, str2, objArr);
                } else if (c27745c == null || this.kXA.contains(c27745c)) {
                    str = "MicroMsg.BKGLoader.BKGLoaderManager";
                    str2 = "[cpan] task is has exist:%s";
                    objArr = new Object[1];
                    objArr[0] = c27745c == null ? "task is null" : c27745c.getKey();
                    C4990ab.m7417i(str, str2, objArr);
                } else {
                    this.kXA.add(c27745c);
                }
            }
        }
        AppMethodBeat.m2505o(53189);
    }

    public final synchronized void bkF() {
        AppMethodBeat.m2504i(53190);
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
        AppMethodBeat.m2505o(53190);
    }

    public final synchronized void bkH() {
        AppMethodBeat.m2504i(53192);
        this.kXp = false;
        this.kXq = false;
        this.kXo = false;
        bkI();
        if (this.kXw != null) {
            this.kXw.cancel();
        }
        AppMethodBeat.m2505o(53192);
    }

    public final void bkI() {
        AppMethodBeat.m2504i(53193);
        if (this.kXB != null && this.kXB.size() > 0) {
            Iterator it = this.kXB.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        AppMethodBeat.m2505o(53193);
    }

    /* renamed from: JH */
    public final void mo7131JH(String str) {
        AppMethodBeat.m2504i(53194);
        C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is ruing. key:%s", str);
        AppMethodBeat.m2505o(53194);
    }

    /* renamed from: m */
    public final synchronized void mo7139m(String str, int i, boolean z) {
        AppMethodBeat.m2504i(53195);
        C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] task is finish. key:%s success:%b", str, Boolean.valueOf(z));
        if (this.kXw == null || C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.BKGLoader.BKGLoaderManager", "CurrentTask or key is null. or key is no equal crrentkey ");
            AppMethodBeat.m2505o(53195);
        } else {
            if (this.kXy.contains(this.kXw)) {
                this.kXy.remove(this.kXw);
            } else if (this.kXz.contains(this.kXw)) {
                this.kXz.remove(this.kXw);
            } else if (this.kXA.contains(this.kXw)) {
                this.kXA.remove(this.kXw);
            }
            if (!z) {
                C4990ab.m7416i("MicroMsg.BKGLoader.BKGLoaderManager", "retry later.");
            } else if (!(i == 2 || this.kXB == null || this.kXB.size() <= 0)) {
                Iterator it = this.kXB.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
            if (i == 2) {
                this.kXF.mo16770ae(5000, 5000);
                AppMethodBeat.m2505o(53195);
            } else {
                this.kXF.mo16770ae(1000, 1000);
                AppMethodBeat.m2505o(53195);
            }
        }
    }

    public static boolean bkJ() {
        AppMethodBeat.m2504i(53196);
        long uptimeMillis = SystemClock.uptimeMillis();
        try {
            NetworkInfo networkInfo = ((ConnectivityManager) C4996ah.getContext().getSystemService("connectivity")).getNetworkInfo(1);
            if (networkInfo != null) {
                boolean isConnected = networkInfo.isConnected();
                if (SystemClock.uptimeMillis() - uptimeMillis >= 1000) {
                    C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
                }
                AppMethodBeat.m2505o(53196);
                return isConnected;
            }
            if (SystemClock.uptimeMillis() - uptimeMillis >= 1000) {
                C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
            AppMethodBeat.m2505o(53196);
            return false;
        } catch (Throwable th) {
            if (SystemClock.uptimeMillis() - uptimeMillis >= 1000) {
                C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[isWifi] cost:%s", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis));
            }
            AppMethodBeat.m2505o(53196);
        }
    }

    static boolean bjI() {
        AppMethodBeat.m2504i(53197);
        if (C5023at.is3G(C4996ah.getContext()) || C5023at.is4G(C4996ah.getContext()) || C5023at.is2G(C4996ah.getContext())) {
            AppMethodBeat.m2505o(53197);
            return true;
        }
        AppMethodBeat.m2505o(53197);
        return false;
    }

    public final synchronized void bkG() {
        AppMethodBeat.m2504i(53191);
        if (C5023at.isWifi(C4996ah.getContext()) || this.kXo) {
            if (this.kXy != null && this.kXy.size() > 0) {
                this.kXu = C1445f.m3071Mo();
                this.kXp = true;
                this.kXq = false;
                this.kXs = false;
                this.kXr = false;
                if (this.kXu) {
                    C4990ab.m7416i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] sdcard is full.");
                } else {
                    this.kXw = (C27745c) this.kXy.remove(0);
                    this.kXw.mo23266a(this);
                    this.kXx.kXl.execute(this.kXw);
                    C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s donwload list size:%d", this.kXw.getKey(), Integer.valueOf(this.kXy.size()));
                }
                bkI();
            } else if (this.kXz == null || this.kXz.size() <= 0) {
                C4990ab.m7416i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart no task list .");
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
                this.kXw = (C27745c) this.kXz.remove(0);
                this.kXw.mo23266a(this);
                this.kXx.kXl.execute(this.kXw);
                C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart task is ruing. key:%s upload list size:%d", this.kXw.getKey(), Integer.valueOf(this.kXz.size()));
                bkI();
            }
            if (!(this.kXq || this.kXp)) {
                if (this.kXA == null || this.kXA.size() <= 0) {
                    this.kXr = false;
                    AppMethodBeat.m2505o(53191);
                } else {
                    this.kXr = true;
                    this.kXw = (C27745c) this.kXA.remove(0);
                    this.kXw.mo23266a(this);
                    this.kXx.kXl.execute(this.kXw);
                    C4990ab.m7417i("MicroMsg.BKGLoader.BKGLoaderManager", "[cpan] tryToStart download store emoji task is runing. productID:%s size:%d", this.kXw.getKey(), Integer.valueOf(this.kXA.size()));
                    AppMethodBeat.m2505o(53191);
                }
            }
            AppMethodBeat.m2505o(53191);
        } else if (BKGLoaderManager.bjI()) {
            C4990ab.m7416i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is 3g or 4g]");
            this.kXp = false;
            this.kXq = false;
            this.kXs = false;
            this.kXr = false;
            bkI();
            AppMethodBeat.m2505o(53191);
        } else {
            C4990ab.m7416i("MicroMsg.BKGLoader.BKGLoaderManager", "[dz tryToStart is not wifi, 3g nor 4g]");
            AppMethodBeat.m2505o(53191);
        }
    }
}
