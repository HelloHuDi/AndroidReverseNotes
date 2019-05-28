package p000a.p001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.p1144a.C41374a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0005J\t\u0010\b\u001a\u00020\tH\u0002J\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, dWq = {"Lkotlin/collections/IndexingIterator;", "T", "", "Lkotlin/collections/IndexedValue;", "iterator", "(Ljava/util/Iterator;)V", "index", "", "hasNext", "", "next", "kotlin-stdlib"})
/* renamed from: a.a.aa */
public final class C31584aa<T> implements C41374a, Iterator<C41364y<? extends T>> {
    private final Iterator<T> AUT;
    private int index;

    public final void remove() {
        AppMethodBeat.m2504i(56028);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.m2505o(56028);
        throw unsupportedOperationException;
    }

    public C31584aa(Iterator<? extends T> it) {
        C25052j.m39376p(it, "iterator");
        AppMethodBeat.m2504i(56027);
        this.AUT = it;
        AppMethodBeat.m2505o(56027);
    }

    public final boolean hasNext() {
        AppMethodBeat.m2504i(56025);
        boolean hasNext = this.AUT.hasNext();
        AppMethodBeat.m2505o(56025);
        return hasNext;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.m2504i(56026);
        int i = this.index;
        this.index = i + 1;
        if (i < 0) {
            C7987l.dWs();
        }
        C41364y c41364y = new C41364y(i, this.AUT.next());
        AppMethodBeat.m2505o(56026);
        return c41364y;
    }
}
