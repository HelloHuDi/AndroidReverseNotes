package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Result;

public interface CredentialRequestResult extends Result {
    Credential getCredential();
}
