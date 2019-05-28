package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.ad */
public final class C19282ad extends C33229ac<C19722s> {
    /* renamed from: b */
    public final /* synthetic */ Bitmap mo34478b(C38492q c38492q) {
        AppMethodBeat.m2504i(130407);
        Bitmap d = m29947d((C19722s) c38492q);
        AppMethodBeat.m2505o(130407);
        return d;
    }

    /* renamed from: d */
    private Bitmap m29947d(C19722s c19722s) {
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(130406);
        C4990ab.m7417i("MicroMsg.JsApiCaptureScreenWC", "getBitmapFromView appId:%s, isGame:%b", r1.mAppId, Boolean.valueOf(c19722s.getRuntime().mo65903xy()));
        if (c19722s.getRuntime().mo65903xy()) {
            try {
                bitmap = ((C42439b) c19722s).getMBRuntime().getCanvasHandler().mo4006a(null, true);
            } catch (Exception e) {
            }
            AppMethodBeat.m2505o(130406);
            return bitmap;
        }
        bitmap = super.mo34478b(c19722s);
        AppMethodBeat.m2505o(130406);
        return bitmap;
    }
}
