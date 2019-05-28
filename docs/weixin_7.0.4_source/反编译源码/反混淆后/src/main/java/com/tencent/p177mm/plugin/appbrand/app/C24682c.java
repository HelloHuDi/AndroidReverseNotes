package com.tencent.p177mm.plugin.appbrand.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherFolderUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandLauncherUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.recommend.C19803c;
import com.tencent.p177mm.plugin.appbrand.service.C19731g;
import com.tencent.p177mm.plugin.profile.p483ui.BizBindWxaInfoUI;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.app.c */
public final class C24682c implements C19731g {
    /* renamed from: a */
    public final void mo34963a(Context context, String str, String str2, List<WxaEntryInfo> list) {
        AppMethodBeat.m2504i(129209);
        Intent intent = new Intent(context, BizBindWxaInfoUI.class);
        intent.putParcelableArrayListExtra("extra_wxa_entry_info_list", new ArrayList(list));
        intent.putExtra("extra_username", str);
        intent.putExtra("extra_appid", str2);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
        AppMethodBeat.m2505o(129209);
    }

    /* renamed from: b */
    public final void mo34964b(Context context, int i, boolean z) {
        AppMethodBeat.m2504i(129210);
        if (!z) {
            z = C19803c.aNE();
        }
        Context context2 = context == null ? C4996ah.getContext() : context;
        context2.startActivity(new Intent(context2, AppBrandLauncherUI.class).putExtra("extra_enter_scene", i).putExtra("extra_show_recommend", z).addFlags(context instanceof Activity ? 0 : 268435456));
        AppMethodBeat.m2505o(129210);
    }

    /* renamed from: C */
    public final void mo34962C(Context context, int i) {
        AppMethodBeat.m2504i(129211);
        if (context == null) {
            context = C4996ah.getContext();
        }
        Intent putExtra = new Intent().putExtra("extra_get_usage_reason", 9).putExtra("extra_enter_scene", i);
        if (C19803c.aNE() && C19803c.aNF()) {
            AppBrandLauncherFolderUI.m38572o(context, putExtra);
            AppMethodBeat.m2505o(129211);
            return;
        }
        context.startActivity(new Intent(context, AppBrandLauncherUI.class).putExtra("extra_show_recents_from_task_bar", true).putExtras(putExtra).addFlags(context instanceof Activity ? 0 : 268435456));
        AppMethodBeat.m2505o(129211);
    }

    /* renamed from: cB */
    public final void mo34965cB(Context context) {
        AppMethodBeat.m2504i(129212);
        if (context == null) {
            context = C4996ah.getContext();
        }
        Intent intent = new Intent();
        intent.putExtra("extra_get_usage_reason", 7);
        intent.putExtra("extra_enter_scene", 3);
        AppBrandLauncherFolderUI.m38573p(context, intent);
        AppMethodBeat.m2505o(129212);
    }
}
