package com.google.android.gms.internal.wearable;

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
        AppMethodBeat.i(70665);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.o(70665);
        return obtain;
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactAndReadExceptionReturnVoid(int i, Parcel parcel) {
        AppMethodBeat.i(70666);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.o(70666);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactOneway(int i, Parcel parcel) {
        AppMethodBeat.i(70667);
        try {
            this.zza.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.o(70667);
        }
    }
}
