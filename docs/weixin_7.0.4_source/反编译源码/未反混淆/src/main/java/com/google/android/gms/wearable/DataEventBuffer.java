package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.wearable.internal.zzcy;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class DataEventBuffer extends EntityBuffer<DataEvent> implements Result {
    private final Status zzp;

    public DataEventBuffer(DataHolder dataHolder) {
        super(dataHolder);
        AppMethodBeat.i(70799);
        this.zzp = new Status(dataHolder.getStatusCode());
        AppMethodBeat.o(70799);
    }

    public /* synthetic */ Object getEntry(int i, int i2) {
        AppMethodBeat.i(70800);
        zzcy zzcy = new zzcy(this.mDataHolder, i, i2);
        AppMethodBeat.o(70800);
        return zzcy;
    }

    public String getPrimaryDataMarkerColumn() {
        return "path";
    }

    public Status getStatus() {
        return this.zzp;
    }
}
