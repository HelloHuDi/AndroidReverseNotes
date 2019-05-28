package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "GetFdForAssetResponseCreator")
@Reserved({1})
public final class zzee extends AbstractSafeParcelable {
    public static final Creator<zzee> CREATOR = new zzef();
    @Field(id = 2)
    public final int statusCode;
    @Field(id = 3)
    public final ParcelFileDescriptor zzdz;

    static {
        AppMethodBeat.i(71243);
        AppMethodBeat.o(71243);
    }

    @Constructor
    public zzee(@Param(id = 2) int i, @Param(id = 3) ParcelFileDescriptor parcelFileDescriptor) {
        this.statusCode = i;
        this.zzdz = parcelFileDescriptor;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71242);
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdz, i2, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71242);
    }
}
