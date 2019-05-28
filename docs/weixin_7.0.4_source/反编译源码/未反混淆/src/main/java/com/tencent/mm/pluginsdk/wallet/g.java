package com.tencent.mm.pluginsdk.wallet;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.Map;
import org.json.JSONObject;

public final class g {
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

    public g(Map<String, Object> map) {
        AppMethodBeat.i(135772);
        this.appId = (String) map.get("appId");
        this.partnerId = (String) map.get("partnerId");
        this.signType = (String) map.get("signType");
        this.nonceStr = (String) map.get("nonceStr");
        this.timeStamp = (String) map.get("timeStamp");
        this.packageExt = (String) map.get("package");
        this.czZ = (String) map.get("reqKey");
        this.vws = bo.getInt((String) map.get("payScene"), 1);
        this.foo = bo.getInt((String) map.get("businessScene"), 1);
        this.cId = (String) map.get("paySign");
        this.url = (String) map.get("url");
        this.cIe = (String) map.get("src_username");
        this.cIf = bo.getInt((String) map.get("scene"), 0);
        if (this.cIf == 0) {
            this.cIf = bo.getInt((String) map.get("pay_scene"), 0);
        }
        this.cvS = bo.getInt((String) map.get("pay_channel"), 0);
        this.extInfo = bo.nullAsNil((String) map.get("ext_info"));
        this.vwv = bo.nullAsNil((String) map.get("token"));
        this.vww = bo.getInt(bo.bc((String) map.get("result_jump_mode"), AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
        this.vwx = bo.nullAsNil((String) map.get("key_appbrand_from_path"));
        this.vwy = bo.nullAsNil((String) map.get("key_appbrand_from_username"));
        this.vwz = bo.nullAsNil((String) map.get("key_appbrand_from_scene"));
        AppMethodBeat.o(135772);
    }

    public g(JSONObject jSONObject) {
        AppMethodBeat.i(135773);
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
        this.vww = bo.getInt(jSONObject.optString("result_jump_mode", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
        this.vwu = jSONObject.optInt("pay_for_wallet_type", 0);
        this.vwx = bo.nullAsNil(jSONObject.optString("key_appbrand_from_path"));
        this.vwy = bo.nullAsNil(jSONObject.optString("key_appbrand_from_username"));
        this.vwz = bo.nullAsNil(jSONObject.optString("key_appbrand_from_scene"));
        AppMethodBeat.o(135773);
    }

    public g(mg mgVar) {
        AppMethodBeat.i(135774);
        if (mgVar == null || mgVar.cIc == null) {
            AppMethodBeat.o(135774);
            return;
        }
        this.appId = mgVar.cIc.appId;
        this.partnerId = mgVar.cIc.partnerId;
        this.signType = mgVar.cIc.signType;
        this.nonceStr = mgVar.cIc.nonceStr;
        this.timeStamp = mgVar.cIc.timeStamp;
        this.packageExt = mgVar.cIc.packageExt;
        this.cId = mgVar.cIc.cId;
        this.url = mgVar.cIc.url;
        this.cIe = mgVar.cIc.cIe;
        this.cIf = mgVar.cIc.cIf;
        this.cvS = mgVar.cIc.cvS;
        this.cIg = mgVar.cIc.cIg;
        AppMethodBeat.o(135774);
    }

    public static int gS(int i, int i2) {
        if (i == FilterEnum4Shaka.MIC_SHAKA_ADD2_2 && i2 > 0) {
            return i2;
        }
        return i;
    }

    public static int gT(int i, int i2) {
        AppMethodBeat.i(135775);
        int gS = gS(i, i2);
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
        ab.i("MicroMsg.WalletJsapiData", "parsePayChannelByScene, scene: %s, rawScene: %s, resultChannel: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(gS));
        AppMethodBeat.o(135775);
        return gS;
    }
}
