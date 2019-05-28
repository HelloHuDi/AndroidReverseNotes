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

@Class(creator = "RetrieveDataRequestCreator")
public final class zzag extends AbstractSafeParcelable {
    public static final Creator<zzag> CREATOR = new zzah();
    @Field(id = 2)
    private final String accountType;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.m2504i(77091);
        AppMethodBeat.m2505o(77091);
    }

    @Constructor
    zzag(@Param(id = 1) int i, @Param(id = 2) String str) {
        AppMethodBeat.m2504i(77089);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        AppMethodBeat.m2505o(77089);
    }

    public zzag(String str) {
        this(1, str);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(77090);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(77090);
    }
}
