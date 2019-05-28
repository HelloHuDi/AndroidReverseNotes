package a.j;

import a.f.a.b;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B1\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0002\u0010\bJ\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lkotlin/sequences/FilteringSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "sendWhen", "", "predicate", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;ZLkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
public final class e<T> implements h<T> {
    final h<T> BOr;
    final boolean BOu;
    final b<T, Boolean> BOv;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, dWq = {"kotlin/sequences/FilteringSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    public static final class a implements a.f.b.a.a, Iterator<T> {
        private final Iterator<T> AUT;
        private int BOw = -1;
        private T BOx;
        final /* synthetic */ e BOy;

        public final void remove() {
            AppMethodBeat.i(55957);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(55957);
            throw unsupportedOperationException;
        }

        a(e eVar) {
            this.BOy = eVar;
            AppMethodBeat.i(55956);
            this.AUT = eVar.BOr.iterator();
            AppMethodBeat.o(55956);
        }

        private final void ekK() {
            AppMethodBeat.i(55953);
            while (this.AUT.hasNext()) {
                Object next = this.AUT.next();
                if (((Boolean) this.BOy.BOv.am(next)).booleanValue() == this.BOy.BOu) {
                    this.BOx = next;
                    this.BOw = 1;
                    AppMethodBeat.o(55953);
                    return;
                }
            }
            this.BOw = 0;
            AppMethodBeat.o(55953);
        }

        public final T next() {
            AppMethodBeat.i(55954);
            if (this.BOw == -1) {
                ekK();
            }
            if (this.BOw == 0) {
                Throwable noSuchElementException = new NoSuchElementException();
                AppMethodBeat.o(55954);
                throw noSuchElementException;
            }
            Object obj = this.BOx;
            this.BOx = null;
            this.BOw = -1;
            AppMethodBeat.o(55954);
            return obj;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(55955);
            if (this.BOw == -1) {
                ekK();
            }
            if (this.BOw == 1) {
                AppMethodBeat.o(55955);
                return true;
            }
            AppMethodBeat.o(55955);
            return false;
        }
    }

    public e(h<? extends T> hVar, boolean z, b<? super T, Boolean> bVar) {
        j.p(hVar, "sequence");
        j.p(bVar, "predicate");
        AppMethodBeat.i(55923);
        this.BOr = hVar;
        this.BOu = z;
        this.BOv = bVar;
        AppMethodBeat.o(55923);
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.i(55922);
        Iterator aVar = new a(this);
        AppMethodBeat.o(55922);
        return aVar;
    }
}
