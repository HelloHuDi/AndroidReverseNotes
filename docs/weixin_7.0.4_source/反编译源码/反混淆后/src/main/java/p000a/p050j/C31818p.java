package p000a.p050j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import p000a.C0220l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.p1144a.C41374a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010(\n\u0002\b\u0002\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u0003B'\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0002\u0010\u0007J3\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\t0\u0003\"\u0004\b\u0002\u0010\t2\u0018\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\t0\u000b0\u0006H\u0000¢\u0006\u0002\b\fJ\u000f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, dWq = {"Lkotlin/sequences/TransformingSequence;", "T", "R", "Lkotlin/sequences/Sequence;", "sequence", "transformer", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "flatten", "E", "iterator", "", "flatten$kotlin_stdlib", "kotlin-stdlib"})
/* renamed from: a.j.p */
public final class C31818p<T, R> implements C44937h<R> {
    public final C44937h<T> BOr;
    public final C17126b<T, R> BOz;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0015\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\t"}, dWq = {"kotlin/sequences/TransformingSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    /* renamed from: a.j.p$a */
    public static final class C17352a implements C41374a, Iterator<R> {
        private final Iterator<T> AUT;
        final /* synthetic */ C31818p BOO;

        public final void remove() {
            AppMethodBeat.m2504i(55969);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.m2505o(55969);
            throw unsupportedOperationException;
        }

        C17352a(C31818p c31818p) {
            this.BOO = c31818p;
            AppMethodBeat.m2504i(55968);
            this.AUT = c31818p.BOr.iterator();
            AppMethodBeat.m2505o(55968);
        }

        public final R next() {
            AppMethodBeat.m2504i(55966);
            Object am = this.BOO.BOz.mo50am(this.AUT.next());
            AppMethodBeat.m2505o(55966);
            return am;
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(55967);
            boolean hasNext = this.AUT.hasNext();
            AppMethodBeat.m2505o(55967);
            return hasNext;
        }
    }

    public C31818p(C44937h<? extends T> c44937h, C17126b<? super T, ? extends R> c17126b) {
        C25052j.m39376p(c44937h, "sequence");
        C25052j.m39376p(c17126b, "transformer");
        AppMethodBeat.m2504i(55937);
        this.BOr = c44937h;
        this.BOz = c17126b;
        AppMethodBeat.m2505o(55937);
    }

    public final Iterator<R> iterator() {
        AppMethodBeat.m2504i(55936);
        Iterator c17352a = new C17352a(this);
        AppMethodBeat.m2505o(55936);
        return c17352a;
    }
}
