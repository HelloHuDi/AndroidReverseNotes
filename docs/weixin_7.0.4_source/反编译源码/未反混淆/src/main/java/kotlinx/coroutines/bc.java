package kotlinx.coroutines;

import a.c.e.c;
import a.l;
import a.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CancellationException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 )2\u00020\u0001:\u0001)J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H'J\b\u0010\u0013\u001a\u00020\u0014H&J\u0014\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016H'J\r\u0010\u0017\u001a\u00020\u0007H\u0017¢\u0006\u0002\b\u0013J\f\u0010\u0018\u001a\u00060\u0019j\u0002`\u001aH'JE\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00072\b\b\u0002\u0010\u001e\u001a\u00020\u00072'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140 j\u0002`#H'J1\u0010\u001b\u001a\u00020\u001c2'\u0010\u001f\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0016¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00140 j\u0002`#H&J\u0011\u0010$\u001a\u00020\u0014H¦@ø\u0001\u0000¢\u0006\u0002\u0010%J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0000H\u0002J\b\u0010(\u001a\u00020\u0007H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00000\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0012\u0010\u000b\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, dWq = {"Lkotlinx/coroutines/Job;", "Lkotlin/coroutines/CoroutineContext$Element;", "children", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "isActive", "", "()Z", "isCancelled", "isCompleted", "onJoin", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "attachChild", "Lkotlinx/coroutines/ChildHandle;", "child", "Lkotlinx/coroutines/ChildJob;", "cancel", "", "cause", "", "cancel0", "getCancellationException", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "invokeOnCompletion", "Lkotlinx/coroutines/DisposableHandle;", "onCancelling", "invokeImmediately", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "join", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plus", "other", "start", "Key", "kotlinx-coroutines-core"})
public interface bc extends a.c.e.b {
    public static final b BQx = b.BQy;

    @l(dWo = {1, 1, 13})
    public static final class a {
        public static /* synthetic */ ap a(bc bcVar, boolean z, boolean z2, a.f.a.b bVar, int i) {
            AppMethodBeat.i(118473);
            if ((i & 1) != 0) {
                z = false;
            }
            if ((i & 2) != 0) {
                z2 = true;
            }
            ap a = bcVar.a(z, z2, bVar);
            AppMethodBeat.o(118473);
            return a;
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, dWq = {"Lkotlinx/coroutines/Job$Key;", "Lkotlin/coroutines/CoroutineContext$Key;", "Lkotlinx/coroutines/Job;", "()V", "kotlinx-coroutines-core"})
    public static final class b implements c<bc> {
        static final /* synthetic */ b BQy = new b();

        static {
            AppMethodBeat.i(118504);
            kotlinx.coroutines.x.a aVar = x.BPJ;
            AppMethodBeat.o(118504);
        }

        private b() {
        }
    }

    ap a(boolean z, boolean z2, a.f.a.b<? super Throwable, y> bVar);

    m a(o oVar);

    CancellationException els();

    boolean isActive();

    boolean start();

    boolean y(Throwable th);
}
