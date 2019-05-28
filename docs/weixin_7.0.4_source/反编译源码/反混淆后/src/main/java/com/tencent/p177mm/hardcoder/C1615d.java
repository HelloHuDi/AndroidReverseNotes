package com.tencent.p177mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1623g.C1622a;
import com.tencent.p177mm.hardcoder.C6588h.C1624a;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: com.tencent.mm.hardcoder.d */
public final class C1615d implements Runnable {
    private C6588h eEa;
    private Set<Integer> eEh;
    private C1621f eEi;
    private long eEj;
    private long eEk;

    /* renamed from: com.tencent.mm.hardcoder.d$a */
    public static class C1612a {
        public final int eEp;
        public final long eEq;
        public final int eEr;
        public final long startTime;

        public C1612a(long j, int i, long j2, int i2) {
            this.startTime = j;
            this.eEp = i;
            this.eEq = j2;
            this.eEr = i2;
        }

        public final String toString() {
            AppMethodBeat.m2504i(93924);
            String format = String.format("Cpu status,startTime:%s,coreId:%s,freq:%s,power:%s", new Object[]{Long.valueOf(this.startTime), Integer.valueOf(this.eEp), Long.valueOf(this.eEq), Integer.valueOf(this.eEr)});
            AppMethodBeat.m2505o(93924);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.hardcoder.d$b */
    public static class C1613b {
        public final Map<Integer, C1612a> eEs;
        public final Map<Integer, C1614c> eEt;
        public final long time;

        public C1613b(long j, Map<Integer, C1612a> map, Map<Integer, C1614c> map2) {
            this.time = j;
            this.eEs = map;
            this.eEt = map2;
        }
    }

    /* renamed from: com.tencent.mm.hardcoder.d$c */
    public static class C1614c {
        public final long[] eDS;
        public long eDU = 0;
        public final int eEu;
        public final int eEv;
        public final long eEw;
        public long eEx = 0;
        public final long startTime;

        public C1614c(int i, long j, int i2, long j2, long[] jArr) {
            AppMethodBeat.m2504i(93925);
            this.eEu = i;
            this.startTime = j;
            this.eEv = i2;
            this.eEw = j2;
            this.eDS = jArr;
            this.eDU = this.eEw;
            AppMethodBeat.m2505o(93925);
        }

        /* renamed from: a */
        public final void mo5068a(long j, long[] jArr) {
            AppMethodBeat.m2504i(93926);
            this.eDU = (this.eDU + j) / 2;
            if (jArr != null) {
                this.eEx = (jArr[0] - this.eDS[0]) + (jArr[1] - this.eDS[1]);
                C1611c.m3269d("HardCoder.HardCoderMonitor", "thread id:" + this.eEu + ",start jiffies:[" + this.eDS[0] + "," + this.eDS[1] + "], end jiffies:[" + jArr[0] + "," + jArr[1] + "]");
            }
            AppMethodBeat.m2505o(93926);
        }

        public final String toString() {
            AppMethodBeat.m2504i(93927);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("Thread status,threadId:%s,startTime:%s,startCoreId:%s,startCoreFreq:%s", new Object[]{Integer.valueOf(this.eEu), Long.valueOf(this.startTime), Integer.valueOf(this.eEv), Long.valueOf(this.eEw)}));
            stringBuilder.append(String.format(",sumJiffies:%s", new Object[]{Long.valueOf(this.eEx)}));
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(93927);
            return stringBuilder2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f3 A:{Splitter:B:3:0x0012, ExcHandler: InterruptedException (r0_48 'e' java.lang.InterruptedException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:26:0x00f3, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:27:0x00f4, code skipped:
            com.tencent.p177mm.hardcoder.C1611c.m3270e("HardCoder.HardCoderMonitor", "Monitor thread need to interrupt:" + r0.getMessage());
            java.lang.Thread.currentThread().interrupt();
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(93928);
     */
    /* JADX WARNING: Missing block: B:39:0x0166, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:40:0x0167, code skipped:
            com.tencent.p177mm.hardcoder.C1611c.printErrStackTrace("HardCoder.HardCoderMonitor", r0, "exception:", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:56:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(93928);
     */
    /* JADX WARNING: Missing block: B:67:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(93928);
     */
    /* JADX WARNING: Missing block: B:86:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(93928);
     */
    /* JADX WARNING: Missing block: B:101:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(93928);
     */
    /* JADX WARNING: Missing block: B:124:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        AppMethodBeat.m2504i(93928);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis < this.eEj || currentTimeMillis > this.eEk) {
                    synchronized (this) {
                        wait(60000);
                        C1611c.m3271i("HardCoder.HardCoderMonitor", "Monitor thread wait(no in time):60000");
                    }
                } else {
                    int i;
                    int intValue;
                    C1611c.m3269d("HardCoder.HardCoderMonitor", "get cpu current freq,begin:" + SystemClock.elapsedRealtime());
                    Map a = C1615d.m3273a(currentTimeMillis, this.eEa);
                    C1611c.m3269d("HardCoder.HardCoderMonitor", "get cpu current freq,end:" + SystemClock.elapsedRealtime());
                    HashSet hashSet = new HashSet();
                    File file = new File("/proc/" + Process.myPid() + "/task");
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length == 0) {
                            i = 1;
                        } else {
                            C1611c.m3269d("HardCoder.HardCoderMonitor", "thread size:" + listFiles.length);
                            for (File file2 : listFiles) {
                                hashSet.add(Integer.valueOf(Integer.parseInt(file2.getName(), 0)));
                            }
                            i = 0;
                        }
                    } else {
                        C1611c.m3270e("HardCoder.HardCoderMonitor", "impossible as usual");
                        i = 1;
                    }
                    TreeMap treeMap = new TreeMap();
                    this.eEh.addAll(hashSet);
                    C1611c.m3269d("HardCoder.HardCoderMonitor", "get thread current stat,end:" + SystemClock.elapsedRealtime());
                    if (i != 0) {
                        synchronized (this) {
                            wait(60000);
                            C1611c.m3271i("HardCoder.HardCoderMonitor", "Monitor thread wait(pid/task error):60000");
                        }
                    } else if (this.eEh.isEmpty()) {
                        synchronized (this) {
                            while (this.eEh.isEmpty()) {
                                wait();
                            }
                        }
                    } else {
                        for (Integer intValue2 : this.eEh) {
                            intValue = intValue2.intValue();
                            long[] jr = C1623g.m3286jr(intValue);
                            int js = C1623g.m3287js(intValue);
                            long jt = C1623g.m3288jt(js);
                            if (treeMap.containsKey(Integer.valueOf(intValue))) {
                                treeMap.get(Integer.valueOf(intValue));
                            } else {
                                treeMap.put(Integer.valueOf(intValue), new C1614c(intValue, currentTimeMillis, js, jt, jr));
                            }
                        }
                        this.eEi.mo5078a(new C1613b(currentTimeMillis, a, treeMap));
                        synchronized (this) {
                            wait(50);
                        }
                    }
                }
            } catch (Exception e) {
                C1611c.m3270e("HardCoder.HardCoderMonitor", "integer parse error:" + e.getMessage());
            } catch (InterruptedException e2) {
            }
        }
        AppMethodBeat.m2505o(93928);
    }

    /* renamed from: a */
    public static Map<Integer, C1612a> m3273a(long j, C6588h c6588h) {
        AppMethodBeat.m2504i(93929);
        final TreeMap treeMap = new TreeMap();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < availableProcessors; i++) {
            File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
            if (file.exists()) {
                final C6588h c6588h2 = c6588h;
                final long j2 = j;
                C1623g.m3285a(file.getAbsolutePath(), new C1622a() {
                    /* renamed from: kZ */
                    public final boolean mo5072kZ(String str) {
                        int intValue;
                        C1612a c1612a;
                        AppMethodBeat.m2504i(93923);
                        long parseLong = Long.parseLong(str.trim());
                        if (c6588h2.eEH.containsKey(Integer.valueOf(i))) {
                            Integer num = (Integer) ((C1624a) c6588h2.eEH.get(Integer.valueOf(i))).eEN.get(Long.valueOf(parseLong));
                            if (num != null) {
                                intValue = num.intValue();
                                c1612a = new C1612a(j2, i, parseLong, intValue);
                                treeMap.put(Integer.valueOf(i), c1612a);
                                C1611c.m3269d("HardCoder.HardCoderMonitor", c1612a.toString());
                                AppMethodBeat.m2505o(93923);
                                return false;
                            }
                        }
                        intValue = 0;
                        c1612a = new C1612a(j2, i, parseLong, intValue);
                        treeMap.put(Integer.valueOf(i), c1612a);
                        C1611c.m3269d("HardCoder.HardCoderMonitor", c1612a.toString());
                        AppMethodBeat.m2505o(93923);
                        return false;
                    }
                });
            }
        }
        AppMethodBeat.m2505o(93929);
        return treeMap;
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(93930);
        super.finalize();
        this.eEh = null;
        this.eEa = null;
        this.eEi = null;
        AppMethodBeat.m2505o(93930);
    }
}
