package a.j;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\u0010\u0004J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002R(\u0010\u0005\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000 \u0007*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lkotlin/sequences/ConstrainedOnceSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "(Lkotlin/sequences/Sequence;)V", "sequenceRef", "Ljava/util/concurrent/atomic/AtomicReference;", "kotlin.jvm.PlatformType", "iterator", "", "kotlin-stdlib"})
public final class a<T> implements h<T> {
    private final AtomicReference<h<T>> BOq;

    public a(h<? extends T> hVar) {
        j.p(hVar, "sequence");
        AppMethodBeat.i(55952);
        this.BOq = new AtomicReference(hVar);
        AppMethodBeat.o(55952);
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.i(55951);
        h hVar = (h) this.BOq.getAndSet(null);
        if (hVar == null) {
            Throwable illegalStateException = new IllegalStateException("This sequence can be consumed only once.");
            AppMethodBeat.o(55951);
            throw illegalStateException;
        }
        Iterator it = hVar.iterator();
        AppMethodBeat.o(55951);
        return it;
    }
}
