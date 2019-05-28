package com.tencent.mm.plugin.wallet.pwd.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.wallet_core.tenpay.model.m;
import java.util.HashMap;
import org.json.JSONObject;

public final class q extends m {
    public String cKT = "";
    public String cQY;
    public String packageName = "";
    public int scene = -1;
    public String tqI;
    public int tqJ;
    public int tqK = -1;
    public int tqL = -1;

    public q(String str, int i, String str2) {
        AppMethodBeat.i(46202);
        this.tqI = str;
        this.tqJ = i;
        this.cQY = str2;
        HashMap hashMap = new HashMap();
        hashMap.put("cre_id", com.tencent.mm.compatible.util.q.encode(str));
        hashMap.put("cre_type", com.tencent.mm.compatible.util.q.encode(String.valueOf(i)));
        hashMap.put("true_name", com.tencent.mm.compatible.util.q.encode(str2));
        hashMap.put("verifyScene", "1");
        M(hashMap);
        AppMethodBeat.o(46202);
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/verifyuserrealnameinfo";
    }

    public final int ZU() {
        return 2784;
    }

    public final int bgI() {
        return 2784;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46203);
        ab.i("MicroMsg.NetSceneVerifyUserRealNameInfo", "onGYNetEnd, errCode: %s, errMsg: %s, json: %s", Integer.valueOf(i), str, jSONObject);
        if (i == 0) {
            jSONObject.optString("retcode");
            jSONObject.optString("retmsg");
            this.tqK = jSONObject.optInt("is_support_face", 0);
            this.scene = jSONObject.optInt("scene", 0);
            this.packageName = jSONObject.optString("package");
            this.tqL = jSONObject.optInt("is_need_cert");
            this.cKT = jSONObject.optString("packagesign");
        }
        AppMethodBeat.o(46203);
    }
}
