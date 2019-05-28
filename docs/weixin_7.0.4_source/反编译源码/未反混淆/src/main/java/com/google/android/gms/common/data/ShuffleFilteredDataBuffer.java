package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ShuffleFilteredDataBuffer<T> extends FilteredDataBuffer<T> {
    private final List<Integer> zzoh;
    private final int zzoi;

    public ShuffleFilteredDataBuffer(DataBuffer<T> dataBuffer, int i) {
        super(dataBuffer);
        AppMethodBeat.i(61169);
        this.zzoi = i;
        int i2 = this.zzoi;
        int count = this.mDataBuffer.getCount();
        if (i2 > count) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("numIndexes must be smaller or equal to max");
            AppMethodBeat.o(61169);
            throw illegalArgumentException;
        }
        ArrayList arrayList = new ArrayList(count);
        for (int i3 = 0; i3 < count; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        Collections.shuffle(arrayList);
        this.zzoh = arrayList.subList(0, i2);
        AppMethodBeat.o(61169);
    }

    public final int computeRealPosition(int i) {
        AppMethodBeat.i(61171);
        if (i < 0 || i >= getCount()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
            AppMethodBeat.o(61171);
            throw illegalArgumentException;
        }
        int intValue = ((Integer) this.zzoh.get(i)).intValue();
        AppMethodBeat.o(61171);
        return intValue;
    }

    public final int getCount() {
        AppMethodBeat.i(61170);
        int min = Math.min(this.zzoi, this.mDataBuffer.getCount());
        AppMethodBeat.o(61170);
        return min;
    }
}
