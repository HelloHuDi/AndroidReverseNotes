package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b;

import android.support.p056d.C0252a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b.b */
public final class C12865b {
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

    /* renamed from: ah */
    public static C12865b m20857ah(JSONObject jSONObject) {
        AppMethodBeat.m2504i(23934);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.MessageInfo", "json is null, err");
            AppMethodBeat.m2505o(23934);
            return null;
        }
        C12865b c12865b = new C12865b();
        try {
            c12865b.title = jSONObject.optString("Title");
            c12865b.hAg = jSONObject.optString("CoverImgUrl");
            c12865b.pqv = jSONObject.optString("ArticleUrl");
            c12865b.pqw = jSONObject.optInt("IsOriginalArticle", 0);
            c12865b.pqx = new ArrayList();
            c12865b.ewK = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("UserInfoList");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("HeadImgUrl");
                    String optString2 = optJSONObject.optString("UserName");
                    if (!(C5046bo.isNullOrNil(optString) || C5046bo.isNullOrNil(optString2))) {
                        c12865b.pqx.add(optString);
                        c12865b.ewK.add(optString2);
                    }
                }
            }
            c12865b.pqy = jSONObject.optString("UserInfoListDesc");
            c12865b.status = jSONObject.optInt("Status");
            c12865b.type = jSONObject.optInt("Type");
            c12865b.pqz = jSONObject.optString("AppMsgId");
            c12865b.pqA = jSONObject.optString("ItemIndex");
            c12865b.pqB = jSONObject.optString("ReportContent");
            c12865b.pqC = jSONObject.optString("Digest");
            c12865b.fgd = jSONObject.optString("VideoId");
            c12865b.videoHeight = jSONObject.optInt("VideoHeight");
            c12865b.videoWidth = jSONObject.optInt("VideoWidth");
            c12865b.eWK = jSONObject.optInt("VideoDuration");
            c12865b.oyB = jSONObject.optInt(C0252a.TAG_DATETIME);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.MessageInfo", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(23934);
        return c12865b;
    }
}
