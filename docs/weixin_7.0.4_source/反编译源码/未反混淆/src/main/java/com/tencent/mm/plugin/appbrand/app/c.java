package com.tencent.mm.plugin.appbrand.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherFolderUI;
import com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI;
import com.tencent.mm.plugin.profile.ui.BizBindWxaInfoUI;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.List;

public final class c implements g {
    public final void a(Context context, String str, String str2, List<WxaEntryInfo> list) {
        AppMethodBeat.i(129209);
        Intent intent = new Intent(context, BizBindWxaInfoUI.class);
        intent.putParcelableArrayListExtra("extra_wxa_entry_info_list", new ArrayList(list));
        intent.putExtra("extra_username", str);
        intent.putExtra("extra_appid", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        AppMethodBeat.o(129209);
    }

    public final void b(Context context, int i, boolean z) {
        AppMethodBeat.i(129210);
        if (!z) {
            z = com.tencent.mm.plugin.appbrand.ui.recommend.c.aNE();
        }
        Context context2 = context == null ? ah.getContext() : context;
        context2.startActivity(new Intent(context2, AppBrandLauncherUI.class).putExtra("extra_enter_scene", i).putExtra("extra_show_recommend", z).addFlags(context instanceof Activity ? 0 : 268435456));
        AppMethodBeat.o(129210);
    }

    public final void C(Context context, int i) {
        AppMethodBeat.i(129211);
        if (context == null) {
            context = ah.getContext();
        }
        Intent putExtra = new Intent().putExtra("extra_get_usage_reason", 9).putExtra("extra_enter_scene", i);
        if (com.tencent.mm.plugin.appbrand.ui.recommend.c.aNE() && com.tencent.mm.plugin.appbrand.ui.recommend.c.aNF()) {
            AppBrandLauncherFolderUI.o(context, putExtra);
            AppMethodBeat.o(129211);
            return;
        }
        context.startActivity(new Intent(context, AppBrandLauncherUI.class).putExtra("extra_show_recents_from_task_bar", true).putExtras(putExtra).addFlags(context instanceof Activity ? 0 : 268435456));
        AppMethodBeat.o(129211);
    }

    public final void cB(Context context) {
        AppMethodBeat.i(129212);
        if (context == null) {
            context = ah.getContext();
        }
        Intent intent = new Intent();
        intent.putExtra("extra_get_usage_reason", 7);
        intent.putExtra("extra_enter_scene", 3);
        AppBrandLauncherFolderUI.p(context, intent);
        AppMethodBeat.o(129212);
    }
}
