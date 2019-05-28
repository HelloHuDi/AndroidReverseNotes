package com.google.android.gms.internal.p1161auth-api-phone;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.gms.internal.auth-api-phone.zza */
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
        AppMethodBeat.m2504i(80424);
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        AppMethodBeat.m2505o(80424);
        return obtain;
    }

    /* Access modifiers changed, original: protected|final */
    public final void transactAndReadExceptionReturnVoid(int i, Parcel parcel) {
        AppMethodBeat.m2504i(80425);
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(1, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
            AppMethodBeat.m2505o(80425);
        }
    }
}
