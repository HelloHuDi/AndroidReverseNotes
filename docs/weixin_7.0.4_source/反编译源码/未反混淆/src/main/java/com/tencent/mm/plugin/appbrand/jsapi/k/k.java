package com.tencent.mm.plugin.appbrand.jsapi.k;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.math.BigDecimal;
import org.json.JSONObject;

public final class k extends u<d> {
    private static final int CTRL_INDEX = 413;
    public static final String NAME = "scrollWebviewTo";

    public final /* synthetic */ String b(c cVar, JSONObject jSONObject) {
        AppMethodBeat.i(74758);
        String a = a((d) cVar, jSONObject);
        AppMethodBeat.o(74758);
        return a;
    }

    private String a(d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(74757);
        com.tencent.mm.plugin.appbrand.page.u currentPageView = dVar instanceof com.tencent.mm.plugin.appbrand.page.u ? (com.tencent.mm.plugin.appbrand.page.u) dVar : dVar instanceof q ? ((q) dVar).getCurrentPageView() : null;
        String j;
        if (currentPageView == null) {
            j = j("fail:page don't exist", null);
            AppMethodBeat.o(74757);
            return j;
        }
        final long optLong = jSONObject.optLong(FFmpegMetadataRetriever.METADATA_KEY_DURATION, 300);
        if (jSONObject.has("scrollTop")) {
            try {
                final int round = Math.round(g.av(new BigDecimal(jSONObject.getString("scrollTop")).floatValue()));
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(74756);
                        currentPageView.aJz().z(round, optLong);
                        AppMethodBeat.o(74756);
                    }
                });
                j = j("ok", null);
                AppMethodBeat.o(74757);
                return j;
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrand.Jsapi_scrollWebviewTo", "opt scrollTop, e = %s", e);
                j = j("fail:invalid data " + bo.nullAsNil(e.getMessage()), null);
                AppMethodBeat.o(74757);
                return j;
            }
        }
        j = j("fail:invalid data", null);
        AppMethodBeat.o(74757);
        return j;
    }
}
