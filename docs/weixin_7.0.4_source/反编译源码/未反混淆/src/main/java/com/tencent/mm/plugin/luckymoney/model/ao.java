package com.tencent.mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.wallet_core.model.a;
import com.tencent.mm.protocal.protobuf.atm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

public final class ao extends ak {
    public a cMO;
    public int kCd;
    public String nSX;
    public String nYX;
    public String nYY;
    public String nYZ;
    public String nZa;
    public String nZb;
    public String nZc;
    public String nZd;
    public String nZe;
    public int nZf;

    public ao(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7) {
        this(i, j, j2, i2, str, str2, str3, str4, str5, str6, i3, str7, "", 0, 0, "", "", 0);
    }

    public ao(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, int i4, int i5, String str9, String str10, int i6) {
        AppMethodBeat.i(42415);
        this.nZb = "";
        this.nZc = "";
        this.nZd = "";
        ab.i("MicroMsg.NetScenePrepareLuckyMoney", "NetScenePrepareLuckyMoney() uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", str8, Integer.valueOf(i4), Integer.valueOf(i5), bo.nullAsNil(str9));
        this.kCd = i;
        HashMap hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(bo.nullAsNil(str)));
        hashMap.put("sendUserName", str5);
        if (!bo.isNullOrNil(str8)) {
            hashMap.put("unique_id", str8);
        }
        hashMap.put("user_confirm_jump", String.valueOf(i4));
        hashMap.put("unpay_type", String.valueOf(i5));
        hashMap.put("cancel_sendid", str9);
        hashMap.put("expression_md5", str10);
        hashMap.put("expression_type", String.valueOf(i6));
        if (!bo.isNullOrNil(str3)) {
            hashMap.put("username", str3);
        }
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(bo.nullAsNil(str6)));
            if (!bo.isNullOrNil(str4)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str4));
            }
        }
        hashMap.put("inWay", String.valueOf(i3));
        if (i3 == 0 || i3 == 1 || i3 == 7) {
            hashMap.put("needSendToMySelf", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        hashMap.put("showSourceMac", URLEncoder.encode(str7));
        M(hashMap);
        AppMethodBeat.o(42415);
    }

    public final int getType() {
        return 1575;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/requestwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42416);
        this.nSX = jSONObject.optString("sendId");
        this.nYX = jSONObject.optString("reqkey");
        this.nYY = jSONObject.optString("sendMsgXml");
        this.nYZ = jSONObject.optString("guide_flag", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.nZa = jSONObject.optString("guide_wording");
        this.nZb = jSONObject.optString("left_button_wording", "");
        this.nZc = jSONObject.optString("right_button_wording", "");
        this.nZd = jSONObject.optString("upload_credit_url", "");
        this.nZe = jSONObject.optString("id_sign", "");
        if (jSONObject.has("showmess")) {
            ab.i("MicroMsg.NetScenePrepareLuckyMoney", "has alert item");
            this.cMO = a(this, jSONObject);
        }
        AppMethodBeat.o(42416);
    }

    public static a a(ao aoVar, JSONObject jSONObject) {
        AppMethodBeat.i(42417);
        a aVar = new a();
        aVar.cEh = jSONObject.optString("retmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("showmess");
        aVar.nZb = optJSONObject.optString("left_button_wording");
        aVar.nZc = optJSONObject.optString("right_button_wording");
        aVar.kCs = optJSONObject.optString("right_button_url");
        if (aoVar != null) {
            aoVar.nZf = jSONObject.optInt("return_to_session", 0);
        }
        AppMethodBeat.o(42417);
        return aVar;
    }

    public static boolean m(m mVar) {
        AppMethodBeat.i(42418);
        try {
            JSONObject jSONObject = new JSONObject(aa.b(((atm) ((b) mVar.ftl).fsH.fsP).wxA));
            if (jSONObject.has("showmess") && bo.gW(jSONObject.optJSONObject("showmess").optInt("return_to_session", 0), 1)) {
                AppMethodBeat.o(42418);
                return true;
            }
        } catch (Exception e) {
            ab.i("MicroMsg.NetScenePrepareLuckyMoney", "ifReturnByReturnToSession() Exception：%s", e.getMessage());
        }
        AppMethodBeat.o(42418);
        return false;
    }
}
