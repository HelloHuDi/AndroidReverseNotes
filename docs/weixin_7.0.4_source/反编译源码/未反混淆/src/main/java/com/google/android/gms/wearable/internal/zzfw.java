package com.google.android.gms.wearable.internal;

import android.os.IBinder;
import android.os.IInterface;
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

@Class(creator = "RemoveListenerRequestCreator")
public final class zzfw extends AbstractSafeParcelable {
    public static final Creator<zzfw> CREATOR = new zzfx();
    @VersionField(id = 1)
    private final int versionCode;
    @Field(getter = "getListenerAsBinder", id = 2, type = "android.os.IBinder")
    private final zzem zzaz;

    static {
        AppMethodBeat.i(71345);
        AppMethodBeat.o(71345);
    }

    @Constructor
    zzfw(@Param(id = 1) int i, @Param(id = 2) IBinder iBinder) {
        zzem zzem = null;
        AppMethodBeat.i(71343);
        this.versionCode = i;
        if (iBinder != null) {
            if (iBinder != null) {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
                zzem = queryLocalInterface instanceof zzem ? (zzem) queryLocalInterface : new zzeo(iBinder);
            }
            this.zzaz = zzem;
            AppMethodBeat.o(71343);
            return;
        }
        this.zzaz = null;
        AppMethodBeat.o(71343);
    }

    public zzfw(zzem zzem) {
        this.versionCode = 1;
        this.zzaz = zzem;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71344);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzaz == null ? null : this.zzaz.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71344);
    }
}
