package com.tencent.mm.plugin.account.model;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.v;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.bf;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.pluginsdk.g.a.a.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.HashMap;
import java.util.Map;

public class j implements at {
    private static int fVL = 0;
    public static a gyR = a.NONE;
    private static ap gyS = null;
    private a gyQ;
    private o gyT = new o() {
        public final void onNewXmlReceived(String str, Map<String, String> map, com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(124699);
            if (bo.nullAsNil(str).equals("ChangeLaunchImage") && map != null) {
                ab.i("MicroMsg.SubCoreAccountSync", "beginTime:%s,endTime:%s,subtype:%s", (String) map.get(".sysmsg.ChangeLaunchImage.BeginTime"), (String) map.get(".sysmsg.ChangeLaunchImage.EndTime"), (String) map.get(".sysmsg.ChangeLaunchImage.ResId.SubType"));
                if (!bo.Q(r0, r9, r10)) {
                    h.pYm.a(723, 5, 1, false);
                    int ank = bo.ank(r10);
                    if (ank > 0) {
                        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("system_config_prefs", 0);
                        sharedPreferences.edit().putLong("new_launch_image_begin_time", bo.anl(r0)).apply();
                        sharedPreferences.edit().putInt("new_launch_image_sub_type", ank).apply();
                        sharedPreferences.edit().putLong("new_launch_image_end_time", bo.anl(r9)).commit();
                        c.veg;
                        j.wp(b.gM(43, ank));
                    }
                }
            }
            AppMethodBeat.o(124699);
        }
    };
    private com.tencent.mm.sdk.b.c gyU = new com.tencent.mm.sdk.b.c<bf>() {
        {
            AppMethodBeat.i(124700);
            this.xxI = bf.class.getName().hashCode();
            AppMethodBeat.o(124700);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(124701);
            bf bfVar = (bf) bVar;
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("system_config_prefs", 0);
            int i = sharedPreferences.getInt("new_launch_image_sub_type", 0);
            if (bfVar.cus.cut == 43 && i > 0 && i == bfVar.cus.cuu) {
                String str = bfVar.cus.filePath;
                h.pYm.a(723, 6, 1, false);
                sharedPreferences.edit().putInt("new_launch_image_res_version", bfVar.cus.cuv).commit();
                ab.i("MicroMsg.SubCoreAccountSync", "filePath: %s", str);
                j.wp(str);
            }
            AppMethodBeat.o(124701);
            return false;
        }
    };

    public enum a {
        NONE,
        SENT,
        VERIFIED;

        static {
            AppMethodBeat.o(124705);
        }
    }

    public j() {
        AppMethodBeat.i(124706);
        AppMethodBeat.o(124706);
    }

    static /* synthetic */ int Fc() {
        int i = fVL;
        fVL = i + 1;
        return i;
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(124707);
        com.tencent.mm.sdk.b.a.xxA.d(this.gyQ.gyA);
        this.gyQ = null;
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("ChangeLaunchImage", this.gyT);
        this.gyU.dead();
        AppMethodBeat.o(124707);
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(124708);
        this.gyQ = new a();
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("ChangeLaunchImage", this.gyT);
        this.gyU.dnU();
        c.veg;
        b.Ky(43);
        AppMethodBeat.o(124708);
    }

    public final void bA(boolean z) {
    }

    public static void a(a aVar) {
        AppMethodBeat.i(124709);
        gyR = aVar;
        switch (aVar) {
            case SENT:
                fVL = 0;
                if (gyS == null) {
                    gyS = new ap(new com.tencent.mm.sdk.platformtools.ap.a() {
                        public final boolean BI() {
                            AppMethodBeat.i(124698);
                            j.Fc();
                            if (j.fVL == 1 || j.fVL == 16 || j.fVL % 96 == 0) {
                                Context context = ah.getContext();
                                ab.d("MicroMsg.SubCoreAccountSync", "[oneliang][showMobileRegNoVerifyCodeNotification]:%s", ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName());
                                if ((!MobileVerifyUI.class.getName().equals(((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName()) ? 1 : 0) != 0) {
                                    Intent intent = new Intent(context, MobileVerifyUI.class);
                                    intent.addFlags(2);
                                    intent.addFlags(536870912);
                                    intent.addFlags(67108864);
                                    PendingIntent activity = PendingIntent.getActivity(context, 36, intent, ErrorDialogData.SUPPRESSED);
                                    v.c bt = com.tencent.mm.bo.a.bt(context, "reminder_channel_id");
                                    bt.d(context.getString(R.string.t0));
                                    bt.as(com.tencent.mm.bo.a.bWV());
                                    bt.j(System.currentTimeMillis());
                                    bt.EI = activity;
                                    Notification build = new v.b(bt).c(context.getString(R.string.czn)).build();
                                    build.defaults |= 1;
                                    build.flags |= 16;
                                    ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().a(36, build, false);
                                }
                            }
                            AppMethodBeat.o(124698);
                            return true;
                        }
                    }, true);
                }
                ab.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]Sent");
                gyS.ae(900000, 900000);
                AppMethodBeat.o(124709);
                return;
            case NONE:
            case VERIFIED:
                if (gyS != null) {
                    gyS.stopTimer();
                }
                ab.d("MicroMsg.SubCoreAccountSync", "[oneliang][SmsVerifyCodeState]verified");
                gyR = a.NONE;
                ((com.tencent.mm.plugin.notification.b.a) g.M(com.tencent.mm.plugin.notification.b.a.class)).getNotification().cancel(36);
                fVL = 0;
                gyS = null;
                break;
        }
        AppMethodBeat.o(124709);
    }

    static /* synthetic */ void wp(String str) {
        AppMethodBeat.i(124710);
        ab.i("MicroMsg.SubCoreAccountSync", "filePath: %s", str);
        if (!bo.isNullOrNil(str) && e.ct(str)) {
            String str2 = com.tencent.mm.compatible.util.e.eSj + "splashWelcomeImg";
            if (e.deleteFile(str2)) {
                e.y(str, str2);
            }
        }
        AppMethodBeat.o(124710);
    }
}
