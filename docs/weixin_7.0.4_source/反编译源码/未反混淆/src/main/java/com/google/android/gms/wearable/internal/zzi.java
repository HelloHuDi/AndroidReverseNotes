package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "AmsEntityUpdateParcelableCreator")
@Reserved({1})
public final class zzi extends AbstractSafeParcelable {
    public static final Creator<zzi> CREATOR = new zzj();
    @Field(getter = "getValue", id = 4)
    private final String value;
    @Field(getter = "getEntityId", id = 2)
    private byte zzbd;
    @Field(getter = "getAttributeId", id = 3)
    private final byte zzbe;

    static {
        AppMethodBeat.i(71447);
        AppMethodBeat.o(71447);
    }

    @Constructor
    public zzi(@Param(id = 2) byte b, @Param(id = 3) byte b2, @Param(id = 4) String str) {
        this.zzbd = b;
        this.zzbe = b2;
        this.value = str;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(71445);
        if (this == obj) {
            AppMethodBeat.o(71445);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(71445);
            return false;
        } else {
            zzi zzi = (zzi) obj;
            if (this.zzbd != zzi.zzbd) {
                AppMethodBeat.o(71445);
                return false;
            } else if (this.zzbe != zzi.zzbe) {
                AppMethodBeat.o(71445);
                return false;
            } else if (this.value.equals(zzi.value)) {
                AppMethodBeat.o(71445);
                return true;
            } else {
                AppMethodBeat.o(71445);
                return false;
            }
        }
    }

    public final int hashCode() {
        AppMethodBeat.i(71446);
        int hashCode = ((((this.zzbd + 31) * 31) + this.zzbe) * 31) + this.value.hashCode();
        AppMethodBeat.o(71446);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(71444);
        byte b = this.zzbd;
        byte b2 = this.zzbe;
        String str = this.value;
        String stringBuilder = new StringBuilder(String.valueOf(str).length() + 73).append("AmsEntityUpdateParcelable{, mEntityId=").append(b).append(", mAttributeId=").append(b2).append(", mValue='").append(str).append('\'').append('}').toString();
        AppMethodBeat.o(71444);
        return stringBuilder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71443);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, this.zzbd);
        SafeParcelWriter.writeByte(parcel, 3, this.zzbe);
        SafeParcelWriter.writeString(parcel, 4, this.value, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71443);
    }
}
