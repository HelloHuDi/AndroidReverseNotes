package com.tencent.mm.af;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.p;
import com.tencent.mm.g.c.t;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.ttpic.baseutils.BaseTemplateParser;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import junit.framework.Assert;

public final class j extends t {
    public static com.tencent.mm.sdk.e.c.a ccO;

    public static class b extends f {
        private static final f<Integer, b> emX = new com.tencent.mm.memory.a.c(100);
        public String action;
        public String appId;
        public String appName;
        public int axy;
        public String cDt;
        public String cEV;
        public int cKu;
        public String cMg;
        public String cMh;
        public String cMj;
        public String cMk;
        public String cMl;
        public String cMm;
        public String cMn;
        public String canvasPageXml = "";
        public String color;
        public String content;
        public String csD;
        public String cuZ;
        public String dJv;
        public String desc;
        public String description;
        public String designerName;
        public String designerRediretctUrl;
        public String extInfo;
        public String eyr;
        public int ffZ;
        public String fgA;
        public String fgB;
        public String fgC;
        public String fgD;
        public String fgE;
        public int fgF;
        public int fgG;
        public int fgH;
        public int fgI;
        public int fgJ;
        public String fgK;
        public int fgL;
        public String fgM;
        public String fgN;
        public int fgO;
        public int fgP;
        public String fgQ;
        public String fgR;
        public int fgS;
        public String fgT;
        public String fgU;
        public int fgV;
        public String fgW;
        public String fgX;
        public int fgY;
        public String fgZ;
        public a fgl;
        public Map<String, String> fgm;
        public String fgn;
        public int fgo;
        public String fgp;
        public String fgq;
        public int fgr;
        public int fgs;
        public int fgt;
        public String fgu;
        public String fgv;
        public int fgw;
        public int fgx;
        public int fgy;
        public String fgz;
        public int fhA;
        public String fhB;
        public String fhC;
        public int fhD;
        public int fhE;
        public int fhF;
        public String fhG;
        public String fhH;
        public String fhI;
        public String fhJ;
        public String fhK;
        public String fhL;
        public String fhM;
        public int fhN;
        public String fhO;
        public String fhP;
        public String fhQ;
        public String fhR;
        public String fhS;
        public String fhT;
        public String fhU;
        public String fhV;
        public String fhW;
        public String fhX;
        public String fhY;
        public String fhZ;
        public String fha;
        public String fhb;
        public String fhc;
        public String fhd;
        public String fhe;
        public String fhf;
        public String fhg;
        public String fhh;
        public String fhi;
        public String fhj;
        public String fhk;
        public String fhl;
        public String fhm;
        public int fhn;
        public int fho;
        public int fhp;
        public String fhq;
        public String fhr;
        public String fhs;
        public String fht;
        public String fhu;
        public int fhv;
        public String fhw;
        public String fhx;
        public String fhy;
        public int fhz;
        public String fiA;
        public String fiB;
        public String fiC;
        public int fiD;
        public String fiE;
        public String fiF;
        public String fiG;
        public int fiH = 0;
        public String fiI = "";
        public String fiJ = "";
        public String fiK = "";
        public String fiL = "";
        public String fiM = "";
        public String fiN = "";
        public String fiO;
        public String fiP;
        public String fiQ;
        public int fiR;
        public String fiS;
        public int fiT;
        public String fiU;
        public String fiV;
        public int fiW = a.BUSINESS_MAX.ordinal();
        public String fiX;
        public int fiY;
        public int fiZ;
        public int fia;
        public String fib;
        public String fic;
        public String fid;
        public int fie;
        public boolean fif = false;
        public int fig = 0;
        public String fih;
        public int fii;
        public String fij;
        public String fik;
        public String fil;
        public String filemd5;
        public List<String> fim;
        public String fin;
        public List<String> fio;
        public String fip;
        public int fiq;
        public String fir;
        public String fis;
        public String fit;
        public String fiu;
        public String fiv;
        public String fiw;
        public String fix;
        public String fiy;
        public String fiz;
        public int fja;
        public String fjb;
        public String fjc = null;
        public int fjd = 0;
        private final HashMap<Class<? extends f>, f> fje = new HashMap();
        public Map<String, String> fjf;
        private String fjg;
        private String fjh;
        private String fji;
        public String iconUrl;
        public String mediaTagName;
        public String messageAction;
        public String messageExt;
        public int pageType;
        public int sdkVer;
        public String secondUrl;
        public int showType;
        public String thumburl;
        public int tid;
        public String title;
        public int type;
        public String url;
        public String username;

        public static class a {
            public String dJE;
            public String desc;
            public int fjj;
            public int fjk;
            public int fjl;
            public int fjm;
            public int fjn = 0;
            public int fjo = 0;
            public String title;
        }

        public b() {
            AppMethodBeat.i(77771);
            AppMethodBeat.o(77771);
        }

        public final /* synthetic */ f Xz() {
            AppMethodBeat.i(77786);
            b XB = XB();
            AppMethodBeat.o(77786);
            return XB;
        }

        static {
            AppMethodBeat.i(77787);
            AppMethodBeat.o(77787);
        }

        public final <T extends f> T X(Class<T> cls) {
            AppMethodBeat.i(77772);
            f fVar = (f) this.fje.get(cls);
            AppMethodBeat.o(77772);
            return fVar;
        }

        public final void a(f fVar) {
            AppMethodBeat.i(77773);
            if (fVar == null) {
                ab.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
                AppMethodBeat.o(77773);
                return;
            }
            fVar.fge = this;
            this.fje.put(fVar.getClass(), fVar);
            AppMethodBeat.o(77773);
        }

        public static final b md(String str) {
            AppMethodBeat.i(77774);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(77774);
                return null;
            }
            Object str2;
            int indexOf = str2.indexOf(60);
            if (indexOf > 0) {
                str2 = str2.substring(indexOf);
            }
            int hashCode = "parseImg_".concat(String.valueOf(str2)).hashCode();
            b bVar = (b) emX.get(Integer.valueOf(hashCode));
            if (bVar != null) {
                AppMethodBeat.o(77774);
                return bVar;
            }
            Map z = br.z(str2, "msg");
            if (z == null) {
                ab.e("MicroMsg.AppMessage", "parseImg failed");
                AppMethodBeat.o(77774);
                return null;
            }
            b bVar2 = new b();
            bVar2.type = 2;
            bVar2.appId = (String) z.get(".msg.appinfo.appid");
            bVar2.axy = bo.getInt((String) z.get(".msg.appinfo.version"), 0);
            bVar2.appName = (String) z.get(".msg.appinfo.appname");
            bVar2.mediaTagName = (String) z.get(".msg.appinfo.mediatagname");
            bVar2.messageExt = (String) z.get(".msg.appinfo.messageext");
            bVar2.messageAction = (String) z.get(".msg.appinfo.messageaction");
            emX.k(Integer.valueOf(hashCode), bVar2);
            AppMethodBeat.o(77774);
            return bVar2;
        }

        public final String p(Context context, boolean z) {
            AppMethodBeat.i(77775);
            String str = "";
            if (cw(true)) {
                if (!bo.isNullOrNil(this.fiX)) {
                    int identifier = context.getResources().getIdentifier(this.fiX, "string", context.getPackageName());
                    ab.d("MicroMsg.AppMessage", "id: %d.", Integer.valueOf(identifier));
                    if (identifier > 0) {
                        str = context.getResources().getString(identifier);
                    } else if (a.BUSINESS_MY_LIFE_AROUND.ordinal() == this.fiW) {
                        str = "";
                    } else {
                        str = this.cMh;
                    }
                } else if (a.BUSINESS_MY_LIFE_AROUND.ordinal() == this.fiW) {
                    str = "";
                } else {
                    str = this.cMh;
                }
            }
            if (z && !str.isEmpty()) {
                str = "[" + str + "]";
            }
            ab.d("MicroMsg.AppMessage", "txt: %s.", str);
            AppMethodBeat.o(77775);
            return str;
        }

        public final boolean cw(boolean z) {
            AppMethodBeat.i(77776);
            if (z) {
                if (44 == this.type && this.fiW >= a.BUSINESS_MY_LIFE_AROUND.ordinal() && this.fiW < a.BUSINESS_MAX.ordinal()) {
                    AppMethodBeat.o(77776);
                    return true;
                }
            } else if (this.fiW >= a.BUSINESS_MY_LIFE_AROUND.ordinal() && this.fiW < a.BUSINESS_MAX.ordinal()) {
                AppMethodBeat.o(77776);
                return true;
            }
            AppMethodBeat.o(77776);
            return false;
        }

        public static final b me(String str) {
            AppMethodBeat.i(77777);
            b X = X(str, null);
            AppMethodBeat.o(77777);
            return X;
        }

        public static final b X(String str, String str2) {
            AppMethodBeat.i(77778);
            if (bo.isNullOrNil(str)) {
                AppMethodBeat.o(77778);
                return null;
            }
            String substring;
            int indexOf = str.indexOf(60);
            if (indexOf > 0) {
                substring = str.substring(indexOf);
            } else {
                substring = str;
            }
            int hashCode = substring.hashCode();
            b bVar = (b) emX.get(Integer.valueOf(hashCode));
            if (bVar != null) {
                AppMethodBeat.o(77778);
                return bVar;
            }
            Map map;
            Map z;
            long currentTimeMillis = System.currentTimeMillis();
            if (bo.isNullOrNil(str2)) {
                map = null;
            } else {
                map = be.amR(str2);
            }
            if (map == null) {
                z = br.z(substring, "msg");
            } else {
                z = map;
            }
            if (z == null) {
                ab.e("MicroMsg.AppMessage", "parse msg failed");
                AppMethodBeat.o(77778);
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            b bVar2 = new b();
            bVar2.fjf = z;
            bVar2.fjg = str;
            bVar2.fjh = substring;
            bVar2.fji = str2;
            try {
                f fVar;
                bVar2.a(z, bVar2);
                for (com.tencent.mm.ci.c cVar : c.fjp) {
                    fVar = (f) cVar.get();
                    fVar.a(z, bVar2);
                    bVar2.a(fVar);
                }
                fVar = c.kq(bVar2.type);
                if (fVar != null) {
                    fVar.a(z, bVar2);
                    bVar2.a(fVar);
                }
                emX.k(Integer.valueOf(hashCode), bVar2);
                ab.d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(bo.nullAsNil(str2).hashCode()));
                AppMethodBeat.o(77778);
                return bVar2;
            } catch (Exception e) {
                ab.e("MicroMsg.AppMessage", "parse amessage xml failed");
                ab.e("MicroMsg.AppMessage", "exception:%s", bo.l(e));
                AppMethodBeat.o(77778);
                return null;
            }
        }

        public static String a(b bVar, String str, d dVar) {
            AppMethodBeat.i(77779);
            ab.i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", bo.anv(bVar.eyr), bVar.filemd5);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msg>");
            if (bVar.fgJ == 0 || bVar.fgI == 0) {
                ab.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
                stringBuilder.append(a(bVar, str, dVar, 0, 0));
            } else {
                ab.d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", Integer.valueOf(bVar.fgJ), Integer.valueOf(bVar.fgI));
                stringBuilder.append(a(bVar, str, dVar, bVar.fgJ, bVar.fgI));
            }
            stringBuilder.append("</msg>");
            emX.k(Integer.valueOf(stringBuilder.toString().hashCode()), bVar);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(77779);
            return stringBuilder2;
        }

        public static String a(b bVar, String str, d dVar, int i, int i2) {
            AppMethodBeat.i(77780);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<appmsg appid=\"" + bo.ani(bVar.appId) + "\" sdkver=\"" + bVar.sdkVer + "\">");
            bVar.a(stringBuilder, bVar, str, dVar, i, i2);
            f kq = c.kq(bVar.type);
            if (kq != null) {
                kq.a(stringBuilder, bVar, str, dVar, i, i2);
            }
            stringBuilder.append("</appmsg>");
            if (2 == bVar.showType) {
                stringBuilder.append("<ShakePageResult>").append(bVar.fgC).append("</ShakePageResult>");
            }
            ab.d("MicroMsg.AppMessage", "summerbig makeContent[%s]", stringBuilder.toString());
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.o(77780);
            return stringBuilder2;
        }

        public static b a(b bVar) {
            AppMethodBeat.i(77781);
            b bVar2;
            if (bVar == null) {
                bVar2 = new b();
                AppMethodBeat.o(77781);
                return bVar2;
            }
            bVar2 = bVar.XB();
            AppMethodBeat.o(77781);
            return bVar2;
        }

        public final void a(Map<String, String> map, b bVar) {
            AppMethodBeat.i(77782);
            try {
                this.fgm = map;
                this.appId = (String) map.get(".msg.appmsg.$appid");
                this.sdkVer = bo.getInt((String) map.get(".msg.appmsg.$sdkver"), 0);
                this.title = bo.amS((String) map.get(".msg.appmsg.title"));
                this.description = (String) map.get(".msg.appmsg.des");
                this.username = (String) map.get(".msg.appmsg.username");
                this.action = (String) map.get(".msg.appmsg.action");
                this.type = bo.getInt((String) map.get(".msg.appmsg.type"), 0);
                this.content = (String) map.get(".msg.appmsg.content");
                this.url = (String) map.get(".msg.appmsg.url");
                this.fgn = (String) map.get(".msg.appmsg.lowurl");
                this.fgu = (String) map.get(".msg.appmsg.appattach.tpurl");
                this.fgv = (String) map.get(".msg.appmsg.appattach.tpthumburl");
                this.fgw = bo.getInt((String) map.get(".msg.appmsg.appattach.tpthumblength"), 0);
                this.fgx = bo.getInt((String) map.get(".msg.appmsg.appattach.tpthumbheight"), 0);
                this.fgy = bo.getInt((String) map.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
                this.fgz = (String) map.get(".msg.appmsg.appattach.tpthumbmd5");
                this.fgA = (String) map.get(".msg.appmsg.appattach.tpauthkey");
                this.fgB = (String) map.get(".msg.appmsg.appattach.tpthumbaeskey");
                this.fgM = (String) map.get(".msg.appmsg.dataurl");
                this.fgN = (String) map.get(".msg.appmsg.lowdataurl");
                this.fgo = bo.getInt((String) map.get(".msg.appmsg.appattach.totallen"), 0);
                this.csD = (String) map.get(".msg.appmsg.appattach.attachid");
                if (!bo.isNullOrNil(this.fgu)) {
                    this.csD = this.fgu;
                }
                this.fgp = bo.amS((String) map.get(".msg.appmsg.appattach.fileext"));
                this.fgq = (String) map.get(".msg.appmsg.appattach.emoticonmd5");
                this.extInfo = (String) map.get(".msg.appmsg.extinfo");
                this.fgr = bo.getInt((String) map.get(".msg.appmsg.androidsource"), 0);
                this.cMg = (String) map.get(".msg.appmsg.sourceusername");
                this.cMh = (String) map.get(".msg.appmsg.sourcedisplayname");
                this.dJv = (String) map.get(".msg.commenturl");
                this.thumburl = (String) map.get(".msg.appmsg.thumburl");
                this.mediaTagName = (String) map.get(".msg.appmsg.mediatagname");
                this.messageAction = (String) map.get(".msg.appmsg.messageaction");
                this.messageExt = (String) map.get(".msg.appmsg.messageext");
                this.axy = bo.getInt((String) map.get(".msg.appinfo.version"), 0);
                this.appName = (String) map.get(".msg.appinfo.appname");
                this.cEV = (String) map.get(".msg.fromusername");
                this.fgD = (String) map.get(".msg.appmsg.appattach.cdnattachurl");
                this.fgE = (String) map.get(".msg.appmsg.appattach.cdnthumburl");
                this.fgF = bo.getInt((String) map.get(".msg.appmsg.appattach.cdnthumblength"), 0);
                this.fgG = bo.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
                this.fgH = bo.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
                this.fgI = bo.getInt((String) map.get(".msg.appmsg.appattach.thumbheight"), 0);
                this.fgJ = bo.getInt((String) map.get(".msg.appmsg.appattach.thumbwidth"), 0);
                this.eyr = (String) map.get(".msg.appmsg.appattach.aeskey");
                this.fgL = bo.getInt((String) map.get(".msg.appmsg.appattach.encryver"), 1);
                this.fgK = (String) map.get(".msg.appmsg.appattach.cdnthumbaeskey");
                this.fgs = bo.getInt((String) map.get(".msg.appmsg.appattach.islargefilemsg"), 0);
                if (this.fgs == 0 && this.fgo > 26214400) {
                    this.fgs = 1;
                    ab.i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", Integer.valueOf(this.fgo));
                }
                this.fgP = bo.getInt((String) map.get(".msg.appmsg.productitem.$type"), 0);
                this.fgQ = (String) map.get(".msg.appmsg.productitem.productinfo");
                this.fgS = bo.getInt((String) map.get(".msg.appmsg.emoticongift.packageflag"), 0);
                this.fgR = (String) map.get(".msg.appmsg.emoticongift.packageid");
                this.fgX = (String) map.get(".msg.appmsg.emoticonshared.packageid");
                this.fgY = bo.getInt((String) map.get(".msg.appmsg.emoticonshared.packageflag"), 0);
                this.fgT = (String) map.get(".msg.appmsg.tvinfo");
                this.fgU = (String) map.get(".msg.appmsg.recorditem");
                this.cMj = (String) map.get(".msg.appmsg.webviewshared.shareUrlOriginal");
                this.cMk = (String) map.get(".msg.appmsg.webviewshared.shareUrlOpen");
                this.cMl = (String) map.get(".msg.appmsg.webviewshared.jsAppId");
                this.cMm = (String) map.get(".msg.appmsg.webviewshared.publisherId");
                this.fiD = p.cB((String) map.get(".msg.appmsg.designershared.designeruin"));
                this.designerName = (String) map.get(".msg.appmsg.designershared.designername");
                this.designerRediretctUrl = (String) map.get(".msg.appmsg.designershared.designerrediretcturl");
                this.tid = bo.ank((String) map.get(".msg.appmsg.emotionpageshared.tid"));
                this.fiE = (String) map.get(".msg.appmsg.emotionpageshared.title");
                this.desc = (String) map.get(".msg.appmsg.emotionpageshared.desc");
                this.iconUrl = (String) map.get(".msg.appmsg.emotionpageshared.iconUrl");
                this.secondUrl = bo.bc((String) map.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
                this.pageType = bo.ank((String) map.get(".msg.appmsg.emotionpageshared.pageType"));
                this.fiG = bo.bc((String) map.get(".msg.appmsg.streamvideo.streamvideourl"), "");
                this.fiH = bo.ank((String) map.get(".msg.appmsg.streamvideo.streamvideototaltime"));
                this.fiI = bo.bc((String) map.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
                this.fiJ = bo.bc((String) map.get(".msg.appmsg.streamvideo.streamvideowording"), "");
                this.fiK = bo.bc((String) map.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
                this.fiL = bo.bc((String) map.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
                this.fiM = bo.bc((String) map.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
                this.fiN = bo.bc((String) map.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
                this.canvasPageXml = bo.bc((String) map.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
                this.fiP = (String) map.get(".msg.appmsg.weappinfo.username");
                this.fiO = (String) map.get(".msg.appmsg.weappinfo.pagepath");
                this.fiQ = (String) map.get(".msg.appmsg.weappinfo.appid");
                this.fja = bo.getInt((String) map.get(".msg.appmsg.weappinfo.version"), 0);
                this.fiR = bo.getInt((String) map.get(".msg.appmsg.weappinfo.type"), 0);
                this.fiZ = bo.getInt((String) map.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
                this.fiS = (String) map.get(".msg.appmsg.weappinfo.pkginfo.md5");
                this.fjb = (String) map.get(".msg.appmsg.weappinfo.weappiconurl");
                this.fiU = (String) map.get(".msg.appmsg.weappinfo.shareId");
                this.fiV = (String) map.get(".msg.appmsg.weappinfo.sharekey");
                this.fiW = bo.getInt((String) map.get(".msg.appmsg.weappinfo.nativeappinfo.type"), a.BUSINESS_MAX.ordinal());
                this.fiX = bo.bc((String) map.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
                this.fiY = bo.getInt((String) map.get(".msg.appmsg.weappinfo.disableforward"), 0);
                String str = "<cache";
                String str2 = "</cache>";
                int indexOf = bVar.fjg.indexOf(str);
                int indexOf2 = bVar.fjg.indexOf(str2);
                if (indexOf2 - indexOf > str.length()) {
                    this.fjc = bVar.fjg.substring(indexOf, str2.length() + indexOf2);
                }
                this.fjd = bo.getInt((String) map.get(".msg.appmsg.soundtype"), 0);
                switch (this.type) {
                    case 1:
                        if (!(map.get(".msg.alphainfo.url") == null || map.get(".msg.alphainfo.md5") == null)) {
                            this.fif = true;
                            break;
                        }
                    case 13:
                        this.fgV = bo.getInt((String) map.get(".msg.appmsg.mallproductitem.$type"), 0);
                        this.fgW = (String) map.get(".msg.appmsg.mallproductitem.mallproductinfo");
                        break;
                    case 16:
                        this.cDt = bVar.fjg;
                        this.fhB = "";
                        this.fhD = bo.getInt((String) map.get(".msg.appmsg.carditem.from_scene"), 2);
                        this.fhC = (String) map.get(".msg.appmsg.carditem.brand_name");
                        this.fhE = bo.getInt((String) map.get(".msg.appmsg.carditem.card_type"), -1);
                        break;
                    case 34:
                        this.fhG = bo.bc((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
                        this.fhF = p.cB((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
                        this.fhH = bo.bc((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
                        this.fhI = bo.bc((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
                        this.fhJ = bo.bc((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
                        this.fhK = bo.bc((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
                        this.fhL = bo.bc((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
                        this.fhM = bo.bc((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
                        break;
                    case 2000:
                        this.fhv = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
                        this.fhw = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.feedesc"));
                        this.fhx = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.transcationid"));
                        this.fhy = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.transferid"));
                        this.fhz = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
                        this.fhA = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
                        this.cKu = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
                        this.cuZ = bo.bc((String) map.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
                        this.fiF = bo.bc((String) map.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
                        break;
                    case 2001:
                        String[] split;
                        this.fhR = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.iconurl"));
                        this.fhW = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.scenetext"));
                        this.fhQ = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.url"));
                        this.fhS = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.receivertitle"));
                        this.fhT = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.sendertitle"));
                        this.fhV = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.receiverdes"));
                        this.fhU = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.senderdes"));
                        this.fhX = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.templateid"));
                        this.fhY = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.sceneid"));
                        this.fhZ = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.nativeurl"));
                        this.fia = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.localtype"), 0);
                        this.fib = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.paymsgid"));
                        this.fic = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.imageid"));
                        this.fid = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.imageaeskey"));
                        this.fie = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
                        this.fig = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.droptips"), 0);
                        this.fih = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.billno"));
                        this.fii = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
                        this.fij = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
                        this.fik = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
                        this.fil = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
                        str = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
                        if (!bo.isNullOrNil(str)) {
                            split = str.split("\\|");
                            if (split != null && split.length > 0) {
                                this.fim = new ArrayList();
                                this.fim.addAll(Arrays.asList(split));
                            }
                        }
                        this.fin = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
                        str = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
                        if (!bo.isNullOrNil(str)) {
                            split = str.split("\\|");
                            if (split != null && split.length > 0) {
                                this.fio = new ArrayList();
                                this.fio.addAll(Arrays.asList(split));
                            }
                        }
                        this.fip = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
                        this.fiq = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
                        this.fir = bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
                        break;
                    case 2002:
                        this.fis = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.url"));
                        this.fit = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.templateid"));
                        this.fiu = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
                        this.fiv = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
                        this.fiw = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
                        this.fix = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
                        this.fiy = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
                        this.fiz = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
                        this.fiA = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
                        this.fiB = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
                        this.fiC = bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
                        break;
                }
                if (this.type != 21) {
                    if (this.type != 2001) {
                        this.showType = bo.getInt((String) map.get(".msg.appmsg.showtype"), 0);
                        switch (this.showType) {
                            case 1:
                                if (bo.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
                                    this.content = be.aS(map);
                                    break;
                                }
                                break;
                            case 2:
                                str = bVar.fjg.toLowerCase();
                                this.fgC = bVar.fjg.substring(str.indexOf("<ShakePageResult>".toLowerCase()) + 17, str.indexOf("</ShakePageResult>".toLowerCase()));
                                break;
                            default:
                                break;
                        }
                    }
                    this.showType = bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.innertype"), 0);
                } else {
                    this.showType = bo.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                }
                this.cMn = (String) map.get(".msg.appmsg.statextstr");
                this.ffZ = bo.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
                if (this.ffZ == 5 && bo.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 1) {
                    this.ffZ = 0;
                }
                this.fgO = bo.getInt((String) map.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
                this.fgZ = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle");
                this.fha = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid");
                if (bo.isNullOrNil(this.fha)) {
                    this.fha = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo.rankid");
                }
                this.fhb = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.rankdisplay");
                this.fhc = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoretitle");
                this.fhd = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.score.scoredisplay");
                this.fhe = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.tipdisplay");
                this.color = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.color");
                this.fhf = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightcolor");
                this.fhg = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.linecolor");
                this.fhi = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.fontcolor");
                this.fhh = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.highlightlinecolor");
                this.fhk = (String) map.get(".msg.appmsg.hardwareinfo.rankview.rankviewtitle");
                this.fhj = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.championusername");
                this.fhn = bo.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                this.fhp = bo.getInt((String) map.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
                this.fho = bo.getInt((String) map.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
                this.fhl = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto");
                this.fhm = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl");
                str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
                this.fht = str;
                this.fhr = str;
                str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
                this.fhs = str;
                this.fhq = str;
                this.fhu = bo.nullAsNil((String) map.get(".msg.appmsg.template_id"));
                this.filemd5 = (String) map.get(".msg.appmsg.md5");
                this.fhN = bo.getInt((String) map.get(".msg.appmsg.jumpcontrol.enable"), 0);
                this.fhO = (String) map.get(".msg.appmsg.jumpcontrol.jumpurl");
                this.fhP = (String) map.get(".msg.appmsg.jumpcontrol.pushcontent");
                Map z = br.z(bVar.fjh, "msgoperation");
                if (!(this == null || z == null)) {
                    this.fgl = new a();
                    this.fgl.dJE = (String) z.get(".msgoperation.expinfo.expidstr");
                    this.fgl.fjj = bo.getInt((String) z.get(".msgoperation.appmsg.usedefaultthumb"), 0);
                    this.fgl.fjk = bo.getInt((String) z.get(".msgoperation.appmsg.isupdatetitle"), 0);
                    this.fgl.title = (String) z.get(".msgoperation.appmsg.title");
                    this.fgl.fjl = bo.getInt((String) z.get(".msgoperation.appmsg.isupdatedesc"), 0);
                    this.fgl.desc = (String) z.get(".msgoperation.appmsg.desc");
                    this.fgl.fjm = bo.getInt((String) z.get(".msgoperation.appmsg.ishiddentail"), 0);
                }
                AppMethodBeat.o(77782);
            } catch (Exception e) {
                ab.e("MicroMsg.AppMessage", "parse amessage xml failed");
                ab.e("MicroMsg.AppMessage", "exception:%s", bo.l(e));
                AppMethodBeat.o(77782);
                throw e;
            }
        }

        private b XB() {
            AppMethodBeat.i(77783);
            b bVar = new b();
            if (this == null) {
                AppMethodBeat.o(77783);
                return bVar;
            }
            ab.i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", bo.anv(this.eyr), this.filemd5, bVar.appId);
            bVar.action = this.action;
            bVar.appId = this.appId;
            bVar.appName = this.appName;
            bVar.axy = this.axy;
            bVar.csD = this.csD;
            bVar.fgo = this.fgo;
            bVar.content = this.content;
            bVar.description = this.description;
            bVar.username = this.username;
            bVar.extInfo = this.extInfo;
            bVar.mediaTagName = this.mediaTagName;
            bVar.messageAction = this.messageAction;
            bVar.messageExt = this.messageExt;
            bVar.fgr = this.fgr;
            bVar.fgp = this.fgp;
            bVar.cEV = this.cEV;
            bVar.fgn = this.fgn;
            bVar.sdkVer = this.sdkVer;
            bVar.title = this.title;
            bVar.type = this.type;
            bVar.showType = this.showType;
            bVar.ffZ = this.ffZ;
            bVar.fgO = this.fgO;
            bVar.url = this.url;
            bVar.fgq = this.fgq;
            bVar.cMg = this.cMg;
            bVar.cMh = this.cMh;
            bVar.dJv = this.dJv;
            bVar.thumburl = this.thumburl;
            bVar.fgC = this.fgC;
            bVar.fgM = this.fgM;
            bVar.fgN = this.fgN;
            bVar.fgP = this.fgP;
            bVar.fgQ = this.fgQ;
            bVar.fgS = this.fgS;
            bVar.fgR = this.fgR;
            bVar.fgV = this.fgV;
            bVar.fgW = this.fgW;
            bVar.fgY = this.fgY;
            bVar.fgX = this.fgX;
            bVar.fgT = this.fgT;
            bVar.fgU = this.fgU;
            bVar.fhu = this.fhu;
            bVar.cDt = this.cDt;
            bVar.fhB = this.fhB;
            bVar.fhC = this.fhC;
            bVar.fhD = this.fhD;
            bVar.fhE = this.fhD;
            bVar.fhw = this.fhw;
            bVar.fhz = this.fhz;
            bVar.fhv = this.fhv;
            bVar.fhx = this.fhx;
            bVar.fhy = this.fhy;
            bVar.fhN = this.fhN;
            bVar.fhO = this.fhO;
            bVar.fhP = this.fhP;
            bVar.fgt = this.fgt;
            bVar.cMj = this.cMj;
            bVar.cMk = this.cMk;
            bVar.cMl = this.cMl;
            bVar.cMm = this.cMm;
            bVar.fiF = this.fiF;
            bVar.fiD = this.fiD;
            bVar.designerName = this.designerName;
            bVar.designerRediretctUrl = this.designerName;
            bVar.tid = this.tid;
            bVar.fiE = this.fiE;
            bVar.desc = this.desc;
            bVar.iconUrl = this.iconUrl;
            bVar.secondUrl = this.secondUrl;
            bVar.pageType = this.pageType;
            bVar.fiG = this.fiG;
            bVar.fiH = this.fiH;
            bVar.fiI = this.fiI;
            bVar.fiJ = this.fiJ;
            bVar.fiK = this.fiK;
            bVar.fiL = this.fiL;
            bVar.fiM = this.fiM;
            bVar.fiN = this.fiN;
            bVar.canvasPageXml = this.canvasPageXml;
            bVar.cMn = this.cMn;
            bVar.fgD = this.fgD;
            bVar.eyr = this.eyr;
            bVar.filemd5 = this.filemd5;
            bVar.fgs = this.fgs;
            bVar.fgl = this.fgl;
            bVar.fiO = this.fiO;
            bVar.fiP = this.fiP;
            bVar.fiR = this.fiR;
            bVar.fiS = this.fiS;
            bVar.fiZ = this.fiZ;
            bVar.fiQ = this.fiQ;
            bVar.fja = this.fja;
            bVar.fjb = this.fjb;
            bVar.fiU = this.fiU;
            bVar.fiV = this.fiV;
            bVar.fiW = this.fiW;
            bVar.fiX = this.fiX;
            bVar.fiY = this.fiY;
            bVar.fjh = this.fjh;
            bVar.fji = this.fji;
            bVar.fjg = this.fjg;
            bVar.fjf = this.fjf;
            bVar.fgu = this.fgu;
            bVar.fgv = this.fgv;
            bVar.fgw = this.fgw;
            bVar.fgx = this.fgx;
            bVar.fgy = this.fgy;
            bVar.fgz = this.fgz;
            bVar.fgA = this.fgA;
            bVar.fgB = this.fgB;
            for (Entry value : this.fje.entrySet()) {
                f Xz = ((f) value.getValue()).Xz();
                if (Xz != null) {
                    bVar.a(Xz);
                }
            }
            AppMethodBeat.o(77783);
            return bVar;
        }

        public final void a(StringBuilder stringBuilder, b bVar, String str, d dVar, int i, int i2) {
            String str2;
            AppMethodBeat.i(77784);
            stringBuilder.append("<title>" + bo.ani(bVar.title) + "</title>");
            stringBuilder.append("<des>" + bo.ani(bVar.description) + "</des>");
            stringBuilder.append("<username>" + bo.ani(bVar.username) + "</username>");
            StringBuilder stringBuilder2 = new StringBuilder("<action>");
            if (bo.isNullOrNil(bVar.action)) {
                str2 = "view";
            } else {
                str2 = bo.ani(bVar.action);
            }
            stringBuilder.append(stringBuilder2.append(str2).append("</action>").toString());
            stringBuilder.append("<type>" + bVar.type + "</type>");
            stringBuilder.append("<showtype>").append(bVar.showType).append("</showtype>");
            stringBuilder.append("<content>" + bo.ani(bVar.content) + "</content>");
            stringBuilder.append("<url>" + bo.ani(bVar.url) + "</url>");
            stringBuilder.append("<lowurl>" + bo.ani(bVar.fgn) + "</lowurl>");
            stringBuilder.append("<dataurl>" + bo.ani(bVar.fgM) + "</dataurl>");
            stringBuilder.append("<lowdataurl>" + bo.ani(bVar.fgN) + "</lowdataurl>");
            stringBuilder.append("<contentattr>").append(bVar.fgt).append("</contentattr>");
            stringBuilder.append("<streamvideo>");
            stringBuilder.append("<streamvideourl>").append(bo.ani(bVar.fiG)).append("</streamvideourl>");
            stringBuilder.append("<streamvideototaltime>").append(bVar.fiH).append("</streamvideototaltime>");
            stringBuilder.append("<streamvideotitle>").append(bo.ani(bVar.fiI)).append("</streamvideotitle>");
            stringBuilder.append("<streamvideowording>").append(bo.ani(bVar.fiJ)).append("</streamvideowording>");
            stringBuilder.append("<streamvideoweburl>").append(bo.ani(bVar.fiK)).append("</streamvideoweburl>");
            stringBuilder.append("<streamvideothumburl>").append(bo.ani(bVar.fiL)).append("</streamvideothumburl>");
            stringBuilder.append("<streamvideoaduxinfo>").append(bo.ani(bVar.fiM)).append("</streamvideoaduxinfo>");
            stringBuilder.append("<streamvideopublishid>").append(bo.ani(bVar.fiN)).append("</streamvideopublishid>");
            stringBuilder.append("</streamvideo>");
            stringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[]{bVar.canvasPageXml}));
            switch (bVar.type) {
                case 10:
                    stringBuilder.append("<productitem type=\"" + bVar.fgP + "\">");
                    stringBuilder.append("<productinfo>" + bo.ani(bVar.fgQ) + "</productinfo>");
                    stringBuilder.append("</productitem>");
                    break;
                case 13:
                    stringBuilder.append("<mallproductitem type=\"" + bVar.fgV + "\">");
                    stringBuilder.append("<mallproductinfo>" + bo.ani(bVar.fgW) + "</mallproductinfo>");
                    stringBuilder.append("</mallproductitem>");
                    break;
                case 16:
                    stringBuilder.append("<carditem>" + bVar.fhB + "</carditem>");
                    break;
                case 19:
                case 24:
                    stringBuilder.append("<recorditem>" + bo.ani(bVar.fgU) + "</recorditem>");
                    break;
                case 20:
                    stringBuilder.append("<tvinfo>" + bo.ani(bVar.fgT) + "</tvinfo>");
                    break;
                case 2000:
                    stringBuilder.append("<wcpayinfo>");
                    stringBuilder.append("<paysubtype>" + bVar.fhv + "</paysubtype>");
                    stringBuilder.append("<feedesc>" + bVar.fhw + "</feedesc>");
                    stringBuilder.append("<transcationid>" + bVar.fhx + "</transcationid>");
                    stringBuilder.append("<transferid>" + bVar.fhy + "</transferid>");
                    stringBuilder.append("<invalidtime>" + bVar.fhz + "</invalidtime>");
                    stringBuilder.append("<pay_memo>" + bVar.fiF + "</pay_memo>");
                    stringBuilder.append("</wcpayinfo>");
                    break;
                case 2001:
                    stringBuilder.append("<wcpayinfo>");
                    stringBuilder.append("<iconurl>" + bo.ani(bVar.fhR) + "</iconurl>");
                    stringBuilder.append("<scenetext>" + bo.ani(bVar.fhW) + "</scenetext>");
                    stringBuilder.append("<url>" + bo.ani(bVar.fhQ) + "</url>");
                    stringBuilder.append("<receivertitle>" + bo.ani(bVar.fhS) + "</receivertitle>");
                    stringBuilder.append("<sendertitle>" + bo.ani(bVar.fhT) + "</sendertitle>");
                    stringBuilder.append("<receiverdes>" + bo.ani(bVar.fhV) + "</receiverdes>");
                    stringBuilder.append("<senderdes>" + bo.ani(bVar.fhU) + "</senderdes>");
                    stringBuilder.append("<templateid>" + bo.ani(bVar.fhX) + "</templateid>");
                    stringBuilder.append("<sceneid>" + bo.ani(bVar.fhY) + "</sceneid>");
                    stringBuilder.append("<nativeurl>" + bo.ani(bVar.fhZ) + "</nativeurl>");
                    stringBuilder.append("<innertype>" + bo.ani(bVar.showType) + "</innertype>");
                    stringBuilder.append("<localtype>" + bo.ani(bVar.fia) + "</localtype>");
                    stringBuilder.append("<paymsgid>" + bo.ani(bVar.fib) + "</paymsgid>");
                    stringBuilder.append("<imageid>" + bo.ani(bVar.fic) + "</imageid>");
                    stringBuilder.append("<imageaeskey>" + bo.ani(bVar.fid) + "</imageaeskey>");
                    stringBuilder.append("<imagelength>" + bo.ani(bVar.fie) + "</imagelength>");
                    stringBuilder.append("<droptips>" + bo.ani(bVar.fig) + "</droptips>");
                    stringBuilder.append("</wcpayinfo>");
                    break;
            }
            stringBuilder.append("<appattach>");
            if (dVar == null || (bo.isNullOrNil(str) && i == 0 && i2 == 0)) {
                stringBuilder.append("<totallen>" + bVar.fgo + "</totallen>");
                stringBuilder.append("<attachid>" + bo.ani(bVar.csD) + "</attachid>");
                stringBuilder.append("<cdnattachurl>" + bo.ani(bVar.fgD) + "</cdnattachurl>");
                stringBuilder.append("<emoticonmd5>" + bo.ani(bVar.fgq) + "</emoticonmd5>");
                stringBuilder.append("<aeskey>" + bo.ani(bVar.eyr) + "</aeskey>");
                if (!(i == 0 || i2 == 0)) {
                    stringBuilder.append("<thumbheight>" + i2 + "</thumbheight>");
                    stringBuilder.append("<thumbwidth>" + i + "</thumbwidth>");
                }
            } else {
                stringBuilder.append("<attachid>" + bo.ani(str) + "</attachid>");
                if (dVar.field_fileLength > 0 && !bo.isNullOrNil(dVar.field_fileId)) {
                    stringBuilder.append("<cdnattachurl>" + bo.ani(dVar.field_fileId) + "</cdnattachurl>");
                    if (bVar.type == 19 || bVar.type == 24 || bVar.type == 4 || bVar.type == 3 || bVar.type == 7 || bVar.type == 27 || bVar.type == 26) {
                        ab.i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", Integer.valueOf(bVar.type), Integer.valueOf(dVar.field_fileLength));
                    } else {
                        stringBuilder.append("<totallen>" + dVar.field_fileLength + "</totallen>");
                    }
                }
                if (dVar.field_thumbimgLength > 0) {
                    stringBuilder.append("<cdnthumburl>" + bo.ani(dVar.field_fileId) + "</cdnthumburl>");
                    if (!bo.isNullOrNil(dVar.field_thumbfilemd5)) {
                        stringBuilder.append("<cdnthumbmd5>" + dVar.field_thumbfilemd5 + "</cdnthumbmd5>");
                    }
                    stringBuilder.append("<cdnthumblength>" + dVar.field_thumbimgLength + "</cdnthumblength>");
                    stringBuilder.append("<cdnthumbheight>" + i2 + "</cdnthumbheight>");
                    stringBuilder.append("<cdnthumbwidth>" + i + "</cdnthumbwidth>");
                    stringBuilder.append("<cdnthumbaeskey>" + dVar.field_aesKey + "</cdnthumbaeskey>");
                }
                stringBuilder.append("<aeskey>" + bo.ani(dVar.field_aesKey) + "</aeskey>");
                stringBuilder.append("<encryver>1</encryver>");
            }
            stringBuilder.append("<fileext>" + bo.ani(bVar.fgp) + "</fileext>");
            stringBuilder.append("<islargefilemsg>" + bVar.fgs + "</islargefilemsg>");
            stringBuilder.append("</appattach>");
            stringBuilder.append("<extinfo>" + bo.ani(bVar.extInfo) + "</extinfo>");
            stringBuilder.append("<androidsource>" + bVar.fgr + "</androidsource>");
            if (!bo.isNullOrNil(bVar.cMg)) {
                stringBuilder.append("<sourceusername>" + bo.ani(bVar.cMg) + "</sourceusername>");
                stringBuilder.append("<sourcedisplayname>" + bo.ani(bVar.cMh) + "</sourcedisplayname>");
                stringBuilder.append("<commenturl>" + bo.ani(bVar.dJv) + "</commenturl>");
            }
            stringBuilder.append("<thumburl>" + bo.ani(bVar.thumburl) + "</thumburl>");
            stringBuilder.append("<mediatagname>" + bo.ani(bVar.mediaTagName) + "</mediatagname>");
            stringBuilder.append("<messageaction>" + mf(bo.ani(bVar.messageAction)) + "</messageaction>");
            stringBuilder.append("<messageext>" + mf(bo.ani(bVar.messageExt)) + "</messageext>");
            stringBuilder.append("<emoticongift>");
            stringBuilder.append("<packageflag>" + bVar.fgS + "</packageflag>");
            stringBuilder.append("<packageid>" + bo.ani(bVar.fgR) + "</packageid>");
            stringBuilder.append("</emoticongift>");
            stringBuilder.append("<emoticonshared>");
            stringBuilder.append("<packageflag>" + bVar.fgY + "</packageflag>");
            stringBuilder.append("<packageid>" + bo.ani(bVar.fgX) + "</packageid>");
            stringBuilder.append("</emoticonshared>");
            stringBuilder.append("<designershared>");
            stringBuilder.append("<designeruin>" + bVar.fiD + "</designeruin>");
            stringBuilder.append("<designername>" + bVar.designerName + "</designername>");
            stringBuilder.append("<designerrediretcturl>" + bVar.designerRediretctUrl + "</designerrediretcturl>");
            stringBuilder.append("</designershared>");
            stringBuilder.append("<emotionpageshared>");
            stringBuilder.append("<tid>" + bVar.tid + "</tid>");
            stringBuilder.append("<title>" + bVar.fiE + "</title>");
            stringBuilder.append("<desc>" + bVar.desc + "</desc>");
            stringBuilder.append("<iconUrl>" + bVar.iconUrl + "</iconUrl>");
            stringBuilder.append("<secondUrl>" + bVar.secondUrl + "</secondUrl>");
            stringBuilder.append("<pageType>" + bVar.pageType + "</pageType>");
            stringBuilder.append("</emotionpageshared>");
            stringBuilder.append("<webviewshared>");
            stringBuilder.append("<shareUrlOriginal>" + bo.ani(bVar.cMj) + "</shareUrlOriginal>");
            stringBuilder.append("<shareUrlOpen>" + bo.ani(bVar.cMk) + "</shareUrlOpen>");
            stringBuilder.append("<jsAppId>" + bo.ani(bVar.cMl) + "</jsAppId>");
            stringBuilder.append("<publisherId>" + bo.ani(bVar.cMm) + "</publisherId>");
            stringBuilder.append("</webviewshared>");
            stringBuilder.append("<template_id>" + bo.ani(bVar.fhu) + "</template_id>");
            ab.i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", bVar.filemd5);
            stringBuilder.append("<md5>" + bo.ani(bVar.filemd5) + "</md5>");
            for (com.tencent.mm.ci.c cVar : c.fjp) {
                f fVar = (f) cVar.get();
                f X = bVar.X(fVar.getClass());
                if (X != null) {
                    fVar = X;
                }
                fVar.a(stringBuilder, bVar, str, dVar, i, i2);
            }
            AppMethodBeat.o(77784);
        }

        public final void a(j jVar) {
            jVar.field_appId = this.appId;
            jVar.field_title = this.title;
            jVar.field_description = this.description;
            jVar.field_type = this.type;
            jVar.field_source = this.appName;
        }

        public static String mf(String str) {
            AppMethodBeat.i(77785);
            String str2 = "<![CDATA[" + str + "]]>";
            AppMethodBeat.o(77785);
            return str2;
        }

        public final String getTitle() {
            if (this.fgl == null || this.fgl.fjk == 0) {
                return this.title;
            }
            return this.fgl.title;
        }

        public final String getDescription() {
            if (this.fgl == null || this.fgl.fjl == 0) {
                return this.description;
            }
            return this.fgl.desc;
        }
    }

    public static class c {
        private static final List<com.tencent.mm.ci.c<? extends f>> fjp = Collections.synchronizedList(new ArrayList());
        private static final HashMap<Integer, com.tencent.mm.ci.c<? extends f>> fjq = new HashMap();

        static {
            AppMethodBeat.i(77790);
            AppMethodBeat.o(77790);
        }

        public static void a(com.tencent.mm.ci.c<? extends f> cVar) {
            AppMethodBeat.i(77788);
            fjp.add(cVar);
            AppMethodBeat.o(77788);
        }

        static /* synthetic */ f kq(int i) {
            AppMethodBeat.i(77789);
            com.tencent.mm.ci.c cVar = (com.tencent.mm.ci.c) fjq.get(Integer.valueOf(i));
            if (cVar != null) {
                f fVar = (f) cVar.get();
                fVar.type = i;
                AppMethodBeat.o(77789);
                return fVar;
            }
            ab.w("MicroMsg.AppMessage", "get for type(%s) is null", Integer.valueOf(i));
            AppMethodBeat.o(77789);
            return null;
        }
    }

    public enum a {
        BUSINESS_MY_LIFE_AROUND,
        BUSINESS_OTHER,
        BUSINESS_MAX;

        static {
            AppMethodBeat.o(77770);
        }

        public static boolean isValid(int i) {
            AppMethodBeat.i(77768);
            if (i < BUSINESS_MY_LIFE_AROUND.ordinal() || i >= BUSINESS_MAX.ordinal()) {
                AppMethodBeat.o(77768);
                return false;
            }
            AppMethodBeat.o(77768);
            return true;
        }

        public static String b(int i, String str, Context context) {
            AppMethodBeat.i(77769);
            String str2 = "";
            if (isValid(i) && !bo.isNullOrNil(str)) {
                int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
                ab.d("MicroMsg.AppMessage", "id: %d.", Integer.valueOf(identifier));
                if (identifier > 0) {
                    str2 = context.getResources().getString(identifier);
                }
            }
            ab.d("MicroMsg.AppMessage", "txt: %s.", str2);
            AppMethodBeat.o(77769);
            return str2;
        }
    }

    public final com.tencent.mm.sdk.e.c.a Ag() {
        return ccO;
    }

    private static final boolean XA() {
        AppMethodBeat.i(77791);
        Field[] declaredFields = b.class.getDeclaredFields();
        int i = 0;
        for (Field modifiers : declaredFields) {
            if (!Modifier.isStatic(modifiers.getModifiers())) {
                i++;
            }
        }
        if (i > 196) {
            ab.e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", Integer.valueOf(i), Integer.valueOf(196));
            AppMethodBeat.o(77791);
            return false;
        }
        ab.i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", Integer.valueOf(i));
        AppMethodBeat.o(77791);
        return true;
    }

    static {
        AppMethodBeat.i(77792);
        com.tencent.mm.sdk.e.c.a aVar = new com.tencent.mm.sdk.e.c.a();
        aVar.xDb = new Field[7];
        aVar.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.columns[0] = "msgId";
        aVar.xDd.put("msgId", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.xDc = "msgId";
        aVar.columns[1] = BaseTemplateParser.POSTFIX_ORIG;
        aVar.xDd.put(BaseTemplateParser.POSTFIX_ORIG, "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        aVar.columns[2] = "appId";
        aVar.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        aVar.columns[3] = "title";
        aVar.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        aVar.columns[4] = "description";
        aVar.xDd.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        aVar.columns[5] = "source";
        aVar.xDd.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        aVar.columns[6] = "type";
        aVar.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        aVar.columns[7] = "rowid";
        aVar.sql = stringBuilder.toString();
        ccO = aVar;
        if (com.tencent.mm.sdk.a.b.dnO()) {
            Assert.assertTrue(XA());
        }
        AppMethodBeat.o(77792);
    }
}
