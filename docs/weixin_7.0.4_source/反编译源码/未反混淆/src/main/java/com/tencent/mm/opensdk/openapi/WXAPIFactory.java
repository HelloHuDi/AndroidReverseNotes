package com.tencent.mm.opensdk.openapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.Log;

public class WXAPIFactory {
    private static final String TAG = "MicroMsg.PaySdk.WXFactory";

    private WXAPIFactory() {
        AppMethodBeat.i(128079);
        RuntimeException runtimeException = new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
        AppMethodBeat.o(128079);
        throw runtimeException;
    }

    public static IWXAPI createWXAPI(Context context, String str) {
        AppMethodBeat.i(128077);
        IWXAPI createWXAPI = createWXAPI(context, str, true);
        AppMethodBeat.o(128077);
        return createWXAPI;
    }

    public static IWXAPI createWXAPI(Context context, String str, boolean z) {
        AppMethodBeat.i(128078);
        Log.d(TAG, "createWXAPI, appId = " + str + ", checkSignature = " + z);
        WXApiImplV10 wXApiImplV10 = new WXApiImplV10(context, str, z);
        AppMethodBeat.o(128078);
        return wXApiImplV10;
    }
}
