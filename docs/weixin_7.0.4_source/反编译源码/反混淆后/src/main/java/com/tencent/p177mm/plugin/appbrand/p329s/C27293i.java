package com.tencent.p177mm.plugin.appbrand.p329s;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMFragmentActivity;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherFolderUI;
import com.tencent.p177mm.plugin.appbrand.service.C10733b;

/* renamed from: com.tencent.mm.plugin.appbrand.s.i */
public final class C27293i implements C10733b {
    /* renamed from: F */
    public final void mo22284F(Context context, int i) {
        AppMethodBeat.m2504i(133578);
        int i2 = -1;
        if (1 == i) {
            i2 = 14;
        } else if (2 == i) {
            i2 = 15;
        }
        Intent intent = new Intent(context, AppBrandLauncherFolderUI.class);
        intent.putExtra(MMFragmentActivity.EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM, true);
        intent.putExtra("extra_enter_scene", i2);
        intent.putExtra("KEY_MODE", 1);
        intent.addFlags(context instanceof Activity ? 0 : 268435456);
        intent.addFlags(536870912);
        intent.addFlags(134217728);
        context.startActivity(intent);
        AppMethodBeat.m2505o(133578);
    }

    /* renamed from: cX */
    public final void mo22285cX(Context context) {
        AppMethodBeat.m2504i(133579);
        Intent intent = new Intent(context, AppBrandLauncherFolderUI.class);
        intent.putExtra(MMFragmentActivity.EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM, true);
        intent.putExtra("extra_enter_scene", 4);
        intent.putExtra("KEY_MODE", 2);
        intent.addFlags(context instanceof Activity ? 0 : 268435456);
        intent.addFlags(536870912);
        intent.addFlags(134217728);
        context.startActivity(intent);
        AppMethodBeat.m2505o(133579);
    }
}
