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
import javax.annotation.Nullable;

@Class(creator = "GetChannelOutputStreamResponseCreator")
@Reserved({1})
public final class zzdo extends AbstractSafeParcelable {
    public static final Creator<zzdo> CREATOR = new zzdp();
    @Field(id = 2)
    public final int statusCode;
    @Field(id = 3)
    @Nullable
    public final ParcelFileDescriptor zzdr;

    static {
        AppMethodBeat.i(71218);
        AppMethodBeat.o(71218);
    }

    @Constructor
    public zzdo(@Param(id = 2) int i, @Param(id = 3) ParcelFileDescriptor parcelFileDescriptor) {
        this.statusCode = i;
        this.zzdr = parcelFileDescriptor;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71217);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdr, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71217);
    }
}
