package com.tencent.p177mm.plugin.profile.p483ui.newbizinfo.p1012b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.profile.ui.newbizinfo.b.a */
public final class C28704a {
    public String bCu;
    public String myX;
    public String pqt;
    public int pqu;
    public String userName;

    /* renamed from: ag */
    public static C28704a m45602ag(JSONObject jSONObject) {
        AppMethodBeat.m2504i(23933);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.BizAccount", "json is null, err");
            AppMethodBeat.m2505o(23933);
            return null;
        }
        C28704a c28704a = new C28704a();
        try {
            c28704a.userName = jSONObject.optString("UserName");
            c28704a.bCu = jSONObject.optString("NickName");
            c28704a.myX = jSONObject.optString("HeadImgUrl");
            c28704a.pqt = jSONObject.optString("FriendSubscribeDesc");
            c28704a.pqu = jSONObject.optInt("IsSubscribed");
        } catch (Exception e) {
            C4990ab.m7408b("MicroMsg.BizAccount", "", e);
        }
        AppMethodBeat.m2505o(23933);
        return c28704a;
    }
}
