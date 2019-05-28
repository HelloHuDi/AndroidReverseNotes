package a.i.b.a.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class a<E> implements Iterable<E> {
    private static final a<Object> BNy = new a();
    public final a<E> BNz;
    public final E first;
    public final int size;

    static class a<E> implements Iterator<E> {
        private a<E> BNA;

        public a(a<E> aVar) {
            this.BNA = aVar;
        }

        public final boolean hasNext() {
            AppMethodBeat.i(122979);
            if (this.BNA.size > 0) {
                AppMethodBeat.o(122979);
                return true;
            }
            AppMethodBeat.o(122979);
            return false;
        }

        public final E next() {
            Object obj = this.BNA.first;
            this.BNA = this.BNA.BNz;
            return obj;
        }

        public final void remove() {
            AppMethodBeat.i(122980);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(122980);
            throw unsupportedOperationException;
        }
    }

    static {
        AppMethodBeat.i(122989);
        AppMethodBeat.o(122989);
    }

    public static <E> a<E> ekE() {
        return BNy;
    }

    private a() {
        this.size = 0;
        this.first = null;
        this.BNz = null;
    }

    private a(E e, a<E> aVar) {
        AppMethodBeat.i(122981);
        this.first = e;
        this.BNz = aVar;
        this.size = aVar.size + 1;
        AppMethodBeat.o(122981);
    }

    private E get(int i) {
        AppMethodBeat.i(122982);
        IndexOutOfBoundsException indexOutOfBoundsException;
        if (i < 0 || i > this.size) {
            indexOutOfBoundsException = new IndexOutOfBoundsException();
            AppMethodBeat.o(122982);
            throw indexOutOfBoundsException;
        }
        try {
            Object next = US(i).next();
            AppMethodBeat.o(122982);
            return next;
        } catch (NoSuchElementException e) {
            indexOutOfBoundsException = new IndexOutOfBoundsException("Index: ".concat(String.valueOf(i)));
            AppMethodBeat.o(122982);
            throw indexOutOfBoundsException;
        }
    }

    public final Iterator<E> iterator() {
        AppMethodBeat.i(122983);
        Iterator US = US(0);
        AppMethodBeat.o(122983);
        return US;
    }

    private Iterator<E> US(int i) {
        AppMethodBeat.i(122984);
        a aVar = new a(UU(i));
        AppMethodBeat.o(122984);
        return aVar;
    }

    public final a<E> dZ(E e) {
        AppMethodBeat.i(122985);
        a aVar = new a(e, this);
        AppMethodBeat.o(122985);
        return aVar;
    }

    private a<E> ea(Object obj) {
        AppMethodBeat.i(122986);
        if (this.size == 0) {
            AppMethodBeat.o(122986);
            return this;
        } else if (this.first.equals(obj)) {
            a<E> thisR = this.BNz;
            AppMethodBeat.o(122986);
            return thisR;
        } else {
            a ea = this.BNz.ea(obj);
            if (ea == this.BNz) {
                AppMethodBeat.o(122986);
                return this;
            }
            a aVar = new a(this.first, ea);
            AppMethodBeat.o(122986);
            return aVar;
        }
    }

    public final a<E> UT(int i) {
        AppMethodBeat.i(122987);
        a ea = ea(get(i));
        AppMethodBeat.o(122987);
        return ea;
    }

    private a<E> UU(int i) {
        AppMethodBeat.i(122988);
        while (i >= 0 && i <= this.size) {
            if (i == 0) {
                AppMethodBeat.o(122988);
                return this;
            }
            this = this.BNz;
            i--;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException();
        AppMethodBeat.o(122988);
        throw indexOutOfBoundsException;
    }
}
