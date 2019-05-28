package com.google.android.gms.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public interface IOfflineAccessCallbacks extends IInterface {

    public static abstract class Stub extends zzb implements IOfflineAccessCallbacks {

        public static class Proxy extends zza implements IOfflineAccessCallbacks {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
            }

            public void checkServerAuthorization(String str, List<Scope> list, ISignInService iSignInService) {
                AppMethodBeat.m2504i(61664);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeTypedList(list);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iSignInService);
                transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61664);
            }

            public void uploadServerAuthCode(String str, String str2, ISignInService iSignInService) {
                AppMethodBeat.m2504i(61665);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeString(str);
                obtainAndWriteInterfaceToken.writeString(str2);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iSignInService);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61665);
            }
        }

        public Stub() {
            super("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
        }

        public static IOfflineAccessCallbacks asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.IOfflineAccessCallbacks");
            return queryLocalInterface instanceof IOfflineAccessCallbacks ? (IOfflineAccessCallbacks) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 2:
                    checkServerAuthorization(parcel.readString(), parcel.createTypedArrayList(Scope.CREATOR), com.google.android.gms.signin.internal.ISignInService.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 3:
                    uploadServerAuthCode(parcel.readString(), parcel.readString(), com.google.android.gms.signin.internal.ISignInService.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void checkServerAuthorization(String str, List<Scope> list, ISignInService iSignInService);

    void uploadServerAuthCode(String str, String str2, ISignInService iSignInService);
}
