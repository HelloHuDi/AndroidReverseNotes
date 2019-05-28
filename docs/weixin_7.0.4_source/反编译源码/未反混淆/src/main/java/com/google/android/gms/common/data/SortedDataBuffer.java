package com.google.android.gms.common.data;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public final class SortedDataBuffer<T> implements DataBuffer<T> {
    private final DataBuffer<T> zzok;
    private final Integer[] zzol;

    public SortedDataBuffer(DataBuffer<T> dataBuffer, Comparator<T> comparator) {
        AppMethodBeat.i(61173);
        this.zzok = dataBuffer;
        this.zzol = new Integer[dataBuffer.getCount()];
        for (int i = 0; i < this.zzol.length; i++) {
            this.zzol[i] = Integer.valueOf(i);
        }
        Arrays.sort(this.zzol, new zzb(this, comparator));
        AppMethodBeat.o(61173);
    }

    public final void close() {
        AppMethodBeat.i(61177);
        this.zzok.release();
        AppMethodBeat.o(61177);
    }

    public final T get(int i) {
        AppMethodBeat.i(61174);
        Object obj = this.zzok.get(this.zzol[i].intValue());
        AppMethodBeat.o(61174);
        return obj;
    }

    public final int getCount() {
        return this.zzol.length;
    }

    public final Bundle getMetadata() {
        AppMethodBeat.i(61176);
        Bundle metadata = this.zzok.getMetadata();
        AppMethodBeat.o(61176);
        return metadata;
    }

    public final boolean isClosed() {
        AppMethodBeat.i(61178);
        boolean isClosed = this.zzok.isClosed();
        AppMethodBeat.o(61178);
        return isClosed;
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.i(61179);
        DataBufferIterator dataBufferIterator = new DataBufferIterator(this);
        AppMethodBeat.o(61179);
        return dataBufferIterator;
    }

    public final void release() {
        AppMethodBeat.i(61175);
        this.zzok.release();
        AppMethodBeat.o(61175);
    }

    public final Iterator<T> singleRefIterator() {
        AppMethodBeat.i(61180);
        Iterator it = iterator();
        AppMethodBeat.o(61180);
        return it;
    }
}
