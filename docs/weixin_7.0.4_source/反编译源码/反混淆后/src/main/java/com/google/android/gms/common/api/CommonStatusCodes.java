package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.iid.InstanceID;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdk
public class CommonStatusCodes {
    public static final int API_NOT_CONNECTED = 17;
    public static final int CANCELED = 16;
    public static final int DEVELOPER_ERROR = 10;
    public static final int ERROR = 13;
    public static final int INTERNAL_ERROR = 8;
    public static final int INTERRUPTED = 14;
    public static final int INVALID_ACCOUNT = 5;
    public static final int NETWORK_ERROR = 7;
    public static final int RESOLUTION_REQUIRED = 6;
    @Deprecated
    public static final int SERVICE_DISABLED = 3;
    @Deprecated
    public static final int SERVICE_VERSION_UPDATE_REQUIRED = 2;
    public static final int SIGN_IN_REQUIRED = 4;
    public static final int SUCCESS = 0;
    public static final int SUCCESS_CACHE = -1;
    public static final int TIMEOUT = 15;

    @KeepForSdk
    protected CommonStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        AppMethodBeat.m2504i(89444);
        String str;
        switch (i) {
            case -1:
                str = "SUCCESS_CACHE";
                AppMethodBeat.m2505o(89444);
                return str;
            case 0:
                str = "SUCCESS";
                AppMethodBeat.m2505o(89444);
                return str;
            case 2:
                str = "SERVICE_VERSION_UPDATE_REQUIRED";
                AppMethodBeat.m2505o(89444);
                return str;
            case 3:
                str = "SERVICE_DISABLED";
                AppMethodBeat.m2505o(89444);
                return str;
            case 4:
                str = "SIGN_IN_REQUIRED";
                AppMethodBeat.m2505o(89444);
                return str;
            case 5:
                str = "INVALID_ACCOUNT";
                AppMethodBeat.m2505o(89444);
                return str;
            case 6:
                str = "RESOLUTION_REQUIRED";
                AppMethodBeat.m2505o(89444);
                return str;
            case 7:
                str = "NETWORK_ERROR";
                AppMethodBeat.m2505o(89444);
                return str;
            case 8:
                str = "INTERNAL_ERROR";
                AppMethodBeat.m2505o(89444);
                return str;
            case 10:
                str = "DEVELOPER_ERROR";
                AppMethodBeat.m2505o(89444);
                return str;
            case 13:
                str = "ERROR";
                AppMethodBeat.m2505o(89444);
                return str;
            case 14:
                str = "INTERRUPTED";
                AppMethodBeat.m2505o(89444);
                return str;
            case 15:
                str = InstanceID.ERROR_TIMEOUT;
                AppMethodBeat.m2505o(89444);
                return str;
            case 16:
                str = "CANCELED";
                AppMethodBeat.m2505o(89444);
                return str;
            case 17:
                str = "API_NOT_CONNECTED";
                AppMethodBeat.m2505o(89444);
                return str;
            case 18:
                str = "DEAD_CLIENT";
                AppMethodBeat.m2505o(89444);
                return str;
            default:
                str = "unknown status code: " + i;
                AppMethodBeat.m2505o(89444);
                return str;
        }
    }
}
