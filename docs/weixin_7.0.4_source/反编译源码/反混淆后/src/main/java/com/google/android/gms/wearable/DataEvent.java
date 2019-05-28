package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public interface DataEvent extends Freezable<DataEvent> {
    public static final int TYPE_CHANGED = 1;
    public static final int TYPE_DELETED = 2;

    DataItem getDataItem();

    int getType();
}
