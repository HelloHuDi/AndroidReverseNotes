package p000a.p050j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;
import p000a.C0220l;
import p000a.p005f.p006a.C17126b;
import p000a.p005f.p007b.C25052j;
import p000a.p005f.p007b.p1144a.C41374a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, dWq = {"Lkotlin/sequences/TakeWhileSequence;", "T", "Lkotlin/sequences/Sequence;", "sequence", "predicate", "Lkotlin/Function1;", "", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)V", "iterator", "", "kotlin-stdlib"})
/* renamed from: a.j.o */
public final class C0214o<T> implements C44937h<T> {
    final C44937h<T> BOr;
    final C17126b<T, Boolean> BOv;

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000#\n\u0000\n\u0002\u0010(\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\t\u0010\u0013\u001a\u00020\u0014H\u0002J\u000e\u0010\u0015\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004R\u001e\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, dWq = {"kotlin/sequences/TakeWhileSequence$iterator$1", "", "iterator", "getIterator", "()Ljava/util/Iterator;", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "nextState", "", "getNextState", "()I", "setNextState", "(I)V", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"})
    /* renamed from: a.j.o$a */
    public static final class C0215a implements C41374a, Iterator<T> {
        private final Iterator<T> AUT;
        final /* synthetic */ C0214o BON;
        private int BOw = -1;
        private T BOx;

        public final void remove() {
            AppMethodBeat.m2504i(55918);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.m2505o(55918);
            throw unsupportedOperationException;
        }

        C0215a(C0214o c0214o) {
            this.BON = c0214o;
            AppMethodBeat.m2504i(55917);
            this.AUT = c0214o.BOr.iterator();
            AppMethodBeat.m2505o(55917);
        }

        private final void ekK() {
            AppMethodBeat.m2504i(55914);
            if (this.AUT.hasNext()) {
                Object next = this.AUT.next();
                if (((Boolean) this.BON.BOv.mo50am(next)).booleanValue()) {
                    this.BOw = 1;
                    this.BOx = next;
                    AppMethodBeat.m2505o(55914);
                    return;
                }
            }
            this.BOw = 0;
            AppMethodBeat.m2505o(55914);
        }

        public final T next() {
            AppMethodBeat.m2504i(55915);
            if (this.BOw == -1) {
                ekK();
            }
            if (this.BOw == 0) {
                Throwable noSuchElementException = new NoSuchElementException();
                AppMethodBeat.m2505o(55915);
                throw noSuchElementException;
            }
            Object obj = this.BOx;
            this.BOx = null;
            this.BOw = -1;
            AppMethodBeat.m2505o(55915);
            return obj;
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(55916);
            if (this.BOw == -1) {
                ekK();
            }
            if (this.BOw == 1) {
                AppMethodBeat.m2505o(55916);
                return true;
            }
            AppMethodBeat.m2505o(55916);
            return false;
        }
    }

    public C0214o(C44937h<? extends T> c44937h, C17126b<? super T, Boolean> c17126b) {
        C25052j.m39376p(c44937h, "sequence");
        C25052j.m39376p(c17126b, "predicate");
        AppMethodBeat.m2504i(55976);
        this.BOr = c44937h;
        this.BOv = c17126b;
        AppMethodBeat.m2505o(55976);
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.m2504i(55975);
        Iterator c0215a = new C0215a(this);
        AppMethodBeat.m2505o(55975);
        return c0215a;
    }
}
