package com.tencent.p177mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.C1737l;
import com.tencent.p177mm.kernel.api.C1675g;
import com.tencent.p177mm.model.C1810a;
import com.tencent.p177mm.modelmulti.C26448f;
import com.tencent.p177mm.modelmulti.C37941i;
import com.tencent.p177mm.modelmulti.C37942k;
import com.tencent.p177mm.network.C1892aa;
import com.tencent.p177mm.network.C32856ab;
import com.tencent.p177mm.p178a.C1179i;
import com.tencent.p177mm.p178a.C37432o;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p188an.C41753a;
import com.tencent.p177mm.p230g.p231a.C6523mp;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.zero.PluginZero;
import com.tencent.p177mm.plugin.zero.p757b.C35779b;
import com.tencent.p177mm.plugin.zero.p757b.C7234a;
import com.tencent.p177mm.protocal.C4845x.C4847b;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.service.C5091c;
import com.tencent.p177mm.service.MMService;
import com.tencent.p177mm.service.ProcessService.MMProcessService;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.tencent.mm.booter.NotifyReceiver */
public class NotifyReceiver extends BroadcastReceiver {
    private static WakerLock ebJ = null;
    private static WakerLock ecc = null;
    private static Set<Long> ecd = new HashSet();
    private static Lock ece = new ReentrantLock(false);
    private static byte[] ecf = new byte[0];
    private static byte[] ecg = new byte[0];
    private static C25970a ech;
    private static boolean eci = true;

    /* renamed from: com.tencent.mm.booter.NotifyReceiver$NotifyService */
    public static class NotifyService extends MMService {
        Boolean ecl = null;
        private C1675g ecm;

        /* renamed from: a */
        static /* synthetic */ void m41406a(NotifyService notifyService, Intent intent) {
            AppMethodBeat.m2504i(57801);
            notifyService.m41410p(intent);
            AppMethodBeat.m2505o(57801);
        }

        public final void onStart(Intent intent, int i) {
            AppMethodBeat.m2504i(57790);
            m41409o(intent);
            AppMethodBeat.m2505o(57790);
        }

        public final int onStartCommand(Intent intent, int i, int i2) {
            AppMethodBeat.m2504i(57791);
            C4990ab.m7416i("MicroMsg.NotifyReceiver", "NotifyService onStartCommand flags :" + i + "startId :" + i2 + " intent " + intent);
            m41409o(intent);
            AppMethodBeat.m2505o(57791);
            return 2;
        }

        /* renamed from: Iu */
        public final IBinder mo10421Iu() {
            return null;
        }

        public final String getTag() {
            return "MicroMsg.NotifyReceiver";
        }

        /* renamed from: o */
        private void m41409o(final Intent intent) {
            AppMethodBeat.m2504i(57792);
            if (intent == null) {
                C4990ab.m7412e("MicroMsg.NotifyReceiver", "receiveImp receiveIntent == null");
                AppMethodBeat.m2505o(57792);
                return;
            }
            int i;
            if (C1720g.m3537RQ().eKi.eKC) {
                i = 0;
            } else {
                C4990ab.m7413e("MicroMsg.NotifyReceiver", "summerboot WorkerProfile not has create, status %d", Integer.valueOf(0));
                if (this.ecm != null) {
                    C1720g.m3537RQ().mo5255b(this.ecm);
                }
                final long currentTimeMillis = System.currentTimeMillis();
                this.ecm = new C1675g() {

                    /* renamed from: com.tencent.mm.booter.NotifyReceiver$NotifyService$1$1 */
                    class C91821 implements Runnable {
                        C91821() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(57788);
                            C4990ab.m7416i("MicroMsg.NotifyReceiver", "summerboot startupDone do delay notify task");
                            NotifyService.m41406a(NotifyService.this, intent);
                            C7053e.pXa.mo8378a(99, 215, 1, false);
                            AppMethodBeat.m2505o(57788);
                        }
                    }

                    /* renamed from: BR */
                    public final void mo5176BR() {
                        AppMethodBeat.m2504i(57789);
                        C1720g.m3537RQ().mo5255b(this);
                        NotifyService.this.ecm = null;
                        long currentTimeMillis = System.currentTimeMillis() - currentTimeMillis;
                        C4990ab.m7417i("MicroMsg.NotifyReceiver", "summerboot startupDone[%b] take[%d]ms tid[%d] post last notify task", Boolean.valueOf(C1720g.m3537RQ().eKi.eKC), Long.valueOf(currentTimeMillis), Long.valueOf(Thread.currentThread().getId()));
                        C7053e.pXa.mo8381e(11098, Integer.valueOf(3600), Long.valueOf(currentTimeMillis));
                        C7053e.pXa.mo8378a(99, 214, 1, false);
                        C5004al.m7442n(new C91821(), 500);
                        AppMethodBeat.m2505o(57789);
                    }

                    /* renamed from: bi */
                    public final void mo5177bi(boolean z) {
                    }
                };
                C1720g.m3537RQ().mo5252a(this.ecm);
                C7053e.pXa.mo8378a(99, 213, 1, false);
                i = -1;
            }
            if (i < 0) {
                C4990ab.m7413e("MicroMsg.NotifyReceiver", "summerboot status %s", Integer.valueOf(-1));
                AppMethodBeat.m2505o(57792);
                return;
            }
            m41410p(intent);
            AppMethodBeat.m2505o(57792);
        }

        /* renamed from: p */
        private void m41410p(Intent intent) {
            AppMethodBeat.m2504i(57793);
            int intExtra = intent.getIntExtra("notify_option_type", 0);
            if (intExtra == 0) {
                C4990ab.m7412e("MicroMsg.NotifyReceiver", "receiveImp invalid opcode.");
                AppMethodBeat.m2505o(57793);
            } else if (!C1720g.m3531RK() || C1668a.m3393QT()) {
                C4990ab.m7413e("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:%b  isHold:%b  opcode:%d", Boolean.valueOf(C1720g.m3531RK()), Boolean.valueOf(C1668a.m3393QT()), Integer.valueOf(intExtra));
                AppMethodBeat.m2505o(57793);
            } else {
                if (C1720g.m3540Rg().ftA == null) {
                    C4990ab.m7421w("MicroMsg.NotifyReceiver", "receiveImp  opcode:%d  getDispatcher == null", Integer.valueOf(intExtra));
                    C1720g.m3540Rg().mo14548cD(true);
                }
                if (this.ecl == null) {
                    NotifyService notifyService;
                    boolean z;
                    if (C4872b.dnO()) {
                        notifyService = this;
                    } else {
                        int i = C5046bo.getInt(((C7234a) C1720g.m3528K(C7234a.class)).mo15608Nu().getValue("AndroidOldNotifyReceiver"), 0);
                        C1720g.m3537RQ();
                        C1720g.m3534RN();
                        if (i > C1179i.m2593bL(C1668a.m3383QF(), 100)) {
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
                C4990ab.m7417i("MicroMsg.NotifyReceiver", "handleCommand useOld:%s operationCode:%d", this.ecl, Integer.valueOf(intExtra));
                switch (intExtra) {
                    case 1:
                        if (this.ecl.booleanValue()) {
                            NotifyService.m41413z(C4996ah.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NETWORK_AVAILABLE");
                        }
                        NotifyService.m41407bt(C4996ah.getContext());
                        AppMethodBeat.m2505o(57793);
                        return;
                    case 2:
                        if (this.ecl.booleanValue()) {
                            NotifyService.m41413z(C4996ah.getContext(), "NotifyReceiver.handleCommand:NOTIFY_OPCODE_NOTIFY");
                            m41412r(intent);
                            AppMethodBeat.m2505o(57793);
                            return;
                        }
                        m41411q(intent);
                        AppMethodBeat.m2505o(57793);
                        return;
                    default:
                        C4990ab.m7412e("MicroMsg.NotifyReceiver", "invald opCode:".concat(String.valueOf(intExtra)));
                        AppMethodBeat.m2505o(57793);
                        return;
                }
            }
        }

        public final void onCreate() {
            AppMethodBeat.m2504i(57794);
            super.onCreate();
            AppMethodBeat.m2505o(57794);
        }

        /* renamed from: jG */
        public static void m41408jG(String str) {
            AppMethodBeat.m2504i(57795);
            synchronized (NotifyReceiver.ecf) {
                try {
                    if (NotifyReceiver.ebJ == null) {
                        NotifyReceiver.ebJ = new WakerLock(C4996ah.getContext(), "MicroMsg.NotifyReceiver");
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57795);
                }
            }
            NotifyReceiver.ebJ.lock(5000, str);
        }

        /* renamed from: z */
        private static void m41413z(Context context, String str) {
            AppMethodBeat.m2504i(57796);
            synchronized (NotifyReceiver.ecf) {
                try {
                    if (NotifyReceiver.ebJ == null) {
                        NotifyReceiver.ebJ = new WakerLock(context, "MicroMsg.NotifyReceiver");
                    }
                    NotifyReceiver.ebJ.lock(14000, str);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57796);
                }
            }
        }

        /* renamed from: A */
        private static void m41404A(Context context, String str) {
            AppMethodBeat.m2504i(57797);
            synchronized (NotifyReceiver.ecg) {
                try {
                    if (NotifyReceiver.ecc == null) {
                        NotifyReceiver.ecc = new WakerLock(context, "MicroMsg.NotifyReceiver");
                    }
                    NotifyReceiver.ecc.lock(60000, str);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(57797);
                }
            }
        }

        /* renamed from: q */
        private void m41411q(Intent intent) {
            AppMethodBeat.m2504i(57798);
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
            C4990ab.m7417i(str, str2, objArr);
            if (C5046bo.m7540cb(byteArrayExtra2)) {
                C4990ab.m7412e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session null and ret sessionKey:" + byteArrayExtra2 + " respType:" + intExtra);
                AppMethodBeat.m2505o(57798);
                return;
            }
            int i;
            switch (intExtra) {
                case 39:
                    C1720g.m3540Rg().mo14541a(new C37941i(), 0);
                    AppMethodBeat.m2505o(57798);
                    return;
                case 138:
                    int i2;
                    if (byteArrayExtra == null) {
                        i2 = 7;
                    } else {
                        i2 = C37432o.m63092t(byteArrayExtra, 0);
                    }
                    i = byteArrayExtra == null ? 2 : 1;
                    String str3 = "MicroMsg.NotifyReceiver";
                    String str4 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = Integer.valueOf(i2);
                    objArr2[1] = Integer.valueOf(i);
                    objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                    C4990ab.m7417i(str3, str4, objArr2);
                    ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44214a((long) i2, i, "");
                    AppMethodBeat.m2505o(57798);
                    return;
                case 268369921:
                    if (C5046bo.m7540cb(byteArrayExtra) || byteArrayExtra.length <= 8) {
                        C4990ab.m7412e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                        AppMethodBeat.m2505o(57798);
                        return;
                    }
                    int t = C37432o.m63092t(byteArrayExtra, 0);
                    i = C37432o.m63092t(byteArrayExtra, 4);
                    if (i != byteArrayExtra.length - 8) {
                        C4990ab.m7412e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                        AppMethodBeat.m2505o(57798);
                        return;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(byteArrayExtra, 8, bArr, 0, i);
                    C4990ab.m7417i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", Integer.valueOf(t), Integer.valueOf(i), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra));
                    C37942k.m64132b(t, bArr, byteArrayExtra2, longExtra);
                    AppMethodBeat.m2505o(57798);
                    return;
                case 1000000205:
                    C4990ab.m7416i("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                    C4847b c4847b = new C4847b();
                    ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44214a(c4847b.vyM, 1, c4847b.dmu());
                    AppMethodBeat.m2505o(57798);
                    return;
                case 2147480001:
                    C4990ab.m7416i("MicroMsg.NotifyReceiver", "dkpush FCM Notify");
                    ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44214a(7, 16, "");
                    AppMethodBeat.m2505o(57798);
                    return;
                default:
                    ((PluginZero) C1720g.m3530M(PluginZero.class)).yag.mo56551a(this, intExtra, byteArrayExtra, byteArrayExtra2, longExtra);
                    AppMethodBeat.m2505o(57798);
                    return;
            }
        }

        /* renamed from: r */
        private void m41412r(Intent intent) {
            AppMethodBeat.m2504i(57799);
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
            objArr[3] = C5046bo.anv(C5046bo.m7543cd(byteArrayExtra2));
            C4990ab.m7417i(str, str2, objArr);
            int i;
            int a;
            switch (intExtra) {
                case 39:
                    C1720g.m3540Rg().mo14541a(new C37941i(), 0);
                    AppMethodBeat.m2505o(57799);
                    return;
                case 138:
                    int i2;
                    if (byteArrayExtra == null) {
                        i2 = 7;
                    } else {
                        i2 = C37432o.m63092t(byteArrayExtra, 0);
                    }
                    i = byteArrayExtra == null ? 2 : 1;
                    String str3 = "MicroMsg.NotifyReceiver";
                    String str4 = "dkpush NOTIFY or SyncCheck selector:%d scnen:%d  respBuf:%d ";
                    Object[] objArr2 = new Object[3];
                    objArr2[0] = Integer.valueOf(i2);
                    objArr2[1] = Integer.valueOf(i);
                    objArr2[2] = Integer.valueOf(byteArrayExtra == null ? -1 : byteArrayExtra.length);
                    C4990ab.m7411d(str3, str4, objArr2);
                    try {
                        NotifyReceiver.ece.lock();
                        a = ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44214a((long) i2, i, "");
                        if (a > 0) {
                            C4990ab.m7411d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(a));
                            NotifyReceiver.ecd.add(Long.valueOf((long) a));
                            NotifyService.m41404A(C4996ah.getContext(), "NotifyReceiver.dealWithNotify:MMFunc_NewSync");
                        }
                        try {
                            NotifyReceiver.ece.unlock();
                            AppMethodBeat.m2505o(57799);
                            return;
                        } catch (Exception e) {
                            AppMethodBeat.m2505o(57799);
                            return;
                        }
                    } catch (Throwable th) {
                        try {
                            NotifyReceiver.ece.unlock();
                        } catch (Exception e2) {
                        }
                        AppMethodBeat.m2505o(57799);
                        throw th;
                    }
                case 268369921:
                    if (C5046bo.m7540cb(byteArrayExtra2)) {
                        C4990ab.m7412e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify session:".concat(String.valueOf(byteArrayExtra2)));
                        AppMethodBeat.m2505o(57799);
                        return;
                    } else if (C5046bo.m7540cb(byteArrayExtra) || byteArrayExtra.length <= 8) {
                        C4990ab.m7412e("MicroMsg.NotifyReceiver", "dkpush dealWithNotify respBuf error ");
                        AppMethodBeat.m2505o(57799);
                        return;
                    } else {
                        a = C37432o.m63092t(byteArrayExtra, 0);
                        i = C37432o.m63092t(byteArrayExtra, 4);
                        if (i != byteArrayExtra.length - 8) {
                            C4990ab.m7412e("MicroMsg.NotifyReceiver", "dkpush: respBuf length error len:" + byteArrayExtra.length);
                            AppMethodBeat.m2505o(57799);
                            return;
                        }
                        byte[] bArr = new byte[i];
                        System.arraycopy(byteArrayExtra, 8, bArr, 0, i);
                        C4990ab.m7417i("MicroMsg.NotifyReceiver", "dkpush PUSHDATA flag:%d bufLen:%d respBuf:%d recvTime:%d", Integer.valueOf(a), Integer.valueOf(i), Integer.valueOf(byteArrayExtra.length), Long.valueOf(longExtra));
                        try {
                            NotifyReceiver.ece.lock();
                            C37942k.m64132b(a, bArr, byteArrayExtra2, longExtra);
                            NotifyReceiver.ecd.add(Long.valueOf(longExtra));
                            NotifyService.m41404A(C4996ah.getContext(), "NotifyReceiver.NotifyData");
                            try {
                                NotifyReceiver.ece.unlock();
                                AppMethodBeat.m2505o(57799);
                                return;
                            } catch (Exception e3) {
                                AppMethodBeat.m2505o(57799);
                                return;
                            }
                        } catch (Throwable th2) {
                            try {
                                NotifyReceiver.ece.unlock();
                            } catch (Exception e4) {
                            }
                            AppMethodBeat.m2505o(57799);
                            throw th2;
                        }
                    }
                case 1000000205:
                    C4990ab.m7410d("MicroMsg.NotifyReceiver", "oreh on newsynccheck2 notify, notify=" + (byteArrayExtra != null));
                    C4847b c4847b = new C4847b();
                    try {
                        c4847b.mo5744P(byteArrayExtra);
                        NotifyReceiver.ece.lock();
                        a = ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44214a(c4847b.vyM, 1, c4847b.dmu());
                        if (a > 0) {
                            C4990ab.m7411d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(a));
                            NotifyReceiver.ecd.add(Long.valueOf((long) a));
                            NotifyService.m41404A(C4996ah.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_NEW_SYNC_CHECK2_RESP");
                        }
                        try {
                            NotifyReceiver.ece.unlock();
                            AppMethodBeat.m2505o(57799);
                            return;
                        } catch (Exception e5) {
                            AppMethodBeat.m2505o(57799);
                            return;
                        }
                    } catch (Exception e6) {
                        C4990ab.printErrStackTrace("MicroMsg.NotifyReceiver", e6, "", new Object[0]);
                        try {
                            NotifyReceiver.ece.unlock();
                            AppMethodBeat.m2505o(57799);
                            return;
                        } catch (Exception e7) {
                            AppMethodBeat.m2505o(57799);
                            return;
                        }
                    } catch (Throwable th22) {
                        try {
                            NotifyReceiver.ece.unlock();
                        } catch (Exception e8) {
                        }
                        AppMethodBeat.m2505o(57799);
                        throw th22;
                    }
                case 2147480001:
                    C4990ab.m7410d("MicroMsg.NotifyReceiver", "dkpush FCM Notify");
                    a = ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44214a(7, 16, "");
                    try {
                        NotifyReceiver.ece.lock();
                        if (a > 0) {
                            C4990ab.m7411d("MicroMsg.NotifyReceiver", "add scene hash to memo, hash:%d", Integer.valueOf(a));
                            NotifyReceiver.ecd.add(Long.valueOf((long) a));
                            NotifyService.m41404A(C4996ah.getContext(), "NotifyReceiver.dealWithNotify:MM_PKT_FCM_NOTIFY");
                        }
                        try {
                            NotifyReceiver.ece.unlock();
                            AppMethodBeat.m2505o(57799);
                            return;
                        } catch (Exception e9) {
                            AppMethodBeat.m2505o(57799);
                            return;
                        }
                    } catch (Throwable th222) {
                        try {
                            NotifyReceiver.ece.unlock();
                        } catch (Exception e10) {
                        }
                        AppMethodBeat.m2505o(57799);
                        throw th222;
                    }
                default:
                    ((PluginZero) C1720g.m3530M(PluginZero.class)).yag.mo56551a(this, intExtra, byteArrayExtra, byteArrayExtra2, longExtra);
                    AppMethodBeat.m2505o(57799);
                    return;
            }
        }

        /* renamed from: bt */
        private static void m41407bt(Context context) {
            AppMethodBeat.m2504i(57800);
            C4990ab.m7416i("MicroMsg.NotifyReceiver", "dealWithLooper");
            if (!C1720g.m3531RK() || C1668a.m3393QT()) {
                C4990ab.m7420w("MicroMsg.NotifyReceiver", "receiveImp hasSetuin:" + C1720g.m3531RK() + " isHold:" + C1668a.m3393QT());
                AppMethodBeat.m2505o(57800);
            } else if (C1720g.m3540Rg().foreground || !C32856ab.m53749cg(context)) {
                ((C35779b) C1720g.m3528K(C35779b.class)).ahW().mo44216lN(2);
                AppMethodBeat.m2505o(57800);
            } else {
                C1720g.m3540Rg().mo14541a(new C37941i(), 0);
                AppMethodBeat.m2505o(57800);
            }
        }
    }

    /* renamed from: com.tencent.mm.booter.NotifyReceiver$a */
    public static class C25970a implements C1202f {
        private static long ecj = 0;

        /* renamed from: com.tencent.mm.booter.NotifyReceiver$a$3 */
        class C259693 implements Runnable {
            C259693() {
            }

            public final void run() {
                AppMethodBeat.m2504i(57782);
                if (C1720g.m3534RN().mo5161QY()) {
                    int i;
                    if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(15, null)) == 0) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (i != 0) {
                        C4990ab.m7412e("MicroMsg.NotifyReceiver", "not init finish , do not post sync task");
                        AppMethodBeat.m2505o(57782);
                        return;
                    }
                    long anU = C5046bo.anU();
                    if (anU - C25970a.ecj <= 0 || anU - C25970a.ecj >= 10000) {
                        C25970a.ecj = anU;
                        C4990ab.m7416i("MicroMsg.NotifyReceiver", "begin post sync task");
                        anU = C5046bo.m7588yz();
                        C4879a.xxA.mo10055m(new C6523mp());
                        C4990ab.m7417i("MicroMsg.NotifyReceiver", "end post sync task, cost=%d, Idle done", Long.valueOf(C5046bo.m7525az(anU)));
                        C25970a.m41416b(C25970a.this);
                        AppMethodBeat.m2505o(57782);
                        return;
                    }
                    C4990ab.m7411d("MicroMsg.NotifyReceiver", "sync task limit now - last : %d", Long.valueOf(anU - C25970a.ecj));
                    AppMethodBeat.m2505o(57782);
                    return;
                }
                AppMethodBeat.m2505o(57782);
            }

            public final String toString() {
                AppMethodBeat.m2504i(57783);
                String str = super.toString() + "|doPostSyncTask";
                AppMethodBeat.m2505o(57783);
                return str;
            }
        }

        /* renamed from: com.tencent.mm.booter.NotifyReceiver$a$2 */
        class C259712 implements Runnable {
            C259712() {
            }

            public final void run() {
                AppMethodBeat.m2504i(57781);
                C4990ab.m7417i("MicroMsg.NotifyReceiver", "checkKillProcess, canKillProcess :%b", Boolean.valueOf(NotifyReceiver.eci));
                synchronized (NotifyReceiver.ecf) {
                    try {
                        if (NotifyReceiver.ebJ != null) {
                            NotifyReceiver.ebJ.unLock();
                        }
                        NotifyReceiver.ebJ = null;
                    } catch (Throwable th) {
                        while (true) {
                            AppMethodBeat.m2505o(57781);
                        }
                    }
                }
                if (NotifyReceiver.eci) {
                    PluginZero pluginZero = (PluginZero) C1720g.m3530M(PluginZero.class);
                    if (pluginZero.yaf != null) {
                        pluginZero.yaf.aVq();
                    }
                    C4990ab.dou();
                    Process.killProcess(Process.myPid());
                }
                AppMethodBeat.m2505o(57781);
            }
        }

        /* renamed from: com.tencent.mm.booter.NotifyReceiver$a$1 */
        class C259721 implements IdleHandler {
            C259721() {
            }

            public final boolean queueIdle() {
                AppMethodBeat.m2504i(57780);
                C25970a.m41415a(C25970a.this);
                AppMethodBeat.m2505o(57780);
                return false;
            }
        }

        /* renamed from: b */
        static /* synthetic */ void m41416b(C25970a c25970a) {
            AppMethodBeat.m2504i(57787);
            c25970a.m41417eO(3000);
            AppMethodBeat.m2505o(57787);
        }

        public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
            long j;
            AppMethodBeat.m2504i(57784);
            long hashCode = (long) c1207m.hashCode();
            if (c1207m.getType() == 268369922) {
                j = ((C26448f) c1207m).fHM;
            } else {
                j = hashCode;
            }
            try {
                NotifyReceiver.ece.lock();
                synchronized (NotifyReceiver.ecg) {
                    String str2 = "MicroMsg.NotifyReceiver";
                    String str3 = "NotifyReceiver onSceneEnd type:%d syncHash: %d hashInMemo: %b isLocking: %b";
                    Object[] objArr = new Object[4];
                    objArr[0] = Integer.valueOf(c1207m.getType());
                    objArr[1] = Long.valueOf(j);
                    objArr[2] = Boolean.valueOf(NotifyReceiver.ecd.contains(Long.valueOf(j)));
                    objArr[3] = Boolean.valueOf(NotifyReceiver.ecc != null ? NotifyReceiver.ecc.isLocking() : false);
                    C4990ab.m7417i(str2, str3, objArr);
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
                        C4990ab.m7416i("MicroMsg.NotifyReceiver", "all scene done, unlock wakelock.");
                    } else {
                        C4990ab.m7417i("MicroMsg.NotifyReceiver", "rest %d scene undone, keep wakelock.", Integer.valueOf(NotifyReceiver.ecd.size()));
                    }
                    try {
                        NotifyReceiver.ece.unlock();
                    } catch (Exception e2) {
                    }
                    switch (c1207m.getType()) {
                        case 138:
                            if (C1720g.m3534RN().mo5161QY()) {
                                Looper.myQueue().addIdleHandler(new C259721());
                                if (i == 0 && i2 == 0 && C1810a.m3717XF()) {
                                    try {
                                        C1720g.m3537RQ();
                                        C1810a c1810a = C1720g.m3534RN().eIQ;
                                        if (c1810a.fkb > -1) {
                                            c1810a.fkb++;
                                        }
                                        C4990ab.m7417i("MicroMsg.AccInfoCacheInWorker", "countNormalCgi :%s ", Long.valueOf(c1810a.fkb));
                                        if (c1810a.fkb == 2 || c1810a.fkb == 5) {
                                            C7053e.pXa.mo8378a(226, c1810a.fkb == 2 ? 37 : 38, 1, false);
                                            C7053e.pXa.mo8381e(11098, Integer.valueOf(2001), Long.valueOf(c1810a.fkb));
                                            break;
                                        }
                                    } catch (Throwable th) {
                                        C4990ab.m7413e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", C5046bo.m7574l(th));
                                        break;
                                    }
                                }
                            }
                            break;
                    }
                    m41417eO(7000);
                    AppMethodBeat.m2505o(57784);
                } catch (Throwable th2) {
                    try {
                        NotifyReceiver.ece.unlock();
                    } catch (Exception e3) {
                    }
                    AppMethodBeat.m2505o(57784);
                    throw th2;
                }
            } catch (Throwable th22) {
                try {
                    NotifyReceiver.ece.unlock();
                } catch (Exception e4) {
                }
                AppMethodBeat.m2505o(57784);
                throw th22;
            }
        }

        /* renamed from: eO */
        private void m41417eO(long j) {
            AppMethodBeat.m2504i(57785);
            if (C1892aa.anh().getBoolean("is_in_notify_mode", false)) {
                new C7306ak(Looper.myLooper()).postDelayed(new C259712(), j);
                AppMethodBeat.m2505o(57785);
                return;
            }
            AppMethodBeat.m2505o(57785);
        }

        /* renamed from: a */
        static /* synthetic */ void m41415a(C25970a c25970a) {
            AppMethodBeat.m2504i(57786);
            C1720g.m3537RQ();
            C1720g.m3539RS().mo10302aa(new C259693());
            AppMethodBeat.m2505o(57786);
        }
    }

    static {
        AppMethodBeat.m2504i(57806);
        AppMethodBeat.m2505o(57806);
    }

    /* renamed from: Im */
    public static void m41394Im() {
        AppMethodBeat.m2504i(57802);
        NotifyReceiver.m41395In();
        AppMethodBeat.m2505o(57802);
    }

    /* renamed from: In */
    public static void m41395In() {
        AppMethodBeat.m2504i(57803);
        C4990ab.m7416i("MicroMsg.NotifyReceiver", "quitLightPushMode");
        eci = false;
        C1892aa.anh().edit().putBoolean("is_in_notify_mode", false).commit();
        AppMethodBeat.m2505o(57803);
    }

    /* renamed from: Io */
    public static void m41396Io() {
        AppMethodBeat.m2504i(57804);
        C1720g.m3540Rg().mo14546b(138, ech);
        C1720g.m3540Rg().mo14546b(39, ech);
        C1720g.m3540Rg().mo14546b(268369922, ech);
        if (ech == null) {
            ech = new C25970a();
        }
        C1720g.m3540Rg().mo14539a(138, ech);
        C1720g.m3540Rg().mo14539a(39, ech);
        C1720g.m3540Rg().mo14539a(268369922, ech);
        AppMethodBeat.m2505o(57804);
    }

    public void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(57805);
        C4990ab.m7417i("MicroMsg.NotifyReceiver", "onReceive intent :%s", intent);
        if (intent == null) {
            AppMethodBeat.m2505o(57805);
        } else if (C1737l.m3591bL(context)) {
            C4990ab.m7416i("MicroMsg.NotifyReceiver", "fully exited, no need to start service");
            AppMethodBeat.m2505o(57805);
        } else {
            C41753a.m73607lm(intent.getIntExtra("notify_respType", -1));
            Intent intent2 = new Intent(context, NotifyService.class);
            if (intent.getBooleanExtra("intent_from_shoot_key", false)) {
                intent2.putExtra("notify_option_type", 3);
            }
            intent2.putExtras(intent);
            C5091c.m7718a(intent2, "mm", true, new Intent(C4996ah.getContext(), MMProcessService.class));
            AppMethodBeat.m2505o(57805);
        }
    }
}
