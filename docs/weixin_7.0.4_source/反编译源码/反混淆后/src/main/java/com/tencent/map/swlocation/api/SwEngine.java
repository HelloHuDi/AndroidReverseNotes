package com.tencent.map.swlocation.api;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.p081b.p082a.p083a.C31915q;
import com.p081b.p082a.p083a.C8501t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SwEngine {
    public static void startContinousLocationUpdate(Handler handler, int i, int i2, LocationUpdateListener locationUpdateListener, ServerMessageListener serverMessageListener) {
        AppMethodBeat.m2504i(55531);
        C8501t.m15104a(handler, (long) i2, locationUpdateListener, serverMessageListener);
        AppMethodBeat.m2505o(55531);
    }

    public static void stopContinousLocationUpdate() {
        AppMethodBeat.m2504i(55532);
        C8501t.m15105wt();
        AppMethodBeat.m2505o(55532);
    }

    public static void creatLocationEngine(Context context, C31915q c31915q) {
        AppMethodBeat.m2504i(55533);
        C8501t.m15103a(context, c31915q);
        AppMethodBeat.m2505o(55533);
    }

    public static void setImei(String str) {
        AppMethodBeat.m2504i(55534);
        if (TextUtils.isEmpty(str)) {
            NullPointerException nullPointerException = new NullPointerException("SenseWhereEngine:invalid imei!");
            AppMethodBeat.m2505o(55534);
            throw nullPointerException;
        }
        C8501t.setImei(str);
        AppMethodBeat.m2505o(55534);
    }

    public static void onDestroy() {
        AppMethodBeat.m2504i(55535);
        C8501t.finish();
        AppMethodBeat.m2505o(55535);
    }
}
