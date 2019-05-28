package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "UserAttributeParcelCreator")
public final class zzjx extends AbstractSafeParcelable {
    public static final Creator<zzjx> CREATOR = new zzjy();
    @Field(id = 2)
    public final String name;
    @Field(id = 7)
    public final String origin;
    @Field(id = 1)
    private final int versionCode;
    @Field(id = 6)
    private final String zzajf;
    @Field(id = 3)
    public final long zzaqz;
    @Field(id = 4)
    private final Long zzara;
    @Field(id = 5)
    private final Float zzarb;
    @Field(id = 8)
    private final Double zzarc;

    static {
        AppMethodBeat.i(69495);
        AppMethodBeat.o(69495);
    }

    @Constructor
    zzjx(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) long j, @Param(id = 4) Long l, @Param(id = 5) Float f, @Param(id = 6) String str2, @Param(id = 7) String str3, @Param(id = 8) Double d) {
        Double d2 = null;
        AppMethodBeat.i(69493);
        this.versionCode = i;
        this.name = str;
        this.zzaqz = j;
        this.zzara = l;
        this.zzarb = null;
        if (i == 1) {
            if (f != null) {
                d2 = Double.valueOf(f.doubleValue());
            }
            this.zzarc = d2;
        } else {
            this.zzarc = d;
        }
        this.zzajf = str2;
        this.origin = str3;
        AppMethodBeat.o(69493);
    }

    zzjx(zzjz zzjz) {
        this(zzjz.name, zzjz.zzaqz, zzjz.value, zzjz.origin);
    }

    zzjx(String str, long j, Object obj, String str2) {
        AppMethodBeat.i(69492);
        Preconditions.checkNotEmpty(str);
        this.versionCode = 2;
        this.name = str;
        this.zzaqz = j;
        this.origin = str2;
        if (obj == null) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = null;
            AppMethodBeat.o(69492);
        } else if (obj instanceof Long) {
            this.zzara = (Long) obj;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = null;
            AppMethodBeat.o(69492);
        } else if (obj instanceof String) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = null;
            this.zzajf = (String) obj;
            AppMethodBeat.o(69492);
        } else if (obj instanceof Double) {
            this.zzara = null;
            this.zzarb = null;
            this.zzarc = (Double) obj;
            this.zzajf = null;
            AppMethodBeat.o(69492);
        } else {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("User attribute given of un-supported type");
            AppMethodBeat.o(69492);
            throw illegalArgumentException;
        }
    }

    public final Object getValue() {
        return this.zzara != null ? this.zzara : this.zzarc != null ? this.zzarc : this.zzajf != null ? this.zzajf : null;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(69494);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzaqz);
        SafeParcelWriter.writeLongObject(parcel, 4, this.zzara, false);
        SafeParcelWriter.writeFloatObject(parcel, 5, null, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzajf, false);
        SafeParcelWriter.writeString(parcel, 7, this.origin, false);
        SafeParcelWriter.writeDoubleObject(parcel, 8, this.zzarc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(69494);
    }
}
