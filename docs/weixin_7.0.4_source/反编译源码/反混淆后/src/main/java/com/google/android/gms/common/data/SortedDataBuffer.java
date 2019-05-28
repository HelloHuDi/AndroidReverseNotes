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
        AppMethodBeat.m2504i(61173);
        this.zzok = dataBuffer;
        this.zzol = new Integer[dataBuffer.getCount()];
        for (int i = 0; i < this.zzol.length; i++) {
            this.zzol[i] = Integer.valueOf(i);
        }
        Arrays.sort(this.zzol, new zzb(this, comparator));
        AppMethodBeat.m2505o(61173);
    }

    public final void close() {
        AppMethodBeat.m2504i(61177);
        this.zzok.release();
        AppMethodBeat.m2505o(61177);
    }

    public final T get(int i) {
        AppMethodBeat.m2504i(61174);
        Object obj = this.zzok.get(this.zzol[i].intValue());
        AppMethodBeat.m2505o(61174);
        return obj;
    }

    public final int getCount() {
        return this.zzol.length;
    }

    public final Bundle getMetadata() {
        AppMethodBeat.m2504i(61176);
        Bundle metadata = this.zzok.getMetadata();
        AppMethodBeat.m2505o(61176);
        return metadata;
    }

    public final boolean isClosed() {
        AppMethodBeat.m2504i(61178);
        boolean isClosed = this.zzok.isClosed();
        AppMethodBeat.m2505o(61178);
        return isClosed;
    }

    public final Iterator<T> iterator() {
        AppMethodBeat.m2504i(61179);
        DataBufferIterator dataBufferIterator = new DataBufferIterator(this);
        AppMethodBeat.m2505o(61179);
        return dataBufferIterator;
    }

    public final void release() {
        AppMethodBeat.m2504i(61175);
        this.zzok.release();
        AppMethodBeat.m2505o(61175);
    }

    public final Iterator<T> singleRefIterator() {
        AppMethodBeat.m2504i(61180);
        Iterator it = iterator();
        AppMethodBeat.m2505o(61180);
        return it;
    }
}
