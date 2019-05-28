package com.tencent.p177mm.plugin.appbrand.jsapi.p303d;

import android.os.Looper;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.widget.input.C19875h;
import com.tencent.p177mm.plugin.appbrand.widget.input.C38609w;
import com.tencent.p177mm.sdk.platformtools.C5039bj;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.d.f */
public final class C33287f extends C19497u<C44709u> {
    private static final int CTRL_INDEX = -2;
    private static final String NAME = "restoreWebviewFocus";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(123543);
        final C44709u c44709u = (C44709u) c2241c;
        final boolean optBoolean = jSONObject.optBoolean("focus", false);
        new C5039bj<Void>() {
            public final /* synthetic */ Object run() {
                AppMethodBeat.m2504i(123542);
                C44709u c44709u = c44709u;
                boolean z = optBoolean;
                C19875h.aQx().mo35114d(c44709u.aJz());
                View contentView = c44709u.aJz().getContentView();
                if (z) {
                    C38609w cO = C38609w.m65442cO(contentView);
                    if (cO != null) {
                        cO.setShowDoneButton(false);
                    }
                    contentView.requestFocus();
                }
                AppMethodBeat.m2505o(123542);
                return null;
            }
        }.mo10372b(new C7306ak(Looper.getMainLooper()));
        String j = mo73394j("ok", null);
        AppMethodBeat.m2505o(123543);
        return j;
    }
}
