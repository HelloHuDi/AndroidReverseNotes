package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.DataItemAsset;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepName
@Class(creator = "DataItemAssetParcelableCreator")
@Reserved({1})
public class DataItemAssetParcelable extends AbstractSafeParcelable implements ReflectedParcelable, DataItemAsset {
    public static final Creator<DataItemAssetParcelable> CREATOR = new zzda();
    @Field(getter = "getId", id = 2)
    private final String zzdm;
    @Field(getter = "getDataItemKey", id = 3)
    private final String zzdn;

    static {
        AppMethodBeat.i(70942);
        AppMethodBeat.o(70942);
    }

    public DataItemAssetParcelable(DataItemAsset dataItemAsset) {
        AppMethodBeat.i(70939);
        this.zzdm = (String) Preconditions.checkNotNull(dataItemAsset.getId());
        this.zzdn = (String) Preconditions.checkNotNull(dataItemAsset.getDataItemKey());
        AppMethodBeat.o(70939);
    }

    @Constructor
    DataItemAssetParcelable(@Param(id = 2) String str, @Param(id = 3) String str2) {
        this.zzdm = str;
        this.zzdn = str2;
    }

    public /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    public String getDataItemKey() {
        return this.zzdn;
    }

    public String getId() {
        return this.zzdm;
    }

    public boolean isDataValid() {
        return true;
    }

    public String toString() {
        AppMethodBeat.i(70941);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
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
        AppMethodBeat.o(70941);
        return stringBuilder2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(70940);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDataItemKey(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(70940);
    }
}
