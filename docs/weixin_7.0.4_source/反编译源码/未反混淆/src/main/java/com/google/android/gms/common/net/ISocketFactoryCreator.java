package com.google.android.gms.common.net;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ISocketFactoryCreator extends IInterface {

    public static abstract class Stub extends zzb implements ISocketFactoryCreator {

        public static class Proxy extends zza implements ISocketFactoryCreator {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.net.ISocketFactoryCreator");
            }

            public IObjectWrapper newSocketFactory(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, boolean z) {
                AppMethodBeat.i(89897);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper3);
                zzc.zza(obtainAndWriteInterfaceToken, z);
                obtainAndWriteInterfaceToken = transactAndReadException(1, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(obtainAndWriteInterfaceToken.readStrongBinder());
                obtainAndWriteInterfaceToken.recycle();
                AppMethodBeat.o(89897);
                return asInterface;
            }

            public IObjectWrapper newSocketFactoryWithCacheDir(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, String str) {
                AppMethodBeat.i(89898);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper3);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken = transactAndReadException(2, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(obtainAndWriteInterfaceToken.readStrongBinder());
                obtainAndWriteInterfaceToken.recycle();
                AppMethodBeat.o(89898);
                return asInterface;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.net.ISocketFactoryCreator");
        }

        public static ISocketFactoryCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.net.ISocketFactoryCreator");
            return queryLocalInterface instanceof ISocketFactoryCreator ? (ISocketFactoryCreator) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            IInterface newSocketFactory;
            switch (i) {
                case 1:
                    newSocketFactory = newSocketFactory(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzc.zza(parcel));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, newSocketFactory);
                    break;
                case 2:
                    newSocketFactory = newSocketFactoryWithCacheDir(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    zzc.zza(parcel2, newSocketFactory);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper newSocketFactory(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, boolean z);

    IObjectWrapper newSocketFactoryWithCacheDir(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, String str);
}
