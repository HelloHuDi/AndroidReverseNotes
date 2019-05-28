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
import java.util.List;

@Class(creator = "StorageInfoResponseCreator")
@Reserved({1})
public final class zzge extends AbstractSafeParcelable {
    public static final Creator<zzge> CREATOR = new zzgf();
    @Field(id = 2)
    private final int statusCode;
    @Field(id = 3)
    private final long zzep;
    @Field(id = 4)
    private final List<zzfs> zzer;

    static {
        AppMethodBeat.m2504i(71363);
        AppMethodBeat.m2505o(71363);
    }

    @Constructor
    public zzge(@Param(id = 2) int i, @Param(id = 3) long j, @Param(id = 4) List<zzfs> list) {
        this.statusCode = i;
        this.zzep = j;
        this.zzer = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71362);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeLong(parcel, 3, this.zzep);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzer, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71362);
    }
}
