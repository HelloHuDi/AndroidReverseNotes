package com.tencent.mm.plugin.appbrand.s;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.b;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.ui.MMFragmentActivity;

public final class i implements b {
    public final void F(Context context, int i) {
        AppMethodBeat.i(133578);
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
        AppMethodBeat.o(133578);
    }

    public final void cX(Context context) {
        AppMethodBeat.i(133579);
        Intent intent = new Intent(context, AppBrandLauncherFolderUI.class);
        intent.putExtra(MMFragmentActivity.EXTRA_USE_SYSTEM_DEFAULT_ENTER_EXIT_ANIM, true);
        intent.putExtra("extra_enter_scene", 4);
        intent.putExtra("KEY_MODE", 2);
        intent.addFlags(context instanceof Activity ? 0 : 268435456);
        intent.addFlags(536870912);
        intent.addFlags(134217728);
        context.startActivity(intent);
        AppMethodBeat.o(133579);
    }
}
