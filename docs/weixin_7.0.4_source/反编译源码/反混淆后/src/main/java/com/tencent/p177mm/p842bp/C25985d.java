package com.tencent.p177mm.p842bp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.p057v4.app.Fragment;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.MMWizardActivity;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.pluginsdk.C23244m;
import com.tencent.p177mm.pluginsdk.C23255n;
import com.tencent.p177mm.pluginsdk.C23256o;
import com.tencent.p177mm.pluginsdk.p1337b.C23233a;
import com.tencent.p177mm.pluginsdk.p1337b.C40415c;
import com.tencent.p177mm.pluginsdk.p1337b.C44040b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.service.C5091c;
import com.tencent.p177mm.service.ProcessService.DexOptProcessService;
import com.tencent.p177mm.service.ProcessService.ExDeviceProcessService;
import com.tencent.p177mm.service.ProcessService.MMProcessService;
import com.tencent.p177mm.service.ProcessService.PushProcessServicer;
import com.tencent.p177mm.service.ProcessService.SandBoxProcessService;
import com.tencent.p177mm.service.ProcessService.SupportProcessService;
import com.tencent.p177mm.service.ProcessService.ToolsProcessService;
import com.tencent.p177mm.service.ProcessService.ToolsmpProcessService;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.tencent.mm.bp.d */
public final class C25985d {
    private static final Map<String, String> vwE;
    private static HashMap<String, C40415c> vwF = new HashMap();
    private static final HashSet<String> vwG = new C1811013();

    /* renamed from: com.tencent.mm.bp.d$13 */
    static class C1811013 extends HashSet<String> {
        C1811013() {
            AppMethodBeat.m2504i(114697);
            add(".ui.transmit.SelectConversationUI");
            AppMethodBeat.m2505o(114697);
        }
    }

    /* renamed from: com.tencent.mm.bp.d$a */
    public interface C25987a {
        void onActivityResult(int i, int i2, Intent intent);
    }

    /* renamed from: com.tencent.mm.bp.d$b */
    public interface C25988b {
        /* renamed from: a */
        void mo43869a(Intent intent, int i, C25987a c25987a);

        Context getContext();
    }

    static {
        AppMethodBeat.m2504i(114738);
        HashMap hashMap = new HashMap();
        vwE = hashMap;
        hashMap.put(C8741b.LOCATION, "talkroom");
        vwE.put("talkroom", "voip");
        AppMethodBeat.m2505o(114738);
    }

    /* renamed from: a */
    public static void m41452a(final Context context, final String str, final String str2, final Intent intent) {
        AppMethodBeat.m2504i(114698);
        C25985d.m41451a(str, new C41909a() {
            public final void onDone() {
                AppMethodBeat.m2504i(114685);
                Intent intent = intent == null ? new Intent() : intent;
                intent.setClassName(C4996ah.getPackageName(), str2.startsWith(".") ? (C4996ah.doz() + ".plugin." + str) + str2 : str2);
                MMWizardActivity.m23791J(context, intent);
                AppMethodBeat.m2505o(114685);
            }
        }, new C41910b() {
            /* renamed from: e */
            public final void mo43868e(Exception exception) {
                AppMethodBeat.m2504i(114690);
                C4990ab.m7413e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", str);
                C4990ab.m7413e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", exception);
                AppMethodBeat.m2505o(114690);
            }
        });
        AppMethodBeat.m2505o(114698);
    }

    /* renamed from: a */
    public static void m41454a(Context context, final String str, String str2, Intent intent, Intent intent2) {
        AppMethodBeat.m2504i(114699);
        final Intent intent3 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final Intent intent4 = intent2;
        C25985d.m41451a(str, new C41909a() {
            public final void onDone() {
                AppMethodBeat.m2504i(114691);
                Intent intent = intent3 == null ? new Intent() : intent3;
                intent.setClassName(C4996ah.getPackageName(), str4.startsWith(".") ? (C4996ah.doz() + ".plugin." + str3) + str4 : str4);
                MMWizardActivity.m23792b(context2, intent, intent4);
                AppMethodBeat.m2505o(114691);
            }
        }, new C41910b() {
            /* renamed from: e */
            public final void mo43868e(Exception exception) {
                AppMethodBeat.m2504i(114692);
                C4990ab.m7413e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", str);
                C4990ab.m7413e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", exception);
                AppMethodBeat.m2505o(114692);
            }
        });
        AppMethodBeat.m2505o(114699);
    }

    /* renamed from: H */
    public static void m41448H(Context context, String str, String str2) {
        AppMethodBeat.m2504i(114700);
        C25985d.m41472c(context, str, str2, null);
        AppMethodBeat.m2505o(114700);
    }

    /* renamed from: b */
    public static void m41467b(Context context, String str, String str2, Intent intent) {
        AppMethodBeat.m2504i(114701);
        C25985d.m41455a(context, str, str2, intent, null);
        AppMethodBeat.m2505o(114701);
    }

    /* renamed from: a */
    public static void m41455a(Context context, String str, String str2, Intent intent, Bundle bundle) {
        AppMethodBeat.m2504i(114702);
        if (!C1443d.m3067fP(21)) {
            try {
                if (context.getSharedPreferences(C4996ah.doA(), 0).getBoolean("settings_multi_webview", false) && ".ui.tools.WebViewUI".endsWith(str2)) {
                    C4990ab.m7416i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
                    intent.addFlags(134217728);
                    intent.addFlags(SQLiteGlobal.journalSizeLimit);
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.PluginHelper", "%s", e.getMessage());
            }
        }
        C25985d.m41469b(context, str, str2, intent, bundle);
        AppMethodBeat.m2505o(114702);
    }

    /* renamed from: c */
    public static void m41472c(Context context, String str, String str2, Intent intent) {
        AppMethodBeat.m2504i(114703);
        C25985d.m41469b(context, str, str2, intent, null);
        AppMethodBeat.m2505o(114703);
    }

    /* renamed from: b */
    private static void m41469b(Context context, final String str, String str2, Intent intent, Bundle bundle) {
        AppMethodBeat.m2504i(114704);
        C4990ab.m7411d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", Boolean.TRUE);
        if (context == null) {
            C4990ab.m7412e("MicroMsg.PluginHelper", "start activity error, context is null");
            AppMethodBeat.m2505o(114704);
            return;
        }
        String str3;
        final String str4;
        final Intent intent2;
        final Context context2;
        final Bundle bundle2;
        if (".ui.tools.WebViewUI".equals(str2)) {
            int startPerformance = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcBizEnable, WXHardCoderJNI.hcBizDelay, WXHardCoderJNI.hcBizCPU, WXHardCoderJNI.hcBizIO, WXHardCoderJNI.hcBizThr ? Process.myTid() : 0, WXHardCoderJNI.hcBizTimeout, 902, WXHardCoderJNI.hcBizAction, "MicroMsg.PluginHelper");
            C4990ab.m7417i("MicroMsg.PluginHelper", "summer hardcoder biz startPerformance [%s][%s]", Integer.valueOf(902), Integer.valueOf(startPerformance));
            try {
                String stringExtra = intent.getStringExtra("rawUrl");
                if (!C5046bo.isNullOrNil(stringExtra)) {
                    Uri parse = Uri.parse(stringExtra);
                    if (intent.getLongExtra("start_activity_time", 0) == 0) {
                        intent.putExtra("start_activity_time", System.currentTimeMillis());
                    }
                    if (parse.getHost() != null && parse.getHost().equals("game.weixin.qq.com")) {
                        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.game_luggage, false)) {
                            str3 = "com.tencent.mm.plugin.game.luggage.LuggageGameWebViewUI";
                        } else {
                            str3 = ".ui.tools.game.GameWebViewUI";
                        }
                        str4 = str;
                        intent2 = intent;
                        context2 = context;
                        bundle2 = bundle;
                        C25985d.m41451a(str, new C41909a() {
                            public final void onDone() {
                                AppMethodBeat.m2504i(114693);
                                C4990ab.m7411d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s:%s", str4, str3);
                                try {
                                    Intent intent = intent2 == null ? new Intent() : intent2;
                                    String str = str3.startsWith(".") ? (C4996ah.doz() + ".plugin." + str4) + str3 : str3;
                                    intent.setClassName(C4996ah.getPackageName(), str);
                                    Class.forName(str, false, context2.getClassLoader());
                                    if (context2 instanceof Activity) {
                                        context2.startActivity(intent, bundle2);
                                        AppMethodBeat.m2505o(114693);
                                        return;
                                    }
                                    intent.addFlags(268435456);
                                    context2.startActivity(intent, bundle2);
                                    AppMethodBeat.m2505o(114693);
                                } catch (ClassNotFoundException e) {
                                    C4990ab.m7413e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", e);
                                    AppMethodBeat.m2505o(114693);
                                }
                            }
                        }, new C41910b() {
                            /* renamed from: e */
                            public final void mo43868e(Exception exception) {
                                AppMethodBeat.m2504i(114694);
                                C4990ab.m7415f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                                C4990ab.m7413e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
                                AppMethodBeat.m2505o(114694);
                            }
                        });
                        AppMethodBeat.m2505o(114704);
                    } else if (!(parse.getHost() == null || !parse.getHost().equals("mp.weixin.qq.com") || ToolsProcessIPCService.m63911Qb())) {
                        str2 = ".ui.tools.WebviewMpUI";
                    }
                }
                str3 = str2;
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.PluginHelper", "parse url failed :" + e.getMessage());
            }
            str4 = str;
            intent2 = intent;
            context2 = context;
            bundle2 = bundle;
            C25985d.m41451a(str, /* anonymous class already generated */, /* anonymous class already generated */);
            AppMethodBeat.m2505o(114704);
        }
        str3 = str2;
        str4 = str;
        intent2 = intent;
        context2 = context;
        bundle2 = bundle;
        C25985d.m41451a(str, /* anonymous class already generated */, /* anonymous class already generated */);
        AppMethodBeat.m2505o(114704);
    }

    /* renamed from: Qb */
    public static boolean m41450Qb() {
        AppMethodBeat.m2504i(139145);
        boolean Qb = ToolsProcessIPCService.m63911Qb();
        AppMethodBeat.m2505o(139145);
        return Qb;
    }

    /* renamed from: f */
    public static void m41473f(Context context, String str, Intent intent) {
        AppMethodBeat.m2504i(114706);
        C25985d.m41470c(context, str, intent, null);
        AppMethodBeat.m2505o(114706);
    }

    /* renamed from: c */
    public static void m41470c(Context context, String str, Intent intent, Bundle bundle) {
        AppMethodBeat.m2504i(114707);
        if (intent == null) {
            intent = new Intent();
        }
        String doz = C4996ah.doz();
        if (str.startsWith(".")) {
            str = doz + str;
        }
        intent.setClassName(C4996ah.getPackageName(), str);
        if (context instanceof Activity) {
            context.startActivity(intent, bundle);
            AppMethodBeat.m2505o(114707);
            return;
        }
        intent.addFlags(268435456);
        context.startActivity(intent, bundle);
        AppMethodBeat.m2505o(114707);
    }

    /* renamed from: c */
    public static void m41471c(Context context, String str, String str2, int i) {
        AppMethodBeat.m2504i(114708);
        C25985d.m41453a(context, str, str2, null, i, true);
        AppMethodBeat.m2505o(114708);
    }

    /* renamed from: b */
    public static void m41468b(Context context, String str, String str2, Intent intent, int i) {
        AppMethodBeat.m2504i(114709);
        C25985d.m41453a(context, str, str2, intent, i, true);
        AppMethodBeat.m2505o(114709);
    }

    /* renamed from: a */
    public static void m41453a(Context context, final String str, String str2, Intent intent, int i, boolean z) {
        AppMethodBeat.m2504i(114710);
        C4990ab.m7411d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.valueOf(z));
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final int i2 = i;
        C25985d.m41451a(str, new C41909a() {
            public final void onDone() {
                AppMethodBeat.m2504i(114695);
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(C4996ah.getPackageName(), str4.startsWith(".") ? (C4996ah.doz() + ".plugin." + str3) + str4 : str4);
                if (context2 instanceof Activity) {
                    ((Activity) context2).startActivityForResult(intent, i2);
                    C25985d.m41474g(context2, str4, intent);
                    AppMethodBeat.m2505o(114695);
                    return;
                }
                C4990ab.m7414f("MicroMsg.PluginHelper", "context not activity, skipped");
                AppMethodBeat.m2505o(114695);
            }
        }, new C41910b() {
            /* renamed from: e */
            public final void mo43868e(Exception exception) {
                AppMethodBeat.m2504i(114696);
                C4990ab.m7415f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                C4990ab.m7413e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
                AppMethodBeat.m2505o(114696);
            }
        });
        AppMethodBeat.m2505o(114710);
    }

    /* renamed from: g */
    public static void m41474g(Context context, String str, Intent intent) {
        AppMethodBeat.m2504i(114712);
        if (intent != null && vwG.contains(str)) {
            intent.putExtra("animation_pop_in", true);
            C5274b.m8044K(context, intent);
        }
        AppMethodBeat.m2505o(114712);
    }

    /* renamed from: b */
    public static void m41466b(Context context, String str, Intent intent, int i) {
        AppMethodBeat.m2504i(114713);
        intent.setClassName(C4996ah.getPackageName(), str.startsWith(".") ? C4996ah.doz() + str : str);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            C25985d.m41474g(context, str, intent);
            AppMethodBeat.m2505o(114713);
            return;
        }
        C4990ab.m7414f("MicroMsg.PluginHelper", "context not activity, skipped");
        AppMethodBeat.m2505o(114713);
    }

    /* renamed from: a */
    public static void m41460a(MMActivity mMActivity, String str, Intent intent, int i, C5186a c5186a) {
        AppMethodBeat.m2504i(114714);
        Intent intent2 = intent == null ? new Intent() : intent;
        String doz = C4996ah.doz();
        if (str.startsWith(".")) {
            doz = doz + str;
        } else {
            doz = str;
        }
        intent2.setClassName(C4996ah.getPackageName(), doz);
        mMActivity.mo17391b(c5186a, intent, i);
        C25985d.m41474g(mMActivity, str, intent);
        AppMethodBeat.m2505o(114714);
    }

    /* renamed from: a */
    public static void m41457a(Fragment fragment, String str, Intent intent, int i) {
        AppMethodBeat.m2504i(114715);
        intent.setClassName(C4996ah.getPackageName(), str.startsWith(".") ? C4996ah.doz() + str : str);
        if (fragment instanceof Fragment) {
            fragment.startActivityForResult(intent, i);
            C25985d.m41474g(fragment.getActivity(), str, intent);
            AppMethodBeat.m2505o(114715);
            return;
        }
        C4990ab.m7414f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
        AppMethodBeat.m2505o(114715);
    }

    public static void dlK() {
        AppMethodBeat.m2504i(114717);
        String str = "mm";
        C5091c.m7720a(str, true, C25985d.aku(str));
        AppMethodBeat.m2505o(114717);
    }

    /* renamed from: i */
    private static void m41476i(Intent intent, String str) {
        AppMethodBeat.m2504i(114718);
        C5091c.m7718a(intent, str, true, C25985d.aku(str));
        AppMethodBeat.m2505o(114718);
    }

    /* renamed from: aH */
    public static void m41463aH(Intent intent) {
        AppMethodBeat.m2504i(114719);
        C25985d.m41476i(intent, "mm");
        AppMethodBeat.m2505o(114719);
    }

    /* renamed from: j */
    public static void m41477j(Intent intent, String str) {
        AppMethodBeat.m2504i(139146);
        C25985d.m41476i(intent, str);
        AppMethodBeat.m2505o(139146);
    }

    /* renamed from: k */
    private static void m41478k(Intent intent, String str) {
        AppMethodBeat.m2504i(114721);
        C5091c.m7722b(intent, str, true, C25985d.aku(str));
        AppMethodBeat.m2505o(114721);
    }

    /* renamed from: aI */
    public static void m41464aI(Intent intent) {
        AppMethodBeat.m2504i(114722);
        C25985d.m41478k(intent, "mm");
        AppMethodBeat.m2505o(114722);
    }

    /* renamed from: l */
    public static void m41479l(Intent intent, String str) {
        AppMethodBeat.m2504i(139147);
        C25985d.m41478k(intent, str);
        AppMethodBeat.m2505o(139147);
    }

    private static Intent aku(String str) {
        AppMethodBeat.m2504i(114726);
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
        Intent intent = new Intent(C4996ah.getContext(), cls);
        AppMethodBeat.m2505o(114726);
        return intent;
    }

    public static C1816at akv(String str) {
        AppMethodBeat.m2504i(114728);
        C4990ab.m7411d("MicroMsg.PluginHelper", "-->createSubCore: %s alone", str);
        C40415c akw = C25985d.akw(str);
        if (akw == null) {
            C4990ab.m7415f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", str);
            AppMethodBeat.m2505o(114728);
            return null;
        }
        C1816at createSubCore = akw.createSubCore();
        if (createSubCore == null) {
            C4990ab.m7421w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", str);
            AppMethodBeat.m2505o(114728);
            return null;
        }
        C4990ab.m7411d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", str);
        AppMethodBeat.m2505o(114728);
        return createSubCore;
    }

    /* renamed from: a */
    public static void m41461a(String str, C23255n c23255n, C23244m c23244m) {
        AppMethodBeat.m2504i(114729);
        C4990ab.m7411d("MicroMsg.PluginHelper", "--> registerApplication: %s", str);
        C40415c akw = C25985d.akw(str);
        if (akw == null) {
            C4990ab.m7415f("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            AppMethodBeat.m2505o(114729);
            return;
        }
        C23256o createApplication = akw.createApplication();
        if (createApplication == null) {
            C4990ab.m7421w("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            AppMethodBeat.m2505o(114729);
            return;
        }
        createApplication.mo7222a(c23244m);
        createApplication.mo7223a(c23255n);
        C4990ab.m7411d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s %s %s", str, c23255n, c23244m);
        AppMethodBeat.m2505o(114729);
    }

    /* renamed from: ac */
    public static C23233a m41465ac(Context context, String str) {
        AppMethodBeat.m2504i(114730);
        C23233a I = C25985d.m41449I(context, str, null);
        AppMethodBeat.m2505o(114730);
        return I;
    }

    /* renamed from: I */
    public static C23233a m41449I(Context context, String str, String str2) {
        AppMethodBeat.m2504i(114731);
        C40415c akw = C25985d.akw(str);
        if (akw == null) {
            C4990ab.m7415f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", str, str2);
            AppMethodBeat.m2505o(114731);
            return null;
        }
        C44040b contactWidgetFactory = akw.getContactWidgetFactory();
        if (contactWidgetFactory == null) {
            C4990ab.m7415f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", str, str2);
            AppMethodBeat.m2505o(114731);
            return null;
        }
        C23233a ac = contactWidgetFactory.mo6747ac(context, str2);
        AppMethodBeat.m2505o(114731);
        return ac;
    }

    public static boolean dlL() {
        return false;
    }

    public static synchronized boolean afj(String str) {
        boolean z;
        synchronized (C25985d.class) {
            AppMethodBeat.m2504i(114732);
            if (vwF.get(str) != null) {
                z = true;
                AppMethodBeat.m2505o(114732);
            } else {
                z = false;
                AppMethodBeat.m2505o(114732);
            }
        }
        return z;
    }

    private static synchronized C40415c akw(String str) {
        C40415c akx;
        synchronized (C25985d.class) {
            AppMethodBeat.m2504i(114733);
            try {
                akx = C25985d.akx(str);
                AppMethodBeat.m2505o(114733);
            } catch (ClassNotFoundException e) {
                C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s, e:%s", str, e.toString());
                akx = null;
                AppMethodBeat.m2505o(114733);
                return akx;
            } catch (InstantiationException e2) {
                C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e2.toString());
                akx = null;
                AppMethodBeat.m2505o(114733);
                return akx;
            } catch (IllegalAccessException e3) {
                C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e3.toString());
                akx = null;
                AppMethodBeat.m2505o(114733);
                return akx;
            }
        }
        return akx;
    }

    /* renamed from: a */
    public static synchronized C40415c m41451a(String str, C41909a c41909a, C41910b c41910b) {
        C40415c c40415c;
        synchronized (C25985d.class) {
            AppMethodBeat.m2504i(114734);
            if (((String) vwE.get(str)) != null) {
                C4990ab.m7411d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, (String) vwE.get(str));
            }
            c40415c = (C40415c) vwF.get(str);
            if (c40415c != null) {
                c41909a.onDone();
                AppMethodBeat.m2505o(114734);
            } else {
                try {
                    c40415c = C25985d.akx(str);
                    if (c40415c != null) {
                        c41909a.onDone();
                    }
                    AppMethodBeat.m2505o(114734);
                } catch (Exception e) {
                    try {
                        c40415c = C25985d.akx(str);
                        if (c40415c != null) {
                            c41909a.onDone();
                        }
                        AppMethodBeat.m2505o(114734);
                    } catch (ClassNotFoundException e2) {
                        C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s ,e:%s", str, e2.toString());
                        C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        c41910b.mo43868e(new IllegalArgumentException("Load Plugin Faild"));
                        c40415c = null;
                        AppMethodBeat.m2505o(114734);
                        return c40415c;
                    } catch (InstantiationException e3) {
                        C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e3.toString());
                        C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        c41910b.mo43868e(new IllegalArgumentException("Load Plugin Faild"));
                        c40415c = null;
                        AppMethodBeat.m2505o(114734);
                        return c40415c;
                    } catch (IllegalAccessException e4) {
                        C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e4.toString());
                        C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        c41910b.mo43868e(new IllegalArgumentException("Load Plugin Faild"));
                        c40415c = null;
                        AppMethodBeat.m2505o(114734);
                        return c40415c;
                    }
                }
            }
        }
        return c40415c;
    }

    private static C40415c akx(String str) {
        AppMethodBeat.m2504i(114735);
        C40415c c40415c = (C40415c) vwF.get(str);
        if (c40415c != null) {
            AppMethodBeat.m2505o(114735);
            return c40415c;
        }
        c40415c = (C40415c) C4996ah.getContext().getClassLoader().loadClass(C4996ah.doz() + ".plugin." + str + ".Plugin").newInstance();
        vwF.put(str, c40415c);
        AppMethodBeat.m2505o(114735);
        return c40415c;
    }

    /* renamed from: hM */
    public static synchronized Class<?> m41475hM(String str, String str2) {
        Class<?> loadClass;
        synchronized (C25985d.class) {
            AppMethodBeat.m2504i(114736);
            if (((String) vwE.get(str)) != null) {
                C4990ab.m7411d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, (String) vwE.get(str));
            }
            if (C25985d.aky(str)) {
                String str3 = C4996ah.doz() + ".plugin." + str;
                if (str2.startsWith(".")) {
                    str2 = str3 + str2;
                }
                try {
                    loadClass = C4996ah.getContext().getClassLoader().loadClass(str2);
                    AppMethodBeat.m2505o(114736);
                } catch (Exception e) {
                    C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                    AppMethodBeat.m2505o(114736);
                    loadClass = null;
                }
            } else {
                C4990ab.m7415f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                AppMethodBeat.m2505o(114736);
                loadClass = null;
            }
        }
        return loadClass;
    }

    private static synchronized boolean aky(String str) {
        boolean z;
        synchronized (C25985d.class) {
            AppMethodBeat.m2504i(114737);
            if (C25985d.akw(str) != null) {
                z = true;
                AppMethodBeat.m2505o(114737);
            } else {
                z = false;
                AppMethodBeat.m2505o(114737);
            }
        }
        return z;
    }

    /* renamed from: a */
    public static void m41458a(Fragment fragment, final String str, String str2, Intent intent, int i) {
        AppMethodBeat.m2504i(114711);
        C4990ab.m7411d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.TRUE);
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Fragment fragment2 = fragment;
        final int i2 = i;
        C25985d.m41451a(str, new C41909a() {
            public final void onDone() {
                AppMethodBeat.m2504i(114688);
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(C4996ah.getPackageName(), str4.startsWith(".") ? (C4996ah.doz() + ".plugin." + str3) + str4 : str4);
                fragment2.startActivityForResult(intent, i2);
                C25985d.m41474g(fragment2.getActivity(), str4, intent2);
                AppMethodBeat.m2505o(114688);
            }
        }, new C41910b() {
            /* renamed from: e */
            public final void mo43868e(Exception exception) {
                AppMethodBeat.m2504i(114689);
                C4990ab.m7415f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                C4990ab.m7413e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
                AppMethodBeat.m2505o(114689);
            }
        });
        AppMethodBeat.m2505o(114711);
    }

    /* renamed from: a */
    public static void m41459a(C25988b c25988b, final String str, String str2, Intent intent, int i, C25987a c25987a) {
        AppMethodBeat.m2504i(114716);
        C4990ab.m7411d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.TRUE);
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final C25988b c25988b2 = c25988b;
        final int i2 = i;
        final C25987a c25987a2 = c25987a;
        C25985d.m41451a(str, new C41909a() {
            public final void onDone() {
                AppMethodBeat.m2504i(114686);
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(C4996ah.getPackageName(), str4.startsWith(".") ? (C4996ah.doz() + ".plugin." + str3) + str4 : str4);
                c25988b2.mo43869a(intent, i2, c25987a2);
                C25985d.m41474g(c25988b2.getContext(), str4, intent2);
                AppMethodBeat.m2505o(114686);
            }
        }, new C41910b() {
            /* renamed from: e */
            public final void mo43868e(Exception exception) {
                AppMethodBeat.m2504i(114687);
                C4990ab.m7415f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                C4990ab.m7413e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
                AppMethodBeat.m2505o(114687);
            }
        });
        AppMethodBeat.m2505o(114716);
    }

    /* renamed from: a */
    public static boolean m41462a(Intent intent, ServiceConnection serviceConnection, String str) {
        AppMethodBeat.m2504i(114724);
        boolean a = C5091c.m7721a(intent, serviceConnection, 1, str, true, C25985d.aku(str));
        AppMethodBeat.m2505o(114724);
        return a;
    }

    /* renamed from: a */
    public static void m41456a(ServiceConnection serviceConnection, String str) {
        AppMethodBeat.m2504i(114725);
        C5091c.m7719a(serviceConnection, str, true, C25985d.aku(str));
        AppMethodBeat.m2505o(114725);
    }
}
