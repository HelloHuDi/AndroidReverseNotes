package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.d.c;
import java.util.Deque;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public final class f implements Runnable {
    private b eEA;
    private Deque<b> eEB;
    private boolean eEb;
    private Queue<com.tencent.mm.hardcoder.d.b> eEz;
    private Thread thread;

    public static class a {
        public final long eEC;
        public final long eED;
        public long eEE = 0;
        public long eEF = 0;

        public a(long j, long j2) {
            AppMethodBeat.i(93933);
            this.eEC = j;
            this.eED = j2;
            this.eEE = this.eEC;
            this.eEF = this.eED;
            AppMethodBeat.o(93933);
        }

        public final void v(long j, long j2) {
            this.eEE = (this.eEE + j) / 2;
            this.eEF = (this.eEF + j2) / 2;
        }

        public final String toString() {
            AppMethodBeat.i(93934);
            String format = String.format("startFreq:%s, startPower:%s, averageFreq:%s, averagePower:%s", new Object[]{Long.valueOf(this.eEC), Long.valueOf(this.eED), Long.valueOf(this.eEE), Long.valueOf(this.eEF)});
            AppMethodBeat.o(93934);
            return format;
        }
    }

    public static class b {
        public final a eDX;
        public final a eDY;
        public final Map<Integer, c> eEG = new TreeMap();
        public final Map<Integer, com.tencent.mm.hardcoder.d.a> eEs;
        public final long startTime;
        public long updateTime = 0;

        public b(long j, Map<Integer, com.tencent.mm.hardcoder.d.a> map, Map<Integer, c> map2) {
            AppMethodBeat.i(93935);
            int[] h = h(map);
            this.eEs = map;
            this.eDX = new a(((com.tencent.mm.hardcoder.d.a) map.get(Integer.valueOf(h[0]))).eEq, (long) ((com.tencent.mm.hardcoder.d.a) map.get(Integer.valueOf(h[0]))).eEr);
            if (h[1] < 0) {
                c.e("HardCoder.HardCoderStatThread", "cluster one is unused?may be possible.");
                this.eDY = null;
            } else {
                this.eDY = new a(((com.tencent.mm.hardcoder.d.a) map.get(Integer.valueOf(h[1]))).eEq, (long) ((com.tencent.mm.hardcoder.d.a) map.get(Integer.valueOf(h[1]))).eEr);
            }
            this.startTime = j;
            this.updateTime = this.startTime;
            i(map2);
            AppMethodBeat.o(93935);
        }

        public static int[] h(Map<Integer, com.tencent.mm.hardcoder.d.a> map) {
            AppMethodBeat.i(93936);
            if (map == null) {
                NullPointerException nullPointerException = new NullPointerException("cpuStatusMap can not be null");
                AppMethodBeat.o(93936);
                throw nullPointerException;
            }
            int i;
            int i2;
            for (i = h.eEJ; i >= 0; i--) {
                if (map.containsKey(Integer.valueOf(i))) {
                    i2 = i;
                    break;
                }
            }
            i2 = -1;
            if (i2 < 0) {
                c.e("HardCoder.HardCoderStatThread", "cluster zero is unused?impossible.CLUSTER_ZERO_CORE_ID:" + h.eEJ);
            }
            i = h.eEK;
            while (i > h.eEJ) {
                if (map.containsKey(Integer.valueOf(i))) {
                    break;
                }
                i--;
            }
            i = -1;
            int[] iArr = new int[]{i2, i};
            AppMethodBeat.o(93936);
            return iArr;
        }

        /* Access modifiers changed, original: final */
        public final void i(Map<Integer, c> map) {
            AppMethodBeat.i(93937);
            if (map == null) {
                NullPointerException nullPointerException = new NullPointerException("threadStatusMap can not be null");
                AppMethodBeat.o(93937);
                throw nullPointerException;
            }
            for (Entry entry : map.entrySet()) {
                c cVar;
                int intValue = ((Integer) entry.getKey()).intValue();
                c cVar2 = (c) entry.getValue();
                if (this.eEG.containsKey(Integer.valueOf(intValue))) {
                    cVar = (c) this.eEG.get(Integer.valueOf(intValue));
                } else {
                    cVar = new c(cVar2.eEu, cVar2.startTime, cVar2.eEv, cVar2.eEw, cVar2.eDS);
                    this.eEG.put(Integer.valueOf(intValue), cVar);
                }
                cVar.a(cVar2.eEw, cVar2.eDS);
            }
            AppMethodBeat.o(93937);
        }

        public final String toString() {
            AppMethodBeat.i(93938);
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
            AppMethodBeat.o(93938);
            return stringBuilder2;
        }
    }

    public final void run() {
        AppMethodBeat.i(93939);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                if (this.eEz.isEmpty()) {
                    synchronized (this) {
                        if (this.eEb) {
                            c.i("HardCoder.HardCoderStatThread", "snapshotStatDeque size:" + this.eEB.size());
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
                    com.tencent.mm.hardcoder.d.b bVar = (com.tencent.mm.hardcoder.d.b) this.eEz.poll();
                    if (bVar != null) {
                        b bVar2;
                        long j = bVar.time;
                        Map map = bVar.eEs;
                        Map map2 = bVar.eEt;
                        if (this.eEA == null) {
                            this.eEA = new b(j, map, map2);
                        } else {
                            bVar2 = this.eEA;
                            int[] h = b.h(map);
                            bVar2.updateTime = j;
                            bVar2.eDX.v(((com.tencent.mm.hardcoder.d.a) map.get(Integer.valueOf(h[0]))).eEq, (long) ((com.tencent.mm.hardcoder.d.a) map.get(Integer.valueOf(h[0]))).eEr);
                            if (bVar2.eDY != null) {
                                bVar2.eDY.v(((com.tencent.mm.hardcoder.d.a) map.get(Integer.valueOf(h[1]))).eEq, (long) ((com.tencent.mm.hardcoder.d.a) map.get(Integer.valueOf(h[1]))).eEr);
                            }
                            bVar2.i(map2);
                        }
                        c.i("HardCoder.HardCoderStatThread", this.eEA.toString());
                        bVar2 = new b(j, map, map2);
                        b bVar3 = (b) this.eEB.peekFirst();
                        b bVar4 = (b) this.eEB.peekLast();
                        if (bVar3 == null || bVar4 == null) {
                            this.eEB.add(bVar2);
                        } else {
                            if (bVar4.startTime - bVar3.startTime >= 30000) {
                                this.eEB.removeFirst();
                            }
                            this.eEB.add(bVar2);
                        }
                    }
                }
            } catch (InterruptedException e) {
                c.e("HardCoder.HardCoderStatThread", "Stat thread need to interrupt:" + e.getMessage());
                Thread.currentThread().interrupt();
                AppMethodBeat.o(93939);
                return;
            } catch (Exception e2) {
                c.e("HardCoder.HardCoderStatThread", "exception:" + e2.getMessage());
            } catch (Throwable th) {
                AppMethodBeat.o(93939);
            }
        }
        AppMethodBeat.o(93939);
    }

    public final void a(com.tencent.mm.hardcoder.d.b bVar) {
        AppMethodBeat.i(93940);
        if (this.eEz != null) {
            synchronized (this) {
                try {
                    this.eEz.add(bVar);
                    notify();
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(93940);
                }
            }
            return;
        }
        AppMethodBeat.o(93940);
    }

    /* Access modifiers changed, original: protected|final */
    public final void finalize() {
        AppMethodBeat.i(93941);
        super.finalize();
        this.eEz = null;
        this.eEA = null;
        this.eEB = null;
        AppMethodBeat.o(93941);
    }
}
