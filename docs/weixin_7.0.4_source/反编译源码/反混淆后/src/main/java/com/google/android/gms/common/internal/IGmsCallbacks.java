package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IGmsCallbacks extends IInterface {

    public static abstract class Stub extends zzb implements IGmsCallbacks {

        public static class Proxy extends zza implements IGmsCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.common.internal.IGmsCallbacks");
            }

            public void onAccountValidationComplete(int i, Bundle bundle) {
                AppMethodBeat.m2504i(89671);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
                transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(89671);
            }

            public void onPostInitComplete(int i, IBinder iBinder, Bundle bundle) {
                AppMethodBeat.m2504i(89670);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeStrongBinder(iBinder);
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) bundle);
                transactAndReadExceptionReturnVoid(1, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(89670);
            }

            public void onPostInitCompleteWithConnectionInfo(int i, IBinder iBinder, ConnectionInfo connectionInfo) {
                AppMethodBeat.m2504i(89672);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                obtainAndWriteInterfaceToken.writeStrongBinder(iBinder);
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) connectionInfo);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(89672);
            }
        }

        public Stub() {
            super("com.google.android.gms.common.internal.IGmsCallbacks");
        }

        public static IGmsCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsCallbacks");
            return queryLocalInterface instanceof IGmsCallbacks ? (IGmsCallbacks) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    onPostInitComplete(parcel.readInt(), parcel.readStrongBinder(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                    break;
                case 2:
                    onAccountValidationComplete(parcel.readInt(), (Bundle) zzc.zza(parcel, Bundle.CREATOR));
                    break;
                case 3:
                    onPostInitCompleteWithConnectionInfo(parcel.readInt(), parcel.readStrongBinder(), (ConnectionInfo) zzc.zza(parcel, ConnectionInfo.CREATOR));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void onAccountValidationComplete(int i, Bundle bundle);

    void onPostInitComplete(int i, IBinder iBinder, Bundle bundle);

    void onPostInitCompleteWithConnectionInfo(int i, IBinder iBinder, ConnectionInfo connectionInfo);
}
