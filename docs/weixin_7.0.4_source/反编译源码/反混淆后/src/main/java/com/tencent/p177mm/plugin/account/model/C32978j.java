package com.tencent.p177mm.plugin.account.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.p057v4.app.C0363v.C0358c;
import android.support.p057v4.app.C0363v.C0364b;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C32519bf;
import com.tencent.p177mm.plugin.account.p275ui.MobileVerifyUI;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C3473o;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.notification.p1652b.C46115a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.account.model.j */
public class C32978j implements C1816at {
    private static int fVL = 0;
    public static C32982a gyR = C32982a.NONE;
    private static C7564ap gyS = null;
    private C18838a gyQ;
    private C3473o gyT = new C329802();
    private C4884c gyU = new C329813();

    /* renamed from: com.tencent.mm.plugin.account.model.j$1 */
    static class C188451 implements C5015a {
        C188451() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(124698);
            C32978j.m53916Fc();
            if (C32978j.fVL == 1 || C32978j.fVL == 16 || C32978j.fVL % 96 == 0) {
                Context context = C4996ah.getContext();
                C4990ab.m7411d("MicroMsg.SubCoreAccountSync", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName());
                if ((!MobileVerifyUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName()) ? 1 : 0) != 0) {
                    Intent intent = new Intent(context, MobileVerifyUI.class);
                    intent.addFlags(2);
                    intent.addFlags(536870912);
                    intent.addFlags(67108864);
                    PendingIntent activity = PendingIntent.getActivity(context, 36, intent, ErrorDialogData.SUPPRESSED);
                    C0358c bt = C45186a.m83262bt(context, "reminder_channel_id");
                    bt.mo621d(context.getString(C25738R.string.f9209t0));
                    bt.mo616as(C45186a.bWV());
                    bt.mo626j(System.currentTimeMillis());
                    bt.f362EI = activity;
                    Notification build = new C0364b(bt).mo633c(context.getString(C25738R.string.czn)).build();
                    build.defaults |= 1;
                    build.flags |= 16;
                    ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().mo41574a(36, build, false);
                }
            }
            AppMethodBeat.m2505o(124698);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.model.j$2 */
    class C329802 implements C3473o {
        C329802() {
        }

        public final void onNewXmlReceived(String str, Map<String, String> map, C1197a c1197a) {
            AppMethodBeat.m2504i(124699);
            if (C5046bo.nullAsNil(str).equals("ChangeLaunchImage") && map != null) {
                C4990ab.m7417i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", (String) map.get(".sysmsg.ChangeLaunchImage.BeginTime"), (String) map.get(".sysmsg.ChangeLaunchImage.EndTime"), (String) map.get(".sysmsg.ChangeLaunchImage.ResId.SubType"));
                if (!C5046bo.m7510Q(r0, r9, r10)) {
                    C7060h.pYm.mo8378a(723, 5, 1, false);
                    int ank = C5046bo.ank(r10);
                    if (ank > 0) {
                        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0);
                        sharedPreferences.edit().putLong("new_launch_image_begin_time", C5046bo.anl(r0)).apply();
                        sharedPreferences.edit().putInt("new_launch_image_sub_type", ank).apply();
                        sharedPreferences.edit().putLong("new_launch_image_end_time", C5046bo.anl(r9)).commit();
                        C14845c.veg;
                        C32978j.m53918wp(C14839b.m23097gM(43, ank));
                    }
                }
            }
            AppMethodBeat.m2505o(124699);
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.model.j$3 */
    class C329813 extends C4884c<C32519bf> {
        C329813() {
            AppMethodBeat.m2504i(124700);
            this.xxI = C32519bf.class.getName().hashCode();
            AppMethodBeat.m2505o(124700);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(124701);
            C32519bf c32519bf = (C32519bf) c4883b;
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0);
            int i = sharedPreferences.getInt("new_launch_image_sub_type", 0);
            if (c32519bf.cus.cut == 43 && i > 0 && i == c32519bf.cus.cuu) {
                String str = c32519bf.cus.filePath;
                C7060h.pYm.mo8378a(723, 6, 1, false);
                sharedPreferences.edit().putInt("new_launch_image_res_version", c32519bf.cus.cuv).commit();
                C4990ab.m7417i("MicroMsg.SubCoreAccountSync", "filePath: %s", str);
                C32978j.m53918wp(str);
            }
            AppMethodBeat.m2505o(124701);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.account.model.j$a */
    public enum C32982a {
        NONE,
        SENT,
        VERIFIED;

        static {
            AppMethodBeat.m2505o(124705);
        }
    }

    public C32978j() {
        AppMethodBeat.m2504i(124706);
        AppMethodBeat.m2505o(124706);
    }

    /* renamed from: Fc */
    static /* synthetic */ int m53916Fc() {
        int i = fVL;
        fVL = i + 1;
        return i;
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(124707);
        C4879a.xxA.mo10053d(this.gyQ.gyA);
        this.gyQ = null;
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14905b("ChangeLaunchImage", this.gyT);
        this.gyU.dead();
        AppMethodBeat.m2505o(124707);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(124708);
        this.gyQ = new C18838a();
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14902a("ChangeLaunchImage", this.gyT);
        this.gyU.dnU();
        C14845c.veg;
        C14839b.m23095Ky(43);
        AppMethodBeat.m2505o(124708);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: a */
    public static void m53917a(C32982a c32982a) {
        AppMethodBeat.m2504i(124709);
        gyR = c32982a;
        switch (c32982a) {
            case SENT:
                fVL = 0;
                if (gyS == null) {
                    gyS = new C7564ap(new C188451(), true);
                }
                C4990ab.m7410d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
                gyS.mo16770ae(900000, 900000);
                AppMethodBeat.m2505o(124709);
                return;
            case NONE:
            case VERIFIED:
                if (gyS != null) {
                    gyS.stopTimer();
                }
                C4990ab.m7410d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
                gyR = C32982a.NONE;
                ((C46115a) C1720g.m3530M(C46115a.class)).getNotification().cancel(36);
                fVL = 0;
                gyS = null;
                break;
        }
        AppMethodBeat.m2505o(124709);
    }

    /* renamed from: wp */
    static /* synthetic */ void m53918wp(String str) {
        AppMethodBeat.m2504i(124710);
        C4990ab.m7417i("MicroMsg.SubCoreAccountSync", "filePath: %s", str);
        if (!C5046bo.isNullOrNil(str) && C5730e.m8628ct(str)) {
            String str2 = C6457e.eSj + "splashWelcomeImg";
            if (C5730e.deleteFile(str2)) {
                C5730e.m8644y(str, str2);
            }
        }
        AppMethodBeat.m2505o(124710);
    }
}
