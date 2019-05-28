package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
@Class(creator = "ScopeCreator")
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<Scope> CREATOR = new zzd();
    @VersionField(id = 1)
    private final int zzal;
    @Field(getter = "getScopeUri", id = 2)
    private final String zzdp;

    static {
        AppMethodBeat.i(89451);
        AppMethodBeat.o(89451);
    }

    @Constructor
    Scope(@Param(id = 1) int i, @Param(id = 2) String str) {
        AppMethodBeat.i(89447);
        Preconditions.checkNotEmpty(str, "scopeUri must not be null or empty");
        this.zzal = i;
        this.zzdp = str;
        AppMethodBeat.o(89447);
    }

    public Scope(String str) {
        this(1, str);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(89448);
        if (this == obj) {
            AppMethodBeat.o(89448);
            return true;
        } else if (obj instanceof Scope) {
            boolean equals = this.zzdp.equals(((Scope) obj).zzdp);
            AppMethodBeat.o(89448);
            return equals;
        } else {
            AppMethodBeat.o(89448);
            return false;
        }
    }

    @KeepForSdk
    public final String getScopeUri() {
        return this.zzdp;
    }

    public final int hashCode() {
        AppMethodBeat.i(89449);
        int hashCode = this.zzdp.hashCode();
        AppMethodBeat.o(89449);
        return hashCode;
    }

    public final String toString() {
        return this.zzdp;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(89450);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeString(parcel, 2, getScopeUri(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(89450);
    }
}
