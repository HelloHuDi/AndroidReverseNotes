package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "SignInRequestCreator")
public class SignInRequest extends AbstractSafeParcelable {
    public static final Creator<SignInRequest> CREATOR = new SignInRequestCreator();
    @Field(getter = "getResolveAccountRequest", id = 2)
    private final ResolveAccountRequest zzadt;
    @VersionField(id = 1)
    private final int zzal;

    static {
        AppMethodBeat.i(61698);
        AppMethodBeat.o(61698);
    }

    @Constructor
    SignInRequest(@Param(id = 1) int i, @Param(id = 2) ResolveAccountRequest resolveAccountRequest) {
        this.zzal = i;
        this.zzadt = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public ResolveAccountRequest getResolveAccountRequest() {
        return this.zzadt;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(61697);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, getResolveAccountRequest(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(61697);
    }
}
