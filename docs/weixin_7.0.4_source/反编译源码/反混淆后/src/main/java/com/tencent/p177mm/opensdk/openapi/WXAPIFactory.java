package com.tencent.p177mm.opensdk.openapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.utils.Log;

/* renamed from: com.tencent.mm.opensdk.openapi.WXAPIFactory */
public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        AppMethodBeat.m2504i(128079);
        RuntimeException runtimeException = new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
        AppMethodBeat.m2505o(128079);
        throw runtimeException;
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        AppMethodBeat.m2504i(128077);
        IWXAPI createWXAPI = WXAPIFactory.createWXAPI(context, str, true);
        AppMethodBeat.m2505o(128077);
        return createWXAPI;
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        AppMethodBeat.m2504i(128078);
        Log.m4139d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z);
        WXApiImplV10 wXApiImplV10 = new WXApiImplV10(context, str, z);
        AppMethodBeat.m2505o(128078);
        return wXApiImplV10;
    }
}
