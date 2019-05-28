package a.a;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Enumeration;
import java.util.Iterator;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u000e\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0002¨\u0006\u0004"}, dWq = {"iterator", "", "T", "Ljava/util/Enumeration;", "kotlin-stdlib"}, dWr = 1)
public class n extends m {

    @l(dWo = {1, 1, 13}, dWp = {"\u0000\u0013\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\t\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u0004\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, dWq = {"kotlin/collections/CollectionsKt__IteratorsJVMKt$iterator$1", "", "hasNext", "", "next", "()Ljava/lang/Object;", "kotlin-stdlib"})
    public static final class a implements a.f.b.a.a, Iterator<T> {
        final /* synthetic */ Enumeration AUL;

        public final void remove() {
            AppMethodBeat.i(56162);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
            AppMethodBeat.o(56162);
            throw unsupportedOperationException;
        }

        public a(Enumeration<T> enumeration) {
            this.AUL = enumeration;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(56160);
            boolean hasMoreElements = this.AUL.hasMoreElements();
            AppMethodBeat.o(56160);
            return hasMoreElements;
        }

        public final T next() {
            AppMethodBeat.i(56161);
            Object nextElement = this.AUL.nextElement();
            AppMethodBeat.o(56161);
            return nextElement;
        }
    }
}
