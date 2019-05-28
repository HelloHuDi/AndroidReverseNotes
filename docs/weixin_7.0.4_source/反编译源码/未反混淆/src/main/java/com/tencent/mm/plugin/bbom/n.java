package com.tencent.mm.plugin.bbom;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.v.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bo.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.Map;

public final class n implements f {
    static n jEu;

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(18272);
        if (i == 4 && !aw.Rg().foreground) {
            switch (i2) {
                case VideoMaterialUtil.INVALID_INT_FIELD_VALUE /*-999999*/:
                    new ak().post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(18271);
                            aw.hold();
                            MMAppMgr.aAd();
                            AppMethodBeat.o(18271);
                        }
                    });
                    AppMethodBeat.o(18272);
                    return;
                case -311:
                case -310:
                case -205:
                case -72:
                case -9:
                case -6:
                case -4:
                case -3:
                    Fx(ah.getContext().getString(R.string.cvy));
                    aw.hold();
                    AppMethodBeat.o(18272);
                    return;
                case -140:
                    ab.e("MicroMsg.NewSyncErrorProcessor", "alpha need whitelist : [%s]", str);
                    if (bo.isNullOrNil(str)) {
                        Fx(ah.getContext().getString(R.string.cvy));
                    } else {
                        Fx(str);
                    }
                    aw.hold();
                    AppMethodBeat.o(18272);
                    return;
                case ZipJNI.UNZ_END_OF_LIST_OF_FILE /*-100*/:
                    Fx(ah.getContext().getString(R.string.cvw));
                    w.cn(ah.getContext());
                    aw.hold();
                    AppMethodBeat.o(18272);
                    return;
                case -17:
                case -16:
                    SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("system_config_prefs", 0);
                    long j = sharedPreferences.getLong("recomended_update_ignore", -1);
                    if (j == -1 || bo.fp(j) >= TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
                        int i3;
                        if (i2 == -17) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                        Context context = ah.getContext();
                        Intent intent = new Intent(context, LauncherUI.class);
                        intent.addFlags(536870912);
                        intent.addFlags(67108864);
                        intent.putExtra("nofification_type", "update_nofification");
                        intent.putExtra("show_update_dialog", true);
                        intent.putExtra("update_type", i3);
                        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 0);
                        c e = a.bt(context, "reminder_channel_id").g(null).j(System.currentTimeMillis()).d(context.getString(R.string.u8)).e(context.getString(R.string.t3));
                        e.EI = activity;
                        Notification build = e.build();
                        build.flags |= 16;
                        aw.getNotification().a(34, build, false);
                        sharedPreferences.edit().putLong("recomended_update_ignore", bo.anT()).commit();
                        h.pYm.a(405, 27, 1, true);
                        break;
                    }
                    ab.d("MicroMsg.NewSyncErrorProcessor", "skip update notification, last check=".concat(String.valueOf(j)));
                    AppMethodBeat.o(18272);
                    return;
            }
        }
        AppMethodBeat.o(18272);
    }

    private static void Fx(String str) {
        CharSequence str2;
        AppMethodBeat.i(18273);
        Context context = ah.getContext();
        Intent intent = new Intent(context, LauncherUI.class);
        intent.putExtra("Intro_Notify", true);
        intent.addFlags(536870912);
        intent.addFlags(67108864);
        if (!bo.isNullOrNil(str2) && str2.startsWith("autoauth_errmsg_")) {
            str2 = str2.substring(16);
        }
        if (!bo.isNullOrNil(str2) && str2.startsWith("<")) {
            Map z = br.z(str2, "e");
            if (!(z == null || bo.isNullOrNil((String) z.get(".e.Content")))) {
                str2 = (String) z.get(".e.Content");
            }
        }
        c e = a.bt(context, a.dgM()).d(str2).e(null);
        e.EI = PendingIntent.getActivity(context, 0, intent, 268435456);
        Notification build = e.build();
        build.icon = a.bWV();
        build.flags = 16;
        aw.getNotification().c(build);
        AppMethodBeat.o(18273);
    }
}
