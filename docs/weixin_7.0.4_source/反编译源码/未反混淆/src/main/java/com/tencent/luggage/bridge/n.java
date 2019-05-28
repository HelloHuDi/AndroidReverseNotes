package com.tencent.luggage.bridge;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import org.json.JSONObject;

final class n {
    private o bOA;
    private Handler bOB;

    n(o oVar) {
        AppMethodBeat.i(90732);
        this.bOA = oVar;
        HandlerThread handlerThread = new HandlerThread("AsyncJSThread");
        handlerThread.start();
        this.bOB = new Handler(handlerThread.getLooper());
        AppMethodBeat.o(90732);
    }

    /* Access modifiers changed, original: final */
    public final String h(final String str, boolean z) {
        AppMethodBeat.i(90733);
        String i;
        if (z) {
            i = i(str, true);
            AppMethodBeat.o(90733);
            return i;
        }
        this.bOB.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(90730);
                n.this.i(str, false);
                AppMethodBeat.o(90730);
            }
        });
        i = "";
        AppMethodBeat.o(90733);
        return i;
    }

    /* Access modifiers changed, original: final */
    public final String i(String str, boolean z) {
        AppMethodBeat.i(90734);
        m bv = bv(str);
        String str2;
        if (bv == null) {
            str2 = "";
            AppMethodBeat.o(90734);
            return str2;
        }
        d.i("Js2JavaMessageQueue", "processImpl, jsMsg.type = %s", bv.wJ().name());
        e eVar = null;
        switch (bv.wJ()) {
            case READY:
                this.bOA.bOH.wL();
                break;
            case INVOKE:
                eVar = this.bOA.a(bv, z);
                break;
            case EVENT:
                this.bOA.a(bv);
                break;
            case CALLBACK:
                this.bOA.b(bv);
                break;
        }
        String str3 = "Js2JavaMessageQueue";
        String str4 = "processImpl, javaMsg.type = %s";
        Object[] objArr = new Object[1];
        objArr[0] = eVar == null ? BuildConfig.COMMAND : eVar.wJ().name();
        d.v(str3, str4, objArr);
        if (eVar == null) {
            str2 = "";
            AppMethodBeat.o(90734);
            return str2;
        }
        str2 = eVar.toString();
        AppMethodBeat.o(90734);
        return str2;
    }

    private static m bv(String str) {
        AppMethodBeat.i(90735);
        try {
            m mVar = new m(new JSONObject(str));
            AppMethodBeat.o(90735);
            return mVar;
        } catch (Exception e) {
            d.e("Js2JavaMessageQueue", "Message parse failed, ex = %s", e.getMessage());
            AppMethodBeat.o(90735);
            return null;
        }
    }
}
