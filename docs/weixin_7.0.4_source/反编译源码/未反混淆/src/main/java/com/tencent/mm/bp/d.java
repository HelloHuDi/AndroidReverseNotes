package com.tencent.mm.bp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.service.ProcessService.DexOptProcessService;
import com.tencent.mm.service.ProcessService.ExDeviceProcessService;
import com.tencent.mm.service.ProcessService.MMProcessService;
import com.tencent.mm.service.ProcessService.PushProcessServicer;
import com.tencent.mm.service.ProcessService.SandBoxProcessService;
import com.tencent.mm.service.ProcessService.SupportProcessService;
import com.tencent.mm.service.ProcessService.ToolsProcessService;
import com.tencent.mm.service.ProcessService.ToolsmpProcessService;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d {
    private static final Map<String, String> vwE;
    private static HashMap<String, c> vwF = new HashMap();
    private static final HashSet<String> vwG = new HashSet<String>() {
        {
            AppMethodBeat.i(114697);
            add(".ui.transmit.SelectConversationUI");
            AppMethodBeat.o(114697);
        }
    };

    public interface a {
        void onActivityResult(int i, int i2, Intent intent);
    }

    public interface b {
        void a(Intent intent, int i, a aVar);

        Context getContext();
    }

    static {
        AppMethodBeat.i(114738);
        HashMap hashMap = new HashMap();
        vwE = hashMap;
        hashMap.put(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION, "talkroom");
        vwE.put("talkroom", "voip");
        AppMethodBeat.o(114738);
    }

    public static void a(final Context context, final String str, final String str2, final Intent intent) {
        AppMethodBeat.i(114698);
        a(str, new a() {
            public final void onDone() {
                AppMethodBeat.i(114685);
                Intent intent = intent == null ? new Intent() : intent;
                intent.setClassName(ah.getPackageName(), str2.startsWith(".") ? (ah.doz() + ".plugin." + str) + str2 : str2);
                MMWizardActivity.J(context, intent);
                AppMethodBeat.o(114685);
            }
        }, new b() {
            public final void e(Exception exception) {
                AppMethodBeat.i(114690);
                ab.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", str);
                ab.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", exception);
                AppMethodBeat.o(114690);
            }
        });
        AppMethodBeat.o(114698);
    }

    public static void a(Context context, final String str, String str2, Intent intent, Intent intent2) {
        AppMethodBeat.i(114699);
        final Intent intent3 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final Intent intent4 = intent2;
        a(str, new a() {
            public final void onDone() {
                AppMethodBeat.i(114691);
                Intent intent = intent3 == null ? new Intent() : intent3;
                intent.setClassName(ah.getPackageName(), str4.startsWith(".") ? (ah.doz() + ".plugin." + str3) + str4 : str4);
                MMWizardActivity.b(context2, intent, intent4);
                AppMethodBeat.o(114691);
            }
        }, new b() {
            public final void e(Exception exception) {
                AppMethodBeat.i(114692);
                ab.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", str);
                ab.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", exception);
                AppMethodBeat.o(114692);
            }
        });
        AppMethodBeat.o(114699);
    }

    public static void H(Context context, String str, String str2) {
        AppMethodBeat.i(114700);
        c(context, str, str2, null);
        AppMethodBeat.o(114700);
    }

    public static void b(Context context, String str, String str2, Intent intent) {
        AppMethodBeat.i(114701);
        a(context, str, str2, intent, null);
        AppMethodBeat.o(114701);
    }

    public static void a(Context context, String str, String str2, Intent intent, Bundle bundle) {
        AppMethodBeat.i(114702);
        if (!com.tencent.mm.compatible.util.d.fP(21)) {
            try {
                if (context.getSharedPreferences(ah.doA(), 0).getBoolean("settings_multi_webview", false) && ".ui.tools.WebViewUI".endsWith(str2)) {
                    ab.i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
                    intent.addFlags(134217728);
                    intent.addFlags(SQLiteGlobal.journalSizeLimit);
                }
            } catch (Exception e) {
                ab.e("MicroMsg.PluginHelper", "%s", e.getMessage());
            }
        }
        b(context, str, str2, intent, bundle);
        AppMethodBeat.o(114702);
    }

    public static void c(Context context, String str, String str2, Intent intent) {
        AppMethodBeat.i(114703);
        b(context, str, str2, intent, null);
        AppMethodBeat.o(114703);
    }

    private static void b(Context context, final String str, String str2, Intent intent, Bundle bundle) {
        AppMethodBeat.i(114704);
        ab.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", Boolean.TRUE);
        if (context == null) {
            ab.e("MicroMsg.PluginHelper", "start activity error, context is null");
            AppMethodBeat.o(114704);
            return;
        }
        String str3;
        final String str4;
        final Intent intent2;
        final Context context2;
        final Bundle bundle2;
        if (".ui.tools.WebViewUI".equals(str2)) {
            int startPerformance = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, "MicroMsg.PluginHelper");
            ab.i("MicroMsg.PluginHelper", "summer hardcoder biz startPerformance [%s][%s]", Integer.valueOf(902), Integer.valueOf(startPerformance));
            try {
                String stringExtra = intent.getStringExtra("rawUrl");
                if (!bo.isNullOrNil(stringExtra)) {
                    Uri parse = Uri.parse(stringExtra);
                    if (intent.getLongExtra("start_activity_time", 0) == 0) {
                        intent.putExtra("start_activity_time", System.currentTimeMillis());
                    }
                    if (parse.getHost() != null && parse.getHost().equals("game.weixin.qq.com")) {
                        if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.game_luggage, false)) {
                            str3 = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI";
                        } else {
                            str3 = ".ui.tools.game.GameWebViewUI";
                        }
                        str4 = str;
                        intent2 = intent;
                        context2 = context;
                        bundle2 = bundle;
                        a(str, new a() {
                            public final void onDone() {
                                AppMethodBeat.i(114693);
                                ab.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", str4, str3);
                                try {
                                    Intent intent = intent2 == null ? new Intent() : intent2;
                                    String str = str3.startsWith(".") ? (ah.doz() + ".plugin." + str4) + str3 : str3;
                                    intent.setClassName(ah.getPackageName(), str);
                                    Class.forName(str, false, context2.getClassLoader());
                                    if (context2 instanceof Activity) {
                                        context2.startActivity(intent, bundle2);
                                        AppMethodBeat.o(114693);
                                        return;
                                    }
                                    intent.addFlags(268435456);
                                    context2.startActivity(intent, bundle2);
                                    AppMethodBeat.o(114693);
                                } catch (ClassNotFoundException e) {
                                    ab.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", e);
                                    AppMethodBeat.o(114693);
                                }
                            }
                        }, new b() {
                            public final void e(Exception exception) {
                                AppMethodBeat.i(114694);
                                ab.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                                ab.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
                                AppMethodBeat.o(114694);
                            }
                        });
                        AppMethodBeat.o(114704);
                    } else if (!(parse.getHost() == null || !parse.getHost().equals("mp.weixin.qq.com") || ToolsProcessIPCService.Qb())) {
                        str2 = ".ui.tools.WebviewMpUI";
                    }
                }
                str3 = str2;
            } catch (Exception e) {
                ab.e("MicroMsg.PluginHelper", "parse url failed :" + e.getMessage());
            }
            str4 = str;
            intent2 = intent;
            context2 = context;
            bundle2 = bundle;
            a(str, /* anonymous class already generated */, /* anonymous class already generated */);
            AppMethodBeat.o(114704);
        }
        str3 = str2;
        str4 = str;
        intent2 = intent;
        context2 = context;
        bundle2 = bundle;
        a(str, /* anonymous class already generated */, /* anonymous class already generated */);
        AppMethodBeat.o(114704);
    }

    public static boolean Qb() {
        AppMethodBeat.i(139145);
        boolean Qb = ToolsProcessIPCService.Qb();
        AppMethodBeat.o(139145);
        return Qb;
    }

    public static void f(Context context, String str, Intent intent) {
        AppMethodBeat.i(114706);
        c(context, str, intent, null);
        AppMethodBeat.o(114706);
    }

    public static void c(Context context, String str, Intent intent, Bundle bundle) {
        AppMethodBeat.i(114707);
        if (intent == null) {
            intent = new Intent();
        }
        String doz = ah.doz();
        if (str.startsWith(".")) {
            str = doz + str;
        }
        intent.setClassName(ah.getPackageName(), str);
        if (context instanceof Activity) {
            context.startActivity(intent, bundle);
            AppMethodBeat.o(114707);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent, bundle);
        AppMethodBeat.o(114707);
    }

    public static void c(Context context, String str, String str2, int i) {
        AppMethodBeat.i(114708);
        a(context, str, str2, null, i, true);
        AppMethodBeat.o(114708);
    }

    public static void b(Context context, String str, String str2, Intent intent, int i) {
        AppMethodBeat.i(114709);
        a(context, str, str2, intent, i, true);
        AppMethodBeat.o(114709);
    }

    public static void a(Context context, final String str, String str2, Intent intent, int i, boolean z) {
        AppMethodBeat.i(114710);
        ab.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.valueOf(z));
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final int i2 = i;
        a(str, new a() {
            public final void onDone() {
                AppMethodBeat.i(114695);
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(ah.getPackageName(), str4.startsWith(".") ? (ah.doz() + ".plugin." + str3) + str4 : str4);
                if (context2 instanceof Activity) {
                    ((Activity) context2).startActivityForResult(intent, i2);
                    d.g(context2, str4, intent);
                    AppMethodBeat.o(114695);
                    return;
                }
                ab.f("MicroMsg.PluginHelper", "context not activity, skipped");
                AppMethodBeat.o(114695);
            }
        }, new b() {
            public final void e(Exception exception) {
                AppMethodBeat.i(114696);
                ab.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                ab.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
                AppMethodBeat.o(114696);
            }
        });
        AppMethodBeat.o(114710);
    }

    public static void g(Context context, String str, Intent intent) {
        AppMethodBeat.i(114712);
        if (intent != null && vwG.contains(str)) {
            intent.putExtra("animation_pop_in", true);
            com.tencent.mm.ui.base.b.K(context, intent);
        }
        AppMethodBeat.o(114712);
    }

    public static void b(Context context, String str, Intent intent, int i) {
        AppMethodBeat.i(114713);
        intent.setClassName(ah.getPackageName(), str.startsWith(".") ? ah.doz() + str : str);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            g(context, str, intent);
            AppMethodBeat.o(114713);
            return;
        }
        ab.f("MicroMsg.PluginHelper", "context not activity, skipped");
        AppMethodBeat.o(114713);
    }

    public static void a(MMActivity mMActivity, String str, Intent intent, int i, com.tencent.mm.ui.MMActivity.a aVar) {
        AppMethodBeat.i(114714);
        Intent intent2 = intent == null ? new Intent() : intent;
        String doz = ah.doz();
        if (str.startsWith(".")) {
            doz = doz + str;
        } else {
            doz = str;
        }
        intent2.setClassName(ah.getPackageName(), doz);
        mMActivity.b(aVar, intent, i);
        g(mMActivity, str, intent);
        AppMethodBeat.o(114714);
    }

    public static void a(Fragment fragment, String str, Intent intent, int i) {
        AppMethodBeat.i(114715);
        intent.setClassName(ah.getPackageName(), str.startsWith(".") ? ah.doz() + str : str);
        if (fragment instanceof Fragment) {
            fragment.startActivityForResult(intent, i);
            g(fragment.getActivity(), str, intent);
            AppMethodBeat.o(114715);
            return;
        }
        ab.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
        AppMethodBeat.o(114715);
    }

    public static void dlK() {
        AppMethodBeat.i(114717);
        String str = "mm";
        com.tencent.mm.service.c.a(str, true, aku(str));
        AppMethodBeat.o(114717);
    }

    private static void i(Intent intent, String str) {
        AppMethodBeat.i(114718);
        com.tencent.mm.service.c.a(intent, str, true, aku(str));
        AppMethodBeat.o(114718);
    }

    public static void aH(Intent intent) {
        AppMethodBeat.i(114719);
        i(intent, "mm");
        AppMethodBeat.o(114719);
    }

    public static void j(Intent intent, String str) {
        AppMethodBeat.i(139146);
        i(intent, str);
        AppMethodBeat.o(139146);
    }

    private static void k(Intent intent, String str) {
        AppMethodBeat.i(114721);
        com.tencent.mm.service.c.b(intent, str, true, aku(str));
        AppMethodBeat.o(114721);
    }

    public static void aI(Intent intent) {
        AppMethodBeat.i(114722);
        k(intent, "mm");
        AppMethodBeat.o(114722);
    }

    public static void l(Intent intent, String str) {
        AppMethodBeat.i(139147);
        k(intent, str);
        AppMethodBeat.o(139147);
    }

    private static Intent aku(String str) {
        AppMethodBeat.i(114726);
        Class cls = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1854767153:
                if (str.equals("support")) {
                    obj = 5;
                    break;
                }
                break;
            case -1335091396:
                if (str.equals("dexopt")) {
                    obj = 2;
                    break;
                }
                break;
            case -1140077378:
                if (str.equals("toolsmp")) {
                    obj = 6;
                    break;
                }
                break;
            case 3488:
                if (str.equals("mm")) {
                    obj = null;
                    break;
                }
                break;
            case 3452698:
                if (str.equals("push")) {
                    obj = 1;
                    break;
                }
                break;
            case 110545371:
                if (str.equals("tools")) {
                    obj = 3;
                    break;
                }
                break;
            case 1865400007:
                if (str.equals("sandbox")) {
                    obj = 7;
                    break;
                }
                break;
            case 2016254153:
                if (str.equals("exdevice")) {
                    obj = 4;
                    break;
                }
                break;
        }
        switch (obj) {
            case null:
                cls = MMProcessService.class;
                break;
            case 1:
                cls = PushProcessServicer.class;
                break;
            case 2:
                cls = DexOptProcessService.class;
                break;
            case 3:
                cls = ToolsProcessService.class;
                break;
            case 4:
                cls = ExDeviceProcessService.class;
                break;
            case 5:
                cls = SupportProcessService.class;
                break;
            case 6:
                cls = ToolsmpProcessService.class;
                break;
            case 7:
                cls = SandBoxProcessService.class;
                break;
        }
        Intent intent = new Intent(ah.getContext(), cls);
        AppMethodBeat.o(114726);
        return intent;
    }

    public static at akv(String str) {
        AppMethodBeat.i(114728);
        ab.d("MicroMsg.PluginHelper", "-->createSubCore: %s alone", str);
        c akw = akw(str);
        if (akw == null) {
            ab.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", str);
            AppMethodBeat.o(114728);
            return null;
        }
        at createSubCore = akw.createSubCore();
        if (createSubCore == null) {
            ab.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", str);
            AppMethodBeat.o(114728);
            return null;
        }
        ab.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", str);
        AppMethodBeat.o(114728);
        return createSubCore;
    }

    public static void a(String str, n nVar, m mVar) {
        AppMethodBeat.i(114729);
        ab.d("MicroMsg.PluginHelper", "--> registerApplication: %s", str);
        c akw = akw(str);
        if (akw == null) {
            ab.f("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            AppMethodBeat.o(114729);
            return;
        }
        o createApplication = akw.createApplication();
        if (createApplication == null) {
            ab.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            AppMethodBeat.o(114729);
            return;
        }
        createApplication.a(mVar);
        createApplication.a(nVar);
        ab.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s %s %s", str, nVar, mVar);
        AppMethodBeat.o(114729);
    }

    public static com.tencent.mm.pluginsdk.b.a ac(Context context, String str) {
        AppMethodBeat.i(114730);
        com.tencent.mm.pluginsdk.b.a I = I(context, str, null);
        AppMethodBeat.o(114730);
        return I;
    }

    public static com.tencent.mm.pluginsdk.b.a I(Context context, String str, String str2) {
        AppMethodBeat.i(114731);
        c akw = akw(str);
        if (akw == null) {
            ab.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", str, str2);
            AppMethodBeat.o(114731);
            return null;
        }
        com.tencent.mm.pluginsdk.b.b contactWidgetFactory = akw.getContactWidgetFactory();
        if (contactWidgetFactory == null) {
            ab.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", str, str2);
            AppMethodBeat.o(114731);
            return null;
        }
        com.tencent.mm.pluginsdk.b.a ac = contactWidgetFactory.ac(context, str2);
        AppMethodBeat.o(114731);
        return ac;
    }

    public static boolean dlL() {
        return false;
    }

    public static synchronized boolean afj(String str) {
        boolean z;
        synchronized (d.class) {
            AppMethodBeat.i(114732);
            if (vwF.get(str) != null) {
                z = true;
                AppMethodBeat.o(114732);
            } else {
                z = false;
                AppMethodBeat.o(114732);
            }
        }
        return z;
    }

    private static synchronized c akw(String str) {
        c akx;
        synchronized (d.class) {
            AppMethodBeat.i(114733);
            try {
                akx = akx(str);
                AppMethodBeat.o(114733);
            } catch (ClassNotFoundException e) {
                ab.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s, e:%s", str, e.toString());
                akx = null;
                AppMethodBeat.o(114733);
                return akx;
            } catch (InstantiationException e2) {
                ab.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e2.toString());
                akx = null;
                AppMethodBeat.o(114733);
                return akx;
            } catch (IllegalAccessException e3) {
                ab.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e3.toString());
                akx = null;
                AppMethodBeat.o(114733);
                return akx;
            }
        }
        return akx;
    }

    public static synchronized c a(String str, a aVar, b bVar) {
        c cVar;
        synchronized (d.class) {
            AppMethodBeat.i(114734);
            if (((String) vwE.get(str)) != null) {
                ab.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, (String) vwE.get(str));
            }
            cVar = (c) vwF.get(str);
            if (cVar != null) {
                aVar.onDone();
                AppMethodBeat.o(114734);
            } else {
                try {
                    cVar = akx(str);
                    if (cVar != null) {
                        aVar.onDone();
                    }
                    AppMethodBeat.o(114734);
                } catch (Exception e) {
                    try {
                        cVar = akx(str);
                        if (cVar != null) {
                            aVar.onDone();
                        }
                        AppMethodBeat.o(114734);
                    } catch (ClassNotFoundException e2) {
                        ab.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s ,e:%s", str, e2.toString());
                        ab.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        bVar.e(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        AppMethodBeat.o(114734);
                        return cVar;
                    } catch (InstantiationException e3) {
                        ab.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e3.toString());
                        ab.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        bVar.e(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        AppMethodBeat.o(114734);
                        return cVar;
                    } catch (IllegalAccessException e4) {
                        ab.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e4.toString());
                        ab.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        bVar.e(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        AppMethodBeat.o(114734);
                        return cVar;
                    }
                }
            }
        }
        return cVar;
    }

    private static c akx(String str) {
        AppMethodBeat.i(114735);
        c cVar = (c) vwF.get(str);
        if (cVar != null) {
            AppMethodBeat.o(114735);
            return cVar;
        }
        cVar = (c) ah.getContext().getClassLoader().loadClass(ah.doz() + ".plugin." + str + ".Plugin").newInstance();
        vwF.put(str, cVar);
        AppMethodBeat.o(114735);
        return cVar;
    }

    public static synchronized Class<?> hM(String str, String str2) {
        Class<?> loadClass;
        synchronized (d.class) {
            AppMethodBeat.i(114736);
            if (((String) vwE.get(str)) != null) {
                ab.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, (String) vwE.get(str));
            }
            if (aky(str)) {
                String str3 = ah.doz() + ".plugin." + str;
                if (str2.startsWith(".")) {
                    str2 = str3 + str2;
                }
                try {
                    loadClass = ah.getContext().getClassLoader().loadClass(str2);
                    AppMethodBeat.o(114736);
                } catch (Exception e) {
                    ab.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                    AppMethodBeat.o(114736);
                    loadClass = null;
                }
            } else {
                ab.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                AppMethodBeat.o(114736);
                loadClass = null;
            }
        }
        return loadClass;
    }

    private static synchronized boolean aky(String str) {
        boolean z;
        synchronized (d.class) {
            AppMethodBeat.i(114737);
            if (akw(str) != null) {
                z = true;
                AppMethodBeat.o(114737);
            } else {
                z = false;
                AppMethodBeat.o(114737);
            }
        }
        return z;
    }

    public static void a(Fragment fragment, final String str, String str2, Intent intent, int i) {
        AppMethodBeat.i(114711);
        ab.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.TRUE);
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Fragment fragment2 = fragment;
        final int i2 = i;
        a(str, new a() {
            public final void onDone() {
                AppMethodBeat.i(114688);
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(ah.getPackageName(), str4.startsWith(".") ? (ah.doz() + ".plugin." + str3) + str4 : str4);
                fragment2.startActivityForResult(intent, i2);
                d.g(fragment2.getActivity(), str4, intent2);
                AppMethodBeat.o(114688);
            }
        }, new b() {
            public final void e(Exception exception) {
                AppMethodBeat.i(114689);
                ab.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                ab.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
                AppMethodBeat.o(114689);
            }
        });
        AppMethodBeat.o(114711);
    }

    public static void a(b bVar, final String str, String str2, Intent intent, int i, a aVar) {
        AppMethodBeat.i(114716);
        ab.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.TRUE);
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final b bVar2 = bVar;
        final int i2 = i;
        final a aVar2 = aVar;
        a(str, new a() {
            public final void onDone() {
                AppMethodBeat.i(114686);
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(ah.getPackageName(), str4.startsWith(".") ? (ah.doz() + ".plugin." + str3) + str4 : str4);
                bVar2.a(intent, i2, aVar2);
                d.g(bVar2.getContext(), str4, intent2);
                AppMethodBeat.o(114686);
            }
        }, new b() {
            public final void e(Exception exception) {
                AppMethodBeat.i(114687);
                ab.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                ab.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
                AppMethodBeat.o(114687);
            }
        });
        AppMethodBeat.o(114716);
    }

    public static boolean a(Intent intent, ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(114724);
        boolean a = com.tencent.mm.service.c.a(intent, serviceConnection, 1, str, true, aku(str));
        AppMethodBeat.o(114724);
        return a;
    }

    public static void a(ServiceConnection serviceConnection, String str) {
        AppMethodBeat.i(114725);
        com.tencent.mm.service.c.a(serviceConnection, str, true, aku(str));
        AppMethodBeat.o(114725);
    }
}
