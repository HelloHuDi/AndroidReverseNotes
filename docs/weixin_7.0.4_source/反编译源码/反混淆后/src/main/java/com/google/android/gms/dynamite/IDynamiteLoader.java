package com.google.android.gms.dynamite;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IDynamiteLoader extends IInterface {

    public static abstract class Stub extends zzb implements IDynamiteLoader {

        public static class Proxy extends zza implements IDynamiteLoader {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
            }

            public IObjectWrapper createModuleContext(IObjectWrapper iObjectWrapper, String str, int i) {
                AppMethodBeat.m2504i(90444);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken = transactAndReadException(2, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(obtainAndWriteInterfaceToken.readStrongBinder());
                obtainAndWriteInterfaceToken.recycle();
                AppMethodBeat.m2505o(90444);
                return asInterface;
            }

            public int getModuleVersion(IObjectWrapper iObjectWrapper, String str) {
                AppMethodBeat.m2504i(90443);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken = transactAndReadException(1, obtainAndWriteInterfaceToken);
                int readInt = obtainAndWriteInterfaceToken.readInt();
                obtainAndWriteInterfaceToken.recycle();
                AppMethodBeat.m2505o(90443);
                return readInt;
            }

            public int getModuleVersion2(IObjectWrapper iObjectWrapper, String str, boolean z) {
                AppMethodBeat.m2504i(90445);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                obtainAndWriteInterfaceToken.writeString(str);
                zzc.zza(obtainAndWriteInterfaceToken, z);
                obtainAndWriteInterfaceToken = transactAndReadException(3, obtainAndWriteInterfaceToken);
                int readInt = obtainAndWriteInterfaceToken.readInt();
                obtainAndWriteInterfaceToken.recycle();
                AppMethodBeat.m2505o(90445);
                return readInt;
            }
        }

        public Stub() {
            super("com.google.android.gms.dynamite.IDynamiteLoader");
        }

        public static IDynamiteLoader asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
            return queryLocalInterface instanceof IDynamiteLoader ? (IDynamiteLoader) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            int moduleVersion;
            switch (i) {
                case 1:
                    moduleVersion = getModuleVersion(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(moduleVersion);
                    break;
                case 2:
                    IInterface createModuleContext = createModuleContext(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    zzc.zza(parcel2, createModuleContext);
                    break;
                case 3:
                    moduleVersion = getModuleVersion2(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzc.zza(parcel));
                    parcel2.writeNoException();
                    parcel2.writeInt(moduleVersion);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper createModuleContext(IObjectWrapper iObjectWrapper, String str, int i);

    int getModuleVersion(IObjectWrapper iObjectWrapper, String str);

    int getModuleVersion2(IObjectWrapper iObjectWrapper, String str, boolean z);
}
