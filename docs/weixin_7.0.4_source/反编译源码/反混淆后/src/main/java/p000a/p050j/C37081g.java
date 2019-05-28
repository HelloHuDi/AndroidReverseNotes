package p000a.p050j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p000a.C0220l;
import p000a.C44941v;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.p1144a.C41374a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
/* renamed from: a.j.g */
final class C37081g<T> implements C44937h<T> {
    final C31214a<T> BOD;
    final C17126b<T, T> BOE;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, dWq = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    /* renamed from: a.j.g$a */
    public static final class C17347a implements C41374a, Iterator<T> {
        final /* synthetic */ C37081g BOF;
        private int BOw = -2;
        private T BOx;

        public final void remove() {
            AppMethodBeat.m2504i(55935);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.m2505o(55935);
            throw unsupportedOperationException;
        }

        C17347a(C37081g c37081g) {
            this.BOF = c37081g;
        }

        private final void ekK() {
            Object invoke;
            AppMethodBeat.m2504i(55932);
            if (this.BOw == -2) {
                invoke = this.BOF.BOD.invoke();
            } else {
                C17126b c17126b = this.BOF.BOE;
                Object obj = this.BOx;
                if (obj == null) {
                    C25052j.dWJ();
                }
                invoke = c17126b.mo50am(obj);
            }
            this.BOx = invoke;
            this.BOw = this.BOx == null ? 0 : 1;
            AppMethodBeat.m2505o(55932);
        }

        public final T next() {
            AppMethodBeat.m2504i(55933);
            if (this.BOw < 0) {
                ekK();
            }
            if (this.BOw == 0) {
                Throwable noSuchElementException = new NoSuchElementException();
                AppMethodBeat.m2505o(55933);
                throw noSuchElementException;
            }
            Object obj = this.BOx;
            if (obj == null) {
                C44941v c44941v = new C44941v("null cannot be cast to non-null type T");
                AppMethodBeat.m2505o(55933);
                throw c44941v;
            }
            this.BOw = -1;
            AppMethodBeat.m2505o(55933);
            return obj;
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(55934);
            if (this.BOw < 0) {
                ekK();
            }
            if (this.BOw == 1) {
                AppMethodBeat.m2505o(55934);
                return true;
            }
            AppMethodBeat.m2505o(55934);
            return false;
        }
    }

    public C37081g(C31214a<? extends T> c31214a, C17126b<? super T, ? extends T> c17126b) {
        C25052j.m39376p(c31214a, "getInitialValue");
        C25052j.m39376p(c17126b, "getNextValue");
        AppMethodBeat.m2504i(55959);
        this.BOD = c31214a;
        this.BOE = c17126b;
        AppMethodBeat.m2505o(55959);
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.m2504i(55958);
        Iterator c17347a = new C17347a(this);
        AppMethodBeat.m2505o(55958);
        return c17347a;
    }
}
