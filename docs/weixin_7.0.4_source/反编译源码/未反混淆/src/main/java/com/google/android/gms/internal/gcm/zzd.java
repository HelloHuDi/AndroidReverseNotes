package com.google.android.gms.internal.gcm;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzd implements IInterface {
    private final IBinder zzd;
    private final String zze;

    protected zzd(IBinder iBinder, String str) {
        this.zzd = iBinder;
        this.zze = str;
    }

    public IBinder asBinder() {
        return this.zzd;
    }

    /* Access modifiers changed, original: protected|final */
    public final Parcel obtainAndWriteInterfaceToken() {
        AppMethodBeat.i(57618);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zze);
        AppMethodBeat.o(57618);
        return obtain;
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactAndReadExceptionReturnVoid(int i, Parcel parcel) {
        AppMethodBeat.i(57619);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzd.transact(2, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.o(57619);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactOneway(int i, Parcel parcel) {
        AppMethodBeat.i(57620);
        try {
            this.zzd.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.o(57620);
        }
    }
}
