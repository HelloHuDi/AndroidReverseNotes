package com.google.android.gms.internal.stable;

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

    /* Access modifiers changed, original: protected */
    public Parcel obtainAndWriteInterfaceToken() {
        AppMethodBeat.m2504i(90457);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.m2505o(90457);
        return obtain;
    }

    /* Access modifiers changed, original: protected */
    public Parcel transactAndReadException(int i, Parcel parcel) {
        AppMethodBeat.m2504i(90458);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i, parcel, obtain, 0);
            obtain.readException();
            parcel.recycle();
            AppMethodBeat.m2505o(90458);
            return obtain;
        } catch (RuntimeException e) {
            obtain.recycle();
            AppMethodBeat.m2505o(90458);
            throw e;
        } catch (Throwable th) {
            parcel.recycle();
            AppMethodBeat.m2505o(90458);
        }
    }

    /* Access modifiers changed, original: protected */
    public void transactAndReadExceptionReturnVoid(int i, Parcel parcel) {
        AppMethodBeat.m2504i(90459);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.m2505o(90459);
        }
    }

    /* Access modifiers changed, original: protected */
    public void transactOneway(int i, Parcel parcel) {
        AppMethodBeat.m2504i(90460);
        try {
            this.zza.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
            AppMethodBeat.m2505o(90460);
        }
    }
}
