package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzdb extends DataBufferRef implements DataItemAsset {
    public zzdb(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    public final /* synthetic */ Object freeze() {
        AppMethodBeat.m2504i(71190);
        zzcz zzcz = new zzcz(this);
        AppMethodBeat.m2505o(71190);
        return zzcz;
    }

    public final String getDataItemKey() {
        AppMethodBeat.m2504i(71189);
        String string = getString("asset_key");
        AppMethodBeat.m2505o(71189);
        return string;
    }

    public final String getId() {
        AppMethodBeat.m2504i(71188);
        String string = getString("asset_id");
        AppMethodBeat.m2505o(71188);
        return string;
    }
}
