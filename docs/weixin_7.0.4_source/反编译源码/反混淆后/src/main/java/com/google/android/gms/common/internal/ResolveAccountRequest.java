package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "ResolveAccountRequestCreator")
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new ResolveAccountRequestCreator();
    @VersionField(id = 1)
    private final int zzal;
    @Field(getter = "getAccount", id = 2)
    private final Account zzs;
    @Field(getter = "getSessionId", id = 3)
    private final int zzut;
    @Field(getter = "getSignInAccountHint", id = 4)
    private final GoogleSignInAccount zzuu;

    static {
        AppMethodBeat.m2504i(61360);
        AppMethodBeat.m2505o(61360);
    }

    @Constructor
    ResolveAccountRequest(@Param(id = 1) int i, @Param(id = 2) Account account, @Param(id = 3) int i2, @Param(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.zzal = i;
        this.zzs = account;
        this.zzut = i2;
        this.zzuu = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account getAccount() {
        return this.zzs;
    }

    public int getSessionId() {
        return this.zzut;
    }

    public GoogleSignInAccount getSignInAccountHint() {
        return this.zzuu;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61359);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, getAccount(), i, false);
        SafeParcelWriter.writeInt(parcel, 3, getSessionId());
        SafeParcelWriter.writeParcelable(parcel, 4, getSignInAccountHint(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(61359);
    }
}
