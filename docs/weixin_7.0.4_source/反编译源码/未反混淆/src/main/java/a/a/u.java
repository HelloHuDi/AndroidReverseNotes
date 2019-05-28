package a.a;

import a.f.b.a.a;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ListIterator;
import java.util.NoSuchElementException;

@l(dWo = {1, 1, 13}, dWp = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010*\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\t\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016¨\u0006\f"}, dWq = {"Lkotlin/collections/EmptyIterator;", "", "", "()V", "hasNext", "", "hasPrevious", "next", "nextIndex", "", "previous", "previousIndex", "kotlin-stdlib"})
public final class u implements a, ListIterator {
    public static final u AUO = new u();

    public final /* synthetic */ void add(Object obj) {
        AppMethodBeat.i(56186);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56186);
        throw unsupportedOperationException;
    }

    public final void remove() {
        AppMethodBeat.i(56185);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56185);
        throw unsupportedOperationException;
    }

    public final /* synthetic */ void set(Object obj) {
        AppMethodBeat.i(56187);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        AppMethodBeat.o(56187);
        throw unsupportedOperationException;
    }

    static {
        AppMethodBeat.i(56184);
        AppMethodBeat.o(56184);
    }

    private u() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final boolean hasPrevious() {
        return false;
    }

    public final int nextIndex() {
        return 0;
    }

    public final int previousIndex() {
        return -1;
    }

    public final /* synthetic */ Object next() {
        AppMethodBeat.i(56182);
        Throwable noSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(56182);
        throw noSuchElementException;
    }

    public final /* synthetic */ Object previous() {
        AppMethodBeat.i(56183);
        Throwable noSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(56183);
        throw noSuchElementException;
    }
}
