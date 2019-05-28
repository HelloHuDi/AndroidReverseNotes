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

@Class(creator = "OpenChannelResponseCreator")
@Reserved({1})
public final class zzfq extends AbstractSafeParcelable {
    public static final Creator<zzfq> CREATOR = new zzfr();
    @Field(id = 2)
    public final int statusCode;
    @Field(id = 3)
    public final zzay zzck;

    static {
        AppMethodBeat.i(71335);
        AppMethodBeat.o(71335);
    }

    @Constructor
    public zzfq(@Param(id = 2) int i, @Param(id = 3) zzay zzay) {
        this.statusCode = i;
        this.zzck = zzay;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71334);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzck, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71334);
    }
}
