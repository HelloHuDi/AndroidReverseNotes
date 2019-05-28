package com.google.android.gms.auth.api.accounttransfer;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class AccountTransferStatusCodes extends CommonStatusCodes {
    public static final int CHALLENGE_NOT_ALLOWED = 20503;
    public static final int INVALID_REQUEST = 20502;
    public static final int NOT_ALLOWED_SECURITY = 20500;
    public static final int NO_DATA_AVAILABLE = 20501;
    public static final int SESSION_INACTIVE = 20504;

    private AccountTransferStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        AppMethodBeat.m2504i(76989);
        String str;
        switch (i) {
            case NOT_ALLOWED_SECURITY /*20500*/:
                str = "NOT_ALLOWED_SECURITY";
                AppMethodBeat.m2505o(76989);
                return str;
            case NO_DATA_AVAILABLE /*20501*/:
                str = "NO_DATA_AVAILABLE";
                AppMethodBeat.m2505o(76989);
                return str;
            case INVALID_REQUEST /*20502*/:
                str = "INVALID_REQUEST";
                AppMethodBeat.m2505o(76989);
                return str;
            case CHALLENGE_NOT_ALLOWED /*20503*/:
                str = "CHALLENGE_NOT_ALLOWED";
                AppMethodBeat.m2505o(76989);
                return str;
            case SESSION_INACTIVE /*20504*/:
                str = "SESSION_INACTIVE";
                AppMethodBeat.m2505o(76989);
                return str;
            default:
                str = CommonStatusCodes.getStatusCodeString(i);
                AppMethodBeat.m2505o(76989);
                return str;
        }
    }
}
