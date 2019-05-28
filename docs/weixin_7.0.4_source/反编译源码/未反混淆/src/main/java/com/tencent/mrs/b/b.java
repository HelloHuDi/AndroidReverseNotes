package com.tencent.mrs.b;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.b.a;
import com.tencent.matrix.d.c;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MrsLogic.PhoneInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import org.json.JSONObject;

public final class b extends a {
    final HashMap<String, ArrayList<com.tencent.matrix.c.b>> AjR = new HashMap();

    public b(Context context) {
        super(context);
    }

    public final void a(com.tencent.matrix.c.b bVar) {
        super.a(bVar);
        if (!MatrixReport.isInstalled()) {
            ArrayList arrayList = (ArrayList) this.AjR.get(bVar.tag);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(bVar);
            c.i("Matrix.PluginListener", "matrix report is not init, wait to report plugin:%s, content:%s", bVar.tag, bVar.bWv);
        } else if ("memory".equals(bVar.tag)) {
            JSONObject jSONObject = bVar.bWv;
            if (jSONObject != null) {
                String optString = jSONObject.optString("resultZipPath");
                if (optString == null || optString.length() == 0) {
                    MatrixReport.with().report(bVar.tag, bVar.bWv);
                    return;
                }
                Properties properties = new Properties();
                properties.put("Uin", com.tencent.mm.loader.j.c.eSp.T("last_login_uin", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                properties.put("ClientVersion", String.valueOf(MatrixReport.with().getClientVersion()));
                properties.put("Revision", MatrixReport.with().getRevision());
                properties.put("ReportTime", String.valueOf(System.currentTimeMillis()));
                properties.put("process", jSONObject.optString("process"));
                PhoneInfo phoneInfo = MatrixReport.with().getPhoneInfo();
                properties.put("DeviceModel", phoneInfo.deviceModel);
                properties.put("OSName", phoneInfo.osName);
                properties.put("OSVersion", phoneInfo.osVersion);
                if (com.tencent.matrix.resource.c.a.a(new File(optString), properties)) {
                    MatrixReport.with().report(bVar, new File(optString));
                    return;
                } else {
                    c.e("Matrix.PluginListener", "HprofBufferShrinker.addExtraInfo fail, tag:memory", new Object[0]);
                    return;
                }
            }
            c.e("Matrix.PluginListener", "issue content is null, tag:memory", new Object[0]);
        } else {
            MatrixReport.with().report(bVar.tag, bVar.bWv);
        }
    }
}
