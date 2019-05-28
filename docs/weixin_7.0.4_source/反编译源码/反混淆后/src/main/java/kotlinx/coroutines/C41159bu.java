package kotlinx.coroutines;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlinx.coroutines.p700a.C16446b;
import kotlinx.coroutines.p700a.C44609p;
import p000a.C0220l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.C25053k;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J?\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\bJ\u0012\u0010\u0012\u001a\u00020\b2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u0014J\u001f\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00052\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\bR \u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u00068\u0000X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, dWq = {"Lkotlinx/coroutines/UndispatchedEventLoop;", "", "()V", "threadLocalEventLoop", "Lkotlinx/coroutines/internal/ThreadLocalWithInitialValue;", "Lkotlinx/coroutines/UndispatchedEventLoop$EventLoop;", "Lkotlinx/coroutines/internal/CommonThreadLocal;", "execute", "", "continuation", "Lkotlinx/coroutines/DispatchedContinuation;", "contState", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeUndispatched", "task", "Lkotlinx/coroutines/DispatchedTask;", "runEventLoop", "eventLoop", "EventLoop", "kotlinx-coroutines-core"})
/* renamed from: kotlinx.coroutines.bu */
public final class C41159bu {
    public static final C44609p<C24590a> BQS = new C44609p(C24591b.BQV);
    public static final C41159bu BQT = new C41159bu();

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005¢\u0006\u0002\u0010\bJ\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005HÆ\u0003J'\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0012\b\u0002\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u0005HÆ\u0001J\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\f\u0012\b\u0012\u00060\u0006j\u0002`\u00070\u00058\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lkotlinx/coroutines/UndispatchedEventLoop$EventLoop;", "", "isActive", "", "queue", "Lkotlinx/coroutines/internal/ArrayQueue;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "(ZLkotlinx/coroutines/internal/ArrayQueue;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "kotlinx-coroutines-core"})
    /* renamed from: kotlinx.coroutines.bu$a */
    public static final class C24590a {
        public final C16446b<Runnable> BQU;
        public boolean csi;

        /* JADX WARNING: Missing block: B:9:0x0021, code skipped:
            if (p000a.p005f.p007b.C25052j.m39373j(r5.BQU, r6.BQU) != false) goto L_0x0023;
     */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(118486);
            if (this != obj) {
                if (obj instanceof C24590a) {
                    C24590a c24590a = (C24590a) obj;
                    if (this.csi == c24590a.csi) {
                    }
                }
                AppMethodBeat.m2505o(118486);
                return false;
            }
            AppMethodBeat.m2505o(118486);
            return true;
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(118485);
            int i = this.csi;
            if (i != 0) {
                i = 1;
            }
            int i2 = i * 31;
            C16446b c16446b = this.BQU;
            i = (c16446b != null ? c16446b.hashCode() : 0) + i2;
            AppMethodBeat.m2505o(118485);
            return i;
        }

        public final String toString() {
            AppMethodBeat.m2504i(118484);
            String str = "EventLoop(isActive=" + this.csi + ", queue=" + this.BQU + ")";
            AppMethodBeat.m2505o(118484);
            return str;
        }

        private C24590a(C16446b<Runnable> c16446b) {
            C25052j.m39376p(c16446b, "queue");
            AppMethodBeat.m2504i(118482);
            this.csi = false;
            this.BQU = c16446b;
            AppMethodBeat.m2505o(118482);
        }

        public /* synthetic */ C24590a() {
            this(new C16446b());
            AppMethodBeat.m2504i(118483);
            AppMethodBeat.m2505o(118483);
        }
    }

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, dWq = {"<anonymous>", "Lkotlinx/coroutines/UndispatchedEventLoop$EventLoop;", "invoke"})
    /* renamed from: kotlinx.coroutines.bu$b */
    static final class C24591b extends C25053k implements C31214a<C24590a> {
        public static final C24591b BQV = new C24591b();

        static {
            AppMethodBeat.m2504i(118548);
            AppMethodBeat.m2505o(118548);
        }

        C24591b() {
            super(0);
        }

        public final /* synthetic */ Object invoke() {
            AppMethodBeat.m2504i(118547);
            C24590a c24590a = new C24590a();
            AppMethodBeat.m2505o(118547);
            return c24590a;
        }
    }

    static {
        AppMethodBeat.m2504i(118499);
        AppMethodBeat.m2505o(118499);
    }

    private C41159bu() {
    }

    /* renamed from: a */
    public static boolean m71592a(C46846an<?> c46846an) {
        AppMethodBeat.m2504i(118498);
        C25052j.m39376p(c46846an, "task");
        C24590a c24590a = (C24590a) BQS.get();
        if (c24590a.csi) {
            c24590a.BQU.addLast(c46846an);
            AppMethodBeat.m2505o(118498);
            return true;
        }
        C25052j.m39375o(c24590a, "eventLoop");
        try {
            c24590a.csi = true;
            C16448am.m25227a(c46846an, c46846an.ekR(), 3);
            while (true) {
                Runnable runnable = (Runnable) c24590a.BQU.elE();
                if (runnable == null) {
                    c24590a.csi = false;
                    AppMethodBeat.m2505o(118498);
                    return false;
                }
                runnable.run();
            }
        } catch (Throwable th) {
            c24590a.csi = false;
            AppMethodBeat.m2505o(118498);
        }
    }
}
