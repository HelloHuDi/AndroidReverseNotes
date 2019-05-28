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

@Class(creator = "GetCloudSyncOptInStatusCreator")
@Reserved({1})
public final class zzdt extends AbstractSafeParcelable {
    public static final Creator<zzdt> CREATOR = new zzds();
    @Field(id = 2)
    private final int statusCode;
    @Field(id = 3)
    private final boolean zzdt;
    @Field(id = 4)
    private final boolean zzdu;

    static {
        AppMethodBeat.i(71225);
        AppMethodBeat.o(71225);
    }

    @Constructor
    public zzdt(@Param(id = 2) int i, @Param(id = 3) boolean z, @Param(id = 4) boolean z2) {
        this.statusCode = i;
        this.zzdt = z;
        this.zzdu = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71224);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzdt);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdu);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71224);
    }
}
