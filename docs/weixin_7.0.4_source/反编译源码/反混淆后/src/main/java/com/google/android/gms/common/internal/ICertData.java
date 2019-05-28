package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ICertData extends IInterface {

    public static abstract class Stub extends zzb implements ICertData {

        public static class Proxy extends zza implements ICertData {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.ICertData");
            }

            public IObjectWrapper getBytesWrapped() {
                AppMethodBeat.m2504i(89668);
                Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken());
                IObjectWrapper asInterface = com.google.android.gms.dynamic.IObjectWrapper.Stub.asInterface(transactAndReadException.readStrongBinder());
                transactAndReadException.recycle();
                AppMethodBeat.m2505o(89668);
                return asInterface;
            }

            public int getHashCode() {
                AppMethodBeat.m2504i(89669);
                Parcel transactAndReadException = transactAndReadException(2, obtainAndWriteInterfaceToken());
                int readInt = transactAndReadException.readInt();
                transactAndReadException.recycle();
                AppMethodBeat.m2505o(89669);
                return readInt;
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.ICertData");
        }

        public static ICertData asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
            return queryLocalInterface instanceof ICertData ? (ICertData) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    IInterface bytesWrapped = getBytesWrapped();
                    parcel2.writeNoException();
                    zzc.zza(parcel2, bytesWrapped);
                    break;
                case 2:
                    int hashCode = getHashCode();
                    parcel2.writeNoException();
                    parcel2.writeInt(hashCode);
                    break;
                default:
                    return false;
            }
            return true;
        }
    }

    IObjectWrapper getBytesWrapped();

    int getHashCode();
}
