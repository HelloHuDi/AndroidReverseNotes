package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class GoogleSignInResult implements Result {
    private Status mStatus;
    private GoogleSignInAccount zzen;

    public GoogleSignInResult(GoogleSignInAccount googleSignInAccount, Status status) {
        this.zzen = googleSignInAccount;
        this.mStatus = status;
    }

    public GoogleSignInAccount getSignInAccount() {
        return this.zzen;
    }

    public Status getStatus() {
        return this.mStatus;
    }

    public boolean isSuccess() {
        AppMethodBeat.m2504i(50396);
        boolean isSuccess = this.mStatus.isSuccess();
        AppMethodBeat.m2505o(50396);
        return isSuccess;
    }
}
