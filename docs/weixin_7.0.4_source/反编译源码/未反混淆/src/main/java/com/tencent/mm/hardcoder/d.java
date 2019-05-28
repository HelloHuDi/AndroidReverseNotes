package com.tencent.mm.hardcoder;

import android.os.Process;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public final class d implements Runnable {
    private h eEa;
    private Set<Integer> eEh;
    private f eEi;
    private long eEj;
    private long eEk;

    public static class a {
        public final int eEp;
        public final long eEq;
        public final int eEr;
        public final long startTime;

        public a(long j, int i, long j2, int i2) {
            this.startTime = j;
            this.eEp = i;
            this.eEq = j2;
            this.eEr = i2;
        }

        public final String toString() {
            AppMethodBeat.i(93924);
            String format = String.format("Cpu status,startTime:%s,coreId:%s,freq:%s,power:%s", new Object[]{Long.valueOf(this.startTime), Integer.valueOf(this.eEp), Long.valueOf(this.eEq), Integer.valueOf(this.eEr)});
            AppMethodBeat.o(93924);
            return format;
        }
    }

    public static class b {
        public final Map<Integer, a> eEs;
        public final Map<Integer, c> eEt;
        public final long time;

        public b(long j, Map<Integer, a> map, Map<Integer, c> map2) {
            this.time = j;
            this.eEs = map;
            this.eEt = map2;
        }
    }

    public static class c {
        public final long[] eDS;
        public long eDU = 0;
        public final int eEu;
        public final int eEv;
        public final long eEw;
        public long eEx = 0;
        public final long startTime;

        public c(int i, long j, int i2, long j2, long[] jArr) {
            AppMethodBeat.i(93925);
            this.eEu = i;
            this.startTime = j;
            this.eEv = i2;
            this.eEw = j2;
            this.eDS = jArr;
            this.eDU = this.eEw;
            AppMethodBeat.o(93925);
        }

        public final void a(long j, long[] jArr) {
            AppMethodBeat.i(93926);
            this.eDU = (this.eDU + j) / 2;
            if (jArr != null) {
                this.eEx = (jArr[0] - this.eDS[0]) + (jArr[1] - this.eDS[1]);
                c.d("HardCoder.HardCoderMonitor", "thread id:" + this.eEu + ",start jiffies:[" + this.eDS[0] + "," + this.eDS[1] + "], end jiffies:[" + jArr[0] + "," + jArr[1] + "]");
            }
            AppMethodBeat.o(93926);
        }

        public final String toString() {
            AppMethodBeat.i(93927);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("Thread status,threadId:%s,startTime:%s,startCoreId:%s,startCoreFreq:%s", new Object[]{Integer.valueOf(this.eEu), Long.valueOf(this.startTime), Integer.valueOf(this.eEv), Long.valueOf(this.eEw)}));
            stringBuilder.append(String.format(",sumJiffies:%s", new Object[]{Long.valueOf(this.eEx)}));
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(93927);
            return stringBuilder2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x00f3 A:{Splitter:B:3:0x0012, ExcHandler: InterruptedException (r0_48 'e' java.lang.InterruptedException)} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:26:0x00f3, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:27:0x00f4, code skipped:
            com.tencent.mm.hardcoder.c.e("HardCoder.HardCoderMonitor", "Monitor thread need to interrupt:" + r0.getMessage());
            java.lang.Thread.currentThread().interrupt();
            com.tencent.matrix.trace.core.AppMethodBeat.o(93928);
     */
    /* JADX WARNING: Missing block: B:39:0x0166, code skipped:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:40:0x0167, code skipped:
            com.tencent.mm.hardcoder.c.printErrStackTrace("HardCoder.HardCoderMonitor", r0, "exception:", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing block: B:56:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(93928);
     */
    /* JADX WARNING: Missing block: B:67:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(93928);
     */
    /* JADX WARNING: Missing block: B:86:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(93928);
     */
    /* JADX WARNING: Missing block: B:101:?, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(93928);
     */
    /* JADX WARNING: Missing block: B:124:?, code skipped:
            return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        AppMethodBeat.i(93928);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis < this.eEj || currentTimeMillis > this.eEk) {
                    synchronized (this) {
                        wait(60000);
                        c.i("HardCoder.HardCoderMonitor", "Monitor thread wait(no in time):60000");
                    }
                } else {
                    int i;
                    int intValue;
                    c.d("HardCoder.HardCoderMonitor", "get cpu current freq,begin:" + SystemClock.elapsedRealtime());
                    Map a = a(currentTimeMillis, this.eEa);
                    c.d("HardCoder.HardCoderMonitor", "get cpu current freq,end:" + SystemClock.elapsedRealtime());
                    HashSet hashSet = new HashSet();
                    File file = new File("/proc/" + Process.myPid() + "/task");
                    if (file.isDirectory()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length == 0) {
                            i = 1;
                        } else {
                            c.d("HardCoder.HardCoderMonitor", "thread size:" + listFiles.length);
                            for (File file2 : listFiles) {
                                hashSet.add(Integer.valueOf(Integer.parseInt(file2.getName(), 0)));
                            }
                            i = 0;
                        }
                    } else {
                        c.e("HardCoder.HardCoderMonitor", "impossible as usual");
                        i = 1;
                    }
                    TreeMap treeMap = new TreeMap();
                    this.eEh.addAll(hashSet);
                    c.d("HardCoder.HardCoderMonitor", "get thread current stat,end:" + SystemClock.elapsedRealtime());
                    if (i != 0) {
                        synchronized (this) {
                            wait(60000);
                            c.i("HardCoder.HardCoderMonitor", "Monitor thread wait(pid/task error):60000");
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
                            long[] jr = g.jr(intValue);
                            int js = g.js(intValue);
                            long jt = g.jt(js);
                            if (treeMap.containsKey(Integer.valueOf(intValue))) {
                                treeMap.get(Integer.valueOf(intValue));
                            } else {
                                treeMap.put(Integer.valueOf(intValue), new c(intValue, currentTimeMillis, js, jt, jr));
                            }
                        }
                        this.eEi.a(new b(currentTimeMillis, a, treeMap));
                        synchronized (this) {
                            wait(50);
                        }
                    }
                }
            } catch (Exception e) {
                c.e("HardCoder.HardCoderMonitor", "integer parse error:" + e.getMessage());
            } catch (InterruptedException e2) {
            }
        }
        AppMethodBeat.o(93928);
    }

    public static Map<Integer, a> a(long j, h hVar) {
        AppMethodBeat.i(93929);
        final TreeMap treeMap = new TreeMap();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        for (int i = 0; i < availableProcessors; i++) {
            File file = new File("/sys/devices/system/cpu/cpu" + i + "/cpufreq/scaling_cur_freq");
            if (file.exists()) {
                final h hVar2 = hVar;
                final long j2 = j;
                g.a(file.getAbsolutePath(), new com.tencent.mm.hardcoder.g.a() {
                    public final boolean kZ(String str) {
                        int intValue;
                        a aVar;
                        AppMethodBeat.i(93923);
                        long parseLong = Long.parseLong(str.trim());
                        if (hVar2.eEH.containsKey(Integer.valueOf(i))) {
                            Integer num = (Integer) ((com.tencent.mm.hardcoder.h.a) hVar2.eEH.get(Integer.valueOf(i))).eEN.get(Long.valueOf(parseLong));
                            if (num != null) {
                                intValue = num.intValue();
                                aVar = new a(j2, i, parseLong, intValue);
                                treeMap.put(Integer.valueOf(i), aVar);
                                c.d("HardCoder.HardCoderMonitor", aVar.toString());
                                AppMethodBeat.o(93923);
                                return false;
                            }
                        }
                        intValue = 0;
                        aVar = new a(j2, i, parseLong, intValue);
                        treeMap.put(Integer.valueOf(i), aVar);
                        c.d("HardCoder.HardCoderMonitor", aVar.toString());
                        AppMethodBeat.o(93923);
                        return false;
                    }
                });
            }
        }
        AppMethodBeat.o(93929);
        return treeMap;
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(93930);
        super.finalize();
        this.eEh = null;
        this.eEa = null;
        this.eEi = null;
        AppMethodBeat.o(93930);
    }
}
