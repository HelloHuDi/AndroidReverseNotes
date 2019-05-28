package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "AppMetadataCreator")
@Reserved({1})
public final class zzdz extends AbstractSafeParcelable {
    public static final Creator<zzdz> CREATOR = new zzea();
    @Field(id = 2)
    public final String packageName;
    @Field(id = 3)
    public final String zzadm;
    @Field(id = 12)
    public final String zzado;
    @Field(defaultValueUnchecked = "Integer.MIN_VALUE", id = 11)
    public final long zzads;
    @Field(id = 5)
    public final String zzadt;
    @Field(id = 6)
    public final long zzadu;
    @Field(id = 7)
    public final long zzadv;
    @Field(defaultValue = "true", id = 9)
    public final boolean zzadw;
    @Field(id = 13)
    public final long zzadx;
    @Field(defaultValue = "true", id = 16)
    public final boolean zzady;
    @Field(defaultValue = "true", id = 17)
    public final boolean zzadz;
    @Field(id = 8)
    public final String zzaek;
    @Field(id = 10)
    public final boolean zzael;
    @Field(id = 14)
    public final long zzaem;
    @Field(id = 15)
    public final int zzaen;
    @Field(id = 18)
    public final boolean zzaeo;
    @Field(id = 4)
    public final String zzth;

    static {
        AppMethodBeat.i(68582);
        AppMethodBeat.o(68582);
    }

    zzdz(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, boolean z5) {
        AppMethodBeat.i(68580);
        Preconditions.checkNotEmpty(str);
        this.packageName = str;
        if (TextUtils.isEmpty(str2)) {
            str2 = null;
        }
        this.zzadm = str2;
        this.zzth = str3;
        this.zzads = j;
        this.zzadt = str4;
        this.zzadu = j2;
        this.zzadv = j3;
        this.zzaek = str5;
        this.zzadw = z;
        this.zzael = z2;
        this.zzado = str6;
        this.zzadx = j4;
        this.zzaem = j5;
        this.zzaen = i;
        this.zzady = z3;
        this.zzadz = z4;
        this.zzaeo = z5;
        AppMethodBeat.o(68580);
    }

    @Constructor
    zzdz(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) String str3, @Param(id = 5) String str4, @Param(id = 6) long j, @Param(id = 7) long j2, @Param(id = 8) String str5, @Param(id = 9) boolean z, @Param(id = 10) boolean z2, @Param(id = 11) long j3, @Param(id = 12) String str6, @Param(id = 13) long j4, @Param(id = 14) long j5, @Param(id = 15) int i, @Param(id = 16) boolean z3, @Param(id = 17) boolean z4, @Param(id = 18) boolean z5) {
        this.packageName = str;
        this.zzadm = str2;
        this.zzth = str3;
        this.zzads = j3;
        this.zzadt = str4;
        this.zzadu = j;
        this.zzadv = j2;
        this.zzaek = str5;
        this.zzadw = z;
        this.zzael = z2;
        this.zzado = str6;
        this.zzadx = j4;
        this.zzaem = j5;
        this.zzaen = i;
        this.zzady = z3;
        this.zzadz = z4;
        this.zzaeo = z5;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(68581);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.packageName, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzadm, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzth, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzadt, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zzadu);
        SafeParcelWriter.writeLong(parcel, 7, this.zzadv);
        SafeParcelWriter.writeString(parcel, 8, this.zzaek, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzadw);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzael);
        SafeParcelWriter.writeLong(parcel, 11, this.zzads);
        SafeParcelWriter.writeString(parcel, 12, this.zzado, false);
        SafeParcelWriter.writeLong(parcel, 13, this.zzadx);
        SafeParcelWriter.writeLong(parcel, 14, this.zzaem);
        SafeParcelWriter.writeInt(parcel, 15, this.zzaen);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzady);
        SafeParcelWriter.writeBoolean(parcel, 17, this.zzadz);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzaeo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(68581);
    }
}
