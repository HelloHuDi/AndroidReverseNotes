package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ICommonCallbacks extends IInterface {

    public static abstract class Stub extends zzb implements ICommonCallbacks {

        public static class Proxy extends zza implements ICommonCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.service.ICommonCallbacks");
            }

            public void onDefaultAccountCleared(int i) {
                AppMethodBeat.i(61397);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
                AppMethodBeat.o(61397);
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.service.ICommonCallbacks");
        }

        public static ICommonCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonCallbacks");
            return queryLocalInterface instanceof ICommonCallbacks ? (ICommonCallbacks) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                return false;
            }
            onDefaultAccountCleared(parcel.readInt());
            parcel2.writeNoException();
            return true;
        }
    }

    void onDefaultAccountCleared(int i);
}
