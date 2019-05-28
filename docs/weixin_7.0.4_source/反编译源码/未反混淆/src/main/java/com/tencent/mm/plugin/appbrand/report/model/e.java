package com.tencent.mm.plugin.appbrand.report.model;

import android.content.Intent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONObject;

public final class e {
    public static void a(o oVar, JSONObject jSONObject) {
        AppMethodBeat.i(132606);
        try {
            b(oVar, jSONObject);
            jSONObject.put("referpagepath", a.d(oVar.atI().hgF));
            jSONObject.put("clickTimestamp", oVar.atI().startTime);
            AppMethodBeat.o(132606);
        } catch (Exception e) {
            ab.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", e);
            AppMethodBeat.o(132606);
        }
    }

    public static void b(o oVar, JSONObject jSONObject) {
        AppMethodBeat.i(132607);
        jSONObject.put("scene", oVar.ya().bQn.scene);
        jSONObject.put("scene_note", oVar.ya().bQn.cst);
        jSONObject.put("sessionId", oVar.atI().xz());
        jSONObject.put("usedState", oVar.ya().bQn.iAo);
        jSONObject.put("prescene", oVar.ya().bQn.cOq);
        jSONObject.put("prescene_note", oVar.ya().bQn.cOr);
        AppMethodBeat.o(132607);
    }

    public static Pair<Integer, String> l(w wVar) {
        Object obj;
        int i = 7;
        AppMethodBeat.i(132608);
        switch (g.wV(wVar.getAppId())) {
            case CLOSE:
                i = wVar.ito.isLoading() ? 4 : 3;
                obj = null;
                break;
            case BACK:
                if (wVar.ito.isLoading()) {
                    i = 5;
                }
                obj = null;
                break;
            case HANG:
                i = 6;
                obj = null;
                break;
            case LAUNCH_MINI_PROGRAM:
                i = 9;
                String obj2 = n.xa(wVar.getAppId()).gPg + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + q.encode(bo.nullAsNil(n.xa(wVar.getAppId()).gPh));
                break;
            default:
                Intent aHY = m(wVar).aHY();
                if (aHY == null) {
                    obj2 = null;
                    break;
                }
                String str;
                if (aHY.getComponent() == null) {
                    str = "";
                    ab.e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", aHY);
                } else {
                    str = aHY.getComponent().getClassName();
                }
                if (!str.contains("WebViewUI") && !str.contains("WebviewMpUI")) {
                    obj2 = bo.bc(aHY.getStringExtra(AppBrandProcessProxyUI.huZ), str);
                    i = 8;
                    break;
                }
                i = 10;
                obj2 = aHY.getStringExtra(AppBrandProcessProxyUI.huY);
                break;
                break;
        }
        Pair create = Pair.create(Integer.valueOf(i), obj2);
        AppMethodBeat.o(132608);
        return create;
    }

    private static g m(w wVar) {
        AppMethodBeat.i(132609);
        g reporter = wVar.getRuntime().atJ().getReporter();
        AppMethodBeat.o(132609);
        return reporter;
    }
}
