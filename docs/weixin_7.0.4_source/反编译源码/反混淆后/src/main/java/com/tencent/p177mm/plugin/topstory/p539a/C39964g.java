package com.tencent.p177mm.plugin.topstory.p539a;

import android.os.Build;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelsfs.FileOp;
import com.tencent.p177mm.plugin.appbrand.jsapi.storage.C19486m;
import com.tencent.p177mm.plugin.misc.p994a.C12534a;
import com.tencent.p177mm.plugin.websearch.api.C46400aa;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C23447tn;
import com.tencent.p177mm.protocal.protobuf.abz;
import com.tencent.p177mm.protocal.protobuf.bzs;
import com.tencent.p177mm.protocal.protobuf.chv;
import com.tencent.p177mm.protocal.protobuf.chw;
import com.tencent.p177mm.protocal.protobuf.chy;
import com.tencent.p177mm.protocal.protobuf.cvi;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.view.C31128d;
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

/* renamed from: com.tencent.mm.plugin.topstory.a.g */
public final class C39964g {
    /* renamed from: dM */
    public static final chy m68433dM(List<chy> list) {
        AppMethodBeat.m2504i(96351);
        for (chy chy : list) {
            if (chy != null && !C5046bo.isNullOrNil(chy.url)) {
                AppMethodBeat.m2505o(96351);
                return chy;
            }
        }
        AppMethodBeat.m2505o(96351);
        return null;
    }

    /* renamed from: a */
    public static final chv m68429a(cvi cvi, int i, String str) {
        int i2 = 0;
        AppMethodBeat.m2504i(96352);
        chv chv = new chv();
        chv.xgj = UUID.randomUUID().toString();
        chv.xgH = new chw();
        chv.xgH.title = cvi.lvA;
        chv.xgH.ubA = "video-" + cvi.uaa;
        chv.xgH.xgS = cvi.uaa;
        chv.xgH.xgQ = cvi.thumbUrl;
        if (C5046bo.isNullOrNil(chv.xgH.xgQ)) {
            chv.xgH.xgQ = "http://shp.qpic.cn/qqvideo_ori/0/" + cvi.uaa + String.format("_%s_%s/0", new Object[]{Integer.valueOf(C19486m.CTRL_INDEX), Integer.valueOf(C31128d.MIC_PTU_TRANS_XINXIAN)});
        }
        chv.xgH.uai = cvi.uai;
        chv.xgH.source = cvi.source;
        chv.xgH.phw = cvi.phw;
        chv.xgH.xgV = cvi.uab;
        chv.xgH.xgX = cvi.uab;
        chv.xgH.uag = cvi.uag;
        chv.xgH.fgJ = C19486m.CTRL_INDEX;
        chv.xgH.fgI = C31128d.MIC_PTU_TRANS_XINXIAN;
        chv.xgH.timestamp = System.currentTimeMillis();
        if (!C5046bo.isNullOrNil(cvi.ual)) {
            try {
                JSONArray jSONArray = new JSONArray(cvi.ual);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    bzs bzs = new bzs();
                    bzs.f4415id = jSONObject.optString("id");
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
        if (!C5046bo.isNullOrNil(cvi.uak)) {
            try {
                JSONArray jSONArray2 = new JSONArray(cvi.uak);
                while (i2 < jSONArray2.length()) {
                    JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                    C23447tn c23447tn = new C23447tn();
                    c23447tn.key = jSONObject2.optString("key", "");
                    c23447tn.waD = (long) jSONObject2.optInt("uintValue", 0);
                    c23447tn.waE = jSONObject2.optString("textValue", "");
                    chv.tZG.add(c23447tn);
                    i2++;
                }
            } catch (Exception e2) {
            }
        }
        chv.hlm = "";
        chv.scene = i;
        chv.ctj = str;
        if (!C5046bo.isNullOrNil(cvi.uan)) {
            chv.xgI = new bzs();
            chv.xgI.title = cvi.uan;
        }
        AppMethodBeat.m2505o(96352);
        return chv;
    }

    /* renamed from: am */
    public static final chv m68432am(JSONObject jSONObject) {
        int i;
        AppMethodBeat.m2504i(96353);
        chv chv = new chv();
        chv.ctj = jSONObject.optString(SearchIntents.EXTRA_QUERY, "");
        chv.scene = jSONObject.optInt("scene", 21);
        chv.xgj = UUID.randomUUID().toString();
        chv.xgE = jSONObject.optString("searchId", "");
        if (C5023at.isConnected(C4996ah.getContext()) && !C5023at.isWifi(C4996ah.getContext())) {
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
        if (!C5046bo.isNullOrNil(optString)) {
            JSONObject jSONObject2;
            JSONArray optJSONArray;
            chv.xgH = new chw();
            chv.xgH.title = jSONObject.optString("title", "");
            chv.xgH.xgQ = jSONObject.optString("thumbUrl", "");
            chv.xgH.xgR = jSONObject.optInt("mediaDuration", 0);
            chv.xgH.xgS = optString;
            chv.xgH.fgJ = C19486m.CTRL_INDEX;
            chv.xgH.fgI = C31128d.MIC_PTU_TRANS_XINXIAN;
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
            chv.xgH.timestamp = C5046bo.m7588yz();
            chv.xgH.xgW = jSONObject.optInt("itemType", 0);
            try {
                jSONObject2 = new JSONObject(jSONObject.optString("block", ""));
                chv.xgH.xgZ = jSONObject2.optLong("resultType");
                chv.xgH.ctk = jSONObject2.optLong("type");
            } catch (JSONException e2) {
            }
            chv.xgH.xgV = jSONObject.optString("expand", "");
            chv.xgH.xhb.addAll(arrayList);
            chy dM = C39964g.m68433dM(arrayList);
            if (dM != null) {
                chv.xgH.videoUrl = dM.url;
                chv.xgH.xhg = dM.xhg;
            }
            if (C5046bo.isNullOrNil(chv.xgH.xgQ)) {
                chv.xgH.xgQ = "http://shp.qpic.cn/qqvideo_ori/0/" + chv.xgH.xgS + String.format("_%s_%s/0", new Object[]{Integer.valueOf(C19486m.CTRL_INDEX), Integer.valueOf(C31128d.MIC_PTU_TRANS_XINXIAN)});
            }
            String optString2 = jSONObject.optString("tagList", "");
            if (!C5046bo.isNullOrNil(optString2)) {
                try {
                    chv.xgH.wiH.addAll(C39964g.m68437y(new JSONArray(optString2)));
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
                            abz.f16202id = optJSONArray.optJSONObject(i).optString("id", "");
                            abz.cEh = optJSONArray.optJSONObject(i).optString("wording", "");
                            chv.xgH.xhc.add(abz);
                        }
                    }
                }
            }
            optString2 = jSONObject.optString("show_tag_list", "");
            if (!C5046bo.isNullOrNil(optString2)) {
                try {
                    chv.xgH.wiH.addAll(C39964g.m68437y(new JSONArray(optString2)));
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
            if (!C5046bo.isNullOrNil(optString2) && (chv.xgG == 100202 || chv.xgG == 100204 || chv.xgG == 100205)) {
                chv.xgI = new bzs();
                chv.xgI.title = optString2;
            }
            optString2 = jSONObject.optString("extReqParams", "");
            if (!C5046bo.isNullOrNil(optString2)) {
                try {
                    optJSONArray = new JSONArray(optString2);
                    for (i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject3 = optJSONArray.getJSONObject(i);
                        C23447tn c23447tn = new C23447tn();
                        c23447tn.key = jSONObject3.optString("key", "");
                        c23447tn.waD = (long) jSONObject3.optInt("uintValue", 0);
                        c23447tn.waE = jSONObject3.optString("textValue", "");
                        chv.tZG.add(c23447tn);
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
        AppMethodBeat.m2505o(96353);
        return chv;
    }

    /* renamed from: ag */
    public static final chv m68431ag(Map<String, Object> map) {
        int i = 0;
        AppMethodBeat.m2504i(96354);
        chv chv = new chv();
        chv.ctj = C46400aa.m87342t(map, SearchIntents.EXTRA_QUERY);
        chv.scene = C46400aa.m87332d((Map) map, "scene", 21);
        chv.xgj = UUID.randomUUID().toString();
        chv.hlm = C46400aa.m87342t(map, "searchId");
        if (C5023at.isConnected(C4996ah.getContext()) && !C5023at.isWifi(C4996ah.getContext())) {
            chv.xgJ = true;
        }
        String t = C46400aa.m87342t(map, "videoId");
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(C46400aa.m87342t(map, "videoUrls"));
            if (jSONArray.length() > 0) {
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    chy chy = new chy();
                    chy.url = jSONArray.getString(i2);
                    arrayList.add(chy);
                }
            }
        } catch (JSONException e) {
        }
        if (!C5046bo.isNullOrNil(t)) {
            JSONObject jSONObject;
            chv.xgH = new chw();
            chv.xgH.title = C46400aa.m87342t(map, "title");
            chv.xgH.xgQ = C46400aa.m87342t(map, "thumbUrl");
            chv.xgH.xgR = C46400aa.m87332d((Map) map, "mediaDuration", 0);
            chv.xgH.xgS = t;
            chv.xgH.fgJ = C19486m.CTRL_INDEX;
            chv.xgH.fgI = C31128d.MIC_PTU_TRANS_XINXIAN;
            chv.xgH.uai = C46400aa.m87342t(map, "strPlayCount");
            chv.xgH.lvz = C46400aa.m87342t(map, "shareUrl");
            chv.xgH.lvA = C46400aa.m87342t(map, "shareTitle");
            chv.xgH.uaj = C46400aa.m87342t(map, "titleUrl");
            chv.xgH.qVw = C46400aa.m87342t(map, "shareDesc");
            chv.xgH.uaf = C46400aa.m87342t(map, "shareImgUrl");
            chv.xgH.uag = C46400aa.m87342t(map, "shareString");
            chv.xgH.uah = C46400aa.m87342t(map, "shareStringUrl");
            chv.xgH.source = C46400aa.m87342t(map, "source");
            chv.xgH.phw = C46400aa.m87342t(map, "sourceUrl");
            chv.xgH.xgT = C46400aa.m87317a((Map) map, "relevant_category", -1);
            chv.xgH.xgU = C46400aa.m87342t(map, "shareOpenId");
            chv.xgH.ubA = C46400aa.m87342t(map, "docID");
            chv.xgH.xha = C46400aa.m87317a((Map) map, "videoSize", 0);
            chv.xgH.timestamp = C5046bo.m7588yz();
            chv.xgH.xgW = C46400aa.m87332d((Map) map, "itemType", 0);
            chv.xgH.xhd = C46400aa.m87332d((Map) map, "switchFlag", 0);
            if (C5046bo.isNullOrNil(chv.xgH.xgQ)) {
                chv.xgH.xgQ = "http://shp.qpic.cn/qqvideo_ori/0/" + chv.xgH.xgS + String.format("_%s_%s/0", new Object[]{Integer.valueOf(C19486m.CTRL_INDEX), Integer.valueOf(C31128d.MIC_PTU_TRANS_XINXIAN)});
            }
            try {
                jSONObject = new JSONObject(C46400aa.m87342t(map, "block"));
                chv.xgH.xgZ = jSONObject.optLong("resultType");
                chv.xgH.ctk = jSONObject.optLong("type");
            } catch (JSONException e2) {
            }
            chv.xgH.xgV = C46400aa.m87342t(map, "expand");
            chv.xgH.xhb.addAll(arrayList);
            chy dM = C39964g.m68433dM(arrayList);
            if (dM != null) {
                chv.xgH.videoUrl = dM.url;
                chv.xgH.xhg = dM.xhg;
            }
            String t2 = C46400aa.m87342t(map, "show_tag_list");
            if (!C5046bo.isNullOrNil(t2)) {
                try {
                    chv.xgH.wiH.addAll(C39964g.m68437y(new JSONArray(t2)));
                } catch (JSONException e3) {
                }
            }
            chv.xgG = chv.xgH.xgT;
            chv.xgD = C46400aa.m87342t(map, "expand");
            chv.xgE = chv.hlm;
            chv.xgC = chv.xgH.xgS;
            t2 = C46400aa.m87342t(map, "videoChannelTitle");
            if (!C5046bo.isNullOrNil(chv.xgH.uag) && (chv.xgG == 100202 || chv.xgG == 100204 || chv.xgG == 100205)) {
                chv.xgI = new bzs();
                chv.xgI.title = t2;
            }
            t2 = C46400aa.m87342t(map, "extReqParams");
            if (!C5046bo.isNullOrNil(t2)) {
                try {
                    JSONArray jSONArray2 = new JSONArray(t2);
                    while (i < jSONArray2.length()) {
                        jSONObject = jSONArray2.getJSONObject(i);
                        C23447tn c23447tn = new C23447tn();
                        c23447tn.key = jSONObject.optString("key", "");
                        c23447tn.waD = (long) jSONObject.optInt("uintValue", 0);
                        c23447tn.waE = jSONObject.optString("textValue", "");
                        chv.tZG.add(c23447tn);
                        i++;
                    }
                } catch (Exception e4) {
                }
            }
        }
        AppMethodBeat.m2505o(96354);
        return chv;
    }

    /* renamed from: a */
    public static final chv m68428a(chv chv) {
        AppMethodBeat.m2504i(96355);
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
        AppMethodBeat.m2505o(96355);
        return chv2;
    }

    public static String cFl() {
        AppMethodBeat.m2504i(96356);
        String str = C4996ah.getContext().getCacheDir() + "topstory/";
        AppMethodBeat.m2505o(96356);
        return str;
    }

    public static String abz(String str) {
        AppMethodBeat.m2504i(96357);
        String str2 = C4996ah.getContext().getCacheDir() + "topstory/" + str + "/";
        AppMethodBeat.m2505o(96357);
        return str2;
    }

    public static boolean cFm() {
        AppMethodBeat.m2504i(96358);
        if (1 >= C4990ab.getLogLevel()) {
            AppMethodBeat.m2505o(96358);
            return true;
        }
        AppMethodBeat.m2505o(96358);
        return false;
    }

    /* renamed from: dN */
    public static JSONArray m68434dN(List<bzs> list) {
        AppMethodBeat.m2504i(96359);
        JSONArray jSONArray = new JSONArray();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    bzs bzs = (bzs) list.get(i2);
                    jSONObject.put("id", bzs.f4415id);
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
                AppMethodBeat.m2505o(96359);
                return jSONArray;
            }
        }
    }

    /* renamed from: y */
    private static List<bzs> m68437y(JSONArray jSONArray) {
        AppMethodBeat.m2504i(96360);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            bzs bzs = new bzs();
            bzs.f4415id = optJSONObject.optString("id", "");
            bzs.cEh = optJSONObject.optString("wording", "");
            bzs.wYN = optJSONObject.optLong("category", 0);
            bzs.actionType = optJSONObject.optInt("actionType", 0);
            bzs.url = optJSONObject.optString("url", "");
            bzs.title = optJSONObject.optString("title", "");
            bzs.jcF = optJSONObject.optString("subTitle", "");
            bzs.cIY = optJSONObject.optString("icon", "");
            arrayList.add(bzs);
        }
        AppMethodBeat.m2505o(96360);
        return arrayList;
    }

    /* renamed from: a */
    public static String m68430a(int i, String str, String str2, String str3, String str4, String str5, int i2, int i3) {
        AppMethodBeat.m2504i(96361);
        HashMap hashMap = new HashMap();
        if (!C5046bo.isNullOrNil(str4)) {
            hashMap.put("redPointMsgId", str4);
        }
        if (!C5046bo.isNullOrNil(str)) {
            hashMap.put("sessionId", str);
        }
        if (!C5046bo.isNullOrNil(str2)) {
            hashMap.put(SearchIntents.EXTRA_QUERY, str2);
        }
        if (!C5046bo.isNullOrNil(str3)) {
            hashMap.put("requestId", str3);
            hashMap.put("pRequestId", str3);
            hashMap.put("seq", str3);
        }
        hashMap.put("scene", String.valueOf(i));
        if (!C5046bo.isNullOrNil(str5)) {
            hashMap.put("tabInfo", str5);
        }
        if (i2 > 0) {
            hashMap.put("contentReddot", String.valueOf(i2));
        }
        if (i3 > 0) {
            hashMap.put("numberReddot", String.valueOf(i3));
        }
        try {
            hashMap.put("deviceName", URLEncoder.encode(C7243d.DEVICE_NAME, "utf8"));
            hashMap.put("deviceBrand", URLEncoder.encode(Build.BRAND, "utf8"));
            hashMap.put("deviceModel", URLEncoder.encode(Build.MODEL, "utf8"));
            hashMap.put("ostype", C7243d.vxk);
        } catch (UnsupportedEncodingException e) {
            C4990ab.printErrStackTrace("MicroMsg.TopStory.TopStoryApiLogic", e, "", new Object[0]);
        }
        String o = C39964g.m68435o(hashMap);
        AppMethodBeat.m2505o(96361);
        return o;
    }

    /* renamed from: o */
    public static String m68435o(HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(96362);
        C39964g.m68436p(hashMap);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("file://");
        stringBuffer.append(C46400aa.m87300HQ(1).aLD());
        stringBuffer.append("/");
        stringBuffer.append("app.html");
        stringBuffer.append("?");
        stringBuffer.append(C46400aa.m87329an(hashMap));
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(96362);
        return stringBuffer2;
    }

    /* renamed from: p */
    private static void m68436p(HashMap<String, String> hashMap) {
        AppMethodBeat.m2504i(96363);
        hashMap.put("lang", C4988aa.m7403gw(C4996ah.getContext()));
        hashMap.put("platform", "android");
        hashMap.put("version", String.valueOf(C46400aa.m87300HQ(1).afW()));
        hashMap.put(DownloadInfo.NETTYPE, C46400aa.bVP());
        hashMap.put("isClientLoading", "1");
        hashMap.put("wechatVersion", C5058f.CLIENT_VERSION);
        AppMethodBeat.m2505o(96363);
    }

    /* renamed from: T */
    public static boolean m68427T(File file) {
        AppMethodBeat.m2504i(96364);
        if (file.exists()) {
            try {
                String cy = FileOp.m64139cy(file.getAbsolutePath());
                if (C5046bo.isNullOrNil(cy)) {
                    AppMethodBeat.m2505o(96364);
                    return false;
                } else if (cy.contains("default#default")) {
                    AppMethodBeat.m2505o(96364);
                    return false;
                } else {
                    AppMethodBeat.m2505o(96364);
                    return true;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(96364);
                return false;
            }
        }
        AppMethodBeat.m2505o(96364);
        return false;
    }

    public static String cFn() {
        AppMethodBeat.m2504i(96365);
        String str = C6457e.eSk.replace("/data/user/0", "/data/data") + "topstory/homecache/";
        AppMethodBeat.m2505o(96365);
        return str;
    }

    public static String cFo() {
        AppMethodBeat.m2504i(96366);
        String str = C6457e.eSk.replace("/data/user/0", "/data/data") + "topstory/negcache/";
        AppMethodBeat.m2505o(96366);
        return str;
    }

    public static boolean cFp() {
        boolean z;
        AppMethodBeat.m2504i(96367);
        switch (((C12534a) C1720g.m3528K(C12534a.class)).bOL()) {
            case 3:
            case 4:
            case 5:
                z = true;
                break;
            default:
                z = false;
                break;
        }
        C4990ab.m7417i("MicroMsg.TopStory.TopStoryApiLogic", "isFreeSimCard result :%b simType: %d", Boolean.valueOf(z), Integer.valueOf(((C12534a) C1720g.m3528K(C12534a.class)).bOL()));
        AppMethodBeat.m2505o(96367);
        return z;
    }

    public static String cFq() {
        AppMethodBeat.m2504i(96368);
        String str;
        if (C5023at.isWifi(C4996ah.getContext())) {
            str = "wifi";
            AppMethodBeat.m2505o(96368);
            return str;
        } else if (C39964g.cFp()) {
            str = "wangka";
            AppMethodBeat.m2505o(96368);
            return str;
        } else if (C5023at.is4G(C4996ah.getContext())) {
            str = "4g";
            AppMethodBeat.m2505o(96368);
            return str;
        } else if (C5023at.is3G(C4996ah.getContext())) {
            str = "3g";
            AppMethodBeat.m2505o(96368);
            return str;
        } else if (C5023at.is2G(C4996ah.getContext())) {
            str = "2g";
            AppMethodBeat.m2505o(96368);
            return str;
        } else if (C5023at.isConnected(C4996ah.getContext())) {
            str = "";
            AppMethodBeat.m2505o(96368);
            return str;
        } else {
            str = "fail";
            AppMethodBeat.m2505o(96368);
            return str;
        }
    }
}
