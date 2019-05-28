package com.tencent.p177mm.pluginsdk.wallet;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p230g.p231a.C18325mg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.pluginsdk.wallet.g */
public final class C40493g {
    public String appId;
    public String cId;
    public String cIe;
    public int cIf;
    public int cIg;
    public int cvS;
    public String czZ;
    public String extInfo;
    public String flp;
    public int foo;
    public String nonceStr;
    public String packageExt;
    public String partnerId;
    public String signType;
    public String timeStamp;
    public String url;
    public int vws;
    public int vwt;
    public int vwu = 0;
    public String vwv;
    public int vww = 0;
    public String vwx;
    public String vwy;
    public String vwz;

    public C40493g(Map<String, Object> map) {
        AppMethodBeat.m2504i(135772);
        this.appId = (String) map.get("appId");
        this.partnerId = (String) map.get("partnerId");
        this.signType = (String) map.get("signType");
        this.nonceStr = (String) map.get("nonceStr");
        this.timeStamp = (String) map.get("timeStamp");
        this.packageExt = (String) map.get("package");
        this.czZ = (String) map.get("reqKey");
        this.vws = C5046bo.getInt((String) map.get("payScene"), 1);
        this.foo = C5046bo.getInt((String) map.get("businessScene"), 1);
        this.cId = (String) map.get("paySign");
        this.url = (String) map.get("url");
        this.cIe = (String) map.get("src_username");
        this.cIf = C5046bo.getInt((String) map.get("scene"), 0);
        if (this.cIf == 0) {
            this.cIf = C5046bo.getInt((String) map.get("pay_scene"), 0);
        }
        this.cvS = C5046bo.getInt((String) map.get("pay_channel"), 0);
        this.extInfo = C5046bo.nullAsNil((String) map.get("ext_info"));
        this.vwv = C5046bo.nullAsNil((String) map.get("token"));
        this.vww = C5046bo.getInt(C5046bo.m7532bc((String) map.get("result_jump_mode"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
        this.vwx = C5046bo.nullAsNil((String) map.get("key_appbrand_from_path"));
        this.vwy = C5046bo.nullAsNil((String) map.get("key_appbrand_from_username"));
        this.vwz = C5046bo.nullAsNil((String) map.get("key_appbrand_from_scene"));
        AppMethodBeat.m2505o(135772);
    }

    public C40493g(JSONObject jSONObject) {
        AppMethodBeat.m2504i(135773);
        this.appId = jSONObject.optString("appId");
        this.partnerId = jSONObject.optString("partnerId");
        this.signType = jSONObject.optString("signType");
        this.nonceStr = jSONObject.optString("nonceStr");
        this.timeStamp = jSONObject.optString("timeStamp");
        this.packageExt = jSONObject.optString("package");
        this.czZ = jSONObject.optString("reqKey");
        this.vws = jSONObject.optInt("payScene", 1);
        this.foo = jSONObject.optInt("businessScene", 1);
        this.cId = jSONObject.optString("paySign");
        this.flp = jSONObject.optString("cookie");
        this.url = jSONObject.optString("url");
        this.cIe = jSONObject.optString("src_username");
        this.cIf = jSONObject.optInt("scene", 0);
        if (this.cIf == 0) {
            this.cIf = jSONObject.optInt("pay_scene", 0);
        }
        this.cvS = jSONObject.optInt("pay_channel", 0);
        this.extInfo = jSONObject.optString("ext_info", "");
        this.vwv = jSONObject.optString("token", "");
        this.vww = C5046bo.getInt(jSONObject.optString("result_jump_mode", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
        this.vwu = jSONObject.optInt("pay_for_wallet_type", 0);
        this.vwx = C5046bo.nullAsNil(jSONObject.optString("key_appbrand_from_path"));
        this.vwy = C5046bo.nullAsNil(jSONObject.optString("key_appbrand_from_username"));
        this.vwz = C5046bo.nullAsNil(jSONObject.optString("key_appbrand_from_scene"));
        AppMethodBeat.m2505o(135773);
    }

    public C40493g(C18325mg c18325mg) {
        AppMethodBeat.m2504i(135774);
        if (c18325mg == null || c18325mg.cIc == null) {
            AppMethodBeat.m2505o(135774);
            return;
        }
        this.appId = c18325mg.cIc.appId;
        this.partnerId = c18325mg.cIc.partnerId;
        this.signType = c18325mg.cIc.signType;
        this.nonceStr = c18325mg.cIc.nonceStr;
        this.timeStamp = c18325mg.cIc.timeStamp;
        this.packageExt = c18325mg.cIc.packageExt;
        this.cId = c18325mg.cIc.cId;
        this.url = c18325mg.cIc.url;
        this.cIe = c18325mg.cIc.cIe;
        this.cIf = c18325mg.cIc.cIf;
        this.cvS = c18325mg.cIc.cvS;
        this.cIg = c18325mg.cIc.cIg;
        AppMethodBeat.m2505o(135774);
    }

    /* renamed from: gS */
    public static int m69625gS(int i, int i2) {
        if (i == FilterEnum4Shaka.MIC_SHAKA_ADD2_2 && i2 > 0) {
            return i2;
        }
        return i;
    }

    /* renamed from: gT */
    public static int m69626gT(int i, int i2) {
        AppMethodBeat.m2504i(135775);
        int gS = C40493g.m69625gS(i, i2);
        if (gS == 1000 || gS == 1018 || gS == 1017 || gS == 1033) {
            gS = 0;
        } else if (gS == 1019) {
            gS = 1;
        } else if (gS == 1010) {
            gS = 5;
        } else if (gS == 1007 || gS == 1008) {
            gS = 6;
        } else if (gS == 1009) {
            gS = 7;
        } else if (gS == 1035 || gS == 1020) {
            gS = 8;
        } else if (gS == 1011 || gS == FilterEnum4Shaka.MIC_SHAKA_ADD2_12 || gS == 1025) {
            gS = 12;
        } else if (gS == 1012 || gS == FilterEnum4Shaka.MIC_SHAKA_ADD_13 || gS == 1048 || gS == 1050) {
            gS = 13;
        } else if (gS == 1005 || gS == 1027 || gS == 1042 || gS == 1006) {
            gS = 15;
        } else if (gS == WXMediaMessage.DESCRIPTION_LENGTH_LIMIT || gS == TXLiveConstants.PUSH_EVT_ROOM_NEED_REENTER) {
            gS = 16;
        } else if (gS == 1029 || gS == 1028) {
            gS = 23;
        } else if (gS == 1013 || gS == 1031 || gS == 1049) {
            gS = 24;
        } else if (gS == 1001 || gS == 1003) {
            gS = 25;
        } else if (gS == 1045 || gS == 1046) {
            gS = 26;
        } else if (gS == 1022) {
            gS = 27;
        } else if (gS == FilterEnum4Shaka.MIC_SHAKA_ADD_4) {
            gS = 28;
        } else if (gS == 1026) {
            gS = 29;
        } else if (gS == 1039) {
            gS = 30;
        } else if (gS == 1034 || gS == 1060) {
            gS = 31;
        } else if (gS == 1014 || gS == FilterEnum4Shaka.MIC_SHAKA_ADD2_8 || gS == FilterEnum4Shaka.MIC_SHAKA_ADD2_9 || gS == 1036) {
            gS = 32;
        }
        C4990ab.m7417i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(gS));
        AppMethodBeat.m2505o(135775);
        return gS;
    }
}
