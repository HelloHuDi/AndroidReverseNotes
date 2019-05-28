package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@Class(creator = "AddListenerRequestCreator")
@Reserved({1})
public final class zzd extends AbstractSafeParcelable {
    public static final Creator<zzd> CREATOR = new zze();
    @Field(getter = "getListenerAsBinder", id = 2, type = "android.os.IBinder")
    private final zzem zzaz;
    @Field(id = 3)
    private final IntentFilter[] zzba;
    @Field(id = 4)
    @Nullable
    private final String zzbb;
    @Field(id = 5)
    @Nullable
    private final String zzbc;

    static {
        AppMethodBeat.i(71186);
        AppMethodBeat.o(71186);
    }

    @Constructor
    zzd(@Param(id = 2) IBinder iBinder, @Param(id = 3) IntentFilter[] intentFilterArr, @Param(id = 4) @Nullable String str, @Param(id = 5) @Nullable String str2) {
        zzem zzem = null;
        AppMethodBeat.i(71183);
        if (iBinder != null) {
            if (iBinder != null) {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.wearable.internal.IWearableListener");
                zzem = queryLocalInterface instanceof zzem ? (zzem) queryLocalInterface : new zzeo(iBinder);
            }
            this.zzaz = zzem;
        } else {
            this.zzaz = null;
        }
        this.zzba = intentFilterArr;
        this.zzbb = str;
        this.zzbc = str2;
        AppMethodBeat.o(71183);
    }

    public zzd(zzhk zzhk) {
        AppMethodBeat.i(71184);
        this.zzaz = zzhk;
        this.zzba = zzhk.zze();
        this.zzbb = zzhk.zzf();
        this.zzbc = null;
        AppMethodBeat.o(71184);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(71185);
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzaz == null ? null : this.zzaz.asBinder(), false);
        SafeParcelWriter.writeTypedArray(parcel, 3, this.zzba, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzbb, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbc, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        AppMethodBeat.o(71185);
    }
}
