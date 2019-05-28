package com.tencent.mm.plugin.downloader_app.detail;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.luggage.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import org.json.JSONException;
import org.json.JSONObject;

public final class d {
    private static k kOm;
    private static String kOn = "";
    private static String kOo = "action_id";
    private static String kOp = "preload_url";
    private static String kOq = "detail_url";
    private static int kOr = 1;
    private static int kOs = 2;
    private static int kOt = 3;
    private static int kOu = 4;

    static class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, c cVar) {
            AppMethodBeat.i(136057);
            Bundle bundle = (Bundle) obj;
            int i = bundle.getInt(d.kOo);
            if (i == d.kOr) {
                d.BK();
                AppMethodBeat.o(136057);
            } else if (i == d.kOs) {
                d.destroy();
                AppMethodBeat.o(136057);
            } else if (i == d.kOt) {
                d.IC(bundle.getString(d.kOp));
                AppMethodBeat.o(136057);
            } else {
                if (i == d.kOu) {
                    d.setUrl(bundle.getString(d.kOq));
                }
                AppMethodBeat.o(136057);
            }
        }
    }

    static /* synthetic */ void BK() {
        AppMethodBeat.i(136063);
        biC();
        AppMethodBeat.o(136063);
    }

    public static void IC(String str) {
        AppMethodBeat.i(136058);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(136058);
        } else if (ah.doF()) {
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
            if (bo.isNullOrNil(str2)) {
                str2 = str3;
            } else {
                str2 = str.replace(str2, "");
            }
            if (!(bo.isNullOrNil(str2) || str2.equals(kOn))) {
                kOn = str2;
                ab.i("MicroMsg.PreloadDetailHelp", "setPreloadlUrl : %s", kOn);
                biC();
            }
            AppMethodBeat.o(136058);
        } else {
            Bundle bundle = new Bundle();
            bundle.putInt(kOo, kOt);
            bundle.putString(kOp, str);
            ToolsProcessIPCService.a(bundle, a.class, null);
            AppMethodBeat.o(136058);
        }
    }

    private static void biC() {
        AppMethodBeat.i(136059);
        if (!ah.doF()) {
            Bundle bundle = new Bundle();
            bundle.putInt(kOo, kOr);
            ToolsProcessIPCService.a(bundle, a.class, null);
            AppMethodBeat.o(136059);
        } else if (bo.isNullOrNil(kOn)) {
            AppMethodBeat.o(136059);
        } else {
            com.tencent.mm.plugin.game.luggage.d.a(b.class, kOn, new com.tencent.mm.plugin.game.luggage.d.a() {
                public final void wM() {
                    AppMethodBeat.i(136054);
                    if (d.kOm != null) {
                        d.destroy();
                    }
                    d.kOm = com.tencent.mm.plugin.game.luggage.d.aq(ah.getContext(), d.kOn);
                    if (d.kOm != null) {
                        com.tencent.mm.plugin.game.luggage.c.a(d.kOm, d.kOn, false);
                    }
                    AppMethodBeat.o(136054);
                }
            });
            AppMethodBeat.o(136059);
        }
    }

    public static k dC(Context context) {
        AppMethodBeat.i(136060);
        if (kOm != null) {
            kOm.setContext(context);
        }
        l.postDelayed(new Runnable() {
            public final void run() {
                AppMethodBeat.i(136055);
                d.BK();
                AppMethodBeat.o(136055);
            }
        }, 50);
        k kVar = kOm;
        kOm = null;
        AppMethodBeat.o(136060);
        return kVar;
    }

    public static void setUrl(String str) {
        AppMethodBeat.i(136061);
        if (!ah.doF()) {
            Bundle bundle = new Bundle();
            bundle.putInt(kOo, kOu);
            bundle.putString(kOq, str);
            ToolsProcessIPCService.a(bundle, a.class, null);
        } else if (kOm != null) {
            ab.i("MicroMsg.PreloadDetailHelp", "setUrl: %s", str);
            final String queryParameter = Uri.parse(str).getQueryParameter("appid");
            kOm.a(new com.tencent.luggage.d.c() {
                public final String name() {
                    return "onDataEnvReady";
                }

                public final JSONObject wQ() {
                    AppMethodBeat.i(136056);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("appid", queryParameter);
                    } catch (JSONException e) {
                    }
                    AppMethodBeat.o(136056);
                    return jSONObject;
                }
            });
            AppMethodBeat.o(136061);
            return;
        }
        AppMethodBeat.o(136061);
    }

    public static void destroy() {
        AppMethodBeat.i(136062);
        if (ah.doF()) {
            if (kOm != null) {
                kOm.destroy();
                kOm = null;
            }
            AppMethodBeat.o(136062);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt(kOo, kOs);
        ToolsProcessIPCService.a(bundle, a.class, null);
        AppMethodBeat.o(136062);
    }
}
