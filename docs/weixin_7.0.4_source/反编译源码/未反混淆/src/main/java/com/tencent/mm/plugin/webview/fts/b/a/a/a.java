package com.tencent.mm.plugin.webview.fts.b.a.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public String csB;
    public String ugA;
    public String ugB;
    private String ugC;
    private String ugD;
    private String ugE;
    private boolean ugF;
    public String ugz;

    public a(String str) {
        boolean z = true;
        AppMethodBeat.i(5776);
        String str2 = new String(bo.readFromFile(str));
        if (TextUtils.isEmpty(str2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("there is no test data");
            AppMethodBeat.o(5776);
            throw illegalArgumentException;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            this.csB = jSONObject.optString("appid");
            this.ugz = jSONObject.optString("versionType");
            try {
                this.ugA = jSONObject.optJSONObject("queryIntent").toString();
            } catch (Exception e) {
                ab.printErrStackTrace("WidgetUiTestInfo", e, "", new Object[0]);
            }
            this.ugB = jSONObject.optString("realQuery");
            try {
                this.ugC = jSONObject.optJSONObject("testData").toString();
            } catch (Exception e2) {
                ab.printErrStackTrace("WidgetUiTestInfo", e2, "", new Object[0]);
            }
            this.ugD = jSONObject.optString("domResultPath");
            this.ugE = jSONObject.optString("widgetPicDir");
            if (jSONObject.optInt("onlyPic") != 1) {
                z = false;
            }
            this.ugF = z;
            AppMethodBeat.o(5776);
        } catch (JSONException e3) {
            IllegalArgumentException illegalArgumentException2 = new IllegalArgumentException(e3);
            AppMethodBeat.o(5776);
            throw illegalArgumentException2;
        }
    }
}
