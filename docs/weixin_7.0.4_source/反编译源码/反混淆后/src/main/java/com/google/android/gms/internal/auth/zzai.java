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

@Class(creator = "SendDataRequestCreator")
public final class zzai extends AbstractSafeParcelable {
    public static final Creator<zzai> CREATOR = new zzaj();
    @Field(id = 2)
    private final String accountType;
    @Field(id = 3)
    private final byte[] zzbz;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.m2504i(77095);
        AppMethodBeat.m2505o(77095);
    }

    @Constructor
    zzai(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) byte[] bArr) {
        AppMethodBeat.m2504i(77093);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        this.zzbz = (byte[]) Preconditions.checkNotNull(bArr);
        AppMethodBeat.m2505o(77093);
    }

    public zzai(String str, byte[] bArr) {
        this(1, str, bArr);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(77094);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzbz, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(77094);
    }
}
