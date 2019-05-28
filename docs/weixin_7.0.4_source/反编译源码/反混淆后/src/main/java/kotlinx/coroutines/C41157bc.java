package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.C31196x.C31197a;
import p000a.C0220l;
import p000a.C37091y;
import p000a.p002c.C41366e.C36928c;
import p000a.p002c.C41366e.C41367b;
import p000a.p005f.p006a.C17126b;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H'J\b\u0010\u0013\u001a\u00020\u0014H&J\u0014\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'J\r\u0010\u0017\u001a\u00020\u0007H\u0017¢\u0006\u0002\b\u0013J\f\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH'JE\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140 j\u0002`#H'J1\u0010\u001b\u001a\u00020\u001c2'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140 j\u0002`#H&J\u0011\u0010$\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\u0002J\b\u0010(\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, dWq = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "cancel0", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bc */
public interface C41157bc extends C41367b {
    public static final C31188b BQx = C31188b.BQy;

    @C0220l(dWo = {1, 1, 13})
    /* renamed from: kotlinx.coroutines.bc$a */
    public static final class C16454a {
        /* renamed from: a */
        public static /* synthetic */ C41155ap m25237a(C41157bc c41157bc, boolean z, boolean z2, C17126b c17126b, int i) {
            AppMethodBeat.m2504i(118473);
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            C41155ap a = c41157bc.mo30329a(z, z2, c17126b);
            AppMethodBeat.m2505o(118473);
            return a;
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, dWq = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.bc$b */
    public static final class C31188b implements C36928c<C41157bc> {
        static final /* synthetic */ C31188b BQy = new C31188b();

        static {
            AppMethodBeat.m2504i(118504);
            C31197a c31197a = C31196x.BPJ;
            AppMethodBeat.m2505o(118504);
        }

        private C31188b() {
        }
    }

    /* renamed from: a */
    C41155ap mo30329a(boolean z, boolean z2, C17126b<? super Throwable, C37091y> c17126b);

    /* renamed from: a */
    C44622m mo30330a(C31194o c31194o);

    CancellationException els();

    boolean isActive();

    boolean start();

    /* renamed from: y */
    boolean mo30344y(Throwable th);
}
