package com.tencent.mm.plugin.topstory.a;

import android.os.Build;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.appbrand.jsapi.storage.m;
import com.tencent.mm.plugin.misc.a.a;
import com.tencent.mm.plugin.websearch.api.aa;
import com.tencent.mm.protocal.protobuf.abz;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.chv;
import com.tencent.mm.protocal.protobuf.chw;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.view.d;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class g {
    public static final chy dM(List<chy> list) {
        AppMethodBeat.i(96351);
        for (chy chy : list) {
            if (chy != null && !bo.isNullOrNil(chy.url)) {
                AppMethodBeat.o(96351);
                return chy;
            }
        }
        AppMethodBeat.o(96351);
        return null;
    }

    public static final chv a(cvi cvi, int i, String str) {
        int i2 = 0;
        AppMethodBeat.i(96352);
        chv chv = new chv();
        chv.xgj = UUID.randomUUID().toString();
        chv.xgH = new chw();
        chv.xgH.title = cvi.lvA;
        chv.xgH.ubA = "video-" + cvi.uaa;
        chv.xgH.xgS = cvi.uaa;
        chv.xgH.xgQ = cvi.thumbUrl;
        if (bo.isNullOrNil(chv.xgH.xgQ)) {
            chv.xgH.xgQ = "http://shp.qpic.cn/qqvideo_ori/0/" + cvi.uaa + String.format("_%s_%s/0", new Object[]{Integer.valueOf(m.CTRL_INDEX), Integer.valueOf(d.MIC_PTU_TRANS_XINXIAN)});
        }
        chv.xgH.uai = cvi.uai;
        chv.xgH.source = cvi.source;
        chv.xgH.phw = cvi.phw;
        chv.xgH.xgV = cvi.uab;
        chv.xgH.xgX = cvi.uab;
        chv.xgH.uag = cvi.uag;
        chv.xgH.fgJ = m.CTRL_INDEX;
        chv.xgH.fgI = d.MIC_PTU_TRANS_XINXIAN;
        chv.xgH.timestamp = System.currentTimeMillis();
        if (!bo.isNullOrNil(cvi.ual)) {
            try {
                JSONArray jSONArray = new JSONArray(cvi.ual);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    bzs bzs = new bzs();
                    bzs.id = jSONObject.optString("id");
                    bzs.cEh = jSONObject.optString("wording");
                    bzs.wYN = jSONObject.optLong("category");
                    bzs.actionType = jSONObject.optInt("actionType");
                    bzs.url = jSONObject.optString("url");
                    bzs.title = jSONObject.optString("title");
                    bzs.jcF = jSONObject.optString("subTitle");
                    bzs.cIY = jSONObject.optString("icon");
                    chv.xgH.wiH.add(bzs);
                }
            } catch (Exception e) {
            }
        }
        chv.xgC = cvi.uaa;
        chv.xgD = cvi.uab;
        chv.xgE = cvi.uac;
        chv.xgF = cvi.uad;
        chv.xgG = cvi.uam;
        if (chv.xgG <= 0) {
            chv.xgG = 100201;
        }
        chv.xgJ = false;
        if (!bo.isNullOrNil(cvi.uak)) {
            try {
                JSONArray jSONArray2 = new JSONArray(cvi.uak);
                while (i2 < jSONArray2.length()) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    tn tnVar = new tn();
                    tnVar.key = jSONObject2.optString("key", "");
                    tnVar.waD = (long) jSONObject2.optInt("uintValue", 0);
                    tnVar.waE = jSONObject2.optString("textValue", "");
                    chv.tZG.add(tnVar);
                    i2++;
                }
            } catch (Exception e2) {
            }
        }
        chv.hlm = "";
        chv.scene = i;
        chv.ctj = str;
        if (!bo.isNullOrNil(cvi.uan)) {
            chv.xgI = new bzs();
            chv.xgI.title = cvi.uan;
        }
        AppMethodBeat.o(96352);
        return chv;
    }

    public static final chv am(JSONObject jSONObject) {
        int i;
        AppMethodBeat.i(96353);
        chv chv = new chv();
        chv.ctj = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
        chv.scene = jSONObject.optInt("scene", 21);
        chv.xgj = UUID.randomUUID().toString();
        chv.xgE = jSONObject.optString("searchId", "");
        if (at.isConnected(ah.getContext()) && !at.isWifi(ah.getContext())) {
            chv.xgJ = true;
        }
        String optString = jSONObject.optString("videoId", "");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(jSONObject.optString("videoUrls", ""));
            if (jSONArray.length() > 0) {
                for (i = 0; i < jSONArray.length(); i++) {
                    chy chy = new chy();
                    chy.url = jSONArray.getString(i);
                    arrayList.add(chy);
                }
            }
        } catch (JSONException e) {
        }
        if (!bo.isNullOrNil(optString)) {
            JSONObject jSONObject2;
            JSONArray optJSONArray;
            chv.xgH = new chw();
            chv.xgH.title = jSONObject.optString("title", "");
            chv.xgH.xgQ = jSONObject.optString("thumbUrl", "");
            chv.xgH.xgR = jSONObject.optInt("mediaDuration", 0);
            chv.xgH.xgS = optString;
            chv.xgH.fgJ = m.CTRL_INDEX;
            chv.xgH.fgI = d.MIC_PTU_TRANS_XINXIAN;
            chv.xgH.uai = jSONObject.optString("strPlayCount", "");
            chv.xgH.lvz = jSONObject.optString("shareUrl", "");
            chv.xgH.lvA = jSONObject.optString("shareTitle", "");
            chv.xgH.uaj = jSONObject.optString("titleUrl", "");
            chv.xgH.qVw = jSONObject.optString("shareDesc", "");
            chv.xgH.uaf = jSONObject.optString("shareImgUrl", "");
            chv.xgH.uag = jSONObject.optString("shareString", "");
            chv.xgH.uah = jSONObject.optString("shareStringUrl", "");
            chv.xgH.source = jSONObject.optString("source", "");
            chv.xgH.phw = jSONObject.optString("sourceUrl", "");
            chv.xgH.xgT = (long) jSONObject.optInt("relevant_category", -1);
            chv.xgH.xgU = jSONObject.optString("shareOpenId", "");
            chv.xgH.ubA = jSONObject.optString("docID", "");
            chv.xgH.xha = (long) jSONObject.optInt("videoSize", 0);
            chv.xgH.timestamp = bo.yz();
            chv.xgH.xgW = jSONObject.optInt("itemType", 0);
            try {
                jSONObject2 = new JSONObject(jSONObject.optString("block", ""));
                chv.xgH.xgZ = jSONObject2.optLong("resultType");
                chv.xgH.ctk = jSONObject2.optLong("type");
            } catch (JSONException e2) {
            }
            chv.xgH.xgV = jSONObject.optString("expand", "");
            chv.xgH.xhb.addAll(arrayList);
            chy dM = dM(arrayList);
            if (dM != null) {
                chv.xgH.videoUrl = dM.url;
                chv.xgH.xhg = dM.xhg;
            }
            if (bo.isNullOrNil(chv.xgH.xgQ)) {
                chv.xgH.xgQ = "http://shp.qpic.cn/qqvideo_ori/0/" + chv.xgH.xgS + String.format("_%s_%s/0", new Object[]{Integer.valueOf(m.CTRL_INDEX), Integer.valueOf(d.MIC_PTU_TRANS_XINXIAN)});
            }
            String optString2 = jSONObject.optString("tagList", "");
            if (!bo.isNullOrNil(optString2)) {
                try {
                    chv.xgH.wiH.addAll(y(new JSONArray(optString2)));
                } catch (Exception e3) {
                }
            }
            if (!jSONObject.optBoolean("not_show_feedback", false)) {
                jSONObject2 = jSONObject.optJSONObject("feedbackObj");
                if (jSONObject2 != null) {
                    optJSONArray = jSONObject2.optJSONArray("feedbackData");
                    if (optJSONArray != null) {
                        for (i = 0; i < optJSONArray.length(); i++) {
                            abz abz = new abz();
                            abz.id = optJSONArray.optJSONObject(i).optString("id", "");
                            abz.cEh = optJSONArray.optJSONObject(i).optString("wording", "");
                            chv.xgH.xhc.add(abz);
                        }
                    }
                }
            }
            optString2 = jSONObject.optString("show_tag_list", "");
            if (!bo.isNullOrNil(optString2)) {
                try {
                    chv.xgH.wiH.addAll(y(new JSONArray(optString2)));
                } catch (JSONException e4) {
                }
            }
            chv.xgG = chv.xgH.xgT;
            chv.xgD = jSONObject.optString("expand", "");
            chv.hlm = "";
            chv.xgC = chv.xgH.xgS;
            chv.xgH.xhd = jSONObject.optInt("switchFlag", 0);
            chw chw = chv.xgH;
            boolean z = jSONObject.optJSONObject("colikeInfo") != null && jSONObject.optJSONObject("colikeInfo").optBoolean("isSelfThumb");
            chw.xhh = z;
            chv.xgH.xhi = jSONObject.optJSONObject("colikeInfo") != null ? jSONObject.optJSONObject("colikeInfo").optString("byPass", "") : "";
            optString2 = jSONObject.optString("videoChannelTitle", "");
            if (!bo.isNullOrNil(optString2) && (chv.xgG == 100202 || chv.xgG == 100204 || chv.xgG == 100205)) {
                chv.xgI = new bzs();
                chv.xgI.title = optString2;
            }
            optString2 = jSONObject.optString("extReqParams", "");
            if (!bo.isNullOrNil(optString2)) {
                try {
                    optJSONArray = new JSONArray(optString2);
                    for (i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                        tn tnVar = new tn();
                        tnVar.key = jSONObject3.optString("key", "");
                        tnVar.waD = (long) jSONObject3.optInt("uintValue", 0);
                        tnVar.waE = jSONObject3.optString("textValue", "");
                        chv.tZG.add(tnVar);
                    }
                } catch (Exception e5) {
                }
            }
            chv.xgN = jSONObject.optString("preNetType", "");
            if (chv.xgN.equals("wangka")) {
                chv.xgO = 1;
            } else if (chv.xgN.equals("2g") || chv.xgN.equals("3g") || chv.xgN.equals("4g")) {
                chv.xgO = 2;
            } else {
                chv.xgO = 0;
            }
        }
        AppMethodBeat.o(96353);
        return chv;
    }

    public static final chv ag(Map<String, Object> map) {
        int i = 0;
        AppMethodBeat.i(96354);
        chv chv = new chv();
        chv.ctj = aa.t(map, SearchIntents.EXTRA_QUERY);
        chv.scene = aa.d((Map) map, "scene", 21);
        chv.xgj = UUID.randomUUID().toString();
        chv.hlm = aa.t(map, "searchId");
        if (at.isConnected(ah.getContext()) && !at.isWifi(ah.getContext())) {
            chv.xgJ = true;
        }
        String t = aa.t(map, "videoId");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(aa.t(map, "videoUrls"));
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    chy chy = new chy();
                    chy.url = jSONArray.getString(i2);
                    arrayList.add(chy);
                }
            }
        } catch (JSONException e) {
        }
        if (!bo.isNullOrNil(t)) {
            JSONObject jSONObject;
            chv.xgH = new chw();
            chv.xgH.title = aa.t(map, "title");
            chv.xgH.xgQ = aa.t(map, "thumbUrl");
            chv.xgH.xgR = aa.d((Map) map, "mediaDuration", 0);
            chv.xgH.xgS = t;
            chv.xgH.fgJ = m.CTRL_INDEX;
            chv.xgH.fgI = d.MIC_PTU_TRANS_XINXIAN;
            chv.xgH.uai = aa.t(map, "strPlayCount");
            chv.xgH.lvz = aa.t(map, "shareUrl");
            chv.xgH.lvA = aa.t(map, "shareTitle");
            chv.xgH.uaj = aa.t(map, "titleUrl");
            chv.xgH.qVw = aa.t(map, "shareDesc");
            chv.xgH.uaf = aa.t(map, "shareImgUrl");
            chv.xgH.uag = aa.t(map, "shareString");
            chv.xgH.uah = aa.t(map, "shareStringUrl");
            chv.xgH.source = aa.t(map, "source");
            chv.xgH.phw = aa.t(map, "sourceUrl");
            chv.xgH.xgT = aa.a((Map) map, "relevant_category", -1);
            chv.xgH.xgU = aa.t(map, "shareOpenId");
            chv.xgH.ubA = aa.t(map, "docID");
            chv.xgH.xha = aa.a((Map) map, "videoSize", 0);
            chv.xgH.timestamp = bo.yz();
            chv.xgH.xgW = aa.d((Map) map, "itemType", 0);
            chv.xgH.xhd = aa.d((Map) map, "switchFlag", 0);
            if (bo.isNullOrNil(chv.xgH.xgQ)) {
                chv.xgH.xgQ = "http://shp.qpic.cn/qqvideo_ori/0/" + chv.xgH.xgS + String.format("_%s_%s/0", new Object[]{Integer.valueOf(m.CTRL_INDEX), Integer.valueOf(d.MIC_PTU_TRANS_XINXIAN)});
            }
            try {
                jSONObject = new JSONObject(aa.t(map, "block"));
                chv.xgH.xgZ = jSONObject.optLong("resultType");
                chv.xgH.ctk = jSONObject.optLong("type");
            } catch (JSONException e2) {
            }
            chv.xgH.xgV = aa.t(map, "expand");
            chv.xgH.xhb.addAll(arrayList);
            chy dM = dM(arrayList);
            if (dM != null) {
                chv.xgH.videoUrl = dM.url;
                chv.xgH.xhg = dM.xhg;
            }
            String t2 = aa.t(map, "show_tag_list");
            if (!bo.isNullOrNil(t2)) {
                try {
                    chv.xgH.wiH.addAll(y(new JSONArray(t2)));
                } catch (JSONException e3) {
                }
            }
            chv.xgG = chv.xgH.xgT;
            chv.xgD = aa.t(map, "expand");
            chv.xgE = chv.hlm;
            chv.xgC = chv.xgH.xgS;
            t2 = aa.t(map, "videoChannelTitle");
            if (!bo.isNullOrNil(chv.xgH.uag) && (chv.xgG == 100202 || chv.xgG == 100204 || chv.xgG == 100205)) {
                chv.xgI = new bzs();
                chv.xgI.title = t2;
            }
            t2 = aa.t(map, "extReqParams");
            if (!bo.isNullOrNil(t2)) {
                try {
                    JSONArray jSONArray2 = new JSONArray(t2);
                    while (i < jSONArray2.length()) {
                        jSONObject = jSONArray2.getJSONObject(i);
                        tn tnVar = new tn();
                        tnVar.key = jSONObject.optString("key", "");
                        tnVar.waD = (long) jSONObject.optInt("uintValue", 0);
                        tnVar.waE = jSONObject.optString("textValue", "");
                        chv.tZG.add(tnVar);
                        i++;
                    }
                } catch (Exception e4) {
                }
            }
        }
        AppMethodBeat.o(96354);
        return chv;
    }

    public static final chv a(chv chv) {
        AppMethodBeat.i(96355);
        chv chv2 = new chv();
        chv2.xgj = chv.xgj;
        chv2.scene = chv.scene;
        chv2.ctj = chv.ctj;
        chv2.hlm = chv.hlm;
        chv2.xgH = chv.xgH;
        chv2.xgG = chv.xgG;
        chv2.xgD = chv.xgD;
        chv2.xgE = chv.xgE;
        chv2.xgF = chv.xgF;
        chv2.xgC = chv.xgC;
        chv2.tZG.addAll(chv.tZG);
        chv2.eif = chv.eif;
        chv2.xgN = chv.xgN;
        chv2.xgO = chv.xgO;
        AppMethodBeat.o(96355);
        return chv2;
    }

    public static String cFl() {
        AppMethodBeat.i(96356);
        String str = ah.getContext().getCacheDir() + "topstory/";
        AppMethodBeat.o(96356);
        return str;
    }

    public static String abz(String str) {
        AppMethodBeat.i(96357);
        String str2 = ah.getContext().getCacheDir() + "topstory/" + str + "/";
        AppMethodBeat.o(96357);
        return str2;
    }

    public static boolean cFm() {
        AppMethodBeat.i(96358);
        if (1 >= ab.getLogLevel()) {
            AppMethodBeat.o(96358);
            return true;
        }
        AppMethodBeat.o(96358);
        return false;
    }

    public static JSONArray dN(List<bzs> list) {
        AppMethodBeat.i(96359);
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    bzs bzs = (bzs) list.get(i2);
                    jSONObject.put("id", bzs.id);
                    jSONObject.put("wording", bzs.cEh);
                    jSONObject.put("category", bzs.wYN);
                    jSONObject.put("actionType", bzs.actionType);
                    jSONObject.put("url", bzs.url);
                    jSONObject.put("title", bzs.title);
                    jSONObject.put("subTitle", bzs.jcF);
                    jSONObject.put("icon", bzs.cIY);
                    jSONArray.put(jSONObject);
                } catch (Exception e) {
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(96359);
                return jSONArray;
            }
        }
    }

    private static List<bzs> y(JSONArray jSONArray) {
        AppMethodBeat.i(96360);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            bzs bzs = new bzs();
            bzs.id = optJSONObject.optString("id", "");
            bzs.cEh = optJSONObject.optString("wording", "");
            bzs.wYN = optJSONObject.optLong("category", 0);
            bzs.actionType = optJSONObject.optInt("actionType", 0);
            bzs.url = optJSONObject.optString("url", "");
            bzs.title = optJSONObject.optString("title", "");
            bzs.jcF = optJSONObject.optString("subTitle", "");
            bzs.cIY = optJSONObject.optString("icon", "");
            arrayList.add(bzs);
        }
        AppMethodBeat.o(96360);
        return arrayList;
    }

    public static String a(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        AppMethodBeat.i(96361);
        HashMap hashMap = new HashMap();
        if (!bo.isNullOrNil(str4)) {
            hashMap.put("redPointMsgId", str4);
        }
        if (!bo.isNullOrNil(str)) {
            hashMap.put("sessionId", str);
        }
        if (!bo.isNullOrNil(str2)) {
            hashMap.put(SearchIntents.EXTRA_QUERY, str2);
        }
        if (!bo.isNullOrNil(str3)) {
            hashMap.put("requestId", str3);
            hashMap.put("pRequestId", str3);
            hashMap.put("seq", str3);
        }
        hashMap.put("scene", String.valueOf(i));
        if (!bo.isNullOrNil(str5)) {
            hashMap.put("tabInfo", str5);
        }
        if (i2 > 0) {
            hashMap.put("contentReddot", String.valueOf(i2));
        }
        if (i3 > 0) {
            hashMap.put("numberReddot", String.valueOf(i3));
        }
        try {
            hashMap.put("deviceName", URLEncoder.encode(com.tencent.mm.protocal.d.DEVICE_NAME, "utf8"));
            hashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
            hashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
            hashMap.put("ostype", com.tencent.mm.protocal.d.vxk);
        } catch (UnsupportedEncodingException e) {
            ab.printErrStackTrace("MicroMsg.TopStory.TopStoryApiLogic", e, "", new Object[0]);
        }
        String o = o(hashMap);
        AppMethodBeat.o(96361);
        return o;
    }

    public static String o(HashMap<String, String> hashMap) {
        AppMethodBeat.i(96362);
        p(hashMap);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(aa.HQ(1).aLD());
        stringBuffer.append("/");
        stringBuffer.append("app.html");
        stringBuffer.append("?");
        stringBuffer.append(aa.an(hashMap));
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(96362);
        return stringBuffer2;
    }

    private static void p(HashMap<String, String> hashMap) {
        AppMethodBeat.i(96363);
        hashMap.put("lang", com.tencent.mm.sdk.platformtools.aa.gw(ah.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(aa.HQ(1).afW()));
        hashMap.put(DownloadInfo.NETTYPE, aa.bVP());
        hashMap.put("isClientLoading", "1");
        hashMap.put("wechatVersion", f.CLIENT_VERSION);
        AppMethodBeat.o(96363);
    }

    public static boolean T(File file) {
        AppMethodBeat.i(96364);
        if (file.exists()) {
            try {
                String cy = FileOp.cy(file.getAbsolutePath());
                if (bo.isNullOrNil(cy)) {
                    AppMethodBeat.o(96364);
                    return false;
                } else if (cy.contains("default#default")) {
                    AppMethodBeat.o(96364);
                    return false;
                } else {
                    AppMethodBeat.o(96364);
                    return true;
                }
            } catch (Exception e) {
                AppMethodBeat.o(96364);
                return false;
            }
        }
        AppMethodBeat.o(96364);
        return false;
    }

    public static String cFn() {
        AppMethodBeat.i(96365);
        String str = e.eSk.replace("/data/user/0", "/data/data") + "topstory/homecache/";
        AppMethodBeat.o(96365);
        return str;
    }

    public static String cFo() {
        AppMethodBeat.i(96366);
        String str = e.eSk.replace("/data/user/0", "/data/data") + "topstory/negcache/";
        AppMethodBeat.o(96366);
        return str;
    }

    public static boolean cFp() {
        boolean z;
        AppMethodBeat.i(96367);
        switch (((a) com.tencent.mm.kernel.g.K(a.class)).bOL()) {
            case 3:
            case 4:
            case 5:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        ab.i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", Boolean.valueOf(z), Integer.valueOf(((a) com.tencent.mm.kernel.g.K(a.class)).bOL()));
        AppMethodBeat.o(96367);
        return z;
    }

    public static String cFq() {
        AppMethodBeat.i(96368);
        String str;
        if (at.isWifi(ah.getContext())) {
            str = "wifi";
            AppMethodBeat.o(96368);
            return str;
        } else if (cFp()) {
            str = "wangka";
            AppMethodBeat.o(96368);
            return str;
        } else if (at.is4G(ah.getContext())) {
            str = "4g";
            AppMethodBeat.o(96368);
            return str;
        } else if (at.is3G(ah.getContext())) {
            str = "3g";
            AppMethodBeat.o(96368);
            return str;
        } else if (at.is2G(ah.getContext())) {
            str = "2g";
            AppMethodBeat.o(96368);
            return str;
        } else if (at.isConnected(ah.getContext())) {
            str = "";
            AppMethodBeat.o(96368);
            return str;
        } else {
            str = "fail";
            AppMethodBeat.o(96368);
            return str;
        }
    }
}
