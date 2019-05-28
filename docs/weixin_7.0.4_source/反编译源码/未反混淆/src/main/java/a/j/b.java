package a.j;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lkotlin/sequences/DropSequence;", "T", "Lkotlin/sequences/Sequence;", "Lkotlin/sequences/DropTakeSequence;", "sequence", "count", "", "(Lkotlin/sequences/Sequence;I)V", "drop", "n", "iterator", "", "take", "kotlin-stdlib"})
public final class b<T> implements c<T>, h<T> {
    final h<T> BOr;
    final int count;

    @l(dWo = {1, 1, 13}, dWp = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u000eH\u0002J\u000e\u0010\u000f\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, dWq = {"kotlin/sequences/DropSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "left", "", "getLeft", "()I", "setLeft", "(I)V", "drop", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class a implements a.f.b.a.a, Iterator<T> {
        private final Iterator<T> AUT;
        final /* synthetic */ b BOs;
        private int left;

        public final void remove() {
            AppMethodBeat.i(55964);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(55964);
            throw unsupportedOperationException;
        }

        a(b bVar) {
            this.BOs = bVar;
            AppMethodBeat.i(55963);
            this.AUT = bVar.BOr.iterator();
            this.left = bVar.count;
            AppMethodBeat.o(55963);
        }

        private final void drop() {
            AppMethodBeat.i(55960);
            while (this.left > 0 && this.AUT.hasNext()) {
                this.AUT.next();
                this.left--;
            }
            AppMethodBeat.o(55960);
        }

        public final T next() {
            AppMethodBeat.i(55961);
            drop();
            Object next = this.AUT.next();
            AppMethodBeat.o(55961);
            return next;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(55962);
            drop();
            boolean hasNext = this.AUT.hasNext();
            AppMethodBeat.o(55962);
            return hasNext;
        }
    }

    public b(h<? extends T> hVar, int i) {
        j.p(hVar, "sequence");
        AppMethodBeat.i(55972);
        this.BOr = hVar;
        this.count = i;
        if ((this.count >= 0 ? 1 : null) == null) {
            Throwable illegalArgumentException = new IllegalArgumentException(("count must be non-negative, but was " + this.count + '.').toString());
            AppMethodBeat.o(55972);
            throw illegalArgumentException;
        }
        AppMethodBeat.o(55972);
    }

    public final h<T> ekJ() {
        AppMethodBeat.i(55970);
        int i = this.count + 1;
        if (i < 0) {
            h bVar = new b(this, 1);
            AppMethodBeat.o(55970);
            return bVar;
        }
        h<T> bVar2 = new b(this.BOr, i);
        AppMethodBeat.o(55970);
        return bVar2;
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.i(55971);
        Iterator aVar = new a(this);
        AppMethodBeat.o(55971);
        return aVar;
    }
}
