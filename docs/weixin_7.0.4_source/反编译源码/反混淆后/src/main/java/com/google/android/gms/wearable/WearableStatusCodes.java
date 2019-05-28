package com.google.android.gms.wearable;

import com.google.android.gms.common.api.CommonStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class WearableStatusCodes extends CommonStatusCodes {
    public static final int ASSET_UNAVAILABLE = 4005;
    public static final int DATA_ITEM_TOO_LARGE = 4003;
    public static final int DUPLICATE_CAPABILITY = 4006;
    public static final int DUPLICATE_LISTENER = 4001;
    public static final int INVALID_TARGET_NODE = 4004;
    public static final int TARGET_NODE_NOT_CONNECTED = 4000;
    public static final int UNKNOWN_CAPABILITY = 4007;
    public static final int UNKNOWN_LISTENER = 4002;
    public static final int WIFI_CREDENTIAL_SYNC_NO_CREDENTIAL_FETCHED = 4008;

    private WearableStatusCodes() {
    }

    public static String getStatusCodeString(int i) {
        AppMethodBeat.m2504i(70938);
        String str;
        switch (i) {
            case TARGET_NODE_NOT_CONNECTED /*4000*/:
                str = "TARGET_NODE_NOT_CONNECTED";
                AppMethodBeat.m2505o(70938);
                return str;
            case DUPLICATE_LISTENER /*4001*/:
                str = "DUPLICATE_LISTENER";
                AppMethodBeat.m2505o(70938);
                return str;
            case UNKNOWN_LISTENER /*4002*/:
                str = "UNKNOWN_LISTENER";
                AppMethodBeat.m2505o(70938);
                return str;
            case DATA_ITEM_TOO_LARGE /*4003*/:
                str = "DATA_ITEM_TOO_LARGE";
                AppMethodBeat.m2505o(70938);
                return str;
            case INVALID_TARGET_NODE /*4004*/:
                str = "INVALID_TARGET_NODE";
                AppMethodBeat.m2505o(70938);
                return str;
            case ASSET_UNAVAILABLE /*4005*/:
                str = "ASSET_UNAVAILABLE";
                AppMethodBeat.m2505o(70938);
                return str;
            default:
                str = CommonStatusCodes.getStatusCodeString(i);
                AppMethodBeat.m2505o(70938);
                return str;
        }
    }
}
