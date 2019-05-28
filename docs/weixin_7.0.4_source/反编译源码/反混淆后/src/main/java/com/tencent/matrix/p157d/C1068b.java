package com.tencent.matrix.p157d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.matrix.d.b */
public class C1068b {
    private static volatile HandlerThread caN;
    private static volatile Handler caO;
    private static volatile Handler caP = new Handler(Looper.getMainLooper());
    private static HashSet<HandlerThread> caQ = new HashSet();

    /* renamed from: zK */
    public static Handler m2357zK() {
        return caP;
    }

    /* renamed from: zL */
    public static HandlerThread m2358zL() {
        HandlerThread handlerThread;
        synchronized (C1068b.class) {
            if (caN == null) {
                handlerThread = new HandlerThread("default_matrix_thread");
                caN = handlerThread;
                handlerThread.start();
                caO = new Handler(caN.getLooper());
                C1070c.m2370w("Matrix.HandlerThread", "create default handler thread, we should use these thread normal", new Object[0]);
            }
            handlerThread = caN;
        }
        return handlerThread;
    }

    /* renamed from: zM */
    public static Handler m2359zM() {
        return caO;
    }

    /* renamed from: cj */
    public static HandlerThread m2356cj(String str) {
        Iterator it = caQ.iterator();
        while (it.hasNext()) {
            if (!((HandlerThread) it.next()).isAlive()) {
                it.remove();
                C1070c.m2370w("Matrix.HandlerThread", "warning: remove dead handler thread with name %s", str);
            }
        }
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        caQ.add(handlerThread);
        C1070c.m2370w("Matrix.HandlerThread", "warning: create new handler thread with name %s, alive thread size:%d", str, Integer.valueOf(caQ.size()));
        return handlerThread;
    }
}
