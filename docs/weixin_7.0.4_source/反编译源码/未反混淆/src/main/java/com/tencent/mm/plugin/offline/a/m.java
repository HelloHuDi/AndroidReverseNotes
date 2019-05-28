package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.c.a;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.wallet_core.c.b;
import com.tencent.xweb.util.d;
import java.util.HashMap;
import org.json.JSONObject;

public final class m extends h {
    String cEW;
    public int oYA;
    int oYB;
    public String oYn;
    public String oYo;
    public String oYp;
    public String oYr;
    public int oYs;
    public String oYt;
    public String oYu;
    public String oYv;
    private String oYx;
    private int oYy;
    public String oYz;
    public String token;

    public m(String str, int i) {
        this(str, i, i);
        AppMethodBeat.i(43407);
        AppMethodBeat.o(43407);
    }

    public m(String str, int i, int i2) {
        Object obj;
        int i3;
        CharSequence genUserSig;
        AppMethodBeat.i(43408);
        this.token = "";
        this.oYn = "";
        this.oYo = "";
        this.oYp = "";
        this.oYr = "";
        this.oYs = 0;
        this.oYt = "";
        this.oYu = "";
        this.oYv = "";
        this.oYA = 0;
        this.oYB = 0;
        this.cEW = d.x((System.currentTimeMillis()).getBytes());
        ab.v("MicroMsg.NetSceneTenpayWxOfflineGetToken", "scene %s stack %s ", Integer.valueOf(i), bo.dpG().toString());
        String token = a.getToken();
        k.bXg();
        String Ax = k.Ax(196628);
        if (TextUtils.isEmpty(Ax)) {
            Ax = q.LM();
        }
        if (TextUtils.isEmpty(token)) {
            obj = Ax + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000);
        } else {
            obj = Ax + "&" + str + "&" + (((int) (Math.random() * 1000000.0d)) + 1000000) + "&" + token;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("token_src", obj);
        String str2 = "";
        k.bXg();
        String Ax2 = k.Ax(196617);
        switch (i2) {
            case 0:
                i3 = 12;
                break;
            case 1:
                i3 = 13;
                break;
            case 2:
                i3 = 14;
                break;
            case 3:
                i3 = 15;
                break;
            case 4:
                i3 = 16;
                break;
            case 5:
                i3 = 17;
                break;
            case 6:
                i3 = 18;
                break;
            case 7:
                i3 = 19;
                break;
            case 8:
                i3 = 20;
                break;
            case 9:
                i3 = 24;
                break;
            case 10:
                i3 = 72;
                break;
            default:
                i3 = 12;
                break;
        }
        h.pYm.a(135, (long) i3, 1, true);
        com.tencent.mm.g.b.a.a aVar = new com.tencent.mm.g.b.a.a();
        aVar.ep(this.cEW);
        aVar.cTl = 1;
        b.dNJ();
        if (b.isCertExist(Ax2)) {
            aVar.cTm = 1;
            b.dNJ();
            aVar.cTn = (long) b.getLastError();
            aVar.ajK();
            aVar = new com.tencent.mm.g.b.a.a();
            aVar.ep(this.cEW);
            aVar.cTl = 3;
            b.dNJ();
            genUserSig = b.genUserSig(Ax2, obj);
            if (bo.isNullOrNil(genUserSig)) {
                aVar.cTm = 0;
                b.dNJ();
                aVar.cTn = (long) b.getLastError();
                aVar.ajK();
            } else {
                aVar.cTm = 1;
                b.dNJ();
                aVar.cTn = (long) b.getLastError();
                aVar.ajK();
            }
            ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().isCertExist(cn) true");
        } else {
            StringBuilder stringBuilder = new StringBuilder("NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().getLastError():");
            b.dNJ();
            ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(b.getLastError()).toString());
            aVar.cTm = 0;
            b.dNJ();
            aVar.cTn = (long) b.getLastError();
            aVar.ajK();
            h.pYm.a(135, 6, 1, true);
            com.tencent.mm.g.b.a.a aVar2 = new com.tencent.mm.g.b.a.a();
            aVar2.ep(this.cEW);
            aVar2.cTl = 2;
            g.RQ();
            Ax = (String) g.RP().Ry().get(ac.a.USERINFO_WALLET_OFFLINE_IEMI_STRING_SYNC, (Object) "");
            if (Ax == null || !Ax.equals(q.LK())) {
                aVar2.cTm = 0;
                b.dNJ();
                aVar2.cTn = (long) b.getLastError();
                ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is diff between create and getToken");
                h.pYm.a(135, 5, 1, true);
            } else {
                ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken iemi is same between create and getToken");
                aVar2.cTm = 1;
                b.dNJ();
                aVar2.cTn = (long) b.getLastError();
            }
            aVar2.ajK();
            ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken CertUtil.getInstance().isCertExist return false! cn: ".concat(String.valueOf(Ax2)));
            obj = str2;
        }
        if (TextUtils.isEmpty(genUserSig)) {
            ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", " NetSceneTenpayWxOfflineGetToken sign is empty!");
            h.pYm.a(135, 4, 1, true);
        } else {
            ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "sign is valid");
        }
        hashMap.put("sign", genUserSig);
        hashMap.put("cert_no", Ax2);
        hashMap.put("type", k.oYq);
        hashMap.put("version_number", k.oYq);
        if (a.bYq() == 2) {
            hashMap.put("last_token", a.bYr());
        } else {
            hashMap.put("last_token", a.getToken());
        }
        ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "inOfflineUI: %B", Boolean.valueOf(k.oXK));
        if (i == 65281) {
            hashMap.put("fetch_tag", "2");
        } else if (k.oXK) {
            hashMap.put("fetch_tag", "1");
        } else {
            hashMap.put("fetch_tag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        if (i == 65281) {
            i = 3;
        }
        hashMap.put("scene", String.valueOf(i));
        M(hashMap);
        AppMethodBeat.o(43408);
    }

    public final int bgI() {
        if (k.oXK) {
            return 52;
        }
        return 1725;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(43409);
        ab.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "errCode: %d, errMsg: %s", Integer.valueOf(i), str);
        if (i == 0) {
            this.token = jSONObject.optString("token");
            this.oYn = jSONObject.optString("valid_end");
            this.oYo = jSONObject.optString("encrypt_str");
            this.oYp = jSONObject.optString("deviceid");
            this.oYr = jSONObject.optString("token_v2");
            this.oYs = jSONObject.optInt("algorithm_type");
            this.oYt = jSONObject.optString("card_list");
            this.oYu = jSONObject.optString("key_list");
            this.oYv = jSONObject.optString("token_pin");
            this.oYx = jSONObject.optString("auth_codes");
            this.oYy = jSONObject.optInt("update_interval");
            this.oYz = jSONObject.optString("code_ver");
            this.oYA = jSONObject.optInt("reget_token_num", 0);
            this.oYB = jSONObject.optInt("cipher_type", 0);
            if (this.oYA > 0) {
                k.oXL = this.oYA;
            } else {
                k.oXL = 10;
            }
            ab.d("MicroMsg.NetSceneTenpayWxOfflineGetToken", "json: %s", jSONObject.toString());
        }
        AppMethodBeat.o(43409);
    }

    public final boolean bXn() {
        AppMethodBeat.i(43410);
        ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "do save token");
        k.bXg();
        k.aT(196626, this.oYn);
        k.bXg();
        k.aT(196627, this.oYo);
        k.bXg();
        k.aT(196628, this.oYp);
        k.bXg();
        k.aT(196632, (System.currentTimeMillis() / 1000));
        a.r(this.token, this.oYr, this.oYt, this.oYu);
        a.AD(this.oYs);
        k.bXg();
        k.aT(196647, this.oYv);
        k.bXg();
        String Ax = k.Ax(196617);
        b.dNJ();
        b.clearToken(Ax);
        b.dNJ();
        boolean F = b.F(Ax, this.oYx, this.oYB == 1);
        com.tencent.mm.g.b.a.a aVar = new com.tencent.mm.g.b.a.a();
        aVar.ep(this.cEW);
        aVar.cTl = 3;
        if (F) {
            aVar.cTm = 1;
            b.dNJ();
            aVar.cTn = (long) b.getLastError();
            ab.i("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens success!");
        } else {
            aVar.cTm = 0;
            b.dNJ();
            aVar.cTn = (long) b.getLastError();
            ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", "CertUtil.getInstance().setTokens failed!");
            StringBuilder stringBuilder = new StringBuilder("WalletOfflineEntranceUI CertUtil.getInstance().getLastError():");
            b.dNJ();
            ab.e("MicroMsg.NetSceneTenpayWxOfflineGetToken", stringBuilder.append(b.getLastError()).toString());
        }
        aVar.ajK();
        k.bXg();
        k.aT(196649, this.oYy);
        g.RQ();
        g.RP().Ry().set(ac.a.USERINFO_WALLET_OFFLINE_CODE_VER_STRING, this.oYz);
        AppMethodBeat.o(43410);
        return F;
    }

    public final int ZU() {
        if (k.oXK) {
            return 571;
        }
        return 1725;
    }

    public final String getUri() {
        if (k.oXK) {
            return "/cgi-bin/mmpay-bin/tenpay/offlinegettoken";
        }
        return "/cgi-bin/mmpay-bin/tenpay/offlinegettokenbackground";
    }
}
