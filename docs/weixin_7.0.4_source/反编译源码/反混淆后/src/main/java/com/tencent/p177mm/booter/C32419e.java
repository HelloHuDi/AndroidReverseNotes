package com.tencent.p177mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.app.ToolsProfile.C6310a;
import com.tencent.p177mm.booter.MMReceivers.C18095a;
import com.tencent.p177mm.p210ca.C18121b;
import com.tencent.p177mm.plugin.websearch.api.C4510aj;
import com.tencent.p177mm.pluginsdk.model.C44067u;
import com.tencent.p177mm.pluginsdk.model.C44067u.C300841;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.xweb.C16403w;
import com.tencent.xweb.p685x5.sdk.C24544d;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.booter.e */
public final class C32419e {

    /* renamed from: com.tencent.mm.booter.e$c */
    public static class C32420c implements C18095a {

        /* renamed from: com.tencent.mm.booter.e$c$1 */
        class C180991 implements Runnable {
            C180991() {
            }

            public final void run() {
                AppMethodBeat.m2504i(15842);
                Process.killProcess(Process.myPid());
                AppMethodBeat.m2505o(15842);
            }
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(15843);
            if (context == null || intent == null) {
                AppMethodBeat.m2505o(15843);
                return;
            }
            C4990ab.m7416i("MicroMsg.SandBoxProcessReceiver", "onReceive");
            C24544d.reset(context);
            C5004al.m7442n(new C180991(), 5000);
            AppMethodBeat.m2505o(15843);
        }
    }

    /* renamed from: com.tencent.mm.booter.e$a */
    public static class C32421a implements C18095a {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(15840);
            if (context == null || intent == null) {
                AppMethodBeat.m2505o(15840);
                return;
            }
            String stringExtra = intent.getStringExtra("exdevice_process_action_code_key");
            C4990ab.m7417i("MicroMsg.ExDeviceProcessReceiver", "onReceive, action %s", stringExtra);
            if (C5046bo.isNullOrNil(stringExtra)) {
                AppMethodBeat.m2505o(15840);
                return;
            }
            if (stringExtra.equals("action_reload_resources")) {
                String stringExtra2 = intent.getStringExtra("exdevice_language");
                C4990ab.m7417i("MicroMsg.ExDeviceProcessReceiver", "onReceive, language %s", stringExtra2);
                Locale amw = C4988aa.amw(stringExtra2);
                if ("language_default".equalsIgnoreCase(stringExtra2)) {
                    if (VERSION.SDK_INT >= 24) {
                        amw = C4988aa.xyO;
                        Locale.setDefault(amw);
                    } else {
                        amw = Locale.getDefault();
                    }
                }
                C4988aa.m7399a(context.getApplicationContext(), amw);
                C4996ah.m7431f(C18121b.m28548a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
            }
            AppMethodBeat.m2505o(15840);
        }
    }

    /* renamed from: com.tencent.mm.booter.e$d */
    public static class C32422d implements C18095a {
        public void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(15844);
            if (context == null || intent == null) {
                AppMethodBeat.m2505o(15844);
                return;
            }
            String stringExtra = intent.getStringExtra("tools_process_action_code_key");
            C4990ab.m7416i("MicroMsg.ToolsProcessReceiver", "onReceive, action = ".concat(String.valueOf(stringExtra)));
            if (stringExtra.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS")) {
                C4990ab.dou();
                C4990ab.m7417i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", Boolean.valueOf(C6310a.isLocked()));
                if (!C6310a.isLocked()) {
                    Process.killProcess(Process.myPid());
                }
                AppMethodBeat.m2505o(15844);
            } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_RELOAD_RESOURCES")) {
                String stringExtra2 = intent.getStringExtra("tools_language");
                C4990ab.m7417i("MicroMsg.ToolsProcessReceiver", "onReceive, language %s", stringExtra2);
                Locale amw = C4988aa.amw(stringExtra2);
                if ("language_default".equalsIgnoreCase(stringExtra2)) {
                    if (VERSION.SDK_INT >= 24) {
                        amw = C4988aa.xyO;
                        Locale.setDefault(amw);
                    } else {
                        amw = Locale.getDefault();
                    }
                }
                C4988aa.m7399a(context.getApplicationContext(), amw);
                C4996ah.m7431f(C18121b.m28548a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
                AppMethodBeat.m2505o(15844);
            } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
                try {
                    C16403w.clearAllWebViewCache(context.getApplicationContext(), true);
                    AppMethodBeat.m2505o(15844);
                } catch (Exception e) {
                    C4990ab.m7416i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + e.getMessage());
                    AppMethodBeat.m2505o(15844);
                }
            } else {
                if (!stringExtra.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX")) {
                    if (stringExtra.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE")) {
                        C4990ab.m7417i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", Boolean.valueOf(intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true)));
                        C16403w.clearAllWebViewCache(context.getApplicationContext(), r0);
                        AppMethodBeat.m2505o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS")) {
                        C4990ab.m7416i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
                        AppMethodBeat.m2505o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING")) {
                        C4990ab.m7416i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
                        AppMethodBeat.m2505o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE")) {
                        String stringExtra3 = intent.getStringExtra("file_path");
                        String stringExtra4 = intent.getStringExtra("file_ext");
                        if (System.currentTimeMillis() - C44067u.vbI >= 1000 && !C5046bo.isNullOrNil(stringExtra3)) {
                            C44067u.vbI = System.currentTimeMillis();
                            Context context2 = C4996ah.getContext();
                            stringExtra = "";
                            try {
                                JSONObject jSONObject = new JSONObject();
                                jSONObject.putOpt("path", stringExtra3);
                                jSONObject.putOpt("ext", stringExtra4);
                                stringExtra = jSONObject.toString();
                            } catch (JSONException e2) {
                                C4990ab.printErrStackTrace("MicroMsg.TBSFileBrowseHelper", e2, "", new Object[0]);
                            }
                            C4990ab.m7417i("MicroMsg.TBSFileBrowseHelper", "openFileByMiniQB, file pathinfo:%s", stringExtra);
                            C24544d.m38196a(context2, stringExtra, new C300841(stringExtra3, stringExtra4, context2));
                        }
                        AppMethodBeat.m2505o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_SET_SWITCH")) {
                        C4510aj.cVp().mo9582nE(intent.getBooleanExtra("tools_param_preload_switch", false));
                        AppMethodBeat.m2505o(15844);
                        return;
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH")) {
                        C4510aj.cVp().mo9581dy(intent.getStringExtra("tools_param_preload_url"), intent.getIntExtra("tools_param_preload_search_biz", -1));
                    }
                }
                AppMethodBeat.m2505o(15844);
            }
        }
    }

    /* renamed from: com.tencent.mm.booter.e$b */
    public static class C32423b extends C32422d {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(15841);
            if (context == null || intent == null) {
                AppMethodBeat.m2505o(15841);
                return;
            }
            super.onReceive(context, intent);
            AppMethodBeat.m2505o(15841);
        }
    }
}
