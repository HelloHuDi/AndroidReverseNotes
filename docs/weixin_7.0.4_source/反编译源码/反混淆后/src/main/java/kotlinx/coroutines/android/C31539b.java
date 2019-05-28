package kotlinx.coroutines.android;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.C24594i;
import kotlinx.coroutines.C31186aj;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p002c.C41366e;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;
import p000a.p009h.C0016h;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001c\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0013\u0010\u0016\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u001c\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0016J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u001e\u0010 \u001a\u00020\u00102\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"H\u0016J\b\u0010#\u001a\u00020\u0006H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, dWq = {"Lkotlinx/coroutines/android/HandlerContext;", "Lkotlinx/coroutines/android/HandlerDispatcher;", "Lkotlinx/coroutines/Delay;", "handler", "Landroid/os/Handler;", "name", "", "(Landroid/os/Handler;Ljava/lang/String;)V", "invokeImmediately", "", "(Landroid/os/Handler;Ljava/lang/String;Z)V", "_immediate", "immediate", "getImmediate", "()Lkotlinx/coroutines/android/HandlerContext;", "dispatch", "", "context", "Lkotlin/coroutines/CoroutineContext;", "block", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "equals", "other", "", "hashCode", "", "invokeOnTimeout", "Lkotlinx/coroutines/DisposableHandle;", "timeMillis", "", "isDispatchNeeded", "scheduleResumeAfterDelay", "continuation", "Lkotlinx/coroutines/CancellableContinuation;", "toString", "kotlinx-coroutines-android"})
/* renamed from: kotlinx.coroutines.android.b */
public final class C31539b extends C24588c implements C31186aj {
    private volatile C31539b BQX;
    private final C31539b BQY;
    private final boolean BQZ;
    private final Handler handler;
    private final String name;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, dWq = {"<anonymous>", "", "it", "", "invoke"})
    /* renamed from: kotlinx.coroutines.android.b$b */
    static final class C6100b extends C25053k implements C17126b<Throwable, C37091y> {
        final /* synthetic */ C31539b BRa;
        final /* synthetic */ Runnable BRc;

        C6100b(C31539b c31539b, Runnable runnable) {
            this.BRa = c31539b;
            this.BRc = runnable;
            super(1);
        }

        /* renamed from: am */
        public final /* synthetic */ Object mo50am(Object obj) {
            AppMethodBeat.m2504i(118258);
            this.BRa.handler.removeCallbacks(this.BRc);
            C37091y c37091y = C37091y.AUy;
            AppMethodBeat.m2505o(118258);
            return c37091y;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, dWq = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"})
    /* renamed from: kotlinx.coroutines.android.b$a */
    public static final class C16449a implements Runnable {
        final /* synthetic */ C31539b BRa;
        final /* synthetic */ C24594i BRb;

        public C16449a(C31539b c31539b, C24594i c24594i) {
            this.BRa = c31539b;
            this.BRb = c24594i;
        }

        public final void run() {
            AppMethodBeat.m2504i(118255);
            this.BRb.mo41382a(this.BRa, C37091y.AUy);
            AppMethodBeat.m2505o(118255);
        }
    }

    private C31539b(Handler handler, String str, boolean z) {
        super();
        AppMethodBeat.m2504i(118253);
        this.handler = handler;
        this.name = str;
        this.BQZ = z;
        this.BQX = this.BQZ ? this : null;
        C31539b c31539b = this.BQX;
        if (c31539b == null) {
            c31539b = new C31539b(this.handler, this.name, true);
            this.BQX = c31539b;
        }
        this.BQY = c31539b;
        AppMethodBeat.m2505o(118253);
    }

    public C31539b(Handler handler, String str) {
        C25052j.m39376p(handler, "handler");
        this(handler, str, false);
        AppMethodBeat.m2504i(118254);
        AppMethodBeat.m2505o(118254);
    }

    /* renamed from: b */
    public final boolean mo41387b(C41366e c41366e) {
        AppMethodBeat.m2504i(118248);
        C25052j.m39376p(c41366e, "context");
        if (this.BQZ && (C25052j.m39373j(Looper.myLooper(), this.handler.getLooper()) ^ 1) == 0) {
            AppMethodBeat.m2505o(118248);
            return false;
        }
        AppMethodBeat.m2505o(118248);
        return true;
    }

    /* renamed from: a */
    public final void mo30313a(C41366e c41366e, Runnable runnable) {
        AppMethodBeat.m2504i(118249);
        C25052j.m39376p(c41366e, "context");
        C25052j.m39376p(runnable, "block");
        this.handler.post(runnable);
        AppMethodBeat.m2505o(118249);
    }

    public final String toString() {
        AppMethodBeat.m2504i(118251);
        String handler;
        if (this.name == null) {
            handler = this.handler.toString();
            C25052j.m39375o(handler, "handler.toString()");
            AppMethodBeat.m2505o(118251);
            return handler;
        } else if (this.BQZ) {
            handler = this.name + " [immediate]";
            AppMethodBeat.m2505o(118251);
            return handler;
        } else {
            handler = this.name;
            AppMethodBeat.m2505o(118251);
            return handler;
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C31539b) && ((C31539b) obj).handler == this.handler;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(118252);
        int identityHashCode = System.identityHashCode(this.handler);
        AppMethodBeat.m2505o(118252);
        return identityHashCode;
    }

    /* renamed from: a */
    public final void mo30314a(C24594i<? super C37091y> c24594i) {
        AppMethodBeat.m2504i(118250);
        C25052j.m39376p(c24594i, "continuation");
        Runnable c16449a = new C16449a(this, c24594i);
        this.handler.postDelayed(c16449a, C0016h.m16aj(1000, 4611686018427387903L));
        c24594i.mo41383h(new C6100b(this, c16449a));
        AppMethodBeat.m2505o(118250);
    }
}
