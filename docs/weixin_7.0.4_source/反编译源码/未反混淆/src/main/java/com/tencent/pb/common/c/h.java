package com.tencent.pb.common.c;

import android.os.Handler;
import android.os.Looper;

public final class h {
    public static Handler sHandler = new Handler(Looper.getMainLooper());

    public static void aB(Runnable runnable) {
        Object obj;
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            runnable.run();
        } else {
            sHandler.post(runnable);
        }
    }
}
