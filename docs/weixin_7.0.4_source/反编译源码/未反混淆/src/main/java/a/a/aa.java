package a.a;

import a.f.b.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0002J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"})
public final class aa<T> implements a, Iterator<y<? extends T>> {
    private final Iterator<T> AUT;
    private int index;

    public final void remove() {
        AppMethodBeat.i(56028);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56028);
        throw unsupportedOperationException;
    }

    public aa(Iterator<? extends T> it) {
        j.p(it, "iterator");
        AppMethodBeat.i(56027);
        this.AUT = it;
        AppMethodBeat.o(56027);
    }

    public final boolean hasNext() {
        AppMethodBeat.i(56025);
        boolean hasNext = this.AUT.hasNext();
        AppMethodBeat.o(56025);
        return hasNext;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.i(56026);
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            l.dWs();
        }
        y yVar = new y(i, this.AUT.next());
        AppMethodBeat.o(56026);
        return yVar;
    }
}
