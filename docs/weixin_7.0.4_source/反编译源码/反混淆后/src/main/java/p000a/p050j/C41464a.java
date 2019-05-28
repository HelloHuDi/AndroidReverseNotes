package p000a.p050j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002R(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0007*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"})
/* renamed from: a.j.a */
public final class C41464a<T> implements C44937h<T> {
    private final AtomicReference<C44937h<T>> BOq;

    public C41464a(C44937h<? extends T> c44937h) {
        C25052j.m39376p(c44937h, "sequence");
        AppMethodBeat.m2504i(55952);
        this.BOq = new AtomicReference(c44937h);
        AppMethodBeat.m2505o(55952);
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.m2504i(55951);
        C44937h c44937h = (C44937h) this.BOq.getAndSet(null);
        if (c44937h == null) {
            Throwable illegalStateException = new IllegalStateException("This sequence can be consumed only once.");
            AppMethodBeat.m2505o(55951);
            throw illegalStateException;
        }
        Iterator it = c44937h.iterator();
        AppMethodBeat.m2505o(55951);
        return it;
    }
}
