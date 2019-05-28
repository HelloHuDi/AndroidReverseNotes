package com.tencent.p127d.p132e.p133a.p134a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: com.tencent.d.e.a.a.g */
public final class C37319g {
    private static final int[] AtM = new int[]{1, 4, 9};
    private final HashSet<Sensor> AtK = new HashSet();
    public final SparseArray<C8764i> AtL = new SparseArray();
    public C0923a AtN = new C0923a();
    private final SensorManager bCW;

    /* renamed from: com.tencent.d.e.a.a.g$a */
    public class C0923a implements SensorEventListener {
        long AtD = 0;
        final AtomicBoolean AtO = new AtomicBoolean(false);
        int AtP = 0;
        long AtQ = 0;

        C0923a() {
            AppMethodBeat.m2504i(114555);
            AppMethodBeat.m2505o(114555);
        }

        public final long dQx() {
            long j;
            synchronized (this.AtO) {
                j = this.AtD;
            }
            return j;
        }

        public final long dQy() {
            long j;
            synchronized (this.AtO) {
                j = this.AtQ;
            }
            return j;
        }

        /* JADX WARNING: Missing block: B:8:0x0017, code skipped:
            if (r10 == null) goto L_0x001d;
     */
        /* JADX WARNING: Missing block: B:10:0x001b, code skipped:
            if (r10.sensor != null) goto L_0x0027;
     */
        /* JADX WARNING: Missing block: B:11:0x001d, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(114556);
     */
        /* JADX WARNING: Missing block: B:16:0x0027, code skipped:
            r2 = new com.tencent.p127d.p132e.p133a.p134a.C32112j(r10, java.lang.System.currentTimeMillis());
            r1 = r9.AtO;
     */
        /* JADX WARNING: Missing block: B:17:0x0032, code skipped:
            monitor-enter(r1);
     */
        /* JADX WARNING: Missing block: B:19:?, code skipped:
            r4 = r2.timestamp - r9.AtD;
     */
        /* JADX WARNING: Missing block: B:20:0x003c, code skipped:
            if (r4 >= 0) goto L_0x0043;
     */
        /* JADX WARNING: Missing block: B:21:0x003e, code skipped:
            monitor-exit(r1);
     */
        /* JADX WARNING: Missing block: B:23:?, code skipped:
            monitor-exit(r1);
     */
        /* JADX WARNING: Missing block: B:24:0x0044, code skipped:
            r1 = r2.AtV;
            r3 = (int) (r4 / com.tencent.p127d.p132e.p133a.p134a.C41661f.AtH);
            r4 = com.tencent.p127d.p132e.p133a.p134a.C37319g.m62720a(r9.AtR);
     */
        /* JADX WARNING: Missing block: B:25:0x0050, code skipped:
            monitor-enter(r4);
     */
        /* JADX WARNING: Missing block: B:27:?, code skipped:
            r0 = (com.tencent.p127d.p132e.p133a.p134a.C8764i) com.tencent.p127d.p132e.p133a.p134a.C37319g.m62720a(r9.AtR).get(r1);
     */
        /* JADX WARNING: Missing block: B:28:0x005d, code skipped:
            if (r0 != null) goto L_0x00a6;
     */
        /* JADX WARNING: Missing block: B:29:0x005f, code skipped:
            r0 = new com.tencent.p127d.p132e.p133a.p134a.C8764i(r1, com.tencent.p127d.p132e.p133a.p134a.C41661f.AtI, r9.AtP);
            com.tencent.p127d.p132e.p133a.p134a.C37319g.m62720a(r9.AtR).put(r1, r0);
            r1 = r0;
     */
        /* JADX WARNING: Missing block: B:31:0x0074, code skipped:
            if (r3 >= r1.mCapacity) goto L_0x0094;
     */
        /* JADX WARNING: Missing block: B:33:0x0078, code skipped:
            if (r3 <= r1.mbt) goto L_0x0094;
     */
        /* JADX WARNING: Missing block: B:34:0x007a, code skipped:
            r5 = r3 / r1.Adk;
            r0 = (java.util.List) r1.f2442Ll[r5];
     */
        /* JADX WARNING: Missing block: B:35:0x0084, code skipped:
            if (r0 != null) goto L_0x008f;
     */
        /* JADX WARNING: Missing block: B:36:0x0086, code skipped:
            r0 = new java.util.ArrayList();
            r1.f2442Ll[r5] = r0;
     */
        /* JADX WARNING: Missing block: B:37:0x008f, code skipped:
            r0.add(r2);
            r1.mbt = r3;
     */
        /* JADX WARNING: Missing block: B:38:0x0094, code skipped:
            monitor-exit(r4);
     */
        /* JADX WARNING: Missing block: B:42:0x009c, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(114556);
     */
        /* JADX WARNING: Missing block: B:46:0x00a2, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(114556);
     */
        /* JADX WARNING: Missing block: B:47:0x00a6, code skipped:
            r1 = r0;
     */
        /* JADX WARNING: Missing block: B:58:?, code skipped:
            return;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onSensorChanged(SensorEvent sensorEvent) {
            AppMethodBeat.m2504i(114556);
            synchronized (this.AtO) {
                try {
                    if (!this.AtO.get()) {
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(114556);
                }
            }
        }

        public final void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    public C37319g(Context context) {
        AppMethodBeat.m2504i(114557);
        this.bCW = (SensorManager) context.getSystemService("sensor");
        AppMethodBeat.m2505o(114557);
    }

    /* renamed from: nA */
    public final synchronized boolean mo60053nA(long j) {
        boolean z;
        try {
            AppMethodBeat.m2504i(114558);
            if (this.bCW == null) {
                AppMethodBeat.m2505o(114558);
                z = false;
            } else {
                C0923a c0923a = this.AtN;
                synchronized (c0923a.AtO) {
                    if (c0923a.AtO.get()) {
                    } else {
                        c0923a.AtO.set(true);
                        c0923a.AtD = System.currentTimeMillis();
                        c0923a.AtP = (int) Math.ceil(((double) j) / ((double) C41661f.AtH));
                    }
                }
                synchronized (this.AtK) {
                    this.AtK.clear();
                }
                synchronized (this.AtK) {
                    z = false;
                    for (int defaultSensor : AtM) {
                        Sensor defaultSensor2 = this.bCW.getDefaultSensor(defaultSensor);
                        if (defaultSensor2 != null && this.bCW.registerListener(this.AtN, defaultSensor2, 0)) {
                            this.AtK.add(defaultSensor2);
                            z = true;
                        }
                    }
                }
                if (!z) {
                    dQv();
                }
                AppMethodBeat.m2505o(114558);
            }
        } catch (Throwable th) {
            throw th;
        }
        return z;
    }

    public final synchronized void dQv() {
        AppMethodBeat.m2504i(114559);
        if (this.bCW == null) {
            AppMethodBeat.m2505o(114559);
        } else {
            int th;
            int i = this.AtK;
            synchronized (i) {
                try {
                    Iterator it = this.AtK.iterator();
                    while (it.hasNext()) {
                        this.bCW.unregisterListener(this.AtN, (Sensor) it.next());
                    }
                    this.AtK.clear();
                } catch (Throwable th2) {
                    th = th2;
                    AppMethodBeat.m2505o(i);
                } finally {
                    while (true) {
                    }
                    i = 114559;
                    AppMethodBeat.m2505o(114559);
                }
            }
            th = this.AtN;
            synchronized (th.AtO) {
                if (th.AtO.get()) {
                    th.AtO.set(false);
                    th.AtQ = System.currentTimeMillis() - th.AtD;
                    if (th.AtQ < 0) {
                        th.AtQ = 0;
                    }
                    th.AtD = 0;
                    AppMethodBeat.m2505o(114559);
                } else {
                    AppMethodBeat.m2505o(th);
                }
            }
        }
    }

    public final SparseArray<C8764i> dQw() {
        SparseArray<C8764i> sparseArray;
        AppMethodBeat.m2504i(114560);
        synchronized (this.AtL) {
            try {
                sparseArray = new SparseArray();
                for (int i = 0; i < this.AtL.size(); i++) {
                    sparseArray.append(this.AtL.keyAt(i), (C8764i) this.AtL.valueAt(i));
                }
                if (C37319g.m62721f(sparseArray)) {
                } else {
                    SparseArray<C8764i> sparseArray2 = new SparseArray();
                    AppMethodBeat.m2505o(114560);
                    return sparseArray2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(114560);
            }
        }
        return sparseArray;
    }

    /* renamed from: f */
    private static boolean m62721f(SparseArray<C8764i> sparseArray) {
        AppMethodBeat.m2504i(114561);
        if (sparseArray.size() == 0) {
            AppMethodBeat.m2505o(114561);
            return false;
        }
        for (int i = 0; i < sparseArray.size(); i++) {
            C8764i c8764i = (C8764i) sparseArray.valueAt(i);
            if (c8764i != null) {
                Object[] dQB = c8764i.dQB();
                if (!(dQB == null || dQB.length == 0)) {
                    int i2 = 0;
                    for (Object obj : c8764i.f2442Ll) {
                        if (((List) obj) != null) {
                            i2++;
                        }
                    }
                    if (i2 < 3) {
                        AppMethodBeat.m2505o(114561);
                        return false;
                    }
                    int i3 = 0;
                    while (i3 < dQB.length) {
                        List list = (List) dQB[i3];
                        if (list == null || list.size() >= C41661f.AtI / 2) {
                            i3++;
                        } else {
                            AppMethodBeat.m2505o(114561);
                            return false;
                        }
                    }
                    continue;
                }
            }
        }
        AppMethodBeat.m2505o(114561);
        return true;
    }
}
