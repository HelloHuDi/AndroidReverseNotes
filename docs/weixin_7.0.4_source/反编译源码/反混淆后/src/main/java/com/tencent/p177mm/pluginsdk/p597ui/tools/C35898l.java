package com.tencent.p177mm.pluginsdk.p597ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C18178q;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.p177mm.opensdk.modelmsg.WXImageObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.p177mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.p177mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p181af.C8909j.C8910b;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5068w;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.pluginsdk.ui.tools.l */
public final class C35898l {
    public static int vvk = 2;

    /* renamed from: a */
    public static void m58844a(int i, C40439f c40439f, WxaAttributes wxaAttributes, WXMediaMessage wXMediaMessage, WXMiniProgramObject wXMiniProgramObject, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(79950);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = c40439f.field_appId;
            String str3 = c40439f.field_appName;
            int i2 = c40439f.mo63847xy() ? 1 : 0;
            int type = wXMediaMessage.getType();
            int i3 = C1855t.m3896kH(str) ? 1 : 0;
            try {
                String encode = C18178q.encode(C5046bo.nullAsNil(wXMiniProgramObject.webpageUrl), "UTF-8");
                String encode2 = C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.title), "UTF-8");
                String encode3 = C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.description), "UTF-8");
                String str4 = "MicroMsg.ShareReport";
                C4990ab.m7416i(str4, i + "," + str2 + "," + str3 + "," + i2 + "," + type + "," + i3 + ",1," + str + "," + encode2 + "," + encode3 + "," + encode + "," + wxaAttributes.field_appId + "," + C18178q.encode(C5046bo.nullAsNil(wXMiniProgramObject.path), "UTF-8") + "," + wXMiniProgramObject.miniprogramType);
                C7060h.pYm.mo8381e(16492, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(type), Integer.valueOf(i3), Integer.valueOf(1), str, encode2, encode3, encode, r11, r12, Integer.valueOf(r13));
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7412e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            }
        }
        AppMethodBeat.m2505o(79950);
    }

    /* renamed from: a */
    public static void m58843a(int i, C40439f c40439f, WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(79951);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = c40439f.field_appId;
            String str3 = c40439f.field_appName;
            int i2 = c40439f.mo63847xy() ? 1 : 0;
            int type = wXMediaMessage.getType();
            try {
                C4990ab.m7416i("MicroMsg.ShareReport", i + "," + str2 + "," + str3 + "," + i2 + "," + type + "," + (C1855t.m3896kH(str) ? 1 : 0) + ",1," + str + "," + C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.title), "UTF-8") + "," + C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.description), "UTF-8") + "," + C18178q.encode(C5046bo.nullAsNil(C35898l.m58847b(wXMediaMessage)), "UTF-8") + "," + "" + "," + "" + "," + "");
                C7060h.pYm.mo8381e(16492, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(type), Integer.valueOf(r3), Integer.valueOf(1), str, C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.title), "UTF-8"), C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.description), "UTF-8"), r8, "", "", "");
            } catch (UnsupportedEncodingException e) {
                C4990ab.m7412e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            }
        }
        AppMethodBeat.m2505o(79951);
    }

    /* renamed from: hK */
    public static void m58848hK(String str, String str2) {
        AppMethodBeat.m2504i(79952);
        C8910b md = C8910b.m16063md(C5046bo.anj(str));
        if (md == null) {
            AppMethodBeat.m2505o(79952);
            return;
        }
        C40439f bT = C46494g.m87739bT(md.appId, true);
        if (bT == null) {
            AppMethodBeat.m2505o(79952);
            return;
        }
        String str3 = bT.field_appId;
        String str4 = bT.field_appName;
        int i = bT.mo63847xy() ? 1 : 0;
        int i2 = md.type;
        int i3 = C1855t.m3896kH(str2) ? 1 : 0;
        int i4 = vvk;
        try {
            String encode = C18178q.encode(C5046bo.nullAsNil(md.url), "UTF-8");
            String encode2 = C18178q.encode(C5046bo.nullAsNil(md.title), "UTF-8");
            String encode3 = C18178q.encode(C5046bo.nullAsNil(md.description), "UTF-8");
            String str5 = "MicroMsg.ShareReport";
            C4990ab.m7416i(str5, "," + str3 + "," + str4 + "," + i + "," + i2 + "," + i3 + "," + i4 + "," + str2 + "," + encode2 + "," + encode3 + "," + encode + "," + md.fiQ + "," + md.fiO + "," + md.fiZ);
            C7060h.pYm.mo8381e(16492, "", str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str2, encode2, encode3, encode, r11, r12, Integer.valueOf(r3));
            AppMethodBeat.m2505o(79952);
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            AppMethodBeat.m2505o(79952);
        }
    }

    /* renamed from: aG */
    public static void m58846aG(Intent intent) {
        AppMethodBeat.m2504i(79953);
        Bundle bundleExtra = intent.getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra == null) {
            AppMethodBeat.m2505o(79953);
            return;
        }
        String n = C5068w.m7689n(intent, "Ksnsupload_appid");
        String n2 = C5068w.m7689n(intent, "Ksnsupload_appname");
        int a = C5068w.m7682a(intent, "Ksnsupload_open_sdk_version", 0);
        boolean a2 = C5068w.m7683a(intent, "KThrid_app", false);
        boolean a3 = C5068w.m7683a(intent, "Ksnsupload_app_is_game", false);
        Req req = new Req();
        req.fromBundle(bundleExtra);
        WXMediaMessage wXMediaMessage = req.message;
        if (wXMediaMessage == null) {
            AppMethodBeat.m2505o(79953);
            return;
        }
        try {
            String encode = C18178q.encode(C5046bo.nullAsNil(C35898l.m58847b(wXMediaMessage)), "UTF-8");
            String encode2 = C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.title), "UTF-8");
            String encode3 = C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.description), "UTF-8");
            C4990ab.m7416i("MicroMsg.ShareReport", a + "," + n + "," + n2 + "," + (a3 ? 1 : 0) + "," + wXMediaMessage.getType() + ",2," + (a2 ? 1 : 2) + ",," + encode2 + "," + encode3 + "," + encode);
            C7060h c7060h = C7060h.pYm;
            Object[] objArr = new Object[11];
            objArr[0] = Integer.valueOf(a);
            objArr[1] = n;
            objArr[2] = n2;
            objArr[3] = Integer.valueOf(a3 ? 1 : 0);
            objArr[4] = Integer.valueOf(wXMediaMessage.getType());
            objArr[5] = Integer.valueOf(2);
            objArr[6] = Integer.valueOf(a2 ? 1 : 2);
            objArr[7] = "";
            objArr[8] = encode2;
            objArr[9] = encode3;
            objArr[10] = encode;
            c7060h.mo8381e(16492, objArr);
            AppMethodBeat.m2505o(79953);
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            AppMethodBeat.m2505o(79953);
        }
    }

    /* renamed from: b */
    private static String m58847b(WXMediaMessage wXMediaMessage) {
        AppMethodBeat.m2504i(79955);
        String str;
        if (wXMediaMessage == null) {
            C4990ab.m7420w("MicroMsg.ShareReport", "sendImgMsg msg not img");
            AppMethodBeat.m2505o(79955);
            return null;
        } else if (wXMediaMessage.mediaObject instanceof WXImageObject) {
            str = ((WXImageObject) wXMediaMessage.mediaObject).imagePath;
            AppMethodBeat.m2505o(79955);
            return str;
        } else if (wXMediaMessage.mediaObject instanceof WXVideoFileObject) {
            str = ((WXVideoFileObject) wXMediaMessage.mediaObject).filePath;
            AppMethodBeat.m2505o(79955);
            return str;
        } else if (wXMediaMessage.mediaObject instanceof WXMusicObject) {
            str = ((WXMusicObject) wXMediaMessage.mediaObject).musicUrl;
            AppMethodBeat.m2505o(79955);
            return str;
        } else if (wXMediaMessage.mediaObject instanceof WXVideoObject) {
            str = ((WXVideoObject) wXMediaMessage.mediaObject).videoUrl;
            AppMethodBeat.m2505o(79955);
            return str;
        } else if (wXMediaMessage.mediaObject instanceof WXWebpageObject) {
            str = ((WXWebpageObject) wXMediaMessage.mediaObject).webpageUrl;
            AppMethodBeat.m2505o(79955);
            return str;
        } else {
            str = "";
            AppMethodBeat.m2505o(79955);
            return str;
        }
    }

    /* renamed from: a */
    public static void m58845a(int i, String str, WXMediaMessage wXMediaMessage) {
        AppMethodBeat.m2504i(79954);
        C40439f bT = C46494g.m87739bT(str, true);
        if (bT == null) {
            AppMethodBeat.m2505o(79954);
            return;
        }
        String str2 = bT.field_appId;
        String str3 = bT.field_appName;
        int i2 = bT.mo63847xy() ? 1 : 0;
        int type = wXMediaMessage.getType();
        String str4 = "";
        try {
            String str5 = "MicroMsg.ShareReport";
            C4990ab.m7416i(str5, i + "," + str2 + "," + str3 + "," + i2 + "," + type + ",3,1," + str4 + "," + C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.title), "UTF-8") + "," + C18178q.encode(C5046bo.nullAsNil(wXMediaMessage.description), "UTF-8") + "," + C18178q.encode(C5046bo.nullAsNil(C35898l.m58847b(wXMediaMessage)), "UTF-8"));
            C7060h.pYm.mo8381e(16492, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(type), Integer.valueOf(3), Integer.valueOf(1), str4, r5, r6, r7);
            AppMethodBeat.m2505o(79954);
        } catch (UnsupportedEncodingException e) {
            C4990ab.m7412e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            AppMethodBeat.m2505o(79954);
        }
    }
}
