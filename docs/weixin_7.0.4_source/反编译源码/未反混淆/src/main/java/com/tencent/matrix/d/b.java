package com.tencent.matrix.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;

public class b {
    private static volatile HandlerThread caN;
    private static volatile Handler caO;
    private static volatile Handler caP = new Handler(Looper.getMainLooper());
    private static HashSet<HandlerThread> caQ = new HashSet();

    public static Handler zK() {
        return caP;
    }

    public static HandlerThread zL() {
        HandlerThread handlerThread;
        synchronized (b.class) {
            if (caN == null) {
                handlerThread = new HandlerThread("default_matrix_thread");
                caN = handlerThread;
                handlerThread.start();
                caO = new Handler(caN.getLooper());
                c.w("Matrix.HandlerThread", "create default handler thread, we should use these thread normal", new Object[0]);
            }
            handlerThread = caN;
        }
        return handlerThread;
    }

    public static Handler zM() {
        return caO;
    }

    public static HandlerThread cj(String str) {
        Iterator it = caQ.iterator();
        while (it.hasNext()) {
            if (!((HandlerThread) it.next()).isAlive()) {
                it.remove();
                c.w("Matrix.HandlerThread", "warning: remove dead handler thread with name %s", str);
            }
        }
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        caQ.add(handlerThread);
        c.w("Matrix.HandlerThread", "warning: create new handler thread with name %s, alive thread size:%d", str, Integer.valueOf(caQ.size()));
        return handlerThread;
    }
}
