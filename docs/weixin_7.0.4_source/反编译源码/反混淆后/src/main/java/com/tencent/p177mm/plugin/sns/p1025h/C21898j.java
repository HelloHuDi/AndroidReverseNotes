package com.tencent.p177mm.plugin.sns.p1025h;

import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.p177mm.protocal.protobuf.TimeLineObject;
import com.tencent.p177mm.protocal.protobuf.bau;
import com.tencent.p177mm.protocal.protobuf.cde;
import com.tencent.p177mm.protocal.protobuf.cdg;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.h.j */
public final class C21898j {
    public static String jrk = "<TimelineObject>";
    public static String jrl = "</TimelineObject>";
    public static String jvr = "]]>";

    /* renamed from: com.tencent.mm.plugin.sns.h.j$a */
    static class C13362a {
        StringBuffer jvt = new StringBuffer();

        C13362a() {
            AppMethodBeat.m2504i(36834);
            AppMethodBeat.m2505o(36834);
        }

        /* renamed from: Fi */
        public final void mo25469Fi(String str) {
            AppMethodBeat.m2504i(36835);
            this.jvt.append("<" + str + ">");
            AppMethodBeat.m2505o(36835);
        }

        /* renamed from: Fj */
        public final void mo25470Fj(String str) {
            AppMethodBeat.m2504i(36836);
            this.jvt.append("</" + str + ">");
            AppMethodBeat.m2505o(36836);
        }

        public final void setText(String str) {
            AppMethodBeat.m2504i(36837);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(36837);
            } else if (str.contains(C21898j.jvr)) {
                this.jvt.append("<![CDATA[" + C5046bo.ani(str) + "]]>");
                AppMethodBeat.m2505o(36837);
            } else {
                this.jvt.append("<![CDATA[" + str + "]]>");
                AppMethodBeat.m2505o(36837);
            }
        }

        public final void setText(int i) {
            AppMethodBeat.m2504i(36838);
            this.jvt.append(i);
            AppMethodBeat.m2505o(36838);
        }

        /* renamed from: m */
        public final void mo25471m(String str, Map<String, String> map) {
            AppMethodBeat.m2504i(36839);
            this.jvt.append("<".concat(String.valueOf(str)));
            for (String str2 : map.keySet()) {
                this.jvt.append(" " + str2 + "=\"" + ((String) map.get(str2)) + "\" ");
            }
            this.jvt.append(">");
            map.clear();
            AppMethodBeat.m2505o(36839);
        }
    }

    /* renamed from: YE */
    private static String m33466YE(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    /* renamed from: YF */
    private static String m33467YF(String str) {
        AppMethodBeat.m2504i(36840);
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(36840);
            return str;
        }
        Object obj;
        if (str.matches("\\d*")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.m2505o(36840);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(36840);
        return str;
    }

    /* renamed from: b */
    public static String m33468b(TimeLineObject timeLineObject) {
        String str;
        AppMethodBeat.m2504i(36841);
        C13362a c13362a = new C13362a();
        HashMap hashMap = new HashMap();
        c13362a.mo25469Fi("TimelineObject");
        c13362a.mo25469Fi("id");
        if (timeLineObject.f15074Id == null || timeLineObject.f15074Id.equals("")) {
            c13362a.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            c13362a.setText(timeLineObject.f15074Id);
        }
        c13362a.mo25470Fj("id");
        if (timeLineObject.jBB != null) {
            c13362a.mo25469Fi("username");
            c13362a.setText(timeLineObject.jBB);
            c13362a.mo25470Fj("username");
        }
        c13362a.mo25469Fi("createTime");
        c13362a.setText(timeLineObject.pcX);
        c13362a.mo25470Fj("createTime");
        c13362a.mo25469Fi("contentDescShowType");
        c13362a.setText(timeLineObject.xfK);
        c13362a.mo25470Fj("contentDescShowType");
        c13362a.mo25469Fi("contentDescScene");
        c13362a.setText(timeLineObject.xfL);
        c13362a.mo25470Fj("contentDescScene");
        c13362a.mo25469Fi("private");
        c13362a.setText(timeLineObject.wEJ);
        c13362a.mo25470Fj("private");
        if (!(timeLineObject.xfH == null || C5046bo.isNullOrNil(timeLineObject.xfH.f17242Id))) {
            c13362a.mo25469Fi("appInfo");
            c13362a.mo25469Fi("id");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfH.f17242Id));
            c13362a.mo25470Fj("id");
            c13362a.mo25469Fi("version");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfH.jCh));
            c13362a.mo25470Fj("version");
            c13362a.mo25469Fi("appName");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfH.ncH));
            c13362a.mo25470Fj("appName");
            c13362a.mo25469Fi("installUrl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfH.vFw));
            c13362a.mo25470Fj("installUrl");
            c13362a.mo25469Fi("fromUrl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfH.vFx));
            c13362a.mo25470Fj("fromUrl");
            c13362a.mo25470Fj("appInfo");
        }
        if (!(timeLineObject.xfN == null || C5046bo.isNullOrNil(timeLineObject.xfN.fiG))) {
            c13362a.mo25469Fi("streamvideo");
            c13362a.mo25469Fi("streamvideourl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfN.fiG));
            c13362a.mo25470Fj("streamvideourl");
            c13362a.mo25469Fi("streamvideototaltime");
            c13362a.setText(timeLineObject.xfN.fiH);
            c13362a.mo25470Fj("streamvideototaltime");
            c13362a.mo25469Fi("streamvideotitle");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfN.fiI));
            c13362a.mo25470Fj("streamvideotitle");
            c13362a.mo25469Fi("streamvideowording");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfN.fiJ));
            c13362a.mo25470Fj("streamvideowording");
            c13362a.mo25469Fi("streamvideoweburl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfN.fiK));
            c13362a.mo25470Fj("streamvideoweburl");
            c13362a.mo25469Fi("streamvideothumburl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfN.fiL));
            c13362a.mo25470Fj("streamvideothumburl");
            c13362a.mo25469Fi("streamvideoaduxinfo");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfN.fiM));
            c13362a.mo25470Fj("streamvideoaduxinfo");
            c13362a.mo25469Fi("streamvideopublishid");
            c13362a.setText(C21898j.m33466YE(timeLineObject.xfN.fiN));
            c13362a.mo25470Fj("streamvideopublishid");
            c13362a.mo25470Fj("streamvideo");
        }
        if (!(timeLineObject.qNQ == null || C5046bo.isNullOrNil(timeLineObject.qNQ.uaa))) {
            c13362a.mo25469Fi("websearch");
            c13362a.mo25469Fi("relevant_vid");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uaa));
            c13362a.mo25470Fj("relevant_vid");
            c13362a.mo25469Fi("relevant_expand");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uab));
            c13362a.mo25470Fj("relevant_expand");
            c13362a.mo25469Fi("relevant_pre_searchid");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uac));
            c13362a.mo25470Fj("relevant_pre_searchid");
            c13362a.mo25469Fi("relevant_shared_openid");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uad));
            c13362a.mo25470Fj("relevant_shared_openid");
            c13362a.mo25469Fi("rec_category");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uae));
            c13362a.mo25470Fj("rec_category");
            c13362a.mo25469Fi("shareUrl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.lvz));
            c13362a.mo25470Fj("shareUrl");
            c13362a.mo25469Fi("shareTitle");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.lvA));
            c13362a.mo25470Fj("shareTitle");
            c13362a.mo25469Fi("shareDesc");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.qVw));
            c13362a.mo25470Fj("shareDesc");
            c13362a.mo25469Fi("shareImgUrl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uaf));
            c13362a.mo25470Fj("shareImgUrl");
            c13362a.mo25469Fi("shareString");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uag));
            c13362a.mo25470Fj("shareString");
            c13362a.mo25469Fi("shareStringUrl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uah));
            c13362a.mo25470Fj("shareStringUrl");
            c13362a.mo25469Fi("source");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.source));
            c13362a.mo25470Fj("source");
            c13362a.mo25469Fi("strPlayCount");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uai));
            c13362a.mo25470Fj("strPlayCount");
            c13362a.mo25469Fi("titleUrl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uaj));
            c13362a.mo25470Fj("titleUrl");
            c13362a.mo25469Fi("extReqParams");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uak));
            c13362a.mo25470Fj("extReqParams");
            c13362a.mo25469Fi("tagList");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.ual));
            c13362a.mo25470Fj("tagList");
            c13362a.mo25469Fi(DownloadInfoColumns.CHANNELID);
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uam));
            c13362a.mo25470Fj(DownloadInfoColumns.CHANNELID);
            c13362a.mo25469Fi("thumbUrl");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.thumbUrl));
            c13362a.mo25470Fj("thumbUrl");
            c13362a.mo25469Fi("shareTag");
            c13362a.setText(C21898j.m33466YE(timeLineObject.qNQ.uan));
            c13362a.mo25470Fj("shareTag");
            c13362a.mo25470Fj("websearch");
        }
        c13362a.mo25469Fi("contentDesc");
        c13362a.setText(C21898j.m33466YE(timeLineObject.xfF));
        c13362a.mo25470Fj("contentDesc");
        c13362a.mo25469Fi("contentattr");
        c13362a.setText(timeLineObject.fgt);
        c13362a.mo25470Fj("contentattr");
        c13362a.mo25469Fi("sourceUserName");
        c13362a.setText(C21898j.m33466YE(timeLineObject.ijx));
        c13362a.mo25470Fj("sourceUserName");
        c13362a.mo25469Fi("sourceNickName");
        c13362a.setText(C21898j.m33466YE(timeLineObject.vjM));
        c13362a.mo25470Fj("sourceNickName");
        c13362a.mo25469Fi("statisticsData");
        c13362a.setText(C21898j.m33466YE(timeLineObject.xfM));
        c13362a.mo25470Fj("statisticsData");
        c13362a.mo25469Fi("weappInfo");
        c13362a.mo25469Fi("appUserName");
        c13362a.setText(C21898j.m33466YE(timeLineObject.xfO.username));
        c13362a.mo25470Fj("appUserName");
        c13362a.mo25469Fi("pagePath");
        c13362a.setText(C21898j.m33466YE(timeLineObject.xfO.path));
        c13362a.mo25470Fj("pagePath");
        c13362a.mo25470Fj("weappInfo");
        c13362a.mo25469Fi("canvasInfoXml");
        c13362a.setText(C21898j.m33466YE(timeLineObject.rCK));
        c13362a.mo25470Fj("canvasInfoXml");
        if (timeLineObject.xfG != null) {
            float f = timeLineObject.xfG.vRp;
            float f2 = timeLineObject.xfG.vRq;
            if (!(f == -1000.0f || f2 == -1000.0f)) {
                hashMap.clear();
                hashMap.put("longitude", timeLineObject.xfG.vRp);
                hashMap.put("latitude", timeLineObject.xfG.vRq);
                hashMap.put("city", C5046bo.ani(C21898j.m33466YE(timeLineObject.xfG.guP)));
                hashMap.put("poiName", C5046bo.ani(C21898j.m33466YE(timeLineObject.xfG.eUu)));
                hashMap.put("poiAddress", C5046bo.ani(C21898j.m33466YE(timeLineObject.xfG.rkg)));
                hashMap.put("poiScale", timeLineObject.xfG.wCE);
                hashMap.put("poiClassifyId", C21898j.m33466YE(timeLineObject.xfG.wCC));
                hashMap.put("poiClassifyType", timeLineObject.xfG.rki);
                hashMap.put("poiClickableStatus", timeLineObject.xfG.wCF);
                c13362a.mo25471m(C8741b.LOCATION, hashMap);
                c13362a.mo25470Fj(C8741b.LOCATION);
            }
        }
        c13362a.mo25469Fi("ContentObject");
        c13362a.mo25469Fi("contentStyle");
        c13362a.setText(timeLineObject.xfI.wbJ);
        c13362a.mo25470Fj("contentStyle");
        c13362a.mo25469Fi("contentSubStyle");
        c13362a.setText(timeLineObject.xfI.wbL);
        c13362a.mo25470Fj("contentSubStyle");
        c13362a.mo25469Fi("title");
        c13362a.setText(C21898j.m33466YE(timeLineObject.xfI.Title));
        c13362a.mo25470Fj("title");
        c13362a.mo25469Fi("description");
        c13362a.setText(C21898j.m33466YE(timeLineObject.xfI.Desc));
        c13362a.mo25470Fj("description");
        c13362a.mo25469Fi("contentUrl");
        c13362a.setText(C21898j.m33466YE(timeLineObject.xfI.Url));
        c13362a.mo25470Fj("contentUrl");
        if (timeLineObject.xfI.wbK.size() > 0) {
            c13362a.mo25469Fi("mediaList");
            Iterator it = timeLineObject.xfI.wbK.iterator();
            while (it.hasNext()) {
                bau bau = (bau) it.next();
                c13362a.mo25469Fi("media");
                c13362a.mo25469Fi("id");
                if (C21898j.m33467YF(bau.f17915Id).equals("")) {
                    c13362a.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                } else {
                    c13362a.setText(C21898j.m33467YF(bau.f17915Id));
                }
                c13362a.mo25470Fj("id");
                c13362a.mo25469Fi("type");
                c13362a.setText(bau.jCt);
                c13362a.mo25470Fj("type");
                c13362a.mo25469Fi("title");
                c13362a.setText(C21898j.m33466YE(bau.Title));
                c13362a.mo25470Fj("title");
                c13362a.mo25469Fi("description");
                c13362a.setText(C21898j.m33466YE(bau.Desc));
                c13362a.mo25470Fj("description");
                c13362a.mo25469Fi("private");
                c13362a.setText(bau.wEJ);
                c13362a.mo25470Fj("private");
                hashMap.clear();
                hashMap.put("type", bau.wEG);
                if (!C5046bo.isNullOrNil(bau.cvZ)) {
                    hashMap.put("md5", bau.cvZ);
                }
                if (!C5046bo.isNullOrNil(bau.wFc)) {
                    hashMap.put("videomd5", bau.wFc);
                }
                c13362a.mo25471m("url", hashMap);
                c13362a.setText(C21898j.m33466YE(bau.Url));
                c13362a.mo25470Fj("url");
                if (!(bau.wEH == null || bau.wEH.equals(""))) {
                    hashMap.clear();
                    hashMap.put("type", bau.wEI);
                    c13362a.mo25471m("thumb", hashMap);
                    c13362a.setText(C21898j.m33466YE(bau.wEH));
                    c13362a.mo25470Fj("thumb");
                }
                if (bau.cuu > 0) {
                    c13362a.mo25469Fi("subType");
                    c13362a.setText(bau.cuu);
                    c13362a.mo25470Fj("subType");
                }
                if (!C5046bo.isNullOrNil(bau.rik)) {
                    c13362a.mo25469Fi("userData");
                    c13362a.setText(bau.rik);
                    c13362a.mo25470Fj("userData");
                }
                if (!(bau.wEL == null || bau.wEL.equals(""))) {
                    hashMap.clear();
                    hashMap.put("type", bau.wEM);
                    c13362a.mo25471m("lowBandUrl", hashMap);
                    c13362a.setText(C21898j.m33466YE(bau.wEL));
                    c13362a.mo25470Fj("lowBandUrl");
                }
                if (bau.wEK != null) {
                    hashMap.clear();
                    if (bau.wEK.wFx > 0.0f) {
                        hashMap.put("width", bau.wEK.wFx);
                    }
                    if (bau.wEK.wFy > 0.0f) {
                        hashMap.put("height", bau.wEK.wFy);
                    }
                    if (bau.wEK.wFz > 0.0f) {
                        hashMap.put("totalSize", bau.wEK.wFz);
                    }
                    c13362a.mo25471m("size", hashMap);
                    c13362a.mo25470Fj("size");
                }
                c13362a.mo25470Fj("media");
            }
            c13362a.mo25470Fj("mediaList");
        }
        c13362a.jvt.append(C21898j.m33466YE(timeLineObject.xfI.wbM));
        if (!(timeLineObject.xfI.wbN == null || timeLineObject.xfI.wbN.vGc == -1)) {
            c13362a.mo25469Fi("mmreadershare");
            if (timeLineObject.xfI.wbN.vGc == 5) {
                c13362a.mo25469Fi("itemshowtype");
                c13362a.setText(timeLineObject.xfI.wbN.vGc);
                c13362a.mo25470Fj("itemshowtype");
                c13362a.mo25469Fi("pubtime");
                c13362a.setText(timeLineObject.xfI.wbN.fga);
                c13362a.mo25470Fj("pubtime");
                c13362a.mo25469Fi("vid");
                c13362a.setText(timeLineObject.xfI.wbN.fgd);
                c13362a.mo25470Fj("vid");
                c13362a.mo25469Fi("funcflag");
                c13362a.setText(timeLineObject.xfI.wbN.fgc);
                c13362a.mo25470Fj("funcflag");
                c13362a.mo25469Fi(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                c13362a.setText(timeLineObject.xfI.wbN.duration);
                c13362a.mo25470Fj(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                c13362a.mo25469Fi("digest");
                c13362a.setText(timeLineObject.xfI.wbN.desc);
                c13362a.mo25470Fj("digest");
                c13362a.mo25469Fi("cover");
                c13362a.setText(timeLineObject.xfI.wbN.lvx);
                c13362a.mo25470Fj("cover");
                c13362a.mo25469Fi("nativepage");
                c13362a.setText(1);
                c13362a.mo25470Fj("nativepage");
                c13362a.mo25469Fi("width");
                c13362a.setText(timeLineObject.xfI.wbN.videoWidth);
                c13362a.mo25470Fj("width");
                c13362a.mo25469Fi("height");
                c13362a.setText(timeLineObject.xfI.wbN.videoHeight);
                c13362a.mo25470Fj("height");
            }
            c13362a.mo25470Fj("mmreadershare");
        }
        c13362a.mo25470Fj("ContentObject");
        if (timeLineObject.qNO != null) {
            c13362a.mo25469Fi("actionInfo");
            if (timeLineObject.qNO.vCy != null) {
                c13362a.mo25469Fi("appMsg");
                c13362a.mo25469Fi("mediaTagName");
                c13362a.setText(timeLineObject.qNO.vCy.vCs);
                c13362a.mo25470Fj("mediaTagName");
                c13362a.mo25469Fi("messageExt");
                c13362a.setText(timeLineObject.qNO.vCy.vCt);
                c13362a.mo25470Fj("messageExt");
                c13362a.mo25469Fi("messageAction");
                c13362a.setText(timeLineObject.qNO.vCy.vCu);
                c13362a.mo25470Fj("messageAction");
                c13362a.mo25470Fj("appMsg");
            }
            c13362a.mo25470Fj("actionInfo");
        }
        if (!(timeLineObject.xfH == null || C5046bo.isNullOrNil(timeLineObject.xfH.f17242Id))) {
            str = timeLineObject.rjC;
            cdg cdg = new cdg();
            if (str != null) {
                try {
                    cdg.parseFrom(Base64.decode(str, 0));
                } catch (Exception e) {
                }
            }
            cdg.xcU = new cde();
            cdg.xcU.mVX = timeLineObject.xfH.f17242Id;
            try {
                str = Base64.encodeToString(cdg.toByteArray(), 0).replace(IOUtils.LINE_SEPARATOR_UNIX, "");
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.TimelineConvert", e2, "", new Object[0]);
            }
            timeLineObject.rjC = str;
        }
        if (timeLineObject.rjC != null) {
            c13362a.mo25469Fi("statExtStr");
            c13362a.setText(timeLineObject.rjC);
            c13362a.mo25470Fj("statExtStr");
        }
        c13362a.mo25470Fj("TimelineObject");
        str = c13362a.jvt.toString();
        C4990ab.m7410d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(str)));
        if (C5049br.m7595z(str, "TimelineObject") == null) {
            C4990ab.m7412e("MicroMsg.TimelineConvert", "xml is error");
            str = "";
            AppMethodBeat.m2505o(36841);
            return str;
        }
        AppMethodBeat.m2505o(36841);
        return str;
    }
}
