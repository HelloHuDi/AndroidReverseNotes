package com.google.android.gms.internal.firebase_messaging;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb;

    protected zza(IBinder iBinder, String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    public IBinder asBinder() {
        return this.zza;
    }

    /* Access modifiers changed, original: protected|final */
    public final Parcel obtainAndWriteInterfaceToken() {
        AppMethodBeat.m2504i(108671);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.m2505o(108671);
        return obtain;
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactOneway(int i, Parcel parcel) {
        AppMethodBeat.m2504i(108672);
        try {
            this.zza.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.m2505o(108672);
        }
    }
}
