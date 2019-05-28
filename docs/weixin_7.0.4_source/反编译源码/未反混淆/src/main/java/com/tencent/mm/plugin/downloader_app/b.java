package com.tencent.mm.plugin.downloader_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader_app.a.a.c;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.b.a;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.plugin.downloader_app.ui.DownloadMainUI;
import com.tencent.mm.plugin.webview.luggage.o;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

public final class b implements d {
    public final boolean bix() {
        AppMethodBeat.i(136014);
        boolean bix = j.bix();
        AppMethodBeat.o(136014);
        return bix;
    }

    public final void biy() {
        AppMethodBeat.i(136015);
        j.biO();
        AppMethodBeat.o(136015);
    }

    public final void a(Context context, Intent intent, c cVar) {
        AppMethodBeat.i(136016);
        if (context == null) {
            if (cVar != null) {
                cVar.biB();
            }
            AppMethodBeat.o(136016);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.getExtras();
        intent.setClass(context, DownloadMainUI.class);
        context.startActivity(intent);
        if (cVar != null) {
            cVar.biB();
        }
        AppMethodBeat.o(136016);
    }

    public final long a(a aVar, com.tencent.mm.plugin.downloader_app.a.a.b bVar) {
        AppMethodBeat.i(136017);
        aVar.extInfo = IA(aVar.extInfo);
        long a = com.tencent.mm.plugin.downloader_app.b.c.a(aVar, bVar);
        AppMethodBeat.o(136017);
        return a;
    }

    public final void ak(final Context context, final String str) {
        AppMethodBeat.i(136018);
        l.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(136013);
                com.tencent.mm.plugin.downloader.h.a.a(context, str, null);
                AppMethodBeat.o(136013);
            }
        }, 200);
        AppMethodBeat.o(136018);
    }

    public final LinkedList<com.tencent.mm.plugin.downloader_app.a.b> biz() {
        AppMethodBeat.i(136019);
        LinkedList biQ = j.biQ();
        if (bo.ek(biQ)) {
            AppMethodBeat.o(136019);
            return null;
        }
        LinkedList<com.tencent.mm.plugin.downloader_app.a.b> linkedList = new LinkedList();
        Iterator it = biQ.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            com.tencent.mm.plugin.downloader_app.a.b bVar = new com.tencent.mm.plugin.downloader_app.a.b();
            bVar.appId = str;
            FileDownloadTaskInfo Ir = com.tencent.mm.plugin.downloader.model.d.bij().Ir(str);
            if (Ir != null) {
                bVar.crZ = Ir.id;
                switch (Ir.status) {
                    case 1:
                        bVar.kOe = "downloading";
                        break;
                    case 2:
                        bVar.kOe = "download_pause";
                        break;
                    case 3:
                        bVar.kOe = "download_succ";
                        break;
                    case 4:
                        bVar.kOe = "download_fail";
                        break;
                    default:
                        bVar.kOe = "default";
                        break;
                }
                if (Ir.jrb > 0) {
                    bVar.progress = (int) ((Ir.kNr * 100) / Ir.jrb);
                }
                if (!bVar.kOe.equals("default")) {
                    bVar.progress = bVar.progress == 0 ? 1 : bVar.progress;
                }
                if (Ir.kNu) {
                    bVar.kNu = true;
                }
                linkedList.add(bVar);
            }
        }
        AppMethodBeat.o(136019);
        return linkedList;
    }

    public final void f(Context context, Bundle bundle) {
        AppMethodBeat.i(136020);
        if (context == null) {
            AppMethodBeat.o(136020);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.game_luggage, false)) {
            o.C(context, intent);
            AppMethodBeat.o(136020);
            return;
        }
        com.tencent.mm.bp.d.b(context, "webview", ".ui.tools.game.GameWebViewUI", intent);
        AppMethodBeat.o(136020);
    }

    public final void kP(String str) {
        AppMethodBeat.i(136021);
        j.kP(str);
        AppMethodBeat.o(136021);
    }

    public final boolean a(long j, boolean z, com.tencent.mm.plugin.downloader_app.a.a.b bVar) {
        AppMethodBeat.i(136022);
        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
        if (hv != null) {
            hv.field_extInfo = IA(hv.field_extInfo);
            com.tencent.mm.plugin.downloader.model.c.e(hv);
            boolean a = com.tencent.mm.plugin.downloader_app.b.c.a(hv, z, bVar);
            AppMethodBeat.o(136022);
            return a;
        }
        bVar.a(com.tencent.mm.plugin.downloader_app.a.a.a.FAIL, j);
        AppMethodBeat.o(136022);
        return false;
    }

    public final void Iz(String str) {
        AppMethodBeat.i(136023);
        if (!j.contains(str)) {
            LinkedList biP = j.biP();
            biP.add(str);
            com.tencent.mm.plugin.downloader_app.b.g.a(biP, null);
            j.Iz(str);
        }
        AppMethodBeat.o(136023);
    }

    private static String IA(String str) {
        JSONObject jSONObject;
        String str2;
        String encode;
        AppMethodBeat.i(136024);
        if (bo.isNullOrNil(str)) {
            jSONObject = null;
            str2 = str;
        } else {
            try {
                str2 = URLDecoder.decode(str, ProtocolPackage.ServerEncoding);
            } catch (UnsupportedEncodingException e) {
                str2 = str;
            }
            try {
                jSONObject = new JSONObject(str2);
            } catch (Exception e2) {
                jSONObject = null;
            }
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (jSONObject.optInt("OpInWidget") == 1) {
            jSONObject.remove("OpInWidget");
        }
        try {
            jSONObject.put("DownloadInWidget", 1);
        } catch (JSONException e3) {
        }
        try {
            encode = URLEncoder.encode(jSONObject.toString(), ProtocolPackage.ServerEncoding);
        } catch (UnsupportedEncodingException e4) {
            encode = str2;
        }
        AppMethodBeat.o(136024);
        return encode;
    }
}
