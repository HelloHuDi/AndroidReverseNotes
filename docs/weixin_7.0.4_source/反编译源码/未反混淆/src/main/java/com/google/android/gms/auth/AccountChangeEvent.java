package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "AccountChangeEventCreator")
public class AccountChangeEvent extends AbstractSafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new zzd();
    @VersionField(id = 1)
    private final int zzh;
    @Field(id = 2)
    private final long zzi;
    @Field(id = 3)
    private final String zzj;
    @Field(id = 4)
    private final int zzk;
    @Field(id = 5)
    private final int zzl;
    @Field(id = 6)
    private final String zzm;

    static {
        AppMethodBeat.i(76927);
        AppMethodBeat.o(76927);
    }

    @Constructor
    AccountChangeEvent(@Param(id = 1) int i, @Param(id = 2) long j, @Param(id = 3) String str, @Param(id = 4) int i2, @Param(id = 5) int i3, @Param(id = 6) String str2) {
        AppMethodBeat.i(76921);
        this.zzh = i;
        this.zzi = j;
        this.zzj = (String) Preconditions.checkNotNull(str);
        this.zzk = i2;
        this.zzl = i3;
        this.zzm = str2;
        AppMethodBeat.o(76921);
    }

    public AccountChangeEvent(long j, String str, int i, int i2, String str2) {
        AppMethodBeat.i(76922);
        this.zzh = 1;
        this.zzi = j;
        this.zzj = (String) Preconditions.checkNotNull(str);
        this.zzk = i;
        this.zzl = i2;
        this.zzm = str2;
        AppMethodBeat.o(76922);
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(76926);
        if (obj == this) {
            AppMethodBeat.o(76926);
            return true;
        } else if (obj instanceof AccountChangeEvent) {
            AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
            if (this.zzh == accountChangeEvent.zzh && this.zzi == accountChangeEvent.zzi && Objects.equal(this.zzj, accountChangeEvent.zzj) && this.zzk == accountChangeEvent.zzk && this.zzl == accountChangeEvent.zzl && Objects.equal(this.zzm, accountChangeEvent.zzm)) {
                AppMethodBeat.o(76926);
                return true;
            }
            AppMethodBeat.o(76926);
            return false;
        } else {
            AppMethodBeat.o(76926);
            return false;
        }
    }

    public String getAccountName() {
        return this.zzj;
    }

    public String getChangeData() {
        return this.zzm;
    }

    public int getChangeType() {
        return this.zzk;
    }

    public int getEventIndex() {
        return this.zzl;
    }

    public int hashCode() {
        AppMethodBeat.i(76925);
        int hashCode = Objects.hashCode(Integer.valueOf(this.zzh), Long.valueOf(this.zzi), this.zzj, Integer.valueOf(this.zzk), Integer.valueOf(this.zzl), this.zzm);
        AppMethodBeat.o(76925);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(76924);
        Object obj = "UNKNOWN";
        switch (this.zzk) {
            case 1:
                obj = "ADDED";
                break;
            case 2:
                obj = "REMOVED";
                break;
            case 3:
                obj = "RENAMED_FROM";
                break;
            case 4:
                obj = "RENAMED_TO";
                break;
        }
        String str = this.zzj;
        String str2 = this.zzm;
        String stringBuilder = new StringBuilder(((String.valueOf(str).length() + 91) + String.valueOf(obj).length()) + String.valueOf(str2).length()).append("AccountChangeEvent {accountName = ").append(str).append(", changeType = ").append(obj).append(", changeData = ").append(str2).append(", eventIndex = ").append(this.zzl).append("}").toString();
        AppMethodBeat.o(76924);
        return stringBuilder;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(76923);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzh);
        SafeParcelWriter.writeLong(parcel, 2, this.zzi);
        SafeParcelWriter.writeString(parcel, 3, this.zzj, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzk);
        SafeParcelWriter.writeInt(parcel, 5, this.zzl);
        SafeParcelWriter.writeString(parcel, 6, this.zzm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(76923);
    }
}
