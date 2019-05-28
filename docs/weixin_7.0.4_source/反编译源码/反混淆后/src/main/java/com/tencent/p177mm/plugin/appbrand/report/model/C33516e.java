package com.tencent.p177mm.plugin.appbrand.report.model;

import android.content.Intent;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandProcessProxyUI;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.report.model.e */
public final class C33516e {
    /* renamed from: a */
    public static void m54741a(C41243o c41243o, JSONObject jSONObject) {
        AppMethodBeat.m2504i(132606);
        try {
            C33516e.m54742b(c41243o, jSONObject);
            jSONObject.put("referpagepath", C27283a.m43315d(c41243o.atI().hgF));
            jSONObject.put("clickTimestamp", c41243o.atI().startTime);
            AppMethodBeat.m2505o(132606);
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.AppBrandPageVisitStatisticsHelper", "fillWxConfigLaunchInfo ex = %s", e);
            AppMethodBeat.m2505o(132606);
        }
    }

    /* renamed from: b */
    public static void m54742b(C41243o c41243o, JSONObject jSONObject) {
        AppMethodBeat.m2504i(132607);
        jSONObject.put("scene", c41243o.mo43491ya().bQn.scene);
        jSONObject.put("scene_note", c41243o.mo43491ya().bQn.cst);
        jSONObject.put("sessionId", c41243o.atI().mo32993xz());
        jSONObject.put("usedState", c41243o.mo43491ya().bQn.iAo);
        jSONObject.put("prescene", c41243o.mo43491ya().bQn.cOq);
        jSONObject.put("prescene_note", c41243o.mo43491ya().bQn.cOr);
        AppMethodBeat.m2505o(132607);
    }

    /* renamed from: l */
    public static Pair<Integer, String> m54743l(C27242w c27242w) {
        Object obj;
        int i = 7;
        AppMethodBeat.m2504i(132608);
        switch (C33183g.m54286wV(c27242w.getAppId())) {
            case CLOSE:
                i = c27242w.ito.isLoading() ? 4 : 3;
                obj = null;
                break;
            case BACK:
                if (c27242w.ito.isLoading()) {
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
                String obj2 = C38450n.m65048xa(c27242w.getAppId()).gPg + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C18178q.encode(C5046bo.nullAsNil(C38450n.m65048xa(c27242w.getAppId()).gPh));
                break;
            default:
                Intent aHY = C33516e.m54744m(c27242w).aHY();
                if (aHY == null) {
                    obj2 = null;
                    break;
                }
                String str;
                if (aHY.getComponent() == null) {
                    str = "";
                    C4990ab.m7413e("MicroMsg.AppBrandPageVisitStatisticsHelper", "onBackground, intent %s, get null cmp name", aHY);
                } else {
                    str = aHY.getComponent().getClassName();
                }
                if (!str.contains("WebViewUI") && !str.contains("WebviewMpUI")) {
                    obj2 = C5046bo.m7532bc(aHY.getStringExtra(AppBrandProcessProxyUI.huZ), str);
                    i = 8;
                    break;
                }
                i = 10;
                obj2 = aHY.getStringExtra(AppBrandProcessProxyUI.huY);
                break;
                break;
        }
        Pair create = Pair.create(Integer.valueOf(i), obj2);
        AppMethodBeat.m2505o(132608);
        return create;
    }

    /* renamed from: m */
    private static C38497g m54744m(C27242w c27242w) {
        AppMethodBeat.m2504i(132609);
        C38497g reporter = c27242w.getRuntime().atJ().getReporter();
        AppMethodBeat.m2505o(132609);
        return reporter;
    }
}
