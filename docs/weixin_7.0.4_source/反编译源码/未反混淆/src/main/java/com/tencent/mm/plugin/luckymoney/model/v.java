package com.tencent.mm.plugin.luckymoney.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.b;
import com.tencent.mm.protocal.protobuf.atb;
import com.tencent.mm.protocal.protobuf.atc;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class v {
    public static k W(JSONObject jSONObject) {
        AppMethodBeat.i(42351);
        k kVar = new k();
        if (jSONObject != null) {
            kVar.cRT = jSONObject.optInt("hbType");
            kVar.cRU = jSONObject.optInt("hbStatus");
            kVar.nWO = jSONObject.optString("statusMess");
            kVar.nWP = jSONObject.optString("gameMess");
            kVar.nSd = jSONObject.optString("wishing");
            kVar.nWQ = jSONObject.optString("sendNick");
            kVar.nWR = jSONObject.optString("sendHeadImg");
            kVar.nSX = jSONObject.optString("sendId");
            kVar.nWS = jSONObject.optString("adMessage");
            kVar.nWT = jSONObject.optString("adUrl");
            kVar.cSh = jSONObject.optLong("amount");
            kVar.nWU = jSONObject.optLong("recNum");
            kVar.nWV = jSONObject.optLong("recAmount");
            kVar.kCd = jSONObject.optInt("totalNum");
            kVar.nWW = jSONObject.optLong("totalAmount");
            kVar.nWX = jSONObject.optString("receiveId");
            kVar.nWY = jSONObject.optInt("hasWriteAnswer");
            kVar.nWZ = jSONObject.optInt("isSender");
            kVar.nXa = jSONObject.optInt("isContinue");
            kVar.nXb = jSONObject.optString("headTitle");
            kVar.cRV = jSONObject.optInt("receiveStatus");
            kVar.nXc = jSONObject.optInt("canShare");
            kVar.nUh = jSONObject.optInt("jumpChange");
            kVar.nUj = jSONObject.optString("changeWording");
            kVar.nUi = jSONObject.optString("changeUrl");
            kVar.nXi = jSONObject.optInt("hbKind");
            kVar.nUk = jSONObject.optString("externMess");
            kVar.nXl = jSONObject.optString("sendUserName");
            if (bo.isNullOrNil(kVar.nWQ) && !bo.isNullOrNil(kVar.nXl)) {
                kVar.nWQ = ((b) g.K(b.class)).mJ(kVar.nXl);
            }
            kVar.nXd = new e();
            JSONObject optJSONObject = jSONObject.optJSONObject("atomicFunc");
            if (optJSONObject != null) {
                kVar.nXd.erD = optJSONObject.optInt("enable");
                kVar.nXd.nWz = optJSONObject.optString("fissionContent");
                kVar.nXd.nWy = optJSONObject.optString("fissionUrl");
            }
            kVar.nXe = new LinkedList();
            JSONArray optJSONArray = jSONObject.optJSONArray("operationHeader");
            if (optJSONArray != null) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    kVar.nXe.add(Y(optJSONArray.getJSONObject(i)));
                }
            }
            kVar.nXg = jSONObject.optString("watermark");
            kVar.nXh = jSONObject.optString("context");
            kVar.nXk = jSONObject.optString("contextMd5");
            kVar.resourceId = jSONObject.optInt("resourceId");
            kVar.nXf = Y(jSONObject.optJSONObject("operationTail"));
            kVar.nXj = X(jSONObject);
            kVar.nXm = jSONObject.optInt("jumpChangeType");
            kVar.nXn = jSONObject.optString("changeIconUrl");
            kVar.nXo = jSONObject.optString("showSourceOpen");
        }
        AppMethodBeat.o(42351);
        return kVar;
    }

    private static LinkedList<w> X(JSONObject jSONObject) {
        AppMethodBeat.i(42352);
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
                w wVar = new w();
                if (jSONObject2 != null) {
                    wVar.nXZ = jSONObject2.optString("receiveName");
                    wVar.nYa = jSONObject2.optString("receiveHeadImg");
                    wVar.nXM = jSONObject2.optLong("receiveAmount");
                    wVar.nXN = jSONObject2.optString("receiveTime");
                    wVar.nYb = jSONObject2.optString("answer");
                    wVar.nWX = jSONObject2.optString("receiveId");
                    wVar.nYc = jSONObject2.optString("gameTips");
                    wVar.userName = jSONObject2.optString("userName");
                    if (bo.isNullOrNil(wVar.nXZ) && !bo.isNullOrNil(wVar.userName)) {
                        wVar.nXZ = ((b) g.K(b.class)).mJ(wVar.userName);
                    }
                }
                linkedList.add(wVar);
                i = i2 + 1;
            }
        }
        AppMethodBeat.o(42352);
        return linkedList;
    }

    public static as Y(JSONObject jSONObject) {
        AppMethodBeat.i(42353);
        as asVar = new as();
        if (jSONObject != null) {
            asVar.erD = jSONObject.optInt("enable", 0);
            asVar.content = jSONObject.optString(FirebaseAnalytics.b.CONTENT);
            asVar.iconUrl = jSONObject.optString("iconUrl");
            asVar.type = jSONObject.optString("type");
            asVar.name = jSONObject.optString("name");
            asVar.nZn = jSONObject.optInt("ossKey");
            asVar.nZo = jSONObject.optInt("focus");
        }
        AppMethodBeat.o(42353);
        return asVar;
    }

    public static atb Z(JSONObject jSONObject) {
        AppMethodBeat.i(42354);
        if (jSONObject == null) {
            AppMethodBeat.o(42354);
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
        AppMethodBeat.o(42354);
        return atb;
    }
}
