package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcy extends DataBufferRef implements DataEvent {
    private final int zzdl;

    public zzcy(DataHolder dataHolder, int i, int i2) {
        super(dataHolder, i);
        this.zzdl = i2;
    }

    public final /* synthetic */ Object freeze() {
        AppMethodBeat.i(71180);
        zzcx zzcx = new zzcx(this);
        AppMethodBeat.o(71180);
        return zzcx;
    }

    public final DataItem getDataItem() {
        AppMethodBeat.i(71177);
        zzdf zzdf = new zzdf(this.mDataHolder, this.mDataRow, this.zzdl);
        AppMethodBeat.o(71177);
        return zzdf;
    }

    public final int getType() {
        AppMethodBeat.i(71178);
        int integer = getInteger("event_type");
        AppMethodBeat.o(71178);
        return integer;
    }

    public final String toString() {
        AppMethodBeat.i(71179);
        Object obj = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(getDataItem());
        String stringBuilder = new StringBuilder((String.valueOf(obj).length() + 32) + String.valueOf(valueOf).length()).append("DataEventRef{ type=").append(obj).append(", dataitem=").append(valueOf).append(" }").toString();
        AppMethodBeat.o(71179);
        return stringBuilder;
    }
}
