package com.tencent.p177mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.p057v4.app.C0363v.C0358c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C9638aw;
import com.tencent.p177mm.p1637bo.C45186a;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p612ui.LauncherUI;
import com.tencent.p177mm.p612ui.MMAppMgr;
import com.tencent.p177mm.platformtools.C26529w;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.bbom.n */
public final class C42785n implements C1202f {
    static C42785n jEu;

    /* renamed from: com.tencent.mm.plugin.bbom.n$1 */
    class C427861 implements Runnable {
        C427861() {
        }

        public final void run() {
            AppMethodBeat.m2504i(18271);
            C9638aw.hold();
            MMAppMgr.aAd();
            AppMethodBeat.m2505o(18271);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(18272);
        if (i == 4 && !C9638aw.m17182Rg().foreground) {
            switch (i2) {
                case VideoMaterialUtil.INVALID_INT_FIELD_VALUE /*-999999*/:
                    new C7306ak().post(new C427861());
                    AppMethodBeat.m2505o(18272);
                    return;
                case -311:
                case -310:
                case -205:
                case -72:
                case -9:
                case -6:
                case -4:
                case -3:
                    C42785n.m75876Fx(C4996ah.getContext().getString(C25738R.string.cvy));
                    C9638aw.hold();
                    AppMethodBeat.m2505o(18272);
                    return;
                case -140:
                    C4990ab.m7413e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", str);
                    if (C5046bo.isNullOrNil(str)) {
                        C42785n.m75876Fx(C4996ah.getContext().getString(C25738R.string.cvy));
                    } else {
                        C42785n.m75876Fx(str);
                    }
                    C9638aw.hold();
                    AppMethodBeat.m2505o(18272);
                    return;
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    C42785n.m75876Fx(C4996ah.getContext().getString(C25738R.string.cvw));
                    C26529w.m42357cn(C4996ah.getContext());
                    C9638aw.hold();
                    AppMethodBeat.m2505o(18272);
                    return;
                case -17:
                case -16:
                    SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("system_config_prefs", 0);
                    long j = sharedPreferences.getLong("recomended_update_ignore", -1);
                    if (j == -1 || C5046bo.m7549fp(j) >= TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                        int i3;
                        if (i2 == -17) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        Context context = C4996ah.getContext();
                        Intent intent = new Intent(context, LauncherUI.class);
                        intent.addFlags(536870912);
                        intent.addFlags(67108864);
                        intent.putExtra("nofification_type", "update_nofification");
                        intent.putExtra("show_update_dialog", true);
                        intent.putExtra("update_type", i3);
                        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
                        C0358c e = C45186a.m83262bt(context, "reminder_channel_id").mo625g(null).mo626j(System.currentTimeMillis()).mo621d(context.getString(C25738R.string.f9247u8)).mo623e(context.getString(C25738R.string.f9210t3));
                        e.f362EI = activity;
                        Notification build = e.build();
                        build.flags |= 16;
                        C9638aw.getNotification().mo41574a(34, build, false);
                        sharedPreferences.edit().putLong("recomended_update_ignore", C5046bo.anT()).commit();
                        C7060h.pYm.mo8378a(405, 27, 1, true);
                        break;
                    }
                    C4990ab.m7410d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=".concat(String.valueOf(j)));
                    AppMethodBeat.m2505o(18272);
                    return;
            }
        }
        AppMethodBeat.m2505o(18272);
    }

    /* renamed from: Fx */
    private static void m75876Fx(String str) {
        CharSequence str2;
        AppMethodBeat.m2504i(18273);
        Context context = C4996ah.getContext();
        Intent intent = new Intent(context, LauncherUI.class);
        intent.putExtra("Intro_Notify", true);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        if (!C5046bo.isNullOrNil(str2) && str2.startsWith("autoauth_errmsg_")) {
            str2 = str2.substring(16);
        }
        if (!C5046bo.isNullOrNil(str2) && str2.startsWith("<")) {
            Map z = C5049br.m7595z(str2, "e");
            if (!(z == null || C5046bo.isNullOrNil((String) z.get(".e.Content")))) {
                str2 = (String) z.get(".e.Content");
            }
        }
        C0358c e = C45186a.m83262bt(context, C45186a.dgM()).mo621d(str2).mo623e(null);
        e.f362EI = PendingIntent.getActivity(context, 0, intent, 268435456);
        Notification build = e.build();
        build.icon = C45186a.bWV();
        build.flags = 16;
        C9638aw.getNotification().mo41577c(build);
        AppMethodBeat.m2505o(18273);
    }
}
