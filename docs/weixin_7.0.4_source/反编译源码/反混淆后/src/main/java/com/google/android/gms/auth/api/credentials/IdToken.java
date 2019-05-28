package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "IdTokenCreator")
@Reserved({1000})
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<IdToken> CREATOR = new zzl();
    @Field(getter = "getAccountType", id = 1)
    private final String zzbx;
    @Field(getter = "getIdToken", id = 2)
    private final String zzdf;

    static {
        AppMethodBeat.m2504i(50353);
        AppMethodBeat.m2505o(50353);
    }

    @Constructor
    public IdToken(@Param(id = 1) String str, @Param(id = 2) String str2) {
        boolean z = true;
        AppMethodBeat.m2504i(50351);
        Preconditions.checkArgument(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        if (TextUtils.isEmpty(str2)) {
            z = false;
        }
        Preconditions.checkArgument(z, "id token string cannot be null or empty");
        this.zzbx = str;
        this.zzdf = str2;
        AppMethodBeat.m2505o(50351);
    }

    public final String getAccountType() {
        return this.zzbx;
    }

    public final String getIdToken() {
        return this.zzdf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(50352);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAccountType(), false);
        SafeParcelWriter.writeString(parcel, 2, getIdToken(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(50352);
    }
}
