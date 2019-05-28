package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataItem;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcx implements DataEvent {
    private int type;
    private DataItem zzdg;

    public zzcx(DataEvent dataEvent) {
        AppMethodBeat.i(71175);
        this.type = dataEvent.getType();
        this.zzdg = (DataItem) dataEvent.getDataItem().freeze();
        AppMethodBeat.o(71175);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final DataItem getDataItem() {
        return this.zzdg;
    }

    public final int getType() {
        return this.type;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        AppMethodBeat.i(71176);
        Object obj = getType() == 1 ? "changed" : getType() == 2 ? "deleted" : "unknown";
        String valueOf = String.valueOf(getDataItem());
        String stringBuilder = new StringBuilder((String.valueOf(obj).length() + 35) + String.valueOf(valueOf).length()).append("DataEventEntity{ type=").append(obj).append(", dataitem=").append(valueOf).append(" }").toString();
        AppMethodBeat.o(71176);
        return stringBuilder;
    }
}
