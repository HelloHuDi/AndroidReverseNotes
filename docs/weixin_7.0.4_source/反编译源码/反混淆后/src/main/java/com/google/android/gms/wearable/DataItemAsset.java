package com.google.android.gms.wearable;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
public interface DataItemAsset extends Freezable<DataItemAsset> {
    String getDataItemKey();

    String getId();
}
