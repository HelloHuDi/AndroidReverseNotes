package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.base.ReportSubmitFormTask;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import java.util.HashMap;
import org.apache.commons.p703b.C46855e;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.bi */
public final class C19327bi extends C10296a<C27242w> {
    public static final int CTRL_INDEX = 66;
    public static final String NAME = "reportSubmitForm";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(130554);
        C27242w c27242w = (C27242w) c2241c;
        MainProcessTask reportSubmitFormTask = new ReportSubmitFormTask(c27242w.getRuntime().atH());
        reportSubmitFormTask.type = 1;
        reportSubmitFormTask.hCT = C4995ag.m7428ck(C46855e.m89095aa(new String[]{c27242w.getAppId(), C1183p.getString(c27242w.getRuntime().atI().uin), System.currentTimeMillis()}));
        reportSubmitFormTask.pageId = c27242w.aBm();
        AppBrandMainProcessService.m54349a(reportSubmitFormTask);
        HashMap hashMap = new HashMap();
        hashMap.put("formId", reportSubmitFormTask.hCT);
        C38450n xb = C38450n.m65049xb(c27242w.getAppId());
        if (xb != null) {
            xb.gPc = reportSubmitFormTask.hCT;
        }
        c27242w.mo6107M(i, mo73394j("ok", hashMap));
        AppMethodBeat.m2505o(130554);
    }
}
