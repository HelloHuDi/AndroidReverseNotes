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

@Class(creator = "GetConnectedNodesResponseCreator")
@Reserved({1})
public final class zzea extends AbstractSafeParcelable {
    public static final Creator<zzea> CREATOR = new zzeb();
    @Field(id = 2)
    public final int statusCode;
    @Field(id = 3)
    public final List<zzfo> zzdx;

    static {
        AppMethodBeat.m2504i(71237);
        AppMethodBeat.m2505o(71237);
    }

    @Constructor
    public zzea(@Param(id = 2) int i, @Param(id = 3) List<zzfo> list) {
        this.statusCode = i;
        this.zzdx = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71236);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.statusCode);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzdx, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71236);
    }
}
