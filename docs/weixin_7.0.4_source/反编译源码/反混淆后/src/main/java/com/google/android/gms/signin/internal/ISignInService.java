package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.IResolveAccountCallbacks;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.internal.stable.zza;
import com.google.android.gms.internal.stable.zzb;
import com.google.android.gms.internal.stable.zzc;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface ISignInService extends IInterface {

    public static abstract class Stub extends zzb implements ISignInService {

        public static class Proxy extends zza implements ISignInService {
            Proxy(IBinder iBinder) {
                super(iBinder, "com.google.android.gms.signin.internal.ISignInService");
            }

            public void authAccount(AuthAccountRequest authAccountRequest, ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.m2504i(61671);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) authAccountRequest);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iSignInCallbacks);
                transactAndReadExceptionReturnVoid(2, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61671);
            }

            public void clearAccountFromSessionStore(int i) {
                AppMethodBeat.m2504i(61675);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                transactAndReadExceptionReturnVoid(7, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61675);
            }

            public void getCurrentAccount(ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.m2504i(61679);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iSignInCallbacks);
                transactAndReadExceptionReturnVoid(11, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61679);
            }

            public void onCheckServerAuthorization(CheckServerAuthResult checkServerAuthResult) {
                AppMethodBeat.m2504i(61672);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) checkServerAuthResult);
                transactAndReadExceptionReturnVoid(3, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61672);
            }

            public void onUploadServerAuthCode(boolean z) {
                AppMethodBeat.m2504i(61673);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(4, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61673);
            }

            public void recordConsent(RecordConsentRequest recordConsentRequest, ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.m2504i(61678);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) recordConsentRequest);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iSignInCallbacks);
                transactAndReadExceptionReturnVoid(10, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61678);
            }

            public void resolveAccount(ResolveAccountRequest resolveAccountRequest, IResolveAccountCallbacks iResolveAccountCallbacks) {
                AppMethodBeat.m2504i(61674);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) resolveAccountRequest);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iResolveAccountCallbacks);
                transactAndReadExceptionReturnVoid(5, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61674);
            }

            public void saveAccountToSessionStore(int i, Account account, ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.m2504i(61676);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                obtainAndWriteInterfaceToken.writeInt(i);
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) account);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iSignInCallbacks);
                transactAndReadExceptionReturnVoid(8, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61676);
            }

            public void saveDefaultAccountToSharedPref(IAccountAccessor iAccountAccessor, int i, boolean z) {
                AppMethodBeat.m2504i(61677);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iAccountAccessor);
                obtainAndWriteInterfaceToken.writeInt(i);
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(9, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61677);
            }

            public void setGamesHasBeenGreeted(boolean z) {
                AppMethodBeat.m2504i(61681);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, z);
                transactAndReadExceptionReturnVoid(13, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61681);
            }

            public void signIn(SignInRequest signInRequest, ISignInCallbacks iSignInCallbacks) {
                AppMethodBeat.m2504i(61680);
                Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
                zzc.zza(obtainAndWriteInterfaceToken, (Parcelable) signInRequest);
                zzc.zza(obtainAndWriteInterfaceToken, (IInterface) iSignInCallbacks);
                transactAndReadExceptionReturnVoid(12, obtainAndWriteInterfaceToken);
                AppMethodBeat.m2505o(61680);
            }
        }

        public Stub() {
            super("com.google.android.gms.signin.internal.ISignInService");
        }

        public static ISignInService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
            return queryLocalInterface instanceof ISignInService ? (ISignInService) queryLocalInterface : new Proxy(iBinder);
        }

        public boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 2:
                    authAccount((AuthAccountRequest) zzc.zza(parcel, AuthAccountRequest.CREATOR), com.google.android.gms.signin.internal.ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 3:
                    onCheckServerAuthorization((CheckServerAuthResult) zzc.zza(parcel, CheckServerAuthResult.CREATOR));
                    break;
                case 4:
                    onUploadServerAuthCode(zzc.zza(parcel));
                    break;
                case 5:
                    resolveAccount((ResolveAccountRequest) zzc.zza(parcel, ResolveAccountRequest.CREATOR), com.google.android.gms.common.internal.IResolveAccountCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 7:
                    clearAccountFromSessionStore(parcel.readInt());
                    break;
                case 8:
                    saveAccountToSessionStore(parcel.readInt(), (Account) zzc.zza(parcel, Account.CREATOR), com.google.android.gms.signin.internal.ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 9:
                    saveDefaultAccountToSharedPref(com.google.android.gms.common.internal.IAccountAccessor.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt(), zzc.zza(parcel));
                    break;
                case 10:
                    recordConsent((RecordConsentRequest) zzc.zza(parcel, RecordConsentRequest.CREATOR), com.google.android.gms.signin.internal.ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 11:
                    getCurrentAccount(com.google.android.gms.signin.internal.ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 12:
                    signIn((SignInRequest) zzc.zza(parcel, SignInRequest.CREATOR), com.google.android.gms.signin.internal.ISignInCallbacks.Stub.asInterface(parcel.readStrongBinder()));
                    break;
                case 13:
                    setGamesHasBeenGreeted(zzc.zza(parcel));
                    break;
                default:
                    return false;
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void authAccount(AuthAccountRequest authAccountRequest, ISignInCallbacks iSignInCallbacks);

    void clearAccountFromSessionStore(int i);

    void getCurrentAccount(ISignInCallbacks iSignInCallbacks);

    void onCheckServerAuthorization(CheckServerAuthResult checkServerAuthResult);

    void onUploadServerAuthCode(boolean z);

    void recordConsent(RecordConsentRequest recordConsentRequest, ISignInCallbacks iSignInCallbacks);

    void resolveAccount(ResolveAccountRequest resolveAccountRequest, IResolveAccountCallbacks iResolveAccountCallbacks);

    void saveAccountToSessionStore(int i, Account account, ISignInCallbacks iSignInCallbacks);

    void saveDefaultAccountToSharedPref(IAccountAccessor iAccountAccessor, int i, boolean z);

    void setGamesHasBeenGreeted(boolean z);

    void signIn(SignInRequest signInRequest, ISignInCallbacks iSignInCallbacks);
}
