package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class l {
    private static volatile l eGh;
    private Handler eGi;
    private m eGj;
    private Handler mHandler;
    private HandlerThread mHandlerThread = new HandlerThread("ThreadCaller#Worker-" + hashCode());

    private static l PP() {
        AppMethodBeat.i(114049);
        if (eGh == null) {
            synchronized (l.class) {
                try {
                    if (eGh == null) {
                        eGh = new l();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114049);
                    }
                }
            }
        }
        l lVar = eGh;
        AppMethodBeat.o(114049);
        return lVar;
    }

    private l() {
        AppMethodBeat.i(114050);
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.eGi = new Handler(Looper.getMainLooper());
        this.eGj = m.PR();
        AppMethodBeat.o(114050);
    }

    public static boolean post(Runnable runnable) {
        AppMethodBeat.i(114051);
        boolean post = PP().mHandler.post(runnable);
        AppMethodBeat.o(114051);
        return post;
    }

    public static boolean postDelayed(Runnable runnable, long j) {
        AppMethodBeat.i(114052);
        boolean postDelayed = PP().mHandler.postDelayed(runnable, j);
        AppMethodBeat.o(114052);
        return postDelayed;
    }

    public static boolean q(Runnable runnable) {
        AppMethodBeat.i(114053);
        boolean post = PP().eGi.post(runnable);
        AppMethodBeat.o(114053);
        return post;
    }

    public static boolean r(Runnable runnable) {
        AppMethodBeat.i(114054);
        boolean postDelayed = PP().eGi.postDelayed(runnable, 100);
        AppMethodBeat.o(114054);
        return postDelayed;
    }

    public static boolean s(Runnable runnable) {
        AppMethodBeat.i(114055);
        PP().eGj.mExecutorService.execute(runnable);
        AppMethodBeat.o(114055);
        return true;
    }
}
