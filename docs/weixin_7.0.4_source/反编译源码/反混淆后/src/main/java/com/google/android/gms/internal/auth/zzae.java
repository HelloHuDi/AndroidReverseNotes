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

@Class(creator = "NotifyCompletionRequestCreator")
public final class zzae extends AbstractSafeParcelable {
    public static final Creator<zzae> CREATOR = new zzaf();
    @Field(id = 2)
    private final String accountType;
    @Field(id = 3)
    private final int zzcg;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.m2504i(77087);
        AppMethodBeat.m2505o(77087);
    }

    @Constructor
    zzae(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) int i2) {
        AppMethodBeat.m2504i(77085);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        this.zzcg = i2;
        AppMethodBeat.m2505o(77085);
    }

    public zzae(String str, int i) {
        this(1, str, i);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(77086);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzcg);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(77086);
    }
}
