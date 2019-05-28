package com.google.android.gms.internal.ads_identifier;

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
        AppMethodBeat.m2504i(115344);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.m2505o(115344);
        return obtain;
    }

    /* Access modifiers changed, original: protected|final */
    public final Parcel transactAndReadException(int i, Parcel parcel) {
        AppMethodBeat.m2504i(115345);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i, parcel, obtain, 0);
            obtain.readException();
            parcel.recycle();
            AppMethodBeat.m2505o(115345);
            return obtain;
        } catch (RuntimeException e) {
            obtain.recycle();
            AppMethodBeat.m2505o(115345);
            throw e;
        } catch (Throwable th) {
            parcel.recycle();
            AppMethodBeat.m2505o(115345);
        }
    }
}
