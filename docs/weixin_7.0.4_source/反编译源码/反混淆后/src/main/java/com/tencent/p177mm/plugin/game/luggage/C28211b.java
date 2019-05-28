package com.tencent.p177mm.plugin.game.luggage;

import com.tencent.luggage.p146d.C17817c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.luggage.b */
public final class C28211b {
    /* renamed from: JQ */
    public static long f13696JQ;
    public static Map<String, String> mHeaders;
    public static String mTH;
    public static boolean mTI;

    /* renamed from: com.tencent.mm.plugin.game.luggage.b$1 */
    public static class C247731 extends C17817c {
        public final String name() {
            return "onGetA8KeyUrl";
        }

        /* renamed from: wQ */
        public final JSONObject mo7075wQ() {
            AppMethodBeat.m2504i(135807);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", C28211b.mTH);
                jSONObject.put("set_cookie", C28211b.mTI ? 1 : 0);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.LuggageGameUinKeyHolder", "onGetA8Key, e:" + e.getMessage());
            }
            AppMethodBeat.m2505o(135807);
            return jSONObject;
        }
    }

    public static boolean bDp() {
        AppMethodBeat.m2504i(135808);
        if (C5046bo.isNullOrNil(mTH)) {
            C4990ab.m7416i("MicroMsg.LuggageGameUinKeyHolder", "fullUrl is null");
            AppMethodBeat.m2505o(135808);
            return false;
        } else if (C45985a.bDl() <= 0) {
            AppMethodBeat.m2505o(135808);
            return false;
        } else if ((System.currentTimeMillis() / 1000) - f13696JQ > ((long) C45985a.bDl())) {
            C4990ab.m7416i("MicroMsg.LuggageGameUinKeyHolder", "updateTime bigger that one hour");
            AppMethodBeat.m2505o(135808);
            return false;
        } else {
            C4990ab.m7410d("MicroMsg.LuggageGameUinKeyHolder", "hasValidCache");
            AppMethodBeat.m2505o(135808);
            return true;
        }
    }
}
