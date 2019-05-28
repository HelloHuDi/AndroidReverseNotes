package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.launching.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.f;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.mm.plugin.appbrand.report.quality.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class h extends a {
    private static long ijU = 0;

    public final boolean b(Context context, LaunchParcel launchParcel) {
        AppMethodBeat.i(132077);
        String a = g.a(launchParcel);
        String str = launchParcel.appId;
        int i = launchParcel.har;
        if (bo.isNullOrNil(str)) {
            str = f.ayD().bK(launchParcel.username);
        }
        if (!bo.isNullOrNil(str) && i == 0 && com.tencent.mm.plugin.appbrand.task.h.bu(str, i)) {
            AppBrandInitConfigWC yY = f.ayD().yY(str);
            if (yY != null && yY.gVs == i) {
                launchParcel.c(yY);
                yY.hgN = new QualitySession(a, yY, launchParcel.ijy);
                yY.hgO = false;
                j.b(context, yY, launchParcel.ijy);
                AppMethodBeat.o(132077);
                return true;
            }
        }
        if (Math.abs(System.currentTimeMillis() - ijU) < 200) {
            ab.w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
            AppMethodBeat.o(132077);
            return false;
        }
        ijU = bo.anU();
        ab.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", str, Integer.valueOf(i));
        boolean equalsIgnoreCase = "wxfe02ecfe70800f46".equalsIgnoreCase(str);
        String str2 = "Token@" + h.class.hashCode() + "#" + System.nanoTime();
        new d(context, str2, !equalsIgnoreCase).a(launchParcel, a);
        ab.v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", launchParcel.username, str, launchParcel.ijy);
        Intent intent = new Intent(context, AppBrandLaunchProxyUI.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("extra_from_mm", true);
        intent.putExtra("extra_entry_token", str2);
        if (!(!equalsIgnoreCase || launchParcel.ijz == null || launchParcel.ijz.bQj == null)) {
            intent.putExtra("extra_launch_weishi_video", true);
            intent.putExtra("extra_launch_thumb_url", launchParcel.ijz.bQj.thumbUrl);
            intent.putExtra("extra_launch_thumb_path", launchParcel.ijz.bQj.ijv);
        }
        context.startActivity(intent);
        AppMethodBeat.o(132077);
        return true;
    }
}
