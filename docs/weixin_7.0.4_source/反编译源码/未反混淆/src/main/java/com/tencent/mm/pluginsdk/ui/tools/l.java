package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXMusicObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoFileObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.w;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.LinkedList;

public final class l {
    public static int vvk = 2;

    public static void a(int i, f fVar, WxaAttributes wxaAttributes, WXMediaMessage wXMediaMessage, WXMiniProgramObject wXMiniProgramObject, LinkedList<String> linkedList) {
        AppMethodBeat.i(79950);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = fVar.field_appId;
            String str3 = fVar.field_appName;
            int i2 = fVar.xy() ? 1 : 0;
            int type = wXMediaMessage.getType();
            int i3 = t.kH(str) ? 1 : 0;
            try {
                String encode = q.encode(bo.nullAsNil(wXMiniProgramObject.webpageUrl), "UTF-8");
                String encode2 = q.encode(bo.nullAsNil(wXMediaMessage.title), "UTF-8");
                String encode3 = q.encode(bo.nullAsNil(wXMediaMessage.description), "UTF-8");
                String str4 = "MicroMsg.ShareReport";
                ab.i(str4, i + "," + str2 + "," + str3 + "," + i2 + "," + type + "," + i3 + ",1," + str + "," + encode2 + "," + encode3 + "," + encode + "," + wxaAttributes.field_appId + "," + q.encode(bo.nullAsNil(wXMiniProgramObject.path), "UTF-8") + "," + wXMiniProgramObject.miniprogramType);
                h.pYm.e(16492, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(type), Integer.valueOf(i3), Integer.valueOf(1), str, encode2, encode3, encode, r11, r12, Integer.valueOf(r13));
            } catch (UnsupportedEncodingException e) {
                ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            }
        }
        AppMethodBeat.o(79950);
    }

    public static void a(int i, f fVar, WXMediaMessage wXMediaMessage, LinkedList<String> linkedList) {
        AppMethodBeat.i(79951);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            String str2 = fVar.field_appId;
            String str3 = fVar.field_appName;
            int i2 = fVar.xy() ? 1 : 0;
            int type = wXMediaMessage.getType();
            try {
                ab.i("MicroMsg.ShareReport", i + "," + str2 + "," + str3 + "," + i2 + "," + type + "," + (t.kH(str) ? 1 : 0) + ",1," + str + "," + q.encode(bo.nullAsNil(wXMediaMessage.title), "UTF-8") + "," + q.encode(bo.nullAsNil(wXMediaMessage.description), "UTF-8") + "," + q.encode(bo.nullAsNil(b(wXMediaMessage)), "UTF-8") + "," + "" + "," + "" + "," + "");
                h.pYm.e(16492, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(type), Integer.valueOf(r3), Integer.valueOf(1), str, q.encode(bo.nullAsNil(wXMediaMessage.title), "UTF-8"), q.encode(bo.nullAsNil(wXMediaMessage.description), "UTF-8"), r8, "", "", "");
            } catch (UnsupportedEncodingException e) {
                ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            }
        }
        AppMethodBeat.o(79951);
    }

    public static void hK(String str, String str2) {
        AppMethodBeat.i(79952);
        b md = b.md(bo.anj(str));
        if (md == null) {
            AppMethodBeat.o(79952);
            return;
        }
        f bT = g.bT(md.appId, true);
        if (bT == null) {
            AppMethodBeat.o(79952);
            return;
        }
        String str3 = bT.field_appId;
        String str4 = bT.field_appName;
        int i = bT.xy() ? 1 : 0;
        int i2 = md.type;
        int i3 = t.kH(str2) ? 1 : 0;
        int i4 = vvk;
        try {
            String encode = q.encode(bo.nullAsNil(md.url), "UTF-8");
            String encode2 = q.encode(bo.nullAsNil(md.title), "UTF-8");
            String encode3 = q.encode(bo.nullAsNil(md.description), "UTF-8");
            String str5 = "MicroMsg.ShareReport";
            ab.i(str5, "," + str3 + "," + str4 + "," + i + "," + i2 + "," + i3 + "," + i4 + "," + str2 + "," + encode2 + "," + encode3 + "," + encode + "," + md.fiQ + "," + md.fiO + "," + md.fiZ);
            h.pYm.e(16492, "", str3, str4, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), str2, encode2, encode3, encode, r11, r12, Integer.valueOf(r3));
            AppMethodBeat.o(79952);
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            AppMethodBeat.o(79952);
        }
    }

    public static void aG(Intent intent) {
        AppMethodBeat.i(79953);
        Bundle bundleExtra = intent.getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra == null) {
            AppMethodBeat.o(79953);
            return;
        }
        String n = w.n(intent, "Ksnsupload_appid");
        String n2 = w.n(intent, "Ksnsupload_appname");
        int a = w.a(intent, "Ksnsupload_open_sdk_version", 0);
        boolean a2 = w.a(intent, "KThrid_app", false);
        boolean a3 = w.a(intent, "Ksnsupload_app_is_game", false);
        Req req = new Req();
        req.fromBundle(bundleExtra);
        WXMediaMessage wXMediaMessage = req.message;
        if (wXMediaMessage == null) {
            AppMethodBeat.o(79953);
            return;
        }
        try {
            String encode = q.encode(bo.nullAsNil(b(wXMediaMessage)), "UTF-8");
            String encode2 = q.encode(bo.nullAsNil(wXMediaMessage.title), "UTF-8");
            String encode3 = q.encode(bo.nullAsNil(wXMediaMessage.description), "UTF-8");
            ab.i("MicroMsg.ShareReport", a + "," + n + "," + n2 + "," + (a3 ? 1 : 0) + "," + wXMediaMessage.getType() + ",2," + (a2 ? 1 : 2) + ",," + encode2 + "," + encode3 + "," + encode);
            h hVar = h.pYm;
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
            hVar.e(16492, objArr);
            AppMethodBeat.o(79953);
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            AppMethodBeat.o(79953);
        }
    }

    private static String b(WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(79955);
        String str;
        if (wXMediaMessage == null) {
            ab.w("MicroMsg.ShareReport", "sendImgMsg msg not img");
            AppMethodBeat.o(79955);
            return null;
        } else if (wXMediaMessage.mediaObject instanceof WXImageObject) {
            str = ((WXImageObject) wXMediaMessage.mediaObject).imagePath;
            AppMethodBeat.o(79955);
            return str;
        } else if (wXMediaMessage.mediaObject instanceof WXVideoFileObject) {
            str = ((WXVideoFileObject) wXMediaMessage.mediaObject).filePath;
            AppMethodBeat.o(79955);
            return str;
        } else if (wXMediaMessage.mediaObject instanceof WXMusicObject) {
            str = ((WXMusicObject) wXMediaMessage.mediaObject).musicUrl;
            AppMethodBeat.o(79955);
            return str;
        } else if (wXMediaMessage.mediaObject instanceof WXVideoObject) {
            str = ((WXVideoObject) wXMediaMessage.mediaObject).videoUrl;
            AppMethodBeat.o(79955);
            return str;
        } else if (wXMediaMessage.mediaObject instanceof WXWebpageObject) {
            str = ((WXWebpageObject) wXMediaMessage.mediaObject).webpageUrl;
            AppMethodBeat.o(79955);
            return str;
        } else {
            str = "";
            AppMethodBeat.o(79955);
            return str;
        }
    }

    public static void a(int i, String str, WXMediaMessage wXMediaMessage) {
        AppMethodBeat.i(79954);
        f bT = g.bT(str, true);
        if (bT == null) {
            AppMethodBeat.o(79954);
            return;
        }
        String str2 = bT.field_appId;
        String str3 = bT.field_appName;
        int i2 = bT.xy() ? 1 : 0;
        int type = wXMediaMessage.getType();
        String str4 = "";
        try {
            String str5 = "MicroMsg.ShareReport";
            ab.i(str5, i + "," + str2 + "," + str3 + "," + i2 + "," + type + ",3,1," + str4 + "," + q.encode(bo.nullAsNil(wXMediaMessage.title), "UTF-8") + "," + q.encode(bo.nullAsNil(wXMediaMessage.description), "UTF-8") + "," + q.encode(bo.nullAsNil(b(wXMediaMessage)), "UTF-8"));
            h.pYm.e(16492, Integer.valueOf(i), str2, str3, Integer.valueOf(i2), Integer.valueOf(type), Integer.valueOf(3), Integer.valueOf(1), str4, r5, r6, r7);
            AppMethodBeat.o(79954);
        } catch (UnsupportedEncodingException e) {
            ab.e("MicroMsg.ShareReport", "URLEncoder.encode Error");
            AppMethodBeat.o(79954);
        }
    }
}
