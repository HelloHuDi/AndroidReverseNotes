package com.tencent.p177mm.plugin.p436hp.p1273d;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.protocal.protobuf.che;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.File;

/* renamed from: com.tencent.mm.plugin.hp.d.d */
public final class C28318d {
    private static String nus = "tinker-boots-install-info";
    private static String nut = "tinker-boots-last-show";
    private static String nuu = "tinker-boots-show-time";
    private static String nuv = "";

    /* renamed from: com.tencent.mm.plugin.hp.d.d$1 */
    static class C210731 implements Runnable {
        C210731() {
        }

        public final void run() {
            AppMethodBeat.m2504i(90686);
            C4990ab.m7416i("MicroMsg.UpdateUtil", "delete apk file. on worker thread");
            C1173e.m2562cu(C28318d.bGC());
            AppMethodBeat.m2505o(90686);
        }
    }

    /* renamed from: en */
    public static String m44928en(Context context) {
        AppMethodBeat.m2504i(90687);
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir;
            AppMethodBeat.m2505o(90687);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(90687);
            return null;
        }
    }

    /* renamed from: aC */
    public static void m44927aC(Context context, String str) {
        AppMethodBeat.m2504i(90688);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
        AppMethodBeat.m2505o(90688);
    }

    /* renamed from: a */
    public static void m44926a(che che) {
        AppMethodBeat.m2504i(90689);
        try {
            C4996ah.getContext().getSharedPreferences("tinker_patch_share_config", C1448h.m3078Mu()).edit().putString(nus, Base64.encodeToString(che.toByteArray(), 0)).apply();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.UpdateUtil", e, "", new Object[0]);
        }
        C4990ab.m7410d("MicroMsg.UpdateUtil", "save tinker install update info.");
        AppMethodBeat.m2505o(90689);
    }

    public static void bGA() {
        AppMethodBeat.m2504i(90690);
        C4990ab.m7416i("MicroMsg.UpdateUtil", "clearInstallUpdateInfo.");
        SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("tinker_patch_share_config", C1448h.m3078Mu());
        sharedPreferences.edit().putString(nus, "").apply();
        sharedPreferences.edit().putLong(nut, 0).apply();
        sharedPreferences.edit().putInt(nuu, 0).apply();
        AppMethodBeat.m2505o(90690);
    }

    public static void bGB() {
        AppMethodBeat.m2504i(90691);
        C7305d.xDG.execute(new C210731());
        AppMethodBeat.m2505o(90691);
    }

    public static String bGC() {
        AppMethodBeat.m2504i(90692);
        if (C5046bo.isNullOrNil(nuv)) {
            nuv = C6457e.euQ + "bsdiff/";
        }
        String str = nuv;
        AppMethodBeat.m2505o(90692);
        return str;
    }

    /* renamed from: OJ */
    public static String m44925OJ(String str) {
        AppMethodBeat.m2504i(90693);
        String str2 = C28318d.bGC() + str + ".apk";
        AppMethodBeat.m2505o(90693);
        return str2;
    }
}
