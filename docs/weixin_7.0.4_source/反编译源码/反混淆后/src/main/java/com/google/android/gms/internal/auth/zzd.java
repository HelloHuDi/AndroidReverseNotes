package com.google.android.gms.internal.auth;

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
        AppMethodBeat.m2504i(77114);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zze);
        AppMethodBeat.m2505o(77114);
        return obtain;
    }

    /* Access modifiers changed, original: protected|final */
    public final Parcel transactAndReadException(int i, Parcel parcel) {
        AppMethodBeat.m2504i(77115);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzd.transact(i, parcel, obtain, 0);
            obtain.readException();
            parcel.recycle();
            AppMethodBeat.m2505o(77115);
            return obtain;
        } catch (RuntimeException e) {
            obtain.recycle();
            AppMethodBeat.m2505o(77115);
            throw e;
        } catch (Throwable th) {
            parcel.recycle();
            AppMethodBeat.m2505o(77115);
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactAndReadExceptionReturnVoid(int i, Parcel parcel) {
        AppMethodBeat.m2504i(77116);
        Parcel obtain = Parcel.obtain();
        try {
            this.zzd.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.m2505o(77116);
        }
    }
}
