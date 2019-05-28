package p000a.p001a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Enumeration;
import java.util.Iterator;
import p000a.C0220l;
import p000a.p005f.p007b.p1144a.C41374a;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0002¨\u0006\u0004"}, dWq = {"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, dWr = 1)
/* renamed from: a.a.n */
public class C7988n extends C25034m {

    @C0220l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    /* renamed from: a.a.n$a */
    public static final class C7989a implements C41374a, Iterator<T> {
        final /* synthetic */ Enumeration AUL;

        public final void remove() {
            AppMethodBeat.m2504i(56162);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.m2505o(56162);
            throw unsupportedOperationException;
        }

        public C7989a(Enumeration<T> enumeration) {
            this.AUL = enumeration;
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(56160);
            boolean hasMoreElements = this.AUL.hasMoreElements();
            AppMethodBeat.m2505o(56160);
            return hasMoreElements;
        }

        public final T next() {
            AppMethodBeat.m2504i(56161);
            Object nextElement = this.AUL.nextElement();
            AppMethodBeat.m2505o(56161);
            return nextElement;
        }
    }
}
