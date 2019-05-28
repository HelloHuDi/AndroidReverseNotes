package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Node;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.concurrent.GuardedBy;

@Class(creator = "CapabilityInfoParcelableCreator")
@Reserved({1})
public final class zzah extends AbstractSafeParcelable implements CapabilityInfo {
    public static final Creator<zzah> CREATOR = new zzai();
    private final Object lock = new Object();
    @Field(getter = "getName", id = 2)
    private final String name;
    @GuardedBy("lock")
    private Set<Node> zzbt;
    @Field(getter = "getNodeParcelables", id = 3)
    private final List<zzfo> zzca;

    static {
        AppMethodBeat.i(70995);
        AppMethodBeat.o(70995);
    }

    @Constructor
    public zzah(@Param(id = 2) String str, @Param(id = 3) List<zzfo> list) {
        AppMethodBeat.i(70989);
        this.name = str;
        this.zzca = list;
        this.zzbt = null;
        Preconditions.checkNotNull(this.name);
        Preconditions.checkNotNull(this.zzca);
        AppMethodBeat.o(70989);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(70993);
        if (this == obj) {
            AppMethodBeat.o(70993);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(70993);
            return false;
        } else {
            zzah zzah = (zzah) obj;
            if (this.name == null ? zzah.name != null : !this.name.equals(zzah.name)) {
                AppMethodBeat.o(70993);
                return false;
            } else if (this.zzca == null ? zzah.zzca != null : !this.zzca.equals(zzah.zzca)) {
                AppMethodBeat.o(70993);
                return false;
            } else {
                AppMethodBeat.o(70993);
                return true;
            }
        }
    }

    public final String getName() {
        return this.name;
    }

    public final Set<Node> getNodes() {
        Set<Node> set;
        AppMethodBeat.i(70990);
        synchronized (this.lock) {
            try {
                if (this.zzbt == null) {
                    this.zzbt = new HashSet(this.zzca);
                }
                set = this.zzbt;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(70990);
            }
        }
        return set;
    }

    public final int hashCode() {
        int i = 0;
        AppMethodBeat.i(70994);
        int hashCode = ((this.name != null ? this.name.hashCode() : 0) + 31) * 31;
        if (this.zzca != null) {
            i = this.zzca.hashCode();
        }
        hashCode += i;
        AppMethodBeat.o(70994);
        return hashCode;
    }

    public final String toString() {
        AppMethodBeat.i(70992);
        String str = this.name;
        String valueOf = String.valueOf(this.zzca);
        str = new StringBuilder((String.valueOf(str).length() + 18) + String.valueOf(valueOf).length()).append("CapabilityInfo{").append(str).append(", ").append(valueOf).append("}").toString();
        AppMethodBeat.o(70992);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(70991);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzca, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(70991);
    }
}
