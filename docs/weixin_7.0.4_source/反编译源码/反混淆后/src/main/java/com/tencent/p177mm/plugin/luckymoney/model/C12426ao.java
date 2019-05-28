package com.tencent.p177mm.plugin.luckymoney.model;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.wallet_core.model.C29628a;
import com.tencent.p177mm.protocal.protobuf.atm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.ao */
public final class C12426ao extends C34442ak {
    public C29628a cMO;
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

    public C12426ao(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7) {
        this(i, j, j2, i2, str, str2, str3, str4, str5, str6, i3, str7, "", 0, 0, "", "", 0);
    }

    public C12426ao(int i, long j, long j2, int i2, String str, String str2, String str3, String str4, String str5, String str6, int i3, String str7, String str8, int i4, int i5, String str9, String str10, int i6) {
        AppMethodBeat.m2504i(42415);
        this.nZb = "";
        this.nZc = "";
        this.nZd = "";
        C4990ab.m7417i("MicroMsg.NetScenePrepareLuckyMoney", "NetScenePrepareLuckyMoney() uniqueId:%s, userConfiremJump:%s, unpayType:%s, cancelSendId:%s", str8, Integer.valueOf(i4), Integer.valueOf(i5), C5046bo.nullAsNil(str9));
        this.kCd = i;
        HashMap hashMap = new HashMap();
        hashMap.put("totalNum", String.valueOf(i));
        hashMap.put("totalAmount", String.valueOf(j));
        hashMap.put("perValue", String.valueOf(j2));
        hashMap.put("hbType", String.valueOf(i2));
        hashMap.put("wishing", URLEncoder.encode(C5046bo.nullAsNil(str)));
        hashMap.put("sendUserName", str5);
        if (!C5046bo.isNullOrNil(str8)) {
            hashMap.put("unique_id", str8);
        }
        hashMap.put("user_confirm_jump", String.valueOf(i4));
        hashMap.put("unpay_type", String.valueOf(i5));
        hashMap.put("cancel_sendid", str9);
        hashMap.put("expression_md5", str10);
        hashMap.put("expression_type", String.valueOf(i6));
        if (!C5046bo.isNullOrNil(str3)) {
            hashMap.put("username", str3);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("headImg", URLEncoder.encode(str2));
            hashMap.put("nickName", URLEncoder.encode(C5046bo.nullAsNil(str6)));
            if (!C5046bo.isNullOrNil(str4)) {
                hashMap.put("receiveNickName", URLEncoder.encode(str4));
            }
        }
        hashMap.put("inWay", String.valueOf(i3));
        if (i3 == 0 || i3 == 1 || i3 == 7) {
            hashMap.put("needSendToMySelf", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        hashMap.put("showSourceMac", URLEncoder.encode(str7));
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42415);
    }

    public final int getType() {
        return 1575;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/requestwxhb";
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42416);
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
            C4990ab.m7416i("MicroMsg.NetScenePrepareLuckyMoney", "has alert item");
            this.cMO = C12426ao.m20345a(this, jSONObject);
        }
        AppMethodBeat.m2505o(42416);
    }

    /* renamed from: a */
    public static C29628a m20345a(C12426ao c12426ao, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42417);
        C29628a c29628a = new C29628a();
        c29628a.cEh = jSONObject.optString("retmsg");
        JSONObject optJSONObject = jSONObject.optJSONObject("showmess");
        c29628a.nZb = optJSONObject.optString("left_button_wording");
        c29628a.nZc = optJSONObject.optString("right_button_wording");
        c29628a.kCs = optJSONObject.optString("right_button_url");
        if (c12426ao != null) {
            c12426ao.nZf = jSONObject.optInt("return_to_session", 0);
        }
        AppMethodBeat.m2505o(42417);
        return c29628a;
    }

    /* renamed from: m */
    public static boolean m20346m(C1207m c1207m) {
        AppMethodBeat.m2504i(42418);
        try {
            JSONObject jSONObject = new JSONObject(C1946aa.m4153b(((atm) ((C7472b) c1207m.ftl).fsH.fsP).wxA));
            if (jSONObject.has("showmess") && C5046bo.m7563gW(jSONObject.optJSONObject("showmess").optInt("return_to_session", 0), 1)) {
                AppMethodBeat.m2505o(42418);
                return true;
            }
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.NetScenePrepareLuckyMoney", "ifReturnByReturnToSession() Exception：%s", e.getMessage());
        }
        AppMethodBeat.m2505o(42418);
        return false;
    }
}
