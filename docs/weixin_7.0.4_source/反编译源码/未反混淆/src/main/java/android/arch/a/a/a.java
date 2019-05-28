package android.arch.a.a;

import java.util.concurrent.Executor;

public class a extends c {
    private static volatile a bL;
    private static final Executor bO = new Executor() {
        public final void execute(Runnable runnable) {
            a.Y().d(runnable);
        }
    };
    private static final Executor bP = new Executor() {
        public final void execute(Runnable runnable) {
            a.Y().c(runnable);
        }
    };
    public c bM = this.bN;
    private c bN = new b();

    private a() {
    }

    public static a Y() {
        if (bL != null) {
            return bL;
        }
        synchronized (a.class) {
            if (bL == null) {
                bL = new a();
            }
        }
        return bL;
    }

    public final void c(Runnable runnable) {
        this.bM.c(runnable);
    }

    public final void d(Runnable runnable) {
        this.bM.d(runnable);
    }

    public final boolean isMainThread() {
        return this.bM.isMainThread();
    }
}
