package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;

@Class(creator = "UserChallengeRequestCreator")
public final class zzak extends AbstractSafeParcelable {
    public static final Creator<zzak> CREATOR = new zzal();
    @Field(id = 2)
    private final String accountType;
    @Field(id = 3)
    private final PendingIntent zzch;
    @VersionField(id = 1)
    private final int zzy;

    static {
        AppMethodBeat.i(77099);
        AppMethodBeat.o(77099);
    }

    @Constructor
    zzak(@Param(id = 1) int i, @Param(id = 2) String str, @Param(id = 3) PendingIntent pendingIntent) {
        AppMethodBeat.i(77097);
        this.zzy = 1;
        this.accountType = (String) Preconditions.checkNotNull(str);
        this.zzch = (PendingIntent) Preconditions.checkNotNull(pendingIntent);
        AppMethodBeat.o(77097);
    }

    public zzak(String str, PendingIntent pendingIntent) {
        this(1, str, pendingIntent);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(77098);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzy);
        SafeParcelWriter.writeString(parcel, 2, this.accountType, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzch, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(77098);
    }
}
