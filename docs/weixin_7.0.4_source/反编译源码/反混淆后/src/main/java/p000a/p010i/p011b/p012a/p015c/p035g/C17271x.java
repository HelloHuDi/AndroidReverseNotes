package p000a.p010i.p011b.p012a.p015c.p035g;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: a.i.b.a.c.g.x */
public final class C17271x extends AbstractList<String> implements C37026o, RandomAccess {
    private final C37026o BAK;

    /* renamed from: a.i.b.a.c.g.x$2 */
    class C172722 implements Iterator<String> {
        Iterator<String> BzK = C17271x.this.BAK.iterator();

        C172722() {
            AppMethodBeat.m2504i(121674);
            AppMethodBeat.m2505o(121674);
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(121675);
            boolean hasNext = this.BzK.hasNext();
            AppMethodBeat.m2505o(121675);
            return hasNext;
        }

        public final void remove() {
            AppMethodBeat.m2504i(121676);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(121676);
            throw unsupportedOperationException;
        }

        public final /* bridge */ /* synthetic */ Object next() {
            AppMethodBeat.m2504i(121677);
            String str = (String) this.BzK.next();
            AppMethodBeat.m2505o(121677);
            return str;
        }
    }

    public C17271x(C37026o c37026o) {
        this.BAK = c37026o;
    }

    public final int size() {
        AppMethodBeat.m2504i(121678);
        int size = this.BAK.size();
        AppMethodBeat.m2505o(121678);
        return size;
    }

    /* renamed from: UC */
    public final C31710d mo31352UC(int i) {
        AppMethodBeat.m2504i(121679);
        C31710d UC = this.BAK.mo31352UC(i);
        AppMethodBeat.m2505o(121679);
        return UC;
    }

    /* renamed from: e */
    public final void mo31353e(C31710d c31710d) {
        AppMethodBeat.m2504i(121680);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(121680);
        throw unsupportedOperationException;
    }

    public final ListIterator<String> listIterator(final int i) {
        AppMethodBeat.m2504i(121681);
        C81891 c81891 = new ListIterator<String>() {
            ListIterator<String> BAL = C17271x.this.BAK.listIterator(i);

            public final boolean hasNext() {
                AppMethodBeat.m2504i(121665);
                boolean hasNext = this.BAL.hasNext();
                AppMethodBeat.m2505o(121665);
                return hasNext;
            }

            public final boolean hasPrevious() {
                AppMethodBeat.m2504i(121666);
                boolean hasPrevious = this.BAL.hasPrevious();
                AppMethodBeat.m2505o(121666);
                return hasPrevious;
            }

            public final int nextIndex() {
                AppMethodBeat.m2504i(121667);
                int nextIndex = this.BAL.nextIndex();
                AppMethodBeat.m2505o(121667);
                return nextIndex;
            }

            public final int previousIndex() {
                AppMethodBeat.m2504i(121668);
                int previousIndex = this.BAL.previousIndex();
                AppMethodBeat.m2505o(121668);
                return previousIndex;
            }

            public final void remove() {
                AppMethodBeat.m2504i(121669);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.m2505o(121669);
                throw unsupportedOperationException;
            }

            public final /* synthetic */ void add(Object obj) {
                AppMethodBeat.m2504i(121670);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.m2505o(121670);
                throw unsupportedOperationException;
            }

            public final /* synthetic */ void set(Object obj) {
                AppMethodBeat.m2504i(121671);
                UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
                AppMethodBeat.m2505o(121671);
                throw unsupportedOperationException;
            }

            public final /* bridge */ /* synthetic */ Object previous() {
                AppMethodBeat.m2504i(121672);
                String str = (String) this.BAL.previous();
                AppMethodBeat.m2505o(121672);
                return str;
            }

            public final /* bridge */ /* synthetic */ Object next() {
                AppMethodBeat.m2504i(121673);
                String str = (String) this.BAL.next();
                AppMethodBeat.m2505o(121673);
                return str;
            }
        };
        AppMethodBeat.m2505o(121681);
        return c81891;
    }

    public final Iterator<String> iterator() {
        AppMethodBeat.m2504i(121682);
        C172722 c172722 = new C172722();
        AppMethodBeat.m2505o(121682);
        return c172722;
    }

    public final List<?> eiz() {
        AppMethodBeat.m2504i(121683);
        List eiz = this.BAK.eiz();
        AppMethodBeat.m2505o(121683);
        return eiz;
    }

    public final C37026o eiA() {
        return this;
    }

    public final /* bridge */ /* synthetic */ Object get(int i) {
        AppMethodBeat.m2504i(121684);
        String str = (String) this.BAK.get(i);
        AppMethodBeat.m2505o(121684);
        return str;
    }
}
