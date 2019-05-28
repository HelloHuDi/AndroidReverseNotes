package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.i;
import com.tencent.mm.a.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.kernel.api.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.modelmulti.k;
import com.tencent.mm.network.aa;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.plugin.zero.PluginZero;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.MMService;
import com.tencent.mm.service.ProcessService.MMProcessService;
import com.tencent.mm.service.c;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NotifyReceiver extends BroadcastReceiver {
    private static WakerLock ebJ = null;
    private static WakerLock ecc = null;
    private static Set<Long> ecd = new HashSet();
    private static Lock ece = new ReentrantLock(false);
    private static byte[] ecf = new byte[0];
    private static byte[] ecg = new byte[0];
    private static a ech;
    private static boolean eci = true;

    public static class NotifyService extends MMService {
        Boolean ecl = null;
        private g ecm;

        static /* synthetic */ void a(NotifyService notifyService, Intent intent) {
            AppMethodBeat.i(57801);
            notifyService.p(intent);
            AppMethodBeat.o(57801);
        }

        public final void onStart(Intent intent, int i) {
            AppMethodBeat.i(57790);
            o(intent);
            AppMethodBeat.o(57790);
        }

        public final int onStartCommand(Intent intent, int i, int i2) {
            AppMethodBeat.i(57791);
            ab.i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + i + "startId :" + i2 + " intent " + intent);
            o(intent);
            AppMethodBeat.o(57791);
            return 2;
        }

        public final IBinder Iu() {
            return null;
        }

        public final String getTag() {
            return "MicroMsg.NotifyReceiver";
        }

        private void o(final Intent intent) {
            AppMethodBeat.i(57792);
            if (intent == null) {
                ab.e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
                AppMethodBeat.o(57792);
                return;
            }
            int i;
            if (com.tencent.mm.kernel.g.RQ().eKi.eKC) {
                i = 0;
            } else {
                ab.e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", Integer.valueOf(0));
                if (this.ecm != null) {
                    com.tencent.mm.kernel.g.RQ().b(this.ecm);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                this.ecm = new g() {
                    public final void BR() {
                        AppMethodBeat.i(57789);
                        com.tencent.mm.kernel.g.RQ().b(this);
                        NotifyService.this.ecm = null;
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        ab.i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", Boolean.valueOf(com.tencent.mm.kernel.g.RQ().eKi.eKC), Long.valueOf(currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
                        e.pXa.e(11098, Integer.valueOf(3600), Long.valueOf(currentTimeMillis));
                        e.pXa.a(99, 214, 1, false);
                        al.n(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(57788);
                                ab.i("MicroMsg.NotifyReceiver", "summerboot startupDone do delay notify task");
                                NotifyService.a(NotifyService.this, intent);
                                e.pXa.a(99, 215, 1, false);
                                AppMethodBeat.o(57788);
                            }
                        }, 500);
                        AppMethodBeat.o(57789);
                    }

                    public final void bi(boolean z) {
                    }
                };
                com.tencent.mm.kernel.g.RQ().a(this.ecm);
                e.pXa.a(99, 213, 1, false);
                i = -1;
            }
            if (i < 0) {
                ab.e("MicroMsg.NotifyReceiver", "summerboot status %s", Integer.valueOf(-1));
                AppMethodBeat.o(57792);
                return;
            }
            p(intent);
            AppMethodBeat.o(57792);
        }

        private void p(Intent intent) {
            AppMethodBeat.i(57793);
            int intExtra = intent.getIntExtra("notify_option_type", 0);
            if (intExtra == 0) {
                ab.e("MicroMsg.NotifyReceiver", "receiveImp invalid opcode.");
                AppMethodBeat.o(57793);
            } else if (!com.tencent.mm.kernel.g.RK() || com.tencent.mm.kernel.a.QT()) {
                ab.e("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:%b  isHold:%b  opcode:%d", Boolean.valueOf(com.tencent.mm.kernel.g.RK()), Boolean.valueOf(com.tencent.mm.kernel.a.QT()), Integer.valueOf(intExtra));
                AppMethodBeat.o(57793);
            } else {
                if (com.tencent.mm.kernel.g.Rg().ftA == null) {
                    ab.w("MicroMsg.NotifyReceiver", "receiveImp  opcode:%d  getDispatcher == null", Integer.valueOf(intExtra));
                    com.tencent.mm.kernel.g.Rg().cD(true);
                }
                if (this.ecl == null) {
                    NotifyService notifyService;
                    boolean z;
                    if (b.dnO()) {
                        notifyService = this;
                    } else {
                        int i = bo.getInt(((com.tencent.mm.plugin.zero.b.a) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.a.class)).Nu().getValue("AndroidOldNotifyReceiver"), 0);
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RN();
                        if (i > i.bL(com.tencent.mm.kernel.a.QF(), 100)) {
                            z = true;
                            notifyService = this;
                            notifyService.ecl = Boolean.valueOf(z);
                        } else {
                            notifyService = this;
                        }
                    }
                    z = false;
                    notifyService.ecl = Boolean.valueOf(z);
                }
                ab.i("MicroMsg.NotifyReceiver", "handleCommand useOld:%s operationCode:%d", this.ecl, Integer.valueOf(intExtra));
                switch (intExtra) {
                    case 1:
                        if (this.ecl.booleanValue()) {
                            z(ah.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE");
                        }
                        bt(ah.getContext());
                        AppMethodBeat.o(57793);
                        return;
                    case 2:
                        if (this.ecl.booleanValue()) {
                            z(ah.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY");
                            r(intent);
                            AppMethodBeat.o(57793);
                            return;
                        }
                        q(intent);
                        AppMethodBeat.o(57793);
                        return;
                    default:
                        ab.e("MicroMsg.NotifyReceiver", "invald opCode:".concat(String.valueOf(intExtra)));
                        AppMethodBeat.o(57793);
                        return;
                }
            }
        }

        public final void onCreate() {
            AppMethodBeat.i(57794);
            super.onCreate();
            AppMethodBeat.o(57794);
        }

        public static void jG(String str) {
            AppMethodBeat.i(57795);
            synchronized (NotifyReceiver.ecf) {
                try {
                    if (NotifyReceiver.ebJ == null) {
                        NotifyReceiver.ebJ = new WakerLock(ah.getContext(), "MicroMsg.NotifyReceiver");
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(57795);
                }
            }
            NotifyReceiver.ebJ.lock(5000, str);
        }

        private static void z(Context context, String str) {
            AppMethodBeat.i(57796);
            synchronized (NotifyReceiver.ecf) {
                try {
                    if (NotifyReceiver.ebJ == null) {
                        NotifyReceiver.ebJ = new WakerLock(context, "MicroMsg.NotifyReceiver");
                    }
                    NotifyReceiver.ebJ.lock(14000, str);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(57796);
                }
            }
        }

        private static void A(Context context, String str) {
            AppMethodBeat.i(57797);
            synchronized (NotifyReceiver.ecg) {
                try {
                    if (NotifyReceiver.ecc == null) {
                        NotifyReceiver.ecc = new WakerLock(context, "MicroMsg.NotifyReceiver");
                    }
                    NotifyReceiver.ecc.lock(60000, str);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(57797);
                }
            }
        }

        private void q(Intent intent) {
            AppMethodBeat.i(57798);
            int intExtra = intent.getIntExtra("notify_respType", 0);
            byte[] byteArrayExtra = intent.getByteArrayExtra("notify_respBuf");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("notify_skey");
            long longExtra = intent.getLongExtra("notfiy_recv_time", -1);
            String str = "MicroMsg.NotifyReceiver";
            String str2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(intExtra);
            objArr[1] = Long.valueOf(longExtra);
            objArr[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
            objArr[3] = Integer.valueOf(byteArrayExtra2 == null ? -1 : byteArrayExtra2.length);
            ab.i(str, str2, objArr);
            if (bo.cb(byteArrayExtra2)) {
                ab.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session null and ret sessionKey:" + byteArrayExtra2 + " respType:" + intExtra);
                AppMethodBeat.o(57798);
                return;
            }
            int i;
            switch (intExtra) {
                case 39:
                    com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.modelmulti.i(), 0);
                    AppMethodBeat.o(57798);
                    return;
                case 138:
                    int i2;
                    if (byteArrayExtra == null) {
                        i2 = 7;
                    } else {
                        i2 = o.t(byteArrayExtra, 0);
                    }
                    i = byteArrayExtra == null ? 2 : 1;
                    String str3 = "MicroMsg.NotifyReceiver";
                    String str4 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = Integer.valueOf(i2);
                    objArr2[1] = Integer.valueOf(i);
                    objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                    ab.i(str3, str4, objArr2);
                    ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().a((long) i2, i, "");
                    AppMethodBeat.o(57798);
                    return;
                case 268369921:
                    if (bo.cb(byteArrayExtra) || byteArrayExtra.length <= 8) {
                        ab.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                        AppMethodBeat.o(57798);
                        return;
                    }
                    int t = o.t(byteArrayExtra, 0);
                    i = o.t(byteArrayExtra, 4);
                    if (i != byteArrayExtra.length - 8) {
                        ab.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                        AppMethodBeat.o(57798);
                        return;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(byteArrayExtra, 8, bArr, 0, i);
                    ab.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", Integer.valueOf(t), Integer.valueOf(i), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra));
                    k.b(t, bArr, byteArrayExtra2, longExtra);
                    AppMethodBeat.o(57798);
                    return;
                case 1000000205:
                    ab.i("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                    x.b bVar = new x.b();
                    ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().a(bVar.vyM, 1, bVar.dmu());
                    AppMethodBeat.o(57798);
                    return;
                case 2147480001:
                    ab.i("MicroMsg.NotifyReceiver", "dkpush FCM Notify");
                    ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().a(7, 16, "");
                    AppMethodBeat.o(57798);
                    return;
                default:
                    ((PluginZero) com.tencent.mm.kernel.g.M(PluginZero.class)).yag.a(this, intExtra, byteArrayExtra, byteArrayExtra2, longExtra);
                    AppMethodBeat.o(57798);
                    return;
            }
        }

        private void r(Intent intent) {
            AppMethodBeat.i(57799);
            int intExtra = intent.getIntExtra("notify_respType", 0);
            byte[] byteArrayExtra = intent.getByteArrayExtra("notify_respBuf");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("notify_skey");
            long longExtra = intent.getLongExtra("notfiy_recv_time", -1);
            String str = "MicroMsg.NotifyReceiver";
            String str2 = "dealWithNotify respType:%d recvTime:%d respBuf:%d sessionkey:%s ";
            Object[] objArr = new Object[4];
            objArr[0] = Integer.valueOf(intExtra);
            objArr[1] = Long.valueOf(longExtra);
            objArr[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
            objArr[3] = bo.anv(bo.cd(byteArrayExtra2));
            ab.i(str, str2, objArr);
            int i;
            int a;
            switch (intExtra) {
                case 39:
                    com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.modelmulti.i(), 0);
                    AppMethodBeat.o(57799);
                    return;
                case 138:
                    int i2;
                    if (byteArrayExtra == null) {
                        i2 = 7;
                    } else {
                        i2 = o.t(byteArrayExtra, 0);
                    }
                    i = byteArrayExtra == null ? 2 : 1;
                    String str3 = "MicroMsg.NotifyReceiver";
                    String str4 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = Integer.valueOf(i2);
                    objArr2[1] = Integer.valueOf(i);
                    objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                    ab.d(str3, str4, objArr2);
                    try {
                        NotifyReceiver.ece.lock();
                        a = ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().a((long) i2, i, "");
                        if (a > 0) {
                            ab.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(a));
                            NotifyReceiver.ecd.add(Long.valueOf((long) a));
                            A(ah.getContext(), "NotifyReceiver.dealWithNotify:MMFunc_NewSync");
                        }
                        try {
                            NotifyReceiver.ece.unlock();
                            AppMethodBeat.o(57799);
                            return;
                        } catch (Exception e) {
                            AppMethodBeat.o(57799);
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            NotifyReceiver.ece.unlock();
                        } catch (Exception e2) {
                        }
                        AppMethodBeat.o(57799);
                        throw th;
                    }
                case 268369921:
                    if (bo.cb(byteArrayExtra2)) {
                        ab.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:".concat(String.valueOf(byteArrayExtra2)));
                        AppMethodBeat.o(57799);
                        return;
                    } else if (bo.cb(byteArrayExtra) || byteArrayExtra.length <= 8) {
                        ab.e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                        AppMethodBeat.o(57799);
                        return;
                    } else {
                        a = o.t(byteArrayExtra, 0);
                        i = o.t(byteArrayExtra, 4);
                        if (i != byteArrayExtra.length - 8) {
                            ab.e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                            AppMethodBeat.o(57799);
                            return;
                        }
                        byte[] bArr = new byte[i];
                        System.arraycopy(byteArrayExtra, 8, bArr, 0, i);
                        ab.i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", Integer.valueOf(a), Integer.valueOf(i), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra));
                        try {
                            NotifyReceiver.ece.lock();
                            k.b(a, bArr, byteArrayExtra2, longExtra);
                            NotifyReceiver.ecd.add(Long.valueOf(longExtra));
                            A(ah.getContext(), "NotifyReceiver.NotifyData");
                            try {
                                NotifyReceiver.ece.unlock();
                                AppMethodBeat.o(57799);
                                return;
                            } catch (Exception e3) {
                                AppMethodBeat.o(57799);
                                return;
                            }
                        } catch (Throwable th2) {
                            try {
                                NotifyReceiver.ece.unlock();
                            } catch (Exception e4) {
                            }
                            AppMethodBeat.o(57799);
                            throw th2;
                        }
                    }
                case 1000000205:
                    ab.d("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                    x.b bVar = new x.b();
                    try {
                        bVar.P(byteArrayExtra);
                        NotifyReceiver.ece.lock();
                        a = ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().a(bVar.vyM, 1, bVar.dmu());
                        if (a > 0) {
                            ab.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(a));
                            NotifyReceiver.ecd.add(Long.valueOf((long) a));
                            A(ah.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP");
                        }
                        try {
                            NotifyReceiver.ece.unlock();
                            AppMethodBeat.o(57799);
                            return;
                        } catch (Exception e5) {
                            AppMethodBeat.o(57799);
                            return;
                        }
                    } catch (Exception e6) {
                        ab.printErrStackTrace("MicroMsg.NotifyReceiver", e6, "", new Object[0]);
                        try {
                            NotifyReceiver.ece.unlock();
                            AppMethodBeat.o(57799);
                            return;
                        } catch (Exception e7) {
                            AppMethodBeat.o(57799);
                            return;
                        }
                    } catch (Throwable th22) {
                        try {
                            NotifyReceiver.ece.unlock();
                        } catch (Exception e8) {
                        }
                        AppMethodBeat.o(57799);
                        throw th22;
                    }
                case 2147480001:
                    ab.d("MicroMsg.NotifyReceiver", "dkpush FCM Notify");
                    a = ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().a(7, 16, "");
                    try {
                        NotifyReceiver.ece.lock();
                        if (a > 0) {
                            ab.d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(a));
                            NotifyReceiver.ecd.add(Long.valueOf((long) a));
                            A(ah.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_FCM_NOTIFY");
                        }
                        try {
                            NotifyReceiver.ece.unlock();
                            AppMethodBeat.o(57799);
                            return;
                        } catch (Exception e9) {
                            AppMethodBeat.o(57799);
                            return;
                        }
                    } catch (Throwable th222) {
                        try {
                            NotifyReceiver.ece.unlock();
                        } catch (Exception e10) {
                        }
                        AppMethodBeat.o(57799);
                        throw th222;
                    }
                default:
                    ((PluginZero) com.tencent.mm.kernel.g.M(PluginZero.class)).yag.a(this, intExtra, byteArrayExtra, byteArrayExtra2, longExtra);
                    AppMethodBeat.o(57799);
                    return;
            }
        }

        private static void bt(Context context) {
            AppMethodBeat.i(57800);
            ab.i("MicroMsg.NotifyReceiver", "dealWithLooper");
            if (!com.tencent.mm.kernel.g.RK() || com.tencent.mm.kernel.a.QT()) {
                ab.w("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:" + com.tencent.mm.kernel.g.RK() + " isHold:" + com.tencent.mm.kernel.a.QT());
                AppMethodBeat.o(57800);
            } else if (com.tencent.mm.kernel.g.Rg().foreground || !com.tencent.mm.network.ab.cg(context)) {
                ((com.tencent.mm.plugin.zero.b.b) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.zero.b.b.class)).ahW().lN(2);
                AppMethodBeat.o(57800);
            } else {
                com.tencent.mm.kernel.g.Rg().a(new com.tencent.mm.modelmulti.i(), 0);
                AppMethodBeat.o(57800);
            }
        }
    }

    public static class a implements f {
        private static long ecj = 0;

        static /* synthetic */ void b(a aVar) {
            AppMethodBeat.i(57787);
            aVar.eO(3000);
            AppMethodBeat.o(57787);
        }

        public final void onSceneEnd(int i, int i2, String str, m mVar) {
            long j;
            AppMethodBeat.i(57784);
            long hashCode = (long) mVar.hashCode();
            if (mVar.getType() == 268369922) {
                j = ((com.tencent.mm.modelmulti.f) mVar).fHM;
            } else {
                j = hashCode;
            }
            try {
                NotifyReceiver.ece.lock();
                synchronized (NotifyReceiver.ecg) {
                    String str2 = "MicroMsg.NotifyReceiver";
                    String str3 = "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b";
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(mVar.getType());
                    objArr[1] = Long.valueOf(j);
                    objArr[2] = Boolean.valueOf(NotifyReceiver.ecd.contains(Long.valueOf(j)));
                    objArr[3] = Boolean.valueOf(NotifyReceiver.ecc != null ? NotifyReceiver.ecc.isLocking() : false);
                    ab.i(str2, str3, objArr);
                }
                NotifyReceiver.ecd.remove(Long.valueOf(j));
                try {
                    NotifyReceiver.ece.unlock();
                } catch (Exception e) {
                }
                try {
                    NotifyReceiver.ece.lock();
                    if (NotifyReceiver.ecd.isEmpty()) {
                        synchronized (NotifyReceiver.ecg) {
                            if (NotifyReceiver.ecc != null) {
                                NotifyReceiver.ecc.unLock();
                            }
                        }
                        ab.i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
                    } else {
                        ab.i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", Integer.valueOf(NotifyReceiver.ecd.size()));
                    }
                    try {
                        NotifyReceiver.ece.unlock();
                    } catch (Exception e2) {
                    }
                    switch (mVar.getType()) {
                        case 138:
                            if (com.tencent.mm.kernel.g.RN().QY()) {
                                Looper.myQueue().addIdleHandler(new IdleHandler() {
                                    public final boolean queueIdle() {
                                        AppMethodBeat.i(57780);
                                        a.a(a.this);
                                        AppMethodBeat.o(57780);
                                        return false;
                                    }
                                });
                                if (i == 0 && i2 == 0 && com.tencent.mm.model.a.XF()) {
                                    try {
                                        com.tencent.mm.kernel.g.RQ();
                                        com.tencent.mm.model.a aVar = com.tencent.mm.kernel.g.RN().eIQ;
                                        if (aVar.fkb > -1) {
                                            aVar.fkb++;
                                        }
                                        ab.i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", Long.valueOf(aVar.fkb));
                                        if (aVar.fkb == 2 || aVar.fkb == 5) {
                                            e.pXa.a(226, aVar.fkb == 2 ? 37 : 38, 1, false);
                                            e.pXa.e(11098, Integer.valueOf(2001), Long.valueOf(aVar.fkb));
                                            break;
                                        }
                                    } catch (Throwable th) {
                                        ab.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", bo.l(th));
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                    eO(7000);
                    AppMethodBeat.o(57784);
                } catch (Throwable th2) {
                    try {
                        NotifyReceiver.ece.unlock();
                    } catch (Exception e3) {
                    }
                    AppMethodBeat.o(57784);
                    throw th2;
                }
            } catch (Throwable th22) {
                try {
                    NotifyReceiver.ece.unlock();
                } catch (Exception e4) {
                }
                AppMethodBeat.o(57784);
                throw th22;
            }
        }

        private void eO(long j) {
            AppMethodBeat.i(57785);
            if (aa.anh().getBoolean("is_in_notify_mode", false)) {
                new ak(Looper.myLooper()).postDelayed(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(57781);
                        ab.i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", Boolean.valueOf(NotifyReceiver.eci));
                        synchronized (NotifyReceiver.ecf) {
                            try {
                                if (NotifyReceiver.ebJ != null) {
                                    NotifyReceiver.ebJ.unLock();
                                }
                                NotifyReceiver.ebJ = null;
                            } catch (Throwable th) {
                                while (true) {
                                    AppMethodBeat.o(57781);
                                }
                            }
                        }
                        if (NotifyReceiver.eci) {
                            PluginZero pluginZero = (PluginZero) com.tencent.mm.kernel.g.M(PluginZero.class);
                            if (pluginZero.yaf != null) {
                                pluginZero.yaf.aVq();
                            }
                            ab.dou();
                            Process.killProcess(Process.myPid());
                        }
                        AppMethodBeat.o(57781);
                    }
                }, j);
                AppMethodBeat.o(57785);
                return;
            }
            AppMethodBeat.o(57785);
        }

        static /* synthetic */ void a(a aVar) {
            AppMethodBeat.i(57786);
            com.tencent.mm.kernel.g.RQ();
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(57782);
                    if (com.tencent.mm.kernel.g.RN().QY()) {
                        int i;
                        if (bo.h((Integer) com.tencent.mm.kernel.g.RP().Ry().get(15, null)) == 0) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (i != 0) {
                            ab.e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
                            AppMethodBeat.o(57782);
                            return;
                        }
                        long anU = bo.anU();
                        if (anU - a.ecj <= 0 || anU - a.ecj >= 10000) {
                            a.ecj = anU;
                            ab.i("MicroMsg.NotifyReceiver", "begin post sync task");
                            anU = bo.yz();
                            com.tencent.mm.sdk.b.a.xxA.m(new mp());
                            ab.i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", Long.valueOf(bo.az(anU)));
                            a.b(a.this);
                            AppMethodBeat.o(57782);
                            return;
                        }
                        ab.d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", Long.valueOf(anU - a.ecj));
                        AppMethodBeat.o(57782);
                        return;
                    }
                    AppMethodBeat.o(57782);
                }

                public final String toString() {
                    AppMethodBeat.i(57783);
                    String str = super.toString() + "|doPostSyncTask";
                    AppMethodBeat.o(57783);
                    return str;
                }
            });
            AppMethodBeat.o(57786);
        }
    }

    static {
        AppMethodBeat.i(57806);
        AppMethodBeat.o(57806);
    }

    public static void Im() {
        AppMethodBeat.i(57802);
        In();
        AppMethodBeat.o(57802);
    }

    public static void In() {
        AppMethodBeat.i(57803);
        ab.i("MicroMsg.NotifyReceiver", "quitLightPushMode");
        eci = false;
        aa.anh().edit().putBoolean("is_in_notify_mode", false).commit();
        AppMethodBeat.o(57803);
    }

    public static void Io() {
        AppMethodBeat.i(57804);
        com.tencent.mm.kernel.g.Rg().b(138, ech);
        com.tencent.mm.kernel.g.Rg().b(39, ech);
        com.tencent.mm.kernel.g.Rg().b(268369922, ech);
        if (ech == null) {
            ech = new a();
        }
        com.tencent.mm.kernel.g.Rg().a(138, ech);
        com.tencent.mm.kernel.g.Rg().a(39, ech);
        com.tencent.mm.kernel.g.Rg().a(268369922, ech);
        AppMethodBeat.o(57804);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(57805);
        ab.i("MicroMsg.NotifyReceiver", "onReceive intent :%s", intent);
        if (intent == null) {
            AppMethodBeat.o(57805);
        } else if (l.bL(context)) {
            ab.i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
            AppMethodBeat.o(57805);
        } else {
            com.tencent.mm.an.a.lm(intent.getIntExtra("notify_respType", -1));
            Intent intent2 = new Intent(context, NotifyService.class);
            if (intent.getBooleanExtra("intent_from_shoot_key", false)) {
                intent2.putExtra("notify_option_type", 3);
            }
            intent2.putExtras(intent);
            c.a(intent2, "mm", true, new Intent(ah.getContext(), MMProcessService.class));
            AppMethodBeat.o(57805);
        }
    }
}
