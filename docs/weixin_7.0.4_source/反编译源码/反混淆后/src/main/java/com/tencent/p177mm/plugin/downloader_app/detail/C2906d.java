package com.tencent.p177mm.plugin.downloader_app.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.p146d.C17817c;
import com.tencent.luggage.p146d.C32186k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C18514l;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.plugin.game.luggage.C12134c;
import com.tencent.p177mm.plugin.game.luggage.C12146d;
import com.tencent.p177mm.plugin.game.luggage.C12146d.C12149a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.downloader_app.detail.d */
public final class C2906d {
    private static C32186k kOm;
    private static String kOn = "";
    private static String kOo = "action_id";
    private static String kOp = "preload_url";
    private static String kOq = "detail_url";
    private static int kOr = 1;
    private static int kOs = 2;
    private static int kOt = 3;
    private static int kOu = 4;

    /* renamed from: com.tencent.mm.plugin.downloader_app.detail.d$2 */
    static class C29052 implements Runnable {
        C29052() {
        }

        public final void run() {
            AppMethodBeat.m2504i(136055);
            C2906d.m5182BK();
            AppMethodBeat.m2505o(136055);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.detail.d$1 */
    static class C29081 implements C12149a {
        C29081() {
        }

        /* renamed from: wM */
        public final void mo7076wM() {
            AppMethodBeat.m2504i(136054);
            if (C2906d.kOm != null) {
                C2906d.destroy();
            }
            C2906d.kOm = C12146d.m20087aq(C4996ah.getContext(), C2906d.kOn);
            if (C2906d.kOm != null) {
                C12134c.m20060a(C2906d.kOm, C2906d.kOn, false);
            }
            AppMethodBeat.m2505o(136054);
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader_app.detail.d$a */
    static class C2909a implements C37866a<Bundle, Bundle> {
        private C2909a() {
        }

        /* renamed from: a */
        public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
            AppMethodBeat.m2504i(136057);
            Bundle bundle = (Bundle) obj;
            int i = bundle.getInt(C2906d.kOo);
            if (i == C2906d.kOr) {
                C2906d.m5182BK();
                AppMethodBeat.m2505o(136057);
            } else if (i == C2906d.kOs) {
                C2906d.destroy();
                AppMethodBeat.m2505o(136057);
            } else if (i == C2906d.kOt) {
                C2906d.m5183IC(bundle.getString(C2906d.kOp));
                AppMethodBeat.m2505o(136057);
            } else {
                if (i == C2906d.kOu) {
                    C2906d.setUrl(bundle.getString(C2906d.kOq));
                }
                AppMethodBeat.m2505o(136057);
            }
        }
    }

    /* renamed from: BK */
    static /* synthetic */ void m5182BK() {
        AppMethodBeat.m2504i(136063);
        C2906d.biC();
        AppMethodBeat.m2505o(136063);
    }

    /* renamed from: IC */
    public static void m5183IC(String str) {
        AppMethodBeat.m2504i(136058);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(136058);
        } else if (C4996ah.doF()) {
            int indexOf = str.indexOf("appid");
            String str2 = "";
            if (indexOf != -1) {
                int indexOf2 = str.indexOf(38, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = str.length();
                }
                str2 = str.substring(indexOf, indexOf2);
            }
            String str3 = "";
            if (C5046bo.isNullOrNil(str2)) {
                str2 = str3;
            } else {
                str2 = str.replace(str2, "");
            }
            if (!(C5046bo.isNullOrNil(str2) || str2.equals(kOn))) {
                kOn = str2;
                C4990ab.m7417i("MicroMsg.PreloadDetailHelp", "setPreloadlUrl : %s", kOn);
                C2906d.biC();
            }
            AppMethodBeat.m2505o(136058);
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt(kOo, kOt);
            bundle.putString(kOp, str);
            ToolsProcessIPCService.m63913a(bundle, C2909a.class, null);
            AppMethodBeat.m2505o(136058);
        }
    }

    private static void biC() {
        AppMethodBeat.m2504i(136059);
        if (!C4996ah.doF()) {
            Bundle bundle = new Bundle();
            bundle.putInt(kOo, kOr);
            ToolsProcessIPCService.m63913a(bundle, C2909a.class, null);
            AppMethodBeat.m2505o(136059);
        } else if (C5046bo.isNullOrNil(kOn)) {
            AppMethodBeat.m2505o(136059);
        } else {
            C12146d.m20086a(C6834b.class, kOn, new C29081());
            AppMethodBeat.m2505o(136059);
        }
    }

    /* renamed from: dC */
    public static C32186k m5185dC(Context context) {
        AppMethodBeat.m2504i(136060);
        if (kOm != null) {
            kOm.setContext(context);
        }
        C18514l.postDelayed(new C29052(), 50);
        C32186k c32186k = kOm;
        kOm = null;
        AppMethodBeat.m2505o(136060);
        return c32186k;
    }

    public static void setUrl(String str) {
        AppMethodBeat.m2504i(136061);
        if (!C4996ah.doF()) {
            Bundle bundle = new Bundle();
            bundle.putInt(kOo, kOu);
            bundle.putString(kOq, str);
            ToolsProcessIPCService.m63913a(bundle, C2909a.class, null);
        } else if (kOm != null) {
            C4990ab.m7417i("MicroMsg.PreloadDetailHelp", "setUrl: %s", str);
            final String queryParameter = Uri.parse(str).getQueryParameter("appid");
            kOm.mo52826a(new C17817c() {
                public final String name() {
                    return "onDataEnvReady";
                }

                /* renamed from: wQ */
                public final JSONObject mo7075wQ() {
                    AppMethodBeat.m2504i(136056);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("appid", queryParameter);
                    } catch (JSONException e) {
                    }
                    AppMethodBeat.m2505o(136056);
                    return jSONObject;
                }
            });
            AppMethodBeat.m2505o(136061);
            return;
        }
        AppMethodBeat.m2505o(136061);
    }

    public static void destroy() {
        AppMethodBeat.m2504i(136062);
        if (C4996ah.doF()) {
            if (kOm != null) {
                kOm.destroy();
                kOm = null;
            }
            AppMethodBeat.m2505o(136062);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(kOo, kOs);
        ToolsProcessIPCService.m63913a(bundle, C2909a.class, null);
        AppMethodBeat.m2505o(136062);
    }
}
