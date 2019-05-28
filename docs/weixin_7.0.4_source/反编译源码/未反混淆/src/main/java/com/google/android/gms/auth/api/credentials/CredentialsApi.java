package com.google.android.gms.auth.api.credentials;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public interface CredentialsApi {
    public static final int ACTIVITY_RESULT_ADD_ACCOUNT = 1000;
    public static final int ACTIVITY_RESULT_NO_HINTS_AVAILABLE = 1002;
    public static final int ACTIVITY_RESULT_OTHER_ACCOUNT = 1001;
    public static final int CREDENTIAL_PICKER_REQUEST_CODE = 2000;

    PendingResult<Status> delete(GoogleApiClient googleApiClient, Credential credential);

    PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient);

    PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest);

    PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, CredentialRequest credentialRequest);

    PendingResult<Status> save(GoogleApiClient googleApiClient, Credential credential);
}
