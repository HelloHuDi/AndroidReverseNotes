package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import android.support.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class b {
    public int eWK;
    public List<String> ewK;
    public String fgd;
    public String hAg;
    public int oyB;
    public String pqA;
    public String pqB;
    public String pqC;
    public String pqv;
    public int pqw;
    public List<String> pqx;
    public String pqy;
    public String pqz;
    public int status;
    public String title;
    public int type;
    public int videoHeight;
    public int videoWidth;

    public static b ah(JSONObject jSONObject) {
        AppMethodBeat.i(23934);
        if (jSONObject == null) {
            ab.e("MicroMsg.MessageInfo", "json is null, err");
            AppMethodBeat.o(23934);
            return null;
        }
        b bVar = new b();
        try {
            bVar.title = jSONObject.optString("Title");
            bVar.hAg = jSONObject.optString("CoverImgUrl");
            bVar.pqv = jSONObject.optString("ArticleUrl");
            bVar.pqw = jSONObject.optInt("IsOriginalArticle", 0);
            bVar.pqx = new ArrayList();
            bVar.ewK = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("UserInfoList");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("HeadImgUrl");
                    String optString2 = optJSONObject.optString("UserName");
                    if (!(bo.isNullOrNil(optString) || bo.isNullOrNil(optString2))) {
                        bVar.pqx.add(optString);
                        bVar.ewK.add(optString2);
                    }
                }
            }
            bVar.pqy = jSONObject.optString("UserInfoListDesc");
            bVar.status = jSONObject.optInt("Status");
            bVar.type = jSONObject.optInt("Type");
            bVar.pqz = jSONObject.optString("AppMsgId");
            bVar.pqA = jSONObject.optString("ItemIndex");
            bVar.pqB = jSONObject.optString("ReportContent");
            bVar.pqC = jSONObject.optString("Digest");
            bVar.fgd = jSONObject.optString("VideoId");
            bVar.videoHeight = jSONObject.optInt("VideoHeight");
            bVar.videoWidth = jSONObject.optInt("VideoWidth");
            bVar.eWK = jSONObject.optInt("VideoDuration");
            bVar.oyB = jSONObject.optInt(a.TAG_DATETIME);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.MessageInfo", e, "", new Object[0]);
        }
        AppMethodBeat.o(23934);
        return bVar;
    }
}
