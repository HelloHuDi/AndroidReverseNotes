package kotlinx.coroutines;

import a.f.b.j;
import a.f.b.k;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.a.p;

@l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\bJ\u0012\u0010\u0012\u001a\u00020\b2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014J\u001f\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\bR \u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lkotlinx/coroutines/UndispatchedEventLoop;", "", "()V", "threadLocalEventLoop", "Lkotlinx/coroutines/internal/ThreadLocalWithInitialValue;", "Lkotlinx/coroutines/UndispatchedEventLoop$EventLoop;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "execute", "", "continuation", "Lkotlinx/coroutines/DispatchedContinuation;", "contState", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeUndispatched", "task", "Lkotlinx/coroutines/DispatchedTask;", "runEventLoop", "eventLoop", "EventLoop", "kotlinx-coroutines-core"})
public final class bu {
    public static final p<a> BQS = new p(b.BQV);
    public static final bu BQT = new bu();

    @l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lkotlinx/coroutines/UndispatchedEventLoop$EventLoop;", "", "isActive", "", "queue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(ZLkotlinx/coroutines/internal/ArrayQueue;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"})
    public static final class a {
        public final kotlinx.coroutines.a.b<Runnable> BQU;
        public boolean csi;

        /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            if (a.f.b.j.j(r5.BQU, r6.BQU) != false) goto L_0x0023;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.i(118486);
            if (this != obj) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    if (this.csi == aVar.csi) {
                    }
                }
                AppMethodBeat.o(118486);
                return false;
            }
            AppMethodBeat.o(118486);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.i(118485);
            int i = this.csi;
            if (i != 0) {
                i = 1;
            }
            int i2 = i * 31;
            kotlinx.coroutines.a.b bVar = this.BQU;
            i = (bVar != null ? bVar.hashCode() : 0) + i2;
            AppMethodBeat.o(118485);
            return i;
        }

        public final String toString() {
            AppMethodBeat.i(118484);
            String str = "EventLoop(isActive=" + this.csi + ", queue=" + this.BQU + ")";
            AppMethodBeat.o(118484);
            return str;
        }

        private a(kotlinx.coroutines.a.b<Runnable> bVar) {
            j.p(bVar, "queue");
            AppMethodBeat.i(118482);
            this.csi = false;
            this.BQU = bVar;
            AppMethodBeat.o(118482);
        }

        public /* synthetic */ a() {
            this(new kotlinx.coroutines.a.b());
            AppMethodBeat.i(118483);
            AppMethodBeat.o(118483);
        }
    }

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lkotlinx/coroutines/UndispatchedEventLoop$EventLoop;", "invoke"})
    static final class b extends k implements a.f.a.a<a> {
        public static final b BQV = new b();

        static {
            AppMethodBeat.i(118548);
            AppMethodBeat.o(118548);
        }

        b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.i(118547);
            a aVar = new a();
            AppMethodBeat.o(118547);
            return aVar;
        }
    }

    static {
        AppMethodBeat.i(118499);
        AppMethodBeat.o(118499);
    }

    private bu() {
    }

    public static boolean a(an<?> anVar) {
        AppMethodBeat.i(118498);
        j.p(anVar, "task");
        a aVar = (a) BQS.get();
        if (aVar.csi) {
            aVar.BQU.addLast(anVar);
            AppMethodBeat.o(118498);
            return true;
        }
        j.o(aVar, "eventLoop");
        try {
            aVar.csi = true;
            am.a(anVar, anVar.ekR(), 3);
            while (true) {
                Runnable runnable = (Runnable) aVar.BQU.elE();
                if (runnable == null) {
                    aVar.csi = false;
                    AppMethodBeat.o(118498);
                    return false;
                }
                runnable.run();
            }
        } catch (Throwable th) {
            aVar.csi = false;
            AppMethodBeat.o(118498);
        }
    }
}
