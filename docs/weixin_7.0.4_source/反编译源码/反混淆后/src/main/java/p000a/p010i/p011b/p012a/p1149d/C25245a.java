package p000a.p010i.p011b.p012a.p1149d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* renamed from: a.i.b.a.d.a */
public final class C25245a<E> implements Iterable<E> {
    private static final C25245a<Object> BNy = new C25245a();
    public final C25245a<E> BNz;
    public final E first;
    public final int size;

    /* renamed from: a.i.b.a.d.a$a */
    static class C25246a<E> implements Iterator<E> {
        private C25245a<E> BNA;

        public C25246a(C25245a<E> c25245a) {
            this.BNA = c25245a;
        }

        public final boolean hasNext() {
            AppMethodBeat.m2504i(122979);
            if (this.BNA.size > 0) {
                AppMethodBeat.m2505o(122979);
                return true;
            }
            AppMethodBeat.m2505o(122979);
            return false;
        }

        public final E next() {
            Object obj = this.BNA.first;
            this.BNA = this.BNA.BNz;
            return obj;
        }

        public final void remove() {
            AppMethodBeat.m2504i(122980);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.m2505o(122980);
            throw unsupportedOperationException;
        }
    }

    static {
        AppMethodBeat.m2504i(122989);
        AppMethodBeat.m2505o(122989);
    }

    public static <E> C25245a<E> ekE() {
        return BNy;
    }

    private C25245a() {
        this.size = 0;
        this.first = null;
        this.BNz = null;
    }

    private C25245a(E e, C25245a<E> c25245a) {
        AppMethodBeat.m2504i(122981);
        this.first = e;
        this.BNz = c25245a;
        this.size = c25245a.size + 1;
        AppMethodBeat.m2505o(122981);
    }

    private E get(int i) {
        AppMethodBeat.m2504i(122982);
        IndexOutOfBoundsException indexOutOfBoundsException;
        if (i < 0 || i > this.size) {
            indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.m2505o(122982);
            throw indexOutOfBoundsException;
        }
        try {
            Object next = m39813US(i).next();
            AppMethodBeat.m2505o(122982);
            return next;
        } catch (NoSuchElementException e) {
            indexOutOfBoundsException = new IndexOutOfBoundsException("Index: ".concat(String.valueOf(i)));
            AppMethodBeat.m2505o(122982);
            throw indexOutOfBoundsException;
        }
    }

    public final Iterator<E> iterator() {
        AppMethodBeat.m2504i(122983);
        Iterator US = m39813US(0);
        AppMethodBeat.m2505o(122983);
        return US;
    }

    /* renamed from: US */
    private Iterator<E> m39813US(int i) {
        AppMethodBeat.m2504i(122984);
        C25246a c25246a = new C25246a(m39814UU(i));
        AppMethodBeat.m2505o(122984);
        return c25246a;
    }

    /* renamed from: dZ */
    public final C25245a<E> mo42088dZ(E e) {
        AppMethodBeat.m2504i(122985);
        C25245a c25245a = new C25245a(e, this);
        AppMethodBeat.m2505o(122985);
        return c25245a;
    }

    /* renamed from: ea */
    private C25245a<E> m39816ea(Object obj) {
        AppMethodBeat.m2504i(122986);
        if (this.size == 0) {
            AppMethodBeat.m2505o(122986);
            return this;
        } else if (this.first.equals(obj)) {
            C25245a<E> thisR = this.BNz;
            AppMethodBeat.m2505o(122986);
            return thisR;
        } else {
            C25245a ea = this.BNz.m39816ea(obj);
            if (ea == this.BNz) {
                AppMethodBeat.m2505o(122986);
                return this;
            }
            C25245a c25245a = new C25245a(this.first, ea);
            AppMethodBeat.m2505o(122986);
            return c25245a;
        }
    }

    /* renamed from: UT */
    public final C25245a<E> mo42087UT(int i) {
        AppMethodBeat.m2504i(122987);
        C25245a ea = m39816ea(get(i));
        AppMethodBeat.m2505o(122987);
        return ea;
    }

    /* renamed from: UU */
    private C25245a<E> m39814UU(int i) {
        AppMethodBeat.m2504i(122988);
        while (i >= 0 && i <= this.size) {
            if (i == 0) {
                AppMethodBeat.m2505o(122988);
                return this;
            }
            this = this.BNz;
            i--;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        AppMethodBeat.m2505o(122988);
        throw indexOutOfBoundsException;
    }
}
