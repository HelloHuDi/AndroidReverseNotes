package android.arch.p1150a.p1151a;

import java.util.concurrent.Executor;

/* renamed from: android.arch.a.a.a */
public class C24631a extends C17361c {
    /* renamed from: bL */
    private static volatile C24631a f4902bL;
    /* renamed from: bO */
    private static final Executor f4903bO = new C173591();
    /* renamed from: bP */
    private static final Executor f4904bP = new C173602();
    /* renamed from: bM */
    public C17361c f4905bM = this.f4906bN;
    /* renamed from: bN */
    private C17361c f4906bN = new C25281b();

    /* renamed from: android.arch.a.a.a$1 */
    static class C173591 implements Executor {
        C173591() {
        }

        public final void execute(Runnable runnable) {
            C24631a.m38318Y().mo31436d(runnable);
        }
    }

    /* renamed from: android.arch.a.a.a$2 */
    static class C173602 implements Executor {
        C173602() {
        }

        public final void execute(Runnable runnable) {
            C24631a.m38318Y().mo31435c(runnable);
        }
    }

    private C24631a() {
    }

    /* renamed from: Y */
    public static C24631a m38318Y() {
        if (f4902bL != null) {
            return f4902bL;
        }
        synchronized (C24631a.class) {
            if (f4902bL == null) {
                f4902bL = new C24631a();
            }
        }
        return f4902bL;
    }

    /* renamed from: c */
    public final void mo31435c(Runnable runnable) {
        this.f4905bM.mo31435c(runnable);
    }

    /* renamed from: d */
    public final void mo31436d(Runnable runnable) {
        this.f4905bM.mo31436d(runnable);
    }

    public final boolean isMainThread() {
        return this.f4905bM.isMainThread();
    }
}
