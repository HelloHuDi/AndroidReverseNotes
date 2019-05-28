package com.tencent.mrs.p656b;

import android.content.Context;
import android.os.MessageQueue.IdleHandler;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.mrs.core.MatrixReport;
import com.tencent.matrix.mrs.core.MrsLogic.PhoneInfo;
import com.tencent.matrix.p155b.C6282a;
import com.tencent.matrix.p156c.C1062b;
import com.tencent.matrix.p157d.C1070c;
import com.tencent.matrix.resource.p164c.C1103a;
import com.tencent.p177mm.loader.p248j.C1762c;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import org.json.JSONObject;

/* renamed from: com.tencent.mrs.b.b */
public final class C7585b extends C6282a {
    final HashMap<String, ArrayList<C1062b>> AjR = new HashMap();

    /* renamed from: com.tencent.mrs.b.b$1 */
    public class C57751 implements IdleHandler {
        public final boolean queueIdle() {
            for (String str : C7585b.this.AjR.keySet()) {
                C1070c.m2368i("Matrix.PluginListener", "matrix report pending issues tag:%s, size:%d", str, Integer.valueOf(((ArrayList) C7585b.this.AjR.get((String) r2.next())).size()));
                Iterator it = r1.iterator();
                while (it.hasNext()) {
                    C1062b c1062b = (C1062b) it.next();
                    MatrixReport.with().report(c1062b.tag, c1062b.bWv);
                }
            }
            C7585b.this.AjR.clear();
            return false;
        }
    }

    public C7585b(Context context) {
        super(context);
    }

    /* renamed from: a */
    public final void mo4193a(C1062b c1062b) {
        super.mo4193a(c1062b);
        if (!MatrixReport.isInstalled()) {
            ArrayList arrayList = (ArrayList) this.AjR.get(c1062b.tag);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(c1062b);
            C1070c.m2368i("Matrix.PluginListener", "matrix report is not init, wait to report plugin:%s, content:%s", c1062b.tag, c1062b.bWv);
        } else if ("memory".equals(c1062b.tag)) {
            JSONObject jSONObject = c1062b.bWv;
            if (jSONObject != null) {
                String optString = jSONObject.optString("resultZipPath");
                if (optString == null || optString.length() == 0) {
                    MatrixReport.with().report(c1062b.tag, c1062b.bWv);
                    return;
                }
                Properties properties = new Properties();
                properties.put("Uin", C1762c.eSp.mo5292T("last_login_uin", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                properties.put("ClientVersion", String.valueOf(MatrixReport.with().getClientVersion()));
                properties.put("Revision", MatrixReport.with().getRevision());
                properties.put("ReportTime", String.valueOf(System.currentTimeMillis()));
                properties.put("process", jSONObject.optString("process"));
                PhoneInfo phoneInfo = MatrixReport.with().getPhoneInfo();
                properties.put("DeviceModel", phoneInfo.deviceModel);
                properties.put("OSName", phoneInfo.osName);
                properties.put("OSVersion", phoneInfo.osVersion);
                if (C1103a.m2414a(new File(optString), properties)) {
                    MatrixReport.with().report(c1062b, new File(optString));
                    return;
                } else {
                    C1070c.m2367e("Matrix.PluginListener", "HprofBufferShrinker.addExtraInfo fail, tag:memory", new Object[0]);
                    return;
                }
            }
            C1070c.m2367e("Matrix.PluginListener", "issue content is null, tag:memory", new Object[0]);
        } else {
            MatrixReport.with().report(c1062b.tag, c1062b.bWv);
        }
    }
}
