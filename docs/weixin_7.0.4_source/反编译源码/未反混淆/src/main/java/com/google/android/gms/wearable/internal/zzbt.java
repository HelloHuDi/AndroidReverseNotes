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

@Class(creator = "CloseChannelResponseCreator")
@Reserved({1})
public final class zzbt extends AbstractSafeParcelable {
    public static final Creator<zzbt> CREATOR = new zzbu();
    @Field(id = 2)
    public final int statusCode;

    static {
        AppMethodBeat.i(71106);
        AppMethodBeat.o(71106);
    }

    @Constructor
    public zzbt(@Param(id = 2) int i) {
        this.statusCode = i;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71105);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71105);
    }
}
