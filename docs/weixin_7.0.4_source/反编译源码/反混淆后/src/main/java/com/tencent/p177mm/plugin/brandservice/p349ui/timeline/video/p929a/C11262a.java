package com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.p929a;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1854s;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.model.C37922v;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p181af.C37436r;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C26217py;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.brandservice.p349ui.timeline.video.C45767b;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.bac;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Map;
import p000a.C0220l;
import p000a.p005f.p007b.C25052j;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "appendText", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "transmitBizVideoMsg", "", "context", "Landroid/content/Context;", "msg", "plugin-brandservice_release"})
/* renamed from: com.tencent.mm.plugin.brandservice.ui.timeline.video.a.a */
public final class C11262a {
    private static final String TAG = TAG;
    public static final C11262a jYp = new C11262a();

    static {
        AppMethodBeat.m2504i(15311);
        AppMethodBeat.m2505o(15311);
    }

    private C11262a() {
    }

    /* renamed from: a */
    public static void m18977a(Context context, C37436r c37436r, C45767b c45767b) {
        Map map;
        String nullAsNil;
        String str = null;
        AppMethodBeat.m2504i(15309);
        C25052j.m39376p(context, "context");
        C25052j.m39376p(c37436r, "msg");
        C25052j.m39376p(c45767b, "controller");
        HashMap hashMap = new HashMap();
        if (c45767b.aYp()) {
            map = hashMap;
            String str2 = "img_url";
            bac bac = c45767b.jVI;
            nullAsNil = C5046bo.nullAsNil(bac != null ? bac.fjx : null);
            C25052j.m39375o(nullAsNil, "Util.nullAsNil(controlle…aliciousTitleInfo?.cover)");
            map.put(str2, nullAsNil);
            map = hashMap;
            str2 = "desc";
            bac = c45767b.jVI;
            if (bac != null) {
                nullAsNil = bac.fjz;
            } else {
                nullAsNil = null;
            }
            nullAsNil = C5046bo.nullAsNil(nullAsNil);
            C25052j.m39375o(nullAsNil, "Util.nullAsNil(controlle…liciousTitleInfo?.digest)");
            map.put(str2, nullAsNil);
            map = hashMap;
            nullAsNil = "title";
            bac bac2 = c45767b.jVI;
            if (bac2 != null) {
                str = bac2.title;
            }
            str = C5046bo.nullAsNil(str);
            C25052j.m39375o(str, "Util.nullAsNil(controlle…aliciousTitleInfo?.title)");
            map.put(nullAsNil, str);
        } else {
            str = c37436r.fjT.fjx;
            C25052j.m39375o(str, "msg.item.cover");
            hashMap.put("img_url", str);
            str = c37436r.fjT.fjz;
            C25052j.m39375o(str, "msg.item.digest");
            hashMap.put("desc", str);
            str = c37436r.fjT.title;
            C25052j.m39375o(str, "msg.item.title");
            hashMap.put("title", str);
        }
        map = hashMap;
        nullAsNil = "url";
        str = c45767b.url;
        if (str == null) {
            C25052j.dWJ();
        }
        map.put(nullAsNil, str);
        C4990ab.m7417i(TAG, "transmitBizVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", hashMap.get("img_url"), hashMap.get("desc"), hashMap.get("title"), c45767b.url);
        C7060h.pYm.mo8378a(157, 5, 1, false);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("scene_from", 2);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("webview_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        C25985d.m41466b(context, ".ui.transmit.SelectConversationUI", intent, 2);
        AppMethodBeat.m2505o(15309);
    }

    /* renamed from: a */
    public static boolean m18978a(String str, C37436r c37436r, String str2, C45767b c45767b) {
        Object obj = null;
        AppMethodBeat.m2504i(15310);
        C25052j.m39376p(str, "toUser");
        C25052j.m39376p(c37436r, "msgInfo");
        C25052j.m39376p(c45767b, "controller");
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = c45767b.url;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (c45767b.aYp()) {
            String str3;
            bac bac = c45767b.jVI;
            if (bac != null) {
                str3 = bac.title;
            } else {
                str3 = null;
            }
            wXMediaMessage.title = str3;
            bac = c45767b.jVI;
            if (bac != null) {
                str3 = bac.fjz;
            } else {
                str3 = null;
            }
            wXMediaMessage.description = str3;
        } else {
            wXMediaMessage.title = c37436r.fjT.title;
            wXMediaMessage.description = c37436r.fjT.fjz;
        }
        C26217py c26217py = new C26217py();
        c26217py.cMe.cEl = wXMediaMessage;
        c26217py.cMe.toUser = str;
        c26217py.cMe.cMf = 2;
        if (C5046bo.isNullOrNil(c37436r.cwG)) {
            c26217py.cMe.cMg = c37436r.mo60325HE();
            c26217py.cMe.cMh = C1854s.m3866mJ(c37436r.mo60325HE());
        } else {
            c26217py.cMe.cMg = c37436r.cwG;
            c26217py.cMe.cMh = c37436r.fjR;
        }
        try {
            c26217py.cMe.cMj = c45767b.url;
            c26217py.cMe.cMm = C5046bo.nullAsNil(c37436r.fjS);
            String nW = C37922v.m64078nW(c26217py.cMe.cMm);
            C32800b y = C37922v.m64076Zp().mo60676y(nW, true);
            if (y == null) {
                C25052j.dWJ();
            }
            y.mo53356j("sendAppMsgScene", Integer.valueOf(2));
            y.mo53356j("preChatName", c37436r.mo60325HE());
            y.mo53356j("preMsgIndex", Integer.valueOf(c37436r.fjQ));
            y.mo53356j("prePublishId", c37436r.fjS);
            y.mo53356j("preUsername", c37436r.mo60325HE());
            int i = c37436r.fjT.type;
            if (i != -1) {
                y.mo53356j("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(i));
                y.mo53356j("_tmpl_webview_transfer_scene", Integer.valueOf(11));
            }
            if (c37436r.fjT.type == 5) {
                y.mo53356j("_DATA_CENTER_VID", c37436r.fjT.fgd);
                y.mo53356j("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(c37436r.fgc));
                y.mo53356j("_DATA_CENTER_PUB_TIME", Integer.valueOf((int) c37436r.fjT.time));
                y.mo53356j("_DATA_CENTER__DULATION", Integer.valueOf(c37436r.fjT.fjB));
                y.mo53356j("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(c37436r.fjT.videoWidth));
                y.mo53356j("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(c37436r.fjT.videoHeight));
                if (c45767b.aYp()) {
                    String str4 = "_DATA_CENTER_COVER_URL";
                    bac bac2 = c45767b.jVI;
                    y.mo53356j(str4, bac2 != null ? bac2.fjx : null);
                    String str5 = "_DATA_CENTER_DESC";
                    bac bac3 = c45767b.jVI;
                    if (bac3 != null) {
                        obj = bac3.fjz;
                    }
                    y.mo53356j(str5, obj);
                } else {
                    y.mo53356j("_DATA_CENTER_COVER_URL", c37436r.fjT.fjx);
                    y.mo53356j("_DATA_CENTER_DESC", c37436r.fjT.fjz);
                }
            }
            c26217py.cMe.cvF = nW;
            c26217py.cMe.cMk = c45767b.url;
        } catch (Exception e) {
            C4990ab.m7413e(TAG, "init bunddata failed : %s", e.getMessage());
        }
        boolean m = C4879a.xxA.mo10055m(c26217py);
        if (!C5046bo.isNullOrNil(str2)) {
            C18372qb c18372qb = new C18372qb();
            c18372qb.cMq.cMr = str;
            c18372qb.cMq.content = str2;
            c18372qb.cMq.type = C1855t.m3925nK(str);
            c18372qb.cMq.flags = 0;
            C4879a.xxA.mo10055m(c18372qb);
        }
        AppMethodBeat.m2505o(15310);
        return m;
    }
}
