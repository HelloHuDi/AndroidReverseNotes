package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashMap;
import org.apache.commons.b.e;
import org.json.JSONObject;

public final class bi extends a<w> {
    public static final int CTRL_INDEX = 66;
    public static final String NAME = "reportSubmitForm";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(130554);
        w wVar = (w) cVar;
        MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(wVar.getRuntime().atH());
        reportSubmitFormTask.type = 1;
        reportSubmitFormTask.hCT = ag.ck(e.aa(new String[]{wVar.getAppId(), p.getString(wVar.getRuntime().atI().uin), System.currentTimeMillis()}));
        reportSubmitFormTask.pageId = wVar.aBm();
        AppBrandMainProcessService.a(reportSubmitFormTask);
        HashMap hashMap = new HashMap();
        hashMap.put("formId", reportSubmitFormTask.hCT);
        n xb = n.xb(wVar.getAppId());
        if (xb != null) {
            xb.gPc = reportSubmitFormTask.hCT;
        }
        wVar.M(i, j("ok", hashMap));
        AppMethodBeat.o(130554);
    }
}
