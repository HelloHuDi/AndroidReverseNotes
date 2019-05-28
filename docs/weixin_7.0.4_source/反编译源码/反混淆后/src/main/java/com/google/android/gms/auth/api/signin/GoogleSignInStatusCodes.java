package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class GoogleSignInStatusCodes extends CommonStatusCodes {
    public static final int SIGN_IN_CANCELLED = 12501;
    public static final int SIGN_IN_CURRENTLY_IN_PROGRESS = 12502;
    public static final int SIGN_IN_FAILED = 12500;

    private GoogleSignInStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        AppMethodBeat.m2504i(50397);
        String str;
        switch (i) {
            case SIGN_IN_FAILED /*12500*/:
                str = "A non-recoverable sign in failure occurred";
                AppMethodBeat.m2505o(50397);
                return str;
            case SIGN_IN_CANCELLED /*12501*/:
                str = "Sign in action cancelled";
                AppMethodBeat.m2505o(50397);
                return str;
            case SIGN_IN_CURRENTLY_IN_PROGRESS /*12502*/:
                str = "Sign-in in progress";
                AppMethodBeat.m2505o(50397);
                return str;
            default:
                str = CommonStatusCodes.getStatusCodeString(i);
                AppMethodBeat.m2505o(50397);
                return str;
        }
    }
}
