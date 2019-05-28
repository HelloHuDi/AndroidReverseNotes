package com.tencent.p177mm.plugin.collect.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C35943ox;
import com.tencent.p177mm.protocal.protobuf.C40555oy;
import com.tencent.p177mm.protocal.protobuf.bbc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.collect.model.l */
public final class C6830l extends C1207m implements C1918k {
    private final String TAG = "MicroMsg.NetSceneF2fQrcode";
    private C7472b ehh;
    private C1202f ehi;
    public C40555oy kCk;

    public C6830l() {
        AppMethodBeat.m2504i(40975);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C35943ox();
        c1196a.fsK = new C40555oy();
        c1196a.fsI = 1588;
        c1196a.uri = "/cgi-bin/mmpay-bin/f2fqrcode";
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(40975);
    }

    public final int getType() {
        return 1588;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(40976);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(40976);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(40977);
        this.kCk = (C40555oy) ((C7472b) c1929q).fsH.fsP;
        C4990ab.m7417i("MicroMsg.NetSceneF2fQrcode", "errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        C4990ab.m7411d("MicroMsg.NetSceneF2fQrcode", "payurl: %s, true_name: %s, bottom_icon_url: %s", this.kCk.url, this.kCk.twd, this.kCk.vWa);
        if (!C5046bo.isNullOrNil(this.kCk.url)) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_F2F_COLLECT_PAY_URL_STRING_SYNC, this.kCk.url);
        }
        if (!C5046bo.isNullOrNil(this.kCk.twd)) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_F2F_COLLECT_TRUE_NAME_STRING_SYNC, this.kCk.twd);
        }
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_LEFT_ICON_URL_STRING_SYNC, this.kCk.vWa);
        JSONObject a = C6830l.m11285a(this.kCk.vVZ);
        JSONArray bo = C6830l.m11286bo(this.kCk.vVY);
        if (a != null) {
            C4990ab.m7411d("MicroMsg.NetSceneF2fQrcode", "bottom: %s", a.toString());
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_F2F_COLLECT_BOTTOM_MENU_STRING_SYNC, a.toString());
        }
        if (bo != null) {
            C4990ab.m7411d("MicroMsg.NetSceneF2fQrcode", "upright: %s", bo.toString());
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_F2F_COLLECT_UPRIGHT_MENU_STRING_SYNC, bo.toString());
        }
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(40977);
    }

    /* renamed from: bo */
    private static JSONArray m11286bo(List<bbc> list) {
        AppMethodBeat.m2504i(40978);
        JSONArray jSONArray = new JSONArray();
        if (list == null || list.size() == 0) {
            C4990ab.m7420w("MicroMsg.NetSceneF2fQrcode", "empty menu items");
            AppMethodBeat.m2505o(40978);
            return null;
        }
        int i = 0;
        while (i < list.size()) {
            try {
                JSONObject a = C6830l.m11285a((bbc) list.get(i));
                if (a != null) {
                    jSONArray.put(i, a);
                }
                i++;
            } catch (JSONException e) {
                C4990ab.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
                AppMethodBeat.m2505o(40978);
                return null;
            }
        }
        AppMethodBeat.m2505o(40978);
        return jSONArray;
    }

    /* renamed from: a */
    private static JSONObject m11285a(bbc bbc) {
        int i;
        AppMethodBeat.m2504i(40979);
        if (bbc == null || C5046bo.isNullOrNil(bbc.cEh)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            C4990ab.m7420w("MicroMsg.NetSceneF2fQrcode", "empty menu item");
            AppMethodBeat.m2505o(40979);
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", bbc.type);
            jSONObject.put("wording", bbc.cEh);
            jSONObject.put("url", bbc.url);
            jSONObject.put("waapp_username", bbc.wFS);
            jSONObject.put("waapp_path", bbc.wFT);
            AppMethodBeat.m2505o(40979);
            return jSONObject;
        } catch (JSONException e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneF2fQrcode", e, "", new Object[0]);
            AppMethodBeat.m2505o(40979);
            return null;
        }
    }
}
