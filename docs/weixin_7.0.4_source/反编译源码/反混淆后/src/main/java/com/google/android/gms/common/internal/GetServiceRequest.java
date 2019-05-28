package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor.Stub;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collection;

@Class(creator = "GetServiceRequestCreator")
@Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new GetServiceRequestCreator();
    @VersionField(id = 1)
    private final int version;
    @Field(id = 2)
    private final int zzst;
    @Field(id = 3)
    private int zzsu;
    @Field(id = 4)
    private String zzsv;
    @Field(id = 5)
    private IBinder zzsw;
    @Field(id = 6)
    private Scope[] zzsx;
    @Field(id = 7)
    private Bundle zzsy;
    @Field(id = 8)
    private Account zzsz;
    @Field(id = 10)
    private Feature[] zzta;
    @Field(id = 11)
    private Feature[] zztb;
    @Field(id = 12)
    private boolean zztc;

    static {
        AppMethodBeat.m2504i(89610);
        AppMethodBeat.m2505o(89610);
    }

    public GetServiceRequest(int i) {
        this.version = 4;
        this.zzsu = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzst = i;
        this.zztc = true;
    }

    @Constructor
    GetServiceRequest(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) int i3, @Param(id = 4) String str, @Param(id = 5) IBinder iBinder, @Param(id = 6) Scope[] scopeArr, @Param(id = 7) Bundle bundle, @Param(id = 8) Account account, @Param(id = 10) Feature[] featureArr, @Param(id = 11) Feature[] featureArr2, @Param(id = 12) boolean z) {
        AppMethodBeat.m2504i(89604);
        this.version = i;
        this.zzst = i2;
        this.zzsu = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzsv = "com.google.android.gms";
        } else {
            this.zzsv = str;
        }
        if (i < 2) {
            this.zzsz = zzb(iBinder);
        } else {
            this.zzsw = iBinder;
            this.zzsz = account;
        }
        this.zzsx = scopeArr;
        this.zzsy = bundle;
        this.zzta = featureArr;
        this.zztb = featureArr2;
        this.zztc = z;
        AppMethodBeat.m2505o(89604);
    }

    public static Creator<GetServiceRequest> getCreator() {
        return CREATOR;
    }

    private static Account zzb(IBinder iBinder) {
        AppMethodBeat.m2504i(89609);
        Account account = null;
        if (iBinder != null) {
            account = AccountAccessor.getAccountBinderSafe(Stub.asInterface(iBinder));
        }
        AppMethodBeat.m2505o(89609);
        return account;
    }

    public Account getAuthenticatedAccount() {
        AppMethodBeat.m2504i(89605);
        Account zzb = zzb(this.zzsw);
        AppMethodBeat.m2505o(89605);
        return zzb;
    }

    public String getCallingPackage() {
        return this.zzsv;
    }

    public Feature[] getClientApiFeatures() {
        return this.zztb;
    }

    public int getClientLibraryVersion() {
        return this.zzsu;
    }

    public Account getClientRequestedAccount() {
        return this.zzsz;
    }

    public Feature[] getClientRequiredFeatures() {
        return this.zzta;
    }

    public Bundle getExtraArgs() {
        return this.zzsy;
    }

    public Scope[] getScopes() {
        return this.zzsx;
    }

    public int getServiceId() {
        return this.zzst;
    }

    public boolean isRequestingConnectionInfo() {
        return this.zztc;
    }

    public GetServiceRequest setAuthenticatedAccount(IAccountAccessor iAccountAccessor) {
        AppMethodBeat.m2504i(89606);
        if (iAccountAccessor != null) {
            this.zzsw = iAccountAccessor.asBinder();
        }
        AppMethodBeat.m2505o(89606);
        return this;
    }

    public GetServiceRequest setCallingPackage(String str) {
        this.zzsv = str;
        return this;
    }

    public GetServiceRequest setClientApiFeatures(Feature[] featureArr) {
        this.zztb = featureArr;
        return this;
    }

    public GetServiceRequest setClientLibraryVersion(int i) {
        this.zzsu = i;
        return this;
    }

    public GetServiceRequest setClientRequestedAccount(Account account) {
        this.zzsz = account;
        return this;
    }

    public GetServiceRequest setClientRequiredFeatures(Feature[] featureArr) {
        this.zzta = featureArr;
        return this;
    }

    public GetServiceRequest setExtraArgs(Bundle bundle) {
        this.zzsy = bundle;
        return this;
    }

    public GetServiceRequest setRequestingConnectionInfo(boolean z) {
        this.zztc = z;
        return this;
    }

    public GetServiceRequest setScopes(Collection<Scope> collection) {
        AppMethodBeat.m2504i(89607);
        this.zzsx = (Scope[]) collection.toArray(new Scope[collection.size()]);
        AppMethodBeat.m2505o(89607);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(89608);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.version);
        SafeParcelWriter.writeInt(parcel, 2, this.zzst);
        SafeParcelWriter.writeInt(parcel, 3, this.zzsu);
        SafeParcelWriter.writeString(parcel, 4, this.zzsv, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzsw, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzsx, i, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzsy, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzsz, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, this.zzta, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, this.zztb, i, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zztc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(89608);
    }
}
