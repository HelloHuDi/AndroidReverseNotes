package com.tencent.mm.af;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.f;
import com.tencent.mm.a.h;
import com.tencent.mm.af.j.b;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.j;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.d;
import com.tencent.mm.plugin.biz.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.t;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TimeZone;

public final class l {
    private static final f<Long, o> emX = new h(50);

    public static boolean mg(String str) {
        AppMethodBeat.i(11211);
        if (str == null || !str.endsWith("@app")) {
            AppMethodBeat.o(11211);
            return false;
        }
        AppMethodBeat.o(11211);
        return true;
    }

    public static String mh(String str) {
        AppMethodBeat.i(11212);
        Map z = br.z(str, "msg");
        String str2;
        if (z == null) {
            ab.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
            str2 = " ";
            AppMethodBeat.o(11212);
            return str2;
        }
        bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        bo.bc((String) z.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        str2 = bo.nullAsNil((String) z.get(".msg.appmsg.title"));
        if (bo.isNullOrNil(str2)) {
            str2 = (String) z.get(".msg.appmsg.mmreader.category.item.title");
        }
        if (bo.isNullOrNil(str2)) {
            str2 = " ";
        }
        AppMethodBeat.o(11212);
        return str2;
    }

    public static String mi(String str) {
        AppMethodBeat.i(11213);
        Map amR = be.amR(str);
        String stringBuilder;
        if (amR == null) {
            o oVar = new o();
            StringBuilder stringBuilder2 = new StringBuilder("");
            Iterator it = oVar.fjr.iterator();
            while (it.hasNext()) {
                p pVar = (p) it.next();
                if (!bo.isNullOrNil(pVar.title)) {
                    stringBuilder2.append(pVar.title);
                    break;
                }
            }
            stringBuilder = stringBuilder2.toString();
            AppMethodBeat.o(11213);
            return stringBuilder;
        }
        stringBuilder = (String) amR.get(".msg.appmsg.mmreader.category.item.title");
        if (stringBuilder == null) {
            stringBuilder = "";
            AppMethodBeat.o(11213);
            return stringBuilder;
        }
        AppMethodBeat.o(11213);
        return stringBuilder;
    }

    static {
        AppMethodBeat.i(11221);
        AppMethodBeat.o(11221);
    }

    public static o b(long j, String str) {
        o oVar;
        AppMethodBeat.i(11214);
        if (j > 0) {
            oVar = (o) emX.get(Long.valueOf(j));
            if (oVar != null) {
                AppMethodBeat.o(11214);
                return oVar;
            }
        }
        Map amR = be.amR(str);
        if (amR == null) {
            oVar = new o();
            AppMethodBeat.o(11214);
            return oVar;
        }
        int i = bo.getInt((String) amR.get(".msg.appmsg.mmreader.category.$type"), 0);
        String nullAsNil = bo.nullAsNil((String) amR.get(".msg.appmsg.mmreader.name"));
        int i2 = bo.getInt((String) amR.get(".msg.appmsg.mmreader.forbid_forward"), 0);
        int i3 = bo.getInt((String) amR.get(".msg.appmsg.mmreader.category.$count"), 0);
        String str2 = (String) amR.get(".msg.commenturl");
        o oVar2 = new o();
        oVar2.type = i;
        oVar2.name = nullAsNil;
        oVar2.dJv = str2;
        oVar2.fjs = i2;
        i = 0;
        while (i < i3) {
            p pVar = new p();
            String str3 = ".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i));
            pVar.title = (String) amR.get(str3 + ".title");
            pVar.url = (String) amR.get(str3 + ".url");
            pVar.fjv = (String) amR.get(str3 + ".shorturl");
            pVar.fjw = (String) amR.get(str3 + ".longurl");
            pVar.time = bo.getLong((String) amR.get(str3 + ".pub_time"), 0);
            pVar.fjy = (String) amR.get(str3 + ".tweetid");
            pVar.fjz = (String) amR.get(str3 + ".digest");
            pVar.type = bo.getInt((String) amR.get(str3 + ".itemshowtype"), 0);
            pVar.fjB = bo.getInt((String) amR.get(str3 + ".play_length"), 0);
            pVar.fjx = (String) amR.get(str3 + ".cover");
            str2 = (String) amR.get(str3 + ".cover_235_1");
            if ((pVar.type != 5 && !bo.isNullOrNil(str2)) || bo.isNullOrNil(pVar.fjx)) {
                pVar.fjx = str2;
            }
            pVar.fjO = (String) amR.get(str3 + ".cover_1_1");
            pVar.fjA = bo.getInt((String) amR.get(str3 + ".del_flag"), 0);
            pVar.fjC = (String) amR.get(str3 + ".weapp_username");
            pVar.fjD = (String) amR.get(str3 + ".weapp_path");
            pVar.fjE = bo.getInt((String) amR.get(str3 + ".weapp_version"), 0);
            pVar.fjF = bo.getInt((String) amR.get(str3 + ".weapp_state"), 0);
            pVar.fjG = (String) amR.get(str3 + ".weapp_appid");
            pVar.fjH = (String) amR.get(str3 + ".weapp_image_url");
            pVar.fjI = (String) amR.get(str3 + ".weapp_icon");
            pVar.fjJ = (String) amR.get(str3 + ".weapp_nickname");
            pVar.fjK = (String) amR.get(str3 + ".play_url");
            pVar.fjL = (String) amR.get(str3 + ".player");
            pVar.fjM = bo.getInt((String) amR.get(str3 + ".music_source"), 1);
            pVar.fjN = bo.getInt((String) amR.get(str3 + ".pic_num"), 1);
            pVar.videoWidth = bo.getInt((String) amR.get(str3 + ".video_width"), 0);
            pVar.videoHeight = bo.getInt((String) amR.get(str3 + ".video_height"), 0);
            pVar.fgd = (String) amR.get(str3 + ".vid");
            oVar2.fjr.add(pVar);
            i++;
        }
        oVar2.fgf = j.o(amR);
        String nullAsNil2 = bo.nullAsNil((String) amR.get(".msg.fromusername"));
        if (!bo.isNullOrNil(nullAsNil2)) {
            str2 = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoO(nullAsNil2).Oi();
            oVar2.cMg = nullAsNil2;
            oVar2.cMh = str2;
        }
        if (j > 0) {
            emX.k(Long.valueOf(j), oVar2);
        }
        AppMethodBeat.o(11214);
        return oVar2;
    }

    public static String a(p pVar) {
        AppMethodBeat.i(11215);
        String str;
        if (pVar.type == 5) {
            if (bo.isNullOrNil(pVar.fjx)) {
                str = pVar.fjO;
                AppMethodBeat.o(11215);
                return str;
            }
            str = pVar.fjx;
            AppMethodBeat.o(11215);
            return str;
        } else if (bo.isNullOrNil(pVar.fjO)) {
            str = pVar.fjx;
            AppMethodBeat.o(11215);
            return str;
        } else {
            str = pVar.fjO;
            AppMethodBeat.o(11215);
            return str;
        }
    }

    public static String kr(int i) {
        AppMethodBeat.i(11216);
        if (i <= 0 || ((long) i) >= TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            AppMethodBeat.o(11216);
            return null;
        }
        String str;
        if (((long) i) < 3600) {
            str = "mm:ss";
        } else {
            str = "HH:mm:ss";
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+0:00"));
        str = simpleDateFormat.format(Long.valueOf(((long) i) * 1000));
        AppMethodBeat.o(11216);
        return str;
    }

    public static boolean c(long j, String str) {
        AppMethodBeat.i(11217);
        if (str == null) {
            AppMethodBeat.o(11217);
            return false;
        }
        o b = ((a) g.K(a.class)).b(j, str);
        if (b == null) {
            ab.w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
            AppMethodBeat.o(11217);
            return false;
        } else if (b.fjs == 1) {
            AppMethodBeat.o(11217);
            return true;
        } else {
            AppMethodBeat.o(11217);
            return false;
        }
    }

    public static String a(Context context, int i, String str, String str2, long j) {
        AppMethodBeat.i(11218);
        if (context == null) {
            ab.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
            AppMethodBeat.o(11218);
            return null;
        } else if (str == null || str2 == null) {
            ab.w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
            AppMethodBeat.o(11218);
            return null;
        } else {
            g.RQ();
            if (g.RP().isSDCardAvailable()) {
                try {
                    o b = ((a) g.K(a.class)).b(j, str);
                    LinkedList linkedList = b.fjr;
                    if (linkedList != null && linkedList.size() > 0 && i < linkedList.size()) {
                        p pVar = (p) linkedList.get(i);
                        b bVar = new b();
                        bVar.title = pVar.title;
                        bVar.description = pVar.fjz;
                        bVar.action = "view";
                        bVar.type = 5;
                        bVar.url = pVar.url;
                        bVar.cMg = b.cMg;
                        bVar.cMh = b.cMh;
                        bVar.dJv = b.dJv;
                        bVar.thumburl = a(pVar);
                        f eVar = new e();
                        eVar.ffZ = pVar.type;
                        if (pVar.type == 5) {
                            eVar.fgd = pVar.fgd;
                            eVar.fga = (int) pVar.time;
                            eVar.duration = pVar.fjB;
                            eVar.videoWidth = pVar.videoWidth;
                            eVar.videoHeight = pVar.videoHeight;
                        }
                        bVar.a(eVar);
                        if (bo.isNullOrNil(bVar.thumburl)) {
                            com.tencent.mm.ah.h qo = o.act().qo(str2);
                            if (qo != null) {
                                bVar.thumburl = qo.ack();
                            }
                        }
                        String a = b.a(bVar, null, null);
                        AppMethodBeat.o(11218);
                        return a;
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.AppMsgBizHelper", e, "", new Object[0]);
                    ab.e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", e.getLocalizedMessage());
                }
                AppMethodBeat.o(11218);
                return null;
            }
            t.hO(context);
            AppMethodBeat.o(11218);
            return null;
        }
    }

    public static String c(String str, int i, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.i(11219);
        int sessionId = s.getSessionId();
        if (str == null || !str.contains("mp.weixin.qq.com") || (sessionId <= 0 && i2 < 0 && i < 0 && i3 <= 0)) {
            AppMethodBeat.o(11219);
            return str;
        }
        String substring;
        String str2 = "";
        int indexOf = str.indexOf("#");
        if (indexOf > 0) {
            substring = str.substring(0, indexOf);
            str2 = str.substring(indexOf);
        } else {
            substring = str;
        }
        if (!str.contains("?")) {
            substring = substring + "?";
            i4 = 1;
        }
        if (i >= 0) {
            substring = substring.replaceAll("(scene=[\\d]*)", "") + "&scene=" + i;
        }
        if (i2 >= 0) {
            substring = substring + "&subscene=" + i2;
        }
        if (sessionId > 0) {
            substring = substring + "&sessionid=" + sessionId;
        }
        if (i3 > 0) {
            substring = substring + "&clicktime=" + i3;
        }
        if (i4 != 0) {
            substring = substring.replace("?&", "?");
        }
        str = substring + str2;
        AppMethodBeat.o(11219);
        return str;
    }

    public static int Me() {
        AppMethodBeat.i(11220);
        Context context = ah.getContext();
        if (!at.isNetworkConnected(context)) {
            AppMethodBeat.o(11220);
            return 100;
        } else if (at.is2G(context)) {
            AppMethodBeat.o(11220);
            return 2;
        } else if (at.is3G(context)) {
            AppMethodBeat.o(11220);
            return 3;
        } else if (at.is4G(context)) {
            AppMethodBeat.o(11220);
            return 4;
        } else if (at.isWifi(context)) {
            AppMethodBeat.o(11220);
            return 1;
        } else {
            AppMethodBeat.o(11220);
            return 0;
        }
    }

    public static String Y(String str, String str2) {
        String str3;
        AppMethodBeat.i(11210);
        Map z = br.z(str, "msg");
        if (z == null) {
            ab.e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
            str3 = null;
        } else {
            str3 = (String) z.get(".msg.fromusername");
        }
        if (!bo.isNullOrNil(str3) || com.tencent.mm.model.t.ny(str2)) {
            str2 = str3;
        }
        if (bo.isNullOrNil(str2)) {
            str3 = "";
            AppMethodBeat.o(11210);
            return str3;
        }
        if (mg(str2)) {
            WxaAttributes zb = ((d) g.K(d.class)).zb(str2);
            if (!(zb == null || TextUtils.isEmpty(zb.field_nickname))) {
                str3 = zb.field_nickname;
                AppMethodBeat.o(11210);
                return str3;
            }
        }
        str3 = ((com.tencent.mm.plugin.messenger.a.b) g.K(com.tencent.mm.plugin.messenger.a.b.class)).mJ(str2);
        AppMethodBeat.o(11210);
        return str3;
    }
}
