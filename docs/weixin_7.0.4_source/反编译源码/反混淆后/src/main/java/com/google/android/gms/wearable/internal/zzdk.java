package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "GetCapabilityResponseCreator")
@Reserved({1})
public final class zzdk extends AbstractSafeParcelable {
    public static final Creator<zzdk> CREATOR = new zzdl();
    @Field(id = 2)
    public final int statusCode;
    @Field(id = 3)
    public final zzah zzdq;

    static {
        AppMethodBeat.m2504i(71212);
        AppMethodBeat.m2505o(71212);
    }

    @Constructor
    public zzdk(@Param(id = 2) int i, @Param(id = 3) zzah zzah) {
        this.statusCode = i;
        this.zzdq = zzah;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71211);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdq, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71211);
    }
}
