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

@Class(creator = "PackageStorageInfoCreator")
@Reserved({1})
public final class zzfs extends AbstractSafeParcelable {
    public static final Creator<zzfs> CREATOR = new zzft();
    @Field(id = 3)
    private final String label;
    @Field(id = 2)
    private final String packageName;
    @Field(id = 4)
    private final long zzep;

    static {
        AppMethodBeat.m2504i(71338);
        AppMethodBeat.m2505o(71338);
    }

    @Constructor
    public zzfs(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) long j) {
        this.packageName = str;
        this.label = str2;
        this.zzep = j;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71337);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.label, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzep);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71337);
    }
}
