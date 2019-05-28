package com.tencent.p177mm.ipcinvoker;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p1383a.C45410b;
import com.tencent.p177mm.ipcinvoker.p1384g.C37870a;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.tencent.mm.ipcinvoker.m */
class C18515m {
    private static volatile C18515m eGk;
    private static C45410b eGl = new C18517a();
    ExecutorService mExecutorService = eGl.mo33757PS();
    private Handler mHandler;

    /* renamed from: com.tencent.mm.ipcinvoker.m$a */
    static class C18517a implements C45410b {
        private int eGo = 3;
        HandlerThread mHandlerThread;

        /* renamed from: com.tencent.mm.ipcinvoker.m$a$3 */
        class C95543 implements RejectedExecutionHandler {
            C95543() {
            }

            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                AppMethodBeat.m2504i(114061);
                C26340b.m41918w("IPC.ExecutorServiceCreatorImpl", "on rejectedExecution(r : %s)", runnable);
                AppMethodBeat.m2505o(114061);
            }
        }

        /* renamed from: com.tencent.mm.ipcinvoker.m$a$1 */
        class C185201 implements ThreadFactory {
            int index = 0;

            C185201() {
            }

            public final Thread newThread(final Runnable runnable) {
                AppMethodBeat.m2504i(114058);
                StringBuilder stringBuilder = new StringBuilder("ThreadPool#Thread-");
                int i = this.index;
                this.index = i + 1;
                Thread thread = new Thread(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(114057);
                        ThreadLocal threadLocal = (ThreadLocal) new C37870a(Looper.class, "sThreadLocal").mo60592PV();
                        if (threadLocal == null || threadLocal.get() != null) {
                            C26340b.m41915d("IPC.ExecutorServiceCreatorImpl", "ThreadLocal Looper variable is null or has set.(%s)", threadLocal);
                        } else {
                            C26340b.m41915d("IPC.ExecutorServiceCreatorImpl", "create a new Looper ThreadLocal variable.", new Object[0]);
                            threadLocal.set(C18517a.this.mHandlerThread.getLooper());
                        }
                        runnable.run();
                        AppMethodBeat.m2505o(114057);
                    }
                }, stringBuilder.append(i).toString());
                C26340b.m41917i("IPC.ExecutorServiceCreatorImpl", "newThread(thread : %s)", r0);
                AppMethodBeat.m2505o(114058);
                return thread;
            }
        }

        C18517a() {
            AppMethodBeat.m2504i(114062);
            HandlerThread handlerThread = new HandlerThread("ThreadPool#InnerWorkerThread-" + hashCode());
            handlerThread.start();
            C26340b.m41917i("IPC.ExecutorServiceCreatorImpl", "createHandlerThread(hash : %d)", Integer.valueOf(handlerThread.hashCode()));
            this.mHandlerThread = handlerThread;
            AppMethodBeat.m2505o(114062);
        }

        /* renamed from: PS */
        public final ExecutorService mo33757PS() {
            AppMethodBeat.m2504i(114063);
            C185182 c185182 = new ScheduledThreadPoolExecutor(this.eGo, new C185201()) {
                public final void execute(final Runnable runnable) {
                    AppMethodBeat.m2504i(114060);
                    super.execute(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(114059);
                            try {
                                runnable.run();
                                AppMethodBeat.m2505o(114059);
                            } catch (Throwable th) {
                                UncaughtExceptionHandler uncaughtExceptionHandler = Thread.currentThread().getUncaughtExceptionHandler();
                                if (uncaughtExceptionHandler == null) {
                                    uncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                                }
                                if (uncaughtExceptionHandler != null) {
                                    uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
                                }
                                AppMethodBeat.m2505o(114059);
                            }
                        }
                    });
                    AppMethodBeat.m2505o(114060);
                }
            };
            c185182.setMaximumPoolSize((int) (((double) this.eGo) * 1.5d));
            c185182.setRejectedExecutionHandler(new C95543());
            AppMethodBeat.m2505o(114063);
            return c185182;
        }
    }

    static {
        AppMethodBeat.m2504i(114069);
        AppMethodBeat.m2505o(114069);
    }

    /* renamed from: PQ */
    private static C18515m m28822PQ() {
        AppMethodBeat.m2504i(114064);
        if (eGk == null) {
            synchronized (C18515m.class) {
                try {
                    if (eGk == null) {
                        eGk = new C18515m();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114064);
                    }
                }
            }
        }
        C18515m c18515m = eGk;
        AppMethodBeat.m2505o(114064);
        return c18515m;
    }

    /* renamed from: PR */
    static C18515m m28823PR() {
        AppMethodBeat.m2504i(114065);
        C18515m c18515m = new C18515m();
        AppMethodBeat.m2505o(114065);
        return c18515m;
    }

    private C18515m() {
        AppMethodBeat.m2504i(114066);
        final HandlerThread handlerThread = new HandlerThread("ThreadPool#WorkerThread-" + hashCode());
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        handler.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(114056);
                C26340b.m41917i("IPC.ThreadPool", "createHandlerThread(id : %d)", Integer.valueOf(handlerThread.getThreadId()));
                AppMethodBeat.m2505o(114056);
            }
        });
        this.mHandler = handler;
        C26340b.m41917i("IPC.ThreadPool", "initialize IPCInvoker ThreadPool(hashCode : %s)", Integer.valueOf(hashCode()));
        AppMethodBeat.m2505o(114066);
    }

    public static boolean post(Runnable runnable) {
        AppMethodBeat.m2504i(114067);
        C18515m.m28822PQ().mExecutorService.execute(runnable);
        AppMethodBeat.m2505o(114067);
        return true;
    }

    /* renamed from: t */
    public static boolean m28824t(Runnable runnable) {
        AppMethodBeat.m2504i(114068);
        boolean postDelayed = C18515m.m28822PQ().mHandler.postDelayed(runnable, FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        AppMethodBeat.m2505o(114068);
        return postDelayed;
    }
}
