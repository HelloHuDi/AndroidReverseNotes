package com.google.android.gms.common.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;

public final class PositionFilteredDataBuffer<T> extends FilteredDataBuffer<T> {
    private final ArrayList<Integer> zzob = new ArrayList();
    private final HashSet<Integer> zzoe = new HashSet();

    public PositionFilteredDataBuffer(AbstractDataBuffer<T> abstractDataBuffer) {
        super(abstractDataBuffer);
        AppMethodBeat.i(61162);
        zzcl();
        AppMethodBeat.o(61162);
    }

    private final void zzcl() {
        AppMethodBeat.i(61168);
        this.zzob.clear();
        int count = this.mDataBuffer.getCount();
        for (int i = 0; i < count; i++) {
            if (!this.zzoe.contains(Integer.valueOf(i))) {
                this.zzob.add(Integer.valueOf(i));
            }
        }
        AppMethodBeat.o(61168);
    }

    public final void clearFilters() {
        AppMethodBeat.i(61167);
        this.zzoe.clear();
        zzcl();
        AppMethodBeat.o(61167);
    }

    public final int computeRealPosition(int i) {
        AppMethodBeat.i(61164);
        if (i < 0 || i >= getCount()) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Position " + i + " is out of bounds for this buffer");
            AppMethodBeat.o(61164);
            throw illegalArgumentException;
        }
        int intValue = ((Integer) this.zzob.get(i)).intValue();
        AppMethodBeat.o(61164);
        return intValue;
    }

    public final void filterOut(int i) {
        AppMethodBeat.i(61165);
        if (i >= 0 && i <= this.mDataBuffer.getCount()) {
            this.zzoe.add(Integer.valueOf(i));
            zzcl();
        }
        AppMethodBeat.o(61165);
    }

    public final int getCount() {
        AppMethodBeat.i(61163);
        int count = this.mDataBuffer.getCount() - this.zzoe.size();
        AppMethodBeat.o(61163);
        return count;
    }

    public final void unfilter(int i) {
        AppMethodBeat.i(61166);
        this.zzoe.remove(Integer.valueOf(i));
        zzcl();
        AppMethodBeat.o(61166);
    }
}
