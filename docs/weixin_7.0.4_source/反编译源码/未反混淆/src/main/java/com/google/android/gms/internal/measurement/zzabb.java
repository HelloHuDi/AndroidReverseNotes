package com.google.android.gms.internal.measurement;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzabb implements Iterator<Object> {
    zzabb() {
    }

    public final boolean hasNext() {
        return false;
    }

    public final Object next() {
        AppMethodBeat.i(3390);
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        AppMethodBeat.o(3390);
        throw noSuchElementException;
    }

    public final void remove() {
        AppMethodBeat.i(3391);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(3391);
        throw unsupportedOperationException;
    }
}
