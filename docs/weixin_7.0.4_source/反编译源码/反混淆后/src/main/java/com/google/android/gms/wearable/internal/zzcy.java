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
        AppMethodBeat.m2504i(71180);
        zzcx zzcx = new zzcx(this);
        AppMethodBeat.m2505o(71180);
        return zzcx;
    }

    public final DataItem getDataItem() {
        AppMethodBeat.m2504i(71177);
        zzdf zzdf = new zzdf(this.mDataHolder, this.mDataRow, this.zzdl);
        AppMethodBeat.m2505o(71177);
        return zzdf;
    }

    public final int getType() {
        AppMethodBeat.m2504i(71178);
        int integer = getInteger("event_type");
        AppMethodBeat.m2505o(71178);
        return integer;
    }

    public final String toString() {
        AppMethodBeat.m2504i(71179);
        Object obj = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(getDataItem());
        String stringBuilder = new StringBuilder((String.valueOf(obj).length() + 32) + String.valueOf(valueOf).length()).append("DataEventRef{ type=").append(obj).append(", dataitem=").append(valueOf).append(" }").toString();
        AppMethodBeat.m2505o(71179);
        return stringBuilder;
    }
}
