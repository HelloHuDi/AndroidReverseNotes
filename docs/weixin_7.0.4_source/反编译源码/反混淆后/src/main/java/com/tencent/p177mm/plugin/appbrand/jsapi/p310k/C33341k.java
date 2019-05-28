package com.tencent.p177mm.plugin.appbrand.jsapi.p310k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C2119d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19497u;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.math.BigDecimal;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.k.k */
public final class C33341k extends C19497u<C2119d> {
    private static final int CTRL_INDEX = 413;
    public static final String NAME = "scrollWebviewTo";

    /* renamed from: b */
    public final /* synthetic */ String mo6145b(C2241c c2241c, JSONObject jSONObject) {
        AppMethodBeat.m2504i(74758);
        String a = m54519a((C2119d) c2241c, jSONObject);
        AppMethodBeat.m2505o(74758);
        return a;
    }

    /* renamed from: a */
    private String m54519a(C2119d c2119d, JSONObject jSONObject) {
        AppMethodBeat.m2504i(74757);
        C44709u currentPageView = c2119d instanceof C44709u ? (C44709u) c2119d : c2119d instanceof C38492q ? ((C38492q) c2119d).getCurrentPageView() : null;
        String j;
        if (currentPageView == null) {
            j = mo73394j("fail:page don't exist", null);
            AppMethodBeat.m2505o(74757);
            return j;
        }
        final long optLong = jSONObject.optLong(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 300);
        if (jSONObject.has("scrollTop")) {
            try {
                final int round = Math.round(C42668g.m75557av(new BigDecimal(jSONObject.getString("scrollTop")).floatValue()));
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(74756);
                        currentPageView.aJz().mo22198z(round, optLong);
                        AppMethodBeat.m2505o(74756);
                    }
                });
                j = mo73394j("ok", null);
                AppMethodBeat.m2505o(74757);
                return j;
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", e);
                j = mo73394j("fail:invalid data " + C5046bo.nullAsNil(e.getMessage()), null);
                AppMethodBeat.m2505o(74757);
                return j;
            }
        }
        j = mo73394j("fail:invalid data", null);
        AppMethodBeat.m2505o(74757);
        return j;
    }
}
