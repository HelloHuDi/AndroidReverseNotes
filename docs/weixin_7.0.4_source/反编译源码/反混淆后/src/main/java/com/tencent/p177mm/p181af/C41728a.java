package com.tencent.p177mm.p181af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p235i.C9545d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;

/* renamed from: com.tencent.mm.af.a */
public class C41728a extends C37435f {
    public String appThumbUrl;
    public boolean feY;
    public String feZ;
    public int ffa;
    public boolean ffb;
    public String ffc;
    public String ffd;
    public String ffe;
    public String fff;
    public String ffg;
    public String ffh;
    public int ffi;
    public int ffj;
    public String ffk;
    public String ffl;
    public boolean ffm;
    public int ffn;
    public int ffo;
    public int ffp = 0;
    public String videoSource;

    /* renamed from: Xz */
    public final C37435f mo20330Xz() {
        AppMethodBeat.m2504i(51119);
        C41728a c41728a = new C41728a();
        c41728a.feY = this.feY;
        c41728a.feZ = this.feZ;
        c41728a.ffa = this.ffa;
        c41728a.ffb = this.ffb;
        c41728a.ffc = this.ffc;
        c41728a.ffd = this.ffd;
        c41728a.ffe = this.ffe;
        c41728a.fff = this.fff;
        c41728a.ffg = this.ffg;
        c41728a.ffi = this.ffi;
        c41728a.ffj = this.ffj;
        c41728a.ffk = this.ffk;
        c41728a.ffo = this.ffo;
        c41728a.ffn = this.ffn;
        c41728a.videoSource = this.videoSource;
        c41728a.appThumbUrl = this.appThumbUrl;
        c41728a.ffp = this.ffp;
        AppMethodBeat.m2505o(51119);
        return c41728a;
    }

    /* renamed from: a */
    public final void mo20331a(StringBuilder stringBuilder, C8910b c8910b, String str, C9545d c9545d, int i, int i2) {
        AppMethodBeat.m2504i(51120);
        stringBuilder.append("<weappinfo>");
        if (!C5046bo.isNullOrNil(c8910b.fiO)) {
            stringBuilder.append("<pagepath>" + C8910b.m16065mf(c8910b.fiO) + "</pagepath>");
        }
        stringBuilder.append("<username>" + C5046bo.ani(c8910b.fiP) + "</username>");
        stringBuilder.append("<appid>" + C5046bo.ani(c8910b.fiQ) + "</appid>");
        if (c8910b.fja != 0) {
            stringBuilder.append("<version>" + c8910b.fja + "</version>");
        }
        if (c8910b.fiR != 0) {
            stringBuilder.append("<type>" + c8910b.fiR + "</type>");
        }
        if (!C5046bo.isNullOrNil(c8910b.fjb)) {
            stringBuilder.append("<weappiconurl>" + C8910b.m16065mf(c8910b.fjb) + "</weappiconurl>");
        }
        if (!C5046bo.isNullOrNil(c8910b.fiU)) {
            stringBuilder.append("<shareId>" + C8910b.m16065mf(c8910b.fiU) + "</shareId>");
        }
        if (c8910b.fiZ == 1 || c8910b.fiZ == 2) {
            stringBuilder.append("<pkginfo>");
            stringBuilder.append("<type>");
            stringBuilder.append(c8910b.fiZ);
            stringBuilder.append("</type>");
            stringBuilder.append("<md5>");
            stringBuilder.append(c8910b.fiS);
            stringBuilder.append("</md5>");
            stringBuilder.append("</pkginfo>");
        }
        if (!C5046bo.isNullOrNil(c8910b.fiV)) {
            stringBuilder.append("<sharekey>" + C8910b.m16065mf(c8910b.fiV) + "</sharekey>");
        }
        if (!C5046bo.isNullOrNil(this.ffk)) {
            stringBuilder.append("<messageextradata>").append(C8910b.m16065mf(this.ffk)).append("</messageextradata>");
        }
        if (this.feY) {
            stringBuilder.append("<wadynamicpageinfo>");
            stringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
            stringBuilder.append("<cacheKey>");
            stringBuilder.append(C8910b.m16065mf(this.feZ));
            stringBuilder.append("</cacheKey>");
            stringBuilder.append("</wadynamicpageinfo>");
        }
        if (this.ffb) {
            stringBuilder.append("<waupdatablemsginfov3>");
            stringBuilder.append("<shoulduseupdatablemsg>1</shoulduseupdatablemsg>");
            stringBuilder.append("<updatablemsgperiod>");
            stringBuilder.append(this.ffi);
            stringBuilder.append("</updatablemsgperiod>");
            stringBuilder.append("<updatablemsgstate>");
            stringBuilder.append(this.ffj);
            stringBuilder.append("</updatablemsgstate>");
            stringBuilder.append("<updatablemsgcontent>");
            stringBuilder.append(C8910b.m16065mf(this.ffc));
            stringBuilder.append("</updatablemsgcontent>");
            stringBuilder.append("<updatablemsgcontentcolor>");
            stringBuilder.append(C8910b.m16065mf(this.ffd));
            stringBuilder.append("</updatablemsgcontentcolor>");
            stringBuilder.append("<subscribeentrycontent>");
            stringBuilder.append(C8910b.m16065mf(this.ffe));
            stringBuilder.append("</subscribeentrycontent>");
            stringBuilder.append("<subscribeentrybuttonwording>");
            stringBuilder.append(C8910b.m16065mf(this.fff));
            stringBuilder.append("</subscribeentrybuttonwording>");
            stringBuilder.append("<subscribeconfirmedcontent>");
            stringBuilder.append(C8910b.m16065mf(this.ffg));
            stringBuilder.append("</subscribeconfirmedcontent>");
            stringBuilder.append("<expiredsubscribewording>");
            stringBuilder.append(C8910b.m16065mf(this.ffh));
            stringBuilder.append("</expiredsubscribewording>");
            stringBuilder.append("</waupdatablemsginfov3>");
        }
        stringBuilder.append("<appservicetype>" + this.ffa + "</appservicetype>");
        if (c8910b.fiY != 0) {
            stringBuilder.append("<disableforward>" + c8910b.fiY + "</disableforward>");
        }
        if (c8910b.mo20336cw(true)) {
            stringBuilder.append("<nativeappinfo>");
            stringBuilder.append("<type>" + c8910b.fiW + "</type>");
            stringBuilder.append("<appnamemultilanguagekey>" + C8910b.m16065mf(c8910b.fiX) + "</appnamemultilanguagekey>");
            stringBuilder.append("</nativeappinfo>");
        }
        stringBuilder.append("<videopageinfo>");
        StringBuilder stringBuilder2 = new StringBuilder("<thumbwidth>");
        if (i == 0) {
            i = this.ffn;
        }
        stringBuilder.append(stringBuilder2.append(i).append("</thumbwidth>").toString());
        stringBuilder2 = new StringBuilder("<thumbheight>");
        if (i2 == 0) {
            i2 = this.ffo;
        }
        stringBuilder.append(stringBuilder2.append(i2).append("</thumbheight>").toString());
        if (!C5046bo.isNullOrNil(this.videoSource)) {
            stringBuilder.append("<videosource>" + C8910b.m16065mf(this.videoSource) + "</videosource>");
        }
        if (!C5046bo.isNullOrNil(this.appThumbUrl)) {
            stringBuilder.append("<appthumburl>" + C8910b.m16065mf(this.appThumbUrl) + "</appthumburl>");
        }
        stringBuilder.append("<fromopensdk>" + this.ffp + "</fromopensdk>");
        stringBuilder.append("</videopageinfo>");
        stringBuilder.append("</weappinfo>");
        AppMethodBeat.m2505o(51120);
    }

    /* renamed from: a */
    public final void mo20332a(Map<String, String> map, C8910b c8910b) {
        boolean z;
        AppMethodBeat.m2504i(51121);
        this.feY = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1;
        this.feZ = (String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey");
        this.ffa = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.appservicetype"), this.ffa);
        this.ffk = (String) map.get(".msg.appmsg.weappinfo.messageextradata");
        if (C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) == 1) {
            z = true;
        } else {
            z = false;
        }
        this.ffb = z;
        this.ffc = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontent");
        this.ffd = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgcontentcolor");
        this.ffe = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrycontent");
        this.fff = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeentrybuttonwording");
        this.ffg = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.subscribeconfirmedcontent");
        this.ffh = (String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.expiredsubscribewording");
        this.ffj = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
        this.ffi = (int) C5046bo.getLong((String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10);
        this.ffn = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
        this.ffo = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
        this.videoSource = (String) map.get(".msg.appmsg.weappinfo.videopageinfo.videosource");
        this.appThumbUrl = (String) map.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl");
        this.ffp = C5046bo.getInt((String) map.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
        AppMethodBeat.m2505o(51121);
    }
}
