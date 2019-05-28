package com.tencent.p177mm.app;

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
import com.tencent.p177mm.compatible.p221e.C1425p;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.p248j.C1760a;
import com.tencent.p177mm.model.C18628c;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac;
import com.tencent.p177mm.storage.C5128ac.C5127a;
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

/* renamed from: com.tencent.mm.app.a */
public final class C32258a {
    private static String bWa = "";
    private static int cdA = 0;
    private static C1425p cdB = new C1425p((long) Process.myPid());
    private static final C8996b cdC = new C322561();
    private static final C32259d cdD = new C322572();
    private static C8996b cdE = cdC;
    private static C32259d cdF = cdD;
    private static Handler cdG;
    private static int cdH = 4500;
    private static int cdI = 500;
    private static String cdJ = "";
    private static boolean cdK = true;
    private static boolean cdL = false;
    private static Thread cdM;
    private static int cdz = 0;

    /* renamed from: com.tencent.mm.app.a$b */
    public interface C8996b {
        /* renamed from: c */
        void mo20431c(C25790a c25790a);
    }

    /* renamed from: com.tencent.mm.app.a$a */
    static class C25790a extends Error {
        LinkedList<Pair<Thread, StackTraceElement[]>> cdN;

        /* renamed from: com.tencent.mm.app.a$a$a */
        static class C25788a implements Serializable {
            final StackTraceElement[] cdP;
            final String name;

            /* renamed from: com.tencent.mm.app.a$a$a$a */
            class C25789a extends Throwable {
                /* synthetic */ C25789a(C25788a c25788a, C25789a c25789a, byte b) {
                    this(c25789a);
                }

                private C25789a(C25789a c25789a) {
                    super(C25788a.this.name, c25789a);
                }

                public final Throwable fillInStackTrace() {
                    AppMethodBeat.m2504i(15351);
                    setStackTrace(C25788a.this.cdP);
                    AppMethodBeat.m2505o(15351);
                    return this;
                }
            }

            /* synthetic */ C25788a(String str, StackTraceElement[] stackTraceElementArr, byte b) {
                this(str, stackTraceElementArr);
            }

            private C25788a(String str, StackTraceElement[] stackTraceElementArr) {
                this.name = str;
                this.cdP = stackTraceElementArr;
            }
        }

        private C25790a(C25789a c25789a, LinkedList<Pair<Thread, StackTraceElement[]>> linkedList) {
            super("Application Not Responding", c25789a);
            this.cdN = linkedList;
        }

        public final Throwable fillInStackTrace() {
            AppMethodBeat.m2504i(15352);
            super.fillInStackTrace();
            AppMethodBeat.m2505o(15352);
            return this;
        }

        /* renamed from: j */
        static C25790a m41003j(String str, boolean z) {
            AppMethodBeat.m2504i(15353);
            final Thread thread = Looper.getMainLooper().getThread();
            LinkedList linkedList = new LinkedList();
            TreeMap treeMap = new TreeMap(new Comparator<Thread>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.m2504i(15350);
                    Thread thread = (Thread) obj;
                    Thread thread2 = (Thread) obj2;
                    if (thread == thread2) {
                        AppMethodBeat.m2505o(15350);
                        return 0;
                    } else if (thread == thread) {
                        AppMethodBeat.m2505o(15350);
                        return 1;
                    } else if (thread2 == thread) {
                        AppMethodBeat.m2505o(15350);
                        return -1;
                    } else {
                        int compareTo = thread2.getName().compareTo(thread.getName());
                        AppMethodBeat.m2505o(15350);
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
                C4990ab.m7417i("MicroMsg.ANRError", "summeranr getAllStackTraces not return mainthread[%s, %d] put in now", thread.getName(), Long.valueOf(thread.getId()));
                treeMap.put(thread, thread.getStackTrace());
                linkedList.addFirst(new Pair(thread, thread.getStackTrace()));
            }
            C25789a c25789a = null;
            for (Entry entry2 : treeMap.entrySet()) {
                C25788a c25788a = new C25788a(C25790a.m41002a((Thread) entry2.getKey()), (StackTraceElement[]) entry2.getValue(), (byte) 0);
                c25788a.getClass();
                c25789a = new C25789a(c25788a, c25789a, (byte) 0);
            }
            C25790a c25790a = new C25790a(c25789a, linkedList);
            AppMethodBeat.m2505o(15353);
            return c25790a;
        }

        /* renamed from: AY */
        static C25790a m41001AY() {
            AppMethodBeat.m2504i(15354);
            Thread thread = Looper.getMainLooper().getThread();
            StackTraceElement[] stackTrace = thread.getStackTrace();
            int length = stackTrace == null ? -1 : stackTrace.length;
            C4990ab.m7417i("MicroMsg.ANRError", "summeranr NewMainOnly mainStackTrace size[%d]", Integer.valueOf(length));
            new TreeMap().put(thread, stackTrace);
            LinkedList linkedList = new LinkedList();
            linkedList.addFirst(new Pair(thread, stackTrace));
            C25788a c25788a = new C25788a(C25790a.m41002a(thread), stackTrace, (byte) 0);
            c25788a.getClass();
            C25790a c25790a = new C25790a(new C25789a(c25788a, null, (byte) 0), linkedList);
            AppMethodBeat.m2505o(15354);
            return c25790a;
        }

        /* renamed from: a */
        private static String m41002a(Thread thread) {
            AppMethodBeat.m2504i(15355);
            String str = thread.getName() + " (prio:" + thread.getPriority() + " tid:" + thread.getId() + " state:" + thread.getState() + ")";
            AppMethodBeat.m2505o(15355);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.app.a$1 */
    static class C322561 implements C8996b {
        C322561() {
        }

        /* renamed from: c */
        public final void mo20431c(C25790a c25790a) {
            AppMethodBeat.m2504i(15348);
            int i = C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getInt("main_thread_watch_report", 0);
            String str = "MicroMsg.ANRWatchDog.summeranr";
            String str2 = "summeranr onAppNotResponding error reportFlag[%b]";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(i > 0);
            C4990ab.m7421w(str, str2, objArr);
            try {
                String b = C32258a.m52648b(c25790a);
                if (i > 0) {
                    if (b != null && b.length() > VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB) {
                        b = b.substring(0, VideoMemoryManager.VIDEO_CACHE_MEM_CACHE_MIN_SIZE_IN_KB);
                    }
                    C4872b.m7233A(Base64.encodeToString(b.getBytes(), 2), "main_thread_watch");
                    AppMethodBeat.m2505o(15348);
                    return;
                }
                C7060h.pYm.mo8378a(510, 14, 1, true);
                AppMethodBeat.m2505o(15348);
            } catch (OutOfMemoryError e) {
                C4990ab.m7413e("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport OutOfMemory %s", e.getMessage());
                System.gc();
                C7060h.pYm.mo8378a(510, 15, 1, true);
                AppMethodBeat.m2505o(15348);
            }
        }
    }

    /* renamed from: com.tencent.mm.app.a$2 */
    static class C322572 implements C32259d {
        C322572() {
        }

        /* renamed from: a */
        public final void mo52969a(InterruptedException interruptedException) {
            AppMethodBeat.m2504i(15349);
            C4990ab.m7421w("MicroMsg.ANRWatchDog.summeranr", "summeranr DEFAULT_INTERRUPTION_LISTENER onInterrupted exception.getMessage[%s]", interruptedException.getMessage());
            AppMethodBeat.m2505o(15349);
        }
    }

    /* renamed from: com.tencent.mm.app.a$d */
    public interface C32259d {
        /* renamed from: a */
        void mo52969a(InterruptedException interruptedException);
    }

    /* renamed from: com.tencent.mm.app.a$c */
    static class C32260c implements Runnable {
        int cdR = 0;
        private final Runnable cdS = new C89971();

        /* renamed from: com.tencent.mm.app.a$c$1 */
        class C89971 implements Runnable {
            C89971() {
            }

            public final void run() {
                AppMethodBeat.m2504i(15356);
                C32260c.this.cdR = (C32260c.this.cdR + 1) % BaseClientBuilder.API_PRIORITY_OTHER;
                if (C32260c.this.cdR % C32258a.cdI == 0) {
                    SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu());
                    int i = sharedPreferences.getInt("main_thread_watch_enable", CdnLogic.kBizGeneric);
                    int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
                    int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
                    int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
                    C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ticker tname[%s], tick[%d] enable[%d], timeout[%d], loop[%d], report[%d]", Thread.currentThread().getName(), Integer.valueOf(C32260c.this.cdR), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
                    if (C32258a.m52653r(C32258a.bWa, i)) {
                        if (i2 > 0 && i2 != C32258a.cdH) {
                            C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset timeout[%d, %d] by new setting", Integer.valueOf(C32258a.cdH), Integer.valueOf(i2));
                            C32258a.cdH = i2;
                        }
                        if (i3 > 0 && i3 != C32258a.cdI) {
                            C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr reset loop[%d, %d] by new setting", Integer.valueOf(C32258a.cdI), Integer.valueOf(i3));
                            C32258a.cdI = i3;
                            AppMethodBeat.m2505o(15356);
                            return;
                        }
                    }
                    C7060h.pYm.mo8378a(510, 12, 1, true);
                    if (C32258a.cdM != null) {
                        C32258a.cdM.interrupt();
                    }
                    C4990ab.m7416i("MicroMsg.ANRWatchDog.summeranr", "summeranr disable by new setting and interrupt watch");
                }
                AppMethodBeat.m2505o(15356);
            }
        }

        C32260c() {
            AppMethodBeat.m2504i(15357);
            AppMethodBeat.m2505o(15357);
        }

        public final void run() {
            AppMethodBeat.m2504i(15358);
            C7060h.pYm.mo8378a(510, 0, 1, true);
            C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread[%s]", Thread.currentThread());
            int i = -1;
            while (!r10.isInterrupted()) {
                int i2 = this.cdR;
                C32258a.cdG.post(this.cdS);
                try {
                    Thread.sleep((long) C32258a.cdH);
                    if (this.cdR == i2) {
                        if (C32258a.cdL || !Debug.isDebuggerConnected()) {
                            C25790a j;
                            C32258a.cdG.removeCallbacks(this.cdS);
                            long LI = (long) C32258a.cdB.mo4873LI();
                            long LJ = (long) C32258a.cdB.mo4874LJ();
                            long LH = (long) C32258a.cdB.mo4872LH();
                            C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr CpuUsage[%d, %d, %d]", Long.valueOf(LI), Long.valueOf(LJ), Long.valueOf(LH));
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr wait for GetCpuUsage interrupted[%b]", Boolean.valueOf(r10.isInterrupted()));
                            }
                            C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread detect anr new sThreadNamePrefix[%s],lastTick tick[%d, %d], current[%d]", C32258a.cdJ, Integer.valueOf(i2), Integer.valueOf(this.cdR), Long.valueOf(System.currentTimeMillis()));
                            if (C32258a.cdJ != null) {
                                j = C25790a.m41003j(C32258a.cdJ, C32258a.cdK);
                            } else {
                                j = C25790a.m41001AY();
                            }
                            C7060h.pYm.mo8378a(510, 1, 1, true);
                            switch (C32258a.cdz) {
                                case 1:
                                    C7060h.pYm.mo8378a(510, 2, 1, true);
                                    break;
                                case 2:
                                    C7060h.pYm.mo8378a(510, 3, 1, true);
                                    break;
                                case 4:
                                    C7060h.pYm.mo8378a(510, 4, 1, true);
                                    break;
                                case 8:
                                    C7060h.pYm.mo8378a(510, 5, 1, true);
                                    break;
                                case 16:
                                    C7060h.pYm.mo8378a(510, 6, 1, true);
                                    break;
                                case 32:
                                    C7060h.pYm.mo8378a(510, 13, 1, true);
                                    break;
                            }
                            if (C32258a.cdA > 0) {
                                C7060h.pYm.mo8378a(510, 7, 1, true);
                            }
                            C32258a.cdE.mo20431c(j);
                            C32258a.m52645AW();
                            if (C32258a.cdA >= 10) {
                                C32258a.cdA = 1;
                            }
                            LI = ((long) ((C32258a.m52651gh(C32258a.cdA) * 5) * 60)) * 1000;
                            this.cdR = 0;
                            C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d]", Integer.valueOf(C32258a.cdA), Long.valueOf(LI), Integer.valueOf(0), Integer.valueOf(this.cdR));
                            try {
                                Thread.sleep(LI);
                                C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread set next detect sFibIndex[%d], sleepTime[%d], lastTick, tick[%d, %d] wakeup", Integer.valueOf(C32258a.cdA), Long.valueOf(LI), Integer.valueOf(0), Integer.valueOf(this.cdR));
                            } catch (InterruptedException e2) {
                                C32258a.cdF.mo52969a(e2);
                                C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted when wait for next detect[%b]", Boolean.valueOf(r10.isInterrupted()));
                                AppMethodBeat.m2505o(15358);
                                return;
                            }
                        }
                        if (this.cdR != i) {
                            C4990ab.m7420w("MicroMsg.ANRWatchDog.summeranr", "summeranr An ANR was detected but ignored because the debugger is connected (you can prevent this with setIgnoreDebugger(true))");
                        }
                        i = this.cdR;
                    }
                } catch (InterruptedException e22) {
                    C32258a.cdF.mo52969a(e22);
                    C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread sleep and interrupted[%b]", Boolean.valueOf(r10.isInterrupted()));
                    AppMethodBeat.m2505o(15358);
                    return;
                }
            }
            C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr ANRWatchDog run thread isInterrupted[%b]", Boolean.valueOf(r10.isInterrupted()));
            AppMethodBeat.m2505o(15358);
        }
    }

    /* renamed from: AW */
    static /* synthetic */ int m52645AW() {
        int i = cdA;
        cdA = i + 1;
        return i;
    }

    /* renamed from: b */
    static /* synthetic */ String m52648b(C25790a c25790a) {
        AppMethodBeat.m2504i(15362);
        String a = C32258a.m52647a(c25790a);
        AppMethodBeat.m2505o(15362);
        return a;
    }

    /* renamed from: gh */
    static /* synthetic */ int m52651gh(int i) {
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

    /* renamed from: r */
    static /* synthetic */ boolean m52653r(String str, int i) {
        AppMethodBeat.m2504i(15363);
        boolean q = C32258a.m52652q(str, i);
        AppMethodBeat.m2505o(15363);
        return q;
    }

    static {
        AppMethodBeat.m2504i(15364);
        AppMethodBeat.m2505o(15364);
    }

    /* renamed from: q */
    private static boolean m52652q(String str, int i) {
        AppMethodBeat.m2504i(15359);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(15359);
            return false;
        } else if (str.equals(C4996ah.getPackageName())) {
            cdz = 1;
            if (C7243d.vxs || (i & 1) != 0) {
                AppMethodBeat.m2505o(15359);
                return true;
            }
            AppMethodBeat.m2505o(15359);
            return false;
        } else if (str.endsWith(":push")) {
            cdz = 2;
            if ((i & 2) != 0) {
                AppMethodBeat.m2505o(15359);
                return true;
            }
            AppMethodBeat.m2505o(15359);
            return false;
        } else if (str.endsWith(":tools") || str.endsWith(":toolsmp")) {
            cdz = 4;
            if ((i & 4) != 0) {
                AppMethodBeat.m2505o(15359);
                return true;
            }
            AppMethodBeat.m2505o(15359);
            return false;
        } else if (str.endsWith(":sandbox")) {
            cdz = 8;
            if ((i & 8) != 0) {
                AppMethodBeat.m2505o(15359);
                return true;
            }
            AppMethodBeat.m2505o(15359);
            return false;
        } else if (str.endsWith(":exdevice")) {
            cdz = 16;
            if ((i & 16) != 0) {
                AppMethodBeat.m2505o(15359);
                return true;
            }
            AppMethodBeat.m2505o(15359);
            return false;
        } else if (str.contains(":appbrand")) {
            cdz = 32;
            if ((i & 32) != 0) {
                AppMethodBeat.m2505o(15359);
                return true;
            }
            AppMethodBeat.m2505o(15359);
            return false;
        } else {
            AppMethodBeat.m2505o(15359);
            return false;
        }
    }

    /* renamed from: cP */
    public static void m52649cP(String str) {
        AppMethodBeat.m2504i(15360);
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu());
        int i = sharedPreferences.getInt("main_thread_watch_enable", CdnLogic.kBizGeneric);
        int i2 = sharedPreferences.getInt("main_thread_watch_timeout", 0);
        int i3 = sharedPreferences.getInt("main_thread_watch_log_loop", 0);
        int i4 = sharedPreferences.getInt("main_thread_watch_report", 0);
        if (C32258a.m52652q(str, i)) {
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
            cdM = C7305d.m12301h(new C32260c(), str + "_ANRWatchDog");
            if (cdG == null) {
                cdG = new Handler(Looper.getMainLooper());
            }
            cdM.start();
            C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch sProcessName[%s], sTimeoutInterval[%d], logLoop[%d], sWatchThread[%s], stack[%s]", bWa, Integer.valueOf(cdH), Integer.valueOf(cdI), cdM.getName(), C5046bo.dpG());
        }
        C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr startWatch processName[%s] enable[%d], timeout[%d], loop[%d], report[%d]", str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4));
        AppMethodBeat.m2505o(15360);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0101 A:{Splitter:B:26:0x015a, ExcHandler: JSONException (r0_57 'e' org.json.JSONException)} */
    /* JADX WARNING: Missing block: B:19:0x0101, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:20:0x0102, code skipped:
            com.tencent.p177mm.sdk.platformtools.C4990ab.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", r0, "summeranr buildReport JSONException:", new java.lang.Object[0]);
            com.tencent.p177mm.plugin.report.service.C7060h.pYm.mo8378a(510, 10, 1, true);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static String m52647a(C25790a c25790a) {
        String str;
        AppMethodBeat.m2504i(15361);
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
            LinkedList linkedList = c25790a.cdN;
            if (!C5046bo.m7548ek(linkedList)) {
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
                C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport CpuUsage [%d, %d, %d]", Integer.valueOf(cdB.mo4873LI()), Integer.valueOf(cdB.mo4874LJ()), Integer.valueOf(cdB.mo4872LH()));
                jSONObject4.put("cpu_usage_total", r0);
                jSONObject4.put("cpu_usage_pid", i);
                jSONObject4.put("cpu_count", r2);
                ActivityManager activityManager = (ActivityManager) C4996ah.getContext().getSystemService("activity");
                MemoryInfo memoryInfo = new MemoryInfo();
                activityManager.getMemoryInfo(memoryInfo);
                long j = 0;
                if (C1443d.m3068iW(16)) {
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
                        long j2 = C5046bo.getLong(stringBuffer.toString(), -1);
                        if (j2 > 0) {
                            j = j2 << 10;
                        }
                        randomAccessFile.close();
                    } catch (Exception e) {
                        C4990ab.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e, "summeranr", new Object[0]);
                        randomAccessFile.close();
                    } catch (Throwable th) {
                        randomAccessFile.close();
                        AppMethodBeat.m2505o(15361);
                    }
                }
                C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr buildReport MemoryInfo[%d, %d, %d, %b]", Long.valueOf(j), Long.valueOf(memoryInfo.availMem), Long.valueOf(memoryInfo.threshold), Boolean.valueOf(memoryInfo.lowMemory));
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
                if (cdz == 1 && C9638aw.m17179RK() && C1720g.m3534RN().eJb) {
                    String str3;
                    C5127a[] c5127aArr = new C5127a[]{C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_SIZE_LONG, C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_SD_FILE_RATIO_LONG, C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_SIZE_LONG, C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_MESSAGE_LONG, C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONVERSATION_LONG, C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CONTACT_LONG, C5127a.USERINFO_HEAVY_USER_REPORT_TYPE_DB_CHATROOM_LONG};
                    str = "";
                    i = 0;
                    while (true) {
                        str3 = str;
                        if (i >= 7) {
                            break;
                        }
                        C5127a c5127a = c5127aArr[i];
                        StringBuilder append = new StringBuilder().append(str3);
                        C9638aw.m17190ZK();
                        str = append.append(C18628c.m29072Ry().get(c5127a, Long.valueOf(0))).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).toString();
                        i++;
                    }
                    C4990ab.m7417i("MicroMsg.ANRWatchDog.summeranr", "summeranr sProcessName[%s] storage_usage[%s]", bWa, str3);
                    jSONObject4.put("storage_usage", str3);
                }
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e2, "summeranr buildReport storage_usage:", new Object[0]);
                C7060h.pYm.mo8378a(510, 9, 1, true);
            } catch (JSONException e3) {
            }
            jSONObject4.put("time", Integer.valueOf(cdH));
            int i2 = 0;
            if (new File(C5128ac.eSj).exists()) {
                i2 = C4996ah.getContext().getSharedPreferences("system_config_prefs", C1448h.m3078Mu()).getInt("default_uin", 0);
            }
            jSONObject3.put(OpenSDKTool4Assistant.EXTRA_UIN, new Long((long) i2));
            jSONObject3.put("process_name", bWa);
            jSONObject3.put("time", new Long(System.currentTimeMillis()));
            jSONObject3.put("cver", Integer.valueOf(C7243d.vxo));
            jSONObject3.put("revision", C1760a.m3621Uk());
            C7060h.pYm.mo8378a(510, 8, 1, true);
        } catch (JSONException e32) {
        } catch (Exception e22) {
            C4990ab.printErrStackTrace("MicroMsg.ANRWatchDog.summeranr", e22, "summeranr buildReport Exception:", new Object[0]);
            C7060h.pYm.mo8378a(510, 11, 1, true);
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
        C4990ab.m7417i(str4, str5, objArr);
        AppMethodBeat.m2505o(15361);
        return jSONObject6;
    }
}
