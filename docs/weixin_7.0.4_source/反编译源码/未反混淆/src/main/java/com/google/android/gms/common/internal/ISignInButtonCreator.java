package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ISignInButtonCreator extends IInterface {

    public static abstract class Stub extends zzb implements ISignInButtonCreator {

        public static class Proxy extends zza implements ISignInButtonCreator {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
            }

            public IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int i, int i2) {
                AppMethodBeat.i(61352);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeInt(i2);
                obtainAndWriteInterfaceToken = transactAndReadException(1, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(obtainAndWriteInterfaceToken.readStrongBinder());
                obtainAndWriteInterfaceToken.recycle();
                AppMethodBeat.o(61352);
                return asInterface;
            }

            public IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig) {
                AppMethodBeat.i(61353);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iObjectWrapper);
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) signInButtonConfig);
                obtainAndWriteInterfaceToken = transactAndReadException(2, obtainAndWriteInterfaceToken);
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(obtainAndWriteInterfaceToken.readStrongBinder());
                obtainAndWriteInterfaceToken.recycle();
                AppMethodBeat.o(61353);
                return asInterface;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.ISignInButtonCreator");
        }

        public static ISignInButtonCreator asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
            return queryLocalInterface instanceof ISignInButtonCreator ? (ISignInButtonCreator) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            IInterface newSignInButton;
            switch (i) {
                case 1:
                    newSignInButton = newSignInButton(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    zzc.zza(parcel2, newSignInButton);
                    break;
                case 2:
                    newSignInButton = newSignInButtonFromConfig(com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (SignInButtonConfig) zzc.zza(parcel, SignInButtonConfig.CREATOR));
                    parcel2.writeNoException();
                    zzc.zza(parcel2, newSignInButton);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper newSignInButton(IObjectWrapper iObjectWrapper, int i, int i2);

    IObjectWrapper newSignInButtonFromConfig(IObjectWrapper iObjectWrapper, SignInButtonConfig signInButtonConfig);
}
