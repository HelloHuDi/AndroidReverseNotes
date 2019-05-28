package com.tencent.magicbrush.p821d;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Callable;

/* renamed from: com.tencent.magicbrush.d.c */
public final class C37415c {

    /* renamed from: com.tencent.magicbrush.d.c$a */
    static class C32198a {
        private static final Handler sMainHandler = new Handler(Looper.getMainLooper());

        static {
            AppMethodBeat.m2504i(116013);
            AppMethodBeat.m2505o(116013);
        }
    }

    public static void runOnUiThread(Runnable runnable) {
        AppMethodBeat.m2504i(116014);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
            AppMethodBeat.m2505o(116014);
            return;
        }
        C32198a.sMainHandler.post(runnable);
        AppMethodBeat.m2505o(116014);
    }

    /* renamed from: b */
    public static <T> T m63044b(Callable<T> callable) {
        AppMethodBeat.m2504i(116015);
        C25714b c25714b = new C25714b((Callable) callable);
        C37415c.runOnUiThread(c25714b);
        Object obj = c25714b.get();
        AppMethodBeat.m2505o(116015);
        return obj;
    }
}
