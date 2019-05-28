package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class zzn implements IInterface {
    private final IBinder zzqi;
    private final String zzqj;

    protected zzn(IBinder iBinder, String str) {
        this.zzqi = iBinder;
        this.zzqj = str;
    }

    public IBinder asBinder() {
        return this.zzqi;
    }

    /* Access modifiers changed, original: protected|final */
    public final Parcel obtainAndWriteInterfaceToken() {
        AppMethodBeat.i(3522);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzqj);
        AppMethodBeat.o(3522);
        return obtain;
    }

    /* Access modifiers changed, original: protected|final */
    public final Parcel transactAndReadException(int i, Parcel parcel) {
        AppMethodBeat.i(3523);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzqi.transact(i, parcel, obtain, 0);
            obtain.readException();
            parcel.recycle();
            AppMethodBeat.o(3523);
            return obtain;
        } catch (RuntimeException e) {
            obtain.recycle();
            AppMethodBeat.o(3523);
            throw e;
        } catch (Throwable th) {
            parcel.recycle();
            AppMethodBeat.o(3523);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactAndReadExceptionReturnVoid(int i, Parcel parcel) {
        AppMethodBeat.i(3524);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzqi.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.o(3524);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactOneway(int i, Parcel parcel) {
        AppMethodBeat.i(3525);
        try {
            this.zzqi.transact(1, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.o(3525);
        }
    }
}
