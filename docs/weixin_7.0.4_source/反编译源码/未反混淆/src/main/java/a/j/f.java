package a.j;

import a.f.a.b;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004BA\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007¢\u0006\u0002\u0010\nJ\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\tH\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lkotlin/sequences/FlatteningSequence;", "T", "R", "E", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "iterator", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "kotlin-stdlib"})
public final class f<T, R, E> implements h<E> {
    final b<R, Iterator<E>> BOA;
    final h<T> BOr;
    final b<T, R> BOz;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\rR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0004¨\u0006\u000e"}, dWq = {"kotlin/sequences/FlatteningSequence$iterator$1", "", "itemIterator", "getItemIterator", "()Ljava/util/Iterator;", "setItemIterator", "(Ljava/util/Iterator;)V", "iterator", "getIterator", "ensureItemIterator", "", "hasNext", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class a implements a.f.b.a.a, Iterator<E> {
        private final Iterator<T> AUT;
        private Iterator<? extends E> BOB;
        final /* synthetic */ f BOC;

        public final void remove() {
            AppMethodBeat.i(55928);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(55928);
            throw unsupportedOperationException;
        }

        a(f fVar) {
            this.BOC = fVar;
            AppMethodBeat.i(55927);
            this.AUT = fVar.BOr.iterator();
            AppMethodBeat.o(55927);
        }

        public final E next() {
            AppMethodBeat.i(55924);
            if (ekL()) {
                Iterator it = this.BOB;
                if (it == null) {
                    j.dWJ();
                }
                Object next = it.next();
                AppMethodBeat.o(55924);
                return next;
            }
            Throwable noSuchElementException = new NoSuchElementException();
            AppMethodBeat.o(55924);
            throw noSuchElementException;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(55925);
            boolean ekL = ekL();
            AppMethodBeat.o(55925);
            return ekL;
        }

        private final boolean ekL() {
            AppMethodBeat.i(55926);
            Iterator it = this.BOB;
            if (!(it == null || it.hasNext())) {
                this.BOB = null;
            }
            while (this.BOB == null) {
                if (this.AUT.hasNext()) {
                    it = (Iterator) this.BOC.BOA.am(this.BOC.BOz.am(this.AUT.next()));
                    if (it.hasNext()) {
                        this.BOB = it;
                        AppMethodBeat.o(55926);
                        return true;
                    }
                }
                AppMethodBeat.o(55926);
                return false;
            }
            AppMethodBeat.o(55926);
            return true;
        }
    }

    public f(h<? extends T> hVar, b<? super T, ? extends R> bVar, b<? super R, ? extends Iterator<? extends E>> bVar2) {
        j.p(hVar, "sequence");
        j.p(bVar, "transformer");
        j.p(bVar2, "iterator");
        AppMethodBeat.i(55931);
        this.BOr = hVar;
        this.BOz = bVar;
        this.BOA = bVar2;
        AppMethodBeat.o(55931);
    }

    public final Iterator<E> iterator() {
        AppMethodBeat.i(55930);
        Iterator aVar = new a(this);
        AppMethodBeat.o(55930);
        return aVar;
    }
}
