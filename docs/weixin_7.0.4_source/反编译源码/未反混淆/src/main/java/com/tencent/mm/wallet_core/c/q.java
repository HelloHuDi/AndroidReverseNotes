package com.tencent.mm.wallet_core.c;

import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.mm.R;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.b.a.i;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public abstract class q extends u {
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
    protected b ehh;
    protected f ehi;
    public k nYe;
    public int tyd = 0;
    public String tye = "";
    public int tyf = 0;
    public String tyg = "";
    public int tyh = 0;

    public abstract void U(boolean z, boolean z2);

    public abstract void a(int i, String str, JSONObject jSONObject);

    public abstract void a(b bVar, SKBuiltinBuffer_t sKBuiltinBuffer_t);

    public abstract String acv(String str);

    public abstract void b(b bVar, SKBuiltinBuffer_t sKBuiltinBuffer_t);

    public abstract int cOo();

    public abstract v e(b bVar);

    public void a(d dVar, JSONObject jSONObject) {
    }

    public boolean cOW() {
        return false;
    }

    public final void aZ(Map<String, String> map) {
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
                M(this.AfN);
                return;
            }
        }
    }

    public final void M(Map<String, String> map) {
        Map map2;
        if (map2 == null) {
            map2 = new HashMap();
        }
        if (map2 != null) {
            map2.remove(OpenSDKTool4Assistant.EXTRA_UIN);
        }
        if (!com.tencent.mm.pluginsdk.wallet.f.dlH()) {
            map2.put("jsapi_reqkey", com.tencent.mm.pluginsdk.wallet.f.dlI());
        }
        this.AfN = map2;
        U(true, true);
        this.ehh.acF().fsO = e.atB((String) map2.get("req_key"));
        if (map2 != null) {
            Object[] toArray = map2.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            for (Object obj : toArray) {
                String str = (String) map2.get(obj);
                if (!bo.isNullOrNil(str)) {
                    if (i != 0) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    b(stringBuilder, str);
                    i = true;
                }
            }
            if (com.tencent.mm.sdk.a.b.dnO()) {
                ab.v("MicroMsg.NetScenePayBase", "RQ: Cmd : " + cOo() + ", req = " + stringBuilder.toString() + " " + toString() + " " + bo.dpG().toString());
            } else {
                ab.i("MicroMsg.NetScenePayBase", "RQ: Cmd : " + cOo() + ", req = " + stringBuilder.toString() + " " + toString());
            }
            String acv = acv(stringBuilder.toString());
            stringBuilder.append(i != 0 ? "&" : "");
            stringBuilder.append("WCPaySign");
            stringBuilder.append("=");
            stringBuilder.append(acv);
            a(this.ehh, new SKBuiltinBuffer_t().setBuffer(stringBuilder.toString().getBytes()));
        }
        ab.i("MicroMsg.NetScenePayBase", "setRequestData getPayCgicmd: %s type: %s this: %s cgi %s ", Integer.valueOf(cOo()), Integer.valueOf(getType()), toString(), this.ehh.uri);
    }

    public void b(StringBuilder stringBuilder, String str) {
        stringBuilder.append(str);
    }

    public final b dNN() {
        return this.ehh;
    }

    public final void f(b bVar) {
        this.ehh = bVar;
    }

    public final void ba(Map<String, String> map) {
        U(false, false);
        if (map != null) {
            aw cPy = k.cPy();
            if (cPy != null) {
                ab.i("MicroMsg.NetScenePayBase", "location found");
                map.put("province", cPy.duc);
                if (!map.containsKey("city")) {
                    map.put("city", cPy.dud);
                }
                map.put("location_timestamp", cPy.vCE);
                map.put("encrypt_key", cPy.vCI);
                map.put("encrypt_userinfo", cPy.vCH);
                if (k.cPB()) {
                    map.put("encrypt_cellinfo", cPy.vCJ);
                }
            }
            Object[] toArray = map.keySet().toArray();
            Arrays.sort(toArray);
            StringBuilder stringBuilder = new StringBuilder();
            boolean z = false;
            for (Object obj : toArray) {
                String str = (String) map.get(obj);
                if (!bo.isNullOrNil(str)) {
                    if (z) {
                        stringBuilder.append("&");
                    }
                    stringBuilder.append(obj);
                    stringBuilder.append("=");
                    stringBuilder.append(str);
                    z = true;
                }
            }
            if (com.tencent.mm.sdk.a.b.dnO()) {
                ab.d("MicroMsg.NetScenePayBase", "Cmd : " + cOo() + ", wxreq = " + stringBuilder.toString());
            }
            ab.d("MicroMsg.NetScenePayBase", "wxreq: " + stringBuilder.toString());
            b(this.ehh, new SKBuiltinBuffer_t().setBuffer(stringBuilder.toString().getBytes()));
        }
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2) {
        a(payInfo, (Map) map, (Map) map2, false);
    }

    public final void a(PayInfo payInfo, Map<String, String> map, Map<String, String> map2, boolean z) {
        Map map22;
        if (map22 == null) {
            map22 = new HashMap();
        }
        if (payInfo == null) {
            ab.e("MicroMsg.NetScenePayBase", "Cmd : " + cOo() + ", payInfo is null");
            map22.put("devicename", Build.MODEL);
            ba(map22);
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
        if (!bo.isNullOrNil(payInfo.vwl)) {
            map.put("deduct_bank_type", payInfo.vwl);
        }
        if (!bo.isNullOrNil(payInfo.vwm)) {
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
    public final void e(int i, int i2, String str, com.tencent.mm.network.q qVar) {
        JSONObject jSONObject;
        String optString;
        Exception e;
        d dVar;
        this.AfF = i;
        this.AfG = i2;
        if (ae.gjr && 1686 == cOo()) {
            i = 3;
            i2 = -1;
        }
        ab.i("MicroMsg.NetScenePayBase", "cgi: %d, rrType %d, rrCgi %s, PayCgicmd %s, errType %d, errCode %d, errMsg %s, this: %s ", Integer.valueOf(getType()), Integer.valueOf(qVar.getType()), qVar.getUri(), Integer.valueOf(cOo()), Integer.valueOf(i), Integer.valueOf(i2), str, toString());
        v e2 = e((b) qVar);
        int i3 = e2.wxB;
        String str2 = e2.wxC;
        int i4 = e2.AfP;
        String str3 = e2.luU;
        int i5 = -10088;
        String string = ah.getContext().getString(R.string.fdx);
        String b = aa.b(e2.wxA);
        if (bo.isNullOrNil(b)) {
            ab.w("MicroMsg.NetScenePayBase", "hy: respString is null");
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
                            ab.dNZ();
                            ab.i("MicroMsg.NetScenePayBase", "clean token %s", ab.dNY());
                            ab.dNZ().atp(string);
                        }
                        this.nYe = k.aS(jSONObject);
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
                ab.w("MicroMsg.NetScenePayBase", "hy: json resolve error: error when resolving error code : " + e.toString());
                str3 = ah.getContext().getString(R.string.fgv);
                i5 = -10089;
                ab.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", Integer.valueOf(getType()), Integer.valueOf(cOo()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), str3, Integer.valueOf(i5), string, jSONObject, toString());
                dVar = new d(i, i2, str);
                if (i == 0) {
                }
                a(i, i2, str, dVar);
                if (i != 0) {
                }
                if (jSONObject != null) {
                }
                a(dVar, jSONObject);
                if (this.AfK) {
                }
            }
        }
        ab.i("MicroMsg.NetScenePayBase", "tenpayResp: cgi: %d, cmd: %d, errType: %d, errCode: %d, errMsg: %s, platRet: %d, platMsg: %s, biz_ErrType: %d, biz_ErrMsg: %s, retcode: %d, retMsg: %s, json: %s this %s", Integer.valueOf(getType()), Integer.valueOf(cOo()), Integer.valueOf(i), Integer.valueOf(i2), str, Integer.valueOf(i3), str2, Integer.valueOf(i4), str3, Integer.valueOf(i5), string, jSONObject, toString());
        dVar = new d(i, i2, str);
        if (i == 0 || i2 != 0) {
            a(i, i2, str, dVar);
        } else if (i3 != 0) {
            ab.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: plat ret is error");
            dVar.f(1000, i3, str2, 1);
        } else if (i4 != 0) {
            ab.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: errType is error");
            dVar.f(1000, i4, str3, 2);
        } else if (i5 != 0) {
            ab.w("MicroMsg.NetScenePayBase", "hy: resolve busi error: retCode is error");
            if (i5 == -10089 || i5 == -10088) {
                dVar.f(1000, 2, string, 2);
            } else {
                dVar.f(1000, i5, string, 2);
            }
        } else {
            if (!bo.isNullOrNil(str3)) {
                ab.i("MicroMsg.NetScenePayBase", "finModel.errMsg = biz_errMsg");
                dVar.aIm = str3;
            }
            ab.i("MicroMsg.NetScenePayBase", "hy: all's OK");
        }
        if (i != 0) {
            try {
                ab.e("MicroMsg.NetScenePayBase", "errType is OK, reportCellInfo do nothing");
            } catch (Exception e42) {
                ab.e("MicroMsg.NetScenePayBase", "reportCellInfo error. %s", e42.getMessage());
            }
        } else if (k.cPB()) {
            aw cPy = k.cPy();
            if (!(cPy == null || bo.isNullOrNil(cPy.vCI) || bo.isNullOrNil(cPy.vCJ))) {
                int cOo = cOo();
                String str4 = cPy.vCI;
                String str5 = cPy.vCH;
                String str6 = cPy.vCJ;
                if (!bo.isNullOrNil(str6)) {
                    int length = str6.length();
                    String str7 = "";
                    str3 = "";
                    String str8 = "";
                    string = "";
                    optString = "";
                    if (length > 5000) {
                        ab.e("MicroMsg.NetScenePayBase", "reportCellInfo. cell info is too long to report");
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
                    ab.e("MicroMsg.NetScenePayBase", "reportCellInfo do report");
                    i iVar = new i();
                    iVar.cVl = cOo;
                    iVar.cVm = i;
                    iVar.cVn = i2;
                    iVar.ew(str4).ex(str5).ey(String.valueOf(length)).ez(str7).eA(str3).eB(str8).eC(string).eD(optString).ajK();
                }
            }
        } else {
            ab.e("MicroMsg.NetScenePayBase", "shouldReportCellInfo is false, reportCellInfo do nothing");
        }
        if (jSONObject != null) {
            ab.i("MicroMsg.NetScenePayBase", "hy: no json object when doing business");
        } else if ((dVar.errType == 0 && dVar.errCode == 0) || cfq()) {
            a(dVar.errCode, dVar.aIm, jSONObject);
        } else {
            ab.i("MicroMsg.NetScenePayBase", "hy: ret code is not ok and should not resolve when error");
        }
        a(dVar, jSONObject);
        if (this.AfK) {
            ab.d("MicroMsg.NetScenePayBase", "hy: user consumed the call back");
        } else {
            this.ehi.onSceneEnd(dVar.errType, dVar.errCode, dVar.aIm, this);
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

    public static void a(int i, int i2, String str, d dVar) {
        if (i != 0 || i2 != 0) {
            ab.w("MicroMsg.NetScenePayBase", "hy: resolve system error.");
            Map z = br.z(str, "e");
            if (z != null) {
                ab.d("MicroMsg.NetScenePayBase", "hy: CDN error!");
                dVar.aIm = (String) z.get(".e.Content");
            } else if (i2 == -1 || i2 == -500) {
                ab.w("MicroMsg.NetScenePayBase", "hy: network error");
                dVar.aIm = ah.getContext().getString(R.string.fk3);
            } else {
                ab.w("MicroMsg.NetScenePayBase", "hy: unknown system error");
                dVar.aIm = ah.getContext().getString(R.string.fdx);
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
