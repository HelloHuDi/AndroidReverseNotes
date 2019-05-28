package com.tencent.p177mm.plugin.luckymoney.model;

import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.protocal.protobuf.atb;
import com.tencent.p177mm.protocal.protobuf.atc;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.luckymoney.model.v */
public final class C43263v {
    /* renamed from: W */
    public static C12428k m77008W(JSONObject jSONObject) {
        AppMethodBeat.m2504i(42351);
        C12428k c12428k = new C12428k();
        if (jSONObject != null) {
            c12428k.cRT = jSONObject.optInt("hbType");
            c12428k.cRU = jSONObject.optInt("hbStatus");
            c12428k.nWO = jSONObject.optString("statusMess");
            c12428k.nWP = jSONObject.optString("gameMess");
            c12428k.nSd = jSONObject.optString("wishing");
            c12428k.nWQ = jSONObject.optString("sendNick");
            c12428k.nWR = jSONObject.optString("sendHeadImg");
            c12428k.nSX = jSONObject.optString("sendId");
            c12428k.nWS = jSONObject.optString("adMessage");
            c12428k.nWT = jSONObject.optString("adUrl");
            c12428k.cSh = jSONObject.optLong("amount");
            c12428k.nWU = jSONObject.optLong("recNum");
            c12428k.nWV = jSONObject.optLong("recAmount");
            c12428k.kCd = jSONObject.optInt("totalNum");
            c12428k.nWW = jSONObject.optLong("totalAmount");
            c12428k.nWX = jSONObject.optString("receiveId");
            c12428k.nWY = jSONObject.optInt("hasWriteAnswer");
            c12428k.nWZ = jSONObject.optInt("isSender");
            c12428k.nXa = jSONObject.optInt("isContinue");
            c12428k.nXb = jSONObject.optString("headTitle");
            c12428k.cRV = jSONObject.optInt("receiveStatus");
            c12428k.nXc = jSONObject.optInt("canShare");
            c12428k.nUh = jSONObject.optInt("jumpChange");
            c12428k.nUj = jSONObject.optString("changeWording");
            c12428k.nUi = jSONObject.optString("changeUrl");
            c12428k.nXi = jSONObject.optInt("hbKind");
            c12428k.nUk = jSONObject.optString("externMess");
            c12428k.nXl = jSONObject.optString("sendUserName");
            if (C5046bo.isNullOrNil(c12428k.nWQ) && !C5046bo.isNullOrNil(c12428k.nXl)) {
                c12428k.nWQ = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(c12428k.nXl);
            }
            c12428k.nXd = new C46060e();
            JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
            if (optJSONObject != null) {
                c12428k.nXd.erD = optJSONObject.optInt("enable");
                c12428k.nXd.nWz = optJSONObject.optString("fissionContent");
                c12428k.nXd.nWy = optJSONObject.optString("fissionUrl");
            }
            c12428k.nXe = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("operationHeader");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    c12428k.nXe.add(C43263v.m77010Y(optJSONArray.getJSONObject(i)));
                }
            }
            c12428k.nXg = jSONObject.optString("watermark");
            c12428k.nXh = jSONObject.optString("context");
            c12428k.nXk = jSONObject.optString("contextMd5");
            c12428k.resourceId = jSONObject.optInt("resourceId");
            c12428k.nXf = C43263v.m77010Y(jSONObject.optJSONObject("operationTail"));
            c12428k.nXj = C43263v.m77009X(jSONObject);
            c12428k.nXm = jSONObject.optInt("jumpChangeType");
            c12428k.nXn = jSONObject.optString("changeIconUrl");
            c12428k.nXo = jSONObject.optString("showSourceOpen");
        }
        AppMethodBeat.m2505o(42351);
        return c12428k;
    }

    /* renamed from: X */
    private static LinkedList<C39323w> m77009X(JSONObject jSONObject) {
        AppMethodBeat.m2504i(42352);
        JSONArray optJSONArray = jSONObject.optJSONArray("record");
        LinkedList linkedList = new LinkedList();
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                C39323w c39323w = new C39323w();
                if (jSONObject2 != null) {
                    c39323w.nXZ = jSONObject2.optString("receiveName");
                    c39323w.nYa = jSONObject2.optString("receiveHeadImg");
                    c39323w.nXM = jSONObject2.optLong("receiveAmount");
                    c39323w.nXN = jSONObject2.optString("receiveTime");
                    c39323w.nYb = jSONObject2.optString("answer");
                    c39323w.nWX = jSONObject2.optString("receiveId");
                    c39323w.nYc = jSONObject2.optString("gameTips");
                    c39323w.userName = jSONObject2.optString("userName");
                    if (C5046bo.isNullOrNil(c39323w.nXZ) && !C5046bo.isNullOrNil(c39323w.userName)) {
                        c39323w.nXZ = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(c39323w.userName);
                    }
                }
                linkedList.add(c39323w);
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(42352);
        return linkedList;
    }

    /* renamed from: Y */
    public static C43255as m77010Y(JSONObject jSONObject) {
        AppMethodBeat.m2504i(42353);
        C43255as c43255as = new C43255as();
        if (jSONObject != null) {
            c43255as.erD = jSONObject.optInt("enable", 0);
            c43255as.content = jSONObject.optString(C8741b.CONTENT);
            c43255as.iconUrl = jSONObject.optString("iconUrl");
            c43255as.type = jSONObject.optString("type");
            c43255as.name = jSONObject.optString("name");
            c43255as.nZn = jSONObject.optInt("ossKey");
            c43255as.nZo = jSONObject.optInt("focus");
        }
        AppMethodBeat.m2505o(42353);
        return c43255as;
    }

    /* renamed from: Z */
    public static atb m77011Z(JSONObject jSONObject) {
        AppMethodBeat.m2504i(42354);
        if (jSONObject == null) {
            AppMethodBeat.m2505o(42354);
            return null;
        }
        atb atb = new atb();
        atb.cuu = jSONObject.optInt("subType", -1);
        atb.wwP = jSONObject.optString("corpName");
        atb.materialId = jSONObject.optString("materialId");
        atb.wwR = jSONObject.optString("expire_desc");
        atb.wwS = jSONObject.optInt("is_expired");
        JSONObject optJSONObject = jSONObject.optJSONObject("sourceObject");
        if (optJSONObject != null) {
            atc atc = new atc();
            atc.wwV = optJSONObject.optString("bubbleImage");
            atc.wwY = optJSONObject.optString("bubbleImageMd5");
            atc.wwU = optJSONObject.optString("corpLogo");
            atc.wxb = optJSONObject.optString("corpLogoMd5");
            atc.wwW = optJSONObject.optString("coverImage");
            atc.wwZ = optJSONObject.optString("coverImageMd5");
            atc.wwX = optJSONObject.optString("detailImage");
            atc.wxa = optJSONObject.optString("detailImageMd5");
            atb.wwQ = atc;
        }
        AppMethodBeat.m2505o(42354);
        return atb;
    }
}
