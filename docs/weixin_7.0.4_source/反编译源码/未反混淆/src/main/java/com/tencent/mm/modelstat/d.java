package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.e;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;

public final class d {
    private static d fSa;
    private a fRY = new a();
    private HashSet<String> fRZ = new HashSet();

    static class a implements ActivityLifecycleCallbacks {
        private int fSb;
        private int fSc;
        int fSd;
        int fSe;

        a() {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            AppMethodBeat.i(78702);
            d.a(d.ake(), 1, activity);
            AppMethodBeat.o(78702);
        }

        public final void onActivityStarted(Activity activity) {
            AppMethodBeat.i(78703);
            this.fSd++;
            ab.i("MicroMsg.ClickFlowStatSender", "started[%d]", Integer.valueOf(this.fSd));
            d.a(d.ake(), 2, activity);
            AppMethodBeat.o(78703);
        }

        public final void onActivityResumed(Activity activity) {
            AppMethodBeat.i(78704);
            this.fSb++;
            ab.i("MicroMsg.ClickFlowStatSender", "resumed[%d]", Integer.valueOf(this.fSb));
            d.a(d.ake(), 3, activity);
            AppMethodBeat.o(78704);
        }

        public final void onActivityPaused(Activity activity) {
            AppMethodBeat.i(78705);
            this.fSc++;
            ab.i("MicroMsg.ClickFlowStatSender", "paused[%d]", Integer.valueOf(this.fSc));
            d.a(d.ake(), 4, activity);
            f akh = f.akh();
            if (activity != null && (activity instanceof MMActivity)) {
                akh.u(activity.getClass().getName(), ((MMActivity) activity).dyi());
                ab.v("MicroMsg.MMActivityBrowseMgr", "onPause activity[%s] time[%d] map[%d]", r1, Long.valueOf(r2), Integer.valueOf(akh.fSR.size()));
            }
            AppMethodBeat.o(78705);
        }

        public final void onActivityStopped(Activity activity) {
            AppMethodBeat.i(78706);
            this.fSe++;
            ab.i("MicroMsg.ClickFlowStatSender", "stopped[%d]", Integer.valueOf(this.fSe));
            d.a(d.ake(), 5, activity);
            AppMethodBeat.o(78706);
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
            AppMethodBeat.i(78707);
            d.a(d.ake(), 6, activity);
            AppMethodBeat.o(78707);
        }
    }

    public static void d(Application application) {
        AppMethodBeat.i(78708);
        application.registerActivityLifecycleCallbacks(ake().fRY);
        AppMethodBeat.o(78708);
    }

    public static boolean akd() {
        AppMethodBeat.i(78709);
        a aVar = ake().fRY;
        if (aVar.fSd > aVar.fSe) {
            AppMethodBeat.o(78709);
            return true;
        }
        AppMethodBeat.o(78709);
        return false;
    }

    public static void b(int i, String str, int i2) {
        AppMethodBeat.i(78710);
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
        intent.putExtra("opCode", i);
        intent.putExtra("ui", str);
        intent.putExtra("uiHashCode", i2);
        intent.putExtra("nowMilliSecond", bo.anU());
        intent.putExtra("elapsedRealtime", SystemClock.elapsedRealtime());
        e.aL(intent);
        Context context = ah.getContext();
        if (context != null) {
            if (ah.bqo()) {
                c.akc().v(intent);
            } else {
                ab.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", intent, intent.getExtras());
                context.sendBroadcast(intent);
            }
        }
        intent.setAction("com.tencent.mm.Intent.ACTION_NET_STATS");
        context.sendBroadcast(intent);
        AppMethodBeat.o(78710);
    }

    private d() {
        AppMethodBeat.i(78711);
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
        AppMethodBeat.o(78711);
    }

    public static d ake() {
        AppMethodBeat.i(78712);
        if (fSa == null) {
            synchronized (d.class) {
                try {
                    if (fSa == null) {
                        fSa = new d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(78712);
                    }
                }
            }
        }
        d dVar = fSa;
        AppMethodBeat.o(78712);
        return dVar;
    }

    public static void h(String str, long j, long j2) {
        AppMethodBeat.i(78713);
        if (com.tencent.mm.protocal.d.vxr || com.tencent.mm.protocal.d.vxq) {
            ab.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j2 - j));
            com.tencent.mm.plugin.report.e.pXa.X(13393, "99999,0,0," + j + "," + j2 + "," + str);
        }
        AppMethodBeat.o(78713);
    }

    static /* synthetic */ void a(d dVar, int i, Activity activity) {
        AppMethodBeat.i(78714);
        int hashCode = activity.hashCode();
        String className = activity.getComponentName().getClassName();
        ab.v("MicroMsg.ClickFlowStatSender", "callback opCode:%d activity:%s hash:%d ignore:%s %s", Integer.valueOf(i), className, Integer.valueOf(hashCode), Boolean.valueOf(dVar.fRZ.contains(className)), bo.dpG());
        if (!dVar.fRZ.contains(className)) {
            b(i, className, hashCode);
        }
        AppMethodBeat.o(78714);
    }
}
