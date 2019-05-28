package a.a;

import a.f.b.a.a;
import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lkotlin/collections/IndexingIterable;", "T", "", "Lkotlin/collections/IndexedValue;", "iteratorFactory", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "kotlin-stdlib"})
public final class z<T> implements a, Iterable<y<? extends T>> {
    private final a.f.a.a<Iterator<T>> AUS;

    public z(a.f.a.a<? extends Iterator<? extends T>> aVar) {
        j.p(aVar, "iteratorFactory");
        AppMethodBeat.i(56067);
        this.AUS = aVar;
        AppMethodBeat.o(56067);
    }

    public final Iterator<y<T>> iterator() {
        AppMethodBeat.i(56066);
        Iterator aaVar = new aa((Iterator) this.AUS.invoke());
        AppMethodBeat.o(56066);
        return aaVar;
    }
}
