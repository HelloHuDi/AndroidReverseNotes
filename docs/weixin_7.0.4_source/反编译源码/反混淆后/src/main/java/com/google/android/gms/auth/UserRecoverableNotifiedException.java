package com.google.android.gms.auth;

import com.google.android.gms.common.util.VisibleForTesting;

public class UserRecoverableNotifiedException extends GoogleAuthException {
    @VisibleForTesting
    public UserRecoverableNotifiedException(String str) {
        super(str);
    }
}
