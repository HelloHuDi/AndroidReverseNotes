package a.i.b.a.c.g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class x extends AbstractList<String> implements o, RandomAccess {
    private final o BAK;

    public x(o oVar) {
        this.BAK = oVar;
    }

    public final int size() {
        AppMethodBeat.i(121678);
        int size = this.BAK.size();
        AppMethodBeat.o(121678);
        return size;
    }

    public final d UC(int i) {
        AppMethodBeat.i(121679);
        d UC = this.BAK.UC(i);
        AppMethodBeat.o(121679);
        return UC;
    }

    public final void e(d dVar) {
        AppMethodBeat.i(121680);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(121680);
        throw unsupportedOperationException;
    }

    public final ListIterator<String> listIterator(final int i) {
        AppMethodBeat.i(121681);
        AnonymousClass1 anonymousClass1 = new ListIterator<String>() {
            ListIterator<String> BAL = x.this.BAK.listIterator(i);

            public final boolean hasNext() {
                AppMethodBeat.i(121665);
                boolean hasNext = this.BAL.hasNext();
                AppMethodBeat.o(121665);
                return hasNext;
            }

            public final boolean hasPrevious() {
                AppMethodBeat.i(121666);
                boolean hasPrevious = this.BAL.hasPrevious();
                AppMethodBeat.o(121666);
                return hasPrevious;
            }

            public final int nextIndex() {
                AppMethodBeat.i(121667);
                int nextIndex = this.BAL.nextIndex();
                AppMethodBeat.o(121667);
                return nextIndex;
            }

            public final int previousIndex() {
                AppMethodBeat.i(121668);
                int previousIndex = this.BAL.previousIndex();
                AppMethodBeat.o(121668);
                return previousIndex;
            }

            public final void remove() {
                AppMethodBeat.i(121669);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(121669);
                throw unsupportedOperationException;
            }

            public final /* synthetic */ void add(Object obj) {
                AppMethodBeat.i(121670);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(121670);
                throw unsupportedOperationException;
            }

            public final /* synthetic */ void set(Object obj) {
                AppMethodBeat.i(121671);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(121671);
                throw unsupportedOperationException;
            }

            public final /* bridge */ /* synthetic */ Object previous() {
                AppMethodBeat.i(121672);
                String str = (String) this.BAL.previous();
                AppMethodBeat.o(121672);
                return str;
            }

            public final /* bridge */ /* synthetic */ Object next() {
                AppMethodBeat.i(121673);
                String str = (String) this.BAL.next();
                AppMethodBeat.o(121673);
                return str;
            }
        };
        AppMethodBeat.o(121681);
        return anonymousClass1;
    }

    public final Iterator<String> iterator() {
        AppMethodBeat.i(121682);
        AnonymousClass2 anonymousClass2 = new Iterator<String>() {
            Iterator<String> BzK = x.this.BAK.iterator();

            {
                AppMethodBeat.i(121674);
                AppMethodBeat.o(121674);
            }

            public final boolean hasNext() {
                AppMethodBeat.i(121675);
                boolean hasNext = this.BzK.hasNext();
                AppMethodBeat.o(121675);
                return hasNext;
            }

            public final void remove() {
                AppMethodBeat.i(121676);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.o(121676);
                throw unsupportedOperationException;
            }

            public final /* bridge */ /* synthetic */ Object next() {
                AppMethodBeat.i(121677);
                String str = (String) this.BzK.next();
                AppMethodBeat.o(121677);
                return str;
            }
        };
        AppMethodBeat.o(121682);
        return anonymousClass2;
    }

    public final List<?> eiz() {
        AppMethodBeat.i(121683);
        List eiz = this.BAK.eiz();
        AppMethodBeat.o(121683);
        return eiz;
    }

    public final o eiA() {
        return this;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        AppMethodBeat.i(121684);
        String str = (String) this.BAK.get(i);
        AppMethodBeat.o(121684);
        return str;
    }
}
