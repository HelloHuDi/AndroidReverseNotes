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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "EventParcelCreator")
@Reserved({1})
public final class zzeu extends AbstractSafeParcelable {
    public static final Creator<zzeu> CREATOR = new zzev();
    @Field(id = 2)
    public final String name;
    @Field(id = 4)
    public final String origin;
    @Field(id = 3)
    public final zzer zzafq;
    @Field(id = 5)
    public final long zzagb;

    static {
        AppMethodBeat.m2504i(68748);
        AppMethodBeat.m2505o(68748);
    }

    zzeu(zzeu zzeu, long j) {
        AppMethodBeat.m2504i(68745);
        Preconditions.checkNotNull(zzeu);
        this.name = zzeu.name;
        this.zzafq = zzeu.zzafq;
        this.origin = zzeu.origin;
        this.zzagb = j;
        AppMethodBeat.m2505o(68745);
    }

    @Constructor
    public zzeu(@Param(id = 2) String str, @Param(id = 3) zzer zzer, @Param(id = 4) String str2, @Param(id = 5) long j) {
        this.name = str;
        this.zzafq = zzer;
        this.origin = str2;
        this.zzagb = j;
    }

    public final String toString() {
        AppMethodBeat.m2504i(68746);
        String str = this.origin;
        String str2 = this.name;
        String valueOf = String.valueOf(this.zzafq);
        str = new StringBuilder(((String.valueOf(str).length() + 21) + String.valueOf(str2).length()) + String.valueOf(valueOf).length()).append("origin=").append(str).append(",name=").append(str2).append(",params=").append(valueOf).toString();
        AppMethodBeat.m2505o(68746);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(68747);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.name, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzafq, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.origin, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzagb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(68747);
    }
}
