package com.tencent.p177mm.wallet_core.p649c;

import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p230g.p232b.p233a.C26294i;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.wallet_core.model.C22594k;
import com.tencent.p177mm.pluginsdk.wallet.C46512f;
import com.tencent.p177mm.pluginsdk.wallet.PayInfo;
import com.tencent.p177mm.protocal.protobuf.C15319aw;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.wallet_core.p650ui.C36391e;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.wallet_core.c.q */
public abstract class C44430q extends C36378u {
    protected int AfF = 0;
    protected int AfG = 0;
    private String AfH = "";
    public String AfI = "";
    public String AfJ = "";
    protected boolean AfK = false;
    protected String AfL;
    public boolean AfM = false;
    private Map<String, String> AfN = new HashMap();
    public boolean AfO = false;
    protected C7472b ehh;
    protected C1202f ehi;
    public C24147k nYe;
    public int tyd = 0;
    public String tye = "";
    public int tyf = 0;
    public String tyg = "";
    public int tyh = 0;

    /* renamed from: U */
    public abstract void mo11719U(boolean z, boolean z2);

    /* renamed from: a */
    public abstract void mo9383a(int i, String str, JSONObject jSONObject);

    /* renamed from: a */
    public abstract void mo11720a(C7472b c7472b, SKBuiltinBuffer_t sKBuiltinBuffer_t);

    public abstract String acv(String str);

    /* renamed from: b */
    public abstract void mo11722b(C7472b c7472b, SKBuiltinBuffer_t sKBuiltinBuffer_t);

    public abstract int cOo();

    /* renamed from: e */
    public abstract C16080v mo11727e(C7472b c7472b);

    /* renamed from: a */
    public void mo26460a(C24144d c24144d, JSONObject jSONObject) {
    }

    public boolean cOW() {
        return false;
    }

    /* renamed from: aZ */
    public final void mo70326aZ(Map<String, String> map) {
        Map map2;
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (map2 != null) {
            map2.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        if (this.AfN == null) {
            this.AfN = new HashMap();
        }
        if (this.AfN != null) {
            this.AfN.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        Object[] toArray = map2.keySet().toArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < toArray.length) {
                Object obj = toArray[i2];
                String str = (String) map2.get(obj);
                if (this.AfN.containsKey(obj)) {
                    this.AfN.remove(obj);
                }
                this.AfN.put((String) obj, str);
                i = i2 + 1;
            } else {
                mo70323M(this.AfN);
                return;
            }
        }
    }

    /* renamed from: M */
    public final void mo70323M(Map<String, String> map) {
        Map map2;
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (map2 != null) {
            map2.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        if (!C46512f.dlH()) {
            map2.put("jsapi_reqkey", C46512f.dlI());
        }
        this.AfN = map2;
        mo11719U(true, true);
        this.ehh.acF().fsO = C36391e.atB((String) map2.get("req_key"));
        if (map2 != null) {
            Object[] toArray = map2.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            for (Object obj : toArray) {
                String str = (String) map2.get(obj);
                if (!C5046bo.isNullOrNil(str)) {
                    if (i != 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    mo57301b(stringBuilder, str);
                    i = true;
                }
            }
            if (C4872b.dnO()) {
                C4990ab.m7418v("MicroMsg.NetScenePayBase", "RQ: Cmd : " + cOo() + ", req = " + stringBuilder.toString() + " " + toString() + " " + C5046bo.dpG().toString());
            } else {
                C4990ab.m7416i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + cOo() + ", req = " + stringBuilder.toString() + " " + toString());
            }
            String acv = acv(stringBuilder.toString());
            stringBuilder.append(i != 0 ? "&" : "");
            stringBuilder.append("WCPaySign");
            stringBuilder.append("=");
            stringBuilder.append(acv);
            mo11720a(this.ehh, new SKBuiltinBuffer_t().setBuffer(stringBuilder.toString().getBytes()));
        }
        C4990ab.m7417i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", Integer.valueOf(cOo()), Integer.valueOf(getType()), toString(), this.ehh.uri);
    }

    /* renamed from: b */
    public void mo57301b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(str);
    }

    public final C7472b dNN() {
        return this.ehh;
    }

    /* renamed from: f */
    public final void mo70332f(C7472b c7472b) {
        this.ehh = c7472b;
    }

    /* renamed from: ba */
    public final void mo70328ba(Map<String, String> map) {
        mo11719U(false, false);
        if (map != null) {
            C15319aw cPy = C22594k.cPy();
            if (cPy != null) {
                C4990ab.m7416i("MicroMsg.NetScenePayBase", "location found");
                map.put("province", cPy.duc);
                if (!map.containsKey("city")) {
                    map.put("city", cPy.dud);
                }
                map.put("location_timestamp", cPy.vCE);
                map.put("encrypt_key", cPy.vCI);
                map.put("encrypt_userinfo", cPy.vCH);
                if (C22594k.cPB()) {
                    map.put("encrypt_cellinfo", cPy.vCJ);
                }
            }
            Object[] toArray = map.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            boolean z = false;
            for (Object obj : toArray) {
                String str = (String) map.get(obj);
                if (!C5046bo.isNullOrNil(str)) {
                    if (z) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    stringBuilder.append(str);
                    z = true;
                }
            }
            if (C4872b.dnO()) {
                C4990ab.m7410d("MicroMsg.NetScenePayBase", "Cmd : " + cOo() + ", wxreq = " + stringBuilder.toString());
            }
            C4990ab.m7410d("MicroMsg.NetScenePayBase", "wxreq: " + stringBuilder.toString());
            mo11722b(this.ehh, new SKBuiltinBuffer_t().setBuffer(stringBuilder.toString().getBytes()));
        }
    }

    /* renamed from: a */
    public final void mo70324a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2) {
        mo70325a(payInfo, (Map) map, (Map) map2, false);
    }

    /* renamed from: a */
    public final void mo70325a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2, boolean z) {
        Map map22;
        if (map22 == null) {
            map22 = new HashMap();
        }
        if (payInfo == null) {
            C4990ab.m7412e("MicroMsg.NetScenePayBase", "Cmd : " + cOo() + ", payInfo is null");
            map22.put("devicename", Build.MODEL);
            mo70328ba(map22);
            return;
        }
        map.put("req_key", payInfo.czZ);
        map.put("partner_id", payInfo.partnerId);
        map.put("pay_sign", payInfo.cQF);
        if (payInfo.vwk >= 0) {
            map.put("auto_deduct_flag", payInfo.vwk);
        }
        if (payInfo.cIf > 0) {
            map.put("pay_scene", payInfo.cIf);
        }
        if (payInfo.cIg >= 0) {
            map.put("bindbankscene", payInfo.cIg);
        }
        if (!C5046bo.isNullOrNil(payInfo.vwl)) {
            map.put("deduct_bank_type", payInfo.vwl);
        }
        if (!C5046bo.isNullOrNil(payInfo.vwm)) {
            map.put("deduct_bind_serial", payInfo.vwm);
        }
        if (z) {
            map.put("use_touch", AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            map.put("use_touch", payInfo.tKd);
        }
        map.put("fp_identify_num", payInfo.tKe);
        if (!TextUtils.isEmpty(payInfo.cBU)) {
            map.put("encrypted_pay_info", URLEncoder.encode(payInfo.cBU));
        }
        if (!TextUtils.isEmpty(payInfo.cBV)) {
            map.put("encrypted_rsa_sign", URLEncoder.encode(payInfo.cBV));
        }
        map22.put("uuid", payInfo.eCq);
        map22.put("appid", payInfo.appId);
        map22.put("appsource", payInfo.tRb);
        map22.put("channel", payInfo.cIb);
        map22.put("devicename", Build.MODEL);
        map22.put("soter_req", payInfo.cHI);
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x029f A:{SYNTHETIC, Splitter:B:59:0x029f} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x01c9 A:{SYNTHETIC, Splitter:B:26:0x01c9} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x03dc  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x01d4  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x03e7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x01f6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: e */
    public final void mo9541e(int i, int i2, String str, C1929q c1929q) {
        JSONObject jSONObject;
        String optString;
        Exception e;
        C24144d c24144d;
        this.AfF = i;
        this.AfG = i2;
        if (C1947ae.gjr && 1686 == cOo()) {
            i = 3;
            i2 = -1;
        }
        C4990ab.m7417i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", Integer.valueOf(getType()), Integer.valueOf(c1929q.getType()), c1929q.getUri(), Integer.valueOf(cOo()), Integer.valueOf(i), Integer.valueOf(i2), str, toString());
        C16080v e2 = mo11727e((C7472b) c1929q);
        int i3 = e2.wxB;
        String str2 = e2.wxC;
        int i4 = e2.AfP;
        String str3 = e2.luU;
        int i5 = -10088;
        String string = C4996ah.getContext().getString(C25738R.string.fdx);
        String b = C1946aa.m4153b(e2.wxA);
        if (C5046bo.isNullOrNil(b)) {
            C4990ab.m7420w("MicroMsg.NetScenePayBase", "hy: respString is null");
            jSONObject = null;
        } else {
            try {
                jSONObject = new JSONObject(b);
                try {
                    this.AfL = jSONObject.optString("error_detail_url");
                    i5 = jSONObject.getInt("retcode");
                    optString = jSONObject.optString("retmsg");
                    try {
                        this.AfH = jSONObject.optString("pay_flag");
                        this.AfI = jSONObject.optString("return_url");
                        this.AfJ = jSONObject.optString("wappay_jumped_url");
                        this.tyd = jSONObject.optInt("is_gen_cert");
                        this.tye = jSONObject.optString("crt_token");
                        this.tyf = jSONObject.optInt("is_hint_crt");
                        JSONObject optJSONObject = jSONObject.optJSONObject("crt_wording");
                        if (optJSONObject != null) {
                            this.tyg = optJSONObject.toString();
                        } else {
                            this.tyg = "";
                        }
                        this.tyh = jSONObject.optInt("is_ignore_crt");
                        if (jSONObject.optInt("del_cert", 0) != 0) {
                            C46720ab.dNZ();
                            C4990ab.m7417i("MicroMsg.NetScenePayBase", "clean token %s", C46720ab.dNY());
                            C46720ab.dNZ().atp(string);
                        }
                        this.nYe = C24147k.m37121aS(jSONObject);
                        this.AfM = true;
                        string = optString;
                    } catch (Exception e3) {
                        e = e3;
                        string = optString;
                    }
                } catch (Exception e4) {
                    e = e4;
                }
            } catch (Exception e5) {
                e = e5;
                jSONObject = null;
                C4990ab.m7420w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                str3 = C4996ah.getContext().getString(C25738R.string.fgv);
                i5 = -10089;
                C4990ab.m7417i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", Integer.valueOf(getType()), Integer.valueOf(cOo()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), str3, Integer.valueOf(i5), string, jSONObject, toString());
                c24144d = new C24144d(i, i2, str);
                if (i == 0) {
                }
                C44430q.m80322a(i, i2, str, c24144d);
                if (i != 0) {
                }
                if (jSONObject != null) {
                }
                mo26460a(c24144d, jSONObject);
                if (this.AfK) {
                }
            }
        }
        C4990ab.m7417i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", Integer.valueOf(getType()), Integer.valueOf(cOo()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), str3, Integer.valueOf(i5), string, jSONObject, toString());
        c24144d = new C24144d(i, i2, str);
        if (i == 0 || i2 != 0) {
            C44430q.m80322a(i, i2, str, c24144d);
        } else if (i3 != 0) {
            C4990ab.m7420w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
            c24144d.mo39942f(1000, i3, str2, 1);
        } else if (i4 != 0) {
            C4990ab.m7420w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
            c24144d.mo39942f(1000, i4, str3, 2);
        } else if (i5 != 0) {
            C4990ab.m7420w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
            if (i5 == -10089 || i5 == -10088) {
                c24144d.mo39942f(1000, 2, string, 2);
            } else {
                c24144d.mo39942f(1000, i5, string, 2);
            }
        } else {
            if (!C5046bo.isNullOrNil(str3)) {
                C4990ab.m7416i("MicroMsg.NetScenePayBase", "finModel.errMsg = biz_errMsg");
                c24144d.aIm = str3;
            }
            C4990ab.m7416i("MicroMsg.NetScenePayBase", "hy: all's OK");
        }
        if (i != 0) {
            try {
                C4990ab.m7412e("MicroMsg.NetScenePayBase", "errType is OK, reportCellInfo do nothing");
            } catch (Exception e42) {
                C4990ab.m7413e("MicroMsg.NetScenePayBase", "reportCellInfo error. %s", e42.getMessage());
            }
        } else if (C22594k.cPB()) {
            C15319aw cPy = C22594k.cPy();
            if (!(cPy == null || C5046bo.isNullOrNil(cPy.vCI) || C5046bo.isNullOrNil(cPy.vCJ))) {
                int cOo = cOo();
                String str4 = cPy.vCI;
                String str5 = cPy.vCH;
                String str6 = cPy.vCJ;
                if (!C5046bo.isNullOrNil(str6)) {
                    int length = str6.length();
                    String str7 = "";
                    str3 = "";
                    String str8 = "";
                    string = "";
                    optString = "";
                    if (length > 5000) {
                        C4990ab.m7412e("MicroMsg.NetScenePayBase", "reportCellInfo. cell info is too long to report");
                    } else if (length > WearableStatusCodes.TARGET_NODE_NOT_CONNECTED) {
                        str7 = str6.substring(0, 1000);
                        str3 = str6.substring(1000, 2000);
                        str8 = str6.substring(2000, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                        string = str6.substring(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, WearableStatusCodes.TARGET_NODE_NOT_CONNECTED);
                        optString = str6.substring(WearableStatusCodes.TARGET_NODE_NOT_CONNECTED, length);
                    } else if (length > AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS) {
                        str7 = str6.substring(0, 1000);
                        str3 = str6.substring(1000, 2000);
                        str8 = str6.substring(2000, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
                        string = str6.substring(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, length);
                    } else if (length > 2000) {
                        str7 = str6.substring(0, 1000);
                        str3 = str6.substring(1000, 2000);
                        str8 = str6.substring(2000, length);
                    } else if (length > 1000) {
                        str7 = str6.substring(0, 1000);
                        str3 = str6.substring(1000, length);
                    } else if (length > 0) {
                        str7 = str6.substring(0, length);
                    }
                    C4990ab.m7412e("MicroMsg.NetScenePayBase", "reportCellInfo do report");
                    C26294i c26294i = new C26294i();
                    c26294i.cVl = cOo;
                    c26294i.cVm = i;
                    c26294i.cVn = i2;
                    c26294i.mo44060ew(str4).mo44061ex(str5).mo44062ey(String.valueOf(length)).mo44063ez(str7).mo44056eA(str3).mo44057eB(str8).mo44058eC(string).mo44059eD(optString).ajK();
                }
            }
        } else {
            C4990ab.m7412e("MicroMsg.NetScenePayBase", "shouldReportCellInfo is false, reportCellInfo do nothing");
        }
        if (jSONObject != null) {
            C4990ab.m7416i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
        } else if ((c24144d.errType == 0 && c24144d.errCode == 0) || cfq()) {
            mo9383a(c24144d.errCode, c24144d.aIm, jSONObject);
        } else {
            C4990ab.m7416i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        }
        mo26460a(c24144d, jSONObject);
        if (this.AfK) {
            C4990ab.m7410d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
        } else {
            this.ehi.onSceneEnd(c24144d.errType, c24144d.errCode, c24144d.aIm, this);
        }
    }

    public final boolean bLD() {
        if (this.nYe == null) {
            return false;
        }
        return true;
    }

    public final boolean dNO() {
        if (this.AfH == null) {
            return false;
        }
        return "1".equals(this.AfH.trim());
    }

    public String getToken() {
        return null;
    }

    public boolean cfq() {
        return false;
    }

    public boolean bXl() {
        reset();
        return false;
    }

    /* renamed from: a */
    public static void m80322a(int i, int i2, String str, C24144d c24144d) {
        if (i != 0 || i2 != 0) {
            C4990ab.m7420w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
            Map z = C5049br.m7595z(str, "e");
            if (z != null) {
                C4990ab.m7410d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                c24144d.aIm = (String) z.get(".e.Content");
            } else if (i2 == -1 || i2 == -500) {
                C4990ab.m7420w("MicroMsg.NetScenePayBase", "hy: network error");
                c24144d.aIm = C4996ah.getContext().getString(C25738R.string.fk3);
            } else {
                C4990ab.m7420w("MicroMsg.NetScenePayBase", "hy: unknown system error");
                c24144d.aIm = C4996ah.getContext().getString(C25738R.string.fdx);
            }
        }
    }

    public final int bLE() {
        return cOo();
    }

    public final String dNP() {
        return this.AfL;
    }

    public boolean bXm() {
        return true;
    }
}
