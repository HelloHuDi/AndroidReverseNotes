package com.tencent.matrix.trace.core;

import android.os.SystemClock;
import android.view.Choreographer;
import com.tencent.matrix.trace.a.a;
import com.tencent.matrix.trace.e.c;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Iterator;

public final class b implements Runnable {
    private static final b bYY = new b();
    public a bYH;
    private volatile boolean bYT = false;
    private long[] bYU = new long[4];
    private HashSet<c> bYV = new HashSet();
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

    public static b zx() {
        return bYY;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003b A:{SYNTHETIC} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void b(int i, Runnable runnable) {
        Method method = null;
        synchronized (this) {
            if (this.bZg[i]) {
                com.tencent.matrix.d.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] this type %s callback has exist!", Integer.valueOf(i));
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
                    com.tencent.matrix.d.c.e("Matrix.UIThreadMonitor", e.toString(), new Object[0]);
                }
            } else {
                com.tencent.matrix.d.c.w("Matrix.UIThreadMonitor", "[addFrameCallback] UIThreadMonitor is not alive!", new Object[0]);
            }
        }
        return;
    }

    public final void a(c cVar) {
        if (!this.bYT) {
            onStart();
        }
        synchronized (this.bYV) {
            this.bYV.add(cVar);
        }
    }

    public final void b(c cVar) {
        synchronized (this.bYV) {
            this.bYV.remove(cVar);
            if (this.bYV.isEmpty()) {
                onStop();
            }
        }
    }

    public final long p(int i, long j) {
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
            com.tencent.matrix.d.c.e("Matrix.UIThreadMonitor", e.toString(), new Object[0]);
            return null;
        }
    }

    public static Method d(Object obj, String str, Class<?>... clsArr) {
        try {
            Method declaredMethod = obj.getClass().getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (Exception e) {
            com.tencent.matrix.d.c.e("Matrix.UIThreadMonitor", e.toString(), new Object[0]);
            return null;
        }
    }

    private void fX(int i) {
        this.bZf[i] = 1;
        this.bZh[i] = System.nanoTime();
    }

    private void fY(int i) {
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
            com.tencent.matrix.d.c.i("Matrix.UIThreadMonitor", "[onStart] %s", com.tencent.matrix.trace.g.b.getStack());
            this.bYT = true;
            b(0, (Runnable) this);
        }
    }

    public final void run() {
        long nanoTime = System.nanoTime();
        try {
            long j = this.bYW;
            this.bYX = true;
            fX(0);
            b(1, new Runnable() {
                public final void run() {
                    b.this.fY(0);
                    b.this.fX(1);
                }
            });
            b(2, new Runnable() {
                public final void run() {
                    b.this.fY(1);
                    b.this.fX(2);
                }
            });
            if (this.bYH.bYE) {
                com.tencent.matrix.d.c.d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", Long.valueOf(System.nanoTime() - nanoTime));
            }
        } catch (Throwable th) {
            if (this.bYH.bYE) {
                com.tencent.matrix.d.c.d("Matrix.UIThreadMonitor", "[UIThreadMonitor#run] inner cost:%sns", Long.valueOf(System.nanoTime() - nanoTime));
            }
        }
    }

    public final synchronized void onStop() {
        if (!this.bZi) {
            throw new RuntimeException("UIThreadMonitor is never init!");
        } else if (this.bYT) {
            this.bYT = false;
            com.tencent.matrix.d.c.i("Matrix.UIThreadMonitor", "[onStop] %s", com.tencent.matrix.trace.g.b.getStack());
        }
    }

    static /* synthetic */ void c(b bVar) {
        if (bVar.bYX) {
            long j = bVar.bYW;
            bVar.fY(2);
            for (int i : bVar.bZf) {
                if (i != 2) {
                    bVar.bZh[i] = -100;
                    if (bVar.bYH.bYE) {
                        throw new RuntimeException(String.format("UIThreadMonitor happens type[%s] != DO_QUEUE_END", new Object[]{Integer.valueOf(i)}));
                    }
                }
            }
            bVar.bZf = new int[3];
            long uptimeMillis = SystemClock.uptimeMillis();
            synchronized (bVar.bYV) {
                Iterator it = bVar.bYV.iterator();
                while (it.hasNext()) {
                    c cVar = (c) it.next();
                    if (cVar.bZv) {
                        cVar.a(AppMethodBeat.getFocusedActivity(), uptimeMillis - j, bVar.bZh[0], bVar.bZh[1], bVar.bZh[2]);
                    }
                }
            }
            bVar.b(0, (Runnable) bVar);
            bVar.bYX = false;
        }
        bVar.bYU[3] = SystemClock.currentThreadTimeMillis();
        bVar.bYU[1] = SystemClock.uptimeMillis();
        AppMethodBeat.o(AppMethodBeat.METHOD_ID_DISPATCH);
        synchronized (bVar.bYV) {
            Iterator it2 = bVar.bYV.iterator();
            while (it2.hasNext()) {
                c cVar2 = (c) it2.next();
                if (cVar2.bZv) {
                    cVar2.a(bVar.bYU[0], bVar.bYU[2], bVar.bYU[1], bVar.bYU[3], bVar.bYW, bVar.bYX);
                }
            }
        }
    }
}
