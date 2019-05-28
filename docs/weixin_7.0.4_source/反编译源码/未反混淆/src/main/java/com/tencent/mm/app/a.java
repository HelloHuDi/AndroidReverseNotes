package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Base64;
import android.util.Pair;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.ttpic.cache.VideoMemoryManager;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static String bWa = "";
    private static int cdA = 0;
    private static p cdB = new p((long) Process.myPid());
    private static final b cdC = new b() {
        public final void c(a aVar) {
            AppMethodBeat.i(15348);
            int i = ah.getContext().getSharedPreferences("system_config_prefs", h.Mu()).getInt("main_thread_watch_report", 0);
            String str = "MicroMsg.ANRWatchDog.summeranr";
            String str2 = "summeranr onAppNotResponding error reportFlag[%b]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i > 0);
            ab.w(str, str2, objArr);
            try {
                String b = a.b(aVar);
                if (i > 0) {
                    if (b != null && b.length() > VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB) {
                        b = b.substring(0, VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
                    }
                    com.tencent.mm.sdk.a.b.A(Base64.encodeToString(b.getBytes(), 2), "main_thread_watch");
                    AppMethodBeat.o(15348);
                    return;
                }
                com.tencent.mm.plugin.report.service.h.pYm.a(510, 14, 1, true);
                AppMethodBeat.o(15348);
            } catch (OutOfMemoryError e) {
                ab.e("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport OutOfMemory %s", e.getMessage());
                System.gc();
                com.tencent.mm.plugin.report.service.h.pYm.a(510, 15, 1, true);
                AppMethodBeat.o(15348);
            }
        }
    };
    private static final d cdD = new d() {
        public final void a(InterruptedException interruptedException) {
            AppMethodBeat.i(15349);
            ab.w("MicroMsg.ANRWatchDog.summeranr", "summeranr DEFAULT_INTERRUPTION_LISTENER onInterrupted exception.getMessage[%s]", interruptedException.getMessage());
            AppMethodBeat.o(15349);
        }
    };
    private static b cdE = cdC;
    private static d cdF = cdD;
    private static Handler cdG;
    private static int cdH = 4500;
    private static int cdI = 500;
    private static String cdJ = "";
    private static boolean cdK = true;
    private static boolean cdL = false;
    private static Thread cdM;
    private static int cdz = 0;

    public interface b {
        void c(a aVar);
    }

    static class a extends Error {
        LinkedList<Pair<Thread, StackTraceElement[]>> cdN;

        static class a implements Serializable {
            final StackTraceElement[] cdP;
            final String name;

            class a extends Throwable {
                /* synthetic */ a(a aVar, a aVar2, byte b) {
                    this(aVar2);
                }

                private a(a aVar) {
                    super(a.this.name, aVar);
                }

                public final Throwable fillInStackTrace() {
                    AppMethodBeat.i(15351);
                    setStackTrace(a.this.cdP);
                    AppMethodBeat.o(15351);
                    return this;
                }
            }

            /* synthetic */ a(String str, StackTraceElement[] stackTraceElementArr, byte b) {
                this(str, stackTraceElementArr);
            }

            private a(String str, StackTraceElement[] stackTraceElementArr) {
                this.name = str;
                this.cdP = stackTraceElementArr;
            }
        }

        private a(a aVar, LinkedList<Pair<Thread, StackTraceElement[]>> linkedList) {
            super("Application Not Responding", aVar);
            this.cdN = linkedList;
        }

        public final Throwable fillInStackTrace() {
            AppMethodBeat.i(15352);
            super.fillInStackTrace();
            AppMethodBeat.o(15352);
            return this;
        }

        static a j(String str, boolean z) {
            AppMethodBeat.i(15353);
            final Thread thread = Looper.getMainLooper().getThread();
            LinkedList linkedList = new LinkedList();
            TreeMap treeMap = new TreeMap(new Comparator<Thread>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(15350);
                    Thread thread = (Thread) obj;
                    Thread thread2 = (Thread) obj2;
                    if (thread == thread2) {
                        AppMethodBeat.o(15350);
                        return 0;
                    } else if (thread == thread) {
                        AppMethodBeat.o(15350);
                        return 1;
                    } else if (thread2 == thread) {
                        AppMethodBeat.o(15350);
                        return -1;
                    } else {
                        int compareTo = thread2.getName().compareTo(thread.getName());
                        AppMethodBeat.o(15350);
                        return compareTo;
                    }
                }
            });
            for (Entry entry : Thread.getAllStackTraces().entrySet()) {
                if ((entry.getKey() == thread || (((Thread) entry.getKey()).getName().startsWith(str) && (z || ((StackTraceElement[]) entry.getValue()).length > 0))) && entry.getValue() != null && ((StackTraceElement[]) entry.getValue()).length > 0) {
                    treeMap.put(entry.getKey(), entry.getValue());
                    if (entry.getKey() == thread) {
                        linkedList.addFirst(new Pair(thread, entry.getValue()));
                    } else {
                        linkedList.addLast(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            if (!treeMap.containsKey(thread)) {
                ab.i("MicroMsg.ANRError", "summeranr getAllStackTraces not return mainthread[%s, %d] put in now", thread.getName(), Long.valueOf(thread.getId()));
                treeMap.put(thread, thread.getStackTrace());
                linkedList.addFirst(new Pair(thread, thread.getStackTrace()));
            }
            a aVar = null;
            for (Entry entry2 : treeMap.entrySet()) {
                a aVar2 = new a(a((Thread) entry2.getKey()), (StackTraceElement[]) entry2.getValue(), (byte) 0);
                aVar2.getClass();
                aVar = new a(aVar2, aVar, (byte) 0);
            }
            a aVar3 = new a(aVar, linkedList);
            AppMethodBeat.o(15353);
            return aVar3;
        }

        static a AY() {
            AppMethodBeat.i(15354);
            Thread thread = Looper.getMainLooper().getThread();
            StackTraceElement[] stackTrace = thread.getStackTrace();
            int length = stackTrace == null ? -1 : stackTrace.length;
            ab.i("MicroMsg.ANRError", "summeranr NewMainOnly mainStackTrace size[%d]", Integer.valueOf(length));
            new TreeMap().put(thread, stackTrace);
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(new Pair(thread, stackTrace));
            a aVar = new a(a(thread), stackTrace, (byte) 0);
            aVar.getClass();
            a aVar2 = new a(new a(aVar, null, (byte) 0), linkedList);
            AppMethodBeat.o(15354);
            return aVar2;
        }

        private static String a(Thread thread) {
            AppMethodBeat.i(15355);
            String str = thread.getName() + " (prio:" + thread.getPriority() + " tid:" + thread.getId() + " state:" + thread.getState() + ")";
            AppMethodBeat.o(15355);
            return str;
        }
    }

    public interface d {
        void a(InterruptedException interruptedException);
    }

    static class c implements Runnable {
        int cdR = 0;
        private final Runnable cdS = new Runnable() {
            public final void run() {
                AppMethodBeat.i(15356);
                c.this.cdR = (c.this.cdR + 1) % BaseClientBuilder.API_PRIORITY_OTHER;
                if (c.this.cdR % a.cdI == 0) {
                    SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("system_config_prefs", h.Mu());
                    int i = sharedPreferences.getInt("main_thread_watch_enable", CdnLogic.kBizGeneric);
                    int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
                    int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
                    int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
                    ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ticker tname[%s], tick[%d] enable[%d], timeout[%d], loop[%d], report[%d]", Thread.currentThread().getName(), Integer.valueOf(c.this.cdR), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                    if (a.r(a.bWa, i)) {
                        if (i2 > 0 && i2 != a.cdH) {
                            ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset timeout[%d, %d] by new setting", Integer.valueOf(a.cdH), Integer.valueOf(i2));
                            a.cdH = i2;
                        }
                        if (i3 > 0 && i3 != a.cdI) {
                            ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset loop[%d, %d] by new setting", Integer.valueOf(a.cdI), Integer.valueOf(i3));
                            a.cdI = i3;
                            AppMethodBeat.o(15356);
                            return;
                        }
                    }
                    com.tencent.mm.plugin.report.service.h.pYm.a(510, 12, 1, true);
                    if (a.cdM != null) {
                        a.cdM.interrupt();
                    }
                    ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr disable by new setting and interrupt watch");
                }
                AppMethodBeat.o(15356);
            }
        };

        c() {
            AppMethodBeat.i(15357);
            AppMethodBeat.o(15357);
        }

        public final void run() {
            AppMethodBeat.i(15358);
            com.tencent.mm.plugin.report.service.h.pYm.a(510, 0, 1, true);
            ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread[%s]", Thread.currentThread());
            int i = -1;
            while (!r10.isInterrupted()) {
                int i2 = this.cdR;
                a.cdG.post(this.cdS);
                try {
                    Thread.sleep((long) a.cdH);
                    if (this.cdR == i2) {
                        if (a.cdL || !Debug.isDebuggerConnected()) {
                            a j;
                            a.cdG.removeCallbacks(this.cdS);
                            long LI = (long) a.cdB.LI();
                            long LJ = (long) a.cdB.LJ();
                            long LH = (long) a.cdB.LH();
                            ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr CpuUsage[%d, %d, %d]", Long.valueOf(LI), Long.valueOf(LJ), Long.valueOf(LH));
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr wait for GetCpuUsage interrupted[%b]", Boolean.valueOf(r10.isInterrupted()));
                            }
                            ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr new sThreadNamePrefix[%s],lastTick tick[%d, %d], current[%d]", a.cdJ, Integer.valueOf(i2), Integer.valueOf(this.cdR), Long.valueOf(System.currentTimeMillis()));
                            if (a.cdJ != null) {
                                j = a.j(a.cdJ, a.cdK);
                            } else {
                                j = a.AY();
                            }
                            com.tencent.mm.plugin.report.service.h.pYm.a(510, 1, 1, true);
                            switch (a.cdz) {
                                case 1:
                                    com.tencent.mm.plugin.report.service.h.pYm.a(510, 2, 1, true);
                                    break;
                                case 2:
                                    com.tencent.mm.plugin.report.service.h.pYm.a(510, 3, 1, true);
                                    break;
                                case 4:
                                    com.tencent.mm.plugin.report.service.h.pYm.a(510, 4, 1, true);
                                    break;
                                case 8:
                                    com.tencent.mm.plugin.report.service.h.pYm.a(510, 5, 1, true);
                                    break;
                                case 16:
                                    com.tencent.mm.plugin.report.service.h.pYm.a(510, 6, 1, true);
                                    break;
                                case 32:
                                    com.tencent.mm.plugin.report.service.h.pYm.a(510, 13, 1, true);
                                    break;
                            }
                            if (a.cdA > 0) {
                                com.tencent.mm.plugin.report.service.h.pYm.a(510, 7, 1, true);
                            }
                            a.cdE.c(j);
                            a.AW();
                            if (a.cdA >= 10) {
                                a.cdA = 1;
                            }
                            LI = ((long) ((a.gh(a.cdA) * 5) * 60)) * 1000;
                            this.cdR = 0;
                            ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d]", Integer.valueOf(a.cdA), Long.valueOf(LI), Integer.valueOf(0), Integer.valueOf(this.cdR));
                            try {
                                Thread.sleep(LI);
                                ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d] wakeup", Integer.valueOf(a.cdA), Long.valueOf(LI), Integer.valueOf(0), Integer.valueOf(this.cdR));
                            } catch (InterruptedException e2) {
                                a.cdF.a(e2);
                                ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted when wait for next detect[%b]", Boolean.valueOf(r10.isInterrupted()));
                                AppMethodBeat.o(15358);
                                return;
                            }
                        }
                        if (this.cdR != i) {
                            ab.w("MicroMsg.ANRWatchDog.summeranr", "summeranr An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        }
                        i = this.cdR;
                    }
                } catch (InterruptedException e22) {
                    a.cdF.a(e22);
                    ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted[%b]", Boolean.valueOf(r10.isInterrupted()));
                    AppMethodBeat.o(15358);
                    return;
                }
            }
            ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread isInterrupted[%b]", Boolean.valueOf(r10.isInterrupted()));
            AppMethodBeat.o(15358);
        }
    }

    static /* synthetic */ int AW() {
        int i = cdA;
        cdA = i + 1;
        return i;
    }

    static /* synthetic */ String b(a aVar) {
        AppMethodBeat.i(15362);
        String a = a(aVar);
        AppMethodBeat.o(15362);
        return a;
    }

    static /* synthetic */ int gh(int i) {
        int i2 = 0;
        if (i < 0) {
            return -1;
        }
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return 1;
        }
        int i3 = 3;
        int i4 = 1;
        int i5 = 1;
        while (i3 <= i) {
            int i6 = i5 + i4;
            i3++;
            i5 = i4;
            i2 = i6;
            i4 = i6;
        }
        return i2;
    }

    static /* synthetic */ boolean r(String str, int i) {
        AppMethodBeat.i(15363);
        boolean q = q(str, i);
        AppMethodBeat.o(15363);
        return q;
    }

    static {
        AppMethodBeat.i(15364);
        AppMethodBeat.o(15364);
    }

    private static boolean q(String str, int i) {
        AppMethodBeat.i(15359);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(15359);
            return false;
        } else if (str.equals(ah.getPackageName())) {
            cdz = 1;
            if (com.tencent.mm.protocal.d.vxs || (i & 1) != 0) {
                AppMethodBeat.o(15359);
                return true;
            }
            AppMethodBeat.o(15359);
            return false;
        } else if (str.endsWith(":push")) {
            cdz = 2;
            if ((i & 2) != 0) {
                AppMethodBeat.o(15359);
                return true;
            }
            AppMethodBeat.o(15359);
            return false;
        } else if (str.endsWith(":tools") || str.endsWith(":toolsmp")) {
            cdz = 4;
            if ((i & 4) != 0) {
                AppMethodBeat.o(15359);
                return true;
            }
            AppMethodBeat.o(15359);
            return false;
        } else if (str.endsWith(":sandbox")) {
            cdz = 8;
            if ((i & 8) != 0) {
                AppMethodBeat.o(15359);
                return true;
            }
            AppMethodBeat.o(15359);
            return false;
        } else if (str.endsWith(":exdevice")) {
            cdz = 16;
            if ((i & 16) != 0) {
                AppMethodBeat.o(15359);
                return true;
            }
            AppMethodBeat.o(15359);
            return false;
        } else if (str.contains(":appbrand")) {
            cdz = 32;
            if ((i & 32) != 0) {
                AppMethodBeat.o(15359);
                return true;
            }
            AppMethodBeat.o(15359);
            return false;
        } else {
            AppMethodBeat.o(15359);
            return false;
        }
    }

    public static void cP(String str) {
        AppMethodBeat.i(15360);
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("system_config_prefs", h.Mu());
        int i = sharedPreferences.getInt("main_thread_watch_enable", CdnLogic.kBizGeneric);
        int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
        int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
        int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
        if (q(str, i)) {
            if (i2 <= 0) {
                i2 = 4500;
            }
            if (i3 <= 0) {
                i3 = 500;
            }
            if (cdM != null) {
                cdM.interrupt();
            }
            bWa = str;
            if (i2 > 0) {
                cdH = i2;
            }
            if (i3 > 0) {
                cdI = i3;
            }
            cdM = com.tencent.mm.sdk.g.d.h(new c(), str + "_ANRWatchDog");
            if (cdG == null) {
                cdG = new Handler(Looper.getMainLooper());
            }
            cdM.start();
            ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch sProcessName[%s], sTimeoutInterval[%d], logLoop[%d], sWatchThread[%s], stack[%s]", bWa, Integer.valueOf(cdH), Integer.valueOf(cdI), cdM.getName(), bo.dpG());
        }
        ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch processName[%s] enable[%d], timeout[%d], loop[%d], report[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.o(15360);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0101 A:{Splitter:B:26:0x015a, ExcHandler: JSONException (r0_57 'e' org.json.JSONException)} */
    /* JADX WARNING: Missing block: B:19:0x0101, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x0102, code skipped:
            com.tencent.mm.sdk.platformtools.ab.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", r0, "summeranr buildReport JSONException:", new java.lang.Object[0]);
            com.tencent.mm.plugin.report.service.h.pYm.a(510, 10, 1, true);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String a(a aVar) {
        String str;
        AppMethodBeat.i(15361);
        JSONObject jSONObject = new JSONObject();
        try {
            int i;
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("head", jSONObject2);
            jSONObject2.put("protocol_ver", Integer.valueOf(1));
            jSONObject2.put("phone", new String(Build.MODEL));
            jSONObject2.put("os_ver", new String("android-" + VERSION.SDK_INT));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject.put("items", jSONObject3);
            jSONObject3.put("tag", "main_thread_watch");
            JSONArray jSONArray = new JSONArray();
            JSONObject jSONObject4 = new JSONObject();
            jSONArray.put(jSONObject4);
            jSONObject3.put("info", jSONArray);
            JSONObject jSONObject5 = new JSONObject();
            jSONObject4.put("traces", jSONObject5);
            LinkedList linkedList = aVar.cdN;
            if (!bo.ek(linkedList)) {
                Iterator it = linkedList.iterator();
                while (it.hasNext()) {
                    Pair pair = (Pair) it.next();
                    Thread thread = (Thread) pair.first;
                    StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) pair.second;
                    if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
                        String str2 = thread.getName() + " (prio:" + thread.getPriority() + " tid:" + thread.getId() + " state:" + thread.getState() + ")";
                        JSONArray jSONArray2 = new JSONArray();
                        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
                            if (stackTraceElement != null) {
                                jSONArray2.put(stackTraceElement.toString());
                            }
                        }
                        jSONObject5.put(str2, jSONArray2);
                    }
                }
            }
            try {
                ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport CpuUsage [%d, %d, %d]", Integer.valueOf(cdB.LI()), Integer.valueOf(cdB.LJ()), Integer.valueOf(cdB.LH()));
                jSONObject4.put("cpu_usage_total", r0);
                jSONObject4.put("cpu_usage_pid", i);
                jSONObject4.put("cpu_count", r2);
                ActivityManager activityManager = (ActivityManager) ah.getContext().getSystemService("activity");
                MemoryInfo memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j = 0;
                if (com.tencent.mm.compatible.util.d.iW(16)) {
                    j = memoryInfo.totalMem;
                } else {
                    RandomAccessFile randomAccessFile = new RandomAccessFile("/proc/meminfo", "r");
                    try {
                        StringBuffer stringBuffer = new StringBuffer();
                        char[] toCharArray = randomAccessFile.readLine().toCharArray();
                        int length = toCharArray.length;
                        i = 0;
                        while (i < length) {
                            if (toCharArray[i] <= '9' && toCharArray[i] >= '0') {
                                stringBuffer.append(toCharArray[i]);
                            }
                            i++;
                        }
                        long j2 = bo.getLong(stringBuffer.toString(), -1);
                        if (j2 > 0) {
                            j = j2 << 10;
                        }
                        randomAccessFile.close();
                    } catch (Exception e) {
                        ab.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e, "summeranr", new Object[0]);
                        randomAccessFile.close();
                    } catch (Throwable th) {
                        randomAccessFile.close();
                        AppMethodBeat.o(15361);
                    }
                }
                ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport MemoryInfo[%d, %d, %d, %b]", Long.valueOf(j), Long.valueOf(memoryInfo.availMem), Long.valueOf(memoryInfo.threshold), Boolean.valueOf(memoryInfo.lowMemory));
                jSONObject4.put("mem_sys_total", j);
                jSONObject4.put("mem_sys_avail", memoryInfo.availMem);
                jSONObject4.put("mem_sys_threshold", memoryInfo.threshold);
                jSONObject4.put("mem_sys_low", memoryInfo.lowMemory);
                jSONObject4.put("mem_native_heap_size", Debug.getNativeHeapSize());
                jSONObject4.put("mem_native_heap_alloc_size", Debug.getNativeHeapAllocatedSize());
                jSONObject4.put("mem_native_heap_free_size", Debug.getNativeHeapFreeSize());
                Debug.MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
                if (!(processMemoryInfo == null || processMemoryInfo.length <= 0 || processMemoryInfo[0] == null)) {
                    Debug.MemoryInfo memoryInfo2 = processMemoryInfo[0];
                    jSONObject4.put("mem_private_dirty", memoryInfo2.getTotalPrivateDirty() << 10);
                    jSONObject4.put("mem_shared_dirty", memoryInfo2.getTotalSharedDirty() << 10);
                    jSONObject4.put("mem_pss", memoryInfo2.getTotalPss() << 10);
                }
                if (cdz == 1 && aw.RK() && g.RN().eJb) {
                    String str3;
                    com.tencent.mm.storage.ac.a[] aVarArr = new com.tencent.mm.storage.ac.a[]{com.tencent.mm.storage.ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG, com.tencent.mm.storage.ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG, com.tencent.mm.storage.ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG, com.tencent.mm.storage.ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG, com.tencent.mm.storage.ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG, com.tencent.mm.storage.ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG, com.tencent.mm.storage.ac.a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG};
                    str = "";
                    i = 0;
                    while (true) {
                        str3 = str;
                        if (i >= 7) {
                            break;
                        }
                        com.tencent.mm.storage.ac.a aVar2 = aVarArr[i];
                        StringBuilder append = new StringBuilder().append(str3);
                        aw.ZK();
                        str = append.append(com.tencent.mm.model.c.Ry().get(aVar2, Long.valueOf(0))).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).toString();
                        i++;
                    }
                    ab.i("MicroMsg.ANRWatchDog.summeranr", "summeranr sProcessName[%s] storage_usage[%s]", bWa, str3);
                    jSONObject4.put("storage_usage", str3);
                }
            } catch (Exception e2) {
                ab.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e2, "summeranr buildReport storage_usage:", new Object[0]);
                com.tencent.mm.plugin.report.service.h.pYm.a(510, 9, 1, true);
            } catch (JSONException e3) {
            }
            jSONObject4.put("time", Integer.valueOf(cdH));
            int i2 = 0;
            if (new File(ac.eSj).exists()) {
                i2 = ah.getContext().getSharedPreferences("system_config_prefs", h.Mu()).getInt("default_uin", 0);
            }
            jSONObject3.put(OpenSDKTool4Assistant.EXTRA_UIN, new Long((long) i2));
            jSONObject3.put("process_name", bWa);
            jSONObject3.put("time", new Long(System.currentTimeMillis()));
            jSONObject3.put("cver", Integer.valueOf(com.tencent.mm.protocal.d.vxo));
            jSONObject3.put("revision", com.tencent.mm.loader.j.a.Uk());
            com.tencent.mm.plugin.report.service.h.pYm.a(510, 8, 1, true);
        } catch (JSONException e32) {
        } catch (Exception e22) {
            ab.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e22, "summeranr buildReport Exception:", new Object[0]);
            com.tencent.mm.plugin.report.service.h.pYm.a(510, 11, 1, true);
        }
        String jSONObject6 = jSONObject.toString();
        String str4 = "MicroMsg.ANRWatchDog.summeranr";
        String str5 = "summeranr buildReport packer len[%d][%d][%s]";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(jSONObject.length());
        objArr[1] = Integer.valueOf(jSONObject6.length());
        if (jSONObject6.length() > VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB) {
            str = jSONObject6.substring(0, VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
        } else {
            str = jSONObject6;
        }
        objArr[2] = str;
        ab.i(str4, str5, objArr);
        AppMethodBeat.o(15361);
        return jSONObject6;
    }
}
