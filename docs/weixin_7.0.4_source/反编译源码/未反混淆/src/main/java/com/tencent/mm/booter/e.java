package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.websearch.api.aj;
import com.tencent.mm.pluginsdk.model.u;
import com.tencent.mm.pluginsdk.model.u.AnonymousClass1;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.xweb.w;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class e {

    public static class c implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(15843);
            if (context == null || intent == null) {
                AppMethodBeat.o(15843);
                return;
            }
            ab.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
            com.tencent.xweb.x5.sdk.d.reset(context);
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(15842);
                    Process.killProcess(Process.myPid());
                    AppMethodBeat.o(15842);
                }
            }, 5000);
            AppMethodBeat.o(15843);
        }
    }

    public static class a implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(15840);
            if (context == null || intent == null) {
                AppMethodBeat.o(15840);
                return;
            }
            String stringExtra = intent.getStringExtra("exdevice_process_action_code_key");
            ab.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, action %s", stringExtra);
            if (bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(15840);
                return;
            }
            if (stringExtra.equals("action_reload_resources")) {
                String stringExtra2 = intent.getStringExtra("exdevice_language");
                ab.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, language %s", stringExtra2);
                Locale amw = aa.amw(stringExtra2);
                if ("language_default".equalsIgnoreCase(stringExtra2)) {
                    if (VERSION.SDK_INT >= 24) {
                        amw = aa.xyO;
                        Locale.setDefault(amw);
                    } else {
                        amw = Locale.getDefault();
                    }
                }
                aa.a(context.getApplicationContext(), amw);
                ah.f(com.tencent.mm.ca.b.a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
            }
            AppMethodBeat.o(15840);
        }
    }

    public static class d implements com.tencent.mm.booter.MMReceivers.a {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(15844);
            if (context == null || intent == null) {
                AppMethodBeat.o(15844);
                return;
            }
            String stringExtra = intent.getStringExtra("tools_process_action_code_key");
            ab.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = ".concat(String.valueOf(stringExtra)));
            if (stringExtra.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS")) {
                ab.dou();
                ab.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", Boolean.valueOf(com.tencent.mm.app.ToolsProfile.a.isLocked()));
                if (!com.tencent.mm.app.ToolsProfile.a.isLocked()) {
                    Process.killProcess(Process.myPid());
                }
                AppMethodBeat.o(15844);
            } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_RELOAD_RESOURCES")) {
                String stringExtra2 = intent.getStringExtra("tools_language");
                ab.i("MicroMsg.ToolsProcessReceiver", "onReceive, language %s", stringExtra2);
                Locale amw = aa.amw(stringExtra2);
                if ("language_default".equalsIgnoreCase(stringExtra2)) {
                    if (VERSION.SDK_INT >= 24) {
                        amw = aa.xyO;
                        Locale.setDefault(amw);
                    } else {
                        amw = Locale.getDefault();
                    }
                }
                aa.a(context.getApplicationContext(), amw);
                ah.f(com.tencent.mm.ca.b.a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
                AppMethodBeat.o(15844);
            } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
                try {
                    w.clearAllWebViewCache(context.getApplicationContext(), true);
                    AppMethodBeat.o(15844);
                } catch (Exception e) {
                    ab.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + e.getMessage());
                    AppMethodBeat.o(15844);
                }
            } else {
                if (!stringExtra.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX")) {
                    if (stringExtra.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE")) {
                        ab.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", Boolean.valueOf(intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true)));
                        w.clearAllWebViewCache(context.getApplicationContext(), r0);
                        AppMethodBeat.o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS")) {
                        ab.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
                        AppMethodBeat.o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING")) {
                        ab.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
                        AppMethodBeat.o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE")) {
                        String stringExtra3 = intent.getStringExtra("file_path");
                        String stringExtra4 = intent.getStringExtra("file_ext");
                        if (System.currentTimeMillis() - u.vbI >= 1000 && !bo.isNullOrNil(stringExtra3)) {
                            u.vbI = System.currentTimeMillis();
                            Context context2 = ah.getContext();
                            stringExtra = "";
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.putOpt("path", stringExtra3);
                                jSONObject.putOpt("ext", stringExtra4);
                                stringExtra = jSONObject.toString();
                            } catch (JSONException e2) {
                                ab.printErrStackTrace("MicroMsg.TBSFileBrowseHelper", e2, "", new Object[0]);
                            }
                            ab.i("MicroMsg.TBSFileBrowseHelper", "openFileByMiniQB, file pathinfo:%s", stringExtra);
                            com.tencent.xweb.x5.sdk.d.a(context2, stringExtra, new AnonymousClass1(stringExtra3, stringExtra4, context2));
                        }
                        AppMethodBeat.o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_SET_SWITCH")) {
                        aj.cVp().nE(intent.getBooleanExtra("tools_param_preload_switch", false));
                        AppMethodBeat.o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH")) {
                        aj.cVp().dy(intent.getStringExtra("tools_param_preload_url"), intent.getIntExtra("tools_param_preload_search_biz", -1));
                    }
                }
                AppMethodBeat.o(15844);
            }
        }
    }

    public static class b extends d {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(15841);
            if (context == null || intent == null) {
                AppMethodBeat.o(15841);
                return;
            }
            super.onReceive(context, intent);
            AppMethodBeat.o(15841);
        }
    }
}
