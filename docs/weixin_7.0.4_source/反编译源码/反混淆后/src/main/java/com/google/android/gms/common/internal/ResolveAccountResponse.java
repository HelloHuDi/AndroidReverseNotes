package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor.Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "ResolveAccountResponseCreator")
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new ResolveAccountResponseCreator();
    @VersionField(id = 1)
    private final int zzal;
    @Field(getter = "getConnectionResult", id = 3)
    private ConnectionResult zzeu;
    @Field(getter = "getSaveDefaultAccount", id = 4)
    private boolean zzhs;
    @Field(id = 2)
    private IBinder zzqv;
    @Field(getter = "isFromCrossClientAuth", id = 5)
    private boolean zzuv;

    static {
        AppMethodBeat.m2504i(61369);
        AppMethodBeat.m2505o(61369);
    }

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, null));
        AppMethodBeat.m2504i(61364);
        AppMethodBeat.m2505o(61364);
    }

    @Constructor
    ResolveAccountResponse(@Param(id = 1) int i, @Param(id = 2) IBinder iBinder, @Param(id = 3) ConnectionResult connectionResult, @Param(id = 4) boolean z, @Param(id = 5) boolean z2) {
        this.zzal = i;
        this.zzqv = iBinder;
        this.zzeu = connectionResult;
        this.zzhs = z;
        this.zzuv = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.m2504i(61368);
        if (this == obj) {
            AppMethodBeat.m2505o(61368);
            return true;
        } else if (obj instanceof ResolveAccountResponse) {
            ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
            if (this.zzeu.equals(resolveAccountResponse.zzeu) && getAccountAccessor().equals(resolveAccountResponse.getAccountAccessor())) {
                AppMethodBeat.m2505o(61368);
                return true;
            }
            AppMethodBeat.m2505o(61368);
            return false;
        } else {
            AppMethodBeat.m2505o(61368);
            return false;
        }
    }

    public IAccountAccessor getAccountAccessor() {
        AppMethodBeat.m2504i(61365);
        IAccountAccessor asInterface = Stub.asInterface(this.zzqv);
        AppMethodBeat.m2505o(61365);
        return asInterface;
    }

    public ConnectionResult getConnectionResult() {
        return this.zzeu;
    }

    public boolean getSaveDefaultAccount() {
        return this.zzhs;
    }

    public boolean isFromCrossClientAuth() {
        return this.zzuv;
    }

    public ResolveAccountResponse setAccountAccessor(IAccountAccessor iAccountAccessor) {
        AppMethodBeat.m2504i(61366);
        this.zzqv = iAccountAccessor == null ? null : iAccountAccessor.asBinder();
        AppMethodBeat.m2505o(61366);
        return this;
    }

    public ResolveAccountResponse setIsFromCrossClientAuth(boolean z) {
        this.zzuv = z;
        return this;
    }

    public ResolveAccountResponse setSaveDefaultAccount(boolean z) {
        this.zzhs = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61367);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzqv, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getConnectionResult(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, getSaveDefaultAccount());
        SafeParcelWriter.writeBoolean(parcel, 5, isFromCrossClientAuth());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(61367);
    }
}
