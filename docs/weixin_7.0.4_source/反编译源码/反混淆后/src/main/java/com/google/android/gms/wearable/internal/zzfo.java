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
import com.google.android.gms.wearable.Node;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "NodeParcelableCreator")
@Reserved({1})
public final class zzfo extends AbstractSafeParcelable implements Node {
    public static final Creator<zzfo> CREATOR = new zzfp();
    @Field(getter = "getDisplayName", id = 3)
    private final String zzbk;
    @Field(getter = "getId", id = 2)
    private final String zzdm;
    @Field(getter = "getHopCount", id = 4)
    private final int zzen;
    @Field(getter = "isNearby", id = 5)
    private final boolean zzeo;

    static {
        AppMethodBeat.m2504i(71332);
        AppMethodBeat.m2505o(71332);
    }

    @Constructor
    public zzfo(@Param(id = 2) String str, @Param(id = 3) String str2, @Param(id = 4) int i, @Param(id = 5) boolean z) {
        this.zzdm = str;
        this.zzbk = str2;
        this.zzen = i;
        this.zzeo = z;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(71329);
        if (obj instanceof zzfo) {
            boolean equals = ((zzfo) obj).zzdm.equals(this.zzdm);
            AppMethodBeat.m2505o(71329);
            return equals;
        }
        AppMethodBeat.m2505o(71329);
        return false;
    }

    public final String getDisplayName() {
        return this.zzbk;
    }

    public final String getId() {
        return this.zzdm;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(71330);
        int hashCode = this.zzdm.hashCode();
        AppMethodBeat.m2505o(71330);
        return hashCode;
    }

    public final boolean isNearby() {
        return this.zzeo;
    }

    public final String toString() {
        AppMethodBeat.m2504i(71331);
        String str = this.zzbk;
        String str2 = this.zzdm;
        int i = this.zzen;
        str = new StringBuilder((String.valueOf(str).length() + 45) + String.valueOf(str2).length()).append("Node{").append(str).append(", id=").append(str2).append(", hops=").append(i).append(", isNearby=").append(this.zzeo).append("}").toString();
        AppMethodBeat.m2505o(71331);
        return str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(71328);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getId(), false);
        SafeParcelWriter.writeString(parcel, 3, getDisplayName(), false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzen);
        SafeParcelWriter.writeBoolean(parcel, 5, isNearby());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.m2505o(71328);
    }
}
