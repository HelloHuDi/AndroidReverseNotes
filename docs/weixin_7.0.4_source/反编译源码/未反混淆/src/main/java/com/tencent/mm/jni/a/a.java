package com.tencent.mm.jni.a;

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
import com.tencent.mm.g.a.om;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import com.tencent.mm.vfs.j;
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

public final class a {
    private static SparseArray<b> eHG = new SparseArray();
    private static final byte[] eHH = new byte[0];
    private static ak mHandler = new ak(Looper.getMainLooper());

    static class a implements Runnable {
        private WakerLock eHI = null;

        public a(WakerLock wakerLock) {
            this.eHI = wakerLock;
        }

        public final void run() {
            AppMethodBeat.i(77185);
            synchronized (a.eHH) {
                try {
                    b bVar = (b) a.eHG.get(this.eHI.hashCode());
                    if (bVar != null) {
                        String str = "MicroMsg.WakeLockManager";
                        String str2 = "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s";
                        Object[] objArr = new Object[4];
                        objArr[0] = Integer.valueOf(this.eHI.hashCode());
                        objArr[1] = Integer.valueOf(this.eHI.innerWakeLockHashCode());
                        objArr[2] = this.eHI.getCreatePosStackLine();
                        Collection<a> values = bVar.eHL.values();
                        StringBuilder stringBuilder = new StringBuilder();
                        Object obj = 1;
                        for (a aVar : values) {
                            if (obj != null) {
                                obj = null;
                            } else {
                                stringBuilder.append(',');
                            }
                            if (aVar.eHN != 0) {
                                stringBuilder.append('{').append(aVar.eHM).append(',').append(SystemClock.elapsedRealtime() - aVar.eHN).append('}');
                            }
                        }
                        if (stringBuilder.length() == 0) {
                            stringBuilder.append("<empty>");
                        }
                        objArr[3] = stringBuilder.toString();
                        ab.w(str, str2, objArr);
                    } else {
                        ab.w("MicroMsg.WakeLockManager", "wakerlock held too long: [%d,%d] @[%s] force to unlock it. state: %s", Integer.valueOf(this.eHI.hashCode()), Integer.valueOf(this.eHI.innerWakeLockHashCode()), this.eHI.getCreatePosStackLine(), "#lost-trace-state#");
                    }
                    this.eHI.unLock();
                } finally {
                    AppMethodBeat.o(77185);
                }
            }
        }
    }

    static class b {
        volatile boolean eHJ = false;
        a eHK = null;
        Map<String, a> eHL = new HashMap();

        static class a {
            public String eHM = null;
            public long eHN = 0;

            public a(String str, long j) {
                this.eHM = str;
                this.eHN = j;
            }
        }

        public b(WakerLock wakerLock) {
            AppMethodBeat.i(77186);
            this.eHK = new a(wakerLock);
            AppMethodBeat.o(77186);
        }
    }

    static class c {
        private static int eHO = 0;
        private static long eHP = 0;
        private static HashMap<String, a> eHQ = null;
        private static final byte[] eHR = new byte[0];
        private static BroadcastReceiver eHS = null;
        private static long mLastReportTime = 0;

        static class a implements Externalizable {
            public String eHM;
            public String eHT;
            public String eHU;
            public boolean eHV;
            public int eHW;
            public int eHX;
            public long eHY;
            public long eHZ;
            public AtomicInteger eIa;

            private a() {
                AppMethodBeat.i(77188);
                this.eHT = "";
                this.eHM = "";
                this.eHU = "";
                this.eHV = false;
                this.eHW = 0;
                this.eHX = 0;
                this.eHY = 0;
                this.eHZ = 0;
                this.eIa = new AtomicInteger(0);
                AppMethodBeat.o(77188);
            }

            /* synthetic */ a(byte b) {
                this();
            }

            public final void readExternal(ObjectInput objectInput) {
                AppMethodBeat.i(77189);
                synchronized (c.eHR) {
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
                        AppMethodBeat.o(77189);
                    }
                }
            }

            public final void writeExternal(ObjectOutput objectOutput) {
                AppMethodBeat.i(77190);
                synchronized (c.eHR) {
                    try {
                        objectOutput.writeUTF(this.eHT);
                        objectOutput.writeUTF(this.eHM);
                        objectOutput.writeInt(this.eHW);
                        objectOutput.writeInt(this.eHX);
                        objectOutput.writeLong(this.eHY);
                    } finally {
                        while (true) {
                        }
                        AppMethodBeat.o(77190);
                    }
                }
            }
        }

        static /* synthetic */ void e(String str, String str2, long j) {
            AppMethodBeat.i(77200);
            c(str, str2, j);
            AppMethodBeat.o(77200);
        }

        static /* synthetic */ void f(String str, String str2, long j) {
            AppMethodBeat.i(77201);
            d(str, str2, j);
            AppMethodBeat.o(77201);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x009e A:{SYNTHETIC, Splitter:B:26:0x009e} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0094 A:{SYNTHETIC, Splitter:B:20:0x0094} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x009e A:{SYNTHETIC, Splitter:B:26:0x009e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void Qm() {
            ObjectInputStream objectInputStream;
            IntentFilter intentFilter;
            Throwable th;
            ObjectInputStream objectInputStream2 = null;
            AppMethodBeat.i(77191);
            if (eHO == 0) {
                eHO = Process.myPid();
                eHS = new BroadcastReceiver() {
                    public final void onReceive(Context context, Intent intent) {
                        AppMethodBeat.i(77187);
                        String action = intent.getAction();
                        if (bo.isNullOrNil(action)) {
                            AppMethodBeat.o(77187);
                            return;
                        }
                        int intExtra = intent.getIntExtra("pid", 0);
                        if (intExtra == 0) {
                            AppMethodBeat.o(77187);
                            return;
                        }
                        String stringExtra = intent.getStringExtra("processName");
                        if (bo.isNullOrNil(stringExtra) || !stringExtra.equals(bo.aw(ah.getContext(), intExtra))) {
                            AppMethodBeat.o(77187);
                            return;
                        }
                        String stringExtra2 = intent.getStringExtra("traceMsg");
                        long longExtra = intent.getLongExtra("tick", 0);
                        if ("com.tencent.mm.ACTION.note_tracemsg_lock".equals(action)) {
                            c.e(stringExtra, stringExtra2, longExtra);
                            AppMethodBeat.o(77187);
                            return;
                        }
                        if ("com.tencent.mm.ACTION.note_tracemsg_unlock".equals(action)) {
                            c.f(stringExtra, stringExtra2, longExtra);
                        }
                        AppMethodBeat.o(77187);
                    }
                };
                synchronized (eHR) {
                    try {
                        ObjectInputStream objectInputStream3 = new ObjectInputStream(e.p(new com.tencent.mm.vfs.b(ah.getContext().getCacheDir(), "wakelock/wakelock_stats.bin")));
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
                                ab.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
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
                                ah.getContext().registerReceiver(eHS, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                                ab.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ah.getProcessName());
                                AppMethodBeat.o(77191);
                            } catch (Throwable th2) {
                                th = th2;
                                objectInputStream2 = objectInputStream;
                                if (objectInputStream2 != null) {
                                }
                                AppMethodBeat.o(77191);
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
                            AppMethodBeat.o(77191);
                            throw th;
                        }
                        try {
                        } catch (Throwable th4) {
                            AppMethodBeat.o(77191);
                        }
                    } catch (Exception e5) {
                        objectInputStream = null;
                        ab.e("MicroMsg.WakeLockStatsManager", "failed to load stats from storage, use default value for last stats info.");
                        mLastReportTime = SystemClock.elapsedRealtime();
                        eHQ = new HashMap();
                        if (objectInputStream != null) {
                        }
                        intentFilter = new IntentFilter();
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                        intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                        ah.getContext().registerReceiver(eHS, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                        ab.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ah.getProcessName());
                        AppMethodBeat.o(77191);
                    } catch (Throwable th32) {
                        th = th32;
                        if (objectInputStream2 != null) {
                        }
                        AppMethodBeat.o(77191);
                        throw th;
                    }
                }
                intentFilter = new IntentFilter();
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_lock");
                intentFilter.addAction("com.tencent.mm.ACTION.note_tracemsg_unlock");
                ah.getContext().registerReceiver(eHS, intentFilter, WXApp.WXAPP_BROADCAST_PERMISSION, null);
                ab.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is attached to process [%s]", ah.getProcessName());
            }
            AppMethodBeat.o(77191);
        }

        public static void detach() {
            AppMethodBeat.i(77192);
            if (eHO > 0) {
                ah.getContext().unregisterReceiver(eHS);
                Qo();
                eHO = 0;
                ab.i("MicroMsg.WakeLockStatsManager", "WakeLockStatsManager is detached from process [%s]", ah.getProcessName());
            }
            AppMethodBeat.o(77192);
        }

        public static void lm(String str) {
            AppMethodBeat.i(77193);
            r(str, true);
            AppMethodBeat.o(77193);
        }

        public static void ln(String str) {
            AppMethodBeat.i(77194);
            r(str, false);
            AppMethodBeat.o(77194);
        }

        private static void r(String str, boolean z) {
            AppMethodBeat.i(77195);
            int myPid = Process.myPid();
            String processName = ah.getProcessName();
            Intent intent;
            if (myPid == eHO) {
                if (z) {
                    c(processName, str, SystemClock.elapsedRealtime());
                    AppMethodBeat.o(77195);
                    return;
                }
                d(processName, str, SystemClock.elapsedRealtime());
                AppMethodBeat.o(77195);
            } else if (z) {
                intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_lock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", processName);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
                AppMethodBeat.o(77195);
            } else {
                intent = new Intent("com.tencent.mm.ACTION.note_tracemsg_unlock");
                intent.putExtra("pid", myPid);
                intent.putExtra("processName", processName);
                intent.putExtra("traceMsg", str);
                intent.putExtra("tick", SystemClock.elapsedRealtime());
                ah.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
                AppMethodBeat.o(77195);
            }
        }

        private static void c(String str, String str2, long j) {
            AppMethodBeat.i(77196);
            String str3 = str + "_" + str2;
            synchronized (eHR) {
                try {
                    a aVar = (a) eHQ.get(str3);
                    if (aVar == null) {
                        aVar = new a();
                        aVar.eHT = str;
                        aVar.eHM = str2;
                        aVar.eHY = 0;
                        aVar.eHW = 0;
                        aVar.eHX = 0;
                        eHQ.put(str3, aVar);
                    }
                    if (aVar.eIa.getAndIncrement() == 0) {
                        aVar.eHZ = j;
                        aVar.eHU = at.getNetTypeString(ah.getContext());
                        aVar.eHV = com.tencent.mm.sdk.a.b.foreground;
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(77196);
                }
            }
        }

        private static void d(String str, String str2, long j) {
            long j2;
            AppMethodBeat.i(77197);
            String str3 = str + "_" + str2;
            long j3 = 0;
            synchronized (eHR) {
                try {
                    a aVar = (a) eHQ.get(str3);
                    if (aVar != null && aVar.eIa.get() > 0) {
                        aVar.eHW++;
                        if (aVar.eIa.decrementAndGet() == 0) {
                            j3 = j - aVar.eHZ;
                            aVar.eHY += j3;
                            aVar.eHX++;
                        }
                    }
                    j2 = j3;
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(77197);
                    }
                }
            }
            Qn();
            j3 = SystemClock.elapsedRealtime();
            if (j2 >= 14000 || j3 - eHP >= 3600000) {
                ab.d("MicroMsg.WakeLockStatsManager", "saveStatsToStorage triggered.");
                Qo();
                eHP = j3;
            }
            AppMethodBeat.o(77197);
        }

        private static void Qn() {
            AppMethodBeat.i(77198);
            synchronized (eHR) {
                try {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    if (elapsedRealtime - mLastReportTime >= 21600000) {
                        if (!eHQ.isEmpty()) {
                            StringBuilder stringBuilder = new StringBuilder();
                            for (Entry value : eHQ.entrySet()) {
                                a aVar = (a) value.getValue();
                                if (aVar.eHX > 0) {
                                    stringBuilder.setLength(0);
                                    stringBuilder.append(aVar.eHT).append(',').append(aVar.eHM.replace(",", "##")).append(',').append(aVar.eHX).append(',').append(aVar.eHW).append(',').append(aVar.eHY).append(',').append(aVar.eHV ? 1 : 0).append(',').append(aVar.eHU);
                                    String stringBuilder2 = stringBuilder.toString();
                                    om omVar = new om();
                                    omVar.cKO.cKP = stringBuilder2;
                                    com.tencent.mm.sdk.b.a.xxA.m(omVar);
                                    ab.d("MicroMsg.WakeLockStatsManager", "kvstat-str: %s", stringBuilder.toString());
                                }
                            }
                            eHQ.clear();
                        }
                        mLastReportTime = elapsedRealtime;
                    }
                } finally {
                    AppMethodBeat.o(77198);
                }
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0062 A:{SYNTHETIC, Splitter:B:12:0x0062} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x008e A:{SYNTHETIC, Splitter:B:26:0x008e} */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private static void Qo() {
            Throwable e;
            AppMethodBeat.i(77199);
            synchronized (eHR) {
                ObjectOutputStream objectOutputStream = null;
                try {
                    com.tencent.mm.vfs.b bVar = new com.tencent.mm.vfs.b(ah.getContext().getCacheDir(), "wakelock");
                    if (e.tf(j.w(bVar.dMD()))) {
                        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(e.q(new com.tencent.mm.vfs.b(bVar, "wakelock_stats.bin")));
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
                                ab.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
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
                                AppMethodBeat.o(77199);
                                throw e;
                            }
                        } catch (Throwable th2) {
                            e = th2;
                            objectOutputStream = objectOutputStream2;
                            if (objectOutputStream != null) {
                            }
                            AppMethodBeat.o(77199);
                            throw e;
                        }
                        try {
                        } finally {
                            AppMethodBeat.o(77199);
                        }
                    } else {
                        IOException iOException = new IOException("failed to call VFSFileOp.mkdirs(" + j.w(bVar.dMD()) + ")");
                        AppMethodBeat.o(77199);
                        throw iOException;
                    }
                } catch (IOException e5) {
                    e = e5;
                    ab.printErrStackTrace("MicroMsg.WakeLockStatsManager", e, "failed to save stats to storage.", new Object[0]);
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
        AppMethodBeat.i(77206);
        AppMethodBeat.o(77206);
    }

    public static void Qi() {
        AppMethodBeat.i(77202);
        c.Qm();
        AppMethodBeat.o(77202);
    }

    public static void Qj() {
        AppMethodBeat.i(77203);
        c.detach();
        AppMethodBeat.o(77203);
    }

    public static void a(WakerLock wakerLock, String str) {
        AppMethodBeat.i(77204);
        synchronized (eHH) {
            try {
                b bVar = (b) eHG.get(wakerLock.hashCode());
                if (bVar == null) {
                    bVar = new b(wakerLock);
                    eHG.put(wakerLock.hashCode(), bVar);
                }
                if (!bVar.eHL.containsKey(str)) {
                    bVar.eHL.put(str, new a(str, SystemClock.elapsedRealtime()));
                }
                c.lm(str);
                ak akVar = mHandler;
                if (!bVar.eHJ) {
                    bVar.eHJ = true;
                    akVar.postDelayed(bVar.eHK, 60000);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(77204);
            }
        }
    }

    public static void c(WakerLock wakerLock) {
        AppMethodBeat.i(77205);
        synchronized (eHH) {
            try {
                b bVar = (b) eHG.get(wakerLock.hashCode());
                if (bVar != null) {
                    ak akVar = mHandler;
                    if (bVar.eHJ) {
                        bVar.eHJ = false;
                        akVar.removeCallbacks(bVar.eHK);
                    }
                    for (a aVar : bVar.eHL.values()) {
                        c.ln(aVar.eHM);
                    }
                    bVar.eHL.clear();
                }
            } finally {
                AppMethodBeat.o(77205);
            }
        }
    }
}
