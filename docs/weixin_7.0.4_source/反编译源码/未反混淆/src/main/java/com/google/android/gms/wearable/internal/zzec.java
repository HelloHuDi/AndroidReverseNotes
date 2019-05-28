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

@Class(creator = "GetDataItemResponseCreator")
@Reserved({1})
public final class zzec extends AbstractSafeParcelable {
    public static final Creator<zzec> CREATOR = new zzed();
    @Field(id = 2)
    public final int statusCode;
    @Field(id = 3)
    public final zzdd zzdy;

    static {
        AppMethodBeat.i(71240);
        AppMethodBeat.o(71240);
    }

    @Constructor
    public zzec(@Param(id = 2) int i, @Param(id = 3) zzdd zzdd) {
        this.statusCode = i;
        this.zzdy = zzdd;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71239);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzdy, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71239);
    }
}
