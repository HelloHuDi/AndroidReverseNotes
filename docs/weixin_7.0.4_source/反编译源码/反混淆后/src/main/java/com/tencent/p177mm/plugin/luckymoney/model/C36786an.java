package com.tencent.p177mm.plugin.luckymoney.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.net.URLEncoder;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.an */
public final class C36786an extends C34442ak {
    public String cRS;
    long cvx;
    public String nSX;
    public RealnameGuideHelper nTN;
    public String nYA;
    public int nYB;
    public LuckyMoneyEmojiSwitch nYC;
    public String nYV;
    public int nYW = 0;
    public C12428k nYn = null;
    public String talker;

    public C36786an(int i, int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(42413);
        this.nSX = str;
        this.cRS = str2;
        this.talker = str5;
        HashMap hashMap = new HashMap();
        hashMap.put("msgType", String.valueOf(i));
        hashMap.put(DownloadInfoColumns.CHANNELID, String.valueOf(i2));
        hashMap.put("sendId", str);
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put("nativeUrl", URLEncoder.encode(str2));
        }
        if (!C5046bo.isNullOrNil(str3)) {
            hashMap.put("headImg", URLEncoder.encode(str3));
            hashMap.put("nickName", URLEncoder.encode(C5046bo.nullAsNil(str4)));
        }
        hashMap.put("sessionUserName", str5);
        hashMap.put("ver", str6);
        hashMap.put("timingIdentifier", str7);
        mo46410M(hashMap);
        AppMethodBeat.m2505o(42413);
    }

    public final int getType() {
        return 1685;
    }

    public final String bgF() {
        return "/cgi-bin/mmpay-bin/openwxhb";
    }

    /* renamed from: a */
    public final void mo7791a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.m2504i(42414);
        try {
            this.nYn = C43263v.m77008W(jSONObject);
            this.nYC = LuckyMoneyEmojiSwitch.m20343V(jSONObject);
            C4990ab.m7417i("NetSceneLuckyMoneyDetail", "luckyMoneyEmojiSwitch:%s", this.nYC.toString());
            this.nYA = jSONObject.optString("expression_md5");
            this.nYB = jSONObject.optInt("expression_type");
            C4990ab.m7417i("NetSceneLuckyMoneyDetail", "expressionmd5:%s expressiontype:%s", this.nYA, Integer.valueOf(this.nYB));
            if (i == 0 && jSONObject.has("real_name_info")) {
                JSONObject optJSONObject = jSONObject.optJSONObject("real_name_info");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("guide_flag");
                    String optString2 = optJSONObject.optString("guide_wording");
                    String optString3 = optJSONObject.optString("left_button_wording");
                    String optString4 = optJSONObject.optString("right_button_wording");
                    String optString5 = optJSONObject.optString("upload_credit_url");
                    this.nTN = new RealnameGuideHelper();
                    this.nTN.mo74571a(optString, optString2, optString3, optString4, optString5, 1003);
                }
            }
            this.nYV = jSONObject.optString("SystemMsgContext");
            this.nYW = jSONObject.optInt("showYearExpression");
            C4990ab.m7417i("NetSceneLuckyMoneyDetail", "showYearExpression:%s", Integer.valueOf(this.nYW));
            if (!(i != 0 || C5046bo.isNullOrNil(this.nYV) || C5046bo.isNullOrNil(this.nYn.nXl))) {
                try {
                    CharSequence string;
                    if (C1853r.m3846Yz().equals(this.nYn.nXl)) {
                        string = C4996ah.getContext().getString(C25738R.string.cti);
                    } else {
                        string = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(this.nYn.nXl);
                    }
                    this.nYV = this.nYV.replace("$" + this.nYn.nXl + "$", string);
                    C46063x.m85816eV(this.nYV, this.talker);
                } catch (Exception e) {
                    C4990ab.m7413e("NetSceneLuckyMoneyDetail", "insertLocalSysMsgIfNeed error: %s", e.getMessage());
                }
            }
            C1720g.m3537RQ();
            int intValue = ((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_LUCKY_MONEY_HONGBAO_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue();
            int a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_hongbao_emoji_all_switch, 0);
            if (C5046bo.m7563gW(intValue, 1) || C5046bo.m7563gW(a, 1)) {
                if (this.nYC == null) {
                    this.nYC = new LuckyMoneyEmojiSwitch();
                }
                this.nYC.nXp = 1;
                this.nYC.nXq = 1;
                this.nYC.nXr = 1;
                this.nYC.nXs = 1;
                this.nYW = 1;
            }
            C4990ab.m7417i("NetSceneLuckyMoneyDetail", "localSwitch() luckyMoneyEmojiSwitch:%s ", this.nYC.toString());
            AppMethodBeat.m2505o(42414);
        } catch (JSONException e2) {
            C4990ab.m7420w("NetSceneLuckyMoneyDetail", "parse luckyMoneyDetail fail: " + e2.getLocalizedMessage());
            AppMethodBeat.m2505o(42414);
        }
    }
}
