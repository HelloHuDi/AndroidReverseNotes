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

@Class(creator = "GetCloudSyncOptInOutDoneCreator")
@Reserved({1})
public final class zzdr extends AbstractSafeParcelable {
    public static final Creator<zzdr> CREATOR = new zzdq();
    @Field(id = 2)
    private final int statusCode;
    @Field(id = 3)
    private final boolean zzds;

    static {
        AppMethodBeat.i(71222);
        AppMethodBeat.o(71222);
    }

    @Constructor
    public zzdr(@Param(id = 2) int i, @Param(id = 3) boolean z) {
        this.statusCode = i;
        this.zzds = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71221);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzds);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71221);
    }
}
