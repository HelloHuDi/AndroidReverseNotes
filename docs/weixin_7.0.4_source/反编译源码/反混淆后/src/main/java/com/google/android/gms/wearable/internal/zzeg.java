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

@Class(creator = "GetLocalNodeResponseCreator")
@Reserved({1})
public final class zzeg extends AbstractSafeParcelable {
    public static final Creator<zzeg> CREATOR = new zzeh();
    @Field(id = 2)
    public final int statusCode;
    @Field(id = 3)
    public final zzfo zzea;

    static {
        AppMethodBeat.m2504i(71246);
        AppMethodBeat.m2505o(71246);
    }

    @Constructor
    public zzeg(@Param(id = 2) int i, @Param(id = 3) zzfo zzfo) {
        this.statusCode = i;
        this.zzea = zzfo;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71245);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzea, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71245);
    }
}
