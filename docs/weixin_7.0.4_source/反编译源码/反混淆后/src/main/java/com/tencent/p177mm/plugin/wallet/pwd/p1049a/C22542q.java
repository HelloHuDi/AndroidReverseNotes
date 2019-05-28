package com.tencent.p177mm.plugin.wallet.pwd.p1049a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.wallet.pwd.a.q */
public final class C22542q extends C5749m {
    public String cKT = "";
    public String cQY;
    public String packageName = "";
    public int scene = -1;
    public String tqI;
    public int tqJ;
    public int tqK = -1;
    public int tqL = -1;

    public C22542q(String str, int i, String str2) {
        AppMethodBeat.m2504i(46202);
        this.tqI = str;
        this.tqJ = i;
        this.cQY = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("cre_id", C18178q.encode(str));
        hashMap.put("cre_type", C18178q.encode(String.valueOf(i)));
        hashMap.put("true_name", C18178q.encode(str2));
        hashMap.put("verifyScene", "1");
        mo70323M(hashMap);
        AppMethodBeat.m2505o(46202);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/verifyuserrealnameinfo";
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 2784;
    }

    public final int bgI() {
        return 2784;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(46203);
        C4990ab.m7417i("MicroMsg.NetSceneVerifyUserRealNameInfo", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", Integer.valueOf(i), str, jSONObject);
        if (i == 0) {
            jSONObject.optString("retcode");
            jSONObject.optString("retmsg");
            this.tqK = jSONObject.optInt("is_support_face", 0);
            this.scene = jSONObject.optInt("scene", 0);
            this.packageName = jSONObject.optString("package");
            this.tqL = jSONObject.optInt("is_need_cert");
            this.cKT = jSONObject.optString("packagesign");
        }
        AppMethodBeat.m2505o(46203);
    }
}
