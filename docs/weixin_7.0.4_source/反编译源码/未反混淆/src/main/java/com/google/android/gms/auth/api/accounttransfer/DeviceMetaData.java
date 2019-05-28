package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "DeviceMetaDataCreator")
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Creator<DeviceMetaData> CREATOR = new zzy();
    @Field(getter = "isLockScreenSolved", id = 2)
    private boolean zzcc;
    @Field(getter = "getMinAgeOfLockScreen", id = 3)
    private long zzcd;
    @Field(getter = "isChallengeAllowed", id = 4)
    private final boolean zzce;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(76991);
        AppMethodBeat.o(76991);
    }

    @Constructor
    DeviceMetaData(@Param(id = 1) int i, @Param(id = 2) boolean z, @Param(id = 3) long j, @Param(id = 4) boolean z2) {
        this.zzy = i;
        this.zzcc = z;
        this.zzcd = j;
        this.zzce = z2;
    }

    public long getMinAgeOfLockScreen() {
        return this.zzcd;
    }

    public boolean isChallengeAllowed() {
        return this.zzce;
    }

    public boolean isLockScreenSolved() {
        return this.zzcc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(76990);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeBoolean(parcel, 2, isLockScreenSolved());
        SafeParcelWriter.writeLong(parcel, 3, getMinAgeOfLockScreen());
        SafeParcelWriter.writeBoolean(parcel, 4, isChallengeAllowed());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(76990);
    }
}
