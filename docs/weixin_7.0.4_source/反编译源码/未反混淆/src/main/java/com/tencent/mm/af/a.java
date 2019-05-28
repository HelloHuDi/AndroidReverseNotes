package com.tencent.mm.af;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;

public class a extends f {
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

    public final f Xz() {
        AppMethodBeat.i(51119);
        a aVar = new a();
        aVar.feY = this.feY;
        aVar.feZ = this.feZ;
        aVar.ffa = this.ffa;
        aVar.ffb = this.ffb;
        aVar.ffc = this.ffc;
        aVar.ffd = this.ffd;
        aVar.ffe = this.ffe;
        aVar.fff = this.fff;
        aVar.ffg = this.ffg;
        aVar.ffi = this.ffi;
        aVar.ffj = this.ffj;
        aVar.ffk = this.ffk;
        aVar.ffo = this.ffo;
        aVar.ffn = this.ffn;
        aVar.videoSource = this.videoSource;
        aVar.appThumbUrl = this.appThumbUrl;
        aVar.ffp = this.ffp;
        AppMethodBeat.o(51119);
        return aVar;
    }

    public final void a(StringBuilder stringBuilder, b bVar, String str, d dVar, int i, int i2) {
        AppMethodBeat.i(51120);
        stringBuilder.append("<weappinfo>");
        if (!bo.isNullOrNil(bVar.fiO)) {
            stringBuilder.append("<pagepath>" + b.mf(bVar.fiO) + "</pagepath>");
        }
        stringBuilder.append("<username>" + bo.ani(bVar.fiP) + "</username>");
        stringBuilder.append("<appid>" + bo.ani(bVar.fiQ) + "</appid>");
        if (bVar.fja != 0) {
            stringBuilder.append("<version>" + bVar.fja + "</version>");
        }
        if (bVar.fiR != 0) {
            stringBuilder.append("<type>" + bVar.fiR + "</type>");
        }
        if (!bo.isNullOrNil(bVar.fjb)) {
            stringBuilder.append("<weappiconurl>" + b.mf(bVar.fjb) + "</weappiconurl>");
        }
        if (!bo.isNullOrNil(bVar.fiU)) {
            stringBuilder.append("<shareId>" + b.mf(bVar.fiU) + "</shareId>");
        }
        if (bVar.fiZ == 1 || bVar.fiZ == 2) {
            stringBuilder.append("<pkginfo>");
            stringBuilder.append("<type>");
            stringBuilder.append(bVar.fiZ);
            stringBuilder.append("</type>");
            stringBuilder.append("<md5>");
            stringBuilder.append(bVar.fiS);
            stringBuilder.append("</md5>");
            stringBuilder.append("</pkginfo>");
        }
        if (!bo.isNullOrNil(bVar.fiV)) {
            stringBuilder.append("<sharekey>" + b.mf(bVar.fiV) + "</sharekey>");
        }
        if (!bo.isNullOrNil(this.ffk)) {
            stringBuilder.append("<messageextradata>").append(b.mf(this.ffk)).append("</messageextradata>");
        }
        if (this.feY) {
            stringBuilder.append("<wadynamicpageinfo>");
            stringBuilder.append("<shouldUseDynamicPage>1</shouldUseDynamicPage>");
            stringBuilder.append("<cacheKey>");
            stringBuilder.append(b.mf(this.feZ));
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
            stringBuilder.append(b.mf(this.ffc));
            stringBuilder.append("</updatablemsgcontent>");
            stringBuilder.append("<updatablemsgcontentcolor>");
            stringBuilder.append(b.mf(this.ffd));
            stringBuilder.append("</updatablemsgcontentcolor>");
            stringBuilder.append("<subscribeentrycontent>");
            stringBuilder.append(b.mf(this.ffe));
            stringBuilder.append("</subscribeentrycontent>");
            stringBuilder.append("<subscribeentrybuttonwording>");
            stringBuilder.append(b.mf(this.fff));
            stringBuilder.append("</subscribeentrybuttonwording>");
            stringBuilder.append("<subscribeconfirmedcontent>");
            stringBuilder.append(b.mf(this.ffg));
            stringBuilder.append("</subscribeconfirmedcontent>");
            stringBuilder.append("<expiredsubscribewording>");
            stringBuilder.append(b.mf(this.ffh));
            stringBuilder.append("</expiredsubscribewording>");
            stringBuilder.append("</waupdatablemsginfov3>");
        }
        stringBuilder.append("<appservicetype>" + this.ffa + "</appservicetype>");
        if (bVar.fiY != 0) {
            stringBuilder.append("<disableforward>" + bVar.fiY + "</disableforward>");
        }
        if (bVar.cw(true)) {
            stringBuilder.append("<nativeappinfo>");
            stringBuilder.append("<type>" + bVar.fiW + "</type>");
            stringBuilder.append("<appnamemultilanguagekey>" + b.mf(bVar.fiX) + "</appnamemultilanguagekey>");
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
        if (!bo.isNullOrNil(this.videoSource)) {
            stringBuilder.append("<videosource>" + b.mf(this.videoSource) + "</videosource>");
        }
        if (!bo.isNullOrNil(this.appThumbUrl)) {
            stringBuilder.append("<appthumburl>" + b.mf(this.appThumbUrl) + "</appthumburl>");
        }
        stringBuilder.append("<fromopensdk>" + this.ffp + "</fromopensdk>");
        stringBuilder.append("</videopageinfo>");
        stringBuilder.append("</weappinfo>");
        AppMethodBeat.o(51120);
    }

    public final void a(Map<String, String> map, b bVar) {
        boolean z;
        AppMethodBeat.i(51121);
        this.feY = bo.getInt((String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.shouldUseDynamicPage"), 0) == 1;
        this.feZ = (String) map.get(".msg.appmsg.weappinfo.wadynamicpageinfo.cacheKey");
        this.ffa = bo.getInt((String) map.get(".msg.appmsg.weappinfo.appservicetype"), this.ffa);
        this.ffk = (String) map.get(".msg.appmsg.weappinfo.messageextradata");
        if (bo.getInt((String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.shoulduseupdatablemsg"), 0) == 1) {
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
        this.ffj = bo.getInt((String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgstate"), 1);
        this.ffi = (int) bo.getLong((String) map.get(".msg.appmsg.weappinfo.waupdatablemsginfov3.updatablemsgperiod"), 10);
        this.ffn = bo.getInt((String) map.get(".msg.appmsg.weappinfo.videopageinfo.thumbwidth"), 0);
        this.ffo = bo.getInt((String) map.get(".msg.appmsg.weappinfo.videopageinfo.thumbheight"), 0);
        this.videoSource = (String) map.get(".msg.appmsg.weappinfo.videopageinfo.videosource");
        this.appThumbUrl = (String) map.get(".msg.appmsg.weappinfo.videopageinfo.appthumburl");
        this.ffp = bo.getInt((String) map.get(".msg.appmsg.weappinfo.videopageinfo.fromopensdk"), 0);
        AppMethodBeat.o(51121);
    }
}
