package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.f.a.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TbsVideo {
    public static boolean canUseTbsPlayer(Context context) {
        AppMethodBeat.i(64603);
        boolean a = be.a(context).a();
        AppMethodBeat.o(64603);
        return a;
    }

    public static boolean canUseYunbo(Context context) {
        AppMethodBeat.i(64604);
        if (be.a(context).a() && QbSdk.canUseVideoFeatrue(context, 1)) {
            AppMethodBeat.o(64604);
            return true;
        }
        AppMethodBeat.o(64604);
        return false;
    }

    public static void openVideo(Context context, String str) {
        AppMethodBeat.i(64600);
        openVideo(context, str, null);
        AppMethodBeat.o(64600);
    }

    public static void openVideo(Context context, String str, Bundle bundle) {
        AppMethodBeat.i(64601);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(64601);
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
        AppMethodBeat.o(64601);
    }

    public static boolean openYunboVideo(Context context, String str, Bundle bundle, b bVar) {
        AppMethodBeat.i(64602);
        if (canUseYunbo(context)) {
            boolean a = be.a(context).a(str, bundle, bVar);
            AppMethodBeat.o(64602);
            return a;
        }
        AppMethodBeat.o(64602);
        return false;
    }
}
