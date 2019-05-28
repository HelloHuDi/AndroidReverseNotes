package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.Preconditions;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DataBufferIterator<T> implements Iterator<T> {
    protected final DataBuffer<T> mDataBuffer;
    protected int mPosition = -1;

    public DataBufferIterator(DataBuffer<T> dataBuffer) {
        AppMethodBeat.i(61035);
        this.mDataBuffer = (DataBuffer) Preconditions.checkNotNull(dataBuffer);
        AppMethodBeat.o(61035);
    }

    public boolean hasNext() {
        AppMethodBeat.i(61036);
        if (this.mPosition < this.mDataBuffer.getCount() - 1) {
            AppMethodBeat.o(61036);
            return true;
        }
        AppMethodBeat.o(61036);
        return false;
    }

    public T next() {
        AppMethodBeat.i(61037);
        if (hasNext()) {
            DataBuffer dataBuffer = this.mDataBuffer;
            int i = this.mPosition + 1;
            this.mPosition = i;
            Object obj = dataBuffer.get(i);
            AppMethodBeat.o(61037);
            return obj;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Cannot advance the iterator beyond " + this.mPosition);
        AppMethodBeat.o(61037);
        throw noSuchElementException;
    }

    public void remove() {
        AppMethodBeat.i(61038);
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
        AppMethodBeat.o(61038);
        throw unsupportedOperationException;
    }
}
