package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.BaseGmsClient.LegacyClientCallbackAdapter;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.signin.SignInClient;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.ISignInService.Stub;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SignInClientImpl extends GmsClient<ISignInService> implements SignInClient {
    public static final String ACTION_START_SERVICE = "com.google.android.gms.signin.service.START";
    public static final String INTERNAL_ACTION_START_SERVICE = "com.google.android.gms.signin.service.INTERNAL_START";
    public static final String KEY_AUTH_API_SIGN_IN_MODULE_VERSION = "com.google.android.gms.signin.internal.authApiSignInModuleVersion";
    public static final String KEY_CLIENT_REQUESTED_ACCOUNT = "com.google.android.gms.signin.internal.clientRequestedAccount";
    public static final String KEY_FORCE_CODE_FOR_REFRESH_TOKEN = "com.google.android.gms.signin.internal.forceCodeForRefreshToken";
    public static final String KEY_HOSTED_DOMAIN = "com.google.android.gms.signin.internal.hostedDomain";
    public static final String KEY_ID_TOKEN_REQUESTED = "com.google.android.gms.signin.internal.idTokenRequested";
    @Deprecated
    public static final String KEY_OFFLINE_ACCESS_CALLBACKS = "com.google.android.gms.signin.internal.signInCallbacks";
    public static final String KEY_OFFLINE_ACCESS_REQUESTED = "com.google.android.gms.signin.internal.offlineAccessRequested";
    public static final String KEY_REAL_CLIENT_LIBRARY_VERSION = "com.google.android.gms.signin.internal.realClientLibraryVersion";
    public static final String KEY_REAL_CLIENT_PACKAGE_NAME = "com.google.android.gms.signin.internal.realClientPackageName";
    public static final String KEY_SERVER_CLIENT_ID = "com.google.android.gms.signin.internal.serverClientId";
    public static final String KEY_USE_PROMPT_MODE_FOR_AUTH_CODE = "com.google.android.gms.signin.internal.usePromptModeForAuthCode";
    public static final String KEY_WAIT_FOR_ACCESS_TOKEN_REFRESH = "com.google.android.gms.signin.internal.waitForAccessTokenRefresh";
    private final Bundle zzada;
    private final boolean zzads;
    private final ClientSettings zzgf;
    private Integer zzsc;

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, Bundle bundle, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, clientSettings, connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.i(61687);
        this.zzads = z;
        this.zzgf = clientSettings;
        this.zzada = bundle;
        this.zzsc = clientSettings.getClientSessionId();
        AppMethodBeat.o(61687);
    }

    public SignInClientImpl(Context context, Looper looper, boolean z, ClientSettings clientSettings, SignInOptions signInOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, clientSettings, createBundleFromClientSettings(clientSettings), connectionCallbacks, onConnectionFailedListener);
        AppMethodBeat.i(61688);
        AppMethodBeat.o(61688);
    }

    public static Bundle createBundleFromClientSettings(ClientSettings clientSettings) {
        AppMethodBeat.i(61695);
        SignInOptions signInOptions = clientSettings.getSignInOptions();
        Integer clientSessionId = clientSettings.getClientSessionId();
        Bundle bundle = new Bundle();
        bundle.putParcelable(KEY_CLIENT_REQUESTED_ACCOUNT, clientSettings.getAccount());
        if (clientSessionId != null) {
            bundle.putInt(ClientSettings.KEY_CLIENT_SESSION_ID, clientSessionId.intValue());
        }
        if (signInOptions != null) {
            bundle.putBoolean(KEY_OFFLINE_ACCESS_REQUESTED, signInOptions.isOfflineAccessRequested());
            bundle.putBoolean(KEY_ID_TOKEN_REQUESTED, signInOptions.isIdTokenRequested());
            bundle.putString(KEY_SERVER_CLIENT_ID, signInOptions.getServerClientId());
            bundle.putBoolean(KEY_USE_PROMPT_MODE_FOR_AUTH_CODE, true);
            bundle.putBoolean(KEY_FORCE_CODE_FOR_REFRESH_TOKEN, signInOptions.isForceCodeForRefreshToken());
            bundle.putString(KEY_HOSTED_DOMAIN, signInOptions.getHostedDomain());
            bundle.putBoolean(KEY_WAIT_FOR_ACCESS_TOKEN_REFRESH, signInOptions.waitForAccessTokenRefresh());
            if (signInOptions.getAuthApiSignInModuleVersion() != null) {
                bundle.putLong(KEY_AUTH_API_SIGN_IN_MODULE_VERSION, signInOptions.getAuthApiSignInModuleVersion().longValue());
            }
            if (signInOptions.getRealClientLibraryVersion() != null) {
                bundle.putLong(KEY_REAL_CLIENT_LIBRARY_VERSION, signInOptions.getRealClientLibraryVersion().longValue());
            }
        }
        AppMethodBeat.o(61695);
        return bundle;
    }

    public void clearAccountFromSessionStore() {
        AppMethodBeat.i(61690);
        try {
            ((ISignInService) getService()).clearAccountFromSessionStore(this.zzsc.intValue());
            AppMethodBeat.o(61690);
        } catch (RemoteException e) {
            AppMethodBeat.o(61690);
        }
    }

    public void connect() {
        AppMethodBeat.i(61694);
        connect(new LegacyClientCallbackAdapter());
        AppMethodBeat.o(61694);
    }

    /* Access modifiers changed, original: protected */
    public ISignInService createServiceInterface(IBinder iBinder) {
        AppMethodBeat.i(61692);
        ISignInService asInterface = Stub.asInterface(iBinder);
        AppMethodBeat.o(61692);
        return asInterface;
    }

    public Bundle getGetServiceRequestExtraArgs() {
        AppMethodBeat.i(61693);
        if (!getContext().getPackageName().equals(this.zzgf.getRealClientPackageName())) {
            this.zzada.putString(KEY_REAL_CLIENT_PACKAGE_NAME, this.zzgf.getRealClientPackageName());
        }
        Bundle bundle = this.zzada;
        AppMethodBeat.o(61693);
        return bundle;
    }

    public int getMinApkVersion() {
        return 12451000;
    }

    public String getServiceDescriptor() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    public String getStartServiceAction() {
        return ACTION_START_SERVICE;
    }

    public boolean requiresSignIn() {
        return this.zzads;
    }

    public void saveDefaultAccount(IAccountAccessor iAccountAccessor, boolean z) {
        AppMethodBeat.i(61689);
        try {
            ((ISignInService) getService()).saveDefaultAccountToSharedPref(iAccountAccessor, this.zzsc.intValue(), z);
            AppMethodBeat.o(61689);
        } catch (RemoteException e) {
            AppMethodBeat.o(61689);
        }
    }

    public void signIn(ISignInCallbacks iSignInCallbacks) {
        AppMethodBeat.i(61691);
        Preconditions.checkNotNull(iSignInCallbacks, "Expecting a valid ISignInCallbacks");
        try {
            Account accountOrDefault = this.zzgf.getAccountOrDefault();
            GoogleSignInAccount googleSignInAccount = null;
            if ("<<default account>>".equals(accountOrDefault.name)) {
                googleSignInAccount = Storage.getInstance(getContext()).getSavedDefaultGoogleSignInAccount();
            }
            ((ISignInService) getService()).signIn(new SignInRequest(new ResolveAccountRequest(accountOrDefault, this.zzsc.intValue(), googleSignInAccount)), iSignInCallbacks);
            AppMethodBeat.o(61691);
        } catch (RemoteException e) {
            try {
                iSignInCallbacks.onSignInComplete(new SignInResponse(8));
                AppMethodBeat.o(61691);
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
                AppMethodBeat.o(61691);
            }
        }
    }
}
