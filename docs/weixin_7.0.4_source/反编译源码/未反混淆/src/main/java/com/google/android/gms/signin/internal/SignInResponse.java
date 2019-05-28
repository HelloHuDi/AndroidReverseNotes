package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "SignInResponseCreator")
public class SignInResponse extends AbstractSafeParcelable {
    public static final Creator<SignInResponse> CREATOR = new SignInResponseCreator();
    @Field(getter = "getResolveAccountResponse", id = 3)
    private final ResolveAccountResponse zzadu;
    @VersionField(id = 1)
    private final int zzal;
    @Field(getter = "getConnectionResult", id = 2)
    private final ConnectionResult zzeu;

    static {
        AppMethodBeat.i(61704);
        AppMethodBeat.o(61704);
    }

    public SignInResponse(int i) {
        this(new ConnectionResult(i, null), null);
        AppMethodBeat.i(61702);
        AppMethodBeat.o(61702);
    }

    @Constructor
    SignInResponse(@Param(id = 1) int i, @Param(id = 2) ConnectionResult connectionResult, @Param(id = 3) ResolveAccountResponse resolveAccountResponse) {
        this.zzal = i;
        this.zzeu = connectionResult;
        this.zzadu = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public ConnectionResult getConnectionResult() {
        return this.zzeu;
    }

    public ResolveAccountResponse getResolveAccountResponse() {
        return this.zzadu;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(61703);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, getConnectionResult(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getResolveAccountResponse(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(61703);
    }
}
