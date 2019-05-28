package com.tencent.p177mm.plugin.offline.p478a;

import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p221e.C1427q;
import com.tencent.p177mm.hardcoder.C1625i;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C44697b;
import com.tencent.p177mm.plugin.offline.C7007k;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.wallet_core.model.Bankcard;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.wallet_core.C46719b;
import com.tencent.p177mm.wallet_core.p649c.C24144d;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.p177mm.wallet_core.tenpay.model.C5749m;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.offline.a.k */
public final class C21402k extends C5749m {
    public static String oYq = TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL;
    public String oYl = "";
    public String oYm = "";
    public String oYn = "";
    public String oYo = "";
    public String oYp = "";
    public String oYr = "";
    public int oYs = 0;
    public String oYt = "";
    public String oYu = "";
    public String oYv = "";
    public int oYw = C1625i.sHCENCODEVIDEOTIMEOUT;
    public String token = "";

    public C21402k(Bankcard bankcard, String str, int i) {
        AppMethodBeat.m2504i(43401);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", C1427q.m3028LM());
        hashMap.put("weixin_ver", "0x" + Integer.toHexString(C7243d.vxo));
        hashMap.put("bind_serialno", bankcard.field_bindSerial);
        hashMap.put("bank_type", bankcard.field_bankcardType);
        hashMap.put("card_tail", bankcard.field_bankcardTail);
        hashMap.put("open_limitfee", String.valueOf(i));
        this.oYw = i;
        String ck = C4995ag.m7428ck(C4995ag.m7428ck(C36391e.getUsername()) + C4995ag.m7428ck(C1427q.m3028LM()));
        hashMap.put(AccessToken.USER_ID_KEY, ck);
        C40928b dNJ = C40928b.dNJ();
        C46719b.dNA();
        String eJ = dNJ.mo64554eJ(ck, C46719b.dNC() ? 1 : 0);
        Object[] objArr = new Object[2];
        objArr[0] = eJ;
        C46719b.dNA();
        objArr[1] = Boolean.valueOf(C46719b.dNC());
        C4990ab.m7417i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", objArr);
        hashMap.put("crt_csr", eJ);
        hashMap.put("type", oYq);
        hashMap.put("version_number", oYq);
        mo70323M(hashMap);
        AppMethodBeat.m2505o(43401);
    }

    public final int bgI() {
        return 46;
    }

    /* renamed from: a */
    public final void mo9383a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43402);
        if (jSONObject != null) {
            this.oYm = jSONObject.optString("crt_crt");
            this.oYl = jSONObject.optString("cn");
            this.token = jSONObject.optString("token");
            this.oYn = jSONObject.optString("valid_end");
            this.oYo = jSONObject.optString("encrypt_str");
            this.oYp = jSONObject.optString("deviceid");
            if (C40928b.dNJ().importCert(this.oYl, this.oYm)) {
                C4990ab.m7416i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
            }
            this.oYr = jSONObject.optString("token_v2");
            this.oYs = jSONObject.optInt("algorithm_type");
            this.oYt = jSONObject.optString("card_list");
            this.oYu = jSONObject.optString("key_list");
            this.oYv = jSONObject.optString("token_pin");
            String optString = jSONObject.optString("notice_url");
            String optString2 = jSONObject.optString("auth_codes");
            int optInt = jSONObject.optInt("update_interval");
            Object optString3 = jSONObject.optString("code_ver");
            int optInt2 = jSONObject.optInt("cipher_type", 0);
            C7007k.bXg();
            C7007k.m11711aT(196617, this.oYl);
            C7007k.bXg();
            C7007k.m11711aT(196626, this.oYn);
            C7007k.bXg();
            C7007k.m11711aT(196627, this.oYo);
            C7007k.bXg();
            C7007k.m11711aT(196628, this.oYp);
            C7007k.bXg();
            C7007k.m11711aT(196630, "1");
            C7007k.bXg();
            C7007k.m11711aT(196632, (System.currentTimeMillis() / 1000));
            C28630a.m45525r(this.token, this.oYr, this.oYt, this.oYu);
            C28630a.m45492AD(this.oYs);
            C7007k.bXg();
            C7007k.m11711aT(196647, this.oYv);
            C28630a.m45500Uh(optString);
            C7007k.bXg();
            optString = C7007k.m11709Ax(196617);
            C40928b.dNJ();
            C40928b.clearToken(optString);
            C40928b.dNJ();
            C4990ab.m7417i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", Boolean.valueOf(C40928b.m70952F(this.oYl, optString2, optInt2 == 1)), this.oYl);
            if (C40928b.m70952F(this.oYl, optString2, optInt2 == 1)) {
                C4990ab.m7416i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
            } else {
                C4990ab.m7412e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
                StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
                C40928b.dNJ();
                C4990ab.m7412e("MicroMsg.NetSceneTenpayWxOfflineCreate", stringBuilder.append(C40928b.getLastError()).toString());
            }
            C7007k.bXg();
            C7007k.m11711aT(196649, String.valueOf(optInt));
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, C1427q.m3026LK());
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, optString3);
        }
        AppMethodBeat.m2505o(43402);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(43403);
        super.mo4498a(i, i2, i3, str, c1929q, bArr);
        if (!(i2 == 0 && i3 == 0)) {
            C7007k.bXg();
            C7007k.m11711aT(196630, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(C44697b.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(11);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(C44697b.CTRL_INDEX);
        iDKey2.SetValue(1);
        if (i3 == 0 && i3 == 0) {
            iDKey2.SetKey(9);
        } else {
            iDKey2.SetKey(10);
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        C7060h.pYm.mo8379b(arrayList, true);
        AppMethodBeat.m2505o(43403);
    }

    /* renamed from: a */
    public final void mo26460a(C24144d c24144d, JSONObject jSONObject) {
        AppMethodBeat.m2504i(43404);
        C40928b.dNJ().dNK();
        AppMethodBeat.m2505o(43404);
    }

    /* renamed from: ZU */
    public final int mo9382ZU() {
        return 565;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
    }
}
