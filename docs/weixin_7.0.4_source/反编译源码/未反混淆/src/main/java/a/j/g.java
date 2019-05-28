package a.j;

import a.f.a.b;
import a.f.b.j;
import a.l;
import a.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B+\u0012\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002R\u0016\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0005X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lkotlin/sequences/GeneratorSequence;", "T", "", "Lkotlin/sequences/Sequence;", "getInitialValue", "Lkotlin/Function0;", "getNextValue", "Lkotlin/Function1;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
final class g<T> implements h<T> {
    final a.f.a.a<T> BOD;
    final b<T, T> BOE;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\t\u0010\u0010\u001a\u00020\u0011H\u0002J\u000e\u0010\u0012\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0002\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0007\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0013"}, dWq = {"kotlin/sequences/GeneratorSequence$iterator$1", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    public static final class a implements a.f.b.a.a, Iterator<T> {
        final /* synthetic */ g BOF;
        private int BOw = -2;
        private T BOx;

        public final void remove() {
            AppMethodBeat.i(55935);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(55935);
            throw unsupportedOperationException;
        }

        a(g gVar) {
            this.BOF = gVar;
        }

        private final void ekK() {
            Object invoke;
            AppMethodBeat.i(55932);
            if (this.BOw == -2) {
                invoke = this.BOF.BOD.invoke();
            } else {
                b bVar = this.BOF.BOE;
                Object obj = this.BOx;
                if (obj == null) {
                    j.dWJ();
                }
                invoke = bVar.am(obj);
            }
            this.BOx = invoke;
            this.BOw = this.BOx == null ? 0 : 1;
            AppMethodBeat.o(55932);
        }

        public final T next() {
            AppMethodBeat.i(55933);
            if (this.BOw < 0) {
                ekK();
            }
            if (this.BOw == 0) {
                Throwable noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(55933);
                throw noSuchElementException;
            }
            Object obj = this.BOx;
            if (obj == null) {
                v vVar = new v("null cannot be cast to non-null type T");
                AppMethodBeat.o(55933);
                throw vVar;
            }
            this.BOw = -1;
            AppMethodBeat.o(55933);
            return obj;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(55934);
            if (this.BOw < 0) {
                ekK();
            }
            if (this.BOw == 1) {
                AppMethodBeat.o(55934);
                return true;
            }
            AppMethodBeat.o(55934);
            return false;
        }
    }

    public g(a.f.a.a<? extends T> aVar, b<? super T, ? extends T> bVar) {
        j.p(aVar, "getInitialValue");
        j.p(bVar, "getNextValue");
        AppMethodBeat.i(55959);
        this.BOD = aVar;
        this.BOE = bVar;
        AppMethodBeat.o(55959);
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.i(55958);
        Iterator aVar = new a(this);
        AppMethodBeat.o(55958);
        return aVar;
    }
}
