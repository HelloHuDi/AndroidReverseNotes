package com.tencent.map.swlocation.api;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.b.a.a.q;
import com.b.a.a.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwEngine {
    public static void startContinousLocationUpdate(Handler handler, int i, int i2, LocationUpdateListener locationUpdateListener, ServerMessageListener serverMessageListener) {
        AppMethodBeat.i(55531);
        t.a(handler, (long) i2, locationUpdateListener, serverMessageListener);
        AppMethodBeat.o(55531);
    }

    public static void stopContinousLocationUpdate() {
        AppMethodBeat.i(55532);
        t.wt();
        AppMethodBeat.o(55532);
    }

    public static void creatLocationEngine(Context context, q qVar) {
        AppMethodBeat.i(55533);
        t.a(context, qVar);
        AppMethodBeat.o(55533);
    }

    public static void setImei(String str) {
        AppMethodBeat.i(55534);
        if (TextUtils.isEmpty(str)) {
            NullPointerException nullPointerException = new NullPointerException("SenseWhereEngine:invalid imei!");
            AppMethodBeat.o(55534);
            throw nullPointerException;
        }
        t.setImei(str);
        AppMethodBeat.o(55534);
    }

    public static void onDestroy() {
        AppMethodBeat.i(55535);
        t.finish();
        AppMethodBeat.o(55535);
    }
}
