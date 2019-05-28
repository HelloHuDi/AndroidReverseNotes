package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.NoSuchElementException;

public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    private T zzoj;

    public SingleRefDataBufferIterator(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        AppMethodBeat.m2504i(61172);
        if (hasNext()) {
            this.mPosition++;
            if (this.mPosition == 0) {
                this.zzoj = this.mDataBuffer.get(0);
                if (!(this.zzoj instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(this.zzoj.getClass());
                    IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("DataBuffer reference of type ").append(valueOf).append(" is not movable").toString());
                    AppMethodBeat.m2505o(61172);
                    throw illegalStateException;
                }
            }
            ((DataBufferRef) this.zzoj).setDataRow(this.mPosition);
            Object obj = this.zzoj;
            AppMethodBeat.m2505o(61172);
            return obj;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException("Cannot advance the iterator beyond " + this.mPosition);
        AppMethodBeat.m2505o(61172);
        throw noSuchElementException;
    }
}
