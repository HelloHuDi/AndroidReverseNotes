package p000a.p001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import p000a.C0220l;
import p000a.p005f.p006a.C31214a;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.p1144a.C41374a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00030\u0002B\u0019\u0012\u0012\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005¢\u0006\u0002\u0010\u0007J\u0015\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00030\u0006H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, dWq = {"Lkotlin/collections/IndexingIterable;", "T", "", "Lkotlin/collections/IndexedValue;", "iteratorFactory", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "iterator", "kotlin-stdlib"})
/* renamed from: a.a.z */
public final class C44630z<T> implements C41374a, Iterable<C41364y<? extends T>> {
    private final C31214a<Iterator<T>> AUS;

    public C44630z(C31214a<? extends Iterator<? extends T>> c31214a) {
        C25052j.m39376p(c31214a, "iteratorFactory");
        AppMethodBeat.m2504i(56067);
        this.AUS = c31214a;
        AppMethodBeat.m2505o(56067);
    }

    public final Iterator<C41364y<T>> iterator() {
        AppMethodBeat.m2504i(56066);
        Iterator c31584aa = new C31584aa((Iterator) this.AUS.invoke());
        AppMethodBeat.m2505o(56066);
        return c31584aa;
    }
}
