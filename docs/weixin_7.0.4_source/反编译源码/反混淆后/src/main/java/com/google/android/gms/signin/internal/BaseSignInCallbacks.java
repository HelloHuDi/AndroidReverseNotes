package com.google.android.gms.signin.internal;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.signin.internal.ISignInCallbacks.Stub;

public class BaseSignInCallbacks extends Stub {
    public void onAuthAccountComplete(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
    }

    public void onGetCurrentAccountComplete(Status status, GoogleSignInAccount googleSignInAccount) {
    }

    public void onRecordConsentComplete(Status status) {
    }

    public void onSaveAccountToSessionStoreComplete(Status status) {
    }

    public void onSignInComplete(SignInResponse signInResponse) {
    }
}
