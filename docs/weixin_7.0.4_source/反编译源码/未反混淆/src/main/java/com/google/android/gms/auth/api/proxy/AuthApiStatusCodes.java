package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.annotation.KeepForSdkWithMembers;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

@KeepForSdkWithMembers
public class AuthApiStatusCodes extends CommonStatusCodes {
    public static final int AUTH_API_ACCESS_FORBIDDEN = 3001;
    public static final int AUTH_API_CLIENT_ERROR = 3002;
    public static final int AUTH_API_INVALID_CREDENTIALS = 3000;
    public static final int AUTH_API_SERVER_ERROR = 3003;
    public static final int AUTH_APP_CERT_ERROR = 3006;
    public static final int AUTH_TOKEN_ERROR = 3004;
    public static final int AUTH_URL_RESOLUTION = 3005;

    private AuthApiStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        AppMethodBeat.i(77034);
        String str;
        switch (i) {
            case AUTH_API_INVALID_CREDENTIALS /*3000*/:
                str = "AUTH_API_INVALID_CREDENTIALS";
                AppMethodBeat.o(77034);
                return str;
            case 3001:
                str = "AUTH_API_ACCESS_FORBIDDEN";
                AppMethodBeat.o(77034);
                return str;
            case 3002:
                str = "AUTH_API_CLIENT_ERROR";
                AppMethodBeat.o(77034);
                return str;
            case 3003:
                str = "AUTH_API_SERVER_ERROR";
                AppMethodBeat.o(77034);
                return str;
            case 3004:
                str = "AUTH_TOKEN_ERROR";
                AppMethodBeat.o(77034);
                return str;
            case 3005:
                str = "AUTH_URL_RESOLUTION";
                AppMethodBeat.o(77034);
                return str;
            case AUTH_APP_CERT_ERROR /*3006*/:
                str = "AUTH_APP_CERT_ERROR";
                AppMethodBeat.o(77034);
                return str;
            default:
                str = CommonStatusCodes.getStatusCodeString(i);
                AppMethodBeat.o(77034);
                return str;
        }
    }
}
