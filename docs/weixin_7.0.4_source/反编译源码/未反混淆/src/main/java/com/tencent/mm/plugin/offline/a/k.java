package com.tencent.mm.plugin.offline.a;

import com.facebook.AccessToken;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.storage.ac;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

public final class k extends m {
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
    public int oYw = i.sHCENCODEVIDEOTIMEOUT;
    public String token = "";

    public k(Bankcard bankcard, String str, int i) {
        AppMethodBeat.i(43401);
        HashMap hashMap = new HashMap();
        hashMap.put("passwd", str);
        hashMap.put("device_id", q.LM());
        hashMap.put("weixin_ver", "0x" + Integer.toHexString(d.vxo));
        hashMap.put("bind_serialno", bankcard.field_bindSerial);
        hashMap.put("bank_type", bankcard.field_bankcardType);
        hashMap.put("card_tail", bankcard.field_bankcardTail);
        hashMap.put("open_limitfee", String.valueOf(i));
        this.oYw = i;
        String ck = ag.ck(ag.ck(e.getUsername()) + ag.ck(q.LM()));
        hashMap.put(AccessToken.USER_ID_KEY, ck);
        b dNJ = b.dNJ();
        com.tencent.mm.wallet_core.b.dNA();
        String eJ = dNJ.eJ(ck, com.tencent.mm.wallet_core.b.dNC() ? 1 : 0);
        Object[] objArr = new Object[2];
        objArr[0] = eJ;
        com.tencent.mm.wallet_core.b.dNA();
        objArr[1] = Boolean.valueOf(com.tencent.mm.wallet_core.b.dNC());
        ab.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "crt_csr %s %s", objArr);
        hashMap.put("crt_csr", eJ);
        hashMap.put("type", oYq);
        hashMap.put("version_number", oYq);
        M(hashMap);
        AppMethodBeat.o(43401);
    }

    public final int bgI() {
        return 46;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43402);
        if (jSONObject != null) {
            this.oYm = jSONObject.optString("crt_crt");
            this.oYl = jSONObject.optString("cn");
            this.token = jSONObject.optString("token");
            this.oYn = jSONObject.optString("valid_end");
            this.oYo = jSONObject.optString("encrypt_str");
            this.oYp = jSONObject.optString("deviceid");
            if (b.dNJ().importCert(this.oYl, this.oYm)) {
                ab.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt success");
            } else {
                ab.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "importCert crt_crt fail");
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
            com.tencent.mm.plugin.offline.k.bXg();
            com.tencent.mm.plugin.offline.k.aT(196617, this.oYl);
            com.tencent.mm.plugin.offline.k.bXg();
            com.tencent.mm.plugin.offline.k.aT(196626, this.oYn);
            com.tencent.mm.plugin.offline.k.bXg();
            com.tencent.mm.plugin.offline.k.aT(196627, this.oYo);
            com.tencent.mm.plugin.offline.k.bXg();
            com.tencent.mm.plugin.offline.k.aT(196628, this.oYp);
            com.tencent.mm.plugin.offline.k.bXg();
            com.tencent.mm.plugin.offline.k.aT(196630, "1");
            com.tencent.mm.plugin.offline.k.bXg();
            com.tencent.mm.plugin.offline.k.aT(196632, (System.currentTimeMillis() / 1000));
            a.r(this.token, this.oYr, this.oYt, this.oYu);
            a.AD(this.oYs);
            com.tencent.mm.plugin.offline.k.bXg();
            com.tencent.mm.plugin.offline.k.aT(196647, this.oYv);
            a.Uh(optString);
            com.tencent.mm.plugin.offline.k.bXg();
            optString = com.tencent.mm.plugin.offline.k.Ax(196617);
            b.dNJ();
            b.clearToken(optString);
            b.dNJ();
            ab.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "offlinecreate isOk %s cn: %s", Boolean.valueOf(b.F(this.oYl, optString2, optInt2 == 1)), this.oYl);
            if (b.F(this.oYl, optString2, optInt2 == 1)) {
                ab.i("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens success!");
            } else {
                ab.e("MicroMsg.NetSceneTenpayWxOfflineCreate", "CertUtil.getInstance().setTokens failed!");
                StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
                b.dNJ();
                ab.e("MicroMsg.NetSceneTenpayWxOfflineCreate", stringBuilder.append(b.getLastError()).toString());
            }
            com.tencent.mm.plugin.offline.k.bXg();
            com.tencent.mm.plugin.offline.k.aT(196649, String.valueOf(optInt));
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, q.LK());
            g.RQ();
            g.RP().Ry().set(ac.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, optString3);
        }
        AppMethodBeat.o(43402);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        AppMethodBeat.i(43403);
        super.a(i, i2, i3, str, qVar, bArr);
        if (!(i2 == 0 && i3 == 0)) {
            com.tencent.mm.plugin.offline.k.bXg();
            com.tencent.mm.plugin.offline.k.aT(196630, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
        iDKey.SetValue(1);
        iDKey.SetKey(11);
        IDKey iDKey2 = new IDKey();
        iDKey2.SetID(com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX);
        iDKey2.SetValue(1);
        if (i3 == 0 && i3 == 0) {
            iDKey2.SetKey(9);
        } else {
            iDKey2.SetKey(10);
        }
        arrayList.add(iDKey);
        arrayList.add(iDKey2);
        h.pYm.b(arrayList, true);
        AppMethodBeat.o(43403);
    }

    public final void a(com.tencent.mm.wallet_core.c.d dVar, JSONObject jSONObject) {
        AppMethodBeat.i(43404);
        b.dNJ().dNK();
        AppMethodBeat.o(43404);
    }

    public final int ZU() {
        return 565;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/offlinecreate";
    }
}
