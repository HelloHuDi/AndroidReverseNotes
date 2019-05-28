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
        AppMethodBeat.m2504i(3390);
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        AppMethodBeat.m2505o(3390);
        throw noSuchElementException;
    }

    public final void remove() {
        AppMethodBeat.m2504i(3391);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.m2505o(3391);
        throw unsupportedOperationException;
    }
}
