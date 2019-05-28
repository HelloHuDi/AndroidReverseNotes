package com.tencent.p177mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.hardcoder.C1615d.C1612a;
import com.tencent.p177mm.hardcoder.C1615d.C1613b;
import com.tencent.p177mm.hardcoder.C1615d.C1614c;
import java.util.Deque;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

/* renamed from: com.tencent.mm.hardcoder.f */
public final class C1621f implements Runnable {
    private C1620b eEA;
    private Deque<C1620b> eEB;
    private boolean eEb;
    private Queue<C1613b> eEz;
    private Thread thread;

    /* renamed from: com.tencent.mm.hardcoder.f$a */
    public static class C1619a {
        public final long eEC;
        public final long eED;
        public long eEE = 0;
        public long eEF = 0;

        public C1619a(long j, long j2) {
            AppMethodBeat.m2504i(93933);
            this.eEC = j;
            this.eED = j2;
            this.eEE = this.eEC;
            this.eEF = this.eED;
            AppMethodBeat.m2505o(93933);
        }

        /* renamed from: v */
        public final void mo5075v(long j, long j2) {
            this.eEE = (this.eEE + j) / 2;
            this.eEF = (this.eEF + j2) / 2;
        }

        public final String toString() {
            AppMethodBeat.m2504i(93934);
            String format = String.format("startFreq:%s, startPower:%s, averageFreq:%s, averagePower:%s", new Object[]{Long.valueOf(this.eEC), Long.valueOf(this.eED), Long.valueOf(this.eEE), Long.valueOf(this.eEF)});
            AppMethodBeat.m2505o(93934);
            return format;
        }
    }

    /* renamed from: com.tencent.mm.hardcoder.f$b */
    public static class C1620b {
        public final C1619a eDX;
        public final C1619a eDY;
        public final Map<Integer, C1614c> eEG = new TreeMap();
        public final Map<Integer, C1612a> eEs;
        public final long startTime;
        public long updateTime = 0;

        public C1620b(long j, Map<Integer, C1612a> map, Map<Integer, C1614c> map2) {
            AppMethodBeat.m2504i(93935);
            int[] h = C1620b.m3279h(map);
            this.eEs = map;
            this.eDX = new C1619a(((C1612a) map.get(Integer.valueOf(h[0]))).eEq, (long) ((C1612a) map.get(Integer.valueOf(h[0]))).eEr);
            if (h[1] < 0) {
                C1611c.m3270e("HardCoder.HardCoderStatThread", "cluster one is unused?may be possible.");
                this.eDY = null;
            } else {
                this.eDY = new C1619a(((C1612a) map.get(Integer.valueOf(h[1]))).eEq, (long) ((C1612a) map.get(Integer.valueOf(h[1]))).eEr);
            }
            this.startTime = j;
            this.updateTime = this.startTime;
            mo5076i(map2);
            AppMethodBeat.m2505o(93935);
        }

        /* renamed from: h */
        public static int[] m3279h(Map<Integer, C1612a> map) {
            AppMethodBeat.m2504i(93936);
            if (map == null) {
                NullPointerException nullPointerException = new NullPointerException("cpuStatusMap can not be null");
                AppMethodBeat.m2505o(93936);
                throw nullPointerException;
            }
            int i;
            int i2;
            for (i = C6588h.eEJ; i >= 0; i--) {
                if (map.containsKey(Integer.valueOf(i))) {
                    i2 = i;
                    break;
                }
            }
            i2 = -1;
            if (i2 < 0) {
                C1611c.m3270e("HardCoder.HardCoderStatThread", "cluster zero is unused?impossible.CLUSTER_ZERO_CORE_ID:" + C6588h.eEJ);
            }
            i = C6588h.eEK;
            while (i > C6588h.eEJ) {
                if (map.containsKey(Integer.valueOf(i))) {
                    break;
                }
                i--;
            }
            i = -1;
            int[] iArr = new int[]{i2, i};
            AppMethodBeat.m2505o(93936);
            return iArr;
        }

        /* Access modifiers changed, original: final */
        /* renamed from: i */
        public final void mo5076i(Map<Integer, C1614c> map) {
            AppMethodBeat.m2504i(93937);
            if (map == null) {
                NullPointerException nullPointerException = new NullPointerException("threadStatusMap can not be null");
                AppMethodBeat.m2505o(93937);
                throw nullPointerException;
            }
            for (Entry entry : map.entrySet()) {
                C1614c c1614c;
                int intValue = ((Integer) entry.getKey()).intValue();
                C1614c c1614c2 = (C1614c) entry.getValue();
                if (this.eEG.containsKey(Integer.valueOf(intValue))) {
                    c1614c = (C1614c) this.eEG.get(Integer.valueOf(intValue));
                } else {
                    c1614c = new C1614c(c1614c2.eEu, c1614c2.startTime, c1614c2.eEv, c1614c2.eEw, c1614c2.eDS);
                    this.eEG.put(Integer.valueOf(intValue), c1614c);
                }
                c1614c.mo5068a(c1614c2.eEw, c1614c2.eDS);
            }
            AppMethodBeat.m2505o(93937);
        }

        public final String toString() {
            AppMethodBeat.m2504i(93938);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.format("startTime:%s,updateTime:%s", new Object[]{Long.valueOf(this.startTime), Long.valueOf(this.updateTime)}));
            stringBuilder.append(",");
            stringBuilder.append(this.eDX);
            if (this.eDY != null) {
                stringBuilder.append(",");
                stringBuilder.append(this.eDY);
            }
            stringBuilder.append(",");
            stringBuilder.append(this.eEG.toString());
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(93938);
            return stringBuilder2;
        }
    }

    public final void run() {
        AppMethodBeat.m2504i(93939);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (this.eEz.isEmpty()) {
                    synchronized (this) {
                        if (this.eEb) {
                            C1611c.m3271i("HardCoder.HardCoderStatThread", "snapshotStatDeque size:" + this.eEB.size());
                            if (this.thread != null) {
                                this.thread.interrupt();
                                this.thread = null;
                                this.eEb = false;
                            }
                        }
                        while (this.eEz.isEmpty()) {
                            wait();
                        }
                    }
                } else {
                    C1613b c1613b = (C1613b) this.eEz.poll();
                    if (c1613b != null) {
                        C1620b c1620b;
                        long j = c1613b.time;
                        Map map = c1613b.eEs;
                        Map map2 = c1613b.eEt;
                        if (this.eEA == null) {
                            this.eEA = new C1620b(j, map, map2);
                        } else {
                            c1620b = this.eEA;
                            int[] h = C1620b.m3279h(map);
                            c1620b.updateTime = j;
                            c1620b.eDX.mo5075v(((C1612a) map.get(Integer.valueOf(h[0]))).eEq, (long) ((C1612a) map.get(Integer.valueOf(h[0]))).eEr);
                            if (c1620b.eDY != null) {
                                c1620b.eDY.mo5075v(((C1612a) map.get(Integer.valueOf(h[1]))).eEq, (long) ((C1612a) map.get(Integer.valueOf(h[1]))).eEr);
                            }
                            c1620b.mo5076i(map2);
                        }
                        C1611c.m3271i("HardCoder.HardCoderStatThread", this.eEA.toString());
                        c1620b = new C1620b(j, map, map2);
                        C1620b c1620b2 = (C1620b) this.eEB.peekFirst();
                        C1620b c1620b3 = (C1620b) this.eEB.peekLast();
                        if (c1620b2 == null || c1620b3 == null) {
                            this.eEB.add(c1620b);
                        } else {
                            if (c1620b3.startTime - c1620b2.startTime >= 30000) {
                                this.eEB.removeFirst();
                            }
                            this.eEB.add(c1620b);
                        }
                    }
                }
            } catch (InterruptedException e) {
                C1611c.m3270e("HardCoder.HardCoderStatThread", "Stat thread need to interrupt:" + e.getMessage());
                Thread.currentThread().interrupt();
                AppMethodBeat.m2505o(93939);
                return;
            } catch (Exception e2) {
                C1611c.m3270e("HardCoder.HardCoderStatThread", "exception:" + e2.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.m2505o(93939);
            }
        }
        AppMethodBeat.m2505o(93939);
    }

    /* renamed from: a */
    public final void mo5078a(C1613b c1613b) {
        AppMethodBeat.m2504i(93940);
        if (this.eEz != null) {
            synchronized (this) {
                try {
                    this.eEz.add(c1613b);
                    notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(93940);
                }
            }
            return;
        }
        AppMethodBeat.m2505o(93940);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.m2504i(93941);
        super.finalize();
        this.eEz = null;
        this.eEA = null;
        this.eEB = null;
        AppMethodBeat.m2505o(93941);
    }
}
