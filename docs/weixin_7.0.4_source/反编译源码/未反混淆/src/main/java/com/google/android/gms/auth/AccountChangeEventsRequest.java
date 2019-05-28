package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "AccountChangeEventsRequestCreator")
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR = new zze();
    @VersionField(id = 1)
    private final int zzh;
    @Field(id = 3)
    @Deprecated
    private String zzj;
    @Field(id = 2)
    private int zzl;
    @Field(id = 4)
    private Account zzn;

    static {
        AppMethodBeat.i(76930);
        AppMethodBeat.o(76930);
    }

    public AccountChangeEventsRequest() {
        this.zzh = 1;
    }

    @Constructor
    AccountChangeEventsRequest(@Param(id = 1) int i, @Param(id = 2) int i2, @Param(id = 3) String str, @Param(id = 4) Account account) {
        AppMethodBeat.i(76928);
        this.zzh = i;
        this.zzl = i2;
        this.zzj = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzn = account;
            AppMethodBeat.o(76928);
            return;
        }
        this.zzn = new Account(str, "com.google");
        AppMethodBeat.o(76928);
    }

    public Account getAccount() {
        return this.zzn;
    }

    @Deprecated
    public String getAccountName() {
        return this.zzj;
    }

    public int getEventIndex() {
        return this.zzl;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzn = account;
        return this;
    }

    @Deprecated
    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzj = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzl = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(76929);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzh);
        SafeParcelWriter.writeInt(parcel, 2, this.zzl);
        SafeParcelWriter.writeString(parcel, 3, this.zzj, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzn, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(76929);
    }
}
