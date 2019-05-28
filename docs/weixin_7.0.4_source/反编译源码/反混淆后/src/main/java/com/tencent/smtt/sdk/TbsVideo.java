package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p1451f.p1452a.p1453a.C37323b;

public class TbsVideo {
    public static boolean canUseTbsPlayer(Context context) {
        AppMethodBeat.m2504i(64603);
        boolean a = C46737be.m88593a(context).mo75283a();
        AppMethodBeat.m2505o(64603);
        return a;
    }

    public static boolean canUseYunbo(Context context) {
        AppMethodBeat.m2504i(64604);
        if (C46737be.m88593a(context).mo75283a() && QbSdk.canUseVideoFeatrue(context, 1)) {
            AppMethodBeat.m2505o(64604);
            return true;
        }
        AppMethodBeat.m2505o(64604);
        return false;
    }

    public static void openVideo(Context context, String str) {
        AppMethodBeat.m2504i(64600);
        openVideo(context, str, null);
        AppMethodBeat.m2505o(64600);
    }

    public static void openVideo(Context context, String str, Bundle bundle) {
        AppMethodBeat.m2504i(64601);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(64601);
            return;
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("videoUrl", str);
        Intent intent = new Intent("com.tencent.smtt.tbs.video.PLAY");
        intent.setFlags(268435456);
        intent.setPackage(context.getPackageName());
        intent.putExtra("extraData", bundle);
        context.startActivity(intent);
        AppMethodBeat.m2505o(64601);
    }

    public static boolean openYunboVideo(Context context, String str, Bundle bundle, C37323b c37323b) {
        AppMethodBeat.m2504i(64602);
        if (canUseYunbo(context)) {
            boolean a = C46737be.m88593a(context).mo75284a(str, bundle, c37323b);
            AppMethodBeat.m2505o(64602);
            return a;
        }
        AppMethodBeat.m2505o(64602);
        return false;
    }
}
