package com.tencent.p177mm.plugin.offline.p478a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.protocal.protobuf.alb;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.wallet_core.p649c.C36378u;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.a */
public final class C28626a extends C36378u {
    private final C7472b ehh;
    private C1202f ehi;
    private ArrayList<String> hUW;
    private String oXT;
    private String oXU;

    public final int getType() {
        return 606;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(43381);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(43381);
        return a;
    }

    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        AppMethodBeat.m2504i(43382);
        if (i != 0) {
            C4990ab.m7412e("MicroMsg.NetSceneGetOffLineInfo", "Cmd : 606, errType = " + i + ", errCode = " + i2 + ", errMsg = " + str);
        }
        alb alb = (alb) ((C7472b) c1929q).fsH.fsP;
        if (i == 0 && i2 == 0) {
            try {
                if (!TextUtils.isEmpty(alb.wqA)) {
                    JSONObject jSONObject = new JSONObject(alb.wqA);
                    int optInt = jSONObject.optInt("InitValue");
                    int optInt2 = jSONObject.optInt("FastChangedLimit");
                    this.oXU = jSONObject.optString("guide_tips");
                    C28630a.m45490AB(optInt);
                    C28630a.m45491AC(optInt2);
                    C4990ab.m7418v("MicroMsg.NetSceneGetOffLineInfo", "initValue:" + optInt + " fastChangeValue:" + optInt2);
                }
                if (!TextUtils.isEmpty(alb.wqB)) {
                    m45484aa(new JSONObject(alb.wqB));
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
                i = 1000;
                i2 = 2;
                str = C4996ah.getContext().getString(C25738R.string.fdx);
            }
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i, i2, str, this);
        }
        AppMethodBeat.m2505o(43382);
    }

    /* renamed from: aa */
    private void m45484aa(JSONObject jSONObject) {
        AppMethodBeat.m2504i(43383);
        this.oXT = jSONObject.optString("micropay_tips");
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("head_url_list");
            if (jSONArray == null || jSONArray.length() == 0) {
                AppMethodBeat.m2505o(43383);
                return;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                this.hUW.add((String) jSONArray.get(i));
            }
            AppMethodBeat.m2505o(43383);
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneGetOffLineInfo", e, "", new Object[0]);
            AppMethodBeat.m2505o(43383);
        }
    }
}
