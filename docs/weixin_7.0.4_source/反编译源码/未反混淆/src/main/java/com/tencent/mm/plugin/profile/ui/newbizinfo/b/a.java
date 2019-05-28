package com.tencent.mm.plugin.profile.ui.newbizinfo.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class a {
    public String bCu;
    public String myX;
    public String pqt;
    public int pqu;
    public String userName;

    public static a ag(JSONObject jSONObject) {
        AppMethodBeat.i(23933);
        if (jSONObject == null) {
            ab.e("MicroMsg.BizAccount", "json is null, err");
            AppMethodBeat.o(23933);
            return null;
        }
        a aVar = new a();
        try {
            aVar.userName = jSONObject.optString("UserName");
            aVar.bCu = jSONObject.optString("NickName");
            aVar.myX = jSONObject.optString("HeadImgUrl");
            aVar.pqt = jSONObject.optString("FriendSubscribeDesc");
            aVar.pqu = jSONObject.optInt("IsSubscribed");
        } catch (Exception e) {
            ab.b("MicroMsg.BizAccount", "", e);
        }
        AppMethodBeat.o(23933);
        return aVar;
    }
}
