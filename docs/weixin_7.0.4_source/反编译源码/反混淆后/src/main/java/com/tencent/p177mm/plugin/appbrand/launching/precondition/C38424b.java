package com.tencent.p177mm.plugin.appbrand.launching.precondition;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.sdk.launching.C17828a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.p177mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandInToolsUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandPluginUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandUI;
import com.tencent.ttpic.FilterEnum4Shaka;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.precondition.b */
final class C38424b extends C17828a {
    C38424b() {
    }

    /* renamed from: b */
    public final boolean mo33004b(Context context, LaunchParcel launchParcel) {
        boolean z = false;
        AppMethodBeat.m2504i(132056);
        Intent intent = new Intent(context, AppBrandLaunchProxyUI.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("extra_from_mm", false);
        intent.putExtra("extra_launch_parcel", launchParcel);
        intent.putExtra("extra_launch_source_context", context.getClass().getName());
        if ((context instanceof AppBrandUI) && !(context instanceof AppBrandPluginUI) && !(context instanceof AppBrandInToolsUI) && ((launchParcel.hgF == null || launchParcel.hgF.hgQ != 1) && launchParcel.ijy.scene != FilterEnum4Shaka.MIC_WEISHI_v4_4_YINGTAO)) {
            z = true;
        }
        if (z) {
            intent.putExtra("extra_result_receiver", new ClientLaunchEntry$1(this, new Handler(Looper.getMainLooper()), context));
        }
        context.startActivity(intent);
        AppMethodBeat.m2505o(132056);
        return true;
    }
}
