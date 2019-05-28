package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "SaveRequestCreator")
@Reserved({1000})
public final class zzbe extends AbstractSafeParcelable {
    public static final Creator<zzbe> CREATOR = new zzbf();
    @Field(getter = "getCredential", id = 1)
    private final Credential zzdq;

    static {
        AppMethodBeat.m2504i(50496);
        AppMethodBeat.m2505o(50496);
    }

    @Constructor
    public zzbe(@Param(id = 1) Credential credential) {
        this.zzdq = credential;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(50495);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzdq, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(50495);
    }
}
