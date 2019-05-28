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
import com.google.android.gms.wearable.MessageEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;

@Class(creator = "MessageEventParcelableCreator")
@Reserved({1})
public final class zzfe extends AbstractSafeParcelable implements MessageEvent {
    public static final Creator<zzfe> CREATOR = new zzff();
    @Field(getter = "getData", id = 4)
    private final byte[] data;
    @Field(getter = "getPath", id = 3)
    private final String zzcl;
    @Field(getter = "getRequestId", id = 2)
    private final int zzeh;
    @Field(getter = "getSourceNodeId", id = 5)
    private final String zzek;

    static {
        AppMethodBeat.i(71312);
        AppMethodBeat.o(71312);
    }

    @Constructor
    public zzfe(@Param(id = 2) int i, @Param(id = 3) String str, @Param(id = 4) byte[] bArr, @Param(id = 5) String str2) {
        this.zzeh = i;
        this.zzcl = str;
        this.data = bArr;
        this.zzek = str2;
    }

    public final byte[] getData() {
        return this.data;
    }

    public final String getPath() {
        return this.zzcl;
    }

    public final int getRequestId() {
        return this.zzeh;
    }

    public final String getSourceNodeId() {
        return this.zzek;
    }

    public final String toString() {
        AppMethodBeat.i(71311);
        int i = this.zzeh;
        String str = this.zzcl;
        String valueOf = String.valueOf(this.data == null ? BuildConfig.COMMAND : Integer.valueOf(this.data.length));
        valueOf = new StringBuilder((String.valueOf(str).length() + 43) + String.valueOf(valueOf).length()).append("MessageEventParcelable[").append(i).append(",").append(str).append(", size=").append(valueOf).append("]").toString();
        AppMethodBeat.o(71311);
        return valueOf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71310);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, getRequestId());
        SafeParcelWriter.writeString(parcel, 3, getPath(), false);
        SafeParcelWriter.writeByteArray(parcel, 4, getData(), false);
        SafeParcelWriter.writeString(parcel, 5, getSourceNodeId(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71310);
    }
}
