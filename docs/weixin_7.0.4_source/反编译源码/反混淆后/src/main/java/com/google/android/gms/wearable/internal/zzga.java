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

@Class(creator = "SendMessageResponseCreator")
@Reserved({1})
public final class zzga extends AbstractSafeParcelable {
    public static final Creator<zzga> CREATOR = new zzgb();
    @Field(id = 2)
    public final int statusCode;
    @Field(id = 3)
    public final int zzeh;

    static {
        AppMethodBeat.m2504i(71352);
        AppMethodBeat.m2505o(71352);
    }

    @Constructor
    public zzga(@Param(id = 2) int i, @Param(id = 3) int i2) {
        this.statusCode = i;
        this.zzeh = i2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71351);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeInt(parcel, 3, this.zzeh);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71351);
    }
}
