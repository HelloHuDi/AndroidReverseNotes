package com.tencent.p177mm.plugin.webview.fts.p578b.p579a.p1329a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.fts.b.a.a.a */
public final class C22789a {
    public String csB;
    public String ugA;
    public String ugB;
    private String ugC;
    private String ugD;
    private String ugE;
    private boolean ugF;
    public String ugz;

    public C22789a(String str) {
        boolean z = true;
        AppMethodBeat.m2504i(5776);
        String str2 = new String(C5046bo.readFromFile(str));
        if (TextUtils.isEmpty(str2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("there is no test data");
            AppMethodBeat.m2505o(5776);
            throw illegalArgumentException;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            this.csB = jSONObject.optString("appid");
            this.ugz = jSONObject.optString("versionType");
            try {
                this.ugA = jSONObject.optJSONObject("queryIntent").toString();
            } catch (Exception e) {
                C4990ab.printErrStackTrace("WidgetUiTestInfo", e, "", new Object[0]);
            }
            this.ugB = jSONObject.optString("realQuery");
            try {
                this.ugC = jSONObject.optJSONObject("testData").toString();
            } catch (Exception e2) {
                C4990ab.printErrStackTrace("WidgetUiTestInfo", e2, "", new Object[0]);
            }
            this.ugD = jSONObject.optString("domResultPath");
            this.ugE = jSONObject.optString("widgetPicDir");
            if (jSONObject.optInt("onlyPic") != 1) {
                z = false;
            }
            this.ugF = z;
            AppMethodBeat.m2505o(5776);
        } catch (JSONException e3) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(e3);
            AppMethodBeat.m2505o(5776);
            throw illegalArgumentException2;
        }
    }
}
