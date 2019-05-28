package com.tencent.p177mm.p181af;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.memory.p259a.C7598c;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C1183p;
import com.tencent.p177mm.p217ci.C32467c;
import com.tencent.p177mm.p230g.p711c.C26316t;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5035be;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
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

/* renamed from: com.tencent.mm.af.j */
public final class C8909j extends C26316t {
    public static C4924a ccO;

    /* renamed from: com.tencent.mm.af.j$b */
    public static class C8910b extends C37435f {
        private static final C1177f<Integer, C8910b> emX = new C7598c(100);
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
        public C8911a fgl;
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
        public int fiW = C8913a.BUSINESS_MAX.ordinal();
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
        private final HashMap<Class<? extends C37435f>, C37435f> fje = new HashMap();
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

        /* renamed from: com.tencent.mm.af.j$b$a */
        public static class C8911a {
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

        public C8910b() {
            AppMethodBeat.m2504i(77771);
            AppMethodBeat.m2505o(77771);
        }

        /* renamed from: Xz */
        public final /* synthetic */ C37435f mo20330Xz() {
            AppMethodBeat.m2504i(77786);
            C8910b XB = m16059XB();
            AppMethodBeat.m2505o(77786);
            return XB;
        }

        static {
            AppMethodBeat.m2504i(77787);
            AppMethodBeat.m2505o(77787);
        }

        /* renamed from: X */
        public final <T extends C37435f> T mo20333X(Class<T> cls) {
            AppMethodBeat.m2504i(77772);
            C37435f c37435f = (C37435f) this.fje.get(cls);
            AppMethodBeat.m2505o(77772);
            return c37435f;
        }

        /* renamed from: a */
        public final void mo20334a(C37435f c37435f) {
            AppMethodBeat.m2504i(77773);
            if (c37435f == null) {
                C4990ab.printErrStackTrace("MicroMsg.AppMessage", new NullPointerException(""), "piece is null", new Object[0]);
                AppMethodBeat.m2505o(77773);
                return;
            }
            c37435f.fge = this;
            this.fje.put(c37435f.getClass(), c37435f);
            AppMethodBeat.m2505o(77773);
        }

        /* renamed from: md */
        public static final C8910b m16063md(String str) {
            AppMethodBeat.m2504i(77774);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(77774);
                return null;
            }
            Object str2;
            int indexOf = str2.indexOf(60);
            if (indexOf > 0) {
                str2 = str2.substring(indexOf);
            }
            int hashCode = "parseImg_".concat(String.valueOf(str2)).hashCode();
            C8910b c8910b = (C8910b) emX.get(Integer.valueOf(hashCode));
            if (c8910b != null) {
                AppMethodBeat.m2505o(77774);
                return c8910b;
            }
            Map z = C5049br.m7595z(str2, "msg");
            if (z == null) {
                C4990ab.m7412e("MicroMsg.AppMessage", "parseImg failed");
                AppMethodBeat.m2505o(77774);
                return null;
            }
            C8910b c8910b2 = new C8910b();
            c8910b2.type = 2;
            c8910b2.appId = (String) z.get(".msg.appinfo.appid");
            c8910b2.axy = C5046bo.getInt((String) z.get(".msg.appinfo.version"), 0);
            c8910b2.appName = (String) z.get(".msg.appinfo.appname");
            c8910b2.mediaTagName = (String) z.get(".msg.appinfo.mediatagname");
            c8910b2.messageExt = (String) z.get(".msg.appinfo.messageext");
            c8910b2.messageAction = (String) z.get(".msg.appinfo.messageaction");
            emX.mo4412k(Integer.valueOf(hashCode), c8910b2);
            AppMethodBeat.m2505o(77774);
            return c8910b2;
        }

        /* renamed from: p */
        public final String mo20339p(Context context, boolean z) {
            AppMethodBeat.m2504i(77775);
            String str = "";
            if (mo20336cw(true)) {
                if (!C5046bo.isNullOrNil(this.fiX)) {
                    int identifier = context.getResources().getIdentifier(this.fiX, "string", context.getPackageName());
                    C4990ab.m7411d("MicroMsg.AppMessage", "id: %d.", Integer.valueOf(identifier));
                    if (identifier > 0) {
                        str = context.getResources().getString(identifier);
                    } else if (C8913a.BUSINESS_MY_LIFE_AROUND.ordinal() == this.fiW) {
                        str = "";
                    } else {
                        str = this.cMh;
                    }
                } else if (C8913a.BUSINESS_MY_LIFE_AROUND.ordinal() == this.fiW) {
                    str = "";
                } else {
                    str = this.cMh;
                }
            }
            if (z && !str.isEmpty()) {
                str = "[" + str + "]";
            }
            C4990ab.m7411d("MicroMsg.AppMessage", "txt: %s.", str);
            AppMethodBeat.m2505o(77775);
            return str;
        }

        /* renamed from: cw */
        public final boolean mo20336cw(boolean z) {
            AppMethodBeat.m2504i(77776);
            if (z) {
                if (44 == this.type && this.fiW >= C8913a.BUSINESS_MY_LIFE_AROUND.ordinal() && this.fiW < C8913a.BUSINESS_MAX.ordinal()) {
                    AppMethodBeat.m2505o(77776);
                    return true;
                }
            } else if (this.fiW >= C8913a.BUSINESS_MY_LIFE_AROUND.ordinal() && this.fiW < C8913a.BUSINESS_MAX.ordinal()) {
                AppMethodBeat.m2505o(77776);
                return true;
            }
            AppMethodBeat.m2505o(77776);
            return false;
        }

        /* renamed from: me */
        public static final C8910b m16064me(String str) {
            AppMethodBeat.m2504i(77777);
            C8910b X = C8910b.m16058X(str, null);
            AppMethodBeat.m2505o(77777);
            return X;
        }

        /* renamed from: X */
        public static final C8910b m16058X(String str, String str2) {
            AppMethodBeat.m2504i(77778);
            if (C5046bo.isNullOrNil(str)) {
                AppMethodBeat.m2505o(77778);
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
            C8910b c8910b = (C8910b) emX.get(Integer.valueOf(hashCode));
            if (c8910b != null) {
                AppMethodBeat.m2505o(77778);
                return c8910b;
            }
            Map map;
            Map z;
            long currentTimeMillis = System.currentTimeMillis();
            if (C5046bo.isNullOrNil(str2)) {
                map = null;
            } else {
                map = C5035be.amR(str2);
            }
            if (map == null) {
                z = C5049br.m7595z(substring, "msg");
            } else {
                z = map;
            }
            if (z == null) {
                C4990ab.m7412e("MicroMsg.AppMessage", "parse msg failed");
                AppMethodBeat.m2505o(77778);
                return null;
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            C8910b c8910b2 = new C8910b();
            c8910b2.fjf = z;
            c8910b2.fjg = str;
            c8910b2.fjh = substring;
            c8910b2.fji = str2;
            try {
                C37435f c37435f;
                c8910b2.mo20332a(z, c8910b2);
                for (C32467c c32467c : C8912c.fjp) {
                    c37435f = (C37435f) c32467c.get();
                    c37435f.mo20332a(z, c8910b2);
                    c8910b2.mo20334a(c37435f);
                }
                c37435f = C8912c.m16076kq(c8910b2.type);
                if (c37435f != null) {
                    c37435f.mo20332a(z, c8910b2);
                    c8910b2.mo20334a(c37435f);
                }
                emX.mo4412k(Integer.valueOf(hashCode), c8910b2);
                C4990ab.m7411d("MicroMsg.AppMessage", "parseContent, time:%d, %d, %d", Long.valueOf(currentTimeMillis2 - currentTimeMillis), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(C5046bo.nullAsNil(str2).hashCode()));
                AppMethodBeat.m2505o(77778);
                return c8910b2;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AppMessage", "parse amessage xml failed");
                C4990ab.m7413e("MicroMsg.AppMessage", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(77778);
                return null;
            }
        }

        /* renamed from: a */
        public static String m16061a(C8910b c8910b, String str, C9545d c9545d) {
            AppMethodBeat.m2504i(77779);
            C4990ab.m7417i("MicroMsg.AppMessage", "summersafecdn makeLocalContent aesKey[%s], filemd5[%s]", C5046bo.anv(c8910b.eyr), c8910b.filemd5);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<msg>");
            if (c8910b.fgJ == 0 || c8910b.fgI == 0) {
                C4990ab.m7410d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb 0");
                stringBuilder.append(C8910b.m16062a(c8910b, str, c9545d, 0, 0));
            } else {
                C4990ab.m7411d("MicroMsg.AppMessage", "summersafecdn makeLocalContent thumb[%d, %d]", Integer.valueOf(c8910b.fgJ), Integer.valueOf(c8910b.fgI));
                stringBuilder.append(C8910b.m16062a(c8910b, str, c9545d, c8910b.fgJ, c8910b.fgI));
            }
            stringBuilder.append("</msg>");
            emX.mo4412k(Integer.valueOf(stringBuilder.toString().hashCode()), c8910b);
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(77779);
            return stringBuilder2;
        }

        /* renamed from: a */
        public static String m16062a(C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
            AppMethodBeat.m2504i(77780);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("<appmsg appid=\"" + C5046bo.ani(c8910b.appId) + "\" sdkver=\"" + c8910b.sdkVer + "\">");
            c8910b.mo20331a(stringBuilder, c8910b, str, c9545d, i, i2);
            C37435f kq = C8912c.m16076kq(c8910b.type);
            if (kq != null) {
                kq.mo20331a(stringBuilder, c8910b, str, c9545d, i, i2);
            }
            stringBuilder.append("</appmsg>");
            if (2 == c8910b.showType) {
                stringBuilder.append("<ShakePageResult>").append(c8910b.fgC).append("</ShakePageResult>");
            }
            C4990ab.m7411d("MicroMsg.AppMessage", "summerbig makeContent[%s]", stringBuilder.toString());
            String stringBuilder2 = stringBuilder.toString();
            AppMethodBeat.m2505o(77780);
            return stringBuilder2;
        }

        /* renamed from: a */
        public static C8910b m16060a(C8910b c8910b) {
            AppMethodBeat.m2504i(77781);
            C8910b c8910b2;
            if (c8910b == null) {
                c8910b2 = new C8910b();
                AppMethodBeat.m2505o(77781);
                return c8910b2;
            }
            c8910b2 = c8910b.m16059XB();
            AppMethodBeat.m2505o(77781);
            return c8910b2;
        }

        /* renamed from: a */
        public final void mo20332a(Map<String, String> map, C8910b c8910b) {
            AppMethodBeat.m2504i(77782);
            try {
                this.fgm = map;
                this.appId = (String) map.get(".msg.appmsg.$appid");
                this.sdkVer = C5046bo.getInt((String) map.get(".msg.appmsg.$sdkver"), 0);
                this.title = C5046bo.amS((String) map.get(".msg.appmsg.title"));
                this.description = (String) map.get(".msg.appmsg.des");
                this.username = (String) map.get(".msg.appmsg.username");
                this.action = (String) map.get(".msg.appmsg.action");
                this.type = C5046bo.getInt((String) map.get(".msg.appmsg.type"), 0);
                this.content = (String) map.get(".msg.appmsg.content");
                this.url = (String) map.get(".msg.appmsg.url");
                this.fgn = (String) map.get(".msg.appmsg.lowurl");
                this.fgu = (String) map.get(".msg.appmsg.appattach.tpurl");
                this.fgv = (String) map.get(".msg.appmsg.appattach.tpthumburl");
                this.fgw = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.tpthumblength"), 0);
                this.fgx = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.tpthumbheight"), 0);
                this.fgy = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.tpthumbwidth"), 0);
                this.fgz = (String) map.get(".msg.appmsg.appattach.tpthumbmd5");
                this.fgA = (String) map.get(".msg.appmsg.appattach.tpauthkey");
                this.fgB = (String) map.get(".msg.appmsg.appattach.tpthumbaeskey");
                this.fgM = (String) map.get(".msg.appmsg.dataurl");
                this.fgN = (String) map.get(".msg.appmsg.lowdataurl");
                this.fgo = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.totallen"), 0);
                this.csD = (String) map.get(".msg.appmsg.appattach.attachid");
                if (!C5046bo.isNullOrNil(this.fgu)) {
                    this.csD = this.fgu;
                }
                this.fgp = C5046bo.amS((String) map.get(".msg.appmsg.appattach.fileext"));
                this.fgq = (String) map.get(".msg.appmsg.appattach.emoticonmd5");
                this.extInfo = (String) map.get(".msg.appmsg.extinfo");
                this.fgr = C5046bo.getInt((String) map.get(".msg.appmsg.androidsource"), 0);
                this.cMg = (String) map.get(".msg.appmsg.sourceusername");
                this.cMh = (String) map.get(".msg.appmsg.sourcedisplayname");
                this.dJv = (String) map.get(".msg.commenturl");
                this.thumburl = (String) map.get(".msg.appmsg.thumburl");
                this.mediaTagName = (String) map.get(".msg.appmsg.mediatagname");
                this.messageAction = (String) map.get(".msg.appmsg.messageaction");
                this.messageExt = (String) map.get(".msg.appmsg.messageext");
                this.axy = C5046bo.getInt((String) map.get(".msg.appinfo.version"), 0);
                this.appName = (String) map.get(".msg.appinfo.appname");
                this.cEV = (String) map.get(".msg.fromusername");
                this.fgD = (String) map.get(".msg.appmsg.appattach.cdnattachurl");
                this.fgE = (String) map.get(".msg.appmsg.appattach.cdnthumburl");
                this.fgF = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.cdnthumblength"), 0);
                this.fgG = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbheight"), 0);
                this.fgH = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.cdnthumbwidth"), 0);
                this.fgI = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.thumbheight"), 0);
                this.fgJ = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.thumbwidth"), 0);
                this.eyr = (String) map.get(".msg.appmsg.appattach.aeskey");
                this.fgL = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.encryver"), 1);
                this.fgK = (String) map.get(".msg.appmsg.appattach.cdnthumbaeskey");
                this.fgs = C5046bo.getInt((String) map.get(".msg.appmsg.appattach.islargefilemsg"), 0);
                if (this.fgs == 0 && this.fgo > 26214400) {
                    this.fgs = 1;
                    C4990ab.m7417i("MicroMsg.AppMessage", "summerbig content.attachlen[%d] set largefilemsg 1", Integer.valueOf(this.fgo));
                }
                this.fgP = C5046bo.getInt((String) map.get(".msg.appmsg.productitem.$type"), 0);
                this.fgQ = (String) map.get(".msg.appmsg.productitem.productinfo");
                this.fgS = C5046bo.getInt((String) map.get(".msg.appmsg.emoticongift.packageflag"), 0);
                this.fgR = (String) map.get(".msg.appmsg.emoticongift.packageid");
                this.fgX = (String) map.get(".msg.appmsg.emoticonshared.packageid");
                this.fgY = C5046bo.getInt((String) map.get(".msg.appmsg.emoticonshared.packageflag"), 0);
                this.fgT = (String) map.get(".msg.appmsg.tvinfo");
                this.fgU = (String) map.get(".msg.appmsg.recorditem");
                this.cMj = (String) map.get(".msg.appmsg.webviewshared.shareUrlOriginal");
                this.cMk = (String) map.get(".msg.appmsg.webviewshared.shareUrlOpen");
                this.cMl = (String) map.get(".msg.appmsg.webviewshared.jsAppId");
                this.cMm = (String) map.get(".msg.appmsg.webviewshared.publisherId");
                this.fiD = C1183p.m2611cB((String) map.get(".msg.appmsg.designershared.designeruin"));
                this.designerName = (String) map.get(".msg.appmsg.designershared.designername");
                this.designerRediretctUrl = (String) map.get(".msg.appmsg.designershared.designerrediretcturl");
                this.tid = C5046bo.ank((String) map.get(".msg.appmsg.emotionpageshared.tid"));
                this.fiE = (String) map.get(".msg.appmsg.emotionpageshared.title");
                this.desc = (String) map.get(".msg.appmsg.emotionpageshared.desc");
                this.iconUrl = (String) map.get(".msg.appmsg.emotionpageshared.iconUrl");
                this.secondUrl = C5046bo.m7532bc((String) map.get(".msg.appmsg.emotionpageshared.secondUrl"), "");
                this.pageType = C5046bo.ank((String) map.get(".msg.appmsg.emotionpageshared.pageType"));
                this.fiG = C5046bo.m7532bc((String) map.get(".msg.appmsg.streamvideo.streamvideourl"), "");
                this.fiH = C5046bo.ank((String) map.get(".msg.appmsg.streamvideo.streamvideototaltime"));
                this.fiI = C5046bo.m7532bc((String) map.get(".msg.appmsg.streamvideo.streamvideotitle"), "");
                this.fiJ = C5046bo.m7532bc((String) map.get(".msg.appmsg.streamvideo.streamvideowording"), "");
                this.fiK = C5046bo.m7532bc((String) map.get(".msg.appmsg.streamvideo.streamvideoweburl"), "");
                this.fiL = C5046bo.m7532bc((String) map.get(".msg.appmsg.streamvideo.streamvideothumburl"), "");
                this.fiM = C5046bo.m7532bc((String) map.get(".msg.appmsg.streamvideo.streamvideoaduxinfo"), "");
                this.fiN = C5046bo.m7532bc((String) map.get(".msg.appmsg.streamvideo.streamvideopublishid"), "");
                this.canvasPageXml = C5046bo.m7532bc((String) map.get(".msg.appmsg.canvasPageItem.canvasPageXml"), "");
                this.fiP = (String) map.get(".msg.appmsg.weappinfo.username");
                this.fiO = (String) map.get(".msg.appmsg.weappinfo.pagepath");
                this.fiQ = (String) map.get(".msg.appmsg.weappinfo.appid");
                this.fja = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.version"), 0);
                this.fiR = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.type"), 0);
                this.fiZ = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.pkginfo.type"), 0);
                this.fiS = (String) map.get(".msg.appmsg.weappinfo.pkginfo.md5");
                this.fjb = (String) map.get(".msg.appmsg.weappinfo.weappiconurl");
                this.fiU = (String) map.get(".msg.appmsg.weappinfo.shareId");
                this.fiV = (String) map.get(".msg.appmsg.weappinfo.sharekey");
                this.fiW = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.nativeappinfo.type"), C8913a.BUSINESS_MAX.ordinal());
                this.fiX = C5046bo.m7532bc((String) map.get(".msg.appmsg.weappinfo.nativeappinfo.appnamemultilanguagekey"), "");
                this.fiY = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.disableforward"), 0);
                String str = "<cache";
                String str2 = "</cache>";
                int indexOf = c8910b.fjg.indexOf(str);
                int indexOf2 = c8910b.fjg.indexOf(str2);
                if (indexOf2 - indexOf > str.length()) {
                    this.fjc = c8910b.fjg.substring(indexOf, str2.length() + indexOf2);
                }
                this.fjd = C5046bo.getInt((String) map.get(".msg.appmsg.soundtype"), 0);
                switch (this.type) {
                    case 1:
                        if (!(map.get(".msg.alphainfo.url") == null || map.get(".msg.alphainfo.md5") == null)) {
                            this.fif = true;
                            break;
                        }
                    case 13:
                        this.fgV = C5046bo.getInt((String) map.get(".msg.appmsg.mallproductitem.$type"), 0);
                        this.fgW = (String) map.get(".msg.appmsg.mallproductitem.mallproductinfo");
                        break;
                    case 16:
                        this.cDt = c8910b.fjg;
                        this.fhB = "";
                        this.fhD = C5046bo.getInt((String) map.get(".msg.appmsg.carditem.from_scene"), 2);
                        this.fhC = (String) map.get(".msg.appmsg.carditem.brand_name");
                        this.fhE = C5046bo.getInt((String) map.get(".msg.appmsg.carditem.card_type"), -1);
                        break;
                    case 34:
                        this.fhG = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.order_id"), "");
                        this.fhF = C1183p.m2611cB((String) map.get(".msg.appmsg.giftcard_info.biz_uin"));
                        this.fhH = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.app_name"), "");
                        this.fhI = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.recv_digest"), "");
                        this.fhJ = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.send_digest"), "");
                        this.fhK = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.background_pic_url"), "");
                        this.fhL = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.title_color"), "");
                        this.fhM = C5046bo.m7532bc((String) map.get(".msg.appmsg.giftcard_info.des_color"), "");
                        break;
                    case 2000:
                        this.fhv = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.paysubtype"), 0);
                        this.fhw = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.feedesc"));
                        this.fhx = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.transcationid"));
                        this.fhy = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.transferid"));
                        this.fhz = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.invalidtime"), 0);
                        this.fhA = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.effectivedate"), 3);
                        this.cKu = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.total_fee"), 0);
                        this.cuZ = C5046bo.m7532bc((String) map.get(".msg.appmsg.wcpayinfo.fee_type"), "ZAR");
                        this.fiF = C5046bo.m7532bc((String) map.get(".msg.appmsg.wcpayinfo.pay_memo"), "");
                        break;
                    case 2001:
                        String[] split;
                        this.fhR = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.iconurl"));
                        this.fhW = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.scenetext"));
                        this.fhQ = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.url"));
                        this.fhS = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.receivertitle"));
                        this.fhT = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.sendertitle"));
                        this.fhV = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.receiverdes"));
                        this.fhU = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.senderdes"));
                        this.fhX = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.templateid"));
                        this.fhY = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.sceneid"));
                        this.fhZ = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.nativeurl"));
                        this.fia = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.localtype"), 0);
                        this.fib = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.paymsgid"));
                        this.fic = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.imageid"));
                        this.fid = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.imageaeskey"));
                        this.fie = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.imagelength"), 0);
                        this.fig = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.droptips"), 0);
                        this.fih = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.billno"));
                        this.fii = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.newaatype"), 0);
                        this.fij = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.receivertitle"));
                        this.fik = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.launchertitle"));
                        this.fil = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.notinertitle"));
                        str = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.receiverlist"));
                        if (!C5046bo.isNullOrNil(str)) {
                            split = str.split("\\|");
                            if (split != null && split.length > 0) {
                                this.fim = new ArrayList();
                                this.fim.addAll(Arrays.asList(split));
                            }
                        }
                        this.fin = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.payertitle"));
                        str = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.payerlist"));
                        if (!C5046bo.isNullOrNil(str)) {
                            split = str.split("\\|");
                            if (split != null && split.length > 0) {
                                this.fio = new ArrayList();
                                this.fio.addAll(Arrays.asList(split));
                            }
                        }
                        this.fip = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.outtradeno"));
                        this.fiq = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.newaa.seq"), 0);
                        this.fir = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpayinfo.newaa.launcherusername"));
                        break;
                    case 2002:
                        this.fis = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.url"));
                        this.fit = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.templateid"));
                        this.fiu = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.iconurl"));
                        this.fiv = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.miniiconurl"));
                        this.fiw = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.backgroundurl"));
                        this.fix = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.receivertitle"));
                        this.fiy = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.sendertitle"));
                        this.fiz = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.scenetext"));
                        this.fiA = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.senderdes"));
                        this.fiB = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.receiverdes"));
                        this.fiC = C5046bo.nullAsNil((String) map.get(".msg.appmsg.wcpaythirdinfo.sceneid"));
                        break;
                }
                if (this.type != 21) {
                    if (this.type != 2001) {
                        this.showType = C5046bo.getInt((String) map.get(".msg.appmsg.showtype"), 0);
                        switch (this.showType) {
                            case 1:
                                if (C5046bo.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 0) {
                                    this.content = C5035be.m7492aS(map);
                                    break;
                                }
                                break;
                            case 2:
                                str = c8910b.fjg.toLowerCase();
                                this.fgC = c8910b.fjg.substring(str.indexOf("<ShakePageResult>".toLowerCase()) + 17, str.indexOf("</ShakePageResult>".toLowerCase()));
                                break;
                            default:
                                break;
                        }
                    }
                    this.showType = C5046bo.getInt((String) map.get(".msg.appmsg.wcpayinfo.innertype"), 0);
                } else {
                    this.showType = C5046bo.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                }
                this.cMn = (String) map.get(".msg.appmsg.statextstr");
                this.ffZ = C5046bo.getInt((String) map.get(".msg.appmsg.mmreader.category.item.itemshowtype"), 0);
                if (this.ffZ == 5 && C5046bo.getInt((String) map.get(".msg.appmsg.mmreader.category.$count"), 0) > 1) {
                    this.ffZ = 0;
                }
                this.fgO = C5046bo.getInt((String) map.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
                this.fgZ = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rank.ranktitle");
                this.fha = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.rankinfo.rankid");
                if (C5046bo.isNullOrNil(this.fha)) {
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
                this.fhn = C5046bo.getInt((String) map.get(".msg.appmsg.hardwareinfo.hardwareshowtype"), 0);
                this.fhp = C5046bo.getInt((String) map.get(".msg.appmsg.hardwareinfo.timestamp"), 0);
                this.fho = C5046bo.getInt((String) map.get(".msg.appmsg.hardwareinfo.devicetype"), 0);
                this.fhl = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.motto");
                this.fhm = (String) map.get(".msg.appmsg.hardwareinfo.rankview.championinfo.coverimgurl");
                str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.displayusername");
                this.fht = str;
                this.fhr = str;
                str = (String) map.get(".msg.appmsg.hardwareinfo.messagenodeinfo.title");
                this.fhs = str;
                this.fhq = str;
                this.fhu = C5046bo.nullAsNil((String) map.get(".msg.appmsg.template_id"));
                this.filemd5 = (String) map.get(".msg.appmsg.md5");
                this.fhN = C5046bo.getInt((String) map.get(".msg.appmsg.jumpcontrol.enable"), 0);
                this.fhO = (String) map.get(".msg.appmsg.jumpcontrol.jumpurl");
                this.fhP = (String) map.get(".msg.appmsg.jumpcontrol.pushcontent");
                Map z = C5049br.m7595z(c8910b.fjh, "msgoperation");
                if (!(this == null || z == null)) {
                    this.fgl = new C8911a();
                    this.fgl.dJE = (String) z.get(".msgoperation.expinfo.expidstr");
                    this.fgl.fjj = C5046bo.getInt((String) z.get(".msgoperation.appmsg.usedefaultthumb"), 0);
                    this.fgl.fjk = C5046bo.getInt((String) z.get(".msgoperation.appmsg.isupdatetitle"), 0);
                    this.fgl.title = (String) z.get(".msgoperation.appmsg.title");
                    this.fgl.fjl = C5046bo.getInt((String) z.get(".msgoperation.appmsg.isupdatedesc"), 0);
                    this.fgl.desc = (String) z.get(".msgoperation.appmsg.desc");
                    this.fgl.fjm = C5046bo.getInt((String) z.get(".msgoperation.appmsg.ishiddentail"), 0);
                }
                AppMethodBeat.m2505o(77782);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.AppMessage", "parse amessage xml failed");
                C4990ab.m7413e("MicroMsg.AppMessage", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(77782);
                throw e;
            }
        }

        /* renamed from: XB */
        private C8910b m16059XB() {
            AppMethodBeat.m2504i(77783);
            C8910b c8910b = new C8910b();
            if (this == null) {
                AppMethodBeat.m2505o(77783);
                return c8910b;
            }
            C4990ab.m7417i("MicroMsg.AppMessage", "summerbig cloneContent srcContent aesKey[%s], filemd5[%s], appid[%s]", C5046bo.anv(this.eyr), this.filemd5, c8910b.appId);
            c8910b.action = this.action;
            c8910b.appId = this.appId;
            c8910b.appName = this.appName;
            c8910b.axy = this.axy;
            c8910b.csD = this.csD;
            c8910b.fgo = this.fgo;
            c8910b.content = this.content;
            c8910b.description = this.description;
            c8910b.username = this.username;
            c8910b.extInfo = this.extInfo;
            c8910b.mediaTagName = this.mediaTagName;
            c8910b.messageAction = this.messageAction;
            c8910b.messageExt = this.messageExt;
            c8910b.fgr = this.fgr;
            c8910b.fgp = this.fgp;
            c8910b.cEV = this.cEV;
            c8910b.fgn = this.fgn;
            c8910b.sdkVer = this.sdkVer;
            c8910b.title = this.title;
            c8910b.type = this.type;
            c8910b.showType = this.showType;
            c8910b.ffZ = this.ffZ;
            c8910b.fgO = this.fgO;
            c8910b.url = this.url;
            c8910b.fgq = this.fgq;
            c8910b.cMg = this.cMg;
            c8910b.cMh = this.cMh;
            c8910b.dJv = this.dJv;
            c8910b.thumburl = this.thumburl;
            c8910b.fgC = this.fgC;
            c8910b.fgM = this.fgM;
            c8910b.fgN = this.fgN;
            c8910b.fgP = this.fgP;
            c8910b.fgQ = this.fgQ;
            c8910b.fgS = this.fgS;
            c8910b.fgR = this.fgR;
            c8910b.fgV = this.fgV;
            c8910b.fgW = this.fgW;
            c8910b.fgY = this.fgY;
            c8910b.fgX = this.fgX;
            c8910b.fgT = this.fgT;
            c8910b.fgU = this.fgU;
            c8910b.fhu = this.fhu;
            c8910b.cDt = this.cDt;
            c8910b.fhB = this.fhB;
            c8910b.fhC = this.fhC;
            c8910b.fhD = this.fhD;
            c8910b.fhE = this.fhD;
            c8910b.fhw = this.fhw;
            c8910b.fhz = this.fhz;
            c8910b.fhv = this.fhv;
            c8910b.fhx = this.fhx;
            c8910b.fhy = this.fhy;
            c8910b.fhN = this.fhN;
            c8910b.fhO = this.fhO;
            c8910b.fhP = this.fhP;
            c8910b.fgt = this.fgt;
            c8910b.cMj = this.cMj;
            c8910b.cMk = this.cMk;
            c8910b.cMl = this.cMl;
            c8910b.cMm = this.cMm;
            c8910b.fiF = this.fiF;
            c8910b.fiD = this.fiD;
            c8910b.designerName = this.designerName;
            c8910b.designerRediretctUrl = this.designerName;
            c8910b.tid = this.tid;
            c8910b.fiE = this.fiE;
            c8910b.desc = this.desc;
            c8910b.iconUrl = this.iconUrl;
            c8910b.secondUrl = this.secondUrl;
            c8910b.pageType = this.pageType;
            c8910b.fiG = this.fiG;
            c8910b.fiH = this.fiH;
            c8910b.fiI = this.fiI;
            c8910b.fiJ = this.fiJ;
            c8910b.fiK = this.fiK;
            c8910b.fiL = this.fiL;
            c8910b.fiM = this.fiM;
            c8910b.fiN = this.fiN;
            c8910b.canvasPageXml = this.canvasPageXml;
            c8910b.cMn = this.cMn;
            c8910b.fgD = this.fgD;
            c8910b.eyr = this.eyr;
            c8910b.filemd5 = this.filemd5;
            c8910b.fgs = this.fgs;
            c8910b.fgl = this.fgl;
            c8910b.fiO = this.fiO;
            c8910b.fiP = this.fiP;
            c8910b.fiR = this.fiR;
            c8910b.fiS = this.fiS;
            c8910b.fiZ = this.fiZ;
            c8910b.fiQ = this.fiQ;
            c8910b.fja = this.fja;
            c8910b.fjb = this.fjb;
            c8910b.fiU = this.fiU;
            c8910b.fiV = this.fiV;
            c8910b.fiW = this.fiW;
            c8910b.fiX = this.fiX;
            c8910b.fiY = this.fiY;
            c8910b.fjh = this.fjh;
            c8910b.fji = this.fji;
            c8910b.fjg = this.fjg;
            c8910b.fjf = this.fjf;
            c8910b.fgu = this.fgu;
            c8910b.fgv = this.fgv;
            c8910b.fgw = this.fgw;
            c8910b.fgx = this.fgx;
            c8910b.fgy = this.fgy;
            c8910b.fgz = this.fgz;
            c8910b.fgA = this.fgA;
            c8910b.fgB = this.fgB;
            for (Entry value : this.fje.entrySet()) {
                C37435f Xz = ((C37435f) value.getValue()).mo20330Xz();
                if (Xz != null) {
                    c8910b.mo20334a(Xz);
                }
            }
            AppMethodBeat.m2505o(77783);
            return c8910b;
        }

        /* renamed from: a */
        public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
            String str2;
            AppMethodBeat.m2504i(77784);
            stringBuilder.append("<title>" + C5046bo.ani(c8910b.title) + "</title>");
            stringBuilder.append("<des>" + C5046bo.ani(c8910b.description) + "</des>");
            stringBuilder.append("<username>" + C5046bo.ani(c8910b.username) + "</username>");
            StringBuilder stringBuilder2 = new StringBuilder("<action>");
            if (C5046bo.isNullOrNil(c8910b.action)) {
                str2 = "view";
            } else {
                str2 = C5046bo.ani(c8910b.action);
            }
            stringBuilder.append(stringBuilder2.append(str2).append("</action>").toString());
            stringBuilder.append("<type>" + c8910b.type + "</type>");
            stringBuilder.append("<showtype>").append(c8910b.showType).append("</showtype>");
            stringBuilder.append("<content>" + C5046bo.ani(c8910b.content) + "</content>");
            stringBuilder.append("<url>" + C5046bo.ani(c8910b.url) + "</url>");
            stringBuilder.append("<lowurl>" + C5046bo.ani(c8910b.fgn) + "</lowurl>");
            stringBuilder.append("<dataurl>" + C5046bo.ani(c8910b.fgM) + "</dataurl>");
            stringBuilder.append("<lowdataurl>" + C5046bo.ani(c8910b.fgN) + "</lowdataurl>");
            stringBuilder.append("<contentattr>").append(c8910b.fgt).append("</contentattr>");
            stringBuilder.append("<streamvideo>");
            stringBuilder.append("<streamvideourl>").append(C5046bo.ani(c8910b.fiG)).append("</streamvideourl>");
            stringBuilder.append("<streamvideototaltime>").append(c8910b.fiH).append("</streamvideototaltime>");
            stringBuilder.append("<streamvideotitle>").append(C5046bo.ani(c8910b.fiI)).append("</streamvideotitle>");
            stringBuilder.append("<streamvideowording>").append(C5046bo.ani(c8910b.fiJ)).append("</streamvideowording>");
            stringBuilder.append("<streamvideoweburl>").append(C5046bo.ani(c8910b.fiK)).append("</streamvideoweburl>");
            stringBuilder.append("<streamvideothumburl>").append(C5046bo.ani(c8910b.fiL)).append("</streamvideothumburl>");
            stringBuilder.append("<streamvideoaduxinfo>").append(C5046bo.ani(c8910b.fiM)).append("</streamvideoaduxinfo>");
            stringBuilder.append("<streamvideopublishid>").append(C5046bo.ani(c8910b.fiN)).append("</streamvideopublishid>");
            stringBuilder.append("</streamvideo>");
            stringBuilder.append(String.format("<canvasPageItem><canvasPageXml><![CDATA[%s]]></canvasPageXml></canvasPageItem>", new Object[]{c8910b.canvasPageXml}));
            switch (c8910b.type) {
                case 10:
                    stringBuilder.append("<productitem type=\"" + c8910b.fgP + "\">");
                    stringBuilder.append("<productinfo>" + C5046bo.ani(c8910b.fgQ) + "</productinfo>");
                    stringBuilder.append("</productitem>");
                    break;
                case 13:
                    stringBuilder.append("<mallproductitem type=\"" + c8910b.fgV + "\">");
                    stringBuilder.append("<mallproductinfo>" + C5046bo.ani(c8910b.fgW) + "</mallproductinfo>");
                    stringBuilder.append("</mallproductitem>");
                    break;
                case 16:
                    stringBuilder.append("<carditem>" + c8910b.fhB + "</carditem>");
                    break;
                case 19:
                case 24:
                    stringBuilder.append("<recorditem>" + C5046bo.ani(c8910b.fgU) + "</recorditem>");
                    break;
                case 20:
                    stringBuilder.append("<tvinfo>" + C5046bo.ani(c8910b.fgT) + "</tvinfo>");
                    break;
                case 2000:
                    stringBuilder.append("<wcpayinfo>");
                    stringBuilder.append("<paysubtype>" + c8910b.fhv + "</paysubtype>");
                    stringBuilder.append("<feedesc>" + c8910b.fhw + "</feedesc>");
                    stringBuilder.append("<transcationid>" + c8910b.fhx + "</transcationid>");
                    stringBuilder.append("<transferid>" + c8910b.fhy + "</transferid>");
                    stringBuilder.append("<invalidtime>" + c8910b.fhz + "</invalidtime>");
                    stringBuilder.append("<pay_memo>" + c8910b.fiF + "</pay_memo>");
                    stringBuilder.append("</wcpayinfo>");
                    break;
                case 2001:
                    stringBuilder.append("<wcpayinfo>");
                    stringBuilder.append("<iconurl>" + C5046bo.ani(c8910b.fhR) + "</iconurl>");
                    stringBuilder.append("<scenetext>" + C5046bo.ani(c8910b.fhW) + "</scenetext>");
                    stringBuilder.append("<url>" + C5046bo.ani(c8910b.fhQ) + "</url>");
                    stringBuilder.append("<receivertitle>" + C5046bo.ani(c8910b.fhS) + "</receivertitle>");
                    stringBuilder.append("<sendertitle>" + C5046bo.ani(c8910b.fhT) + "</sendertitle>");
                    stringBuilder.append("<receiverdes>" + C5046bo.ani(c8910b.fhV) + "</receiverdes>");
                    stringBuilder.append("<senderdes>" + C5046bo.ani(c8910b.fhU) + "</senderdes>");
                    stringBuilder.append("<templateid>" + C5046bo.ani(c8910b.fhX) + "</templateid>");
                    stringBuilder.append("<sceneid>" + C5046bo.ani(c8910b.fhY) + "</sceneid>");
                    stringBuilder.append("<nativeurl>" + C5046bo.ani(c8910b.fhZ) + "</nativeurl>");
                    stringBuilder.append("<innertype>" + C5046bo.ani(c8910b.showType) + "</innertype>");
                    stringBuilder.append("<localtype>" + C5046bo.ani(c8910b.fia) + "</localtype>");
                    stringBuilder.append("<paymsgid>" + C5046bo.ani(c8910b.fib) + "</paymsgid>");
                    stringBuilder.append("<imageid>" + C5046bo.ani(c8910b.fic) + "</imageid>");
                    stringBuilder.append("<imageaeskey>" + C5046bo.ani(c8910b.fid) + "</imageaeskey>");
                    stringBuilder.append("<imagelength>" + C5046bo.ani(c8910b.fie) + "</imagelength>");
                    stringBuilder.append("<droptips>" + C5046bo.ani(c8910b.fig) + "</droptips>");
                    stringBuilder.append("</wcpayinfo>");
                    break;
            }
            stringBuilder.append("<appattach>");
            if (c9545d == null || (C5046bo.isNullOrNil(str) && i == 0 && i2 == 0)) {
                stringBuilder.append("<totallen>" + c8910b.fgo + "</totallen>");
                stringBuilder.append("<attachid>" + C5046bo.ani(c8910b.csD) + "</attachid>");
                stringBuilder.append("<cdnattachurl>" + C5046bo.ani(c8910b.fgD) + "</cdnattachurl>");
                stringBuilder.append("<emoticonmd5>" + C5046bo.ani(c8910b.fgq) + "</emoticonmd5>");
                stringBuilder.append("<aeskey>" + C5046bo.ani(c8910b.eyr) + "</aeskey>");
                if (!(i == 0 || i2 == 0)) {
                    stringBuilder.append("<thumbheight>" + i2 + "</thumbheight>");
                    stringBuilder.append("<thumbwidth>" + i + "</thumbwidth>");
                }
            } else {
                stringBuilder.append("<attachid>" + C5046bo.ani(str) + "</attachid>");
                if (c9545d.field_fileLength > 0 && !C5046bo.isNullOrNil(c9545d.field_fileId)) {
                    stringBuilder.append("<cdnattachurl>" + C5046bo.ani(c9545d.field_fileId) + "</cdnattachurl>");
                    if (c8910b.type == 19 || c8910b.type == 24 || c8910b.type == 4 || c8910b.type == 3 || c8910b.type == 7 || c8910b.type == 27 || c8910b.type == 26) {
                        C4990ab.m7417i("MicroMsg.AppMessage", "summersafecdn content.type[%d], len[%d] but not set", Integer.valueOf(c8910b.type), Integer.valueOf(c9545d.field_fileLength));
                    } else {
                        stringBuilder.append("<totallen>" + c9545d.field_fileLength + "</totallen>");
                    }
                }
                if (c9545d.field_thumbimgLength > 0) {
                    stringBuilder.append("<cdnthumburl>" + C5046bo.ani(c9545d.field_fileId) + "</cdnthumburl>");
                    if (!C5046bo.isNullOrNil(c9545d.field_thumbfilemd5)) {
                        stringBuilder.append("<cdnthumbmd5>" + c9545d.field_thumbfilemd5 + "</cdnthumbmd5>");
                    }
                    stringBuilder.append("<cdnthumblength>" + c9545d.field_thumbimgLength + "</cdnthumblength>");
                    stringBuilder.append("<cdnthumbheight>" + i2 + "</cdnthumbheight>");
                    stringBuilder.append("<cdnthumbwidth>" + i + "</cdnthumbwidth>");
                    stringBuilder.append("<cdnthumbaeskey>" + c9545d.field_aesKey + "</cdnthumbaeskey>");
                }
                stringBuilder.append("<aeskey>" + C5046bo.ani(c9545d.field_aesKey) + "</aeskey>");
                stringBuilder.append("<encryver>1</encryver>");
            }
            stringBuilder.append("<fileext>" + C5046bo.ani(c8910b.fgp) + "</fileext>");
            stringBuilder.append("<islargefilemsg>" + c8910b.fgs + "</islargefilemsg>");
            stringBuilder.append("</appattach>");
            stringBuilder.append("<extinfo>" + C5046bo.ani(c8910b.extInfo) + "</extinfo>");
            stringBuilder.append("<androidsource>" + c8910b.fgr + "</androidsource>");
            if (!C5046bo.isNullOrNil(c8910b.cMg)) {
                stringBuilder.append("<sourceusername>" + C5046bo.ani(c8910b.cMg) + "</sourceusername>");
                stringBuilder.append("<sourcedisplayname>" + C5046bo.ani(c8910b.cMh) + "</sourcedisplayname>");
                stringBuilder.append("<commenturl>" + C5046bo.ani(c8910b.dJv) + "</commenturl>");
            }
            stringBuilder.append("<thumburl>" + C5046bo.ani(c8910b.thumburl) + "</thumburl>");
            stringBuilder.append("<mediatagname>" + C5046bo.ani(c8910b.mediaTagName) + "</mediatagname>");
            stringBuilder.append("<messageaction>" + C8910b.m16065mf(C5046bo.ani(c8910b.messageAction)) + "</messageaction>");
            stringBuilder.append("<messageext>" + C8910b.m16065mf(C5046bo.ani(c8910b.messageExt)) + "</messageext>");
            stringBuilder.append("<emoticongift>");
            stringBuilder.append("<packageflag>" + c8910b.fgS + "</packageflag>");
            stringBuilder.append("<packageid>" + C5046bo.ani(c8910b.fgR) + "</packageid>");
            stringBuilder.append("</emoticongift>");
            stringBuilder.append("<emoticonshared>");
            stringBuilder.append("<packageflag>" + c8910b.fgY + "</packageflag>");
            stringBuilder.append("<packageid>" + C5046bo.ani(c8910b.fgX) + "</packageid>");
            stringBuilder.append("</emoticonshared>");
            stringBuilder.append("<designershared>");
            stringBuilder.append("<designeruin>" + c8910b.fiD + "</designeruin>");
            stringBuilder.append("<designername>" + c8910b.designerName + "</designername>");
            stringBuilder.append("<designerrediretcturl>" + c8910b.designerRediretctUrl + "</designerrediretcturl>");
            stringBuilder.append("</designershared>");
            stringBuilder.append("<emotionpageshared>");
            stringBuilder.append("<tid>" + c8910b.tid + "</tid>");
            stringBuilder.append("<title>" + c8910b.fiE + "</title>");
            stringBuilder.append("<desc>" + c8910b.desc + "</desc>");
            stringBuilder.append("<iconUrl>" + c8910b.iconUrl + "</iconUrl>");
            stringBuilder.append("<secondUrl>" + c8910b.secondUrl + "</secondUrl>");
            stringBuilder.append("<pageType>" + c8910b.pageType + "</pageType>");
            stringBuilder.append("</emotionpageshared>");
            stringBuilder.append("<webviewshared>");
            stringBuilder.append("<shareUrlOriginal>" + C5046bo.ani(c8910b.cMj) + "</shareUrlOriginal>");
            stringBuilder.append("<shareUrlOpen>" + C5046bo.ani(c8910b.cMk) + "</shareUrlOpen>");
            stringBuilder.append("<jsAppId>" + C5046bo.ani(c8910b.cMl) + "</jsAppId>");
            stringBuilder.append("<publisherId>" + C5046bo.ani(c8910b.cMm) + "</publisherId>");
            stringBuilder.append("</webviewshared>");
            stringBuilder.append("<template_id>" + C5046bo.ani(c8910b.fhu) + "</template_id>");
            C4990ab.m7417i("MicroMsg.AppMessage", "summerbig makecontent content md5[%s]", c8910b.filemd5);
            stringBuilder.append("<md5>" + C5046bo.ani(c8910b.filemd5) + "</md5>");
            for (C32467c c32467c : C8912c.fjp) {
                C37435f c37435f = (C37435f) c32467c.get();
                C37435f X = c8910b.mo20333X(c37435f.getClass());
                if (X != null) {
                    c37435f = X;
                }
                c37435f.mo20331a(stringBuilder, c8910b, str, c9545d, i, i2);
            }
            AppMethodBeat.m2505o(77784);
        }

        /* renamed from: a */
        public final void mo20335a(C8909j c8909j) {
            c8909j.field_appId = this.appId;
            c8909j.field_title = this.title;
            c8909j.field_description = this.description;
            c8909j.field_type = this.type;
            c8909j.field_source = this.appName;
        }

        /* renamed from: mf */
        public static String m16065mf(String str) {
            AppMethodBeat.m2504i(77785);
            String str2 = "<![CDATA[" + str + "]]>";
            AppMethodBeat.m2505o(77785);
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

    /* renamed from: com.tencent.mm.af.j$c */
    public static class C8912c {
        private static final List<C32467c<? extends C37435f>> fjp = Collections.synchronizedList(new ArrayList());
        private static final HashMap<Integer, C32467c<? extends C37435f>> fjq = new HashMap();

        static {
            AppMethodBeat.m2504i(77790);
            AppMethodBeat.m2505o(77790);
        }

        /* renamed from: a */
        public static void m16075a(C32467c<? extends C37435f> c32467c) {
            AppMethodBeat.m2504i(77788);
            fjp.add(c32467c);
            AppMethodBeat.m2505o(77788);
        }

        /* renamed from: kq */
        static /* synthetic */ C37435f m16076kq(int i) {
            AppMethodBeat.m2504i(77789);
            C32467c c32467c = (C32467c) fjq.get(Integer.valueOf(i));
            if (c32467c != null) {
                C37435f c37435f = (C37435f) c32467c.get();
                c37435f.type = i;
                AppMethodBeat.m2505o(77789);
                return c37435f;
            }
            C4990ab.m7421w("MicroMsg.AppMessage", "get for type(%s) is null", Integer.valueOf(i));
            AppMethodBeat.m2505o(77789);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.af.j$a */
    public enum C8913a {
        BUSINESS_MY_LIFE_AROUND,
        BUSINESS_OTHER,
        BUSINESS_MAX;

        static {
            AppMethodBeat.m2505o(77770);
        }

        public static boolean isValid(int i) {
            AppMethodBeat.m2504i(77768);
            if (i < BUSINESS_MY_LIFE_AROUND.ordinal() || i >= BUSINESS_MAX.ordinal()) {
                AppMethodBeat.m2505o(77768);
                return false;
            }
            AppMethodBeat.m2505o(77768);
            return true;
        }

        /* renamed from: b */
        public static String m16077b(int i, String str, Context context) {
            AppMethodBeat.m2504i(77769);
            String str2 = "";
            if (C8913a.isValid(i) && !C5046bo.isNullOrNil(str)) {
                int identifier = context.getResources().getIdentifier(str, "string", context.getPackageName());
                C4990ab.m7411d("MicroMsg.AppMessage", "id: %d.", Integer.valueOf(identifier));
                if (identifier > 0) {
                    str2 = context.getResources().getString(identifier);
                }
            }
            C4990ab.m7411d("MicroMsg.AppMessage", "txt: %s.", str2);
            AppMethodBeat.m2505o(77769);
            return str2;
        }
    }

    /* renamed from: Ag */
    public final C4924a mo4635Ag() {
        return ccO;
    }

    /* renamed from: XA */
    private static final boolean m16056XA() {
        AppMethodBeat.m2504i(77791);
        Field[] declaredFields = C8910b.class.getDeclaredFields();
        int i = 0;
        for (Field modifiers : declaredFields) {
            if (!Modifier.isStatic(modifiers.getModifiers())) {
                i++;
            }
        }
        if (i > 196) {
            C4990ab.m7413e("MicroMsg.AppMessage", "AppMessage.Content should not add new field!!! (%d) is over the limit(%d)!!!", Integer.valueOf(i), Integer.valueOf(196));
            AppMethodBeat.m2505o(77791);
            return false;
        }
        C4990ab.m7417i("MicroMsg.AppMessage", "AppMessage.Content nonStaticFieldCount: %d", Integer.valueOf(i));
        AppMethodBeat.m2505o(77791);
        return true;
    }

    static {
        AppMethodBeat.m2504i(77792);
        C4924a c4924a = new C4924a();
        c4924a.xDb = new Field[7];
        c4924a.columns = new String[8];
        StringBuilder stringBuilder = new StringBuilder();
        c4924a.columns[0] = "msgId";
        c4924a.xDd.put("msgId", "LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
        stringBuilder.append(", ");
        c4924a.xDc = "msgId";
        c4924a.columns[1] = BaseTemplateParser.POSTFIX_ORIG;
        c4924a.xDd.put(BaseTemplateParser.POSTFIX_ORIG, "TEXT");
        stringBuilder.append(" xml TEXT");
        stringBuilder.append(", ");
        c4924a.columns[2] = "appId";
        c4924a.xDd.put("appId", "TEXT");
        stringBuilder.append(" appId TEXT");
        stringBuilder.append(", ");
        c4924a.columns[3] = "title";
        c4924a.xDd.put("title", "TEXT");
        stringBuilder.append(" title TEXT");
        stringBuilder.append(", ");
        c4924a.columns[4] = "description";
        c4924a.xDd.put("description", "TEXT");
        stringBuilder.append(" description TEXT");
        stringBuilder.append(", ");
        c4924a.columns[5] = "source";
        c4924a.xDd.put("source", "TEXT");
        stringBuilder.append(" source TEXT");
        stringBuilder.append(", ");
        c4924a.columns[6] = "type";
        c4924a.xDd.put("type", "INTEGER");
        stringBuilder.append(" type INTEGER");
        c4924a.columns[7] = "rowid";
        c4924a.sql = stringBuilder.toString();
        ccO = c4924a;
        if (C4872b.dnO()) {
            Assert.assertTrue(C8909j.m16056XA());
        }
        AppMethodBeat.m2505o(77792);
    }
}
