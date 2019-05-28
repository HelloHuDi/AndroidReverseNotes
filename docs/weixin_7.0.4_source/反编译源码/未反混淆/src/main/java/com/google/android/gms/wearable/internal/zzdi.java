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
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

@Class(creator = "GetAllCapabilitiesResponseCreator")
@Reserved({1})
public final class zzdi extends AbstractSafeParcelable {
    public static final Creator<zzdi> CREATOR = new zzdj();
    @Field(id = 2)
    public final int statusCode;
    @Field(id = 3)
    @VisibleForTesting
    public final List<zzah> zzdp;

    static {
        AppMethodBeat.i(71209);
        AppMethodBeat.o(71209);
    }

    @Constructor
    public zzdi(@Param(id = 2) int i, @Param(id = 3) List<zzah> list) {
        this.statusCode = i;
        this.zzdp = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71208);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzdp, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71208);
    }
}
