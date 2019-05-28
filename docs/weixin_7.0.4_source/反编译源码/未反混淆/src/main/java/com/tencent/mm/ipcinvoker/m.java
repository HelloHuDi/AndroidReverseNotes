package com.tencent.mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.a.b;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

class m {
    private static volatile m eGk;
    private static b eGl = new a();
    ExecutorService mExecutorService = eGl.PS();
    private Handler mHandler;

    static class a implements b {
        private int eGo = 3;
        HandlerThread mHandlerThread;

        a() {
            AppMethodBeat.i(114062);
            HandlerThread handlerThread = new HandlerThread("ThreadPool#InnerWorkerThread-" + hashCode());
            handlerThread.start();
            com.tencent.mm.ipcinvoker.h.b.i("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", Integer.valueOf(handlerThread.hashCode()));
            this.mHandlerThread = handlerThread;
            AppMethodBeat.o(114062);
        }

        public final ExecutorService PS() {
            AppMethodBeat.i(114063);
            AnonymousClass2 anonymousClass2 = new ScheduledThreadPoolExecutor(this.eGo, new ThreadFactory() {
                int index = 0;

                public final Thread newThread(final Runnable runnable) {
                    AppMethodBeat.i(114058);
                    StringBuilder stringBuilder = new StringBuilder("ThreadPool#Thread-");
                    int i = this.index;
                    this.index = i + 1;
                    Thread thread = new Thread(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(114057);
                            ThreadLocal threadLocal = (ThreadLocal) new com.tencent.mm.ipcinvoker.g.a(Looper.class, "sThreadLocal").PV();
                            if (threadLocal == null || threadLocal.get() != null) {
                                com.tencent.mm.ipcinvoker.h.b.d("IPC.ExecutorServiceCreatorImpl", "ThreadLocal Looper variable is null or has set.(%s)", threadLocal);
                            } else {
                                com.tencent.mm.ipcinvoker.h.b.d("IPC.ExecutorServiceCreatorImpl", "create a new Looper ThreadLocal variable.", new Object[0]);
                                threadLocal.set(a.this.mHandlerThread.getLooper());
                            }
                            runnable.run();
                            AppMethodBeat.o(114057);
                        }
                    }, stringBuilder.append(i).toString());
                    com.tencent.mm.ipcinvoker.h.b.i("IPC.ExecutorServiceCreatorImpl", "newThread(thread : %s)", r0);
                    AppMethodBeat.o(114058);
                    return thread;
                }
            }) {
                public final void execute(final Runnable runnable) {
                    AppMethodBeat.i(114060);
                    super.execute(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(114059);
                            try {
                                runnable.run();
                                AppMethodBeat.o(114059);
                            } catch (Throwable th) {
                                UncaughtExceptionHandler uncaughtExceptionHandler = Thread.currentThread().getUncaughtExceptionHandler();
                                if (uncaughtExceptionHandler == null) {
                                    uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                                }
                                if (uncaughtExceptionHandler != null) {
                                    uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
                                }
                                AppMethodBeat.o(114059);
                            }
                        }
                    });
                    AppMethodBeat.o(114060);
                }
            };
            anonymousClass2.setMaximumPoolSize((int) (((double) this.eGo) * 1.5d));
            anonymousClass2.setRejectedExecutionHandler(new RejectedExecutionHandler() {
                public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                    AppMethodBeat.i(114061);
                    com.tencent.mm.ipcinvoker.h.b.w("IPC.ExecutorServiceCreatorImpl", "on rejectedExecution(r : %s)", runnable);
                    AppMethodBeat.o(114061);
                }
            });
            AppMethodBeat.o(114063);
            return anonymousClass2;
        }
    }

    static {
        AppMethodBeat.i(114069);
        AppMethodBeat.o(114069);
    }

    private static m PQ() {
        AppMethodBeat.i(114064);
        if (eGk == null) {
            synchronized (m.class) {
                try {
                    if (eGk == null) {
                        eGk = new m();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(114064);
                    }
                }
            }
        }
        m mVar = eGk;
        AppMethodBeat.o(114064);
        return mVar;
    }

    static m PR() {
        AppMethodBeat.i(114065);
        m mVar = new m();
        AppMethodBeat.o(114065);
        return mVar;
    }

    private m() {
        AppMethodBeat.i(114066);
        final HandlerThread handlerThread = new HandlerThread("ThreadPool#WorkerThread-" + hashCode());
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(114056);
                com.tencent.mm.ipcinvoker.h.b.i("IPC.ThreadPool", "createHandlerThread(id : %d)", Integer.valueOf(handlerThread.getThreadId()));
                AppMethodBeat.o(114056);
            }
        });
        this.mHandler = handler;
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ThreadPool", "initialize IPCInvoker ThreadPool(hashCode : %s)", Integer.valueOf(hashCode()));
        AppMethodBeat.o(114066);
    }

    public static boolean post(Runnable runnable) {
        AppMethodBeat.i(114067);
        PQ().mExecutorService.execute(runnable);
        AppMethodBeat.o(114067);
        return true;
    }

    public static boolean t(Runnable runnable) {
        AppMethodBeat.i(114068);
        boolean postDelayed = PQ().mHandler.postDelayed(runnable, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.o(114068);
        return postDelayed;
    }
}
