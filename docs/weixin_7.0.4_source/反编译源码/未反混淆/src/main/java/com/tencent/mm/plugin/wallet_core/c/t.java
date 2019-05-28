package com.tencent.mm.plugin.wallet_core.c;

import android.text.TextUtils;
import android.util.SparseArray;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.x;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class t extends m {
    public String kaE;
    public String mTimeStamp;
    public String pNL;
    public List<ElementQuery> tum;
    public ElementQuery tun;
    private int tuo;
    private int tup;
    private int tuq;
    public Profession[] tur;
    public int tus;
    public String[] tut;

    public t(String str, String str2, PayInfo payInfo) {
        this(str, str2, payInfo, null, -1, -1, (byte) 0);
    }

    public t(String str, String str2, PayInfo payInfo, int i) {
        this(str, str2, payInfo, null, -1, i, (byte) 0);
    }

    public t(String str, String str2, PayInfo payInfo, String str3, int i, int i2) {
        this(str, str2, payInfo, str3, i, i2, (byte) 0);
    }

    public t() {
        this(null, null, null, null, -1, -1, (byte) 0);
    }

    private t(String str, String str2, PayInfo payInfo, String str3, int i, int i2, byte b) {
        AppMethodBeat.i(46538);
        this.tum = null;
        this.tun = null;
        this.mTimeStamp = null;
        this.kaE = null;
        this.pNL = null;
        this.tuo = 3;
        this.tur = null;
        this.tut = null;
        this.kaE = str2;
        this.tuo = 3;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        a(payInfo, (Map) hashMap, (Map) hashMap2);
        hashMap.put("req_key", str);
        hashMap.put("flag", "4");
        hashMap.put("card_id", str2);
        if (i2 > 0) {
            hashMap.put("realname_scene", String.valueOf(i2));
            ab.i("MicroMsg.NetSenceTenPayBase", "realname_scene=%d", Integer.valueOf(i2));
        }
        if (i == 8) {
            hashMap.put("scene", "1003");
        }
        hashMap.put("bank_card_tag", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        hashMap.put("token", str3);
        M(hashMap);
        if (x.dNS()) {
            hashMap2.put("uuid_for_bindcard", x.dNU());
            hashMap2.put("bindcard_scene", x.dNT());
        }
        ba(hashMap2);
        AppMethodBeat.o(46538);
    }

    public final int bgI() {
        return 73;
    }

    public final void a(int i, String str, JSONObject jSONObject) {
        AppMethodBeat.i(46539);
        this.tum = new ArrayList();
        try {
            String str2;
            int i2;
            JSONObject jSONObject2;
            this.mTimeStamp = jSONObject.optString("time_stamp");
            String optString = jSONObject.optString("bank_type");
            if (bo.isNullOrNil(this.pNL)) {
                str2 = optString;
            } else {
                str2 = this.pNL;
            }
            JSONArray jSONArray = jSONObject.getJSONArray("Array");
            int length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                ElementQuery elementQuery = new ElementQuery();
                elementQuery.fvc = jSONObject2;
                elementQuery.nuL = jSONObject2.optString("bank_name");
                elementQuery.pbn = jSONObject2.optString("bank_type");
                elementQuery.tyF = jSONObject2.optString("bankacc_type_name");
                elementQuery.tyH = jSONObject2.optString("bank_phone");
                elementQuery.tyK = jSONObject2.optString("forbid_word");
                elementQuery.tyJ = jSONObject2.optString("bank_recommend_desc");
                elementQuery.tyI = jSONObject2.optString("bank_app_user_name");
                elementQuery.tyE = jSONObject2.optInt("bankacc_type", 1);
                elementQuery.tyw = e.n(jSONObject2, "canModifyName");
                elementQuery.tyx = e.n(jSONObject2, "canModifyCreID");
                elementQuery.tyC = AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(jSONObject2.optString("is_sure"));
                elementQuery.tyy = "1".equals(jSONObject2.optString("needCVV"));
                elementQuery.tyz = "1".equals(jSONObject2.optString("needValiDate"));
                elementQuery.tyv = jSONObject2.optString("time_stamp");
                elementQuery.tyB = jSONObject2.optString("uesr_name");
                elementQuery.tyG = jSONObject2.optString("bank_flag");
                elementQuery.tyL = e.n(jSONObject2, "needFirstName");
                elementQuery.tyM = e.n(jSONObject2, "needLastName");
                elementQuery.tyN = e.n(jSONObject2, "needCountry");
                elementQuery.tyO = e.n(jSONObject2, "needArea");
                elementQuery.tyP = e.n(jSONObject2, "needCity");
                elementQuery.tyQ = e.n(jSONObject2, "needAddress");
                elementQuery.tyR = e.n(jSONObject2, "needZip");
                elementQuery.tyS = e.n(jSONObject2, "needPhone");
                elementQuery.tyT = e.n(jSONObject2, "needEmail");
                elementQuery.tyW = e.n(jSONObject2, "needShowProtocol");
                elementQuery.tyU = jSONObject2.optString("support_cre_type");
                elementQuery.tyA = jSONObject2.optString("cre_id");
                elementQuery.tuo = jSONObject2.optInt("bank_card_tag", 1);
                if (elementQuery.tuo == 1) {
                    if (!e.n(jSONObject2, "IsSaveYfq")) {
                        elementQuery.tyD = 0;
                    } else if (e.n(jSONObject2, "canReturnYfq")) {
                        elementQuery.tyD = 4;
                    } else {
                        elementQuery.tyD = 3;
                    }
                } else if (jSONObject2.optInt("auth_mode") == 1) {
                    elementQuery.tyD = 1;
                } else {
                    elementQuery.tyD = 2;
                }
                String optString2 = jSONObject2.optString("support_micropay");
                if (TextUtils.isEmpty(optString2)) {
                    elementQuery.tza = true;
                } else if ("1".equals(optString2)) {
                    elementQuery.tza = true;
                } else if (AppEventsConstants.EVENT_PARAM_VALUE_NO.equals(optString2)) {
                    elementQuery.tza = false;
                }
                elementQuery.twk = jSONObject2.optString("arrive_type");
                elementQuery.tyX = jSONObject2.optString("pre_auth_word");
                elementQuery.tyY = jSONObject2.optInt("support_foreign_mobile", 0);
                elementQuery.tyZ = ElementQuery.ax(jSONObject2);
                if (Bankcard.gh(this.tuo, elementQuery.tuo)) {
                    this.tum.add(elementQuery);
                }
                if (str2 != null && str2.equals(elementQuery.pbn)) {
                    this.tun = elementQuery;
                }
            }
            SparseArray sparseArray = new SparseArray();
            jSONArray = jSONObject.getJSONArray("cre_type_map");
            length = jSONArray.length();
            for (i2 = 0; i2 < length; i2++) {
                jSONObject2 = jSONArray.getJSONObject(i2);
                int optInt = jSONObject2.optInt("key", 0);
                if (optInt > 0) {
                    sparseArray.put(optInt, jSONObject2.getString("val"));
                }
            }
            com.tencent.mm.plugin.wallet_core.model.t cPQ = r.cPQ();
            List list = this.tum;
            cPQ.tCm = sparseArray;
            cPQ.tum = list;
            this.tup = jSONObject.optInt("need_area");
            this.tuq = jSONObject.optInt("need_profession");
            if (!(this.tun == null || this.tun.tuo == 1)) {
                ab.i("MicroMsg.NetSenceTenPayBase", "oversea card, no need area and profession");
                this.tup = 0;
                this.tuq = 0;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("profession_array");
            if (optJSONArray != null) {
                this.tur = new Profession[optJSONArray.length()];
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                    if (optJSONObject != null) {
                        String optString3 = optJSONObject.optString("profession_name");
                        int optInt2 = optJSONObject.optInt("profession_type");
                        if (bo.isNullOrNil(optString3)) {
                            ab.i("MicroMsg.NetSenceTenPayBase", "empty profession_name!");
                        } else {
                            this.tur[i2] = new Profession(optString3, optInt2);
                        }
                    }
                }
            }
            this.tus = jSONObject.optInt("need_nationality", 0);
            optJSONArray = jSONObject.optJSONArray("nationality_exclude_array");
            if (optJSONArray != null) {
                this.tut = new String[optJSONArray.length()];
                for (i2 = 0; i2 < optJSONArray.length(); i2++) {
                    this.tut[i2] = optJSONArray.optString(i2);
                }
            }
            AppMethodBeat.o(46539);
        } catch (JSONException e) {
            ab.printErrStackTrace("MicroMsg.NetSenceTenPayBase", e, "", new Object[0]);
            AppMethodBeat.o(46539);
        }
    }

    public final int ZU() {
        return 1505;
    }

    public final String getUri() {
        return "/cgi-bin/mmpay-bin/tenpay/elementquerynew";
    }

    public final boolean cOU() {
        return this.tup == 1;
    }

    public final boolean cOV() {
        return this.tuq == 1;
    }
}
