package com.tencent.mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class an extends ak {
    public String cRS;
    long cvx;
    public String nSX;
    public RealnameGuideHelper nTN;
    public String nYA;
    public int nYB;
    public LuckyMoneyEmojiSwitch nYC;
    public String nYV;
    public int nYW = 0;
    public k nYn = null;
    public String talker;

    public an(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.i(42413);
        this.nSX = str;
        this.cRS = str2;
        this.talker = str5;
        HashMap hashMap = new HashMap();
        hashMap.put("msgType", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i2));
        hashMap.put("sendId", str);
        if (!bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        if (!bo.isNullOrNil(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
            hashMap.put("nickName", URLEncoder.encode(bo.nullAsNil(str4)));
        }
        hashMap.put("sessionUserName", str5);
        hashMap.put("ver", str6);
        hashMap.put("timingIdentifier", str7);
        M(hashMap);
        AppMethodBeat.o(42413);
    }

    public final int getType() {
        return 1685;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/openwxhb";
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(42414);
        try {
            this.nYn = v.W(jSONObject);
            this.nYC = LuckyMoneyEmojiSwitch.V(jSONObject);
            ab.i("NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", this.nYC.toString());
            this.nYA = jSONObject.optString("expression_md5");
            this.nYB = jSONObject.optInt("expression_type");
            ab.i("NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", this.nYA, Integer.valueOf(this.nYB));
            if (i == 0 && jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("guide_flag");
                    String optString2 = optJSONObject.optString("guide_wording");
                    String optString3 = optJSONObject.optString("left_button_wording");
                    String optString4 = optJSONObject.optString("right_button_wording");
                    String optString5 = optJSONObject.optString("upload_credit_url");
                    this.nTN = new RealnameGuideHelper();
                    this.nTN.a(optString, optString2, optString3, optString4, optString5, 1003);
                }
            }
            this.nYV = jSONObject.optString("SystemMsgContext");
            this.nYW = jSONObject.optInt("showYearExpression");
            ab.i("NetSceneLuckyMoneyDetail", "showYearExpression:%s", Integer.valueOf(this.nYW));
            if (!(i != 0 || bo.isNullOrNil(this.nYV) || bo.isNullOrNil(this.nYn.nXl))) {
                try {
                    CharSequence string;
                    if (r.Yz().equals(this.nYn.nXl)) {
                        string = ah.getContext().getString(R.string.cti);
                    } else {
                        string = ((b) g.K(b.class)).mJ(this.nYn.nXl);
                    }
                    this.nYV = this.nYV.replace("$" + this.nYn.nXl + "$", string);
                    x.eV(this.nYV, this.talker);
                } catch (Exception e) {
                    ab.e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", e.getMessage());
                }
            }
            g.RQ();
            int intValue = ((Integer) g.RP().Ry().get(a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue();
            int a = ((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_hongbao_emoji_all_switch, 0);
            if (bo.gW(intValue, 1) || bo.gW(a, 1)) {
                if (this.nYC == null) {
                    this.nYC = new LuckyMoneyEmojiSwitch();
                }
                this.nYC.nXp = 1;
                this.nYC.nXq = 1;
                this.nYC.nXr = 1;
                this.nYC.nXs = 1;
                this.nYW = 1;
            }
            ab.i("NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", this.nYC.toString());
            AppMethodBeat.o(42414);
        } catch (JSONException e2) {
            ab.w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e2.getLocalizedMessage());
            AppMethodBeat.o(42414);
        }
    }
}
