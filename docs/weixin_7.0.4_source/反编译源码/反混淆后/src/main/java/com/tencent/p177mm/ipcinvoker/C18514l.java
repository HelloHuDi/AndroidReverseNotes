package com.tencent.p177mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ipcinvoker.l */
public class C18514l {
    private static volatile C18514l eGh;
    private Handler eGi;
    private C18515m eGj;
    private Handler mHandler;
    private HandlerThread mHandlerThread = new HandlerThread("ThreadCaller#Worker-" + hashCode());

    /* renamed from: PP */
    private static C18514l m28818PP() {
        AppMethodBeat.m2504i(114049);
        if (eGh == null) {
            synchronized (C18514l.class) {
                try {
                    if (eGh == null) {
                        eGh = new C18514l();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114049);
                    }
                }
            }
        }
        C18514l c18514l = eGh;
        AppMethodBeat.m2505o(114049);
        return c18514l;
    }

    private C18514l() {
        AppMethodBeat.m2504i(114050);
        this.mHandlerThread.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.eGi = new Handler(Looper.getMainLooper());
        this.eGj = C18515m.m28823PR();
        AppMethodBeat.m2505o(114050);
    }

    public static boolean post(Runnable runnable) {
        AppMethodBeat.m2504i(114051);
        boolean post = C18514l.m28818PP().mHandler.post(runnable);
        AppMethodBeat.m2505o(114051);
        return post;
    }

    public static boolean postDelayed(Runnable runnable, long j) {
        AppMethodBeat.m2504i(114052);
        boolean postDelayed = C18514l.m28818PP().mHandler.postDelayed(runnable, j);
        AppMethodBeat.m2505o(114052);
        return postDelayed;
    }

    /* renamed from: q */
    public static boolean m28819q(Runnable runnable) {
        AppMethodBeat.m2504i(114053);
        boolean post = C18514l.m28818PP().eGi.post(runnable);
        AppMethodBeat.m2505o(114053);
        return post;
    }

    /* renamed from: r */
    public static boolean m28820r(Runnable runnable) {
        AppMethodBeat.m2504i(114054);
        boolean postDelayed = C18514l.m28818PP().eGi.postDelayed(runnable, 100);
        AppMethodBeat.m2505o(114054);
        return postDelayed;
    }

    /* renamed from: s */
    public static boolean m28821s(Runnable runnable) {
        AppMethodBeat.m2504i(114055);
        C18514l.m28818PP().eGj.mExecutorService.execute(runnable);
        AppMethodBeat.m2505o(114055);
        return true;
    }
}
