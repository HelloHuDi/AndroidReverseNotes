package com.tencent.p177mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.sdk.platformtools.C46615e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;

/* renamed from: com.tencent.mm.modelstat.d */
public final class C26483d {
    private static C26483d fSa;
    private C26484a fRY = new C26484a();
    private HashSet<String> fRZ = new HashSet();

    /* renamed from: com.tencent.mm.modelstat.d$a */
    static class C26484a implements ActivityLifecycleCallbacks {
        private int fSb;
        private int fSc;
        int fSd;
        int fSe;

        C26484a() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            AppMethodBeat.m2504i(78702);
            C26483d.m42195a(C26483d.ake(), 1, activity);
            AppMethodBeat.m2505o(78702);
        }

        public final void onActivityStarted(Activity activity) {
            AppMethodBeat.m2504i(78703);
            this.fSd++;
            C4990ab.m7417i("MicroMsg.ClickFlowStatSender", "started[%d]", Integer.valueOf(this.fSd));
            C26483d.m42195a(C26483d.ake(), 2, activity);
            AppMethodBeat.m2505o(78703);
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.m2504i(78704);
            this.fSb++;
            C4990ab.m7417i("MicroMsg.ClickFlowStatSender", "resumed[%d]", Integer.valueOf(this.fSb));
            C26483d.m42195a(C26483d.ake(), 3, activity);
            AppMethodBeat.m2505o(78704);
        }

        public final void onActivityPaused(Activity activity) {
            AppMethodBeat.m2504i(78705);
            this.fSc++;
            C4990ab.m7417i("MicroMsg.ClickFlowStatSender", "paused[%d]", Integer.valueOf(this.fSc));
            C26483d.m42195a(C26483d.ake(), 4, activity);
            C18691f akh = C18691f.akh();
            if (activity != null && (activity instanceof MMActivity)) {
                akh.mo33961u(activity.getClass().getName(), ((MMActivity) activity).dyi());
                C4990ab.m7419v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", r1, Long.valueOf(r2), Integer.valueOf(akh.fSR.size()));
            }
            AppMethodBeat.m2505o(78705);
        }

        public final void onActivityStopped(Activity activity) {
            AppMethodBeat.m2504i(78706);
            this.fSe++;
            C4990ab.m7417i("MicroMsg.ClickFlowStatSender", "stopped[%d]", Integer.valueOf(this.fSe));
            C26483d.m42195a(C26483d.ake(), 5, activity);
            AppMethodBeat.m2505o(78706);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
            AppMethodBeat.m2504i(78707);
            C26483d.m42195a(C26483d.ake(), 6, activity);
            AppMethodBeat.m2505o(78707);
        }
    }

    /* renamed from: d */
    public static void m42197d(Application application) {
        AppMethodBeat.m2504i(78708);
        application.registerActivityLifecycleCallbacks(C26483d.ake().fRY);
        AppMethodBeat.m2505o(78708);
    }

    public static boolean akd() {
        AppMethodBeat.m2504i(78709);
        C26484a c26484a = C26483d.ake().fRY;
        if (c26484a.fSd > c26484a.fSe) {
            AppMethodBeat.m2505o(78709);
            return true;
        }
        AppMethodBeat.m2505o(78709);
        return false;
    }

    /* renamed from: b */
    public static void m42196b(int i, String str, int i2) {
        AppMethodBeat.m2504i(78710);
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
        intent.putExtra("opCode", i);
        intent.putExtra("ui", str);
        intent.putExtra("uiHashCode", i2);
        intent.putExtra("nowMilliSecond", C5046bo.anU());
        intent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
        C46615e.m88169aL(intent);
        Context context = C4996ah.getContext();
        if (context != null) {
            if (C4996ah.bqo()) {
                C37957c.akc().mo60731v(intent);
            } else {
                C4990ab.m7411d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", intent, intent.getExtras());
                context.sendBroadcast(intent);
            }
        }
        intent.setAction("com.tencent.mm.Intent.ACTION_NET_STATS");
        context.sendBroadcast(intent);
        AppMethodBeat.m2505o(78710);
    }

    private C26483d() {
        AppMethodBeat.m2504i(78711);
        this.fRZ.add("com.tencent.mm.ui.LauncherUI");
        this.fRZ.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
        this.fRZ.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        this.fRZ.add("com.tencent.mm.ui.conversation.BizConversationUI");
        this.fRZ.add("com.tencent.mm.ui.chatting.ChattingUI");
        this.fRZ.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
        this.fRZ.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI");
        this.fRZ.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI1");
        this.fRZ.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI2");
        this.fRZ.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI3");
        this.fRZ.add("com.tencent.mm.plugin.appbrand.ui.AppBrandUI4");
        AppMethodBeat.m2505o(78711);
    }

    public static C26483d ake() {
        AppMethodBeat.m2504i(78712);
        if (fSa == null) {
            synchronized (C26483d.class) {
                try {
                    if (fSa == null) {
                        fSa = new C26483d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(78712);
                    }
                }
            }
        }
        C26483d c26483d = fSa;
        AppMethodBeat.m2505o(78712);
        return c26483d;
    }

    /* renamed from: h */
    public static void m42198h(String str, long j, long j2) {
        AppMethodBeat.m2504i(78713);
        if (C7243d.vxr || C7243d.vxq) {
            C4990ab.m7417i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j2 - j));
            C7053e.pXa.mo8374X(13393, "99999,0,0," + j + "," + j2 + "," + str);
        }
        AppMethodBeat.m2505o(78713);
    }

    /* renamed from: a */
    static /* synthetic */ void m42195a(C26483d c26483d, int i, Activity activity) {
        AppMethodBeat.m2504i(78714);
        int hashCode = activity.hashCode();
        String className = activity.getComponentName().getClassName();
        C4990ab.m7419v("MicroMsg.ClickFlowStatSender", "callback opCode:%d activity:%s hash:%d ignore:%s %s", Integer.valueOf(i), className, Integer.valueOf(hashCode), Boolean.valueOf(c26483d.fRZ.contains(className)), C5046bo.dpG());
        if (!c26483d.fRZ.contains(className)) {
            C26483d.m42196b(i, className, hashCode);
        }
        AppMethodBeat.m2505o(78714);
    }
}
