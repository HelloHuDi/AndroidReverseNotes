package com.tencent.matrix.trace.core;

import android.os.SystemClock;
import android.view.Choreographer;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.trace.core.C1145a.C1144a;
import com.tencent.matrix.trace.p170a.C1133a;
import com.tencent.matrix.trace.p174e.C1154c;
import com.tencent.matrix.trace.p176g.C1167b;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.matrix.trace.core.b */
public final class C1148b implements Runnable {
    private static final C1148b bYY = new C1148b();
    public C1133a bYH;
    private volatile boolean bYT = false;
    private long[] bYU = new long[4];
    private HashSet<C1154c> bYV = new HashSet();
    private volatile long bYW = 0;
    private boolean bYX = false;
    public Object bYZ;
    public Object[] bZa;
    public Method bZb;
    public Method bZc;
    public Method bZd;
    public long bZe = 16666666;
    private int[] bZf = new int[3];
    private boolean[] bZg = new boolean[3];
    private long[] bZh = new long[3];
    public boolean bZi = false;
    public Choreographer bsZ;

    /* renamed from: com.tencent.matrix.trace.core.b$3 */
    class C11463 implements Runnable {
        C11463() {
        }

        public final void run() {
            C1148b.this.m2517fY(0);
            C1148b.this.m2516fX(1);
        }
    }

    /* renamed from: com.tencent.matrix.trace.core.b$4 */
    class C11474 implements Runnable {
        C11474() {
        }

        public final void run() {
            C1148b.this.m2517fY(1);
            C1148b.this.m2516fX(2);
        }
    }

    /* renamed from: com.tencent.matrix.trace.core.b$1 */
    public class C11491 extends C1144a {
        public final boolean isValid() {
            return C1148b.this.bYT;
        }

        public final void dispatchStart() {
            super.dispatchStart();
            C1148b.m2512b(C1148b.this);
        }

        public final void dispatchEnd() {
            super.dispatchEnd();
            C1148b.m2514c(C1148b.this);
        }
    }

    /* renamed from: com.tencent.matrix.trace.core.b$2 */
    public class C11502 extends C1154c {
        /* renamed from: a */
        public final void mo4382a(String str, long j, long j2, long j3, long j4) {
            C1070c.m2368i("Matrix.UIThreadMonitor", "activityName[%s] frame cost:%sms [%s|%s|%s]ns", str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4));
        }
    }

    /* renamed from: zx */
    public static C1148b m2518zx() {
        return bYY;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private synchronized void m2511b(int i, Runnable runnable) {
        Method method = null;
        synchronized (this) {
            if (this.bZg[i]) {
                C1070c.m2370w("Matrix.UIThreadMonitor", "[addFrameCallback] this type %s callback has exist!", Integer.valueOf(i));
            } else if (this.bYT || i != 0) {
                try {
                    synchronized (this.bYZ) {
                        switch (i) {
                            case 0:
                                method = this.bZc;
                            case 1:
                                method = this.bZd;
                                if (method != null) {
                                    method.invoke(this.bZa[i], new Object[]{Long.valueOf(-1), runnable, null});
                                    this.bZg[i] = true;
                                }
                            case 2:
                                method = this.bZb;
                                if (method != null) {
                                }
                                break;
                        }
                        if (method != null) {
                        }
                    }
                } catch (Exception e) {
                    C1070c.m2367e("Matrix.UIThreadMonitor", e.toString(), new Object[0]);
                }
            } else {
                C1070c.m2370w("Matrix.UIThreadMonitor", "[addFrameCallback] UIThreadMonitor is not alive!", new Object[0]);
            }
        }
        return;
    }

    /* renamed from: a */
    public final void mo4376a(C1154c c1154c) {
        if (!this.bYT) {
            onStart();
        }
        synchronized (this.bYV) {
            this.bYV.add(c1154c);
        }
    }

    /* renamed from: b */
    public final void mo4377b(C1154c c1154c) {
        synchronized (this.bYV) {
            this.bYV.remove(c1154c);
            if (this.bYV.isEmpty()) {
                onStop();
            }
        }
    }

    /* renamed from: p */
    public final long mo4380p(int i, long j) {
        if (j != this.bYW) {
            return -1;
        }
        return this.bZf[i] == 2 ? this.bZh[i] : 0;
    }

    public static <T> T reflectObject(Object obj, String str) {
        try {
            Field declaredField = obj.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception e) {
            C1070c.m2367e("Matrix.UIThreadMonitor", e.toString(), new Object[0]);
            return null;
        }
    }

    /* renamed from: d */
    public static Method m2515d(Object obj, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e) {
            C1070c.m2367e("Matrix.UIThreadMonitor", e.toString(), new Object[0]);
            return null;
        }
    }

    /* renamed from: fX */
    private void m2516fX(int i) {
        this.bZf[i] = 1;
        this.bZh[i] = System.nanoTime();
    }

    /* renamed from: fY */
    private void m2517fY(int i) {
        this.bZf[i] = 2;
        this.bZh[i] = System.nanoTime() - this.bZh[i];
        synchronized (this.bZg) {
            this.bZg[i] = false;
        }
    }

    public final synchronized void onStart() {
        if (!this.bZi) {
            throw new RuntimeException("never init!");
        } else if (!this.bYT) {
            C1070c.m2368i("Matrix.UIThreadMonitor", "[onStart] %s", C1167b.getStack());
            this.bYT = true;
            m2511b(0, (Runnable) this);
        }
    }

    public final void run() {
        long nanoTime = System.nanoTime();
        try {
            long j = this.bYW;
            this.bYX = true;
            m2516fX(0);
            m2511b(1, new C11463());
            m2511b(2, new C11474());
            if (this.bYH.bYE) {
                C1070c.m2366d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", Long.valueOf(System.nanoTime() - nanoTime));
            }
        } catch (Throwable th) {
            if (this.bYH.bYE) {
                C1070c.m2366d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", Long.valueOf(System.nanoTime() - nanoTime));
            }
        }
    }

    public final synchronized void onStop() {
        if (!this.bZi) {
            throw new RuntimeException("UIThreadMonitor is never init!");
        } else if (this.bYT) {
            this.bYT = false;
            C1070c.m2368i("Matrix.UIThreadMonitor", "[onStop] %s", C1167b.getStack());
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m2514c(C1148b c1148b) {
        if (c1148b.bYX) {
            long j = c1148b.bYW;
            c1148b.m2517fY(2);
            for (int i : c1148b.bZf) {
                if (i != 2) {
                    c1148b.bZh[i] = -100;
                    if (c1148b.bYH.bYE) {
                        throw new RuntimeException(String.format("UIThreadMonitor happens type[%s] != DO_QUEUE_END", new Object[]{Integer.valueOf(i)}));
                    }
                }
            }
            c1148b.bZf = new int[3];
            long uptimeMillis = SystemClock.uptimeMillis();
            synchronized (c1148b.bYV) {
                Iterator it = c1148b.bYV.iterator();
                while (it.hasNext()) {
                    C1154c c1154c = (C1154c) it.next();
                    if (c1154c.bZv) {
                        c1154c.mo4382a(AppMethodBeat.getFocusedActivity(), uptimeMillis - j, c1148b.bZh[0], c1148b.bZh[1], c1148b.bZh[2]);
                    }
                }
            }
            c1148b.m2511b(0, (Runnable) c1148b);
            c1148b.bYX = false;
        }
        c1148b.bYU[3] = SystemClock.currentThreadTimeMillis();
        c1148b.bYU[1] = SystemClock.uptimeMillis();
        AppMethodBeat.m2505o(AppMethodBeat.METHOD_ID_DISPATCH);
        synchronized (c1148b.bYV) {
            Iterator it2 = c1148b.bYV.iterator();
            while (it2.hasNext()) {
                C1154c c1154c2 = (C1154c) it2.next();
                if (c1154c2.bZv) {
                    c1154c2.mo4388a(c1148b.bYU[0], c1148b.bYU[2], c1148b.bYU[1], c1148b.bYU[3], c1148b.bYW, c1148b.bYX);
                }
            }
        }
    }
}
