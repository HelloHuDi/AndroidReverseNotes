package com.tencent.p177mm.plugin.downloader_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p943h.C33913a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20331a;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20332b;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C20334a.C20333c;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38854b;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.downloader_app.p377b.C27716g;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45833a;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45836c;
import com.tencent.p177mm.plugin.downloader_app.p377b.C45837j;
import com.tencent.p177mm.plugin.downloader_app.p380ui.DownloadMainUI;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.webview.luggage.C46420o;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.b */
public final class C42921b implements C38855d {
    public final boolean bix() {
        AppMethodBeat.m2504i(136014);
        boolean bix = C45837j.bix();
        AppMethodBeat.m2505o(136014);
        return bix;
    }

    public final void biy() {
        AppMethodBeat.m2504i(136015);
        C45837j.biO();
        AppMethodBeat.m2505o(136015);
    }

    /* renamed from: a */
    public final void mo61727a(Context context, Intent intent, C20333c c20333c) {
        AppMethodBeat.m2504i(136016);
        if (context == null) {
            if (c20333c != null) {
                c20333c.biB();
            }
            AppMethodBeat.m2505o(136016);
            return;
        }
        if (intent == null) {
            intent = new Intent();
        }
        intent.getExtras();
        intent.setClass(context, DownloadMainUI.class);
        context.startActivity(intent);
        if (c20333c != null) {
            c20333c.biB();
        }
        AppMethodBeat.m2505o(136016);
    }

    /* renamed from: a */
    public final long mo61726a(C45833a c45833a, C20332b c20332b) {
        AppMethodBeat.m2504i(136017);
        c45833a.extInfo = C42921b.m76218IA(c45833a.extInfo);
        long a = C45836c.m84831a(c45833a, c20332b);
        AppMethodBeat.m2505o(136017);
        return a;
    }

    /* renamed from: ak */
    public final void mo61729ak(final Context context, final String str) {
        AppMethodBeat.m2504i(136018);
        C18514l.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(136013);
                C33913a.m55500a(context, str, null);
                AppMethodBeat.m2505o(136013);
            }
        }, 200);
        AppMethodBeat.m2505o(136018);
    }

    public final LinkedList<C38854b> biz() {
        AppMethodBeat.m2504i(136019);
        LinkedList biQ = C45837j.biQ();
        if (C5046bo.m7548ek(biQ)) {
            AppMethodBeat.m2505o(136019);
            return null;
        }
        LinkedList<C38854b> linkedList = new LinkedList();
        Iterator it = biQ.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C38854b c38854b = new C38854b();
            c38854b.appId = str;
            FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
            if (Ir != null) {
                c38854b.crZ = Ir.f16167id;
                switch (Ir.status) {
                    case 1:
                        c38854b.kOe = "downloading";
                        break;
                    case 2:
                        c38854b.kOe = "download_pause";
                        break;
                    case 3:
                        c38854b.kOe = "download_succ";
                        break;
                    case 4:
                        c38854b.kOe = "download_fail";
                        break;
                    default:
                        c38854b.kOe = "default";
                        break;
                }
                if (Ir.jrb > 0) {
                    c38854b.progress = (int) ((Ir.kNr * 100) / Ir.jrb);
                }
                if (!c38854b.kOe.equals("default")) {
                    c38854b.progress = c38854b.progress == 0 ? 1 : c38854b.progress;
                }
                if (Ir.kNu) {
                    c38854b.kNu = true;
                }
                linkedList.add(c38854b);
            }
        }
        AppMethodBeat.m2505o(136019);
        return linkedList;
    }

    /* renamed from: f */
    public final void mo61733f(Context context, Bundle bundle) {
        AppMethodBeat.m2504i(136020);
        if (context == null) {
            AppMethodBeat.m2505o(136020);
            return;
        }
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.game_luggage, false)) {
            C46420o.m87431C(context, intent);
            AppMethodBeat.m2505o(136020);
            return;
        }
        C25985d.m41467b(context, "webview", ".ui.tools.game.GameWebViewUI", intent);
        AppMethodBeat.m2505o(136020);
    }

    /* renamed from: kP */
    public final void mo61734kP(String str) {
        AppMethodBeat.m2504i(136021);
        C45837j.m84848kP(str);
        AppMethodBeat.m2505o(136021);
    }

    /* renamed from: a */
    public final boolean mo61728a(long j, boolean z, C20332b c20332b) {
        AppMethodBeat.m2504i(136022);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            hv.field_extInfo = C42921b.m76218IA(hv.field_extInfo);
            C2895c.m5146e(hv);
            boolean a = C45836c.m84840a(hv, z, c20332b);
            AppMethodBeat.m2505o(136022);
            return a;
        }
        c20332b.mo9713a(C20331a.FAIL, j);
        AppMethodBeat.m2505o(136022);
        return false;
    }

    /* renamed from: Iz */
    public final void mo61725Iz(String str) {
        AppMethodBeat.m2504i(136023);
        if (!C45837j.contains(str)) {
            LinkedList biP = C45837j.biP();
            biP.add(str);
            C27716g.m44026a(biP, null);
            C45837j.m84846Iz(str);
        }
        AppMethodBeat.m2505o(136023);
    }

    /* renamed from: IA */
    private static String m76218IA(String str) {
        JSONObject jSONObject;
        String str2;
        String encode;
        AppMethodBeat.m2504i(136024);
        if (C5046bo.isNullOrNil(str)) {
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
        AppMethodBeat.m2505o(136024);
        return encode;
    }
}
