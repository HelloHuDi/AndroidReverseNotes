package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.wearable.internal.zzdf;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class DataItemBuffer extends EntityBuffer<DataItem> implements Result {
    private final Status zzp;

    public DataItemBuffer(DataHolder dataHolder) {
        super(dataHolder);
        AppMethodBeat.i(70801);
        this.zzp = new Status(dataHolder.getStatusCode());
        AppMethodBeat.o(70801);
    }

    public /* synthetic */ Object getEntry(int i, int i2) {
        AppMethodBeat.i(70802);
        zzdf zzdf = new zzdf(this.mDataHolder, i, i2);
        AppMethodBeat.o(70802);
        return zzdf;
    }

    public String getPrimaryDataMarkerColumn() {
        return "path";
    }

    public Status getStatus() {
        return this.zzp;
    }
}
