package com.tencent.mm.modelsns;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.bz.a;
import com.tencent.mm.protocal.protobuf.TimeLineObject;
import com.tencent.mm.protocal.protobuf.at;
import com.tencent.mm.protocal.protobuf.av;
import com.tencent.mm.protocal.protobuf.ayt;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.cfg;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.protocal.protobuf.cvi;
import com.tencent.mm.protocal.protobuf.dj;
import com.tencent.mm.protocal.protobuf.ds;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.protocal.protobuf.uf;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.Map;

public final class e {
    private static float tA(String str) {
        AppMethodBeat.i(35573);
        if (str == null) {
            AppMethodBeat.o(35573);
            return 0.0f;
        }
        float f = bo.getFloat(str, 0.0f);
        AppMethodBeat.o(35573);
        return f;
    }

    private static String tB(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public static TimeLineObject ajM() {
        AppMethodBeat.i(35574);
        TimeLineObject timeLineObject = new TimeLineObject();
        uf ufVar = new uf();
        timeLineObject.xfH = new ds();
        timeLineObject.xfI = ufVar;
        timeLineObject.wEJ = 0;
        timeLineObject.pcX = 0;
        timeLineObject.Id = "";
        ayt ayt = new ayt();
        ayt.vRq = 0.0f;
        ayt.vRp = 0.0f;
        timeLineObject.xfG = ayt;
        timeLineObject.rCK = "";
        timeLineObject.xfO = new cth();
        AppMethodBeat.o(35574);
        return timeLineObject;
    }

    public static bau ajN() {
        AppMethodBeat.i(35575);
        bau bau = new bau();
        bau.Desc = "";
        bau.wEJ = 0;
        AppMethodBeat.o(35575);
        return bau;
    }

    public static bau a(String str, int i, String str2, String str3, int i2, int i3, String str4) {
        AppMethodBeat.i(35576);
        bau bau = new bau();
        bau.Id = str;
        bau.jCt = i;
        bau.Url = str2;
        bau.wEH = str3;
        bau.wEG = i2;
        bau.wEI = i3;
        bau.Desc = str4;
        baw baw = new baw();
        baw.wFy = 0.0f;
        baw.wFx = 0.0f;
        baw.wFz = 0.0f;
        bau.wEK = baw;
        bau.wEV = g.x(str2 == null ? "".getBytes() : str2.getBytes());
        AppMethodBeat.o(35576);
        return bau;
    }

    public static bau a(String str, int i, String str2, String str3, int i2, int i3, int i4, String str4, baw baw) {
        AppMethodBeat.i(35577);
        bau bau = new bau();
        bau.Id = tB(str);
        bau.jCt = i;
        bau.Desc = tB(str4);
        bau.Url = tB(str2);
        bau.wEG = i2;
        bau.wEH = tB(str3);
        bau.wEI = i3;
        bau.wEJ = i4;
        bau.wEK = baw;
        bau.wEV = g.x(str2 == null ? "".getBytes() : str2.getBytes());
        AppMethodBeat.o(35577);
        return bau;
    }

    public static TimeLineObject tC(String str) {
        TimeLineObject timeLineObject;
        AppMethodBeat.i(35578);
        Map z = br.z(str, "TimelineObject");
        TimeLineObject ajM = ajM();
        if (z != null) {
            int i;
            int indexOf;
            ajM.Id = tB((String) z.get(".TimelineObject.id"));
            ajM.jBB = tB((String) z.get(".TimelineObject.username"));
            ajM.wEJ = bo.getInt((String) z.get(".TimelineObject.private"), 0);
            ajM.pcX = bo.getInt((String) z.get(".TimelineObject.createTime"), 0);
            ajM.xfF = tB((String) z.get(".TimelineObject.contentDesc"));
            ajM.xfK = bo.getInt((String) z.get(".TimelineObject.contentDescShowType"), 0);
            ajM.xfL = bo.getInt((String) z.get(".TimelineObject.contentDescScene"), 0);
            ajM.rjC = tB((String) z.get(".TimelineObject.statExtStr"));
            ajM.xfP = bo.getInt((String) z.get(".TimelineObject.sightFolded"), 0);
            ajM.dtW = bo.getInt((String) z.get(".TimelineObject.showFlag"), 0);
            ayt ayt = new ayt();
            ayt.vRp = tA((String) z.get(".TimelineObject.location.$longitude"));
            ayt.vRq = tA((String) z.get(".TimelineObject.location.$latitude"));
            ayt.guP = tB((String) z.get(".TimelineObject.location.$city"));
            ayt.wCE = bo.getInt((String) z.get(".TimelineObject.location.$poiScale"), 0);
            ayt.wCC = tB((String) z.get(".TimelineObject.location.$poiClassifyId"));
            ayt.rki = bo.getInt((String) z.get(".TimelineObject.location.$poiClassifyType"), 0);
            ayt.rkg = tB((String) z.get(".TimelineObject.location.$poiAddress"));
            ayt.eUu = tB((String) z.get(".TimelineObject.location.$poiName"));
            ayt.wCF = bo.getInt((String) z.get(".TimelineObject.location.$poiClickableStatus"), 0);
            ayt.wCH = tB((String) z.get(".TimelineObject.location.$poiAddressName"));
            ayt.country = tB((String) z.get(".TimelineObject.location.$country"));
            ajM.xfG = ayt;
            String str2 = ".TimelineObject.ContentObject.description";
            String str3 = ".TimelineObject.ContentObject.contentStyle";
            String str4 = ".TimelineObject.ContentObject.contentSubStyle";
            String str5 = ".TimelineObject.ContentObject.title";
            String str6 = ".TimelineObject.ContentObject.contentUrl";
            String str7 = ".TimelineObject.ContentObject.mmreadershare.itemshowtype";
            String str8 = ".TimelineObject.ContentObject.mmreadershare.pubtime";
            String str9 = ".TimelineObject.ContentObject.mmreadershare.vid";
            String str10 = ".TimelineObject.ContentObject.mmreadershare.cover";
            String str11 = ".TimelineObject.ContentObject.mmreadershare.funcflag";
            String str12 = ".TimelineObject.ContentObject.mmreadershare.duration";
            String str13 = ".TimelineObject.ContentObject.mmreadershare.digest";
            String str14 = ".TimelineObject.ContentObject.mmreadershare.nativepage";
            String str15 = ".TimelineObject.ContentObject.mmreadershare.width";
            String str16 = ".TimelineObject.ContentObject.mmreadershare.height";
            if (ajM.xfI == null) {
                ajM.xfI = new uf();
            }
            ajM.xfI.Desc = tB((String) z.get(str2));
            ajM.xfI.wbJ = bo.getInt((String) z.get(str3), 0);
            ajM.xfI.wbL = bo.getInt((String) z.get(str4), 0);
            ajM.xfI.Title = tB((String) z.get(str5));
            ajM.xfI.Url = tB((String) z.get(str6));
            if (z.containsKey(str7)) {
                i = bo.getInt((String) z.get(str7), 0);
                if (i != -1) {
                    ajM.xfI.wbN = new azu();
                    ajM.xfI.wbN.vGc = i;
                }
                if (i == 5) {
                    ajM.xfI.wbN.fga = bo.getInt((String) z.get(str8), 0);
                    ajM.xfI.wbN.fgd = tB((String) z.get(str9));
                    ajM.xfI.wbN.lvx = tB((String) z.get(str10));
                    ajM.xfI.wbN.fgc = bo.getInt((String) z.get(str11), 0);
                    ajM.xfI.wbN.duration = bo.getInt((String) z.get(str12), 0);
                    ajM.xfI.wbN.desc = tB((String) z.get(str13));
                    ajM.xfI.wbN.fgb = bo.getInt((String) z.get(str14), 0);
                    ajM.xfI.wbN.videoWidth = bo.getInt((String) z.get(str15), 0);
                    ajM.xfI.wbN.videoHeight = bo.getInt((String) z.get(str16), 0);
                }
            }
            int i2 = 0;
            while (true) {
                String str17;
                String str18;
                String str19;
                String str20;
                String str21;
                String str22;
                String str23;
                String str24;
                String str25;
                String str26;
                String str27;
                String str28;
                String concat;
                String str29;
                String str30;
                String str31;
                String str32;
                String str33;
                String str34;
                String str35;
                String str36;
                String str37;
                String str38;
                String str39;
                String str40;
                String str41;
                String str42;
                String str43;
                if (i2 != 0) {
                    str17 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".id";
                    str18 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".type";
                    str19 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".title";
                    str20 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".description";
                    str21 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".url";
                    str22 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".url.$videomd5";
                    str23 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".thumb";
                    str24 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".url.$type";
                    str25 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".thumb.$type";
                    str26 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".private";
                    str27 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".subType";
                    str28 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".userData";
                    concat = ".TimelineObject.ContentObject.mediaList.media".concat(String.valueOf(i2));
                    str29 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".lowBandUrl";
                    str30 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".lowBandUrl.$type";
                    str15 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".attachUrl";
                    str14 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".attachUrl.$md5";
                    str13 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".url.$md5";
                    str12 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".videosize.$attachTotalTime";
                    str11 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".attachThumbUrl";
                    str10 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".attachShareTitle";
                    str9 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".enc";
                    str8 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".enc.$key";
                    str7 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".url.$token";
                    str6 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".url.$enc_idx";
                    str5 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".url.$key";
                    str4 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".thumb.$token";
                    str3 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".thumb.$enc_idx";
                    str31 = ".TimelineObject.ContentObject.mediaList.media" + i2 + ".thumb.$key";
                    str32 = str3;
                    str33 = str4;
                    str34 = str5;
                    str35 = str6;
                    str36 = str7;
                    str37 = str8;
                    str38 = str9;
                    str39 = str10;
                    str40 = str11;
                    str41 = str12;
                    str42 = str13;
                    str43 = str14;
                    str16 = str15;
                } else {
                    str17 = ".TimelineObject.ContentObject.mediaList.media.id";
                    str18 = ".TimelineObject.ContentObject.mediaList.media.type";
                    str19 = ".TimelineObject.ContentObject.mediaList.media.title";
                    str20 = ".TimelineObject.ContentObject.mediaList.media.description";
                    str21 = ".TimelineObject.ContentObject.mediaList.media.url";
                    str22 = ".TimelineObject.ContentObject.mediaList.media.url.$videomd5";
                    str23 = ".TimelineObject.ContentObject.mediaList.media.thumb";
                    str24 = ".TimelineObject.ContentObject.mediaList.media.url.$type";
                    str25 = ".TimelineObject.ContentObject.mediaList.media.thumb.$type";
                    str26 = ".TimelineObject.ContentObject.mediaList.media.private";
                    str27 = ".TimelineObject.ContentObject.mediaList.media.subType";
                    str28 = ".TimelineObject.ContentObject.mediaList.media.userData";
                    concat = ".TimelineObject.ContentObject.mediaList.media";
                    str29 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl";
                    str30 = ".TimelineObject.ContentObject.mediaList.media.lowBandUrl.$type";
                    str31 = ".TimelineObject.ContentObject.mediaList.media.thumb.$key";
                    str32 = ".TimelineObject.ContentObject.mediaList.media.thumb.$enc_idx";
                    str33 = ".TimelineObject.ContentObject.mediaList.media.thumb.$token";
                    str34 = ".TimelineObject.ContentObject.mediaList.media.url.$key";
                    str35 = ".TimelineObject.ContentObject.mediaList.media.url.$enc_idx";
                    str36 = ".TimelineObject.ContentObject.mediaList.media.url.$token";
                    str37 = ".TimelineObject.ContentObject.mediaList.media.enc.$key";
                    str38 = ".TimelineObject.ContentObject.mediaList.media.enc";
                    str39 = ".TimelineObject.ContentObject.mediaList.media.attachShareTitle";
                    str40 = ".TimelineObject.ContentObject.mediaList.media.attachThumbUrl";
                    str41 = ".TimelineObject.ContentObject.mediaList.media.videosize.$attachTotalTime";
                    str42 = ".TimelineObject.ContentObject.mediaList.media.url.$md5";
                    str43 = ".TimelineObject.ContentObject.mediaList.media.attachUrl.$md5";
                    str16 = ".TimelineObject.ContentObject.mediaList.media.attachUrl";
                }
                str2 = concat + ".size.$width";
                str3 = concat + ".size.$height";
                str2 = (String) z.get(str2);
                str3 = (String) z.get(str3);
                str4 = (String) z.get(concat + ".size.$totalSize");
                baw baw = new baw();
                baw.wFy = 0.0f;
                baw.wFx = 0.0f;
                baw.wFz = 0.0f;
                if (str2 != null) {
                    baw.wFx = tA(str2);
                }
                if (str3 != null) {
                    baw.wFy = tA(str3);
                }
                if (str4 != null) {
                    baw.wFz = tA(str4);
                }
                str2 = (String) z.get(str17);
                str3 = (String) z.get(str18);
                str4 = (String) z.get(str19);
                str5 = (String) z.get(str20);
                str6 = (String) z.get(str21);
                str7 = (String) z.get(str26);
                str8 = (String) z.get(str23);
                str9 = (String) z.get(str22);
                str10 = (String) z.get(str24);
                str11 = (String) z.get(str25);
                str12 = (String) z.get(str29);
                str13 = (String) z.get(str30);
                str14 = (String) z.get(str27);
                str15 = (String) z.get(str28);
                str16 = (String) z.get(str16);
                str43 = (String) z.get(str43);
                str42 = (String) z.get(str42);
                str41 = (String) z.get(str41);
                str40 = (String) z.get(str40);
                str39 = (String) z.get(str39);
                str38 = (String) z.get(str38);
                str37 = (String) z.get(str37);
                str36 = (String) z.get(str36);
                str35 = (String) z.get(str35);
                str34 = (String) z.get(str34);
                str33 = (String) z.get(str33);
                str32 = (String) z.get(str32);
                str31 = (String) z.get(str31);
                if (str3 == null || str2 == null) {
                    i = str.indexOf("<noteinfo>");
                    indexOf = str.indexOf("</noteinfo>");
                } else {
                    byte[] bytes;
                    bau bau = new bau();
                    bau.Id = tB(str2);
                    bau.jCt = bo.getInt(str3, 0);
                    bau.Title = tB(str4);
                    bau.Desc = tB(str5);
                    bau.Url = tB(str6);
                    bau.wEG = bo.getInt(str10, 0);
                    bau.wEH = tB(str8);
                    bau.wEI = bo.getInt(str11, 0);
                    bau.wEJ = bo.getInt(str7, 0);
                    bau.wEK = baw;
                    bau.wEL = tB(str12);
                    bau.wEM = bo.getInt(str13, 0);
                    bau.rik = tB(str15);
                    bau.cuu = bo.getInt(str14, 0);
                    bau.wEO = tB(str16);
                    bau.wEQ = tB(str43);
                    bau.wEP = tB(str42);
                    bau.wFc = tB(str9);
                    bau.rEd = bo.getInt(str41, 0);
                    bau.wER = tB(str40);
                    bau.wES = tB(str39);
                    bau.wET = bo.getInt(str38, 0);
                    bau.wEU = bo.getLong(str37, 0);
                    if (bau.Url == null) {
                        bytes = "".getBytes();
                    } else {
                        bytes = bau.Url.getBytes();
                    }
                    bau.wEV = g.x(bytes);
                    bau.wEW = str36;
                    bau.wEX = bo.getInt(str35, 0);
                    bau.wEY = str34;
                    bau.wEZ = str33;
                    bau.wFa = bo.getInt(str32, 0);
                    bau.wFb = str31;
                    ajM.xfI.wbK.add(bau);
                    i2++;
                }
            }
            i = str.indexOf("<noteinfo>");
            indexOf = str.indexOf("</noteinfo>");
            if (i < 0 || indexOf < 0) {
                timeLineObject = ajM;
            } else {
                ajM.xfI.wbM = str.substring(i, indexOf + 11);
                timeLineObject = ajM;
            }
            ds dsVar = new ds();
            str5 = tB((String) z.get(".TimelineObject.appInfo.id"));
            str6 = tB((String) z.get(".TimelineObject.appInfo.version"));
            str7 = tB((String) z.get(".TimelineObject.appInfo.appName"));
            str8 = tB((String) z.get(".TimelineObject.appInfo.installUrl "));
            str2 = tB((String) z.get(".TimelineObject.appInfo.fromUrl "));
            dsVar.Id = str5;
            dsVar.ncH = str7;
            dsVar.vFw = str8;
            dsVar.vFx = str2;
            dsVar.jCh = str6;
            dsVar.vFy = bo.getInt((String) z.get(".TimelineObject.appInfo.clickable"), 0);
            timeLineObject.xfH = dsVar;
            cth cth = new cth();
            str5 = tB((String) z.get(".TimelineObject.weappInfo.appUserName"));
            str2 = tB((String) z.get(".TimelineObject.weappInfo.pagePath"));
            cth.username = str5;
            cth.path = str2;
            timeLineObject.xfO = cth;
            cfg cfg = new cfg();
            str5 = tB((String) z.get(".TimelineObject.streamvideo.streamvideotitle"));
            str6 = tB((String) z.get(".TimelineObject.streamvideo.streamvideototaltime"));
            str7 = tB((String) z.get(".TimelineObject.streamvideo.streamvideourl"));
            str8 = tB((String) z.get(".TimelineObject.streamvideo.streamvideoweburl"));
            str9 = tB((String) z.get(".TimelineObject.streamvideo.streamvideowording"));
            str10 = tB((String) z.get(".TimelineObject.streamvideo.streamvideothumburl"));
            str11 = tB((String) z.get(".TimelineObject.streamvideo.streamvideoaduxinfo"));
            str2 = tB((String) z.get(".TimelineObject.streamvideo.streamvideopublishid"));
            cfg.fiI = str5;
            cfg.fiH = bo.ank(str6);
            cfg.fiG = str7;
            cfg.fiK = str8;
            cfg.fiJ = str9;
            cfg.fiL = str10;
            cfg.fiM = str11;
            cfg.fiN = str2;
            timeLineObject.xfN = cfg;
            cbc cbc = new cbc();
            str5 = tB((String) z.get(".TimelineObject.redEnvelopesInfo.sendId"));
            str2 = tB((String) z.get(".TimelineObject.redEnvelopesInfo.ticket"));
            cbc.nSX = str5;
            cbc.cxb = str2;
            av avVar = new av();
            int i3 = bo.getInt((String) z.get(".TimelineObject.actionInfo.scene"), 0);
            str6 = tB((String) z.get(".TimelineObject.actionInfo.appid"));
            int i4 = bo.getInt((String) z.get(".TimelineObject.actionInfo.type"), 0);
            str8 = tB((String) z.get(".TimelineObject.actionInfo.url"));
            str9 = tB((String) z.get(".TimelineObject.actionInfo.mediaTagName"));
            str2 = tB((String) z.get(".TimelineObject.actionInfo.wordingKey"));
            avVar.vCv = str6;
            avVar.Scene = i3;
            avVar.jCt = i4;
            avVar.Url = str8;
            avVar.vCw = str9;
            avVar.vCx = str2;
            at atVar = new at();
            str6 = tB((String) z.get(".TimelineObject.actionInfo.appMsg.appid"));
            str7 = tB((String) z.get(".TimelineObject.actionInfo.appMsg.mediaTagName"));
            str8 = tB((String) z.get(".TimelineObject.actionInfo.appMsg.messageExt"));
            str2 = tB((String) z.get(".TimelineObject.actionInfo.appMsg.messageAction"));
            atVar.fKh = str6;
            atVar.vCs = str7;
            atVar.vCt = str8;
            atVar.vCu = str2;
            avVar.vCy = atVar;
            i3 = bo.getInt((String) z.get(".TimelineObject.actionInfo.appActionScene.installedActionScene"), 0);
            int i5 = bo.getInt((String) z.get(".TimelineObject.actionInfo.appActionScene.uninstalledActionScene"), 0);
            str7 = tB((String) z.get(".TimelineObject.actionInfo.appJumpWordingKey.installedWordingKey"));
            str8 = tB((String) z.get(".TimelineObject.actionInfo.appJumpWordingKey.uninstalledWordingKey"));
            avVar.vCz = tB((String) z.get(".TimelineObject.actionInfo.newWordingKey"));
            dj djVar = new dj();
            djVar.vFo = i3;
            djVar.vFp = i5;
            du duVar = new du();
            duVar.vFC = str7;
            duVar.vFD = str8;
            avVar.vCA = djVar;
            avVar.vCB = duVar;
            avVar.vCC = tD((String) z.get(".TimelineObject.actionInfo.installedWording"));
            avVar.vCD = tD((String) z.get(".TimelineObject.actionInfo.uninstalledWording"));
            timeLineObject.qNO = avVar;
            timeLineObject.ijx = tB((String) z.get(".TimelineObject.sourceUserName"));
            timeLineObject.vjM = tB((String) z.get(".TimelineObject.sourceNickName"));
            timeLineObject.xfJ = tB((String) z.get(".TimelineObject.publicUserName"));
            timeLineObject.xfM = tB((String) z.get(".TimelineObject.statisticsData"));
            timeLineObject.rCK = tB((String) z.get(".TimelineObject.canvasInfoXml"));
            timeLineObject.fgt = bo.getInt((String) z.get(".TimelineObject.contentattr"), 0);
            cvi cvi = new cvi();
            cvi.uaa = tB((String) z.get(".TimelineObject.websearch.relevant_vid"));
            cvi.uab = tB((String) z.get(".TimelineObject.websearch.relevant_expand"));
            cvi.uac = tB((String) z.get(".TimelineObject.websearch.relevant_pre_searchid"));
            cvi.uad = tB((String) z.get(".TimelineObject.websearch.relevant_shared_openid"));
            cvi.uae = bo.getLong((String) z.get(".TimelineObject.websearch.rec_category"), 0);
            cvi.lvz = tB((String) z.get(".TimelineObject.websearch.shareUrl"));
            cvi.lvA = tB((String) z.get(".TimelineObject.websearch.shareTitle"));
            cvi.qVw = tB((String) z.get(".TimelineObject.websearch.shareDesc"));
            cvi.uaf = tB((String) z.get(".TimelineObject.websearch.shareImgUrl"));
            cvi.uag = tB((String) z.get(".TimelineObject.websearch.shareString"));
            cvi.uah = tB((String) z.get(".TimelineObject.websearch.shareStringUrl"));
            cvi.source = tB((String) z.get(".TimelineObject.websearch.source"));
            cvi.phw = tB((String) z.get(".TimelineObject.websearch.sourceUrl"));
            cvi.uai = tB((String) z.get(".TimelineObject.websearch.strPlayCount"));
            cvi.uaj = tB((String) z.get(".TimelineObject.websearch.titleUrl"));
            cvi.uak = tB((String) z.get(".TimelineObject.websearch.extReqParams"));
            cvi.ual = tB((String) z.get(".TimelineObject.websearch.tagList"));
            cvi.uam = bo.getLong((String) z.get(".TimelineObject.websearch.channelId"), 0);
            cvi.uan = tB((String) z.get(".TimelineObject.websearch.shareTag"));
            timeLineObject.qNQ = cvi;
        } else {
            timeLineObject = ajM;
        }
        AppMethodBeat.o(35578);
        return timeLineObject;
    }

    private static dt tD(String str) {
        AppMethodBeat.i(35579);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(35579);
            return null;
        }
        Map z = br.z("<root>" + tE(str) + "</root>", "root");
        if (z == null) {
            AppMethodBeat.o(35579);
            return null;
        }
        dt dtVar = new dt();
        dtVar.vFz = tB((String) z.get(".root.en"));
        dtVar.vFA = tB((String) z.get(".root.zh-CN"));
        dtVar.vFB = tB((String) z.get(".root.zh-TW"));
        AppMethodBeat.o(35579);
        return dtVar;
    }

    private static String tE(String str) {
        AppMethodBeat.i(35580);
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i = 0;
        int length = str.length();
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt != '&') {
                stringBuilder.append(charAt);
                i++;
            } else if (str.startsWith("&amp;", i)) {
                stringBuilder.append('&');
                i += 5;
            } else if (str.startsWith("&apos;", i)) {
                stringBuilder.append('\'');
                i += 6;
            } else if (str.startsWith("&quot;", i)) {
                stringBuilder.append('\"');
                i += 6;
            } else if (str.startsWith("&lt;", i)) {
                stringBuilder.append('<');
                i += 4;
            } else if (str.startsWith("&gt;", i)) {
                stringBuilder.append('>');
                i += 4;
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(35580);
        return stringBuilder2;
    }

    public static Pair<Integer, Integer> a(TimeLineObject timeLineObject, Context context, boolean z) {
        int i;
        int i2;
        Pair a;
        AppMethodBeat.i(35581);
        if (!(timeLineObject == null || timeLineObject.xfI == null || timeLineObject.xfI.wbK == null || timeLineObject.xfI.wbK.size() <= 0)) {
            bau bau = (bau) timeLineObject.xfI.wbK.get(0);
            if (bau != null && bau.wEK != null && bau.wEK.wFx > 0.0f && bau.wEK.wFy > 0.0f) {
                int i3 = (int) bau.wEK.wFx;
                i = (int) bau.wEK.wFy;
                i2 = i3;
                a = a(i2, i, context, z);
                AppMethodBeat.o(35581);
                return a;
            }
        }
        i = 0;
        i2 = 0;
        a = a(i2, i, context, z);
        AppMethodBeat.o(35581);
        return a;
    }

    public static Pair<Integer, Integer> a(int i, int i2, Context context, boolean z) {
        int i3;
        AppMethodBeat.i(35582);
        if (i <= 0) {
            i3 = 320;
        } else {
            i3 = i;
        }
        if (i2 <= 0) {
            i2 = 240;
        }
        if (context == null) {
            ab.e("MicroMsg.TimeLineHelper", "the context is null");
            Pair create = Pair.create(Integer.valueOf(i3), Integer.valueOf(i2));
            AppMethodBeat.o(35582);
            return create;
        }
        int min;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (displayMetrics != null) {
            min = (int) Math.min(((float) displayMetrics.widthPixels) * 0.63f, ((float) displayMetrics.heightPixels) * 0.63f);
        } else {
            min = i3;
        }
        int i4 = (min >> 5) << 5;
        if (i3 < i2 && context != null) {
            i4 = Math.min(b.b(context, 160.0f), i4);
        }
        min = (int) (((((double) i4) * 1.0d) * ((double) i2)) / ((double) i3));
        if (!z) {
            int fromDPToPix = a.fromDPToPix(context, 200);
            int fromDPToPix2 = a.fromDPToPix(context, 44);
            if (min >= i4) {
                if (min > fromDPToPix) {
                    min = fromDPToPix;
                }
                i4 = (int) (((((float) i3) * 1.0f) / ((float) i2)) * ((float) min));
                if (i4 < fromDPToPix2) {
                    min = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i2)) / ((double) i3));
                    i4 = fromDPToPix2;
                }
            } else {
                if (i4 > fromDPToPix) {
                    i4 = fromDPToPix;
                }
                min = (int) (((((float) i2) * 1.0f) / ((float) i3)) * ((float) i4));
                if (min < fromDPToPix2) {
                    i4 = (int) (((((double) fromDPToPix2) * 1.0d) * ((double) i3)) / ((double) i2));
                    min = fromDPToPix2;
                }
            }
        }
        ab.i("MicroMsg.TimeLineHelper", "getTimelineVideoSize: width %d, height %d, expectWidth %d,expectHeight %d, isAd: %s", Integer.valueOf(i3), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(min), Boolean.valueOf(z));
        Pair<Integer, Integer> create2 = Pair.create(Integer.valueOf(i4), Integer.valueOf(min));
        AppMethodBeat.o(35582);
        return create2;
    }
}
