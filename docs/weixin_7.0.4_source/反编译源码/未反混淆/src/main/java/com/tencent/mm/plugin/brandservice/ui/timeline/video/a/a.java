package com.tencent.mm.plugin.brandservice.ui.timeline.video.a;

import a.f.b.j;
import a.l;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.r;
import com.tencent.mm.bp.d;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.b;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Map;

@l(dWo = {1, 1, 13}, dWp = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0012"}, dWq = {"Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/util/BizVideoMsgTransmit;", "", "()V", "TAG", "", "doSendAppMsg", "", "toUser", "msgInfo", "Lcom/tencent/mm/message/MPMsgInfo;", "appendText", "controller", "Lcom/tencent/mm/plugin/brandservice/ui/timeline/video/BizVideoController;", "transmitBizVideoMsg", "", "context", "Landroid/content/Context;", "msg", "plugin-brandservice_release"})
public final class a {
    private static final String TAG = TAG;
    public static final a jYp = new a();

    static {
        AppMethodBeat.i(15311);
        AppMethodBeat.o(15311);
    }

    private a() {
    }

    public static void a(Context context, r rVar, b bVar) {
        Map map;
        String nullAsNil;
        String str = null;
        AppMethodBeat.i(15309);
        j.p(context, "context");
        j.p(rVar, "msg");
        j.p(bVar, "controller");
        HashMap hashMap = new HashMap();
        if (bVar.aYp()) {
            map = hashMap;
            String str2 = "img_url";
            bac bac = bVar.jVI;
            nullAsNil = bo.nullAsNil(bac != null ? bac.fjx : null);
            j.o(nullAsNil, "Util.nullAsNil(controlle…aliciousTitleInfo?.cover)");
            map.put(str2, nullAsNil);
            map = hashMap;
            str2 = "desc";
            bac = bVar.jVI;
            if (bac != null) {
                nullAsNil = bac.fjz;
            } else {
                nullAsNil = null;
            }
            nullAsNil = bo.nullAsNil(nullAsNil);
            j.o(nullAsNil, "Util.nullAsNil(controlle…liciousTitleInfo?.digest)");
            map.put(str2, nullAsNil);
            map = hashMap;
            nullAsNil = "title";
            bac bac2 = bVar.jVI;
            if (bac2 != null) {
                str = bac2.title;
            }
            str = bo.nullAsNil(str);
            j.o(str, "Util.nullAsNil(controlle…aliciousTitleInfo?.title)");
            map.put(nullAsNil, str);
        } else {
            str = rVar.fjT.fjx;
            j.o(str, "msg.item.cover");
            hashMap.put("img_url", str);
            str = rVar.fjT.fjz;
            j.o(str, "msg.item.digest");
            hashMap.put("desc", str);
            str = rVar.fjT.title;
            j.o(str, "msg.item.title");
            hashMap.put("title", str);
        }
        map = hashMap;
        nullAsNil = "url";
        str = bVar.url;
        if (str == null) {
            j.dWJ();
        }
        map.put(nullAsNil, str);
        ab.i(TAG, "transmitBizVideoMsg, img_url=%s, desc=%s, title=%s, url=%s", hashMap.get("img_url"), hashMap.get("desc"), hashMap.get("title"), bVar.url);
        h.pYm.a(157, 5, 1, false);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("scene_from", 2);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("webview_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        d.b(context, ".ui.transmit.SelectConversationUI", intent, 2);
        AppMethodBeat.o(15309);
    }

    public static boolean a(String str, r rVar, String str2, b bVar) {
        Object obj = null;
        AppMethodBeat.i(15310);
        j.p(str, "toUser");
        j.p(rVar, "msgInfo");
        j.p(bVar, "controller");
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = bVar.url;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (bVar.aYp()) {
            String str3;
            bac bac = bVar.jVI;
            if (bac != null) {
                str3 = bac.title;
            } else {
                str3 = null;
            }
            wXMediaMessage.title = str3;
            bac = bVar.jVI;
            if (bac != null) {
                str3 = bac.fjz;
            } else {
                str3 = null;
            }
            wXMediaMessage.description = str3;
        } else {
            wXMediaMessage.title = rVar.fjT.title;
            wXMediaMessage.description = rVar.fjT.fjz;
        }
        py pyVar = new py();
        pyVar.cMe.cEl = wXMediaMessage;
        pyVar.cMe.toUser = str;
        pyVar.cMe.cMf = 2;
        if (bo.isNullOrNil(rVar.cwG)) {
            pyVar.cMe.cMg = rVar.HE();
            pyVar.cMe.cMh = s.mJ(rVar.HE());
        } else {
            pyVar.cMe.cMg = rVar.cwG;
            pyVar.cMe.cMh = rVar.fjR;
        }
        try {
            pyVar.cMe.cMj = bVar.url;
            pyVar.cMe.cMm = bo.nullAsNil(rVar.fjS);
            String nW = v.nW(pyVar.cMe.cMm);
            v.b y = v.Zp().y(nW, true);
            if (y == null) {
                j.dWJ();
            }
            y.j("sendAppMsgScene", Integer.valueOf(2));
            y.j("preChatName", rVar.HE());
            y.j("preMsgIndex", Integer.valueOf(rVar.fjQ));
            y.j("prePublishId", rVar.fjS);
            y.j("preUsername", rVar.HE());
            int i = rVar.fjT.type;
            if (i != -1) {
                y.j("_DATA_CENTER_ITEM_SHOW_TYPE", Integer.valueOf(i));
                y.j("_tmpl_webview_transfer_scene", Integer.valueOf(11));
            }
            if (rVar.fjT.type == 5) {
                y.j("_DATA_CENTER_VID", rVar.fjT.fgd);
                y.j("_DATA_CENTER_FUNC_FLAG", Integer.valueOf(rVar.fgc));
                y.j("_DATA_CENTER_PUB_TIME", Integer.valueOf((int) rVar.fjT.time));
                y.j("_DATA_CENTER__DULATION", Integer.valueOf(rVar.fjT.fjB));
                y.j("_DATA_CENTER_VIDEO_WIDTH", Integer.valueOf(rVar.fjT.videoWidth));
                y.j("_DATA_CENTER_VIDEO_HEIGHT", Integer.valueOf(rVar.fjT.videoHeight));
                if (bVar.aYp()) {
                    String str4 = "_DATA_CENTER_COVER_URL";
                    bac bac2 = bVar.jVI;
                    y.j(str4, bac2 != null ? bac2.fjx : null);
                    String str5 = "_DATA_CENTER_DESC";
                    bac bac3 = bVar.jVI;
                    if (bac3 != null) {
                        obj = bac3.fjz;
                    }
                    y.j(str5, obj);
                } else {
                    y.j("_DATA_CENTER_COVER_URL", rVar.fjT.fjx);
                    y.j("_DATA_CENTER_DESC", rVar.fjT.fjz);
                }
            }
            pyVar.cMe.cvF = nW;
            pyVar.cMe.cMk = bVar.url;
        } catch (Exception e) {
            ab.e(TAG, "init bunddata failed : %s", e.getMessage());
        }
        boolean m = com.tencent.mm.sdk.b.a.xxA.m(pyVar);
        if (!bo.isNullOrNil(str2)) {
            qb qbVar = new qb();
            qbVar.cMq.cMr = str;
            qbVar.cMq.content = str2;
            qbVar.cMq.type = t.nK(str);
            qbVar.cMq.flags = 0;
            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
        }
        AppMethodBeat.o(15310);
        return m;
    }
}
