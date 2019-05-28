package com.tencent.mm.plugin.appbrand.s;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.atomic.AtomicBoolean;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u00012\u00020\u0002:\u0001\nB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "Ljava/lang/Runnable;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "mRunnable", "(Ljava/lang/Runnable;)V", "mDead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dead", "", "run", "Companion", "luggage-wxa-app_release"})
public final class p implements com.tencent.mm.vending.e.a, Runnable {
    @Deprecated
    public static final a iRD = new a();
    private final AtomicBoolean iRC = new AtomicBoolean(false);
    private final Runnable mRunnable;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\u0007"}, dWq = {"Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable$Companion;", "", "()V", "obtain", "Lcom/tencent/mm/plugin/appbrand/utils/LifeCycleWrappedRunnable;", "runnable", "Ljava/lang/Runnable;", "luggage-wxa-app_release"})
    static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    static {
        AppMethodBeat.i(87595);
        AppMethodBeat.o(87595);
    }

    private p(Runnable runnable) {
        AppMethodBeat.i(87594);
        this.mRunnable = runnable;
        AppMethodBeat.o(87594);
    }

    public final void run() {
        AppMethodBeat.i(87592);
        if (!this.iRC.get()) {
            Runnable runnable = this.mRunnable;
            if (runnable != null) {
                runnable.run();
                AppMethodBeat.o(87592);
                return;
            }
        }
        AppMethodBeat.o(87592);
    }

    public final void dead() {
        AppMethodBeat.i(87593);
        this.iRC.set(true);
        AppMethodBeat.o(87593);
    }

    public static final p O(Runnable runnable) {
        AppMethodBeat.i(87596);
        if (runnable instanceof p) {
            p pVar = (p) runnable;
            AppMethodBeat.o(87596);
            return pVar;
        }
        p pVar2 = new p(runnable);
        AppMethodBeat.o(87596);
        return pVar2;
    }
}
