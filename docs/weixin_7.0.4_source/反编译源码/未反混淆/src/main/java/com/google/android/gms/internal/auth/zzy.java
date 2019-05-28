package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "DeviceMetaDataRequestCreator")
public final class zzy extends AbstractSafeParcelable {
    public static final Creator<zzy> CREATOR = new zzz();
    @Field(id = 2)
    private final String accountType;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(77157);
        AppMethodBeat.o(77157);
    }

    @Constructor
    zzy(@Param(id = 1) int i, @Param(id = 2) String str) {
        AppMethodBeat.i(77155);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        AppMethodBeat.o(77155);
    }

    public zzy(String str) {
        this(1, str);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(77156);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(77156);
    }
}
