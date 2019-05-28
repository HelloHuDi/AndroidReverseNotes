package com.tencent.p177mm.p181af;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p178a.C1177f;
import com.tencent.p177mm.p178a.C6294h;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.p182ah.C17880h;
import com.tencent.p177mm.p182ah.C17884o;
import com.tencent.p177mm.p184aj.C37455j;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.appbrand.service.C42686d;
import com.tencent.p177mm.plugin.biz.p1395a.C27500a;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.messenger.p993a.C34530b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5035be;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.storage.C30309s;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: com.tencent.mm.af.l */
public final class C1192l {
    private static final C1177f<Long, C32223o> emX = new C6294h(50);

    /* renamed from: mg */
    public static boolean m2624mg(String str) {
        AppMethodBeat.m2504i(11211);
        if (str == null || !str.endsWith("@app")) {
            AppMethodBeat.m2505o(11211);
            return false;
        }
        AppMethodBeat.m2505o(11211);
        return true;
    }

    /* renamed from: mh */
    public static String m2625mh(String str) {
        AppMethodBeat.m2504i(11212);
        Map z = C5049br.m7595z(str, "msg");
        String str2;
        if (z == null) {
            C4990ab.m7412e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempTitle fail, values is null");
            str2 = " ";
            AppMethodBeat.m2505o(11212);
            return str2;
        }
        C5046bo.getInt((String) z.get(".msg.appmsg.mmreader.template_detail.template_show_type"), 0);
        C5046bo.m7532bc((String) z.get(".msg.appmsg.ext_pay_info.pay_type"), "");
        str2 = C5046bo.nullAsNil((String) z.get(".msg.appmsg.title"));
        if (C5046bo.isNullOrNil(str2)) {
            str2 = (String) z.get(".msg.appmsg.mmreader.category.item.title");
        }
        if (C5046bo.isNullOrNil(str2)) {
            str2 = " ";
        }
        AppMethodBeat.m2505o(11212);
        return str2;
    }

    /* renamed from: mi */
    public static String m2626mi(String str) {
        AppMethodBeat.m2504i(11213);
        Map amR = C5035be.amR(str);
        String stringBuilder;
        if (amR == null) {
            C32223o c32223o = new C32223o();
            StringBuilder stringBuilder2 = new StringBuilder("");
            Iterator it = c32223o.fjr.iterator();
            while (it.hasNext()) {
                C32224p c32224p = (C32224p) it.next();
                if (!C5046bo.isNullOrNil(c32224p.title)) {
                    stringBuilder2.append(c32224p.title);
                    break;
                }
            }
            stringBuilder = stringBuilder2.toString();
            AppMethodBeat.m2505o(11213);
            return stringBuilder;
        }
        stringBuilder = (String) amR.get(".msg.appmsg.mmreader.category.item.title");
        if (stringBuilder == null) {
            stringBuilder = "";
            AppMethodBeat.m2505o(11213);
            return stringBuilder;
        }
        AppMethodBeat.m2505o(11213);
        return stringBuilder;
    }

    static {
        AppMethodBeat.m2504i(11221);
        AppMethodBeat.m2505o(11221);
    }

    /* renamed from: b */
    public static C32223o m2620b(long j, String str) {
        C32223o c32223o;
        AppMethodBeat.m2504i(11214);
        if (j > 0) {
            c32223o = (C32223o) emX.get(Long.valueOf(j));
            if (c32223o != null) {
                AppMethodBeat.m2505o(11214);
                return c32223o;
            }
        }
        Map amR = C5035be.amR(str);
        if (amR == null) {
            c32223o = new C32223o();
            AppMethodBeat.m2505o(11214);
            return c32223o;
        }
        int i = C5046bo.getInt((String) amR.get(".msg.appmsg.mmreader.category.$type"), 0);
        String nullAsNil = C5046bo.nullAsNil((String) amR.get(".msg.appmsg.mmreader.name"));
        int i2 = C5046bo.getInt((String) amR.get(".msg.appmsg.mmreader.forbid_forward"), 0);
        int i3 = C5046bo.getInt((String) amR.get(".msg.appmsg.mmreader.category.$count"), 0);
        String str2 = (String) amR.get(".msg.commenturl");
        C32223o c32223o2 = new C32223o();
        c32223o2.type = i;
        c32223o2.name = nullAsNil;
        c32223o2.dJv = str2;
        c32223o2.fjs = i2;
        i = 0;
        while (i < i3) {
            C32224p c32224p = new C32224p();
            String str3 = ".msg.appmsg.mmreader.category.item" + (i == 0 ? "" : String.valueOf(i));
            c32224p.title = (String) amR.get(str3 + ".title");
            c32224p.url = (String) amR.get(str3 + ".url");
            c32224p.fjv = (String) amR.get(str3 + ".shorturl");
            c32224p.fjw = (String) amR.get(str3 + ".longurl");
            c32224p.time = C5046bo.getLong((String) amR.get(str3 + ".pub_time"), 0);
            c32224p.fjy = (String) amR.get(str3 + ".tweetid");
            c32224p.fjz = (String) amR.get(str3 + ".digest");
            c32224p.type = C5046bo.getInt((String) amR.get(str3 + ".itemshowtype"), 0);
            c32224p.fjB = C5046bo.getInt((String) amR.get(str3 + ".play_length"), 0);
            c32224p.fjx = (String) amR.get(str3 + ".cover");
            str2 = (String) amR.get(str3 + ".cover_235_1");
            if ((c32224p.type != 5 && !C5046bo.isNullOrNil(str2)) || C5046bo.isNullOrNil(c32224p.fjx)) {
                c32224p.fjx = str2;
            }
            c32224p.fjO = (String) amR.get(str3 + ".cover_1_1");
            c32224p.fjA = C5046bo.getInt((String) amR.get(str3 + ".del_flag"), 0);
            c32224p.fjC = (String) amR.get(str3 + ".weapp_username");
            c32224p.fjD = (String) amR.get(str3 + ".weapp_path");
            c32224p.fjE = C5046bo.getInt((String) amR.get(str3 + ".weapp_version"), 0);
            c32224p.fjF = C5046bo.getInt((String) amR.get(str3 + ".weapp_state"), 0);
            c32224p.fjG = (String) amR.get(str3 + ".weapp_appid");
            c32224p.fjH = (String) amR.get(str3 + ".weapp_image_url");
            c32224p.fjI = (String) amR.get(str3 + ".weapp_icon");
            c32224p.fjJ = (String) amR.get(str3 + ".weapp_nickname");
            c32224p.fjK = (String) amR.get(str3 + ".play_url");
            c32224p.fjL = (String) amR.get(str3 + ".player");
            c32224p.fjM = C5046bo.getInt((String) amR.get(str3 + ".music_source"), 1);
            c32224p.fjN = C5046bo.getInt((String) amR.get(str3 + ".pic_num"), 1);
            c32224p.videoWidth = C5046bo.getInt((String) amR.get(str3 + ".video_width"), 0);
            c32224p.videoHeight = C5046bo.getInt((String) amR.get(str3 + ".video_height"), 0);
            c32224p.fgd = (String) amR.get(str3 + ".vid");
            c32223o2.fjr.add(c32224p);
            i++;
        }
        c32223o2.fgf = C37455j.m63155o(amR);
        String nullAsNil2 = C5046bo.nullAsNil((String) amR.get(".msg.fromusername"));
        if (!C5046bo.isNullOrNil(nullAsNil2)) {
            str2 = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoO(nullAsNil2).mo16706Oi();
            c32223o2.cMg = nullAsNil2;
            c32223o2.cMh = str2;
        }
        if (j > 0) {
            emX.mo4412k(Long.valueOf(j), c32223o2);
        }
        AppMethodBeat.m2505o(11214);
        return c32223o2;
    }

    /* renamed from: a */
    public static String m2619a(C32224p c32224p) {
        AppMethodBeat.m2504i(11215);
        String str;
        if (c32224p.type == 5) {
            if (C5046bo.isNullOrNil(c32224p.fjx)) {
                str = c32224p.fjO;
                AppMethodBeat.m2505o(11215);
                return str;
            }
            str = c32224p.fjx;
            AppMethodBeat.m2505o(11215);
            return str;
        } else if (C5046bo.isNullOrNil(c32224p.fjO)) {
            str = c32224p.fjx;
            AppMethodBeat.m2505o(11215);
            return str;
        } else {
            str = c32224p.fjO;
            AppMethodBeat.m2505o(11215);
            return str;
        }
    }

    /* renamed from: kr */
    public static String m2623kr(int i) {
        AppMethodBeat.m2504i(11216);
        if (i <= 0 || ((long) i) >= TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            AppMethodBeat.m2505o(11216);
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
        AppMethodBeat.m2505o(11216);
        return str;
    }

    /* renamed from: c */
    public static boolean m2622c(long j, String str) {
        AppMethodBeat.m2504i(11217);
        if (str == null) {
            AppMethodBeat.m2505o(11217);
            return false;
        }
        C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(j, str);
        if (b == null) {
            C4990ab.m7420w("MicroMsg.AppMsgBizHelper", "isBizMsgForbidForward reader is null");
            AppMethodBeat.m2505o(11217);
            return false;
        } else if (b.fjs == 1) {
            AppMethodBeat.m2505o(11217);
            return true;
        } else {
            AppMethodBeat.m2505o(11217);
            return false;
        }
    }

    /* renamed from: a */
    public static String m2618a(Context context, int i, String str, String str2, long j) {
        AppMethodBeat.m2504i(11218);
        if (context == null) {
            C4990ab.m7420w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: context is null");
            AppMethodBeat.m2505o(11218);
            return null;
        } else if (str == null || str2 == null) {
            C4990ab.m7420w("MicroMsg.AppMsgBizHelper", "getReaderAppMsgContent: msg is null");
            AppMethodBeat.m2505o(11218);
            return null;
        } else {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().isSDCardAvailable()) {
                try {
                    C32223o b = ((C27500a) C1720g.m3528K(C27500a.class)).mo35246b(j, str);
                    LinkedList linkedList = b.fjr;
                    if (linkedList != null && linkedList.size() > 0 && i < linkedList.size()) {
                        C32224p c32224p = (C32224p) linkedList.get(i);
                        C8910b c8910b = new C8910b();
                        c8910b.title = c32224p.title;
                        c8910b.description = c32224p.fjz;
                        c8910b.action = "view";
                        c8910b.type = 5;
                        c8910b.url = c32224p.url;
                        c8910b.cMg = b.cMg;
                        c8910b.cMh = b.cMh;
                        c8910b.dJv = b.dJv;
                        c8910b.thumburl = C1192l.m2619a(c32224p);
                        C37435f c25747e = new C25747e();
                        c25747e.ffZ = c32224p.type;
                        if (c32224p.type == 5) {
                            c25747e.fgd = c32224p.fgd;
                            c25747e.fga = (int) c32224p.time;
                            c25747e.duration = c32224p.fjB;
                            c25747e.videoWidth = c32224p.videoWidth;
                            c25747e.videoHeight = c32224p.videoHeight;
                        }
                        c8910b.mo20334a(c25747e);
                        if (C5046bo.isNullOrNil(c8910b.thumburl)) {
                            C17880h qo = C17884o.act().mo33392qo(str2);
                            if (qo != null) {
                                c8910b.thumburl = qo.ack();
                            }
                        }
                        String a = C8910b.m16061a(c8910b, null, null);
                        AppMethodBeat.m2505o(11218);
                        return a;
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.AppMsgBizHelper", e, "", new Object[0]);
                    C4990ab.m7413e("MicroMsg.AppMsgBizHelper", "retransmit app msg error : %s", e.getLocalizedMessage());
                }
                AppMethodBeat.m2505o(11218);
                return null;
            }
            C23639t.m36492hO(context);
            AppMethodBeat.m2505o(11218);
            return null;
        }
    }

    /* renamed from: c */
    public static String m2621c(String str, int i, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.m2504i(11219);
        int sessionId = C30309s.getSessionId();
        if (str == null || !str.contains("mp.weixin.qq.com") || (sessionId <= 0 && i2 < 0 && i < 0 && i3 <= 0)) {
            AppMethodBeat.m2505o(11219);
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
        AppMethodBeat.m2505o(11219);
        return str;
    }

    /* renamed from: Me */
    public static int m2616Me() {
        AppMethodBeat.m2504i(11220);
        Context context = C4996ah.getContext();
        if (!C5023at.isNetworkConnected(context)) {
            AppMethodBeat.m2505o(11220);
            return 100;
        } else if (C5023at.is2G(context)) {
            AppMethodBeat.m2505o(11220);
            return 2;
        } else if (C5023at.is3G(context)) {
            AppMethodBeat.m2505o(11220);
            return 3;
        } else if (C5023at.is4G(context)) {
            AppMethodBeat.m2505o(11220);
            return 4;
        } else if (C5023at.isWifi(context)) {
            AppMethodBeat.m2505o(11220);
            return 1;
        } else {
            AppMethodBeat.m2505o(11220);
            return 0;
        }
    }

    /* renamed from: Y */
    public static String m2617Y(String str, String str2) {
        String str3;
        AppMethodBeat.m2504i(11210);
        Map z = C5049br.m7595z(str, "msg");
        if (z == null) {
            C4990ab.m7412e("MicroMsg.AppMsgBizHelper", "getAppMsgDyeingTempFromUser fail, values is null");
            str3 = null;
        } else {
            str3 = (String) z.get(".msg.fromusername");
        }
        if (!C5046bo.isNullOrNil(str3) || C1855t.m3956ny(str2)) {
            str2 = str3;
        }
        if (C5046bo.isNullOrNil(str2)) {
            str3 = "";
            AppMethodBeat.m2505o(11210);
            return str3;
        }
        if (C1192l.m2624mg(str2)) {
            WxaAttributes zb = ((C42686d) C1720g.m3528K(C42686d.class)).mo44618zb(str2);
            if (!(zb == null || TextUtils.isEmpty(zb.field_nickname))) {
                str3 = zb.field_nickname;
                AppMethodBeat.m2505o(11210);
                return str3;
            }
        }
        str3 = ((C34530b) C1720g.m3528K(C34530b.class)).mo55066mJ(str2);
        AppMethodBeat.m2505o(11210);
        return str3;
    }
}
