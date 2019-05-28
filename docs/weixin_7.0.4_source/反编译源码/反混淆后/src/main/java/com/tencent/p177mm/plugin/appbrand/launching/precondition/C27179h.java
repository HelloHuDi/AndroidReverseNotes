package com.tencent.p177mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.sdk.launching.C17828a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C7488f;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.report.quality.C2453g;
import com.tencent.p177mm.plugin.appbrand.report.quality.QualitySession;
import com.tencent.p177mm.plugin.appbrand.task.C45694h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.h */
public final class C27179h extends C17828a {
    private static long ijU = 0;

    /* renamed from: b */
    public final boolean mo33004b(Context context, LaunchParcel launchParcel) {
        AppMethodBeat.m2504i(132077);
        String a = C2453g.m4694a(launchParcel);
        String str = launchParcel.appId;
        int i = launchParcel.har;
        if (C5046bo.isNullOrNil(str)) {
            str = C7488f.ayD().mo14507bK(launchParcel.username);
        }
        if (!C5046bo.isNullOrNil(str) && i == 0 && C45694h.m84423bu(str, i)) {
            AppBrandInitConfigWC yY = C7488f.ayD().mo16716yY(str);
            if (yY != null && yY.gVs == i) {
                launchParcel.mo34789c(yY);
                yY.hgN = new QualitySession(a, yY, launchParcel.ijy);
                yY.hgO = false;
                C42615j.m75457b(context, yY, launchParcel.ijy);
                AppMethodBeat.m2505o(132077);
                return true;
            }
        }
        if (Math.abs(System.currentTimeMillis() - ijU) < 200) {
            C4990ab.m7420w("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start in 200 ms, just return");
            AppMethodBeat.m2505o(132077);
            return false;
        }
        ijU = C5046bo.anU();
        C4990ab.m7419v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "[applaunch] start entered %s %d", str, Integer.valueOf(i));
        boolean equalsIgnoreCase = "wxfe02ecfe70800f46".equalsIgnoreCase(str);
        String str2 = "Token@" + C27179h.class.hashCode() + "#" + System.nanoTime();
        new C42613d(context, str2, !equalsIgnoreCase).mo73413a(launchParcel, a);
        C4990ab.m7419v("MicroMsg.AppBrand.Precondition.MMLaunchEntry", "start we app with username(%s) and appId(%s) and statObj(%s)", launchParcel.username, str, launchParcel.ijy);
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
        AppMethodBeat.m2505o(132077);
        return true;
    }
}
