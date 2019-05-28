package com.tencent.mm.plugin.hp.d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;

public final class d {
    private static String nus = "tinker-boots-install-info";
    private static String nut = "tinker-boots-last-show";
    private static String nuu = "tinker-boots-show-time";
    private static String nuv = "";

    public static String en(Context context) {
        AppMethodBeat.i(90687);
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AppMethodBeat.o(90687);
            return str;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
            AppMethodBeat.o(90687);
            return null;
        }
    }

    public static void aC(Context context, String str) {
        AppMethodBeat.i(90688);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
        AppMethodBeat.o(90688);
    }

    public static void a(che che) {
        AppMethodBeat.i(90689);
        try {
            ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mu()).edit().putString(nus, Base64.encodeToString(che.toByteArray(), 0)).apply();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
        }
        ab.d("MicroMsg.UpdateUtil", "save tinker install update info.");
        AppMethodBeat.o(90689);
    }

    public static void bGA() {
        AppMethodBeat.i(90690);
        ab.i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
        SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("tinker_patch_share_config", h.Mu());
        sharedPreferences.edit().putString(nus, "").apply();
        sharedPreferences.edit().putLong(nut, 0).apply();
        sharedPreferences.edit().putInt(nuu, 0).apply();
        AppMethodBeat.o(90690);
    }

    public static void bGB() {
        AppMethodBeat.i(90691);
        com.tencent.mm.sdk.g.d.xDG.execute(new Runnable() {
            public final void run() {
                AppMethodBeat.i(90686);
                ab.i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
                e.cu(d.bGC());
                AppMethodBeat.o(90686);
            }
        });
        AppMethodBeat.o(90691);
    }

    public static String bGC() {
        AppMethodBeat.i(90692);
        if (bo.isNullOrNil(nuv)) {
            nuv = com.tencent.mm.compatible.util.e.euQ + "bsdiff/";
        }
        String str = nuv;
        AppMethodBeat.o(90692);
        return str;
    }

    public static String OJ(String str) {
        AppMethodBeat.i(90693);
        String str2 = bGC() + str + ".apk";
        AppMethodBeat.o(90693);
        return str2;
    }
}
