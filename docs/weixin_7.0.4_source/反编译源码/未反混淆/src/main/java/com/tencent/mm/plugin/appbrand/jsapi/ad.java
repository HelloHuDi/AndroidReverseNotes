package com.tencent.mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.b;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.ab;

public final class ad extends ac<s> {
    public final /* synthetic */ Bitmap b(q qVar) {
        AppMethodBeat.i(130407);
        Bitmap d = d((s) qVar);
        AppMethodBeat.o(130407);
        return d;
    }

    private Bitmap d(s sVar) {
        Bitmap bitmap = null;
        AppMethodBeat.i(130406);
        ab.i("MicroMsg.JsApiCaptureScreenWC", "getBitmapFromView appId:%s, isGame:%b", r1.mAppId, Boolean.valueOf(sVar.getRuntime().xy()));
        if (sVar.getRuntime().xy()) {
            try {
                bitmap = ((b) sVar).getMBRuntime().getCanvasHandler().a(null, true);
            } catch (Exception e) {
            }
            AppMethodBeat.o(130406);
            return bitmap;
        }
        bitmap = super.b(sVar);
        AppMethodBeat.o(130406);
        return bitmap;
    }
}
