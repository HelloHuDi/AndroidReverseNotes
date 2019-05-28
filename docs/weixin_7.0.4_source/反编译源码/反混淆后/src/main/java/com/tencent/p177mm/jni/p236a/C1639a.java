package com.tencent.p177mm.jni.p236a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import android.util.SparseArray;
import com.tencent.mars.comm.WakerLock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.p177mm.p230g.p231a.C6532om;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vfs.C5728b;
import com.tencent.p177mm.vfs.C5730e;
import com.tencent.p177mm.vfs.C5736j;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.jni.a.a */
public final class C1639a {
    private static SparseArray<C1635b> eHG = new SparseArray();
    private static final byte[] eHH = new byte[0];
    private static C7306ak mHandler = new C7306ak(Looper.getMainLooper());

    /* renamed from: com.tencent.mm.jni.a.a$a */
    static class C1633a implements Runnable {
        private WakerLock eHI = null;

        public C1633a(WakerLock wakerLock) {
            this.eHI = wakerLock;
        }

        public final void run() {
            AppMethodBeat.m2504i(77185);
            synchronized (C1639a.eHH) {
                try {
                    C1635b c1635b = (C1635b) C1639a.eHG.get(this.eHI.hashCode());
                    if (c1635b != null) {
                        String str = "MicroMsg.WakeLockManager";
                        String str2 = "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(this.eHI.hashCode());
                        objArr[1] = Integer.valueOf(this.eHI.innerWakeLockHashCode());
                        objArr[2] = this.eHI.getCreatePosStackLine();
                        Collection<C1634a> values = c1635b.eHL.values();
                        StringBuilder stringBuilder = new StringBuilder();
                        Object obj = 1;
                        for (C1634a c1634a : values) {
                            if (obj != null) {
                                obj = null;
                            } else {
                                stringBuilder.append(',');
                            }
                            if (c1634a.eHN != 0) {
                                stringBuilder.append('{').append(c1634a.eHM).append(',').append(SystemClock.elapsedRealtime() - c1634a.eHN).append('}');
                            }
                        }
                        if (stringBuilder.length() == 0) {
                            stringBuilder.append("<empty>");
                        }
                        objArr[3] = stringBuilder.toString();
                        C4990ab.m7421w(str, str2, objArr);
                    } else {
                        C4990ab.m7421w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", Integer.valueOf(this.eHI.hashCode()), Integer.valueOf(this.eHI.innerWakeLockHashCode()), this.eHI.getCreatePosStackLine(), "#lost-trace-state#");
                    }
                    this.eHI.unLock();
                } finally {
                    AppMethodBeat.m2505o(77185);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.jni.a.a$b */
    static class C1635b {
        volatile boolean eHJ = false;
        C1633a eHK = null;
        Map<String, C1634a> eHL = new HashMap();

        /* renamed from: com.tencent.mm.jni.a.a$b$a */
        static class C1634a {
            public String eHM = null;
            public long eHN = 0;

            public C1634a(String str, long j) {
                this.eHM = str;
                this.eHN = j;
            }
        }

        public C1635b(WakerLock wakerLock) {
            AppMethodBeat.m2504i(77186);
            this.eHK = new C1633a(wakerLock);
            AppMethodBeat.m2505o(77186);
        }
    }

    /* renamed from: com.tencent.mm.jni.a.a$c */
    static class C1638c {
        private static int eHO = 0;
        private static long eHP = 0;
        private static HashMap<String, C1637a> eHQ = null;
        private static final byte[] eHR = new byte[0];
        private static BroadcastReceiver eHS = null;
        private static long mLastReportTime = 0;

        /* renamed from: com.tencent.mm.jni.a.a$c$1 */
        static class C16361 extends BroadcastReceiver {
            C16361() {
            }

            public final void onReceive(Context context, Intent intent) {
                AppMethodBeat.m2504i(77187);
                String action = intent.getAction();
                if (C5046bo.isNullOrNil(action)) {
                    AppMethodBeat.m2505o(77187);
                    return;
                }
                int intExtra = intent.getIntExtra("pid", 0);
                if (intExtra == 0) {
                    AppMethodBeat.m2505o(77187);
                    return;
                }
                String stringExtra = intent.getStringExtra("processName");
                if (C5046bo.isNullOrNil(stringExtra) || !stringExtra.equals(C5046bo.m7524aw(C4996ah.getContext(), intExtra))) {
                    AppMethodBeat.m2505o(77187);
                    return;
                }
                String stringExtra2 = intent.getStringExtra("traceMsg");
                long longExtra = intent.getLongExtra("tick", 0);
                if ("com.tencent.mm.ACTION.note_tracemsg_lock".equals(action)) {
                    C1638c.m3302e(stringExtra, stringExtra2, longExtra);
                    AppMethodBeat.m2505o(77187);
                    return;
                }
                if ("com.tencent.mm.ACTION.note_tracemsg_unlock".equals(action)) {
                    C1638c.m3303f(stringExtra, stringExtra2, longExtra);
                }
                AppMethodBeat.m2505o(77187);
            }
        }

        /* renamed from: com.tencent.mm.jni.a.a$c$a */
        static class C1637a implements Externalizable {
            public String eHM;
            public String eHT;
            public String eHU;
            public boolean eHV;
            public int eHW;
            public int eHX;
            public long eHY;
            public long eHZ;
            public AtomicInteger eIa;

            private C1637a() {
                AppMethodBeat.m2504i(77188);
                this.eHT = "";
                this.eHM = "";
                this.eHU = "";
                this.eHV = false;
                this.eHW = 0;
                this.eHX = 0;
                this.eHY = 0;
                this.eHZ = 0;
                this.eIa = new AtomicInteger(0);
                AppMethodBeat.m2505o(77188);
            }

            /* synthetic */ C1637a(byte b) {
                this();
            }

            public final void readExternal(ObjectInput objectInput) {
                AppMethodBeat.m2504i(77189);
                synchronized (C1638c.eHR) {
                    try {
                        this.eHT = objectInput.readUTF();
                        this.eHM = objectInput.readUTF();
                        this.eHW = objectInput.readInt();
                        this.eHX = objectInput.readInt();
                        this.eHY = objectInput.readLong();
                        this.eHU = "";
                        this.eHV = false;
                        this.eHZ = 0;
                        this.eIa = new AtomicInteger(0);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(77189);
                    }
                }
            }

            public final void writeExternal(ObjectOutput objectOutput) {
                AppMethodBeat.m2504i(77190);
                synchronized (C1638c.eHR) {
                    try {
                        objectOutput.writeUTF(this.eHT);
                        objectOutput.writeUTF(this.eHM);
                        objectOutput.writeInt(this.eHW);
                        objectOutput.writeInt(this.eHX);
                        objectOutput.writeLong(this.eHY);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.m2505o(77190);
                    }
                }
            }
        }

        /* renamed from: e */
        static /* synthetic */ void m3302e(String str, String str2, long j) {
            AppMethodBeat.m2504i(77200);
            C1638c.m3300c(str, str2, j);
            AppMethodBeat.m2505o(77200);
        }

        /* renamed from: f */
        static /* synthetic */ void m3303f(String str, String str2, long j) {
            AppMethodBeat.m2504i(77201);
            C1638c.m3301d(str, str2, j);
            AppMethodBeat.m2505o(77201);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x009e A:{SYNTHETIC, Splitter:B:26:0x009e} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0094 A:{SYNTHETIC, Splitter:B:20:0x0094} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x009e A:{SYNTHETIC, Splitter:B:26:0x009e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: Qm */
        public static void m3297Qm() {
            ObjectInputStream objectInputStream;
            IntentFilter intentFilter;
            Throwable th;
            ObjectInputStream objectInputStream2 = null;
            AppMethodBeat.m2504i(77191);
            if (eHO == 0) {
                eHO = Process.myPid();
                eHS = new C16361();
                synchronized (eHR) {
                    try {
                        ObjectInputStream objectInputStream3 = new ObjectInputStream(C5730e.m8638p(new C5728b(C4996ah.getContext().getCacheDir(), "wakelock/wakelock_stats.bin")));
                        try {
                            mLastReportTime = objectInputStream3.readLong();
                            eHQ = (HashMap) objectInputStream3.readObject();
                            try {
                                objectInputStream3.close();
                            } catch (Exception e) {
                            }
                        } catch (Exception e2) {
                            objectInputStream = objectInputStream3;
                            try {
                                C4990ab.m7412e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                                mLastReportTime = SystemClock.elapsedRealtime();
                                eHQ = new HashMap();
                                if (objectInputStream != null) {
                                    try {
                                        objectInputStream.close();
                                    } catch (Exception e3) {
                                    }
                                }
                                intentFilter = new IntentFilter();
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                                C4996ah.getContext().registerReceiver(eHS, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                                C4990ab.m7417i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", C4996ah.getProcessName());
                                AppMethodBeat.m2505o(77191);
                            } catch (Throwable th2) {
                                th = th2;
                                objectInputStream2 = objectInputStream;
                                if (objectInputStream2 != null) {
                                }
                                AppMethodBeat.m2505o(77191);
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            objectInputStream2 = objectInputStream3;
                            if (objectInputStream2 != null) {
                                try {
                                    objectInputStream2.close();
                                } catch (Exception e4) {
                                }
                            }
                            AppMethodBeat.m2505o(77191);
                            throw th;
                        }
                        try {
                        } catch (Throwable th4) {
                            AppMethodBeat.m2505o(77191);
                        }
                    } catch (Exception e5) {
                        objectInputStream = null;
                        C4990ab.m7412e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                        mLastReportTime = SystemClock.elapsedRealtime();
                        eHQ = new HashMap();
                        if (objectInputStream != null) {
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                        C4996ah.getContext().registerReceiver(eHS, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                        C4990ab.m7417i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", C4996ah.getProcessName());
                        AppMethodBeat.m2505o(77191);
                    } catch (Throwable th32) {
                        th = th32;
                        if (objectInputStream2 != null) {
                        }
                        AppMethodBeat.m2505o(77191);
                        throw th;
                    }
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                C4996ah.getContext().registerReceiver(eHS, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                C4990ab.m7417i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", C4996ah.getProcessName());
            }
            AppMethodBeat.m2505o(77191);
        }

        public static void detach() {
            AppMethodBeat.m2504i(77192);
            if (eHO > 0) {
                C4996ah.getContext().unregisterReceiver(eHS);
                C1638c.m3299Qo();
                eHO = 0;
                C4990ab.m7417i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", C4996ah.getProcessName());
            }
            AppMethodBeat.m2505o(77192);
        }

        /* renamed from: lm */
        public static void m3304lm(String str) {
            AppMethodBeat.m2504i(77193);
            C1638c.m3306r(str, true);
            AppMethodBeat.m2505o(77193);
        }

        /* renamed from: ln */
        public static void m3305ln(String str) {
            AppMethodBeat.m2504i(77194);
            C1638c.m3306r(str, false);
            AppMethodBeat.m2505o(77194);
        }

        /* renamed from: r */
        private static void m3306r(String str, boolean z) {
            AppMethodBeat.m2504i(77195);
            int myPid = Process.myPid();
            String processName = C4996ah.getProcessName();
            Intent intent;
            if (myPid == eHO) {
                if (z) {
                    C1638c.m3300c(processName, str, SystemClock.elapsedRealtime());
                    AppMethodBeat.m2505o(77195);
                    return;
                }
                C1638c.m3301d(processName, str, SystemClock.elapsedRealtime());
                AppMethodBeat.m2505o(77195);
            } else if (z) {
                intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", processName);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                C4996ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
                AppMethodBeat.m2505o(77195);
            } else {
                intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", processName);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                C4996ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
                AppMethodBeat.m2505o(77195);
            }
        }

        /* renamed from: c */
        private static void m3300c(String str, String str2, long j) {
            AppMethodBeat.m2504i(77196);
            String str3 = str + "_" + str2;
            synchronized (eHR) {
                try {
                    C1637a c1637a = (C1637a) eHQ.get(str3);
                    if (c1637a == null) {
                        c1637a = new C1637a();
                        c1637a.eHT = str;
                        c1637a.eHM = str2;
                        c1637a.eHY = 0;
                        c1637a.eHW = 0;
                        c1637a.eHX = 0;
                        eHQ.put(str3, c1637a);
                    }
                    if (c1637a.eIa.getAndIncrement() == 0) {
                        c1637a.eHZ = j;
                        c1637a.eHU = C5023at.getNetTypeString(C4996ah.getContext());
                        c1637a.eHV = C4872b.foreground;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(77196);
                }
            }
        }

        /* renamed from: d */
        private static void m3301d(String str, String str2, long j) {
            long j2;
            AppMethodBeat.m2504i(77197);
            String str3 = str + "_" + str2;
            long j3 = 0;
            synchronized (eHR) {
                try {
                    C1637a c1637a = (C1637a) eHQ.get(str3);
                    if (c1637a != null && c1637a.eIa.get() > 0) {
                        c1637a.eHW++;
                        if (c1637a.eIa.decrementAndGet() == 0) {
                            j3 = j - c1637a.eHZ;
                            c1637a.eHY += j3;
                            c1637a.eHX++;
                        }
                    }
                    j2 = j3;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(77197);
                    }
                }
            }
            C1638c.m3298Qn();
            j3 = SystemClock.elapsedRealtime();
            if (j2 >= 14000 || j3 - eHP >= 3600000) {
                C4990ab.m7410d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
                C1638c.m3299Qo();
                eHP = j3;
            }
            AppMethodBeat.m2505o(77197);
        }

        /* renamed from: Qn */
        private static void m3298Qn() {
            AppMethodBeat.m2504i(77198);
            synchronized (eHR) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (elapsedRealtime - mLastReportTime >= 21600000) {
                        if (!eHQ.isEmpty()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (Entry value : eHQ.entrySet()) {
                                C1637a c1637a = (C1637a) value.getValue();
                                if (c1637a.eHX > 0) {
                                    stringBuilder.setLength(0);
                                    stringBuilder.append(c1637a.eHT).append(',').append(c1637a.eHM.replace(",", "##")).append(',').append(c1637a.eHX).append(',').append(c1637a.eHW).append(',').append(c1637a.eHY).append(',').append(c1637a.eHV ? 1 : 0).append(',').append(c1637a.eHU);
                                    String stringBuilder2 = stringBuilder.toString();
                                    C6532om c6532om = new C6532om();
                                    c6532om.cKO.cKP = stringBuilder2;
                                    C4879a.xxA.mo10055m(c6532om);
                                    C4990ab.m7411d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", stringBuilder.toString());
                                }
                            }
                            eHQ.clear();
                        }
                        mLastReportTime = elapsedRealtime;
                    }
                } finally {
                    AppMethodBeat.m2505o(77198);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0062 A:{SYNTHETIC, Splitter:B:12:0x0062} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x008e A:{SYNTHETIC, Splitter:B:26:0x008e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: Qo */
        private static void m3299Qo() {
            Throwable e;
            AppMethodBeat.m2504i(77199);
            synchronized (eHR) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    C5728b c5728b = new C5728b(C4996ah.getContext().getCacheDir(), "wakelock");
                    if (C5730e.m8643tf(C5736j.m8649w(c5728b.dMD()))) {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(C5730e.m8641q(new C5728b(c5728b, "wakelock_stats.bin")));
                        try {
                            objectOutputStream2.writeLong(mLastReportTime);
                            objectOutputStream2.writeObject(eHQ);
                            try {
                                objectOutputStream2.close();
                            } catch (Exception e2) {
                            }
                        } catch (IOException e3) {
                            e = e3;
                            objectOutputStream = objectOutputStream2;
                            try {
                                C4990ab.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                                if (objectOutputStream != null) {
                                }
                            } catch (Throwable th) {
                                e = th;
                                if (objectOutputStream != null) {
                                    try {
                                        objectOutputStream.close();
                                    } catch (Exception e4) {
                                    }
                                }
                                AppMethodBeat.m2505o(77199);
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                            }
                            AppMethodBeat.m2505o(77199);
                            throw e;
                        }
                        try {
                        } finally {
                            AppMethodBeat.m2505o(77199);
                        }
                    } else {
                        IOException iOException = new IOException("failed to call VFSFileOp.mkdirs(" + C5736j.m8649w(c5728b.dMD()) + ")");
                        AppMethodBeat.m2505o(77199);
                        throw iOException;
                    }
                } catch (IOException e5) {
                    e = e5;
                    C4990ab.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e6) {
                        }
                    }
                }
            }
        }
    }

    static {
        AppMethodBeat.m2504i(77206);
        AppMethodBeat.m2505o(77206);
    }

    /* renamed from: Qi */
    public static void m3307Qi() {
        AppMethodBeat.m2504i(77202);
        C1638c.m3297Qm();
        AppMethodBeat.m2505o(77202);
    }

    /* renamed from: Qj */
    public static void m3308Qj() {
        AppMethodBeat.m2504i(77203);
        C1638c.detach();
        AppMethodBeat.m2505o(77203);
    }

    /* renamed from: a */
    public static void m3311a(WakerLock wakerLock, String str) {
        AppMethodBeat.m2504i(77204);
        synchronized (eHH) {
            try {
                C1635b c1635b = (C1635b) eHG.get(wakerLock.hashCode());
                if (c1635b == null) {
                    c1635b = new C1635b(wakerLock);
                    eHG.put(wakerLock.hashCode(), c1635b);
                }
                if (!c1635b.eHL.containsKey(str)) {
                    c1635b.eHL.put(str, new C1634a(str, SystemClock.elapsedRealtime()));
                }
                C1638c.m3304lm(str);
                C7306ak c7306ak = mHandler;
                if (!c1635b.eHJ) {
                    c1635b.eHJ = true;
                    c7306ak.postDelayed(c1635b.eHK, 60000);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(77204);
            }
        }
    }

    /* renamed from: c */
    public static void m3312c(WakerLock wakerLock) {
        AppMethodBeat.m2504i(77205);
        synchronized (eHH) {
            try {
                C1635b c1635b = (C1635b) eHG.get(wakerLock.hashCode());
                if (c1635b != null) {
                    C7306ak c7306ak = mHandler;
                    if (c1635b.eHJ) {
                        c1635b.eHJ = false;
                        c7306ak.removeCallbacks(c1635b.eHK);
                    }
                    for (C1634a c1634a : c1635b.eHL.values()) {
                        C1638c.m3305ln(c1634a.eHM);
                    }
                    c1635b.eHL.clear();
                }
            } finally {
                AppMethodBeat.m2505o(77205);
            }
        }
    }
}
