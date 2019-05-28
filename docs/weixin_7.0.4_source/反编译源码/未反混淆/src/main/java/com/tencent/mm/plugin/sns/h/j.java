package com.tencent.mm.plugin.sns.h;

import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.cde;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class j {
    public static String jrk = "<TimelineObject>";
    public static String jrl = "</TimelineObject>";
    public static String jvr = "]]>";

    static class a {
        StringBuffer jvt = new StringBuffer();

        a() {
            AppMethodBeat.i(36834);
            AppMethodBeat.o(36834);
        }

        public final void Fi(String str) {
            AppMethodBeat.i(36835);
            this.jvt.append("<" + str + ">");
            AppMethodBeat.o(36835);
        }

        public final void Fj(String str) {
            AppMethodBeat.i(36836);
            this.jvt.append("</" + str + ">");
            AppMethodBeat.o(36836);
        }

        public final void setText(String str) {
            AppMethodBeat.i(36837);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(36837);
            } else if (str.contains(j.jvr)) {
                this.jvt.append("<![CDATA[" + bo.ani(str) + "]]>");
                AppMethodBeat.o(36837);
            } else {
                this.jvt.append("<![CDATA[" + str + "]]>");
                AppMethodBeat.o(36837);
            }
        }

        public final void setText(int i) {
            AppMethodBeat.i(36838);
            this.jvt.append(i);
            AppMethodBeat.o(36838);
        }

        public final void m(String str, Map<String, String> map) {
            AppMethodBeat.i(36839);
            this.jvt.append("<".concat(String.valueOf(str)));
            for (String str2 : map.keySet()) {
                this.jvt.append(" " + str2 + "=\"" + ((String) map.get(str2)) + "\" ");
            }
            this.jvt.append(">");
            map.clear();
            AppMethodBeat.o(36839);
        }
    }

    private static String YE(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    private static String YF(String str) {
        AppMethodBeat.i(36840);
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(36840);
            return str;
        }
        Object obj;
        if (str.matches("\\d*")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.o(36840);
            return str;
        }
        str = "";
        AppMethodBeat.o(36840);
        return str;
    }

    public static String b(TimeLineObject timeLineObject) {
        String str;
        AppMethodBeat.i(36841);
        a aVar = new a();
        HashMap hashMap = new HashMap();
        aVar.Fi("TimelineObject");
        aVar.Fi("id");
        if (timeLineObject.Id == null || timeLineObject.Id.equals("")) {
            aVar.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        } else {
            aVar.setText(timeLineObject.Id);
        }
        aVar.Fj("id");
        if (timeLineObject.jBB != null) {
            aVar.Fi("username");
            aVar.setText(timeLineObject.jBB);
            aVar.Fj("username");
        }
        aVar.Fi("createTime");
        aVar.setText(timeLineObject.pcX);
        aVar.Fj("createTime");
        aVar.Fi("contentDescShowType");
        aVar.setText(timeLineObject.xfK);
        aVar.Fj("contentDescShowType");
        aVar.Fi("contentDescScene");
        aVar.setText(timeLineObject.xfL);
        aVar.Fj("contentDescScene");
        aVar.Fi("private");
        aVar.setText(timeLineObject.wEJ);
        aVar.Fj("private");
        if (!(timeLineObject.xfH == null || bo.isNullOrNil(timeLineObject.xfH.Id))) {
            aVar.Fi("appInfo");
            aVar.Fi("id");
            aVar.setText(YE(timeLineObject.xfH.Id));
            aVar.Fj("id");
            aVar.Fi("version");
            aVar.setText(YE(timeLineObject.xfH.jCh));
            aVar.Fj("version");
            aVar.Fi("appName");
            aVar.setText(YE(timeLineObject.xfH.ncH));
            aVar.Fj("appName");
            aVar.Fi("installUrl");
            aVar.setText(YE(timeLineObject.xfH.vFw));
            aVar.Fj("installUrl");
            aVar.Fi("fromUrl");
            aVar.setText(YE(timeLineObject.xfH.vFx));
            aVar.Fj("fromUrl");
            aVar.Fj("appInfo");
        }
        if (!(timeLineObject.xfN == null || bo.isNullOrNil(timeLineObject.xfN.fiG))) {
            aVar.Fi("streamvideo");
            aVar.Fi("streamvideourl");
            aVar.setText(YE(timeLineObject.xfN.fiG));
            aVar.Fj("streamvideourl");
            aVar.Fi("streamvideototaltime");
            aVar.setText(timeLineObject.xfN.fiH);
            aVar.Fj("streamvideototaltime");
            aVar.Fi("streamvideotitle");
            aVar.setText(YE(timeLineObject.xfN.fiI));
            aVar.Fj("streamvideotitle");
            aVar.Fi("streamvideowording");
            aVar.setText(YE(timeLineObject.xfN.fiJ));
            aVar.Fj("streamvideowording");
            aVar.Fi("streamvideoweburl");
            aVar.setText(YE(timeLineObject.xfN.fiK));
            aVar.Fj("streamvideoweburl");
            aVar.Fi("streamvideothumburl");
            aVar.setText(YE(timeLineObject.xfN.fiL));
            aVar.Fj("streamvideothumburl");
            aVar.Fi("streamvideoaduxinfo");
            aVar.setText(YE(timeLineObject.xfN.fiM));
            aVar.Fj("streamvideoaduxinfo");
            aVar.Fi("streamvideopublishid");
            aVar.setText(YE(timeLineObject.xfN.fiN));
            aVar.Fj("streamvideopublishid");
            aVar.Fj("streamvideo");
        }
        if (!(timeLineObject.qNQ == null || bo.isNullOrNil(timeLineObject.qNQ.uaa))) {
            aVar.Fi("websearch");
            aVar.Fi("relevant_vid");
            aVar.setText(YE(timeLineObject.qNQ.uaa));
            aVar.Fj("relevant_vid");
            aVar.Fi("relevant_expand");
            aVar.setText(YE(timeLineObject.qNQ.uab));
            aVar.Fj("relevant_expand");
            aVar.Fi("relevant_pre_searchid");
            aVar.setText(YE(timeLineObject.qNQ.uac));
            aVar.Fj("relevant_pre_searchid");
            aVar.Fi("relevant_shared_openid");
            aVar.setText(YE(timeLineObject.qNQ.uad));
            aVar.Fj("relevant_shared_openid");
            aVar.Fi("rec_category");
            aVar.setText(YE(timeLineObject.qNQ.uae));
            aVar.Fj("rec_category");
            aVar.Fi("shareUrl");
            aVar.setText(YE(timeLineObject.qNQ.lvz));
            aVar.Fj("shareUrl");
            aVar.Fi("shareTitle");
            aVar.setText(YE(timeLineObject.qNQ.lvA));
            aVar.Fj("shareTitle");
            aVar.Fi("shareDesc");
            aVar.setText(YE(timeLineObject.qNQ.qVw));
            aVar.Fj("shareDesc");
            aVar.Fi("shareImgUrl");
            aVar.setText(YE(timeLineObject.qNQ.uaf));
            aVar.Fj("shareImgUrl");
            aVar.Fi("shareString");
            aVar.setText(YE(timeLineObject.qNQ.uag));
            aVar.Fj("shareString");
            aVar.Fi("shareStringUrl");
            aVar.setText(YE(timeLineObject.qNQ.uah));
            aVar.Fj("shareStringUrl");
            aVar.Fi("source");
            aVar.setText(YE(timeLineObject.qNQ.source));
            aVar.Fj("source");
            aVar.Fi("strPlayCount");
            aVar.setText(YE(timeLineObject.qNQ.uai));
            aVar.Fj("strPlayCount");
            aVar.Fi("titleUrl");
            aVar.setText(YE(timeLineObject.qNQ.uaj));
            aVar.Fj("titleUrl");
            aVar.Fi("extReqParams");
            aVar.setText(YE(timeLineObject.qNQ.uak));
            aVar.Fj("extReqParams");
            aVar.Fi("tagList");
            aVar.setText(YE(timeLineObject.qNQ.ual));
            aVar.Fj("tagList");
            aVar.Fi(DownloadInfoColumns.CHANNELID);
            aVar.setText(YE(timeLineObject.qNQ.uam));
            aVar.Fj(DownloadInfoColumns.CHANNELID);
            aVar.Fi("thumbUrl");
            aVar.setText(YE(timeLineObject.qNQ.thumbUrl));
            aVar.Fj("thumbUrl");
            aVar.Fi("shareTag");
            aVar.setText(YE(timeLineObject.qNQ.uan));
            aVar.Fj("shareTag");
            aVar.Fj("websearch");
        }
        aVar.Fi("contentDesc");
        aVar.setText(YE(timeLineObject.xfF));
        aVar.Fj("contentDesc");
        aVar.Fi("contentattr");
        aVar.setText(timeLineObject.fgt);
        aVar.Fj("contentattr");
        aVar.Fi("sourceUserName");
        aVar.setText(YE(timeLineObject.ijx));
        aVar.Fj("sourceUserName");
        aVar.Fi("sourceNickName");
        aVar.setText(YE(timeLineObject.vjM));
        aVar.Fj("sourceNickName");
        aVar.Fi("statisticsData");
        aVar.setText(YE(timeLineObject.xfM));
        aVar.Fj("statisticsData");
        aVar.Fi("weappInfo");
        aVar.Fi("appUserName");
        aVar.setText(YE(timeLineObject.xfO.username));
        aVar.Fj("appUserName");
        aVar.Fi("pagePath");
        aVar.setText(YE(timeLineObject.xfO.path));
        aVar.Fj("pagePath");
        aVar.Fj("weappInfo");
        aVar.Fi("canvasInfoXml");
        aVar.setText(YE(timeLineObject.rCK));
        aVar.Fj("canvasInfoXml");
        if (timeLineObject.xfG != null) {
            float f = timeLineObject.xfG.vRp;
            float f2 = timeLineObject.xfG.vRq;
            if (!(f == -1000.0f || f2 == -1000.0f)) {
                hashMap.clear();
                hashMap.put("longitude", timeLineObject.xfG.vRp);
                hashMap.put("latitude", timeLineObject.xfG.vRq);
                hashMap.put("city", bo.ani(YE(timeLineObject.xfG.guP)));
                hashMap.put("poiName", bo.ani(YE(timeLineObject.xfG.eUu)));
                hashMap.put("poiAddress", bo.ani(YE(timeLineObject.xfG.rkg)));
                hashMap.put("poiScale", timeLineObject.xfG.wCE);
                hashMap.put("poiClassifyId", YE(timeLineObject.xfG.wCC));
                hashMap.put("poiClassifyType", timeLineObject.xfG.rki);
                hashMap.put("poiClickableStatus", timeLineObject.xfG.wCF);
                aVar.m(b.LOCATION, hashMap);
                aVar.Fj(b.LOCATION);
            }
        }
        aVar.Fi("ContentObject");
        aVar.Fi("contentStyle");
        aVar.setText(timeLineObject.xfI.wbJ);
        aVar.Fj("contentStyle");
        aVar.Fi("contentSubStyle");
        aVar.setText(timeLineObject.xfI.wbL);
        aVar.Fj("contentSubStyle");
        aVar.Fi("title");
        aVar.setText(YE(timeLineObject.xfI.Title));
        aVar.Fj("title");
        aVar.Fi("description");
        aVar.setText(YE(timeLineObject.xfI.Desc));
        aVar.Fj("description");
        aVar.Fi("contentUrl");
        aVar.setText(YE(timeLineObject.xfI.Url));
        aVar.Fj("contentUrl");
        if (timeLineObject.xfI.wbK.size() > 0) {
            aVar.Fi("mediaList");
            Iterator it = timeLineObject.xfI.wbK.iterator();
            while (it.hasNext()) {
                bau bau = (bau) it.next();
                aVar.Fi("media");
                aVar.Fi("id");
                if (YF(bau.Id).equals("")) {
                    aVar.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                } else {
                    aVar.setText(YF(bau.Id));
                }
                aVar.Fj("id");
                aVar.Fi("type");
                aVar.setText(bau.jCt);
                aVar.Fj("type");
                aVar.Fi("title");
                aVar.setText(YE(bau.Title));
                aVar.Fj("title");
                aVar.Fi("description");
                aVar.setText(YE(bau.Desc));
                aVar.Fj("description");
                aVar.Fi("private");
                aVar.setText(bau.wEJ);
                aVar.Fj("private");
                hashMap.clear();
                hashMap.put("type", bau.wEG);
                if (!bo.isNullOrNil(bau.cvZ)) {
                    hashMap.put("md5", bau.cvZ);
                }
                if (!bo.isNullOrNil(bau.wFc)) {
                    hashMap.put("videomd5", bau.wFc);
                }
                aVar.m("url", hashMap);
                aVar.setText(YE(bau.Url));
                aVar.Fj("url");
                if (!(bau.wEH == null || bau.wEH.equals(""))) {
                    hashMap.clear();
                    hashMap.put("type", bau.wEI);
                    aVar.m("thumb", hashMap);
                    aVar.setText(YE(bau.wEH));
                    aVar.Fj("thumb");
                }
                if (bau.cuu > 0) {
                    aVar.Fi("subType");
                    aVar.setText(bau.cuu);
                    aVar.Fj("subType");
                }
                if (!bo.isNullOrNil(bau.rik)) {
                    aVar.Fi("userData");
                    aVar.setText(bau.rik);
                    aVar.Fj("userData");
                }
                if (!(bau.wEL == null || bau.wEL.equals(""))) {
                    hashMap.clear();
                    hashMap.put("type", bau.wEM);
                    aVar.m("lowBandUrl", hashMap);
                    aVar.setText(YE(bau.wEL));
                    aVar.Fj("lowBandUrl");
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
                    aVar.m("size", hashMap);
                    aVar.Fj("size");
                }
                aVar.Fj("media");
            }
            aVar.Fj("mediaList");
        }
        aVar.jvt.append(YE(timeLineObject.xfI.wbM));
        if (!(timeLineObject.xfI.wbN == null || timeLineObject.xfI.wbN.vGc == -1)) {
            aVar.Fi("mmreadershare");
            if (timeLineObject.xfI.wbN.vGc == 5) {
                aVar.Fi("itemshowtype");
                aVar.setText(timeLineObject.xfI.wbN.vGc);
                aVar.Fj("itemshowtype");
                aVar.Fi("pubtime");
                aVar.setText(timeLineObject.xfI.wbN.fga);
                aVar.Fj("pubtime");
                aVar.Fi("vid");
                aVar.setText(timeLineObject.xfI.wbN.fgd);
                aVar.Fj("vid");
                aVar.Fi("funcflag");
                aVar.setText(timeLineObject.xfI.wbN.fgc);
                aVar.Fj("funcflag");
                aVar.Fi(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                aVar.setText(timeLineObject.xfI.wbN.duration);
                aVar.Fj(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
                aVar.Fi("digest");
                aVar.setText(timeLineObject.xfI.wbN.desc);
                aVar.Fj("digest");
                aVar.Fi("cover");
                aVar.setText(timeLineObject.xfI.wbN.lvx);
                aVar.Fj("cover");
                aVar.Fi("nativepage");
                aVar.setText(1);
                aVar.Fj("nativepage");
                aVar.Fi("width");
                aVar.setText(timeLineObject.xfI.wbN.videoWidth);
                aVar.Fj("width");
                aVar.Fi("height");
                aVar.setText(timeLineObject.xfI.wbN.videoHeight);
                aVar.Fj("height");
            }
            aVar.Fj("mmreadershare");
        }
        aVar.Fj("ContentObject");
        if (timeLineObject.qNO != null) {
            aVar.Fi("actionInfo");
            if (timeLineObject.qNO.vCy != null) {
                aVar.Fi("appMsg");
                aVar.Fi("mediaTagName");
                aVar.setText(timeLineObject.qNO.vCy.vCs);
                aVar.Fj("mediaTagName");
                aVar.Fi("messageExt");
                aVar.setText(timeLineObject.qNO.vCy.vCt);
                aVar.Fj("messageExt");
                aVar.Fi("messageAction");
                aVar.setText(timeLineObject.qNO.vCy.vCu);
                aVar.Fj("messageAction");
                aVar.Fj("appMsg");
            }
            aVar.Fj("actionInfo");
        }
        if (!(timeLineObject.xfH == null || bo.isNullOrNil(timeLineObject.xfH.Id))) {
            str = timeLineObject.rjC;
            cdg cdg = new cdg();
            if (str != null) {
                try {
                    cdg.parseFrom(Base64.decode(str, 0));
                } catch (Exception e) {
                }
            }
            cdg.xcU = new cde();
            cdg.xcU.mVX = timeLineObject.xfH.Id;
            try {
                str = Base64.encodeToString(cdg.toByteArray(), 0).replace(IOUtils.LINE_SEPARATOR_UNIX, "");
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.TimelineConvert", e2, "", new Object[0]);
            }
            timeLineObject.rjC = str;
        }
        if (timeLineObject.rjC != null) {
            aVar.Fi("statExtStr");
            aVar.setText(timeLineObject.rjC);
            aVar.Fj("statExtStr");
        }
        aVar.Fj("TimelineObject");
        str = aVar.jvt.toString();
        ab.d("MicroMsg.TimelineConvert", "xmlContent: ".concat(String.valueOf(str)));
        if (br.z(str, "TimelineObject") == null) {
            ab.e("MicroMsg.TimelineConvert", "xml is error");
            str = "";
            AppMethodBeat.o(36841);
            return str;
        }
        AppMethodBeat.o(36841);
        return str;
    }
}
