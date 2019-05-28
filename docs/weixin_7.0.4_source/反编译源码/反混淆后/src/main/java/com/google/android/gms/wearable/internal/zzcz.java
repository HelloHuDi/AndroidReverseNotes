package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class zzcz implements DataItemAsset {
    private final String zzdm;
    private final String zzdn;

    public zzcz(DataItemAsset dataItemAsset) {
        AppMethodBeat.m2504i(71181);
        this.zzdm = dataItemAsset.getId();
        this.zzdn = dataItemAsset.getDataItemKey();
        AppMethodBeat.m2505o(71181);
    }

    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public final String getDataItemKey() {
        return this.zzdn;
    }

    public final String getId() {
        return this.zzdm;
    }

    public final boolean isDataValid() {
        return true;
    }

    public final String toString() {
        AppMethodBeat.m2504i(71182);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.zzdm == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.zzdm);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.zzdn);
        stringBuilder.append("]");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(71182);
        return stringBuilder2;
    }
}
