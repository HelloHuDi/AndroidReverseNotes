package com.tencent.p659pb.common.p1102c;

import android.os.Handler;
import android.os.Looper;

/* renamed from: com.tencent.pb.common.c.h */
public final class C30916h {
    public static Handler sHandler = new Handler(Looper.getMainLooper());

    /* renamed from: aB */
    public static void m49359aB(Runnable runnable) {
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
