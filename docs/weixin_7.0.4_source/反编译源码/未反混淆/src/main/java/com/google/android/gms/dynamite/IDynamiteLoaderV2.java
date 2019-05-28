package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IDynamiteLoaderV2 extends IInterface {

    public static abstract class Stub extends zzb implements IDynamiteLoaderV2 {

        public static class Proxy extends zza implements IDynamiteLoaderV2 {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
            }

            public IObjectWrapper loadModule(IObjectWrapper iObjectWrapper, String str, byte[] bArr) {
                AppMethodBeat.i(90446);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeByteArray(bArr);
                obtainAndWriteInterfaceToken = transactAndReadException(1, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(obtainAndWriteInterfaceToken.readStrongBinder());
                obtainAndWriteInterfaceToken.recycle();
                AppMethodBeat.o(90446);
                return asInterface;
            }

            public IObjectWrapper loadModule2(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2) {
                AppMethodBeat.i(90447);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeInt(i);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper2);
                obtainAndWriteInterfaceToken = transactAndReadException(2, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(obtainAndWriteInterfaceToken.readStrongBinder());
                obtainAndWriteInterfaceToken.recycle();
                AppMethodBeat.o(90447);
                return asInterface;
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        }

        public static IDynamiteLoaderV2 asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
            return queryLocalInterface instanceof IDynamiteLoaderV2 ? (IDynamiteLoaderV2) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            IInterface loadModule;
            switch (i) {
                case 1:
                    loadModule = loadModule(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.createByteArray());
                    parcel2.writeNoException();
                    zzc.zza(parcel2, loadModule);
                    break;
                case 2:
                    loadModule = loadModule2(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt(), com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, loadModule);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper loadModule(IObjectWrapper iObjectWrapper, String str, byte[] bArr);

    IObjectWrapper loadModule2(IObjectWrapper iObjectWrapper, String str, int i, IObjectWrapper iObjectWrapper2);
}
