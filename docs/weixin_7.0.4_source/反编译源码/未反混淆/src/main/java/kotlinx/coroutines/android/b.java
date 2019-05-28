package kotlinx.coroutines.android;

import a.c.e;
import a.f.b.j;
import a.f.b.k;
import a.h.h;
import a.l;
import a.y;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.aj;
import kotlinx.coroutines.i;

@l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010 \u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"})
public final class b extends c implements aj {
    private volatile b BQX;
    private final b BQY;
    private final boolean BQZ;
    private final Handler handler;
    private final String name;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    static final class b extends k implements a.f.a.b<Throwable, y> {
        final /* synthetic */ b BRa;
        final /* synthetic */ Runnable BRc;

        b(b bVar, Runnable runnable) {
            this.BRa = bVar;
            this.BRc = runnable;
            super(1);
        }

        public final /* synthetic */ Object am(Object obj) {
            AppMethodBeat.i(118258);
            this.BRa.handler.removeCallbacks(this.BRc);
            y yVar = y.AUy;
            AppMethodBeat.o(118258);
            return yVar;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"})
    public static final class a implements Runnable {
        final /* synthetic */ b BRa;
        final /* synthetic */ i BRb;

        public a(b bVar, i iVar) {
            this.BRa = bVar;
            this.BRb = iVar;
        }

        public final void run() {
            AppMethodBeat.i(118255);
            this.BRb.a(this.BRa, y.AUy);
            AppMethodBeat.o(118255);
        }
    }

    private b(Handler handler, String str, boolean z) {
        super();
        AppMethodBeat.i(118253);
        this.handler = handler;
        this.name = str;
        this.BQZ = z;
        this.BQX = this.BQZ ? this : null;
        b bVar = this.BQX;
        if (bVar == null) {
            bVar = new b(this.handler, this.name, true);
            this.BQX = bVar;
        }
        this.BQY = bVar;
        AppMethodBeat.o(118253);
    }

    public b(Handler handler, String str) {
        j.p(handler, "handler");
        this(handler, str, false);
        AppMethodBeat.i(118254);
        AppMethodBeat.o(118254);
    }

    public final boolean b(e eVar) {
        AppMethodBeat.i(118248);
        j.p(eVar, "context");
        if (this.BQZ && (j.j(Looper.myLooper(), this.handler.getLooper()) ^ 1) == 0) {
            AppMethodBeat.o(118248);
            return false;
        }
        AppMethodBeat.o(118248);
        return true;
    }

    public final void a(e eVar, Runnable runnable) {
        AppMethodBeat.i(118249);
        j.p(eVar, "context");
        j.p(runnable, "block");
        this.handler.post(runnable);
        AppMethodBeat.o(118249);
    }

    public final String toString() {
        AppMethodBeat.i(118251);
        String handler;
        if (this.name == null) {
            handler = this.handler.toString();
            j.o(handler, "handler.toString()");
            AppMethodBeat.o(118251);
            return handler;
        } else if (this.BQZ) {
            handler = this.name + " [immediate]";
            AppMethodBeat.o(118251);
            return handler;
        } else {
            handler = this.name;
            AppMethodBeat.o(118251);
            return handler;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof b) && ((b) obj).handler == this.handler;
    }

    public final int hashCode() {
        AppMethodBeat.i(118252);
        int identityHashCode = System.identityHashCode(this.handler);
        AppMethodBeat.o(118252);
        return identityHashCode;
    }

    public final void a(i<? super y> iVar) {
        AppMethodBeat.i(118250);
        j.p(iVar, "continuation");
        Runnable aVar = new a(this, iVar);
        this.handler.postDelayed(aVar, h.aj(1000, 4611686018427387903L));
        iVar.h(new b(this, aVar));
        AppMethodBeat.o(118250);
    }
}
