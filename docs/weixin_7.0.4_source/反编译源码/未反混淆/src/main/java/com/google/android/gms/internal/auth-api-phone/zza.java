package com.google.android.gms.internal.auth-api-phone;

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
        AppMethodBeat.i(80424);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.o(80424);
        return obtain;
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactAndReadExceptionReturnVoid(int i, Parcel parcel) {
        AppMethodBeat.i(80425);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(1, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.o(80425);
        }
    }
}
