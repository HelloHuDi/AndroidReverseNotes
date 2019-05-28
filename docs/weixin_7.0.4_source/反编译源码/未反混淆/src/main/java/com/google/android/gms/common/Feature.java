package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "FeatureCreator")
public class Feature extends AbstractSafeParcelable {
    public static final Creator<Feature> CREATOR = new FeatureCreator();
    @Field(getter = "getName", id = 1)
    private final String name;
    @Field(getter = "getOldVersion", id = 2)
    @Deprecated
    private final int zzaq;
    @Field(defaultValue = "-1", getter = "getVersion", id = 3)
    private final long zzar;

    static {
        AppMethodBeat.i(89356);
        AppMethodBeat.o(89356);
    }

    @Constructor
    public Feature(@Param(id = 1) String str, @Param(id = 2) int i, @Param(id = 3) long j) {
        this.name = str;
        this.zzaq = i;
        this.zzar = j;
    }

    public Feature(String str, long j) {
        this.name = str;
        this.zzar = j;
        this.zzaq = -1;
    }

    public boolean equals(Object obj) {
        AppMethodBeat.i(89353);
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() == null || !getName().equals(feature.getName())) && !(getName() == null && feature.getName() == null)) || getVersion() != feature.getVersion()) {
                AppMethodBeat.o(89353);
                return false;
            }
            AppMethodBeat.o(89353);
            return true;
        }
        AppMethodBeat.o(89353);
        return false;
    }

    public String getName() {
        return this.name;
    }

    public long getVersion() {
        return this.zzar == -1 ? (long) this.zzaq : this.zzar;
    }

    public int hashCode() {
        AppMethodBeat.i(89354);
        int hashCode = Objects.hashCode(getName(), Long.valueOf(getVersion()));
        AppMethodBeat.o(89354);
        return hashCode;
    }

    public String toString() {
        AppMethodBeat.i(89355);
        String toStringHelper = Objects.toStringHelper(this).add("name", getName()).add("version", Long.valueOf(getVersion())).toString();
        AppMethodBeat.o(89355);
        return toStringHelper;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(89352);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzaq);
        SafeParcelWriter.writeLong(parcel, 3, getVersion());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(89352);
    }
}
