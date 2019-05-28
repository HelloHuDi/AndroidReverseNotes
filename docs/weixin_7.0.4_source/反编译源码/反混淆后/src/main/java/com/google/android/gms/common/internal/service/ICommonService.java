package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ICommonService extends IInterface {

    public static abstract class Stub extends zzb implements ICommonService {

        public static class Proxy extends zza implements ICommonService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
            }

            public void clearDefaultAccount(ICommonCallbacks iCommonCallbacks) {
                AppMethodBeat.m2504i(61398);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iCommonCallbacks);
                transactOneway(1, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61398);
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.service.ICommonService");
        }

        public static ICommonService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return queryLocalInterface instanceof ICommonService ? (ICommonService) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                return false;
            }
            clearDefaultAccount(com.google.android.gms.common.internal.service.ICommonCallbacks.Stub.asInterface(parcel.readStrongBinder()));
            return true;
        }
    }

    void clearDefaultAccount(ICommonCallbacks iCommonCallbacks);
}
